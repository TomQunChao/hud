package com.amap.api.col.stln3;

import java.util.Map;

/* compiled from: HttpRequest */
public final class vo extends tw {
    Map<String, String> d = null;
    Map<String, String> e = null;
    String f = "";
    byte[] g = null;

    public final void a(Map<String, String> map) {
        this.d = map;
    }

    public final void b(Map<String, String> map) {
        this.e = map;
    }

    @Override // com.amap.api.col.stln3.tw
    public final Map<String, String> getRequestHead() {
        return this.d;
    }

    @Override // com.amap.api.col.stln3.tw
    public final Map<String, String> getParams() {
        return this.e;
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return this.f;
    }

    public final void a(String str) {
        this.f = str;
    }

    @Override // com.amap.api.col.stln3.tw
    public final byte[] getEntityBytes() {
        return this.g;
    }
}
