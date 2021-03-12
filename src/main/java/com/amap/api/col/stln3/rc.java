package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;

/* compiled from: CoordinatorSoDownloader */
public class rc extends ri {
    private boolean h = false;

    public rc(Context context, String str, String str2, String str3) {
        super(context, str, str2, str3);
    }

    public final void a(boolean z) {
        this.h = z;
    }

    @Override // com.amap.api.col.stln3.ri
    public final void a() {
        if (this.a != null && !TextUtils.isEmpty(this.a.getURL()) && this.a.getURL().endsWith("png") && this.a.getURL().contains(rk.a(this.f))) {
            if ((this.h || !rk.b(this.f)) && !g && !new File(this.d).exists()) {
                start();
            }
        }
    }

    @Override // com.amap.api.col.stln3.tt.a, com.amap.api.col.stln3.ri
    public void onFinish() {
        try {
            if (this.b != null) {
                this.b.close();
            }
            String a = rg.a(this.c);
            if (a == null || !a.equalsIgnoreCase(this.e)) {
                b();
                return;
            }
            File file = new File(this.d);
            if (file.exists()) {
                b();
                return;
            }
            File file2 = new File(this.c);
            if (file2.exists()) {
                a(file2, file);
                b();
            }
        } catch (Throwable th) {
            b();
            File file3 = new File(this.d);
            if (file3.exists()) {
                file3.delete();
            }
            ru.a(th, "sdl", "ofs");
        }
    }

    private static void a(File file, File file2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(new byte[32]);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
            byte[] bArr = new byte[1024];
            int i = 0;
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    if (read == 1024) {
                        randomAccessFile.seek((long) i);
                        randomAccessFile.write(bArr);
                    } else {
                        byte[] bArr2 = new byte[read];
                        System.arraycopy(bArr, 0, bArr2, 0, read);
                        randomAccessFile.seek((long) i);
                        randomAccessFile.write(bArr2);
                    }
                    i += read;
                } else {
                    fileInputStream.close();
                    randomAccessFile.close();
                    file.delete();
                    return;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
