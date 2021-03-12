package com.amap.api.col.stln3;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: PreferenceTools */
public final class ht {
    public static void a(Context context, String str, String str2, Object obj) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            if (obj instanceof String) {
                edit.putString(str2, (String) obj);
            } else if (obj instanceof Integer) {
                edit.putInt(str2, ((Integer) obj).intValue());
            } else if (obj instanceof Boolean) {
                edit.putBoolean(str2, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Float) {
                edit.putFloat(str2, ((Float) obj).floatValue());
            } else if (obj instanceof Long) {
                edit.putLong(str2, ((Long) obj).longValue());
            } else {
                edit.putString(str2, obj.toString());
            }
            edit.apply();
        }
    }

    public static String a(Context context, String str, String str2, String str3) {
        Object b = b(context, str, str2, str3);
        if (b != null) {
            return (String) b;
        }
        return str3;
    }

    public static Long a(Context context, String str, String str2, Long l) {
        Object b = b(context, str, str2, l);
        if (b != null) {
            return (Long) b;
        }
        return l;
    }

    private static Object b(Context context, String str, String str2, Object obj) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (obj instanceof String) {
            return sharedPreferences.getString(str2, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str2, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str2, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str2, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str2, ((Long) obj).longValue()));
        }
        return null;
    }
}
