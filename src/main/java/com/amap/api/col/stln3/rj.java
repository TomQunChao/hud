package com.amap.api.col.stln3;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

@sd(a = "a")
/* compiled from: SDKInfo */
public class rj {
    @se(a = "a1", b = 6)
    private String a;
    @se(a = "a2", b = 6)
    private String b;
    @se(a = "a6", b = 2)
    private int c;
    @se(a = "a3", b = 6)
    private String d;
    @se(a = "a4", b = 6)
    private String e;
    @se(a = "a5", b = 6)
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String[] l;

    /* synthetic */ rj(a aVar, byte b2) {
        this(aVar);
    }

    private rj() {
        this.c = 1;
        this.l = null;
    }

    private rj(a aVar) {
        this.c = 1;
        this.l = null;
        this.g = aVar.a;
        this.h = aVar.b;
        this.j = aVar.c;
        this.i = aVar.d;
        this.c = aVar.e ? 1 : 0;
        this.k = aVar.f;
        this.l = aVar.g;
        this.b = rk.b(this.h);
        this.a = rk.b(this.j);
        this.d = rk.b(this.i);
        this.e = rk.b(a(this.l));
        this.f = rk.b(this.k);
    }

    /* compiled from: SDKInfo */
    public static class a {
        private String a;
        private String b;
        private String c;
        private String d;
        private boolean e = true;
        private String f = "standard";
        private String[] g = null;

        public a(String str, String str2, String str3) {
            this.a = str2;
            this.b = str2;
            this.d = str3;
            this.c = str;
        }

        public final a a(boolean z) {
            this.e = z;
            return this;
        }

        public final a a(String[] strArr) {
            if (strArr != null) {
                this.g = (String[]) strArr.clone();
            }
            return this;
        }

        public final a a(String str) {
            this.b = str;
            return this;
        }

        public final rj a() throws qx {
            if (this.g != null) {
                return new rj(this, (byte) 0);
            }
            throw new qx("sdk packages is null");
        }
    }

    public final void a(boolean z) {
        this.c = z ? 1 : 0;
    }

    public final String a() {
        if (TextUtils.isEmpty(this.j) && !TextUtils.isEmpty(this.a)) {
            this.j = rk.c(this.a);
        }
        return this.j;
    }

    public final String b() {
        return this.g;
    }

    public final String c() {
        if (TextUtils.isEmpty(this.h) && !TextUtils.isEmpty(this.b)) {
            this.h = rk.c(this.b);
        }
        return this.h;
    }

    public final String d() {
        if (TextUtils.isEmpty(this.i) && !TextUtils.isEmpty(this.d)) {
            this.i = rk.c(this.d);
        }
        return this.i;
    }

    public final String e() {
        if (TextUtils.isEmpty(this.k) && !TextUtils.isEmpty(this.f)) {
            this.k = rk.c(this.f);
        }
        if (TextUtils.isEmpty(this.k)) {
            this.k = "standard";
        }
        return this.k;
    }

    public final boolean f() {
        return this.c == 1;
    }

    public final String[] g() {
        String[] strArr = this.l;
        if ((strArr == null || strArr.length == 0) && !TextUtils.isEmpty(this.e)) {
            this.l = b(rk.c(this.e));
        }
        return (String[]) this.l.clone();
    }

    private static String[] b(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str);
                sb.append(";");
            }
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("a1", rk.b(str));
        return sc.a((Map<String, String>) hashMap);
    }

    public static String h() {
        return "a6=1";
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (getClass() == obj.getClass() && hashCode() == ((rj) obj).hashCode()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        rt rtVar = new rt();
        rtVar.a(this.j).a(this.g).a(this.h).a((Object[]) this.l);
        return rtVar.a();
    }
}
