package com.amap.api.col.stln3;

import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: CellAgeEstimator */
public final class ve {
    private HashMap<Long, vf> a = new HashMap<>();
    private long b = 0;

    public final long a(vf vfVar) {
        long j;
        if (vfVar == null || !vfVar.o) {
            return 0;
        }
        HashMap<Long, vf> hashMap = this.a;
        switch (vfVar.k) {
            case 1:
            case 3:
            case 4:
                j = a(vfVar.c, vfVar.d);
                break;
            case 2:
                j = a(vfVar.h, vfVar.i);
                break;
            default:
                j = 0;
                break;
        }
        vf vfVar2 = hashMap.get(Long.valueOf(j));
        if (vfVar2 == null) {
            vfVar.m = wc.b();
            hashMap.put(Long.valueOf(j), vfVar);
            return 0;
        } else if (vfVar2.j != vfVar.j) {
            vfVar.m = wc.b();
            hashMap.put(Long.valueOf(j), vfVar);
            return 0;
        } else {
            vfVar.m = vfVar2.m;
            hashMap.put(Long.valueOf(j), vfVar);
            return (wc.b() - vfVar2.m) / 1000;
        }
    }

    public final void a(ArrayList<? extends vf> arrayList) {
        if (arrayList != null) {
            long b2 = wc.b();
            long j = this.b;
            if (j <= 0 || b2 - j >= 60000) {
                HashMap<Long, vf> hashMap = this.a;
                int size = arrayList.size();
                long j2 = 0;
                for (int i = 0; i < size; i++) {
                    vf vfVar = (vf) arrayList.get(i);
                    if (vfVar.o) {
                        switch (vfVar.k) {
                            case 1:
                            case 3:
                            case 4:
                                j2 = a(vfVar.c, vfVar.d);
                                break;
                            case 2:
                                j2 = a(vfVar.h, vfVar.i);
                                break;
                        }
                        vf vfVar2 = hashMap.get(Long.valueOf(j2));
                        if (vfVar2 != null) {
                            if (vfVar2.j == vfVar.j) {
                                vfVar.m = vfVar2.m;
                            } else {
                                vfVar.m = b2;
                            }
                        }
                    }
                }
                hashMap.clear();
                int size2 = arrayList.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    vf vfVar3 = (vf) arrayList.get(i2);
                    if (vfVar3.o) {
                        switch (vfVar3.k) {
                            case 1:
                            case 3:
                            case 4:
                                j2 = a(vfVar3.c, vfVar3.d);
                                break;
                            case 2:
                                j2 = a(vfVar3.h, vfVar3.i);
                                break;
                        }
                        hashMap.put(Long.valueOf(j2), vfVar3);
                    }
                }
                this.b = b2;
            }
        }
    }

    public final void a() {
        this.a.clear();
        this.b = 0;
    }

    private static long a(int i, int i2) {
        return (((long) i2) & 65535) | ((((long) i) & 65535) << 32);
    }
}
