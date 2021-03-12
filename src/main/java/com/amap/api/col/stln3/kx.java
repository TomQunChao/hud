package com.amap.api.col.stln3;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import com.alibaba.idst.nls.internal.connector.NetDefine;
import com.amap.api.services.core.AMapException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BaseHandler */
public abstract class kx<T, V> extends tw {
    protected T d;
    protected int e = 1;
    protected String f = "";
    protected Context g;

    /* access modifiers changed from: protected */
    public abstract V a(String str) throws kv;

    public kx(Context context, T t) {
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
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
                String string = jSONObject.getString(NotificationCompat.CATEGORY_STATUS);
                if (!"1".equals(string)) {
                    if ("0".equals(string)) {
                        if (!jSONObject.has("infocode")) {
                            throw new kv(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
                        }
                    }
                    int i = jSONObject.getInt("infocode");
                    if ("0".equals(string)) {
                        la.a(i);
                    }
                }
            }
            return a(str);
        } catch (JSONException e3) {
            la.a(e3, "CoreUtil", "paseAuthFailurJson");
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
                    throw new kv(e4.a());
                }
            } catch (Throwable th) {
                throw new kv(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
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
}
