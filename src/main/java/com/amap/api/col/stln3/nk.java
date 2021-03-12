package com.amap.api.col.stln3;

import com.amap.api.col.stln3.rj;
import com.amap.api.services.core.ServiceSettings;

/* compiled from: ConfigableConst */
public final class nk {
    public static final String[] a = {"com.amap.api.services", "com.amap.api.search.admic"};

    public static String a() {
        if (ServiceSettings.getInstance().getProtocol() == 1) {
            return "http://restapi.amap.com/v3";
        }
        return "https://restapi.amap.com/v3";
    }

    public static String b() {
        if (ServiceSettings.getInstance().getProtocol() == 1) {
            return "http://restapi.amap.com/v4";
        }
        return "https://restapi.amap.com/v4";
    }

    public static String c() {
        if (ServiceSettings.getInstance().getProtocol() == 1) {
            return "http://yuntuapi.amap.com";
        }
        return "https://yuntuapi.amap.com";
    }

    public static rj a(boolean z) {
        try {
            return new rj.a("sea", "6.5.0", "AMAP SDK Android Search 6.5.0").a(a).a(z).a("6.5.0").a();
        } catch (qx e) {
            nl.a(e, "ConfigableConst", "getSDKInfo");
            return null;
        }
    }

    public static String d() {
        if (ServiceSettings.getInstance().getProtocol() == 1) {
            return "http://m5.amap.com/ws/mapapi/shortaddress/transform";
        }
        return "https://m5.amap.com/ws/mapapi/shortaddress/transform";
    }
}
