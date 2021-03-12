package com.amap.api.col.stln3;

import com.alibaba.idst.nls.internal.connector.NetDefine;

/* compiled from: ServiceSettings */
public final class lu {
    private static lu c;
    private String a = "zh-CN";
    private int b = 1;
    private int d = NetDefine.HTTP_READ_TIMEOUT;
    private int e = NetDefine.HTTP_READ_TIMEOUT;

    private lu() {
    }

    public static lu a() {
        if (c == null) {
            c = new lu();
        }
        return c;
    }

    public final String b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }
}
