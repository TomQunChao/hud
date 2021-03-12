package com.amap.api.col.stln3;

import android.content.Context;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: LocNetManager */
public final class vp {
    private static vp b = null;
    tr a = null;
    private Context c = null;
    private int d = 0;
    private int e = vu.f;
    private boolean f = false;
    private int g = 0;

    private vp(Context context) {
        try {
            rf.a().a(context);
        } catch (Throwable th) {
        }
        this.c = context;
        this.a = tr.a();
    }

    public static vp a(Context context) {
        if (b == null) {
            b = new vp(context);
        }
        return b;
    }

    public final void a(long j, boolean z, int i) {
        try {
            this.f = z;
            try {
                rf.a().a(z);
            } catch (Throwable th) {
            }
            this.e = Long.valueOf(j).intValue();
            this.g = i;
        } catch (Throwable th2) {
            vu.a(th2, "LocNetManager", "setOption");
        }
    }

    public final vq a(Context context, byte[] bArr, String str, boolean z) {
        try {
            HashMap hashMap = new HashMap(16);
            vq vqVar = new vq(context, vu.b());
            try {
                hashMap.put("Content-Type", "application/octet-stream");
                hashMap.put("Accept-Encoding", "gzip");
                hashMap.put("gzipped", "1");
                hashMap.put("Connection", "Keep-Alive");
                hashMap.put("User-Agent", "AMAP_Location_SDK_Android 4.5.0");
                hashMap.put("KEY", qy.f(context));
                hashMap.put("enginever", "4.9");
                String a2 = rb.a();
                String a3 = rb.a(context, a2, "key=" + qy.f(context));
                hashMap.put("ts", a2);
                hashMap.put("scode", a3);
                hashMap.put("encr", "1");
                vqVar.d = hashMap;
                String str2 = "loc";
                if (!z) {
                    str2 = "locf";
                }
                vqVar.m = true;
                vqVar.k = String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "4.5.0", str2, 3);
                vqVar.j = z;
                vqVar.e = str;
                vqVar.f = wc.a(bArr);
                vqVar.setProxy(rh.a(context));
                HashMap hashMap2 = new HashMap(16);
                hashMap2.put("output", "bin");
                hashMap2.put("policy", "3103");
                switch (this.g) {
                    case 0:
                        hashMap2.remove("custom");
                        break;
                    case 1:
                        hashMap2.put("custom", "language:cn");
                        break;
                    case 2:
                        hashMap2.put("custom", "language:en");
                        break;
                    default:
                        hashMap2.remove("custom");
                        break;
                }
                vqVar.l = hashMap2;
                vqVar.setConnectionTimeout(this.e);
                vqVar.setSoTimeout(this.e);
                if (!this.f) {
                    if (!wc.j(context)) {
                        return vqVar;
                    }
                }
                if (!str.startsWith("http:")) {
                    return vqVar;
                }
                vqVar.e = vqVar.getURL().replace("https:", "https:");
                return vqVar;
            } catch (Throwable th) {
                return vqVar;
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    public final ty a(vq vqVar) throws Throwable {
        long b2 = wc.b();
        boolean z = this.f || wc.j(this.c);
        tr trVar = this.a;
        ty a2 = tr.a(vqVar, z);
        this.d = Long.valueOf(wc.b() - b2).intValue();
        return a2;
    }

    public final String a(Context context, double d2, double d3) {
        byte[] bArr;
        try {
            HashMap hashMap = new HashMap(16);
            vq vqVar = new vq(context, vu.b());
            hashMap.clear();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Connection", "Keep-Alive");
            hashMap.put("User-Agent", "AMAP_Location_SDK_Android 4.5.0");
            HashMap hashMap2 = new HashMap(16);
            hashMap2.put("custom", "26260A1F00020002");
            hashMap2.put("key", qy.f(context));
            switch (this.g) {
                case 0:
                    hashMap2.remove("language");
                    break;
                case 1:
                    hashMap2.put("language", "zh-CN");
                    break;
                case 2:
                    hashMap2.put("language", "en");
                    break;
                default:
                    hashMap2.remove("language");
                    break;
            }
            String a2 = rb.a();
            String a3 = rb.a(context, a2, rk.b(hashMap2));
            hashMap2.put("ts", a2);
            hashMap2.put("scode", a3);
            vqVar.b(("output=json&radius=1000&extensions=all&location=" + d3 + "," + d2).getBytes("UTF-8"));
            vqVar.m = false;
            vqVar.j = true;
            vqVar.k = String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "4.5.0", "loc", 3);
            vqVar.l = hashMap2;
            vqVar.d = hashMap;
            vqVar.setProxy(rh.a(context));
            vqVar.setConnectionTimeout(vu.f);
            vqVar.setSoTimeout(vu.f);
            try {
                if (wc.j(context)) {
                    vqVar.e = "http://restapi.amap.com/v3/geocode/regeo".replace("http:", "https:");
                    tr trVar = this.a;
                    bArr = tr.a(vqVar);
                } else {
                    vqVar.e = "http://restapi.amap.com/v3/geocode/regeo";
                    bArr = this.a.b(vqVar);
                }
                return new String(bArr, "utf-8");
            } catch (Throwable th) {
                vu.a(th, "LocNetManager", "post");
                return null;
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    public final int a() {
        return this.d;
    }
}
