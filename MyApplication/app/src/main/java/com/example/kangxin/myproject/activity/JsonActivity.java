package com.example.kangxin.myproject.activity;

import android.app.Activity;
import android.os.BaseBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.kangxin.myproject.R;
import com.example.kangxin.myproject.bean.JsonBean1;
import com.example.kangxin.myproject.bean.JsonBean2;
import com.example.kangxin.myproject.utils.JSONUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JsonActivity extends Activity {
    @BindView(R.id.json_textview1)
    TextView textView1;
    @BindView(R.id.json_textview2)
    TextView textView2;
    @BindView(R.id.json_textview3)
    TextView textView3;
    JsonBean1 bean1=new JsonBean1(1,2,"fjkjk");
    String string="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.json_textview1,R.id.json_textview2})
    void Click(View view){
        switch (view.getId()){
            case R.id.json_textview1:
                string=JSONUtils.objectToJson(bean1);
                textView3.setText(string);

                break;
            case R.id.json_textview2:
                JsonBean2 bean2=JSONUtils.jsonToBean(string,JsonBean2.class);
                textView3.setText(bean2.getName1());
                break;
        }
    }
}
