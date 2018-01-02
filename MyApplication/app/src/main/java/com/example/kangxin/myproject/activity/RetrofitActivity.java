package com.example.kangxin.myproject.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kangxin.myproject.App;
import com.example.kangxin.myproject.R;
import com.example.kangxin.myproject.bean.Book;
import com.example.kangxin.myproject.retrofit.RetrofitService;
import com.google.gson.GsonBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends BaseActivity {
    @BindView(R.id.retrofitActivity_textview1)
    TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.retrofitActivity1})
    void mclick(View view){
        switch (view.getId()){
            case R.id.retrofitActivity1:
                requestNet();
                break;
        }
    }

    private void requestNet() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .build();
        RetrofitService service=retrofit.create(RetrofitService.class);
        Call<Book> call=service.getSearchBook("金瓶梅",null,0,1);
        call.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                textView1.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                Toast.makeText(App.getInstance(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
