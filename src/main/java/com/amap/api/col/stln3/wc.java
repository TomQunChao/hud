package com.amap.api.col.stln3;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.location.Location;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import com.alibaba.idst.nls.internal.common.PhoneInfo;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.autonavi.ae.guide.GuideControl;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: Utils */
public final class wc {
    static WifiManager a = null;
    private static int b = 0;
    private static String[] c = null;
    private static Hashtable<String, Long> d = new Hashtable<>();
    private static SparseArray<String> e = null;
    private static String[] f = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    private static boolean g = false;

    public static boolean a(vc vcVar) {
        if (vcVar != null && !GuideControl.CHANGE_PLAY_TYPE_YYQX.equals(vcVar.d()) && !GuideControl.CHANGE_PLAY_TYPE_BBHX.equals(vcVar.d()) && !GuideControl.CHANGE_PLAY_TYPE_CLH.equals(vcVar.d())) {
            return b(vcVar);
        }
        return false;
    }

    public static boolean a(AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            return b(aMapLocation);
        }
        return false;
    }

    public static boolean b(AMapLocation aMapLocation) {
        double longitude = aMapLocation.getLongitude();
        double latitude = aMapLocation.getLatitude();
        if ((longitude != 0.0d || latitude != 0.0d) && longitude <= 180.0d && latitude <= 90.0d && longitude >= -180.0d && latitude >= -90.0d) {
            return true;
        }
        return false;
    }

    public static int a(int i) {
        return (i * 2) - 113;
    }

    public static String[] a(TelephonyManager telephonyManager) {
        String str;
        boolean z;
        int i;
        String[] strArr;
        if (telephonyManager != null) {
            str = telephonyManager.getNetworkOperator();
        } else {
            str = null;
        }
        String[] strArr2 = {"0", "0"};
        if (TextUtils.isEmpty(str)) {
            z = false;
        } else if (!TextUtils.isDigitsOnly(str)) {
            z = false;
        } else if (str.length() <= 4) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            strArr2[0] = str.substring(0, 3);
            char[] charArray = str.substring(3).toCharArray();
            int i2 = 0;
            while (i2 < charArray.length && Character.isDigit(charArray[i2])) {
                i2++;
            }
            strArr2[1] = str.substring(3, i2 + 3);
        }
        try {
            i = Integer.parseInt(strArr2[0]);
        } catch (Throwable th) {
            vu.a(th, "Utils", "getMccMnc");
            i = 0;
        }
        if (i == 0) {
            strArr2[0] = "0";
        }
        if (!"0".equals(strArr2[0]) && !"0".equals(strArr2[1])) {
            c = strArr2;
        } else if ("0".equals(strArr2[0]) && "0".equals(strArr2[1]) && (strArr = c) != null) {
            return strArr;
        }
        return strArr2;
    }

    public static long a() {
        return System.currentTimeMillis();
    }

    public static long b() {
        return SystemClock.elapsedRealtime();
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (c() < 17) {
                return c(context, "android.provider.Settings$System");
            }
            return c(context, "android.provider.Settings$Global");
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean c(Context context, String str) throws Throwable {
        if (((Integer) vx.a(str, "getInt", new Object[]{context.getContentResolver(), ((String) vx.a(str, "AIRPLANE_MODE_ON")).toString()}, new Class[]{ContentResolver.class, String.class})).intValue() == 1) {
            return true;
        }
        return false;
    }

    public static float a(double[] dArr) {
        if (dArr.length != 4) {
            return 0.0f;
        }
        float[] fArr = new float[1];
        Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }

    public static float a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        return a(new double[]{aMapLocation.getLatitude(), aMapLocation.getLongitude(), aMapLocation2.getLatitude(), aMapLocation2.getLongitude()});
    }

    public static float a(DPoint dPoint, DPoint dPoint2) {
        return a(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), dPoint2.getLatitude(), dPoint2.getLongitude()});
    }

    public static Object a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationContext().getSystemService(str);
        } catch (Throwable th) {
            vu.a(th, "Utils", "getServ");
            return null;
        }
    }

    public static int c() {
        int i = b;
        if (i > 0) {
            return i;
        }
        try {
            return vx.b("android.os.Build$VERSION", "SDK_INT");
        } catch (Throwable th) {
            return 0;
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            return rk.b(bArr);
        } catch (Throwable th) {
            vu.a(th, "Utils", "gz");
            return null;
        }
    }

    public static String d() {
        return Build.MODEL;
    }

    public static String e() {
        return Build.VERSION.RELEASE;
    }

    public static String b(Context context) {
        PackageInfo packageInfo;
        if (!TextUtils.isEmpty(vu.g)) {
            return vu.g;
        }
        CharSequence charSequence = null;
        if (context == null) {
            return null;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(qy.c(context), 64);
        } catch (Throwable th) {
            vu.a(th, "Utils", "getAppName part");
            packageInfo = null;
        }
        try {
            if (TextUtils.isEmpty(vu.h)) {
                vu.h = null;
            }
        } catch (Throwable th2) {
            vu.a(th2, "Utils", "getAppName");
        }
        StringBuilder sb = new StringBuilder();
        if (packageInfo != null) {
            if (packageInfo.applicationInfo != null) {
                charSequence = packageInfo.applicationInfo.loadLabel(context.getPackageManager());
            }
            if (charSequence != null) {
                sb.append(charSequence.toString());
            }
            if (!TextUtils.isEmpty(packageInfo.versionName)) {
                sb.append(packageInfo.versionName);
            }
        }
        String c2 = qy.c(context);
        if (!TextUtils.isEmpty(c2)) {
            sb.append(",");
            sb.append(c2);
        }
        if (!TextUtils.isEmpty(vu.h)) {
            sb.append(",");
            sb.append(vu.h);
        }
        String sb2 = sb.toString();
        vu.g = sb2;
        return sb2;
    }

    public static NetworkInfo c(Context context) {
        try {
            return rd.s(context);
        } catch (Throwable th) {
            vu.a(th, "Utils", "getNetWorkInfo");
            return null;
        }
    }

    public static int f() {
        return new Random().nextInt(65536) - 32768;
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return rk.a(jSONObject, str);
    }

    public static boolean a(String str) {
        if (!TextUtils.isEmpty(str) && !"00:00:00:00:00:00".equals(str) && !str.contains(" :")) {
            return true;
        }
        return false;
    }

    public static void g() {
        d.clear();
    }

    public static String h() {
        try {
            return re.b("S128DF1572465B890OE3F7A13167KLEI".getBytes("UTF-8")).substring(20);
        } catch (Throwable th) {
            return "";
        }
    }

    public static int a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return networkInfo.getType();
        }
        return -1;
    }

    public static boolean d(Context context) {
        try {
            NetworkInfo c2 = c(context);
            if (c2 == null || !c2.isConnectedOrConnecting()) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static String b(TelephonyManager telephonyManager) {
        int i = 0;
        if (e == null) {
            SparseArray<String> sparseArray = new SparseArray<>();
            e = sparseArray;
            sparseArray.append(0, "UNKWN");
            e.append(1, "GPRS");
            e.append(2, "EDGE");
            e.append(3, "UMTS");
            e.append(4, "CDMA");
            e.append(5, "EVDO_0");
            e.append(6, "EVDO_A");
            e.append(7, "1xRTT");
            e.append(8, "HSDPA");
            e.append(9, "HSUPA");
            e.append(10, "HSPA");
            e.append(11, "IDEN");
            e.append(12, "EVDO_B");
            e.append(13, "LTE");
            e.append(14, "EHRPD");
            e.append(15, "HSPAP");
        }
        if (telephonyManager != null) {
            i = telephonyManager.getNetworkType();
        }
        return e.get(i, "UNKWN");
    }

    public static boolean e(Context context) {
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(qy.c(context))) {
                    if (runningAppProcessInfo.importance != 100) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            vu.a(th, "Utils", "isApplicationBroughtToBackground");
            return true;
        }
    }

    public static byte[] a(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) ((int) ((j >> (i * 8)) & 255));
        }
        return bArr;
    }

    public static byte[] b(String str) {
        return a(Integer.parseInt(str), (byte[]) null);
    }

    public static byte[] a(int i, byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            bArr = new byte[2];
        }
        bArr[0] = (byte) (i & 255);
        bArr[1] = (byte) ((i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
        return bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(long r4, java.lang.String r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L_0x0009
            java.lang.String r6 = "yyyy-MM-dd HH:mm:ss"
            goto L_0x000a
        L_0x0009:
        L_0x000a:
            r0 = 0
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat     // Catch:{ Throwable -> 0x0018 }
            java.util.Locale r2 = java.util.Locale.CHINA     // Catch:{ Throwable -> 0x0018 }
            r1.<init>(r6, r2)     // Catch:{ Throwable -> 0x0018 }
            r1.applyPattern(r6)     // Catch:{ Throwable -> 0x0016 }
            goto L_0x0021
        L_0x0016:
            r6 = move-exception
            goto L_0x001a
        L_0x0018:
            r6 = move-exception
            r1 = r0
        L_0x001a:
            java.lang.String r0 = "Utils"
            java.lang.String r2 = "formatUTC"
            com.amap.api.col.stln3.vu.a(r6, r0, r2)
        L_0x0021:
            r2 = 0
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 > 0) goto L_0x002c
            long r4 = java.lang.System.currentTimeMillis()
            goto L_0x002d
        L_0x002c:
        L_0x002d:
            if (r1 != 0) goto L_0x0032
            java.lang.String r4 = "NULL"
            return r4
        L_0x0032:
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.String r4 = r1.format(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.wc.a(long, java.lang.String):java.lang.String");
    }

    public static boolean a(long j, long j2) {
        String a2 = a(j, "yyyyMMddHH");
        String a3 = a(j2, "yyyyMMddHH");
        if ("NULL".equals(a2) || "NULL".equals(a3)) {
            return false;
        }
        return a2.equals(a3);
    }

    public static boolean b(long j, long j2) {
        String a2 = a(j, "yyyyMMdd");
        String a3 = a(j2, "yyyyMMdd");
        if ("NULL".equals(a2) || "NULL".equals(a3)) {
            return false;
        }
        return a2.equals(a3);
    }

    public static boolean c(long j, long j2) {
        if (!b(j, j2)) {
            return false;
        }
        Calendar instance = Calendar.getInstance(Locale.CHINA);
        instance.setTimeInMillis(j);
        int i = instance.get(11);
        instance.setTimeInMillis(j2);
        int i2 = instance.get(11);
        if (i > 12) {
            if (i2 > 12) {
                return true;
            }
        } else if (i2 <= 12) {
            return true;
        }
        return false;
    }

    public static byte[] c(String str) {
        return b(Integer.parseInt(str), (byte[]) null);
    }

    public static byte[] b(int i, byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            bArr = new byte[4];
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) ((i >> (i2 * 8)) & 255);
        }
        return bArr;
    }

    public static double a(double d2) {
        return ((double) ((long) (d2 * 1000000.0d))) / 1000000.0d;
    }

    public static double b(double d2) {
        return ((double) ((long) (d2 * 100.0d))) / 100.0d;
    }

    public static double c(double d2) {
        return ((double) ((long) (d2 * 1000000.0d))) / 1000000.0d;
    }

    public static float a(float f2) {
        return (float) (((double) ((long) (((double) f2) * 100.0d))) / 100.0d);
    }

    public static String i() {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return null;
        }
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "amap" + File.separator + "openamaplocationsdk" + File.separator;
    }

    public static String b(int i) {
        switch (i) {
            case 0:
                return "success";
            case 1:
                return "重要参数为空";
            case 2:
                return "WIFI信息不足";
            case 3:
                return "请求参数获取出现异常";
            case 4:
                return "网络连接异常";
            case 5:
                return "解析数据异常";
            case 6:
                return "定位结果错误";
            case 7:
                return "KEY错误";
            case 8:
                return "其他错误";
            case 9:
                return "初始化异常";
            case 10:
                return "定位服务启动失败";
            case 11:
                return "错误的基站信息，请检查是否插入SIM卡";
            case 12:
                return "缺少定位权限";
            case 13:
                return "网络定位失败，请检查设备是否插入sim卡，是否开启移动网络或开启了wifi模块";
            case 14:
                return "GPS 定位失败，由于设备当前 GPS 状态差,建议持设备到相对开阔的露天场所再次尝试";
            case 15:
                return "当前返回位置为模拟软件返回，请关闭模拟软件，或者在option中设置允许模拟";
            case 16:
            case 17:
            default:
                return "其他错误";
            case 18:
                return "定位失败，飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关";
            case 19:
                return "定位失败，没有检查到SIM卡，并且关闭了WIFI开关，请打开WIFI开关或者插入SIM卡";
        }
    }

    public static boolean b(Context context, String str) {
        try {
            if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean f(Context context) {
        int i;
        if (Build.VERSION.SDK_INT < 23 || context.getApplicationInfo().targetSdkVersion < 23) {
            for (String str : f) {
                if (context.checkCallingOrSelfPermission(str) != 0) {
                    return false;
                }
            }
        } else {
            Application application = (Application) context;
            for (String str2 : f) {
                try {
                    i = vx.b(application.getBaseContext(), "checkSelfPermission", str2);
                } catch (Throwable th) {
                    i = 0;
                }
                if (i != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean a(Location location, int i) {
        int i2;
        Boolean bool = false;
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                bool = (Boolean) vx.a(location, "isFromMockProvider", new Object[0]);
            } catch (Throwable th) {
            }
        }
        if (bool.booleanValue()) {
            return true;
        }
        Bundle extras = location.getExtras();
        if (extras != null) {
            i2 = extras.getInt("satellites");
        } else {
            i2 = 0;
        }
        if (i2 <= 0) {
            return true;
        }
        if (i == 0 && location.getAltitude() == 0.0d && location.getBearing() == 0.0f && location.getSpeed() == 0.0f) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.database.sqlite.SQLiteDatabase r6, java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 121
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.wc.a(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        ArrayList<String> d2 = d(str);
        String[] split = str2.toString().split("#");
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < split.length; i3++) {
            if (split[i3].contains(",nb") || split[i3].contains(",access")) {
                i++;
                if (d2.contains(split[i3])) {
                    i2++;
                }
            }
        }
        if (((double) (i2 * 2)) >= ((double) (d2.size() + i)) * 0.618d) {
            return true;
        }
        return false;
    }

    public static ArrayList<String> d(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("#");
            for (int i = 0; i < split.length; i++) {
                if (split[i].contains(",nb") || split[i].contains(",access")) {
                    arrayList.add(split[i]);
                }
            }
        }
        return arrayList;
    }

    @SuppressLint({"NewApi"})
    public static boolean g(Context context) {
        boolean z;
        if (context == null) {
            return true;
        }
        if (a == null) {
            a = (WifiManager) a(context, "wifi");
        }
        try {
            z = a.isWifiEnabled();
        } catch (Throwable th) {
            z = false;
        }
        if (z || c() <= 17) {
            return z;
        }
        try {
            return "true".equals(String.valueOf(vx.a(a, "isScanAlwaysAvailable", new Object[0])));
        } catch (Throwable th2) {
            return z;
        }
    }

    public static String h(Context context) {
        NetworkInfo c2 = c(context);
        if (c2 == null || !c2.isConnectedOrConnecting()) {
            return "DISCONNECTED";
        }
        int type = c2.getType();
        if (type == 1) {
            return PhoneInfo.NETWORK_TYPE_WIFI;
        }
        if (type != 0) {
            return "UNKNOWN";
        }
        String subtypeName = c2.getSubtypeName();
        switch (c2.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return "3G";
            case 13:
                return "4G";
            default:
                if ("GSM".equalsIgnoreCase(subtypeName)) {
                    return "2G";
                }
                if ("TD-SCDMA".equalsIgnoreCase(subtypeName) || "WCDMA".equalsIgnoreCase(subtypeName) || "CDMA2000".equalsIgnoreCase(subtypeName)) {
                    return "3G";
                }
                return subtypeName;
        }
    }

    public static String i(Context context) {
        String m = rd.m(context);
        if (TextUtils.isEmpty(m) || m.equals("00:00:00:00:00:00")) {
            m = "00:00:00:00:00:00";
            if (context != null) {
                m = wb.b(context, "pref", "smac", m);
            }
        }
        if (TextUtils.isEmpty(m)) {
            m = "00:00:00:00:00:00";
        }
        if (!g) {
            if (context != null && !TextUtils.isEmpty(m)) {
                wb.a(context, "pref", "smac", m);
            }
            g = true;
        }
        return m;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00cb, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00cc, code lost:
        r0 = r7;
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00cf, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00d0, code lost:
        r0 = r7;
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        r0.closeEntry();
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00e7, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r0.closeEntry();
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ab A[SYNTHETIC, Splitter:B:42:0x00ab] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b7 A[SYNTHETIC, Splitter:B:49:0x00b7] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00cb A[ExcHandler: all (r8v5 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:11:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e1 A[SYNTHETIC, Splitter:B:67:0x00e1] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00ee A[SYNTHETIC, Splitter:B:72:0x00ee] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x003b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(java.lang.String r7, java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 249
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.wc.b(java.lang.String, java.lang.String):void");
    }

    public static boolean c(String str, String str2) {
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        for (File file2 : listFiles) {
            if (file2.isDirectory() && file2.getName().equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static void e(String str) {
        try {
            if (!str.endsWith(File.separator)) {
                str = str + File.separator;
            }
            File file = new File(str);
            if (!file.exists()) {
                return;
            }
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        e(file2.getAbsolutePath());
                    } else {
                        file2.delete();
                    }
                }
                file.delete();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static double f(String str) throws NumberFormatException {
        return Double.parseDouble(str);
    }

    public static float g(String str) throws NumberFormatException {
        return Float.parseFloat(str);
    }

    public static int h(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }

    public static int i(String str) throws NumberFormatException {
        return Integer.parseInt(str, 16);
    }

    public static byte j(String str) throws NumberFormatException {
        return Byte.parseByte(str);
    }

    public static boolean j(Context context) {
        if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
            return false;
        }
        return true;
    }

    public static boolean k(Context context) {
        ServiceInfo serviceInfo;
        try {
            serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.amap.api.location.APSService"), 128);
        } catch (Throwable th) {
            serviceInfo = null;
        }
        if (serviceInfo == null) {
            return false;
        }
        return true;
    }
}
