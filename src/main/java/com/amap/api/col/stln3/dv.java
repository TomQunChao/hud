package com.amap.api.col.stln3;

/* compiled from: IBounds */
public final class dv {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;

    public dv(int i, int i2, int i3, int i4) {
        a(i, i2, i3, i4);
    }

    public final void a(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i3;
        this.c = i2;
        this.d = i4;
        this.e = (i + i2) / 2;
        this.f = (i3 + i4) / 2;
    }

    public final boolean a(int i, int i2) {
        return this.a <= i && i <= this.c && this.b <= i2 && i2 <= this.d;
    }

    public final boolean a(dv dvVar) {
        if (dvVar == null) {
            return false;
        }
        int i = dvVar.a;
        int i2 = dvVar.c;
        int i3 = dvVar.b;
        int i4 = dvVar.d;
        if (i >= this.c || this.a >= i2 || i3 >= this.d || this.b >= i4) {
            return false;
        }
        return true;
    }
}
