package com.example.kangxin.myproject.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kangxin.myproject.R;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

/**
 * 学信资源链接  http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2016/0429/4193.html
 */
public class ButterKnifeActivity extends Activity {
    @BindView(R.id.butterknife_textview) TextView mTextView;
    @BindView(R.id.butterknife_view) View mView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife);
        ButterKnife.bind(this);//绑定
        mTextView.setText("绑定后,调用");//这样就可以直接使用该Textview

        TextView mChildTextView=ButterKnife.findById(mView,R.id.child_item_view);
        mChildTextView.setText("这是从引入的View里面的找到的TextView");
    }
    @OnClick({R.id.butterknife_textview,R.id.child_item_view})
    void butterKnifeOnClick(View view){
        switch (view.getId()){
            case R.id.butterknife_textview:
                Toast.makeText(this,"点我了,急眼啦啊",Toast.LENGTH_SHORT).show();
                break;
            case R.id.child_item_view:
                Toast.makeText(this,"点击了嵌套子view",Toast.LENGTH_SHORT).show();
                break;
        }

    }
    @OnLongClick({R.id.butterknife_textview,R.id.child_item_view})
    boolean butterKnifeOnLongClick(View view){
        switch (view.getId()){
            case R.id.butterknife_textview:
                Toast.makeText(this,"长按,急眼啦啊",Toast.LENGTH_SHORT).show();
                break;
            case R.id.child_item_view:
                Toast.makeText(this,"长按,点击了嵌套子view",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }


}
