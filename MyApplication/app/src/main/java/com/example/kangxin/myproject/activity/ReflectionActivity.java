package com.example.kangxin.myproject.activity;

import android.content.res.ColorStateList;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.kangxin.myproject.R;
import com.example.kangxin.myproject.utils.LogUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 反射
 */
public class ReflectionActivity extends BaseActivity {
    @BindView(R.id.activity_reflection_imageview1)
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflection);
        ButterKnife.bind(this);
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @OnClick({R.id.activity_reflection_bt})
    void mclick(View view){
        switch (view.getId()){
            case R.id.activity_reflection_bt:
                try {
                    Class<?> clazz=Class.forName("ClassLoader.Student");
                    Constructor constructor=clazz.getDeclaredConstructor(int.class,String.class,String.class);
                    constructor.setAccessible(true);

                    //利用构造器生成对象
                    Object mstudent=constructor.newInstance(24,"小红","北京市海淀区");
                    LogUtil.d("反射数据"+mstudent.toString());
                    //获取隐藏的属性
                    Field mAgeField=clazz.getDeclaredField("age");
                    mAgeField.setAccessible(true);
                    int age= (int) mAgeField.get(mstudent);
                    LogUtil.d("反射数据--年龄"+age);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                imageView.setImageTintList(ColorStateList.valueOf(getColor(R.color.bg_color)));
                break;
        }
    }
}
