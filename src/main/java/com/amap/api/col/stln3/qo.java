package com.amap.api.col.stln3;

import android.text.TextUtils;

/* compiled from: JSONStrUtil */
public final class qo {
    private static int c = 1;
    private static int d = 2;
    private static int e = 3;
    private StringBuffer a;
    private int b;

    public final qo a() {
        if (this.a == null) {
            this.a = new StringBuffer();
        }
        if (this.a.length() == 0) {
            this.a.append("{");
        }
        this.b = c;
        return this;
    }

    public final qo a(String str, String str2) {
        if (this.a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return this;
        }
        if (this.b == d) {
            this.a.append(",");
        }
        this.a.append(String.format("\"%s\":%s", str, str2));
        this.b = d;
        return this;
    }

    public final qo b(String str, String str2) {
        if (this.a == null || TextUtils.isEmpty(str)) {
            return this;
        }
        if (str2 == null) {
            str2 = "";
        }
        if (this.b == d) {
            this.a.append(",");
        }
        this.a.append(String.format("\"%s\":\"%s\"", str, str2));
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
            return "{}";
        }
        if (i == d) {
            stringBuffer.append("}");
        }
        this.b = e;
        return this.a.toString();
    }
}
