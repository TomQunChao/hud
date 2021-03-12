package com.amap.api.col.stln3;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.os.RemoteException;
import android.view.animation.AnimationUtils;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.amap.mapcore.animation.GLAnimationSet;
import com.autonavi.amap.mapcore.animation.GLTransformation;
import com.autonavi.amap.mapcore.animation.GLTranslateAnimation;
import com.autonavi.amap.mapcore.interfaces.IAnimation;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import com.autonavi.amap.mapcore.interfaces.IOverlayImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MarkerDelegateImp */
public final class gg extends cg implements fx, IAnimation, IMarkerAction {
    private static int g = 0;
    private boolean A = false;
    private boolean B = true;
    private int C = 5;
    private boolean D = true;
    private boolean E = true;
    private boolean F = false;
    private boolean G = false;
    private boolean H = false;
    private boolean I = true;
    private FPoint J = FPoint.obtain();
    private Point K = new Point();
    private float L;
    private float M;
    private int N = 0;
    private int O = 0;
    private cx P;
    private cx[] Q = null;
    private boolean R = false;
    private String S;
    private LatLng T;
    private LatLng U;
    private String V;
    private String W;
    private float X = 0.5f;
    private float Y = 1.0f;
    private boolean Z = false;
    float[] a;
    private boolean aa = true;
    private cu ab;
    private Object ac;
    private boolean ad = false;
    private List<BitmapDescriptor> ae = new CopyOnWriteArrayList();
    private boolean af = false;
    private boolean ag = false;
    private boolean ah = true;
    private int ai = 0;
    private int aj = 20;
    private boolean ak = false;
    private int al;
    private int am;
    private long an = 0;
    private float ao = Float.MAX_VALUE;
    private float ap = Float.MIN_VALUE;
    private float aq = Float.MIN_VALUE;
    private float ar = Float.MAX_VALUE;
    float[] b;
    Rect c = new Rect(0, 0, 0, 0);
    GLAnimation d;
    GLAnimation e;
    Object f = new Object();
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private float k = 0.0f;
    private float l = 0.0f;
    private boolean m = false;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private int q = 0;
    private int r;
    private int s;
    private FPoint t = FPoint.obtain();
    private float[] u = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private float v = 0.0f;
    private float w = 1.0f;
    private float x = 1.0f;
    private float y = 1.0f;
    private MarkerOptions z;

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final void setRotateAngle(float f2) {
        this.z.rotateAngle(f2);
        this.l = f2;
        this.k = (((-f2) % 360.0f) + 360.0f) % 360.0f;
        this.j = true;
        p();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final void destroy(boolean z2) {
        try {
            this.R = true;
            if (z2) {
                remove();
            }
            int i2 = 0;
            if (this.ab != null) {
                int i3 = 0;
                while (this.Q != null && i3 < this.Q.length) {
                    cx cxVar = this.Q[i3];
                    if (cxVar != null) {
                        this.ab.a(cxVar);
                        this.ab.c().c(cxVar.j());
                    }
                    i3++;
                }
            }
            while (this.ae != null && i2 < this.ae.size()) {
                this.ae.get(i2).recycle();
                i2++;
            }
            this.T = null;
            this.ac = null;
            this.Q = null;
        } catch (Throwable th) {
            rx.c(th, "MarkerDelegateImp", "destroy");
            th.printStackTrace();
        }
    }

    private synchronized void m() {
        if (this.ae != null) {
            this.ae.clear();
        }
    }

    private synchronized void a(ArrayList<BitmapDescriptor> arrayList) {
        m();
        if (arrayList != null) {
            Iterator<BitmapDescriptor> it = arrayList.iterator();
            while (it.hasNext()) {
                BitmapDescriptor next = it.next();
                if (next != null) {
                    this.ae.add(next);
                }
            }
        }
        if (this.ae.size() > 0) {
            this.N = this.ae.get(0).getWidth();
            this.O = this.ae.get(0).getHeight();
            return;
        }
        this.ae.add(BitmapDescriptorFactory.defaultMarker());
        this.N = this.ae.get(0).getWidth();
        this.O = this.ae.get(0).getHeight();
    }

    public gg(MarkerOptions markerOptions, cu cuVar) {
        this.ab = cuVar;
        setMarkerOptions(markerOptions);
    }

    private int n() {
        try {
            return this.N;
        } catch (Throwable th) {
            return 0;
        }
    }

    private int o() {
        try {
            return this.O;
        } catch (Throwable th) {
            return 0;
        }
    }

    @Override // com.amap.api.col.stln3.ga, com.amap.api.col.stln3.cs
    public final Rect i() {
        if (this.u == null) {
            this.c.set(0, 0, 0, 0);
            return this.c;
        }
        try {
            GLMapState f2 = this.ab.c().f();
            if (f2 == null) {
                return new Rect(0, 0, 0, 0);
            }
            int n2 = n();
            int o2 = o();
            FPoint obtain = FPoint.obtain();
            if (this.ak) {
                obtain.x = (float) this.al;
                obtain.y = (float) this.am;
            } else {
                f2.p20ToScreenPoint(this.r, this.s, obtain);
            }
            Matrix.setIdentityM(this.a, 0);
            Matrix.rotateM(this.a, 0, -this.k, 0.0f, 0.0f, 1.0f);
            if (this.m) {
                Matrix.rotateM(this.a, 0, this.ab.c().getMapConfig().getSC(), 1.0f, 0.0f, 0.0f);
                Matrix.rotateM(this.a, 0, this.ab.c().getMapConfig().getSR(), 0.0f, 0.0f, 1.0f);
            }
            float[] fArr = new float[4];
            float f3 = (float) (-n2);
            this.b[0] = this.X * f3;
            float f4 = (float) o2;
            this.b[1] = this.Y * f4;
            this.b[2] = 0.0f;
            this.b[3] = 1.0f;
            Matrix.multiplyMV(fArr, 0, this.a, 0, this.b, 0);
            this.c.set((int) (obtain.x + fArr[0]), (int) (obtain.y - fArr[1]), (int) (obtain.x + fArr[0]), (int) (obtain.y - fArr[1]));
            float f5 = (float) n2;
            this.b[0] = (1.0f - this.X) * f5;
            this.b[1] = f4 * this.Y;
            this.b[2] = 0.0f;
            this.b[3] = 1.0f;
            Matrix.multiplyMV(fArr, 0, this.a, 0, this.b, 0);
            this.c.union((int) (obtain.x + fArr[0]), (int) (obtain.y - fArr[1]));
            this.b[0] = f5 * (1.0f - this.X);
            float f6 = (float) (-o2);
            this.b[1] = (1.0f - this.Y) * f6;
            this.b[2] = 0.0f;
            this.b[3] = 1.0f;
            Matrix.multiplyMV(fArr, 0, this.a, 0, this.b, 0);
            this.c.union((int) (obtain.x + fArr[0]), (int) (obtain.y - fArr[1]));
            this.b[0] = f3 * this.X;
            this.b[1] = f6 * (1.0f - this.Y);
            this.b[2] = 0.0f;
            this.b[3] = 1.0f;
            Matrix.multiplyMV(fArr, 0, this.a, 0, this.b, 0);
            this.c.union((int) (obtain.x + fArr[0]), (int) (obtain.y - fArr[1]));
            this.p = (int) (((float) this.c.centerX()) - obtain.x);
            this.q = (int) (((float) this.c.top) - obtain.y);
            obtain.recycle();
            return this.c;
        } catch (Throwable th) {
            rx.c(th, "MarkerDelegateImp", "getRect");
            th.printStackTrace();
            return new Rect(0, 0, 0, 0);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final boolean remove() {
        p();
        this.aa = false;
        cu cuVar = this.ab;
        if (cuVar != null) {
            return cuVar.a((ga) this);
        }
        return false;
    }

    private void p() {
        if (this.ab.c() != null) {
            this.ab.c().setRunLowFrame(false);
        }
    }

    @Override // com.amap.api.col.stln3.cg, com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final LatLng getPosition() {
        if (!this.ak || this.t == null) {
            return this.T;
        }
        DPoint obtain = DPoint.obtain();
        IPoint obtain2 = IPoint.obtain();
        q();
        this.ab.c().a(this.t.x, this.t.y, obtain2);
        GLMapState.geo2LonLat(obtain2.x, obtain2.y, obtain);
        LatLng latLng = new LatLng(obtain.y, obtain.x);
        obtain2.recycle();
        obtain.recycle();
        return latLng;
    }

    @Override // com.amap.api.col.stln3.cg, com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final String getId() {
        if (this.S == null) {
            g++;
            this.S = "Marker" + g;
        }
        return this.S;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final void setPosition(LatLng latLng) {
        if (latLng == null) {
            rx.c(new AMapException("非法坐标值 latlng is null"), "setPosition", "Marker");
            return;
        }
        this.T = latLng;
        IPoint obtain = IPoint.obtain();
        if (this.af) {
            try {
                double[] a2 = wd.a(latLng.longitude, latLng.latitude);
                this.U = new LatLng(a2[1], a2[0]);
                GLMapState.lonlat2Geo(a2[0], a2[1], obtain);
            } catch (Throwable th) {
                this.U = latLng;
            }
        } else {
            GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
        }
        this.r = obtain.x;
        this.s = obtain.y;
        this.ak = false;
        q();
        p();
        this.j = true;
        obtain.recycle();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction, com.autonavi.amap.mapcore.interfaces.IMarker
    public final void setTitle(String str) {
        this.V = str;
        p();
        this.z.title(str);
        hn.a().a(this.T, this.V, this.W);
    }

    @Override // com.amap.api.col.stln3.cg, com.autonavi.amap.mapcore.interfaces.IMarker
    public final String getTitle() {
        return this.V;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction, com.autonavi.amap.mapcore.interfaces.IMarker
    public final void setSnippet(String str) {
        this.W = str;
        p();
        this.z.snippet(str);
    }

    @Override // com.amap.api.col.stln3.cg, com.autonavi.amap.mapcore.interfaces.IMarker
    public final String getSnippet() {
        return this.W;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public final void setDraggable(boolean z2) {
        this.Z = z2;
        this.z.draggable(z2);
        p();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public final synchronized void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        if (arrayList != null) {
            try {
                if (this.ae != null) {
                    a(arrayList);
                    this.ag = false;
                    this.h = false;
                    this.F = false;
                    p();
                    this.j = true;
                }
            } catch (Throwable th) {
                rx.c(th, "MarkerDelegateImp", "setIcons");
                th.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public final synchronized ArrayList<BitmapDescriptor> getIcons() {
        if (this.ae == null || this.ae.size() <= 0) {
            return null;
        }
        ArrayList<BitmapDescriptor> arrayList = new ArrayList<>();
        for (BitmapDescriptor bitmapDescriptor : this.ae) {
            arrayList.add(bitmapDescriptor);
        }
        return arrayList;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public final void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            try {
                if (this.ae != null) {
                    synchronized (this) {
                        this.ae.clear();
                        this.ae.add(bitmapDescriptor);
                        this.F = false;
                        this.ag = false;
                        this.h = false;
                        p();
                        this.j = true;
                        this.N = bitmapDescriptor.getWidth();
                        this.O = bitmapDescriptor.getHeight();
                    }
                }
            } catch (Throwable th) {
                rx.c(th, "MarkerDelegateImp", "setIcon");
                th.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.col.stln3.cg, com.autonavi.amap.mapcore.interfaces.IMarker
    public final boolean isDraggable() {
        return this.Z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public final boolean isRemoved() {
        try {
            return !this.ab.c(this);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public final void showInfoWindow() {
        if (this.aa && isInfoWindowEnable()) {
            this.ab.a((cg) this);
            p();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public final void hideInfoWindow() {
        if (isInfoWindowShown()) {
            this.ab.b(this);
            p();
            this.i = false;
        }
        this.j = false;
    }

    @Override // com.amap.api.col.stln3.cs
    public final void a(boolean z2) {
        this.i = z2;
        this.j = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker, com.amap.api.col.stln3.ga
    public final boolean isInfoWindowShown() {
        return this.i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final void setVisible(boolean z2) {
        if (this.aa != z2) {
            this.z.visible(z2);
            this.aa = z2;
            if (!z2) {
                this.H = false;
                if (isInfoWindowShown()) {
                    this.ab.b(this);
                }
            }
            p();
        }
    }

    @Override // com.amap.api.col.stln3.cg, com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final boolean isVisible() {
        return this.aa;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final void setAnchor(float f2, float f3) {
        if (this.X != f2 || this.Y != f3) {
            this.z.anchor(f2, f3);
            this.X = f2;
            this.Y = f3;
            this.j = true;
            p();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final float getAnchorU() {
        return this.X;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final float getAnchorV() {
        return this.Y;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final boolean equalsRemote(IOverlayImage iOverlayImage) throws RemoteException {
        if (equals(iOverlayImage) || iOverlayImage.getId().equals(getId())) {
            return true;
        }
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final int hashCodeRemote() {
        return super.hashCode();
    }

    private boolean q() {
        try {
            if (!(this.ab == null || this.ab.c() == null)) {
                if (this.ab.c().f() != null) {
                    if (this.t == null) {
                        this.t = FPoint.obtain();
                    }
                    if (this.ak) {
                        IPoint obtain = IPoint.obtain();
                        this.ab.c().a(this.al, this.am, obtain);
                        this.r = obtain.x;
                        this.s = obtain.y;
                        obtain.recycle();
                    }
                    this.ab.c().a(this.r, this.s, this.t);
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.amap.api.col.stln3.ga
    public final void a(co coVar, float[] fArr, int i2, float f2) {
        if (!(this.R || (this.T == null && !this.ak) || this.ae == null)) {
            try {
                if (!this.h) {
                    this.an = System.currentTimeMillis();
                    this.h = true;
                }
                if (this.ak && this.E) {
                    IPoint obtain = IPoint.obtain();
                    coVar.a(this.al, this.am, obtain);
                    this.r = obtain.x;
                    this.s = obtain.y;
                    obtain.recycle();
                }
                this.t.x = (float) (this.r - coVar.getMapConfig().getSX());
                if (this.t.x > 1.34217728E8f) {
                    this.t.x -= 2.68435456E8f;
                } else if (this.t.x < -1.34217728E8f) {
                    this.t.x += 2.68435456E8f;
                }
                this.t.y = (float) (this.s - coVar.getMapConfig().getSY());
                int n2 = n();
                int o2 = o();
                if (this.I || this.d == null || this.d.hasEnded()) {
                    this.w = 1.0f;
                    this.x = 1.0f;
                    this.I = true;
                    if (this.ae != null && this.ae.size() == 1) {
                        this.ah = true;
                    }
                } else {
                    p();
                    synchronized (this.f) {
                        GLTransformation gLTransformation = new GLTransformation();
                        this.d.getTransformation(AnimationUtils.currentAnimationTimeMillis(), gLTransformation);
                        if (!Double.isNaN(gLTransformation.scaleX) && !Double.isNaN(gLTransformation.scaleY)) {
                            this.w = (float) gLTransformation.scaleX;
                            this.x = (float) gLTransformation.scaleY;
                        }
                        if (!Double.isNaN(gLTransformation.rotate)) {
                            setRotateAngle((float) gLTransformation.rotate);
                        }
                        if (!Double.isNaN(gLTransformation.x) && !Double.isNaN(gLTransformation.y)) {
                            double d2 = gLTransformation.x;
                            double d3 = gLTransformation.y;
                            if (this.ak) {
                                IPoint obtain2 = IPoint.obtain();
                                this.ab.c().a((int) d2, (int) d3, obtain2);
                                a(obtain2.x, obtain2.y);
                                obtain2.recycle();
                                this.ak = true;
                            } else {
                                a((int) d2, (int) d3);
                            }
                        }
                        if (!Double.isNaN(gLTransformation.alpha)) {
                            this.y = (float) gLTransformation.alpha;
                        }
                    }
                    this.j = true;
                    this.ah = false;
                }
                float f3 = ((float) ((int) (this.w * ((float) n2)))) * f2;
                float f4 = ((float) ((int) (this.x * ((float) o2)))) * f2;
                float f5 = this.t.x;
                float f6 = this.t.y;
                float sc = coVar.getMapConfig().getSC();
                float f7 = this.k;
                float f8 = 0.0f;
                if (this.m) {
                    f7 -= coVar.getMapConfig().getSR();
                    sc = 0.0f;
                }
                float f9 = this.y;
                if (f9 >= 0.0f) {
                    f8 = f9;
                }
                if (f8 > 1.0f) {
                    f8 = 1.0f;
                }
                this.u[0] = f5 - (this.X * f3);
                this.u[1] = ((1.0f - this.Y) * f4) + f6;
                this.u[2] = f5;
                this.u[3] = f6;
                this.u[6] = f7;
                this.u[7] = sc;
                this.u[8] = f8;
                this.u[9] = ((1.0f - this.X) * f3) + f5;
                this.u[10] = ((1.0f - this.Y) * f4) + f6;
                this.u[11] = f5;
                this.u[12] = f6;
                this.u[15] = f7;
                this.u[16] = sc;
                this.u[17] = f8;
                this.u[18] = ((1.0f - this.X) * f3) + f5;
                this.u[19] = f6 - (this.Y * f4);
                this.u[20] = f5;
                this.u[21] = f6;
                this.u[24] = f7;
                this.u[25] = sc;
                this.u[26] = f8;
                this.u[27] = f5 - (f3 * this.X);
                this.u[28] = f6 - (f4 * this.Y);
                this.u[29] = f5;
                this.u[30] = f6;
                this.u[33] = f7;
                this.u[34] = sc;
                this.u[35] = f8;
                if (this.ae != null && this.ae.size() > 0) {
                    this.ai++;
                    if (this.ai >= this.aj * this.ae.size()) {
                        this.ai = 0;
                    }
                    if (this.aj == 0) {
                        this.aj = 1;
                    }
                    this.P = this.Q[this.ai / this.aj];
                    if (!this.ah) {
                        p();
                    }
                }
                if (!this.F || !this.ah) {
                    try {
                        this.u[4] = this.P.b();
                        this.u[5] = this.P.d();
                        this.u[13] = this.P.c();
                        this.u[14] = this.P.d();
                        this.u[22] = this.P.c();
                        this.u[23] = this.P.a();
                        this.u[31] = this.P.b();
                        this.u[32] = this.P.a();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    this.F = true;
                }
                if (this.Q != null && this.Q.length > 0) {
                    System.arraycopy(this.u, 0, fArr, i2, this.u.length);
                }
                if (this.j && isInfoWindowShown()) {
                    this.ab.c().m();
                    if (System.currentTimeMillis() - this.an > 1000) {
                        this.j = false;
                    }
                }
            } catch (Throwable th2) {
                rx.c(th2, "MarkerDelegateImp", "drawMarker");
            }
        }
    }

    @Override // com.amap.api.col.stln3.ga
    public final void a(co coVar) {
        int i2;
        cx cxVar;
        if (!this.ag) {
            synchronized (this) {
                try {
                    if (this.Q != null) {
                        cx[] cxVarArr = this.Q;
                        for (cx cxVar2 : cxVarArr) {
                            if (cxVar2 != null) {
                                this.ab.a(cxVar2);
                            }
                        }
                    }
                    this.Q = null;
                    if (this.ae != null) {
                        this.Q = new cx[this.ae.size()];
                        boolean z2 = Build.VERSION.SDK_INT >= 12;
                        int i3 = 0;
                        for (BitmapDescriptor bitmapDescriptor : this.ae) {
                            if (z2) {
                                cxVar = coVar.a(bitmapDescriptor);
                                if (cxVar != null) {
                                    i2 = cxVar.f();
                                } else {
                                    i2 = 0;
                                }
                            } else {
                                cxVar = null;
                                i2 = 0;
                            }
                            if (cxVar == null) {
                                cxVar = new cx(bitmapDescriptor, i2);
                            }
                            if (i2 == 0) {
                                Bitmap bitmap = bitmapDescriptor.getBitmap();
                                if (bitmap != null && !bitmap.isRecycled()) {
                                    this.N = bitmap.getWidth();
                                    this.O = bitmap.getHeight();
                                    int h2 = this.ab.c().h();
                                    if (h2 == 0) {
                                        int r2 = r();
                                        cxVar.a(r2);
                                        if (z2) {
                                            coVar.a(cxVar);
                                        }
                                        ic.a(r2, bitmap, false);
                                    } else {
                                        if (this.ab.a(bitmap, cxVar)) {
                                            ic.a(h2, bitmap, (int) (cxVar.b() * 512.0f), (int) (cxVar.a() * 1024.0f));
                                            cxVar.a(h2);
                                        } else {
                                            int r3 = r();
                                            ic.a(r3, bitmap, false);
                                            cxVar.a(r3);
                                        }
                                        if (z2) {
                                            coVar.a(cxVar);
                                        }
                                    }
                                }
                            }
                            cxVar.g();
                            this.Q[i3] = cxVar;
                            i3++;
                        }
                        if (this.ae.size() == 1) {
                            this.ah = true;
                        } else {
                            this.ah = false;
                        }
                        this.F = false;
                        this.ag = true;
                    }
                    q();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static int r() {
        int[] iArr = {0};
        GLES20.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    @Override // com.amap.api.col.stln3.ga
    public final boolean j() {
        return this.ah;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public final void setPeriod(int i2) {
        if (i2 <= 1) {
            this.aj = 1;
        } else {
            this.aj = i2;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final void setObject(Object obj) {
        this.ac = obj;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final Object getObject() {
        return this.ac;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public final void setPerspective(boolean z2) {
        this.ad = z2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public final boolean isPerspective() {
        return this.ad;
    }

    @Override // com.amap.api.col.stln3.ga
    public final int k() {
        try {
            if (this.ae != null) {
                if (this.ae.size() > 0) {
                    return this.P.f();
                }
            }
            return 0;
        } catch (Throwable th) {
            return 0;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public final int getPeriod() {
        return this.aj;
    }

    @Override // com.amap.api.col.stln3.cs
    public final LatLng b() {
        try {
            if (!this.ak) {
                return this.af ? this.U : this.T;
            }
            DPoint obtain = DPoint.obtain();
            this.ab.c().b(this.al, this.am, obtain);
            LatLng latLng = new LatLng(obtain.y, obtain.y);
            obtain.recycle();
            return latLng;
        } catch (Throwable th) {
            rx.c(th, "MarkerDelegateImp", "getRealPosition");
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public final void set2Top() {
        this.ab.a((fx) this);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public final void setFlat(boolean z2) throws RemoteException {
        this.m = z2;
        p();
        this.z.setFlat(z2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public final boolean isFlat() {
        return this.m;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final float getRotateAngle() {
        p();
        return this.l;
    }

    @Override // com.amap.api.col.stln3.cs
    public final int c() {
        return this.n;
    }

    @Override // com.amap.api.col.stln3.cs
    public final int d() {
        return this.o;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public final void setPositionByPixels(int i2, int i3) {
        this.al = i2;
        this.am = i3;
        this.ak = true;
        q();
        p();
        this.j = true;
    }

    @Override // com.amap.api.col.stln3.cs
    public final int e() {
        return this.p;
    }

    @Override // com.amap.api.col.stln3.cs
    public final int f() {
        return this.q;
    }

    @Override // com.amap.api.col.stln3.cs
    public final FPoint a() {
        return this.t;
    }

    @Override // com.amap.api.col.stln3.cs
    public final boolean g() {
        return this.ak;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final void setZIndex(float f2) {
        this.v = f2;
        this.z.zIndex(f2);
        if (this.H) {
            this.H = false;
            this.ab.a();
        }
        this.ab.f();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final float getZIndex() {
        return this.v;
    }

    @Override // com.amap.api.col.stln3.ga, com.amap.api.col.stln3.cs
    public final boolean h() {
        float f2;
        FPoint fPoint;
        float f3;
        FPoint fPoint2;
        if (this.ak) {
            return true;
        }
        if (this.t != null) {
            if (!this.I) {
                return true;
            }
            Point point = this.K;
            point.x = this.r;
            point.y = this.s;
            if (this.ab.c().getMapConfig().getGeoRectangle().contains(this.r, this.s)) {
                return true;
            }
            s();
            this.J.x = this.t.x;
            this.J.y = this.t.y;
            FPoint[] mapRect = this.ab.c().getMapConfig().getMapRect();
            if (mapRect != null) {
                s();
                if (this.L > 0.0f && this.M > 0.0f && mapRect.length == 4) {
                    this.ao = Math.min(mapRect[0].x, mapRect[1].x);
                    this.ao = Math.min(this.ao, mapRect[2].x);
                    this.ao = Math.min(this.ao, mapRect[3].x);
                    this.ap = Math.max(mapRect[0].x, mapRect[1].x);
                    this.ap = Math.max(this.ap, mapRect[2].x);
                    this.ap = Math.max(this.ap, mapRect[3].x);
                    this.ar = Math.min(mapRect[0].y, mapRect[1].y);
                    this.ar = Math.min(this.ar, mapRect[2].y);
                    this.ar = Math.min(this.ar, mapRect[3].y);
                    this.aq = Math.max(mapRect[0].y, mapRect[1].y);
                    this.aq = Math.max(this.aq, mapRect[2].y);
                    this.aq = Math.max(this.aq, mapRect[3].y);
                    if (this.t.x < (this.ao + this.ap) / 2.0f) {
                        fPoint = this.J;
                        f2 = this.t.x + (this.L / 2.0f);
                    } else {
                        fPoint = this.J;
                        f2 = this.t.x - (this.L / 2.0f);
                    }
                    fPoint.x = f2;
                    if (this.t.y < (this.ar + this.aq) / 2.0f) {
                        fPoint2 = this.J;
                        f3 = this.t.y;
                    } else {
                        fPoint2 = this.J;
                        f3 = this.t.y - this.M;
                    }
                    fPoint2.y = f3;
                }
            }
            if (ic.a(this.J, mapRect)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public final void setGeoPoint(IPoint iPoint) {
        this.ak = false;
        a(iPoint.x, iPoint.y);
    }

    private void a(int i2, int i3) {
        this.r = i2;
        this.s = i3;
        DPoint obtain = DPoint.obtain();
        GLMapState.geo2LonLat(this.r, this.s, obtain);
        this.T = new LatLng(obtain.y, obtain.x, false);
        cu cuVar = this.ab;
        if (!(cuVar == null || cuVar.c() == null)) {
            this.t.x = (float) (this.r - this.ab.c().getMapConfig().getSX());
            this.t.y = (float) (this.s - this.ab.c().getMapConfig().getSY());
        }
        obtain.recycle();
        p();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public final IPoint getGeoPoint() {
        IPoint obtain = IPoint.obtain();
        if (this.ak) {
            this.ab.c().a(this.al, this.am, obtain);
            return obtain;
        }
        obtain.set(this.r, this.s);
        return obtain;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public final void setAnimation(Animation animation) {
        setAnimation(animation == null ? null : animation.glAnimation);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAnimation
    public final void setAnimation(GLAnimation gLAnimation) {
        if (gLAnimation != null) {
            this.e = gLAnimation;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker, com.autonavi.amap.mapcore.interfaces.IAnimation
    public final boolean startAnimation() {
        if (this.e != null) {
            synchronized (this.f) {
                if (this.e instanceof GLAnimationSet) {
                    GLAnimationSet gLAnimationSet = (GLAnimationSet) this.e;
                    for (GLAnimation gLAnimation : gLAnimationSet.getAnimations()) {
                        a(gLAnimation);
                        gLAnimation.setDuration(gLAnimationSet.getDuration());
                    }
                } else {
                    a(this.e);
                }
                this.I = false;
                this.d = this.e;
                this.d.start();
            }
            p();
        }
        return false;
    }

    private void a(GLAnimation gLAnimation) {
        if (gLAnimation instanceof GLTranslateAnimation) {
            if (this.ak) {
                this.T = getPosition();
                setPosition(this.T);
                this.ak = true;
            }
            if (this.ak) {
                GLTranslateAnimation gLTranslateAnimation = (GLTranslateAnimation) gLAnimation;
                gLTranslateAnimation.mFromXDelta = (double) this.al;
                gLTranslateAnimation.mFromYDelta = (double) this.am;
                IPoint obtain = IPoint.obtain();
                this.ab.c().b(gLTranslateAnimation.mToYDelta, gLTranslateAnimation.mToXDelta, obtain);
                gLTranslateAnimation.mToXDelta = (double) obtain.x;
                gLTranslateAnimation.mToYDelta = (double) obtain.y;
                obtain.recycle();
                return;
            }
            GLTranslateAnimation gLTranslateAnimation2 = (GLTranslateAnimation) gLAnimation;
            gLTranslateAnimation2.mFromXDelta = (double) this.r;
            gLTranslateAnimation2.mFromYDelta = (double) this.s;
            IPoint obtain2 = IPoint.obtain();
            GLMapState.lonlat2Geo(gLTranslateAnimation2.mToXDelta, gLTranslateAnimation2.mToYDelta, obtain2);
            gLTranslateAnimation2.mToXDelta = (double) obtain2.x;
            gLTranslateAnimation2.mToYDelta = (double) obtain2.y;
            obtain2.recycle();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker, com.autonavi.amap.mapcore.interfaces.IAnimation
    public final void setAnimationListener(Animation.AnimationListener animationListener) {
        GLAnimation gLAnimation = this.e;
        if (gLAnimation != null) {
            gLAnimation.setAnimationListener(animationListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public final IMarkerAction getIMarkerAction() {
        return this;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public final float getAlpha() {
        return this.y;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public final void setAlpha(float f2) {
        this.y = f2;
        this.z.alpha(f2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public final int getDisplayLevel() {
        return this.C;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public final MarkerOptions getOptions() {
        return this.z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public final void setMarkerOptions(MarkerOptions markerOptions) {
        if (markerOptions != null) {
            this.z = markerOptions;
            this.T = this.z.getPosition();
            IPoint obtain = IPoint.obtain();
            this.af = this.z.isGps();
            if (this.z.getPosition() != null) {
                if (this.af) {
                    try {
                        double[] a2 = wd.a(this.z.getPosition().longitude, this.z.getPosition().latitude);
                        this.U = new LatLng(a2[1], a2[0]);
                        GLMapState.lonlat2Geo(a2[0], a2[1], obtain);
                    } catch (Throwable th) {
                        rx.c(th, "MarkerDelegateImp", "create");
                        this.U = this.z.getPosition();
                    }
                } else {
                    GLMapState.lonlat2Geo(this.T.longitude, this.T.latitude, obtain);
                }
            }
            this.r = obtain.x;
            this.s = obtain.y;
            this.X = this.z.getAnchorU();
            this.Y = this.z.getAnchorV();
            this.n = this.z.getInfoWindowOffsetX();
            this.o = this.z.getInfoWindowOffsetY();
            this.aj = this.z.getPeriod();
            this.v = this.z.getZIndex();
            this.G = this.z.isBelowMaskLayer();
            q();
            a(this.z.getIcons());
            this.aa = this.z.isVisible();
            this.W = this.z.getSnippet();
            this.V = this.z.getTitle();
            this.Z = this.z.isDraggable();
            this.S = getId();
            this.ad = this.z.isPerspective();
            this.m = this.z.isFlat();
            this.G = this.z.isBelowMaskLayer();
            this.y = this.z.getAlpha();
            setRotateAngle(this.z.getRotateAngle());
            this.C = this.z.getDisplayLevel();
            this.A = this.z.isInfoWindowAutoOverturn();
            this.B = this.z.isInfoWindowEnable();
            this.a = new float[16];
            this.b = new float[4];
            obtain.recycle();
            hn.a().a(this.T, this.V, this.W);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public final boolean isClickable() {
        return this.D;
    }

    @Override // com.amap.api.col.stln3.cg, com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public final boolean isInfoWindowAutoOverturn() {
        return this.A;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction, com.amap.api.col.stln3.cs
    public final boolean isInfoWindowEnable() {
        return this.B;
    }

    @Override // com.amap.api.col.stln3.ga
    public final void b(boolean z2) {
        this.H = z2;
    }

    @Override // com.amap.api.col.stln3.ga
    public final boolean l() {
        return this.H;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public final void setInfoWindowEnable(boolean z2) {
        this.B = z2;
        if (!z2) {
            hideInfoWindow();
        }
        this.z.infoWindowEnable(z2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public final void setAutoOverturnInfoWindow(boolean z2) {
        this.A = z2;
        this.z.autoOverturnInfoWindow(z2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public final void setClickable(boolean z2) {
        this.D = z2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public final void setDisplayLevel(int i2) {
        this.C = i2;
        this.z.displayLevel(i2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public final void setFixingPointEnable(boolean z2) {
        this.E = z2;
        if (!z2) {
            boolean z3 = false;
            if (this.ak) {
                z3 = true;
            }
            this.T = getPosition();
            setPosition(this.T);
            if (z3) {
                this.ak = true;
            }
        } else if (this.ak && this.T != null) {
            FPoint obtain = FPoint.obtain();
            this.ab.c().f().p20ToScreenPoint(this.r, this.s, obtain);
            this.al = (int) obtain.x;
            this.am = (int) obtain.y;
            obtain.recycle();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public final void setPositionNotUpdate(LatLng latLng) {
        setPosition(latLng);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public final void setRotateAngleNotUpdate(float f2) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public final void setBelowMaskLayer(boolean z2) {
        this.G = z2;
    }

    private void s() {
        if (this.ab.c() != null && this.ab.c().getMapConfig() != null) {
            this.L = this.ab.c().getMapConfig().getMapPerPixelUnitLength() * ((float) n());
            this.M = this.ab.c().getMapConfig().getMapPerPixelUnitLength() * ((float) o());
        }
    }
}
