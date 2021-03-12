package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.idst.nls.internal.protocol.NlsRequestProto;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AuthConfigManager */
public final class qz {
    public static int a = -1;
    public static String b = "";

    /* compiled from: AuthConfigManager */
    public static class a {
        @Deprecated
        public c A;
        public c B;
        public b C;
        public b D;
        public b E;
        public b F;
        public f G;
        public String a;
        public int b = -1;
        @Deprecated
        public JSONObject c;
        @Deprecated
        public JSONObject d;
        @Deprecated
        public JSONObject e;
        @Deprecated
        public JSONObject f;
        @Deprecated
        public JSONObject g;
        @Deprecated
        public JSONObject h;
        @Deprecated
        public JSONObject i;
        @Deprecated
        public JSONObject j;
        @Deprecated
        public JSONObject k;
        @Deprecated
        public JSONObject l;
        @Deprecated
        public JSONObject m;
        @Deprecated
        public JSONObject n;
        @Deprecated
        public JSONObject o;
        @Deprecated
        public JSONObject p;
        @Deprecated
        public JSONObject q;
        @Deprecated
        public JSONObject r;
        @Deprecated
        public JSONObject s;
        @Deprecated
        public JSONObject t;
        @Deprecated
        public JSONObject u;
        @Deprecated
        public JSONObject v;
        public JSONObject w;
        public C0001a x;
        public d y;
        public e z;

        /* renamed from: com.amap.api.col.stln3.qz$a$a  reason: collision with other inner class name */
        /* compiled from: AuthConfigManager */
        public static class C0001a {
            public boolean a;
            public boolean b;
            public JSONObject c;
        }

        /* compiled from: AuthConfigManager */
        public static class b {
            public boolean a;
            public String b;
            public String c;
            public String d;
            public boolean e;
        }

        /* compiled from: AuthConfigManager */
        public static class c {
            public String a;
            public String b;
        }

        /* compiled from: AuthConfigManager */
        public static class d {
            public String a;
            public String b;
            public String c;
        }

        /* compiled from: AuthConfigManager */
        public static class e {
            public boolean a;
        }

        /* compiled from: AuthConfigManager */
        public static class f {
            public boolean a;
            public boolean b;
            public boolean c;
            public String d;
            public String e;
            public String f;
        }
    }

    @Deprecated
    public static void a(String str) {
        qy.a(null, str);
    }

    public static void a(Context context, String str) {
        qy.a(context, str);
    }

