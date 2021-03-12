package com.amap.api.col.stln3;

import com.amap.api.col.stln3.l;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* access modifiers changed from: package-private */
/* compiled from: MapDeserializer */
public final class u implements ae {
    public static u a = new u();

    u() {
    }

    @Override // com.amap.api.col.stln3.ae
    public final <T> T a(l lVar, Type type, Object obj) {
        if (type == e.class && lVar.h == null) {
            return (T) lVar.b();
        }
        o oVar = lVar.c;
        if (oVar.a == 8) {
            oVar.a(16);
            return null;
        }
        Map a2 = a(type);
        v vVar = lVar.d;
        try {
            lVar.a(vVar, a2, obj);
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type type2 = parameterizedType.getActualTypeArguments()[0];
                Type type3 = parameterizedType.getActualTypeArguments()[1];
                if (String.class == type2) {
                    return (T) a(lVar, a2, type3, obj);
                }
                T t = (T) a(lVar, (Map<Object, Object>) a2, type2, type3);
                lVar.a(vVar);
                return t;
            }
            T t2 = (T) lVar.a(a2, obj);
            lVar.a(vVar);
            return t2;
        } finally {
            lVar.a(vVar);
        }
    }

    private static Map a(l lVar, Map<String, Object> map, Type type, Object obj) {
        String str;
        o oVar = lVar.c;
        if (oVar.a == 12) {
            v vVar = lVar.d;
            while (true) {
                try {
                    oVar.o();
                    char c = oVar.d;
                    while (c == ',') {
                        oVar.c();
                        oVar.o();
                        c = oVar.d;
                    }
                    if (c == '\"') {
                        str = oVar.a(lVar.a, '\"');
                        oVar.o();
                        if (oVar.d != ':') {
                            throw new d("syntax error, " + oVar.h());
                        }
                    } else if (c == '}') {
                        oVar.c();
                        oVar.h = 0;
                        oVar.a(16);
                        lVar.a(vVar);
                        return map;
                    } else if (c == '\'') {
                        str = oVar.a(lVar.a, '\'');
                        oVar.o();
                        if (oVar.d != ':') {
                            throw new d("syntax error, " + oVar.h());
                        }
                    } else {
                        str = oVar.b(lVar.a);
                        oVar.o();
                        char c2 = oVar.d;
                        if (c2 != ':') {
                            throw new d("expect ':' at " + oVar.b + ", actual " + c2);
                        }
                    }
                    oVar.c();
                    oVar.o();
                    char c3 = oVar.d;
                    oVar.h = 0;
                    Object obj2 = null;
                    if (str != "@type" || oVar.a(n.DisableSpecialKeyDetect)) {
                        oVar.f();
                        lVar.a(vVar);
                        if (oVar.a == 8) {
                            oVar.f();
                        } else {
                            obj2 = lVar.a(type, str);
                        }
                        map.put(str, obj2);
                        if (lVar.e == 1) {
                            lVar.b(map, str);
                        }
                        lVar.a(vVar, obj2, str);
                        int i = oVar.a;
                        if (i == 20 || i == 15) {
                            lVar.a(vVar);
                        } else if (i == 13) {
                            oVar.f();
                            lVar.a(vVar);
                            return map;
                        }
                    } else {
                        Class<?> a2 = lVar.b.a(oVar.a(lVar.a, '\"'), null, oVar.c);
                        if (a2 == map.getClass()) {
                            oVar.a(16);
                            if (oVar.a == 13) {
                                oVar.a(16);
                                return map;
                            }
                        } else {
                            ae a3 = lVar.b.a((Type) a2);
                            oVar.a(16);
                            lVar.e = 2;
                            if (vVar != null && !(obj instanceof Integer)) {
                                lVar.d();
                            }
                            Map map2 = (Map) a3.a(lVar, a2, obj);
                            lVar.a(vVar);
                            return map2;
                        }
                    }
                } finally {
                    lVar.a(vVar);
                }
            }
            lVar.a(vVar);
            return map;
        }
        throw new d("syntax error, expect {, actual " + oVar.a);
    }

    private static Object a(l lVar, Map<Object, Object> map, Type type, Type type2) {
        Object obj;
        o oVar = lVar.c;
        int i = oVar.a;
        if (i == 12 || i == 16) {
            ae a2 = lVar.b.a(type);
            ae a3 = lVar.b.a(type2);
            oVar.f();
            v vVar = lVar.d;
            while (true) {
                try {
                    int i2 = oVar.a;
                    if (i2 == 13) {
                        oVar.a(16);
                        lVar.a(vVar);
                        return map;
                    } else if (i2 != 4 || oVar.h != 4 || !oVar.q.startsWith("$ref", oVar.k + 1) || oVar.a(n.DisableSpecialKeyDetect)) {
                        if (map.size() == 0 && i2 == 4 && "@type".equals(oVar.m()) && !oVar.a(n.DisableSpecialKeyDetect)) {
                            oVar.d();
                            oVar.a(16);
                            if (oVar.a == 13) {
                                oVar.f();
                                return map;
                            }
                            oVar.f();
                        }
                        Object a4 = a2.a(lVar, type, null);
                        if (oVar.a == 17) {
                            oVar.f();
                            Object a5 = a3.a(lVar, type2, a4);
                            if (lVar.e == 1) {
                                lVar.b(map, a4);
                            }
                            map.put(a4, a5);
                            if (oVar.a == 16) {
                                oVar.f();
                            }
                        } else {
                            throw new d("syntax error, expect :, actual " + oVar.a);
                        }
                    } else {
                        oVar.d();
                        if (oVar.a == 4) {
                            String m = oVar.m();
                            if ("..".equals(m)) {
                                obj = vVar.b.a;
                            } else if ("$".equals(m)) {
                                v vVar2 = vVar;
                                while (vVar2.b != null) {
                                    vVar2 = vVar2.b;
                                }
                                obj = vVar2.a;
                            } else {
                                lVar.a(new l.a(vVar, m));
                                lVar.e = 1;
                                obj = null;
                            }
                            oVar.a(13);
                            if (oVar.a == 13) {
                                oVar.a(16);
                                lVar.a(vVar);
                                return obj;
                            }
                            throw new d("illegal ref");
                        }
                        throw new d("illegal ref, " + p.a(i2));
                    }
                } finally {
                    lVar.a(vVar);
                }
            }
        } else {
            throw new d("syntax error, expect {, actual " + p.a(i));
        }
    }

    private static Map<?, ?> a(Type type) {
        while (type != Properties.class) {
            if (type == Hashtable.class) {
                return new Hashtable();
            }
            if (type == IdentityHashMap.class) {
                return new IdentityHashMap();
            }
            if (type == SortedMap.class || type == TreeMap.class) {
                return new TreeMap();
            }
            if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
                return new ConcurrentHashMap();
            }
            if (type == Map.class || type == HashMap.class) {
                return new HashMap();
            }
            if (type == LinkedHashMap.class) {
                return new LinkedHashMap();
            }
            if (type == e.class) {
                return new e();
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type rawType = parameterizedType.getRawType();
                if (EnumMap.class.equals(rawType)) {
                    return new EnumMap((Class) parameterizedType.getActualTypeArguments()[0]);
                }
                type = rawType;
            } else {
                Class cls = (Class) type;
                if (!cls.isInterface()) {
                    try {
                        return (Map) cls.newInstance();
                    } catch (Exception e) {
                        throw new d("unsupport type " + type, e);
                    }
                } else {
                    throw new d("unsupport type " + type);
                }
            }
        }
        return new Properties();
    }
}
