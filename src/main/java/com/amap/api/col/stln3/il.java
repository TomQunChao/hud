package com.amap.api.col.stln3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps.model.CameraPosition;

/* compiled from: CompassView */
public final class il extends LinearLayout {
    Bitmap a;
    Bitmap b;
    Bitmap c;
    ImageView d;
    co e;
    Matrix f = new Matrix();

    public final void a() {
        try {
            removeAllViews();
            if (this.a != null) {
                this.a.recycle();
            }
            if (this.b != null) {
                this.b.recycle();
            }
            if (this.c != null) {
                this.c.recycle();
            }
            if (this.f != null) {
                this.f.reset();
                this.f = null;
            }
            this.c = null;
            this.a = null;
            this.b = null;
        } catch (Throwable th) {
            rx.c(th, "CompassView", "destroy");
            th.printStackTrace();
        }
    }

    public il(Context context, co coVar) {
        super(context);
        this.e = coVar;
        try {
            this.c = ic.a(context, "maps_dav_compass_needle_large.png");
            this.b = ic.a(this.c, ch.a * 0.8f);
            this.c = ic.a(this.c, ch.a * 0.7f);
            if (this.b == null) {
                return;
            }
            if (this.c != null) {
                this.a = Bitmap.createBitmap(this.b.getWidth(), this.b.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.a);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                canvas.drawBitmap(this.c, ((float) (this.b.getWidth() - this.c.getWidth())) / 2.0f, ((float) (this.b.getHeight() - this.c.getHeight())) / 2.0f, paint);
                this.d = new ImageView(context);
                this.d.setScaleType(ImageView.ScaleType.MATRIX);
                this.d.setImageBitmap(this.a);
                this.d.setClickable(true);
                b();
                this.d.setOnTouchListener(new View.OnTouchListener() {
                    /* class com.amap.api.col.stln3.il.AnonymousClass1 */

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        try {
                            if (!il.this.e.isMaploaded()) {
                                return false;
                            }
                            if (motionEvent.getAction() == 0) {
                                il.this.d.setImageBitmap(il.this.b);
                            } else if (motionEvent.getAction() == 1) {
                                il.this.d.setImageBitmap(il.this.a);
                                CameraPosition cameraPosition = il.this.e.getCameraPosition();
                                il.this.e.b(dh.a(new CameraPosition(cameraPosition.target, cameraPosition.zoom, 0.0f, 0.0f)));
                            }
                            return false;
                        } catch (Throwable th) {
                            rx.c(th, "CompassView", "onTouch");
                            th.printStackTrace();
                        }
                    }
                });
                addView(this.d);
            }
        } catch (Throwable th) {
            rx.c(th, "CompassView", "create");
            th.printStackTrace();
        }
    }

    public final void b() {
        try {
            if (this.e != null && this.d != null) {
                float v = this.e.v();
                float u = this.e.u();
                if (this.f == null) {
                    this.f = new Matrix();
                }
                this.f.reset();
                this.f.postRotate(-u, ((float) this.d.getDrawable().getBounds().width()) / 2.0f, ((float) this.d.getDrawable().getBounds().height()) / 2.0f);
                this.f.postScale(1.0f, (float) Math.cos((((double) v) * 3.141592653589793d) / 180.0d), ((float) this.d.getDrawable().getBounds().width()) / 2.0f, ((float) this.d.getDrawable().getBounds().height()) / 2.0f);
                this.d.setImageMatrix(this.f);
            }
        } catch (Throwable th) {
            rx.c(th, "CompassView", "invalidateAngle");
            th.printStackTrace();
        }
    }

    public final void a(boolean z) {
        if (z) {
            setVisibility(0);
            b();
            return;
        }
        setVisibility(8);
    }
}
