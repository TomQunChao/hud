package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ErrorLogManager */
public class ry {
    private static WeakReference<ub> a;
    private static boolean b = true;
    private static WeakReference<uv> c;
    private static WeakReference<uv> d;
    private static String[] e = new String[10];
    private static int f = 0;
    private static boolean g = false;
    private static int h = 0;
    private static rj i;

    private static boolean a(rj rjVar) {
        return rjVar != null && rjVar.f();
    }

    private static void a(Context context, rj rjVar, int i2, String str, String str2) {
        String str3;
        String a2 = rk.a(System.currentTimeMillis());
        String a3 = ui.a(context, rjVar);
        qy.a(context);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a3);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(a2);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i2);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\"");
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !"".equals(stringBuffer2)) {
            String c2 = rg.c(str2);
            if (i2 == 1) {
                str3 = rv.b;
            } else if (i2 == 2) {
                str3 = rv.d;
            } else if (i2 == 0) {
                str3 = rv.c;
            } else {
                return;
            }
            ub a4 = ui.a(a);
            ui.a(context, a4, str3, 1000, 20480, "1");
            if (a4.e == null) {
                a4.e = new rm(new rn(new rp(new rr())));
            }
            try {
                uc.a(c2, rk.a(stringBuffer2), a4);
            } catch (Throwable th) {
            }
        }
    }

    static void a(Context context) {
        String a2;
        rj rjVar;
        List<rj> c2 = rv.c(context);
        if (c2 != null && c2.size() != 0 && (a2 = a(c2)) != null && !"".equals(a2) && (rjVar = i) != null) {
            a(context, rjVar, 2, "ANR", a2);
        }
    }

    public static void a(Context context, Throwable th, int i2, String str, String str2) {
        String a2 = rk.a(th);
        rj a3 = a(context, a2);
        if (a(a3)) {
            String replaceAll = a2.replaceAll("\n", "<br/>");
            String th2 = th.toString();
            if (th2 != null && !"".equals(th2)) {
                StringBuilder sb = new StringBuilder();
                if (str != null) {
                    sb.append("class:");
                    sb.append(str);
                }
                if (str2 != null) {
                    sb.append(" method:");
                    sb.append(str2);
                    sb.append("$<br/>");
                }
                sb.append(replaceAll);
                a(context, a3, i2, th2, sb.toString());
            }
        }
    }

    static void a(rj rjVar, Context context, String str, String str2) {
        if (a(rjVar) && str != null && !"".equals(str)) {
            a(context, rjVar, 0, str, str2);
        }
    }

    static void b(rj rjVar, Context context, String str, String str2) {
        if (a(rjVar) && str != null && !"".equals(str)) {
            a(context, rjVar, 1, str, str2);
        }
    }

    static void b(Context context) {
        ut utVar = new ut(b);
        b = false;
        a(context, utVar, rv.c);
    }

    static void c(Context context) {
        WeakReference<uv> weakReference = c;
        if (weakReference == null || weakReference.get() == null) {
            c = new WeakReference<>(new uu(context, 3600000, "hKey", new uw(context)));
        }
        a(context, c.get(), rv.d);
    }

    static void d(Context context) {
        WeakReference<uv> weakReference = d;
        if (weakReference == null || weakReference.get() == null) {
            d = new WeakReference<>(new uu(context, 3600000, "gKey", new uw(context)));
        }
        a(context, d.get(), rv.b);
    }

    private static void a(final Context context, final uv uvVar, final String str) {
        rx.d().submit(new Runnable() {
            /* class com.amap.api.col.stln3.ry.AnonymousClass1 */

            public final void run() {
                try {
                    synchronized (ry.class) {
                        ub a2 = ui.a(ry.a);
                        ui.a(context, a2, str, 1000, 20480, "1");
                        a2.f = uvVar;
                        if (a2.g == null) {
                            a2.g = new um(new ul(context, new uq(), new rn(new rp(new rr())), "EImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMiLA=", qy.f(context), rd.v(context), qy.c(context), Build.MODEL, qy.b(context), qy.d(context), Build.VERSION.RELEASE));
                        }
                        a2.h = 3600000;
                        uc.a(a2);
                    }
                } catch (Throwable th) {
                    rx.c(th, "lg", "pul");
                }
            }
        });
    }

    private static rj a(Context context, String str) {
        List<rj> c2 = rv.c(context);
        if (c2 == null) {
            c2 = new ArrayList();
        }
        if (str == null || "".equals(str)) {
            return null;
        }
        for (rj rjVar : c2) {
            if (rv.a(rjVar.g(), str)) {
                return rjVar;
            }
        }
        if (str.contains("com.amap.api.col")) {
            try {
                return rk.a();
            } catch (qx e2) {
                e2.printStackTrace();
            }
        }
        if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
            try {
                rj b2 = rk.b();
                b2.a(true);
                return b2;
            } catch (qx e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00dd, code lost:
        r10 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01c2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00df A[ExcHandler: FileNotFoundException (e java.io.FileNotFoundException), Splitter:B:12:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e2 A[ExcHandler: EOFException (e java.io.EOFException), Splitter:B:12:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x012c A[SYNTHETIC, Splitter:B:66:0x012c] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0141 A[SYNTHETIC, Splitter:B:71:0x0141] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x015b A[SYNTHETIC, Splitter:B:77:0x015b] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0170 A[SYNTHETIC, Splitter:B:82:0x0170] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x018e A[SYNTHETIC, Splitter:B:90:0x018e] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01a3 A[SYNTHETIC, Splitter:B:95:0x01a3] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.util.List<com.amap.api.col.stln3.rj> r10) {
        /*
        // Method dump skipped, instructions count: 451
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ry.a(java.util.List):java.lang.String");
    }

    private static String b() {
        StringBuilder sb = new StringBuilder();
        try {
            int i2 = f;
            while (true) {
                if (i2 >= 10) {
                    break;
                }
                if (i2 > 9) {
                    break;
                }
                sb.append(e[i2]);
                i2++;
            }
            for (int i3 = 0; i3 < f; i3++) {
                sb.append(e[i3]);
            }
        } catch (Throwable th) {
            rx.c(th, "alg", "gLI");
        }
        return sb.toString();
    }
}
