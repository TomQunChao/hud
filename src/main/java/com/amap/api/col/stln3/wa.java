package com.amap.api.col.stln3;

import android.content.Context;

/* compiled from: RollBackDynamic */
public final class wa {
    static boolean a = false;
    static boolean b = false;
    static boolean c = false;
    static boolean d = false;
    static int e = 0;
    static int f = 0;
    static boolean g = true;
    static boolean h = false;

    public static void a(Context context, rj rjVar) {
        if (!d) {
            c = sk.b(context, rjVar);
            d = true;
            if (!c && vu.d()) {
                sk.a(context, "loc");
                vz.a("dexrollbackstatistics", "RollBack because of version error");
            }
        }
    }

    private static boolean e(Context context) {
        if (!d) {
            a(context, vu.b());
        }
        return c;
    }

    public static void a(Context context) {
        try {
            if (e(context) && !a) {
                wb.a(context, "loc", "startMark", wb.b(context, "loc", "startMark", 0) + 1);
                a = true;
            }
        } catch (Throwable th) {
            vu.a(th, "RollBackDynamic", "AddStartMark");
        }
    }

    public static void b(Context context) {
        try {
            if (e(context) && !b) {
                wb.a(context, "loc", "endMark", wb.b(context, "loc", "endMark", 0) + 1);
                b = true;
            }
        } catch (Throwable th) {
            vu.a(th, "RollBackDynamic", "AddEndMark");
        }
    }

    public static boolean c(Context context) {
        try {
            if (!e(context)) {
                return false;
            }
            if (h) {
                return g;
            }
            if (e == 0) {
                e = wb.b(context, "loc", "startMark", 0);
            }
            if (f == 0) {
                f = wb.b(context, "loc", "endMark", 0);
            }
            if (!a && !b) {
                if (e < f) {
                    a(context, 0);
                    g = true;
                }
                if (e - f > 0 && e > 99) {
                    a(context, 0);
                    g = true;
                }
                if (e - f > 0 && e < 99) {
                    a(context, -2);
                    g = false;
                }
                if (e - f > 0 && f < 0) {
                    a(context, "loc", "checkMark");
                    g = false;
                }
            }
            wb.a(context, "loc", "isload", g);
            h = true;
            return g;
        } catch (Throwable th) {
            vu.a(th, "RollBackDynamic", "checkMark");
        }
    }

    public static boolean d(Context context) {
        try {
            if (!e(context)) {
                return false;
            }
            return wb.b(context, "loc", "isload", false);
        } catch (Throwable th) {
            vu.a(th, "RollBackDynamic", "isLoad");
            return true;
        }
    }

    private static void a(Context context, int i) {
        try {
            if (e(context)) {
                wb.a(context, "loc", "endMark", i);
                wb.a(context, "loc", "startMark", i);
            }
        } catch (Throwable th) {
            vu.a(th, "RollBackDynamic", "resetMark");
        }
    }

    public static void a(Context context, String str, String str2) {
        try {
            sk.a(context, str);
            vz.a("dexrollbackstatistics", "RollBack because of " + str2);
        } catch (Throwable th) {
            vu.a(th, "RollBackDynamic", "rollBackDynamicFile");
        }
    }
}
