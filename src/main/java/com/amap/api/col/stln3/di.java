package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.CoordUtil;
import com.autonavi.amap.mapcore.DPoint;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: OffsetUtil */
public final class di {
    static double a = 3.141592653589793d;
    public static double b = 6378245.0d;
    public static double c = 0.006693421622965943d;
    private static boolean d = false;
    private static final double[] e = {25.575374d, 120.391111d};
    private static final double[] f = {21.405235d, 121.649046d};
    private static final List<LatLng> g = new ArrayList(Arrays.asList(new LatLng(23.379947d, 119.757001d), new LatLng(24.983296d, 120.474496d), new LatLng(25.518722d, 121.359866d), new LatLng(25.41329d, 122.443582d), new LatLng(24.862708d, 122.288354d), new LatLng(24.461292d, 122.188319d), new LatLng(21.584761d, 120.968923d), new LatLng(21.830837d, 120.654445d)));

    public static LatLng a(Context context, LatLng latLng) {
        if (context == null) {
            return null;
        }
        if (!hv.a(latLng.latitude, latLng.longitude)) {
            return latLng;
        }
        String a2 = rc.a(context, "libwgs2gcj.so");
        if (!TextUtils.isEmpty(a2) && new File(a2).exists() && !d) {
            try {
                System.load(a2);
                d = true;
            } catch (Throwable th) {
                ri.a(context, th);
            }
        }
        DPoint a3 = a(DPoint.obtain(latLng.longitude, latLng.latitude), d);
        LatLng latLng2 = new LatLng(a3.y, a3.x, false);
        a3.recycle();
        return latLng2;
    }

