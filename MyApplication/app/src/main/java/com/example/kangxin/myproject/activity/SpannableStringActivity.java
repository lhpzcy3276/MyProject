package com.example.kangxin.myproject.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.TextView;

import com.example.kangxin.myproject.R;
import com.example.kangxin.myproject.utils.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpannableStringActivity extends BaseActivity {

    @BindView(R.id.spannablestring_tx)
    TextView textView;
    @BindView(R.id.spannablestring_tx2)
    TextView textView2;
    @BindView(R.id.spannablestring_tx3)
    TextView textView3;
    @BindView(R.id.spannablestring_tx4)
    TextView textView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spannable_string);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        SpannableString spannableString=new SpannableString("设置文字的前景色为淡蓝色");
        ForegroundColorSpan colorSpan=new ForegroundColorSpan(Color.parseColor("#0099EE"));
        spannableString.setSpan(colorSpan,9,spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);

        SpannableString spannableString1=new SpannableString("设置文字的背景色为淡绿色");
        BackgroundColorSpan colorSpan1=new BackgroundColorSpan(Color.parseColor("#ac00ff30"));
        spannableString1.setSpan(colorSpan1,8,spannableString1.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView2.setText(spannableString1);

        relativeText();

        clickText();
    }

    private void clickText() {
        SpannableString spannableString=new SpannableString("为文字设置点击事件");

    }

    private void relativeText() {
        SpannableString spannableString=new SpannableString("万丈高楼平地起");
        RelativeSizeSpan sizeSpan01 = new RelativeSizeSpan(1.2f);
        RelativeSizeSpan sizeSpan02 = new RelativeSizeSpan(1.4f);
        RelativeSizeSpan sizeSpan03 = new RelativeSizeSpan(1.6f);
        RelativeSizeSpan sizeSpan04 = new RelativeSizeSpan(1.8f);
        RelativeSizeSpan sizeSpan05 = new RelativeSizeSpan(1.6f);
        RelativeSizeSpan sizeSpan06 = new RelativeSizeSpan(1.4f);
        RelativeSizeSpan sizeSpan07 = new RelativeSizeSpan(1.2f);

        spannableString.setSpan(sizeSpan01, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(sizeSpan02, 1, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(sizeSpan03, 2, 3, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(sizeSpan04, 3, 4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(sizeSpan05, 4, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(sizeSpan06, 5, 6, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(sizeSpan07, 6, 7, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView3.setText(spannableString);


    }

    class MyClickableSpan extends ClickableSpan{

        @Override
        public void onClick(View widget) {

        }
    }
}
