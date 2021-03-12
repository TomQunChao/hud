package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.services.core.ServiceSettings;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BasicLBSRestHandler */
public abstract class nd<T, V> extends nc<T, V> {
    /* access modifiers changed from: protected */
    public abstract String d();

    public nd(Context context, T t) {
        super(context, t);
    }

    @Override // com.amap.api.col.stln3.tw
    public byte[] getEntityBytes() {
        try {
            StringBuffer stringBuffer = new StringBuffer(d());
            stringBuffer.append("&language=");
            stringBuffer.append(ServiceSettings.getInstance().getLanguage());
            String stringBuffer2 = stringBuffer.toString();
            String c = c(stringBuffer2);
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(stringBuffer2);
            String a = rb.a();
            stringBuffer3.append("&ts=" + a);
            stringBuffer3.append("&scode=" + rb.a(this.g, a, c));
            return stringBuffer3.toString().getBytes("utf-8");
        } catch (Throwable th) {
            nl.a(th, "ProtocalHandler", "getEntity");
            return null;
        }
    }

    @Override // com.amap.api.col.stln3.nc, com.amap.api.col.stln3.tw
    public Map<String, String> getParams() {
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.HashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.stln3.nc, com.amap.api.col.stln3.tw
    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Search 6.5.0");
        hashMap.put("X-INFO", rb.b(this.g));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "6.5.0", "sea"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    private static String c(String str) {
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(d(str2));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2.length() > 1) {
            return (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
        }
        return str;
    }

    protected static String b(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            nl.a(e, "ProtocalHandler", "strEncoderUnsupportedEncodingException");
            return "";
        } catch (Exception e2) {
            nl.a(e2, "ProtocalHandler", "strEncoderException");
            return "";
        }
    }

    private static String d(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            nl.a(e, "ProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e2) {
            nl.a(e2, "ProtocalHandler", "strReEncoderException");
            return "";
        }
    }
}
