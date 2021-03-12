package com.amap.api.col.stln3;

/* compiled from: DexDownloadItem */
public final class sj {
    String a;
    String b;
    String c;
    String d;
    int e;
    int f;
    private String g;
    private String h;
    private boolean i;
    private boolean j;

    public sj(String str, String str2) {
        this(str, str2, false);
    }

    public sj(String str, String str2, boolean z) {
        this.i = false;
        this.j = false;
        this.g = str;
        this.h = str2;
        this.i = z;
        try {
            String[] split = str.split("/");
            int length = split.length;
            if (length > 1) {
                this.a = split[length - 1];
                String[] split2 = this.a.split("_");
                this.b = split2[0];
                this.c = split2[2];
                this.d = split2[1];
                this.e = Integer.parseInt(split2[3]);
                this.f = Integer.parseInt(split2[4].split("\\.")[0]);
            }
        } catch (Throwable th) {
            ru.a(th, "DexDownloadItem", "DexDownloadItem");
        }
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        return this.g;
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        return this.h;
    }

    public final boolean c() {
        return this.i;
    }

    public final boolean d() {
        return this.j;
    }

    public final void a(boolean z) {
        this.j = z;
    }
}
