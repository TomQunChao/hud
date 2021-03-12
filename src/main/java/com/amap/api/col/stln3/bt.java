package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import java.util.List;
import org.json.JSONObject;

/* compiled from: LastLocationManager */
public final class bt {
    static vl b = null;
    static sc e = null;
    static long g = 0;
    String a = null;
    vl c = null;
    vl d = null;
    long f = 0;
    boolean h = false;
    private Context i;

    public bt(Context context) {
        this.i = context.getApplicationContext();
    }

    public final void a() {
        if (!this.h) {
            try {
                if (this.a == null) {
                    this.a = vj.a("MD5", rd.v(this.i));
                }
                if (e == null) {
                    e = new sc(this.i, sc.a((Class<? extends sb>) vm.class), wc.i());
                }
            } catch (Throwable th) {
                vu.a(th, "LastLocationManager", "<init>:DBOperation");
            }
            this.h = true;
        }
    }

    public final boolean a(AMapLocation aMapLocation, String str) {
        if (this.i == null || aMapLocation == null || !wc.a(aMapLocation) || aMapLocation.getLocationType() == 2 || aMapLocation.isMock() || aMapLocation.isFixLastLocation()) {
            return false;
        }
        vl vlVar = new vl();
        vlVar.a(aMapLocation);
        if (aMapLocation.getLocationType() == 1) {
            vlVar.a((String) null);
        } else {
            vlVar.a(str);
        }
        try {
            b = vlVar;
            g = wc.b();
            this.c = vlVar;
            if (this.d != null) {
                if (wc.a(this.d.a(), vlVar.a()) <= 500.0f) {
                    return false;
                }
            }
            if (wc.b() - this.f > 30000) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            vu.a(th, "LastLocationManager", "setLastFix");
        }
    }

    public final AMapLocation b() {
        e();
        vl vlVar = b;
        if (vlVar != null && wc.a(vlVar.a())) {
            return b.a();
        }
        return null;
    }

    public final AMapLocation a(AMapLocation aMapLocation, String str, long j) {
        Throwable th;
        if (aMapLocation == null || aMapLocation.getErrorCode() == 0 || aMapLocation.getLocationType() == 1 || aMapLocation.getErrorCode() == 7) {
            return aMapLocation;
        }
        try {
            e();
            if (b != null) {
                if (b.a() != null) {
                    boolean z = false;
                    if (TextUtils.isEmpty(str)) {
                        long b2 = wc.b() - b.d();
                        if (b2 >= 0 && b2 <= j) {
                            z = true;
                        }
                        aMapLocation.setTrustedLevel(3);
                    } else {
                        if (wc.a(b.b(), str)) {
                            z = true;
                        }
                        aMapLocation.setTrustedLevel(2);
                    }
                    if (!z) {
                        return aMapLocation;
                    }
                    AMapLocation a2 = b.a();
                    try {
                        a2.setLocationType(9);
                        a2.setFixLastLocation(true);
                        a2.setLocationDetail(aMapLocation.getLocationDetail());
                        return a2;
                    } catch (Throwable th2) {
                        th = th2;
                        aMapLocation = a2;
                        vu.a(th, "LastLocationManager", "fixLastLocation");
                        return aMapLocation;
                    }
                }
            }
            return aMapLocation;
        } catch (Throwable th3) {
            th = th3;
            vu.a(th, "LastLocationManager", "fixLastLocation");
            return aMapLocation;
        }
    }

    public final void c() {
        try {
            d();
            this.f = 0;
            this.h = false;
            this.c = null;
            this.d = null;
        } catch (Throwable th) {
            vu.a(th, "LastLocationManager", "destroy");
        }
    }

    public final void d() {
        String str;
        try {
            a();
            if (this.c != null && wc.a(this.c.a()) && e != null && this.c != this.d) {
                if (this.c.d() == 0) {
                    String str2 = this.c.a().toStr();
                    String b2 = this.c.b();
                    this.d = this.c;
                    String str3 = null;
                    if (!TextUtils.isEmpty(str2)) {
                        str = re.b(vj.c(str2.getBytes("UTF-8"), this.a));
                        if (!TextUtils.isEmpty(b2)) {
                            str3 = re.b(vj.c(b2.getBytes("UTF-8"), this.a));
                        }
                    } else {
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        vl vlVar = new vl();
                        vlVar.b(str);
                        vlVar.a(wc.b());
                        vlVar.a(str3);
                        e.a(vlVar, "_id=1");
                        this.f = wc.b();
                        if (b != null) {
                            b.a(wc.b());
                        }
                    }
                }
            }
        } catch (Throwable th) {
            vu.a(th, "LastLocationManager", "saveLastFix");
        }
    }

    private void e() {
        if (b == null || wc.b() - g > 180000) {
            vl f2 = f();
            g = wc.b();
            if (f2 != null && wc.a(f2.a())) {
                b = f2;
            }
        }
    }

    private vl f() {
        vl vlVar;
        Throwable th;
        String str;
        byte[] b2;
        byte[] d2;
        String str2 = null;
        if (this.i == null) {
            return null;
        }
        a();
        try {
            if (e == null) {
                return null;
            }
            List b3 = e.b("_id=1", vl.class);
            if (b3 == null || b3.size() <= 0) {
                vlVar = null;
            } else {
                vlVar = (vl) b3.get(0);
                try {
                    byte[] b4 = re.b(vlVar.c());
                    if (b4 != null && b4.length > 0) {
                        byte[] d3 = vj.d(b4, this.a);
                        if (d3 != null && d3.length > 0) {
                            str = new String(d3, "UTF-8");
                            b2 = re.b(vlVar.b());
                            if (b2 != null && b2.length > 0) {
                                d2 = vj.d(b2, this.a);
                                if (d2 == null && d2.length > 0) {
                                    str2 = new String(d2, "UTF-8");
                                }
                            }
                            vlVar.a(str2);
                            str2 = str;
                        }
                    }
                    str = null;
                    b2 = re.b(vlVar.b());
                    d2 = vj.d(b2, this.a);
                    if (d2 == null) {
                    }
                    vlVar.a(str2);
                    str2 = str;
                } catch (Throwable th2) {
                    th = th2;
                    vu.a(th, "LastLocationManager", "readLastFix");
                    return vlVar;
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                AMapLocation aMapLocation = new AMapLocation("");
                vu.a(aMapLocation, new JSONObject(str2));
                if (wc.b(aMapLocation)) {
                    vlVar.a(aMapLocation);
                }
            }
            return vlVar;
        } catch (Throwable th3) {
            th = th3;
            vlVar = null;
            vu.a(th, "LastLocationManager", "readLastFix");
            return vlVar;
        }
    }
}
