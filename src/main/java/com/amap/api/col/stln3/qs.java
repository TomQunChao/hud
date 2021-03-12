package com.amap.api.col.stln3;

/* compiled from: ParseUtil */
public final class qs {
    public static long a(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            return 0;
        }
    }

    public static double b(String str) {
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            return 0.0d;
        }
    }

    public static int c(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return 0;
        }
    }

    public static float d(String str) {
        try {
            return Float.parseFloat(str);
        } catch (Exception e) {
            return 0.0f;
        }
    }
}
