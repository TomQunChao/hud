package com.amap.api.col.stln3;

import java.util.HashMap;
import java.util.Map;

/* compiled from: LogUpdateRequest */
public final class rw extends tw {
    private byte[] d;
    private String e = "1";

    public rw(byte[] bArr, String str) {
        this.d = (byte[]) bArr.clone();
        this.e = str;
    }

    @Override // com.amap.api.col.stln3.tw
    public final Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.d.length));
        return hashMap;
    }

    @Override // com.amap.api.col.stln3.tw
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        String c = rk.c(rs.c);
        byte[] a = rk.a(rs.b);
        byte[] bArr = new byte[(a.length + 50)];
        System.arraycopy(this.d, 0, bArr, 0, 50);
        System.arraycopy(a, 0, bArr, 50, a.length);
        return String.format(c, "1", this.e, "1", "open", rg.a(bArr));
    }

    @Override // com.amap.api.col.stln3.tw
    public final byte[] getEntityBytes() {
        return this.d;
    }
}
