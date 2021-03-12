package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.stln3.tt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;

@Deprecated
/* compiled from: SDKCoordinatorDownload */
public class ri extends Thread implements tt.a {
    protected static boolean g = false;
    private static String i = "sodownload";
    private static String j = "sofail";
    protected a a;
    protected RandomAccessFile b;
    protected String c;
    protected String d;
    protected String e;
    protected Context f;
    private tt h = new tt(this.a);

    public ri(Context context, String str, String str2, String str3) {
        this.f = context;
        this.e = str3;
        this.c = a(context, str + "temp.so");
        this.d = a(context, "libwgs2gcj.so");
        this.a = new a(str2);
    }

    public static String a(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + File.separator + "libso" + File.separator + str;
    }

    public static void a(Context context, Throwable th) {
        if ((th instanceof UnsatisfiedLinkError) || (th instanceof LinkageError)) {
            g = true;
            try {
                File file = new File(a(context, "libwgs2gcj.so"));
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable th2) {
            }
        }
    }

    public void a() {
        a aVar = this.a;
        if (aVar != null && !TextUtils.isEmpty(aVar.getURL()) && this.a.getURL().contains("libJni_wgs2gcj.so") && this.a.getURL().contains(rk.a(this.f)) && !new File(this.d).exists()) {
            start();
        }
    }

    public void run() {
        try {
            File file = new File(a(this.f, "tempfile"));
            if (file.exists()) {
                file.delete();
            }
            this.h.a(this);
        } catch (Throwable th) {
            rx.c(th, "sdl", "run");
            b();
        }
    }

    @Override // com.amap.api.col.stln3.tt.a
    public void onDownload(byte[] bArr, long j2) {
        try {
            if (this.b == null) {
                File file = new File(this.c);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                try {
                    this.b = new RandomAccessFile(file, "rw");
                } catch (FileNotFoundException e2) {
                    rx.c(e2, "sdl", "oDd");
                    b();
                }
            }
            if (this.b != null) {
                try {
                    this.b.seek(j2);
                    this.b.write(bArr);
                } catch (IOException e3) {
                    b();
                    rx.c(e3, "sdl", "oDd");
                }
            }
        } catch (Throwable th) {
            b();
            rx.c(th, "sdl", "oDd");
        }
    }

    @Override // com.amap.api.col.stln3.tt.a
    public void onStop() {
        b();
    }

    @Override // com.amap.api.col.stln3.tt.a
    public void onFinish() {
        try {
            if (this.b != null) {
                this.b.close();
            }
            String a2 = rg.a(this.c);
            if (a2 == null || !a2.equalsIgnoreCase(this.e)) {
                b();
            } else if (new File(this.d).exists()) {
                b();
            } else {
                new File(this.c).renameTo(new File(this.d));
            }
        } catch (Throwable th) {
            b();
            File file = new File(this.d);
            if (file.exists()) {
                file.delete();
            }
            rx.c(th, "sdl", "ofs");
        }
    }

    @Override // com.amap.api.col.stln3.tt.a
    public void onException(Throwable th) {
        try {
            if (this.b != null) {
                this.b.close();
            }
            b();
            File file = new File(a(this.f, "tempfile"));
            if (!file.exists()) {
                try {
                    File parentFile = file.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdir();
                    }
                    file.createNewFile();
                } catch (Throwable th2) {
                    rx.c(th2, "sdl", "oe");
                }
            }
        } catch (Throwable th3) {
            rx.c(th3, "sdl", "oe");
        }
    }

    /* access modifiers changed from: protected */
    public final void b() {
        File file = new File(this.c);
        if (file.exists()) {
            file.delete();
        }
    }

    /* compiled from: SDKCoordinatorDownload */
    public static class a extends tw {
        private String d;

        a(String str) {
            this.d = str;
        }

        @Override // com.amap.api.col.stln3.tw
        public final Map<String, String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.col.stln3.tw
        public final Map<String, String> getParams() {
            return null;
        }

        @Override // com.amap.api.col.stln3.tw
        public final String getURL() {
            return this.d;
        }
    }
}
