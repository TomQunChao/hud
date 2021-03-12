package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.navi.model.NaviLatLng;
import java.util.Calendar;

/* compiled from: AuthUtils */
public final class mf {
    static String a = "14P";
    static String b = "14Q";
    static String c = "158";
    static String d = "15F";
    public static boolean e = true;
    public static int f = 2;
    public static String g = " ";
    public static String h = "120102";
    private static boolean i = false;
    private static boolean j = false;
    private static boolean k = false;

    static /* synthetic */ void b(Context context) {
        e = ly.b(context, "online_car_hailing_able", e);
        f = ly.b(context, "online_car_hailing_poitype", f);
        g = ly.c(context, "online_car_hailing_poiid", g);
        h = ly.c(context, "online_car_hailing_typecode", h);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01d0, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01d1, code lost:
        r1.printStackTrace();
        com.amap.api.col.stln3.rx.c(r1, "AuthUtils", "loadOfflineTtsConfig(Context context, JSONObject jsonObject)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01f5, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01f6, code lost:
        r7.printStackTrace();
        r7 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01f9, code lost:
        com.amap.api.col.stln3.rx.c(r7, "AuthUtils", "loadAuthConfig(Context context)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0200, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0201, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0202, code lost:
        r7.printStackTrace();
        r7 = r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0201 A[ExcHandler: qx (r7v1 'e' com.amap.api.col.stln3.qx A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void c(android.content.Context r7) {
        /*
        // Method dump skipped, instructions count: 518
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.mf.c(android.content.Context):void");
    }

    public static void a(final Context context) {
        try {
            jg.a().execute(new Runnable() {
                /* class com.amap.api.col.stln3.mf.AnonymousClass1 */

                public final void run() {
                    try {
                        mf.b(context);
                        mf.c(context.getApplicationContext());
                        NaviLatLng a2 = iu.a(context);
                        if (a2 != null) {
                            Calendar instance = Calendar.getInstance();
                            int i = instance.get(1);
                            int i2 = 1 + instance.get(2);
                            int i3 = instance.get(5);
                            mg.a(i, i2, i3, a2.getLatitude(), a2.getLongitude());
                            mg.b(i, i2, i3, a2.getLatitude(), a2.getLongitude());
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviCore", "initAuth()");
        }
    }

    public static boolean a() {
        return i;
    }

    public static boolean b() {
        return j;
    }
}
