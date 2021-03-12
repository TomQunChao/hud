package com.amap.api.col.stln3;

import android.graphics.Color;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.v4.view.ViewCompat;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.AMapNativeRenderer;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.Rectangle;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/* compiled from: NavigateArrowDelegateImp */
public final class gi implements fy {
    float a;
    float b;
    float c;
    float d;
    Rect e = null;
    float[] f;
    int g = 0;
    private co h;
    private float i = 10.0f;
    private int j = ViewCompat.MEASURED_STATE_MASK;
    private int k = ViewCompat.MEASURED_STATE_MASK;
    private float l = 0.0f;
    private boolean m = true;
    private String n;
    private List<IPoint> o = new Vector();
    private int p = 0;
    private boolean q = false;
    private Object r = new Object();

    public gi(co coVar) {
        this.h = coVar;
        try {
            this.n = getId();
        } catch (RemoteException e2) {
            rx.c(e2, "NavigateArrowDelegateImp", "create");
            e2.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void remove() throws RemoteException {
        this.h.a(getId());
        this.h.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final String getId() throws RemoteException {
        if (this.n == null) {
            this.n = this.h.d("NavigateArrow");
        }
        return this.n;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public final void setPoints(List<LatLng> list) throws RemoteException {
        synchronized (this.r) {
            this.o.clear();
            if (this.e == null) {
                this.e = new Rect();
            }
            ic.a(this.e);
            if (list != null) {
                LatLng latLng = null;
                for (LatLng latLng2 : list) {
                    if (latLng2 != null && !latLng2.equals(latLng)) {
                        IPoint obtain = IPoint.obtain();
                        this.h.a(latLng2.latitude, latLng2.longitude, obtain);
                        this.o.add(obtain);
                        ic.b(this.e, obtain.x, obtain.y);
                        latLng = latLng2;
                    }
                }
            }
            this.p = 0;
            this.e.sort();
        }
        this.h.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public final List<LatLng> getPoints() throws RemoteException {
        return c();
    }

    private List<LatLng> c() throws RemoteException {
        ArrayList arrayList;
        if (this.o == null) {
            return null;
        }
        synchronized (this.r) {
            arrayList = new ArrayList();
            for (IPoint iPoint : this.o) {
                if (iPoint != null) {
                    DPoint obtain = DPoint.obtain();
                    this.h.a(iPoint.x, iPoint.y, obtain);
                    arrayList.add(new LatLng(obtain.y, obtain.x));
                    obtain.recycle();
                }
            }
        }
        return arrayList;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public final void setWidth(float f2) throws RemoteException {
        this.i = f2;
        this.h.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public final float getWidth() throws RemoteException {
        return this.i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public final void setTopColor(int i2) throws RemoteException {
        this.j = i2;
        this.a = ((float) Color.alpha(i2)) / 255.0f;
        this.b = ((float) Color.red(i2)) / 255.0f;
        this.c = ((float) Color.green(i2)) / 255.0f;
        this.d = ((float) Color.blue(i2)) / 255.0f;
        this.h.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public final int getTopColor() throws RemoteException {
        return this.j;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public final void setSideColor(int i2) throws RemoteException {
        this.k = i2;
        this.h.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.INavigateArrow
    public final int getSideColor() throws RemoteException {
        return this.k;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void setZIndex(float f2) throws RemoteException {
        this.l = f2;
        this.h.i();
        this.h.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final float getZIndex() throws RemoteException {
        return this.l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void setVisible(boolean z) throws RemoteException {
        this.m = z;
        this.h.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final boolean isVisible() throws RemoteException {
        return this.m;
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
        Rectangle geoRectangle;
        if (this.e == null || (geoRectangle = this.h.getMapConfig().getGeoRectangle()) == null || !geoRectangle.isOverlap(this.e)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0038 A[LOOP:0: B:11:0x0032->B:13:0x0038, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(com.autonavi.amap.mapcore.MapConfig r9) throws android.os.RemoteException {
        /*
        // Method dump skipped, instructions count: 106
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.gi.b(com.autonavi.amap.mapcore.MapConfig):boolean");
    }

    @Override // com.amap.api.col.stln3.fz
    public final void a(MapConfig mapConfig) throws RemoteException {
        List<IPoint> list = this.o;
        if (list != null && list.size() != 0 && this.i > 0.0f) {
            b(this.h.getMapConfig());
            if (this.f != null && this.p > 0) {
                AMapNativeRenderer.nativeDrawLineByTextureID(this.f, this.g, this.h.f().getMapLenWithWin((int) this.i), this.h.g(), this.b, this.c, this.d, this.a, 0.0f, false, true, true, this.h.A(), 2, 0);
            }
            this.q = true;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void destroy() {
        try {
            if (this.f != null) {
                this.f = null;
            }
        } catch (Throwable th) {
            rx.c(th, "NavigateArrowDelegateImp", "destroy");
            th.printStackTrace();
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
    public final void setAboveMaskLayer(boolean z) {
    }
}
