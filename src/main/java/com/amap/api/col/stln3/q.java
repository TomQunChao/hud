package com.amap.api.col.stln3;

import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: JavaBeanDeserializer */
public class q implements ae {
    protected final Class<?> a;
    public final r b;
    private final ac[] c;
    private final ac[] d;
    private final Map<String, ac> e;
    private ConcurrentMap<String, Object> f;
    private transient long[] g;
    private transient int[] h;

    public q(w wVar, Class<?> cls, Type type) {
        this(cls, r.a(cls, cls.getModifiers(), type, wVar.d));
    }

    private q(Class<?> cls, r rVar) {
        this.a = cls;
        this.b = rVar;
        this.d = new ac[rVar.f.length];
        int length = rVar.f.length;
        HashMap hashMap = null;
        int i = 0;
        while (i < length) {
            bh bhVar = rVar.f[i];
            ac a2 = w.a(cls, bhVar);
            this.d[i] = a2;
            String[] strArr = bhVar.m;
            HashMap hashMap2 = hashMap;
            for (String str : strArr) {
                if (hashMap2 == null) {
                    hashMap2 = new HashMap();
                }
                hashMap2.put(str, a2);
            }
            i++;
            hashMap = hashMap2;
        }
        this.e = hashMap;
        this.c = new ac[rVar.e.length];
        int length2 = rVar.e.length;
        for (int i2 = 0; i2 < length2; i2++) {
            this.c[i2] = a(rVar.e[i2].a);
        }
    }

