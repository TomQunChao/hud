package com.amap.api.col.stln3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.view.View;
import com.alibaba.idst.nls.internal.connector.NetDefine;
import com.amap.api.services.core.AMapException;
import com.amap.api.track.ErrorCode;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

/* compiled from: ScaleView */
public final class ip extends View {
    private String a = "";
    private int b = 0;
    private co c;
    private Paint d;
    private Paint e;
    private Rect f;
    private IPoint g;
    private float h = 0.0f;
    private final int[] i = {10000000, 5000000, 2000000, 1000000, 500000, 200000, 100000, 50000, 30000, NetDefine.HTTP_READ_TIMEOUT, ErrorCode.Response.SUCCESS, 5000, AMapException.CODE_AMAP_SERVICE_TABLEID_NOT_EXIST, 1000, 500, 200, 100, 50, 25, 10, 5};

    public final void a() {
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = null;
        this.g = null;
    }

    public ip(Context context, co coVar) {
        super(context);
        this.c = coVar;
        this.d = new Paint();
        this.f = new Rect();
        this.d.setAntiAlias(true);
        this.d.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.d.setStrokeWidth(ch.a * 2.0f);
        this.d.setStyle(Paint.Style.STROKE);
        this.e = new Paint();
        this.e.setAntiAlias(true);
        this.e.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.e.setTextSize(ch.a * 20.0f);
        this.h = (float) hw.b(context);
        this.g = new IPoint();
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        Point o;
        String str = this.a;
        if (str != null && !"".equals(str) && this.b != 0 && (o = this.c.o()) != null) {
            Paint paint = this.e;
            String str2 = this.a;
            paint.getTextBounds(str2, 0, str2.length(), this.f);
            int i2 = o.x;
            int height = (o.y - this.f.height()) + 5;
            canvas.drawText(this.a, (float) (((this.b - this.f.width()) / 2) + i2), (float) height, this.e);
            float f2 = (float) i2;
            float height2 = (float) (height + (this.f.height() - 5));
            canvas.drawLine(f2, height2 - (this.h * 2.0f), f2, height2 + ch.a, this.d);
            canvas.drawLine(f2, height2, (float) (this.b + i2), height2, this.d);
            int i3 = this.b;
            canvas.drawLine((float) (i2 + i3), height2 - (this.h * 2.0f), (float) (i2 + i3), height2 + ch.a, this.d);
        }
    }

    public final void a(String str) {
        this.a = str;
    }

    public final void b() {
        this.b = 0;
    }

    public final void c() {
        co coVar = this.c;
        if (coVar != null) {
            try {
                float b2 = coVar.b();
                this.c.a(this.g);
                if (this.g != null) {
                    DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) this.g.x, (long) this.g.y, 20);
                    float x = this.c.x();
                    int i2 = (int) b2;
                    String a2 = ic.a(this.i[i2]);
                    this.b = (int) (((double) this.i[i2]) / (((double) ((float) ((((Math.cos((pixelsToLatLong.y * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, (double) b2) * 256.0d)))) * ((double) x)));
                    this.a = a2;
                    pixelsToLatLong.recycle();
                    invalidate();
                }
            } catch (Throwable th) {
                rx.c(th, "AMapDelegateImpGLSurfaceView", "changeScaleState");
                th.printStackTrace();
            }
        }
    }
}
