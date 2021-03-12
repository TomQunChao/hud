package com.amap.api.col.stln3;

import android.content.Context;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: AbstractBasicLbsRestHandler */
public abstract class ph<T, V> extends pg<T, V> {
    /* access modifiers changed from: protected */
    public abstract String d();

    public ph(Context context, T t) {
        super(context, t);
    }

    @Override // com.amap.api.col.stln3.tw
    public byte[] getEntityBytes() {
        try {
            return d().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.stln3.tw, com.amap.api.col.stln3.hb
    public Map<String, String> getParams() {
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.HashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.stln3.tw, com.amap.api.col.stln3.hb
    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap(16);
        hashMap.put("Content-Type", " application/json");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Trace 6.6.0");
        hashMap.put("x-INFO", rb.b(this.f));
        hashMap.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", "6.6.0", "trace"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }
}
