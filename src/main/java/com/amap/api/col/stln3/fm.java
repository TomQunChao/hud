package com.amap.api.col.stln3;

/* compiled from: WaitingStateAbstractAbstract */
public final class fm extends fc {
    public fm(dz dzVar) {
        super(2, dzVar);
    }

    @Override // com.amap.api.col.stln3.fh
    public final void h() {
        this.b.k();
        this.b.d();
    }

    @Override // com.amap.api.col.stln3.fd
    public final void c() {
        a(this.b.c);
        this.b.a(this.b.c);
        this.b.c().h();
    }

    @Override // com.amap.api.col.stln3.fd
    public final void e() {
        a(this.b.d);
        this.b.a(this.b.d);
        this.b.c().h();
    }

    @Override // com.amap.api.col.stln3.fd
    public final void a(int i) {
        a(this.b.b(i));
        this.b.a(this.b.b(i));
        this.b.c().h();
    }
}
