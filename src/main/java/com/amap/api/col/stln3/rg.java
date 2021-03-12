package com.amap.api.col.stln3;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5 */
public final class rg {
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0069 A[SYNTHETIC, Splitter:B:30:0x0069] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r5) {
        /*
        // Method dump skipped, instructions count: 142
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.rg.a(java.lang.String):java.lang.String");
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        return rk.e(d(str));
    }

    public static String a(byte[] bArr) {
        return rk.e(a(bArr, "MD5"));
    }

    public static String c(String str) {
        return rk.f(e(str));
    }

    public static byte[] a(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return instance.digest();
        } catch (Throwable th) {
            ru.a(th, "MD5", "gmb");
            return null;
        }
    }

    private static byte[] d(String str) {
        try {
            return f(str);
        } catch (Throwable th) {
            ru.a(th, "MD5", "gmb");
            return new byte[0];
        }
    }

    private static byte[] e(String str) {
        try {
            return f(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] f(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(rk.a(str));
        return instance.digest();
    }
}
