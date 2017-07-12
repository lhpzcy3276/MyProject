package com.example.kangxin.myproject.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.kangxin.myproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RetrofitActivity extends Activity {
        public static final String BASE_URL = "http://101.200.130.201:8080/v3/"; // 临时测试
    @BindView(R.id.retrofit_tablayout)
    TabLayout tabLayout;
    @BindView(R.id.retrofit_viewpager)
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

    }

}
