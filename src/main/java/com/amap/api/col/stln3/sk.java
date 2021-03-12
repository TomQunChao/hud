package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Constructor;

/* compiled from: InstanceFactory */
public final class sk {
    public static <T> T a(Context context, rj rjVar, String str, Class cls, Class[] clsArr, Object[] objArr) throws qx {
        T t = (T) a(c(context, rjVar), str, clsArr, objArr);
        if (t != null) {
            return t;
        }
        T t2 = (T) a(cls, clsArr, objArr);
        if (t2 != null) {
            return t2;
        }
        throw new qx("获取对象错误");
    }

    public static void a(final Context context, final String str) {
        try {
            ss.b().a().submit(new Runnable() {
                /* class com.amap.api.col.stln3.sk.AnonymousClass1 */

                public final void run() {
                    try {
                        sn.a(new sc(context, sp.a()), context, str);
                    } catch (Throwable th) {
                        ru.a(th, "InstanceFactory", "rollBack");
                    }
                }
            });
        } catch (Throwable th) {
            ru.a(th, "InstanceFactory", "rollBack");
        }
    }

    public static String a(Context context, rj rjVar) {
        try {
            if (!new File(sn.a(context)).exists()) {
                return null;
            }
            File file = new File(sn.b(context, rjVar.a(), rjVar.b()));
            if (file.exists()) {
                return file.getAbsolutePath();
            }
            sn.a(context, file, rjVar);
            return null;
        } catch (Throwable th) {
            ru.a(th, "IFactory", "isdowned");
            return null;
        }
    }

    public static boolean a(Context context, sj sjVar, rj rjVar) {
        boolean z = sjVar != null && sjVar.c();
        try {
            if (!st.a(rjVar, sjVar) || !st.a(sjVar) || !st.a(context, z) || st.a(context, sjVar, rjVar)) {
                return false;
            }
            sn.b(context, rjVar.a());
            return true;
        } catch (Throwable th) {
            ru.a(th, "dDownLoad", "isNeedDownload()");
            return false;
        }
    }

    public static boolean b(Context context, rj rjVar) {
        try {
            if (!new File(sn.a(context)).exists()) {
                return false;
            }
            File file = new File(sn.b(context, rjVar.a(), rjVar.b()));
            if (file.exists()) {
                return true;
            }
            sn.a(context, file, rjVar);
            return false;
        } catch (Throwable th) {
            ru.a(th, "IFactory", "isdowned");
            return false;
        }
    }

    public static Class a(Context context, rj rjVar, String str) {
        sl c = c(context, rjVar);
        try {
            if (a(c)) {
                return c.loadClass(str);
            }
            return null;
        } catch (Throwable th) {
            ru.a(th, "InstanceFactory", "loadpn");
            return null;
        }
    }

    public static void b(Context context, sj sjVar, rj rjVar) {
        if (sjVar != null) {
            try {
                if (!TextUtils.isEmpty(sjVar.a()) && !TextUtils.isEmpty(sjVar.b())) {
                    if (!TextUtils.isEmpty(sjVar.c)) {
                        new si(context, sjVar, rjVar).a();
                    }
                }
            } catch (Throwable th) {
                ru.a(th, "IFactory", "dDownload()");
            }
        }
    }

    private static sl c(Context context, rj rjVar) {
        if (context == null) {
            return null;
        }
        try {
            if (b(context, rjVar)) {
                return ss.b().a(context, rjVar);
            }
            return null;
        } catch (Throwable th) {
            ru.a(th, "IFactory", "gIns1");
            return null;
        }
    }

    private static boolean a(sl slVar) {
        if (slVar == null || !slVar.a() || !slVar.d) {
            return false;
        }
        return true;
    }

    private static <T> T a(sl slVar, String str, Class[] clsArr, Object[] objArr) {
        Class<?> loadClass;
        try {
            if (!a(slVar) || (loadClass = slVar.loadClass(str)) == null) {
                return null;
            }
            Constructor<?> declaredConstructor = loadClass.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            return (T) declaredConstructor.newInstance(objArr);
        } catch (Throwable th) {
            ru.a(th, "IFactory", "getWrap");
            return null;
        }
    }

    private static <T> T a(Class cls, Class[] clsArr, Object[] objArr) {
        if (cls == null) {
            return null;
        }
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(objArr);
        } catch (Throwable th) {
            ru.a(th, "IFactory", "gIns2()");
            return null;
        }
    }
}
