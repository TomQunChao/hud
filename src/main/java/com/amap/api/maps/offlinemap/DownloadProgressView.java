package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.internal.view.SupportMenu;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.amap.api.col.stln3.bu;

public class DownloadProgressView extends View {
    private String a;
    private int b = SupportMenu.CATEGORY_MASK;
    private int c = SupportMenu.CATEGORY_MASK;
    private float d = 0.0f;
    private float e = 0.6f;
    private TextPaint f;
    private TextPaint g;
    private float h;
    private float i;

    public DownloadProgressView(Context context) {
        super(context);
        a(null, 0);
    }

    public DownloadProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet, 0);
    }

    public DownloadProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet, i2);
    }

    private void a(AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, bu.a.a, i2, 0);
        this.a = obtainStyledAttributes.getString(0);
        this.b = obtainStyledAttributes.getColor(3, this.b);
        this.d = obtainStyledAttributes.getDimension(1, this.d);
        this.c = obtainStyledAttributes.getColor(2, this.c);
        obtainStyledAttributes.recycle();
        this.f = new TextPaint();
        this.f.setFlags(1);
        this.f.setTextAlign(Paint.Align.RIGHT);
        this.g = new TextPaint();
        this.g.setStyle(Paint.Style.FILL);
        this.f.setTextSize(this.d);
        this.f.setColor(this.b);
        this.g.setColor(this.c);
        this.h = this.f.measureText(this.a);
        this.i = this.f.getFontMetrics().bottom;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int height = (getHeight() - paddingTop) - getPaddingBottom();
        double d2 = (double) (((float) height) * 0.8f);
        float width = (float) ((getWidth() - paddingLeft) - paddingRight);
        canvas.drawRect(new Rect(0, (int) d2, (int) (width * this.e), height), this.g);
        canvas.drawText(String.valueOf((int) (this.e * 100.0f)) + "%", (float) ((int) ((double) (this.e * width))), (float) ((int) (d2 - 3.0d)), this.f);
    }

    public void setProgress(int i2) {
        if (i2 <= 100 && i2 >= 0) {
            this.e = ((float) i2) / 100.0f;
            invalidate();
        }
    }
}
