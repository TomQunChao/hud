package com.amap.api.col.stln3;

import android.text.TextUtils;
import com.alibaba.idst.nls.internal.connector.NetDefine;
import java.net.Proxy;
import java.util.Map;

/* compiled from: Request */
public abstract class tw {
    int a = NetDefine.HTTP_READ_TIMEOUT;
    int b = NetDefine.HTTP_READ_TIMEOUT;
    Proxy c = null;

    public abstract Map<String, String> getParams();

    public abstract Map<String, String> getRequestHead();

    public abstract String getURL();

    /* access modifiers changed from: package-private */
    public String b() {
        byte[] entityBytes = getEntityBytes();
        if (entityBytes == null || entityBytes.length == 0) {
            return getURL();
        }
        Map<String, String> params = getParams();
        if (params == null) {
            return getURL();
        }
        String a2 = tu.a(params);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getURL());
        stringBuffer.append("?");
        stringBuffer.append(a2);
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    public String getIPDNSName() {
        return "";
    }

    /* access modifiers changed from: protected */
    public boolean isIPRequest() {
        return !TextUtils.isEmpty(getIPDNSName());
    }

    public boolean isIgnoreGZip() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public byte[] c() {
        byte[] entityBytes = getEntityBytes();
        if (entityBytes != null && entityBytes.length != 0) {
            return entityBytes;
        }
        String a2 = tu.a(getParams());
        if (!TextUtils.isEmpty(a2)) {
            return rk.a(a2);
        }
        return entityBytes;
    }

    public final void setConnectionTimeout(int i) {
        this.a = i;
    }

    public final void setSoTimeout(int i) {
        this.b = i;
    }

    public byte[] getEntityBytes() {
        return null;
    }

    public final void setProxy(Proxy proxy) {
        this.c = proxy;
    }
}
