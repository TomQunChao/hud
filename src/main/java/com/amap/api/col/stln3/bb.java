package com.amap.api.col.stln3;

/* compiled from: SerialContext */
public final class bb {
    public final bb a;
    public final Object b;
    public final Object c;
    public final int d;

    public bb(bb bbVar, Object obj, Object obj2, int i) {
        this.a = bbVar;
        this.b = obj;
        this.c = obj2;
        this.d = i;
    }

    public final String toString() {
        if (this.a == null) {
            return "$";
        }
        if (this.c instanceof Integer) {
            return this.a.toString() + "[" + this.c + "]";
        }
        return this.a.toString() + "." + this.c;
    }
}
