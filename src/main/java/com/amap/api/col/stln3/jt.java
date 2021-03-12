package com.amap.api.col.stln3;

import android.content.Context;
import java.util.Map;

/* compiled from: BaseRequest */
public final class jt extends tw {
    String d = "";
    byte[] e = null;
    Context f = null;
    Map<String, String> g = null;
    Map<String, String> h = null;

    public jt(Context context, String str, byte[] bArr, Map<String, String> map, Map<String, String> map2) {
        this.d = str;
        this.e = bArr;
        this.f = context;
        this.g = map;
        this.h = map2;
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return this.d;
    }

    @Override // com.amap.api.col.stln3.tw
    public final Map<String, String> getRequestHead() {
        return this.g;
    }

    @Override // com.amap.api.col.stln3.tw
    public final Map<String, String> getParams() {
        return this.h;
    }

    @Override // com.amap.api.col.stln3.tw
    public final byte[] getEntityBytes() {
        return this.e;
    }
}
