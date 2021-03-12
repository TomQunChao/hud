package com.amap.api.col.stln3;

import android.content.Context;
import java.lang.ref.WeakReference;

/* compiled from: Utils */
public final class ui {
    public static void a(Context context, ub ubVar, String str, int i, int i2, String str2) {
        ubVar.a = rv.c(context, str);
        ubVar.d = i;
        ubVar.b = (long) i2;
        ubVar.c = str2;
    }

    public static ub a(WeakReference<ub> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new ub());
        }
        return weakReference.get();
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0079 A[SYNTHETIC, Splitter:B:45:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0086 A[SYNTHETIC, Splitter:B:50:0x0086] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static byte[] a(com.amap.api.col.stln3.tm r4, java.lang.String r5) {
        /*
        // Method dump skipped, instructions count: 176
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ui.a(com.amap.api.col.stln3.tm, java.lang.String):byte[]");
    }

    public static String a(Context context, rj rjVar) {
        StringBuilder sb = new StringBuilder();
        try {
            String g = rd.g(context);
            sb.append("\"sim\":\"");
            sb.append(g);
            sb.append("\",\"sdkversion\":\"");
            sb.append(rjVar.c());
            sb.append("\",\"product\":\"");
            sb.append(rjVar.a());
            sb.append("\",\"ed\":\"");
            sb.append(rjVar.e());
            sb.append("\",\"nt\":\"");
            sb.append(rd.e(context));
            sb.append("\",\"np\":\"");
            sb.append(rd.c(context));
            sb.append("\",\"mnc\":\"");
            sb.append(rd.d(context));
            sb.append("\",\"ant\":\"");
            sb.append(rd.f(context));
            sb.append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }
}
