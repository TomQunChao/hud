package com.amap.api.col.stln3;

import java.lang.reflect.Type;
import java.util.Arrays;

/* compiled from: EnumDeserializer */
public final class m implements ae {
    protected final Enum[] a;
    protected final Enum[] b;
    protected long[] c;
    private final Class<?> d;

    public m(Class<?> cls) {
        this.d = cls;
        this.b = (Enum[]) cls.getEnumConstants();
        Enum[] enumArr = this.b;
        long[] jArr = new long[enumArr.length];
        this.c = new long[enumArr.length];
        int i = 0;
        while (true) {
            Enum[] enumArr2 = this.b;
            if (i >= enumArr2.length) {
                break;
            }
            String name = enumArr2[i].name();
            long j = -3750763034362895579L;
            for (int i2 = 0; i2 < name.length(); i2++) {
                j = (j ^ ((long) name.charAt(i2))) * 1099511628211L;
            }
            jArr[i] = j;
            this.c[i] = j;
            i++;
        }
        Arrays.sort(this.c);
        this.a = new Enum[this.b.length];
        for (int i3 = 0; i3 < this.c.length; i3++) {
            int i4 = 0;
            while (true) {
                if (i4 >= jArr.length) {
                    break;
                } else if (this.c[i3] == jArr[i4]) {
                    this.a[i3] = this.b[i4];
                    break;
                } else {
                    i4++;
                }
            }
        }
    }

    @Override // com.amap.api.col.stln3.ae
    public final <T> T a(l lVar, Type type, Object obj) {
        try {
            o oVar = lVar.c;
            int i = oVar.a;
            if (i == 2) {
                int k = oVar.k();
                oVar.a(16);
                if (k >= 0 && k <= this.b.length) {
                    return (T) this.b[k];
                }
                throw new d("parse enum " + this.d.getName() + " error, value : " + k);
            } else if (i == 4) {
                String m = oVar.m();
                oVar.a(16);
                if (m.length() == 0) {
                    return null;
                }
                long j = -3750763034362895579L;
                for (int i2 = 0; i2 < m.length(); i2++) {
                    j = (j ^ ((long) m.charAt(i2))) * 1099511628211L;
                }
                int binarySearch = Arrays.binarySearch(this.c, j);
                if (binarySearch < 0) {
                    return null;
                }
                return (T) this.a[binarySearch];
            } else if (i == 8) {
                oVar.a(16);
                return null;
            } else {
                Object e = lVar.e();
                throw new d("parse enum " + this.d.getName() + " error, value : " + e);
            }
        } catch (d e2) {
            throw e2;
        } catch (Exception e3) {
            throw new d(e3.getMessage(), e3);
        }
    }
}
