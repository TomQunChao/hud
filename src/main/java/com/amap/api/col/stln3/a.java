package com.amap.api.col.stln3;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

/* compiled from: JSON */
public abstract class a implements c, f {
    public static TimeZone a = TimeZone.getDefault();
    public static Locale b = Locale.getDefault();
    public static int c = (((n.UseBigDecimal.s | 0) | n.SortFeidFastMatch.s) | n.IgnoreNotMatch.s);
    public static String d = "yyyy-MM-dd HH:mm:ss";
    public static int e = ((((be.QuoteFieldNames.w | 0) | be.SkipTransientField.w) | be.WriteEnumUsingToString.w) | be.SortField.w);

    public static final Object a(String str) {
        int i = c;
        if (str == null) {
            return null;
        }
        l lVar = new l(str, w.a, i);
        Object a2 = lVar.a((Object) null);
        lVar.f();
        lVar.close();
        return a2;
    }

    public static final e b(String str) {
        Object a2 = a(str);
        if ((a2 instanceof e) || a2 == null) {
            return (e) a2;
        }
        e eVar = (e) a(a2, bc.a);
        if ((c & n.SupportAutoType.s) != 0) {
            eVar.put("@type", a2.getClass().getName());
        }
        return eVar;
    }

    public static final <T> T a(String str, Class<T> cls) {
        n[] nVarArr = new n[0];
        w wVar = w.a;
        int i = c;
        if (str == null) {
            return null;
        }
        for (n nVar : nVarArr) {
            i |= nVar.s;
        }
        l lVar = new l(str, wVar, i);
        T t = (T) lVar.a((Type) cls);
        lVar.f();
        lVar.close();
        return t;
    }

    public static final String a(Object obj) {
        return a(obj, bc.a, e, new be[0]);
    }

    public String toString() {
        return a();
    }

    @Override // com.amap.api.col.stln3.c
    public final String a() {
        bd bdVar = new bd(e, be.x);
        try {
            new ar(bdVar, bc.a).b(this);
            return bdVar.toString();
        } finally {
            bdVar.close();
        }
    }

    @Override // com.amap.api.col.stln3.f
    public final void a(Appendable appendable) {
        bd bdVar = new bd(e, be.x);
        try {
            new ar(bdVar, bc.a).b(this);
            appendable.append(bdVar.toString());
            bdVar.close();
        } catch (IOException e2) {
            throw new d(e2.getMessage(), e2);
        } catch (Throwable th) {
            bdVar.close();
            throw th;
        }
    }

    public static final Object b(Object obj) {
        return a(obj, bc.a);
    }

    public static Object a(Object obj, bc bcVar) {
        Map map;
        if (obj == null) {
            return null;
        }
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj instanceof Map) {
            Map map2 = (Map) obj;
            int size = map2.size();
            if (map2 instanceof LinkedHashMap) {
                map = new LinkedHashMap(size);
            } else if (map2 instanceof TreeMap) {
                map = new TreeMap();
            } else {
                map = new HashMap(size);
            }
            e eVar = new e(map);
            for (Map.Entry entry : map2.entrySet()) {
                eVar.put(bk.a(entry.getKey()), a(entry.getValue(), bc.a));
            }
            return eVar;
        } else if (obj instanceof Collection) {
            Collection<Object> collection = (Collection) obj;
            b bVar = new b(collection.size());
            for (Object obj2 : collection) {
                bVar.add(a(obj2, bc.a));
            }
            return bVar;
        } else {
            Class<?> cls = obj.getClass();
            if (cls.isEnum()) {
                return ((Enum) obj).name();
            }
            if (cls.isArray()) {
                int length = Array.getLength(obj);
                b bVar2 = new b(length);
                for (int i = 0; i < length; i++) {
                    bVar2.add(a(Array.get(obj, i), bc.a));
                }
                return bVar2;
            } else if (w.a(cls)) {
                return obj;
            } else {
                ay a2 = bcVar.a(cls);
                if (!(a2 instanceof as)) {
                    return null;
                }
                as asVar = (as) a2;
                e eVar2 = new e();
                try {
                    for (Map.Entry<String, Object> entry2 : asVar.a(obj).entrySet()) {
                        eVar2.put(entry2.getKey(), a(entry2.getValue(), bc.a));
                    }
                    return eVar2;
                } catch (Exception e2) {
                    throw new d("toJSON error", e2);
                }
            }
        }
    }

    private static String a(Object obj, bc bcVar, int i, be... beVarArr) {
        bd bdVar = new bd(i, beVarArr);
        try {
            ar arVar = new ar(bdVar, bcVar);
            for (be beVar : beVarArr) {
                arVar.b.a(beVar);
            }
            arVar.b(obj);
            return bdVar.toString();
        } finally {
            bdVar.close();
        }
    }
}
