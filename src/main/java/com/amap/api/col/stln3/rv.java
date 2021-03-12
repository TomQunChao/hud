package com.amap.api.col.stln3;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: Log */
public final class rv {
    public static final String a = "/a/";
    static final String b = "b";
    static final String c = "c";
    static final String d = "d";
    static final String e = "i";
    public static final String f = "g";
    public static final String g = "h";
    public static final String h = "e";
    public static final String i = "f";
    public static final String j = "j";

    public static String a(Context context, String str) {
        return context.getSharedPreferences("AMSKLG_CFG", 0).getString(str, "");
    }

    @TargetApi(9)
    public static void a(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void b(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.remove(str);
        edit.apply();
    }

    public static String a(Context context) {
        return c(context, e);
    }

    public static String c(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + a + str;
    }

    public static void b(final Context context) {
        try {
            ExecutorService d2 = rx.d();
            if (d2 == null) {
                return;
            }
            if (!d2.isShutdown()) {
                d2.submit(new Runnable() {
                    /* class com.amap.api.col.stln3.rv.AnonymousClass1 */

                    public final void run() {
                        try {
                            ud.a(context);
                            ry.b(context);
                            ry.d(context);
                            ry.c(context);
                            uh.a(context);
                            uf.a(context);
                        } catch (RejectedExecutionException e) {
                        } catch (Throwable th) {
                            rx.c(th, "Lg", "proL");
                        }
                    }
                });
            }
        } catch (Throwable th) {
            rx.c(th, "Lg", "proL");
        }
    }

    static List<rj> c(Context context) {
        List<rj> list = null;
        try {
            synchronized (Looper.getMainLooper()) {
                list = new sh(context, false).a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return list;
    }

    static boolean a(String[] strArr, String str) {
        if (strArr == null || str == null) {
            return false;
        }
        try {
            for (String str2 : str.split("\n")) {
                if (b(strArr, str2.trim())) {
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    static boolean b(String[] strArr, String str) {
        if (strArr == null || str == null) {
            return false;
        }
        try {
            String str2 = str;
            for (String str3 : strArr) {
                str2 = str2.trim();
                if (str2.startsWith("at ")) {
                    if (str2.contains(str3 + ".") && str2.endsWith(")") && !str2.contains("uncaughtException")) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }
}
