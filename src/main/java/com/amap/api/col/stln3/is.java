package com.amap.api.col.stln3;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ServiceInfo;
import com.amap.api.location.AMapLocationClient;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;

/* compiled from: AMapLocationClient */
public final class is {
    Context a;
    Inner_3dMap_locationManagerBase b = null;
    Object c = null;
    boolean d = false;
    wg e = null;
    rj f = null;

    public is(Context context) {
        ServiceInfo serviceInfo = null;
        try {
            this.f = wp.a();
        } catch (Throwable th) {
        }
        this.e = new wg();
        if (context != null) {
            try {
                this.a = context.getApplicationContext();
                try {
                    Class<?> cls = Class.forName("com.amap.api.location.AMapLocationClient");
                    try {
                        serviceInfo = this.a.getPackageManager().getServiceInfo(new ComponentName(this.a, "com.amap.api.location.APSService"), 128);
                    } catch (Throwable th2) {
                    }
                    if (!(cls == null || serviceInfo == null)) {
                        this.d = true;
                    }
                } catch (Throwable th3) {
                    this.d = false;
                }
                if (this.d) {
                    this.c = new AMapLocationClient(this.a);
                } else {
                    this.b = a(this.a);
                }
            } catch (Throwable th4) {
                wy.a(th4, "AMapLocationClient", "AMapLocationClient 1");
            }
        } else {
            throw new IllegalArgumentException("Context参数不能为null");
        }
    }

    private Inner_3dMap_locationManagerBase a(Context context) {
        Inner_3dMap_locationManagerBase inner_3dMap_locationManagerBase;
        try {
            inner_3dMap_locationManagerBase = (Inner_3dMap_locationManagerBase) sk.a(context, this.f, rk.c("YY29tLmFtYXAuYXBpLndyYXBwZXIuSW5uZXJfM2RNYXBfbG9jYXRpb25NYW5hZ2VyV3JhcHBlcg=="), wi.class, new Class[]{Context.class}, new Object[]{context});
        } catch (Throwable th) {
            inner_3dMap_locationManagerBase = new wi(context);
        }
        return inner_3dMap_locationManagerBase == null ? new wi(context) : inner_3dMap_locationManagerBase;
    }

    public final void a() {
        try {
            if (this.d) {
                ((AMapLocationClient) this.c).startLocation();
            } else {
                this.b.startLocation();
            }
        } catch (Throwable th) {
            wy.a(th, "AMapLocationClient", "startLocation");
        }
    }

    public final void a(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        if (inner_3dMap_locationListener != null) {
            try {
                if (this.d) {
                    this.e.a(this.c, inner_3dMap_locationListener);
                } else {
                    this.b.setLocationListener(inner_3dMap_locationListener);
                }
            } catch (Throwable th) {
                wy.a(th, "AMapLocationClient", "setLocationListener");
            }
        } else {
            throw new IllegalArgumentException("listener参数不能为null");
        }
    }

    public final void a(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        if (inner_3dMap_locationOption != null) {
            try {
                if (this.d) {
                    wg wgVar = this.e;
                    wg.a(this.c, inner_3dMap_locationOption);
                    return;
                }
                this.b.setLocationOption(inner_3dMap_locationOption);
            } catch (Throwable th) {
                wy.a(th, "AMapLocationClient", "setLocationOption");
            }
        } else {
            throw new IllegalArgumentException("LocationManagerOption参数不能为null");
        }
    }

    public final void b() {
        try {
            if (this.d) {
                ((AMapLocationClient) this.c).stopLocation();
            } else {
                this.b.stopLocation();
            }
        } catch (Throwable th) {
            wy.a(th, "AMapLocationClient", "stopLocation");
        }
    }

    public final void c() {
        try {
            if (this.d) {
                ((AMapLocationClient) this.c).onDestroy();
            } else {
                this.b.destroy();
            }
            if (this.e != null) {
                this.e = null;
            }
        } catch (Throwable th) {
            wy.a(th, "AMapLocationClient", "onDestroy");
        }
    }
}
