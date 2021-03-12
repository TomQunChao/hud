package com.amap.api.col.stln3;

import android.graphics.Color;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.os.RemoteException;
import com.amap.api.col.stln3.gq;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.CircleHoleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.PolygonHoleOptions;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.Rectangle;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* compiled from: PolygonDelegateImp */
public final class gk implements gc {
    private static double C = 1.0E10d;
    private static float v = 4.0075016E7f;
    private static int w = 256;
    private static int x = 20;
    private FloatBuffer A;
    private FloatBuffer B;
    Rect a = null;
    private co b;
    private float c = 0.0f;
    private boolean d = true;
    private String e;
    private float f;
    private int g;
    private int h;
    private List<LatLng> i;
    private List<IPoint> j = new Vector();
    private List<BaseHoleOptions> k = new Vector();
    private List<BaseHoleOptions> l;
    private FloatBuffer m;
    private FloatBuffer n;
    private int o = 0;
    private int p = 0;
    private boolean q = false;
    private float r = 0.0f;
    private Object s = new Object();
    private float t = 0.0f;
    private gq.e u;
    private int y;
    private int z;

    public gk(co coVar) {
        this.b = coVar;
        try {
            this.e = getId();
        } catch (RemoteException e2) {
            rx.c(e2, "PolygonDelegateImp", "create");
            e2.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void remove() throws RemoteException {
        this.b.a(getId());
        this.b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final String getId() throws RemoteException {
        if (this.e == null) {
            this.e = this.b.d("Polygon");
        }
        return this.e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public final void setPoints(List<LatLng> list) throws RemoteException {
        synchronized (this.s) {
            this.i = list;
            LatLngBounds.Builder builder = LatLngBounds.builder();
            if (this.a == null) {
                this.a = new Rect();
            }
            ic.a(this.a);
            this.j.clear();
            if (list != null) {
                Object obj = null;
                for (LatLng latLng : list) {
                    if (!latLng.equals(obj)) {
                        IPoint obtain = IPoint.obtain();
                        this.b.a(latLng.latitude, latLng.longitude, obtain);
                        this.j.add(obtain);
                        ic.b(this.a, obtain.x, obtain.y);
                        builder.include(latLng);
                        obj = latLng;
                    }
                }
                int size = this.j.size();
                if (size > 1) {
                    IPoint iPoint = this.j.get(0);
                    int i2 = size - 1;
                    IPoint iPoint2 = this.j.get(i2);
                    if (iPoint.x == iPoint2.x && iPoint.y == iPoint2.y) {
                        this.j.remove(i2);
                    }
                }
            }
            this.a.sort();
            if (this.m != null) {
                this.m.clear();
            }
            if (this.n != null) {
                this.n.clear();
            }
            if (ic.a(this.j, this.j.size())) {
                Collections.reverse(this.j);
            }
            this.o = 0;
            this.p = 0;
            this.b.setRunLowFrame(false);
            this.b.setRunLowFrame(false);
            setHoleOptions(this.l);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public final List<LatLng> getPoints() throws RemoteException {
        return this.i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void setZIndex(float f2) throws RemoteException {
        this.c = f2;
        this.b.i();
        this.b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final float getZIndex() throws RemoteException {
        return this.c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void setVisible(boolean z2) throws RemoteException {
        this.d = z2;
        this.b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final boolean isVisible() throws RemoteException {
        return this.d;
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
        return super.hashCode();
    }

    @Override // com.amap.api.col.stln3.fz
    public final boolean a() {
        if (this.b.getMapConfig().getGeoRectangle().isOverlap(this.a)) {
            return true;
        }
        return false;
    }

    private void c() {
        co coVar = this.b;
        if (coVar != null) {
            this.u = (gq.e) coVar.k(3);
        }
    }

    @Override // com.amap.api.col.stln3.fz
    public final void a(MapConfig mapConfig) throws RemoteException {
        int i2;
        List<IPoint> list = this.j;
        if (!(list == null || list.size() == 0)) {
            Rectangle geoRectangle = mapConfig.getGeoRectangle();
            geoRectangle.getClipRect();
            List<IPoint> list2 = this.j;
            a(geoRectangle);
            MapConfig mapConfig2 = this.b.getMapConfig();
            List<BaseHoleOptions> list3 = this.k;
            if (list3 != null && list3.size() > 0) {
                GLES20.glClearStencil(0);
                GLES20.glStencilMask(255);
                GLES20.glClear(1024);
                GLES20.glFlush();
                GLES20.glEnable(2960);
                GLES20.glColorMask(false, false, false, false);
                GLES20.glStencilFunc(512, 1, 255);
                GLES20.glStencilOp(7681, 7680, 7680);
                for (int i3 = 0; i3 < this.k.size(); i3++) {
                    BaseHoleOptions baseHoleOptions = this.k.get(i3);
                    boolean z2 = baseHoleOptions instanceof PolygonHoleOptions;
                    if (z2) {
                        a(a(((PolygonHoleOptions) baseHoleOptions).getPoints()), mapConfig2.getSX(), mapConfig2.getSY());
                    } else if (baseHoleOptions instanceof CircleHoleOptions) {
                        this.b.i();
                        a((CircleHoleOptions) baseHoleOptions);
                    }
                    if (this.A != null && this.y > 0) {
                        gq.e eVar = this.u;
                        if (eVar == null || eVar.b()) {
                            c();
                        }
                        if (z2) {
                            hl.a(this.u, -1, this.h, this.A, this.f, this.B, this.y, this.z, this.b.A());
                        } else if (baseHoleOptions instanceof CircleHoleOptions) {
                            hl.a(this.u, Color.argb(200, 80, 1, 1), Color.argb(200, 1, 1, 1), this.A, 5.0f, this.y, this.b.A(), 0.0f, 0);
                        }
                    }
                }
                GLES20.glColorMask(true, true, true, true);
                GLES20.glStencilFunc(517, 1, 255);
                GLES20.glStencilMask(0);
            }
            if (list2.size() > 2) {
                int sx = mapConfig.getSX();
                int sy = mapConfig.getSY();
                e();
                ArrayList arrayList = new ArrayList();
                int size = list2.size();
                if (size >= 2) {
                    IPoint iPoint = list2.get(0);
                    arrayList.add(iPoint);
                    IPoint iPoint2 = iPoint;
                    int i4 = 1;
                    while (true) {
                        i2 = size - 1;
                        if (i4 >= i2) {
                            break;
                        }
                        IPoint iPoint3 = list2.get(i4);
                        if (((float) (iPoint3.x - iPoint2.x)) >= this.r || ((float) (iPoint3.x - iPoint2.x)) <= (-this.r) || ((float) (iPoint3.y - iPoint2.y)) >= this.r || ((float) (iPoint3.y - iPoint2.y)) <= (-this.r)) {
                            arrayList.add(iPoint3);
                            iPoint2 = iPoint3;
                        }
                        i4++;
                    }
                    arrayList.add(list2.get(i2));
                    float[] fArr = new float[(arrayList.size() * 3)];
                    IPoint[] iPointArr = new IPoint[arrayList.size()];
                    Iterator it = arrayList.iterator();
                    int i5 = 0;
                    while (it.hasNext()) {
                        IPoint iPoint4 = (IPoint) it.next();
                        int i6 = i5 * 3;
                        fArr[i6] = (float) (iPoint4.x - sx);
                        fArr[i6 + 1] = (float) (iPoint4.y - sy);
                        fArr[i6 + 2] = 0.0f;
                        iPointArr[i5] = iPoint4;
                        i5++;
                    }
                    IPoint[] a2 = a(iPointArr);
                    if (a2.length == 0) {
                        if (C == 1.0E10d) {
                            C = 1.0E8d;
                        } else {
                            C = 1.0E10d;
                        }
                        a2 = a(iPointArr);
                    }
                    float[] fArr2 = new float[(a2.length * 3)];
                    int i7 = 0;
                    for (IPoint iPoint5 : a2) {
                        int i8 = i7 * 3;
                        fArr2[i8] = (float) (iPoint5.x - sx);
                        fArr2[i8 + 1] = (float) (iPoint5.y - sy);
                        fArr2[i8 + 2] = 0.0f;
                        i7++;
                    }
                    this.o = iPointArr.length;
                    this.p = a2.length;
                    this.m = ic.a(fArr);
                    this.n = ic.a(fArr2);
                }
                if (this.m != null && this.n != null && this.o > 0 && this.p > 0) {
                    gq.e eVar2 = this.u;
                    if (eVar2 == null || eVar2.b()) {
                        c();
                    }
                    hl.a(this.u, this.g, this.h, this.m, this.f, this.n, this.o, this.p, this.b.A());
                }
            }
            d();
            this.q = true;
        }
    }

    private void d() throws RemoteException {
        GLES20.glClearStencil(0);
        GLES20.glClear(1024);
        GLES20.glDisable(2960);
        MapConfig mapConfig = this.b.getMapConfig();
        List<BaseHoleOptions> list = this.k;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                BaseHoleOptions baseHoleOptions = this.k.get(i2);
                boolean z2 = baseHoleOptions instanceof PolygonHoleOptions;
                if (z2) {
                    a(a(((PolygonHoleOptions) baseHoleOptions).getPoints()), mapConfig.getSX(), mapConfig.getSY());
                } else if (baseHoleOptions instanceof CircleHoleOptions) {
                    this.b.i();
                    a((CircleHoleOptions) baseHoleOptions);
                }
                if (this.A != null && this.y > 0) {
                    gq.e eVar = this.u;
                    if (eVar == null || eVar.b()) {
                        c();
                    }
                    if (z2) {
                        gq.e eVar2 = this.u;
                        int i3 = this.h;
                        FloatBuffer floatBuffer = this.A;
                        float f2 = this.f;
                        FloatBuffer floatBuffer2 = this.B;
                        int i4 = this.y;
                        int i5 = this.z;
                        hl.a(eVar2, i3, floatBuffer, f2, i4, this.b.A());
                    } else if (baseHoleOptions instanceof CircleHoleOptions) {
                        hl.a(this.u, this.h, this.A, this.f, this.y, this.b.A(), 1.0f, -1);
                    }
                }
            }
        }
    }

    private void a(CircleHoleOptions circleHoleOptions) throws RemoteException {
        if (circleHoleOptions.getCenter() != null) {
            IPoint obtain = IPoint.obtain();
            FPoint obtain2 = FPoint.obtain();
            GLMapState.lonlat2Geo(circleHoleOptions.getCenter().longitude, circleHoleOptions.getCenter().latitude, obtain);
            float[] fArr = new float[1086];
            double d2 = 3.141592653589793d;
            double d3 = 180.0d;
            double cos = (1.0d / ((double) ((float) ((Math.cos((circleHoleOptions.getCenter().latitude * 3.141592653589793d) / 180.0d) * ((double) v)) / ((double) (w << x)))))) * circleHoleOptions.getRadius();
            int sx = this.b.getMapConfig().getSX();
            int sy = this.b.getMapConfig().getSY();
            obtain2.x = (float) (obtain.x - sx);
            obtain2.y = (float) (obtain.y - sy);
            int i2 = 0;
            fArr[0] = obtain2.x;
            fArr[1] = obtain2.y;
            fArr[2] = 0.0f;
            while (i2 < 361) {
                double d4 = (((double) i2) * d2) / d3;
                int sin = (int) (((double) obtain.x) + (Math.sin(d4) * cos));
                int cos2 = (int) (((double) obtain.y) + (Math.cos(d4) * cos));
                obtain2.x = (float) (sin - sx);
                obtain2.y = (float) (cos2 - sy);
                obtain2.x = (float) (sin - this.b.getMapConfig().getSX());
                obtain2.y = (float) (cos2 - this.b.getMapConfig().getSY());
                i2++;
                int i3 = i2 * 3;
                fArr[i3] = obtain2.x;
                fArr[i3 + 1] = obtain2.y;
                fArr[i3 + 2] = 0.0f;
                d2 = 3.141592653589793d;
                d3 = 180.0d;
            }
            this.y = fArr.length / 3;
            this.A = ic.a(fArr);
            obtain.recycle();
            obtain2.recycle();
        }
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
                if (C == 1.0E10d) {
                    C = 1.0E8d;
                } else {
                    C = 1.0E10d;
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
            this.y = iPointArr.length;
            this.z = a2.length;
            this.A = ic.a(fArr);
            this.B = ic.a(fArr2);
        }
    }

    private boolean a(Rectangle rectangle) {
        this.t = this.b.j();
        e();
        if (this.t <= 10.0f || rectangle == null) {
            return false;
        }
        try {
            if (rectangle.contains(this.a)) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private List<IPoint> a(List<LatLng> list) throws RemoteException {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            LatLng latLng = null;
            for (LatLng latLng2 : list) {
                if (!latLng2.equals(latLng)) {
                    IPoint obtain = IPoint.obtain();
                    this.b.a(latLng2.latitude, latLng2.longitude, obtain);
                    arrayList.add(obtain);
                    ic.b(this.a, obtain.x, obtain.y);
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

    private void e() {
        float j2 = this.b.j();
        if (this.j.size() <= 5000) {
            this.r = this.b.f().getMapLenWithWin(2);
        } else if (j2 <= 12.0f) {
            float f2 = (this.f / 2.0f) + (j2 / 2.0f);
            float f3 = 200.0f;
            if (f2 <= 200.0f) {
                f3 = f2;
            }
            this.r = this.b.f().getMapLenWithWin((int) f3);
        } else {
            this.r = this.b.f().getMapLenWithWin(10);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public final void setStrokeWidth(float f2) throws RemoteException {
        this.f = f2;
        this.b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public final float getStrokeWidth() throws RemoteException {
        return this.f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public final void setFillColor(int i2) throws RemoteException {
        this.g = i2;
        this.b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public final int getFillColor() throws RemoteException {
        return this.g;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public final void setStrokeColor(int i2) throws RemoteException {
        this.h = i2;
        this.b.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public final int getStrokeColor() throws RemoteException {
        return this.h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public final void setHoleOptions(List<BaseHoleOptions> list) {
        try {
            this.l = list;
            if (this.k == null) {
                this.k = new ArrayList();
            } else {
                this.k.clear();
            }
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    BaseHoleOptions baseHoleOptions = list.get(i2);
                    if (baseHoleOptions instanceof PolygonHoleOptions) {
                        PolygonHoleOptions polygonHoleOptions = (PolygonHoleOptions) baseHoleOptions;
                        if (a(polygonHoleOptions) && !ic.a(this.k, polygonHoleOptions)) {
                            this.k.add(polygonHoleOptions);
                        }
                    } else if (baseHoleOptions instanceof CircleHoleOptions) {
                        CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
                        if (b(circleHoleOptions) && !ic.a(this.k, circleHoleOptions)) {
                            this.k.add(circleHoleOptions);
                        }
                    }
                }
            } else {
                this.k.clear();
            }
        } catch (Throwable th) {
            rx.c(th, "PolygonDelegateImp", "setHoleOptions");
            th.printStackTrace();
        }
        this.b.setRunLowFrame(false);
    }

    private boolean b(CircleHoleOptions circleHoleOptions) {
        try {
            if (ic.b(getPoints(), circleHoleOptions) || !contains(circleHoleOptions.getCenter())) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            rx.c(th, "PolygonDelegateImp", "isCircleInPolygon");
            th.printStackTrace();
            return false;
        }
    }

    private boolean a(PolygonHoleOptions polygonHoleOptions) {
        boolean z2 = true;
        try {
            List<LatLng> points = polygonHoleOptions.getPoints();
            int i2 = 0;
            while (i2 < points.size() && (z2 = ic.a(points.get(i2), getPoints()))) {
                i2++;
            }
        } catch (Throwable th) {
            rx.c(th, "PolygonDelegateImp", "isPolygonInPolygon");
            th.printStackTrace();
        }
        return z2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public final List<BaseHoleOptions> getHoleOptions() {
        return this.k;
    }

    private static IPoint[] a(IPoint[] iPointArr) {
        int length = iPointArr.length;
        double[] dArr = new double[(length * 2)];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            dArr[i3] = ((double) iPointArr[i2].x) * C;
            dArr[i3 + 1] = ((double) iPointArr[i2].y) * C;
        }
        hy a2 = new hi().a(dArr);
        int i4 = a2.b;
        IPoint[] iPointArr2 = new IPoint[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            iPointArr2[i5] = new IPoint();
            iPointArr2[i5].x = (int) (dArr[a2.a(i5) * 2] / C);
            iPointArr2[i5].y = (int) (dArr[(a2.a(i5) * 2) + 1] / C);
        }
        return iPointArr2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void destroy() {
        try {
            if (this.m != null) {
                this.m.clear();
                this.m = null;
            }
            if (this.n != null) {
                this.n = null;
            }
            if (this.A != null) {
                this.A.clear();
                this.A = null;
            }
            if (this.B != null) {
                this.B.clear();
                this.B = null;
            }
            if (this.k != null) {
                this.k.clear();
            }
            if (this.l != null) {
                this.l.clear();
            }
            this.k = null;
            this.l = null;
        } catch (Throwable th) {
            rx.c(th, "PolygonDelegateImp", "destroy");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolygon
    public final boolean contains(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return false;
        }
        try {
            if (this.k != null && this.k.size() > 0) {
                for (BaseHoleOptions baseHoleOptions : this.k) {
                    if (ic.a(baseHoleOptions, latLng)) {
                        return false;
                    }
                }
            }
            return ic.a(latLng, getPoints());
        } catch (Throwable th) {
            rx.c(th, "PolygonDelegateImp", "contains");
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.amap.api.col.stln3.fz
    public final boolean b() {
        return this.q;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final boolean isAboveMaskLayer() {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void setAboveMaskLayer(boolean z2) {
    }
}
