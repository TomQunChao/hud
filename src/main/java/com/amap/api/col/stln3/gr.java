package com.amap.api.col.stln3;

import android.content.Context;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

/* compiled from: CustomStyleRequest */
public final class gr extends pg<String, a> {
    private String h;
    private boolean i;

    /* compiled from: CustomStyleRequest */
    public static class a {
        public byte[] a;
        public int b = -1;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.pg
    public final /* bridge */ /* synthetic */ a a(String str) throws pf {
        return null;
    }

    public gr(Context context, String str) {
        super(context, str);
        this.i = false;
        this.g = "/map/styles";
    }

    public gr(Context context, String str, byte b) {
        super(context, str);
        this.i = false;
        this.i = true;
        this.g = "/sdk/map/styles";
        this.isPostFlag = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public a a(byte[] bArr) throws pf {
        a aVar = new a();
        aVar.a = bArr;
        if (this.i && bArr != null) {
            if (bArr.length == 0) {
                aVar.a = null;
            } else if (aVar.a.length <= 1024) {
                try {
                    if (new String(bArr, "utf-8").contains("errcode")) {
                        aVar.a = null;
                    }
                } catch (Exception e) {
                    rx.c(e, "CustomStyleRequest", "loadData");
                }
            }
        }
        return aVar;
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

    @Override // com.amap.api.col.stln3.tw, com.amap.api.col.stln3.hb
    public final Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", qy.f(this.f));
        if (!this.i) {
            hashtable.put("output", "bin");
        }
        hashtable.put("styleid", this.h);
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

    public final void b(String str) {
        this.h = str;
    }
}
