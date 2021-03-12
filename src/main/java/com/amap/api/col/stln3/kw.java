package com.amap.api.col.stln3;

import android.content.Context;
import com.alibaba.idst.nls.internal.connector.NetDefine;
import com.amap.api.services.core.AMapException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BaseBatchHandler */
public abstract class kw<T, V> extends tw {
    protected T d;
    protected int e = 1;
    protected String f = "";
    protected Context g;

    /* access modifiers changed from: protected */
    public abstract V a(String str) throws kv;

    public kw(Context context, T t) {
        this.g = context;
        this.d = t;
        this.e = 1;
        setSoTimeout(NetDefine.HTTP_READ_TIMEOUT);
        setConnectionTimeout(NetDefine.HTTP_READ_TIMEOUT);
    }

    private V a(byte[] bArr) throws kv {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e2) {
            str = null;
        }
        if (str == null || "".equals(str)) {
            return null;
        }
        c(str);
        return a(str);
    }

    private static void c(String str) throws kv {
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() != 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject.has("body")) {
                        int i2 = jSONObject.getJSONObject("body").getInt("infocode");
                        if (i2 != 10000) {
                            la.a(i2);
                        }
                    }
                }
                return;
            }
            throw new kv(AMapException.AMAP_ENGINE_RESPONSE_DATA_ERROR);
        } catch (JSONException e2) {
            throw new kv("协议解析错误 - ProtocolException");
        }
    }

    public final V a() throws kv {
        if (this.d != null) {
            return d();
        }
        return null;
    }

    private V d() throws kv {
        byte[] bArr;
        int i = 0;
        V v = null;
        while (i < this.e) {
            try {
                setProxy(rh.a(this.g));
                ty a = jv.a(true, this);
                if (a != null) {
                    bArr = a.a;
                } else {
                    bArr = null;
                }
                v = a(bArr);
                i = this.e;
            } catch (qx e2) {
                i++;
                if (i < this.e) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e3) {
                        if (com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(e2.getMessage()) || com.amap.api.maps.AMapException.ERROR_SOCKET.equals(e2.getMessage()) || com.amap.api.maps.AMapException.ERROR_UNKNOW_SERVICE.equals(e2.getMessage())) {
                            throw new kv(AMapException.AMAP_CLIENT_NETWORK_EXCEPTION);
                        }
                        throw new kv(e2.a());
                    }
                } else if (com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(e2.getMessage()) || com.amap.api.maps.AMapException.ERROR_SOCKET.equals(e2.getMessage()) || com.amap.api.maps.AMapException.ERROR_UNKNOWN.equals(e2.a()) || com.amap.api.maps.AMapException.ERROR_UNKNOW_SERVICE.equals(e2.getMessage())) {
                    throw new kv(AMapException.AMAP_CLIENT_NETWORK_EXCEPTION);
                } else {
                    throw new kv(e2.a());
                }
            } catch (kv e4) {
                i++;
                if (i >= this.e) {
                    throw e4;
                }
            }
        }
        return v;
    }

    @Override // com.amap.api.col.stln3.tw
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.stln3.tw
    public Map<String, String> getRequestHead() {
        return null;
    }

    public static String b(String str) {
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

    private static String d(String str) {
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
