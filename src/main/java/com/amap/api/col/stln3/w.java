package com.amap.api.col.stln3;

import java.io.Closeable;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

/* compiled from: ParserConfig */
public final class w {
    public static w a = new w();
    private static long[] f = {-7600952144447537354L, -4082057040235125754L, -2364987994247679115L, -676156662527871184L, -254670111376247151L, 1502845958873959152L, 4147696707147271408L, 5347909877633654828L, 5751393439502795295L, 7702607466162283393L};
    public final y b = new y();
    public ClassLoader c;
    public g d;
    public boolean e;
    private final bi<ae> g = new bi<>();

    public static w a() {
        return a;
    }

    public w() {
        this.g.a(SimpleDateFormat.class, av.a);
        this.g.a(Date.class, am.a);
        this.g.a(Calendar.class, am.a);
        this.g.a(Map.class, u.a);
        this.g.a(HashMap.class, u.a);
        this.g.a(LinkedHashMap.class, u.a);
        this.g.a(TreeMap.class, u.a);
        this.g.a(ConcurrentMap.class, u.a);
        this.g.a(ConcurrentHashMap.class, u.a);
        this.g.a(Collection.class, al.a);
        this.g.a(List.class, al.a);
        this.g.a(ArrayList.class, al.a);
        this.g.a(Object.class, s.a);
        this.g.a(String.class, bf.a);
        this.g.a(Character.TYPE, av.a);
        this.g.a(Character.class, av.a);
        this.g.a(Byte.TYPE, ax.a);
        this.g.a(Byte.class, ax.a);
        this.g.a(Short.TYPE, ax.a);
        this.g.a(Short.class, ax.a);
        this.g.a(Integer.TYPE, ap.a);
        this.g.a(Integer.class, ap.a);
        this.g.a(Long.TYPE, ap.a);
        this.g.a(Long.class, ap.a);
        this.g.a(BigInteger.class, aj.a);
        this.g.a(BigDecimal.class, aj.a);
        this.g.a(Float.TYPE, ax.a);
        this.g.a(Float.class, ax.a);
        this.g.a(Double.TYPE, ax.a);
        this.g.a(Double.class, ax.a);
        this.g.a(Boolean.TYPE, ak.a);
        this.g.a(Boolean.class, ak.a);
        this.g.a(Class.class, av.a);
        this.g.a(char[].class, ag.a);
        this.g.a(Object[].class, ag.a);
        this.g.a(UUID.class, av.a);
        this.g.a(TimeZone.class, av.a);
        this.g.a(Locale.class, av.a);
        this.g.a(Currency.class, av.a);
        this.g.a(URI.class, av.a);
        this.g.a(URL.class, av.a);
        this.g.a(Pattern.class, av.a);
        this.g.a(Charset.class, av.a);
        this.g.a(Number.class, ax.a);
        this.g.a(StackTraceElement.class, av.a);
        this.g.a(Serializable.class, s.a);
        this.g.a(Cloneable.class, s.a);
        this.g.a(Comparable.class, s.a);
        this.g.a(Closeable.class, s.a);
    }

    public final ae a(Type type) {
        while (true) {
            ae a2 = this.g.a(type);
            if (a2 == null) {
                if (!(type instanceof Class)) {
                    if (!(type instanceof ParameterizedType)) {
                        if (!(type instanceof WildcardType)) {
                            break;
                        }
                        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
                        if (upperBounds.length != 1) {
                            break;
                        }
                        type = upperBounds[0];
                    } else {
                        Type rawType = ((ParameterizedType) type).getRawType();
                        if (rawType instanceof Class) {
                            return a((Class) rawType, type);
                        }
                        type = rawType;
                    }
                } else {
                    return a((Class) type, type);
                }
            } else {
                return a2;
            }
        }
        return s.a;
    }

