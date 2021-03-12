package com.amap.api.col.stln3;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.api.col.stln3.qz;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AuthUtil */
public final class vt {
    private static int A = 0;
    private static int B = 0;
    private static boolean C = true;
    private static int D = 1000;
    private static int E = 200;
    private static boolean F = false;
    private static int G = 20;
    private static boolean H = true;
    private static boolean I = true;
    private static int J = -1;
    private static long K = 0;
    private static ArrayList<String> L = new ArrayList<>();
    private static boolean M = false;
    private static int N = -1;
    private static long O = 0;
    private static ArrayList<String> P = new ArrayList<>();
    private static String Q;
    private static String R;
    private static boolean S = false;
    private static boolean T = false;
    private static int U = 3000;
    private static int V = 3000;
    private static boolean W = true;
    private static long X = 300000;
    private static boolean Y = false;
    private static List<vw> Z = new ArrayList();
    public static boolean a = true;
    private static boolean aa = false;
    private static long ab = 0;
    private static int ac = 0;
    private static int ad = 0;
    private static List<String> ae = new ArrayList();
    private static boolean af = true;
    private static int ag = 80;
    private static boolean ah = false;
    private static boolean ai = true;
    private static boolean aj = false;
    private static boolean ak = true;
    private static boolean al = false;
    private static int am = -1;
    private static boolean an = true;
    private static long ao = -1;
    static boolean b = false;
    static boolean c = false;
    static int d = 3600000;
    static long e = 0;
    static long f = 0;
    static boolean g = false;
    static boolean h = true;
    static boolean i = false;
    private static boolean j = false;
    private static String k = "提示信息";
    private static String l = "确认";
    private static String m = "取消";
    private static String n = "";
    private static String o = "";
    private static String p = "";
    private static boolean q = false;
    private static long r = 0;
    private static long s = 0;
    private static long t = 5000;
    private static boolean u = false;
    private static int v = 0;
    private static boolean w = false;
    private static int x = 0;
    private static boolean y = false;
    private static int z = 3600000;

    public static boolean a(Context context) {
        H = true;
        boolean z2 = false;
        try {
            j = wb.b(context, "pref", "oda", false);
            qz.a a2 = qz.a(context, vu.b(), vu.c(), null, j);
            if (a2 != null) {
                z2 = a(context, a2);
            }
        } catch (Throwable th) {
            vu.a(th, "AuthUtil", "getConfig");
        }
        f = wc.b();
        e = wc.b();
        return z2;
    }

    public static boolean a(long j2) {
        long b2 = wc.b();
        if (!q || b2 - s > r || b2 - j2 < t) {
            return false;
        }
        return true;
    }

    public static boolean a() {
        return u;
    }

    public static int b() {
        return v;
    }

    public static boolean c() {
        return w;
    }

    public static int d() {
        return x;
    }

    public static boolean e() {
        return y;
    }

    public static String f() {
        return k;
    }

    public static String g() {
        return l;
    }

    public static String h() {
        return m;
    }

    public static String i() {
        return n;
    }

    public static String j() {
        return o;
    }

    public static String k() {
        return p;
    }

    public static boolean l() {
        return b;
    }

    public static ArrayList<String> m() {
        return L;
    }

    public static ArrayList<String> n() {
        return P;
    }

    public static boolean o() {
        return C;
    }

    public static int p() {
        return E;
    }

    public static boolean q() {
        return H;
    }

