package com.amap.api.col.stln3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: Reflect */
public final class vx {
    public static Object a(String str, String str2) throws Exception {
        Class<?> cls = Class.forName(str);
        Field field = cls.getField(str2);
        field.setAccessible(true);
        return field.get(cls);
    }

    public static int b(String str, String str2) throws Exception {
        return ((Integer) a(str, str2)).intValue();
    }

    public static Object a(Object obj, String str, Object... objArr) {
        try {
            return a(obj, obj.getClass(), str, objArr);
        } catch (Throwable th) {
            return null;
        }
    }

    public static int b(Object obj, String str, Object... objArr) throws Exception {
        return ((Integer) a(obj, str, objArr)).intValue();
    }

    public static Object a(String str, String str2, Object[] objArr, Class<?>[] clsArr) throws Exception {
        Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod.invoke(null, objArr);
    }

    public static Object a(Object obj, Class<?> cls, String str, Object... objArr) throws Exception {
        Class<?>[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
            if (clsArr[i] == Integer.class) {
                clsArr[i] = Integer.TYPE;
            }
            if (clsArr[i] == Boolean.class) {
                clsArr[i] = Boolean.TYPE;
            }
            if (clsArr[i] == Double.class) {
                clsArr[i] = Double.TYPE;
            }
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        try {
            return declaredMethod.invoke(obj, objArr);
        } catch (Throwable th) {
            return null;
        }
    }

    public static Object a(Object obj, String str, Class[] clsArr, Object[] objArr) {
        try {
            return a(obj, obj.getClass(), str, clsArr, objArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static Object a(Object obj, Class<?> cls, String str, Class[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            return declaredMethod.invoke(obj, objArr);
        } catch (Throwable th) {
        }
        return null;
    }
}
