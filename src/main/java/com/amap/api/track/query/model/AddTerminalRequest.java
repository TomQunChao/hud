package com.amap.api.track.query.model;

import com.amap.api.col.stln3.qf;
import java.util.HashMap;

public final class AddTerminalRequest extends qf {
    private String d;
    private long e;

    public AddTerminalRequest(String str, long j) {
        this.d = str;
        this.e = j;
    }

    @Override // com.amap.api.col.stln3.qf
    public final int getUrl() {
        return 101;
    }

    @Override // com.amap.api.col.stln3.qf
    public final HashMap<String, String> getRequestParams() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name", this.d);
        StringBuilder sb = new StringBuilder();
        sb.append(this.e);
        hashMap.put("sid", sb.toString());
        return hashMap;
    }
}
