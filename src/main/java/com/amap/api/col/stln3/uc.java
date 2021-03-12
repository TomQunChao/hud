package com.amap.api.col.stln3;

import com.amap.api.col.stln3.tm;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: LogEngine */
public final class uc {
    public static void a(String str, byte[] bArr, ub ubVar) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        Throwable th;
        tm tmVar;
        OutputStream outputStream = null;
        try {
            if (!a(ubVar.a, str)) {
                File file = new File(ubVar.a);
                if (!file.exists()) {
                    file.mkdirs();
                }
                tmVar = tm.a(file, ubVar.b);
                try {
                    tmVar.a(ubVar.d);
                    byte[] b = ubVar.e.b(bArr);
                    tm.a b2 = tmVar.b(str);
                    outputStream = b2.a();
                    outputStream.write(b);
                    b2.b();
                    tmVar.d();
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    if (tmVar != null) {
                        try {
                            tmVar.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            tmVar = null;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
            }
            if (tmVar != null) {
                try {
                    tmVar.close();
                } catch (Throwable th7) {
                    th7.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0094, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0096, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0097, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ba, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00bb, code lost:
        r8.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00c8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00c9, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0094 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b6 A[SYNTHETIC, Splitter:B:48:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c4 A[SYNTHETIC, Splitter:B:53:0x00c4] */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.amap.api.col.stln3.ub r8) {
        /*
        // Method dump skipped, instructions count: 207
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.uc.a(com.amap.api.col.stln3.ub):void");
    }

    private static byte[] a(tm tmVar, ub ubVar, List<String> list) {
        try {
            File b = tmVar.b();
            if (b != null && b.exists()) {
                String[] list2 = b.list();
                int length = list2.length;
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = list2[i];
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] a = ui.a(tmVar, str2);
                        i2 += a.length;
                        list.add(str2);
                        if (i2 > ubVar.f.b()) {
                            break;
                        }
                        ubVar.g.b(a);
                    }
                    i++;
                }
                return ubVar.g.a();
            }
        } catch (Throwable th) {
            rx.c(th, "leg", "gCo");
        }
        return new byte[0];
    }

    private static void a(tm tmVar, List<String> list) {
        if (tmVar != null) {
            try {
                for (String str : list) {
                    tmVar.c(str);
                }
                tmVar.close();
            } catch (Throwable th) {
                rx.c(th, "ofm", "dlo");
            }
        }
    }

    private static boolean a(String str, String str2) {
        try {
            return new File(str, str2 + ".0").exists();
        } catch (Throwable th) {
            rx.c(th, "leg", "fet");
            return false;
        }
    }
}
