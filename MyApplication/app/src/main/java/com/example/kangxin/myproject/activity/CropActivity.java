package com.example.kangxin.myproject.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kangxin.myproject.R;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;

import java.io.File;
import java.util.Locale;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
//http://blog.csdn.net/u011771755/article/details/50676888
public class CropActivity extends BaseActivity {
    @BindView(R.id.activity_crop_textview1)
    TextView textView1;
    @BindView(R.id.activity_crop_textview2)
    ImageView imageView1;
    private static final String SAMPLE_CROPPED_IMAGE_NAME = "SampleCropImage"+".png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.activity_crop_textview1)
    void click(View view){
        switch (view.getId()){
            case R.id.activity_crop_textview1:
                Random random = new Random();
                int minSizePixels = 800;
                int maxSizePixels = 2400;

                UCrop.Options options = new UCrop.Options();
                //设置裁剪出来图片的格式
                options.setCompressionFormat(Bitmap.CompressFormat.PNG);
                //一共三个参数，分别对应裁剪功能页面的“缩放”，“旋转”，“裁剪”界面，对应的传入NONE，就表示关闭了其手势操作，比如这里我关闭了缩放和旋转界面的手势，只留了裁剪页面的手势操作
                options.setAllowedGestures(UCropActivity.NONE, UCropActivity.NONE, UCropActivity.ALL);
                UCrop.of(Uri.parse(String.format(Locale.getDefault(), "https://unsplash.it/%d/%d/?random",
                        minSizePixels + random.nextInt(maxSizePixels - minSizePixels),
                        minSizePixels + random.nextInt(maxSizePixels - minSizePixels))), Uri.fromFile(new File(getCacheDir(), SAMPLE_CROPPED_IMAGE_NAME)))
                        .withAspectRatio(16, 9)
                        .withOptions(options)
//                        .withMaxResultSize(maxWidth, maxHeight)
                        .start(CropActivity.this);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == UCrop.REQUEST_CROP) {
            final Uri resultUri = UCrop.getOutput(data);
            BitmapLoadUtils.decodeBitmapInBackground(CropActivity.this, resultUri, null, 500, 500,
                    new BitmapLoadCallback() {

                        @Override
                        public void onBitmapLoaded(@NonNull Bitmap bitmap, @NonNull ExifInfo exifInfo, @NonNull String imageInputPath, @Nullable String imageOutputPath) {
//                            mImageInputPath = imageInputPath;
//                            mImageOutputPath = imageOutputPath;
//                            mExifInfo = exifInfo;
//
//                            mBitmapDecoded = true;
                            imageView1.setImageBitmap(bitmap);
                        }

                        @Override
                        public void onFailure(@NonNull Exception bitmapWorkerException) {
//                            Log.e(TAG, "onFailure: setImageUri", bitmapWorkerException);
//                            if (mTransformImageListener != null) {
//                                mTransformImageListener.onLoadFailure(bitmapWorkerException);
//                            }
                        }
                    });
        } else if (resultCode == UCrop.RESULT_ERROR) {
            final Throwable cropError = UCrop.getError(data);
        }
    }
}
