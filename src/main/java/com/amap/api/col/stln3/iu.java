package com.amap.api.col.stln3;

import android.content.Context;
import android.content.SharedPreferences;
import com.amap.api.navi.model.NaviLatLng;
import com.autonavi.ae.pos.LocInfo;
import com.autonavi.ae.route.model.POIInfo;

/* compiled from: Ae8Temp */
public final class iu {
    private static POIInfo[] a = new POIInfo[0];
    private static POIInfo[] b = new POIInfo[0];
    private static POIInfo[] c = new POIInfo[0];
    private static int d = 0;
    private static NaviLatLng e = new NaviLatLng();
    private static float f;
    private static double g;
    private static LocInfo h = null;

    public static boolean a() {
        POIInfo[] pOIInfoArr;
        POIInfo[] pOIInfoArr2 = a;
        if (pOIInfoArr2 == null || (pOIInfoArr = c) == null || pOIInfoArr.length <= 0 || pOIInfoArr2.length <= 0) {
            return false;
        }
        return true;
    }

    public static void a(float f2, double d2) {
        f = f2;
        g = d2;
    }

    public static float b() {
        return f;
    }

    public static double c() {
        return g;
    }

    public static POIInfo[] d() {
        return a;
    }

    public static void a(POIInfo[] pOIInfoArr) {
        a = pOIInfoArr;
    }

    public static POIInfo[] e() {
        return b;
    }

    public static void b(POIInfo[] pOIInfoArr) {
        b = pOIInfoArr;
    }

    public static POIInfo[] f() {
        return c;
    }

    public static void c(POIInfo[] pOIInfoArr) {
        c = pOIInfoArr;
    }

    public static int g() {
        return d;
    }

    public static void a(int i) {
        d = i;
    }

    public static NaviLatLng a(Context context) {
        NaviLatLng naviLatLng = e;
        if (naviLatLng != null && naviLatLng.getLatitude() >= 1.0d && e.getLongitude() >= 1.0d) {
            return e;
        }
        NaviLatLng c2 = c(context);
        e = c2;
        return c2;
    }

    public static void a(NaviLatLng naviLatLng) {
        if (naviLatLng != null) {
            e = naviLatLng;
        }
    }

    public static void a(LocInfo locInfo) {
        if (locInfo != null) {
            h = locInfo;
        }
    }

    public static LocInfo h() {
        return h;
    }

    public static void b(Context context) {
        try {
            if (e != null) {
                double longitude = e.getLongitude();
                double latitude = e.getLatitude();
                SharedPreferences.Editor edit = context.getSharedPreferences("SDK_API", 0).edit();
                edit.putFloat("CURRENT_LOCATION_LON", (float) longitude);
                edit.putFloat("CURRENT_LOCATION_LAT", (float) latitude);
                edit.apply();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static NaviLatLng c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("SDK_API", 0);
            float f2 = sharedPreferences.getFloat("CURRENT_LOCATION_LON", 0.0f);
            float f3 = sharedPreferences.getFloat("CURRENT_LOCATION_LAT", 0.0f);
            if (f2 != 0.0f) {
                if (f3 != 0.0f) {
                    return new NaviLatLng((double) f3, (double) f2);
                }
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
