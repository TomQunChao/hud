package com.amap.api.col.stln3;

import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Encrypt */
public final class vj {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final byte[] b = {0, 1, 1, 2, 3, 5, 8, 13, 8, 7, 6, 5, 4, 3, 2, 1};
    private static final IvParameterSpec c = new IvParameterSpec(b);

    public static synchronized byte[] a(byte[] bArr, String str) throws Exception {
        byte[] byteArray;
        byte[] bArr2;
        synchronized (vj.class) {
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(re.b(str)));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, generatePrivate);
            int length = bArr.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = length - i;
                if (i3 > 0) {
                    if (i3 > 245) {
                        bArr2 = instance.doFinal(bArr, i, 245);
                    } else {
                        bArr2 = instance.doFinal(bArr, i, i3);
                    }
                    byteArrayOutputStream.write(bArr2, 0, bArr2.length);
                    i2++;
                    i = i2 * 245;
                } else {
                    byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                }
            }
        }
        return byteArray;
    }

    public static synchronized byte[] b(byte[] bArr, String str) throws Exception {
        byte[] byteArray;
        byte[] bArr2;
        synchronized (vj.class) {
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(re.b(str)));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(2, generatePrivate);
            int length = bArr.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = length - i;
                if (i3 > 0) {
                    if (i3 > 256) {
                        bArr2 = instance.doFinal(bArr, i, 256);
                    } else {
                        bArr2 = instance.doFinal(bArr, i, i3);
                    }
                    byteArrayOutputStream.write(bArr2, 0, bArr2.length);
                    i2++;
                    i = i2 * 256;
                } else {
                    byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                }
            }
        }
        return byteArray;
    }

    public static byte[] c(byte[] bArr, String str) {
        try {
            SecretKeySpec b2 = b(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(rk.c());
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, b2, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Throwable th) {
            vu.a(th, "Encrypt", "aesEncrypt");
            return null;
        }
    }

    public static byte[] d(byte[] bArr, String str) {
        try {
            SecretKeySpec b2 = b(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(rk.c());
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, b2, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Throwable th) {
            vu.a(th, "Encrypt", "aesDecrypt");
            return null;
        }
    }

    private static SecretKeySpec b(String str) {
        byte[] bArr;
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append(str);
        while (stringBuffer.length() < 16) {
            stringBuffer.append("0");
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            bArr = stringBuffer.toString().getBytes("UTF-8");
        } catch (Throwable th) {
            vu.a(th, "Encrypt", "createKey");
            bArr = null;
        }
        return new SecretKeySpec(bArr, "AES");
    }

    public static String a(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    String a2 = a("SHA1", str);
                    return a("MD5", a2 + str);
                }
            } catch (Throwable th) {
                vu.a(th, "Encrypt", "generatorKey");
                return null;
            }
        }
        return null;
    }

    public static String a(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        try {
            byte[] a2 = rg.a(str2.getBytes("UTF-8"), str);
            int length = a2.length;
            StringBuilder sb = new StringBuilder(length * 2);
            for (int i = 0; i < length; i++) {
                sb.append(a[(a2[i] >> 4) & 15]);
                sb.append(a[a2[i] & 15]);
            }
            return sb.toString();
        } catch (Throwable th) {
            vu.a(th, "Encrypt", "encode");
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, new SecretKeySpec(bArr, "AES"), c);
        return instance.doFinal(bArr2);
    }

    public static byte[] a(byte[] bArr) {
        int i = 0;
        try {
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[(bArr.length - 16)];
            System.arraycopy(bArr, 0, bArr2, 0, 16);
            System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(rk.c()));
            return instance.doFinal(bArr3);
        } catch (Throwable th) {
            if (bArr != null) {
                i = bArr.length;
            }
            vu.a(th, "Encrypt", "decryptRsponse length = " + i);
            return null;
        }
    }
}
