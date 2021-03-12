package com.amap.api.col.stln3;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: DeviceInfo */
public final class rd {
    static String a = "";
    static String b = "";
    public static boolean c = false;
    static String d = "";
    static boolean e = false;
    static int f = -1;
    static String g = "";
    static String h = "";
    private static String i = null;
    private static boolean j = false;
    private static String k = "";
    private static String l = "";
    private static String m = "";
    private static String n = "";
    private static String o = "";
    private static String p = "";
    private static boolean q = false;
    private static long r;
    private static int s;
    private static String t;
    private static String u = "";

    public static void a(String str) {
        i = str;
    }

    public static String a() {
        return i;
    }

    public static String a(Context context) {
        try {
            if (!TextUtils.isEmpty(d)) {
                return d;
            }
            rj a2 = rs.a();
            if (!sk.b(context, a2)) {
                return "";
            }
            Class a3 = sk.a(context, a2, rk.c("WY29tLmFtYXAuYXBpLmFpdW5ldC5OZXRSZXVlc3RQYXJhbQ"));
            if (a3 != null) {
                d = (String) a3.getMethod("getAdiuExtras", new Class[0]).invoke(a3, new Object[0]);
            }
            return d;
        } catch (Throwable th) {
            rx.c(th, "dI", "aiuEx");
            return "";
        }
    }

    public static String b(final Context context) {
        try {
            if (!TextUtils.isEmpty(b)) {
                return b;
            }
            rj a2 = rs.a();
            if (a2 == null) {
                return null;
            }
            if (!sk.b(context, a2)) {
                return "";
            }
            final Class a3 = sk.a(context, a2, rk.c("WY29tLmFtYXAuYXBpLmFpdW5ldC5OZXRSZXVlc3RQYXJhbQ"));
            if (a3 == null) {
                return b;
            }
            String str = (String) a3.getMethod("getADIU", Context.class).invoke(a3, context);
            if (!TextUtils.isEmpty(str)) {
                b = str;
                return str;
            } else if (j) {
                return "";
            } else {
                j = true;
                rx.d().submit(new Runnable() {
                    /* class com.amap.api.col.stln3.rd.AnonymousClass1 */

                    public final void run() {
                        try {
                            Map map = (Map) a3.getMethod("getGetParams", new Class[0]).invoke(a3, new Object[0]);
                            if (map != null) {
                                String str = (String) a3.getMethod("getPostParam", String.class, String.class, String.class, String.class).invoke(a3, rd.h(context), rd.v(context), rd.m(context), rd.x(context));
                                if (!TextUtils.isEmpty(str)) {
                                    tr.a();
                                    byte[] a2 = tr.a(new tq(str.getBytes(), map));
                                    a3.getMethod("parseResult", Context.class, String.class).invoke(a3, context, new String(a2));
                                }
                            }
                        } catch (Throwable th) {
                            rx.c(th, "dI", "aiun");
                        }
                    }
                });
                return "";
            }
        } catch (Throwable th) {
            rx.c(th, "dI", "aiu");
            return "";
        }
    }

