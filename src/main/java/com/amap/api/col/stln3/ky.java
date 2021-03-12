package com.amap.api.col.stln3;

import android.content.Context;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BaseLbsRestHandler */
public abstract class ky<T, V> extends kx<T, V> {
    /* access modifiers changed from: protected */
    public abstract String d();

    public ky(Context context, T t) {
        super(context, t);
    }

    @Override // com.amap.api.col.stln3.tw
    public byte[] getEntityBytes() {
        try {
            String d = d();
            String[] split = d.split("&");
            Arrays.sort(split);
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : split) {
                stringBuffer.append(c(str));
                stringBuffer.append("&");
            }
            String stringBuffer2 = stringBuffer.toString();
            String str2 = stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : d;
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(d);
            String a = rb.a();
            stringBuffer3.append("&ts=" + a);
            stringBuffer3.append("&scode=" + rb.a(this.g, a, str2));
            return stringBuffer3.toString().getBytes("utf-8");
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // com.amap.api.col.stln3.tw, com.amap.api.col.stln3.kx
    public Map<String, String> getParams() {
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.HashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.stln3.tw, com.amap.api.col.stln3.kx
    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP_SDK_Android_NAVI_6.5.0");
        hashMap.put("X-INFO", rb.b(this.g));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "6.5.0", "navi"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    protected static String b(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Throwable th) {
            return "";
        }
    }

    private static String c(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (Throwable th) {
            return "";
        }
    }
}
