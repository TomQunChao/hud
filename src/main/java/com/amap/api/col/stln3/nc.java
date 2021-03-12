package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import java.util.Map;

/* compiled from: BasicHandler */
public abstract class nc<T, V> extends tw {
    protected T d;
    protected int e = 1;
    protected String f = "";
    protected Context g;
    protected String h = "";
    private int i = 1;

    /* access modifiers changed from: protected */
    public abstract V a(String str) throws AMapException;

    public nc(Context context, T t) {
        this.g = context;
        this.d = t;
        this.e = 1;
        setSoTimeout(ServiceSettings.getInstance().getSoTimeOut());
        setConnectionTimeout(ServiceSettings.getInstance().getConnectionTimeOut());
    }

    private String d() {
        String url = getURL();
        if (url == null) {
            return null;
        }
        try {
            int indexOf = url.indexOf(".com/");
            int indexOf2 = url.indexOf("?");
            if (indexOf2 == -1) {
                return url.substring(indexOf + ".com/".length());
            }
            return url.substring(indexOf + ".com/".length(), indexOf2);
        } catch (Throwable th) {
            return null;
        }
    }

    private V a(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e2) {
            nl.a(e2, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        nl.b(str);
        return a(str);
    }

    public final V a() throws AMapException {
        String str;
        if (this.d == null) {
            return null;
        }
        try {
            return e();
        } catch (AMapException e2) {
            String d2 = d();
            String str2 = this.h;
            if (d2 != null) {
                String errorType = e2.getErrorType();
                if (e2.getErrorLevel() == 0) {
                    int errorCode = e2.getErrorCode();
                    if (errorCode == 0) {
                        str = "4";
                    } else {
                        int pow = (int) Math.pow(10.0d, Math.floor(Math.log10((double) errorCode)));
                        int i2 = (errorCode % pow) + (pow * 4);
                        StringBuilder sb = new StringBuilder();
                        sb.append(i2);
                        str = sb.toString();
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(e2.getErrorCode());
                    str = sb2.toString();
                }
                if (str != null && str.length() > 0) {
                    rx.a(nk.a(true), d2, errorType, str2, str);
                }
            }
            throw e2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x010b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x010c, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0116, code lost:
        throw new com.amap.api.services.core.AMapException(com.amap.api.services.core.AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0117, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0118, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x010b A[ExcHandler: Throwable (r0v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private V e() throws com.amap.api.services.core.AMapException {
        /*
        // Method dump skipped, instructions count: 281
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.nc.e():java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public byte[] a(int i2, tw twVar) throws qx {
        ty tyVar;
        if (i2 == 1) {
            tyVar = tv.a(twVar, false);
        } else if (i2 == 2) {
            tyVar = tv.a(twVar, true);
        } else {
            tyVar = null;
        }
        if (tyVar == null) {
            return null;
        }
        byte[] bArr = tyVar.a;
        this.h = tyVar.d;
        return bArr;
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
