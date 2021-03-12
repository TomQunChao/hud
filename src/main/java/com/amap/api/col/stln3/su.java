package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.stln3.qz;
import com.autonavi.amap.mapcore.NativeConfigInfo;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: SoLoader */
public final class su {
    private WeakReference<Context> a;
    private tj b = new tj();

    /* access modifiers changed from: package-private */
    /* compiled from: SoLoader */
    public static class a {
        public static su a = new su();
    }

    public static su a() {
        return a.a;
    }

    public final boolean a(Context context, sv svVar, String str) {
        if (svVar == null || TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        boolean b2 = svVar.b();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (context == null || svVar == null) {
            a(str);
            return false;
        }
        a(context);
        return this.b.a(context, svVar, str, b2);
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            System.loadLibrary(str);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public final void a(Context context, sv svVar, qz.a.f fVar) {
        if (fVar != null && svVar != null && context != null) {
            a(context);
            this.b.a(context, svVar, fVar.a, fVar.b, fVar.e, fVar.f, fVar.d, fVar.c);
        }
    }

    public static void a(Context context, rj rjVar, List<String> list) {
        String str;
        if (context != null) {
            String a2 = rv.a(context);
            if (!TextUtils.isEmpty(a2)) {
                if (list == null || list.size() == 0) {
                    str = "";
                } else {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i = 0; i < list.size(); i++) {
                        if (!TextUtils.isEmpty(list.get(i))) {
                            String str2 = list.get(i);
                            if (TextUtils.isEmpty(str2)) {
                                str2 = "";
                            } else {
                                if (!str2.startsWith("lib")) {
                                    str2 = "lib" + str2;
                                }
                                if (!str2.endsWith(".so")) {
                                    str2 = str2 + ".so";
                                }
                            }
                            stringBuffer.append(str2);
                            stringBuffer.append(",");
                            stringBuffer.append(sw.a(context, str2));
                            if (i < list.size() - 1) {
                                stringBuffer.append(",");
                            }
                        }
                    }
                    str = stringBuffer.toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    File file = new File(a2);
                    if (!file.isDirectory() || !file.exists()) {
                        if (file.isFile() && file.exists()) {
                            file.delete();
                        }
                        file.mkdirs();
                    }
                    NativeConfigInfo.nativeInit(a2, "defconfig", str);
                }
            }
        }
        a.a.b.a(rjVar, list);
    }

    private void a(Context context) {
        if (context != null && context.getApplicationContext() != null) {
            this.a = null;
            this.a = new WeakReference<>(context.getApplicationContext());
        }
    }
}
