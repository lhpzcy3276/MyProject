package com.example.kangxin.myproject.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.kangxin.myproject.R;
import com.example.kangxin.myproject.utils.PublicStaticMethod;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Dialog_Loading_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog__loading);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.dialog_activity_textview)
    void myclick(View view){
        switch (view.getId()){
            case R.id.dialog_activity_textview:
                PublicStaticMethod.startLoadingActivity(this);
                break;
        }
    }
}
