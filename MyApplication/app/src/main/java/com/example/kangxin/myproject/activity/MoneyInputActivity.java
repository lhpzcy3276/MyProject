package com.example.kangxin.myproject.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.kangxin.myproject.R;
import com.example.kangxin.myproject.utils.PublicStaticMethod;

public class MoneyInputActivity extends Activity {
    EditText mEditText;
    EditText mEditTextOne;
    /**
     * 金额输入edittext 可以输入小数,但只能输入两位小数
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_input);

        mEditText = (EditText) findViewById(R.id.activity_moneyinput_edittext);

        mEditTextOne = (EditText) findViewById(R.id.activity_moneyinput_edittext_one);
        registerListener();
    }

    private void registerListener() {
        PublicStaticMethod.setMoneyEditText(mEditText);
        PublicStaticMethod.setMoneyEditTExtOne(mEditTextOne);
    }
}
