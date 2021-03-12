package com.amap.api.col.stln3;

/* compiled from: DynamicSoUtil */
public final class hh {
    private static sv a;

    public static sv a() {
        if (a == null) {
            try {
                a = new sv(ic.f());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return a;
    }
}
