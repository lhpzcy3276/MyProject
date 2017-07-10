package com.example.kangxin.myproject.utils;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by kangxin on 17/6/28.
 */
public class PublicStaticMethod {
    public static String matches="(^[1-9]([0-9]+)?(\\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\\.[0-9]([0-9])?$)";
    static String oldText;
    public static void setMoneyEditText(final EditText mServiceMoneySet) {
        mServiceMoneySet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s.toString())) {
                    if (s.toString().startsWith("00")) { //设置只能有一个零
                        mServiceMoneySet.setText("0");
                        mServiceMoneySet.setSelection(mServiceMoneySet.getText().toString().length());
                    } else if (s.toString().startsWith(".")) {//设置 第一位不能是小数点
                        mServiceMoneySet.setText("");
                        mServiceMoneySet.setSelection(mServiceMoneySet.getText().toString().length());
                    } else if (s.toString().contains(".")) {  //等有小数时只能输入两位小数
                        String[] strs = s.toString().split("\\.");
                        if (strs.length > 1) {
                            if (strs[1].length() > 2) {
                                    mServiceMoneySet.setText( strs[0] + "." + strs[1].substring(0, 2));
                                mServiceMoneySet.setSelection(mServiceMoneySet.getText().toString().length());
                            }
                        }

                    }
                }
            }
        });
    }
    public static void setMoneyEditTExtOne(final EditText editTExtOne){
        editTExtOne.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.toString().matches(matches)){

                    oldText = s.toString();

                }else {
                    editTExtOne.setText(oldText);
                }
            }
        });
    }
}
