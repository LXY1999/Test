package com.example.liaoxinying.thetimer2;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class CountdownDrawable extends Drawable {
    private final static int PROGRESS_FACTOR = -360;

    private Paint mPaint;//画笔
    private RectF mArcRect;//画笔

    private float progress;//进度条进度
    private int outlineColor;//边框圆颜色
    private int innerColor;//内部圆颜色
    private int ringColor;//进度条颜色
    private int ringWidth;//进度条宽度
    private int showNumber;//倒计时数字
    private int textColor;//数字颜色

    @Override
    public void draw(@NonNull Canvas canvas) {
        //获取view的边界
        final Rect bounds=getBounds();
        int size= bounds.height()>bounds.width()?bounds.width():bounds.height();
        float outerRadius=((size/2)*0.75f)*0.937f;
        float innerRadius = ((size / 2) * 0.75f) * 0.75f;
        float offsetX = (bounds.width() - outerRadius * 2) / 2;
        float offsetY = (bounds.height() - outerRadius * 2) / 2;

        //画边框圆
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(1);
        mPaint.setColor(outlineColor);
        canvas.drawCircle(bounds.centerX(), bounds.centerY(), outerRadius, mPaint);

        //画内部背景
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(innerColor);
        canvas.drawCircle(bounds.centerX(), bounds.centerY(), innerRadius, mPaint);

        //画倒计时数字
        float textSize = innerRadius * 2 * 0.75f;
        mPaint.setTextSize(textSize);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setColor(textColor);
        float textX = bounds.centerX();
        float textY = bounds.centerY() - (mPaint.descent() + mPaint.ascent()) / 2;
        canvas.drawText(Integer.toString(showNumber), textX, textY, mPaint);

        //画进度条
        int halfRingWidth = ringWidth / 2;
        float arcX0 = offsetX + halfRingWidth;
        float arcY0 = offsetY + halfRingWidth;
        float arcX = offsetX + outerRadius * 2 - halfRingWidth;
        float arcY = offsetY + outerRadius * 2 - halfRingWidth;

        mPaint.setColor(ringColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(ringWidth);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mArcRect.set(arcX0, arcY0, arcX, arcY);
        canvas.drawArc(mArcRect, 89, progress, false, mPaint);
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return mPaint.getAlpha();
    }

    //初始化变量
    public CountdownDrawable(int ringWidth, int outlineColor, int innerColor, int ringColor, int showNumber, int textColor) {
        mPaint = new Paint();
        mArcRect = new RectF();

        this.outlineColor = outlineColor;
        this.innerColor = innerColor;
        this.ringColor = ringColor;
        this.ringWidth = ringWidth;
        this.showNumber = showNumber;
        this.textColor = textColor;
    }

    public float getProgress() {
        return progress / PROGRESS_FACTOR;
    }

    public void setProgress(float progress) {
        this.progress = progress * PROGRESS_FACTOR;

        invalidateSelf();
    }

    public int getShowNumber() {
        return showNumber;
    }

    public void setShowNumber(int showNumber) {
        this.showNumber = showNumber;

        invalidateSelf();
    }
}
