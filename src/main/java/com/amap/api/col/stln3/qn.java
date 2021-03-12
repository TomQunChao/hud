package com.amap.api.col.stln3;

import android.text.TextUtils;

/* compiled from: JSONArrayStrUtil */
public final class qn {
    private static int c = 1;
    private static int d = 2;
    private static int e = 3;
    private StringBuffer a;
    private int b;

    public final qn a() {
        if (this.a == null) {
            this.a = new StringBuffer();
        }
        if (this.a.length() == 0) {
            this.a.append("[");
        }
        this.b = c;
        return this;
    }

    public final qn a(String str) {
        if (this.a == null || TextUtils.isEmpty(str)) {
            return this;
        }
        if (this.b == d) {
            this.a.append(",");
        }
        this.a.append(str);
        this.b = d;
        return this;
    }

    public final String b() {
        StringBuffer stringBuffer = this.a;
        if (stringBuffer == null) {
            return "";
        }
        int i = this.b;
        if (i == c) {
            return "[]";
        }
        if (i == d) {
            stringBuffer.append("]");
        }
        this.b = e;
        return this.a.toString();
    }
}
