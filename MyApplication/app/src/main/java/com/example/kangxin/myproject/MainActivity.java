package com.example.kangxin.myproject;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Toast;

import com.example.kangxin.myproject.activity.Android6Activity;
import com.example.kangxin.myproject.activity.Android7Activity;
import com.example.kangxin.myproject.activity.BadgeActivity;
import com.example.kangxin.myproject.activity.ButterKnifeActivity;
import com.example.kangxin.myproject.activity.ConstraintLayoutActivity;
import com.example.kangxin.myproject.activity.CropActivity;
import com.example.kangxin.myproject.activity.Dialog_Loading_Activity;
import com.example.kangxin.myproject.activity.EventBusActivity01;
import com.example.kangxin.myproject.activity.EventBusActivity2;
import com.example.kangxin.myproject.activity.Glide4Activity;
import com.example.kangxin.myproject.activity.JsonActivity;
import com.example.kangxin.myproject.activity.MaterialDesignActivity;
import com.example.kangxin.myproject.activity.MoneyInputActivity;
import com.example.kangxin.myproject.activity.MyShowLightDialog;
import com.example.kangxin.myproject.activity.RetrofitActivity;
import com.example.kangxin.myproject.activity.RxJavaActivity;
import com.example.kangxin.myproject.activity.Rxjava2Activity;
import com.example.kangxin.myproject.activity.SpannableStringActivity;
import com.example.kangxin.myproject.activity.ThreadPoolActivity;
import com.example.kangxin.myproject.utils.PublicStaticMethod;


public class MainActivity extends Activity {
    LocalBroadcastManager manager;
    IntentFilter filter;
    MyBroad myBroad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerRec();
    }
    public void click25(View veiw){
        startActivity(new Intent(this, MaterialDesignActivity.class));

    }
    public void click24(View veiw){
        startActivity(new Intent(this, BadgeActivity.class));

    }
    public void click23(View veiw){
        startActivity(new Intent(this, SpannableStringActivity.class));

    }
     public void click22(View veiw){
        PublicStaticMethod.switchCase(2);

    }
    public void click21(View veiw){
        startActivity(new Intent(MainActivity.this, ConstraintLayoutActivity.class));

    }
    public void click20(View veiw){
        startActivity(new Intent(MainActivity.this, JsonActivity.class));

    }
    public void click19(View veiw){
        startActivity(new Intent(MainActivity.this, EventBusActivity2.class));

    }
    public void click18(View veiw){
        startActivity(new Intent(MainActivity.this, EventBusActivity2.class));

    }
    public void click17(View veiw){
        startActivity(new Intent(MainActivity.this, EventBusActivity01.class));

    }
    public void click16(View veiw){
        startActivity(new Intent(MainActivity.this, CropActivity.class));

    }
    public void click15(View veiw){
        LocalBroadcastManager manager= LocalBroadcastManager.getInstance(this);
        Intent intent=new Intent("aa.aa.bb");
        manager.sendBroadcast(intent);

    }
    public void click14(View veiw){
        startActivity(new Intent(MainActivity.this, Dialog_Loading_Activity.class));
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
    public void click2(View veiw){
        startActivity(new Intent(MainActivity.this,MoneyInputActivity.class));
    }
    public void click1(View veiw){
        startActivity(new Intent(MainActivity.this,MyShowLightDialog.class));
    }
    private void registerRec() {
        manager = LocalBroadcastManager.getInstance(this);
        filter = new IntentFilter("aa.aa.bb");

        myBroad = new MyBroad();
        manager.registerReceiver(myBroad,filter);
    }
    public class MyBroad extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(MainActivity.this,"公播发出",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        manager.unregisterReceiver(myBroad);
    }
}
