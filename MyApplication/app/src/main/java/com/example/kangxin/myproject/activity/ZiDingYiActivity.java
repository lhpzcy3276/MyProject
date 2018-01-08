package com.example.kangxin.myproject.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.kangxin.myproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZiDingYiActivity extends BaseActivity {
    @BindView(R.id.activity_zidingyi_listview)
    ListView listView;
    //item上的数据源
    private String[] name = {"矩形", "圆形", "三角形", "扇形", "椭圆", "曲线","文字和图片"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zi_ding_yi);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
