package com.amap.api.col.stln3;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

/* compiled from: WifiManagerWrapper */
public final class vi {
    static long c = 0;
    static long d = 0;
    static long e = 0;
    static long f = 0;
    static long g = 0;
    public static HashMap<String, Long> q = new HashMap<>(36);
    public static long r = 0;
    static int s = 0;
    WifiManager a;
    ArrayList<ScanResult> b = new ArrayList<>();
    Context h;
    boolean i = false;
    StringBuilder j = null;
    boolean k = true;
    boolean l = true;
    boolean m = true;
    String n = null;
    TreeMap<Integer, ScanResult> o = null;
    public boolean p = true;
    ConnectivityManager t = null;
    volatile boolean u = false;
    private volatile WifiInfo v = null;
    private long w = 30000;

    public vi(Context context, WifiManager wifiManager) {
        this.a = wifiManager;
        this.h = context;
    }

    private List<ScanResult> n() {
        WifiManager wifiManager = this.a;
        if (wifiManager != null) {
            try {
                List<ScanResult> scanResults = wifiManager.getScanResults();
                if (Build.VERSION.SDK_INT >= 17) {
                    HashMap<String, Long> hashMap = new HashMap<>(36);
                    for (ScanResult scanResult : scanResults) {
                        hashMap.put(scanResult.BSSID, Long.valueOf(scanResult.timestamp));
                    }
                    if (!q.isEmpty()) {
                        if (!q.equals(hashMap)) {
                        }
                    }
                    q = hashMap;
                    r = wc.b();
                } else {
                    r = wc.b();
                }
                this.n = null;
                return scanResults;
            } catch (SecurityException e2) {
                this.n = e2.getMessage();
            } catch (Throwable th) {
                this.n = null;
                vu.a(th, "WifiManagerWrapper", "getScanResults");
            }
        }
        return null;
    }

    public static long a() {
        return ((wc.b() - r) / 1000) + 1;
    }

