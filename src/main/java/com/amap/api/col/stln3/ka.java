package com.amap.api.col.stln3;

import android.content.Context;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: RideTbtTask */
public final class ka extends ju {
    private jr p;

    public ka(jr jrVar, Context context, String str, int i, String str2, int i2, int i3, byte[] bArr) {
        super(context, str, i, str2, i2, i3, bArr);
        this.p = jrVar;
    }

    @Override // com.amap.api.col.stln3.ju
    public final void run() {
        try {
            HashMap hashMap = new HashMap();
            String b = rb.b(this.i);
            hashMap.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", "6.5.0", "navi"));
            hashMap.put("X-INFO", b);
            hashMap.put("logversion", "2.1");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("origin", this.l + "," + this.m);
            hashMap2.put("destination", this.n + "," + this.o);
            hashMap2.put("output", "bin");
            hashMap2.put("key", qy.f(this.i));
            hashMap2.put("enginever", "4.1");
            String a = rb.a();
            String a2 = rb.a(this.i, rb.a(), rk.b(hashMap2));
            hashMap2.put("ts", a);
            hashMap2.put("scode", a2);
            ty a3 = a(new jt(this.i, "http://restapi.amap.com/v4/direction/bicycling", null, hashMap, hashMap2));
            int b2 = jy.b("http://restapi.amap.com/v4/direction/bicycling", a3);
            if (b2 < 0) {
                b2 = 1;
            }
            try {
                if (this.p != null && this.p.e() != null) {
                    if (b2 == 1) {
                        this.p.e().receiveNetData(this.f, this.g, a3.a, a3.a.length);
                        this.p.e().setNetRequestState(this.f, this.g, b2);
                        return;
                    }
                    this.p.e().setNetRequestState(this.f, this.g, 4);
                    this.p.f().setRouteRequestState(b2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                if (!(this.p == null || this.p.e() == null)) {
                    this.p.e().setNetRequestState(this.f, this.g, 4);
                    this.p.f().setRouteRequestState(2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            throw th;
        }
    }
}
