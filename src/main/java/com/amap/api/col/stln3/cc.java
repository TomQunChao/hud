package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.col.stln3.cd;
import java.lang.ref.WeakReference;

/* compiled from: AuthProTask */
public final class cc extends Thread {
    private static int c = 0;
    private static int d = 3;
    private static long e = 30000;
    private static boolean g = false;
    private WeakReference<Context> a = null;
    private co b;
    private a f = null;
    private Handler h = new Handler(Looper.getMainLooper()) {
        /* class com.amap.api.col.stln3.cc.AnonymousClass1 */

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (!cc.g) {
                if (cc.this.f == null) {
                    cc ccVar = cc.this;
                    ccVar.f = new a(ccVar.b, cc.this.a == null ? null : (Context) cc.this.a.get());
                }
                ib.a().a(cc.this.f);
            }
        }
    };

    static /* synthetic */ int b() {
        int i = c;
        c = i + 1;
        return i;
    }

    public cc(Context context, co coVar) {
        if (context != null) {
            this.a = new WeakReference<>(context);
        }
        this.b = coVar;
        f();
    }

    private static void f() {
        c = 0;
        g = false;
    }

    public final void run() {
        try {
            if (!g) {
                int i = 0;
                while (i <= d) {
                    i++;
                    this.h.sendEmptyMessageDelayed(0, ((long) i) * e);
                }
            }
        } catch (Throwable th) {
            rx.c(th, "AMapDelegateImpGLSurfaceView", "mVerfy");
            th.printStackTrace();
        }
    }

    public final void interrupt() {
        this.b = null;
        this.a = null;
        Handler handler = this.h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.h = null;
        this.f = null;
        f();
        super.interrupt();
    }

    /* access modifiers changed from: package-private */
    /* compiled from: AuthProTask */
    public static class a implements Runnable {
        private WeakReference<co> a = null;
        private WeakReference<Context> b = null;
        private cd c;

        public a(co coVar, Context context) {
            this.a = new WeakReference<>(coVar);
            if (context != null) {
                this.b = new WeakReference<>(context);
            }
        }

        public final void run() {
            cd.a aVar;
            try {
                if (!cc.g) {
                    if (this.c == null) {
                        if (this.b != null && this.b.get() != null) {
                            this.c = new cd(this.b.get(), "");
                        }
                    }
                    cc.b();
                    if (cc.c > cc.d) {
                        boolean unused = cc.g = true;
                        a();
                    } else if (this.c != null && (aVar = (cd.a) this.c.a()) != null) {
                        if (!aVar.d) {
                            a();
                        }
                        boolean unused2 = cc.g = true;
                    }
                }
            } catch (Throwable th) {
                rx.c(th, "authForPro", "loadConfigData_uploadException");
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
            r0 = r2.a.get();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a() {
            /*
                r2 = this;
                java.lang.ref.WeakReference<com.amap.api.col.stln3.co> r0 = r2.a
                if (r0 == 0) goto L_0x0024
                java.lang.Object r0 = r0.get()
                if (r0 == 0) goto L_0x0024
                java.lang.ref.WeakReference<com.amap.api.col.stln3.co> r0 = r2.a
                java.lang.Object r0 = r0.get()
                com.amap.api.col.stln3.co r0 = (com.amap.api.col.stln3.co) r0
                if (r0 == 0) goto L_0x0023
                com.autonavi.amap.mapcore.MapConfig r1 = r0.getMapConfig()
                if (r1 == 0) goto L_0x0023
                com.amap.api.col.stln3.cc$a$1 r1 = new com.amap.api.col.stln3.cc$a$1
                r1.<init>(r0)
                r0.queueEvent(r1)
                goto L_0x0025
            L_0x0023:
                goto L_0x0025
            L_0x0024:
            L_0x0025:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.cc.a.a():void");
        }
    }
}
