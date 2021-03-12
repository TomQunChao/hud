package com.amap.api.col.stln3;

import java.lang.reflect.Type;

/* compiled from: IdentityHashMap */
public final class bi<V> {
    private final a<V>[] a = new a[1024];
    private final int b = 1023;

    public final V a(Type type) {
        for (a<V> aVar = this.a[System.identityHashCode(type) & this.b]; aVar != null; aVar = aVar.d) {
            if (type == aVar.b) {
                return aVar.c;
            }
        }
        return null;
    }

    public final boolean a(Type type, V v) {
        int identityHashCode = System.identityHashCode(type);
        int i = this.b & identityHashCode;
        for (a<V> aVar = this.a[i]; aVar != null; aVar = aVar.d) {
            if (type == aVar.b) {
                aVar.c = v;
                return true;
            }
        }
        this.a[i] = new a<>(type, v, identityHashCode, this.a[i]);
        return false;
    }

    public final Class a(String str) {
        int i = 0;
        while (true) {
            a<V>[] aVarArr = this.a;
            if (i >= aVarArr.length) {
                return null;
            }
            a<V> aVar = aVarArr[i];
            if (aVar != null) {
                for (a<V> aVar2 = aVar; aVar2 != null; aVar2 = aVar2.d) {
                    Type type = aVar.b;
                    if (type instanceof Class) {
                        Class cls = (Class) type;
                        if (cls.getName().equals(str)) {
                            return cls;
                        }
                    }
                }
                continue;
            }
            i++;
        }
    }

    /* access modifiers changed from: protected */
    /* compiled from: IdentityHashMap */
    public static final class a<V> {
        public final int a;
        public final Type b;
        public V c;
        public final a<V> d;

        public a(Type type, V v, int i, a<V> aVar) {
            this.b = type;
            this.c = v;
            this.d = aVar;
            this.a = i;
        }
    }
}
