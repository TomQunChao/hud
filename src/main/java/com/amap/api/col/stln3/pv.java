package com.amap.api.col.stln3;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Set;

/* compiled from: DBDataCacher */
public final class pv implements py {
    private static int f = 1000;
    private pz a;
    private qh b;
    private WeakReference<Context> c = null;
    private qq d;
    private long e = 0;

    public pv(Context context, qq qqVar) {
        this.d = qqVar;
        this.a = new pz();
        this.c = new WeakReference<>(context);
        this.b = new qh(context);
    }

    public final List<pt> a(int i) {
        List<pt> a2 = this.a.a(i);
        if (a2 != null && a2.size() > 0) {
            return a2;
        }
        this.a.a(this.b.a(i));
        List<pt> a3 = this.a.a(i);
        qh qhVar = this.b;
        long j = 0;
        if (qhVar != null) {
            long j2 = this.e;
            j = j2 > 0 ? j2 : qhVar.a();
        }
        this.e = j;
        return a3;
    }

    public final void a() {
        this.a.c();
        if (this.b != null) {
            qh.b();
            this.b = null;
        }
    }

    @Override // com.amap.api.col.stln3.py
    public final void a(Set<Long> set) {
        if (set != null && set != null && set.size() > 0) {
            this.a.a(set);
            this.b.a(set);
            this.e -= (long) set.size();
        }
    }

    public final void a(List<pt> list) {
        if (!(list == null || list.size() == 0)) {
            int i = 0;
            for (pt ptVar : list) {
                if (i > f) {
                    break;
                }
                this.b.a(ptVar);
                i++;
                this.e++;
            }
            qq qqVar = this.d;
            if (qqVar != null && this.e > ((long) qqVar.a())) {
                int a2 = this.d.a() / 10;
                this.b.b(a2);
                this.e -= (long) a2;
            }
        }
    }
}
