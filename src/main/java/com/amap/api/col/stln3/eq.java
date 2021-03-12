package com.amap.api.col.stln3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* access modifiers changed from: package-private */
/* compiled from: FileAccessI */
public final class eq {
    RandomAccessFile a;

    public eq() throws IOException {
        this("", 0);
    }

    public eq(String str, long j) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (IOException e) {
                rx.c(e, "FileAccessI", "create");
                e.printStackTrace();
            }
        }
        this.a = new RandomAccessFile(str, "rw");
        this.a.seek(j);
    }

    public final synchronized int a(byte[] bArr) throws IOException {
        this.a.write(bArr);
        return bArr.length;
    }

    public final void a() {
        RandomAccessFile randomAccessFile = this.a;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.a = null;
        }
    }
}
