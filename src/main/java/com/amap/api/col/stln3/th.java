package com.amap.api.col.stln3;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.List;

/* compiled from: SoFileManager */
public final class th {
    private static ti a = null;
    private static List<tg> b = null;

    public static ti a(Context context) {
        if (context == null) {
            return null;
        }
        ti tiVar = a;
        if (tiVar == null || !ti.a(tiVar)) {
            a = a(context, "SO_INFO_ENTITY_KEY");
        }
        return new ti(a);
    }

    public static void a(Context context, ti tiVar) {
        if (a != null) {
            a = null;
        }
        a(context, "SO_INFO_ENTITY_KEY", tiVar);
    }

    public static void b(Context context, ti tiVar) {
        a(context, "SO_TEMP_INFO_ENTITY_KEY", tiVar);
    }

    public static ti b(Context context) {
        return a(context, "SO_TEMP_INFO_ENTITY_KEY");
    }

    public static void c(Context context) {
        a = null;
        if (context != null) {
            b(context, "SO_INFO_ENTITY_KEY");
        }
    }

    public static void d(Context context) {
        b(context, "SO_TEMP_INFO_ENTITY_KEY");
    }

    private static void a(Context context, String str, ti tiVar) {
        if (context != null && !TextUtils.isEmpty(str) && tiVar != null) {
            String e = tiVar.e();
            if (!TextUtils.isEmpty(e)) {
                String g = rk.g(qw.a(rk.a(e)));
                SharedPreferences.Editor edit = context.getSharedPreferences(rg.b("SO_DYNAMIC_FILE_KEY"), 0).edit();
                edit.putString(str, g);
                edit.commit();
            }
        }
    }

    private static ti a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return new ti();
        }
        return ti.b(rk.a(qw.b(rk.e(context.getSharedPreferences(rg.b("SO_DYNAMIC_FILE_KEY"), 0).getString(str, "")))));
    }

    private static void b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            SharedPreferences.Editor edit = context.getSharedPreferences(rg.b("SO_DYNAMIC_FILE_KEY"), 0).edit();
            edit.putString(str, "");
            edit.commit();
        }
    }

    public static void a(Context context, tg tgVar) {
        if (!(context == null || tgVar == null || !tgVar.g())) {
            List<tg> list = b;
            if (list != null) {
                list.clear();
                b = null;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(rg.b("SO_DYNAMIC_FILE_KEY"), 0);
            List<tg> c = tg.c(rk.a(qw.b(rk.e(sharedPreferences.getString("SO_ERROR_KEY", "")))));
            for (int i = 0; i < c.size(); i++) {
                if (tg.a(c.get(i), tgVar)) {
                    return;
                }
            }
            c.add(tgVar);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("SO_ERROR_KEY", rk.g(qw.a(rk.a(tg.a(c)))));
            edit.commit();
        }
    }

    public static boolean b(Context context, tg tgVar) {
        if (context == null || tgVar == null || !tgVar.g()) {
            return false;
        }
        List<tg> list = b;
        if (list == null || list.isEmpty()) {
            b = tg.c(rk.a(qw.b(rk.e(context.getSharedPreferences(rg.b("SO_DYNAMIC_FILE_KEY"), 0).getString("SO_ERROR_KEY", "")))));
        }
        List<tg> list2 = b;
        if (list2 != null) {
            for (tg tgVar2 : list2) {
                if (tgVar2 != null && tg.a(tgVar2, tgVar)) {
                    return true;
                }
            }
        }
        return false;
    }
}
