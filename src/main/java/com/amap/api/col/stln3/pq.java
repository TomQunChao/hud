package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.col.stln3.ps;

/* compiled from: DataDelegateImpl */
public final class pq implements ps {
    private px a = new px(this.c, this.b, this.d);
    private pw b;
    private qq c;
    private ps.a d;

    public pq(Context context, qq qqVar, ps.a aVar) {
        this.c = qqVar;
        this.d = aVar;
        this.b = new pw(context, qqVar);
    }

    @Override // com.amap.api.col.stln3.ps
    public final void a(Context context) {
        this.a.a(context);
    }

    @Override // com.amap.api.col.stln3.ps
    public final void a(pt ptVar) {
        if (ptVar != null && ptVar.f()) {
            this.b.a(ptVar);
        }
    }

    @Override // com.amap.api.col.stln3.ps
    public final void a(qq qqVar) {
        this.c = qqVar;
        this.a.a(qqVar);
    }

    @Override // com.amap.api.col.stln3.ps
    public final void a() {
        this.b.c();
    }
}
