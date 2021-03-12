package com.amap.api.col.stln3;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

/* compiled from: ServiceUtils */
public class na {
    public static int a = -1;
    private static AssetManager b = null;
    private static Resources c = null;
    private static Resources d = null;
    private static boolean e = true;
    private static Context f;
    private static String g = "amap_resource";
    private static String h = "1_0_0";
    private static String i = ".png";
    private static String j = ".jar";
    private static String k = (g + h + j);
    private static String l = (g + h + i);
    private static String m = "";
    private static String n = (m + k);
    private static Resources.Theme o = null;
    private static Resources.Theme p = null;
    private static Field q = null;
    private static Field r = null;
    private static Activity s = null;

    public static boolean a(Context context) {
        try {
            f = context;
            File b2 = b(context);
            if (b2 != null) {
                m = b2.getAbsolutePath() + "/";
            }
            n = m + k;
            if (!e) {
                return true;
            }
            if (!c(context)) {
                return false;
            }
            b = a(n);
            AssetManager assetManager = b;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setToDefaults();
            c = new Resources(assetManager, displayMetrics, context.getResources().getConfiguration());
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static File b(Context context) {
        File file;
        if (context == null) {
            if (context != null) {
                context.getFilesDir();
            }
            return null;
        }
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                if (Environment.getExternalStorageDirectory().canWrite()) {
                    file = context.getExternalFilesDir("LBS");
                    if (file == null && context != null) {
                        context.getFilesDir();
                    }
                    return file;
                }
            }
            file = context.getFilesDir();
            context.getFilesDir();
            return file;
        } catch (Exception e2) {
            e2.printStackTrace();
            if (0 != 0 || context == null) {
                return null;
            }
            return context.getFilesDir();
        } catch (Throwable th) {
            if (0 == 0 && context != null) {
                context.getFilesDir();
            }
            throw th;
        }
    }

    public static Resources a() {
        Resources resources = c;
        if (resources == null) {
            return f.getResources();
        }
        return resources;
    }

    private static AssetManager a(String str) {
        AssetManager assetManager;
        Throwable th;
        try {
            Class<?> cls = Class.forName("android.content.res.AssetManager");
            assetManager = (AssetManager) cls.getConstructor(null).newInstance(null);
            try {
                cls.getDeclaredMethod("addAssetPath", String.class).invoke(assetManager, str);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            assetManager = null;
            rx.c(th, "ResourcesUtil", "getAssetManager(String apkPath)");
            return assetManager;
        }
        return assetManager;
    }

    private static boolean c(Context context) {
        boolean z;
        m = context.getFilesDir().getAbsolutePath();
        n = m + "/" + k;
        InputStream inputStream = null;
        try {
            InputStream open = context.getResources().getAssets().open(l);
            File file = new File(n);
            long length = file.length();
            int available = open.available();
            if (!file.exists() || length != ((long) available)) {
                z = false;
            } else {
                open.close();
                z = true;
            }
            if (z) {
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        rx.c(e2, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                    }
                }
                return true;
            }
            e();
            OutputStream a2 = a(open);
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                    rx.c(e3, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                }
            }
            if (a2 != null) {
                a2.close();
            }
            return true;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                    rx.c(e4, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                }
            }
            throw th;
        }
    }

    private static OutputStream a(InputStream inputStream) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(m, k));
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return fileOutputStream;
            }
            fileOutputStream.write(bArr, 0, read);
        }
    }

    private static void e() {
        File[] listFiles = new File(m).listFiles(new a());
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                file.delete();
            }
        }
    }

    public static View a(Context context, int i2) {
        XmlResourceParser xml = a().getXml(i2);
        View view = null;
        if (!e) {
            return LayoutInflater.from(context).inflate(xml, (ViewGroup) null);
        }
        try {
            view = LayoutInflater.from(new mz(context, a == -1 ? 0 : a, na.class.getClassLoader())).inflate(xml, (ViewGroup) null);
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
        xml.close();
        return view;
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ServiceUtils */
    public static class a implements FilenameFilter {
        a() {
        }

        public final boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(na.h);
            sb.append(na.j);
            return str.startsWith(na.g) && !str.endsWith(sb.toString());
        }
    }
}
