package com.amap.api.col.stln3;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/* compiled from: WifiManagerWrapper */
public final class wt {
    static long c = 0;
    static long d = 0;
    static long e = 0;
    static long f = 0;
    static long g = 0;
    WifiManager a;
    ArrayList<ScanResult> b = new ArrayList<>();
    Context h;
    boolean i = false;
    StringBuilder j = null;
    boolean k = true;
    boolean l = true;
    String m = null;
    TreeMap<Integer, ScanResult> n = null;
    public boolean o = true;
    ConnectivityManager p = null;
    volatile boolean q = false;
    private volatile WifiInfo r = null;

    public wt(Context context, WifiManager wifiManager) {
        this.a = wifiManager;
        this.h = context;
    }

    private static boolean a(int i2) {
        int i3 = 20;
        try {
            i3 = WifiManager.calculateSignalLevel(i2, 20);
        } catch (ArithmeticException e2) {
            wy.a(e2, "Aps", "wifiSigFine");
        }
        return i3 > 0;
    }

    public static boolean a(WifiInfo wifiInfo) {
        return wifiInfo != null && !TextUtils.isEmpty(wifiInfo.getSSID()) && xb.a(wifiInfo.getBSSID());
    }

    public static String i() {
        return String.valueOf(xb.b() - f);
    }

    private List<ScanResult> j() {
        WifiManager wifiManager = this.a;
        if (wifiManager != null) {
            try {
                List<ScanResult> scanResults = wifiManager.getScanResults();
                this.m = null;
                return scanResults;
            } catch (SecurityException e2) {
                this.m = e2.getMessage();
            } catch (Throwable th) {
                this.m = null;
                wy.a(th, "WifiManagerWrapper", "getScanResults");
            }
        }
        return null;
    }

