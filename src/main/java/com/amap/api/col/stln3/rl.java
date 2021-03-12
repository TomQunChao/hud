package com.amap.api.col.stln3;

import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
@Deprecated
/* compiled from: AuthRequest */
public final class rl extends tw {
    private Map<String, String> d = new HashMap();
    private String e;
    private Map<String, String> f = new HashMap();

    rl() {
    }

    /* access modifiers changed from: package-private */
    public final void a(Map<String, String> map) {
        this.d.clear();
        this.d.putAll(map);
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        this.e = str;
    }

    /* access modifiers changed from: package-private */
    public final void b(Map<String, String> map) {
        this.f.clear();
        this.f.putAll(map);
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return this.e;
    }

    @Override // com.amap.api.col.stln3.tw
    public final Map<String, String> getRequestHead() {
        return this.d;
    }

    @Override // com.amap.api.col.stln3.tw
    public final Map<String, String> getParams() {
        return this.f;
    }
}
