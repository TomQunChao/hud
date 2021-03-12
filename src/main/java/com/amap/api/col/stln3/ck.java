package com.amap.api.col.stln3;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.amap.api.col.stln3.Cdo;
import com.amap.api.col.stln3.dl;
import com.amap.api.col.stln3.dm;
import com.amap.api.col.stln3.dp;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.autonavi.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.amap.mapcore.message.ScaleGestureMapMessage;

/* compiled from: GlMapGestureDetector */
public final class ck {
    co a;
    Context b;
    GestureDetector c;
    public AMapGestureListener d;
    private Cdo e;
    private dm f;
    private dl g;
    private dp h;
    private boolean i = false;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private boolean o = false;
    private boolean p = false;
    private boolean q = true;
    private Handler r = new Handler(Looper.getMainLooper());

    static /* synthetic */ int g(ck ckVar) {
        int i2 = ckVar.k;
        ckVar.k = i2 + 1;
        return i2;
    }

    static /* synthetic */ int h(ck ckVar) {
        int i2 = ckVar.l;
        ckVar.l = i2 + 1;
        return i2;
    }

    static /* synthetic */ int l(ck ckVar) {
        int i2 = ckVar.j;
        ckVar.j = i2 + 1;
        return i2;
    }

    static /* synthetic */ int m(ck ckVar) {
        int i2 = ckVar.m;
        ckVar.m = i2 + 1;
        return i2;
    }

    public final void a() {
        this.j = 0;
        this.l = 0;
        this.k = 0;
        this.m = 0;
        this.n = 0;
    }

    public ck(co coVar) {
        this.b = coVar.y();
        this.a = coVar;
        a aVar = new a(this, (byte) 0);
        this.c = new GestureDetector(this.b, aVar, this.r);
        this.c.setOnDoubleTapListener(aVar);
        this.e = new Cdo(this.b, new d(this, (byte) 0));
        this.f = new dm(this.b, new c(this, (byte) 0));
        this.g = new dl(this.b, new b(this, (byte) 0));
        this.h = new dp(this.b, new e(this, (byte) 0));
    }