    public static void r() {
        H = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:116:0x0365 A[Catch:{ Throwable -> 0x0376 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0367 A[Catch:{ Throwable -> 0x0376 }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x03dd A[SYNTHETIC, Splitter:B:139:0x03dd] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x043a A[Catch:{ Throwable -> 0x04e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0514 A[Catch:{ Throwable -> 0x05b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x053e  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0579  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x05c6 A[Catch:{ Throwable -> 0x0602 }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0617 A[Catch:{ Throwable -> 0x065a }] */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x066f A[Catch:{ Throwable -> 0x067f }] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0694 A[Catch:{ Throwable -> 0x0800 }] */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0700 A[SYNTHETIC, Splitter:B:239:0x0700] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x07d3  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x0815 A[Catch:{ Throwable -> 0x083b }] */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x084f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(android.content.Context r16, com.amap.api.col.stln3.qz.a r17) {
        /*
        // Method dump skipped, instructions count: 2537
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.vt.a(android.content.Context, com.amap.api.col.stln3.qz$a):boolean");
    }

    private static a a(JSONObject jSONObject, String str) {
        a aVar;
        Throwable th;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                if (jSONObject2 != null) {
                    aVar = new a();
                    try {
                        aVar.a = qz.a(jSONObject2.optString("b"), false);
                        aVar.b = jSONObject2.optString("t");
                        aVar.c = qz.a(jSONObject2.optString("st"), false);
                        aVar.d = jSONObject2.optInt("i", 0);
                        return aVar;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                aVar = null;
                vu.a(th, "AuthUtil", "getLocateObj");
                return aVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* compiled from: AuthUtil */
    public static class a {
        boolean a = false;
        String b = "0";
        boolean c = false;
        int d = 5;

        a() {
        }
    }

    public static boolean b(Context context) {
        if (!I) {
            return false;
        }
        if (J == -1 || K == 0) {
            return true;
        }
        if (!wc.b(K, wb.b(context, "pref", "nowtime", 0L))) {
            i(context);
            wb.a(context, "pref", "count", 1);
            return true;
        }
        int b2 = wb.b(context, "pref", "count", 0);
        if (b2 >= J) {
            return false;
        }
        wb.a(context, "pref", "count", b2 + 1);
        return true;
    }

    private static void i(Context context) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pref", 0).edit();
            edit.putLong("nowtime", K);
            edit.putInt("count", 0);
            wb.a(edit);
        } catch (Throwable th) {
            vu.a(th, "AuthUtil", "resetPrefsBind");
        }
    }

    public static boolean c(Context context) {
        if (!M) {
            return false;
        }
        if (N == -1 || O == 0) {
            return true;
        }
        if (!wc.b(O, wb.b(context, "pref", "pushSerTime", 0L))) {
            j(context);
            wb.a(context, "pref", "pushCount", 1);
            return true;
        }
        int b2 = wb.b(context, "pref", "pushCount", 0);
        if (b2 >= N) {
            return false;
        }
        wb.a(context, "pref", "pushCount", b2 + 1);
        return true;
    }

    private static void j(Context context) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pref", 0).edit();
            edit.putLong("pushSerTime", O);
            edit.putInt("pushCount", 0);
            wb.a(edit);
        } catch (Throwable th) {
            vu.a(th, "AuthUtil", "resetPrefsBind");
        }
    }

    public static boolean d(Context context) {
        int i2;
        int i3;
        int b2;
        if (!S || (i2 = B) <= 0 || (i3 = A) <= 0 || i2 > i3) {
            return false;
        }
        long b3 = wb.b(context, "abcd", "lct", 0L);
        long b4 = wb.b(context, "abcd", "lst", 0L);
        long b5 = wc.b();
        if (b5 < b3) {
            wb.a(context, "abcd", "lct", b5);
            return false;
        }
        if (b5 - b3 > 86400000) {
            wb.a(context, "abcd", "lct", b5);
            wb.a(context, "abcd", "t", 0);
        }
        if (b5 - b4 < ((long) z) || (b2 = wb.b(context, "abcd", "t", 0) + 1) > A) {
            return false;
        }
        wb.a(context, "abcd", "lst", b5);
        wb.a(context, "abcd", "t", b2);
        return true;
    }

    public static void e(Context context) {
        try {
            C = wb.b(context, "pref", "exception", C);
            f(context);
        } catch (Throwable th) {
            vu.a(th, "AuthUtil", "loadLastAbleState p1");
        }
        try {
            D = wb.b(context, "pref", "fn", D);
            E = wb.b(context, "pref", "mpn", E);
            F = wb.b(context, "pref", "igu", F);
            G = wb.b(context, "pref", "ms", G);
            uf.a(D, F, G);
        } catch (Throwable th2) {
        }
        try {
            W = wb.b(context, "pref", "ca", W);
            X = wb.b(context, "pref", "ct", X);
        } catch (Throwable th3) {
        }
        try {
            h = wb.b(context, "pref", "fr", h);
        } catch (Throwable th4) {
        }
        try {
            aj = wb.b(context, "pref", "ok0", aj);
            i = wb.b(context, "pref", "ok1", i);
            ak = wb.b(context, "pref", "ok2", ak);
            al = wb.b(context, "pref", "ok3", al);
        } catch (Throwable th5) {
        }
        try {
            an = wb.b(context, "pref", "asw", an);
        } catch (Throwable th6) {
        }
        try {
            ao = wb.b(context, "pref", "awsi", ao);
        } catch (Throwable th7) {
        }
    }

    public static boolean s() {
        return T;
    }

    public static boolean a(Context context, long j2) {
        if (!T) {
            return false;
        }
        long a2 = wc.a();
        if (a2 - j2 < ((long) U)) {
            return false;
        }
        if (V == -1) {
            return true;
        }
        if (!wc.c(a2, wb.b(context, "pref", "ngpsTime", 0L))) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("pref", 0).edit();
                edit.putLong("ngpsTime", a2);
                edit.putInt("ngpsCount", 0);
                wb.a(edit);
            } catch (Throwable th) {
                vu.a(th, "AuthUtil", "resetPrefsNGPS");
            }
            wb.a(context, "pref", "ngpsCount", 1);
            return true;
        }
        int b2 = wb.b(context, "pref", "ngpsCount", 0);
        if (b2 >= V) {
            return false;
        }
        wb.a(context, "pref", "ngpsCount", b2 + 1);
        return true;
    }

    public static long t() {
        return X;
    }

    public static boolean u() {
        return W;
    }

    public static boolean b(long j2) {
        if (!W) {
            return false;
        }
        long a2 = wc.a() - j2;
        long j3 = X;
        if (j3 < 0 || a2 < j3) {
            return true;
        }
        return false;
    }

    public static boolean v() {
        return Y;
    }

    private static boolean a(Context context, qz.a.b bVar, String str, String str2) {
        if (bVar != null) {
            try {
                boolean z2 = bVar.a;
                String str3 = bVar.b;
                String str4 = bVar.c;
                String str5 = bVar.d;
                boolean z3 = bVar.e;
                rj a2 = vu.a(str, str2);
                if (z2) {
                    if (z3) {
                        if (!TextUtils.isEmpty(str4)) {
                            if (!TextUtils.isEmpty(str3)) {
                                if (!TextUtils.isEmpty(str5)) {
                                    sj sjVar = new sj(str3, str4);
                                    sjVar.a(j);
                                    sk.b(context, sjVar, a2);
                                }
                            }
                        }
                    }
                } else if (vz.a(context, a2)) {
                    wa.a(context, str, "config|get dex able is false");
                }
                if (!z2 || !z3) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                vu.a(th, "AuthUtil", "downLoadPluginDex");
            }
        }
        return false;
    }

    public static void f(Context context) {
        try {
            rj b2 = vu.b();
            b2.a(C);
            rx.a(context, b2);
        } catch (Throwable th) {
        }
    }

    public static boolean g(Context context) {
        int i2 = ac;
        boolean z2 = i2 != -1 && i2 < ad;
        if (!aa || ac == 0 || ad == 0 || ab == 0 || z2) {
            return false;
        }
        List<String> list = ae;
        if (list != null && list.size() > 0) {
            for (String str : ae) {
                if (wc.b(context, str)) {
                    return false;
                }
            }
        }
        if (ac == -1 && ad == -1) {
            return true;
        }
        long b2 = wb.b(context, "pref", "ots", 0L);
        long b3 = wb.b(context, "pref", "otsh", 0L);
        int b4 = wb.b(context, "pref", "otn", 0);
        int b5 = wb.b(context, "pref", "otnh", 0);
        if (ac != -1) {
            if (!wc.b(ab, b2)) {
                try {
                    SharedPreferences.Editor edit = context.getSharedPreferences("pref", 0).edit();
                    edit.putLong("ots", ab);
                    edit.putLong("otsh", ab);
                    edit.putInt("otn", 0);
                    edit.putInt("otnh", 0);
                    wb.a(edit);
                } catch (Throwable th) {
                    vu.a(th, "AuthUtil", "resetPrefsBind");
                }
                wb.a(context, "pref", "otn", 1);
                wb.a(context, "pref", "otnh", 1);
                return true;
            } else if (b4 < ac) {
                if (ad == -1) {
                    wb.a(context, "pref", "otn", b4 + 1);
                    wb.a(context, "pref", "otnh", 0);
                    return true;
                } else if (!wc.a(ab, b3)) {
                    wb.a(context, "pref", "otsh", ab);
                    wb.a(context, "pref", "otn", b4 + 1);
                    wb.a(context, "pref", "otnh", 1);
                    return true;
                } else if (b5 < ad) {
                    wb.a(context, "pref", "otn", b4 + 1);
                    wb.a(context, "pref", "otnh", b5 + 1);
                    return true;
                }
            }
        }
        if (ac == -1) {
            wb.a(context, "pref", "otn", 0);
            if (ad == -1) {
                wb.a(context, "pref", "otnh", 0);
                return true;
            } else if (!wc.a(ab, b3)) {
                wb.a(context, "pref", "otsh", ab);
                wb.a(context, "pref", "otnh", 1);
                return true;
            } else if (b5 < ad) {
                wb.a(context, "pref", "otnh", b5 + 1);
                return true;
            }
        }
        return false;
    }

    public static List<vw> w() {
        return Z;
    }

    public static boolean x() {
        return af;
    }

    public static int y() {
        return ag;
    }

    public static boolean z() {
        return ai;
    }

    public static boolean h(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (wc.b() - f >= ((long) d)) {
                g = true;
                return true;
            }
        } catch (Throwable th) {
            vu.a(th, "Aps", "isConfigNeedUpdate");
        }
        return false;
    }

    public static boolean A() {
        boolean z2 = g;
        if (!z2) {
            return z2;
        }
        g = false;
        return true;
    }

    public static boolean B() {
        return h;
    }

    public static boolean C() {
        return aj;
    }

    public static boolean D() {
        return al;
    }

    public static boolean E() {
        return ak;
    }

    public static int F() {
        return am;
    }

    public static boolean G() {
        return i;
    }

    public static boolean H() {
        return an;
    }

    public static long I() {
        return ao;
    }
}
