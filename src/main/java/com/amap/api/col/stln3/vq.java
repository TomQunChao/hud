package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

/* compiled from: LocationRequest */
public final class vq extends ts {
    Map<String, String> d = null;
    String e = "";
    byte[] f = null;
    byte[] g = null;
    boolean j = false;
    String k = null;
    Map<String, String> l = null;
    boolean m = false;
    private String n = "";

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003b A[SYNTHETIC, Splitter:B:24:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(byte[] r3) {
        /*
            r2 = this;
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Throwable -> 0x002c }
            r1.<init>()     // Catch:{ Throwable -> 0x002c }
            if (r3 == 0) goto L_0x0014
            byte[] r0 = a(r3)     // Catch:{ Throwable -> 0x0026, all -> 0x0024 }
            r1.write(r0)     // Catch:{ Throwable -> 0x0026, all -> 0x0024 }
            r1.write(r3)     // Catch:{ Throwable -> 0x0026, all -> 0x0024 }
            goto L_0x0015
        L_0x0014:
        L_0x0015:
            byte[] r3 = r1.toByteArray()     // Catch:{ Throwable -> 0x0026, all -> 0x0024 }
            r2.g = r3     // Catch:{ Throwable -> 0x0026, all -> 0x0024 }
            r1.close()     // Catch:{ IOException -> 0x001f }
            return
        L_0x001f:
            r3 = move-exception
            r3.printStackTrace()
            return
        L_0x0024:
            r3 = move-exception
            goto L_0x0038
        L_0x0026:
            r3 = move-exception
            r0 = r1
            goto L_0x002d
        L_0x0029:
            r3 = move-exception
            r1 = r0
            goto L_0x0038
        L_0x002c:
            r3 = move-exception
        L_0x002d:
            r3.printStackTrace()     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0036
            r0.close()
            goto L_0x0037
        L_0x0036:
        L_0x0037:
            return
        L_0x0038:
            if (r1 == 0) goto L_0x0044
            r1.close()     // Catch:{ IOException -> 0x003f }
            goto L_0x0045
        L_0x003f:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0046
        L_0x0044:
        L_0x0045:
        L_0x0046:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.vq.b(byte[]):void");
    }

    @Override // com.amap.api.col.stln3.tw, com.amap.api.col.stln3.ts
    public final Map<String, String> getParams() {
        return this.l;
    }

    @Override // com.amap.api.col.stln3.ts
    public final boolean g() {
        return this.j;
    }

    public vq(Context context, rj rjVar) {
        super(context, rjVar);
    }

    @Override // com.amap.api.col.stln3.ts
    public final byte[] d() {
        return this.f;
    }

    @Override // com.amap.api.col.stln3.tw
    public final Map<String, String> getRequestHead() {
        return this.d;
    }

    @Override // com.amap.api.col.stln3.ts
    public final byte[] a() {
        return this.g;
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return this.e;
    }

    @Override // com.amap.api.col.stln3.ts
    public final String h() {
        return this.k;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.ts
    public final boolean i() {
        return this.m;
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.n = str;
        } else {
            this.n = "";
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.tw
    public final String getIPDNSName() {
        return this.n;
    }
}
