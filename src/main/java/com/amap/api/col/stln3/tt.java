package com.amap.api.col.stln3;

import java.net.Proxy;

/* compiled from: DownloadManager */
public class tt {
    private tu a;
    private tw b;

    /* compiled from: DownloadManager */
    public interface a {
        void onDownload(byte[] bArr, long j);

        void onException(Throwable th);

        void onFinish();

        void onStop();
    }

    public tt(tw twVar) {
        this(twVar, (byte) 0);
    }

    private tt(tw twVar, byte b2) {
        this(twVar, 0, -1, false);
    }

    public tt(tw twVar, long j, long j2, boolean z) {
        Proxy proxy;
        this.b = twVar;
        if (twVar.c == null) {
            proxy = null;
        } else {
            proxy = twVar.c;
        }
        this.a = new tu(this.b.a, this.b.b, proxy, z);
        this.a.b(j2);
        this.a.a(j);
    }

    public final void a(a aVar) {
        this.a.a(this.b.getURL(), this.b.isIPRequest(), this.b.getIPDNSName(), this.b.getRequestHead(), this.b.getParams(), this.b.getEntityBytes(), aVar);
    }

    public final void a() {
        this.a.a();
    }
}
