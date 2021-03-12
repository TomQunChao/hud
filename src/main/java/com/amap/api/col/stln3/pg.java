package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.maps.AMapException;

/* compiled from: AbstractBasicHandler */
public abstract class pg<T, V> extends hb {
    protected T d;
    protected int e = 1;
    protected Context f;
    protected String g;

    /* access modifiers changed from: protected */
    public abstract V a(String str) throws pf;

    public pg(Context context, T t) {
        this.f = context;
        this.d = t;
        this.e = 1;
        setSoTimeout(30000);
        setConnectionTimeout(30000);
    }

    /* access modifiers changed from: protected */
    public V a(byte[] bArr) throws pf {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            str = null;
        }
        if (str == null || "".equals(str)) {
            return null;
        }
        String str2 = this.g;
        pi.a(str);
        return a(str);
    }

    public final V a() throws pf {
        if (this.d != null) {
            return d();
        }
        return null;
    }

    private V d() throws pf {
        V v = null;
        int i = 0;
        while (i < this.e) {
            try {
                setProxy(rh.a(this.f));
                v = a(makeHttpRequest());
                i = this.e;
            } catch (qx e2) {
                i++;
                if (i < this.e) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e3) {
                        if (AMapException.ERROR_CONNECTION.equals(e2.getMessage()) || AMapException.ERROR_SOCKET.equals(e2.getMessage()) || AMapException.ERROR_UNKNOW_SERVICE.equals(e2.getMessage())) {
                            throw new pf(com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION);
                        }
                        throw new pf(e2.a());
                    }
                } else if (AMapException.ERROR_CONNECTION.equals(e2.getMessage()) || AMapException.ERROR_SOCKET.equals(e2.getMessage()) || AMapException.ERROR_UNKNOWN.equals(e2.a()) || AMapException.ERROR_UNKNOW_SERVICE.equals(e2.getMessage())) {
                    throw new pf(com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION);
                } else {
                    throw new pf(e2.a());
                }
            } catch (pf e4) {
                i++;
                if (i >= this.e) {
                    throw new pf(e4.a());
                }
            } catch (Throwable th) {
                throw new pf(com.amap.api.services.core.AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
            }
        }
        return v;
    }
}
