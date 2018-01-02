package com.example.kangxin.myproject.activity;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.kangxin.myproject.R;
import com.example.kangxin.myproject.utils.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTouch;

public class MaterialDesignActivity extends AppCompatActivity {
    @BindView(R.id.materialdesign_bt1)
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design);
        init();
    }

    private void init() {
        ButterKnife.bind(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnTouch(R.id.materialdesign_bt1)
    boolean mOnTouch(View view, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtil.d("ACTION_DOWN on view.");
                button1.setTranslationZ(120);
                break;
            case MotionEvent.ACTION_UP:
                LogUtil.d("ACTION_UP on view.");
                view.setTranslationZ(0);
                break;
            default:
                return false;
        }
        return false;
    }
}