    public static boolean a(String str, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return z;
            }
            String[] split = URLDecoder.decode(str).split("/");
            if (split[split.length - 1].charAt(4) % 2 == 1) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            return z;
        }
    }

    public static a a(Context context, rj rjVar, String str, Map<String, String> map) {
        return a(context, rjVar, str, map, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008f, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0090, code lost:
        r12 = null;
        r4 = r3;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009c, code lost:
        r12 = null;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009f, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a0, code lost:
        r12 = null;
        r4 = r3;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a3, code lost:
        r0.a = r4.a();
        com.amap.api.col.stln3.rx.a(r10, "/v3/iasdkauth", r4);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009b A[ExcHandler: IllegalBlockSizeException (e javax.crypto.IllegalBlockSizeException), PHI: r11 
      PHI: (r11v23 java.lang.String) = (r11v0 java.lang.String), (r11v0 java.lang.String), (r11v0 java.lang.String), (r11v25 java.lang.String) binds: [B:1:0x0016, B:2:?, B:3:0x001b, B:4:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x0016] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.amap.api.col.stln3.qz.a a(android.content.Context r9, com.amap.api.col.stln3.rj r10, java.lang.String r11, java.util.Map<java.lang.String, java.lang.String> r12, boolean r13) {
        /*
        // Method dump skipped, instructions count: 1002
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.qz.a(android.content.Context, com.amap.api.col.stln3.rj, java.lang.String, java.util.Map, boolean):com.amap.api.col.stln3.qz$a");
    }

    private static String a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str) && !jSONObject.getString(str).equals("[]")) {
            return jSONObject.optString(str);
        }
        return "";
    }

    private static void a(JSONObject jSONObject, a.b bVar) {
        if (bVar != null) {
            try {
                String a2 = a(jSONObject, "m");
                String a3 = a(jSONObject, "u");
                String a4 = a(jSONObject, "v");
                String a5 = a(jSONObject, "able");
                String a6 = a(jSONObject, "on");
                bVar.c = a2;
                bVar.b = a3;
                bVar.d = a4;
                bVar.a = a(a5, false);
                bVar.e = a(a6, true);
            } catch (Throwable th) {
                ru.a(th, "at", "pe");
            }
        }
    }

    private static void a(JSONObject jSONObject, a.c cVar) {
        if (jSONObject != null) {
            try {
                String a2 = a(jSONObject, "md5");
                String a3 = a(jSONObject, "url");
                cVar.b = a2;
                cVar.a = a3;
            } catch (Throwable th) {
                ru.a(th, "at", "psc");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: AuthConfigManager */
    public static class b extends ts {
        private String d;
        private Map<String, String> e;
        private boolean f;

        b(Context context, rj rjVar, String str, Map<String, String> map) {
            super(context, rjVar);
            this.d = str;
            this.e = map;
            this.f = Build.VERSION.SDK_INT != 19;
        }

        public final boolean e() {
            return this.f;
        }

        @Override // com.amap.api.col.stln3.tw
        public final Map<String, String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.col.stln3.tw
        public final String getURL() {
            return this.f ? "https://restapi.amap.com/v3/iasdkauth" : "http://restapi.amap.com/v3/iasdkauth";
        }

        @Override // com.amap.api.col.stln3.ts
        public final byte[] d() {
            return null;
        }

        @Override // com.amap.api.col.stln3.ts
        public final byte[] a() {
            String v = rd.v(this.h);
            if (TextUtils.isEmpty(v)) {
                v = rd.i(this.h);
            }
            if (!TextUtils.isEmpty(v)) {
                v = rg.b(new StringBuilder(v).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", this.d);
            hashMap.put("plattype", "android");
            hashMap.put("product", this.i.a());
            hashMap.put("version", this.i.b());
            hashMap.put("output", "json");
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb.toString());
            hashMap.put("deviceId", v);
            hashMap.put("manufacture", Build.MANUFACTURER);
            Map<String, String> map = this.e;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.e);
            }
            hashMap.put("abitype", rk.a(this.h));
            hashMap.put("ext", this.i.e());
            return rk.a(rk.a(hashMap));
        }

        /* access modifiers changed from: protected */
        @Override // com.amap.api.col.stln3.ts
        public final String f() {
            return NlsRequestProto.VERSION30;
        }
    }

    private static void a(a aVar, JSONObject jSONObject) {
        try {
            if (rk.a(jSONObject, "11B")) {
                aVar.h = jSONObject.getJSONObject("11B");
            }
            if (rk.a(jSONObject, "11C")) {
                aVar.k = jSONObject.getJSONObject("11C");
            }
            if (rk.a(jSONObject, "11I")) {
                aVar.l = jSONObject.getJSONObject("11I");
            }
            if (rk.a(jSONObject, "11H")) {
                aVar.m = jSONObject.getJSONObject("11H");
            }
            if (rk.a(jSONObject, "11E")) {
                aVar.n = jSONObject.getJSONObject("11E");
            }
            if (rk.a(jSONObject, "11F")) {
                aVar.o = jSONObject.getJSONObject("11F");
            }
            if (rk.a(jSONObject, "13A")) {
                aVar.q = jSONObject.getJSONObject("13A");
            }
            if (rk.a(jSONObject, "13J")) {
                aVar.i = jSONObject.getJSONObject("13J");
            }
            if (rk.a(jSONObject, "11G")) {
                aVar.p = jSONObject.getJSONObject("11G");
            }
            if (rk.a(jSONObject, "006")) {
                aVar.r = jSONObject.getJSONObject("006");
            }
            if (rk.a(jSONObject, "010")) {
                aVar.s = jSONObject.getJSONObject("010");
            }
            if (rk.a(jSONObject, "11Z")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("11Z");
                a.b bVar = new a.b();
                a(jSONObject2, bVar);
                aVar.C = bVar;
            }
            if (rk.a(jSONObject, "135")) {
                aVar.j = jSONObject.getJSONObject("135");
            }
            if (rk.a(jSONObject, "13S")) {
                aVar.g = jSONObject.getJSONObject("13S");
            }
            if (rk.a(jSONObject, "121")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("121");
                a.b bVar2 = new a.b();
                a(jSONObject3, bVar2);
                aVar.D = bVar2;
            }
            if (rk.a(jSONObject, "122")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("122");
                a.b bVar3 = new a.b();
                a(jSONObject4, bVar3);
                aVar.E = bVar3;
            }
            if (rk.a(jSONObject, "123")) {
                JSONObject jSONObject5 = jSONObject.getJSONObject("123");
                a.b bVar4 = new a.b();
                a(jSONObject5, bVar4);
                aVar.F = bVar4;
            }
            if (rk.a(jSONObject, "011")) {
                aVar.c = jSONObject.getJSONObject("011");
            }
            if (rk.a(jSONObject, "012")) {
                aVar.d = jSONObject.getJSONObject("012");
            }
            if (rk.a(jSONObject, "013")) {
                aVar.e = jSONObject.getJSONObject("013");
            }
            if (rk.a(jSONObject, "014")) {
                aVar.f = jSONObject.getJSONObject("014");
            }
            if (rk.a(jSONObject, "145")) {
                aVar.t = jSONObject.getJSONObject("145");
            }
            if (rk.a(jSONObject, "14B")) {
                aVar.u = jSONObject.getJSONObject("14B");
            }
            if (rk.a(jSONObject, "14D")) {
                aVar.v = jSONObject.getJSONObject("14D");
            }
        } catch (Throwable th) {
            rx.c(th, "at", "pe");
        }
    }
}
