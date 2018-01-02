package com.example.kangxin.myproject.activity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import com.example.kangxin.myproject.R;
import com.example.kangxin.myproject.utils.PublicStaticMethod;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Dialog_Loading_Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog__loading);
        ButterKnife.bind(this);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        return super.onCreateDialog(id);
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