    private static DPoint a(DPoint dPoint, boolean z) {
        try {
            if (!hv.a(dPoint.y, dPoint.x)) {
                return dPoint;
            }
            double[] dArr = new double[2];
            if (z) {
                try {
                    if (CoordUtil.convertToGcj(new double[]{dPoint.x, dPoint.y}, dArr) != 0) {
                        dArr = wd.a(dPoint.x, dPoint.y);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                dPoint.recycle();
                return DPoint.obtain(dArr[0], dArr[1]);
            }
            dArr = wd.a(dPoint.x, dPoint.y);
            dPoint.recycle();
            return DPoint.obtain(dArr[0], dArr[1]);
        } catch (Throwable th2) {
            return dPoint;
        }
    }

    public static LatLng b(Context context, LatLng latLng) {
        try {
            if (!hv.a(latLng.latitude, latLng.longitude)) {
                return latLng;
            }
            double d2 = (double) (((long) (latLng.longitude * 100000.0d)) % 36000000);
            double d3 = (double) (((long) (latLng.latitude * 100000.0d)) % 36000000);
            int i = (int) ((-a(d2, d3)) + d2);
            double d4 = (double) ((int) ((-b(d2, d3)) + d3));
            double d5 = (-a((double) i, d4)) + d2;
            int i2 = 1;
            double d6 = (double) ((int) (d5 + ((double) (d2 > 0.0d ? 1 : -1))));
            double d7 = (-b(d6, d4)) + d3;
            if (d3 <= 0.0d) {
                i2 = -1;
            }
            DPoint obtain = DPoint.obtain(d6 / 100000.0d, ((double) ((int) (d7 + ((double) i2)))) / 100000.0d);
            LatLng a2 = a(context, new LatLng(obtain.y, obtain.x, false));
            obtain.recycle();
            return a2;
        } catch (Throwable th) {
            th.printStackTrace();
            return latLng;
        }
    }

    private static double a(double d2, double d3) {
        return (Math.cos(d3 / 100000.0d) * (d2 / 18000.0d)) + (Math.sin(d2 / 100000.0d) * (d3 / 9000.0d));
    }

    private static double b(double d2, double d3) {
        return (Math.sin(d3 / 100000.0d) * (d2 / 18000.0d)) + (Math.cos(d2 / 100000.0d) * (d3 / 9000.0d));
    }

    public static LatLng a(LatLng latLng) {
        if (latLng != null) {
            try {
                if (hv.a(latLng.latitude, latLng.longitude)) {
                    DPoint c2 = c(latLng.longitude, latLng.latitude);
                    LatLng latLng2 = new LatLng(c2.y, c2.x, false);
                    c2.recycle();
                    return latLng2;
                } else if (!ic.a(new LatLng(latLng.latitude, latLng.longitude), g)) {
                    return latLng;
                } else {
                    DPoint c3 = c(latLng.longitude, latLng.latitude);
                    double d2 = c3.y;
                    double d3 = c3.x;
                    double d4 = d3 - 105.0d;
                    double d5 = d2 - 35.0d;
                    double d6 = d4 * 2.0d;
                    double d7 = d4 * 0.1d;
                    double d8 = d7 * d5;
                    double d9 = 6.0d * d4;
                    double sqrt = -100.0d + d6 + (d5 * 3.0d) + (d5 * 0.2d * d5) + d8 + (Math.sqrt(Math.abs(d4)) * 0.2d) + ((((Math.sin(a * d9) * 20.0d) + (Math.sin(a * d6) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(a * d5) * 20.0d) + (Math.sin((d5 / 3.0d) * a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d5 / 12.0d) * a) * 160.0d) + (Math.sin((a * d5) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
                    double sqrt2 = d4 + 300.0d + (d5 * 2.0d) + (d7 * d4) + d8 + (Math.sqrt(Math.abs(d4)) * 0.1d) + ((((Math.sin(d9 * a) * 20.0d) + (Math.sin(d6 * a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(a * d4) * 20.0d) + (Math.sin((d4 / 3.0d) * a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d4 / 12.0d) * a) * 150.0d) + (Math.sin((d4 / 30.0d) * a) * 300.0d)) * 2.0d) / 3.0d);
                    double d10 = (d2 / 180.0d) * a;
                    double sin = Math.sin(d10);
                    double d11 = 1.0d - ((c * sin) * sin);
                    double sqrt3 = Math.sqrt(d11);
                    LatLng latLng3 = new LatLng(((sqrt * 180.0d) / (((b * (1.0d - c)) / (d11 * sqrt3)) * a)) + d2, d3 + ((sqrt2 * 180.0d) / (((b / sqrt3) * Math.cos(d10)) * a)));
                    return new LatLng((d2 * 2.0d) - latLng3.latitude, (d3 * 2.0d) - latLng3.longitude);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return latLng;
    }

    private static double a(double d2) {
        return Math.sin(d2 * 3000.0d * (a / 180.0d)) * 2.0E-5d;
    }

    private static double b(double d2) {
        return Math.cos(d2 * 3000.0d * (a / 180.0d)) * 3.0E-6d;
    }

    private static double c(double d2) {
        return new BigDecimal(d2).setScale(8, 4).doubleValue();
    }

    private static DPoint c(double d2, double d3) {
        double d4 = 0.006401062d;
        double d5 = 0.0060424805d;
        DPoint dPoint = null;
        for (int i = 0; i < 2; i++) {
            dPoint = DPoint.obtain();
            double d6 = d2 - d4;
            double d7 = d3 - d5;
            DPoint obtain = DPoint.obtain();
            double d8 = (d6 * d6) + (d7 * d7);
            obtain.x = c((Math.cos(b(d6) + Math.atan2(d7, d6)) * (a(d7) + Math.sqrt(d8))) + 0.0065d);
            obtain.y = c((Math.sin(b(d6) + Math.atan2(d7, d6)) * (a(d7) + Math.sqrt(d8))) + 0.006d);
            dPoint.x = c((d6 + d2) - obtain.x);
            dPoint.y = c((d3 + d7) - obtain.y);
            d4 = d2 - dPoint.x;
            d5 = d3 - dPoint.y;
        }
        return dPoint;
    }
}
