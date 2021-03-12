package com.amap.api.col.stln3;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ResourcesUtil */
public class mm {
    static mk a = null;
    public static int b = -1;
    private static AssetManager c = null;
    private static Resources d = null;
    private static Resources e = null;
    private static boolean f = true;
    private static Context g;
    private static String h = "autonavi_Resource";
    private static String i = "1_1_0";
    private static String j = ".png";
    private static String k = ".jar";
    private static String l = (h + i + k);
    private static String m = (h + i + j);
    private static String n = "";
    private static String o = (n + l);
    private static Resources.Theme p = null;
    private static Resources.Theme q = null;
    private static Field r = null;
    private static Field s = null;

    public static boolean a(Context context) {
        try {
            g = context;
            File a2 = mj.a(context);
            if (a2 != null) {
                n = a2.getAbsolutePath() + "/";
                o = n + l;
            }
            if (!f) {
                return true;
            }
            if (!b(context)) {
                return false;
            }
            c = a(o);
            d = a(context, c);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static Resources a() {
        Resources resources = d;
        if (resources == null) {
            return g.getResources();
        }
        return resources;
    }

    private static Resources a(Context context, AssetManager assetManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setToDefaults();
        return new Resources(assetManager, displayMetrics, context.getResources().getConfiguration());
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

    private static boolean b(Context context) {
        boolean z;
        n = context.getFilesDir().getAbsolutePath();
        o = n + "/" + l;
        InputStream inputStream = null;
        try {
            InputStream open = context.getResources().getAssets().open(m);
            File file = new File(o);
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
            g();
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
        FileOutputStream fileOutputStream = new FileOutputStream(new File(n, l));
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return fileOutputStream;
            }
            fileOutputStream.write(bArr, 0, read);
        }
    }

    private static void g() {
        File[] listFiles = new File(n).listFiles(new a());
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                file.delete();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public static View a(Context context, int i2, ViewGroup viewGroup) {
        XmlResourceParser xml = a().getXml(i2);
        if (!f) {
            return LayoutInflater.from(context).inflate(xml, viewGroup);
        }
        try {
            int i3 = 0;
            if (a == null) {
                a = new mk(context, b == -1 ? 0 : b, mm.class.getClassLoader());
            }
            mk mkVar = a;
            if (b != -1) {
                i3 = b;
            }
            mkVar.a(i3);
            View inflate = LayoutInflater.from(a).inflate(xml, viewGroup);
            xml.close();
            return inflate;
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }

    public static Resources.Theme b() {
        try {
            if (p == null) {
                if (c == null) {
                    c = a(o);
                }
                if (d == null) {
                    d = a(g, c);
                }
                p = d.newTheme();
                p.applyStyle(b("com.android.internal.R.style.Theme"), true);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "ResourcesUtil", "getTheme()");
        }
        return p;
    }

    private static int b(String str) {
        try {
            String substring = str.substring(0, str.indexOf(".R.") + 2);
            int lastIndexOf = str.lastIndexOf(".");
            String substring2 = str.substring(lastIndexOf + 1, str.length());
            String substring3 = str.substring(0, lastIndexOf);
            String substring4 = substring3.substring(substring3.lastIndexOf(".") + 1, substring3.length());
            return Class.forName(substring + "$" + substring4).getDeclaredField(substring2).getInt(null);
        } catch (Throwable th) {
            rx.c(th, "ResourcesUtil", "getInnerRIdValue(String rStrnig)");
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.view.animation.Animation a(android.content.Context r3, int r4) throws android.content.res.Resources.NotFoundException {
        /*
            android.content.res.Resources$NotFoundException r0 = new android.content.res.Resources$NotFoundException
            r0.<init>()
            r1 = 0
            android.content.res.Resources r2 = a()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x002b }
            android.content.res.XmlResourceParser r4 = r2.getAnimation(r4)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x002b }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r4)     // Catch:{ XmlPullParserException -> 0x0026, IOException -> 0x0023, all -> 0x0020 }
            android.view.animation.Animation r3 = a(r3, r4, r1, r2)     // Catch:{ XmlPullParserException -> 0x0026, IOException -> 0x0023, all -> 0x0020 }
            if (r4 == 0) goto L_0x001d
            r4.close()
            goto L_0x001e
        L_0x001d:
        L_0x001e:
            return r3
        L_0x0020:
            r3 = move-exception
            r1 = r4
            goto L_0x003d
        L_0x0023:
            r3 = move-exception
            r1 = r4
            goto L_0x002c
        L_0x0026:
            r3 = move-exception
            r1 = r4
            goto L_0x0035
        L_0x0029:
            r3 = move-exception
            goto L_0x003d
        L_0x002b:
            r3 = move-exception
        L_0x002c:
            java.lang.String r4 = "ResourcesUtil"
            java.lang.String r2 = "loadAnimation(Context context, int id)"
            com.amap.api.col.stln3.rx.c(r3, r4, r2)     // Catch:{ all -> 0x0029 }
            throw r0     // Catch:{ all -> 0x0029 }
        L_0x0034:
            r3 = move-exception
        L_0x0035:
            java.lang.String r4 = "ResourcesUtil"
            java.lang.String r2 = "loadAnimation(Context context, int id)"
            com.amap.api.col.stln3.rx.c(r3, r4, r2)     // Catch:{ all -> 0x0029 }
            throw r0     // Catch:{ all -> 0x0029 }
        L_0x003d:
            if (r1 == 0) goto L_0x0044
            r1.close()
        L_0x0044:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.mm.a(android.content.Context, int):android.view.animation.Animation");
    }

    private static Animation a(Context context, XmlPullParser xmlPullParser, AnimationSet animationSet, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int next;
        Animation animation;
        int depth = xmlPullParser.getDepth();
        do {
            next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
            }
        } while (next != 2);
        String name = xmlPullParser.getName();
        if ("set".equals(name)) {
            animation = new AnimationSet(context, attributeSet);
            a(context, xmlPullParser, (AnimationSet) animation, attributeSet);
        } else if ("alpha".equals(name)) {
            animation = new AlphaAnimation(context, attributeSet);
        } else if ("scale".equals(name)) {
            animation = new ScaleAnimation(context, attributeSet);
        } else if ("rotate".equals(name)) {
            animation = new RotateAnimation(context, attributeSet);
        } else if ("translate".equals(name)) {
            animation = new TranslateAnimation(context, attributeSet);
        } else {
            throw new RuntimeException("Unknown animation name: " + xmlPullParser.getName());
        }
        if (animationSet != null) {
            animationSet.addAnimation(animation);
        }
        return animation;
    }

    public static void c() {
        a = null;
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ResourcesUtil */
    public static class a implements FilenameFilter {
        a() {
        }

        public final boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(mm.i);
            sb.append(mm.k);
            return str.startsWith(mm.h) && !str.endsWith(sb.toString());
        }
    }

    public static void b(Context context, int i2) {
        if (!f) {
            context.setTheme(i2);
            b = -1;
            return;
        }
        b = i2;
    }
}