    private WifiInfo o() {
        try {
            if (this.a != null) {
                return this.a.getConnectionInfo();
            }
            return null;
        } catch (Throwable th) {
            vu.a(th, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    public final boolean a(ConnectivityManager connectivityManager) {
        WifiManager wifiManager = this.a;
        if (wifiManager == null) {
            return false;
        }
        try {
            if (wc.a(connectivityManager.getActiveNetworkInfo()) != 1 || !a(wifiManager.getConnectionInfo())) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            vu.a(th, "WifiManagerWrapper", "wifiAccess");
            return false;
        }
    }

    public final void a(boolean z) {
        Context context = this.h;
        if (vt.H() && this.m && this.a != null && context != null && z && wc.c() > 17) {
            ContentResolver contentResolver = context.getContentResolver();
            try {
                if (((Integer) vx.a("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                    vx.a("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", 1}, new Class[]{ContentResolver.class, String.class, Integer.TYPE});
                }
            } catch (Throwable th) {
                vu.a(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
            }
        }
    }

    public static boolean a(WifiInfo wifiInfo) {
        if (wifiInfo != null && !TextUtils.isEmpty(wifiInfo.getSSID()) && wc.a(wifiInfo.getBSSID())) {
            return true;
        }
        return false;
    }

    public final String b() {
        return this.n;
    }

    private List<WifiConfiguration> p() {
        WifiManager wifiManager = this.a;
        if (wifiManager != null) {
            return wifiManager.getConfiguredNetworks();
        }
        return null;
    }

    public final ArrayList<ScanResult> c() {
        if (this.b == null) {
            return null;
        }
        ArrayList<ScanResult> arrayList = new ArrayList<>();
        if (!this.b.isEmpty()) {
            arrayList.addAll(this.b);
        }
        return arrayList;
    }

    public final void b(boolean z) {
        String str;
        if (!z) {
            q();
        } else if (r()) {
            long b2 = wc.b();
            if (b2 - d >= 10000) {
                this.b.clear();
                g = f;
            }
            q();
            if (b2 - d >= 10000) {
                for (int i2 = 20; i2 > 0 && f == g; i2--) {
                    try {
                        Thread.sleep(150);
                    } catch (Throwable th) {
                    }
                }
            }
        }
        if (this.u) {
            this.u = false;
            d();
        }
        if (g != f) {
            List<ScanResult> list = null;
            try {
                list = n();
            } catch (Throwable th2) {
                vu.a(th2, "WifiManager", "updateScanResult");
            }
            g = f;
            if (list != null) {
                this.b.clear();
                this.b.addAll(list);
            } else {
                this.b.clear();
            }
        }
        if (wc.b() - f > 20000) {
            this.b.clear();
        }
        d = wc.b();
        if (this.b.isEmpty()) {
            f = wc.b();
            List<ScanResult> n2 = n();
            if (n2 != null) {
                this.b.addAll(n2);
            }
        }
        ArrayList<ScanResult> arrayList = this.b;
        if (!(arrayList == null || arrayList.isEmpty())) {
            if (wc.b() - f > 3600000) {
                d();
            }
            if (this.o == null) {
                this.o = new TreeMap<>(Collections.reverseOrder());
            }
            this.o.clear();
            int size = this.b.size();
            for (int i3 = 0; i3 < size; i3++) {
                ScanResult scanResult = this.b.get(i3);
                if (wc.a(scanResult != null ? scanResult.BSSID : "") && (size <= 20 || a(scanResult.level))) {
                    if (!TextUtils.isEmpty(scanResult.SSID)) {
                        if (!"<unknown ssid>".equals(scanResult.SSID)) {
                            str = String.valueOf(i3);
                        }
                        this.o.put(Integer.valueOf((scanResult.level * 25) + i3), scanResult);
                    } else {
                        str = "unkwn";
                    }
                    scanResult.SSID = str;
                    this.o.put(Integer.valueOf((scanResult.level * 25) + i3), scanResult);
                }
            }
            this.b.clear();
            for (ScanResult scanResult2 : this.o.values()) {
                this.b.add(scanResult2);
            }
            this.o.clear();
        }
    }

    public final void a(boolean z, boolean z2, boolean z3, long j2) {
        this.k = z;
        this.l = z2;
        this.m = z3;
        if (j2 < 10000) {
            this.w = 10000;
        } else {
            this.w = j2;
        }
    }

    public final void d() {
        this.v = null;
        this.b.clear();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0057, code lost:
        if (r0 < r6) goto L_0x0074;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0077 A[Catch:{ Throwable -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void q() {
        /*
        // Method dump skipped, instructions count: 139
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.vi.q():void");
    }

    public final void e() {
        if (this.a != null && wc.b() - f > 4900) {
            f = wc.b();
        }
    }

    public final void f() {
        int i2;
        WifiManager wifiManager = this.a;
        if (wifiManager != null) {
            if (wifiManager != null) {
                try {
                    i2 = wifiManager.getWifiState();
                } catch (Throwable th) {
                    vu.a(th, "Aps", "onReceive part");
                    i2 = 4;
                }
            } else {
                i2 = 4;
            }
            if (this.b == null) {
                this.b = new ArrayList<>();
            }
            if (i2 != 4) {
                switch (i2) {
                    case 0:
                    case 1:
                        break;
                    default:
                        return;
                }
            }
            this.u = true;
        }
    }

    private static boolean a(int i2) {
        int i3 = 20;
        try {
            i3 = WifiManager.calculateSignalLevel(i2, 20);
        } catch (ArithmeticException e2) {
            vu.a(e2, "Aps", "wifiSigFine");
        }
        return i3 > 0;
    }

    public final boolean g() {
        return this.p;
    }

    private boolean r() {
        this.p = this.a == null ? false : wc.g(this.h);
        if (!this.p || !this.k) {
            return false;
        }
        if (e == 0) {
            return true;
        }
        if (wc.b() - e < 4900 || wc.b() - f < 1500) {
            return false;
        }
        if (wc.b() - f > 4900) {
            return true;
        }
        return true;
    }

    public final WifiInfo h() {
        this.v = o();
        return this.v;
    }

    public final boolean i() {
        return this.i;
    }

    public final String j() {
        StringBuilder sb = this.j;
        int i2 = 0;
        if (sb == null) {
            this.j = new StringBuilder(700);
        } else {
            sb.delete(0, sb.length());
        }
        this.i = false;
        String str = "";
        this.v = h();
        if (a(this.v)) {
            str = this.v.getBSSID();
        }
        int size = this.b.size();
        boolean z = false;
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            String str2 = this.b.get(i3).BSSID;
            if (!this.l && !"<unknown ssid>".equals(this.b.get(i3).SSID)) {
                z = true;
            }
            String str3 = "nb";
            if (str.equals(str2)) {
                str3 = "access";
                z2 = true;
            }
            this.j.append(String.format(Locale.US, "#%s,%s", str2, str3));
        }
        if (this.b.size() == 0) {
            z = true;
        }
        try {
            if (!this.l && !z) {
                List<WifiConfiguration> p2 = p();
                int i4 = 0;
                while (p2 != null) {
                    try {
                        if (i2 >= p2.size()) {
                            break;
                        }
                        if (this.j.toString().contains(p2.get(i2).BSSID)) {
                            i4 = 1;
                        }
                        i2++;
                    } catch (Throwable th) {
                        i2 = i4;
                    }
                }
                i2 = i4;
            }
        } catch (Throwable th2) {
        }
        if (!this.l && !z && i2 == 0) {
            this.i = true;
        }
        if (!z2 && !TextUtils.isEmpty(str)) {
            StringBuilder sb2 = this.j;
            sb2.append("#");
            sb2.append(str);
            this.j.append(",access");
        }
        return this.j.toString();
    }

    public final void k() {
        d();
        this.b.clear();
    }

    public static String l() {
        return String.valueOf(wc.b() - f);
    }

    public final boolean m() {
        try {
            List<WifiConfiguration> p2 = p();
            if (p2 == null || p2.isEmpty()) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}
