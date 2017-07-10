package com.example.kangxin.myproject.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kangxin.myproject.R;

import retrofit2.Retrofit;

public class RetrofitActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        initData();
    }

    private void initData() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://localhost:4567/")
                .build();
    }
}
