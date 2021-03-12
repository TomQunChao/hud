package com.amap.api.col.stln3;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: FieldInfo */
public final class bh implements Comparable<bh> {
    public final String a;
    public final Method b;
    public final Field c;
    public final boolean d;
    public final boolean e;
    public final Class<?> f;
    public final Type g;
    public final Class<?> h;
    public final boolean i;
    public final boolean j;
    public final String k;
    public final long l;
    public final String[] m;
    public final int n;
    private int o = 0;
    private final i p;
    private final i q;

    public bh(String str, Class<?> cls, Class<?> cls2, Type type, Field field, int i2, int i3) {
        this.a = str;
        this.h = cls;
        this.f = cls2;
        this.g = type;
        this.b = null;
        this.c = field;
        this.o = i2;
        this.n = i3;
        boolean z = true;
        this.j = cls2.isEnum() && !c.class.isAssignableFrom(cls2);
        this.p = null;
        this.q = null;
        if (field != null) {
            int modifiers = field.getModifiers();
            if ((modifiers & 1) == 0 && this.b != null) {
                z = false;
            }
            this.d = z;
            this.e = Modifier.isTransient(modifiers);
        } else {
            this.d = false;
            this.e = false;
        }
        this.i = false;
        long j2 = -3750763034362895579L;
        for (int i4 = 0; i4 < str.length(); i4++) {
            j2 = (j2 ^ ((long) str.charAt(i4))) * 1099511628211L;
        }
        this.l = j2;
        this.k = null;
        this.m = new String[0];
    }

