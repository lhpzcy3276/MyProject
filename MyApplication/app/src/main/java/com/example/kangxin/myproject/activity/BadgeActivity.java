package com.example.kangxin.myproject.activity;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.kangxin.myproject.R;
import com.example.kangxin.myproject.bean.UserInfo;
import com.example.kangxin.myproject.service.DaemonService;
import com.example.kangxin.myproject.utils.BadgeUtil;
import com.example.kangxin.myproject.utils.LogUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class BadgeActivity extends BaseActivity {
    UserInfo userInfo=new UserInfo();
    int num=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badge);
        ButterKnife.bind(this);

        mStartService();
    }

    private void mStartService() {

    }

    @OnClick(R.id.badge_textview)
    void mClick(View view){
        switch (view.getId()){
            case R.id.badge_textview:
                num++;
                BadgeUtil.setBadgeCount(this,num,R.mipmap.ic_launcher);
                break;
        }
    }

}
