package com.amap.api.col.stln3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: JavaBeanSerializer */
public final class as implements ay {
    private static final char[] d = {'t', 'r', 'u', 'e'};
    private static final char[] e = {'f', 'a', 'l', 's', 'e'};
    protected int a;
    protected final String b;
    protected final String c;
    private final ao[] f;
    private final ao[] g;

    public as(Class<?> cls, g gVar) {
        this(cls, cls.getModifiers(), gVar);
    }

    private as(Class<?> cls, int i, g gVar) {
        String str;
        String str2;
        g i2;
        this.a = 0;
        j jVar = (j) cls.getAnnotation(j.class);
        String[] strArr = null;
        if (jVar != null) {
            this.a = be.a(jVar.c());
            str2 = jVar.f();
            if (str2.length() == 0) {
                str2 = null;
                str = null;
            } else {
                Class<? super Object> superclass = cls.getSuperclass();
                String str3 = null;
                while (superclass != null && superclass != Object.class) {
                    j jVar2 = (j) superclass.getAnnotation(j.class);
                    if (jVar2 == null) {
                        break;
                    }
                    str3 = jVar2.g();
                    if (str3.length() != 0) {
                        break;
                    }
                    superclass = superclass.getSuperclass();
                }
                str = str3;
                for (Class<?> cls2 : cls.getInterfaces()) {
                    j jVar3 = (j) cls2.getAnnotation(j.class);
                    if (jVar3 != null) {
                        str = jVar3.g();
                        if (str.length() != 0) {
                            break;
                        }
                    }
                }
                if (str != null && str.length() == 0) {
                    str = null;
                }
            }
            if (gVar == null && (i2 = jVar.i()) != g.CamelCase) {
                gVar = i2;
            }
        } else {
            str2 = null;
            str = null;
        }
        this.b = str2;
        this.c = str;
        List<bh> a2 = bk.a(cls, i, jVar, false, gVar);
        ArrayList arrayList = new ArrayList();
        for (bh bhVar : a2) {
            arrayList.add(new ao(bhVar));
        }
        this.f = (ao[]) arrayList.toArray(new ao[arrayList.size()]);
        strArr = jVar != null ? jVar.a() : strArr;
        if (strArr == null || strArr.length == 0) {
            ao[] aoVarArr = this.f;
            ao[] aoVarArr2 = new ao[aoVarArr.length];
            System.arraycopy(aoVarArr, 0, aoVarArr2, 0, aoVarArr.length);
            Arrays.sort(aoVarArr2);
            if (Arrays.equals(aoVarArr2, this.f)) {
                this.g = this.f;
            } else {
                this.g = aoVarArr2;
            }
        } else {
            List<bh> a3 = bk.a(cls, i, jVar, true, gVar);
            ArrayList arrayList2 = new ArrayList();
            for (bh bhVar2 : a3) {
                arrayList2.add(new ao(bhVar2));
            }
            this.g = (ao[]) arrayList2.toArray(new ao[arrayList2.size()]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:287:0x0571  */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x0741 A[Catch:{ Exception -> 0x0908, all -> 0x0906 }] */
    /* JADX WARNING: Removed duplicated region for block: B:471:0x0962 A[SYNTHETIC, Splitter:B:471:0x0962] */
    @Override // com.amap.api.col.stln3.ay
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.amap.api.col.stln3.ar r34, java.lang.Object r35, java.lang.Object r36, java.lang.reflect.Type r37) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 2447
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.as.a(com.amap.api.col.stln3.ar, java.lang.Object, java.lang.Object, java.lang.reflect.Type):void");
    }

    public final Map<String, Object> a(Object obj) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.g.length);
        ao[] aoVarArr = this.g;
        for (ao aoVar : aoVarArr) {
            linkedHashMap.put(aoVar.a.a, aoVar.a(obj));
        }
        return linkedHashMap;
    }
}
