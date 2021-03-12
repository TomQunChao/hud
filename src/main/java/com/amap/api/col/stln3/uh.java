package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Random;

/* compiled from: StatisticsManager */
public class uh {
    private static WeakReference<ub> a;

    static /* synthetic */ void a(Context context, byte[] bArr) throws IOException {
        ub a2 = ui.a(a);
        ui.a(context, a2, rv.h, 1000, 307200, "2");
        if (a2.e == null) {
            a2.e = new rq();
        }
        Random random = new Random();
        try {
            uc.a(Integer.toString(random.nextInt(100)) + Long.toString(System.nanoTime()), bArr, a2);
        } catch (Throwable th) {
            rx.c(th, "stm", "wts");
        }
    }

    public static synchronized void a(final ug ugVar, final Context context) {
        synchronized (uh.class) {
            rx.d().submit(new Runnable() {
                /* class com.amap.api.col.stln3.uh.AnonymousClass1 */

                public final void run() {
                    try {
                        synchronized (uh.class) {
                            uh.a(context, ugVar.a());
                        }
                    } catch (Throwable th) {
                        rx.c(th, "stm", "as");
                    }
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
        if (r3.size() == 0) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(final java.util.List<com.amap.api.col.stln3.ug> r3, final android.content.Context r4) {
        /*
            java.lang.Class<com.amap.api.col.stln3.uh> r0 = com.amap.api.col.stln3.uh.class
            monitor-enter(r0)
            if (r3 == 0) goto L_0x0020
            int r1 = r3.size()     // Catch:{ Throwable -> 0x000f }
            if (r1 != 0) goto L_0x000c
            goto L_0x0020
        L_0x000c:
            goto L_0x0010
        L_0x000d:
            r3 = move-exception
            goto L_0x001e
        L_0x000f:
            r1 = move-exception
        L_0x0010:
            java.util.concurrent.ExecutorService r1 = com.amap.api.col.stln3.rx.d()     // Catch:{ all -> 0x000d }
            com.amap.api.col.stln3.uh$2 r2 = new com.amap.api.col.stln3.uh$2     // Catch:{ all -> 0x000d }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x000d }
            r1.submit(r2)     // Catch:{ all -> 0x000d }
            monitor-exit(r0)
            return
        L_0x001e:
            monitor-exit(r0)
            throw r3
        L_0x0020:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.uh.a(java.util.List, android.content.Context):void");
    }

    public static void a(final Context context) {
        rx.d().submit(new Runnable() {
            /* class com.amap.api.col.stln3.uh.AnonymousClass3 */

            public final void run() {
                try {
                    ub a2 = ui.a(uh.a);
                    ui.a(context, a2, rv.h, 1000, 307200, "2");
                    if (a2.g == null) {
                        a2.g = new uj(new un(context, new uk(new uo(new uq()))));
                    }
                    a2.h = 3600000;
                    if (TextUtils.isEmpty(a2.i)) {
                        a2.i = "cKey";
                    }
                    if (a2.f == null) {
                        a2.f = new uu(context, a2.h, a2.i, new ur(30, a2.a, new uw(context)));
                    }
                    uc.a(a2);
                } catch (Throwable th) {
                    rx.c(th, "stm", "usd");
                }
            }
        });
    }
}
