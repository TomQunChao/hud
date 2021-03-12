package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.stln3.sr;
import com.amap.api.col.stln3.ss;
import dalvik.system.DexFile;
import java.io.File;
import java.util.List;

/* compiled from: DexFileManager */
public final class sn {

    /* compiled from: DexFileManager */
    public static class a {
        static sr a(sc scVar, String str) {
            List b = scVar.b(sr.b(str), sr.class);
            if (b == null || b.size() <= 0) {
                return null;
            }
            return (sr) b.get(0);
        }

        public static List<sr> a(sc scVar, String str, String str2) {
            return scVar.b(sr.b(str, str2), sr.class);
        }
    }

    static String a(String str) {
        return str + ".o";
    }

    static String a(Context context, String str, String str2) {
        String v = rd.v(context);
        return rg.b(str + str2 + v) + ".jar";
    }

    static String b(Context context, String str, String str2) {
        return a(context, a(context, str, str2));
    }

    public static String a(Context context, String str) {
        return a(context) + File.separator + str;
    }

    static String a(Context context) {
        return context.getFilesDir().getAbsolutePath() + File.separator + "pngex";
    }

    static void a(Context context, rj rjVar) {
        try {
            ss.a a2 = ss.b().a(rjVar);
            if (a2 != null && a2.a) {
                synchronized (a2) {
                    a2.wait();
                }
            }
            a2.b = true;
            String b = b(context, rjVar.a(), rjVar.b());
            if (!TextUtils.isEmpty(b)) {
                File file = new File(b);
                File parentFile = file.getParentFile();
                if (file.exists()) {
                    String a3 = a(context, a(file.getName()));
                    DexFile loadDex = DexFile.loadDex(b, a3, 0);
                    if (loadDex != null) {
                        loadDex.close();
                        String str = null;
                        sc scVar = new sc(context, sp.a());
                        sr a4 = a.a(scVar, file.getName());
                        if (a4 != null) {
                            str = a4.e();
                        }
                        File file2 = new File(a3);
                        if (!TextUtils.isEmpty(str) && file2.exists()) {
                            String a5 = rg.a(a3);
                            String name = file2.getName();
                            scVar.a(new sr.a(name, a5, rjVar.a(), rjVar.b(), str).a("useod").a(), sr.b(name));
                        }
                    }
                    a2.b = false;
                } else if (parentFile != null && parentFile.exists()) {
                    c(context, rjVar.a(), rjVar.b());
                }
            }
        } catch (Throwable th) {
            ru.a(th, "BaseLoader", "getInstanceByThread()");
        }
    }

    static void b(Context context, String str) {
        sc scVar = new sc(context, sp.a());
        List<sr> a2 = a.a(scVar, str, "copy");
        st.a(a2);
        if (a2 != null) {
            if (a2.size() > 1) {
                int size = a2.size();
                for (int i = 1; i < size; i++) {
                    c(context, scVar, a2.get(i).a());
                }
            }
        }
    }

    static void a(Context context, sc scVar, String str) {
        c(context, scVar, a(str));
        c(context, scVar, str);
    }

    private static void c(final Context context, final String str, final String str2) {
        try {
            ss.b().a().submit(new Runnable() {
                /* class com.amap.api.col.stln3.sn.AnonymousClass1 */

                public final void run() {
                    try {
                        sc scVar = new sc(context, sp.a());
                        List<sr> b2 = scVar.b(sr.a(str), sr.class);
                        if (b2 != null && b2.size() > 0) {
                            for (sr srVar : b2) {
                                if (!str2.equalsIgnoreCase(srVar.d())) {
                                    sn.c(context, scVar, srVar.a());
                                }
                            }
                        }
                    } catch (Throwable th) {
                        ru.a(th, "FileManager", "clearUnSuitableV");
                    }
                }
            });
        } catch (Throwable th) {
        }
    }

    static void a(sc scVar, Context context, String str) {
        List<sr> a2 = a.a(scVar, str, "used");
        if (a2 != null && a2.size() > 0) {
            for (sr srVar : a2) {
                if (srVar != null && srVar.c().equals(str)) {
                    a(context, scVar, srVar.a());
                    List b = scVar.b(sr.a(str, srVar.e()), sr.class);
                    if (b != null && b.size() > 0) {
                        sr srVar2 = (sr) b.get(0);
                        srVar2.c("errorstatus");
                        scVar.a(srVar2, sr.b(srVar2.a()));
                        File file = new File(a(context, srVar2.a()));
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v5, resolved type: java.io.RandomAccessFile */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0128 A[SYNTHETIC, Splitter:B:70:0x0128] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(android.content.Context r16, com.amap.api.col.stln3.sc r17, com.amap.api.col.stln3.rj r18, java.lang.String r19, java.lang.String r20) throws java.lang.Throwable {
        /*
        // Method dump skipped, instructions count: 307
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.sn.a(android.content.Context, com.amap.api.col.stln3.sc, com.amap.api.col.stln3.rj, java.lang.String, java.lang.String):void");
    }

    static String a(Context context, sc scVar, rj rjVar) {
        List b = scVar.b(sr.b(rjVar.a(), "copy"), sr.class);
        String str = null;
        if (b == null || b.size() == 0) {
            return null;
        }
        st.a(b);
        for (int i = 0; i < b.size(); i++) {
            sr srVar = (sr) b.get(i);
            String a2 = srVar.a();
            if (st.a(scVar, a2, a(context, a2), rjVar)) {
                try {
                    a(context, scVar, rjVar, a(context, srVar.a()), srVar.e());
                    str = srVar.e();
                    break;
                } catch (Throwable th) {
                    ru.a(th, "FileManager", "loadAvailableD");
                }
            } else {
                c(context, scVar, srVar.a());
            }
        }
        return str;
    }

    static void a(Context context, File file, rj rjVar) {
        File parentFile = file.getParentFile();
        if (!file.exists() && parentFile != null && parentFile.exists()) {
            c(context, rjVar.a(), rjVar.b());
        }
    }

    /* access modifiers changed from: private */
    public static void c(Context context, sc scVar, String str) {
        File file = new File(a(context, str));
        if (file.exists()) {
            file.delete();
        }
        scVar.a(sr.b(str), sr.class);
    }
}
