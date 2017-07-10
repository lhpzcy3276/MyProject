package com.example.kangxin.myproject.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.kangxin.myproject.R;
import com.example.kangxin.myproject.utils.ActivityUtils;
import com.example.kangxin.myproject.utils.GetToast;

import java.util.Random;

/**
 * activity样式的dialog
 */
public class MyShowLightDialog extends Activity implements View.OnClickListener {
    private Button yes;//确定按钮
    private Button no;//取消按钮
    private TextView titleTv;//消息标题文本
    private TextView messageTv;//消息提示文本
    private String titleStr;//从外界设置的title文本
    private String messageStr;//从外界设置的消息文本
    //确定文本和取消文本的显示内容
    private String yesStr, noStr;
    private SeekBar sSeekBar;
    private LinearLayout ll_contentView;
    private onNoOnclickListener noOnclickListener;//取消按钮被点击了的监听器
    private onYesOnclickListener yesOnclickListener;//确定按钮被点击了的监听器
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置无title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //此两段必须设置在setContentView()方法之前
        setContentView(R.layout.show_light_dialog_layout);
        //按空白处不能取消动画
        setFinishOnTouchOutside(false);//类似于dialog中---------->setCanceledOnTouchOutside(false);
        //初始化界面控件
        initView();
        regisitListener();
        //初始化界面数据
        initData();
        //使用SeekBar进行亮度控制
        detalSeekBar();
        //设置透明状态栏
        dealStatusBar();
    }

    /**
     * 初始化界面控件
     */
    private void initView() {
        yes= (Button) findViewById(R.id.yes);
        no= (Button) findViewById(R.id.no);
        titleTv= (TextView) findViewById(R.id.title);
        messageTv= (TextView) findViewById(R.id.message);
        sSeekBar= (SeekBar) findViewById(R.id.seek_bar);
        ll_contentView= (LinearLayout) findViewById(R.id.ll_contentView);
    }

    private void regisitListener() {
        no.setOnClickListener(this);
        yes.setOnClickListener(this);
    }

    /**
     * 初始化界面控件的显示数据
     */
    private void initData() {
        if (titleStr!=null){
            titleTv.setText(titleStr);
        }
        if (messageStr!=null){
            messageTv.setText(messageStr);
        }
        //如果设置按钮的文字
        if (yesStr!=null){
            yes.setText(yesStr);
        }
        if (noStr!=null){
            no.setText(noStr);
        }
    }

    private void detalSeekBar() {
        //设置透明状态栏
        ViewGroup  contentFrameLayout= (ViewGroup) findViewById(Window.ID_ANDROID_CONTENT);
        View parentView=contentFrameLayout.getChildAt(0);
        if (parentView!=null&& Build.VERSION.SDK_INT>=14){
            parentView.setFitsSystemWindows(true);
        }
    }

    /**
     * 使用SeekBar进行亮度控制:
     */
    private void dealStatusBar() {
        sSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress<10){

                }else {
                    messageTv.setText("activity当前亮度为:  "+progress);
                    ActivityUtils.setBrightness(MyShowLightDialog.this,progress);
                    ll_contentView.setBackgroundColor(Color.parseColor("#"+getRandColorCode()));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    /**
     * 获取十六进制的颜色代码.例如  "#6E36B4" , For HTML ,
     * @return String
     */
    public static String getRandColorCode(){
        String r,g,b;
        Random random = new Random();
        r = Integer.toHexString(random.nextInt(256)).toUpperCase();
        g = Integer.toHexString(random.nextInt(256)).toUpperCase();
        b = Integer.toHexString(random.nextInt(256)).toUpperCase();
        r = r.length()==1 ? "0" + r : r ;
        g = g.length()==1 ? "0" + g : g ;
        b = b.length()==1 ? "0" + b : b ;
        return r+g+b;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.no:
                finish();
                break;
            case R.id.yes:
                GetToast.useString(MyShowLightDialog.this,"要做其他事情了");
        }
    }

    /**
     * 设置确定按钮和取消被点击的接口
     */
    public interface onYesOnclickListener {
        public void onYesClick();
    }

    public interface onNoOnclickListener {
        public void onNoClick();
    }

    /**
     * 设置取消按钮的显示内容和监听
     *
     * @param str
     * @param onNoOnclickListener
     */
    public void setNoOnclickListener(String str, onNoOnclickListener onNoOnclickListener) {
        if (str != null) {
            noStr = str;
        }
        this.noOnclickListener = onNoOnclickListener;
    }

    /**
     * 设置确定按钮的显示内容和监听
     *
     * @param str
     * @param onYesOnclickListener
     */
    public MyShowLightDialog setYesOnclickListener(String str, onYesOnclickListener onYesOnclickListener) {
        if (str != null) {
            yesStr = str;
        }
        this.yesOnclickListener = onYesOnclickListener;
        return  this;
    }
}
