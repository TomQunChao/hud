package com.amap.api.col.stln3;

/* compiled from: AESMD5Util */
public final class qw {
    private static byte[] a = rz.a;
    private static byte[] b = rz.b;
    private static int c = 6;

    public static byte[] a(byte[] bArr) {
        try {
            return re.b(a, bArr, b);
        } catch (Throwable th) {
            return new byte[0];
        }
    }

    public static byte[] b(byte[] bArr) {
        try {
            return re.a(a, bArr, b);
        } catch (Exception e) {
            return new byte[0];
        }
    }
}
