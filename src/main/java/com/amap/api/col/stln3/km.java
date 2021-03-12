package com.amap.api.col.stln3;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LbsGuideGroup */
public final class km {
    private String a;
    private int b;
    private int c;
    private int d;
    private int e;
    private List<a> f = new ArrayList();

    public final List<a> a() {
        return this.f;
    }

    public final String b() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final int c() {
        return this.b;
    }

    public final void a(int i) {
        this.b = i;
    }

    public final int d() {
        return this.c;
    }

    public final void b(int i) {
        this.c = i;
    }

    public final int e() {
        return this.d;
    }

    public final void c(int i) {
        this.d = i;
    }

    public final void d(int i) {
        this.e = i;
    }

    /* compiled from: LbsGuideGroup */
    public static class a {
        private int a;
        private int b;
        private String c;

        public a(int i, String str, int i2) {
            this.a = i;
            this.b = i2;
            if (TextUtils.isEmpty(str)) {
                this.c = "内部道路";
            } else {
                this.c = str;
            }
        }

        public final String a() {
            return this.c;
        }

        public final int b() {
            return this.b;
        }

        public final int c() {
            return this.a;
        }
    }
}
