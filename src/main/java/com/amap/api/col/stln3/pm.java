package com.amap.api.col.stln3;

import android.content.Context;

/* compiled from: LocMonitor */
public final class pm {
    private pn a;
    private qq b;
    private a c;
    private Context d;

    /* compiled from: LocMonitor */
    public interface a {
        void a(int i, String str);

        void b(int i, String str);

        void c(int i, String str);

        void d(int i, String str);
    }

    /* compiled from: LocMonitor */
    public interface b {
        String a();
    }

    public pm(Context context, qq qqVar, a aVar) {
        this.b = qqVar;
        qq qqVar2 = this.b;
        this.c = aVar;
        this.d = context;
        try {
            this.a = new pn(this.d, qqVar2, this.c);
        } catch (Exception e) {
            qr.a("LocMonitorManager construct ex " + e);
        }
    }

    public final void a(a aVar) {
        this.c = aVar;
        this.a.a(aVar);
    }

    public final void a() {
        this.a.a();
    }

    public final void b() {
        this.a.b();
    }

    public final void c() {
        this.a.a(false);
    }

    public final void a(boolean z) {
        this.a.b(z);
    }

    public final void a(long j) {
        this.a.a(j);
    }

    public final long d() {
        return this.a.c();
    }

    public final void a(String str) {
        this.a.a(str);
    }

    public final String e() {
        return this.a.d();
    }

    public final void a(qq qqVar) {
        this.b = qqVar;
        pn pnVar = this.a;
        if (pnVar == null) {
            qr.a("LocMonitorCore is null");
        } else {
            pnVar.a(this.b);
        }
    }

    public final void a(b bVar) {
        this.a.a(bVar);
    }
}
