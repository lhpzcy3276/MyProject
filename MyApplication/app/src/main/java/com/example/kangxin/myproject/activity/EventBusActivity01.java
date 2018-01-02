package com.example.kangxin.myproject.activity;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.kangxin.myproject.R;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventBusActivity01 extends BaseActivity {
//    @BindView(R.id.activity_eventbus_textview1)
//    TextView textView1;
//    @BindView(R.id.activity_eventbus_textview2)
//    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_event_bus01);
//        ButterKnife.bind(this);
        EventBus.getDefault().register(this);//订阅

    }
    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void onDataSynEvent(String string) {
//        textView2.setText(System.currentTimeMillis()+"");
        Log.d("dayinlema1","aljfjfjfj");
    }
//    @OnClick(R.id.activity_eventbus_textview1)
//    void click(View veiw){
//
//        EventBus.getDefault().post("1");
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);//解除订阅
    }
}
