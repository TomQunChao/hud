package com.amap.api.col.stln3;

/* access modifiers changed from: package-private */
@sd(a = "update_item_download_info")
/* compiled from: DTDownloadInfo */
public class el {
    @se(a = "mAdcode", b = 6)
    private String a = "";
    @se(a = "fileLength", b = 5)
    private long b = 0;
    @se(a = "splitter", b = 2)
    private int c = 0;
    @se(a = "startPos", b = 5)
    private long d = 0;
    @se(a = "endPos", b = 5)
    private long e = 0;

    public el() {
    }

    public el(String str, long j, int i, long j2, long j3) {
        this.a = str;
        this.b = j;
        this.c = i;
        this.d = j2;
        this.e = j3;
    }

    public static String a(String str) {
        return "mAdcode" + "='" + str + "'";
    }
}
