package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: FileProvider */
public final class sw {
    private Context a;
    private String b;

    public sw(Context context) {
        this.a = context;
        if (TextUtils.isEmpty(this.b)) {
            this.b = "d";
        }
    }

    private String d() {
        Context context = this.a;
        if (context == null) {
            return "";
        }
        return context.getFilesDir().getAbsolutePath();
    }

    public final String a(String str) {
        if (this.a == null || TextUtils.isEmpty(this.b)) {
            return "";
        }
        return d() + File.separator + this.b + File.separator + rg.b(str) + File.separator + "i";
    }

    public final String b(String str) {
        if (this.a == null) {
            return "";
        }
        return a(str) + File.separator + e();
    }

    private String e() {
        Context context = this.a;
        if (context == null) {
            return "";
        }
        return b(context, "");
    }

    public static String a(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            str = "emptyfilename";
        }
        return b(context, str);
    }

    public final String a() {
        if (this.a == null || TextUtils.isEmpty(this.b)) {
            return "";
        }
        return d() + File.separator + this.b + File.separator + "j";
    }

    public final String b() {
        if (this.a == null || TextUtils.isEmpty(this.b)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(d() + File.separator + this.b);
        sb.append(File.separator);
        sb.append(File.separator);
        sb.append("m");
        return sb.toString();
    }

    public final String c() {
        if (this.a == null || TextUtils.isEmpty(this.b)) {
            return "";
        }
        return b() + File.separator + e();
    }

    public static void c(String str) {
        if (!TextUtils.isEmpty(str)) {
        }
    }

    public static void d(String str) {
        File file = new File(str);
        if (file.exists()) {
            a(file);
        }
    }

    private static void a(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].isDirectory()) {
                        a(listFiles[i]);
                    } else {
                        listFiles[i].delete();
                    }
                }
                return;
            }
            return;
        }
        file.delete();
    }

    public static void e(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    private static void f(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                return;
            }
            if (!file.exists()) {
                file.mkdirs();
            } else if (file.exists() && !file.isDirectory()) {
                file.delete();
                file.mkdirs();
            }
        }
    }

    private static void b(File file) throws IOException {
        if (file.exists() && file.isFile()) {
            return;
        }
        if (!file.exists()) {
            file.createNewFile();
        } else if (file.exists() && !file.isFile()) {
            file.delete();
            file.createNewFile();
        }
    }

    private static void g(String str) throws IOException {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            f(file.getParentFile().getAbsolutePath());
            b(file);
        }
    }

    public static void a(String str, String str2) {
        FileInputStream fileInputStream;
        Throwable th;
        FileOutputStream fileOutputStream;
        if (h(str)) {
            FileOutputStream fileOutputStream2 = null;
            fileOutputStream2 = null;
            FileInputStream fileInputStream2 = null;
            try {
                File file = new File(str);
                File file2 = new File(str2);
                g(file2.getAbsolutePath());
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read > 0) {
                                fileOutputStream.write(bArr, 0, read);
                            } else {
                                fileOutputStream.flush();
                                try {
                                    fileInputStream.close();
                                    fileOutputStream.close();
                                    return;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    return;
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = fileInputStream;
                        try {
                            fileInputStream2.close();
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                    fileInputStream2 = fileInputStream;
                    fileInputStream2.close();
                    fileOutputStream.close();
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                fileInputStream2.close();
                fileOutputStream.close();
                throw th;
            }
        }
    }

    public static void b(String str, String str2) {
        FileInputStream fileInputStream;
        Throwable th;
        FileOutputStream fileOutputStream;
        if (h(str)) {
            FileOutputStream fileOutputStream2 = null;
            fileOutputStream2 = null;
            FileInputStream fileInputStream2 = null;
            try {
                File file = new File(str);
                File file2 = new File(str2 + File.separator + file.getName());
                f(str2);
                g(file2.getAbsolutePath());
                fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(new byte[32]);
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    fileInputStream2 = fileInputStream;
                    try {
                        fileInputStream2.close();
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileOutputStream.flush();
                            try {
                                fileInputStream.close();
                                fileOutputStream.close();
                                return;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                return;
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream2 = fileInputStream;
                    fileInputStream2.close();
                    fileOutputStream.close();
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                fileInputStream2.close();
                fileOutputStream.close();
                throw th;
            }
        }
    }

    public static void a(Context context, String str, String str2) {
        if (c(new File(str))) {
            byte[] bArr = new byte[1024];
            try {
                FileInputStream fileInputStream = new FileInputStream(str);
                ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
                for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                    String name = nextEntry.getName();
                    if (name != null && name.endsWith(".so")) {
                        String a2 = a(context, name);
                        File file = new File(str2 + File.separator + a2);
                        b(file);
                        new File(file.getParent()).mkdirs();
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.close();
                    }
                    zipInputStream.closeEntry();
                }
                zipInputStream.closeEntry();
                zipInputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean h(String str) {
        return c(new File(str));
    }

    private static boolean c(File file) {
        return file.exists();
    }

    public static boolean c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str.equals(rg.a(str2));
    }

    private static String b(Context context, String str) {
        if (context == null) {
            return rg.b(str);
        }
        return rg.b(rd.v(context) + str);
    }
}
