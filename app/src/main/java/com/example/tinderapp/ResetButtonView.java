package com.example.tinderapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class ResetButtonView extends View {
    public ResetButtonView(Context context) {
        super(context);
    }

    public ResetButtonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ResetButtonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ResetButtonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.FILL);
        float cW = getWidth() / 2;
        float cH = getHeight() / 2;
        canvas.drawCircle(cW, cH, 70, paint);
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(5);
        float[] pts = new float[] {cW - 30, cH - 30, cW - 30, cH + 30,
                cW - 30, cH + 30, cW + 30, cH + 30,
                cW + 30, cH + 30, cW + 30, cH - 30,
                cW + 30, cH - 30, cW     , cH - 60,
                cW     , cH - 60, cW - 30, cH - 30,
                cW - 30, cH - 30, cW + 30, cH - 30 };
        canvas.drawLines(pts, paint);
    }
}
