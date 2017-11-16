package com.example.kangxin.myproject.activity;

import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.kangxin.myproject.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventBusActivity2 extends EventBusActivity01 {
    @BindView(R.id.activity_eventbus2_textview2)
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus2);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.activity_eventbus2_textview1)
    void click(View veiw){

        EventBus.getDefault().post("3");
    }
    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void onDataSynEvent(String string) {
        textView.setText(System.currentTimeMillis()+"");
        Log.d("dayinlema2","aljfjfjfj");
    }
}
