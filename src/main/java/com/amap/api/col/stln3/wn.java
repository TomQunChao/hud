package com.amap.api.col.stln3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.autonavi.ae.guide.GuideControl;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;

/* compiled from: MapNetLocation */
public final class wn {
    Context a = null;
    boolean b = false;
    String c = null;
    long d = 0;
    private wt e = null;
    private ws f = null;
    private a g = null;
    private wv h = null;
    private ConnectivityManager i = null;
    private wx j = null;
    private StringBuilder k = new StringBuilder();
    private Inner_3dMap_locationOption l = null;
    private wl m = null;
    private final String n = "\"status\":\"0\"";
    private final String o = "</body></html>";

    /* access modifiers changed from: private */
    /* compiled from: MapNetLocation */
    public class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(wn wnVar, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                try {
                    String action = intent.getAction();
                    if (!TextUtils.isEmpty(action)) {
                        if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                            if (wn.this.e != null) {
                                wn.this.e.c();
                            }
                        } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED") && wn.this.e != null) {
                            wn.this.e.d();
                        }
                    }
                } catch (Throwable th) {
                    wy.a(th, "MapNetLocation", "onReceive");
                }
            }
        }
    }

    public wn(Context context) {
        try {
            this.a = context.getApplicationContext();
            xb.b(this.a);
            try {
                if (this.a.checkCallingOrSelfPermission("android.permission.WRITE_SECURE_SETTINGS") == 0) {
                    this.b = true;
                }
            } catch (Throwable th) {
            }
            this.l = new Inner_3dMap_locationOption();
            if (this.e == null) {
                this.e = new wt(this.a, (WifiManager) xb.a(this.a, "wifi"));
                this.e.a(this.b);
            }
            if (this.f == null) {
                this.f = new ws(this.a);
            }
            if (this.h == null) {
                Context context2 = this.a;
                this.h = wv.a();
            }
            if (this.i == null) {
                this.i = (ConnectivityManager) xb.a(this.a, "connectivity");
            }
            this.j = new wx();
            try {
                if (this.g == null) {
                    this.g = new a(this, (byte) 0);
                }
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
                this.a.registerReceiver(this.g, intentFilter);
                this.e.b(false);
                this.f.b();
            } catch (Throwable th2) {
                wy.a(th2, "MapNetLocation", "initBroadcastListener");
            }
        } catch (Throwable th3) {
            wy.a(th3, "MapNetLocation", "<init>");
        }
    }

    private wl c() throws Exception {
        String str;
        StringBuilder sb;
        wl wlVar = new wl("");
        wt wtVar = this.e;
        if (wtVar == null || !wtVar.g()) {
            try {
                if (this.j == null) {
                    this.j = new wx();
                }
                this.j.a(this.a, this.l.isNeedAddress(), this.l.isOffset(), this.f, this.e, this.i, this.c);
                wo woVar = new wo();
                byte[] bArr = null;
                String str2 = "";
                try {
                    try {
                        ty a2 = this.h.a(this.h.a(this.a, this.j.a(), wy.a()));
                        if (a2 != null) {
                            bArr = a2.a;
                            str2 = a2.c;
                        }
                        if (bArr == null || bArr.length == 0) {
                            wlVar.setErrorCode(4);
                            this.k.append("please check the network");
                            if (!TextUtils.isEmpty(str2)) {
                                StringBuilder sb2 = this.k;
                                sb2.append(" #csid:" + str2);
                            }
                            wlVar.setLocationDetail(this.k.toString());
                            return wlVar;
                        }
                        String str3 = new String(bArr, "UTF-8");
                        if (str3.contains("\"status\":\"0\"")) {
                            return woVar.a(str3, this.a, a2);
                        }
                        if (str3.contains("</body></html>")) {
                            wlVar.setErrorCode(5);
                            wt wtVar2 = this.e;
                            if (wtVar2 == null || !wtVar2.a(this.i)) {
                                sb = this.k;
                                str = "request may be intercepted";
                            } else {
                                sb = this.k;
                                str = "make sure you are logged in to the network";
                            }
                            sb.append(str);
                            if (!TextUtils.isEmpty(str2)) {
                                StringBuilder sb3 = this.k;
                                sb3.append(" #csid:" + str2);
                            }
                            wlVar.setLocationDetail(this.k.toString());
                            return wlVar;
                        }
                        byte[] a3 = wu.a(bArr);
                        if (a3 == null) {
                            wlVar.setErrorCode(5);
                            this.k.append("decrypt response data error");
                            if (!TextUtils.isEmpty(str2)) {
                                StringBuilder sb4 = this.k;
                                sb4.append(" #csid:" + str2);
                            }
                            wlVar.setLocationDetail(this.k.toString());
                            return wlVar;
                        }
                        wl a4 = woVar.a(a3);
                        if (a4 == null) {
                            wl wlVar2 = new wl("");
                            wlVar2.setErrorCode(5);
                            this.k.append("location is null");
                            if (!TextUtils.isEmpty(str2)) {
                                StringBuilder sb5 = this.k;
                                sb5.append(" #csid:" + str2);
                            }
                            wlVar2.setLocationDetail(this.k.toString());
                            return wlVar2;
                        }
                        this.c = a4.a();
                        if (a4.getErrorCode() != 0) {
                            if (!TextUtils.isEmpty(str2)) {
                                a4.setLocationDetail(a4.getLocationDetail() + " #csid:" + str2);
                            }
                            return a4;
                        } else if (wp.a(a4)) {
                            a4.e();
                            if (a4.getErrorCode() == 0 && a4.getLocationType() == 0) {
                                if ("-5".equals(a4.d()) || "1".equals(a4.d()) || "2".equals(a4.d()) || GuideControl.CHANGE_PLAY_TYPE_KLHNH.equals(a4.d()) || "24".equals(a4.d()) || "-1".equals(a4.d())) {
                                    a4.setLocationType(5);
                                } else {
                                    a4.setLocationType(6);
                                }
                                this.k.append(a4.d());
                                if (!TextUtils.isEmpty(str2)) {
                                    StringBuilder sb6 = this.k;
                                    sb6.append(" #csid:" + str2);
                                }
                                a4.setLocationDetail(this.k.toString());
                            }
                            return a4;
                        } else {
                            String b2 = a4.b();
                            a4.setErrorCode(6);
                            StringBuilder sb7 = this.k;
                            StringBuilder sb8 = new StringBuilder("location faile retype:");
                            sb8.append(a4.d());
                            sb8.append(" rdesc:");
                            if (b2 == null) {
                                b2 = "null";
                            }
                            sb8.append(b2);
                            sb7.append(sb8.toString());
                            if (!TextUtils.isEmpty(str2)) {
                                StringBuilder sb9 = this.k;
                                sb9.append(" #csid:" + str2);
                            }
                            a4.setLocationDetail(this.k.toString());
                            return a4;
                        }
                    } catch (Throwable th) {
                        wy.a(th, "MapNetLocation", "getApsLoc req");
                        wlVar.setErrorCode(4);
                        this.k.append("please check the network");
                        wlVar.setLocationDetail(this.k.toString());
                        return wlVar;
                    }
                } catch (Throwable th2) {
                    wy.a(th2, "MapNetLocation", "getApsLoc buildV4Dot2");
                    wlVar.setErrorCode(3);
                    StringBuilder sb10 = this.k;
                    sb10.append("buildV4Dot2 error " + th2.getMessage());
                    wlVar.setLocationDetail(this.k.toString());
                    return wlVar;
                }
            } catch (Throwable th3) {
                wy.a(th3, "MapNetLocation", "getApsLoc");
                StringBuilder sb11 = this.k;
                sb11.append("get parames error:" + th3.getMessage());
                wlVar.setErrorCode(3);
                wlVar.setLocationDetail(this.k.toString());
                return wlVar;
            }
        } else {
            wlVar.setErrorCode(15);
            return wlVar;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0070 A[SYNTHETIC, Splitter:B:21:0x0070] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.autonavi.amap.mapcore.Inner_3dMap_location a() {
        /*
        // Method dump skipped, instructions count: 208
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.wn.a():com.autonavi.amap.mapcore.Inner_3dMap_location");
    }

    public final void a(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.l = inner_3dMap_locationOption;
        if (this.l == null) {
            this.l = new Inner_3dMap_locationOption();
        }
        try {
            wt wtVar = this.e;
            this.l.isWifiActiveScan();
            wtVar.c(this.l.isWifiScan());
        } catch (Throwable th) {
        }
        try {
            this.h.a(this.l.getHttpTimeOut(), this.l.getLocationProtocol().equals(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationProtocol.HTTPS));
        } catch (Throwable th2) {
        }
    }

    public final void b() {
        this.b = false;
        this.c = null;
        try {
            if (!(this.a == null || this.g == null)) {
                this.a.unregisterReceiver(this.g);
            }
            if (this.f != null) {
                this.f.c();
            }
            if (this.e != null) {
                this.e.h();
            }
        } catch (Throwable th) {
        } finally {
            this.g = null;
        }
    }
}
