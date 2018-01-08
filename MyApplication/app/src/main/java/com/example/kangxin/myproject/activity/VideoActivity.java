package com.example.kangxin.myproject.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.kangxin.myproject.R;
import com.example.kangxin.myproject.utils.LogUtil;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VideoActivity extends BaseActivity {
    @BindView(R.id.activity_video_bt1)
    Button play;
    @BindView(R.id.activity_video_bt2)
    Button pause;
    @BindView(R.id.activity_video_bt3)
    Button replay;
    @BindView(R.id.activity_video_bt4)
    Button stop;
    @BindView(R.id.activity_video_seekbar)
    SeekBar seekBar;
    @BindView(R.id.activity_video_surfaceview)
    SurfaceView surfaceView;
    MediaPlayer mediaPlayer;
    private boolean isPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
        surfaceView.getHolder().addCallback(callback);
        seekBar.setOnSeekBarChangeListener(listener);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @OnClick({R.id.activity_video_bt1, R.id.activity_video_bt2, R.id.activity_video_bt3})
    void mClick(View view) {
        switch (view.getId()) {
            case R.id.activity_video_bt1:

                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},201);
                break;
            case R.id.activity_video_bt2:
                pause();
                break;
            case R.id.activity_video_bt3:
                replay();
                break;
            case R.id.activity_video_bt4:
                stop();
                break;
        }
    }

    private int currentPosition;
    Callback callback = new Callback() {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            LogUtil.i( "SurfaceHolder 被创建");
                     if (currentPosition > 0) {
                              // 创建SurfaceHolder的时候，如果存在上次播放的位置，则按照上次播放位置进行播放
                             play(currentPosition);
                             currentPosition = 0;
                          }
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            LogUtil.i( "SurfaceHolder 被创建");
                      if (currentPosition > 0) {
                                // 创建SurfaceHolder的时候，如果存在上次播放的位置，则按照上次播放位置进行播放
                                play(currentPosition);
                                currentPosition = 0;
                            }
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            LogUtil.i( "SurfaceHolder 被销毁");
                  // 销毁SurfaceHolder的时候记录当前的播放位置并停止播放
                  if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                              currentPosition = mediaPlayer.getCurrentPosition();
                              mediaPlayer.stop();
                           }
        }
    };
    SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
// 当进度条停止修改的时候触发
            // 取得当前进度条的刻度
            int progress = seekBar.getProgress();
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                // 设置当前播放的位置
                mediaPlayer.seekTo(progress);
            }
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    /*
     * 停止播放
     */
    protected void stop() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
            play.setEnabled(true);
            isPlaying = false;
        }
    }

    /**
     * 开始播放
     *
     * @param msec 播放初始位置
     */
    protected void play(final int msec) {
        // 获取视频文件地址
        String path = Environment.getExternalStorageDirectory()+"/DCIM/Camera/VID_20180105_094613.mp4";
        File file = new File(path);
        if (!file.exists()) {
            Toast.makeText(this, "视频文件路径错误", 0).show();
            return;
        }
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            // 设置播放的视频源
            mediaPlayer.setDataSource(file.getAbsolutePath());
            // 设置显示视频的SurfaceHolder
            mediaPlayer.setDisplay(surfaceView.getHolder());
            Log.i("", "开始装载");
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                @Override
                public void onPrepared(MediaPlayer mp) {
                    Log.i("", "装载完成");
                    mediaPlayer.start();
                    // 按照初始位置播放
                    mediaPlayer.seekTo(msec);
                    // 设置进度条的最大进度为视频流的最大播放时长
                    seekBar.setMax(mediaPlayer.getDuration());
                    // 开始线程，更新进度条的刻度
                    new Thread() {

                        @Override
                        public void run() {
                            try {
                                isPlaying = true;
                                while (isPlaying) {
                                    final int current = mediaPlayer
                                            .getCurrentPosition();
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            seekBar.setProgress(current);
                                        }
                                    });
                                    sleep(500);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();

                    play.setEnabled(false);
                }
            });
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer mp) {
                    // 在播放完毕被回调
                    play.setEnabled(true);
                }
            });

            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {

                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    // 发生错误重新播放
                    LogUtil.e("播放器错误时打印");

                    play(0);
                    isPlaying = false;
                    return false;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 重新开始播放
     */
    protected void replay() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.seekTo(0);
            Toast.makeText(this, "重新播放", 0).show();
            pause.setText("暂停");
            return;
        }
        isPlaying = false;
        play(0);


    }

    /**
     * 暂停或继续
     */
    protected void pause() {
        if (pause.getText().toString().trim().equals("继续")) {
            pause.setText("暂停");
            mediaPlayer.start();
            Toast.makeText(this, "继续播放", 0).show();
            return;
        }
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            pause.setText("继续");
            Toast.makeText(this, "暂停播放", 0).show();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==201){
            if (grantResults[0]== PackageManager.PERMISSION_GRANTED){
                play(0);
            }
        }
    }
}
