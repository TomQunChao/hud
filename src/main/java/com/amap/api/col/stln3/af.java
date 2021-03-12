package com.amap.api.col.stln3;

/* compiled from: AfterFilter */
public abstract class af {
    private static final ThreadLocal<ar> a = new ThreadLocal<>();
    private static final ThreadLocal<Character> b = new ThreadLocal<>();
    private static final Character c = ',';

    static char a(ar arVar, char c2) {
        a.set(arVar);
        b.set(Character.valueOf(c2));
        a.set(null);
        return b.get().charValue();
    }
}
