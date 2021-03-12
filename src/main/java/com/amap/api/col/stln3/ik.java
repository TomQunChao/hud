package com.amap.api.col.stln3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/* compiled from: BlankView */
public final class ik extends View {
    public static final int a = Color.argb(255, 235, 235, 235);
    public static final int b = Color.argb(255, 21, 21, 21);
    private Paint c = new Paint();

    public ik(Context context) {
        super(context);
        this.c.setAntiAlias(true);
        this.c.setColor(a);
    }

    public final void a(int i) {
        Paint paint = this.c;
        if (paint != null) {
            paint.setColor(i);
        }
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.c);
    }

    public final void a() {
        setVisibility(8);
    }
}
