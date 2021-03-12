package com.amap.api.col.stln3;

import android.content.Context;

/* compiled from: StatisticsUtil */
public final class ia {
    public static void a(Context context, boolean z) {
        try {
            String a = a(z);
            ug ugVar = new ug(context, "3dmap", "6.6.0", "O001");
            ugVar.a(a);
            uh.a(ugVar, context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static String a(boolean z) {
        try {
            return "{\"Quest\":" + z + "}";
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
