package com.amap.api.track.query.model;

import com.amap.api.col.stln3.qf;
import java.util.HashMap;
import java.util.Map;

public final class QueryTerminalRequest extends qf {
    private long d;
    private String e;

    public QueryTerminalRequest(long j, String str) {
        this.d = j;
        this.e = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.qf
    public final int getUrl() {
        return 304;
    }

    @Override // com.amap.api.col.stln3.qf
    public final Map<String, String> getRequestParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", this.e);
        StringBuilder sb = new StringBuilder();
        sb.append(this.d);
        hashMap.put("sid", sb.toString());
        return hashMap;
    }

    @Override // com.amap.api.col.stln3.qf
    public final int getMethod() {
        return 0;
    }
}
