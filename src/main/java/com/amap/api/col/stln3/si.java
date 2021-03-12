package com.amap.api.col.stln3;

import android.content.Context;
import android.content.SharedPreferences;
import com.amap.api.col.stln3.sr;
import com.amap.api.col.stln3.tt;
import java.io.File;
import java.io.RandomAccessFile;

/* compiled from: DexDownLoad */
public final class si implements tt.a {
    private sj a;
    private tt b;
    private rj c;
    private String d;
    private RandomAccessFile e;
    private Context f;

    /* access modifiers changed from: package-private */
    /* compiled from: DexDownLoad */
    public class a implements Runnable {
        private int b = 0;
        private sc c;
        private String d;

        a() {
        }

        a(sc scVar) {
            this.c = scVar;
        }

        public final void run() {
            switch (this.b) {
                case 0:
                    try {
                        if (si.this.b()) {
                            ug ugVar = new ug(si.this.f, si.this.c.a(), si.this.c.b(), "O008");
                            ugVar.a("{\"param_int_first\":0}");
                            uh.a(ugVar, si.this.f);
                            si.this.b.a(si.this);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        ru.a(th, "dDownLoad", "run()");
                        return;
                    }
                case 1:
                case 2:
                    try {
                        sn.a(si.this.f, this.c, si.this.c, si.this.d, si.this.a.d);
                        sn.a(si.this.f, si.this.c);
                        return;
                    } catch (Throwable th2) {
                        ru.a(th2, "dDownLoad", "onFinish2");
                        return;
                    }
                case 3:
                    try {
                        sn.a(si.this.f, this.c, si.this.c, si.this.d, this.d);
                        sn.a(si.this.f, si.this.c);
                        return;
                    } catch (Throwable th3) {
                        ru.a(th3, "dDownLoad", "processDownloadedFile()");
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public si(Context context, sj sjVar, rj rjVar) {
        try {
            this.f = context.getApplicationContext();
            this.c = rjVar;
            if (sjVar != null) {
                this.a = sjVar;
                this.b = new tt(new sm(this.a));
                this.d = sn.a(context, this.a.a);
            }
        } catch (Throwable th) {
            ru.a(th, "dDownLoad", "DexDownLoad()");
        }
    }

    public final void a() {
        try {
            ss.b().a().submit(new a());
        } catch (Throwable th) {
            ru.a(th, "dDownLoad", "startDownload()");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004d A[Catch:{ Throwable -> 0x005c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b() {
        /*
        // Method dump skipped, instructions count: 101
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.si.b():boolean");
    }

    @Override // com.amap.api.col.stln3.tt.a
    public final void onDownload(byte[] bArr, long j) {
        try {
            if (this.e == null) {
                File file = new File(this.d);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.e = new RandomAccessFile(file, "rw");
            }
            this.e.seek(j);
            this.e.write(bArr);
        } catch (Throwable th) {
            ru.a(th, "dDownLoad", "onDownload()");
        }
    }

    @Override // com.amap.api.col.stln3.tt.a
    public final void onException(Throwable th) {
        try {
            st.a(this.e);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.col.stln3.tt.a
    public final void onFinish() {
        try {
            if (this.e != null) {
                st.a(this.e);
                String b2 = this.a.b();
                if (st.a(this.d, b2)) {
                    String str = this.a.c;
                    sc scVar = new sc(this.f, sp.a());
                    scVar.a(new sr.a(this.a.a, b2, this.a.b, str, this.a.d).a("copy").a(), sr.a(this.a.a, this.a.b, str, this.a.d));
                    try {
                        SharedPreferences.Editor edit = this.f.getSharedPreferences(this.a.b, 0).edit();
                        edit.clear();
                        edit.commit();
                    } catch (Throwable th) {
                        ru.a(th, "dDownLoad", "clearMarker()");
                    }
                    try {
                        ss.b().a().submit(new a(scVar));
                    } catch (Throwable th2) {
                        ru.a(th2, "dDownLoad", "onFinish1");
                    }
                    ug ugVar = new ug(this.f, this.c.a(), this.c.b(), "O008");
                    ugVar.a("{\"param_int_first\":1}");
                    uh.a(ugVar, this.f);
                    return;
                }
                try {
                    new File(this.d).delete();
                } catch (Throwable th3) {
                    ru.a(th3, "dDownLoad", "onFinish");
                }
            }
        } catch (Throwable th4) {
            ru.a(th4, "dDownLoad", "onFinish()");
        }
    }

    @Override // com.amap.api.col.stln3.tt.a
    public final void onStop() {
    }
}
