package com.amap.api.col.stln3;

import java.lang.reflect.Type;

/* compiled from: ParseContext */
public final class v {
    public Object a;
    public final v b;
    public final Object c;
    public Type d;
    private transient String e;

    public v(v vVar, Object obj, Object obj2) {
        this.b = vVar;
        this.a = obj;
        this.c = obj2;
    }

    public final String toString() {
        if (this.e == null) {
            if (this.b == null) {
                this.e = "$";
            } else if (this.c instanceof Integer) {
                this.e = this.b.toString() + "[" + this.c + "]";
            } else {
                this.e = this.b.toString() + "." + this.c;
            }
        }
        return this.e;
    }
}
