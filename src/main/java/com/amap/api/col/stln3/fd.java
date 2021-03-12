package com.amap.api.col.stln3;

/* compiled from: AbstractCityStateImp */
public abstract class fd implements fh {
    protected int a;
    protected dz b;

    public fd(int i, dz dzVar) {
        this.a = i;
        this.b = dzVar;
    }

    public final int b() {
        return this.a;
    }

    public final void a(fd fdVar) {
        String str = this.a + " ==> " + fdVar.a + "   " + getClass() + "==>" + fdVar.getClass();
    }

    public void c() {
        String str = "Wrong call start()  State: " + this.a + "  " + getClass();
    }

    public void d() {
        String str = "Wrong call continueDownload()  State: " + this.a + "  " + getClass();
    }

    public void e() {
        String str = "Wrong call pause()  State: " + this.a + "  " + getClass();
    }

    public void a() {
        String str = "Wrong call delete()  State: " + this.a + "  " + getClass();
    }

    public void a(int i) {
        String str = "Wrong call fail()  State: " + this.a + "  " + getClass();
    }

    public void f() {
        String str = "Wrong call hasNew()  State: " + this.a + "  " + getClass();
    }

    public void g() {
        String str = "Wrong call complete()  State: " + this.a + "  " + getClass();
    }
}
