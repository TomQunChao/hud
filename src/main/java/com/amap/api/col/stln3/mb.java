package com.amap.api.col.stln3;

import android.os.Build;
import android.view.VelocityTracker;

/* compiled from: VelocityTrackerCompat */
public final class mb {
    static final c a;

    /* compiled from: VelocityTrackerCompat */
    interface c {
        float a(VelocityTracker velocityTracker, int i);

        float b(VelocityTracker velocityTracker, int i);
    }

    /* compiled from: VelocityTrackerCompat */
    static class a implements c {
        a() {
        }

        @Override // com.amap.api.col.stln3.mb.c
        public final float a(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getXVelocity();
        }

        @Override // com.amap.api.col.stln3.mb.c
        public final float b(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getYVelocity();
        }
    }

    /* compiled from: VelocityTrackerCompat */
    static class b implements c {
        b() {
        }

        @Override // com.amap.api.col.stln3.mb.c
        public final float a(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getXVelocity(i);
        }

        @Override // com.amap.api.col.stln3.mb.c
        public final float b(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getYVelocity(i);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            a = new b();
        } else {
            a = new a();
        }
    }

    public static float a(VelocityTracker velocityTracker, int i) {
        return a.a(velocityTracker, i);
    }

    public static float b(VelocityTracker velocityTracker, int i) {
        return a.b(velocityTracker, i);
    }
}
