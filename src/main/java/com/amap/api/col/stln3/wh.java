package com.amap.api.col.stln3;

/* compiled from: MapLocFilter */
public final class wh {
    private static wh b = null;
    long a = 0;
    private wl c = null;
    private long d = 0;
    private long e = 0;

    private wh() {
    }

    public static synchronized wh a() {
        wh whVar;
        synchronized (wh.class) {
            if (b == null) {
                b = new wh();
            }
            whVar = b;
        }
        return whVar;
    }

    public static wl b(wl wlVar) {
        return wlVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e6, code lost:
        if ((r9 - r2) > 30000) goto L_0x00e8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.amap.api.col.stln3.wl a(com.amap.api.col.stln3.wl r20) {
        /*
        // Method dump skipped, instructions count: 314
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.wh.a(com.amap.api.col.stln3.wl):com.amap.api.col.stln3.wl");
    }
}