    /* access modifiers changed from: protected */
    public final Object a(l lVar, Type type) {
        Object obj;
        if ((type instanceof Class) && this.a.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new e((lVar.c.c & n.OrderedField.s) != 0));
        } else if (this.b.a == null && this.b.d == null) {
            return null;
        } else {
            if (this.b.d != null && this.b.b > 0) {
                return null;
            }
            try {
                Constructor<?> constructor = this.b.a;
                if (this.b.b != 0) {
                    obj = constructor.newInstance(lVar.d.a);
                } else if (constructor != null) {
                    obj = constructor.newInstance(new Object[0]);
                } else {
                    obj = this.b.d.invoke(null, new Object[0]);
                }
                if (!(lVar == null || (lVar.c.c & n.InitStringFieldAsEmpty.s) == 0)) {
                    bh[] bhVarArr = this.b.e;
                    for (bh bhVar : bhVarArr) {
                        if (bhVar.f == String.class) {
                            bhVar.a(obj, "");
                        }
                    }
                }
                return obj;
            } catch (Exception e2) {
                throw new d("create instance error, class " + this.a.getName(), e2);
            }
        }
    }

    @Override // com.amap.api.col.stln3.ae
    public <T> T a(l lVar, Type type, Object obj) {
        return (T) a(lVar, type, obj, null);
    }

    private <T> T b(l lVar, Type type, Object obj) {
        char c2;
        char c3;
        char c4;
        char c5;
        char c6;
        Enum r15;
        char c7;
        char c8;
        char c9;
        char c10;
        char c11;
        char c12;
        String str;
        char c13;
        char c14;
        char c15;
        char c16;
        char c17;
        o oVar = lVar.c;
        T t = (T) a(lVar, type);
        int length = this.d.length;
        int i = 0;
        while (i < length) {
            char c18 = i == length + -1 ? ']' : ',';
            ac acVar = this.d[i];
            bh bhVar = acVar.b;
            Class<?> cls = bhVar.f;
            try {
                if (cls == Integer.TYPE) {
                    int s = (int) oVar.s();
                    if (bhVar.d) {
                        bhVar.c.setInt(t, s);
                    } else {
                        acVar.a(t, new Integer(s));
                    }
                    if (oVar.d == ',') {
                        int i2 = oVar.e + 1;
                        oVar.e = i2;
                        if (i2 >= oVar.r) {
                            c17 = 26;
                        } else {
                            c17 = oVar.q.charAt(i2);
                        }
                        oVar.d = c17;
                        oVar.a = 16;
                    } else if (oVar.d == ']') {
                        int i3 = oVar.e + 1;
                        oVar.e = i3;
                        if (i3 >= oVar.r) {
                            c16 = 26;
                        } else {
                            c16 = oVar.q.charAt(i3);
                        }
                        oVar.d = c16;
                        oVar.a = 15;
                    } else {
                        oVar.f();
                    }
                } else if (cls == String.class) {
                    if (oVar.d == '\"') {
                        str = oVar.j();
                    } else {
                        if (oVar.d == 'n') {
                            if (oVar.q.startsWith("null", oVar.e)) {
                                oVar.e += 4;
                                int i4 = oVar.e;
                                if (oVar.e >= oVar.r) {
                                    c15 = 26;
                                } else {
                                    c15 = oVar.q.charAt(i4);
                                }
                                oVar.d = c15;
                                str = null;
                            }
                        }
                        throw new d("not match string. feild : " + obj);
                    }
                    if (bhVar.d) {
                        bhVar.c.set(t, str);
                    } else {
                        acVar.a(t, str);
                    }
                    if (oVar.d == ',') {
                        int i5 = oVar.e + 1;
                        oVar.e = i5;
                        if (i5 >= oVar.r) {
                            c14 = 26;
                        } else {
                            c14 = oVar.q.charAt(i5);
                        }
                        oVar.d = c14;
                        oVar.a = 16;
                    } else if (oVar.d == ']') {
                        int i6 = oVar.e + 1;
                        oVar.e = i6;
                        if (i6 >= oVar.r) {
                            c13 = 26;
                        } else {
                            c13 = oVar.q.charAt(i6);
                        }
                        oVar.d = c13;
                        oVar.a = 15;
                    } else {
                        oVar.f();
                    }
                } else if (cls == Long.TYPE) {
                    long s2 = oVar.s();
                    if (bhVar.d) {
                        bhVar.c.setLong(t, s2);
                    } else {
                        acVar.a(t, new Long(s2));
                    }
                    if (oVar.d == ',') {
                        int i7 = oVar.e + 1;
                        oVar.e = i7;
                        if (i7 >= oVar.r) {
                            c12 = 26;
                        } else {
                            c12 = oVar.q.charAt(i7);
                        }
                        oVar.d = c12;
                        oVar.a = 16;
                    } else if (oVar.d == ']') {
                        int i8 = oVar.e + 1;
                        oVar.e = i8;
                        if (i8 >= oVar.r) {
                            c11 = 26;
                        } else {
                            c11 = oVar.q.charAt(i8);
                        }
                        oVar.d = c11;
                        oVar.a = 15;
                    } else {
                        oVar.f();
                    }
                } else if (cls == Boolean.TYPE) {
                    boolean q = oVar.q();
                    if (bhVar.d) {
                        bhVar.c.setBoolean(t, q);
                    } else {
                        acVar.a(t, Boolean.valueOf(q));
                    }
                    if (oVar.d == ',') {
                        int i9 = oVar.e + 1;
                        oVar.e = i9;
                        if (i9 >= oVar.r) {
                            c10 = 26;
                        } else {
                            c10 = oVar.q.charAt(i9);
                        }
                        oVar.d = c10;
                        oVar.a = 16;
                    } else if (oVar.d == ']') {
                        int i10 = oVar.e + 1;
                        oVar.e = i10;
                        if (i10 >= oVar.r) {
                            c9 = 26;
                        } else {
                            c9 = oVar.q.charAt(i10);
                        }
                        oVar.d = c9;
                        oVar.a = 15;
                    } else {
                        oVar.f();
                    }
                } else if (cls.isEnum()) {
                    char c19 = oVar.d;
                    if (c19 == '\"') {
                        String a2 = oVar.a(lVar.a);
                        if (a2 == null) {
                            r15 = null;
                        } else {
                            r15 = Enum.valueOf(cls, a2);
                        }
                    } else if (c19 < '0' || c19 > '9') {
                        throw new d("illegal enum." + oVar.h());
                    } else {
                        r15 = ((m) ((k) acVar).a(lVar.b)).b[(int) oVar.s()];
                    }
                    acVar.a(t, r15);
                    if (oVar.d == ',') {
                        int i11 = oVar.e + 1;
                        oVar.e = i11;
                        if (i11 >= oVar.r) {
                            c8 = 26;
                        } else {
                            c8 = oVar.q.charAt(i11);
                        }
                        oVar.d = c8;
                        oVar.a = 16;
                    } else if (oVar.d == ']') {
                        int i12 = oVar.e + 1;
                        oVar.e = i12;
                        if (i12 >= oVar.r) {
                            c7 = 26;
                        } else {
                            c7 = oVar.q.charAt(i12);
                        }
                        oVar.d = c7;
                        oVar.a = 15;
                    } else {
                        oVar.f();
                    }
                } else if (cls == Date.class && oVar.d == '1') {
                    acVar.a(t, new Date(oVar.s()));
                    if (oVar.d == ',') {
                        int i13 = oVar.e + 1;
                        oVar.e = i13;
                        if (i13 >= oVar.r) {
                            c6 = 26;
                        } else {
                            c6 = oVar.q.charAt(i13);
                        }
                        oVar.d = c6;
                        oVar.a = 16;
                    } else if (oVar.d == ']') {
                        int i14 = oVar.e + 1;
                        oVar.e = i14;
                        if (i14 >= oVar.r) {
                            c5 = 26;
                        } else {
                            c5 = oVar.q.charAt(i14);
                        }
                        oVar.d = c5;
                        oVar.a = 15;
                    } else {
                        oVar.f();
                    }
                } else {
                    if (oVar.d == '[') {
                        int i15 = oVar.e + 1;
                        oVar.e = i15;
                        if (i15 >= oVar.r) {
                            c4 = 26;
                        } else {
                            c4 = oVar.q.charAt(i15);
                        }
                        oVar.d = c4;
                        oVar.a = 14;
                    } else if (oVar.d == '{') {
                        int i16 = oVar.e + 1;
                        oVar.e = i16;
                        if (i16 >= oVar.r) {
                            c3 = 26;
                        } else {
                            c3 = oVar.q.charAt(i16);
                        }
                        oVar.d = c3;
                        oVar.a = 12;
                    } else {
                        oVar.f();
                    }
                    acVar.a(lVar, t, bhVar.g, null);
                    if (c18 == ']') {
                        if (oVar.a != 15) {
                            throw new d("syntax error");
                        }
                    } else if (c18 != ',') {
                        continue;
                    } else if (oVar.a != 16) {
                        throw new d("syntax error");
                    }
                }
                i++;
            } catch (IllegalAccessException e2) {
                throw new d("set " + bhVar.a + "error", e2);
            }
        }
        if (oVar.d == ',') {
            int i17 = oVar.e + 1;
            oVar.e = i17;
            if (i17 >= oVar.r) {
                c2 = 26;
            } else {
                c2 = oVar.q.charAt(i17);
            }
            oVar.d = c2;
            oVar.a = 16;
        } else {
            oVar.f();
        }
        return t;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:224:0x043a, code lost:
        r10.d();
        r0 = r10.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x0440, code lost:
        if (r0 != 4) goto L_0x04e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x0442, code lost:
        r0 = r10.m();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x044c, code lost:
        if ("@".equals(r0) == false) goto L_0x0452;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x044e, code lost:
        r6 = (T) r14.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x0458, code lost:
        if ("..".equals(r0) == false) goto L_0x0470;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x045a, code lost:
        r1 = r14.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x045e, code lost:
        if (r1.a == null) goto L_0x0464;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x0460, code lost:
        r6 = (T) r1.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x0464, code lost:
        r35.a(new com.amap.api.col.stln3.l.a(r1, r0));
        r35.e = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x0476, code lost:
        if ("$".equals(r0) == false) goto L_0x04a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0479, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x047e, code lost:
        if (r1.b == null) goto L_0x0485;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0481, code lost:
        r1 = r1.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0489, code lost:
        if (r1.a == null) goto L_0x0491;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x048c, code lost:
        r6 = (T) r1.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0491, code lost:
        r35.a(new com.amap.api.col.stln3.l.a(r1, r0));
        r35.e = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x04a2, code lost:
        r35.a(new com.amap.api.col.stln3.l.a(r14, r0));
        r35.e = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x04b2, code lost:
        r10.a(13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x04bc, code lost:
        if (r10.a != 13) goto L_0x04d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x04bf, code lost:
        r10.a(16);
        r35.a(r14, r6, r37);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x04cc, code lost:
        if (r20 == null) goto L_0x04d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x04cf, code lost:
        r20.a = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x04d3, code lost:
        r35.a(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x04d8, code lost:
        return (T) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x04d9, code lost:
        r2 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x04e6, code lost:
        throw new com.amap.api.col.stln3.d("illegal ref");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x0509, code lost:
        throw new com.amap.api.col.stln3.d("illegal ref, " + com.amap.api.col.stln3.p.a(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x055b, code lost:
        r12 = r2;
        r13 = (T) r6;
        r1 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x057c, code lost:
        if (r4 != null) goto L_0x05bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x057f, code lost:
        r12 = r35.b.a(r1, r34.a, r10.c);
        r0 = com.amap.api.col.stln3.bk.c(r36);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x0592, code lost:
        if (r0 == null) goto L_0x05b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x0595, code lost:
        if (r12 == null) goto L_0x05a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:282:0x059d, code lost:
        if (r0.isAssignableFrom(r12) == false) goto L_0x05a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x05af, code lost:
        throw new com.amap.api.col.stln3.d("type not match");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x05b1, code lost:
        r4 = r35.b.a((java.lang.reflect.Type) r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x05bb, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x05c1, code lost:
        if ((r4 instanceof com.amap.api.col.stln3.q) == false) goto L_0x05dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x05c4, code lost:
        r4 = (com.amap.api.col.stln3.q) r4;
        r0 = (T) r4.a(r35, r12, r37, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x05cd, code lost:
        if (r3 == null) goto L_0x05db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x05d0, code lost:
        r4.a(r3).a(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x05dd, code lost:
        r0 = (T) r4.a(r35, r12, r37);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x05e5, code lost:
        if (r2 == null) goto L_0x05ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x05e8, code lost:
        r2.a = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x05ec, code lost:
        r35.a(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x05f1, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x0600, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:485:0x09e0, code lost:
        throw new com.amap.api.col.stln3.d("syntax error, unexpect token " + com.amap.api.col.stln3.p.a(r10.a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:496:0x0a0b, code lost:
        r12.a = r6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x040c A[SYNTHETIC, Splitter:B:211:0x040c] */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x0608  */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x0614 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x065a  */
    /* JADX WARNING: Removed duplicated region for block: B:409:0x0805  */
    /* JADX WARNING: Removed duplicated region for block: B:419:0x084a  */
    /* JADX WARNING: Removed duplicated region for block: B:486:0x09e1  */
    /* JADX WARNING: Removed duplicated region for block: B:496:0x0a0b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> T a(com.amap.api.col.stln3.l r35, java.lang.reflect.Type r36, java.lang.Object r37, java.lang.Object r38) {
        /*
        // Method dump skipped, instructions count: 2588
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.q.a(com.amap.api.col.stln3.l, java.lang.reflect.Type, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    private ac a(long j) {
        int i = 0;
        while (true) {
            ac[] acVarArr = this.d;
            if (i >= acVarArr.length) {
                return null;
            }
            ac acVar = acVarArr[i];
            if (acVar.b.l == j) {
                return acVar;
            }
            i++;
        }
    }

    /* access modifiers changed from: protected */
    public final ac a(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        if (this.b.h) {
            while (true) {
                ac[] acVarArr = this.d;
                if (i >= acVarArr.length) {
                    return null;
                }
                ac acVar = acVarArr[i];
                if (acVar.b.a.equalsIgnoreCase(str)) {
                    return acVar;
                }
                i++;
            }
        } else {
            int length = this.d.length - 1;
            while (i <= length) {
                int i2 = (i + length) >>> 1;
                int compareTo = this.d[i2].b.a.compareTo(str);
                if (compareTo < 0) {
                    i = i2 + 1;
                } else if (compareTo <= 0) {
                    return this.d[i2];
                } else {
                    length = i2 - 1;
                }
            }
            Map<String, ac> map = this.e;
            if (map != null) {
                return map.get(str);
            }
            return null;
        }
    }

    private boolean a(l lVar, String str, Object obj, Type type, Map<String, Object> map) {
        boolean z;
        o oVar = lVar.c;
        ac a2 = a(str);
        if (a2 == null) {
            long c2 = bk.c(str);
            if (this.g == null) {
                long[] jArr = new long[this.d.length];
                int i = 0;
                while (true) {
                    ac[] acVarArr = this.d;
                    if (i >= acVarArr.length) {
                        break;
                    }
                    jArr[i] = bk.c(acVarArr[i].b.a);
                    i++;
                }
                Arrays.sort(jArr);
                this.g = jArr;
            }
            int binarySearch = Arrays.binarySearch(this.g, c2);
            if (binarySearch < 0) {
                z = str.startsWith("is");
                if (z) {
                    binarySearch = Arrays.binarySearch(this.g, bk.c(str.substring(2)));
                }
            } else {
                z = false;
            }
            if (binarySearch >= 0) {
                if (this.h == null) {
                    int[] iArr = new int[this.g.length];
                    Arrays.fill(iArr, -1);
                    int i2 = 0;
                    while (true) {
                        ac[] acVarArr2 = this.d;
                        if (i2 >= acVarArr2.length) {
                            break;
                        }
                        int binarySearch2 = Arrays.binarySearch(this.g, bk.c(acVarArr2[i2].b.a));
                        if (binarySearch2 >= 0) {
                            iArr[binarySearch2] = i2;
                        }
                        i2++;
                    }
                    this.h = iArr;
                }
                int i3 = this.h[binarySearch];
                if (i3 != -1) {
                    a2 = this.d[i3];
                    Class<?> cls = a2.b.f;
                    if (!(!z || cls == Boolean.TYPE || cls == Boolean.class)) {
                        a2 = null;
                    }
                }
            }
        }
        int i4 = n.SupportNonPublicField.s;
        if (a2 == null && !((lVar.c.c & i4) == 0 && (i4 & this.b.l) == 0)) {
            if (this.f == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(1, 0.75f, 1);
                Class<?> cls2 = this.a;
                while (cls2 != null && cls2 != Object.class) {
                    Field[] declaredFields = cls2.getDeclaredFields();
                    for (Field field : declaredFields) {
                        String name = field.getName();
                        if (a(name) == null) {
                            int modifiers = field.getModifiers();
                            if ((modifiers & 16) == 0 && (modifiers & 8) == 0) {
                                concurrentHashMap.put(name, field);
                            }
                        }
                    }
                    cls2 = cls2.getSuperclass();
                }
                this.f = concurrentHashMap;
            }
            Object obj2 = this.f.get(str);
            if (obj2 != null) {
                if (obj2 instanceof ac) {
                    a2 = (ac) obj2;
                } else {
                    Field field2 = (Field) obj2;
                    field2.setAccessible(true);
                    bh bhVar = new bh(str, field2.getDeclaringClass(), field2.getType(), field2.getGenericType(), field2, 0, 0);
                    w wVar = lVar.b;
                    a2 = new k(this.a, bhVar);
                    this.f.put(str, a2);
                }
            }
        }
        if (a2 == null) {
            a(lVar, obj, str);
            return false;
        }
        oVar.d();
        a2.a(lVar, obj, type, map);
        return true;
    }

    private void a(l lVar, Object obj, String str) {
        List<ExtraProcessor> list;
        o oVar = lVar.c;
        if ((lVar.c.c & n.IgnoreNotMatch.s) != 0) {
            oVar.d();
            Type type = null;
            List<ab> list2 = lVar.f;
            if (list2 != null) {
                for (ab abVar : list2) {
                    type = abVar.a();
                }
            }
            if (type == null) {
                lVar.e();
            } else {
                lVar.a(type);
            }
            if (!(obj instanceof aa) && (list = lVar.g) != null) {
                Iterator<ExtraProcessor> it = list.iterator();
                while (it.hasNext()) {
                    it.next();
                }
                return;
            }
            return;
        }
        throw new d("setter not found, class " + this.a.getName() + ", property " + str);
    }

    public final Object a(Map<String, Object> map, w wVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object obj;
        if (this.b.c == null) {
            Object a2 = a((l) null, this.a);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                ac a3 = a(entry.getKey());
                if (a3 != null) {
                    Object value = entry.getValue();
                    Method method = a3.b.b;
                    if (method != null) {
                        method.invoke(a2, bk.a(value, method.getGenericParameterTypes()[0], wVar));
                    } else {
                        Field field = a3.b.c;
                        Type type = a3.b.g;
                        String str = a3.b.k;
                        if (str == null || type != Date.class || !(value instanceof String)) {
                            obj = bk.a(value, type, wVar);
                        } else {
                            try {
                                obj = new SimpleDateFormat(str).parse((String) value);
                            } catch (ParseException e2) {
                                obj = null;
                            }
                        }
                        field.set(a2, obj);
                    }
                }
            }
            return a2;
        }
        bh[] bhVarArr = this.b.e;
        int length = bhVarArr.length;
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            bh bhVar = bhVarArr[i];
            Object obj2 = map.get(bhVar.a);
            if (obj2 == null) {
                obj2 = bk.c(bhVar.f);
            }
            objArr[i] = obj2;
        }
        if (this.b.c == null) {
            return null;
        }
        try {
            return this.b.c.newInstance(objArr);
        } catch (Exception e3) {
            throw new d("create instance error, " + this.b.c.toGenericString(), e3);
        }
    }

    private q a(w wVar, r rVar, String str) {
        if (rVar.g == null) {
            return null;
        }
        for (Class<?> cls : rVar.g.h()) {
            ae a2 = wVar.a((Type) cls);
            if (a2 instanceof q) {
                q qVar = (q) a2;
                r rVar2 = qVar.b;
                if (rVar2.j.equals(str)) {
                    return qVar;
                }
                q a3 = a(wVar, rVar2, str);
                if (a3 != null) {
                    return a3;
                }
            }
        }
        return null;
    }
}
