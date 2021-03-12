package com.amap.api.services.core;

import com.alibaba.idst.nls.internal.connector.NetDefine;
import com.amap.api.col.stln3.nl;
import com.amap.api.col.stln3.ok;
import com.amap.api.col.stln3.ra;
import com.amap.api.col.stln3.rf;

public class ServiceSettings {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";
    public static final int HTTP = 1;
    public static final int HTTPS = 2;
    private static ServiceSettings c;
    private String a = "zh-CN";
    private int b = 1;
    private int d = NetDefine.HTTP_READ_TIMEOUT;
    private int e = NetDefine.HTTP_READ_TIMEOUT;

    public int getConnectionTimeOut() {
        return this.d;
    }

    public int getSoTimeOut() {
        return this.e;
    }

    public void setConnectionTimeOut(int i) {
        if (i < 5000) {
            this.d = 5000;
        } else if (i > 30000) {
            this.d = 30000;
        } else {
            this.d = i;
        }
    }

    public void setSoTimeOut(int i) {
        if (i < 5000) {
            this.e = 5000;
        } else if (i > 30000) {
            this.e = 30000;
        } else {
            this.e = i;
        }
    }

    private ServiceSettings() {
    }

    public static ServiceSettings getInstance() {
        if (c == null) {
            c = new ServiceSettings();
        }
        return c;
    }

    public void setLanguage(String str) {
        if ("en".equals(str) || "zh-CN".equals(str)) {
            this.a = str;
        }
    }

    public void setProtocol(int i) {
        this.b = i;
        rf.a().a(this.b == 2);
    }

    public String getLanguage() {
        return this.a;
    }

    public int getProtocol() {
        return this.b;
    }

    public void setApiKey(String str) {
        ra.a(str);
    }

    public void destroyInnerAsynThreadPool() {
        try {
            ok.b();
        } catch (Throwable th) {
            nl.a(th, "ServiceSettings", "destroyInnerAsynThreadPool");
        }
    }
}
