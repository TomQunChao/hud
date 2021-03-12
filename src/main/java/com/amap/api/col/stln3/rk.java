package com.amap.api.col.stln3;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.col.stln3.rj;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Utils */
public final class rk {
    static String a;
    private static final String[] b = {"arm64-v8a", "x86_64"};
    private static final String[] c = {"arm", "x86"};

    public static Method a(Class cls, String str, Class<?>... clsArr) {
        try {
            return cls.getDeclaredMethod(c(str), clsArr);
        } catch (Throwable th) {
            return null;
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 80; i++) {
            sb.append("=");
        }
        a = sb.toString();
    }

    public static String a(Context context) {
        String[] strArr;
        String str = "";
        if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 28) {
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                Field declaredField = Class.forName(ApplicationInfo.class.getName()).getDeclaredField("primaryCpuAbi");
                declaredField.setAccessible(true);
                str = (String) declaredField.get(applicationInfo);
            } catch (Throwable th) {
                ru.a(th, "ut", "gct");
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                String[] strArr2 = (String[]) Build.class.getDeclaredField("SUPPORTED_ABIS").get(null);
                if (strArr2 != null && strArr2.length > 0) {
                    str = strArr2[0];
                }
                if (!TextUtils.isEmpty(str) && Arrays.asList(b).contains(str)) {
                    String str2 = context.getApplicationInfo().nativeLibraryDir;
                    if (!TextUtils.isEmpty(str2)) {
                        if (Arrays.asList(c).contains(str2.substring(str2.lastIndexOf(File.separator) + 1)) && (strArr = (String[]) Build.class.getDeclaredField("SUPPORTED_32_BIT_ABIS").get(null)) != null && strArr.length > 0) {
                            str = strArr[0];
                        }
                    }
                }
            } catch (Throwable th2) {
                ru.a(th2, "ut", "gct_p");
            }
        }
        if (TextUtils.isEmpty(str)) {
            return Build.CPU_ABI;
        }
        return str;
    }

    public static boolean a(Context context, String str) {
        if (context == null || context.checkCallingOrSelfPermission(str) != 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23 && context.getApplicationInfo().targetSdkVersion >= 23) {
            try {
                if (((Integer) context.getClass().getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (Throwable th) {
            }
        }
        return true;
    }

    public static rj a() throws qx {
        return new rj.a("collection", "1.0", "AMap_collection_1.0").a(new String[]{"com.amap.api.collection"}).a();
    }

    public static rj b() throws qx {
        return new rj.a("co", "1.0.0", "AMap_co_1.0.0").a(new String[]{"com.amap.co", "com.amap.opensdk.co", "com.amap.location"}).a();
    }

    public static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            try {
                byteArrayOutputStream.write(new byte[]{0});
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            int length = str.length();
            if (length > 255) {
                length = 255;
            }
            a(byteArrayOutputStream, (byte) length, a(str));
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return new String(bArr);
        }
    }

    public static byte[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str.getBytes();
        }
    }

    public static void a(ByteArrayOutputStream byteArrayOutputStream, byte b2, byte[] bArr) {
        try {
            byteArrayOutputStream.write(new byte[]{b2});
            int i = b2 & 255;
            if (i < 255 && i > 0) {
                byteArrayOutputStream.write(bArr);
            } else if (i == 255) {
                byteArrayOutputStream.write(bArr, 0, 255);
            }
        } catch (IOException e) {
            ru.a(e, "ut", "wFie");
        }
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        String c2 = re.c(a(str));
        try {
            return ((char) ((c2.length() % 26) + 65)) + c2;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String c(String str) {
        if (str.length() < 2) {
            return "";
        }
        return re.a(str.substring(1));
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }

    public static byte[] c() {
        try {
            String[] split = new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(",");
            byte[] bArr = new byte[split.length];
            for (int i = 0; i < split.length; i++) {
                bArr[i] = Byte.parseByte(split[i]);
            }
            String[] split2 = new StringBuffer(new String(re.b(new String(bArr)))).reverse().toString().split(",");
            byte[] bArr2 = new byte[split2.length];
            for (int i2 = 0; i2 < split2.length; i2++) {
                bArr2[i2] = Byte.parseByte(split2[i2]);
            }
            return bArr2;
        } catch (Throwable th) {
            ru.a(th, "ut", "gIV");
            return new byte[16];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x004c A[SYNTHETIC, Splitter:B:31:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0058 A[SYNTHETIC, Splitter:B:36:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0068 A[SYNTHETIC, Splitter:B:43:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0074 A[SYNTHETIC, Splitter:B:48:0x0074] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.Throwable r3) {
        /*
        // Method dump skipped, instructions count: 128
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.rk.a(java.lang.Throwable):java.lang.String");
    }

    public static String a(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (z) {
                    z = false;
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append("=");
                    stringBuffer.append(entry.getValue());
                } else {
                    stringBuffer.append("&");
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append("=");
                    stringBuffer.append(entry.getValue());
                }
            }
        } catch (Throwable th) {
            ru.a(th, "ut", "abP");
        }
        return stringBuffer.toString();
    }

    public static String b(Map<String, String> map) {
        String str;
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
            }
            str = sb.toString();
        } else {
            str = null;
        }
        return d(str);
    }

    public static String d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String[] split = str.split("&");
            Arrays.sort(split);
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
                stringBuffer.append("&");
            }
            String stringBuffer2 = stringBuffer.toString();
            if (stringBuffer2.length() > 1) {
                return (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
            }
            return str;
        } catch (Throwable th) {
            ru.a(th, "ut", "sPa");
        }
    }

    public static byte[] b(byte[] bArr) {
        try {
            return i(bArr);
        } catch (Throwable th) {
            ru.a(th, "ut", "gZp");
            return new byte[0];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0061 A[SYNTHETIC, Splitter:B:31:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071 A[SYNTHETIC, Splitter:B:36:0x0071] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0085 A[SYNTHETIC, Splitter:B:43:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0095 A[SYNTHETIC, Splitter:B:48:0x0095] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] c(byte[] r5) {
        /*
        // Method dump skipped, instructions count: 167
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.rk.c(byte[]):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d A[SYNTHETIC, Splitter:B:28:0x005d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.security.PublicKey d() throws java.security.cert.CertificateException, java.security.spec.InvalidKeySpecException, java.security.NoSuchAlgorithmException, java.lang.NullPointerException, java.io.IOException {
        /*
        // Method dump skipped, instructions count: 122
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.rk.d():java.security.PublicKey");
    }

    public static byte[] d(byte[] bArr) {
        try {
            return i(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    static String e(byte[] bArr) {
        try {
            return g(bArr);
        } catch (Throwable th) {
            ru.a(th, "ut", "h2s");
            return null;
        }
    }

    static String f(byte[] bArr) {
        try {
            return g(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String g(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null) {
            return null;
        }
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static byte[] e(String str) {
        if (str.length() % 2 != 0) {
            str = "0" + str;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
        }
        return bArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0042 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x004b A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] i(byte[] r3) throws java.io.IOException, java.lang.Throwable {
        /*
            r0 = 0
            if (r3 != 0) goto L_0x0007
            return r0
        L_0x0007:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Throwable -> 0x003a, all -> 0x0037 }
            r1.<init>()     // Catch:{ Throwable -> 0x003a, all -> 0x0037 }
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch:{ Throwable -> 0x0033, all -> 0x0031 }
            r2.<init>(r1)     // Catch:{ Throwable -> 0x0033, all -> 0x0031 }
            r2.write(r3)     // Catch:{ Throwable -> 0x002f, all -> 0x002d }
            r2.finish()     // Catch:{ Throwable -> 0x002f, all -> 0x002d }
            byte[] r3 = r1.toByteArray()     // Catch:{ Throwable -> 0x002f, all -> 0x002d }
            r2.close()     // Catch:{ Throwable -> 0x002b }
            r1.close()     // Catch:{ Throwable -> 0x0029 }
            return r3
        L_0x0029:
            r3 = move-exception
            throw r3
        L_0x002b:
            r3 = move-exception
            throw r3
        L_0x002d:
            r3 = move-exception
            goto L_0x003f
        L_0x002f:
            r3 = move-exception
            goto L_0x0035
        L_0x0031:
            r3 = move-exception
            goto L_0x0040
        L_0x0033:
            r3 = move-exception
            r2 = r0
        L_0x0035:
            r0 = r1
            goto L_0x003c
        L_0x0037:
            r3 = move-exception
            r1 = r0
            goto L_0x0040
        L_0x003a:
            r3 = move-exception
            r2 = r0
        L_0x003c:
            throw r3     // Catch:{ all -> 0x003d }
        L_0x003d:
            r3 = move-exception
            r1 = r0
        L_0x003f:
            r0 = r2
        L_0x0040:
            if (r0 == 0) goto L_0x0048
            r0.close()     // Catch:{ Throwable -> 0x0046 }
            goto L_0x0049
        L_0x0046:
            r3 = move-exception
            throw r3
        L_0x0048:
        L_0x0049:
            if (r1 == 0) goto L_0x0051
            r1.close()     // Catch:{ Throwable -> 0x004f }
            goto L_0x0052
        L_0x004f:
            r3 = move-exception
            throw r3
        L_0x0051:
        L_0x0052:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.rk.i(byte[]):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0056 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x005f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] h(byte[] r6) throws java.io.IOException, java.lang.Throwable {
        /*
        // Method dump skipped, instructions count: 104
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.rk.h(byte[]):byte[]");
    }

    public static String a(long j) {
        try {
            return new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS", Locale.CHINA).format(new Date(j));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String a(long j, String str) {
        try {
            return new SimpleDateFormat(str, Locale.CHINA).format(new Date(j));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void a(Context context, String str, String str2, JSONObject jSONObject) {
        String str3 = "";
        String e = qy.e(context);
        String b2 = rg.b(e);
        String str4 = "";
        String str5 = "";
        String a2 = qy.a(context);
        String str6 = "";
        try {
            if (jSONObject.has("info")) {
                str3 = jSONObject.getString("info");
                String str7 = "请在高德开放平台官网中搜索\"" + str3 + "\"相关内容进行解决";
            }
            if ("INVALID_USER_SCODE".equals(str3)) {
                if (jSONObject.has("sec_code")) {
                    str4 = jSONObject.getString("sec_code");
                }
                if (jSONObject.has("sec_code_debug")) {
                    str5 = jSONObject.getString("sec_code_debug");
                }
                if (!b2.equals(str4)) {
                    if (b2.equals(str5)) {
                    }
                }
            } else if ("INVALID_USER_KEY".equals(str3)) {
                if (jSONObject.has("key")) {
                    str6 = jSONObject.getString("key");
                }
                if (str6.length() > 0) {
                    a2.equals(str6);
                }
            }
        } catch (Throwable th) {
        }
        String str8 = a;
        f("SHA1Package:" + e);
        f("key:" + a2);
        f("csid:" + str);
        f("gsid:" + str2);
        f("json:" + jSONObject.toString());
        String str9 = a;
    }

    private static void f(String str) {
        int i;
        while (true) {
            if (str.length() < 78) {
                break;
            }
            String str2 = "|" + str.substring(0, 78) + "|";
            str = str.substring(78);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        sb.append(str);
        for (i = 0; i < 78 - str.length(); i++) {
            sb.append(" ");
        }
        sb.append("|");
        sb.toString();
    }

    public static boolean b(Context context) {
        return sa.a(context);
    }
}
