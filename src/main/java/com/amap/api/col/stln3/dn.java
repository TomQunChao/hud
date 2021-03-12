package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* compiled from: ScaleGestureDetector */
public class dn {
    private final Context a;
    private final a b;
    private boolean c;
    private MotionEvent d;
    private MotionEvent e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private long q;
    private final float r;
    private float s;
    private float t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private boolean y;

    /* compiled from: ScaleGestureDetector */
    public interface a {
        boolean a(dn dnVar);

        boolean b(dn dnVar);

        void c(dn dnVar);
    }

    public final MotionEvent a() {
        return this.e;
    }

    public dn(Context context, a aVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.a = context;
        this.b = aVar;
        this.r = (float) viewConfiguration.getScaledEdgeSlop();
    }

    public final boolean a(MotionEvent motionEvent) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int a2;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            j();
        }
        boolean z = false;
        if (this.v) {
            return false;
        }
        int i8 = -1;
        if (!this.c) {
            switch (action) {
                case 0:
                    this.w = motionEvent.getPointerId(0);
                    this.y = true;
                    return true;
                case 1:
                    j();
                    return true;
                case 2:
                    if (!this.u) {
                        return true;
                    }
                    float f2 = this.r;
                    float f3 = this.s;
                    float f4 = this.t;
                    int findPointerIndex = motionEvent.findPointerIndex(this.w);
                    int findPointerIndex2 = motionEvent.findPointerIndex(this.x);
                    float a3 = a(motionEvent, findPointerIndex);
                    float b2 = b(motionEvent, findPointerIndex);
                    float a4 = a(motionEvent, findPointerIndex2);
                    float b3 = b(motionEvent, findPointerIndex2);
                    boolean z2 = a3 < f2 || b2 < f2 || a3 > f3 || b2 > f4;
                    boolean z3 = a4 < f2 || b3 < f2 || a4 > f3 || b3 > f4;
                    if (!z2 || (i3 = a(motionEvent, this.x, findPointerIndex)) < 0) {
                        i3 = findPointerIndex;
                    } else {
                        this.w = motionEvent.getPointerId(i3);
                        a(motionEvent, i3);
                        b(motionEvent, i3);
                        z2 = false;
                    }
                    if (!z3 || (i4 = a(motionEvent, this.w, findPointerIndex2)) < 0) {
                        i4 = findPointerIndex2;
                    } else {
                        this.x = motionEvent.getPointerId(i4);
                        a(motionEvent, i4);
                        b(motionEvent, i4);
                        z3 = false;
                    }
                    if (z2 && z3) {
                        this.f = -1.0f;
                        this.g = -1.0f;
                        return true;
                    } else if (z2) {
                        this.f = motionEvent.getX(i4);
                        this.g = motionEvent.getY(i4);
                        return true;
                    } else if (z3) {
                        this.f = motionEvent.getX(i3);
                        this.g = motionEvent.getY(i3);
                        return true;
                    } else {
                        this.u = false;
                        this.c = this.b.b(this);
                        return true;
                    }
                case 3:
                case 4:
                default:
                    return true;
                case 5:
                    DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
                    this.s = ((float) displayMetrics.widthPixels) - this.r;
                    this.t = ((float) displayMetrics.heightPixels) - this.r;
                    MotionEvent motionEvent2 = this.d;
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    this.d = MotionEvent.obtain(motionEvent);
                    this.q = 0;
                    if (Build.VERSION.SDK_INT >= 8) {
                        i6 = motionEvent.getActionIndex();
                        i5 = motionEvent.findPointerIndex(this.w);
                        this.x = motionEvent.getPointerId(i6);
                        if (i5 < 0 || i5 == i6) {
                            if (i5 != i6) {
                                i8 = this.x;
                            }
                            i5 = a(motionEvent, i8, i5);
                            this.w = motionEvent.getPointerId(i5);
                        }
                    } else if (motionEvent.getPointerCount() > 0) {
                        i6 = motionEvent.findPointerIndex(1);
                        i5 = motionEvent.findPointerIndex(this.w);
                        this.x = motionEvent.getPointerId(i6);
                    } else {
                        i6 = 0;
                        i5 = 0;
                    }
                    this.y = false;
                    b(motionEvent);
                    float f5 = this.r;
                    float f6 = this.s;
                    float f7 = this.t;
                    float a5 = a(motionEvent, i5);
                    float b4 = b(motionEvent, i5);
                    float a6 = a(motionEvent, i6);
                    float b5 = b(motionEvent, i6);
                    boolean z4 = a5 < f5 || b4 < f5 || a5 > f6 || b4 > f7;
                    boolean z5 = a6 < f5 || b5 < f5 || a6 > f6 || b5 > f7;
                    if (z4 && z5) {
                        this.f = -1.0f;
                        this.g = -1.0f;
                        this.u = true;
                        return true;
                    } else if (z4) {
                        this.f = motionEvent.getX(i6);
                        this.g = motionEvent.getY(i6);
                        this.u = true;
                        return true;
                    } else if (z5) {
                        this.f = motionEvent.getX(i5);
                        this.g = motionEvent.getY(i5);
                        this.u = true;
                        return true;
                    } else {
                        this.u = false;
                        this.c = this.b.b(this);
                        return true;
                    }
                case 6:
                    if (!this.u) {
                        return true;
                    }
                    int pointerCount = motionEvent.getPointerCount();
                    if (Build.VERSION.SDK_INT >= 8) {
                        i7 = motionEvent.getActionIndex();
                    } else {
                        i7 = 0;
                    }
                    int pointerId = motionEvent.getPointerId(i7);
                    if (pointerCount > 2) {
                        int i9 = this.w;
                        if (pointerId == i9) {
                            int a7 = a(motionEvent, this.x, i7);
                            if (a7 < 0) {
                                return true;
                            }
                            this.w = motionEvent.getPointerId(a7);
                            return true;
                        } else if (pointerId != this.x || (a2 = a(motionEvent, i9, i7)) < 0) {
                            return true;
                        } else {
                            this.x = motionEvent.getPointerId(a2);
                            return true;
                        }
                    } else {
                        int i10 = this.w;
                        if (pointerId == i10) {
                            i10 = this.x;
                        }
                        int findPointerIndex3 = motionEvent.findPointerIndex(i10);
                        if (findPointerIndex3 < 0) {
                            this.v = true;
                            if (this.c) {
                                this.b.c(this);
                            }
                            return false;
                        }
                        this.w = motionEvent.getPointerId(findPointerIndex3);
                        this.y = true;
                        this.x = -1;
                        this.f = motionEvent.getX(findPointerIndex3);
                        this.g = motionEvent.getY(findPointerIndex3);
                        return true;
                    }
            }
        } else {
            switch (action) {
                case 1:
                    j();
                    return true;
                case 2:
                    b(motionEvent);
                    if (this.o / this.p <= 0.67f || !this.b.a(this)) {
                        return true;
                    }
                    this.d.recycle();
                    this.d = MotionEvent.obtain(motionEvent);
                    return true;
                case 3:
                    this.b.c(this);
                    j();
                    return true;
                case 4:
                default:
                    return true;
                case 5:
                    this.b.c(this);
                    int i11 = this.w;
                    int i12 = this.x;
                    j();
                    this.d = MotionEvent.obtain(motionEvent);
                    if (!this.y) {
                        i11 = i12;
                    }
                    this.w = i11;
                    if (Build.VERSION.SDK_INT >= 8) {
                        this.x = motionEvent.getPointerId(motionEvent.getActionIndex());
                    } else {
                        this.x = motionEvent.getPointerId(1);
                    }
                    this.y = false;
                    int findPointerIndex4 = motionEvent.findPointerIndex(this.w);
                    if (findPointerIndex4 < 0 || this.w == this.x) {
                        int i13 = this.w;
                        int i14 = this.x;
                        if (i13 == i14) {
                            i14 = -1;
                        }
                        this.w = motionEvent.getPointerId(a(motionEvent, i14, findPointerIndex4));
                    }
                    b(motionEvent);
                    this.c = this.b.b(this);
                    return true;
                case 6:
                    int pointerCount2 = motionEvent.getPointerCount();
                    if (Build.VERSION.SDK_INT >= 8) {
                        i2 = motionEvent.getActionIndex();
                    } else {
                        i2 = 0;
                    }
                    int pointerId2 = motionEvent.getPointerId(i2);
                    if (pointerCount2 > 2) {
                        int i15 = this.w;
                        if (pointerId2 == i15) {
                            int a8 = a(motionEvent, this.x, i2);
                            if (a8 >= 0) {
                                this.b.c(this);
                                this.w = motionEvent.getPointerId(a8);
                                this.y = true;
                                this.d = MotionEvent.obtain(motionEvent);
                                b(motionEvent);
                                this.c = this.b.b(this);
                            } else {
                                z = true;
                            }
                        } else if (pointerId2 == this.x) {
                            int a9 = a(motionEvent, i15, i2);
                            if (a9 >= 0) {
                                this.b.c(this);
                                this.x = motionEvent.getPointerId(a9);
                                this.y = false;
                                this.d = MotionEvent.obtain(motionEvent);
                                b(motionEvent);
                                this.c = this.b.b(this);
                            } else {
                                z = true;
                            }
                        }
                        this.d.recycle();
                        this.d = MotionEvent.obtain(motionEvent);
                        b(motionEvent);
                    } else {
                        z = true;
                    }
                    if (!z) {
                        return true;
                    }
                    b(motionEvent);
                    int i16 = this.w;
                    if (pointerId2 == i16) {
                        i16 = this.x;
                    }
                    int findPointerIndex5 = motionEvent.findPointerIndex(i16);
                    this.f = motionEvent.getX(findPointerIndex5);
                    this.g = motionEvent.getY(findPointerIndex5);
                    this.b.c(this);
                    j();
                    this.w = i16;
                    this.y = true;
                    return true;
            }
        }
    }

    private int a(MotionEvent motionEvent, int i2, int i3) {
        int pointerCount = motionEvent.getPointerCount();
        int findPointerIndex = motionEvent.findPointerIndex(i2);
        for (int i4 = 0; i4 < pointerCount; i4++) {
            if (!(i4 == i3 || i4 == findPointerIndex)) {
                float f2 = this.r;
                float f3 = this.s;
                float f4 = this.t;
                float a2 = a(motionEvent, i4);
                float b2 = b(motionEvent, i4);
                if (a2 >= f2 && b2 >= f2 && a2 <= f3 && b2 <= f4) {
                    return i4;
                }
            }
        }
        return -1;
    }

    private static float a(MotionEvent motionEvent, int i2) {
        if (i2 < 0) {
            return Float.MIN_VALUE;
        }
        if (i2 == 0) {
            return motionEvent.getRawX();
        }
        return motionEvent.getX(i2) + (motionEvent.getRawX() - motionEvent.getX());
    }

    private static float b(MotionEvent motionEvent, int i2) {
        if (i2 < 0) {
            return Float.MIN_VALUE;
        }
        if (i2 == 0) {
            return motionEvent.getRawY();
        }
        return motionEvent.getY(i2) + (motionEvent.getRawY() - motionEvent.getY());
    }

    private void b(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.e;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.e = MotionEvent.obtain(motionEvent);
        this.l = -1.0f;
        this.m = -1.0f;
        this.n = -1.0f;
        MotionEvent motionEvent3 = this.d;
        int findPointerIndex = motionEvent3.findPointerIndex(this.w);
        int findPointerIndex2 = motionEvent3.findPointerIndex(this.x);
        int findPointerIndex3 = motionEvent.findPointerIndex(this.w);
        int findPointerIndex4 = motionEvent.findPointerIndex(this.x);
        if (findPointerIndex < 0 || findPointerIndex2 < 0 || findPointerIndex3 < 0 || findPointerIndex4 < 0) {
            this.v = true;
            if (this.c) {
                this.b.c(this);
                return;
            }
            return;
        }
        float x2 = motionEvent3.getX(findPointerIndex);
        float y2 = motionEvent3.getY(findPointerIndex);
        float x3 = motionEvent3.getX(findPointerIndex2);
        float y3 = motionEvent3.getY(findPointerIndex2);
        float x4 = motionEvent.getX(findPointerIndex3);
        float y4 = motionEvent.getY(findPointerIndex3);
        float x5 = motionEvent.getX(findPointerIndex4) - x4;
        float y5 = motionEvent.getY(findPointerIndex4) - y4;
        this.h = x3 - x2;
        this.i = y3 - y2;
        this.j = x5;
        this.k = y5;
        this.f = x4 + (x5 * 0.5f);
        this.g = y4 + (y5 * 0.5f);
        this.q = motionEvent.getEventTime() - motionEvent3.getEventTime();
        this.o = motionEvent.getPressure(findPointerIndex3) + motionEvent.getPressure(findPointerIndex4);
        this.p = motionEvent3.getPressure(findPointerIndex) + motionEvent3.getPressure(findPointerIndex2);
    }

    private void j() {
        MotionEvent motionEvent = this.d;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.d = null;
        }
        MotionEvent motionEvent2 = this.e;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.e = null;
        }
        this.u = false;
        this.c = false;
        this.w = -1;
        this.x = -1;
        this.v = false;
    }

    public final float b() {
        return this.f;
    }

    public final float c() {
        return this.g;
    }

    public final float d() {
        return this.j;
    }

    public final float e() {
        return this.k;
    }

    public final float f() {
        return this.h;
    }

    public final float g() {
        return this.i;
    }

    public final float h() {
        if (this.n == -1.0f) {
            if (this.l == -1.0f) {
                float f2 = this.j;
                float f3 = this.k;
                this.l = (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
            }
            float f4 = this.l;
            if (this.m == -1.0f) {
                float f5 = this.h;
                float f6 = this.i;
                this.m = (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
            }
            this.n = f4 / this.m;
        }
        return this.n;
    }

    public final long i() {
        return this.q;
    }
}
