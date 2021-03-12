package com.amap.api.col.stln3;

import android.content.Context;

/* compiled from: OfflineLocEntity */
public final class ue {
    private Context a;
    private rj b;
    private String c;

    public ue(Context context, rj rjVar, String str) {
        this.a = context.getApplicationContext();
        this.b = rjVar;
        this.c = str;
    }

    /* access modifiers changed from: package-private */
    public final byte[] a() {
        return rk.a(a(this.a, this.b, this.c));
    }

    private static String a(Context context, rj rjVar, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sdkversion\":\"");
            sb.append(rjVar.c());
            sb.append("\",\"product\":\"");
            sb.append(rjVar.a());
            sb.append("\",\"nt\":\"");
            sb.append(rd.e(context));
            sb.append("\",\"details\":");
            sb.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }
}