    public final ae a(Class<?> cls, Type type) {
        ae a2;
        ae aeVar;
        j jVar;
        Class<?> e2;
        while (true) {
            ae a3 = this.g.a(type);
            if (a3 != null) {
                return a3;
            }
            if (type == null) {
                type = cls;
            }
            a2 = this.g.a(type);
            if (a2 != null) {
                return a2;
            }
            if (!a(cls) && (jVar = (j) cls.getAnnotation(j.class)) != null && (e2 = jVar.e()) != Void.class) {
                cls = e2;
                type = cls;
            }
        }
        if ((type instanceof WildcardType) || (type instanceof TypeVariable) || (type instanceof ParameterizedType)) {
            a2 = this.g.a(cls);
        }
        if (a2 != null) {
            return a2;
        }
        ae a4 = this.g.a(type);
        if (a4 != null) {
            return a4;
        }
        if (cls.isEnum()) {
            aeVar = new m(cls);
        } else if (cls.isArray()) {
            aeVar = ag.a;
        } else if (cls == Set.class || cls == HashSet.class || cls == Collection.class || cls == List.class || cls == ArrayList.class) {
            aeVar = al.a;
        } else if (Collection.class.isAssignableFrom(cls)) {
            aeVar = al.a;
        } else if (Map.class.isAssignableFrom(cls)) {
            aeVar = u.a;
        } else if (Throwable.class.isAssignableFrom(cls)) {
            aeVar = new z(this, cls);
        } else if (cls.getName().equals("android.net.Uri")) {
            aeVar = av.a;
        } else {
            aeVar = new q(this, cls, type);
        }
        this.g.a(type, aeVar);
        return aeVar;
    }

    public static ac a(Class<?> cls, bh bhVar) {
        Class<?> cls2 = bhVar.f;
        if (cls2 == List.class || cls2 == ArrayList.class || (cls2.isArray() && !cls2.getComponentType().isPrimitive())) {
            return new t(cls, bhVar);
        }
        return new k(cls, bhVar);
    }

    public static boolean a(Class<?> cls) {
        return cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == Date.class || cls == java.sql.Date.class || cls == Time.class || cls == Timestamp.class;
    }

    public final Class<?> a(String str, Class<?> cls, int i) {
        if (str == null) {
            return null;
        }
        if (str.length() < 128) {
            if (str.length() >= 3) {
                long charAt = (((long) str.charAt(0)) ^ -3750763034362895579L) * 1099511628211L;
                if (charAt == -5808493101479473382L) {
                    throw new d("autoType is not support. " + str);
                } else if ((charAt ^ ((long) str.charAt(str.length() - 1))) * 1099511628211L != 655701488918567152L) {
                    long charAt2 = (((((((long) str.charAt(0)) ^ -3750763034362895579L) * 1099511628211L) ^ ((long) str.charAt(1))) * 1099511628211L) ^ ((long) str.charAt(2))) * 1099511628211L;
                    for (int i2 = 3; i2 < str.length(); i2++) {
                        charAt2 = (charAt2 ^ ((long) str.charAt(i2))) * 1099511628211L;
                        if (Arrays.binarySearch(f, charAt2) >= 0 && bk.a(str) == null) {
                            throw new d("autoType is not support. " + str);
                        }
                    }
                    Class<?> a2 = bk.a(str);
                    if (a2 != null) {
                        return a2;
                    }
                    Class<?> a3 = this.g.a(str);
                    if (a3 != null) {
                        return a3;
                    }
                    Class<?> a4 = bk.a(str, this.c);
                    if (a4 == null || cls == null || a4 == HashMap.class) {
                        if (a4.isAnnotationPresent(j.class)) {
                            bk.a(str, a4);
                            return a4;
                        }
                        int i3 = n.SupportAutoType.s;
                        if ((i & i3) == 0 && (i3 & a.c) == 0 && !this.e) {
                            throw new d("autoType is not support : " + str);
                        }
                        bk.a(str, a4);
                        return a4;
                    } else if (cls.isAssignableFrom(a4)) {
                        bk.a(str, a4);
                        return a4;
                    } else {
                        throw new d("type not match. " + str + " -> " + cls.getName());
                    }
                } else {
                    throw new d("autoType is not support. " + str);
                }
            }
        }
        throw new d("autoType is not support. " + str);
    }
}
