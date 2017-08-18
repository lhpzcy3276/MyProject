package com.example.kangxin.myproject.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.kangxin.myproject.R;
import com.example.kangxin.myproject.callback.ExceptionCallBack;

/**
 * Created by kangxin on 17/6/28.
 */
public class PublicStaticMethod {
    public static boolean NETLOADINGISSHOW=false;
    private static Dialog loadingDialog;

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

    public static void startLoadingActivity(final Activity activity){
        if (loadingDialog==null||!loadingDialog.isShowing()){
            loadingDialog = new Dialog(activity, R.style.MyDialogStyle);
            loadingDialog.setContentView(R.layout.activity_net_loading);
            loadingDialog.setCanceledOnTouchOutside(true);//点击外部是否消失
            /**
             *将显示Dialog的方法封装在这里面
             */
            Window window = loadingDialog.getWindow();
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            window.setGravity(Gravity.CENTER);
            window.setAttributes(lp);
            window.setWindowAnimations(R.style.PopWindowAnimStyle);

            loadingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    clossLoadingActivity();
                }
            });
            try {
                loadingDialog.show();
            }catch (Exception e){
                Log.d("崩溃时候走这个方法了吗",e.getMessage());
                clossLoadingActivity();
            }

        }
    }

    public static void clossLoadingActivity() {
        if (loadingDialog!=null){
            if (loadingDialog.isShowing()){
                loadingDialog.dismiss();
            }
            loadingDialog=null;
        }
    }


    /**
     * 隐藏异常不至于导致崩溃
     * @param callBack
     */
    public static void catchException(ExceptionCallBack callBack){
        try {
            callBack.tryCallBack();
        }catch (Exception e){
            Log.e("数据报错",e.getMessage());
        }
    }
}
