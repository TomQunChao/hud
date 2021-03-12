package com.amap.api.col.stln3;

import com.amap.api.col.stln3.ij;

/* compiled from: AbstractPool */
public abstract class ii<T extends ij<?>> {
    protected T a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T extends com.amap.api.col.stln3.ij<T>] */
    /* JADX WARN: Type inference failed for: r2v0, types: [T extends com.amap.api.col.stln3.ij<?>, T extends com.amap.api.col.stln3.ij<T>] */
    public final T a(T t) {
        if (t == null) {
            return null;
        }
        while (t != null) {
            t.f = this.a;
            this.a = t;
            t = t.f;
        }
        return null;
    }
}
