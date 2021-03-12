package com.amap.api.col.stln3;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: JSONObject */
public class e extends a implements Serializable, Cloneable, InvocationHandler, Map<String, Object> {
    private final Map<String, Object> f;

    public e() {
        this(false, (byte) 0);
    }

    public e(Map<String, Object> map) {
        this.f = map;
    }

    public e(boolean z) {
        this(z, (byte) 0);
    }

    private e(boolean z, byte b) {
        if (z) {
            this.f = new LinkedHashMap(16);
        } else {
            this.f = new HashMap(16);
        }
    }

    public int size() {
        return this.f.size();
    }

    public boolean isEmpty() {
        return this.f.isEmpty();
    }

    public boolean containsKey(Object obj) {
        return this.f.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.f.containsValue(obj);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.f.get(obj);
    }

    public final e c(String str) {
        Object obj = this.f.get(str);
        if (obj instanceof e) {
            return (e) obj;
        }
        if (obj instanceof String) {
            return a.b((String) obj);
        }
        return (e) a.a(obj, bc.a);
    }

    public final String d(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    /* renamed from: a */
    public final Object put(String str, Object obj) {
        return this.f.put(str, obj);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> map) {
        this.f.putAll(map);
    }

    public void clear() {
        this.f.clear();
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this.f.remove(obj);
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.f.keySet();
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return this.f.values();
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return this.f.entrySet();
    }

    @Override // java.lang.Object
    public Object clone() {
        return new e(new LinkedHashMap(this.f));
    }

    public boolean equals(Object obj) {
        return this.f.equals(obj);
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        String str;
        Class<?>[] parameterTypes = method.getParameterTypes();
        String str2 = null;
        if (parameterTypes.length == 1) {
            if (method.getName().equals("equals")) {
                return Boolean.valueOf(equals(objArr[0]));
            }
            if (method.getReturnType() == Void.TYPE) {
                i iVar = (i) method.getAnnotation(i.class);
                if (iVar == null || iVar.b().length() == 0) {
                    str = null;
                } else {
                    str = iVar.b();
                }
                if (str == null) {
                    String name = method.getName();
                    if (name.startsWith("set")) {
                        String substring = name.substring(3);
                        if (substring.length() != 0) {
                            str = Character.toLowerCase(substring.charAt(0)) + substring.substring(1);
                        } else {
                            throw new d("illegal setter");
                        }
                    } else {
                        throw new d("illegal setter");
                    }
                }
                this.f.put(str, objArr[0]);
                return null;
            }
            throw new d("illegal setter");
        } else if (parameterTypes.length != 0) {
            throw new UnsupportedOperationException(method.toGenericString());
        } else if (method.getReturnType() != Void.TYPE) {
            i iVar2 = (i) method.getAnnotation(i.class);
            if (!(iVar2 == null || iVar2.b().length() == 0)) {
                str2 = iVar2.b();
            }
            if (str2 == null) {
                String name2 = method.getName();
                if (name2.startsWith("get")) {
                    String substring2 = name2.substring(3);
                    if (substring2.length() != 0) {
                        str2 = Character.toLowerCase(substring2.charAt(0)) + substring2.substring(1);
                    } else {
                        throw new d("illegal getter");
                    }
                } else if (name2.startsWith("is")) {
                    String substring3 = name2.substring(2);
                    if (substring3.length() != 0) {
                        str2 = Character.toLowerCase(substring3.charAt(0)) + substring3.substring(1);
                    } else {
                        throw new d("illegal getter");
                    }
                } else if (name2.startsWith("hashCode")) {
                    return Integer.valueOf(hashCode());
                } else {
                    if (name2.startsWith("toString")) {
                        return toString();
                    }
                    throw new d("illegal getter");
                }
            }
            return bk.a(this.f.get(str2), method.getGenericReturnType(), w.a);
        } else {
            throw new d("illegal getter");
        }
    }

    public final Map<String, Object> b() {
        return this.f;
    }
}
