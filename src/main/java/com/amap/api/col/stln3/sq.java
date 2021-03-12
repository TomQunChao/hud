package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.stln3.ss;
import dalvik.system.DexFile;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* access modifiers changed from: package-private */
/* compiled from: DynamicLoader */
public final class sq extends sl {
    private PublicKey i = null;

    sq(final Context context, rj rjVar) throws Exception {
        super(context, rjVar);
        ss.a aVar = null;
        final String b = sn.b(context, rjVar.a(), rjVar.b());
        final String a = sn.a(context);
        if (TextUtils.isEmpty(b) || TextUtils.isEmpty(a)) {
            throw new Exception("dexPath or dexOutputDir is null.");
        }
        File file = new File(b);
        if (!ss.b().a(this.e).b) {
            String str = a + File.separator + sn.a(file.getName());
            try {
                if (this.c == null) {
                    ss.a a2 = ss.b().a(this.e);
                    if (a2 != null) {
                        a2.a = true;
                    }
                    b();
                    if (!a2.b) {
                        this.c = DexFile.loadDex(b, str, 0);
                        if (a2 != null) {
                            try {
                                a2.a = false;
                                synchronized (a2) {
                                    a2.notify();
                                }
                            } catch (Throwable th) {
                            }
                        }
                    } else {
                        throw new Exception("file is downloading");
                    }
                }
                try {
                    ss.b().a().submit(new Runnable() {
                        /* class com.amap.api.col.stln3.sq.AnonymousClass1 */

                        public final void run() {
                            try {
                                sq.this.a(context, b, a);
                            } catch (Throwable th) {
                                ru.a(th, "dLoader", "run()");
                            }
                        }
                    });
                    return;
                } catch (Throwable th2) {
                    return;
                }
            } catch (Throwable th3) {
            }
        } else {
            throw new Exception("file is downloading");
        }
        throw th;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0051, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0052, code lost:
        com.amap.api.col.stln3.ru.a(r2, "dLoader", "findCl");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0072, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0074, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        com.amap.api.col.stln3.ru.a(r1, "dLoader", "findCl");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0081, code lost:
        throw new java.lang.ClassNotFoundException(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0082, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0083, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0084, code lost:
        r6.h = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0086, code lost:
        throw r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0082 A[Catch:{ Throwable -> 0x0051, ClassNotFoundException -> 0x0082, ClassNotFoundException -> 0x0082, Throwable -> 0x0074, all -> 0x0072 }, ExcHandler: ClassNotFoundException (r7v1 'e' java.lang.ClassNotFoundException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:1:0x0001] */
    @Override // java.lang.ClassLoader
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Class<?> findClass(java.lang.String r7) throws java.lang.ClassNotFoundException {
        /*
        // Method dump skipped, instructions count: 135
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.sq.findClass(java.lang.String):java.lang.Class");
    }

    private static void a(JarFile jarFile, JarEntry jarEntry) throws IOException {
        try {
            InputStream inputStream = jarFile.getInputStream(jarEntry);
            do {
            } while (inputStream.read(new byte[8192]) > 0);
            try {
                st.a(inputStream);
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        } catch (Throwable th2) {
            try {
                ru.a(th2, "DyLoader", "loadJa");
                st.a((Closeable) null);
                return;
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
        throw th;
    }

    private boolean a(Certificate[] certificateArr) {
        int length;
        try {
            if (certificateArr.length <= 0 || (length = certificateArr.length - 1) < 0) {
                return false;
            }
            certificateArr[length].verify(this.i);
            return true;
        } catch (Exception e) {
            ru.a(e, "DyLoader", "check");
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x004b A[SYNTHETIC, Splitter:B:35:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0057 A[SYNTHETIC, Splitter:B:40:0x0057] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.io.File r5) {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
            java.security.PublicKey r2 = r4.i     // Catch:{ Throwable -> 0x0041 }
            if (r2 != 0) goto L_0x000d
            java.security.PublicKey r2 = com.amap.api.col.stln3.st.a()     // Catch:{ Throwable -> 0x0041 }
            r4.i = r2     // Catch:{ Throwable -> 0x0041 }
        L_0x000d:
            java.util.jar.JarFile r2 = new java.util.jar.JarFile     // Catch:{ Throwable -> 0x0041 }
            r2.<init>(r5)     // Catch:{ Throwable -> 0x0041 }
            java.lang.String r5 = "classes.dex"
            java.util.jar.JarEntry r5 = r2.getJarEntry(r5)     // Catch:{ Throwable -> 0x003c, all -> 0x0039 }
            if (r5 != 0) goto L_0x0020
            r2.close()     // Catch:{ Throwable -> 0x001e }
            goto L_0x001f
        L_0x001e:
            r5 = move-exception
        L_0x001f:
            return r0
        L_0x0020:
            a(r2, r5)
            java.security.cert.Certificate[] r5 = r5.getCertificates()
            if (r5 != 0) goto L_0x002f
            r2.close()     // Catch:{ Throwable -> 0x002d }
            goto L_0x002e
        L_0x002d:
            r5 = move-exception
        L_0x002e:
            return r0
        L_0x002f:
            boolean r5 = r4.a(r5)
            r2.close()     // Catch:{ Throwable -> 0x0037 }
            goto L_0x0038
        L_0x0037:
            r0 = move-exception
        L_0x0038:
            return r5
        L_0x0039:
            r5 = move-exception
            r1 = r2
            goto L_0x0054
        L_0x003c:
            r5 = move-exception
            r1 = r2
            goto L_0x0042
        L_0x003f:
            r5 = move-exception
            goto L_0x0054
        L_0x0041:
            r5 = move-exception
        L_0x0042:
            java.lang.String r2 = "DyLoader"
            java.lang.String r3 = "verify"
            com.amap.api.col.stln3.ru.a(r5, r2, r3)     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x0051
            r1.close()     // Catch:{ Throwable -> 0x004f }
            goto L_0x0052
        L_0x004f:
            r5 = move-exception
            goto L_0x0053
        L_0x0051:
        L_0x0052:
        L_0x0053:
            return r0
        L_0x0054:
            if (r1 == 0) goto L_0x005d
            r1.close()     // Catch:{ Throwable -> 0x005b }
            goto L_0x005e
        L_0x005b:
            r0 = move-exception
            goto L_0x005f
        L_0x005d:
        L_0x005e:
        L_0x005f:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.sq.a(java.io.File):boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f2 A[Catch:{ Throwable -> 0x00fd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r11, java.lang.String r12, java.lang.String r13) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 270
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.sq.a(android.content.Context, java.lang.String, java.lang.String):void");
    }
}
