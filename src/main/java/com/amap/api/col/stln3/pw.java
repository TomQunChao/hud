package com.amap.api.col.stln3;

import android.content.Context;
import java.util.HashSet;
import java.util.List;

/* compiled from: DataCacherManager */
public final class pw {
    private pv a;
    private pz b = new pz();

    public pw(Context context, qq qqVar) {
        this.a = new pv(context, qqVar);
    }

    public final pv a() {
        return this.a;
    }

    public final pz b() {
        return this.b;
    }

    public final void a(pt ptVar) {
        if (this.b.a() >= 100) {
            this.a.a(this.b.b());
            this.b.c();
        }
        this.b.a(ptVar);
    }

    public final void a(List<pt> list) {
        this.a.a(list);
    }

    public final List<pt> a(int i) {
        return this.b.a(i);
    }

    public final List<pt> b(int i) {
        return this.a.a(i);
    }

    public final void b(List<pt> list) {
        if (!(list == null || list.size() == 0)) {
            HashSet hashSet = new HashSet();
            for (pt ptVar : list) {
                hashSet.add(Long.valueOf(ptVar.a()));
            }
            this.b.a(hashSet);
        }
    }

    public final void c() {
        if (this.b != null && this.a != null) {
            pu.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.pw.AnonymousClass1 */

                public final void run() {
                    pw.this.a.a(pw.this.b.b());
                    pw.this.b.c();
                    pw.this.a.a();
                }
            });
        }
    }
}
