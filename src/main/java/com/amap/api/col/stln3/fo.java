package com.amap.api.col.stln3;

import android.graphics.Color;
import android.os.RemoteException;
import android.support.v4.view.ViewCompat;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.AMapNativeRenderer;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.interfaces.IOverlay;

/* compiled from: ArcDelegateImp */
public final class fo implements ft {
    float a;
    float b;
    float c;
    float d;
    private LatLng e;
    private LatLng f;
    private LatLng g;
    private float h = 10.0f;
    private int i = ViewCompat.MEASURED_STATE_MASK;
    private float j = 0.0f;
    private boolean k = true;
    private String l;
    private co m;
    private float[] n;
    private int o = 0;
    private boolean p = false;
    private double q = 0.0d;
    private double r = 0.0d;
    private double s = 0.0d;

    public fo(co coVar) {
        this.m = coVar;
        try {
            this.l = getId();
        } catch (RemoteException e2) {
            rx.c(e2, "ArcDelegateImp", "create");
            e2.printStackTrace();
        }
    }

    @Override // com.amap.api.col.stln3.fz
    public final boolean a() {
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void remove() throws RemoteException {
        this.m.a(getId());
        this.m.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final String getId() throws RemoteException {
        if (this.l == null) {
            this.l = this.m.d("Arc");
        }
        return this.l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void setZIndex(float f2) throws RemoteException {
        this.j = f2;
        this.m.i();
        this.m.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final float getZIndex() throws RemoteException {
        return this.j;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void setVisible(boolean z) throws RemoteException {
        this.k = z;
        this.m.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final boolean isVisible() throws RemoteException {
        return this.k;
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

    private boolean c() throws RemoteException {
        if (this.e == null || this.f == null || this.g == null || !this.k) {
            return false;
        }
        try {
            this.p = false;
            this.m.f();
            if (!(Math.abs((((this.e.latitude - this.f.latitude) * (this.f.longitude - this.g.longitude)) * Math.pow(10.0d, 6.0d)) - (((this.e.longitude - this.f.longitude) * (this.f.latitude - this.g.latitude)) * Math.pow(10.0d, 6.0d))) >= 1.0E-6d)) {
                FPoint[] fPointArr = new FPoint[3];
                this.n = new float[(fPointArr.length * 3)];
                FPoint obtain = FPoint.obtain();
                this.m.a(this.e.latitude, this.e.longitude, obtain);
                fPointArr[0] = obtain;
                FPoint obtain2 = FPoint.obtain();
                this.m.a(this.f.latitude, this.f.longitude, obtain2);
                fPointArr[1] = obtain2;
                FPoint obtain3 = FPoint.obtain();
                this.m.a(this.g.latitude, this.g.longitude, obtain3);
                fPointArr[2] = obtain3;
                for (int i2 = 0; i2 < 3; i2++) {
                    int i3 = i2 * 3;
                    this.n[i3] = fPointArr[i2].x;
                    this.n[i3 + 1] = fPointArr[i2].y;
                    this.n[i3 + 2] = 0.0f;
                }
                this.o = fPointArr.length;
                return true;
            }
            IPoint obtain4 = IPoint.obtain();
            this.m.a(this.e.latitude, this.e.longitude, obtain4);
            IPoint obtain5 = IPoint.obtain();
            this.m.a(this.f.latitude, this.f.longitude, obtain5);
            IPoint obtain6 = IPoint.obtain();
            this.m.a(this.g.latitude, this.g.longitude, obtain6);
            double d2 = (double) obtain4.x;
            double d3 = (double) obtain4.y;
            double d4 = (double) obtain5.x;
            double d5 = (double) obtain5.y;
            double d6 = (double) obtain6.x;
            double d7 = (double) obtain6.y;
            double d8 = d7 - d3;
            double d9 = d5 * d5;
            double d10 = d3 * d3;
            double d11 = d4 * d4;
            double d12 = d2 * d2;
            double d13 = d5 - d3;
            double d14 = d7 * d7;
            double d15 = d6 * d6;
            double d16 = d4 - d2;
            double d17 = d6 - d2;
            double d18 = (((((d9 - d10) + d11) - d12) * d8) + ((((d10 - d14) + d12) - d15) * d13)) / (((d16 * 2.0d) * d8) - ((d17 * 2.0d) * d13));
            double d19 = (((((d11 - d12) + d9) - d10) * d17) + ((((d12 - d15) + d10) - d14) * d16)) / (((d13 * 2.0d) * d17) - ((d8 * 2.0d) * d16));
            double d20 = d2 - d18;
            double d21 = d3 - d19;
            this.q = Math.sqrt((d20 * d20) + (d21 * d21));
            this.r = a(d18, d19, d2, d3);
            double a2 = a(d18, d19, d4, d5);
            this.s = a(d18, d19, d6, d7);
            if (this.r < this.s) {
                if (a2 <= this.r || a2 >= this.s) {
                    this.s -= 6.283185307179586d;
                }
            } else if (a2 <= this.s || a2 >= this.r) {
                this.s += 6.283185307179586d;
            }
            obtain4.recycle();
            obtain5.recycle();
            obtain6.recycle();
            DPoint obtain7 = DPoint.obtain(d18, d19);
            int abs = (int) ((Math.abs(this.s - this.r) * 180.0d) / 3.141592653589793d);
            double d22 = (this.s - this.r) / ((double) abs);
            FPoint[] fPointArr2 = new FPoint[(abs + 1)];
            this.n = new float[(fPointArr2.length * 3)];
            for (int i4 = 0; i4 <= abs; i4++) {
                if (i4 == abs) {
                    FPoint obtain8 = FPoint.obtain();
                    this.m.a(this.g.latitude, this.g.longitude, obtain8);
                    fPointArr2[i4] = obtain8;
                } else {
                    fPointArr2[i4] = a(this.r + (((double) i4) * d22), obtain7.x, obtain7.y);
                }
                fPointArr2[i4] = a(this.r + (((double) i4) * d22), obtain7.x, obtain7.y);
                int i5 = i4 * 3;
                this.n[i5] = fPointArr2[i4].x;
                this.n[i5 + 1] = fPointArr2[i4].y;
                this.n[i5 + 2] = 0.0f;
            }
            obtain7.recycle();
            this.o = fPointArr2.length;
            return true;
        } catch (Throwable th) {
            rx.c(th, "ArcDelegateImp", "calMapFPoint");
            th.printStackTrace();
            return false;
        }
    }

    private FPoint a(double d2, double d3, double d4) {
        int cos = (int) (d3 + (Math.cos(d2) * this.q));
        int i2 = (int) (d4 + ((-Math.sin(d2)) * this.q));
        FPoint obtain = FPoint.obtain();
        MapConfig mapConfig = this.m.getMapConfig();
        if (mapConfig != null) {
            obtain.x = (float) (cos - mapConfig.getSX());
            obtain.y = (float) (i2 - mapConfig.getSY());
        }
        return obtain;
    }

    private double a(double d2, double d3, double d4, double d5) {
        double d6 = (d3 - d5) / this.q;
        if (Math.abs(d6) > 1.0d) {
            d6 = Math.signum(d6);
        }
        double asin = Math.asin(d6);
        if (asin >= 0.0d) {
            if (d4 < d2) {
                return 3.141592653589793d - Math.abs(asin);
            }
            return asin;
        } else if (d4 < d2) {
            return 3.141592653589793d - asin;
        } else {
            return asin + 6.283185307179586d;
        }
    }

    @Override // com.amap.api.col.stln3.fz
    public final void a(MapConfig mapConfig) throws RemoteException {
        if (this.e != null && this.f != null && this.g != null && this.k) {
            c();
            if (this.n != null && this.o > 0) {
                float mapLenWithWin = this.m.f().getMapLenWithWin((int) this.h);
                this.m.f().getMapLenWithWin(1);
                float[] fArr = this.n;
                AMapNativeRenderer.nativeDrawLineByTextureID(fArr, fArr.length, mapLenWithWin, this.m.g(), this.b, this.c, this.d, this.a, 0.0f, false, true, false, this.m.A(), 3, 0);
            }
            this.p = true;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IArc
    public final void setStrokeWidth(float f2) throws RemoteException {
        this.h = f2;
        this.m.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IArc
    public final float getStrokeWidth() throws RemoteException {
        return this.h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IArc
    public final void setStrokeColor(int i2) throws RemoteException {
        this.i = i2;
        this.a = ((float) Color.alpha(i2)) / 255.0f;
        this.b = ((float) Color.red(i2)) / 255.0f;
        this.c = ((float) Color.green(i2)) / 255.0f;
        this.d = ((float) Color.blue(i2)) / 255.0f;
        this.m.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IArc
    public final int getStrokeColor() throws RemoteException {
        return this.i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void destroy() {
        try {
            this.e = null;
            this.f = null;
            this.g = null;
        } catch (Throwable th) {
            rx.c(th, "ArcDelegateImp", "destroy");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.stln3.fz
    public final boolean b() {
        return this.p;
    }

    public final void a(LatLng latLng) {
        this.e = latLng;
    }

    public final void b(LatLng latLng) {
        this.f = latLng;
    }

    public final void c(LatLng latLng) {
        this.g = latLng;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final boolean isAboveMaskLayer() {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void setAboveMaskLayer(boolean z) {
    }
}
