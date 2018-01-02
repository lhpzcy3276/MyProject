package com.example.kangxin.myproject.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.kangxin.myproject.App;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by kangxin on 2017/12/21.
 */

public class BaseActivity extends Activity {
    @Override
    protected void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher= App.getRefWatcher(this);
        refWatcher.watch(this);
    }
}
