package com.example.kangxin.myproject.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.kangxin.myproject.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Android7Activity extends BaseActivity {

    private static final int REQUEST_CODE_TAKE_PHOTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android7);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.activity_android7_textview1,R.id.activity_android7_textview2})
    public void myclick(View view){
        switch (view.getId()){
            case R.id.activity_android7_textview1:
                takePhotoNoCompress(view);
                break;
            case R.id.activity_android7_textview2:
                break;
        }
    }

    private void takePhotoNoCompress(View view) {
        Intent takePictureIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager())!=null){
            String filename=new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA).format(new Date())+".png";

            File file= new File(Environment.getExternalStorageDirectory(),filename);
            String mCurrentPhotoPath=file.getAbsolutePath();
            //必须做版本校验,否则会报错
            Uri fileUri = null;
            if (Build.VERSION.SDK_INT>=24){
                fileUri = FileProvider.getUriForFile(this,"com.example.kangxin.myproject.fileprovider",file);
            }else {
                fileUri=Uri.fromFile(file);
            }
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,fileUri);

            startActivityForResult(takePictureIntent,REQUEST_CODE_TAKE_PHOTO);
        }
    }
}
