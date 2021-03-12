package com.amap.api.col.stln3;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: UnZipFile */
public final class ew {
    private b a;

    /* compiled from: UnZipFile */
    public static class a {
        public boolean a = false;
    }

    /* compiled from: UnZipFile */
    public interface c {
        void a();

        void a(long j);
    }

    public ew(et etVar, es esVar) {
        this.a = new b(etVar, esVar);
    }

    public final void a() {
        b bVar = this.a;
        if (bVar != null) {
            bVar.f();
        }
    }

    public final void b() {
        b bVar = this.a;
        if (bVar != null && bVar != null) {
            final es d = bVar.d();
            if (d != null) {
                d.p();
            }
            String a2 = bVar.a();
            String b2 = bVar.b();
            if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(b2)) {
                File file = new File(a2);
                if (file.exists()) {
                    File file2 = new File(b2);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    AnonymousClass1 r3 = new c() {
                        /* class com.amap.api.col.stln3.ew.AnonymousClass1 */

                        @Override // com.amap.api.col.stln3.ew.c
                        public final void a(long j) {
                            try {
                                if (d != null) {
                                    d.a(j);
                                }
                            } catch (Exception e) {
                            }
                        }

                        @Override // com.amap.api.col.stln3.ew.c
                        public final void a() {
                            es esVar = d;
                            if (esVar != null) {
                                esVar.q();
                            }
                        }
                    };
                    try {
                        if (bVar.e().a && d != null) {
                            d.r();
                        }
                        a(file, file2, r3, bVar);
                        if (bVar.e().a) {
                            if (d != null) {
                                d.r();
                                return;
                            }
                            return;
                        } else if (d != null) {
                            d.b(bVar.c());
                            return;
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        if (bVar.e().a) {
                            if (d == null) {
                                return;
                            }
                        } else if (d != null) {
                            d.q();
                            return;
                        } else {
                            return;
                        }
                    }
                } else if (bVar.e().a) {
                    if (d == null) {
                        return;
                    }
                } else if (d != null) {
                    d.q();
                    return;
                } else {
                    return;
                }
            } else if (bVar.e().a) {
                if (d == null) {
                    return;
                }
            } else if (d != null) {
                d.q();
                return;
            } else {
                return;
            }
            d.r();
        }
    }

    private static void a(File file, File file2, c cVar, b bVar) throws Exception {
        long j;
        StringBuffer stringBuffer = new StringBuffer();
        a e = bVar.e();
        long j2 = 0;
        if (cVar != null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new CRC32());
                ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        if (e != null && e.a) {
                            zipInputStream.closeEntry();
                            zipInputStream.close();
                            checkedInputStream.close();
                            fileInputStream.close();
                            break;
                        }
                        if (!nextEntry.isDirectory()) {
                            if (!a(nextEntry.getName())) {
                                cVar.a();
                                break;
                            } else {
                                stringBuffer.append(nextEntry.getName());
                                stringBuffer.append(";");
                            }
                        }
                        j2 += nextEntry.getSize();
                        zipInputStream.closeEntry();
                    } else {
                        break;
                    }
                }
                bVar.a(stringBuffer.toString());
                zipInputStream.close();
                checkedInputStream.close();
                fileInputStream.close();
                j = j2;
            } catch (Exception e2) {
                e2.printStackTrace();
                j = 0;
            }
        } else {
            j = 0;
        }
        FileInputStream fileInputStream2 = new FileInputStream(file);
        CheckedInputStream checkedInputStream2 = new CheckedInputStream(fileInputStream2, new CRC32());
        ZipInputStream zipInputStream2 = new ZipInputStream(checkedInputStream2);
        a(file2, zipInputStream2, j, cVar, e);
        zipInputStream2.close();
        checkedInputStream2.close();
        fileInputStream2.close();
    }

    private static void a(File file, ZipInputStream zipInputStream, long j, c cVar, a aVar) throws Exception {
        int i = 0;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return;
            }
            if (aVar == null || !aVar.a) {
                String str = file.getPath() + File.separator + nextEntry.getName();
                if (a(nextEntry.getName())) {
                    File file2 = new File(str);
                    a(file2);
                    if (nextEntry.isDirectory()) {
                        file2.mkdirs();
                    } else {
                        i += a(file2, zipInputStream, (long) i, j, cVar, aVar);
                    }
                    zipInputStream.closeEntry();
                } else if (cVar != null) {
                    cVar.a();
                    return;
                } else {
                    return;
                }
            } else {
                zipInputStream.closeEntry();
                return;
            }
        }
    }

    private static boolean a(String str) {
        if (str.contains("..") || str.contains("/") || str.contains("\\") || str.contains("%")) {
            return false;
        }
        return true;
    }

    private static int a(File file, ZipInputStream zipInputStream, long j, long j2, c cVar, a aVar) throws Exception {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bArr = new byte[1024];
        int i = 0;
        while (true) {
            int read = zipInputStream.read(bArr, 0, 1024);
            if (read == -1) {
                bufferedOutputStream.close();
                return i;
            } else if (aVar == null || !aVar.a) {
                bufferedOutputStream.write(bArr, 0, read);
                i += read;
                if (j2 > 0 && cVar != null) {
                    long j3 = ((((long) i) + j) * 100) / j2;
                    if (aVar == null || !aVar.a) {
                        cVar.a(j3);
                    }
                }
            } else {
                bufferedOutputStream.close();
                return i;
            }
        }
    }

    private static void a(File file) {
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            a(parentFile);
            parentFile.mkdir();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: UnZipFile */
    public static class b {
        private String a;
        private String b;
        private es c = null;
        private a d = new a();
        private String e;

        public b(et etVar, es esVar) {
            this.a = etVar.x();
            this.b = etVar.y();
            this.c = esVar;
        }

        public final void a(String str) {
            if (str.length() > 1) {
                this.e = str;
            }
        }

        public final String a() {
            return this.a;
        }

        public final String b() {
            return this.b;
        }

        public final String c() {
            return this.e;
        }

        public final es d() {
            return this.c;
        }

        public final a e() {
            return this.d;
        }

        public final void f() {
            this.d.a = true;
        }
    }
}
