package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.CoordUtil;
import com.amap.api.location.DPoint;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: OffsetUtil */
public final class vv {
    static double a = 3.141592653589793d;
    private static final List<DPoint> b = new ArrayList(Arrays.asList(new DPoint(23.379947d, 119.757001d), new DPoint(24.983296d, 120.474496d), new DPoint(25.518722d, 121.359866d), new DPoint(25.41329d, 122.443582d), new DPoint(24.862708d, 122.288354d), new DPoint(24.461292d, 122.188319d), new DPoint(21.584761d, 120.968923d), new DPoint(21.830837d, 120.654445d)));

    public static DPoint a(Context context, DPoint dPoint) {
        if (context == null) {
            return null;
        }
        String a2 = rc.a(context, "libwgs2gcj.so");
        if (!TextUtils.isEmpty(a2) && new File(a2).exists() && !CoordUtil.isLoadedSo()) {
            try {
                System.load(a2);
                CoordUtil.setLoadedSo(true);
            } catch (Throwable th) {
            }
        }
        return a(dPoint, CoordUtil.isLoadedSo());
        vu.a(th, "OffsetUtil", "offset");
        return a(dPoint, CoordUtil.isLoadedSo());
    }

    public static DPoint a(Context context, double d, double d2) {
        if (context == null) {
            return null;
        }
        return a(context, new DPoint(d2, d));
    }

    private static DPoint a(DPoint dPoint, boolean z) {
        try {
            if (!vu.a(dPoint.getLatitude(), dPoint.getLongitude())) {
                return dPoint;
            }
            double[] dArr = new double[2];
            if (z) {
                try {
                    if (CoordUtil.convertToGcj(new double[]{dPoint.getLongitude(), dPoint.getLatitude()}, dArr) != 0) {
                    }
                } catch (Throwable th) {
                    vu.a(th, "OffsetUtil", "cover part1");
                } finally {
                    wd.a(dPoint.getLongitude(), dPoint.getLatitude());
                }
            } else {
                dArr = wd.a(dPoint.getLongitude(), dPoint.getLatitude());
            }
            return new DPoint(dArr[1], dArr[0]);
        } catch (Throwable th2) {
            vu.a(th2, "OffsetUtil", "cover part2");
            return dPoint;
        }
    }

    public static DPoint b(Context context, DPoint dPoint) {
        try {
            if (!vu.a(dPoint.getLatitude(), dPoint.getLongitude())) {
                return dPoint;
            }
            double longitude = (double) (((long) (dPoint.getLongitude() * 100000.0d)) % 36000000);
            double latitude = (double) (((long) (dPoint.getLatitude() * 100000.0d)) % 36000000);
            double d = (double) ((int) ((-a(longitude, latitude)) + longitude));
            double d2 = (double) ((int) ((-b(longitude, latitude)) + latitude));
            int i = 1;
            double d3 = (double) ((int) ((-a(d, d2)) + longitude + ((double) (longitude > 0.0d ? 1 : -1))));
            double d4 = (-b(d3, d2)) + latitude;
            if (latitude <= 0.0d) {
                i = -1;
            }
            return a(context, new DPoint(((double) ((int) (d4 + ((double) i)))) / 100000.0d, d3 / 100000.0d));
        } catch (Throwable th) {
            vu.a(th, "OffsetUtil", "marbar2G");
            return dPoint;
        }
    }

    private static double a(double d, double d2) {
        return (Math.cos(d2 / 100000.0d) * (d / 18000.0d)) + (Math.sin(d / 100000.0d) * (d2 / 9000.0d));
    }

    private static double b(double d, double d2) {
        return (Math.sin(d2 / 100000.0d) * (d / 18000.0d)) + (Math.cos(d / 100000.0d) * (d2 / 9000.0d));
    }

