package com.amap.api.col.stln3;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.IPoint;

/* compiled from: MyLocationOverlay */
public final class gh {
    a a = null;
    ValueAnimator b;
    Animator.AnimatorListener c = new Animator.AnimatorListener() {
        /* class com.amap.api.col.stln3.gh.AnonymousClass1 */

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            gh.this.f();
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    };
    ValueAnimator.AnimatorUpdateListener d = new ValueAnimator.AnimatorUpdateListener() {
        /* class com.amap.api.col.stln3.gh.AnonymousClass2 */

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                if (gh.this.g != null) {
                    LatLng latLng = (LatLng) valueAnimator.getAnimatedValue();
                    gh.this.g.setCenter(latLng);
                    gh.this.f.setPosition(latLng);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private co e;
    private Marker f;
    private Circle g;
    private MyLocationStyle h = new MyLocationStyle();
    private LatLng i;
    private double j;
    private Context k;
    private da l;
    private int m = 4;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;

    public gh(co coVar, Context context) {
        this.k = context.getApplicationContext();
        this.e = coVar;
        this.l = new da(this.k, coVar);
        a(4, true);
    }

    public final void a(MyLocationStyle myLocationStyle) {
        try {
            this.h = myLocationStyle;
            a(this.h.isMyLocationShowing());
            if (!this.h.isMyLocationShowing()) {
                this.l.a(false);
                this.m = this.h.getMyLocationType();
                return;
            }
            g();
            if (this.f != null || this.g != null) {
                this.l.a(this.f);
                a(this.h.getMyLocationType(), false);
            }
        } catch (Throwable th) {
            rx.c(th, "MyLocationOverlay", "setMyLocationStyle");
            th.printStackTrace();
        }
    }

    public final MyLocationStyle a() {
        return this.h;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void a(int i2, boolean z) {
        this.m = i2;
        this.n = false;
        this.p = false;
        this.o = false;
        this.r = false;
        this.s = false;
        switch (this.m) {
            case 1:
                this.o = true;
                this.p = true;
                this.q = true;
                break;
            case 2:
                this.o = true;
                this.q = true;
                break;
            case 3:
                this.o = true;
                this.s = true;
                break;
            case 4:
                this.o = true;
                this.r = true;
                break;
            case 5:
                this.r = true;
                break;
            case 7:
                this.s = true;
                break;
        }
        if (this.r || this.s) {
            if (this.s) {
                this.l.a(true);
                if (!z) {
                    try {
                        this.e.a(dh.a(17.0f));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                b(45.0f);
            } else {
                this.l.a(false);
            }
            this.l.a();
            Marker marker = this.f;
            if (marker != null) {
                marker.setFlat(true);
                return;
            }
            return;
        }
        Marker marker2 = this.f;
        if (marker2 != null) {
            marker2.setFlat(false);
        }
        co coVar = this.e;
        if (coVar != null) {
            try {
                coVar.a(dh.c(0.0f));
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        b(0.0f);
        this.l.b();
    }

    private void b(float f2) {
        co coVar = this.e;
        if (coVar != null) {
            try {
                coVar.a(dh.b(f2));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(Location location) {
        ValueAnimator valueAnimator;
        long j2;
        if (location != null) {
            a(this.h.isMyLocationShowing());
            if (this.h.isMyLocationShowing()) {
                this.i = new LatLng(location.getLatitude(), location.getLongitude());
                this.j = (double) location.getAccuracy();
                if (this.f == null && this.g == null) {
                    g();
                }
                Circle circle = this.g;
                if (circle != null) {
                    try {
                        if (this.j != -1.0d) {
                            circle.setRadius(this.j);
                        }
                    } catch (Throwable th) {
                        rx.c(th, "MyLocationOverlay", "setCentAndRadius");
                        th.printStackTrace();
                    }
                }
                float bearing = location.getBearing();
                if (this.q) {
                    float f2 = bearing % 360.0f;
                    if (f2 > 180.0f) {
                        f2 -= 360.0f;
                    } else if (f2 < -180.0f) {
                        f2 += 360.0f;
                    }
                    Marker marker = this.f;
                    if (marker != null) {
                        marker.setRotateAngle(-f2);
                    }
                }
                if (!this.i.equals(this.f.getPosition())) {
                    LatLng latLng = this.i;
                    LatLng position = this.f.getPosition();
                    if (position == null) {
                        position = new LatLng(0.0d, 0.0d);
                    }
                    if (this.a == null) {
                        this.a = new a();
                    }
                    ValueAnimator valueAnimator2 = this.b;
                    if (valueAnimator2 == null) {
                        this.b = ValueAnimator.ofObject(new a(), position, latLng);
                        this.b.addListener(this.c);
                        this.b.addUpdateListener(this.d);
                    } else {
                        valueAnimator2.setObjectValues(position, latLng);
                        this.b.setEvaluator(this.a);
                    }
                    if (position.latitude == 0.0d && position.longitude == 0.0d) {
                        valueAnimator = this.b;
                        j2 = 1;
                    } else {
                        valueAnimator = this.b;
                        j2 = 1000;
                    }
                    valueAnimator.setDuration(j2);
                    this.b.start();
                    return;
                }
                f();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f() {
        if (this.i == null || !this.o) {
            return;
        }
        if (!this.p || !this.n) {
            this.n = true;
            try {
                IPoint obtain = IPoint.obtain();
                GLMapState.lonlat2Geo(this.i.longitude, this.i.latitude, obtain);
                this.e.b(dh.a(obtain));
            } catch (Throwable th) {
                rx.c(th, "MyLocationOverlay", "moveMapToLocation");
                th.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0162 A[Catch:{ Throwable -> 0x01e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01c1 A[Catch:{ Throwable -> 0x01e2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g() {
        /*
        // Method dump skipped, instructions count: 496
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.gh.g():void");
    }

    public final void b() throws RemoteException {
        Circle circle = this.g;
        if (circle != null) {
            try {
                this.e.a(circle.getId());
            } catch (Throwable th) {
                rx.c(th, "MyLocationOverlay", "locationIconRemove");
                th.printStackTrace();
            }
            this.g = null;
        }
        Marker marker = this.f;
        if (marker != null) {
            marker.remove();
            this.f = null;
            this.l.a((Marker) null);
        }
        da daVar = this.l;
        if (daVar != null) {
            daVar.b();
            this.l = null;
        }
    }

    private void a(boolean z) {
        Circle circle = this.g;
        if (!(circle == null || circle.isVisible() == z)) {
            this.g.setVisible(z);
        }
        Marker marker = this.f;
        if (marker != null && marker.isVisible() != z) {
            this.f.setVisible(z);
        }
    }

    public final void a(float f2) {
        Marker marker = this.f;
        if (marker != null) {
            marker.setRotateAngle(f2);
        }
    }

    public final String c() {
        Marker marker = this.f;
        if (marker != null) {
            return marker.getId();
        }
        return null;
    }

    public final String d() throws RemoteException {
        Circle circle = this.g;
        if (circle != null) {
            return circle.getId();
        }
        return null;
    }

    public final void e() {
        this.g = null;
        this.f = null;
    }

    /* compiled from: MyLocationOverlay */
    public static class a implements TypeEvaluator {
        @Override // android.animation.TypeEvaluator
        public final Object evaluate(float f, Object obj, Object obj2) {
            LatLng latLng = (LatLng) obj;
            LatLng latLng2 = (LatLng) obj2;
            double d = (double) f;
            return new LatLng(latLng.latitude + ((latLng2.latitude - latLng.latitude) * d), latLng.longitude + (d * (latLng2.longitude - latLng.longitude)));
        }
    }
}
