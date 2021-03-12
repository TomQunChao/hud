package com.amap.api.col.stln3;

import java.io.File;

/* compiled from: FileUtils */
public final class mi {
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a8, code lost:
        r7 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00aa, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ab, code lost:
        r0 = r6;
        r6 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r0.closeEntry();
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c1, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c2, code lost:
        r6.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r6.closeEntry();
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d5, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d6, code lost:
        r6.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a8 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:9:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ba A[SYNTHETIC, Splitter:B:40:0x00ba] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ce A[SYNTHETIC, Splitter:B:45:0x00ce] */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r6, java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 222
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.mi.a(java.lang.String, java.lang.String):void");
    }

    public static void a(String str) {
        if (str != null) {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    return;
                }
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            a(file2.getAbsolutePath());
                        } else {
                            file2.delete();
                        }
                    }
                    file.delete();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