    public bh(String str, Method method, Field field, Class<?> cls, Type type, int i2, int i3, i iVar, i iVar2) {
        String str2;
        Type type2;
        Class<?> cls2;
        Type type3;
        Type type4;
        this.a = str;
        this.b = method;
        this.c = field;
        this.o = i2;
        this.q = iVar;
        this.p = iVar2;
        this.n = i3;
        i a2 = a();
        Type type5 = null;
        if (a2 != null) {
            str2 = a2.c();
            str2 = str2.trim().length() == 0 ? null : str2;
            this.m = a2.g();
        } else {
            this.m = new String[0];
            str2 = null;
        }
        this.k = str2;
        boolean z = true;
        if (field != null) {
            int modifiers = field.getModifiers();
            this.d = method == null || ((modifiers & 1) != 0 && method.getReturnType() == field.getType());
            this.e = (modifiers & 128) != 0;
        } else {
            this.d = false;
            this.e = false;
        }
        long j2 = -3750763034362895579L;
        for (int i4 = 0; i4 < str.length(); i4++) {
            j2 = (j2 ^ ((long) str.charAt(i4))) * 1099511628211L;
        }
        this.l = j2;
        if (method != null) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1) {
                cls2 = parameterTypes[0];
                if (cls2 == Class.class || cls2 == String.class || cls2.isPrimitive()) {
                    type4 = cls2;
                } else {
                    type4 = method.getGenericParameterTypes()[0];
                }
                this.i = false;
            } else {
                cls2 = method.getReturnType();
                type4 = cls2 != Class.class ? method.getGenericReturnType() : cls2;
                this.i = true;
            }
            this.h = method.getDeclaringClass();
            type2 = type4;
        } else {
            cls2 = field.getType();
            if (cls2.isPrimitive() || cls2 == String.class || cls2.isEnum()) {
                type2 = cls2;
            } else {
                type2 = field.getGenericType();
            }
            this.h = field.getDeclaringClass();
            this.i = Modifier.isFinal(field.getModifiers());
        }
        if (cls != null && cls2 == Object.class && (type2 instanceof TypeVariable)) {
            TypeVariable typeVariable = (TypeVariable) type2;
            Type[] actualTypeArguments = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments() : null;
            Class<?> cls3 = cls;
            while (cls3 != null && cls3 != Object.class && cls3 != this.h) {
                Type genericSuperclass = cls3.getGenericSuperclass();
                if (genericSuperclass instanceof ParameterizedType) {
                    Type[] actualTypeArguments2 = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                    bk.a(actualTypeArguments2, cls3.getTypeParameters(), actualTypeArguments);
                    actualTypeArguments = actualTypeArguments2;
                }
                cls3 = cls3.getSuperclass();
            }
            if (actualTypeArguments != null) {
                TypeVariable<Class<?>>[] typeParameters = this.h.getTypeParameters();
                int i5 = 0;
                while (true) {
                    if (i5 >= typeParameters.length) {
                        break;
                    } else if (typeVariable.equals(typeParameters[i5])) {
                        type5 = actualTypeArguments[i5];
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            if (type5 != null) {
                this.f = bk.c(type5);
                this.g = type5;
                this.j = (!cls2.isEnum() || c.class.isAssignableFrom(cls2)) ? false : z;
                return;
            }
        }
        if (!(type2 instanceof Class)) {
            type3 = a(cls, type == null ? cls : type, type2);
            if (type3 != type2) {
                if (type3 instanceof ParameterizedType) {
                    cls2 = bk.c(type3);
                } else if (type3 instanceof Class) {
                    cls2 = bk.c(type3);
                }
            }
        } else {
            type3 = type2;
        }
        this.g = type3;
        this.f = cls2;
        this.j = (cls2.isArray() || !cls2.isEnum() || c.class.isAssignableFrom(cls2)) ? false : z;
    }

    public static Type a(Class<?> cls, Type type, Type type2) {
        ParameterizedType parameterizedType;
        TypeVariable<Class<? super Object>>[] typeVariableArr;
        if (cls == null || type == null) {
            return type2;
        }
        if (type2 instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
            Type a2 = a(cls, type, genericComponentType);
            if (genericComponentType != a2) {
                return Array.newInstance(bk.c(a2), 0).getClass();
            }
            return type2;
        } else if (!bk.a(type)) {
            return type2;
        } else {
            if (type2 instanceof TypeVariable) {
                ParameterizedType parameterizedType2 = (ParameterizedType) bk.b(type);
                Class<?> c2 = bk.c((Type) parameterizedType2);
                TypeVariable typeVariable = (TypeVariable) type2;
                for (int i2 = 0; i2 < c2.getTypeParameters().length; i2++) {
                    if (c2.getTypeParameters()[i2].getName().equals(typeVariable.getName())) {
                        return parameterizedType2.getActualTypeArguments()[i2];
                    }
                }
            }
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType3 = (ParameterizedType) type2;
                Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                if (type instanceof ParameterizedType) {
                    parameterizedType = (ParameterizedType) type;
                    typeVariableArr = cls.getTypeParameters();
                } else if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                    parameterizedType = (ParameterizedType) cls.getGenericSuperclass();
                    typeVariableArr = cls.getSuperclass().getTypeParameters();
                } else {
                    typeVariableArr = null;
                    parameterizedType = null;
                }
                Type[] typeArr = null;
                boolean z = false;
                for (int i3 = 0; i3 < actualTypeArguments.length && parameterizedType != null; i3++) {
                    Type type3 = actualTypeArguments[i3];
                    if (type3 instanceof TypeVariable) {
                        TypeVariable typeVariable2 = (TypeVariable) type3;
                        Type[] typeArr2 = typeArr;
                        boolean z2 = z;
                        for (int i4 = 0; i4 < typeVariableArr.length; i4++) {
                            if (typeVariableArr[i4].getName().equals(typeVariable2.getName())) {
                                if (typeArr2 == null) {
                                    typeArr2 = parameterizedType.getActualTypeArguments();
                                }
                                actualTypeArguments[i3] = typeArr2[i4];
                                z2 = true;
                            }
                        }
                        z = z2;
                        typeArr = typeArr2;
                    }
                }
                if (z) {
                    return new bj(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType());
                }
            }
            return type2;
        }
    }

    public final String toString() {
        return this.a;
    }

    /* renamed from: a */
    public final int compareTo(bh bhVar) {
        int i2 = this.o;
        int i3 = bhVar.o;
        if (i2 < i3) {
            return -1;
        }
        if (i2 > i3) {
            return 1;
        }
        return this.a.compareTo(bhVar.a);
    }

    public final boolean b(bh bhVar) {
        if (bhVar == this || compareTo(bhVar) == 0) {
            return true;
        }
        return false;
    }

    public final i a() {
        i iVar = this.p;
        if (iVar != null) {
            return iVar;
        }
        return this.q;
    }

    public final void a(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        Method method = this.b;
        if (method != null) {
            method.invoke(obj, obj2);
            return;
        }
        this.c.set(obj, obj2);
    }
}
