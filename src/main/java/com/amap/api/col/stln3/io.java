package com.amap.api.col.stln3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.Marker;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;

/* compiled from: MapOverlayViewGroup */
public final class io extends ViewGroup implements dr {
    ds a;
    private co b;
    private Context c;
    private iq d;
    private in e;
    private il f;
    private ip g;
    private ik h;
    private im i;
    private ir j;
    private View k;
    private cg l;
    private Drawable m = null;
    private boolean n;
    private View o;
    private boolean p;

    public io(Context context, co coVar) {
        super(context);
        int i2 = 1;
        this.n = true;
        try {
            this.b = coVar;
            this.c = context;
            co coVar2 = this.b;
            this.d = new iq(context);
            this.g = new ip(context, this.b);
            this.h = new ik(context);
            this.i = new im(context);
            this.j = new ir(context, this.b);
            this.e = new in(context, this.b);
            this.f = new il(context, this.b);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (this.b.p() != null) {
                addView(this.b.p(), 0, layoutParams);
            } else {
                i2 = 0;
            }
            addView(this.h, i2, layoutParams);
            addView(this.d, layoutParams);
            addView(this.g, layoutParams);
            addView(this.i, new ViewGroup.LayoutParams(-2, -2));
            addView(this.j, new a(-2, -2, new FPoint(0.0f, 0.0f), 0, 0, 83));
            addView(this.e, new a(-2, -2, FPoint.obtain(0.0f, 0.0f), 0, 0, 83));
            addView(this.f, new a(-2, -2, FPoint.obtain(0.0f, 0.0f), 0, 0, 51));
            this.f.setVisibility(8);
            this.b.a(new AMapWidgetListener() {
                /* class com.amap.api.col.stln3.io.AnonymousClass1 */

                @Override // com.autonavi.ae.gmap.listener.AMapWidgetListener
                public final void invalidateScaleView() {
                    if (io.this.g != null) {
                        io.this.g.post(new Runnable() {
                            /* class com.amap.api.col.stln3.io.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                io.this.g.c();
                            }
                        });
                    }
                }

                @Override // com.autonavi.ae.gmap.listener.AMapWidgetListener
                public final void invalidateCompassView() {
                    if (io.this.f != null) {
                        io.this.f.post(new Runnable() {
                            /* class com.amap.api.col.stln3.io.AnonymousClass1.AnonymousClass2 */

                            public final void run() {
                                io.this.f.b();
                            }
                        });
                    }
                }

                @Override // com.autonavi.ae.gmap.listener.AMapWidgetListener
                public final void invalidateZoomController(final float f) {
                    if (io.this.j != null) {
                        io.this.j.post(new Runnable() {
                            /* class com.amap.api.col.stln3.io.AnonymousClass1.AnonymousClass3 */

                            public final void run() {
                                io.this.j.a(f);
                            }
                        });
                    }
                }

                @Override // com.autonavi.ae.gmap.listener.AMapWidgetListener
                public final void setFrontViewVisibility(boolean z) {
                }
            });
            try {
                if (!this.b.k().isMyLocationButtonEnabled()) {
                    this.e.setVisibility(8);
                }
            } catch (Throwable th) {
                rx.c(th, "AMapDelegateImpGLSurfaceView", "locationView gone");
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void a(boolean z) {
        if (this.i != null && z && this.b.q()) {
            this.i.a(true);
        }
    }

    public final void b(boolean z) {
        ir irVar = this.j;
        if (irVar != null) {
            irVar.a(z);
        }
    }

    public final void c(boolean z) {
        in inVar = this.e;
        if (inVar != null) {
            if (z) {
                inVar.setVisibility(0);
            } else {
                inVar.setVisibility(8);
            }
        }
    }

    public final void d(boolean z) {
        il ilVar = this.f;
        if (ilVar != null) {
            ilVar.a(z);
        }
    }

    public final void e(boolean z) {
        ip ipVar = this.g;
        if (ipVar != null) {
            if (z) {
                ipVar.setVisibility(0);
                ipVar.c();
                return;
            }
            ipVar.a("");
            ipVar.b();
            ipVar.setVisibility(8);
        }
    }

    public final void f(boolean z) {
        iq iqVar = this.d;
        if (iqVar != null) {
            iqVar.setVisibility(z ? 0 : 8);
        }
    }

    public final void a(String str, boolean z, int i2) {
        if (this.d != null && !TextUtils.isEmpty(str)) {
            this.d.a(str, i2);
            this.d.b(z);
        }
    }

    public final void a(float f2) {
        ir irVar = this.j;
        if (irVar != null) {
            irVar.a(f2);
        }
    }

    public final void a(int i2) {
        ir irVar = this.j;
        if (irVar != null) {
            irVar.a(i2);
        }
    }

    public final void b(int i2) {
        iq iqVar = this.d;
        if (iqVar != null) {
            iqVar.a(i2);
            this.d.postInvalidate();
            m();
        }
    }

    private void m() {
        ip ipVar = this.g;
        if (ipVar != null && ipVar.getVisibility() == 0) {
            this.g.postInvalidate();
        }
    }

    public final void c(int i2) {
        iq iqVar = this.d;
        if (iqVar != null) {
            iqVar.b(i2);
            m();
        }
    }

    public final void d(int i2) {
        iq iqVar = this.d;
        if (iqVar != null) {
            iqVar.c(i2);
            m();
        }
    }

    public final float e(int i2) {
        if (this.d == null) {
            return 0.0f;
        }
        m();
        return this.d.d(i2);
    }

    public final void a(int i2, float f2) {
        iq iqVar = this.d;
        if (iqVar != null) {
            iqVar.a(i2, f2);
            m();
        }
    }

    @Override // com.amap.api.col.stln3.dr
    public final void a(ds dsVar) {
        this.a = dsVar;
    }

    public final Point c() {
        iq iqVar = this.d;
        if (iqVar == null) {
            return null;
        }
        return iqVar.b();
    }

    public final void g(boolean z) {
        iq iqVar = this.d;
        if (iqVar == null || !z) {
            iq iqVar2 = this.d;
            if (iqVar2 != null) {
                iqVar2.a(false);
                return;
            }
            return;
        }
        iqVar.a(true);
    }

    public final boolean d() {
        iq iqVar = this.d;
        if (iqVar != null) {
            return iqVar.d();
        }
        return false;
    }

    public final void e() {
        iq iqVar = this.d;
        if (iqVar != null) {
            iqVar.c();
        }
    }

    public final ik f() {
        return this.h;
    }

    public final im g() {
        return this.i;
    }

    public final in h() {
        return this.e;
    }

    public final il i() {
        return this.f;
    }

    public final iq j() {
        return this.d;
    }

    public final void a(CameraPosition cameraPosition) {
        if (this.b.k().isLogoEnable()) {
            if (MapsInitializer.isLoadWorldGridMap() && cameraPosition.zoom >= 7.0f && !hv.a(cameraPosition.target.latitude, cameraPosition.target.longitude)) {
                this.d.setVisibility(8);
            } else if (this.b.s() == -1) {
                this.d.setVisibility(0);
            }
        }
    }

    /* compiled from: MapOverlayViewGroup */
    public static class a extends ViewGroup.LayoutParams {
        public FPoint a = null;
        public int b = 0;
        public int c = 0;
        public int d = 51;

        public a(int i, int i2, FPoint fPoint, int i3, int i4, int i5) {
            super(i, i2);
            this.a = fPoint;
            this.b = i3;
            this.c = i4;
            this.d = i5;
        }
    }

    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        try {
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (childAt != null) {
                    if (childAt.getLayoutParams() instanceof a) {
                        a aVar = (a) childAt.getLayoutParams();
                        int[] iArr = new int[2];
                        a(childAt, aVar.width, aVar.height, iArr);
                        if (childAt instanceof ir) {
                            i6 = iArr[0];
                            i7 = iArr[1];
                            i8 = getWidth() - iArr[0];
                            i9 = getHeight();
                            i10 = aVar.d;
                        } else if (childAt instanceof in) {
                            i6 = iArr[0];
                            i7 = iArr[1];
                            i8 = getWidth() - iArr[0];
                            i9 = iArr[1];
                            i10 = aVar.d;
                        } else if (childAt instanceof il) {
                            i6 = iArr[0];
                            i7 = iArr[1];
                            i8 = 0;
                            i9 = 0;
                            i10 = aVar.d;
                        } else if (aVar.a != null) {
                            IPoint obtain = IPoint.obtain();
                            MapConfig mapConfig = this.b.getMapConfig();
                            GLMapState f2 = this.b.f();
                            if (!(mapConfig == null || f2 == null)) {
                                FPoint obtain2 = FPoint.obtain();
                                f2.p20ToScreenPoint(mapConfig.getSX() + ((int) aVar.a.x), mapConfig.getSY() + ((int) aVar.a.y), obtain2);
                                obtain.x = (int) obtain2.x;
                                obtain.y = (int) obtain2.y;
                                obtain2.recycle();
                            }
                            obtain.x += aVar.b;
                            obtain.y += aVar.c;
                            a(childAt, iArr[0], iArr[1], obtain.x, obtain.y, aVar.d);
                            obtain.recycle();
                        }
                        a(childAt, i6, i7, i8, i9, i10);
                    } else {
                        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                        int[] iArr2 = new int[2];
                        a(childAt, layoutParams.width, layoutParams.height, iArr2);
                        if (childAt instanceof im) {
                            a(childAt, iArr2[0], iArr2[1], 20, (this.b.o().y - 80) - iArr2[1], 51);
                        } else {
                            a(childAt, iArr2[0], iArr2[1], 0, 0, 51);
                        }
                    }
                }
            }
            this.d.c();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.stln3.dr
    public final void a(cg cgVar) {
        if (cgVar != null) {
            try {
                if (this.a != null && this.a.a()) {
                    if (cgVar.getTitle() == null && cgVar.getSnippet() == null) {
                        return;
                    }
                }
                if (cgVar.isInfoWindowEnable()) {
                    if (this.l != null && !this.l.getId().equals(cgVar.getId())) {
                        b_();
                    }
                    if (this.a != null) {
                        this.l = cgVar;
                        cgVar.a(true);
                        this.p = true;
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    private View b(cg cgVar) throws RemoteException {
        Throwable th;
        View view;
        View view2;
        Throwable th2;
        View view3;
        View view4 = null;
        if (cgVar instanceof gg) {
            Marker marker = new Marker((gg) cgVar);
            try {
                if (this.m == null) {
                    this.m = hs.a(this.c, "infowindow_bg.9.png");
                }
            } catch (Throwable th3) {
                rx.c(th3, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
                th3.printStackTrace();
            }
            try {
                if (this.p) {
                    view3 = this.a.a((BasePointOverlay) marker);
                    if (view3 == null) {
                        try {
                            view3 = this.a.b((BasePointOverlay) marker);
                        } catch (Throwable th4) {
                            th2 = th4;
                            view4 = view3;
                            rx.c(th2, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                            th2.printStackTrace();
                            return view4;
                        }
                    }
                    this.o = view3;
                    this.p = false;
                } else {
                    view3 = this.o;
                }
                if (view3 != null) {
                    view4 = view3;
                } else if (!this.a.a()) {
                    return null;
                } else {
                    view4 = this.a.a((BasePointOverlay) marker);
                }
                if (view4 != null && view4.getBackground() == null) {
                    view4.setBackground(this.m);
                }
            } catch (Throwable th5) {
                th2 = th5;
                rx.c(th2, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                th2.printStackTrace();
                return view4;
            }
        } else {
            try {
                if (this.m == null) {
                    this.m = hs.a(this.c, "infowindow_bg.9.png");
                }
            } catch (Throwable th6) {
                rx.c(th6, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
                th6.printStackTrace();
            }
            try {
                GL3DModel gL3DModel = new GL3DModel((fr) cgVar);
                if (this.p) {
                    view = this.a.a(gL3DModel);
                    if (view == null) {
                        try {
                            view = this.a.b(gL3DModel);
                        } catch (Throwable th7) {
                            th = th7;
                            view4 = view;
                            rx.c(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                            th.printStackTrace();
                            return view4;
                        }
                    }
                    this.o = view;
                    this.p = false;
                } else {
                    view = this.o;
                }
                if (view != null) {
                    view2 = view;
                } else if (!this.a.a()) {
                    return null;
                } else {
                    view2 = this.a.a(gL3DModel);
                }
                if (view2.getBackground() == null) {
                    view2.setBackground(this.m);
                }
                return view2;
            } catch (Throwable th8) {
                th = th8;
                rx.c(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                th.printStackTrace();
                return view4;
            }
        }
        return view4;
    }

    @Override // com.amap.api.col.stln3.dr
    public final void a_() {
        int i2;
        try {
            if (this.l == null || !this.l.h()) {
                if (this.k != null && this.k.getVisibility() == 0) {
                    this.k.setVisibility(8);
                }
            } else if (this.n) {
                int e2 = this.l.e() + this.l.c();
                int f2 = this.l.f() + this.l.d() + 2;
                View b2 = b(this.l);
                if (b2 != null) {
                    if (b2 != null) {
                        if (this.k != null) {
                            if (b2 != this.k) {
                                this.k.clearFocus();
                                removeView(this.k);
                            }
                        }
                        this.k = b2;
                        ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
                        this.k.setDrawingCacheEnabled(true);
                        this.k.setDrawingCacheQuality(0);
                        this.l.i();
                        int i3 = -2;
                        if (layoutParams != null) {
                            i3 = layoutParams.width;
                            i2 = layoutParams.height;
                        } else {
                            i2 = -2;
                        }
                        addView(this.k, new a(i3, i2, this.l.a(), e2, f2, 81));
                    }
                    if (this.k != null) {
                        a aVar = (a) this.k.getLayoutParams();
                        if (aVar != null) {
                            aVar.a = this.l.a();
                            aVar.b = e2;
                            aVar.c = f2;
                        }
                        onLayout(false, 0, 0, 0, 0);
                        if (this.a.a()) {
                            this.a.a(this.l.getTitle(), this.l.getSnippet());
                        }
                        if (this.k.getVisibility() == 8) {
                            this.k.setVisibility(0);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            rx.c(th, "MapOverlayViewGroup", "redrawInfoWindow");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.stln3.dr
    public final void b_() {
        co coVar = this.b;
        if (coVar != null && coVar.getMainHandler() != null) {
            this.b.getMainHandler().post(new Runnable() {
                /* class com.amap.api.col.stln3.io.AnonymousClass2 */

                public final void run() {
                    if (io.this.k != null) {
                        io.this.k.clearFocus();
                        io ioVar = io.this;
                        ioVar.removeView(ioVar.k);
                        ic.a(io.this.k.getBackground());
                        ic.a(io.this.m);
                        io.this.k = null;
                    }
                }
            });
            cg cgVar = this.l;
            if (cgVar != null) {
                cgVar.a(false);
            }
            this.l = null;
        }
    }

    private void a(View view, int i2, int i3, int[] iArr) {
        View view2;
        if ((view instanceof ListView) && (view2 = (View) view.getParent()) != null) {
            iArr[0] = view2.getWidth();
            iArr[1] = view2.getHeight();
        }
        if (i2 <= 0 || i3 <= 0) {
            view.measure(0, 0);
        }
        if (i2 == -2) {
            iArr[0] = view.getMeasuredWidth();
        } else if (i2 == -1) {
            iArr[0] = getMeasuredWidth();
        } else {
            iArr[0] = i2;
        }
        if (i3 == -2) {
            iArr[1] = view.getMeasuredHeight();
        } else if (i3 == -1) {
            iArr[1] = getMeasuredHeight();
        } else {
            iArr[1] = i3;
        }
    }

    private void a(View view, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i6 & 7;
        int i8 = i6 & 112;
        if (i7 == 5) {
            i4 -= i2;
        } else if (i7 == 1) {
            i4 -= i2 / 2;
        }
        if (i8 == 80) {
            i5 -= i3;
        } else if (i8 == 17) {
            i5 -= i3 / 2;
        } else if (i8 == 16) {
            i5 = (i5 / 2) - (i3 / 2);
        }
        view.layout(i4, i5, i4 + i2, i5 + i3);
        if (view instanceof cp) {
            this.b.a(i2, i3);
        }
    }

    public final void k() {
        b_();
        ic.a(this.m);
        ir irVar = this.j;
        if (irVar != null) {
            irVar.a();
        }
        ip ipVar = this.g;
        if (ipVar != null) {
            ipVar.a();
        }
        iq iqVar = this.d;
        if (iqVar != null) {
            iqVar.a();
        }
        in inVar = this.e;
        if (inVar != null) {
            inVar.a();
        }
        il ilVar = this.f;
        if (ilVar != null) {
            ilVar.a();
        }
        im imVar = this.i;
        if (imVar != null) {
            imVar.a();
        }
        removeAllViews();
        this.o = null;
    }

    @Override // com.amap.api.col.stln3.dr
    public final boolean a(MotionEvent motionEvent) {
        View view = this.k;
        if (view == null || this.l == null || !ic.a(new Rect(view.getLeft(), this.k.getTop(), this.k.getRight(), this.k.getBottom()), (int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return true;
    }

    public final void a(Canvas canvas) {
        Bitmap drawingCache;
        View view = this.k;
        if (view != null && this.l != null && (drawingCache = view.getDrawingCache(true)) != null) {
            canvas.drawBitmap(drawingCache, (float) this.k.getLeft(), (float) this.k.getTop(), new Paint());
        }
    }

    public static void l() {
    }
}
