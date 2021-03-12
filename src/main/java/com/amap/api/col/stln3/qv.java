package com.amap.api.col.stln3;

import com.amap.api.col.stln3.rj;

/* compiled from: SDKConfig */
public final class qv {
    private static final String[] a = {"com.amap.track"};

    public static rj a() {
        try {
            return new rj.a("track", "1.0.0", "AMAP_TRACK_Android_1.0.0").a(a).a("1.0.0").a();
        } catch (qx e) {
            qr.a("AMapCoreException " + e);
            return null;
        }
    }
}
