package com.amap.api.col.stln3;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.os.Build;
import android.os.RemoteException;
import android.support.v4.view.ViewCompat;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.PolylineOptions;
import com.autonavi.amap.mapcore.AMapNativePolyline;
import com.autonavi.amap.mapcore.AMapNativeRenderer;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.FPoint3;
import com.autonavi.amap.mapcore.FPointBounds;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.Rectangle;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: PolylineDelegateImp */
public final class gl implements gd {
    private boolean A = true;
    private int B = 0;
    private int C = 0;
    private int D = ViewCompat.MEASURED_STATE_MASK;
    private int E = 0;
    private int F = 0;
    private float G = 10.0f;
    private float H = 0.0f;
    private float I = 0.0f;
    private float J;
    private float K;
    private float L;
    private float M;
    private float N = 1.0f;
    private float O = 0.0f;
    private float[] P;
    private int[] Q;
    private int[] R;
    private boolean S = false;
    private FPointBounds T = null;
    private PolylineOptions U;
    private int V = 0;
    private PolylineOptions.LineJoinType W = PolylineOptions.LineJoinType.LineJoinBevel;
    private PolylineOptions.LineCapType X = PolylineOptions.LineCapType.LineCapRound;
    private gq Y;
    private long Z = 0;
    Rect a = null;
    private boolean aa = false;
    private float ab = -1.0f;
    private List<IPoint> ac = new ArrayList();
    int b = 0;
    ArrayList<FPoint> c = new ArrayList<>();
    long d = 0;
    private cm e;
    private String f;
    private List<IPoint> g = new ArrayList();
    private List<FPoint> h = new ArrayList();
    private List<LatLng> i = new ArrayList();
    private List<BitmapDescriptor> j = new ArrayList();
    private List<cx> k = new ArrayList();
    private List<Integer> l = new ArrayList();
    private List<Integer> m = new ArrayList();
    private List<Integer> n = new ArrayList();
    private List<Integer> o = new ArrayList();
    private FloatBuffer p;
    private BitmapDescriptor q = null;
    private Object r = new Object();
    private boolean s = true;
    private boolean t = true;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private boolean x = true;
    private boolean y = false;
    private boolean z = false;

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public final void setGeodesic(boolean z2) throws RemoteException {
        this.u = z2;
        this.e.e().setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public final boolean isGeodesic() {
        return this.u;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public final void setDottedLine(boolean z2) {
        int i2 = this.B;
        if (i2 == 2 || i2 == 0) {
            this.v = z2;
            if (z2 && this.t) {
                this.B = 2;
            } else if (!z2 && this.t) {
                this.B = 0;
            }
            this.e.e().setRunLowFrame(false);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public final boolean isDottedLine() {
        return this.v;
    }

    public gl(cm cmVar, PolylineOptions polylineOptions) {
        this.e = cmVar;
        setOptions(polylineOptions);
        try {
            this.f = getId();
        } catch (RemoteException e2) {
            rx.c(e2, "PolylineDelegateImp", "create");
            e2.printStackTrace();
        }
    }

    private static void a(List<IPoint> list, List<IPoint> list2, double d2) {
        if (list.size() == 3) {
            int i2 = 0;
            int i3 = 0;
            while (i3 <= 10) {
                float f2 = (float) i3;
                float f3 = f2 / 10.0f;
                IPoint obtain = IPoint.obtain();
                double d3 = 1.0d - ((double) f3);
                double d4 = d3 * d3;
                double d5 = ((double) (2.0f * f3)) * d3;
                float f4 = f3 * f3;
                double d6 = (((double) list.get(i2).x) * d4) + (((double) list.get(1).x) * d5 * d2) + ((double) (((float) list.get(2).x) * f4));
                double d7 = (((double) list.get(i2).y) * d4) + (((double) list.get(1).y) * d5 * d2) + ((double) (((float) list.get(2).y) * f4));
                double d8 = d4 + (d5 * d2) + ((double) f4);
                obtain.x = (int) (d6 / d8);
                obtain.y = (int) (d7 / d8);
                list2.add(obtain);
                i3 = (int) (1.0f + f2);
                i2 = 0;
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void remove() throws RemoteException {
        this.e.c(getId());
        setVisible(false);
        this.e.e().setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final String getId() throws RemoteException {
        if (this.f == null) {
            this.f = this.e.a("Polyline");
        }
        return this.f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01fa A[Catch:{ all -> 0x027c, Throwable -> 0x0282 }] */
    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setPoints(java.util.List<com.amap.api.maps.model.LatLng> r31) throws android.os.RemoteException {
        /*
        // Method dump skipped, instructions count: 662
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.gl.setPoints(java.util.List):void");
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public final List<LatLng> getPoints() throws RemoteException {
        return this.i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public final void setWidth(float f2) throws RemoteException {
        this.G = f2;
        this.e.e().setRunLowFrame(false);
        this.U.width(f2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public final float getWidth() throws RemoteException {
        return this.G;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public final void setColor(int i2) {
        int i3 = this.B;
        if (i3 == 0 || i3 == 2) {
            this.D = i2;
            this.J = ((float) Color.alpha(i2)) / 255.0f;
            this.K = ((float) Color.red(i2)) / 255.0f;
            this.L = ((float) Color.green(i2)) / 255.0f;
            this.M = ((float) Color.blue(i2)) / 255.0f;
            if (this.t) {
                if (this.v) {
                    this.B = 2;
                } else {
                    this.B = 0;
                }
            }
            this.e.e().setRunLowFrame(false);
        }
        this.U.color(i2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public final int getColor() throws RemoteException {
        return this.D;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void setZIndex(float f2) throws RemoteException {
        this.H = f2;
        this.e.d();
        this.e.e().setRunLowFrame(false);
        PolylineOptions polylineOptions = this.U;
        if (polylineOptions != null) {
            polylineOptions.zIndex(f2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final float getZIndex() throws RemoteException {
        return this.H;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void setVisible(boolean z2) throws RemoteException {
        this.s = z2;
        this.e.e().setRunLowFrame(false);
        PolylineOptions polylineOptions = this.U;
        if (polylineOptions != null) {
            polylineOptions.visible(z2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final boolean isVisible() throws RemoteException {
        return this.s;
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
        if (this.aa) {
            return true;
        }
        Rectangle geoRectangle = this.e.e().getMapConfig().getGeoRectangle();
        Rect rect = this.a;
        if (rect == null || geoRectangle == null || geoRectangle.isOverlap(rect)) {
            return true;
        }
        return false;
    }

    private boolean a(List<IPoint> list) {
        synchronized (this.r) {
            FPointBounds.Builder builder = new FPointBounds.Builder();
            this.h.clear();
            int i2 = 0;
            this.z = false;
            this.P = new float[(list.size() * 3)];
            this.b = this.P.length;
            for (IPoint iPoint : list) {
                FPoint3 fPoint3 = new FPoint3();
                this.e.e().a(iPoint.x, iPoint.y, (FPoint) fPoint3);
                int i3 = i2 * 3;
                this.P[i3] = fPoint3.x;
                this.P[i3 + 1] = fPoint3.y;
                this.P[i3 + 2] = 0.0f;
                if (this.l != null) {
                    synchronized (this.l) {
                        if (this.l != null && this.l.size() > i2) {
                            fPoint3.setColorIndex(this.l.get(i2).intValue());
                        } else if (this.m != null && this.m.size() > i2) {
                            fPoint3.setColorIndex(this.m.get(i2).intValue());
                        }
                    }
                }
                this.h.add(fPoint3);
                builder.include(fPoint3);
                i2++;
            }
            this.T = builder.build();
            if (!this.A) {
                this.p = ic.a(this.P);
            }
            this.E = list.size();
            c();
        }
        return true;
    }

    private void c() {
        float mapPerPixelUnitLength = this.e.e().getMapConfig().getMapPerPixelUnitLength();
        if (this.E > 5000) {
            float f2 = this.I;
            if (f2 <= 12.0f) {
                float f3 = (this.G / 2.0f) + (f2 / 2.0f);
                float f4 = 200.0f;
                if (f3 <= 200.0f) {
                    f4 = f3;
                }
                this.O = mapPerPixelUnitLength * f4;
                return;
            }
            this.O = mapPerPixelUnitLength * 10.0f;
            return;
        }
        this.O = mapPerPixelUnitLength * 2.0f;
    }

    private void b(List<FPoint> list) throws RemoteException {
        int i2;
        this.c.clear();
        int size = list.size();
        if (size >= 2) {
            int i3 = 0;
            FPoint fPoint = list.get(0);
            this.c.add(fPoint);
            FPoint fPoint2 = fPoint;
            int i4 = 1;
            while (true) {
                i2 = size - 1;
                if (i4 >= i2) {
                    break;
                }
                FPoint fPoint3 = list.get(i4);
                if (i4 != 1) {
                    if (!(((fPoint2 instanceof FPoint3) && (fPoint3 instanceof FPoint3) && ((FPoint3) fPoint2).colorIndex != ((FPoint3) fPoint3).colorIndex) || Math.abs(fPoint3.x - fPoint2.x) >= this.O || Math.abs(fPoint3.y - fPoint2.y) >= this.O)) {
                        ArrayList<FPoint> arrayList = this.c;
                        arrayList.set(arrayList.size() - 1, fPoint3);
                        i4++;
                    }
                }
                this.c.add(fPoint3);
                fPoint2 = fPoint3;
                i4++;
            }
            this.c.add(list.get(i2));
            int size2 = this.c.size() * 3;
            this.b = size2;
            float[] fArr = this.P;
            if (fArr == null || fArr.length < this.b) {
                this.P = new float[size2];
            }
            int i5 = this.B;
            if (i5 == 5 || i5 == 3 || i5 == 4) {
                int[] iArr = new int[this.c.size()];
                ArrayList arrayList2 = new ArrayList();
                int i6 = 0;
                int i7 = 0;
                for (int i8 = 0; i8 < size2 / 3; i8++) {
                    FPoint3 fPoint32 = (FPoint3) this.c.get(i8);
                    int i9 = i8 * 3;
                    this.P[i9] = fPoint32.x;
                    this.P[i9 + 1] = fPoint32.y;
                    this.P[i9 + 2] = 0.0f;
                    int i10 = fPoint32.colorIndex;
                    if (i8 == 0) {
                        arrayList2.add(Integer.valueOf(i10));
                    } else if (i10 != i6) {
                        if (i10 == -1) {
                            i10 = i6;
                        }
                        arrayList2.add(Integer.valueOf(i10));
                    }
                    iArr[i7] = i8;
                    i7++;
                    i6 = i10;
                }
                this.Q = new int[arrayList2.size()];
                int[] iArr2 = this.Q;
                System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
                this.n = arrayList2;
                this.o = arrayList2;
                return;
            }
            Iterator<FPoint> it = this.c.iterator();
            while (it.hasNext()) {
                FPoint next = it.next();
                int i11 = i3 * 3;
                this.P[i11] = next.x;
                this.P[i11 + 1] = next.y;
                this.P[i11 + 2] = 0.0f;
                i3++;
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public final void setCustomTexture(BitmapDescriptor bitmapDescriptor) {
        long nanoTime = System.nanoTime();
        if (nanoTime - this.d >= 16) {
            this.d = nanoTime;
            if (bitmapDescriptor != null) {
                synchronized (this) {
                    if (!bitmapDescriptor.equals(this.q)) {
                        this.t = false;
                        this.w = false;
                        this.B = 1;
                        this.q = bitmapDescriptor;
                        this.e.e().setRunLowFrame(false);
                        if (this.U != null) {
                            this.U.setCustomTexture(bitmapDescriptor);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.amap.api.col.stln3.fz
    public final void a(MapConfig mapConfig) throws RemoteException {
        List<IPoint> list;
        List<FPoint> list2;
        List<FPoint> list3;
        List<FPoint> list4;
        List<FPoint> list5;
        int[] iArr;
        gq gqVar;
        if (this.Z == 0) {
            this.Z = AMapNativePolyline.nativeCreate();
            long j2 = this.Z;
            if (!(j2 == 0 || (gqVar = this.Y) == null)) {
                AMapNativePolyline.nativeSetGLShaderManager(j2, gqVar.a());
            }
        }
        if (this.ab != -1.0f) {
            list = this.ac;
        } else {
            list = this.g;
        }
        if (!(list == null || list.size() == 0 || this.G <= 0.0f || this.e.e() == null)) {
            synchronized (this.r) {
                int sx = mapConfig.getSX();
                int sy = mapConfig.getSY();
                int beyond180Mode = mapConfig.getGeoRectangle().getBeyond180Mode();
                int size = this.h.size();
                int size2 = list.size();
                if (size == size2) {
                    for (int i2 = 0; i2 < size2; i2++) {
                        IPoint iPoint = list.get(i2);
                        FPoint fPoint = this.h.get(i2);
                        fPoint.x = (float) (iPoint.x - sx);
                        fPoint.y = (float) (iPoint.y - sy);
                        if (this.aa) {
                            if (beyond180Mode >= 0) {
                                if (mapConfig.getSX() < 134217728) {
                                }
                            }
                            fPoint.x -= 2.68435456E8f;
                        }
                    }
                } else {
                    this.h.clear();
                    int i3 = 0;
                    for (int i4 = 0; i4 < size2; i4++) {
                        IPoint iPoint2 = list.get(i4);
                        FPoint3 fPoint3 = new FPoint3();
                        if (this.l != null) {
                            synchronized (this.l) {
                                if (this.l != null && this.l.size() > i3) {
                                    fPoint3.setColorIndex(this.l.get(i3).intValue());
                                }
                            }
                        }
                        fPoint3.x = (float) (iPoint2.x - sx);
                        fPoint3.y = (float) (iPoint2.y - sy);
                        if (this.aa && (beyond180Mode < 0 || mapConfig.getSX() < 134217728)) {
                            fPoint3.x -= 2.68435456E8f;
                        }
                        this.h.add(fPoint3);
                        i3++;
                    }
                }
            }
            if (this.x) {
                a(this.ab != -1.0f ? this.ac : this.g);
                this.x = false;
            } else if (this.y) {
                synchronized (this.r) {
                    int size3 = this.h.size();
                    synchronized (this.l) {
                        int size4 = this.l.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (size4 > i5) {
                                ((FPoint3) this.h.get(i5)).setColorIndex(this.l.get(i5).intValue());
                            }
                        }
                    }
                }
            }
            if (this.P != null && this.E > 0) {
                MapConfig mapConfig2 = this.e.e().getMapConfig();
                float mapLenWithWin = this.e.e().f().getMapLenWithWin((int) this.G);
                switch (this.B) {
                    case 0:
                        b(mapLenWithWin, mapConfig2);
                        break;
                    case 1:
                        if (this.A) {
                            if (!this.w) {
                                synchronized (this) {
                                    try {
                                        if (this.q != null) {
                                            this.C = a(Build.VERSION.SDK_INT >= 12, this.q, true);
                                            this.w = true;
                                        }
                                    } catch (Throwable th) {
                                        rx.c(th, "MarkerDelegateImp", "loadtexture");
                                        break;
                                    }
                                }
                            }
                            if (mapConfig2.getChangeRatio() == 1.0d && this.P != null) {
                                this.V++;
                                if (this.V > 2) {
                                    AMapNativeRenderer.nativeDrawLineByTextureID(this.P, this.b, mapLenWithWin, this.C, this.K, this.L, this.M, this.J, 1.0f - this.N, false, false, false, this.e.f(), this.X.getTypeValue(), this.W.getTypeValue());
                                    break;
                                }
                            }
                            this.V = 0;
                            FPoint[] clipMapRect = mapConfig2.getGeoRectangle().getClipMapRect();
                            List<FPoint> list6 = this.h;
                            if (a(clipMapRect)) {
                                synchronized (this.r) {
                                    list2 = ic.a(clipMapRect, this.h);
                                }
                            } else {
                                list2 = list6;
                            }
                            if (list2.size() >= 2) {
                                b(list2);
                                AMapNativeRenderer.nativeDrawLineByTextureID(this.P, this.b, mapLenWithWin, this.C, this.K, this.L, this.M, this.J, 1.0f - this.N, false, false, false, this.e.f(), this.X.getTypeValue(), this.W.getTypeValue());
                                break;
                            }
                        }
                        b(mapLenWithWin, mapConfig2);
                        break;
                    case 2:
                        if (this.F != -1) {
                            if (!this.w) {
                                synchronized (this) {
                                    try {
                                        if (this.q != null) {
                                            this.C = a(Build.VERSION.SDK_INT >= 12, this.q, true);
                                            this.w = true;
                                        }
                                    } catch (Throwable th2) {
                                        rx.c(th2, "MarkerDelegateImp", "loadtexture");
                                        break;
                                    }
                                }
                            }
                            try {
                                List<FPoint> list7 = this.h;
                                if (this.e.e() == null) {
                                    break;
                                } else {
                                    if (mapConfig2.getChangeRatio() == 1.0d && this.P != null) {
                                        this.V++;
                                        if (this.V > 2) {
                                            AMapNativeRenderer.nativeDrawLineByTextureID(this.P, this.b, mapLenWithWin, this.e.e().c(this.F), this.K, this.L, this.M, this.J, 0.0f, true, true, false, this.e.f(), this.X.getTypeValue(), this.W.getTypeValue());
                                            break;
                                        }
                                    }
                                    this.V = 0;
                                    FPoint[] clipMapRect2 = mapConfig2.getGeoRectangle().getClipMapRect();
                                    if (a(clipMapRect2)) {
                                        synchronized (this.r) {
                                            list3 = ic.a(clipMapRect2, this.h);
                                        }
                                    } else {
                                        list3 = list7;
                                    }
                                    if (list3.size() >= 2) {
                                        b(list3);
                                        AMapNativeRenderer.nativeDrawLineByTextureID(this.P, this.b, mapLenWithWin, this.e.e().c(this.F), this.K, this.L, this.M, this.J, 0.0f, true, true, false, this.e.f(), this.X.getTypeValue(), this.W.getTypeValue());
                                        break;
                                    }
                                }
                            } catch (Throwable th3) {
                                break;
                            }
                        }
                        b(mapLenWithWin, mapConfig2);
                        break;
                    case 3:
                        a(mapLenWithWin, mapConfig2);
                        break;
                    case 4:
                        int[] iArr2 = new int[this.m.size()];
                        for (int i6 = 0; i6 < this.m.size(); i6++) {
                            iArr2[i6] = this.m.get(i6).intValue();
                        }
                        FPoint[] clipMapRect3 = mapConfig2.getGeoRectangle().getClipMapRect();
                        List<FPoint> list8 = this.h;
                        if (a(clipMapRect3)) {
                            synchronized (this.r) {
                                list4 = ic.b(clipMapRect3, this.h);
                            }
                        } else {
                            list4 = list8;
                        }
                        if (list4.size() >= 2) {
                            b(list4);
                            int[] iArr3 = new int[this.o.size()];
                            for (int i7 = 0; i7 < iArr3.length; i7++) {
                                iArr3[i7] = this.o.get(i7).intValue();
                            }
                            if ((this.Q != null) && true) {
                                AMapNativeRenderer.nativeDrawGradientColorLine(this.P, this.b, mapLenWithWin, iArr3, iArr3.length, this.Q, this.Q.length, this.e.e().g(), this.e.f(), this.X.getTypeValue(), this.W.getTypeValue());
                                break;
                            }
                        }
                        break;
                    case 5:
                        if (this.A) {
                            if (!this.w) {
                                try {
                                    if (this.j != null) {
                                        this.R = new int[this.j.size()];
                                        boolean z2 = Build.VERSION.SDK_INT >= 12;
                                        d();
                                        int i8 = 0;
                                        for (BitmapDescriptor bitmapDescriptor : this.j) {
                                            this.R[i8] = a(z2, bitmapDescriptor, false);
                                            i8++;
                                        }
                                        this.w = true;
                                    }
                                } catch (Throwable th4) {
                                    rx.c(th4, "MarkerDelegateImp", "loadtexture");
                                    break;
                                }
                            }
                            FPoint[] clipMapRect4 = mapConfig2.getGeoRectangle().getClipMapRect();
                            try {
                                List<FPoint> list9 = this.h;
                                if (a(clipMapRect4)) {
                                    synchronized (this.r) {
                                        try {
                                            list5 = ic.b(clipMapRect4, this.h);
                                        } catch (Throwable th5) {
                                            th = th5;
                                            throw th;
                                        }
                                    }
                                } else {
                                    list5 = list9;
                                }
                                if (list5.size() >= 2) {
                                    b(list5);
                                    synchronized (this.n) {
                                        try {
                                            iArr = new int[this.n.size()];
                                            for (int i9 = 0; i9 < iArr.length; i9++) {
                                                int intValue = this.n.get(i9).intValue();
                                                if (intValue < 0) {
                                                    intValue = 0;
                                                }
                                                iArr[i9] = this.R[intValue];
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            throw th;
                                        }
                                    }
                                    if ((this.Q != null) && true) {
                                        AMapNativeRenderer.nativeDrawLineByMultiTextureID(this.P, this.b, mapLenWithWin, iArr, iArr.length, this.Q, this.Q.length, 1.0f - this.N, this.e.f(), this.X.getTypeValue(), this.W.getTypeValue());
                                        break;
                                    }
                                }
                            } catch (Throwable th7) {
                                th7.printStackTrace();
                                break;
                            }
                        }
                        a(mapLenWithWin, mapConfig2);
                        break;
                }
            }
            this.z = true;
        }
    }

    private void d() {
        cm cmVar;
        List<cx> list = this.k;
        if (list != null) {
            for (cx cxVar : list) {
                if (!(cxVar == null || (cmVar = this.e) == null)) {
                    cmVar.a(cxVar);
                }
            }
            this.k.clear();
        }
    }

    private void a(cx cxVar) {
        if (cxVar != null) {
            this.k.add(cxVar);
            cxVar.g();
        }
    }

    private int a(boolean z2, BitmapDescriptor bitmapDescriptor, boolean z3) {
        if (z3) {
            d();
        }
        cx cxVar = null;
        if (!z2 || (cxVar = this.e.a(bitmapDescriptor)) == null) {
            int i2 = 0;
            if (cxVar == null) {
                cxVar = new cx(bitmapDescriptor, 0);
            }
            Bitmap bitmap = bitmapDescriptor.getBitmap();
            if (bitmap != null && !bitmap.isRecycled()) {
                int[] iArr = {0};
                GLES20.glGenTextures(1, iArr, 0);
                i2 = iArr[0];
                if (z2) {
                    cxVar.a(i2);
                    this.e.e().a(cxVar);
                }
                a(cxVar);
                ic.a(i2, bitmap, true);
            }
            return i2;
        }
        int f2 = cxVar.f();
        a(cxVar);
        return f2;
    }

    private void a(float f2, MapConfig mapConfig) {
        List<FPoint> list;
        int[] iArr = new int[this.m.size()];
        boolean z2 = false;
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            iArr[i2] = this.m.get(i2).intValue();
        }
        FPoint[] clipMapRect = mapConfig.getGeoRectangle().getClipMapRect();
        try {
            List<FPoint> list2 = this.h;
            if (a(clipMapRect)) {
                synchronized (this.r) {
                    list = ic.b(clipMapRect, this.h);
                }
            } else {
                list = list2;
            }
            if (list.size() >= 2) {
                b(list);
                int[] iArr2 = new int[this.o.size()];
                for (int i3 = 0; i3 < iArr2.length; i3++) {
                    iArr2[i3] = this.o.get(i3).intValue();
                }
                if (this.Q != null) {
                    z2 = true;
                }
                if (z2 && true) {
                    AMapNativeRenderer.nativeDrawLineByMultiColor(this.P, this.b, f2, this.e.e().g(), iArr2, iArr2.length, this.Q, this.Q.length, this.e.f(), this.X.getTypeValue(), this.W.getTypeValue());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b(float f2, MapConfig mapConfig) {
        try {
            List<FPoint> list = this.h;
            if (this.e.e() != null) {
                if (mapConfig.getChangeRatio() == 1.0d && this.P != null) {
                    this.V++;
                    if (this.V > 2) {
                        if (this.Z == 0 || this.Y == null) {
                            AMapNativeRenderer.nativeDrawLineByTextureID(this.P, this.b, f2, this.e.e().g(), this.K, this.L, this.M, this.J, 0.0f, false, true, false, this.e.f(), this.X.getTypeValue(), this.W.getTypeValue());
                            return;
                        } else {
                            AMapNativePolyline.nativeDrawLineByTextureID(this.Z, this.P, this.b, f2, this.e.e().g(), this.K, this.L, this.M, this.J, 0.0f, false, true, false, this.e.f(), this.X.getTypeValue(), this.W.getTypeValue());
                            return;
                        }
                    }
                }
                this.V = 0;
                FPoint[] clipMapRect = mapConfig.getGeoRectangle().getClipMapRect();
                if (a(clipMapRect)) {
                    synchronized (this.r) {
                        list = ic.a(clipMapRect, this.h);
                    }
                }
                if (list.size() >= 2) {
                    b(list);
                    if (this.Z == 0 || this.Y == null) {
                        AMapNativeRenderer.nativeDrawLineByTextureID(this.P, this.b, f2, this.e.e().g(), this.K, this.L, this.M, this.J, 0.0f, false, true, false, this.e.f(), this.X.getTypeValue(), this.W.getTypeValue());
                    } else {
                        AMapNativePolyline.nativeDrawLineByTextureID(this.Z, this.P, this.b, f2, this.e.e().g(), this.K, this.L, this.M, this.J, 0.0f, false, true, false, this.e.f(), this.X.getTypeValue(), this.W.getTypeValue());
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    private boolean a(FPoint[] fPointArr) {
        int i2;
        this.I = this.e.e().j();
        c();
        if (this.g.size() > 10000) {
            i2 = 7;
        } else {
            i2 = 3;
        }
        if (this.I <= ((float) i2)) {
            return false;
        }
        try {
            if (this.e.e() == null) {
                return false;
            }
            if (!ic.a(this.T.northeast, fPointArr) || !ic.a(this.T.southwest, fPointArr)) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void destroy() {
        try {
            remove();
            if (this.k != null && this.k.size() > 0) {
                for (int i2 = 0; i2 < this.k.size(); i2++) {
                    cx cxVar = this.k.get(i2);
                    if (cxVar != null) {
                        this.e.a(cxVar);
                        this.e.e().c(cxVar.j());
                    }
                }
                this.k.clear();
            }
            if (this.P != null) {
                this.P = null;
            }
            if (this.p != null) {
                this.p.clear();
                this.p = null;
            }
            if (this.j != null && this.j.size() > 0) {
                for (BitmapDescriptor bitmapDescriptor : this.j) {
                    bitmapDescriptor.recycle();
                }
            }
            synchronized (this) {
                if (this.q != null) {
                    this.q.recycle();
                }
            }
            if (this.m != null) {
                this.m.clear();
                this.m = null;
            }
            if (this.l != null) {
                synchronized (this.l) {
                    this.l.clear();
                    this.l = null;
                }
            }
            if (this.i != null) {
                this.i.clear();
                this.i = null;
            }
            this.U = null;
            if (this.Z != 0) {
                AMapNativePolyline.nativeDestroy(this.Z);
            }
        } catch (Throwable th) {
            rx.c(th, "PolylineDelegateImp", "destroy");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.stln3.fz
    public final boolean b() {
        return this.z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public final LatLng getNearestLatLng(LatLng latLng) {
        List<LatLng> list;
        if (latLng == null || (list = this.i) == null || list.size() == 0) {
            return null;
        }
        int i2 = 0;
        float f2 = 0.0f;
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            try {
                if (i3 == 0) {
                    f2 = AMapUtils.calculateLineDistance(latLng, this.i.get(i3));
                } else {
                    float calculateLineDistance = AMapUtils.calculateLineDistance(latLng, this.i.get(i3));
                    if (f2 > calculateLineDistance) {
                        i2 = i3;
                        f2 = calculateLineDistance;
                    }
                }
            } catch (Throwable th) {
                rx.c(th, "PolylineDelegateImp", "getNearestLatLng");
                th.printStackTrace();
                return null;
            }
        }
        return this.i.get(i2);
    }

    @Override // com.amap.api.col.stln3.gd
    public final boolean a(LatLng latLng) {
        int i2;
        double d2;
        double d3;
        float[] fArr = this.P;
        float[] fArr2 = new float[fArr.length];
        System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
        if (fArr2.length / 3 < 2) {
            return false;
        }
        try {
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            while (true) {
                if (i3 >= this.P.length) {
                    break;
                }
                float f2 = this.P[i3];
                int i4 = i3 + 1;
                arrayList.add(FPoint.obtain(f2, this.P[i4]));
                i3 = i4 + 1 + 1;
            }
            if (arrayList.size() <= 0) {
                return false;
            }
            double mapLenWithWin = (double) this.e.e().f().getMapLenWithWin(((int) this.G) / 4);
            double mapLenWithWin2 = (double) this.e.e().f().getMapLenWithWin(5);
            IPoint obtain = IPoint.obtain();
            this.e.e().a(latLng.latitude, latLng.longitude, obtain);
            FPoint obtain2 = FPoint.obtain();
            this.e.e().a(obtain.x, obtain.y, obtain2);
            obtain.recycle();
            FPoint fPoint = null;
            int i5 = 0;
            for (i2 = 1; i5 < arrayList.size() - i2; i2 = 1) {
                if (i5 == 0) {
                    fPoint = (FPoint) arrayList.get(i5);
                }
                int i6 = i5 + 1;
                FPoint fPoint2 = (FPoint) arrayList.get(i6);
                double d4 = (double) obtain2.x;
                double d5 = (double) obtain2.y;
                double d6 = (double) fPoint.x;
                double d7 = (double) fPoint.y;
                double d8 = (double) fPoint2.x;
                double d9 = (double) fPoint2.y;
                double d10 = d8 - d6;
                double d11 = d4 - d6;
                double d12 = d9 - d7;
                double d13 = d5 - d7;
                double d14 = (d10 * d11) + (d12 * d13);
                if (d14 <= 0.0d) {
                    d2 = Math.sqrt((d11 * d11) + (d13 * d13));
                } else {
                    double d15 = (d10 * d10) + (d12 * d12);
                    if (d14 >= d15) {
                        double d16 = d4 - d8;
                        double d17 = d5 - d9;
                        d3 = (d16 * d16) + (d17 * d17);
                    } else {
                        double d18 = d14 / d15;
                        double d19 = d4 - (d6 + (d10 * d18));
                        double d20 = (d7 + (d12 * d18)) - d5;
                        d3 = (d19 * d19) + (d20 * d20);
                    }
                    d2 = Math.sqrt(d3);
                }
                if ((mapLenWithWin2 + mapLenWithWin) - d2 >= 0.0d) {
                    arrayList.clear();
                    return true;
                }
                obtain2 = obtain2;
                mapLenWithWin2 = mapLenWithWin2;
                fPoint = fPoint2;
                i5 = i6;
            }
            arrayList.clear();
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public final void setTransparency(float f2) {
        this.N = (float) Math.min(1.0d, Math.max(0.0d, (double) f2));
        this.e.e().setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public final void setCustemTextureIndex(List<Integer> list) {
        if (list != null && list.size() != 0) {
            try {
                synchronized (this.l) {
                    this.l.clear();
                    this.l.addAll(list);
                    this.n = c(list);
                    this.y = true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private List<Integer> c(List<Integer> list) {
        int[] iArr = new int[list.size()];
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            int intValue = list.get(i4).intValue();
            if (i4 == 0) {
                arrayList.add(Integer.valueOf(intValue));
            } else if (intValue != i2) {
                arrayList.add(Integer.valueOf(intValue));
            }
            iArr[i3] = i4;
            i3++;
            i2 = intValue;
        }
        this.Q = new int[arrayList.size()];
        int[] iArr2 = this.Q;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
        return arrayList;
    }

    private void e() {
        this.w = false;
        this.C = 0;
        int[] iArr = this.R;
        if (iArr != null) {
            Arrays.fill(iArr, 0);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void setAboveMaskLayer(boolean z2) {
        this.S = z2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final boolean isAboveMaskLayer() {
        return this.S;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public final void setOptions(PolylineOptions polylineOptions) {
        if (polylineOptions != null) {
            this.U = polylineOptions;
            try {
                setColor(polylineOptions.getColor());
                setGeodesic(polylineOptions.isGeodesic());
                setDottedLine(polylineOptions.isDottedLine());
                this.F = polylineOptions.getDottedLineType();
                this.S = polylineOptions.isAboveMaskLayer();
                setVisible(polylineOptions.isVisible());
                setWidth(polylineOptions.getWidth());
                setZIndex(polylineOptions.getZIndex());
                this.A = polylineOptions.isUseTexture();
                this.e.e().setRunLowFrame(false);
                setTransparency(polylineOptions.getTransparency());
                this.X = polylineOptions.getLineCapType();
                this.W = polylineOptions.getLineJoinType();
                if (polylineOptions.getColorValues() != null) {
                    List<Integer> colorValues = polylineOptions.getColorValues();
                    if (colorValues != null) {
                        if (colorValues.size() != 0) {
                            this.m = colorValues;
                            if (colorValues.size() > 1) {
                                this.t = false;
                                this.o = c(colorValues);
                                this.B = 3;
                                this.e.e().setRunLowFrame(false);
                            } else {
                                setColor(colorValues.get(0).intValue());
                            }
                        }
                    }
                    if (polylineOptions.isUseGradient() && this.m != null && this.m.size() > 1) {
                        this.B = 4;
                        this.e.e().setRunLowFrame(false);
                    }
                }
                if (polylineOptions.getCustomTexture() != null) {
                    setCustomTexture(polylineOptions.getCustomTexture());
                    e();
                }
                if (polylineOptions.getCustomTextureList() != null) {
                    List<BitmapDescriptor> customTextureList = polylineOptions.getCustomTextureList();
                    if (customTextureList != null) {
                        if (customTextureList.size() != 0) {
                            if (customTextureList.size() > 1) {
                                this.t = false;
                                this.B = 5;
                                this.j = customTextureList;
                                this.e.e().setRunLowFrame(false);
                            } else {
                                setCustomTexture(customTextureList.get(0));
                            }
                        }
                    }
                    setCustemTextureIndex(polylineOptions.getCustomTextureIndex());
                    e();
                }
                setPoints(polylineOptions.getPoints());
                setShownRatio(polylineOptions.getShownRatio());
            } catch (RemoteException e2) {
                rx.c(e2, "PolylineDelegateImp", "setOptions");
                e2.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public final PolylineOptions getOptions() {
        return this.U;
    }

    public final void a(gq gqVar) {
        this.Y = gqVar;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public final void setShownRatio(float f2) {
        this.ab = f2;
        synchronized (this.r) {
            int size = this.g.size();
            if (size >= 2) {
                float f3 = this.ab;
                if (f3 < 0.0f) {
                    f3 = 0.0f;
                } else if (f3 >= ((float) size)) {
                    f3 = (float) (size - 1);
                }
                if (this.u) {
                    int size2 = this.i.size();
                    if (size2 >= 2) {
                        f3 = (f3 / ((float) (size2 - 1))) * ((float) (size - 1));
                    } else {
                        return;
                    }
                }
                this.ac.clear();
                int floor = (int) Math.floor((double) f3);
                IPoint iPoint = null;
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    IPoint iPoint2 = this.g.get(i2);
                    if (i2 > floor) {
                        float f4 = f3 - ((float) floor);
                        if (f2 != 0.0f) {
                            if (iPoint != null) {
                                IPoint iPoint3 = new IPoint();
                                iPoint3.x = (int) (((float) iPoint.x) + (((float) (iPoint2.x - iPoint.x)) * f4));
                                iPoint3.y = (int) (((float) iPoint.y) + (((float) (iPoint2.y - iPoint.y)) * f4));
                                this.ac.add(iPoint3);
                            }
                        }
                    } else {
                        this.ac.add(iPoint2);
                        i2++;
                        iPoint = iPoint2;
                    }
                }
                this.x = true;
                this.e.e().setRunLowFrame(false);
                this.U.setShownRatio(f2);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public final float getShownRatio() {
        return this.ab;
    }
}
