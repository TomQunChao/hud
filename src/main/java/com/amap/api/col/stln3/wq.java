package com.amap.api.col.stln3;

import java.util.HashMap;

/* compiled from: CellAgeEstimator */
public final class wq {
    private HashMap<Long, wr> a = new HashMap<>();
    private long b = 0;

    private static long a(int i, int i2) {
        return (((long) i2) & 65535) | ((((long) i) & 65535) << 32);
    }

    public final long a(wr wrVar) {
        long j;
        int i;
        int i2;
        if (wrVar == null || !wrVar.o) {
            return 0;
        }
        HashMap<Long, wr> hashMap = this.a;
        switch (wrVar.k) {
            case 1:
            case 3:
            case 4:
                i2 = wrVar.c;
                i = wrVar.d;
                j = a(i2, i);
                break;
            case 2:
                i2 = wrVar.h;
                i = wrVar.i;
                j = a(i2, i);
                break;
            default:
                j = 0;
                break;
        }
        wr wrVar2 = hashMap.get(Long.valueOf(j));
        if (wrVar2 == null) {
            wrVar.m = xb.b();
            hashMap.put(Long.valueOf(j), wrVar);
            return 0;
        } else if (wrVar2.j != wrVar.j) {
            wrVar.m = xb.b();
            hashMap.put(Long.valueOf(j), wrVar);
            return 0;
        } else {
            wrVar.m = wrVar2.m;
            hashMap.put(Long.valueOf(j), wrVar);
            return (xb.b() - wrVar2.m) / 1000;
        }
    }

    public final void a() {
        this.a.clear();
        this.b = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0059 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.ArrayList<? extends com.amap.api.col.stln3.wr> r13) {
        /*
        // Method dump skipped, instructions count: 168
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.wq.a(java.util.ArrayList):void");
    }
}
