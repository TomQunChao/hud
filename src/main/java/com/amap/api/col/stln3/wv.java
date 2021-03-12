package com.amap.api.col.stln3;

/* compiled from: LocNetManager */
public final class wv {
    private static wv b = null;
    tr a;
    private int c;
    private int d;
    private boolean e;
    private int f;

    private wv() {
        this.a = null;
        this.c = 0;
        this.d = wy.f;
        this.e = false;
        this.f = 0;
        this.a = tr.a();
    }

    public static wv a() {
        if (b == null) {
            b = new wv();
        }
        return b;
    }

    public final ty a(ww wwVar) throws Throwable {
        long b2 = xb.b();
        tr trVar = this.a;
        ty a2 = tr.a(wwVar, this.e);
        this.c = Long.valueOf(xb.b() - b2).intValue();
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x00de A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.amap.api.col.stln3.ww a(android.content.Context r11, byte[] r12, java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 252
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.wv.a(android.content.Context, byte[], java.lang.String):com.amap.api.col.stln3.ww");
    }

    public final void a(long j, boolean z) {
        try {
            this.e = z;
            this.d = Long.valueOf(j).intValue();
            this.f = 0;
        } catch (Throwable th) {
            wy.a(th, "netmanager", "setOption");
        }
    }
}
