package com.amap.api.col.stln3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.amap.mapcore.interfaces.IInfoWindowManager;
import com.autonavi.amap.mapcore.interfaces.IMarker;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.nio.FloatBuffer;

/* compiled from: PopupOverlay */
public final class gm implements dr, fz, IInfoWindowManager {
    private boolean A = true;
    private Bitmap B = null;
    private Bitmap C = null;
    private Bitmap D = null;
    private Bitmap E = null;
    private boolean F = false;
    private boolean G = false;
    private GLAnimation H;
    private GLAnimation I;
    private boolean J = false;
    private boolean K = true;
    co a = null;
    float[] b = new float[12];
    a c;
    float[] d = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    long e = 0;
    ds f;
    private Context g;
    private cg h;
    private boolean i = false;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private FPoint n;
    private FloatBuffer o = null;
    private String p;
    private boolean q = true;
    private FloatBuffer r;
    private float s = 0.5f;
    private float t = 1.0f;
    private boolean u;
    private Bitmap v;
    private Bitmap w;
    private Rect x = new Rect();
    private float y = 0.0f;
    private int z;

    private synchronized void a(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                this.B = bitmap;
            }
        }
    }

    private synchronized void b(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    private synchronized void c(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                b(this.C);
                this.C = bitmap;
            }
        }
    }

    private synchronized void d(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                b(this.D);
                this.D = bitmap;
            }
        }
    }

    private synchronized void e(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                b(this.E);
                this.E = bitmap;
            }
        }
    }

    private synchronized Bitmap c() {
        return this.B;
    }

    private synchronized Bitmap d() {
        return this.D;
    }

    public gm(co coVar, Context context) {
        this.g = context;
        this.a = coVar;
        this.p = getId();
    }

    private int e() {
        try {
            synchronized (this) {
                if (this.v == null || this.v.isRecycled()) {
                    return 0;
                }
                return this.v.getWidth();
            }
        } catch (Throwable th) {
            return 0;
        }
    }

    private int f() {
        try {
            if (this.v == null || this.v.isRecycled()) {
                return 0;
            }
            return this.v.getHeight();
        } catch (Throwable th) {
            return 0;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final String getId() {
        if (this.p == null) {
            this.p = "PopupOverlay";
        }
        return this.p;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x009f, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void f(android.graphics.Bitmap r6) {
        /*
        // Method dump skipped, instructions count: 163
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.gm.f(android.graphics.Bitmap):void");
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void setVisible(boolean z2) {
        if (!this.q && z2) {
            this.u = true;
        }
        this.q = z2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final boolean isVisible() {
        return this.q;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        if (equals(iOverlay) || iOverlay.getId().equals(getId())) {
            return true;
        }
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final int hashCodeRemote() {
        return super.hashCode();
    }

    /* compiled from: PopupOverlay */
    static class a extends gp {
        int a;
        int b;
        int c;

        a(String str) {
            if (a(str)) {
                this.a = c("aMVP");
                this.b = b("aVertex");
                this.c = b("aTextureCoord");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00ee, code lost:
        if (java.lang.Double.isNaN(r0.scaleY) == false) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0123, code lost:
        if (java.lang.Double.isNaN(r0.scaleY) == false) goto L_0x0125;
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0238  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r26, int r27) {
        /*
        // Method dump skipped, instructions count: 766
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.gm.a(int, int):void");
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowAppearAnimation(Animation animation) {
        GLAnimation gLAnimation = this.I;
        if (gLAnimation == null || !gLAnimation.equals(animation.glAnimation)) {
            this.H = animation.glAnimation;
            return;
        }
        try {
            this.H = animation.glAnimation.clone();
        } catch (Throwable th) {
            rx.c(th, "PopupOverlay", "setInfoWindowDisappearAnimation");
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowBackColor(int i2) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowBackEnable(boolean z2) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowBackScale(float f2, float f3) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowDisappearAnimation(Animation animation) {
        GLAnimation gLAnimation = this.H;
        if (gLAnimation == null || !gLAnimation.equals(animation.glAnimation)) {
            this.I = animation.glAnimation;
            return;
        }
        try {
            this.I = animation.glAnimation.clone();
        } catch (Throwable th) {
            rx.c(th, "PopupOverlay", "setInfoWindowDisappearAnimation");
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowMovingAnimation(Animation animation) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void startAnimation() {
    }

    private void b(int i2, int i3) throws RemoteException {
        if (this.J) {
            this.l = i2;
            this.m = i3;
            return;
        }
        this.j = i2;
        this.k = i3;
        this.l = i2;
        this.m = i3;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void setZIndex(float f2) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final float getZIndex() {
        return 0.0f;
    }

    @Override // com.amap.api.col.stln3.fz
    public final boolean a() {
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void remove() throws RemoteException {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(boolean z2) {
        if (z2) {
            f(c());
        } else {
            f(d());
        }
    }

    private void g() {
        if (this.A || this.v == null) {
            f(c());
        } else {
            GLAnimation gLAnimation = this.I;
            if (gLAnimation != null) {
                this.K = false;
                this.J = true;
                gLAnimation.startNow();
                this.I.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.amap.api.col.stln3.gm.AnonymousClass1 */
                    final /* synthetic */ boolean a = true;

                    @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
                    public final void onAnimationStart() {
                    }

                    @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
                    public final void onAnimationEnd() {
                        if (gm.this.H != null) {
                            gm.this.J = true;
                            gm.this.H.startNow();
                            gm.this.a((gm) this.a);
                        }
                    }
                });
            } else {
                GLAnimation gLAnimation2 = this.H;
                if (gLAnimation2 != null) {
                    this.J = true;
                    gLAnimation2.startNow();
                }
                a(true);
            }
        }
        this.A = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void destroy() {
        if (this.i) {
            try {
                h();
                if (this.r != null) {
                    this.r.clear();
                    this.r = null;
                }
                if (this.o != null) {
                    this.o.clear();
                    this.o = null;
                }
                this.n = null;
                this.z = 0;
            } catch (Throwable th) {
                rx.c(th, "PopupOverlay", "realDestroy");
                th.printStackTrace();
            }
        }
    }

    private synchronized void h() {
        if (this.v != null) {
            Bitmap bitmap = this.v;
            if (bitmap != null) {
                bitmap.recycle();
                this.v = null;
            }
        }
        if (this.w != null && !this.w.isRecycled()) {
            this.w.recycle();
            this.w = null;
        }
        if (this.B != null && !this.B.isRecycled()) {
            this.B.recycle();
        }
        if (this.C != null && !this.C.isRecycled()) {
            this.C.recycle();
        }
        if (this.D != null && !this.D.isRecycled()) {
            this.D.recycle();
        }
        if (this.E != null && !this.E.isRecycled()) {
            this.E.recycle();
        }
    }

    @Override // com.amap.api.col.stln3.fz
    public final boolean b() {
        return false;
    }

    @Override // com.amap.api.col.stln3.fz
    public final void a(MapConfig mapConfig) throws RemoteException {
    }

    @Override // com.amap.api.col.stln3.dr
    public final synchronized void a(cg cgVar) throws RemoteException {
        View b2;
        View b3;
        if (cgVar != null) {
            if (cgVar.isInfoWindowEnable()) {
                if (this.h != null && !this.h.getId().equals(cgVar.getId())) {
                    b_();
                }
                if (this.f != null) {
                    this.h = cgVar;
                    cgVar.a(true);
                    setVisible(true);
                    try {
                        if (this.h instanceof gg) {
                            Marker marker = new Marker((IMarker) this.h);
                            if (this.f != null) {
                                Bitmap a2 = a(this.f.a((BasePointOverlay) marker));
                                if (a2 == null && (b3 = this.f.b((BasePointOverlay) marker)) != null) {
                                    if (b3.getBackground() == null) {
                                        b3.setBackground(this.f.d());
                                    }
                                    a2 = a(b3);
                                }
                                a(a2);
                                c(a(this.f.a(marker)));
                                d(a(this.f.b(marker)));
                                e(a(this.f.c(marker)));
                            }
                        } else if (this.f != null) {
                            GL3DModel gL3DModel = new GL3DModel((fr) this.h);
                            Bitmap a3 = a(this.f.a(gL3DModel));
                            if (a3 == null && (b2 = this.f.b(gL3DModel)) != null) {
                                if (b2.getBackground() == null) {
                                    b2.setBackground(this.f.d());
                                }
                                a3 = a(b2);
                            }
                            a(a3);
                        }
                    } catch (Throwable th) {
                        rx.c(th, "PopupOverlay", "getInfoWindow");
                        th.printStackTrace();
                    }
                }
                this.F = true;
            }
        }
    }

    private Bitmap a(View view) {
        Context context;
        if (view == null) {
            return null;
        }
        if ((view instanceof RelativeLayout) && (context = this.g) != null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.addView(view);
            view = linearLayout;
        }
        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(0);
        return ic.a(view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003d, code lost:
        monitor-enter(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        if (r11.J == false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        if (r11.v != null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        if (r11.B != null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (r11.D == null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0052, code lost:
        if (r5 == false) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0054, code lost:
        r5 = ((com.amap.api.col.stln3.gg) r11.h).getIMarkerAction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005c, code lost:
        if (r5 == null) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0062, code lost:
        if (r5.isInfoWindowEnable() != false) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0064, code lost:
        setVisible(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0067, code lost:
        monitor-exit(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0068, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0069, code lost:
        setVisible(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006d, code lost:
        if (r5 == null) goto L_0x0108;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0073, code lost:
        if (r5.isInfoWindowAutoOverturn() == false) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0075, code lost:
        r5 = r11.x.left;
        r6 = r11.x.top;
        r7 = r11.x.right;
        r8 = r11.x.top;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0089, code lost:
        if (r11.B == null) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0091, code lost:
        if (r11.B.isRecycled() == false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0094, code lost:
        r9 = r11.B.getHeight();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009b, code lost:
        r9 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009c, code lost:
        r0 = new android.graphics.Rect(r5, r6, r7, r8 + r9);
        r6 = r11.x.left;
        r7 = r11.x.top;
        r8 = r11.x.right;
        r9 = r11.x.top;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b4, code lost:
        if (r11.D == null) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00bc, code lost:
        if (r11.D.isRecycled() == false) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00bf, code lost:
        r10 = r11.D.getHeight();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c6, code lost:
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c7, code lost:
        r5 = new android.graphics.Rect(r6, r7, r8, r9 + r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00cd, code lost:
        if (r11.A == false) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00cf, code lost:
        r5.offset(0, (r2.height() + r0.height()) + 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00de, code lost:
        r0.offset(0, -((r2.height() + r0.height()) + 2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ed, code lost:
        r11.a.r();
        r11.a.r();
        g();
        r11.n = r11.h.a();
        b(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0108, code lost:
        r11.n = r11.h.a();
        b(r3, r4);
        g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0118, code lost:
        monitor-exit(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0119, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x011f, code lost:
        if (r11.J == false) goto L_0x012f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0123, code lost:
        if (r11.v != null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0127, code lost:
        if (r11.B != null) goto L_0x012f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x012b, code lost:
        if (r11.D == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0135, code lost:
        if (r11.h.isInfoWindowEnable() != false) goto L_0x013b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0137, code lost:
        setVisible(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x013a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x013b, code lost:
        setVisible(true);
        r11.n = r11.h.a();
        b(r3, r4);
        g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        setVisible(true);
        r2 = r11.h.i();
        r3 = r11.h.e() + r11.h.c();
        r4 = (r11.h.f() + r11.h.d()) + 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003b, code lost:
        if ((r11.h instanceof com.amap.api.col.stln3.gg) == false) goto L_0x011d;
     */
    @Override // com.amap.api.col.stln3.dr
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a_() {
        /*
        // Method dump skipped, instructions count: 347
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.gm.a_():void");
    }

    @Override // com.amap.api.col.stln3.dr
    public final boolean a(MotionEvent motionEvent) {
        if (!this.q || this.h == null || !this.F || !ic.a(this.x, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return true;
    }

    @Override // com.amap.api.col.stln3.dr
    public final synchronized void b_() {
        setVisible(false);
        h();
        this.F = false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final boolean isAboveMaskLayer() {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void setAboveMaskLayer(boolean z2) {
    }

    @Override // com.amap.api.col.stln3.dr
    public final void a(ds dsVar) {
        synchronized (this) {
            this.f = dsVar;
        }
    }
}
