package com.amap.api.col.stln3;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import android.view.MotionEvent;
import com.amap.api.col.stln3.gq;
import com.amap.api.col.stln3.ih;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.interfaces.IMarker;
import java.io.Serializable;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: MapOverlayImageView */
public final class cu {
    co a;
    float[] b = new float[180000];
    public gq.d c;
    int d = 0;
    int e = 0;
    private List<ga> f = new ArrayList(500);
    private List<cx> g = new ArrayList();
    private List<ga> h = new ArrayList();
    private a i = new a();
    private boolean j = true;
    private IPoint k;
    private cg l;
    private fx m;
    private ih n;
    private hr o;
    private FloatBuffer p;
    private HandlerThread q;
    private Handler r;
    private int[] s = new int[1];
    private Runnable t = new Runnable() {
        /* class com.amap.api.col.stln3.cu.AnonymousClass2 */

        public final void run() {
            synchronized (cu.this.f) {
                cu.b(cu.this);
            }
        }
    };

    static /* synthetic */ void b(cu cuVar) {
        try {
            Collections.sort(cuVar.f, cuVar.i);
        } catch (Throwable th) {
            rx.c(th, "MapOverlayImageView", "changeOverlayIndex");
        }
    }

    public cu(co coVar) {
        this.a = coVar;
        this.n = new ih();
        this.o = new hr();
        this.q = new HandlerThread("AMapZindexSortThread");
        this.q.start();
        this.r = new Handler(this.q.getLooper());
    }

    public final Marker a(MarkerOptions markerOptions) throws RemoteException {
        Marker marker;
        if (markerOptions == null) {
            return null;
        }
        gg ggVar = new gg(markerOptions, this);
        synchronized (this.f) {
            d(ggVar);
            hn.a(this.f.size());
            marker = new Marker(ggVar);
        }
        return marker;
    }

