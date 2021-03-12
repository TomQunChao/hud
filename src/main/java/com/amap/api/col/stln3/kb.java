package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: TtsStatisticsTask */
public final class kb implements Runnable {
    String a = "errcode";
    private final String b = "http://restapi.amap.com";
    private String c = "http://restapi.amap.com/v4/stats/alitts";
    private Context d;
    private int e;
    private jx f;

    public kb(Context context, int i, jx jxVar) {
        this.d = context;
        this.e = i;
        this.f = jxVar;
    }

    public final void run() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("key", qy.f(this.d));
            hashMap.put("basecount", String.valueOf(this.e));
            String a2 = rb.a();
            String a3 = rb.a(this.d, a2, rk.b(hashMap));
            hashMap.put("ts", a2);
            hashMap.put("scode", a3);
            byte[] bArr = null;
            jw jwVar = new jw(this.d, this.c, null, hashMap);
            jwVar.setProxy(rh.a(this.d));
            jwVar.setConnectionTimeout(AMapException.CODE_AMAP_SERVICE_TABLEID_NOT_EXIST);
            jwVar.setSoTimeout(AMapException.CODE_AMAP_SERVICE_TABLEID_NOT_EXIST);
            ty a4 = jv.a(true, jwVar);
            if (a4 != null) {
                bArr = a4.a;
            }
            JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
            int i = 0;
            if (jSONObject.has(this.a)) {
                i = jSONObject.getInt(this.a);
            }
            this.f.a(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
