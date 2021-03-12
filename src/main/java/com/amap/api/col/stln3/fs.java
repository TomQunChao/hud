package com.amap.api.col.stln3;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.amap.api.col.stln3.gq;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.track.ErrorCode;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GroundOverlayDelegateImp */
public final class fs implements fw {
    float[] a;
    gq.c b;
    private co c;
    private BitmapDescriptor d;
    private LatLng e;
    private float f;
    private float g;
    private LatLngBounds h;
    private float i;
    private float j;
    private boolean k;
    private float l;
    private float m;
    private float n;
    private float o;
    private String p;
    private FloatBuffer q;
    private FloatBuffer r;
    private int s;
    private boolean t;
    private boolean u;
    private List<cx> v;
    private cm w;

    public fs(co coVar, cm cmVar) {
        this(coVar);
        this.w = cmVar;
    }

    private fs(co coVar) {
        this.k = true;
        this.l = 0.0f;
        this.m = 1.0f;
        this.n = 0.5f;
        this.o = 0.5f;
        this.q = null;
        this.t = false;
        this.u = false;
        this.v = new ArrayList();
        this.a = null;
        this.c = coVar;
        try {
            this.p = getId();
        } catch (RemoteException e2) {
            rx.c(e2, "GroundOverlayDelegateImp", "create");
            e2.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void remove() throws RemoteException {
        this.c.a(getId());
        this.c.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final String getId() throws RemoteException {
        if (this.p == null) {
            this.p = this.c.d("GroundOverlay");
        }
        return this.p;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void setZIndex(float f2) throws RemoteException {
        this.j = f2;
        this.c.i();
        this.c.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final float getZIndex() throws RemoteException {
        return this.j;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void setVisible(boolean z) throws RemoteException {
        this.k = z;
        this.c.setRunLowFrame(false);
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
        return super.hashCode();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        if (r2.h != null) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
        d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0009, code lost:
        r2.u = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000d, code lost:
        if (r2.e != null) goto L_0x0013;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        e();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c() throws android.os.RemoteException {
        /*
            r2 = this;
            monitor-enter(r2)
            float[] r0 = r2.a     // Catch:{ all -> 0x0020 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r2)     // Catch:{ all -> 0x0020 }
            return r1
        L_0x0008:
            monitor-exit(r2)
            r2.u = r1
            com.amap.api.maps.model.LatLng r0 = r2.e
            if (r0 != 0) goto L_0x0013
            r2.e()
            goto L_0x001e
        L_0x0013:
            com.amap.api.maps.model.LatLngBounds r0 = r2.h
            if (r0 != 0) goto L_0x001b
            r2.d()
            goto L_0x001e
        L_0x001b:
            r2.f()
        L_0x001e:
            r0 = 1
            return r0
        L_0x0020:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.fs.c():boolean");
    }

    private void d() {
        LatLng latLng = this.e;
        if (latLng != null) {
            double cos = ((double) this.f) / ((Math.cos(latLng.latitude * 0.01745329251994329d) * 6371000.79d) * 0.01745329251994329d);
            double d2 = ((double) this.g) / 111194.94043265979d;
            try {
                this.h = new LatLngBounds(new LatLng(this.e.latitude - (((double) (1.0f - this.o)) * d2), this.e.longitude - (((double) this.n) * cos)), new LatLng(this.e.latitude + (((double) this.o) * d2), this.e.longitude + (((double) (1.0f - this.n)) * cos)));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            f();
        }
    }

    private synchronized void e() {
        if (this.h != null) {
            LatLng latLng = this.h.southwest;
            LatLng latLng2 = this.h.northeast;
            this.e = new LatLng(latLng.latitude + (((double) (1.0f - this.o)) * (latLng2.latitude - latLng.latitude)), latLng.longitude + (((double) this.n) * (latLng2.longitude - latLng.longitude)));
            this.f = (float) (Math.cos(this.e.latitude * 0.01745329251994329d) * 6371000.79d * (latLng2.longitude - latLng.longitude) * 0.01745329251994329d);
            this.g = (float) ((latLng2.latitude - latLng.latitude) * 6371000.79d * 0.01745329251994329d);
            f();
        }
    }

    private synchronized void f() {
        if (this.h != null) {
            this.a = new float[16];
            IPoint obtain = IPoint.obtain();
            IPoint obtain2 = IPoint.obtain();
            IPoint obtain3 = IPoint.obtain();
            IPoint obtain4 = IPoint.obtain();
            GLMapState.lonlat2Geo(this.h.southwest.longitude, this.h.southwest.latitude, obtain);
            GLMapState.lonlat2Geo(this.h.northeast.longitude, this.h.southwest.latitude, obtain2);
            GLMapState.lonlat2Geo(this.h.northeast.longitude, this.h.northeast.latitude, obtain3);
            GLMapState.lonlat2Geo(this.h.southwest.longitude, this.h.northeast.latitude, obtain4);
            if (this.i != 0.0f) {
                double d2 = (double) (obtain2.x - obtain.x);
                double d3 = (double) (obtain2.y - obtain3.y);
                DPoint obtain5 = DPoint.obtain();
                obtain5.x = ((double) obtain.x) + (((double) this.n) * d2);
                obtain5.y = ((double) obtain.y) - (((double) (1.0f - this.o)) * d3);
                a(obtain5, 0.0d, 0.0d, d2, d3, obtain);
                a(obtain5, d2, 0.0d, d2, d3, obtain2);
                a(obtain5, d2, d3, d2, d3, obtain3);
                a(obtain5, 0.0d, d3, d2, d3, obtain4);
                obtain5.recycle();
            }
            this.a[0] = (float) (obtain.x / ErrorCode.Response.SUCCESS);
            this.a[1] = (float) (obtain.y / ErrorCode.Response.SUCCESS);
            this.a[2] = (float) (obtain.x % ErrorCode.Response.SUCCESS);
            this.a[3] = (float) (obtain.y % ErrorCode.Response.SUCCESS);
            this.a[4] = (float) (obtain2.x / ErrorCode.Response.SUCCESS);
            this.a[5] = (float) (obtain2.y / ErrorCode.Response.SUCCESS);
            this.a[6] = (float) (obtain2.x % ErrorCode.Response.SUCCESS);
            this.a[7] = (float) (obtain2.y % ErrorCode.Response.SUCCESS);
            this.a[8] = (float) (obtain3.x / ErrorCode.Response.SUCCESS);
            this.a[9] = (float) (obtain3.y / ErrorCode.Response.SUCCESS);
            this.a[10] = (float) (obtain3.x % ErrorCode.Response.SUCCESS);
            this.a[11] = (float) (obtain3.y % ErrorCode.Response.SUCCESS);
            this.a[12] = (float) (obtain4.x / ErrorCode.Response.SUCCESS);
            this.a[13] = (float) (obtain4.y / ErrorCode.Response.SUCCESS);
            this.a[14] = (float) (obtain4.x % ErrorCode.Response.SUCCESS);
            this.a[15] = (float) (obtain4.y % ErrorCode.Response.SUCCESS);
            if (this.q == null) {
                this.q = ic.a(this.a);
            } else {
                this.q = ic.a(this.a, this.q);
            }
            obtain4.recycle();
            obtain.recycle();
            obtain2.recycle();
            obtain3.recycle();
        }
    }

    private void a(DPoint dPoint, double d2, double d3, double d4, double d5, IPoint iPoint) {
        double d6 = d2 - (d4 * ((double) this.n));
        double d7 = (d5 * ((double) (1.0f - this.o))) - d3;
        double d8 = ((double) (-this.i)) * 0.01745329251994329d;
        iPoint.x = (int) (dPoint.x + (Math.cos(d8) * d6) + (Math.sin(d8) * d7));
        iPoint.y = (int) (dPoint.y + ((d7 * Math.cos(d8)) - (d6 * Math.sin(d8))));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x001e, code lost:
        c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0023, code lost:
        if (r18.t != false) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0029, code lost:
        if (android.os.Build.VERSION.SDK_INT < 12) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002b, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002d, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x002e, code lost:
        r4 = r18.d;
        r5 = r18.v;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0032, code lost:
        if (r5 == null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0034, code lost:
        r5 = r5.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003c, code lost:
        if (r5.hasNext() == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x003e, code lost:
        r6 = r5.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0044, code lost:
        if (r6 == null) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0046, code lost:
        r7 = r18.w;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0048, code lost:
        if (r7 == null) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004a, code lost:
        r7.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x004f, code lost:
        r18.v.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0055, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0056, code lost:
        if (r0 == false) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0058, code lost:
        r5 = r18.w.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x005e, code lost:
        if (r5 == null) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0060, code lost:
        r0 = r5.f();
        a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0068, code lost:
        if (r5 != null) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x006a, code lost:
        r5 = new com.amap.api.col.stln3.cx(r4, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0070, code lost:
        r4 = r4.getBitmap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0074, code lost:
        if (r4 == null) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x007a, code lost:
        if (r4.isRecycled() != false) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x007c, code lost:
        r6 = new int[]{0};
        android.opengl.GLES20.glGenTextures(1, r6, 0);
        r6 = r6[0];
        r5.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0088, code lost:
        if (r0 == false) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x008a, code lost:
        r18.c.a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0090, code lost:
        a(r5);
        com.amap.api.col.stln3.ic.a(r6, r4, true);
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0098, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0099, code lost:
        r18.s = r0;
        r18.t = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a4, code lost:
        if (r18.f != 0.0f) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00aa, code lost:
        if (r18.g != 0.0f) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ac, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ae, code lost:
        monitor-enter(r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        r0 = r18.s;
        r9 = r18.q;
        r15 = r18.r;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00b5, code lost:
        if (r9 == null) goto L_0x01aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00b7, code lost:
        if (r15 != null) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00bd, code lost:
        if (r18.b == null) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00c5, code lost:
        if (r18.b.b() == false) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00c9, code lost:
        if (r18.c == null) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00cb, code lost:
        r18.b = (com.amap.api.col.stln3.gq.c) r18.c.k(2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00d6, code lost:
        android.opengl.GLES20.glUseProgram(r18.b.d);
        android.opengl.GLES20.glEnable(3042);
        android.opengl.GLES20.glBlendFunc(1, 771);
        android.opengl.GLES20.glBlendColor(r18.m * 1.0f, r18.m * 1.0f, r18.m * 1.0f, r18.m);
        android.opengl.GLES20.glActiveTexture(33984);
        android.opengl.GLES20.glBindTexture(3553, r0);
        android.opengl.GLES20.glEnableVertexAttribArray(r18.b.b);
        android.opengl.GLES20.glVertexAttribPointer(r18.b.b, 4, 5126, false, 16, (java.nio.Buffer) r9);
        android.opengl.GLES20.glEnableVertexAttribArray(r18.b.c);
        android.opengl.GLES20.glVertexAttribPointer(r18.b.c, 2, 5126, false, 8, (java.nio.Buffer) r15);
        android.opengl.GLES20.glUniform4f(r18.b.g, (float) (r18.c.getMapConfig().getSX() / com.amap.api.track.ErrorCode.Response.SUCCESS), (float) (r18.c.getMapConfig().getSY() / com.amap.api.track.ErrorCode.Response.SUCCESS), (float) (r18.c.getMapConfig().getSX() % com.amap.api.track.ErrorCode.Response.SUCCESS), (float) (r18.c.getMapConfig().getSY() % com.amap.api.track.ErrorCode.Response.SUCCESS));
        android.opengl.GLES20.glUniform4f(r18.b.h, r18.m * 1.0f, r18.m * 1.0f, r18.m * 1.0f, r18.m);
        android.opengl.GLES20.glUniformMatrix4fv(r18.b.a, 1, false, r18.c.A(), 0);
        android.opengl.GLES20.glDrawArrays(6, 0, 4);
        android.opengl.GLES20.glBindTexture(3553, 0);
        android.opengl.GLES20.glDisableVertexAttribArray(r18.b.b);
        android.opengl.GLES20.glDisableVertexAttribArray(r18.b.c);
        android.opengl.GLES20.glDisable(3042);
        android.opengl.GLES20.glUseProgram(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01aa, code lost:
        monitor-exit(r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01ab, code lost:
        r18.u = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01ad, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x001b A[DONT_GENERATE] */
    @Override // com.amap.api.col.stln3.fz
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.autonavi.amap.mapcore.MapConfig r19) throws android.os.RemoteException {
        /*
        // Method dump skipped, instructions count: 436
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.fs.a(com.autonavi.amap.mapcore.MapConfig):void");
    }

    private void a(cx cxVar) {
        if (cxVar != null) {
            this.v.add(cxVar);
            cxVar.g();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void destroy() {
        try {
            remove();
            if (this.v != null && this.v.size() > 0) {
                for (int i2 = 0; i2 < this.v.size(); i2++) {
                    cx cxVar = this.v.get(i2);
                    if (cxVar != null) {
                        if (this.w != null) {
                            this.w.a(cxVar);
                        }
                        if (this.c != null) {
                            this.c.c(cxVar.j());
                        }
                    }
                }
                this.v.clear();
            }
            if (this.d != null) {
                Bitmap bitmap = this.d.getBitmap();
                if (bitmap != null) {
                    bitmap.recycle();
                    this.d = null;
                }
            }
            if (this.r != null) {
                this.r.clear();
                this.r = null;
            }
            synchronized (this) {
                if (this.q != null) {
                    this.q.clear();
                    this.q = null;
                }
                this.h = null;
            }
            this.e = null;
        } catch (Throwable th) {
            rx.c(th, "GroundOverlayDelegateImp", "destroy");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.stln3.fz
    public final boolean a() {
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public final void setPosition(LatLng latLng) throws RemoteException {
        this.e = latLng;
        d();
        this.c.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public final LatLng getPosition() throws RemoteException {
        return this.e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public final void setDimensions(float f2) throws RemoteException {
        if (!this.t || this.f == f2) {
            this.f = f2;
            this.g = f2;
        } else {
            this.f = f2;
            this.g = f2;
            d();
        }
        this.c.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public final void setDimensions(float f2, float f3) throws RemoteException {
        if (!this.t || this.f == f2 || this.g == f3) {
            this.f = f2;
            this.g = f3;
        } else {
            this.f = f2;
            this.g = f3;
            d();
        }
        this.c.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public final float getWidth() throws RemoteException {
        return this.f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public final float getHeight() throws RemoteException {
        return this.g;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public final void setPositionFromBounds(LatLngBounds latLngBounds) throws RemoteException {
        if (latLngBounds != null) {
            this.h = latLngBounds;
            e();
            this.c.setRunLowFrame(false);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public final LatLngBounds getBounds() throws RemoteException {
        return this.h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public final void setBearing(float f2) throws RemoteException {
        float f3 = ((f2 % 360.0f) + 360.0f) % 360.0f;
        if (((double) Math.abs(this.i - f3)) > 1.0E-7d) {
            this.i = f3;
            f();
        }
        this.c.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public final float getBearing() throws RemoteException {
        return this.i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public final void setTransparency(float f2) throws RemoteException {
        this.l = (float) Math.min(1.0d, Math.max(0.0d, (double) f2));
        this.m = 1.0f - f2;
        this.c.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public final float getTransparency() throws RemoteException {
        return this.l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public final void setImage(BitmapDescriptor bitmapDescriptor) throws RemoteException {
        if (bitmapDescriptor != null && bitmapDescriptor.getBitmap() != null && !bitmapDescriptor.getBitmap().isRecycled()) {
            this.d = bitmapDescriptor;
            BitmapDescriptor bitmapDescriptor2 = this.d;
            if (!(bitmapDescriptor2 == null && (bitmapDescriptor2 == null || bitmapDescriptor2.getBitmap() == null))) {
                int width = this.d.getWidth();
                int height = this.d.getHeight();
                int height2 = this.d.getBitmap().getHeight();
                float width2 = ((float) width) / ((float) this.d.getBitmap().getWidth());
                float f2 = ((float) height) / ((float) height2);
                this.r = ic.a(new float[]{0.0f, f2, width2, f2, width2, 0.0f, 0.0f, 0.0f});
            }
            if (this.t) {
                this.t = false;
            }
            this.c.setRunLowFrame(false);
        }
    }

    public final void a(float f2, float f3) throws RemoteException {
        this.n = f2;
        this.o = f3;
        this.c.setRunLowFrame(false);
    }

    @Override // com.amap.api.col.stln3.fz
    public final boolean b() {
        return this.u;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final boolean isAboveMaskLayer() {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void setAboveMaskLayer(boolean z) {
    }
}
