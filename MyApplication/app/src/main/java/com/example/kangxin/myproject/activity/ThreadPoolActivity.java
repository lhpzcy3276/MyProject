package com.example.kangxin.myproject.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.kangxin.myproject.R;
import com.example.kangxin.myproject.utils.ThreadPoolUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * http://www.trinea.cn/android/java-android-thread-pool/
 *
 * http://blog.csdn.net/qq_17250009/article/details/50906508
 */
public class ThreadPoolActivity extends Activity {
    @BindView(R.id.thread_activity_textview4)
    TextView textView4;
    int num=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_pool);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.thread_activity_textview1,R.id.thread_activity_textview2,R.id.thread_activity_textview3,R.id.thread_activity_textview4})
    void myclick(View view){
        switch (view.getId()){
            case R.id.thread_activity_textview1:

                break;
            case R.id.thread_activity_textview2:
                break;
            case R.id.thread_activity_textview3:
                break;
            case R.id.thread_activity_textview4:
                ThreadPoolUtils.newScheduledThreadPool(5).schedule(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                textView4.setText(++num+"");
                            }
                        });
                    }
                },2,TimeUnit.SECONDS);
                break;
        }
    }

}
