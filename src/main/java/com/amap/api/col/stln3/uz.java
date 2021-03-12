package com.amap.api.col.stln3;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.text.TextUtils;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.ae.guide.GuideControl;
import com.autonavi.amap.mapcore.tools.GLMapStaticValue;
import java.util.ArrayList;
import java.util.Locale;

@SuppressLint({"NewApi"})
/* compiled from: Aps */
public final class uz {
    static int D = -1;
    public static boolean H = true;
    private static boolean M = false;
    private static int O = -1;
    int A = 12;
    vd B = null;
    boolean C = false;
    vb E = null;
    String F = null;
    vh G = null;
    IntentFilter I = null;
    LocationManager J = null;
    private int K = 0;
    private String L = null;
    private String N = null;
    private boolean P = true;
    Context a = null;
    ConnectivityManager b = null;
    vi c = null;
    vg d = null;
    vk e = null;
    va f = null;
    vr g = null;
    ArrayList<ScanResult> h = new ArrayList<>();
    a i = null;
    AMapLocationClientOption j = new AMapLocationClientOption();
    vc k = null;
    long l = 0;
    vs m = null;
    boolean n = false;
    vp o = null;
    StringBuilder p = new StringBuilder();
    boolean q = true;
    boolean r = true;
    AMapLocationClientOption.GeoLanguage s = AMapLocationClientOption.GeoLanguage.DEFAULT;
    boolean t = true;
    boolean u = false;
    WifiInfo v = null;
    boolean w = true;
    StringBuilder x = null;
    boolean y = false;
    public boolean z = false;

    public final void a(Context context) {
        try {
            if (this.a == null) {
                this.E = new vb();
                this.a = context.getApplicationContext();
                vt.e(this.a);
                wc.b(this.a);
                if (this.c == null) {
                    this.c = new vi(this.a, (WifiManager) wc.a(this.a, "wifi"));
                }
                if (this.d == null) {
                    this.d = new vg(this.a);
                }
                if (this.e == null) {
                    this.e = new vk();
                }
                if (this.g == null) {
                    this.g = new vr();
                }
                if (this.G == null) {
                    this.G = new vh(this.a);
                }
            }
        } catch (Throwable th) {
            vu.a(th, "Aps", "initBase");
        }
    }