    private WifiInfo k() {
        try {
            if (this.a != null) {
                return this.a.getConnectionInfo();
            }
            return null;
        } catch (Throwable th) {
            wy.a(th, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c A[Catch:{ Throwable -> 0x0053 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void l() {
        /*
            r5 = this;
            boolean r0 = r5.m()
            if (r0 == 0) goto L_0x005b
            long r0 = com.amap.api.col.stln3.xb.b()     // Catch:{ Throwable -> 0x0053 }
            long r2 = com.amap.api.col.stln3.wt.c     // Catch:{ Throwable -> 0x0053 }
            long r0 = r0 - r2
            r2 = 4900(0x1324, double:2.421E-320)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x0049
            android.net.ConnectivityManager r0 = r5.p     // Catch:{ Throwable -> 0x0053 }
            if (r0 != 0) goto L_0x0023
            android.content.Context r0 = r5.h     // Catch:{ Throwable -> 0x0053 }
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = com.amap.api.col.stln3.xb.a(r0, r1)     // Catch:{ Throwable -> 0x0053 }
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch:{ Throwable -> 0x0053 }
            r5.p = r0     // Catch:{ Throwable -> 0x0053 }
        L_0x0023:
            android.net.ConnectivityManager r0 = r5.p     // Catch:{ Throwable -> 0x0053 }
            boolean r0 = r5.a(r0)     // Catch:{ Throwable -> 0x0053 }
            if (r0 == 0) goto L_0x0038
            long r0 = com.amap.api.col.stln3.xb.b()     // Catch:{ Throwable -> 0x0053 }
            long r2 = com.amap.api.col.stln3.wt.c     // Catch:{ Throwable -> 0x0053 }
            long r0 = r0 - r2
            r2 = 9900(0x26ac, double:4.8912E-320)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x0049
        L_0x0038:
            android.net.wifi.WifiManager r0 = r5.a     // Catch:{ Throwable -> 0x0053 }
            if (r0 == 0) goto L_0x0049
            long r0 = com.amap.api.col.stln3.xb.b()     // Catch:{ Throwable -> 0x0053 }
            com.amap.api.col.stln3.wt.c = r0     // Catch:{ Throwable -> 0x0053 }
            android.net.wifi.WifiManager r0 = r5.a     // Catch:{ Throwable -> 0x0053 }
            boolean r0 = r0.startScan()     // Catch:{ Throwable -> 0x0053 }
            goto L_0x004a
        L_0x0049:
            r0 = 0
        L_0x004a:
            if (r0 == 0) goto L_0x0052
            long r0 = com.amap.api.col.stln3.xb.b()     // Catch:{ Throwable -> 0x0053 }
            com.amap.api.col.stln3.wt.e = r0     // Catch:{ Throwable -> 0x0053 }
        L_0x0052:
            return
        L_0x0053:
            r0 = move-exception
            java.lang.String r1 = "WifiManager"
            java.lang.String r2 = "wifiScan"
            com.amap.api.col.stln3.wy.a(r0, r1, r2)
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.wt.l():void");
    }

    private boolean m() {
        this.o = this.a == null ? false : xb.c(this.h);
        if (!this.o || !this.k) {
            return false;
        }
        if (e != 0) {
            if (xb.b() - e < 4900 || xb.b() - f < 1500) {
                return false;
            }
            int i2 = ((xb.b() - f) > 4900 ? 1 : ((xb.b() - f) == 4900 ? 0 : -1));
        }
        return true;
    }

    public final ArrayList<ScanResult> a() {
        if (this.b == null) {
            return null;
        }
        ArrayList<ScanResult> arrayList = new ArrayList<>();
        if (!this.b.isEmpty()) {
            arrayList.addAll(this.b);
        }
        return arrayList;
    }

    public final void a(boolean z) {
        Context context = this.h;
        if (this.a != null && context != null && z && xb.c() > 17) {
            ContentResolver contentResolver = context.getContentResolver();
            try {
                if (((Integer) wz.a("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                    wz.a("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", 1}, new Class[]{ContentResolver.class, String.class, Integer.TYPE});
                }
            } catch (Throwable th) {
                wy.a(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
            }
        }
    }

    public final boolean a(ConnectivityManager connectivityManager) {
        WifiManager wifiManager = this.a;
        if (wifiManager == null) {
            return false;
        }
        try {
            return xb.a(connectivityManager.getActiveNetworkInfo()) == 1 && a(wifiManager.getConnectionInfo());
        } catch (Throwable th) {
            wy.a(th, "WifiManagerWrapper", "wifiAccess");
            return false;
        }
    }

    public final void b() {
        this.r = null;
        this.b.clear();
    }

    public final void b(boolean z) {
        String str;
        if (!z) {
            l();
        } else if (m()) {
            long b2 = xb.b();
            if (b2 - d >= 10000) {
                this.b.clear();
                g = f;
            }
            l();
            if (b2 - d >= 10000) {
                for (int i2 = 20; i2 > 0 && f == g; i2--) {
                    try {
                        Thread.sleep(150);
                    } catch (Throwable th) {
                    }
                }
            }
        }
        if (this.q) {
            this.q = false;
            b();
        }
        if (g != f) {
            List<ScanResult> list = null;
            try {
                list = j();
            } catch (Throwable th2) {
                wy.a(th2, "WifiManager", "updateScanResult");
            }
            g = f;
            if (list != null) {
                this.b.clear();
                this.b.addAll(list);
            } else {
                this.b.clear();
            }
        }
        if (xb.b() - f > 20000) {
            this.b.clear();
        }
        d = xb.b();
        if (this.b.isEmpty()) {
            f = xb.b();
            List<ScanResult> j2 = j();
            if (j2 != null) {
                this.b.addAll(j2);
            }
        }
        ArrayList<ScanResult> arrayList = this.b;
        if (!(arrayList == null || arrayList.isEmpty())) {
            if (xb.b() - f > 3600000) {
                b();
            }
            if (this.n == null) {
                this.n = new TreeMap<>(Collections.reverseOrder());
            }
            this.n.clear();
            int size = this.b.size();
            for (int i3 = 0; i3 < size; i3++) {
                ScanResult scanResult = this.b.get(i3);
                if (xb.a(scanResult != null ? scanResult.BSSID : "") && (size <= 20 || a(scanResult.level))) {
                    if (!TextUtils.isEmpty(scanResult.SSID)) {
                        if (!"<unknown ssid>".equals(scanResult.SSID)) {
                            str = String.valueOf(i3);
                        }
                        this.n.put(Integer.valueOf((scanResult.level * 25) + i3), scanResult);
                    } else {
                        str = "unkwn";
                    }
                    scanResult.SSID = str;
                    this.n.put(Integer.valueOf((scanResult.level * 25) + i3), scanResult);
                }
            }
            this.b.clear();
            for (ScanResult scanResult2 : this.n.values()) {
                this.b.add(scanResult2);
            }
            this.n.clear();
        }
    }

    public final void c() {
        if (this.a != null && xb.b() - f > 4900) {
            f = xb.b();
        }
    }

    public final void c(boolean z) {
        this.k = z;
        this.l = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r4 = this;
            android.net.wifi.WifiManager r0 = r4.a
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r1 = 4
            if (r0 == 0) goto L_0x0015
            int r0 = r0.getWifiState()     // Catch:{ Throwable -> 0x000d }
            goto L_0x0016
        L_0x000d:
            r0 = move-exception
            java.lang.String r2 = "Aps"
            java.lang.String r3 = "onReceive part"
            com.amap.api.col.stln3.wy.a(r0, r2, r3)
        L_0x0015:
            r0 = 4
        L_0x0016:
            java.util.ArrayList<android.net.wifi.ScanResult> r2 = r4.b
            if (r2 != 0) goto L_0x0021
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r4.b = r2
        L_0x0021:
            if (r0 == r1) goto L_0x0027
            switch(r0) {
                case 0: goto L_0x0027;
                case 1: goto L_0x0027;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x002a
        L_0x0027:
            r0 = 1
            r4.q = r0
        L_0x002a:
            return
            switch-data {0->0x0027, 1->0x0027, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.wt.d():void");
    }

    public final boolean e() {
        return this.o;
    }

    public final WifiInfo f() {
        this.r = k();
        return this.r;
    }

    public final boolean g() {
        return this.i;
    }

    public final void h() {
        b();
        this.b.clear();
    }
}
