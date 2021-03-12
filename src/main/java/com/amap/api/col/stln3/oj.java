package com.amap.api.col.stln3;

import android.content.Context;

/* compiled from: StatisticsUtil */
public final class oj {
    static ug a;

    public static void a(Context context, String str, long j, boolean z) {
        try {
            String a2 = a(str, j, z);
            if (a2 == null) {
                return;
            }
            if (a2.length() > 0) {
                if (a == null) {
                    a = new ug(context, "sea", "6.5.0", "O002");
                }
                a.a(a2);
                uh.a(a, context);
            }
        } catch (Throwable th) {
            nl.a(th, "StatisticsUtil", "recordResponseAction");
        }
    }

    private static String a(String str, long j, boolean z) {
        try {
            return "{" + "\"RequestPath\":\"" + str + "\"" + "," + "\"ResponseTime\":" + j + "," + "\"Success\":" + z + "}";
        } catch (Throwable th) {
            nl.a(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }
}
