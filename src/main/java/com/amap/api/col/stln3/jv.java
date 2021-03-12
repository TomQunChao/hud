package com.amap.api.col.stln3;

import com.amap.api.navi.enums.NetWorkingProtocol;

/* compiled from: NaviNetManager */
public final class jv {
    public static NetWorkingProtocol a = NetWorkingProtocol.HTTP;

    public static ty a(boolean z, tw twVar) throws qx {
        boolean z2 = a == NetWorkingProtocol.HTTPS;
        if (z) {
            tv.b();
            return tv.a(twVar, z2);
        }
        tv.b();
        return tv.c(twVar, z2);
    }

    public static void a() {
        tv.d();
    }
}
