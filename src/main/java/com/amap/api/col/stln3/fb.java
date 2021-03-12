package com.amap.api.col.stln3;

import java.util.Hashtable;
import java.util.Map;

/* compiled from: OfflineDownloadRequest */
public final class fb extends hb {
    private String d;

    public fb(String str) {
        this.d = str;
    }

    @Override // com.amap.api.col.stln3.tw, com.amap.api.col.stln3.hb
    public final Map<String, String> getRequestHead() {
        Hashtable hashtable = new Hashtable(32);
        hashtable.put("User-Agent", "MAC=channel:amapapi");
        return hashtable;
    }

    @Override // com.amap.api.col.stln3.tw, com.amap.api.col.stln3.hb
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return this.d;
    }
}