    public final boolean a(MotionEvent motionEvent) {
        if (this.n < motionEvent.getPointerCount()) {
            this.n = motionEvent.getPointerCount();
        }
        if ((motionEvent.getAction() & 255) == 0) {
            this.p = false;
            this.q = false;
        }
        if (motionEvent.getAction() == 6 && motionEvent.getPointerCount() > 0) {
            this.p = true;
        }
        if (this.o && this.n >= 2) {
            this.o = false;
        }
        try {
            if (this.d != null) {
                if (motionEvent.getAction() == 0) {
                    this.d.onDown(motionEvent.getX(), motionEvent.getY());
                } else if (motionEvent.getAction() == 1) {
                    this.d.onUp(motionEvent.getX(), motionEvent.getY());
                }
            }
            this.c.onTouchEvent(motionEvent);
            this.g.c(motionEvent);
            if (this.i) {
                if (this.m > 0) {
                    return true;
                }
            }
            this.h.c(motionEvent);
            if (!this.o) {
                this.e.a(motionEvent);
                this.f.c(motionEvent);
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void b() {
        Handler handler = this.r;
        if (handler != null) {
            handler.removeCallbacks(null);
            this.r = null;
        }
    }

    /* compiled from: GlMapGestureDetector */
    private class a implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {
        float a;
        long b;
        private int d;
        private EAMapPlatformGestureInfo e;

        private a() {
            this.d = 0;
            this.a = 0.0f;
            this.e = new EAMapPlatformGestureInfo();
            this.b = 0;
        }

        /* synthetic */ a(ck ckVar, byte b2) {
            this();
        }

        public final boolean onDown(MotionEvent motionEvent) {
            ck.this.o = false;
            return true;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (ck.this.d != null) {
                ck.this.d.onFling(f, f2);
            }
            try {
                if (ck.this.a.k().isScrollGesturesEnabled() && ck.this.m <= 0 && ck.this.k <= 0 && ck.this.l == 0 && !ck.this.q) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
                    eAMapPlatformGestureInfo.mGestureState = 3;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent2.getX(), motionEvent2.getY()};
                    int a2 = ck.this.a.a(this.e);
                    ck.this.a.onFling();
                    ck.this.a.a().startMapSlidAnim(a2, new Point((int) motionEvent2.getX(), (int) motionEvent2.getY()), f, f2);
                }
                return true;
            } catch (Throwable th) {
                rx.c(th, "GLMapGestrureDetector", "onFling");
                th.printStackTrace();
                return true;
            }
        }

        public final void onLongPress(MotionEvent motionEvent) {
            if (ck.this.n == 1) {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
                eAMapPlatformGestureInfo.mGestureState = 3;
                eAMapPlatformGestureInfo.mGestureType = 7;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                ck.this.a.a(ck.this.a.a(this.e), motionEvent);
                if (ck.this.d != null) {
                    ck.this.d.onLongPress(motionEvent.getX(), motionEvent.getY());
                }
            }
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (ck.this.d == null) {
                return false;
            }
            ck.this.d.onScroll(f, f2);
            return false;
        }

        public final void onShowPress(MotionEvent motionEvent) {
            try {
                this.e.mGestureState = 3;
                this.e.mGestureType = 7;
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                ck.this.a.a().clearAnimations(ck.this.a.a(this.e), false);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            ck.this.c.setIsLongpressEnabled(false);
            this.d = motionEvent.getPointerCount();
            if (ck.this.d != null) {
                ck.this.d.onDoubleTap(motionEvent.getX(), motionEvent.getY());
            }
            return false;
        }

        public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if (this.d < motionEvent.getPointerCount()) {
                this.d = motionEvent.getPointerCount();
            }
            int action = motionEvent.getAction() & 255;
            if (this.d != 1) {
                return false;
            }
            try {
                if (!ck.this.a.k().isZoomGesturesEnabled()) {
                    return false;
                }
            } catch (Throwable th) {
                rx.c(th, "GLMapGestrureDetector", "onDoubleTapEvent");
                th.printStackTrace();
            }
            if (action == 0) {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
                eAMapPlatformGestureInfo.mGestureState = 1;
                eAMapPlatformGestureInfo.mGestureType = 9;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                int a2 = ck.this.a.a(this.e);
                this.a = motionEvent.getY();
                ck.this.a.a(a2, ScaleGestureMapMessage.obtain(100, 1.0f, 0, 0));
                this.b = SystemClock.uptimeMillis();
                return true;
            } else if (action == 2) {
                ck.this.o = true;
                float y = this.a - motionEvent.getY();
                if (Math.abs(y) < 20.0f) {
                    return true;
                }
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo2 = this.e;
                eAMapPlatformGestureInfo2.mGestureState = 2;
                eAMapPlatformGestureInfo2.mGestureType = 9;
                eAMapPlatformGestureInfo2.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                ck.this.a.a(ck.this.a.a(this.e), ScaleGestureMapMessage.obtain(101, (y * 4.0f) / ((float) ck.this.a.getMapHeight()), 0, 0));
                this.a = motionEvent.getY();
                return true;
            } else {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo3 = this.e;
                eAMapPlatformGestureInfo3.mGestureState = 3;
                eAMapPlatformGestureInfo3.mGestureType = 9;
                eAMapPlatformGestureInfo3.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                int a3 = ck.this.a.a(this.e);
                ck.this.c.setIsLongpressEnabled(true);
                ck.this.a.a(a3, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
                if (action == 1) {
                    ck.this.a.a(3);
                    long uptimeMillis = SystemClock.uptimeMillis() - this.b;
                    if (!ck.this.o || uptimeMillis < 200) {
                        return ck.this.a.a(motionEvent);
                    }
                    ck.this.o = false;
                    return true;
                }
                ck.this.o = false;
                return true;
            }
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (ck.this.n != 1) {
                return false;
            }
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 8;
            eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
            ck.this.a.a(this.e);
            if (ck.this.d != null) {
                try {
                    ck.this.d.onSingleTap(motionEvent.getX(), motionEvent.getY());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return ck.this.a.b(motionEvent);
        }
    }

    /* compiled from: GlMapGestureDetector */
    private class d extends Cdo.a {
        private boolean b;
        private boolean c;
        private boolean d;
        private Point e;
        private float[] f;
        private float g;
        private float[] h;
        private float i;
        private EAMapPlatformGestureInfo j;

        private d() {
            this.b = false;
            this.c = false;
            this.d = false;
            this.e = new Point();
            this.f = new float[10];
            this.g = 0.0f;
            this.h = new float[10];
            this.i = 0.0f;
            this.j = new EAMapPlatformGestureInfo();
        }

        /* synthetic */ d(ck ckVar, byte b2) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:35:0x00fc A[Catch:{ Throwable -> 0x0111 }] */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0105 A[Catch:{ Throwable -> 0x0111 }] */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0133 A[Catch:{ Throwable -> 0x01e5 }] */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x01a9 A[Catch:{ Throwable -> 0x01e5 }] */
        /* JADX WARNING: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:84:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        @Override // com.amap.api.col.stln3.Cdo.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(com.amap.api.col.stln3.Cdo r19) {
            /*
            // Method dump skipped, instructions count: 497
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ck.d.a(com.amap.api.col.stln3.do):boolean");
        }

        @Override // com.amap.api.col.stln3.Cdo.a
        public final boolean b(Cdo doVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.j;
            eAMapPlatformGestureInfo.mGestureState = 1;
            eAMapPlatformGestureInfo.mGestureType = 4;
            eAMapPlatformGestureInfo.mLocation = new float[]{doVar.a().getX(), doVar.a().getY()};
            int a2 = ck.this.a.a(this.j);
            int b2 = (int) doVar.b();
            int c2 = (int) doVar.c();
            this.d = false;
            Point point = this.e;
            point.x = b2;
            point.y = c2;
            this.b = false;
            this.c = false;
            ck.this.a.a(a2, ScaleGestureMapMessage.obtain(100, 1.0f, b2, c2));
            try {
                if (ck.this.a.k().isRotateGesturesEnabled() && !ck.this.a.b(a2)) {
                    ck.this.a.a(a2, RotateGestureMapMessage.obtain(100, ck.this.a.u(), b2, c2));
                }
            } catch (Throwable th) {
                rx.c(th, "GLMapGestrureDetector", "onScaleRotateBegin");
                th.printStackTrace();
            }
            return true;
        }

        @Override // com.amap.api.col.stln3.Cdo.a
        public final void c(Cdo doVar) {
            float f2;
            float f3;
            int i2;
            float f4;
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.j;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 4;
            boolean z = true;
            eAMapPlatformGestureInfo.mLocation = new float[]{doVar.a().getX(), doVar.a().getY()};
            int a2 = ck.this.a.a(this.j);
            this.d = false;
            ck.this.a.a(a2, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
            if (ck.this.k > 0) {
                int i3 = ck.this.k > 10 ? 10 : ck.this.k;
                float f5 = 0.0f;
                for (int i4 = 0; i4 < 10; i4++) {
                    float[] fArr = this.f;
                    f5 += fArr[i4];
                    fArr[i4] = 0.0f;
                }
                float f6 = f5 / ((float) i3);
                if (0.004f <= f6) {
                    float f7 = f6 * 300.0f;
                    float f8 = 1.5f;
                    if (f7 < 1.5f) {
                        f8 = f7;
                    }
                    if (this.g < 0.0f) {
                        f8 = -f8;
                    }
                    f4 = f8 + ck.this.a.b();
                } else {
                    f4 = -9999.0f;
                }
                this.g = 0.0f;
                f2 = f4;
            } else {
                f2 = -9999.0f;
            }
            if (!ck.this.a.b(a2)) {
                try {
                    if (ck.this.a.k().isRotateGesturesEnabled()) {
                        ck.this.a.a(a2, RotateGestureMapMessage.obtain(102, ck.this.a.u(), 0, 0));
                    }
                } catch (Throwable th) {
                    rx.c(th, "GLMapGestrureDetector", "onScaleRotateEnd");
                    th.printStackTrace();
                }
                if (ck.this.l > 0) {
                    ck.this.a.a(6);
                    if (ck.this.l > 10) {
                        i2 = 10;
                    } else {
                        i2 = ck.this.l;
                    }
                    float f9 = 0.0f;
                    for (int i5 = 0; i5 < 10; i5++) {
                        float[] fArr2 = this.h;
                        f9 += fArr2[i5];
                        fArr2[i5] = 0.0f;
                    }
                    float f10 = f9 / ((float) i2);
                    if (0.1f <= f10) {
                        float f11 = f10 * 200.0f;
                        int u = ((int) ck.this.a.u()) % SpatialRelationUtil.A_CIRCLE_DEGREE;
                        float f12 = 60.0f;
                        if (f11 < 60.0f) {
                            f12 = f11;
                        }
                        if (this.i < 0.0f) {
                            f12 = -f12;
                        }
                        f3 = (float) (((int) (((float) u) + f12)) % SpatialRelationUtil.A_CIRCLE_DEGREE);
                        this.g = 0.0f;
                    }
                }
                f3 = -9999.0f;
                this.g = 0.0f;
            } else {
                f3 = -9999.0f;
            }
            if (f2 == -9999.0f && f3 == -9999.0f) {
                z = false;
            }
            if (z) {
                ck.this.a.a().startPivotZoomRotateAnim(a2, this.e, f2, (int) f3, 500);
            }
        }
    }

    /* compiled from: GlMapGestureDetector */
    private class c implements dm.a {
        private EAMapPlatformGestureInfo b;

        private c() {
            this.b = new EAMapPlatformGestureInfo();
        }

        /* synthetic */ c(ck ckVar, byte b2) {
            this();
        }

        @Override // com.amap.api.col.stln3.dm.a
        public final boolean a(dm dmVar) {
            if (ck.this.i) {
                return true;
            }
            try {
                if (!ck.this.a.k().isScrollGesturesEnabled() || ck.this.p) {
                    return true;
                }
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
                eAMapPlatformGestureInfo.mGestureState = 2;
                eAMapPlatformGestureInfo.mGestureType = 3;
                eAMapPlatformGestureInfo.mLocation = new float[]{dmVar.c().getX(), dmVar.c().getY()};
                int a2 = ck.this.a.a(this.b);
                PointF d = dmVar.d();
                float f = 1.0f;
                if (ck.this.j == 0) {
                    f = 4.0f;
                }
                if (Math.abs(d.x) <= f && Math.abs(d.y) <= f) {
                    return false;
                }
                if (ck.this.j == 0) {
                    ck.this.a.a().clearAnimations(a2, false);
                }
                ck.this.a.a(a2, MoveGestureMapMessage.obtain(101, d.x, d.y));
                ck.l(ck.this);
                return true;
            } catch (Throwable th) {
                rx.c(th, "GLMapGestrureDetector", "onMove");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.stln3.dm.a
        public final boolean b(dm dmVar) {
            try {
                if (!ck.this.a.k().isScrollGesturesEnabled()) {
                    return true;
                }
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
                eAMapPlatformGestureInfo.mGestureState = 1;
                eAMapPlatformGestureInfo.mGestureType = 3;
                eAMapPlatformGestureInfo.mLocation = new float[]{dmVar.c().getX(), dmVar.c().getY()};
                ck.this.a.a(ck.this.a.a(this.b), MoveGestureMapMessage.obtain(100, 0.0f, 0.0f));
                return true;
            } catch (Throwable th) {
                rx.c(th, "GLMapGestrureDetector", "onMoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.stln3.dm.a
        public final void c(dm dmVar) {
            try {
                if (ck.this.a.k().isScrollGesturesEnabled()) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
                    eAMapPlatformGestureInfo.mGestureState = 3;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{dmVar.c().getX(), dmVar.c().getY()};
                    int a2 = ck.this.a.a(this.b);
                    if (ck.this.j > 0) {
                        ck.this.a.a(5);
                    }
                    ck.this.a.a(a2, MoveGestureMapMessage.obtain(102, 0.0f, 0.0f));
                }
            } catch (Throwable th) {
                rx.c(th, "GLMapGestrureDetector", "onMoveEnd");
                th.printStackTrace();
            }
        }
    }

    /* compiled from: GlMapGestureDetector */
    private class b implements dl.a {
        private EAMapPlatformGestureInfo b;

        private b() {
            this.b = new EAMapPlatformGestureInfo();
        }

        /* synthetic */ b(ck ckVar, byte b2) {
            this();
        }

        @Override // com.amap.api.col.stln3.dl.a
        public final boolean a(dl dlVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
            eAMapPlatformGestureInfo.mGestureState = 2;
            eAMapPlatformGestureInfo.mGestureType = 6;
            boolean z = false;
            eAMapPlatformGestureInfo.mLocation = new float[]{dlVar.c().getX(), dlVar.c().getY()};
            try {
                if (!ck.this.a.k().isTiltGesturesEnabled()) {
                    return true;
                }
                int a2 = ck.this.a.a(this.b);
                ck.this.a.d();
                if (ck.this.l > 3) {
                    return false;
                }
                float f = dlVar.d().x;
                float f2 = dlVar.d().y;
                if (!ck.this.i) {
                    PointF a3 = dlVar.a(0);
                    PointF a4 = dlVar.a(1);
                    if ((a3.y > 10.0f && a4.y > 10.0f) || (a3.y < -10.0f && a4.y < -10.0f)) {
                        z = true;
                    }
                    if (z && Math.abs(f2) > 10.0f && Math.abs(f) < 10.0f) {
                        ck.this.i = true;
                    }
                }
                if (ck.this.i) {
                    ck.this.i = true;
                    float f3 = f2 / 6.0f;
                    if (Math.abs(f3) > 1.0f) {
                        ck.this.a.a(a2, HoverGestureMapMessage.obtain(101, f3));
                        ck.m(ck.this);
                        return true;
                    }
                }
                return true;
            } catch (Throwable th) {
                rx.c(th, "GLMapGestrureDetector", "onHove");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.stln3.dl.a
        public final boolean b(dl dlVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
            eAMapPlatformGestureInfo.mGestureState = 1;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{dlVar.c().getX(), dlVar.c().getY()};
            try {
                if (!ck.this.a.k().isTiltGesturesEnabled()) {
                    return true;
                }
                int a2 = ck.this.a.a(this.b);
                ck.this.a.d();
                ck.this.a.a(a2, HoverGestureMapMessage.obtain(100, ck.this.a.v()));
                return true;
            } catch (Throwable th) {
                rx.c(th, "GLMapGestrureDetector", "onHoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.stln3.dl.a
        public final void c(dl dlVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{dlVar.c().getX(), dlVar.c().getY()};
            try {
                if (ck.this.a.k().isTiltGesturesEnabled()) {
                    int a2 = ck.this.a.a(this.b);
                    ck.this.a.d();
                    if (ck.this.a.v() >= 0.0f && ck.this.m > 0) {
                        ck.this.a.a(7);
                    }
                    ck.this.i = false;
                    ck.this.a.a(a2, HoverGestureMapMessage.obtain(102, ck.this.a.v()));
                }
            } catch (Throwable th) {
                rx.c(th, "GLMapGestrureDetector", "onHoveEnd");
                th.printStackTrace();
            }
        }
    }

    /* compiled from: GlMapGestureDetector */
    private class e extends dp.b {
        EAMapPlatformGestureInfo a;

        private e() {
            this.a = new EAMapPlatformGestureInfo();
        }

        /* synthetic */ e(ck ckVar, byte b2) {
            this();
        }

        @Override // com.amap.api.col.stln3.dp.a, com.amap.api.col.stln3.dp.b
        public final void a(dp dpVar) {
            try {
                if (ck.this.a.k().isZoomGesturesEnabled() && Math.abs(dpVar.d()) <= 10.0f && Math.abs(dpVar.e()) <= 10.0f && dpVar.b() < 200) {
                    ck.this.q = true;
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.a;
                    eAMapPlatformGestureInfo.mGestureState = 2;
                    eAMapPlatformGestureInfo.mGestureType = 2;
                    eAMapPlatformGestureInfo.mLocation = new float[]{dpVar.c().getX(), dpVar.c().getY()};
                    ck.this.a.a(this.a);
                    ck.this.a.a(4);
                    ck.this.a.c();
                }
            } catch (Throwable th) {
                rx.c(th, "GLMapGestrureDetector", "onZoomOut");
                th.printStackTrace();
            }
        }
    }
}
