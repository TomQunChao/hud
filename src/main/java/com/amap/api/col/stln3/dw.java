package com.amap.api.col.stln3;

import android.graphics.Rect;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* compiled from: MultiPointOverlayDelegate */
public final class dw implements IMultiPointOverlay {
    private static int E = 0;
    int A;
    private String B;
    private float[] C;
    private boolean D;
    private ExecutorService F;
    private List<String> G;
    private float[] H;
    BitmapDescriptor a = BitmapDescriptorFactory.defaultMarker();
    BitmapDescriptor b;
    float c;
    float d;
    float e;
    float f;
    float g;
    List<MultiPointItem> h;
    dy i;
    dv j;
    dv k;
    List<MultiPointItem> l;
    IPoint m;
    dx n;
    List<du> o;
    float[] p;
    float[] q;
    float[] r;
    Rect s;
    dv t;
    dv u;
    int v;
    int w;
    float[] x;
    String y;
    String z;

    public dw(MultiPointOverlayOptions multiPointOverlayOptions, dx dxVar) {
        float[] fArr = null;
        this.b = null;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.5f;
        this.g = 0.5f;
        this.i = null;
        this.j = null;
        this.k = new dv(0, 1, 0, 1);
        this.l = new ArrayList();
        this.C = new float[]{-0.5f, -0.5f, 0.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.5f, 0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 0.5f, -0.5f, 0.0f, 0.0f, 1.0f, 0.0f};
        this.D = true;
        this.o = new ArrayList();
        this.F = null;
        this.G = new ArrayList();
        this.H = new float[(du.a * 3)];
        this.p = new float[16];
        this.q = new float[4];
        this.r = new float[4];
        this.s = new Rect();
        this.t = null;
        this.u = null;
        this.v = 0;
        this.w = 0;
        this.x = new float[12];
        this.y = "precision highp float;\nattribute vec3 aVertex;//顶点数组,三维坐标\nuniform mat4 aMVPMatrix;//mvp矩阵\nvoid main(){\n  gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n}";
        this.z = "//有颜色 没有纹理\nprecision highp float;\nvoid main(){\n  gl_FragColor = vec4(0,0,1,1.0);\n}";
        this.A = -1;
        this.n = dxVar;
        if (multiPointOverlayOptions != null) {
            this.b = (multiPointOverlayOptions.getIcon() == null || multiPointOverlayOptions.getIcon().getBitmap() == null || multiPointOverlayOptions.getIcon().getBitmap().isRecycled()) ? this.a : multiPointOverlayOptions.getIcon();
            this.f = multiPointOverlayOptions.getAnchorU();
            this.g = multiPointOverlayOptions.getAnchorV();
        }
        float[] fArr2 = this.C;
        if (fArr2 != null) {
            fArr = (float[]) fArr2.clone();
            float f2 = this.f - 0.5f;
            float f3 = this.g - 0.5f;
            fArr[0] = fArr[0] + f2;
            fArr[1] = fArr[1] - f3;
            fArr[6] = fArr[6] + f2;
            fArr[7] = fArr[7] - f3;
            fArr[12] = fArr[12] + f2;
            fArr[13] = fArr[13] - f3;
            fArr[18] = fArr[18] + f2;
            fArr[19] = fArr[19] - f3;
        }
        du duVar = new du(fArr);
        duVar.a(dxVar.a());
        duVar.a(this.b);
        this.o.add(duVar);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay
    public final void addItems(List<MultiPointItem> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    synchronized (this) {
                        if (this.h == null) {
                            this.h = new ArrayList();
                        }
                        this.h.clear();
                        this.h.addAll(list);
                        int size = this.h.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            if (this.h != null) {
                                MultiPointItem multiPointItem = this.h.get(i2);
                                if (!(multiPointItem == null || multiPointItem.getLatLng() == null)) {
                                    if (multiPointItem.getIPoint() == null) {
                                        IPoint iPoint = new IPoint();
                                        MapProjection.lonlat2Geo(multiPointItem.getLatLng().longitude, multiPointItem.getLatLng().latitude, iPoint);
                                        multiPointItem.setIPoint(iPoint);
                                    }
                                }
                            } else {
                                return;
                            }
                        }
                        if (this.i == null) {
                            dv a2 = a();
                            if (a2 != null) {
                                this.i = new dy(a2);
                            }
                        }
                        if (this.h != null) {
                            int size2 = this.h.size();
                            for (int i3 = 0; i3 < size2; i3++) {
                                MultiPointItem multiPointItem2 = this.h.get(i3);
                                if (!(multiPointItem2 == null || multiPointItem2.getIPoint() == null)) {
                                    if (this.i != null) {
                                        this.i.a(multiPointItem2);
                                    }
                                }
                            }
                        }
                        b();
                    }
                }
            } catch (Throwable th) {
                rx.c(th, "MultiPointOverlayDelegate", "addItems");
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay
    public final void addItem(MultiPointItem multiPointItem) {
        b();
    }

    private dv a() {
        List<MultiPointItem> list = this.h;
        if (list == null || list.size() == 0) {
            return null;
        }
        Iterator<MultiPointItem> it = this.h.iterator();
        MultiPointItem next = it.next();
        int i2 = next.getIPoint().x;
        int i3 = next.getIPoint().x;
        int i4 = next.getIPoint().y;
        int i5 = next.getIPoint().y;
        while (it.hasNext()) {
            MultiPointItem next2 = it.next();
            int i6 = next2.getIPoint().x;
            int i7 = next2.getIPoint().y;
            if (i6 < i2) {
                i2 = i6;
            }
            if (i6 > i3) {
                i3 = i6;
            }
            if (i7 < i4) {
                i4 = i7;
            }
            if (i7 > i5) {
                i5 = i7;
            }
        }
        return new dv(i2, i3, i4, i5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x02bc A[SYNTHETIC] */
    @Override // com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void draw(com.autonavi.amap.mapcore.MapConfig r33, float[] r34, float[] r35) {
        /*
        // Method dump skipped, instructions count: 862
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.dw.draw(com.autonavi.amap.mapcore.MapConfig, float[], float[]):void");
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay
    public final MultiPointItem onClick(IPoint iPoint) {
        if (!this.D || this.i == null) {
            return null;
        }
        if (this.t == null) {
            this.t = new dv(0, 1, 0, 1);
        }
        int i2 = (int) (this.c * 8.0f);
        this.t.a(iPoint.x - i2, iPoint.x + i2, iPoint.y - i2, iPoint.y + i2);
        synchronized (this.l) {
            for (int size = this.l.size() - 1; size >= 0; size--) {
                MultiPointItem multiPointItem = this.l.get(size);
                IPoint iPoint2 = multiPointItem.getIPoint();
                if (iPoint2 != null) {
                    if (this.k == null) {
                        return null;
                    }
                    if (this.u == null) {
                        this.u = new dv(0, 1, 0, 1);
                    }
                    this.u.a(iPoint2.x + this.k.a, iPoint2.x + this.k.c, iPoint2.y + this.k.b, iPoint2.y + this.k.d);
                    if (this.u.a(this.t)) {
                        return multiPointItem;
                    }
                }
            }
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay
    public final void setAnchor(float f2, float f3) {
        this.f = f2;
        this.g = f3;
        b();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay
    public final String getId() throws RemoteException {
        if (this.B == null) {
            E++;
            this.B = "MultiPointOverlay" + E;
        }
        return this.B;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay
    public final void remove(boolean z2) {
        dx dxVar;
        this.D = false;
        this.v = 0;
        this.w = 0;
        BitmapDescriptor bitmapDescriptor = this.a;
        if (bitmapDescriptor != null) {
            bitmapDescriptor.recycle();
        }
        synchronized (this) {
            if (this.h != null) {
                this.h.clear();
                this.h = null;
            }
        }
        dy dyVar = this.i;
        if (dyVar != null) {
            dyVar.a();
            this.i = null;
        }
        List<MultiPointItem> list = this.l;
        if (list != null) {
            list.clear();
        }
        ExecutorService executorService = this.F;
        if (executorService != null) {
            executorService.shutdownNow();
            this.F = null;
        }
        List<String> list2 = this.G;
        if (list2 != null) {
            list2.clear();
        }
        List<du> list3 = this.o;
        if (list3 != null) {
            for (du duVar : list3) {
                if (duVar != null) {
                    duVar.c();
                }
            }
            this.o.clear();
        }
        if (z2 && (dxVar = this.n) != null) {
            dxVar.a(this);
            this.n.d();
        }
        this.n = null;
        this.C = null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay
    public final void setVisible(boolean z2) {
        if (this.D != z2) {
            b();
        }
        this.D = z2;
    }

    private void b() {
        dx dxVar = this.n;
        if (dxVar != null) {
            dxVar.d();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay
    public final void destroy(boolean z2) {
        remove(z2);
        BitmapDescriptor bitmapDescriptor = this.b;
        if (bitmapDescriptor != null) {
            bitmapDescriptor.recycle();
        }
    }
}
