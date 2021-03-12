package com.amap.api.col.stln3;

import com.amap.api.col.stln3.rj;
import com.autonavi.ae.guide.GuideControl;

/* compiled from: Util */
public final class wp {
    static rj a = null;
    private static final String[] b = {"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core"};
    private static final String[] c = {"com.amap.api.mapcore2d", "com.amap.api.maps2d"};
    private static final String[] d = {"com.amap.trace"};

    public static rj a() throws qx {
        Class<?> cls;
        Class<?> cls2;
        rj a2;
        rj rjVar = a;
        if (rjVar != null) {
            return rjVar;
        }
        try {
            cls = Class.forName("com.amap.api.maps.MapsInitializer");
        } catch (Throwable th) {
            cls = null;
        }
        if (cls != null) {
            try {
                String str = (String) wz.a(cls, "getVersion", (Object[]) null, (Class<?>[]) null);
                a2 = new rj.a("3dmap", str, "AMAP_SDK_Android_Map_" + str).a(b).a();
            } catch (Throwable th2) {
            }
        } else {
            cls = Class.forName("com.amap.api.maps2d.MapsInitializer");
            String str2 = (String) wz.a(cls, "getVersion", (Object[]) null, (Class<?>[]) null);
            a2 = new rj.a("2dmap", str2, "AMAP_SDK_Android_2DMap_" + str2).a(c).a();
        }
        a = a2;
        if (cls == null) {
            try {
                cls2 = Class.forName("com.amap.trace.AMapTraceClient");
            } catch (Throwable th3) {
                cls2 = null;
            }
            if (cls2 != null) {
                try {
                    String str3 = (String) wz.a(cls2, "getVersion", (Object[]) null, (Class<?>[]) null);
                    a = new rj.a("trace", str3, "AMAP_TRACE_Android_" + str3).a(d).a();
                } catch (Throwable th4) {
                }
            }
        }
        return a;
    }

    public static boolean a(wl wlVar) {
        if (wlVar == null || wlVar.d().equals(GuideControl.CHANGE_PLAY_TYPE_YYQX) || wlVar.d().equals(GuideControl.CHANGE_PLAY_TYPE_BBHX) || wlVar.d().equals(GuideControl.CHANGE_PLAY_TYPE_CLH)) {
            return false;
        }
        double longitude = wlVar.getLongitude();
        double latitude = wlVar.getLatitude();
        return !(longitude == 0.0d && latitude == 0.0d) && longitude <= 180.0d && latitude <= 90.0d && longitude >= -180.0d && latitude >= -90.0d;
    }
}
