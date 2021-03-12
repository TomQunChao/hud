package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.col.stln3.fa;
import com.amap.api.col.stln3.tt;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.MapsInitializer;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* compiled from: NetFileFetch */
public final class eu implements tt.a {
    ev a = null;
    long b = 0;
    long c = 0;
    long d;
    boolean e = true;
    ep f;
    long g = 0;
    a h;
    private Context i;
    private fa j;
    private String k;
    private tz l;
    private eq m;
    private boolean n = false;

    /* compiled from: NetFileFetch */
    public interface a {
        void c();
    }

    public eu(ev evVar, String str, Context context, fa faVar) throws IOException {
        this.f = ep.a(context.getApplicationContext());
        this.a = evVar;
        this.i = context;
        this.k = str;
        this.j = faVar;
        File file = new File(this.a.b() + this.a.c());
        if (file.exists()) {
            this.e = false;
            this.b = file.length();
            try {
                this.d = c();
                this.c = this.d;
            } catch (IOException e2) {
                fa faVar2 = this.j;
                if (faVar2 != null) {
                    faVar2.a(fa.a.file_io_exception);
                }
            }
        } else {
            this.b = 0;
            this.c = 0;
        }
    }

    public final void a() {
        try {
            if (ic.d(this.i)) {
                if (ra.a != 1) {
                    for (int i2 = 0; i2 < 3; i2++) {
                        try {
                            if (ra.a(this.i, ic.f())) {
                                break;
                            }
                        } catch (Throwable th) {
                            rx.c(th, "SiteFileFetch", "authOffLineDownLoad");
                            th.printStackTrace();
                        }
                    }
                }
                if (ra.a == 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.a.b());
                    sb.append(File.separator);
                    sb.append(this.a.c());
                    if (!(new File(sb.toString()).length() >= 10)) {
                        this.e = true;
                    }
                    if (this.e) {
                        this.d = c();
                        if (!(this.d == -1 || this.d == -2)) {
                            this.c = this.d;
                        }
                        this.b = 0;
                    }
                    if (this.j != null) {
                        this.j.m();
                    }
                    if (this.b >= this.c) {
                        onFinish();
                        return;
                    }
                    fb fbVar = new fb(this.k);
                    fbVar.setConnectionTimeout(1800000);
                    fbVar.setSoTimeout(1800000);
                    this.l = new tz(fbVar, this.b, this.c, MapsInitializer.getProtocol() == 2);
                    this.m = new eq(this.a.b() + File.separator + this.a.c(), this.b);
                    this.l.a(this);
                } else if (this.j != null) {
                    this.j.a(fa.a.amap_exception);
                }
            } else if (this.j != null) {
                this.j.a(fa.a.network_exception);
            }
        } catch (AMapException e2) {
            rx.c(e2, "SiteFileFetch", "download");
            fa faVar = this.j;
            if (faVar != null) {
                faVar.a(fa.a.amap_exception);
            }
        } catch (IOException e3) {
            fa faVar2 = this.j;
            if (faVar2 != null) {
                faVar2.a(fa.a.file_io_exception);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: NetFileFetch */
    public static class b extends hb {
        private final String d;

        public b(String str) {
            this.d = str;
        }

        @Override // com.amap.api.col.stln3.tw
        public final String getURL() {
            return this.d;
        }
    }

    private long c() throws IOException {
        Map<String, String> map;
        String a2 = this.a.a();
        try {
            tv.b();
            map = tv.b(new b(a2), MapsInitializer.getProtocol() == 2);
        } catch (qx e2) {
            e2.printStackTrace();
            map = null;
        }
        int i2 = -1;
        if (map != null) {
            for (String str : map.keySet()) {
                if ("Content-Length".equalsIgnoreCase(str)) {
                    i2 = Integer.parseInt(map.get(str));
                }
            }
        }
        return (long) i2;
    }

    private void d() {
        fa faVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.a != null && currentTimeMillis - this.g > 500) {
            e();
            this.g = currentTimeMillis;
            long j2 = this.b;
            long j3 = this.d;
            if (j3 > 0 && (faVar = this.j) != null) {
                faVar.a(j3, j2);
                this.g = System.currentTimeMillis();
            }
        }
    }

    private void e() {
        this.f.a(this.a.e(), this.a.d(), this.d, this.b, this.c);
    }

    public final void b() {
        tz tzVar = this.l;
        if (tzVar != null) {
            tzVar.a();
        }
    }

    @Override // com.amap.api.col.stln3.tt.a
    public final void onStop() {
        if (!this.n) {
            fa faVar = this.j;
            if (faVar != null) {
                faVar.o();
            }
            e();
        }
    }

    @Override // com.amap.api.col.stln3.tt.a
    public final void onFinish() {
        d();
        fa faVar = this.j;
        if (faVar != null) {
            faVar.n();
        }
        eq eqVar = this.m;
        if (eqVar != null) {
            eqVar.a();
        }
        a aVar = this.h;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.amap.api.col.stln3.tt.a
    public final void onException(Throwable th) {
        eq eqVar;
        this.n = true;
        b();
        fa faVar = this.j;
        if (faVar != null) {
            faVar.a(fa.a.network_exception);
        }
        if (!(th instanceof IOException) && (eqVar = this.m) != null) {
            eqVar.a();
        }
    }

    @Override // com.amap.api.col.stln3.tt.a
    public final void onDownload(byte[] bArr, long j2) {
        try {
            this.m.a(bArr);
            this.b = j2;
            d();
        } catch (IOException e2) {
            e2.printStackTrace();
            rx.c(e2, "fileAccessI", "fileAccessI.write(byte[] data)");
            fa faVar = this.j;
            if (faVar != null) {
                faVar.a(fa.a.file_io_exception);
            }
            tz tzVar = this.l;
            if (tzVar != null) {
                tzVar.a();
            }
        }
    }

    public final void a(a aVar) {
        this.h = aVar;
    }
}
