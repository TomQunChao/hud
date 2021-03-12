package com.amap.api.col.stln3;

import android.content.Context;
import java.util.Map;

/* compiled from: PandlaBinaryRequest */
public final class jw extends ts {
    String d = "";
    byte[] e = null;
    Context f = null;
    Map<String, String> g = null;

    public jw(Context context, String str, byte[] bArr, Map<String, String> map) {
        super(context, mj.a());
        this.d = str;
        this.e = bArr;
        this.f = context;
        this.g = map;
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return this.d;
    }

    @Override // com.amap.api.col.stln3.tw, com.amap.api.col.stln3.ts
    public final Map<String, String> getParams() {
        Map<String, String> map = this.g;
        if (map == null) {
            return super.getParams();
        }
        return map;
    }

    @Override // com.amap.api.col.stln3.ts
    public final byte[] a() {
        return this.e;
    }

    @Override // com.amap.api.col.stln3.tw
    public final Map<String, String> getRequestHead() {
        return null;
    }

    @Override // com.amap.api.col.stln3.ts
    public final byte[] d() {
        return null;
    }
}
