package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.stln3.tt;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Map;

/* compiled from: AuthTaskDownload */
public final class cf implements tt.a {
    a a;
    private final Context b;
    private RandomAccessFile c;
    private tz d;
    private String e;

    public cf(Context context, a aVar) {
        this.b = context.getApplicationContext();
        if (aVar != null) {
            this.a = aVar;
            this.d = new tz(new b(aVar));
            this.e = aVar.c();
        }
    }

    public final void a() {
        try {
            c e2 = this.a.e();
            if ((e2 == null || !e2.c() || !ht.a(this.b, e2.a(), e2.b(), "").equalsIgnoreCase(this.a.b())) && this.d != null) {
                this.d.a(this);
            }
        } catch (Throwable th) {
            rx.c(th, "AuthTaskDownload", "startDownload()");
        }
    }

    @Override // com.amap.api.col.stln3.tt.a
    public final void onDownload(byte[] bArr, long j) {
        try {
            if (this.c == null) {
                File file = new File(this.e);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.c = new RandomAccessFile(file, "rw");
            }
            this.c.seek(j);
            this.c.write(bArr);
        } catch (Throwable th) {
            rx.c(th, "AuthTaskDownload", "onDownload()");
        }
    }

    @Override // com.amap.api.col.stln3.tt.a
    public final void onStop() {
    }

    @Override // com.amap.api.col.stln3.tt.a
    public final void onFinish() {
        try {
            if (this.c != null) {
                try {
                    this.c.close();
                } catch (Throwable th) {
                    rx.c(th, "AuthTaskDownload", "onFinish3");
                }
                String b2 = this.a.b();
                String a2 = rg.a(this.e);
                if (a2 == null || !b2.equalsIgnoreCase(a2)) {
                    try {
                        new File(this.e).delete();
                    } catch (Throwable th2) {
                        rx.c(th2, "AuthTaskDownload", "onFinish");
                    }
                } else {
                    String d2 = this.a.d();
                    try {
                        er erVar = new er();
                        File file = new File(this.e);
                        erVar.a(file, new File(d2), -1, ex.a(file), null);
                        c e2 = this.a.e();
                        if (e2 != null) {
                            if (e2.c()) {
                                ht.a(this.b, e2.a(), e2.b(), (Object) a2);
                            }
                        }
                        new File(this.e).delete();
                    } catch (Throwable th3) {
                        rx.c(th3, "AuthTaskDownload", "onFinish1");
                    }
                }
            }
        } catch (Throwable th4) {
            rx.c(th4, "AuthTaskDownload", "onFinish()");
        }
    }

    @Override // com.amap.api.col.stln3.tt.a
    public final void onException(Throwable th) {
        try {
            if (this.c != null) {
                this.c.close();
            }
        } catch (Throwable th2) {
            rx.c(th2, "AuthTaskDownload", "onException()");
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: AuthTaskDownload */
    public static class c {
        protected String a;
        protected String b;

        public c(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public final String a() {
            return this.a;
        }

        public final String b() {
            return this.b;
        }

        public final boolean c() {
            return !TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: AuthTaskDownload */
    public static class a {
        protected String a;
        protected String b;
        protected String c;
        protected String d;
        protected c e;

        public a(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3 + ".tmp";
            this.d = str3;
        }

        public final String a() {
            return this.a;
        }

        public final String b() {
            return this.b;
        }

        public final String c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }

        public final void a(c cVar) {
            this.e = cVar;
        }

        public final c e() {
            return this.e;
        }
    }

    /* compiled from: AuthTaskDownload */
    static class d extends a {
        public d(String str, String str2, String str3) {
            super(str, str2, str3);
        }

        public final void a(String str, String str2) {
            a(new c(str, str2));
        }
    }

    /* compiled from: AuthTaskDownload */
    static class b extends hb {
        private final a d;

        b(a aVar) {
            this.d = aVar;
        }

        @Override // com.amap.api.col.stln3.tw, com.amap.api.col.stln3.hb
        public final Map<String, String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.col.stln3.tw, com.amap.api.col.stln3.hb
        public final Map<String, String> getParams() {
            return null;
        }

        @Override // com.amap.api.col.stln3.tw
        public final String getURL() {
            a aVar = this.d;
            if (aVar != null) {
                return aVar.a();
            }
            return null;
        }
    }
}
