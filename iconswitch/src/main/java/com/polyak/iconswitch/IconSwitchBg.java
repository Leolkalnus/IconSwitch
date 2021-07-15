package com.polyak.iconswitch;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by polyak01 on 31.03.2017.
 * https://github.com/polyak01
 */
class IconSwitchBg extends Drawable {
    private static final int STROKE_SIZE = 4;
    private RectF bounds;
    private Paint paint;
    private float radiusX = 0;

    private ThumbTypeEnum thumbType = ThumbTypeEnum.CIRCLE;
    private BgTypeEnum bgType = BgTypeEnum.INNER;

    public IconSwitchBg() {
        bounds = new RectF();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @SuppressWarnings("UnnecessaryLocalVariable")
    public void init(int imageSize, int width, int height) {
        final float centerX = width * 0.5f;
        final float centerY = height * 0.5f;
        float halfWidth = imageSize * 1.75f;
        float halfHeight = imageSize * 0.75f;
        switch (bgType){
            case INNER:
                halfWidth = imageSize * 1.75f;
                halfHeight = imageSize * 0.75f;
                break;
            case OUTER:
                halfWidth = imageSize * 2f-STROKE_SIZE/2;
                halfHeight = imageSize * 1f-STROKE_SIZE/2;
                break;
        }
        bounds.set(
                centerX - halfWidth, centerY - halfHeight,
                centerX + halfWidth, centerY + halfHeight);
        switch (thumbType){
            case CIRCLE:
                radiusX = bounds.height() * 0.5f;
                break;
            case SQUARE:
                break;
        }
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        setPaintStyle();
        canvas.drawRoundRect(bounds, radiusX, radiusX, paint);
    }

    public void setColor(int color) {
        paint.setColor(color);
        setPaintStyle();
        invalidateSelf();
    }

    public void setBgType(BgTypeEnum bgType) {
        this.bgType = bgType;
    }

    public void setThumbType(ThumbTypeEnum thumbType) {
        this.thumbType = thumbType;
    }

    public void setRadiusX(float radiusX) {
        this.radiusX = radiusX;
    }

    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    private void setPaintStyle(){
        switch (bgType){
            case INNER:
                paint.setStyle(Paint.Style.FILL);
                break;
            case OUTER:
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(STROKE_SIZE);
                break;
        }
    }
}
