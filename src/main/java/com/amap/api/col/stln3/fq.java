package com.amap.api.col.stln3;

import android.opengl.GLES20;
import android.os.RemoteException;
import android.support.v4.view.ViewCompat;
import com.amap.api.col.stln3.gq;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.CircleHoleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.PolygonHoleOptions;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: CircleDelegateImp */
public final class fq implements fv {
    private static int A = 20;
    private static double B = 1.0E10d;
    private static Object v = new Object();
    private static float y = 4.0075016E7f;
    private static int z = 256;
    float a = 0.0f;
    private LatLng b = null;
    private double c = 0.0d;
    private float d = 10.0f;
    private int e = ViewCompat.MEASURED_STATE_MASK;
    private int f = 0;
    private float g = 0.0f;
    private boolean h = true;
    private String i;
    private co j;
    private FloatBuffer k;
    private int l = 0;
    private boolean m = false;
    private IPoint n = IPoint.obtain();
    private FPoint o = FPoint.obtain();
    private List<BaseHoleOptions> p;
    private List<BaseHoleOptions> q;
    private int r;
    private int s;
    private FloatBuffer t;
    private FloatBuffer u;
    private int w = -1;
    private gq.e x;

    public fq(co coVar) {
        this.j = coVar;
        try {
            this.i = getId();
        } catch (RemoteException e2) {
            rx.c(e2, "CircleDelegateImp", "create");
            e2.printStackTrace();
        }
    }