    public final ArrayList<Marker> a(ArrayList<MarkerOptions> arrayList, boolean z) throws RemoteException {
        MarkerOptions markerOptions;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<Marker> arrayList2 = new ArrayList<>();
        try {
            if (arrayList.size() != 1 || (markerOptions = arrayList.get(0)) == null) {
                final LatLngBounds.Builder builder = LatLngBounds.builder();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    MarkerOptions markerOptions2 = arrayList.get(i2);
                    if (arrayList.get(i2) != null) {
                        arrayList2.add(a(markerOptions2));
                        if (markerOptions2.getPosition() != null) {
                            builder.include(markerOptions2.getPosition());
                        }
                    }
                }
                if (z && arrayList2.size() > 0) {
                    this.a.getMainHandler().postDelayed(new Runnable() {
                        /* class com.amap.api.col.stln3.cu.AnonymousClass1 */

                        public final void run() {
                            try {
                                cu.this.a.a(dh.a(builder.build(), 50));
                            } catch (Throwable th) {
                            }
                        }
                    }, 50);
                }
            } else {
                arrayList2.add(a(markerOptions));
                if (z && markerOptions.getPosition() != null) {
                    this.a.a(dh.a(markerOptions.getPosition(), 18.0f));
                }
            }
            return arrayList2;
        } catch (Throwable th) {
            rx.c(th, "AMapDelegateImpGLSurfaceView", "addMarkers");
            th.printStackTrace();
            return arrayList2;
        }
    }

    public final Text a(TextOptions textOptions) throws RemoteException {
        Text text;
        if (textOptions == null) {
            return null;
        }
        synchronized (this.f) {
            gn gnVar = new gn(textOptions, this);
            d(gnVar);
            text = new Text(gnVar);
        }
        return text;
    }

    private void d(ga gaVar) {
        try {
            this.f.add(gaVar);
            f();
        } catch (Throwable th) {
            rx.c(th, "MapOverlayImageView", "addMarker");
        }
    }

    public final boolean a(ga gaVar) {
        boolean remove;
        synchronized (this.f) {
            try {
                if (this.m != null && this.m.getId().equals(gaVar.getId())) {
                    this.m = null;
                }
                b(gaVar);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            remove = this.f.remove(gaVar);
        }
        return remove;
    }

    public final void a(fx fxVar) {
        try {
            if (this.m != null) {
                if (fxVar == null || !fxVar.getId().equals(this.m.getId())) {
                    this.m.b(false);
                } else {
                    return;
                }
            }
            if (this.f.contains(fxVar)) {
                if (fxVar != null) {
                    fxVar.b(true);
                }
                this.m = fxVar;
            }
        } catch (Throwable th) {
            rx.c(th, "MapOverlayImageView", "set2Top");
        }
    }

    public final void a() {
        this.m = null;
    }

    public final void a(cg cgVar) {
        if (this.k == null) {
            this.k = IPoint.obtain();
        }
        Rect i2 = cgVar.i();
        this.k = IPoint.obtain(i2.left + (i2.width() / 2), i2.top);
        this.l = cgVar;
        try {
            this.a.a(this.l);
        } catch (Throwable th) {
            rx.c(th, "MapOverlayImageView", "showInfoWindow");
            th.printStackTrace();
        }
    }

    public final void b(ga gaVar) {
        try {
            if (gaVar.isInfoWindowShown()) {
                this.a.l();
                this.l = null;
            } else if (this.l != null && this.l.getId().equals(gaVar.getId())) {
                this.l = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void b() {
        try {
            if (this.a != null) {
                float mapPerPixelUnitLength = this.a.getMapConfig().getMapPerPixelUnitLength();
                synchronized (this.f) {
                    synchronized (this.g) {
                        int h2 = this.a.h();
                        for (int i2 = 0; i2 < this.g.size(); i2++) {
                            cx cxVar = this.g.get(i2);
                            if (cxVar != null) {
                                cxVar.h();
                                if (cxVar.i() <= 0) {
                                    if (cxVar.f() == h2) {
                                        this.n.a(cxVar.j());
                                    } else {
                                        this.s[0] = cxVar.f();
                                        GLES20.glDeleteTextures(1, this.s, 0);
                                    }
                                    if (this.a != null) {
                                        this.a.c(cxVar.j());
                                    }
                                }
                            }
                        }
                        this.g.clear();
                    }
                    if (this.f.size() != 0) {
                        this.h.clear();
                        int size = this.f.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            ga gaVar = this.f.get(i3);
                            if (gaVar.isVisible() && !gaVar.l()) {
                                this.j = gaVar.j();
                                if (gaVar.h() || gaVar.isInfoWindowShown()) {
                                    try {
                                        this.h.add(gaVar);
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                            }
                        }
                        if (this.m != null && this.m.isVisible()) {
                            this.h.add(this.m);
                        }
                        if (this.h.size() > 0) {
                            int size2 = this.h.size();
                            int i4 = 0;
                            int i5 = 0;
                            int i6 = 0;
                            int i7 = 0;
                            for (int i8 = 0; i8 < size2; i8++) {
                                ga gaVar2 = this.h.get(i8);
                                synchronized (gaVar2) {
                                    gaVar2.a(this.a);
                                    if (i8 == 0) {
                                        i5 = gaVar2.k();
                                    } else {
                                        int k2 = gaVar2.k();
                                        if (k2 != i5) {
                                            a(i5, i4, i6, i7);
                                            i5 = k2;
                                            i4 = 0;
                                            i6 = 0;
                                            i7 = 0;
                                        }
                                    }
                                    gaVar2.a(this.a, this.b, i7, mapPerPixelUnitLength);
                                    int k3 = gaVar2.k();
                                    if (k3 != i5) {
                                        a(i5, i4, i6, i7);
                                        i6 = i7;
                                        i5 = k3;
                                        i4 = 0;
                                        i7 = 0;
                                    }
                                    i7 += 36;
                                    i4++;
                                    if (i4 == 5000) {
                                        a(i5, i4, i6, i7);
                                        i4 = 0;
                                        i6 = 0;
                                        i7 = 0;
                                    }
                                }
                            }
                            if (i4 > 0) {
                                a(i5, i4, i6, i7);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void a(int i2, int i3, int i4, int i5) {
        co coVar;
        if (!(i3 == 0 || i2 == 0)) {
            this.p = this.o.a(i3 * 36);
            this.p.put(this.b, i4, i5);
            this.p.flip();
            int i6 = i3 > 5000 ? 5000 : i3;
            if (this.d == 0) {
                int[] iArr = new int[2];
                GLES20.glGenBuffers(2, iArr, 0);
                this.d = iArr[0];
                this.e = iArr[1];
                ShortBuffer b2 = this.o.b();
                short[] sArr = new short[30000];
                int i7 = 0;
                for (int i8 = 5000; i7 < i8; i8 = 5000) {
                    int i9 = i7 * 6;
                    int i10 = i7 * 4;
                    short s2 = (short) (i10 + 0);
                    sArr[i9 + 0] = s2;
                    sArr[i9 + 1] = (short) (i10 + 1);
                    short s3 = (short) (i10 + 2);
                    sArr[i9 + 2] = s3;
                    sArr[i9 + 3] = s2;
                    sArr[i9 + 4] = s3;
                    sArr[i9 + 5] = (short) (i10 + 3);
                    i7++;
                }
                b2.put(sArr);
                b2.flip();
                GLES20.glBindBuffer(34963, this.e);
                GLES20.glBufferData(34963, 60000, b2, 35044);
            }
            GLES20.glBindBuffer(34962, this.d);
            GLES20.glBufferData(34962, i6 * 36 * 4, this.p, 35044);
            FloatBuffer floatBuffer = this.p;
            MapConfig mapConfig = this.a.getMapConfig();
            if (!(i2 == 0 || floatBuffer == null || i3 == 0)) {
                gq.d dVar = this.c;
                if ((dVar == null || dVar.b()) && this.c == null && (coVar = this.a) != null) {
                    this.c = (gq.d) coVar.k(1);
                }
                GLES20.glUseProgram(this.c.d);
                GLES20.glUniform1f(this.c.h, mapConfig.getSR());
                GLES20.glEnableVertexAttribArray(this.c.b);
                GLES20.glBindBuffer(34962, this.d);
                GLES20.glVertexAttribPointer(this.c.b, 4, 5126, false, 36, 0);
                GLES20.glEnable(3042);
                GLES20.glBlendFunc(1, 771);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, i2);
                GLES20.glEnableVertexAttribArray(this.c.c);
                GLES20.glBindBuffer(34962, this.d);
                GLES20.glVertexAttribPointer(this.c.c, 2, 5126, false, 36, 16);
                GLES20.glEnableVertexAttribArray(this.c.g);
                GLES20.glBindBuffer(34962, this.d);
                GLES20.glVertexAttribPointer(this.c.g, 3, 5126, false, 36, 24);
                int i11 = this.c.a;
                co coVar2 = this.a;
                GLES20.glUniformMatrix4fv(i11, 1, false, coVar2 != null ? coVar2.A() : new float[16], 0);
                GLES20.glBindBuffer(34963, this.e);
                GLES20.glDrawElements(4, i3 * 6, 5123, 0);
                GLES20.glBindBuffer(34962, 0);
                GLES20.glBindBuffer(34963, 0);
                GLES20.glBindTexture(3553, 0);
                GLES20.glDisableVertexAttribArray(this.c.b);
                GLES20.glDisableVertexAttribArray(this.c.c);
                GLES20.glDisable(3042);
                GLES20.glUseProgram(0);
            }
            this.o.a();
        }
    }

    public final synchronized boolean a(Bitmap bitmap, cx cxVar) {
        ih.c a2 = this.n.a(bitmap.getWidth() + 1, bitmap.getHeight() + 1, cxVar.j());
        if (a2 == null) {
            return false;
        }
        cxVar.b(((float) a2.a) / ((float) this.n.a()));
        cxVar.a(((float) a2.b) / ((float) this.n.b()));
        cxVar.c(((float) ((a2.a + a2.c) - 1)) / ((float) this.n.a()));
        cxVar.d(((float) ((a2.b + a2.d) - 1)) / ((float) this.n.b()));
        return true;
    }

    public final co c() {
        return this.a;
    }

    public final cg d() {
        return this.l;
    }

    public final cg a(MotionEvent motionEvent) {
        synchronized (this.f) {
            for (int size = this.f.size() - 1; size >= 0; size--) {
                ga gaVar = this.f.get(size);
                if ((gaVar instanceof gg) && ic.a(gaVar.i(), (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.l = (gg) gaVar;
                    return this.l;
                }
            }
            return null;
        }
    }

    public final boolean b(MotionEvent motionEvent) throws RemoteException {
        boolean z;
        synchronized (this.f) {
            z = false;
            int size = this.f.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                ga gaVar = this.f.get(size);
                if (gaVar instanceof gg) {
                    if (gaVar.isVisible() && ((gg) gaVar).isClickable()) {
                        Rect i2 = gaVar.i();
                        boolean a2 = ic.a(i2, (int) motionEvent.getX(), (int) motionEvent.getY());
                        if (a2) {
                            this.k = IPoint.obtain(i2.left + (i2.width() / 2), i2.top);
                            this.l = (gg) gaVar;
                            z = a2;
                            break;
                        }
                    }
                }
                size--;
            }
        }
        return z;
    }

    public final List<Marker> e() {
        ArrayList arrayList;
        synchronized (this.f) {
            arrayList = new ArrayList();
            try {
                for (ga gaVar : this.f) {
                    if ((gaVar instanceof gg) && gaVar.h()) {
                        arrayList.add(new Marker((IMarker) gaVar));
                    }
                }
            } catch (Throwable th) {
                rx.c(th, "MapOverlayImageView", "getMapScreenMarkers");
                th.printStackTrace();
            }
        }
        return arrayList;
    }

    public final void f() {
        Handler handler = this.r;
        if (handler != null) {
            handler.removeCallbacks(this.t);
            this.r.postDelayed(this.t, 10);
        }
    }

    public final boolean c(ga gaVar) {
        boolean contains;
        synchronized (this.f) {
            contains = this.f.contains(gaVar);
        }
        return contains;
    }

    /* access modifiers changed from: protected */
    public final int g() {
        int size;
        synchronized (this.f) {
            size = this.f.size();
        }
        return size;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0025 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 168
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.cu.a(java.lang.String):void");
    }

    public final void a(cx cxVar) {
        synchronized (this.g) {
            if (cxVar != null) {
                this.g.add(cxVar);
            }
        }
    }

    public final void h() {
        try {
            for (ga gaVar : this.f) {
                if (gaVar != null) {
                    gaVar.destroy(false);
                }
            }
            a((String) null);
            if (this.q != null) {
                this.q.quit();
            }
            this.r = null;
            this.a = null;
        } catch (Throwable th) {
            rx.c(th, "MapOverlayImageView", "destroy");
            th.printStackTrace();
            String str = "MapOverlayImageView clear erro" + th.getMessage();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: MapOverlayImageView */
    public static class a implements Serializable, Comparator<Object> {
        a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            ga gaVar = (ga) obj;
            ga gaVar2 = (ga) obj2;
            if (gaVar == null || gaVar2 == null) {
                return 0;
            }
            try {
                return Float.compare(gaVar.getZIndex(), gaVar2.getZIndex());
            } catch (Throwable th) {
                rx.c(th, "MapOverlayImageView", "compare");
                th.printStackTrace();
                return 0;
            }
        }
    }
}
