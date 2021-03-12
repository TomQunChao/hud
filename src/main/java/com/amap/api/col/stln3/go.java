package com.amap.api.col.stln3;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.support.v7.widget.ActivityChooserView;
import com.amap.api.col.stln3.Cif;
import com.amap.api.col.stln3.gq;
import com.amap.api.col.stln3.hc;
import com.amap.api.col.stln3.ig;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.interfaces.ITileOverlay;
import java.io.File;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: TileOverlayDelegateImp */
public final class go implements gf {
    private static int h = 0;
    gq.f a;
    private db b;
    private TileProvider c;
    private Float d;
    private boolean e;
    private boolean f = false;
    private co g;
    private int i = 256;
    private int j = 256;
    private int k = -1;
    private id l;
    private List<a> m = new ArrayList();
    private boolean n = false;
    private b o = null;
    private String p = null;
    private FloatBuffer q = null;

    static /* synthetic */ ArrayList a(co coVar, int i2, int i3, int i4, int i5, db dbVar, id idVar) {
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z2;
        IPoint iPoint;
        boolean z3;
        int i17;
        GLMapState f2 = coVar.f();
        Rect rect = coVar.getMapConfig().getGeoRectangle().getRect();
        IPoint obtain = IPoint.obtain();
        IPoint obtain2 = IPoint.obtain();
        obtain.x = rect.left;
        obtain.y = rect.top;
        int min = Math.min((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, obtain.x);
        int max = Math.max(0, obtain.x);
        int min2 = Math.min((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, obtain.y);
        int max2 = Math.max(0, obtain.y);
        obtain.x = rect.right;
        obtain.y = rect.top;
        int min3 = Math.min(min, obtain.x);
        int max3 = Math.max(max, obtain.x);
        int min4 = Math.min(min2, obtain.y);
        int max4 = Math.max(max2, obtain.y);
        obtain.x = rect.left;
        obtain.y = rect.bottom;
        int min5 = Math.min(min3, obtain.x);
        int max5 = Math.max(max3, obtain.x);
        int min6 = Math.min(min4, obtain.y);
        int max6 = Math.max(max4, obtain.y);
        obtain.x = rect.right;
        obtain.y = rect.bottom;
        int min7 = Math.min(min5, obtain.x);
        int max7 = Math.max(max5, obtain.x);
        int min8 = Math.min(min6, obtain.y);
        int max8 = Math.max(max6, obtain.y);
        int i18 = 20 - i2;
        int i19 = 1 << i18;
        int i20 = min7 - (i19 * i3);
        f2.getMapGeoCenter(obtain2);
        int i21 = (obtain2.x >> i18) / i3;
        int i22 = (obtain2.y >> i18) / i4;
        int i23 = min8 - (i19 * i4);
        int i24 = max8;
        a aVar = new a(i21, i22, i2, i5, coVar, dbVar, idVar);
        aVar.e = IPoint.obtain((i21 << i18) * i3, (i22 << i18) * i4);
        obtain.recycle();
        obtain2.recycle();
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        int i25 = 1;
        while (true) {
            int i26 = i21 - i25;
            int i27 = i26;
            boolean z4 = false;
            while (true) {
                i6 = i21 + i25;
                if (i27 > i6) {
                    break;
                }
                int i28 = i22 + i25;
                int i29 = (i27 << i18) * i3;
                IPoint iPoint2 = new IPoint(i29, (i28 << i18) * i4);
                if (iPoint2.x >= max7 || iPoint2.x <= i20) {
                    i13 = i26;
                    i12 = i27;
                    i15 = i29;
                    i11 = i23;
                    i16 = i24;
                } else if (iPoint2.y < i24) {
                    if (iPoint2.y > i23) {
                        if (!z4) {
                            z4 = true;
                        }
                        i14 = i21;
                        i13 = i26;
                        i16 = i24;
                        i12 = i27;
                        i15 = i29;
                        i11 = i23;
                        a aVar2 = new a(i27, i28, i2, i5, coVar, dbVar, idVar);
                        aVar2.e = iPoint2;
                        arrayList.add(aVar2);
                        z2 = z4;
                    } else {
                        i14 = i21;
                        i13 = i26;
                        i12 = i27;
                        z2 = z4;
                        i11 = i23;
                        i16 = i24;
                        i15 = i29;
                    }
                    int i30 = i22 - i25;
                    iPoint = new IPoint(i15, (i30 << i18) * i4);
                    if (iPoint.x < max7 || iPoint.x <= i20 || iPoint.y >= i16) {
                        z3 = z2;
                        i17 = i11;
                    } else if (iPoint.y > i11) {
                        if (!z2) {
                            z2 = true;
                        }
                        z3 = z2;
                        i17 = i11;
                        a aVar3 = new a(i12, i30, i2, i5, coVar, dbVar, idVar);
                        aVar3.e = iPoint;
                        arrayList.add(aVar3);
                    } else {
                        z3 = z2;
                        i17 = i11;
                    }
                    z4 = z3;
                    i27 = i12 + 1;
                    i24 = i16;
                    i26 = i13;
                    i23 = i17;
                    i21 = i14;
                } else {
                    i13 = i26;
                    i12 = i27;
                    i16 = i24;
                    i15 = i29;
                    i11 = i23;
                }
                i14 = i21;
                z2 = z4;
                int i302 = i22 - i25;
                iPoint = new IPoint(i15, (i302 << i18) * i4);
                if (iPoint.x < max7) {
                }
                z3 = z2;
                i17 = i11;
                z4 = z3;
                i27 = i12 + 1;
                i24 = i16;
                i26 = i13;
                i23 = i17;
                i21 = i14;
            }
            int i31 = (i22 + i25) - 1;
            while (i31 > i22 - i25) {
                int i32 = (i31 << i18) * i4;
                IPoint iPoint3 = new IPoint((i6 << i18) * i3, i32);
                if (iPoint3.x >= max7 || iPoint3.x <= i20 || iPoint3.y >= i24 || iPoint3.y <= i23) {
                    i9 = i25;
                    i8 = i31;
                    i10 = i32;
                    i7 = i6;
                    z = z4;
                } else {
                    if (!z4) {
                        z4 = true;
                    }
                    z = z4;
                    i9 = i25;
                    i10 = i32;
                    i8 = i31;
                    i7 = i6;
                    a aVar4 = new a(i6, i31, i2, i5, coVar, dbVar, idVar);
                    aVar4.e = iPoint3;
                    arrayList.add(aVar4);
                }
                IPoint iPoint4 = new IPoint((i26 << i18) * i3, i10);
                if (iPoint4.x < max7 && iPoint4.x > i20 && iPoint4.y < i24 && iPoint4.y > i23) {
                    if (!z) {
                        z = true;
                    }
                    a aVar5 = new a(i26, i8, i2, i5, coVar, dbVar, idVar);
                    aVar5.e = iPoint4;
                    arrayList.add(aVar5);
                }
                z4 = z;
                i31 = i8 - 1;
                i25 = i9;
                i6 = i7;
            }
            if (!z4) {
                return arrayList;
            }
            i25++;
            i24 = i24;
            i23 = i23;
            i21 = i21;
        }
    }

    public go(TileOverlayOptions tileOverlayOptions, db dbVar, boolean z) {
        ig.a aVar;
        this.b = dbVar;
        this.c = tileOverlayOptions.getTileProvider();
        this.i = this.c.getTileWidth();
        this.j = this.c.getTileHeight();
        this.q = ic.a(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f});
        this.d = Float.valueOf(tileOverlayOptions.getZIndex());
        this.e = tileOverlayOptions.isVisible();
        this.f = z;
        if (this.f) {
            this.p = "TileOverlay0";
        } else {
            this.p = getId();
        }
        this.g = this.b.a();
        this.k = Integer.parseInt(this.p.substring(11));
        if (z) {
            try {
                aVar = new ig.a(this.b.e(), this.p, dbVar.a().getMapConfig().getMapLanguage());
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        } else {
            aVar = new ig.a(this.b.e(), this.p);
        }
        aVar.f = tileOverlayOptions.getMemoryCacheEnabled();
        if (this.f) {
            aVar.i = false;
        }
        aVar.g = tileOverlayOptions.getDiskCacheEnabled();
        aVar.a = tileOverlayOptions.getMemCacheSize();
        long diskCacheSize = tileOverlayOptions.getDiskCacheSize();
        if (diskCacheSize <= 0) {
            aVar.g = false;
        }
        aVar.b = diskCacheSize;
        String diskCacheDir = tileOverlayOptions.getDiskCacheDir();
        if (diskCacheDir != null && !"".equals(diskCacheDir)) {
            aVar.c = new File(diskCacheDir);
        }
        this.l = new id(this.b.e(), this.i, this.j);
        this.l.a(this.c);
        this.l.a(aVar);
        this.l.a((Cif.c) new Cif.c() {
            /* class com.amap.api.col.stln3.go.AnonymousClass1 */

            @Override // com.amap.api.col.stln3.Cif.c
            public final void a() {
                go.this.g.w();
            }
        });
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public final void remove() {
        this.b.a(this);
        this.g.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public final void destroy(boolean z) {
        d();
        synchronized (this.m) {
            int size = this.m.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.m.get(i2).a();
            }
            this.m.clear();
        }
        id idVar = this.l;
        if (idVar != null) {
            idVar.c(z);
            this.l.a(true);
            this.l.a((TileProvider) null);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public final void clearTileCache() {
        id idVar = this.l;
        if (idVar != null) {
            idVar.f();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public final String getId() {
        if (this.p == null) {
            h++;
            this.p = "TileOverlay" + h;
        }
        return this.p;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public final void setZIndex(float f2) {
        this.d = Float.valueOf(f2);
        this.b.d();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public final float getZIndex() {
        return this.d.floatValue();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public final void setVisible(boolean z) {
        this.e = z;
        this.g.setRunLowFrame(false);
        if (z) {
            a(true);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public final boolean isVisible() {
        return this.e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public final boolean equalsRemote(ITileOverlay iTileOverlay) {
        if (equals(iTileOverlay) || iTileOverlay.getId().equals(getId())) {
            return true;
        }
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public final int hashCodeRemote() {
        return super.hashCode();
    }

    @Override // com.amap.api.col.stln3.gf
    public final void a() {
        List<a> list = this.m;
        if (list != null) {
            synchronized (list) {
                if (this.m.size() != 0) {
                    int size = this.m.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        a aVar = this.m.get(i2);
                        if (!aVar.g) {
                            try {
                                IPoint iPoint = aVar.e;
                                if (!(aVar.i == null || aVar.i.isRecycled() || iPoint == null)) {
                                    aVar.f = ic.a(aVar.i);
                                    if (aVar.f != 0) {
                                        aVar.g = true;
                                    }
                                    aVar.i = null;
                                }
                            } catch (Throwable th) {
                                rx.c(th, "TileOverlayDelegateImp", "drawTiles");
                            }
                        }
                        if (aVar.g) {
                            int i3 = this.i;
                            int i4 = this.j;
                            int i5 = aVar.e.x;
                            int i6 = 1 << (20 - ((int) ((float) aVar.c)));
                            int i7 = i4 * i6;
                            int i8 = aVar.e.y + i7;
                            MapConfig mapConfig = this.g.getMapConfig();
                            int i9 = (i6 * i3) + i5;
                            int i10 = i8 - i7;
                            float[] fArr = {(float) (i5 - mapConfig.getSX()), (float) (i8 - mapConfig.getSY()), 0.0f, (float) (i9 - mapConfig.getSX()), (float) (i8 - mapConfig.getSY()), 0.0f, (float) (i9 - mapConfig.getSX()), (float) (i10 - mapConfig.getSY()), 0.0f, (float) (i5 - mapConfig.getSX()), (float) (i10 - mapConfig.getSY()), 0.0f};
                            aVar.h = aVar.h == null ? ic.a(fArr) : ic.a(fArr, aVar.h);
                            int i11 = aVar.f;
                            FloatBuffer floatBuffer = aVar.h;
                            FloatBuffer floatBuffer2 = this.q;
                            if (!(floatBuffer == null || floatBuffer2 == null || i11 == 0)) {
                                if (!(!(this.a == null || this.a.b()) || this.b == null || this.b.a() == null)) {
                                    this.a = (gq.f) this.b.a().k(0);
                                }
                                GLES20.glUseProgram(this.a.d);
                                GLES20.glEnable(3042);
                                GLES20.glBlendFunc(1, 771);
                                GLES20.glBlendColor(1.0f, 1.0f, 1.0f, 1.0f);
                                GLES20.glActiveTexture(33984);
                                GLES20.glBindTexture(3553, i11);
                                GLES20.glEnableVertexAttribArray(this.a.b);
                                GLES20.glVertexAttribPointer(this.a.b, 3, 5126, false, 12, (Buffer) floatBuffer);
                                GLES20.glEnableVertexAttribArray(this.a.c);
                                GLES20.glVertexAttribPointer(this.a.c, 2, 5126, false, 8, (Buffer) floatBuffer2);
                                GLES20.glUniformMatrix4fv(this.a.a, 1, false, this.b.f(), 0);
                                GLES20.glDrawArrays(6, 0, 4);
                                GLES20.glDisableVertexAttribArray(this.a.b);
                                GLES20.glDisableVertexAttribArray(this.a.c);
                                GLES20.glBindTexture(3553, 0);
                                GLES20.glUseProgram(0);
                                GLES20.glDisable(3042);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void b() {
        List<a> list = this.m;
        if (list != null) {
            synchronized (list) {
                this.m.clear();
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean b(co coVar, List<a> list, int i2, boolean z, List<a> list2, boolean z2, db dbVar, id idVar) {
        int size;
        if (list == null || list2 == null) {
            return false;
        }
        synchronized (list2) {
            Iterator<a> it = list2.iterator();
            while (true) {
                boolean z3 = true;
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                Iterator<a> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z3 = false;
                        break;
                    }
                    a next2 = it2.next();
                    if (next.equals(next2) && next.g) {
                        next2.g = next.g;
                        next2.f = next.f;
                        break;
                    }
                }
                if (!z3) {
                    next.a();
                }
            }
            list2.clear();
        }
        if (i2 > ((int) coVar.getMaxZoomLevel()) || i2 < ((int) coVar.getMinZoomLevel()) || (size = list.size()) <= 0) {
            return false;
        }
        for (int i3 = 0; i3 < size; i3++) {
            a aVar = list.get(i3);
            if (aVar != null) {
                if (z2) {
                    if (dbVar.a().getMapConfig().getMapLanguage().equals("zh_cn")) {
                        if (MapsInitializer.isLoadWorldGridMap()) {
                            if (aVar.c >= 7) {
                                if (hv.a(aVar.a, aVar.b, aVar.c)) {
                                }
                            }
                        }
                    } else if (!MapsInitializer.isLoadWorldGridMap() && aVar.c >= 7 && !hv.a(aVar.a, aVar.b, aVar.c)) {
                    }
                }
                list2.add(aVar);
                if (!aVar.g && idVar != null) {
                    idVar.a(z, aVar);
                }
            }
        }
        return true;
    }

    @Override // com.amap.api.col.stln3.gf
    public final void a(boolean z) {
        if (!this.n) {
            d();
            c(z);
        }
    }

    private void d() {
        b bVar = this.o;
        if (bVar != null && bVar.a() == hc.e.RUNNING) {
            this.o.d();
        }
    }

    private void c(boolean z) {
        this.o = new b(z, this.g, this.i, this.j, this.k, this.m, this.f, this.b, this.l);
        this.o.b((Object[]) new Void[0]);
    }

    public final void c() {
        d();
        synchronized (this.m) {
            int size = this.m.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.m.get(i2).a();
            }
            this.m.clear();
        }
    }

    @Override // com.amap.api.col.stln3.gf
    public final void b(boolean z) {
        if (this.n != z) {
            this.n = z;
            id idVar = this.l;
            if (idVar != null) {
                idVar.a(z);
            }
        }
    }

    public final void a(String str) {
        d();
        b();
        id idVar = this.l;
        if (idVar != null) {
            idVar.a(true);
            this.l.a(str);
            this.l.a(false);
        }
        c(true);
    }

    /* access modifiers changed from: private */
    /* compiled from: TileOverlayDelegateImp */
    public static class b extends hc<Void, Void, List<a>> {
        private int d;
        private boolean e;
        private int f = 256;
        private int g = 256;
        private int h = 0;
        private WeakReference<co> i;
        private List<a> j;
        private boolean k;
        private WeakReference<db> l;
        private WeakReference<id> m;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // com.amap.api.col.stln3.hc
        public final /* synthetic */ List<a> a(Void[] voidArr) {
            return e();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // com.amap.api.col.stln3.hc
        public final /* synthetic */ void a(List<a> list) {
            List<a> list2 = list;
            if (list2 != null) {
                try {
                    if (list2.size() > 0) {
                        go.b(this.i.get(), list2, this.d, this.e, this.j, this.k, this.l.get(), this.m.get());
                        list2.clear();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public b(boolean z, co coVar, int i2, int i3, int i4, List<a> list, boolean z2, db dbVar, id idVar) {
            this.e = z;
            this.i = new WeakReference<>(coVar);
            this.f = i2;
            this.g = i3;
            this.h = i4;
            this.j = list;
            this.k = z2;
            this.l = new WeakReference<>(dbVar);
            this.m = new WeakReference<>(idVar);
        }

        private List<a> e() {
            try {
                co coVar = this.i.get();
                if (coVar == null) {
                    return null;
                }
                int mapWidth = coVar.getMapWidth();
                int mapHeight = coVar.getMapHeight();
                this.d = (int) coVar.j();
                if (mapWidth > 0) {
                    if (mapHeight > 0) {
                        return go.a(coVar, this.d, this.f, this.g, this.h, this.l.get(), this.m.get());
                    }
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
    }

    /* compiled from: TileOverlayDelegateImp */
    public static class a implements Cloneable {
        public int a;
        public int b;
        public int c;
        public int d;
        public IPoint e;
        public int f = 0;
        public boolean g = false;
        public FloatBuffer h = null;
        public Bitmap i = null;
        public Cif.a j = null;
        public int k = 0;
        private co l;
        private db m;
        private id n;

        public a(int i2, int i3, int i4, int i5, co coVar, db dbVar, id idVar) {
            this.a = i2;
            this.b = i3;
            this.c = i4;
            this.d = i5;
            this.l = coVar;
            this.m = dbVar;
            this.n = idVar;
        }

        private a(a aVar) {
            this.a = aVar.a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.h = aVar.h;
            this.k = 0;
            this.m = aVar.m;
            this.l = aVar.l;
            this.n = aVar.n;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public a clone() {
            try {
                a aVar = (a) super.clone();
                aVar.a = this.a;
                aVar.b = this.b;
                aVar.c = this.c;
                aVar.d = this.d;
                aVar.e = (IPoint) this.e.clone();
                aVar.h = this.h.asReadOnlyBuffer();
                this.k = 0;
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
            }
            return new a(this);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (this.a * 7) + (this.b * 11) + (this.c * 13) + this.d;
        }

        public final String toString() {
            return this.a + "-" + this.b + "-" + this.c + "-" + this.d;
        }

        public final synchronized void a(Bitmap bitmap) {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    try {
                        this.j = null;
                        this.i = bitmap;
                        this.l.setRunLowFrame(false);
                    } catch (Throwable th) {
                        rx.c(th, "TileOverlayDelegateImp", "setBitmap");
                        th.printStackTrace();
                        if (this.k < 3) {
                            this.k++;
                            if (this.n != null) {
                                this.n.a(true, this);
                            }
                        }
                    }
                    return;
                }
            }
            if (this.k < 3) {
                this.k++;
                if (this.n != null) {
                    this.n.a(true, this);
                }
            }
        }

        public final void a() {
            try {
                Cif.a(this);
                if (this.g) {
                    this.m.a(this.f);
                }
                this.g = false;
                this.f = 0;
                if (this.i != null && !this.i.isRecycled()) {
                    this.i.recycle();
                }
                this.i = null;
                if (this.h != null) {
                    this.h.clear();
                }
                this.h = null;
                this.j = null;
                this.k = 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
