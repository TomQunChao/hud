package com.amap.api.col.stln3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v4.view.ViewCompat;
import android.view.View;
import java.io.File;

/* compiled from: WaterMarkerView */
public final class iq extends View {
    private Bitmap a;
    private Bitmap b;
    private Bitmap c;
    private Bitmap d;
    private Bitmap e;
    private Bitmap f;
    private Paint g = new Paint();
    private boolean h = false;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 10;
    private int m = 0;
    private int n = 0;
    private int o = 10;
    private int p = 8;
    private boolean q = false;
    private boolean r = false;
    private Context s;
    private float t = 0.0f;
    private float u = 0.0f;
    private boolean v = true;

    public final void a() {
        try {
            if (this.a != null) {
                this.a.recycle();
            }
            if (this.b != null) {
                this.b.recycle();
            }
            this.a = null;
            this.b = null;
            if (this.e != null) {
                this.e.recycle();
                this.e = null;
            }
            if (this.f != null) {
                this.f.recycle();
                this.f = null;
            }
            if (this.c != null) {
                this.c.recycle();
            }
            this.c = null;
            if (this.d != null) {
                this.d.recycle();
            }
            this.d = null;
            this.g = null;
        } catch (Throwable th) {
            rx.c(th, "WaterMarkerView", "destory");
            th.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x011d A[SYNTHETIC, Splitter:B:38:0x011d] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0129 A[SYNTHETIC, Splitter:B:43:0x0129] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public iq(android.content.Context r6) {
        /*
        // Method dump skipped, instructions count: 309
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.iq.<init>(android.content.Context):void");
    }

    public final void a(boolean z) {
        try {
            this.h = z;
            if (z) {
                this.g.setColor(-1);
            } else {
                this.g.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
        } catch (Throwable th) {
            rx.c(th, "WaterMarkerView", "changeBitmap");
            th.printStackTrace();
        }
    }

    public final Point b() {
        return new Point(this.l, this.m - 2);
    }

    public final void a(int i2) {
        this.n = 0;
        this.k = i2;
        c();
    }

    public final void b(int i2) {
        this.n = 1;
        this.p = i2;
        c();
    }

    public final void c(int i2) {
        this.n = 1;
        this.o = i2;
        c();
    }

    public final float d(int i2) {
        switch (i2) {
            case 0:
                return this.t;
            case 1:
                return 1.0f - this.t;
            case 2:
                return 1.0f - this.u;
            default:
                return 0.0f;
        }
    }

    public final void a(int i2, float f2) {
        this.n = 2;
        float max = Math.max(0.0f, Math.min(f2, 1.0f));
        switch (i2) {
            case 0:
                this.t = max;
                this.v = true;
                break;
            case 1:
                this.t = 1.0f - max;
                this.v = false;
                break;
            case 2:
                this.u = 1.0f - max;
                break;
        }
        c();
    }

    public final void c() {
        if (getWidth() != 0 && getHeight() != 0) {
            e();
            postInvalidate();
        }
    }

    public final void onDraw(Canvas canvas) {
        try {
            if (getWidth() == 0) {
                return;
            }
            if (getHeight() != 0) {
                if (this.b != null) {
                    if (!this.q) {
                        e();
                        this.q = true;
                    }
                    canvas.drawBitmap(this.h ? (!this.r || this.d == null) ? this.b : this.d : (!this.r || this.c == null) ? this.a : this.c, (float) this.l, (float) this.m, this.g);
                }
            }
        } catch (Throwable th) {
            rx.c(th, "WaterMarkerView", "onDraw");
            th.printStackTrace();
        }
    }

    private void e() {
        int width;
        switch (this.n) {
            case 0:
                int i2 = this.k;
                if (i2 != 1) {
                    if (i2 != 2) {
                        this.o = 10;
                        this.p = 8;
                        break;
                    } else {
                        width = (getWidth() - this.j) - 10;
                    }
                } else {
                    width = (getWidth() - this.j) / 2;
                }
                this.o = width;
                this.p = 8;
            case 2:
                this.o = (int) (this.v ? ((float) getWidth()) * this.t : (((float) getWidth()) * this.t) - ((float) this.j));
                this.p = (int) (((float) getHeight()) * this.u);
                break;
        }
        this.l = this.o;
        this.m = (getHeight() - this.p) - this.i;
        if (this.l < 0) {
            this.l = 0;
        }
        if (this.m < 0) {
            this.m = 0;
        }
    }

    public final void a(String str, int i2) {
        try {
            if (new File(str).exists()) {
                if (i2 == 0) {
                    Bitmap bitmap = this.c;
                    this.e = BitmapFactory.decodeFile(str);
                    this.c = ic.a(this.e, ch.a);
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                } else if (i2 == 1) {
                    Bitmap bitmap2 = this.d;
                    this.e = BitmapFactory.decodeFile(str);
                    this.d = ic.a(this.e, ch.a);
                    if (bitmap2 != null && !bitmap2.isRecycled()) {
                        bitmap2.recycle();
                    }
                }
            }
        } catch (Throwable th) {
            rx.c(th, "WaterMarkerView", "create");
            th.printStackTrace();
        }
    }

    public final void b(boolean z) {
        if (this.r != z) {
            this.r = z;
            if (!z) {
                this.j = this.a.getWidth();
                this.i = this.a.getHeight();
            } else if (this.h) {
                Bitmap bitmap = this.d;
                if (bitmap != null) {
                    this.j = bitmap.getWidth();
                    this.i = this.d.getHeight();
                }
            } else {
                Bitmap bitmap2 = this.c;
                if (bitmap2 != null) {
                    this.j = bitmap2.getWidth();
                    this.i = this.c.getHeight();
                }
            }
        }
    }

    public final boolean d() {
        return this.h;
    }
}