    public static String c(Context context) {
        try {
            return C(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String d(Context context) {
        try {
            String x = x(context);
            if (x != null) {
                if (x.length() >= 5) {
                    return x.substring(3, 5);
                }
            }
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int e(Context context) {
        try {
            return F(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static int f(Context context) {
        try {
            return D(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static String g(Context context) {
        try {
            return B(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static void b() {
        try {
            if (Build.VERSION.SDK_INT > 14) {
                TrafficStats.class.getDeclaredMethod("setThreadStatsTag", Integer.TYPE).invoke(null, 40964);
            }
        } catch (Throwable th) {
            rx.c(th, "dI", "sag");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ae A[SYNTHETIC, Splitter:B:45:0x00ae] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00bc A[SYNTHETIC, Splitter:B:51:0x00bc] */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String A(android.content.Context r8) {
        /*
        // Method dump skipped, instructions count: 210
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.rd.A(android.content.Context):java.lang.String");
    }

    public static String h(Context context) {
        try {
            if (a != null && !"".equals(a)) {
                return a;
            }
            if (b(context, rk.c("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
                a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
            }
            if (a != null && !"".equals(a)) {
                return a;
            }
            try {
                a = A(context);
            } catch (Throwable th) {
            }
            String str = a;
            return str == null ? "" : str;
        } catch (Throwable th2) {
        }
    }

    public static String i(Context context) {
        if (!TextUtils.isEmpty(l)) {
            return l;
        }
        if (!b(context, rk.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                return (String) rk.a(Build.class, "MZ2V0U2VyaWFs", new Class[0]).invoke(Build.class, new Object[0]);
            }
            if (Build.VERSION.SDK_INT >= 9) {
                l = Build.SERIAL;
            }
            String str = l;
            return str == null ? "" : str;
        } catch (Throwable th) {
        }
    }

    public static String j(Context context) {
        if (!TextUtils.isEmpty(k)) {
            return k;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), rk.c(new String(rs.a(13))));
            k = string;
            return string == null ? "" : k;
        } catch (Throwable th) {
            return k;
        }
    }

    private static boolean b(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    static String k(Context context) {
        if (context != null) {
            try {
                if (b(context, rk.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager != null && wifiManager.isWifiEnabled()) {
                        return wifiManager.getConnectionInfo().getBSSID();
                    }
                    return "";
                }
            } catch (Throwable th) {
                ru.a(th, "dI", "gcW");
                return "";
            }
        }
        return "";
    }

    static String l(Context context) {
        StringBuilder sb = new StringBuilder();
        if (context != null) {
            try {
                if (b(context, rk.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager == null) {
                        return "";
                    }
                    if (wifiManager.isWifiEnabled()) {
                        List<ScanResult> scanResults = wifiManager.getScanResults();
                        if (scanResults != null) {
                            if (scanResults.size() != 0) {
                                List<ScanResult> a2 = a(scanResults);
                                int i2 = 0;
                                boolean z = true;
                                while (i2 < a2.size() && i2 < 7) {
                                    ScanResult scanResult = a2.get(i2);
                                    if (z) {
                                        z = false;
                                    } else {
                                        sb.append(";");
                                    }
                                    sb.append(scanResult.BSSID);
                                    i2++;
                                }
                            }
                        }
                        return sb.toString();
                    }
                    return sb.toString();
                }
            } catch (Throwable th) {
                rx.c(th, "dI", "gWs");
            }
        }
        return sb.toString();
    }

    public static String m(Context context) {
        try {
            if (m != null && !"".equals(m)) {
                return m;
            }
            if (!b(context, rk.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                return m;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            m = wifiManager.getConnectionInfo().getMacAddress();
            if (!rk.c("YMDI6MDA6MDA6MDA6MDA6MDA").equals(m)) {
                if (!rk.c("YMDA6MDA6MDA6MDA6MDA6MDA").equals(m)) {
                    return m;
                }
            }
            m = e();
            return m;
        } catch (Throwable th) {
            rx.c(th, "dI", "gDc");
        }
    }

    private static String e() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] bArr = null;
                    if (Build.VERSION.SDK_INT >= 9) {
                        bArr = networkInterface.getHardwareAddress();
                    }
                    if (bArr == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : bArr) {
                        String upperCase = Integer.toHexString(b2 & 255).toUpperCase();
                        if (upperCase.length() == 1) {
                            sb.append("0");
                        }
                        sb.append(upperCase);
                        sb.append(":");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "";
        } catch (Exception e2) {
            rx.c(e2, "dI", "gMr");
            return "";
        }
    }

    static String[] n(Context context) {
        try {
            if (b(context, rk.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                if (b(context, rk.c("EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04="))) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager == null) {
                        return new String[]{"", ""};
                    }
                    CellLocation cellLocation = telephonyManager.getCellLocation();
                    if (cellLocation instanceof GsmCellLocation) {
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                        int cid = gsmCellLocation.getCid();
                        int lac = gsmCellLocation.getLac();
                        return new String[]{lac + "||" + cid, "gsm"};
                    } else if (!(cellLocation instanceof CdmaCellLocation)) {
                        return new String[]{"", ""};
                    } else {
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                        int systemId = cdmaCellLocation.getSystemId();
                        int networkId = cdmaCellLocation.getNetworkId();
                        int baseStationId = cdmaCellLocation.getBaseStationId();
                        return new String[]{systemId + "||" + networkId + "||" + baseStationId, "cdma"};
                    }
                }
            }
            return new String[]{"", ""};
        } catch (Throwable th) {
            ru.a(th, "dI", "cf");
        }
    }

    static String o(Context context) {
        TelephonyManager G;
        try {
            if (!b(context, rk.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) || (G = G(context)) == null) {
                return "";
            }
            String networkOperator = G.getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                if (networkOperator.length() >= 3) {
                    return networkOperator.substring(0, 3);
                }
            }
            return "";
        } catch (Throwable th) {
            rx.c(th, "dI1", "gNC");
            return "";
        }
    }

    static String p(Context context) {
        TelephonyManager G;
        try {
            if (!b(context, rk.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) || (G = G(context)) == null) {
                return "";
            }
            String networkOperator = G.getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                if (networkOperator.length() >= 3) {
                    return networkOperator.substring(3);
                }
            }
            return "";
        } catch (Throwable th) {
            rx.c(th, "dI", "gNC");
            return "";
        }
    }

    public static int q(Context context) {
        try {
            return F(context);
        } catch (Throwable th) {
            rx.c(th, "dI", "gNT");
            return -1;
        }
    }

    public static int r(Context context) {
        try {
            return D(context);
        } catch (Throwable th) {
            ru.a(th, "dI", "gAT");
            return -1;
        }
    }

    public static NetworkInfo s(Context context) {
        ConnectivityManager E;
        if (b(context, rk.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && (E = E(context)) != null) {
            return E.getActiveNetworkInfo();
        }
        return null;
    }

    static String t(Context context) {
        try {
            NetworkInfo s2 = s(context);
            if (s2 == null) {
                return null;
            }
            return s2.getExtraInfo();
        } catch (Throwable th) {
            rx.c(th, "dI", "gne");
            return null;
        }
    }

    static String u(Context context) {
        StringBuilder sb;
        try {
            if (n != null && !"".equals(n)) {
                return n;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return "";
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            if (i3 > i2) {
                sb = new StringBuilder();
                sb.append(i2);
                sb.append("*");
                sb.append(i3);
            } else {
                sb = new StringBuilder();
                sb.append(i3);
                sb.append("*");
                sb.append(i2);
            }
            n = sb.toString();
            return n;
        } catch (Throwable th) {
            rx.c(th, "dI", "gR");
        }
    }

    public static String a(Context context, String str) {
        try {
            if (Build.VERSION.SDK_INT < 21) {
                return "";
            }
            if (!TextUtils.isEmpty(g)) {
                return g;
            }
            TelephonyManager G = G(context);
            if (f == -1) {
                Method a2 = rk.a(TelephonyManager.class, "UZ2V0UGhvbmVDb3VudA=", new Class[0]);
                if (a2 != null) {
                    try {
                        f = ((Integer) a2.invoke(G, new Object[0])).intValue();
                    } catch (Throwable th) {
                        rx.c(th, "dI", "gpc");
                        f = 0;
                    }
                } else {
                    f = 0;
                }
            }
            Method a3 = rk.a(TelephonyManager.class, "MZ2V0SW1laQ=", Integer.TYPE);
            if (a3 == null) {
                f = 0;
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < f; i2++) {
                try {
                    sb.append((String) a3.invoke(G, Integer.valueOf(i2)));
                    sb.append(str);
                } catch (Throwable th2) {
                    rx.c(th2, "dI", "gim");
                }
            }
            String sb2 = sb.toString();
            if (sb2.length() == 0) {
                f = 0;
                return "";
            }
            String substring = sb2.substring(0, sb2.length() - 1);
            g = substring;
            return substring;
        } catch (Throwable th3) {
            rx.c(th3, "dI", "gmim");
            return "";
        }
    }

    public static String v(Context context) {
        try {
            if (o != null && !"".equals(o)) {
                return o;
            }
            if (!b(context, rk.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return o;
            }
            TelephonyManager G = G(context);
            if (G == null) {
                return "";
            }
            Method a2 = rk.a(G.getClass(), "QZ2V0RGV2aWNlSWQ", new Class[0]);
            if (Build.VERSION.SDK_INT >= 26) {
                a2 = rk.a(G.getClass(), "QZ2V0SW1laQ==", new Class[0]);
            }
            if (a2 != null) {
                o = (String) a2.invoke(G, new Object[0]);
            }
            if (o == null) {
                o = "";
            }
            return o;
        } catch (Throwable th) {
            rx.c(th, "dI", "gd");
        }
    }

    public static String w(Context context) {
        try {
            if (p != null && !"".equals(p)) {
                return p;
            }
            if (!b(context, rk.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return p;
            }
            TelephonyManager G = G(context);
            if (G == null) {
                return "";
            }
            if (Build.VERSION.SDK_INT >= 26) {
                Method a2 = rk.a(G.getClass(), "QZ2V0TWVpZA==", new Class[0]);
                if (a2 != null) {
                    p = (String) a2.invoke(G, new Object[0]);
                }
                if (p == null) {
                    p = "";
                }
            }
            return p;
        } catch (Throwable th) {
            rx.c(th, "meI", "med");
        }
    }

    public static String x(Context context) {
        try {
            return B(context);
        } catch (Throwable th) {
            ru.a(th, "dI", "gSd");
            return "";
        }
    }

    public static long c() {
        long j2;
        long j3;
        long j4 = r;
        if (j4 != 0) {
            return j4;
        }
        try {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 18) {
                j3 = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 1048576;
                j2 = (statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()) / 1048576;
            } else {
                j3 = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1048576;
                j2 = (((long) statFs2.getBlockCount()) * ((long) statFs2.getBlockSize())) / 1048576;
            }
            r = j3 + j2;
        } catch (Throwable th) {
            rx.c(th, "dI", "gDS");
        }
        return r;
    }

    public static int y(Context context) {
        Throwable th;
        Throwable th2;
        int i2 = s;
        if (i2 != 0) {
            return i2;
        }
        int i3 = 0;
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return 0;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            i3 = (int) (memoryInfo.totalMem / 1024);
        } else {
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(new File("/proc/meminfo")));
                try {
                    i3 = Integer.valueOf(bufferedReader2.readLine().split("\\s+")[1]).intValue();
                    try {
                        bufferedReader2.close();
                    } catch (IOException e2) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th2 = th4;
                try {
                    rx.c(th2, "dI", "gRS");
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                        }
                    }
                    int i4 = i3 / 1024;
                    s = i4;
                    return i4;
                } catch (Throwable th5) {
                    th = th5;
                }
            }
        }
        int i42 = i3 / 1024;
        s = i42;
        return i42;
    }

    public static String d() {
        if (!TextUtils.isEmpty(t)) {
            return t;
        }
        String property = System.getProperty("os.arch");
        t = property;
        return property;
    }

    static String z(Context context) {
        try {
            return C(context);
        } catch (Throwable th) {
            rx.c(th, "dI", "gNNa");
            return "";
        }
    }

    private static String B(Context context) throws InvocationTargetException, IllegalAccessException {
        String str = u;
        if (str != null && !"".equals(str)) {
            return u;
        }
        if (!b(context, rk.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return u;
        }
        TelephonyManager G = G(context);
        if (G == null) {
            return "";
        }
        Method a2 = rk.a(G.getClass(), "UZ2V0U3Vic2NyaWJlcklk", new Class[0]);
        if (a2 != null) {
            u = (String) a2.invoke(G, new Object[0]);
        }
        if (u == null) {
            u = "";
        }
        return u;
    }

    private static String C(Context context) {
        if (!b(context, rk.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return null;
        }
        TelephonyManager G = G(context);
        if (G == null) {
            return "";
        }
        String simOperatorName = G.getSimOperatorName();
        if (TextUtils.isEmpty(simOperatorName)) {
            return G.getNetworkOperatorName();
        }
        return simOperatorName;
    }

    private static int D(Context context) {
        ConnectivityManager E;
        NetworkInfo activeNetworkInfo;
        if (context == null || !b(context, rk.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (E = E(context)) == null || (activeNetworkInfo = E.getActiveNetworkInfo()) == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    private static ConnectivityManager E(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    private static int F(Context context) {
        TelephonyManager G;
        if (b(context, rk.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) && (G = G(context)) != null) {
            return G.getNetworkType();
        }
        return -1;
    }

    private static TelephonyManager G(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    private static List<ScanResult> a(List<ScanResult> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size - 1; i2++) {
            for (int i3 = 1; i3 < size - i2; i3++) {
                int i4 = i3 - 1;
                if (list.get(i4).level > list.get(i3).level) {
                    list.set(i4, list.get(i3));
                    list.set(i3, list.get(i4));
                }
            }
        }
        return list;
    }
}
