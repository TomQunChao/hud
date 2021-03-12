package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.track.ErrorCode;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: AuthRequest */
public final class cd extends pg<String, a> {
    private int[] h = {ErrorCode.Response.SUCCESS, 0, 10018, 10019, 10020, 10021, 10022, 10023};

    /* compiled from: AuthRequest */
    public static class a {
        public int a = -1;
        public String b;
        public String c;
        public boolean d = false;
    }

    public cd(Context context, String str) {
        super(context, str);
        this.g = "/feedback";
        this.isPostFlag = false;
    }

    @Override // com.amap.api.col.stln3.tw, com.amap.api.col.stln3.hb
    public final Map<String, String> getRequestHead() {
        String str;
        rj f = ic.f();
        if (f != null) {
            str = f.b();
        } else {
            str = null;
        }
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", ch.c);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", str, "3dmap"));
        hashtable.put("x-INFO", rb.a(this.f));
        hashtable.put("key", qy.f(this.f));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public a a(String str) throws pf {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = -1;
            String str2 = "";
            String str3 = "";
            if (jSONObject.has("errcode")) {
                i = jSONObject.optInt("errcode");
                str2 = jSONObject.optString("errmsg");
                str3 = jSONObject.optString("errdetail");
            }
            a aVar = new a();
            aVar.a = i;
            aVar.b = str2;
            aVar.c = str3;
            int i2 = 0;
            aVar.d = false;
            int[] iArr = this.h;
            int length = iArr.length;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (iArr[i2] == i) {
                    aVar.d = true;
                    break;
                } else {
                    i2++;
                }
            }
            return aVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.stln3.tw, com.amap.api.col.stln3.hb
    public final Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", qy.f(this.f));
        hashtable.put("pname", "3dmap");
        String a2 = rb.a();
        String a3 = rb.a(this.f, a2, rk.b(hashtable));
        hashtable.put("ts", a2);
        hashtable.put("scode", a3);
        return hashtable;
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return "http://restapi.amap.com/v4" + this.g;
    }
}