    public final void a() {
        this.o = vp.a(this.a);
        l();
        if (this.b == null) {
            this.b = (ConnectivityManager) wc.a(this.a, "connectivity");
        }
        if (this.m == null) {
            this.m = new vs();
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048 A[Catch:{ Throwable -> 0x004e }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049 A[Catch:{ Throwable -> 0x004e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void l() {
        /*
            r8 = this;
            com.amap.api.col.stln3.vp r0 = r8.o
            if (r0 == 0) goto L_0x0050
            com.amap.api.location.AMapLocationClientOption r0 = r8.j     // Catch:{ Throwable -> 0x004e }
            if (r0 != 0) goto L_0x0010
            com.amap.api.location.AMapLocationClientOption r0 = new com.amap.api.location.AMapLocationClientOption     // Catch:{ Throwable -> 0x004e }
            r0.<init>()     // Catch:{ Throwable -> 0x004e }
            r8.j = r0     // Catch:{ Throwable -> 0x004e }
            goto L_0x0011
        L_0x0010:
        L_0x0011:
            com.amap.api.location.AMapLocationClientOption r0 = r8.j     // Catch:{ Throwable -> 0x004e }
            com.amap.api.location.AMapLocationClientOption$GeoLanguage r0 = r0.getGeoLanguage()     // Catch:{ Throwable -> 0x004e }
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0031
            int[] r0 = com.amap.api.col.stln3.uz.AnonymousClass1.a     // Catch:{ Throwable -> 0x004e }
            com.amap.api.location.AMapLocationClientOption r3 = r8.j     // Catch:{ Throwable -> 0x004e }
            com.amap.api.location.AMapLocationClientOption$GeoLanguage r3 = r3.getGeoLanguage()     // Catch:{ Throwable -> 0x004e }
            int r3 = r3.ordinal()     // Catch:{ Throwable -> 0x004e }
            r0 = r0[r3]     // Catch:{ Throwable -> 0x004e }
            switch(r0) {
                case 1: goto L_0x0031;
                case 2: goto L_0x002f;
                case 3: goto L_0x002d;
                default: goto L_0x002c;
            }     // Catch:{ Throwable -> 0x004e }
        L_0x002c:
            goto L_0x0031
        L_0x002d:
            r0 = 2
            goto L_0x0032
        L_0x002f:
            r0 = 1
            goto L_0x0032
        L_0x0031:
            r0 = 0
        L_0x0032:
            com.amap.api.col.stln3.vp r3 = r8.o     // Catch:{ Throwable -> 0x004e }
            com.amap.api.location.AMapLocationClientOption r4 = r8.j     // Catch:{ Throwable -> 0x004e }
            long r4 = r4.getHttpTimeOut()     // Catch:{ Throwable -> 0x004e }
            com.amap.api.location.AMapLocationClientOption r6 = r8.j     // Catch:{ Throwable -> 0x004e }
            com.amap.api.location.AMapLocationClientOption$AMapLocationProtocol r6 = r6.getLocationProtocol()     // Catch:{ Throwable -> 0x004e }
            com.amap.api.location.AMapLocationClientOption$AMapLocationProtocol r7 = com.amap.api.location.AMapLocationClientOption.AMapLocationProtocol.HTTPS     // Catch:{ Throwable -> 0x004e }
            boolean r6 = r6.equals(r7)     // Catch:{ Throwable -> 0x004e }
            if (r6 == 0) goto L_0x0049
            goto L_0x004a
        L_0x0049:
            r1 = 0
        L_0x004a:
            r3.a(r4, r1, r0)     // Catch:{ Throwable -> 0x004e }
            return
        L_0x004e:
            r0 = move-exception
            goto L_0x0051
        L_0x0050:
        L_0x0051:
            return
            switch-data {1->0x0031, 2->0x002f, 3->0x002d, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.uz.l():void");
    }

    public final void b() {
        if (this.B == null) {
            this.B = new vd(this.a);
        }
        if (this.f == null) {
            this.f = new va(this.a);
        }
        m();
        this.c.b(false);
        this.h = this.c.c();
        this.d.a(false, o());
        this.e.a(this.a);
        this.f.b();
        try {
            if (this.a.checkCallingOrSelfPermission(rk.c("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) == 0) {
                this.n = true;
            }
        } catch (Throwable th) {
        }
        this.z = true;
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        boolean z2;
        boolean z3;
        this.j = aMapLocationClientOption;
        if (this.j == null) {
            this.j = new AMapLocationClientOption();
        }
        vi viVar = this.c;
        if (viVar != null) {
            this.j.isWifiActiveScan();
            boolean isWifiScan = this.j.isWifiScan();
            boolean isMockEnable = this.j.isMockEnable();
            AMapLocationClientOption aMapLocationClientOption2 = this.j;
            viVar.a(isWifiScan, isMockEnable, AMapLocationClientOption.isOpenAlwaysScanWifi(), aMapLocationClientOption.getScanWifiInterval());
        }
        l();
        vk vkVar = this.e;
        if (vkVar != null) {
            vkVar.a(this.j);
        }
        vr vrVar = this.g;
        if (vrVar != null) {
            vrVar.a(this.j);
        }
        AMapLocationClientOption.GeoLanguage geoLanguage = AMapLocationClientOption.GeoLanguage.DEFAULT;
        boolean z4 = true;
        try {
            geoLanguage = this.j.getGeoLanguage();
            z3 = this.j.isNeedAddress();
            try {
                z2 = this.j.isOffset();
                try {
                    z4 = this.j.isLocationCacheEnable();
                    this.u = this.j.isOnceLocationLatest();
                    this.C = this.j.isSensorEnable();
                    if (!(z2 == this.r && z3 == this.q && z4 == this.t && geoLanguage == this.s)) {
                        try {
                            if (this.e != null) {
                                this.e.a();
                            }
                            b((vc) null);
                            this.P = false;
                            if (this.E != null) {
                                this.E.a();
                            }
                        } catch (Throwable th) {
                            vu.a(th, "Aps", "cleanCache");
                        }
                    }
                } catch (Throwable th2) {
                }
            } catch (Throwable th3) {
                z2 = true;
                this.r = z2;
                this.q = z3;
                this.t = z4;
                this.s = geoLanguage;
            }
        } catch (Throwable th4) {
            z3 = true;
            z2 = true;
            this.r = z2;
            this.q = z3;
            this.t = z4;
            this.s = geoLanguage;
        }
        this.r = z2;
        this.q = z3;
        this.t = z4;
        this.s = geoLanguage;
    }

    public final void c() {
        if (this.p.length() > 0) {
            StringBuilder sb = this.p;
            sb.delete(0, sb.length());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x012a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.amap.api.col.stln3.vc d() throws java.lang.Throwable {
        /*
        // Method dump skipped, instructions count: 699
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.uz.d():com.amap.api.col.stln3.vc");
    }

    public final void e() {
        try {
            a(this.a);
            a(this.j);
            Context context = this.a;
            i();
            a(a(true, true));
        } catch (Throwable th) {
            vu.a(th, "Aps", "doFusionLocation");
        }
    }

    public final vc a(vc vcVar, String... strArr) {
        this.E.a(this.t);
        if (strArr == null || strArr.length == 0) {
            return this.E.a(vcVar);
        }
        if (strArr[0].equals("shake")) {
            return this.E.a(vcVar);
        }
        if (!strArr[0].equals("fusion")) {
            return vcVar;
        }
        vb vbVar = this.E;
        return vcVar;
    }

    @SuppressLint({"NewApi"})
    public final void f() {
        this.F = null;
        this.y = false;
        this.z = false;
        vh vhVar = this.G;
        if (vhVar != null) {
            vhVar.c();
        }
        va vaVar = this.f;
        if (vaVar != null) {
            vaVar.a();
        }
        vk vkVar = this.e;
        if (vkVar != null) {
            vkVar.b(this.a);
        }
        vb vbVar = this.E;
        if (vbVar != null) {
            vbVar.a();
        }
        if (this.g != null) {
            this.g = null;
        }
        wc.g();
        try {
            if (!(this.a == null || this.i == null)) {
                this.a.unregisterReceiver(this.i);
            }
        } catch (Throwable th) {
            this.i = null;
            throw th;
        }
        this.i = null;
        vg vgVar = this.d;
        if (vgVar != null) {
            vgVar.h();
        }
        vi viVar = this.c;
        if (viVar != null) {
            viVar.k();
        }
        ArrayList<ScanResult> arrayList = this.h;
        if (arrayList != null) {
            arrayList.clear();
        }
        vd vdVar = this.B;
        if (vdVar != null) {
            vdVar.f();
        }
        vn.d();
        this.k = null;
        this.a = null;
        this.x = null;
        this.J = null;
    }

    private void m() {
        try {
            if (this.i == null) {
                this.i = new a();
            }
            if (this.I == null) {
                this.I = new IntentFilter();
                this.I.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                this.I.addAction("android.net.wifi.SCAN_RESULTS");
            }
            this.a.registerReceiver(this.i, this.I);
        } catch (Throwable th) {
            vu.a(th, "Aps", "initBroadcastListener");
        }
    }

    private String n() {
        boolean z2;
        String str;
        String str2;
        String str3 = "";
        int f2 = this.d.f();
        vf c2 = this.d.c();
        ArrayList<ScanResult> arrayList = this.h;
        boolean z3 = arrayList == null || arrayList.isEmpty();
        if (c2 != null || !z3) {
            this.v = this.c.h();
            vi viVar = this.c;
            this.w = vi.a(this.v);
            switch (f2) {
                case 0:
                    if (!this.h.isEmpty() || this.w) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!this.w || !this.h.isEmpty()) {
                        if (this.h.size() == 1) {
                            this.A = 2;
                            if (!this.w) {
                                this.p.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
                                vz.a((String) null, (int) GLMapStaticValue.MAP_PARAMETERNAME_CLEAR_INDOORBUILDING_LAST);
                                return str3;
                            }
                            if (this.c.h().getBSSID().equals(this.h.get(0).BSSID)) {
                                this.p.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
                                vz.a((String) null, 2021);
                                return str3;
                            }
                        }
                        str3 = String.format(Locale.US, "#%s#", "network");
                        if (!z2) {
                            if ("network".equals("network")) {
                                str3 = "";
                                this.A = 2;
                                if (!this.c.g()) {
                                    this.p.append("当前基站为伪基站,并且关闭了WIFI开关，请在设置中打开WIFI开关#0203");
                                } else {
                                    this.p.append("当前基站为伪基站,并且没有搜索到WIFI，请移动到WIFI比较丰富的区域#0204");
                                }
                                vz.a((String) null, (int) GLMapStaticValue.MAP_PARAMETERNAME_CLEAR_INDOORBUILDING_LAST);
                                break;
                            }
                        } else {
                            str3 = str3 + "wifi";
                            break;
                        }
                    } else {
                        this.A = 2;
                        this.p.append("当前基站为伪基站，并且WIFI权限被禁用，请在安全软件中打开应用的定位权限#0201");
                        vz.a((String) null, 2021);
                        return str3;
                    }
                    break;
                case 1:
                    if (c2 != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(c2.a);
                        sb.append("#");
                        sb.append(c2.b);
                        sb.append("#");
                        sb.append(c2.c);
                        sb.append("#");
                        sb.append(c2.d);
                        sb.append("#");
                        sb.append("network");
                        sb.append("#");
                        if (!this.h.isEmpty() || this.w) {
                            str = "cgiwifi";
                        } else {
                            str = "cgi";
                        }
                        sb.append(str);
                        str3 = sb.toString();
                        break;
                    }
                    break;
                case 2:
                    if (c2 != null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(c2.a);
                        sb2.append("#");
                        sb2.append(c2.b);
                        sb2.append("#");
                        sb2.append(c2.g);
                        sb2.append("#");
                        sb2.append(c2.h);
                        sb2.append("#");
                        sb2.append(c2.i);
                        sb2.append("#");
                        sb2.append("network");
                        sb2.append("#");
                        if (!this.h.isEmpty() || this.w) {
                            str2 = "cgiwifi";
                        } else {
                            str2 = "cgi";
                        }
                        sb2.append(str2);
                        str3 = sb2.toString();
                        break;
                    }
                    break;
                default:
                    this.A = 11;
                    vz.a((String) null, 2111);
                    this.p.append("get cgi failure#1101");
                    break;
            }
            if (TextUtils.isEmpty(str3)) {
                return str3;
            }
            if (!str3.startsWith("#")) {
                str3 = "#" + str3;
            }
            return wc.h() + str3;
        }
        if (this.b == null) {
            this.b = (ConnectivityManager) wc.a(this.a, "connectivity");
        }
        if (!wc.a(this.a) || this.c.g()) {
            if (wc.c() >= 28) {
                if (this.J == null) {
                    this.J = (LocationManager) this.a.getApplicationContext().getSystemService("location");
                }
                if (!((Boolean) vx.a(this.J, "isLocationEnabled", new Object[0])).booleanValue()) {
                    this.A = 12;
                    this.p.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
                    vz.a((String) null, 2121);
                    return str3;
                }
            }
            if (!wc.f(this.a)) {
                this.A = 12;
                this.p.append("定位权限被禁用,请授予应用定位权限#1201");
                vz.a((String) null, 2121);
                return str3;
            } else if (wc.c() < 24 || wc.c() >= 28 || Settings.Secure.getInt(this.a.getContentResolver(), "location_mode", 0) != 0) {
                String j2 = this.d.j();
                String b2 = this.c.b();
                if (this.c.a(this.b) || this.c.m() || b2 != null) {
                    this.A = 12;
                    if (j2 != null) {
                        this.p.append("获取基站与获取WIFI的权限都被禁用，请在安全软件中打开应用的定位权限#1202");
                    } else {
                        this.p.append("获取到的基站为空，并且获取WIFI权限被禁用,请在安全软件中打开应用的定位权限#1203");
                    }
                    vz.a((String) null, 2121);
                    return str3;
                } else if (j2 != null) {
                    this.A = 12;
                    if (!this.c.g()) {
                        this.p.append("WIFI开关关闭，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限或者打开WIFI开关#1204");
                    } else {
                        this.p.append("获取的WIFI列表为空，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限#1205");
                    }
                    vz.a((String) null, 2121);
                    return str3;
                } else if (this.c.g() || this.d.m()) {
                    if (!this.c.g()) {
                        this.p.append("获取到的基站为空，并且关闭了WIFI开关，请您打开WIFI开关在发起定位#1301");
                    } else {
                        this.p.append("获取到的基站与WIFI为空，请移动到有WIFI的区域，若确定当前区域有WIFI，请检查是否授予APP定位权限#1302");
                    }
                    this.A = 13;
                    vz.a((String) null, 2131);
                    return str3;
                } else {
                    this.A = 19;
                    this.p.append("没有检查到SIM卡，并且WIFI开关关闭，请打开WIFI开关或者插入SIM卡#1901");
                    vz.a((String) null, 2133);
                    return str3;
                }
            } else {
                this.A = 12;
                this.p.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
                vz.a((String) null, 2121);
                return str3;
            }
        } else {
            this.A = 18;
            this.p.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1801");
            vz.a((String) null, 2132);
            return str3;
        }
    }

    private StringBuilder a(StringBuilder sb) {
        if (sb == null) {
            sb = new StringBuilder(700);
        } else {
            sb.delete(0, sb.length());
        }
        sb.append(this.d.l());
        sb.append(this.c.j());
        return sb;
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Aps */
    public class a extends BroadcastReceiver {
        a() {
        }

        public final void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                try {
                    String action = intent.getAction();
                    if (!TextUtils.isEmpty(action)) {
                        if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                            if (uz.this.c != null) {
                                uz.this.c.e();
                            }
                        } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED") && uz.this.c != null) {
                            uz.this.c.f();
                        }
                    }
                } catch (Throwable th) {
                    vu.a(th, "Aps", "onReceive");
                }
            }
        }
    }

    private vc a(vc vcVar, ty tyVar) {
        if (tyVar != null) {
            try {
                if (tyVar.a != null) {
                    if (tyVar.a.length != 0) {
                        vr vrVar = new vr();
                        String str = new String(tyVar.a, "UTF-8");
                        if (str.contains("\"status\":\"0\"")) {
                            vc a2 = vrVar.a(str, this.a, tyVar);
                            a2.h(this.x.toString());
                            return a2;
                        } else if (!str.contains("</body></html>")) {
                            return null;
                        } else {
                            vcVar.setErrorCode(5);
                            if (this.c == null || !this.c.a(this.b)) {
                                this.p.append("请求可能被劫持了#0502");
                                vz.a((String) null, 2052);
                            } else {
                                this.p.append("您连接的是一个需要登录的网络，请确认已经登入网络#0501");
                                vz.a((String) null, 2051);
                            }
                            vcVar.setLocationDetail(this.p.toString());
                            return vcVar;
                        }
                    }
                }
            } catch (Throwable th) {
                vcVar.setErrorCode(4);
                vu.a(th, "Aps", "checkResponseEntity");
                StringBuilder sb = this.p;
                sb.append("check response exception ex is" + th.getMessage() + "#0403");
                vcVar.setLocationDetail(this.p.toString());
                return vcVar;
            }
        }
        vcVar.setErrorCode(4);
        this.p.append("网络异常,请求异常#0403");
        vcVar.h(this.x.toString());
        vcVar.setLocationDetail(this.p.toString());
        if (tyVar != null) {
            vz.a(tyVar.d, 2041);
        }
        return vcVar;
    }

    @SuppressLint({"NewApi"})
    private vc a(boolean z2, boolean z3) {
        vc vcVar = new vc("");
        try {
            if (this.m == null) {
                this.m = new vs();
            }
            if (this.j == null) {
                this.j = new AMapLocationClientOption();
            }
            this.m.a(this.a, this.j.isNeedAddress(), this.j.isOffset(), this.d, this.c, this.b, this.G != null ? this.G.b() : null, this.F);
            byte[] a2 = this.m.a();
            this.l = wc.b();
            try {
                vu.c(this.a);
                vq a3 = this.o.a(this.a, a2, vu.a(), z3);
                vn.a(this.a).a(a3);
                ty a4 = this.o.a(a3);
                vn.a(this.a).a();
                String str = "";
                if (a4 != null) {
                    vn.a(this.a).b();
                    vcVar.a((long) this.o.a());
                    if (!TextUtils.isEmpty(a4.c)) {
                        StringBuilder sb = this.p;
                        sb.append("#csid:" + a4.c);
                    }
                    str = a4.d;
                    vcVar.h(this.x.toString());
                }
                if (!z2) {
                    vc a5 = a(vcVar, a4);
                    if (a5 != null) {
                        return a5;
                    }
                    byte[] a6 = vj.a(a4.a);
                    if (a6 == null) {
                        vcVar.setErrorCode(5);
                        this.p.append("解密数据失败#0503");
                        vcVar.setLocationDetail(this.p.toString());
                        vz.a(str, 2053);
                        return vcVar;
                    }
                    vcVar = this.g.a(vcVar, a6);
                    if (!wc.a(vcVar)) {
                        this.L = vcVar.b();
                        if (!TextUtils.isEmpty(this.L)) {
                            vz.a(str, 2062);
                        } else {
                            vz.a(str, 2061);
                        }
                        vcVar.setErrorCode(6);
                        StringBuilder sb2 = this.p;
                        StringBuilder sb3 = new StringBuilder("location faile retype:");
                        sb3.append(vcVar.d());
                        sb3.append(" rdesc:");
                        sb3.append(TextUtils.isEmpty(this.L) ? "" : this.L);
                        sb3.append("#0601");
                        sb2.append(sb3.toString());
                        vcVar.h(this.x.toString());
                        vcVar.setLocationDetail(this.p.toString());
                        return vcVar;
                    }
                    if (vcVar.getErrorCode() == 0 && vcVar.getLocationType() == 0) {
                        if ("-5".equals(vcVar.d()) || "1".equals(vcVar.d()) || "2".equals(vcVar.d()) || GuideControl.CHANGE_PLAY_TYPE_KLHNH.equals(vcVar.d()) || "24".equals(vcVar.d()) || "-1".equals(vcVar.d())) {
                            vcVar.setLocationType(5);
                        } else {
                            vcVar.setLocationType(6);
                        }
                    }
                    vcVar.setOffset(this.r);
                    vcVar.a(this.q);
                    vcVar.f(String.valueOf(this.s));
                }
                vcVar.e("new");
                vcVar.setLocationDetail(this.p.toString());
                this.F = vcVar.a();
                return vcVar;
            } catch (Throwable th) {
                vn.a(this.a).c();
                vu.a(th, "Aps", "getApsLoc req");
                vz.a("/mobile/binary", th);
                if (!wc.d(this.a)) {
                    this.p.append("网络异常，未连接到网络，请连接网络#0401");
                } else if (th instanceof qx) {
                    qx qxVar = (qx) th;
                    if (qxVar.a().contains("网络异常状态码")) {
                        StringBuilder sb4 = this.p;
                        sb4.append("网络异常，状态码错误#0404");
                        sb4.append(qxVar.e());
                    } else if (qxVar.e() == 23 || Math.abs((wc.b() - this.l) - this.j.getHttpTimeOut()) < 500) {
                        this.p.append("网络异常，连接超时#0402");
                    } else {
                        this.p.append("网络异常,请求异常#0403");
                    }
                } else {
                    this.p.append("网络异常,请求异常#0403");
                }
                vc a7 = a(4, this.p.toString());
                a7.h(this.x.toString());
                return a7;
            }
        } catch (Throwable th2) {
            StringBuilder sb5 = this.p;
            sb5.append("get parames error:" + th2.getMessage() + "#0301");
            vz.a((String) null, 2031);
            vc a8 = a(3, this.p.toString());
            a8.h(this.x.toString());
            return a8;
        }
    }

    public final void g() {
        try {
            if (this.f != null) {
                this.f.c();
            }
        } catch (Throwable th) {
            vu.a(th, "Aps", "bindAMapService");
        }
    }

    public final void h() {
        try {
            if (this.f != null) {
                this.f.d();
            }
        } catch (Throwable th) {
            vu.a(th, "Aps", "bindOtherService");
        }
    }

    public static void b(Context context) {
        try {
            if (O != -1) {
                if (!vt.h(context)) {
                    return;
                }
            }
            O = 1;
            vt.a(context);
        } catch (Throwable th) {
            vu.a(th, "Aps", "initAuth");
        }
    }

    public final void i() {
        try {
            if (!this.y) {
                if (this.N != null) {
                    this.N = null;
                }
                if (this.x != null) {
                    this.x.delete(0, this.x.length());
                }
                if (this.u) {
                    m();
                }
                this.c.b(this.u);
                this.h = this.c.c();
                this.d.a(true, o());
                this.N = n();
                if (!TextUtils.isEmpty(this.N)) {
                    this.x = a(this.x);
                }
                this.y = true;
            }
        } catch (Throwable th) {
            vu.a(th, "Aps", "initFirstLocateParam");
        }
    }

    private boolean o() {
        this.h = this.c.c();
        ArrayList<ScanResult> arrayList = this.h;
        if (arrayList == null || arrayList.size() <= 0) {
            return true;
        }
        return false;
    }

    public final vc j() {
        if (this.c.i()) {
            return a(15, "networkLocation has been mocked!#1502");
        }
        if (TextUtils.isEmpty(this.N)) {
            return a(this.A, this.p.toString());
        }
        vc a2 = this.e.a(this.a, this.N, this.x, true);
        if (!wc.a(a2)) {
            return a2;
        }
        b(a2);
        return a2;
    }

    private void b(vc vcVar) {
        if (vcVar != null) {
            this.k = vcVar;
        }
    }

    public final vc a(boolean z2) {
        if (this.a == null) {
            this.p.append("context is null#0101");
            vz.a((String) null, 2011);
            return a(1, this.p.toString());
        } else if (this.c.i()) {
            return a(15, "networkLocation has been mocked!#1502");
        } else {
            a();
            if (TextUtils.isEmpty(this.N)) {
                return a(this.A, this.p.toString());
            }
            vc a2 = a(false, z2);
            if (wc.a(a2)) {
                this.e.a(this.x.toString());
                this.e.a(this.d.c());
                b(a2);
            }
            return a2;
        }
    }

    public final void a(vc vcVar) {
        if (wc.a(vcVar)) {
            this.e.a(this.N, this.x, vcVar, this.a, true);
        }
    }

    public final void k() {
        vh vhVar = this.G;
        if (vhVar != null) {
            vhVar.a();
        }
    }

    public final vc a(double d2, double d3) {
        try {
            String a2 = this.o.a(this.a, d2, d3);
            if (!a2.contains("\"status\":\"1\"")) {
                return null;
            }
            vc a3 = this.g.a(a2);
            a3.setLatitude(d2);
            a3.setLongitude(d3);
            return a3;
        } catch (Throwable th) {
            return null;
        }
    }

    private static vc a(int i2, String str) {
        vc vcVar = new vc("");
        vcVar.setErrorCode(i2);
        vcVar.setLocationDetail(str);
        if (i2 == 15) {
            vz.a((String) null, 2151);
        }
        return vcVar;
    }
}
