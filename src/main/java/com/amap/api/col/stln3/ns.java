package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* compiled from: ManifestConfig */
public final class ns {
    public static rj a;
    private static ns b;
    private static Context c;
    private a d;
    private HandlerThread e = new HandlerThread("manifestThread") {
        /* class com.amap.api.col.stln3.ns.AnonymousClass1 */

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x009d, code lost:
            if (r9.a.d != null) goto L_0x00b2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b0, code lost:
            if (r9.a.d == null) goto L_0x00bd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b2, code lost:
            r9.a.d.sendMessage(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            java.lang.Thread.sleep(10000);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c2, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c3, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c4, code lost:
            r0.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c7, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 222
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ns.AnonymousClass1.run():void");
        }
    };

    private ns(Context context) {
        c = context;
        a = nk.a(false);
        try {
            this.d = new a(Looper.getMainLooper());
            this.e.start();
        } catch (Throwable th) {
            nl.a(th, "ManifestConfig", "ManifestConfig");
        }
    }

    public static ns a(Context context) {
        if (b == null) {
            b = new ns(context);
        }
        return b;
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ManifestConfig */
    public class a extends Handler {
        String a = "handleMessage";

        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            if (message != null && message.what == 3) {
                try {
                    nt ntVar = (nt) message.obj;
                    if (ntVar == null) {
                        ntVar = new nt(false, false);
                    }
                    rx.a(ns.c, nk.a(ntVar.a()));
                    ns.a = nk.a(ntVar.a());
                } catch (Throwable th) {
                    nl.a(th, "ManifestConfig", this.a);
                }
            }
        }
    }
}
