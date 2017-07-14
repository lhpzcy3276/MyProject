package com.example.kangxin.myproject.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.example.kangxin.myproject.App;
import com.example.kangxin.myproject.R;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by kangxin on 17/7/14.
 */
public class ImageUtil {
    public static void load(ImageView imageView,String url){
        Glide.with(App.getInstance())
                .load(url)
                .dontTransform()//不设置imageview的scaletype   由imageview自己决定scaletype
                .into(imageView);
    }

    //加载缩略图(缩略图是原图十分之一)
    public static void load_Center_URL_thumbnail(ImageView imageView,String url){
        Glide.with(App.getInstance()).load(url)
                .thumbnail(0.1f)
                .into(imageView);
    }

    //其它图片作为缩略图
    public static void load_Center_URL_thumbnail_other_drawable(ImageView imageView,String url){
        DrawableTypeRequest<Integer> load = Glide.with(App.getInstance()).load(R.mipmap.ic_launcher);

        Glide.with(App.getInstance()).load(url)
                .thumbnail(load)
                .into(imageView);



    }

    //按图片的原来size居中显示，当图片长/宽超过View的长/宽，则截取图片的居中部分显示
    public static void load_Center_URL(ImageView imageView,String url){
        Glide.with(App.getInstance())
                .load(url)
                .into(imageView);
    }
    public static void load_Center_SD(ImageView imageView,String url){
        Glide.with(App.getInstance())
                .load(url)
                .into(imageView);
    }
    public static void load_Center_drawable(ImageView imageView,int urlId){
        Glide.with(App.getInstance())
                .load(urlId)
                .into(imageView);
    }

    //按比例扩大图片的size居中显示，使得图片长(宽)等于或大于View的长(宽)
    public static void load_CENTER_CROP_URL(ImageView imageView,String url){
        Glide.with(App.getInstance())
                .load(url)
                .centerCrop()
                .into(imageView);
    }
    public static void load_CENTER_CROP_SD(ImageView imageView,String url){
        Glide.with(App.getInstance())
                .load(url)
                .centerCrop()
                .into(imageView);
    }
    public static void load_CENTER_CROP_drawable(ImageView imageView,int urlId){
        Glide.with(App.getInstance())
                .load(urlId)
                .centerCrop()
                .into(imageView);
    }

    //把图片按比例扩大/缩小到View的宽度，居中显示
    public static void load_FIT_CENTER_URL(ImageView imageView,String url){
        Glide.with(App.getInstance())
                .load(url)
                .fitCenter()
                .into(imageView);
    }
    public static void load_FIT_CENTER_SD(ImageView imageView,String url){
        Glide.with(App.getInstance())
                .load(url)
                .fitCenter()
                .into(imageView);
    }
    public static void load_FIT_CENTER_drawable(ImageView imageView,int urlId){
        Glide.with(App.getInstance())
                .load(urlId)
                .fitCenter()
                .into(imageView);
    }


    public static void load_Center_URL_Circle(ImageView imageView4, String imageurl) {
        Glide.with(App.getInstance())
                .load(imageurl)
                .bitmapTransform(new CropCircleTransformation(App.getInstance()))
                .into(imageView4);
    }
    public static void load_Center_URL_Corners(ImageView imageView, String imageurl) {
        Glide.with(App.getInstance())
                .load(imageurl)
                .bitmapTransform(new RoundedCornersTransformation(App.getInstance(),30,0,RoundedCornersTransformation.CornerType.ALL))
                .into(imageView);
    }
    public static void load_Center_URL_Gray(ImageView imageView, String imageurl) {
        Glide.with(App.getInstance())
                .load(imageurl)
                .bitmapTransform(new GrayscaleTransformation(App.getInstance()))
                .into(imageView);
    }
}
