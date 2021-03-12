package com.amap.api.col.stln3;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* compiled from: MoveGestureDetector */
public final class dm extends dk {
    private static final PointF a = new PointF();
    private final a b;
    private PointF c;
    private PointF d;
    private PointF l = new PointF();
    private PointF m = new PointF();

    /* compiled from: MoveGestureDetector */
    public interface a {
        boolean a(dm dmVar);

        boolean b(dm dmVar);

        void c(dm dmVar);
    }

    public dm(Context context, a aVar) {
        super(context);
        this.b = aVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.dk
    public final void a(int i, MotionEvent motionEvent) {
        if (i == 0) {
            a();
            this.g = MotionEvent.obtain(motionEvent);
            this.k = 0;
            a(motionEvent);
        } else if (i == 2) {
            this.f = this.b.b(this);
        } else if (i == 5) {
            if (this.g != null) {
                this.g.recycle();
            }
            this.g = MotionEvent.obtain(motionEvent);
            a(motionEvent);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.dk
    public final void b(int i, MotionEvent motionEvent) {
        switch (i) {
            case 1:
            case 3:
                this.b.c(this);
                a();
                return;
            case 2:
                a(motionEvent);
                if (this.i / this.j > 0.67f && motionEvent.getPointerCount() <= 1 && this.b.a(this)) {
                    this.g.recycle();
                    this.g = MotionEvent.obtain(motionEvent);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.dk
    public final void a(MotionEvent motionEvent) {
        super.a(motionEvent);
        MotionEvent motionEvent2 = this.g;
        this.c = d(motionEvent);
        this.d = d(motionEvent2);
        boolean z = this.g.getPointerCount() != motionEvent.getPointerCount();
        this.m = z ? a : new PointF(this.c.x - this.d.x, this.c.y - this.d.y);
        if (z) {
            this.g.recycle();
            this.g = MotionEvent.obtain(motionEvent);
        }
        this.l.x += this.m.x;
        this.l.y += this.m.y;
    }

    public final PointF d() {
        return this.m;
    }
}
