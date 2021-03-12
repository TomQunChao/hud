package com.amap.api.col.stln3;

@sd(a = "update_item")
/* compiled from: DTInfo */
public class en {
    @se(a = "title", b = 6)
    protected String a = null;
    @se(a = "url", b = 6)
    protected String b = null;
    @se(a = "mAdcode", b = 6)
    protected String c = null;
    @se(a = "fileName", b = 6)
    protected String d = null;
    @se(a = "version", b = 6)
    protected String e = "";
    @se(a = "lLocalLength", b = 5)
    protected long f = 0;
    @se(a = "lRemoteLength", b = 5)
    protected long g = 0;
    @se(a = "localPath", b = 6)
    protected String h;
    @se(a = "isProvince", b = 2)
    protected int i = 0;
    @se(a = "mCompleteCode", b = 2)
    protected int j;
    @se(a = "mCityCode", b = 6)
    protected String k = "";
    @se(a = "mState", b = 2)
    public int l;
    @se(a = "mPinyin", b = 6)
    public String m = "";

    public final String c() {
        return this.a;
    }

    public final String d() {
        return this.e;
    }

    public final String e() {
        return this.c;
    }

    public final void c(String str) {
        this.c = str;
    }

    public final String f() {
        return this.b;
    }

    public final int g() {
        return this.j;
    }

    public final void d(String str) {
        this.k = str;
    }

    public final String h() {
        return this.m;
    }

    public static String e(String str) {
        return "mAdcode" + "='" + str + "'";
    }

    public static String f(String str) {
        return "mPinyin" + "='" + str + "'";
    }
}