    @Override // com.amap.api.col.stln3.fz
    public final boolean a() {
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void remove() throws RemoteException {
        this.j.a(getId());
        this.j.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final String getId() throws RemoteException {
        if (this.i == null) {
            this.i = this.j.d("Circle");
        }
        return this.i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void setZIndex(float f2) throws RemoteException {
        this.g = f2;
        this.j.i();
        this.j.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final float getZIndex() throws RemoteException {
        return this.g;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void setVisible(boolean z2) throws RemoteException {
        this.h = z2;
        this.j.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final boolean isVisible() throws RemoteException {
        return this.h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        if (equals(iOverlay) || iOverlay.getId().equals(getId())) {
            return true;
        }
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final int hashCodeRemote() throws RemoteException {
        return 0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public final int getDottedLineType() {
        return this.w;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public final void setDottedLineType(int i2) {
        this.w = i2;
    }

    private boolean c() throws RemoteException {
        synchronized (v) {
            int i2 = 0;
            this.m = false;
            if (this.b != null) {
                float[] fArr = new float[1086];
                double a2 = a(this.b.latitude) * this.c;
                this.j.f();
                this.o.x = (float) (this.n.x - this.j.getMapConfig().getSX());
                this.o.y = (float) (this.n.y - this.j.getMapConfig().getSY());
                fArr[0] = this.o.x;
                fArr[1] = this.o.y;
                fArr[2] = 0.0f;
                while (i2 < 361) {
                    double d2 = (((double) i2) * 3.141592653589793d) / 180.0d;
                    double d3 = (double) this.n.x;
                    int cos = (int) (((double) this.n.y) + (Math.cos(d2) * a2));
                    this.o.x = (float) (((int) (d3 + (Math.sin(d2) * a2))) - this.j.getMapConfig().getSX());
                    this.o.y = (float) (cos - this.j.getMapConfig().getSY());
                    i2++;
                    int i3 = i2 * 3;
                    fArr[i3] = this.o.x;
                    fArr[i3 + 1] = this.o.y;
                    fArr[i3 + 2] = 0.0f;
                }
                this.l = fArr.length / 3;
                this.k = ic.a(fArr);
            }
        }
        return true;
    }

    private void d() {
        co coVar = this.j;
        if (coVar != null) {
            this.x = (gq.e) coVar.k(3);
        }
    }

    @Override // com.amap.api.col.stln3.fz
    public final void a(MapConfig mapConfig) throws RemoteException {
        if (this.b != null && this.c > 0.0d && this.h) {
            c();
            MapConfig mapConfig2 = this.j.getMapConfig();
            List<BaseHoleOptions> list = this.p;
            if (list != null && list.size() > 0) {
                GLES20.glClearStencil(0);
                GLES20.glStencilMask(255);
                GLES20.glClear(1024);
                GLES20.glFlush();
                GLES20.glEnable(2960);
                GLES20.glColorMask(false, false, false, false);
                GLES20.glStencilFunc(512, 1, 255);
                GLES20.glStencilOp(7681, 7680, 7680);
                for (int i2 = 0; i2 < this.p.size(); i2++) {
                    BaseHoleOptions baseHoleOptions = this.p.get(i2);
                    boolean z2 = baseHoleOptions instanceof PolygonHoleOptions;
                    if (z2) {
                        a(a(((PolygonHoleOptions) baseHoleOptions).getPoints()), mapConfig2.getSX(), mapConfig2.getSY());
                    } else if (baseHoleOptions instanceof CircleHoleOptions) {
                        this.j.i();
                        b((CircleHoleOptions) baseHoleOptions);
                    }
                    if (this.t != null && this.r > 0) {
                        gq.e eVar = this.x;
                        if (eVar == null || eVar.b()) {
                            d();
                        }
                        if (z2) {
                            hl.a(this.x, -1, this.f, this.t, getStrokeWidth(), this.u, this.r, this.s, this.j.A());
                        } else if (baseHoleOptions instanceof CircleHoleOptions) {
                            hl.a(this.x, -1, -1, this.t, 10.0f, this.r, this.j.A(), 0.0f, 0);
                        }
                    }
                }
                GLES20.glColorMask(true, true, true, true);
                GLES20.glStencilFunc(517, 1, 255);
                GLES20.glStencilMask(0);
            }
            if (this.k != null && this.l > 0) {
                gq.e eVar2 = this.x;
                if (eVar2 == null || eVar2.b()) {
                    d();
                }
                this.a = this.j.getMapConfig().getMapPerPixelUnitLength();
                hl.a(this.x, this.f, this.e, this.k, this.d, this.l, this.j.A(), this.a, this.j.c(this.w));
            }
            GLES20.glClearStencil(0);
            GLES20.glClear(1024);
            GLES20.glDisable(2960);
            MapConfig mapConfig3 = this.j.getMapConfig();
            List<BaseHoleOptions> list2 = this.p;
            if (list2 != null && list2.size() > 0) {
                for (int i3 = 0; i3 < this.p.size(); i3++) {
                    BaseHoleOptions baseHoleOptions2 = this.p.get(i3);
                    boolean z3 = baseHoleOptions2 instanceof PolygonHoleOptions;
                    if (z3) {
                        a(a(((PolygonHoleOptions) baseHoleOptions2).getPoints()), mapConfig3.getSX(), mapConfig3.getSY());
                    } else if (baseHoleOptions2 instanceof CircleHoleOptions) {
                        this.j.i();
                        b((CircleHoleOptions) baseHoleOptions2);
                    }
                    if (this.t != null && this.r > 0) {
                        gq.e eVar3 = this.x;
                        if (eVar3 == null || eVar3.b()) {
                            d();
                        }
                        if (z3) {
                            gq.e eVar4 = this.x;
                            int i4 = this.e;
                            FloatBuffer floatBuffer = this.t;
                            float f2 = this.d;
                            FloatBuffer floatBuffer2 = this.u;
                            int i5 = this.r;
                            int i6 = this.s;
                            hl.a(eVar4, i4, floatBuffer, f2, i5, this.j.A());
                        } else if (baseHoleOptions2 instanceof CircleHoleOptions) {
                            hl.a(this.x, this.e, this.t, this.d, this.r, this.j.A(), this.a, -1);
                        }
                    }
                }
            }
            this.m = true;
        }
    }

    private void e() {
        this.l = 0;
        FloatBuffer floatBuffer = this.k;
        if (floatBuffer != null) {
            floatBuffer.clear();
        }
        this.j.setRunLowFrame(false);
        setHoleOptions(this.q);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public final void setCenter(LatLng latLng) throws RemoteException {
        synchronized (v) {
            if (latLng != null) {
                this.b = latLng;
                GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, this.n);
                e();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public final LatLng getCenter() throws RemoteException {
        return this.b;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public final void setRadius(double d2) throws RemoteException {
        this.c = d2;
        e();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public final double getRadius() throws RemoteException {
        return this.c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public final void setStrokeWidth(float f2) throws RemoteException {
        this.d = f2;
        this.j.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public final float getStrokeWidth() throws RemoteException {
        return this.d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public final void setStrokeColor(int i2) throws RemoteException {
        this.e = i2;
        this.j.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public final int getStrokeColor() throws RemoteException {
        return this.e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public final void setFillColor(int i2) throws RemoteException {
        this.f = i2;
        this.j.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public final int getFillColor() throws RemoteException {
        return this.f;
    }

    private static double a(double d2) {
        return 1.0d / ((double) ((float) ((Math.cos((d2 * 3.141592653589793d) / 180.0d) * ((double) y)) / ((double) (z << A)))));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void destroy() {
        try {
            this.b = null;
            if (this.k != null) {
                this.k.clear();
                this.k = null;
            }
            if (this.t != null) {
                this.t.clear();
                this.t = null;
            }
            if (this.u != null) {
                this.u.clear();
                this.u = null;
            }
            if (this.p != null) {
                this.p.clear();
            }
            if (this.q != null) {
                this.q.clear();
            }
            this.p = null;
            this.q = null;
        } catch (Throwable th) {
            rx.c(th, "CircleDelegateImp", "destroy");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public final boolean contains(LatLng latLng) throws RemoteException {
        List<BaseHoleOptions> list = this.p;
        if (list != null && list.size() > 0) {
            for (BaseHoleOptions baseHoleOptions : this.p) {
                if (ic.a(baseHoleOptions, latLng)) {
                    return false;
                }
            }
        }
        if (this.c >= ((double) AMapUtils.calculateLineDistance(this.b, latLng))) {
            return true;
        }
        return false;
    }

    @Override // com.amap.api.col.stln3.fz
    public final boolean b() {
        return this.m;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final boolean isAboveMaskLayer() {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void setAboveMaskLayer(boolean z2) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public final void setHoleOptions(List<BaseHoleOptions> list) {
        try {
            this.q = list;
            if (this.p == null) {
                this.p = new ArrayList();
            } else {
                this.p.clear();
            }
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    BaseHoleOptions baseHoleOptions = list.get(i2);
                    if (baseHoleOptions instanceof PolygonHoleOptions) {
                        PolygonHoleOptions polygonHoleOptions = (PolygonHoleOptions) baseHoleOptions;
                        if (a(polygonHoleOptions) && !ic.a(this.p, polygonHoleOptions)) {
                            this.p.add(polygonHoleOptions);
                        }
                    } else if (baseHoleOptions instanceof CircleHoleOptions) {
                        CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
                        if (a(circleHoleOptions) && !ic.a(this.p, circleHoleOptions)) {
                            this.p.add(circleHoleOptions);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            rx.c(th, "PolygonDelegateImp", "setHoleOptions");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public final List<BaseHoleOptions> getHoleOptions() throws RemoteException {
        return this.p;
    }

    private boolean a(PolygonHoleOptions polygonHoleOptions) {
        boolean z2 = true;
        try {
            List<LatLng> points = polygonHoleOptions.getPoints();
            int i2 = 0;
            while (i2 < points.size() && (z2 = contains(points.get(i2)))) {
                i2++;
            }
        } catch (Throwable th) {
            rx.c(th, "CircleDelegateImp", "isPolygonInCircle");
            th.printStackTrace();
        }
        return z2;
    }

    private boolean a(CircleHoleOptions circleHoleOptions) {
        try {
            if (((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), getCenter())) <= getRadius() - circleHoleOptions.getRadius()) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            rx.c(th, "CircleDelegateImp", "isCircleInCircle");
            th.printStackTrace();
            return true;
        }
    }

    private static IPoint[] a(IPoint[] iPointArr) {
        int length = iPointArr.length;
        double[] dArr = new double[(length * 2)];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            dArr[i3] = ((double) iPointArr[i2].x) * B;
            dArr[i3 + 1] = ((double) iPointArr[i2].y) * B;
        }
        hy a2 = new hi().a(dArr);
        int i4 = a2.b;
        IPoint[] iPointArr2 = new IPoint[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            iPointArr2[i5] = new IPoint();
            iPointArr2[i5].x = (int) (dArr[a2.a(i5) * 2] / B);
            iPointArr2[i5].y = (int) (dArr[(a2.a(i5) * 2) + 1] / B);
        }
        return iPointArr2;
    }

    private void a(List<IPoint> list, int i2, int i3) throws RemoteException {
        if (list.size() >= 2) {
            float[] fArr = new float[(list.size() * 3)];
            IPoint[] iPointArr = new IPoint[list.size()];
            int i4 = 0;
            for (IPoint iPoint : list) {
                int i5 = i4 * 3;
                fArr[i5] = (float) (iPoint.x - i2);
                fArr[i5 + 1] = (float) (iPoint.y - i3);
                fArr[i5 + 2] = 0.0f;
                iPointArr[i4] = iPoint;
                i4++;
            }
            IPoint[] a2 = a(iPointArr);
            if (a2.length == 0) {
                if (B == 1.0E10d) {
                    B = 1.0E8d;
                } else {
                    B = 1.0E10d;
                }
                a2 = a(iPointArr);
            }
            float[] fArr2 = new float[(a2.length * 3)];
            int i6 = 0;
            for (IPoint iPoint2 : a2) {
                int i7 = i6 * 3;
                fArr2[i7] = (float) (iPoint2.x - i2);
                fArr2[i7 + 1] = (float) (iPoint2.y - i3);
                fArr2[i7 + 2] = 0.0f;
                i6++;
            }
            this.r = iPointArr.length;
            this.s = a2.length;
            this.t = ic.a(fArr);
            this.u = ic.a(fArr2);
        }
    }

    private List<IPoint> a(List<LatLng> list) throws RemoteException {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            LatLng latLng = null;
            for (LatLng latLng2 : list) {
                if (!latLng2.equals(latLng)) {
                    IPoint obtain = IPoint.obtain();
                    this.j.a(latLng2.latitude, latLng2.longitude, obtain);
                    arrayList.add(obtain);
                    latLng = latLng2;
                }
            }
            int size = arrayList.size();
            if (size > 1) {
                IPoint iPoint = (IPoint) arrayList.get(0);
                int i2 = size - 1;
                IPoint iPoint2 = (IPoint) arrayList.get(i2);
                if (iPoint.x == iPoint2.x && iPoint.y == iPoint2.y) {
                    arrayList.remove(i2);
                }
            }
        }
        if (ic.a(arrayList, arrayList.size())) {
            Collections.reverse(arrayList);
        }
        return arrayList;
    }

    private void b(CircleHoleOptions circleHoleOptions) throws RemoteException {
        if (circleHoleOptions.getCenter() != null) {
            IPoint obtain = IPoint.obtain();
            FPoint obtain2 = FPoint.obtain();
            GLMapState.lonlat2Geo(circleHoleOptions.getCenter().longitude, circleHoleOptions.getCenter().latitude, obtain);
            float[] fArr = new float[1086];
            double a2 = a(circleHoleOptions.getCenter().latitude) * circleHoleOptions.getRadius();
            obtain2.x = (float) (obtain.x - this.j.getMapConfig().getSX());
            obtain2.y = (float) (obtain.y - this.j.getMapConfig().getSY());
            int i2 = 0;
            fArr[0] = obtain2.x;
            fArr[1] = obtain2.y;
            fArr[2] = 0.0f;
            while (i2 < 361) {
                double d2 = (((double) i2) * 3.141592653589793d) / 180.0d;
                double d3 = (double) obtain.x;
                double d4 = (double) obtain.y;
                obtain2.x = (float) (((int) (d3 + (Math.sin(d2) * a2))) - this.j.getMapConfig().getSX());
                obtain2.y = (float) (((int) (d4 + (Math.cos(d2) * a2))) - this.j.getMapConfig().getSY());
                i2++;
                int i3 = i2 * 3;
                fArr[i3] = obtain2.x;
                fArr[i3 + 1] = obtain2.y;
                fArr[i3 + 2] = 0.0f;
            }
            this.r = fArr.length / 3;
            this.t = ic.a(fArr);
            obtain.recycle();
            obtain2.recycle();
        }
    }
}
