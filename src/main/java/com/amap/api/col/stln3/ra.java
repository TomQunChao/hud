package com.amap.api.col.stln3;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* compiled from: AuthManager */
public final class ra {
    public static int a = -1;
    public static String b = "";
    private static rj c;
    private static String d = "http://apiinit.amap.com/v3/log/init";
    private static String e = null;

    private static boolean b(Context context, rj rjVar) {
        c = rjVar;
        try {
            String str = d;
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Accept-Encoding", "gzip");
            hashMap.put("Connection", "Keep-Alive");
            hashMap.put("User-Agent", c.d());
            hashMap.put("X-INFO", rb.b(context));
            hashMap.put("logversion", "2.1");
            hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", c.b(), c.a()));
            tr a2 = tr.a();
            rl rlVar = new rl();
            rlVar.setProxy(rh.a(context));
            rlVar.a(hashMap);
            rlVar.b(a(context));
            rlVar.a(str);
            return a(a2.b(rlVar));
        } catch (Throwable th) {
            ru.a(th, "Auth", "getAuth");
            return true;
        }
    }

    @Deprecated
    public static synchronized boolean a(Context context, rj rjVar) {
        boolean b2;
        synchronized (ra.class) {
            b2 = b(context, rjVar);
        }
        return b2;
    }

    public static void a(String str) {
        qy.b(str);
    }

    private static boolean a(byte[] bArr) {
        if (bArr == null) {
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject(rk.a(bArr));
            if (jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
                int i = jSONObject.getInt(NotificationCompat.CATEGORY_STATUS);
                if (i == 1) {
                    a = 1;
                } else if (i == 0) {
                    a = 0;
                }
            }
            if (jSONObject.has("info")) {
                b = jSONObject.getString("info");
            }
            if (a == 0) {
                String str = b;
            }
            if (a == 1) {
                return true;
            }
            return false;
        } catch (JSONException e2) {
            ru.a(e2, "Auth", "lData");
            return false;
        } catch (Throwable th) {
            ru.a(th, "Auth", "lData");
            return false;
        }
    }

    private static Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("resType", "json");
            hashMap.put("encode", "UTF-8");
            String a2 = rb.a();
            hashMap.put("ts", a2);
            hashMap.put("key", qy.f(context));
            hashMap.put("scode", rb.a(context, a2, rk.d("resType=json&encode=UTF-8&key=" + qy.f(context))));
        } catch (Throwable th) {
            ru.a(th, "Auth", "gParams");
        }
        return hashMap;
    }
}
