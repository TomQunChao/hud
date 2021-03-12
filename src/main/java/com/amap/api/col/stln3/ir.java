package com.amap.api.col.stln3;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.col.stln3.io;

/* access modifiers changed from: package-private */
/* compiled from: ZoomControllerView */
public final class ir extends LinearLayout {
    private Bitmap a;
    private Bitmap b;
    private Bitmap c;
    private Bitmap d;
    private Bitmap e;
    private Bitmap f;
    private Bitmap g;
    private Bitmap h;
    private Bitmap i;
    private Bitmap j;
    private Bitmap k;
    private Bitmap l;
    private ImageView m;
    private ImageView n;
    private co o;

    public final void a() {
        try {
            removeAllViews();
            this.a.recycle();
            this.b.recycle();
            this.c.recycle();
            this.d.recycle();
            this.e.recycle();
            this.f.recycle();
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            if (this.g != null) {
                this.g.recycle();
                this.g = null;
            }
            if (this.h != null) {
                this.h.recycle();
                this.h = null;
            }
            if (this.i != null) {
                this.i.recycle();
                this.i = null;
            }
            if (this.j != null) {
                this.j.recycle();
                this.g = null;
            }
            if (this.k != null) {
                this.k.recycle();
                this.k = null;
            }
            if (this.l != null) {
                this.l.recycle();
                this.l = null;
            }
            this.m = null;
            this.n = null;
        } catch (Throwable th) {
            rx.c(th, "ZoomControllerView", "destory");
            th.printStackTrace();
        }
    }

    public ir(Context context, co coVar) {
        super(context);
        this.o = coVar;
        try {
            this.g = ic.a(context, "zoomin_selected.png");
            this.a = ic.a(this.g, ch.a);
            this.h = ic.a(context, "zoomin_unselected.png");
            this.b = ic.a(this.h, ch.a);
            this.i = ic.a(context, "zoomout_selected.png");
            this.c = ic.a(this.i, ch.a);
            this.j = ic.a(context, "zoomout_unselected.png");
            this.d = ic.a(this.j, ch.a);
            this.k = ic.a(context, "zoomin_pressed.png");
            this.e = ic.a(this.k, ch.a);
            this.l = ic.a(context, "zoomout_pressed.png");
            this.f = ic.a(this.l, ch.a);
            this.m = new ImageView(context);
            this.m.setImageBitmap(this.a);
            this.m.setClickable(true);
            this.n = new ImageView(context);
            this.n.setImageBitmap(this.c);
            this.n.setClickable(true);
            this.m.setOnTouchListener(new View.OnTouchListener() {
                /* class com.amap.api.col.stln3.ir.AnonymousClass1 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    try {
                        if (ir.this.o.j() < ir.this.o.getMaxZoomLevel()) {
                            if (ir.this.o.isMaploaded()) {
                                if (motionEvent.getAction() == 0) {
                                    ir.this.m.setImageBitmap(ir.this.e);
                                } else if (motionEvent.getAction() == 1) {
                                    ir.this.m.setImageBitmap(ir.this.a);
                                    try {
                                        ir.this.o.b(dh.a());
                                    } catch (RemoteException e) {
                                        rx.c(e, "ZoomControllerView", "zoomin ontouch");
                                        e.printStackTrace();
                                    }
                                }
                                return false;
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            this.n.setOnTouchListener(new View.OnTouchListener() {
                /* class com.amap.api.col.stln3.ir.AnonymousClass2 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    try {
                        if (ir.this.o.j() > ir.this.o.getMinZoomLevel()) {
                            if (ir.this.o.isMaploaded()) {
                                if (motionEvent.getAction() == 0) {
                                    ir.this.n.setImageBitmap(ir.this.f);
                                } else if (motionEvent.getAction() == 1) {
                                    ir.this.n.setImageBitmap(ir.this.c);
                                    ir.this.o.b(dh.b());
                                }
                                return false;
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        rx.c(th, "ZoomControllerView", "zoomout ontouch");
                        th.printStackTrace();
                    }
                }
            });
            this.m.setPadding(0, 0, 20, -2);
            this.n.setPadding(0, 0, 20, 20);
            setOrientation(1);
            addView(this.m);
            addView(this.n);
        } catch (Throwable th) {
            rx.c(th, "ZoomControllerView", "create");
            th.printStackTrace();
        }
    }

    public final void a(float f2) {
        try {
            if (f2 < this.o.getMaxZoomLevel()) {
                if (f2 > this.o.getMinZoomLevel()) {
                    this.m.setImageBitmap(this.a);
                    this.n.setImageBitmap(this.c);
                    return;
                }
            }
            if (f2 == this.o.getMinZoomLevel()) {
                this.n.setImageBitmap(this.d);
                this.m.setImageBitmap(this.a);
            } else if (f2 == this.o.getMaxZoomLevel()) {
                this.m.setImageBitmap(this.b);
                this.n.setImageBitmap(this.c);
            }
        } catch (Throwable th) {
            rx.c(th, "ZoomControllerView", "setZoomBitmap");
            th.printStackTrace();
        }
    }

    public final void a(int i2) {
        try {
            io.a aVar = (io.a) getLayoutParams();
            if (i2 == 1) {
                aVar.d = 16;
            } else if (i2 == 2) {
                aVar.d = 80;
            }
            setLayoutParams(aVar);
        } catch (Throwable th) {
            rx.c(th, "ZoomControllerView", "setZoomPosition");
            th.printStackTrace();
        }
    }

    public final void a(boolean z) {
        if (z) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }
}
