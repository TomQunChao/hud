package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

/* compiled from: ClientInfo */
public final class rb {
    public static String a(Context context, String str, String str2) {
        try {
            String e = qy.e(context);
            return rg.b(e + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            ru.a(th, "CI", "Sco");
            return null;
        }
    }

    public static String a() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = "1";
            if (!qy.a()) {
                str = "0";
            }
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (Throwable th) {
            ru.a(th, "CI", "TS");
            return null;
        }
    }

    public static String a(Context context) {
        try {
            a aVar = new a((byte) 0);
            aVar.d = qy.c(context);
            aVar.i = qy.d(context);
            return re.b(a(aVar));
        } catch (Throwable th) {
            ru.a(th, "CI", "IX");
            return null;
        }
    }

    public static byte[] a(Context context, boolean z) {
        try {
            return a(b(context, z));
        } catch (Throwable th) {
            ru.a(th, "CI", "gz");
            return null;
        }
    }

    public static String b(Context context) {
        try {
            return re.b(a(b(context, false)));
        } catch (Throwable th) {
            ru.a(th, "CI", "gCX");
            return null;
        }
    }

    @Deprecated
    public static String c(Context context) {
        try {
            return re.b(a(b(context, false)));
        } catch (Throwable th) {
            ru.a(th, "CI", "rsc");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00cf A[SYNTHETIC, Splitter:B:22:0x00cf] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] a(com.amap.api.col.stln3.rb.a r7) {
        /*
        // Method dump skipped, instructions count: 233
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.rb.a(com.amap.api.col.stln3.rb$a):byte[]");
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        byte b;
        if (!TextUtils.isEmpty(str)) {
            if (str.getBytes().length > 255) {
                b = -1;
            } else {
                b = (byte) str.getBytes().length;
            }
            rk.a(byteArrayOutputStream, b, rk.a(str));
            return;
        }
        rk.a(byteArrayOutputStream, (byte) 0, new byte[0]);
    }

    private static a b(Context context, boolean z) {
        a aVar = new a((byte) 0);
        aVar.a = rd.v(context);
        aVar.b = rd.m(context);
        String h = rd.h(context);
        if (h == null) {
            h = "";
        }
        aVar.c = h;
        aVar.d = qy.c(context);
        aVar.e = Build.MODEL;
        aVar.f = Build.MANUFACTURER;
        aVar.g = Build.DEVICE;
        aVar.h = qy.b(context);
        aVar.i = qy.d(context);
        aVar.j = String.valueOf(Build.VERSION.SDK_INT);
        aVar.k = rd.x(context);
        aVar.l = rd.u(context);
        StringBuilder sb = new StringBuilder();
        sb.append(rd.r(context));
        aVar.m = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(rd.q(context));
        aVar.n = sb2.toString();
        aVar.o = rd.z(context);
        aVar.p = rd.p(context);
        if (z) {
            aVar.q = "";
        } else {
            aVar.q = rd.l(context);
        }
        if (z) {
            aVar.r = "";
        } else {
            aVar.r = rd.k(context);
        }
        if (z) {
            aVar.s = "";
            aVar.t = "";
        } else {
            String[] n = rd.n(context);
            aVar.s = n[0];
            aVar.t = n[1];
        }
        aVar.w = rd.a();
        String b = rd.b(context);
        if (!TextUtils.isEmpty(b)) {
            aVar.x = b;
        } else {
            aVar.x = "";
        }
        aVar.y = new String(rs.a(11)) + rd.j(context) + "|" + new String(rs.a(12)) + rd.i(context) + "|storage=" + rd.c() + "|ram=" + rd.y(context) + "|arch=" + rd.d();
        String a2 = rd.a(context);
        if (!TextUtils.isEmpty(a2)) {
            aVar.y += "|adiuExtras=" + a2;
        }
        String a3 = rd.a(context, ",");
        if (!TextUtils.isEmpty(a3)) {
            aVar.y += "|multiImeis=" + a3;
        }
        String w = rd.w(context);
        if (!TextUtils.isEmpty(w)) {
            aVar.y += "|meid=" + w;
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    /* compiled from: ClientInfo */
    public static class a {
        String a;
        String b;
        String c;
        String d;
        String e;
        String f;
        String g;
        String h;
        String i;
        String j;
        String k;
        String l;
        String m;
        String n;
        String o;
        String p;
        String q;
        String r;
        String s;
        String t;
        String u;
        String v;
        String w;
        String x;
        String y;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }
}
