package com.example.kangxin.myproject.custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by kangxin on 2018/1/8.
 */

public class TrigonView extends View {
    public TrigonView(Context context) {
        super(context);
    }

    public TrigonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TrigonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TrigonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p=new Paint();
        p.setColor(Color.GREEN);
        //实例化路径
        Path path=new Path();
        path.moveTo(80,600);//以此点为多边形的起点
        path.lineTo(120,650);
        path.lineTo(80,650);
        path.close();//使这些点构成封闭的多边形
        canvas.drawPath(path,p);
    }
}
