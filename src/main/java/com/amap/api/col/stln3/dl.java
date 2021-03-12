package com.amap.api.col.stln3;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* compiled from: HoverGestureDetectorAbstract */
public final class dl extends dj {
    private static final PointF l = new PointF();
    private final a m;
    private boolean n;
    private PointF o;
    private PointF p;
    private PointF q = new PointF();
    private PointF r = new PointF();

    /* compiled from: HoverGestureDetectorAbstract */
    public interface a {
        boolean a(dl dlVar);

        boolean b(dl dlVar);

        void c(dl dlVar);
    }

    public dl(Context context, a aVar) {
        super(context);
        this.m = aVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.dk
    public final void a(int i, MotionEvent motionEvent) {
        if (i != 2) {
            switch (i) {
                case 5:
                    a();
                    this.g = MotionEvent.obtain(motionEvent);
                    this.k = 0;
                    a(motionEvent);
                    this.n = b(motionEvent);
                    if (!this.n) {
                        this.f = this.m.b(this);
                        return;
                    }
                    return;
                case 6:
                    boolean z = this.n;
                    return;
                default:
                    return;
            }
        } else if (this.n) {
            this.n = b(motionEvent);
            if (!this.n) {
                this.f = this.m.b(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.dk
    public final void b(int i, MotionEvent motionEvent) {
        if (i != 6) {
            switch (i) {
                case 2:
                    a(motionEvent);
                    if (this.i / this.j > 0.67f && this.m.a(this)) {
                        this.g.recycle();
                        this.g = MotionEvent.obtain(motionEvent);
                        return;
                    }
                    return;
                case 3:
                    if (!this.n) {
                        this.m.c(this);
                    }
                    a();
                    return;
                default:
                    return;
            }
        } else {
            a(motionEvent);
            if (!this.n) {
                this.m.c(this);
            }
            a();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.dk
    public final void a() {
        super.a();
        this.n = false;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.dk, com.amap.api.col.stln3.dj
    public final void a(MotionEvent motionEvent) {
        super.a(motionEvent);
        MotionEvent motionEvent2 = this.g;
        this.o = d(motionEvent);
        this.p = d(motionEvent2);
        this.r = this.g.getPointerCount() != motionEvent.getPointerCount() ? l : new PointF(this.o.x - this.p.x, this.o.y - this.p.y);
        this.q.x += this.r.x;
        this.q.y += this.r.y;
    }

    public final PointF d() {
        return this.r;
    }
}