    public static DPoint a(DPoint dPoint) {
        if (dPoint != null) {
            try {
                if (vu.a(dPoint.getLatitude(), dPoint.getLongitude())) {
                    return b(dPoint);
                }
                if (!vu.a(new DPoint(dPoint.getLatitude(), dPoint.getLongitude()), b)) {
                    return dPoint;
                }
                DPoint b2 = b(dPoint);
                double latitude = b2.getLatitude();
                double longitude = b2.getLongitude();
                double d = longitude - 105.0d;
                double d2 = latitude - 35.0d;
                double d3 = d * 2.0d;
                double d4 = d * 0.1d;
                double d5 = d4 * d2;
                double d6 = 6.0d * d;
                double sqrt = -100.0d + d3 + (d2 * 3.0d) + (d2 * 0.2d * d2) + d5 + (Math.sqrt(Math.abs(d)) * 0.2d) + ((((Math.sin(a * d6) * 20.0d) + (Math.sin(a * d3) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(a * d2) * 20.0d) + (Math.sin((d2 / 3.0d) * a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d2 / 12.0d) * a) * 160.0d) + (Math.sin((a * d2) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
                double sqrt2 = d + 300.0d + (d2 * 2.0d) + (d4 * d) + d5 + (Math.sqrt(Math.abs(d)) * 0.1d) + ((((Math.sin(d6 * a) * 20.0d) + (Math.sin(d3 * a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(a * d) * 20.0d) + (Math.sin((d / 3.0d) * a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d / 12.0d) * a) * 150.0d) + (Math.sin((d / 30.0d) * a) * 300.0d)) * 2.0d) / 3.0d);
                double d7 = (latitude / 180.0d) * a;
                double sin = Math.sin(d7);
                double d8 = 1.0d - ((0.006693421622965943d * sin) * sin);
                double sqrt3 = Math.sqrt(d8);
                DPoint dPoint2 = new DPoint(((sqrt * 180.0d) / ((6335552.717000426d / (d8 * sqrt3)) * a)) + latitude, longitude + ((sqrt2 * 180.0d) / (((6378245.0d / sqrt3) * Math.cos(d7)) * a)));
                return new DPoint((latitude * 2.0d) - dPoint2.getLatitude(), (longitude * 2.0d) - dPoint2.getLongitude());
            } catch (Throwable th) {
                vu.a(th, "OffsetUtil", "b2G");
            }
        }
        return dPoint;
    }

    private static double a(double d) {
        return Math.sin(d * 3000.0d * (a / 180.0d)) * 2.0E-5d;
    }

    private static double b(double d) {
        return Math.cos(d * 3000.0d * (a / 180.0d)) * 3.0E-6d;
    }

    private static double c(double d) {
        return new BigDecimal(d).setScale(8, 4).doubleValue();
    }

    private static DPoint b(DPoint dPoint) {
        double d = 0.006401062d;
        double d2 = 0.0060424805d;
        DPoint dPoint2 = null;
        for (int i = 0; i < 2; i++) {
            double longitude = dPoint.getLongitude();
            double latitude = dPoint.getLatitude();
            dPoint2 = new DPoint();
            double d3 = longitude - d;
            double d4 = latitude - d2;
            DPoint dPoint3 = new DPoint();
            double d5 = (d3 * d3) + (d4 * d4);
            dPoint3.setLongitude(c((Math.cos(b(d3) + Math.atan2(d4, d3)) * (a(d4) + Math.sqrt(d5))) + 0.0065d));
            dPoint3.setLatitude(c((Math.sin(b(d3) + Math.atan2(d4, d3)) * (a(d4) + Math.sqrt(d5))) + 0.006d));
            dPoint2.setLongitude(c((longitude + d3) - dPoint3.getLongitude()));
            dPoint2.setLatitude(c((latitude + d4) - dPoint3.getLatitude()));
            d = dPoint.getLongitude() - dPoint2.getLongitude();
            d2 = dPoint.getLatitude() - dPoint2.getLatitude();
        }
        return dPoint2;
    }
}
