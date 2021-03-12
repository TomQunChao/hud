package com.amap.api.col.stln3;

import android.content.Context;

/* compiled from: SpUtil */
public final class xa {
    public static int a(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, 200);
        } catch (Throwable th) {
            wy.a(th, "SpUtil", "getPrefsInt");
            return 200;
        }
    }

    public static String a(Context context) {
        return context == null ? "00:00:00:00:00:00" : a(context, "pref", "smac", "00:00:00:00:00:00");
    }

    private static String a(Context context, String str, String str2, String str3) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            wy.a(th, "SpUtil", "getPrefsInt");
            return str3;
        }
    }

    public static boolean b(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, true);
        } catch (Throwable th) {
            wy.a(th, "SpUtil", "getPrefsBoolean");
            return true;
        }
    }
}
