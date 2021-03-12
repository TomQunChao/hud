package com.amap.api.col.stln3;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.util.TypedValue;
import com.amap.api.col.stln3.rj;
import com.amap.api.maps.model.LatLng;
import com.amap.api.navi.model.NaviLatLng;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import java.io.File;

/* compiled from: NaviUtil */
public final class mj {
    public static boolean a = false;
    public static boolean b = false;
    public static double c = 1000.0d;
    static int d = 2;
    static String e = "00";
    static String f = "0";
    static int g = 10;
    static float h = 180.0f;
    static float i = 90.0f;
    static int j = 60;
    private static String[] k = {"com.amap.api.navi", "com.autonavi.tbt", "com.autonavi.wtbt", "com.autonavi.rbt", "com.autonavi.ae.guide", "com.autonavi.ae.route", "com.autonavi.ae.pos"};

    public static rj a() {
        try {
            return new rj.a("navi", "6.5.0", "AMAP_SDK_Android_NAVI_6.5.0").a(k).a();
        } catch (qx e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static rj a(String str, String str2) {
        try {
            return new rj.a(str, str2, "AMAP_SDK_Android_NAVI_6.5.0").a(k).a();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void a(Throwable th) {
        th.printStackTrace();
    }

    public static File a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                if (Environment.getExternalStorageDirectory().canWrite()) {
                    return context.getExternalFilesDir("LBS");
                }
            }
            return context.getFilesDir();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int a(Context context, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (context == null) {
            return i2;
        }
        try {
            return (int) TypedValue.applyDimension(1, (float) i2, context.getResources().getDisplayMetrics());
        } catch (Exception e2) {
            e2.printStackTrace();
            return i2;
        }
    }

    public static String a(int i2) {
        if (i2 == 0) {
            return "0米";
        }
        double d2 = (double) i2;
        double d3 = c;
        if (d2 < d3) {
            return i2 + "米";
        } else if (d3 <= d2) {
            return (((double) ((i2 / 100) * 100)) / c) + "公里";
        } else {
            return (d2 / c) + "公里";
        }
    }

    public static String a(int i2, String str, String str2) {
        if (i2 == 0) {
            return "<font color='" + str + "' ><B>0</B></font><font color ='" + str2 + "'>米</font>";
        }
        double d2 = (double) i2;
        double d3 = c;
        if (d2 < d3) {
            return "<font color='" + str + "'><B>" + i2 + "</B></font><font color ='" + str2 + "'>米</font>";
        } else if (d3 <= d2) {
            return "<font color='" + str + "'><B>" + (((double) ((i2 / 10) * 10)) / c) + "</B></font><font color ='" + str2 + "'>公里</font>";
        } else {
            return "<font color='" + str + "'><B>" + (d2 / c) + "</B></font><font color ='" + str2 + "'>公里</font>";
        }
    }

    public static SpannableStringBuilder a(int i2, int i3, int i4) {
        if (((double) i2) < c) {
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            return a(sb.toString(), i3, "米", i4);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((double) ((i2 / 100) * 100)) / c);
        return a(sb2.toString(), i3, "公里", i4);
    }

    public static String a(String str) {
        String str2;
        String str3;
        if (str == null) {
            return "";
        }
        String[] split = str.split(":");
        StringBuffer stringBuffer = new StringBuffer();
        if (split != null && split.length > d) {
            if (!e.equals(split[0])) {
                if (split[0].indexOf(f) != -1) {
                    int indexOf = split[0].indexOf(f) + 1;
                    if (indexOf < split[0].length()) {
                        str3 = split[0].substring(indexOf);
                    } else {
                        str3 = split[0];
                    }
                    stringBuffer.append(str3 + "小时");
                } else {
                    stringBuffer.append(split[0] + "小时");
                }
            }
            if (!e.equals(split[1])) {
                if (split[1].indexOf(f) != -1) {
                    int indexOf2 = split[1].indexOf("0") + 1;
                    if (indexOf2 < split[1].length()) {
                        str2 = split[1].substring(indexOf2);
                    } else {
                        str2 = split[1];
                    }
                    stringBuffer.append(str2 + "分钟");
                } else {
                    stringBuffer.append(split[1] + "分钟");
                }
            }
        }
        return stringBuffer.toString();
    }

    public static SpannableStringBuilder a(String str, int i2, int i3) {
        String str2;
        String str3;
        int i4;
        if (str == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        String[] split = str.split(":");
        new StringBuffer();
        if (split != null && split.length > d) {
            if (!e.equals(split[0])) {
                if (split[0].indexOf(f) != -1) {
                    int indexOf = split[0].indexOf(f);
                    if (indexOf != 0 || (i4 = indexOf + 1) >= split[0].length()) {
                        str3 = split[0];
                    } else {
                        str3 = split[0].substring(i4);
                    }
                    spannableStringBuilder = a(str3, i2, "小时", i3);
                } else {
                    spannableStringBuilder = a(split[0], i2, "小时", i3);
                }
            }
            if (!e.equals(split[1])) {
                if (split[1].indexOf(f) != -1) {
                    int indexOf2 = split[1].indexOf("0") + 1;
                    if (indexOf2 < split[1].length()) {
                        str2 = split[1].substring(indexOf2);
                    } else {
                        str2 = split[1];
                    }
                    spannableStringBuilder2 = a(str2, i2, "分钟", i3);
                } else {
                    spannableStringBuilder2 = a(split[1], i2, "分钟", i3);
                }
            }
        }
        return spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
    }

    private static SpannableStringBuilder a(String str, int i2, String str2, int i3) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(i2, true), 0, str.length(), 17);
        spannableStringBuilder.append((CharSequence) str2);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(i3, true), str.length(), spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static String a(String str, String str2, String str3) {
        String str4;
        String str5;
        int i2;
        if (str == null) {
            return "";
        }
        String[] split = str.split(":");
        StringBuffer stringBuffer = new StringBuffer();
        if (split != null && split.length > d) {
            if (!e.equals(split[0])) {
                if (split[0].indexOf(f) != -1) {
                    int indexOf = split[0].indexOf(f);
                    if (indexOf != 0 || (i2 = indexOf + 1) >= split[0].length()) {
                        str5 = split[0];
                    } else {
                        str5 = split[0].substring(i2);
                    }
                    stringBuffer.append("<font color='" + str2 + "' ><B>" + str5 + "</B></font><font color ='" + str3 + "'>小时</font>");
                } else {
                    stringBuffer.append("<font color='" + str2 + "' ><B>" + split[0] + "</B></font><font color ='" + str3 + "'>小时</font>");
                }
            }
            if (!e.equals(split[1])) {
                if (split[1].indexOf(f) != -1) {
                    int indexOf2 = split[1].indexOf("0") + 1;
                    if (indexOf2 < split[1].length()) {
                        str4 = split[1].substring(indexOf2);
                    } else {
                        str4 = split[1];
                    }
                    stringBuffer.append("<font color='" + str2 + "' ><B>" + str4 + "</B></font><font color ='" + str3 + "'>分钟</font>");
                } else {
                    stringBuffer.append("<font color='" + str2 + "' ><B>" + split[1] + "</B></font><font color ='" + str3 + "'>分钟</font>");
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String b(int i2) {
        int abs = Math.abs(i2);
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = abs / 3600;
        if (i3 == 0) {
            stringBuffer.append("00:");
        }
        if (i3 > 0) {
            stringBuffer.append(d(i3) + ":");
        }
        int i4 = abs % 3600;
        stringBuffer.append(d((i4 + 59) / 60) + ":");
        stringBuffer.append(d(i4 % 60));
        return stringBuffer.toString();
    }

    private static String d(int i2) {
        if (i2 < g) {
            return f + i2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        return sb.toString();
    }

    public static NaviLatLng a(double d2, double d3, double d4, double d5) {
        double d6;
        double d7 = 0.0d;
        if (d2 <= 0.0d || d3 <= 0.0d || d4 <= 0.0d || d5 <= 0.0d) {
            d6 = 0.0d;
        } else {
            d7 = (d2 + d4) / 2.0d;
            d6 = (d3 + d5) / 2.0d;
        }
        return new NaviLatLng(d7, d6);
    }

    public static NaviLatLng a(NaviLatLng naviLatLng, NaviLatLng naviLatLng2, double d2) {
        NaviLatLng naviLatLng3 = new NaviLatLng();
        double a2 = d2 / ((double) a(naviLatLng, naviLatLng2));
        naviLatLng3.setLatitude(((naviLatLng2.getLatitude() - naviLatLng.getLatitude()) * a2) + naviLatLng.getLatitude());
        naviLatLng3.setLongitude(((naviLatLng2.getLongitude() - naviLatLng.getLongitude()) * a2) + naviLatLng.getLongitude());
        return naviLatLng3;
    }

    public static int a(NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
        double longitude = naviLatLng.getLongitude();
        double latitude = naviLatLng.getLatitude();
        double d2 = longitude * 0.01745329251994329d;
        double d3 = latitude * 0.01745329251994329d;
        double longitude2 = naviLatLng2.getLongitude() * 0.01745329251994329d;
        double latitude2 = naviLatLng2.getLatitude() * 0.01745329251994329d;
        double sin = Math.sin(d2);
        double sin2 = Math.sin(d3);
        double cos = Math.cos(d2);
        double cos2 = Math.cos(d3);
        double sin3 = Math.sin(longitude2);
        double sin4 = Math.sin(latitude2);
        double cos3 = Math.cos(longitude2);
        double cos4 = Math.cos(latitude2);
        double[] dArr = {(cos * cos2) - (cos3 * cos4), (cos2 * sin) - (cos4 * sin3), sin2 - sin4};
        return (int) (Math.asin(Math.sqrt(((dArr[0] * dArr[0]) + (dArr[1] * dArr[1])) + (dArr[2] * dArr[2])) / 2.0d) * 1.27420015798544E7d);
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static float a(LatLng latLng, LatLng latLng2) {
        try {
            IPoint iPoint = new IPoint();
            IPoint iPoint2 = new IPoint();
            MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
            MapProjection.lonlat2Geo(latLng2.longitude, latLng2.latitude, iPoint2);
            double d2 = (double) iPoint2.x;
            return ((float) ((Math.atan2(((double) iPoint2.y) - ((double) iPoint.y), d2 - ((double) iPoint.x)) / 3.141592653589793d) * 180.0d)) + 90.0f;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    public static boolean a(NaviLatLng naviLatLng) {
        if (naviLatLng == null) {
            return false;
        }
        try {
            double longitude = naviLatLng.getLongitude();
            if (longitude <= ((double) h)) {
                if (longitude >= 0.0d) {
                    double latitude = naviLatLng.getLatitude();
                    if (latitude < 0.0d || latitude > ((double) i)) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String c(int i2) {
        int i3 = (i2 + 59) / 60;
        if (i3 <= j) {
            return i3 + "分钟";
        }
        return (i3 / 60) + "小时" + (i3 % 60) + "分";
    }

    public static void a(boolean z) {
        a = z;
    }

    public static LatLng b(NaviLatLng naviLatLng) {
        return new LatLng(naviLatLng.getLatitude(), naviLatLng.getLongitude());
    }

    public static Activity c(Context context) {
        if (context == null) {
            return null;
        }
        while (context != null) {
            try {
                if (context instanceof Activity) {
                    break;
                } else if (context instanceof ContextWrapper) {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        if (context == null) {
            return null;
        }
        return (Activity) context;
    }

    public static int d(Context context) {
        if (context != null) {
            return context.getResources().getConfiguration().orientation;
        }
        return 1;
    }
}
