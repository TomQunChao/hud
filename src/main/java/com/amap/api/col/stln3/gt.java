package com.amap.api.col.stln3;

import android.content.Context;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: CustomStyleTextureRequest */
public final class gt extends pg<String, a> {

    /* compiled from: CustomStyleTextureRequest */
    public static class a {
        public byte[] a;
        public int b = -1;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.pg
    public final /* bridge */ /* synthetic */ a a(String str) throws pf {
        return null;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.pg
    public final /* synthetic */ a a(byte[] bArr) throws pf {
        a aVar = new a();
        aVar.a = bArr;
        return aVar;
    }

    public final void b(String str) {
        this.g = str;
    }

    public gt(Context context, String str) {
        super(context, str);
        this.g = "/map/styles";
    }

    @Override // com.amap.api.col.stln3.tw, com.amap.api.col.stln3.hb
    public final Map<String, String> getRequestHead() {
        String str;
        rj f = ic.f();
        if (f != null) {
            str = f.b();
        } else {
            str = null;
        }
        HashMap hashMap = new HashMap(16);
        hashMap.put("User-Agent", ch.c);
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", str, "3dmap"));
        hashMap.put("x-INFO", rb.a(this.f));
        hashMap.put("key", qy.f(this.f));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.stln3.tw, com.amap.api.col.stln3.hb
    public final Map<String, String> getParams() {
        HashMap hashMap = new HashMap(16);
        hashMap.put("key", qy.f(this.f));
        hashMap.put("output", "bin");
        String a2 = rb.a();
        String a3 = rb.a(this.f, a2, rk.b(hashMap));
        hashMap.put("ts", a2);
        hashMap.put("scode", a3);
        return hashMap;
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return this.g;
    }
}
