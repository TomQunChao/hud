package com.amap.api.col.stln3;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.amap.api.col.stln3.tm;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.util.HashMap;

/* compiled from: ImageCache */
public final class ig {
    private static final Bitmap.CompressFormat a = Bitmap.CompressFormat.PNG;
    private tm b;
    private hp<String, Bitmap> c;
    private a d;
    private final Object e = new Object();
    private boolean f;
    private HashMap<String, WeakReference<Bitmap>> g;

    private ig(a aVar) {
        boolean z = true;
        this.f = true;
        this.d = aVar;
        if (this.d.f) {
            if (Build.VERSION.SDK_INT < 11 ? false : z) {
                this.g = new HashMap<>(64);
            }
            this.c = new hp<String, Bitmap>(this.d.a) {
                /* class com.amap.api.col.stln3.ig.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* access modifiers changed from: protected */
                @Override // com.amap.api.col.stln3.hp
                public final /* synthetic */ int b(Bitmap bitmap) {
                    int a2 = ig.a(bitmap);
                    if (a2 == 0) {
                        return 1;
                    }
                    return a2;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                /* access modifiers changed from: protected */
                @Override // com.amap.api.col.stln3.hp
                public final /* synthetic */ void b(String str, Bitmap bitmap) {
                    String str2 = str;
                    Bitmap bitmap2 = bitmap;
                    if (ic.d() && ig.this.g != null && bitmap2 != null && !bitmap2.isRecycled()) {
                        ig.this.g.put(str2, new WeakReference(bitmap2));
                    }
                }
            };
        }
        if (aVar.h) {
            a();
        }
    }

    public static ig a(a aVar) {
        return new ig(aVar);
    }

    public final void a() {
        long j;
        synchronized (this.e) {
            if (this.b != null) {
                if (!this.b.c()) {
                    this.f = false;
                    this.e.notifyAll();
                }
            }
            File file = this.d.c;
            if (this.d.g && file != null) {
                try {
                    if (!file.exists()) {
                        file.mkdirs();
                    } else if (this.d.i) {
                        a(file);
                        file.mkdir();
                    }
                } catch (Throwable th) {
                }
                if (ic.c()) {
                    j = file.getUsableSpace();
                } else {
                    StatFs statFs = new StatFs(file.getPath());
                    j = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
                }
                if (j > this.d.b) {
                    try {
                        this.b = tm.a(file, this.d.b);
                    } catch (Throwable th2) {
                        this.d.c = null;
                    }
                }
            }
            this.f = false;
            this.e.notifyAll();
        }
    }

    private void a(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    a(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + file);
    }

    public final void a(String str, Bitmap bitmap) {
        if (str != null && bitmap != null && !bitmap.isRecycled()) {
            hp<String, Bitmap> hpVar = this.c;
            if (hpVar != null) {
                hpVar.a(str, bitmap);
            }
            synchronized (this.e) {
                if (this.b != null) {
                    String c2 = c(str);
                    OutputStream outputStream = null;
                    try {
                        tm.b a2 = this.b.a(c2);
                        if (a2 == null) {
                            tm.a b2 = this.b.b(c2);
                            if (b2 != null) {
                                outputStream = b2.a();
                                bitmap.compress(this.d.d, this.d.e, outputStream);
                                b2.b();
                                outputStream.close();
                            }
                        } else {
                            a2.a().close();
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable th) {
                            }
                        }
                    } catch (Throwable th2) {
                    }
                }
            }
            return;
        }
        return;
        throw th;
    }

