package com.amap.api.col.stln3;

import android.content.Context;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: WalkTbtTask */
public final class kc extends ju {
    private js p;

    public kc(js jsVar, Context context, String str, int i, String str2, int i2, int i3, byte[] bArr) {
        super(context, str, i, str2, i2, i3, bArr);
        this.p = jsVar;
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
            hashMap2.put("output", "binary");
            hashMap2.put("enginever", "3.1");
            hashMap2.put("key", qy.f(this.i));
            String a = rb.a();
            String a2 = rb.a(this.i, a, rk.b(hashMap2));
            hashMap2.put("ts", a);
            hashMap2.put("scode", a2);
            ty a3 = a(new jt(this.i, "http://restapi.amap.com/v3/direction/walking", null, hashMap, hashMap2));
            int a4 = jy.a("http://restapi.amap.com/v3/direction/walking", a3);
            if (a4 < 0) {
                a4 = 1;
            }
            try {
                if (this.p != null && this.p.f() != null) {
                    if (a4 == 1) {
                        this.p.f().receiveNetData(this.f, this.g, a3.a, a3.a.length);
                        this.p.f().setNetRequestState(this.f, this.g, a4);
                        return;
                    }
                    this.p.f().setNetRequestState(this.f, this.g, 4);
                    this.p.a().setRouteRequestState(a4);
                    return;
                }
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            return;
        }
        throw th;
    }
}
