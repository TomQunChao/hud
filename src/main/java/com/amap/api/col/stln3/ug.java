package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: StatisticsEntity */
public final class ug {
    private Context a;
    private String b;
    private String c;
    private String d;
    private String e;

    public ug(Context context, String str, String str2, String str3) throws qx {
        if (TextUtils.isEmpty(str3) || str3.length() > 256) {
            throw new qx("无效的参数 - IllegalArgumentException");
        }
        this.a = context.getApplicationContext();
        this.c = str;
        this.d = str2;
        this.b = str3;
    }

    public final void a(String str) throws qx {
        if (TextUtils.isEmpty(str) || str.length() > 65536) {
            throw new qx("无效的参数 - IllegalArgumentException");
        }
        this.e = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0090, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0092, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0093, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b6, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b7, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0090 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b2 A[SYNTHETIC, Splitter:B:35:0x00b2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] a() {
        /*
        // Method dump skipped, instructions count: 189
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ug.a():byte[]");
    }
}
