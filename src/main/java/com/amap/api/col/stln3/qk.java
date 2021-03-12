package com.amap.api.col.stln3;

import android.os.Build;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AESUtil */
public final class qk {
    public static String a(String str, String str2) throws Exception {
        if (str == null) {
            str = "123456";
        }
        if (str2 == null) {
            return str2;
        }
        byte[] a = a(str.getBytes());
        byte[] bytes = str2.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(a, "AES");
        Cipher instance = Cipher.getInstance("AES");
        instance.init(1, secretKeySpec);
        return b(instance.doFinal(bytes));
    }

    public static String b(String str, String str2) throws Exception {
        byte[] a = a(str.getBytes());
        int length = str2.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = Integer.valueOf(str2.substring(i2, i2 + 2), 16).byteValue();
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(a, "AES");
        Cipher instance = Cipher.getInstance("AES");
        instance.init(2, secretKeySpec);
        return new String(instance.doFinal(bArr));
    }

    private static byte[] a(byte[] bArr) throws Exception {
        SecureRandom secureRandom;
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        if (Build.VERSION.SDK_INT >= 17) {
            secureRandom = SecureRandom.getInstance("SHA1PRNG", "Crypto");
        } else {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        }
        secureRandom.setSeed(bArr);
        instance.init(256, secureRandom);
        return instance.generateKey().getEncoded();
    }

    private static String b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15));
            stringBuffer.append("0123456789ABCDEF".charAt(b & 15));
        }
        return stringBuffer.toString();
    }
}
