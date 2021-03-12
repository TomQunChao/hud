package com.amap.api.col.stln3;

/* compiled from: Bounds */
public final class hg {
    public final double a;
    public final double b;
    public final double c;
    public final double d;
    public final double e;
    public final double f;

    public hg(double d2, double d3, double d4, double d5) {
        this.a = d2;
        this.b = d4;
        this.c = d3;
        this.d = d5;
        this.e = (d2 + d3) / 2.0d;
        this.f = (d4 + d5) / 2.0d;
    }

    public final boolean a(double d2, double d3) {
        return this.a <= d2 && d2 <= this.c && this.b <= d3 && d3 <= this.d;
    }

    public final boolean a(hg hgVar) {
        return hgVar.a < this.c && this.a < hgVar.c && hgVar.b < this.d && this.b < hgVar.d;
    }
}
