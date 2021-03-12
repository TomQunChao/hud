package com.amap.api.col.stln3;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Locale;

/* compiled from: AppInfo */
public final class qy {
    static String a = null;
    static boolean b = false;
    private static String c = "";
    private static String d = "";
    private static String e = "";
    private static String f = "";

    private static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        char[] charArray = str.toCharArray();
        for (char c2 : charArray) {
            if (('A' > c2 || c2 > 'z') && (('0' > c2 || c2 > ':') && c2 != '.')) {
                try {
                    rx.b(rk.a(), str, "errorPackage");
                } catch (Throwable th) {
                }
                return false;
            }
        }
        return true;
    }

    static boolean a() {
        try {
            if (b) {
                return true;
            }
            if (c(a)) {
                b = true;
                return true;
            } else if (!TextUtils.isEmpty(a)) {
                b = false;
                a = null;
                return false;
            } else if (c(d)) {
                b = true;
                return true;
            } else if (TextUtils.isEmpty(d)) {
                return true;
            } else {
                b = false;
                d = null;
                return false;
            }
        } catch (Throwable th) {
            return true;
        }
    }

    public static String a(Context context) {
        try {
            return h(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return f;
        }
    }

    public static String b(Context context) {
        try {
            if (!"".equals(c)) {
                return c;
            }
            PackageManager packageManager = context.getPackageManager();
            c = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            return c;
        } catch (Throwable th) {
            ru.a(th, "AI", "gAN");
        }
    }

    public static void a(String str) {
        d = str;
    }

    public static String c(Context context) {
        try {
            if (d != null && !"".equals(d)) {
                return d;
            }
            String packageName = context.getPackageName();
            d = packageName;
            if (!c(packageName)) {
                d = context.getPackageName();
            }
            return d;
        } catch (Throwable th) {
            ru.a(th, "AI", "gpck");
        }
    }

    public static String d(Context context) {
        try {
            if (!"".equals(e)) {
                return e;
            }
            e = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            String str = e;
            return str == null ? "" : str;
        } catch (Throwable th) {
            ru.a(th, "AI", "gAV");
        }
    }

    public static String e(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = MessageDigest.getInstance("SHA1").digest(packageInfo.signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                String upperCase = Integer.toHexString(b2 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            String str = packageInfo.packageName;
            if (c(str)) {
                str = packageInfo.packageName;
            }
            if (!TextUtils.isEmpty(d)) {
                str = c(context);
            }
            stringBuffer.append(str);
            String stringBuffer2 = stringBuffer.toString();
            a = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable th) {
            ru.a(th, "AI", "gsp");
            return a;
        }
    }

    static void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            f = str;
        }
    }

    static void a(final Context context, final String str) {
        if (!TextUtils.isEmpty(str)) {
            f = str;
            if (context != null) {
                rx.d().submit(new Runnable() {
                    /* class com.amap.api.col.stln3.qy.AnonymousClass1 */

                    public final void run() {
                        Throwable th;
                        Throwable th2;
                        FileOutputStream fileOutputStream = null;
                        try {
                            File file = new File(rv.c(context, "k.store"));
                            if (!file.getParentFile().exists()) {
                                file.getParentFile().mkdirs();
                            }
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                            try {
                                fileOutputStream2.write(rk.a(str));
                                try {
                                    fileOutputStream2.close();
                                } catch (Throwable th3) {
                                    th3.printStackTrace();
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Throwable th5) {
                                        th5.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th2 = th6;
                            try {
                                ru.a(th2, "AI", "stf");
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Throwable th7) {
                                        th7.printStackTrace();
                                    }
                                }
                            } catch (Throwable th8) {
                                th = th8;
                            }
                        }
                    }
                });
            }
        }
    }

    public static String f(Context context) {
        try {
            return h(context);
        } catch (Throwable th) {
            ru.a(th, "AI", "gKy");
            return f;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0054 A[Catch:{ Throwable -> 0x005a }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0061 A[SYNTHETIC, Splitter:B:31:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0072 A[SYNTHETIC, Splitter:B:37:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String g(android.content.Context r5) {
        /*
        // Method dump skipped, instructions count: 125
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.qy.g(android.content.Context):java.lang.String");
    }

    private static String h(Context context) throws PackageManager.NameNotFoundException {
        String str = f;
        if (str == null || str.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return f;
            }
            String string = applicationInfo.metaData.getString("com.amap.api.v2.apikey");
            f = string;
            if (string == null) {
                f = g(context);
            }
        }
        return f;
    }
}
