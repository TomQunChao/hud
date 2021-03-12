package com.amap.api.col.stln3;

/* access modifiers changed from: package-private */
@sd(a = "update_item_file")
/* compiled from: DTFileInfo */
public class em {
    @se(a = "mAdcode", b = 6)
    private String a = "";
    @se(a = "file", b = 6)
    private String b = "";

    public em() {
    }

    public em(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final String a() {
        return this.b;
    }

    public static String a(String str) {
        return "mAdcode" + "='" + str + "'";
    }
}
