package com.amap.api.col.stln3;

import android.content.Context;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BaseRequest */
public abstract class qf extends tw {
    public static final String CIPHER_FLAG = "1";
    public static final int GET_METHOD = 0;
    public static final String NON_CIPHER_FLAG = "0";
    public static final int POST_METHOD = 1;
    private int d;
    private Context e;

    public abstract Map<String, String> getRequestParams();

    /* access modifiers changed from: protected */
    public abstract int getUrl();

    private boolean a() {
        return this.d == 0;
    }

    public boolean isOutputCipher() {
        return false;
    }

    public void setProtocolType(int i) {
        this.d = i;
    }

    public void setContext(Context context) {
        this.e = context;
    }

    public int getMethod() {
        return 1;
    }

    @Override // com.amap.api.col.stln3.tw
    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", a() ? "application/octet-stream" : "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Track AMAP_TRACK_Android_1.0.0");
        Context context = this.e;
        qv.a();
        hashMap.put("X-INFO", rb.c(context));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "1.0.0", "track"));
        hashMap.put("logversion", "2.1");
        hashMap.put("ciphertext", a() ? "1" : "0");
        return hashMap;
    }

    @Override // com.amap.api.col.stln3.tw
    public byte[] getEntityBytes() {
        Uri.Builder builder = new Uri.Builder();
        Map<String, String> requestParams = getRequestParams();
        if (requestParams == null) {
            return super.getEntityBytes();
        }
        try {
            for (String str : requestParams.keySet()) {
                builder.appendQueryParameter(str, requestParams.get(str));
            }
            String encodedQuery = builder.build().getEncodedQuery();
            if (!a() || this.d != 0) {
                return rk.a(encodedQuery);
            }
            return ql.c(this.e, encodedQuery);
        } catch (Throwable th) {
            return super.getEntityBytes();
        }
    }

    @Override // com.amap.api.col.stln3.tw
    public Map<String, String> getParams() {
        HashMap hashMap = new HashMap();
        if (getMethod() == 0) {
            hashMap.putAll(getRequestParams());
        }
        hashMap.put("key", qy.f(this.e));
        if (isOutputCipher()) {
            hashMap.put("output", "enc");
        }
        String b = rk.b(hashMap);
        String a = rb.a();
        hashMap.put("scode", rb.a(this.e, a, b));
        hashMap.put("ts", a);
        return hashMap;
    }

    @Override // com.amap.api.col.stln3.tw
    public String getURL() {
        return qg.a(this.d, getUrl()).toString();
    }
}
