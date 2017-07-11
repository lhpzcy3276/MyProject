package com.example.kangxin.myproject.activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.kangxin.myproject.R;
import com.example.kangxin.myproject.fragment.CacheFragment;
import com.example.kangxin.myproject.fragment.ElementtaryFragment;
import com.example.kangxin.myproject.fragment.MapFragment;
import com.example.kangxin.myproject.fragment.TokenAdvancedFragment;
import com.example.kangxin.myproject.fragment.TokenFragment;
import com.example.kangxin.myproject.fragment.ZipFragment;

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
        viewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position){
                    case 0:
                        return new ElementtaryFragment();
                    case 1:
                        return new MapFragment();
                    case 2:
                        return new ZipFragment();
                    case 3:
                        return new TokenFragment();
                    case 4:
                        return new TokenAdvancedFragment();
                    case 5:
                        return new CacheFragment();
                    default:
                        return new ElementtaryFragment();
                }
            }

            @Override
            public int getCount() {
                return 6;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position){
                    case 0:
                        return getString(R.string.title_elementary);
                    case 1:
                        return getString(R.string.title_elementary);
                    case 2:
                        return getString(R.string.title_elementary);
                    case 3:
                        return getString(R.string.title_elementary);
                    case 4:
                        return getString(R.string.title_elementary);
                    case 5:
                        return getString(R.string.title_elementary);
                    default:
                        return getString(R.string.title_elementary);

                }
            }
        });

        tabLayout.setupWithViewPager(viewPager);

    }
}
