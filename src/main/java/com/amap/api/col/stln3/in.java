package com.amap.api.col.stln3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps.model.LatLng;

/* compiled from: LocationView */
public final class in extends LinearLayout {
    Bitmap a;
    Bitmap b;
    Bitmap c;
    Bitmap d;
    Bitmap e;
    Bitmap f;
    ImageView g;
    co h;
    boolean i = false;

    public final void a() {
        try {
            removeAllViews();
            if (this.a != null) {
                this.a.recycle();
            }
            if (this.b != null) {
                this.b.recycle();
            }
            if (this.b != null) {
                this.c.recycle();
            }
            this.a = null;
            this.b = null;
            this.c = null;
            if (this.d != null) {
                this.d.recycle();
                this.d = null;
            }
            if (this.e != null) {
                this.e.recycle();
                this.e = null;
            }
            if (this.f != null) {
                this.f.recycle();
                this.f = null;
            }
        } catch (Throwable th) {
            rx.c(th, "LocationView", "destroy");
            th.printStackTrace();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public in(Context context, co coVar) {
        super(context);
        this.h = coVar;
        try {
            this.d = ic.a(context, "location_selected.png");
            this.a = ic.a(this.d, ch.a);
            this.e = ic.a(context, "location_pressed.png");
            this.b = ic.a(this.e, ch.a);
            this.f = ic.a(context, "location_unselected.png");
            this.c = ic.a(this.f, ch.a);
            this.g = new ImageView(context);
            this.g.setImageBitmap(this.a);
            this.g.setClickable(true);
            this.g.setPadding(0, 20, 20, 0);
            this.g.setOnTouchListener(new View.OnTouchListener() {
                /* class com.amap.api.col.stln3.in.AnonymousClass1 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (!in.this.i) {
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        in.this.g.setImageBitmap(in.this.b);
                    } else if (motionEvent.getAction() == 1) {
                        try {
                            in.this.g.setImageBitmap(in.this.a);
                            in.this.h.setMyLocationEnabled(true);
                            Location myLocation = in.this.h.getMyLocation();
                            if (myLocation == null) {
                                return false;
                            }
                            LatLng latLng = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
                            in.this.h.a(myLocation);
                            in.this.h.a(dh.a(latLng, in.this.h.j()));
                        } catch (Throwable th) {
                            rx.c(th, "LocationView", "onTouch");
                            th.printStackTrace();
                        }
                    }
                    return false;
                }
            });
            addView(this.g);
        } catch (Throwable th) {
            rx.c(th, "LocationView", "create");
            th.printStackTrace();
        }
    }

    public final void a(boolean z) {
        this.i = z;
        if (z) {
            try {
                this.g.setImageBitmap(this.a);
            } catch (Throwable th) {
                rx.c(th, "LocationView", "showSelect");
                th.printStackTrace();
                return;
            }
        } else {
            this.g.setImageBitmap(this.c);
        }
        this.g.invalidate();
    }
}
