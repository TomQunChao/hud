package com.amap.api.col.stln3;

import java.util.Map;

/* compiled from: ADIURequest */
public final class tq extends tw {
    private byte[] d;
    private Map<String, String> e;

    public tq(byte[] bArr, Map<String, String> map) {
        this.d = bArr;
        this.e = map;
    }

    @Override // com.amap.api.col.stln3.tw
    public final Map<String, String> getRequestHead() {
        return null;
    }

    @Override // com.amap.api.col.stln3.tw
    public final Map<String, String> getParams() {
        return this.e;
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return "https://adiu.amap.com/ws/device/adius";
    }

    @Override // com.amap.api.col.stln3.tw
    public final byte[] getEntityBytes() {
        return this.d;
    }
}
