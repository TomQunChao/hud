package com.amap.api.col.stln3;

import java.util.Map;

/* compiled from: SoDownloadRequest */
public final class td extends tw {
    private ta d;

    public td(ta taVar) {
        this.d = taVar;
    }

    @Override // com.amap.api.col.stln3.tw
    public final Map<String, String> getRequestHead() {
        return null;
    }

    @Override // com.amap.api.col.stln3.tw
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        ta taVar = this.d;
        if (taVar == null) {
            return "";
        }
        return taVar.a();
    }
}
