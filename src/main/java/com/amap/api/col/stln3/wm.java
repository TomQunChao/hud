package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;
import org.json.JSONArray;

/* compiled from: MapLocationService */
public final class wm {
    private static int m = 200;
    private static boolean n = true;
    Context a = null;
    wf b = null;
    wn c = null;
    b d = null;
    Handler e = null;
    Handler f = null;
    boolean g = false;
    boolean h = false;
    Inner_3dMap_locationOption i = null;
    final int j = 500;
    final int k = 30;
    Object l = new Object();
    private JSONArray o = null;

    /* compiled from: MapLocationService */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                wm.this.b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: MapLocationService */
    public static class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        /* access modifiers changed from: protected */
        public final void onLooperPrepared() {
            super.onLooperPrepared();
        }

        public final void run() {
            try {
                super.run();
            } catch (Throwable th) {
            }
        }
    }

    public wm(Context context, Handler handler) {
        if (context != null) {
            try {
                this.a = context.getApplicationContext();
                this.f = handler;
                this.i = new Inner_3dMap_locationOption();
                e();
                this.d = new b("locServiceAction");
                this.d.setPriority(5);
                this.d.start();
                this.e = new a(this.d.getLooper());
            } catch (Throwable th) {
                wy.a(th, "LocationService", "<init>");
            }
        } else {
            throw new IllegalArgumentException("Context参数不能为null");
        }
    }

    private void e() {
        try {
            if (this.i == null) {
                this.i = new Inner_3dMap_locationOption();
            }
            if (!this.h) {
                this.b = new wf(this.a);
                this.c = new wn(this.a);
                this.c.a(this.i);
                try {
                    n = xa.b(this.a, "maploc", "ue");
                    int a2 = xa.a(this.a, "maploc", "opn");
                    m = a2;
                    if (a2 > 500) {
                        m = 500;
                    }
                    if (m < 30) {
                        m = 30;
                    }
                } catch (Throwable th) {
                    wy.a(th, "LocationService", "getSPConfig");
                }
                this.h = true;
            }
        } catch (Throwable th2) {
            wy.a(th2, "LocationService", "init");
        }
    }

    private synchronized void f() {
        try {
            if (this.o != null && this.o.length() > 0) {
                uf.a(new ue(this.a, wy.b(), this.o.toString()), this.a);
                this.o = null;
            }
        } catch (Throwable th) {
            wy.a(th, "LocationService", "writeOfflineLog");
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0051 A[ExcHandler: SecurityException (e java.lang.SecurityException), Splitter:B:7:0x001e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
        // Method dump skipped, instructions count: 103
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.wm.a():void");
    }

    public final void a(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.i = inner_3dMap_locationOption;
        if (this.i == null) {
            this.i = new Inner_3dMap_locationOption();
        }
        wn wnVar = this.c;
        if (wnVar != null) {
            wnVar.a(inner_3dMap_locationOption);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036 A[Catch:{ Throwable -> 0x00c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d A[Catch:{ Throwable -> 0x00c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0077 A[Catch:{ Throwable -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0078 A[Catch:{ Throwable -> 0x00be }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
        // Method dump skipped, instructions count: 208
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.wm.b():void");
    }

    public final void c() {
        this.g = false;
        try {
            synchronized (this.l) {
                if (this.e != null) {
                    this.e.removeMessages(1);
                }
            }
            if (this.b != null) {
                this.b.a();
            }
        } catch (Throwable th) {
            wy.a(th, "LocationService", "stopLocation");
        }
    }

    public final void d() {
        b bVar;
        try {
            c();
            synchronized (this.l) {
                if (this.e != null) {
                    this.e.removeCallbacksAndMessages(null);
                }
                this.e = null;
            }
            if (this.d != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    try {
                        wz.a(this.d, HandlerThread.class, "quitSafely", new Object[0]);
                    } catch (Throwable th) {
                        bVar = this.d;
                    }
                } else {
                    bVar = this.d;
                    bVar.quit();
                }
            }
            this.d = null;
            this.c.b();
            this.g = false;
            this.h = false;
            f();
        } catch (Throwable th2) {
            wy.a(th2, "LocationService", "destroy");
        }
    }
}
