package com.amap.api.col.stln3;

import android.content.Context;
import java.util.Map;

/* compiled from: LocationRequest */
public final class ww extends ts {
    Map<String, String> d = null;
    String e = "";
    byte[] f = null;
    byte[] g = null;
    boolean j = false;
    String k = null;
    Map<String, String> l = null;
    boolean m = false;

    public ww(Context context, rj rjVar) {
        super(context, rjVar);
    }

    @Override // com.amap.api.col.stln3.ts
    public final byte[] a() {
        return this.g;
    }

    @Override // com.amap.api.col.stln3.ts
    public final byte[] d() {
        return this.f;
    }

    @Override // com.amap.api.col.stln3.ts
    public final boolean g() {
        return this.j;
    }

    @Override // com.amap.api.col.stln3.tw, com.amap.api.col.stln3.ts
    public final Map<String, String> getParams() {
        return this.l;
    }

    @Override // com.amap.api.col.stln3.tw
    public final Map<String, String> getRequestHead() {
        return this.d;
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return this.e;
    }

    @Override // com.amap.api.col.stln3.ts
    public final String h() {
        return this.k;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.ts
    public final boolean i() {
        return this.m;
    }
}
