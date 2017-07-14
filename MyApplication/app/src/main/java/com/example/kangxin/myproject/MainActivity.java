package com.example.kangxin.myproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.kangxin.myproject.activity.Android6Activity;
import com.example.kangxin.myproject.activity.Android7Activity;
import com.example.kangxin.myproject.activity.ButterKnifeActivity;
import com.example.kangxin.myproject.activity.Glide4Activity;
import com.example.kangxin.myproject.activity.MoneyInputActivity;
import com.example.kangxin.myproject.activity.MyShowLightDialog;
import com.example.kangxin.myproject.activity.OkhttpUtilsActivity;
import com.example.kangxin.myproject.activity.RealmActivity;
import com.example.kangxin.myproject.activity.RetrofitActivity;
import com.example.kangxin.myproject.activity.RxJavaActivity;
import com.example.kangxin.myproject.activity.Rxjava2Activity;
import com.example.kangxin.myproject.activity.ThreadPoolActivity;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click13(View veiw){
        startActivity(new Intent(MainActivity.this, Glide4Activity.class));
    }
    public void click12(View veiw){
        startActivity(new Intent(MainActivity.this, Glide4Activity.class));
    }
    public void click11(View veiw){
        startActivity(new Intent(MainActivity.this, ThreadPoolActivity.class));
    }
    public void click10(View veiw){
        startActivity(new Intent(MainActivity.this, RealmActivity.class));
    }
    public void click9(View veiw){
        startActivity(new Intent(MainActivity.this, Rxjava2Activity.class));
    }
    public void click8(View veiw){
        startActivity(new Intent(MainActivity.this, Android7Activity.class));
    }
    public void click7(View veiw){
        startActivity(new Intent(MainActivity.this, Android6Activity.class));
    }
    public void click6(View veiw){
        startActivity(new Intent(MainActivity.this, ButterKnifeActivity.class));
    }
    public void click5(View veiw){
        startActivity(new Intent(MainActivity.this, RxJavaActivity.class));
    }
    public void click4(View veiw){
        startActivity(new Intent(MainActivity.this, RetrofitActivity.class));
    }
    public void click3(View veiw){
        startActivity(new Intent(MainActivity.this, OkhttpUtilsActivity.class));
    }
    public void click2(View veiw){
        startActivity(new Intent(MainActivity.this,MoneyInputActivity.class));
    }
    public void click1(View veiw){
        startActivity(new Intent(MainActivity.this,MyShowLightDialog.class));
    }
}
