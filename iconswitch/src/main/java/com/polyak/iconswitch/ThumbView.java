package com.polyak.iconswitch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yarolegovich on 31.03.2017.
 * https://github.com/yarolegovich
 */
class ThumbView extends View {
    private static final int PADDING_W = 4;
    private static final int PADDING_H = 8;

    private RectF rect;
    private PointF center;
    private Paint paint;
    private ThumbTypeEnum thumbType = ThumbTypeEnum.CIRCLE;
    private BgTypeEnum bgType = BgTypeEnum.INNER;
    private float radius = 0;

    public ThumbView(Context context) {
        super(context);
    }

    public ThumbView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ThumbView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ThumbView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.GRAY);
        center = new PointF();
        rect = new RectF();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        switch (bgType){
            case INNER:
                switch (thumbType){
                    case CIRCLE:
                        center.set(w * 0.5f, h * 0.5f);
                        radius = Math.min(w, h) * 0.5f;
                        break;
                    case SQUARE:
                        rect.set(0,0,w,h);
                        break;
                }
                break;
            case OUTER:
                switch (thumbType){
                    case CIRCLE:
                        center.set(w * 0.5f, h * 0.5f);
                        radius = (Math.min(w, h) * 0.5f) - PADDING_H;
                        break;
                    case SQUARE:
                        rect.set(PADDING_W, PADDING_H,(w- PADDING_W),(h- PADDING_H));
                        break;
                }
                break;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        switch (thumbType){
            case CIRCLE:
                canvas.drawCircle(center.x, center.y, radius, paint);
                break;
            case SQUARE:
                canvas.drawRoundRect(rect, radius,radius,paint);
                break;
        }
    }

    public void setColor(int color) {
        paint.setColor(color);
        invalidate();
    }

    public void setRadiusX(float radius) {
        this.radius = radius;
    }

    public int getColor() {
        return paint.getColor();
    }

    public void setBgType(BgTypeEnum bgType) {
        this.bgType = bgType;
    }

    public void setThumbType(ThumbTypeEnum thumbType) {
        this.thumbType = thumbType;
    }

}
