package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: EncryptUtil */
public final class ql {
    private static final byte[] a = {17, 32, 107, -114, -18, -61, 39, 59, -6, 113, 122, 88, 11, 19, 90, -27};

    public static String a(Context context, String str) {
        try {
            return qk.a(context.getPackageName(), str);
        } catch (Exception e) {
            qr.a("AESUtil encrypt ex " + e);
            return str;
        }
    }

    public static String b(Context context, String str) {
        try {
            return qk.b(context.getPackageName(), str);
        } catch (Exception e) {
            qr.a("AESUtil decrpt ex " + e);
            return str;
        }
    }

    public static byte[] c(Context context, String str) {
        try {
            return re.b(a(context), rk.b(rk.a(str)), a);
        } catch (Exception e) {
            qr.a("encrptForRemote  ex :" + e);
            e.printStackTrace();
            return new byte[0];
        }
    }

    public static byte[] a(Context context, byte[] bArr) {
        try {
            return rk.h(re.a(a(context), bArr, a));
        } catch (Throwable th) {
            qr.a("encrptForRemote  ex :" + th);
            return new byte[0];
        }
    }

    private static byte[] a(Context context) {
        String f = qy.f(context);
        int i = 0;
        if (TextUtils.isEmpty(f)) {
            return new byte[0];
        }
        if (f.length() <= 16) {
            return rk.a(f);
        }
        byte[] bytes = f.substring(0, 16).getBytes();
        byte[] bytes2 = f.substring(16, f.length()).getBytes();
        if (bytes == null || bytes2 == null) {
            return new byte[0];
        }
        while (i < bytes.length && i < bytes2.length) {
            bytes[i] = (byte) (bytes[i] + bytes2[i]);
            i++;
        }
        return bytes;
    }
}
