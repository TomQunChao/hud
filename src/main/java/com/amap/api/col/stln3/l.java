package com.amap.api.col.stln3;

import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import java.io.Closeable;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* compiled from: DefaultJSONParser */
public final class l implements Closeable {
    public final y a;
    public w b;
    public final o c;
    protected v d;
    public int e;
    protected List<ab> f;
    protected List<ExtraProcessor> g;
    public ad h;
    private String i;
    private DateFormat j;
    private v[] k;
    private int l;
    private List<a> m;

    public final DateFormat a() {
        if (this.j == null) {
            this.j = new SimpleDateFormat(this.i, this.c.n);
            this.j.setTimeZone(this.c.m);
        }
        return this.j;
    }

    public l(String str, w wVar, int i2) {
        this(new o(str, i2), wVar);
    }

    private l(o oVar, w wVar) {
        this.i = a.d;
        this.l = 0;
        this.e = 0;
        this.f = null;
        this.g = null;
        this.h = null;
        this.c = oVar;
        this.b = wVar;
        this.a = wVar.b;
        char c2 = 26;
        if (oVar.d == '{') {
            int i2 = oVar.e + 1;
            oVar.e = i2;
            oVar.d = i2 < oVar.r ? oVar.q.charAt(i2) : c2;
            oVar.a = 12;
        } else if (oVar.d == '[') {
            int i3 = oVar.e + 1;
            oVar.e = i3;
            oVar.d = i3 < oVar.r ? oVar.q.charAt(i3) : c2;
            oVar.a = 14;
        } else {
            oVar.f();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:395:0x0066 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:70:0x018e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:413:0x0066 */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.amap.api.col.stln3.o */
    /* JADX DEBUG: Multi-variable search result rejected for r7v20, resolved type: com.amap.api.col.stln3.o */
    /* JADX DEBUG: Multi-variable search result rejected for r6v40, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x06c5  */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x06e0  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x06ef  */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x06f4  */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x06fd  */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x0724  */
    /* JADX WARNING: Removed duplicated region for block: B:402:0x070c A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.util.Map r18, java.lang.Object r19) {
        /*
        // Method dump skipped, instructions count: 2442
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.l.a(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public final <T> T a(Class<T> cls) {
        return (T) a(cls, (Object) null);
    }

    public final <T> T a(Type type) {
        return (T) a(type, (Object) null);
    }

    public final <T> T a(Type type, Object obj) {
        if (this.c.a == 8) {
            this.c.f();
            return null;
        }
        if (this.c.a == 4) {
            if (type == byte[].class) {
                T t = (T) this.c.l();
                this.c.f();
                return t;
            } else if (type == char[].class) {
                String m2 = this.c.m();
                this.c.f();
                return (T) m2.toCharArray();
            }
        }
        try {
            return (T) this.b.a(type).a(this, type, obj);
        } catch (d e2) {
            throw e2;
        } catch (Exception e3) {
            throw new d(e3.getMessage(), e3);
        }
    }

    public final void a(Type type, Collection collection) {
        a(type, collection, (Object) null);
    }

    /* JADX INFO: finally extract failed */
    public final void a(Type type, Collection collection, Object obj) {
        ae aeVar;
        String str;
        if (this.c.a == 21 || this.c.a == 22) {
            this.c.f();
        }
        if (this.c.a == 14) {
            if (Integer.TYPE == type) {
                aeVar = ap.a;
                this.c.a(2);
            } else if (String.class == type) {
                aeVar = bf.a;
                this.c.a(4);
            } else {
                aeVar = this.b.a(type);
                this.c.a(12);
            }
            v vVar = this.d;
            if (!this.c.t) {
                a(this.d, collection, obj);
            }
            int i2 = 0;
            while (true) {
                try {
                    if (this.c.a == 16) {
                        this.c.f();
                    } else if (this.c.a != 15) {
                        Object obj2 = null;
                        if (Integer.TYPE == type) {
                            collection.add(ap.a.a(this, null, null));
                        } else if (String.class == type) {
                            if (this.c.a == 4) {
                                str = this.c.m();
                                this.c.a(16);
                            } else {
                                Object a2 = a((Object) null);
                                if (a2 == null) {
                                    str = null;
                                } else {
                                    str = a2.toString();
                                }
                            }
                            collection.add(str);
                        } else {
                            if (this.c.a == 8) {
                                this.c.f();
                            } else {
                                obj2 = aeVar.a(this, type, Integer.valueOf(i2));
                            }
                            collection.add(obj2);
                            if (this.e == 1) {
                                a(collection);
                            }
                        }
                        if (this.c.a == 16) {
                            this.c.f();
                        }
                        i2++;
                    } else {
                        this.d = vVar;
                        this.c.a(16);
                        return;
                    }
                } catch (Throwable th) {
                    this.d = vVar;
                    throw th;
                }
            }
        } else {
            throw new d("exepct '[', but " + p.a(this.c.a) + ", " + this.c.h());
        }
    }

    private void b(Object obj) {
        q qVar;
        ac acVar;
        Object obj2;
        Class<?> cls = obj.getClass();
        ae a2 = this.b.a((Type) cls);
        if (a2 instanceof q) {
            qVar = (q) a2;
        } else {
            qVar = null;
        }
        int i2 = this.c.a;
        if (i2 == 12 || i2 == 16) {
            while (true) {
                String a3 = this.c.a(this.a);
                if (a3 == null) {
                    if (this.c.a == 13) {
                        this.c.a(16);
                        return;
                    } else if (this.c.a == 16) {
                        continue;
                    }
                }
                if (qVar != null) {
                    acVar = qVar.a(a3);
                } else {
                    acVar = null;
                }
                if (acVar != null) {
                    Class<?> cls2 = acVar.b.f;
                    Type type = acVar.b.g;
                    if (cls2 == Integer.TYPE) {
                        this.c.d();
                        obj2 = ap.a.a(this, type, null);
                    } else if (cls2 == String.class) {
                        this.c.d();
                        obj2 = g();
                    } else if (cls2 == Long.TYPE) {
                        this.c.d();
                        obj2 = ap.a.a(this, type, null);
                    } else {
                        ae a4 = this.b.a(cls2, type);
                        this.c.d();
                        obj2 = a4.a(this, type, null);
                    }
                    acVar.a(obj, obj2);
                    if (this.c.a != 16 && this.c.a == 13) {
                        this.c.a(16);
                        return;
                    }
                } else if ((this.c.c & n.IgnoreNotMatch.s) != 0) {
                    this.c.d();
                    a((Object) null);
                    if (this.c.a == 13) {
                        this.c.f();
                        return;
                    }
                } else {
                    throw new d("setter not found, class " + cls.getName() + ", property " + a3);
                }
            }
        } else {
            throw new d("syntax error, expect {, actual " + p.a(i2));
        }
    }

    /* access modifiers changed from: protected */
    public final void a(Collection collection) {
        if (collection instanceof List) {
            a c2 = c();
            c2.a = new x(this, (List) collection, collection.size() - 1);
            c2.b = this.d;
            this.e = 0;
            return;
        }
        a c3 = c();
        c3.a = new x(collection);
        c3.b = this.d;
        this.e = 0;
    }

    /* access modifiers changed from: protected */
    public final void b(Map map, Object obj) {
        x xVar = new x(map, obj);
        a c2 = c();
        c2.a = xVar;
        c2.b = this.d;
        this.e = 0;
    }

    public final e b() {
        return (e) a((this.c.c & n.OrderedField.s) != 0 ? new e(new LinkedHashMap()) : new e(), (Object) null);
    }

    public final void b(Collection collection) {
        a(collection, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x013a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0142 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0208  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.util.Collection r17, java.lang.Object r18) {
        /*
        // Method dump skipped, instructions count: 744
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.l.a(java.util.Collection, java.lang.Object):void");
    }

    /* access modifiers changed from: protected */
    public final void a(a aVar) {
        if (this.m == null) {
            this.m = new ArrayList(2);
        }
        this.m.add(aVar);
    }

    /* access modifiers changed from: protected */
    public final a c() {
        List<a> list = this.m;
        return list.get(list.size() - 1);
    }

    public final void a(v vVar) {
        if (!this.c.t) {
            this.d = vVar;
        }
    }

    /* access modifiers changed from: protected */
    public final void d() {
        this.d = this.d.b;
        v[] vVarArr = this.k;
        int i2 = this.l;
        vVarArr[i2 - 1] = null;
        this.l = i2 - 1;
    }

    /* access modifiers changed from: protected */
    public final v a(v vVar, Object obj, Object obj2) {
        if (this.c.t) {
            return null;
        }
        this.d = new v(vVar, obj, obj2);
        int i2 = this.l;
        this.l = i2 + 1;
        v[] vVarArr = this.k;
        if (vVarArr == null) {
            this.k = new v[8];
        } else if (i2 >= vVarArr.length) {
            v[] vVarArr2 = new v[((vVarArr.length * 3) / 2)];
            System.arraycopy(vVarArr, 0, vVarArr2, 0, vVarArr.length);
            this.k = vVarArr2;
        }
        v[] vVarArr3 = this.k;
        v vVar2 = this.d;
        vVarArr3[i2] = vVar2;
        return vVar2;
    }

    public final Object e() {
        return a((Object) null);
    }

    public final Object a(Object obj) {
        boolean z = true;
        switch (this.c.a) {
            case 2:
                Number g2 = this.c.g();
                this.c.f();
                return g2;
            case 3:
                if ((this.c.c & n.UseBigDecimal.s) == 0) {
                    z = false;
                }
                Number a2 = this.c.a(z);
                this.c.f();
                return a2;
            case 4:
                String m2 = this.c.m();
                this.c.a(16);
                if ((this.c.c & n.AllowISO8601DateFormat.s) != 0) {
                    o oVar = new o(m2);
                    try {
                        if (oVar.b(true)) {
                            return oVar.o.getTime();
                        }
                        oVar.b();
                    } finally {
                        oVar.b();
                    }
                }
                return m2;
            case 5:
            case 10:
            case 11:
            case 13:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            default:
                throw new d("syntax error, " + this.c.h());
            case 6:
                this.c.a(16);
                return Boolean.TRUE;
            case 7:
                this.c.a(16);
                return Boolean.FALSE;
            case 8:
            case 23:
                this.c.f();
                return null;
            case 9:
                this.c.a(18);
                if (this.c.a == 18) {
                    this.c.a(10);
                    a(10);
                    long longValue = this.c.g().longValue();
                    a(2);
                    a(11);
                    return new Date(longValue);
                }
                throw new d("syntax error, " + this.c.h());
            case 12:
                return a((this.c.c & n.OrderedField.s) != 0 ? new e(new LinkedHashMap()) : new e(), obj);
            case 14:
                b bVar = new b();
                a(bVar, obj);
                return bVar;
            case 20:
                if (this.c.n()) {
                    return null;
                }
                throw new d("syntax error, " + this.c.h());
            case 21:
                this.c.f();
                HashSet hashSet = new HashSet();
                a(hashSet, obj);
                return hashSet;
            case 22:
                this.c.f();
                TreeSet treeSet = new TreeSet();
                a(treeSet, obj);
                return treeSet;
        }
    }

    public final void a(int i2) {
        if (this.c.a == i2) {
            this.c.f();
            return;
        }
        throw new d("syntax error, expect " + p.a(i2) + ", actual " + p.a(this.c.a));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            if (this.c.a != 20) {
                throw new d("not close json text, token : " + p.a(this.c.a));
            }
        } finally {
            this.c.b();
        }
    }

    public final void f() {
        List<a> list = this.m;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = this.m.get(i2);
                ac acVar = aVar.a;
                if (acVar != null) {
                    Object obj = null;
                    Object obj2 = aVar.b != null ? aVar.b.a : null;
                    String str = aVar.d;
                    if (str.startsWith("$")) {
                        for (int i3 = 0; i3 < this.l; i3++) {
                            if (str.equals(this.k[i3].toString())) {
                                obj = this.k[i3].a;
                            }
                        }
                    } else {
                        obj = aVar.c.a;
                    }
                    acVar.a(obj2, obj);
                }
            }
        }
    }

    public final String g() {
        int i2 = this.c.a;
        if (i2 == 4) {
            String m2 = this.c.m();
            char c2 = 26;
            if (this.c.d == ',') {
                o oVar = this.c;
                int i3 = oVar.e + 1;
                oVar.e = i3;
                o oVar2 = this.c;
                if (i3 < oVar2.r) {
                    c2 = this.c.q.charAt(i3);
                }
                oVar2.d = c2;
                this.c.a = 16;
            } else if (this.c.d == ']') {
                o oVar3 = this.c;
                int i4 = oVar3.e + 1;
                oVar3.e = i4;
                o oVar4 = this.c;
                if (i4 < oVar4.r) {
                    c2 = this.c.q.charAt(i4);
                }
                oVar4.d = c2;
                this.c.a = 15;
            } else if (this.c.d == '}') {
                o oVar5 = this.c;
                int i5 = oVar5.e + 1;
                oVar5.e = i5;
                o oVar6 = this.c;
                if (i5 < oVar6.r) {
                    c2 = this.c.q.charAt(i5);
                }
                oVar6.d = c2;
                this.c.a = 13;
            } else {
                this.c.f();
            }
            return m2;
        } else if (i2 == 2) {
            String e2 = this.c.e();
            this.c.a(16);
            return e2;
        } else {
            Object a2 = a((Object) null);
            if (a2 == null) {
                return null;
            }
            return a2.toString();
        }
    }

    /* compiled from: DefaultJSONParser */
    public static class a {
        public ac a;
        public v b;
        private final v c;
        private final String d;

        public a(v vVar, String str) {
            this.c = vVar;
            this.d = str;
        }
    }
}
