package com.amap.api.col.stln3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: JavaBeanInfo */
public final class r {
    final Constructor<?> a;
    final int b;
    final Constructor<?> c;
    final Method d;
    final bh[] e;
    final bh[] f;
    final j g;
    boolean h = false;
    final boolean i;
    public final String j;
    public final String k;
    public final int l;
    public final String[] m;

    private r(Class<?> cls, Constructor<?> constructor, Constructor<?> constructor2, Method method, bh[] bhVarArr, bh[] bhVarArr2, j jVar, String[] strArr) {
        int i2;
        boolean z;
        int i3 = 0;
        this.a = constructor;
        this.c = constructor2;
        this.d = method;
        this.e = bhVarArr;
        this.g = jVar;
        if (strArr == null || strArr.length != bhVarArr.length) {
            this.m = strArr;
        } else {
            this.m = null;
        }
        if (jVar != null) {
            String f2 = jVar.f();
            this.j = f2.length() <= 0 ? cls.getName() : f2;
            String g2 = jVar.g();
            this.k = g2.length() <= 0 ? null : g2;
            i2 = 0;
            for (n nVar : jVar.d()) {
                i2 |= nVar.s;
            }
        } else {
            this.j = cls.getName();
            this.k = null;
            i2 = 0;
        }
        this.l = i2;
        if (jVar != null) {
            n[] d2 = jVar.d();
            z = false;
            for (n nVar2 : d2) {
                if (nVar2 == n.SupportArrayToBean) {
                    z = true;
                }
            }
        } else {
            z = false;
        }
        this.i = z;
        bh[] a2 = a(bhVarArr, bhVarArr2);
        this.f = Arrays.equals(bhVarArr, a2) ? bhVarArr : a2;
        if (constructor != null) {
            i3 = constructor.getParameterTypes().length;
        } else if (method != null) {
            i3 = method.getParameterTypes().length;
        }
        this.b = i3;
    }

    private bh[] a(bh[] bhVarArr, bh[] bhVarArr2) {
        String[] a2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        j jVar = this.g;
        if (!(jVar == null || (a2 = jVar.a()) == null || a2.length == 0)) {
            int i2 = 0;
            while (true) {
                if (i2 >= a2.length) {
                    z = true;
                    break;
                }
                int i3 = 0;
                while (true) {
                    if (i3 >= bhVarArr2.length) {
                        z4 = false;
                        break;
                    } else if (bhVarArr2[i3].a.equals(a2[i2])) {
                        z4 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (!z4) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (!z) {
                return bhVarArr2;
            }
            if (a2.length == bhVarArr.length) {
                int i4 = 0;
                while (true) {
                    if (i4 >= a2.length) {
                        z3 = true;
                        break;
                    } else if (!bhVarArr2[i4].a.equals(a2[i4])) {
                        z3 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (z3) {
                    return bhVarArr2;
                }
                bh[] bhVarArr3 = new bh[bhVarArr2.length];
                for (int i5 = 0; i5 < a2.length; i5++) {
                    int i6 = 0;
                    while (true) {
                        if (i6 >= bhVarArr2.length) {
                            break;
                        } else if (bhVarArr2[i6].a.equals(a2[i5])) {
                            bhVarArr3[i5] = bhVarArr2[i6];
                            break;
                        } else {
                            i6++;
                        }
                    }
                }
                this.h = true;
                return bhVarArr3;
            }
            bh[] bhVarArr4 = new bh[bhVarArr2.length];
            for (int i7 = 0; i7 < a2.length; i7++) {
                int i8 = 0;
                while (true) {
                    if (i8 >= bhVarArr2.length) {
                        break;
                    } else if (bhVarArr2[i8].a.equals(a2[i7])) {
                        bhVarArr4[i7] = bhVarArr2[i8];
                        break;
                    } else {
                        i8++;
                    }
                }
            }
            int length = a2.length;
            for (int i9 = 0; i9 < bhVarArr2.length; i9++) {
                int i10 = 0;
                while (true) {
                    if (i10 >= bhVarArr4.length || i10 >= length) {
                        z2 = false;
                    } else if (bhVarArr4[i9].b(bhVarArr2[i10])) {
                        z2 = true;
                        break;
                    } else {
                        i10++;
                    }
                }
                z2 = false;
                if (!z2) {
                    bhVarArr4[length] = bhVarArr2[i9];
                    length++;
                }
            }
            this.h = true;
        }
        return bhVarArr2;
    }

    private static boolean a(List<bh> list, bh bhVar) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            bh bhVar2 = list.get(i2);
            if (bhVar2.a.equals(bhVar.a) && (!bhVar2.i || bhVar.i)) {
                return false;
            }
        }
        list.add(bhVar);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:314:0x0767, code lost:
        if (r2.length() > 0) goto L_0x0788;
     */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x057b  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x0581  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.amap.api.col.stln3.r a(java.lang.Class<?> r31, int r32, java.lang.reflect.Type r33, com.amap.api.col.stln3.g r34) {
        /*
        // Method dump skipped, instructions count: 2044
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.r.a(java.lang.Class, int, java.lang.reflect.Type, com.amap.api.col.stln3.g):com.amap.api.col.stln3.r");
    }
}
