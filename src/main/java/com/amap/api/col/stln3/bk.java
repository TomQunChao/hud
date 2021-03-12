package com.amap.api.col.stln3;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: TypeUtils */
public final class bk {
    public static boolean a = false;
    private static boolean b = true;
    private static volatile Class c;
    private static volatile boolean d;
    private static volatile boolean e;
    private static volatile Constructor f;
    private static volatile Method g;
    private static volatile Method h;
    private static volatile Method i;
    private static volatile boolean j;
    private static volatile Map<Class, String[]> k;
    private static volatile boolean l;
    private static final ConcurrentMap<String, Class<?>> m;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(36, 0.75f, 1);
        m = concurrentHashMap;
        concurrentHashMap.put("byte", Byte.TYPE);
        m.put("short", Short.TYPE);
        m.put("int", Integer.TYPE);
        m.put("long", Long.TYPE);
        m.put("float", Float.TYPE);
        m.put("double", Double.TYPE);
        m.put("boolean", Boolean.TYPE);
        m.put("char", Character.TYPE);
        m.put("[byte", byte[].class);
        m.put("[short", short[].class);
        m.put("[int", int[].class);
        m.put("[long", long[].class);
        m.put("[float", float[].class);
        m.put("[double", double[].class);
        m.put("[boolean", boolean[].class);
        m.put("[char", char[].class);
        m.put("[B", byte[].class);
        m.put("[S", short[].class);
        m.put("[I", int[].class);
        m.put("[J", long[].class);
        m.put("[F", float[].class);
        m.put("[D", double[].class);
        m.put("[C", char[].class);
        m.put("[Z", boolean[].class);
        m.put("java.util.HashMap", HashMap.class);
        m.put("java.util.TreeMap", TreeMap.class);
        m.put("java.util.Date", Date.class);
        m.put("com.alibaba.fastjson.JSONObject", e.class);
        m.put("java.util.concurrent.ConcurrentHashMap", ConcurrentHashMap.class);
        m.put("java.text.SimpleDateFormat", SimpleDateFormat.class);
        m.put("java.lang.StackTraceElement", StackTraceElement.class);
        m.put("java.lang.RuntimeException", RuntimeException.class);
    }

    public static boolean a(Class cls) {
        if (c == null && !d) {
            try {
                c = Class.forName("kotlin.Metadata");
            } catch (Throwable th) {
                d = true;
            }
        }
        if (c == null) {
            return false;
        }
        return cls.isAnnotationPresent(c);
    }

    private static boolean a(Class cls, String str) {
        String[] strArr;
        if (k == null && !l) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(Class.forName("kotlin.ranges.CharRange"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("kotlin.ranges.IntRange"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("kotlin.ranges.LongRange"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("kotlin.ranges.ClosedFloatRange"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("kotlin.ranges.ClosedDoubleRange"), new String[]{"getEndInclusive", "isEmpty"});
                k = hashMap;
            } catch (Throwable th) {
                l = true;
            }
        }
        if (k == null || (strArr = k.get(cls)) == null || Arrays.binarySearch(strArr, str) < 0) {
            return false;
        }
        return true;
    }

    public static String[] b(Class cls) {
        if (f == null && !e) {
            try {
                Class<?> cls2 = Class.forName("kotlin.reflect.jvm.internal.KClassImpl");
                f = cls2.getConstructor(Class.class);
                g = cls2.getMethod("getConstructors", new Class[0]);
                h = Class.forName("kotlin.reflect.KFunction").getMethod("getParameters", new Class[0]);
                i = Class.forName("kotlin.reflect.KParameter").getMethod("getName", new Class[0]);
            } catch (Throwable th) {
                e = true;
            }
        }
        if (f == null || j) {
            return null;
        }
        try {
            Iterator it = ((Iterable) g.invoke(f.newInstance(cls), new Object[0])).iterator();
            Object obj = null;
            while (it.hasNext()) {
                Object next = it.next();
                List list = (List) h.invoke(next, new Object[0]);
                if (obj != null) {
                    if (list.size() == 0) {
                        it.hasNext();
                    }
                }
                obj = next;
                it.hasNext();
            }
            List list2 = (List) h.invoke(obj, new Object[0]);
            String[] strArr = new String[list2.size()];
            for (int i2 = 0; i2 < list2.size(); i2++) {
                strArr[i2] = (String) i.invoke(list2.get(i2), new Object[0]);
            }
            return strArr;
        } catch (Throwable th2) {
            j = true;
            return null;
        }
    }

    public static final String a(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static final Byte b(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            return Byte.valueOf(Byte.parseByte(str));
        }
        throw new d("can not cast to byte, value : " + obj);
    }

    public static final Character c(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            if (str.length() == 1) {
                return Character.valueOf(str.charAt(0));
            }
            throw new d("can not cast to byte, value : " + obj);
        }
        throw new d("can not cast to byte, value : " + obj);
    }

    public static final Short d(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            return Short.valueOf(Short.parseShort(str));
        }
        throw new d("can not cast to short, value : " + obj);
    }

    public static final BigDecimal e(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof BigInteger) {
            return new BigDecimal((BigInteger) obj);
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0 || "null".equals(obj2)) {
            return null;
        }
        return new BigDecimal(obj2);
    }

    public static final BigInteger f(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return BigInteger.valueOf(((Number) obj).longValue());
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0 || "null".equals(obj2)) {
            return null;
        }
        return new BigInteger(obj2);
    }

    public static final Float g(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2)) {
                return null;
            }
            return Float.valueOf(Float.parseFloat(obj2));
        }
        throw new d("can not cast to float, value : " + obj);
    }

    public static final Double h(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2) || "NULL".equals(obj2)) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(obj2));
        }
        throw new d("can not cast to double, value : " + obj);
    }

    private static Date l(Object obj) {
        String str;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        long j2 = -1;
        if (obj instanceof Number) {
            j2 = ((Number) obj).longValue();
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.indexOf(45) != -1) {
                if (str2.length() == a.d.length()) {
                    str = a.d;
                } else if (str2.length() == 10) {
                    str = "yyyy-MM-dd";
                } else if (str2.length() == 19) {
                    str = "yyyy-MM-dd HH:mm:ss";
                } else if (str2.length() == 29 && str2.charAt(26) == ':' && str2.charAt(28) == '0') {
                    str = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
                } else {
                    str = "yyyy-MM-dd HH:mm:ss.SSS";
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, a.b);
                simpleDateFormat.setTimeZone(a.a);
                try {
                    return simpleDateFormat.parse(str2);
                } catch (ParseException e2) {
                    throw new d("can not cast to Date, value : " + str2);
                }
            } else if (str2.length() == 0 || "null".equals(str2)) {
                return null;
            } else {
                j2 = Long.parseLong(str2);
            }
        }
        if (j2 >= 0) {
            return new Date(j2);
        }
        throw new d("can not cast to Date, value : " + obj);
    }

    public static final Long i(Object obj) {
        Calendar calendar = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            try {
                return Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException e2) {
                o oVar = new o(str);
                if (oVar.b(false)) {
                    calendar = oVar.o;
                }
                oVar.b();
                if (calendar != null) {
                    return Long.valueOf(calendar.getTimeInMillis());
                }
            }
        }
        throw new d("can not cast to long, value : " + obj);
    }

    public static final Integer j(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(str));
        }
        throw new d("can not cast to int, value : " + obj);
    }

    public static final Boolean k(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Number) {
            boolean z = true;
            if (((Number) obj).intValue() != 1) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            if ("true".equalsIgnoreCase(str) || "1".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(str) || "0".equals(str)) {
                return Boolean.FALSE;
            }
        }
        throw new d("can not cast to int, value : " + obj);
    }

    public static final <T> T a(Object obj, Class<T> cls, w wVar) {
        return (T) b(obj, cls, wVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T b(Object obj, Class<T> cls, w wVar) {
        T t;
        if (obj == 0) {
            return null;
        }
        if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        } else if (cls == obj.getClass()) {
            return obj;
        } else {
            int i2 = 0;
            if (!(obj instanceof Map)) {
                if (cls.isArray()) {
                    if (obj instanceof Collection) {
                        Collection<Object> collection = (Collection) obj;
                        T t2 = (T) Array.newInstance(cls.getComponentType(), collection.size());
                        for (Object obj2 : collection) {
                            Array.set(t2, i2, b(obj2, cls.getComponentType(), wVar));
                            i2++;
                        }
                        return t2;
                    } else if (cls == byte[].class) {
                        if (obj instanceof byte[]) {
                            return (T) ((byte[]) obj);
                        }
                        if (obj instanceof String) {
                            String str = (String) obj;
                            return (T) o.a(str, 0, str.length());
                        }
                        throw new d("can not cast to int, value : " + obj);
                    }
                }
                if (cls.isAssignableFrom(obj.getClass())) {
                    return obj;
                }
                if (cls == Boolean.TYPE || cls == Boolean.class) {
                    return (T) k(obj);
                }
                if (cls == Byte.TYPE || cls == Byte.class) {
                    return (T) b(obj);
                }
                if ((cls == Character.TYPE || cls == Character.class) && (obj instanceof String)) {
                    String str2 = (String) obj;
                    if (str2.length() == 1) {
                        return (T) Character.valueOf(str2.charAt(0));
                    }
                }
                if (cls == Short.TYPE || cls == Short.class) {
                    return (T) d(obj);
                }
                if (cls == Integer.TYPE || cls == Integer.class) {
                    return (T) j(obj);
                }
                if (cls == Long.TYPE || cls == Long.class) {
                    return (T) i(obj);
                }
                if (cls == Float.TYPE || cls == Float.class) {
                    return (T) g(obj);
                }
                if (cls == Double.TYPE || cls == Double.class) {
                    return (T) h(obj);
                }
                if (cls == String.class) {
                    return (T) a(obj);
                }
                if (cls == BigDecimal.class) {
                    return (T) e(obj);
                }
                if (cls == BigInteger.class) {
                    return (T) f(obj);
                }
                if (cls == Date.class) {
                    return (T) l(obj);
                }
                if (cls.isEnum()) {
                    return (T) a(obj, cls);
                }
                if (Calendar.class.isAssignableFrom(cls)) {
                    Date l2 = l(obj);
                    if (cls == Calendar.class) {
                        t = (T) Calendar.getInstance(a.a, a.b);
                    } else {
                        try {
                            t = cls.newInstance();
                        } catch (Exception e2) {
                            throw new d("can not cast to : " + cls.getName(), e2);
                        }
                    }
                    t.setTime(l2);
                    return t;
                }
                if (obj instanceof String) {
                    String str3 = (String) obj;
                    if (str3.length() == 0 || "null".equals(str3)) {
                        return null;
                    }
                    if (cls == Currency.class) {
                        return (T) Currency.getInstance(str3);
                    }
                }
                throw new d("can not cast to : " + cls.getName());
            } else if (cls == Map.class) {
                return obj;
            } else {
                Map map = (Map) obj;
                return (cls != Object.class || map.containsKey("@type")) ? (T) a(map, cls, wVar, 0) : obj;
            }
        }
    }

    private static <T> T a(Object obj, Class<T> cls) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                return (T) Enum.valueOf(cls, str);
            }
            if (obj instanceof Number) {
                int intValue = ((Number) obj).intValue();
                T[] enumConstants = cls.getEnumConstants();
                if (intValue < enumConstants.length) {
                    return enumConstants[intValue];
                }
            }
            throw new d("can not cast to : " + cls.getName());
        } catch (Exception e2) {
            throw new d("can not cast to : " + cls.getName(), e2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T a(Object obj, Type type, w wVar) {
        while (obj != 0) {
            if (type instanceof Class) {
                return (T) b(obj, (Class) type, wVar);
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type rawType = parameterizedType.getRawType();
                if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == List.class || rawType == ArrayList.class) {
                    Type type2 = parameterizedType.getActualTypeArguments()[0];
                    if (obj instanceof Iterable) {
                        T t = (rawType == Set.class || rawType == HashSet.class) ? (T) new HashSet() : rawType == TreeSet.class ? (T) new TreeSet() : (T) new ArrayList();
                        for (T t2 : (Iterable) obj) {
                            t.add(a(t2, type2, wVar));
                        }
                        return t;
                    }
                }
                if (rawType == Map.class || rawType == HashMap.class) {
                    Type type3 = parameterizedType.getActualTypeArguments()[0];
                    Type type4 = parameterizedType.getActualTypeArguments()[1];
                    if (obj instanceof Map) {
                        T t3 = (T) new HashMap();
                        for (Map.Entry entry : ((Map) obj).entrySet()) {
                            t3.put(a(entry.getKey(), type3, wVar), a(entry.getValue(), type4, wVar));
                        }
                        return t3;
                    }
                }
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.length() == 0 || "null".equals(str)) {
                        return null;
                    }
                }
                if (parameterizedType.getActualTypeArguments().length != 1 || !(parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
                    throw new d("can not cast to : " + parameterizedType);
                }
                type = rawType;
            } else {
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (str2.length() == 0 || "null".equals(str2)) {
                        return null;
                    }
                }
                if (type instanceof TypeVariable) {
                    return obj;
                }
                throw new d("can not cast to : " + type);
            }
        }
        return null;
    }

    private static <T> T a(Map<String, Object> map, Class<T> cls, w wVar, int i2) {
        e eVar;
        int i3 = 0;
        if (cls == StackTraceElement.class) {
            try {
                String str = (String) map.get("className");
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get("fileName");
                Number number = (Number) map.get("lineNumber");
                if (number != null) {
                    i3 = number.intValue();
                }
                return (T) new StackTraceElement(str, str2, str3, i3);
            } catch (Exception e2) {
                throw new d(e2.getMessage(), e2);
            }
        } else {
            Object obj = map.get("@type");
            q qVar = null;
            if (obj instanceof String) {
                String str4 = (String) obj;
                if (wVar == null) {
                    wVar = w.a;
                }
                Class<?> a2 = wVar.a(str4, null, i2);
                if (a2 == null) {
                    throw new ClassNotFoundException(str4 + " not found");
                } else if (!a2.equals(cls)) {
                    return (T) a(map, a2, wVar, i2);
                }
            }
            if (cls.isInterface()) {
                if (map instanceof e) {
                    eVar = (e) map;
                } else {
                    eVar = new e(map);
                }
                if (wVar == null) {
                    wVar = w.a();
                }
                if (wVar.a(cls) != null) {
                    return (T) a.a(a.a(eVar), cls);
                }
                return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, eVar);
            } else if (cls == String.class && (map instanceof e)) {
                return (T) map.toString();
            } else {
                if (wVar == null) {
                    wVar = w.a;
                }
                ae a3 = wVar.a(cls);
                if (a3 instanceof q) {
                    qVar = (q) a3;
                }
                if (qVar != null) {
                    return (T) qVar.a(map, wVar);
                }
                throw new d("can not get javaBeanDeserializer");
            }
        }
    }

    public static Class<?> a(String str) {
        return m.get(str);
    }

    public static Class<?> a(String str, ClassLoader classLoader) {
        while (str != null && str.length() != 0) {
            if (str.length() < 256) {
                Class<?> cls = m.get(str);
                if (cls != null) {
                    return cls;
                }
                if (str.charAt(0) == '[') {
                    Class<?> a2 = a(str.substring(1), classLoader);
                    if (a2 == null) {
                        return null;
                    }
                    return Array.newInstance(a2, 0).getClass();
                } else if (!str.startsWith("L") || !str.endsWith(";")) {
                    if (classLoader != null) {
                        try {
                            return classLoader.loadClass(str);
                        } catch (Exception e2) {
                        }
                    }
                    try {
                        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                        if (!(contextClassLoader == null || contextClassLoader == classLoader)) {
                            return contextClassLoader.loadClass(str);
                        }
                    } catch (Exception e3) {
                    }
                    try {
                        cls = Class.forName(str);
                        m.put(str, cls);
                        return cls;
                    } catch (Exception e4) {
                        return cls;
                    }
                } else {
                    str = str.substring(1, str.length() - 1);
                }
            } else {
                throw new d("className too long. " + str);
            }
        }
        return null;
    }

    public static List<bh> a(Class<?> cls, int i2, j jVar, boolean z, g gVar) {
        String[] strArr;
        int i3;
        int i4;
        String str;
        short[] sArr;
        String[] strArr2;
        Annotation[][] annotationArr;
        i iVar;
        Constructor<?>[] constructorArr;
        HashMap hashMap;
        int i5;
        Field[] fieldArr;
        g gVar2;
        Field[] fieldArr2;
        int i6;
        int i7;
        Field[] fieldArr3;
        Method method;
        int i8;
        int i9;
        char c2;
        String str2;
        String str3;
        Field field;
        i iVar2;
        int i10;
        int i11;
        String str4;
        String str5;
        i iVar3;
        boolean z2;
        String str6;
        Annotation[] annotationArr2;
        int i12 = i2;
        g gVar3 = gVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        HashMap hashMap2 = new HashMap();
        Field[] declaredFields = cls.getDeclaredFields();
        boolean a2 = a((Class) cls);
        ArrayList<Method> arrayList = new ArrayList();
        Class<?> cls2 = cls;
        while (cls2 != null && cls2 != Object.class) {
            Method[] declaredMethods = cls2.getDeclaredMethods();
            for (Method method2 : declaredMethods) {
                int modifiers = method2.getModifiers();
                if ((modifiers & 8) == 0 && (modifiers & 2) == 0 && (modifiers & 256) == 0 && (modifiers & 4) == 0 && !method2.getReturnType().equals(Void.TYPE) && method2.getParameterTypes().length == 0 && method2.getReturnType() != ClassLoader.class && method2.getDeclaringClass() != Object.class) {
                    arrayList.add(method2);
                }
            }
            cls2 = cls2.getSuperclass();
        }
        Constructor<?>[] constructorArr2 = null;
        String[] strArr3 = null;
        short[] sArr2 = null;
        Annotation[][] annotationArr3 = null;
        for (Method method3 : arrayList) {
            String name = method3.getName();
            if (!name.equals("getMetaClass") || !method3.getReturnType().getName().equals("groovy.lang.MetaClass")) {
                i iVar4 = (i) method3.getAnnotation(i.class);
                if (iVar4 == null) {
                    iVar4 = a(cls, method3);
                }
                if (!a2 || !a(cls, name)) {
                    if (iVar4 != null || !a2) {
                        iVar = iVar4;
                        constructorArr = constructorArr2;
                    } else {
                        if (constructorArr2 == null) {
                            Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
                            if (declaredConstructors.length == 1) {
                                short s = 0;
                                annotationArr3 = declaredConstructors[0].getParameterAnnotations();
                                strArr3 = b((Class) cls);
                                if (strArr3 != null) {
                                    String[] strArr4 = new String[strArr3.length];
                                    System.arraycopy(strArr3, 0, strArr4, 0, strArr3.length);
                                    Arrays.sort(strArr4);
                                    short[] sArr3 = new short[strArr3.length];
                                    while (true) {
                                        constructorArr = declaredConstructors;
                                        if (s >= strArr3.length) {
                                            break;
                                        }
                                        sArr3[Arrays.binarySearch(strArr4, strArr3[s])] = s;
                                        s = (short) (s + 1);
                                        declaredConstructors = constructorArr;
                                    }
                                    strArr3 = strArr4;
                                    sArr2 = sArr3;
                                } else {
                                    constructorArr = declaredConstructors;
                                }
                            } else {
                                constructorArr = declaredConstructors;
                            }
                        } else {
                            constructorArr = constructorArr2;
                        }
                        if (strArr3 == null || sArr2 == null || !name.startsWith("get")) {
                            iVar = iVar4;
                        } else {
                            String b2 = b(name.substring(3));
                            int binarySearch = Arrays.binarySearch(strArr3, b2);
                            if (binarySearch < 0) {
                                int i13 = 0;
                                while (true) {
                                    iVar = iVar4;
                                    if (i13 >= strArr3.length) {
                                        break;
                                    } else if (b2.equalsIgnoreCase(strArr3[i13])) {
                                        binarySearch = i13;
                                        break;
                                    } else {
                                        i13++;
                                        iVar4 = iVar;
                                    }
                                }
                            } else {
                                iVar = iVar4;
                            }
                            if (binarySearch >= 0 && (annotationArr2 = annotationArr3[sArr2[binarySearch]]) != null) {
                                int length = annotationArr2.length;
                                int i14 = 0;
                                while (true) {
                                    if (i14 >= length) {
                                        break;
                                    }
                                    Annotation annotation = annotationArr2[i14];
                                    if (annotation instanceof i) {
                                        strArr2 = strArr3;
                                        sArr = sArr2;
                                        annotationArr = annotationArr3;
                                        iVar = (i) annotation;
                                        break;
                                    }
                                    i14++;
                                    annotationArr2 = annotationArr2;
                                }
                            }
                        }
                    }
                    strArr2 = strArr3;
                    sArr = sArr2;
                    annotationArr = annotationArr3;
                    if (iVar != null) {
                        if (iVar.d()) {
                            i7 = iVar.a();
                            i6 = be.a(iVar.f());
                            if (iVar.b().length() != 0) {
                                String b3 = iVar.b();
                                a(cls, method3, i12);
                                linkedHashMap.put(b3, new bh(b3, method3, null, cls, null, i7, i6, iVar, null));
                                hashMap = hashMap2;
                                i5 = i2;
                                fieldArr = declaredFields;
                                gVar2 = gVar3;
                            } else {
                                fieldArr2 = declaredFields;
                            }
                        } else {
                            hashMap = hashMap2;
                            i5 = i2;
                            fieldArr = declaredFields;
                            gVar2 = gVar3;
                        }
                        declaredFields = fieldArr;
                        constructorArr2 = constructorArr;
                        annotationArr3 = annotationArr;
                        strArr3 = strArr2;
                        sArr2 = sArr;
                        gVar3 = gVar2;
                        i12 = i5;
                        hashMap2 = hashMap;
                    } else {
                        fieldArr2 = declaredFields;
                        i7 = 0;
                        i6 = 0;
                    }
                    if (name.startsWith("get")) {
                        if (name.length() < 4) {
                            hashMap = hashMap2;
                            fieldArr = fieldArr2;
                            gVar2 = gVar;
                            i5 = i2;
                        } else if (!name.equals("getClass")) {
                            char charAt = name.charAt(3);
                            if (Character.isUpperCase(charAt)) {
                                str5 = a ? b(name.substring(3)) : Character.toLowerCase(name.charAt(3)) + name.substring(4);
                            } else if (charAt == '_') {
                                str5 = name.substring(4);
                            } else if (charAt == 'f') {
                                str5 = name.substring(3);
                            } else if (name.length() < 5 || !Character.isUpperCase(name.charAt(4))) {
                                hashMap = hashMap2;
                                fieldArr = fieldArr2;
                                gVar2 = gVar;
                                i5 = i2;
                            } else {
                                str5 = b(name.substring(3));
                            }
                            if (!a(cls, jVar, str5)) {
                                Field a3 = a(cls, str5, fieldArr2, hashMap2);
                                if (a3 != null) {
                                    i iVar5 = (i) a3.getAnnotation(i.class);
                                    if (iVar5 == null) {
                                        iVar3 = iVar5;
                                        i9 = i7;
                                        i8 = i6;
                                        z2 = false;
                                    } else if (iVar5.d()) {
                                        int a4 = iVar5.a();
                                        int a5 = be.a(iVar5.f());
                                        if (iVar5.b().length() != 0) {
                                            str5 = iVar5.b();
                                            iVar3 = iVar5;
                                            i9 = a4;
                                            i8 = a5;
                                            z2 = true;
                                        } else {
                                            iVar3 = iVar5;
                                            i9 = a4;
                                            i8 = a5;
                                            z2 = false;
                                        }
                                    } else {
                                        hashMap = hashMap2;
                                        i5 = i2;
                                        fieldArr = fieldArr2;
                                        gVar2 = gVar3;
                                    }
                                } else {
                                    i9 = i7;
                                    i8 = i6;
                                    iVar3 = null;
                                    z2 = false;
                                }
                                if (gVar3 == null || z2) {
                                    str6 = str5;
                                } else {
                                    str6 = gVar3.a(str5);
                                }
                                a(cls, method3, i2);
                                str2 = name;
                                method = method3;
                                fieldArr3 = fieldArr2;
                                c2 = 'f';
                                linkedHashMap.put(str6, new bh(str6, method3, a3, cls, null, i9, i8, iVar, iVar3));
                            } else {
                                hashMap = hashMap2;
                                fieldArr = fieldArr2;
                                gVar2 = gVar;
                                i5 = i2;
                            }
                        } else {
                            hashMap = hashMap2;
                            fieldArr = fieldArr2;
                            gVar2 = gVar;
                            i5 = i2;
                        }
                        declaredFields = fieldArr;
                        constructorArr2 = constructorArr;
                        annotationArr3 = annotationArr;
                        strArr3 = strArr2;
                        sArr2 = sArr;
                        gVar3 = gVar2;
                        i12 = i5;
                        hashMap2 = hashMap;
                    } else {
                        method = method3;
                        fieldArr3 = fieldArr2;
                        c2 = 'f';
                        str2 = name;
                        i9 = i7;
                        i8 = i6;
                    }
                    if (!str2.startsWith("is")) {
                        hashMap = hashMap2;
                        fieldArr = fieldArr3;
                        gVar2 = gVar;
                        i5 = i2;
                    } else if (str2.length() >= 3) {
                        char charAt2 = str2.charAt(2);
                        if (Character.isUpperCase(charAt2)) {
                            str3 = a ? b(str2.substring(2)) : Character.toLowerCase(str2.charAt(2)) + str2.substring(3);
                        } else if (charAt2 == '_') {
                            str3 = str2.substring(3);
                        } else if (charAt2 == c2) {
                            str3 = str2.substring(2);
                        } else {
                            hashMap = hashMap2;
                            fieldArr = fieldArr3;
                            gVar2 = gVar;
                            i5 = i2;
                        }
                        if (!a(cls, jVar, str3)) {
                            fieldArr = fieldArr3;
                            Field a6 = a(cls, str3, fieldArr, hashMap2);
                            if (a6 == null) {
                                field = a(cls, str2, fieldArr, hashMap2);
                            } else {
                                field = a6;
                            }
                            if (field != null) {
                                i iVar6 = (i) field.getAnnotation(i.class);
                                if (iVar6 == null) {
                                    iVar2 = iVar6;
                                    i11 = i9;
                                    i10 = i8;
                                } else if (iVar6.d()) {
                                    int a7 = iVar6.a();
                                    int a8 = be.a(iVar6.f());
                                    if (iVar6.b().length() != 0) {
                                        str3 = iVar6.b();
                                        iVar2 = iVar6;
                                        i11 = a7;
                                        i10 = a8;
                                    } else {
                                        iVar2 = iVar6;
                                        i11 = a7;
                                        i10 = a8;
                                    }
                                } else {
                                    hashMap = hashMap2;
                                    gVar2 = gVar;
                                    i5 = i2;
                                }
                            } else {
                                iVar2 = null;
                                i11 = i9;
                                i10 = i8;
                            }
                            gVar2 = gVar;
                            if (gVar2 != null) {
                                str4 = gVar2.a(str3);
                            } else {
                                str4 = str3;
                            }
                            a(cls, field, i2);
                            a(cls, method, i2);
                            hashMap = hashMap2;
                            i5 = i2;
                            linkedHashMap.put(str4, new bh(str4, method, field, cls, null, i11, i10, iVar, iVar2));
                        } else {
                            hashMap = hashMap2;
                            fieldArr = fieldArr3;
                            gVar2 = gVar;
                            i5 = i2;
                        }
                    } else {
                        hashMap = hashMap2;
                        fieldArr = fieldArr3;
                        gVar2 = gVar;
                        i5 = i2;
                    }
                    declaredFields = fieldArr;
                    constructorArr2 = constructorArr;
                    annotationArr3 = annotationArr;
                    strArr3 = strArr2;
                    sArr2 = sArr;
                    gVar3 = gVar2;
                    i12 = i5;
                    hashMap2 = hashMap;
                }
            }
        }
        ArrayList<Field> arrayList2 = new ArrayList(declaredFields.length);
        for (Field field2 : declaredFields) {
            if ((field2.getModifiers() & 8) == 0 && !field2.getName().equals("this$0") && (field2.getModifiers() & 1) != 0) {
                arrayList2.add(field2);
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        while (superclass != null && superclass != Object.class) {
            Field[] declaredFields2 = superclass.getDeclaredFields();
            for (Field field3 : declaredFields2) {
                if ((field3.getModifiers() & 8) == 0) {
                    if ((field3.getModifiers() & 1) != 0) {
                        arrayList2.add(field3);
                    }
                }
            }
            superclass = superclass.getSuperclass();
        }
        for (Field field4 : arrayList2) {
            i iVar7 = (i) field4.getAnnotation(i.class);
            String name2 = field4.getName();
            if (iVar7 == null) {
                i4 = 0;
                i3 = 0;
            } else if (iVar7.d()) {
                int a9 = iVar7.a();
                int a10 = be.a(iVar7.f());
                if (iVar7.b().length() != 0) {
                    name2 = iVar7.b();
                    i4 = a9;
                    i3 = a10;
                } else {
                    i4 = a9;
                    i3 = a10;
                }
            }
            if (gVar3 != null) {
                str = gVar3.a(name2);
            } else {
                str = name2;
            }
            if (!linkedHashMap.containsKey(str)) {
                a(cls, field4, i12);
                linkedHashMap.put(str, new bh(str, null, field4, cls, null, i4, i3, null, iVar7));
            }
        }
        boolean z3 = true;
        ArrayList arrayList3 = new ArrayList();
        if (jVar != null) {
            strArr = jVar.a();
            if (strArr != null && strArr.length == linkedHashMap.size()) {
                int length2 = strArr.length;
                int i15 = 0;
                while (true) {
                    if (i15 >= length2) {
                        break;
                    }
                    if (!linkedHashMap.containsKey(strArr[i15])) {
                        break;
                    }
                    i15++;
                }
            }
            z3 = false;
        } else {
            strArr = null;
            z3 = false;
        }
        if (z3) {
            for (String str7 : strArr) {
                arrayList3.add((bh) linkedHashMap.get(str7));
            }
        } else {
            for (bh bhVar : linkedHashMap.values()) {
                arrayList3.add(bhVar);
            }
            if (z) {
                Collections.sort(arrayList3);
            }
        }
        return arrayList3;
    }

    public static i a(Class<?> cls, Method method) {
        boolean z;
        i iVar;
        boolean z2;
        i iVar2;
        for (Class<?> cls2 : cls.getInterfaces()) {
            Method[] methods = cls2.getMethods();
            for (Method method2 : methods) {
                if (method2.getName().equals(method.getName())) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    Class<?>[] parameterTypes2 = method.getParameterTypes();
                    if (parameterTypes.length == parameterTypes2.length) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= parameterTypes.length) {
                                z2 = true;
                                break;
                            } else if (!parameterTypes[i2].equals(parameterTypes2[i2])) {
                                z2 = false;
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (z2 && (iVar2 = (i) method2.getAnnotation(i.class)) != null) {
                            return iVar2;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && Modifier.isAbstract(superclass.getModifiers())) {
            Class<?>[] parameterTypes3 = method.getParameterTypes();
            Method[] methods2 = superclass.getMethods();
            for (Method method3 : methods2) {
                Class<?>[] parameterTypes4 = method3.getParameterTypes();
                if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= parameterTypes3.length) {
                            z = true;
                            break;
                        } else if (!parameterTypes4[i3].equals(parameterTypes3[i3])) {
                            z = false;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (z && (iVar = (i) method3.getAnnotation(i.class)) != null) {
                        return iVar;
                    }
                }
            }
        }
        return null;
    }

    private static boolean a(Class<?> cls, j jVar, String str) {
        if (!(jVar == null || jVar.b() == null)) {
            for (String str2 : jVar.b()) {
                if (str.equalsIgnoreCase(str2)) {
                    return true;
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        return (superclass == Object.class || superclass == null || !a(superclass, (j) superclass.getAnnotation(j.class), str)) ? false : true;
    }

    public static boolean a(Type type) {
        Type genericSuperclass;
        if (type instanceof ParameterizedType) {
            return true;
        }
        if (!(type instanceof Class) || (genericSuperclass = ((Class) type).getGenericSuperclass()) == Object.class || !a(genericSuperclass)) {
            return false;
        }
        return true;
    }

    public static Type b(Type type) {
        while (type instanceof Class) {
            type = ((Class) type).getGenericSuperclass();
        }
        return type;
    }

    public static Class<?> c(Type type) {
        while (type.getClass() != Class.class) {
            if (type instanceof ParameterizedType) {
                type = ((ParameterizedType) type).getRawType();
            } else if (type instanceof TypeVariable) {
                return (Class) ((TypeVariable) type).getBounds()[0];
            } else {
                if (!(type instanceof WildcardType)) {
                    return Object.class;
                }
                Type[] upperBounds = ((WildcardType) type).getUpperBounds();
                if (upperBounds.length != 1) {
                    return Object.class;
                }
                type = upperBounds[0];
            }
        }
        return (Class) type;
    }

    public static String b(String str) {
        if (str == null || str.length() == 0 || (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0)))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public static boolean a(Class<?> cls, Member member, int i2) {
        if (member == null || !b) {
            return false;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if ((superclass == null || superclass == Object.class) && (member.getModifiers() & 1) != 0 && (i2 & 1) != 0) {
            return false;
        }
        try {
            ((AccessibleObject) member).setAccessible(true);
            return true;
        } catch (AccessControlException e2) {
            b = false;
            return false;
        }
    }

    public static Field a(Class<?> cls, String str, Field[] fieldArr, Map<Class<?>, Field[]> map) {
        Field b2 = b(cls, str, fieldArr, map);
        if (b2 == null) {
            b2 = b(cls, "_" + str, fieldArr, map);
        }
        if (b2 == null) {
            b2 = b(cls, "m_" + str, fieldArr, map);
        }
        if (b2 != null) {
            return b2;
        }
        return b(cls, "m" + str.substring(0, 1).toUpperCase() + str.substring(1), fieldArr, map);
    }

    private static Field b(Class<?> cls, String str, Field[] fieldArr, Map<Class<?>, Field[]> map) {
        char charAt;
        char charAt2;
        for (Field field : fieldArr) {
            String name = field.getName();
            if (str.equals(name)) {
                return field;
            }
            if (str.length() > 2 && (charAt = str.charAt(0)) >= 'a' && charAt <= 'z' && (charAt2 = str.charAt(1)) >= 'A' && charAt2 <= 'Z' && str.equalsIgnoreCase(name)) {
                return field;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        Field[] fieldArr2 = null;
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        if (map != null) {
            fieldArr2 = map.get(superclass);
        }
        if (fieldArr2 == null) {
            fieldArr2 = superclass.getDeclaredFields();
            if (map != null) {
                map.put(superclass, fieldArr2);
            }
        }
        return a(superclass, str, fieldArr2, map);
    }

    public static Type d(Type type) {
        Type type2;
        if (type instanceof ParameterizedType) {
            type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
                if (upperBounds.length == 1) {
                    type2 = upperBounds[0];
                }
            }
        } else {
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (!cls.getName().startsWith("java.")) {
                    type2 = d(cls.getGenericSuperclass());
                }
            }
            type2 = null;
        }
        if (type2 == null) {
            return Object.class;
        }
        return type2;
    }

    public static Object c(Class<?> cls) {
        if (cls == Byte.TYPE) {
            return (byte) 0;
        }
        if (cls == Short.TYPE) {
            return (short) 0;
        }
        if (cls == Integer.TYPE) {
            return 0;
        }
        if (cls == Long.TYPE) {
            return 0L;
        }
        if (cls == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (cls == Double.TYPE) {
            return Double.valueOf(0.0d);
        }
        if (cls == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (cls == Character.TYPE) {
            return '0';
        }
        return null;
    }

    public static boolean a(Type[] typeArr, TypeVariable[] typeVariableArr, Type[] typeArr2) {
        if (typeArr2 == null || typeVariableArr.length == 0) {
            return false;
        }
        boolean z = false;
        for (int i2 = 0; i2 < typeArr.length; i2++) {
            Type type = typeArr[i2];
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (a(actualTypeArguments, typeVariableArr, typeArr2)) {
                    typeArr[i2] = new bj(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType());
                    z = true;
                }
            } else if (type instanceof TypeVariable) {
                boolean z2 = z;
                for (int i3 = 0; i3 < typeVariableArr.length; i3++) {
                    if (type.equals(typeVariableArr[i3])) {
                        typeArr[i2] = typeArr2[i3];
                        z2 = true;
                    }
                }
                z = z2;
            }
        }
        return z;
    }

    public static long c(String str) {
        long j2 = -3750763034362895579L;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (!(charAt == '_' || charAt == '-')) {
                if (charAt >= 'A' && charAt <= 'Z') {
                    charAt = (char) (charAt + ' ');
                }
                j2 = (j2 ^ ((long) charAt)) * 1099511628211L;
            }
        }
        return j2;
    }

    public static void a(String str, Class<?> cls) {
        m.put(str, cls);
    }
}
