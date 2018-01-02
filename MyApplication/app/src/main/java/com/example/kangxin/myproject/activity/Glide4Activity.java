package com.example.kangxin.myproject.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.kangxin.myproject.R;
import com.example.kangxin.myproject.utils.ImageUtil;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * http://blog.csdn.net/shangmingchao/article/details/51125554
 *
 *
 */
public class Glide4Activity extends BaseActivity {
    @BindView(R.id.activity_glide_imageview1)
    ImageView imageView1;
    @BindView(R.id.activity_glide_imageview2)
    ImageView imageView2;
    @BindView(R.id.activity_glide_imageview3)
    ImageView imageView3;
    @BindView(R.id.activity_glide_imageview4)
    ImageView imageView4;
    @BindView(R.id.activity_glide_imageview5)
    ImageView imageView5;
    @BindView(R.id.activity_glide_imageview6)
    ImageView imageView6;


    String imageurl="http://inthecheesefactory.com/uploads/source/nestedfragment/fragments.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide4);
        ButterKnife.bind(this);
        ImageUtil.load_Center_drawable(imageView1,R.mipmap.ic_launcher);
        ImageUtil.load_Center_URL(imageView2,imageurl);
        //用其它图片做缩略图
        ImageUtil.load_Center_URL_thumbnail_other_drawable(imageView3,imageurl);
        //圆形裁剪
        ImageUtil.load_Center_URL_Circle(imageView4,imageurl);
        //圆角处理
        ImageUtil.load_Center_URL_Corners(imageView5,imageurl);
        //灰度处理
        ImageUtil.load_Center_URL_Gray(imageView6,imageurl);

    }
    @OnClick({R.id.activity_glide_imageview1,R.id.activity_glide_imageview2,R.id.activity_glide_imageview3,R.id.activity_glide_imageview4})
    void myclick(View view){
        switch (view.getId()){
            case R.id.activity_glide_imageview1:

                break;
            case R.id.activity_glide_imageview2:


                break;
            case R.id.activity_glide_imageview3:
                break;
            case R.id.activity_glide_imageview4:
                break;
        }
    }
}