    public final Bitmap a(String str) {
        Bitmap bitmap;
        hp<String, Bitmap> hpVar;
        HashMap<String, WeakReference<Bitmap>> hashMap;
        WeakReference<Bitmap> weakReference;
        if (!ic.d() || (hashMap = this.g) == null || (weakReference = hashMap.get(str)) == null) {
            bitmap = null;
        } else {
            bitmap = weakReference.get();
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = null;
            }
            this.g.remove(str);
        }
        if (bitmap == null && (hpVar = this.c) != null) {
            bitmap = hpVar.a(str);
        }
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x004d A[SYNTHETIC, Splitter:B:29:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005c A[SYNTHETIC, Splitter:B:36:0x005c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap b(java.lang.String r4) {
        /*
        // Method dump skipped, instructions count: 106
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ig.b(java.lang.String):android.graphics.Bitmap");
    }

    public final void b() {
        HashMap<String, WeakReference<Bitmap>> hashMap;
        if (ic.d() && (hashMap = this.g) != null) {
            hashMap.clear();
        }
        hp<String, Bitmap> hpVar = this.c;
        if (hpVar != null) {
            hpVar.a();
        }
        synchronized (this.e) {
            this.f = true;
            if (this.b != null && !this.b.c()) {
                try {
                    this.b.close();
                    a(a(ct.a, this.d.j, null));
                } catch (Throwable th) {
                }
                this.b = null;
                a();
            }
        }
    }

    public final void c() {
        synchronized (this.e) {
            if (this.b != null) {
                try {
                    this.b.d();
                } catch (Throwable th) {
                }
            }
        }
    }

    public final void a(boolean z) {
        HashMap<String, WeakReference<Bitmap>> hashMap;
        if (ic.d() && (hashMap = this.g) != null) {
            hashMap.clear();
        }
        hp<String, Bitmap> hpVar = this.c;
        if (hpVar != null) {
            hpVar.a();
        }
        synchronized (this.e) {
            if (this.b != null) {
                try {
                    if (!this.b.c()) {
                        if (z) {
                            this.b.e();
                        } else {
                            this.b.close();
                        }
                        this.b = null;
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    /* compiled from: ImageCache */
    public static class a {
        public int a = 5242880;
        public long b = 10485760;
        public File c;
        public Bitmap.CompressFormat d = ig.a;
        public int e = 100;
        public boolean f = true;
        public boolean g = true;
        public boolean h = false;
        public boolean i = true;
        public String j = null;

        public a(Context context, String str) {
            this.j = str;
            this.c = ig.a(context, str, null);
        }

        public a(Context context, String str, String str2) {
            this.j = str;
            this.c = ig.a(context, str, str2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((com.amap.api.col.stln3.ic.c() ? android.os.Environment.isExternalStorageRemovable() : true) == false) goto L_0x0020;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File a(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.io.File r0 = a(r3)
            java.lang.String r1 = "mounted"
            java.lang.String r2 = android.os.Environment.getExternalStorageState()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x001f
            boolean r1 = com.amap.api.col.stln3.ic.c()
            if (r1 == 0) goto L_0x001b
            boolean r1 = android.os.Environment.isExternalStorageRemovable()
            goto L_0x001c
        L_0x001b:
            r1 = 1
        L_0x001c:
            if (r1 != 0) goto L_0x0027
            goto L_0x0020
        L_0x001f:
        L_0x0020:
            if (r0 == 0) goto L_0x0027
            java.lang.String r3 = r0.getPath()
            goto L_0x0030
        L_0x0027:
            java.io.File r3 = r3.getCacheDir()
            java.lang.String r3 = r3.getPath()
        L_0x0030:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            java.lang.String r3 = java.io.File.separator
            r0.append(r3)
            r0.append(r4)
            boolean r3 = android.text.TextUtils.isEmpty(r5)
            if (r3 != 0) goto L_0x004f
            java.lang.String r3 = java.io.File.separator
            r0.append(r3)
            r0.append(r5)
            goto L_0x0050
        L_0x004f:
        L_0x0050:
            java.io.File r3 = new java.io.File
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ig.a(android.content.Context, java.lang.String, java.lang.String):java.io.File");
    }

    private static String c(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes("utf-8"));
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Throwable th) {
            return String.valueOf(str.hashCode());
        }
    }

    public static int a(Bitmap bitmap) {
        if (ic.e()) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    private static File a(Context context) {
        try {
            if (ic.b()) {
                return context.getExternalCacheDir();
            }
            return new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/cache/"));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
