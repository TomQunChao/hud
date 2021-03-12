package com.amap.api.col.stln3;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* compiled from: ZoomOutGestureDetectorAbstract */
public final class dp extends dj {
    private static final PointF n = new PointF();
    private final a l;
    private boolean m;
    private PointF o;
    private PointF p;
    private PointF q = new PointF();
    private PointF r = new PointF();

    /* compiled from: ZoomOutGestureDetectorAbstract */
    public interface a {
        void a(dp dpVar);
    }

    /* compiled from: ZoomOutGestureDetectorAbstract */
    public static class b implements a {
        @Override // com.amap.api.col.stln3.dp.a
        public void a(dp dpVar) {
        }
    }

    public dp(Context context, a aVar) {
        super(context);
        this.l = aVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.dk
    public final void a(int i, MotionEvent motionEvent) {
        if (i == 5) {
            a();
            this.g = MotionEvent.obtain(motionEvent);
            this.k = 0;
            a(motionEvent);
            this.m = b(motionEvent);
            if (!this.m) {
                a aVar = this.l;
                this.f = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.dk
    public final void b(int i, MotionEvent motionEvent) {
        if (i == 3) {
            a();
        } else if (i == 6) {
            a(motionEvent);
            if (!this.m) {
                this.l.a(this);
            }
            a();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.dk
    public final void a() {
        super.a();
        this.m = false;
        PointF pointF = this.q;
        pointF.x = 0.0f;
        PointF pointF2 = this.r;
        pointF2.x = 0.0f;
        pointF.y = 0.0f;
        pointF2.y = 0.0f;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.dk, com.amap.api.col.stln3.dj
    public final void a(MotionEvent motionEvent) {
        super.a(motionEvent);
        MotionEvent motionEvent2 = this.g;
        this.o = d(motionEvent);
        this.p = d(motionEvent2);
        this.r = this.g.getPointerCount() != motionEvent.getPointerCount() ? n : new PointF(this.o.x - this.p.x, this.o.y - this.p.y);
        this.q.x += this.r.x;
        this.q.y += this.r.y;
    }

    public final float d() {
        return this.q.x;
    }

    public final float e() {
        return this.q.y;
    }
}
