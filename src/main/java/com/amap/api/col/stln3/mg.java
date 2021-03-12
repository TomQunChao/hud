package com.amap.api.col.stln3;

import com.alibaba.idst.nls.NlsClient;
import com.amap.api.services.core.AMapException;
import java.util.Calendar;

/* compiled from: DayAndNightUtil */
public final class mg {
    static int[] a = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] b = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static double c = -0.833d;
    static int d = NlsClient.ErrorCode.ERROR_FORMAT;
    static int e = 100;
    static int f = 4;
    static int g = AMapException.CODE_AMAP_SERVICE_TABLEID_NOT_EXIST;
    static double h = 0.1d;
    static double i = 180.0d;
    static int j = -1;
    static int k = -1;
    static int l = -1;
    static int m = -1;

    private static boolean a(int i2) {
        if (i2 % d == 0) {
            return true;
        }
        if (i2 % e == 0 || i2 % f != 0) {
            return false;
        }
        return true;
    }

    private static int a(int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        for (int i7 = g; i7 < i2; i7++) {
            if (a(i7)) {
                i6 += 366;
            } else {
                i6 += 365;
            }
        }
        if (a(i2)) {
            while (i5 < i3 - 1) {
                i6 += b[i5];
                i5++;
            }
        } else {
            while (i5 < i3 - 1) {
                i6 += a[i5];
                i5++;
            }
        }
        return i6 + i4;
    }

    private static double a(int i2, double d2) {
        return (((double) i2) + (d2 / 360.0d)) / 36525.0d;
    }

    private static double a(double d2) {
        return (d2 * 36000.77d) + 280.46d;
    }

    private static double b(double d2) {
        return (d2 * 35999.05d) + 357.528d;
    }

    private static double a(double d2, double d3) {
        return d2 + (Math.sin((d3 * 3.141592653589793d) / 180.0d) * 1.915d) + (Math.sin(((d3 * 2.0d) * 3.141592653589793d) / 180.0d) * 0.02d);
    }

    private static double c(double d2) {
        return 23.4393d - (d2 * 0.013d);
    }

    private static double b(double d2, double d3) {
        return Math.asin(Math.sin(d2 * 0.017453292519943295d) * Math.sin(d3 * 0.017453292519943295d)) * 57.29577951308232d;
    }

    private static double a(double d2, double d3, double d4) {
        return ((((d2 - 180.0d) - (Math.sin((d3 * 3.141592653589793d) / 180.0d) * 1.915d)) - (Math.sin(((d3 * 2.0d) * 3.141592653589793d) / 180.0d) * 0.02d)) + (Math.sin(((2.0d * d4) * 3.141592653589793d) / 180.0d) * 2.466d)) - (Math.sin(((d4 * 4.0d) * 3.141592653589793d) / 180.0d) * 0.053d);
    }

    private static double b(double d2, double d3, double d4) {
        double d5 = (d3 * 3.141592653589793d) / 180.0d;
        double d6 = (d4 * 3.141592653589793d) / 180.0d;
        return Math.acos((Math.sin((d2 * 3.141592653589793d) / 180.0d) - (Math.sin(d5) * Math.sin(d6))) / (Math.cos(d5) * Math.cos(d6))) * 57.29577951308232d;
    }

    private static double a(double d2, double d3, double d4, double d5) {
        return d2 - ((d3 + d4) + d5);
    }

    private static double b(double d2, double d3, double d4, double d5) {
        return d2 - ((d3 + d4) - d5);
    }

    private static double a(double d2, double d3, double d4, double d5, int i2, int i3, int i4) {
        double d6;
        if (d2 >= d3) {
            d6 = d2 - d3;
        } else {
            d6 = d3 - d2;
        }
        if (d6 < h) {
            return d2;
        }
        double a2 = a(d2, a(d2, b(a(a(i2, i3, i4), d2)), a(a(a(a(i2, i3, i4), d2)), b(a(a(i2, i3, i4), d2)))), d4, b(c, d5, b(c(a(a(i2, i3, i4), d2)), a(a(a(a(i2, i3, i4), d2)), b(a(a(i2, i3, i4), d2))))));
        a(a2, d2, d4, d5, i2, i3, i4);
        return a2;
    }

    private static double b(double d2, double d3, double d4, double d5, int i2, int i3, int i4) {
        double d6;
        if (d2 >= d3) {
            d6 = d2 - d3;
        } else {
            d6 = d3 - d2;
        }
        if (d6 < h) {
            return d2;
        }
        double b2 = b(d2, a(d2, b(a(a(i2, i3, i4), d2)), a(a(a(a(i2, i3, i4), d2)), b(a(a(i2, i3, i4), d2)))), d4, b(c, d5, b(c(a(a(i2, i3, i4), d2)), a(a(a(a(i2, i3, i4), d2)), b(a(a(i2, i3, i4), d2))))));
        b(b2, d2, d4, d5, i2, i3, i4);
        return b2;
    }

    private static int d(double d2) {
        if (d2 >= 0.0d) {
            return ((int) (d2 / 15.0d)) + 1;
        }
        return ((int) (d2 / 15.0d)) - 1;
    }

    public static void a(int i2, int i3, int i4, double d2, double d3) {
        double d4 = i;
        double a2 = a(a(d4, a(d4, b(a(a(i2, i3, i4), i)), a(a(a(a(i2, i3, i4), i)), b(a(a(i2, i3, i4), i)))), d3, b(c, d2, b(c(a(a(i2, i3, i4), i)), a(a(a(a(i2, i3, i4), i)), b(a(a(i2, i3, i4), i)))))), i, d3, d2, i2, i3, i4) / 15.0d;
        j = (int) (((double) d(d3)) + a2);
        k = (int) (((((double) d(d3)) + a2) - ((double) ((int) (a2 + ((double) d(d3)))))) * 60.0d);
    }

    public static void b(int i2, int i3, int i4, double d2, double d3) {
        double d4 = i;
        double b2 = b(b(d4, a(d4, b(a(a(i2, i3, i4), i)), a(a(a(a(i2, i3, i4), i)), b(a(a(i2, i3, i4), i)))), d3, b(c, d2, b(c(a(a(i2, i3, i4), i)), a(a(a(a(i2, i3, i4), i)), b(a(a(i2, i3, i4), i)))))), i, d3, d2, i2, i3, i4) / 15.0d;
        l = (int) (((double) d(d3)) + b2);
        m = (int) (((((double) d(d3)) + b2) - ((double) ((int) (b2 + ((double) d(d3)))))) * 60.0d);
    }

    public static boolean a() {
        int i2;
        Calendar instance = Calendar.getInstance();
        int i3 = (instance.get(11) * 60) + instance.get(12);
        int i4 = l;
        if (i4 == -1 || (i2 = j) == -1) {
            return false;
        }
        int i5 = (i2 * 60) + k;
        if (i3 >= (i4 * 60) + m || i3 <= i5) {
            return true;
        }
        return false;
    }
}
