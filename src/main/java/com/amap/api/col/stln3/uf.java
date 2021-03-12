package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.autonavi.ae.guide.GuideControl;
import java.lang.ref.WeakReference;

/* compiled from: OfflineLocManager */
public class uf {
    static int a = 1000;
    static boolean b = false;
    static int c = 20;
    private static WeakReference<ub> d;
    private static int e = 10;

    @Deprecated
    public static synchronized void a(int i, boolean z) {
        synchronized (uf.class) {
            a = i;
            b = z;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(int r1, boolean r2, int r3) {
        /*
            java.lang.Class<com.amap.api.col.stln3.uf> r0 = com.amap.api.col.stln3.uf.class
            monitor-enter(r0)
            com.amap.api.col.stln3.uf.a = r1     // Catch:{ all -> 0x0026 }
            com.amap.api.col.stln3.uf.b = r2     // Catch:{ all -> 0x0026 }
            r1 = 10
            if (r3 < r1) goto L_0x0011
            r1 = 100
            if (r3 <= r1) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            goto L_0x0013
        L_0x0011:
            r3 = 20
        L_0x0013:
            com.amap.api.col.stln3.uf.c = r3     // Catch:{ all -> 0x0026 }
            int r3 = r3 / 5
            int r1 = com.amap.api.col.stln3.uf.e     // Catch:{ all -> 0x0026 }
            if (r3 <= r1) goto L_0x0023
            int r1 = com.amap.api.col.stln3.uf.c     // Catch:{ all -> 0x0026 }
            int r1 = r1 / 5
            com.amap.api.col.stln3.uf.e = r1     // Catch:{ all -> 0x0026 }
            goto L_0x0024
        L_0x0023:
        L_0x0024:
            monitor-exit(r0)
            return
        L_0x0026:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.uf.a(int, boolean, int):void");
    }

    public static synchronized void a(final ue ueVar, final Context context) {
        synchronized (uf.class) {
            rx.d().submit(new Runnable() {
                /* class com.amap.api.col.stln3.uf.AnonymousClass1 */

                public final void run() {
                    try {
                        synchronized (uf.class) {
                            String l = Long.toString(System.currentTimeMillis());
                            ub a2 = ui.a(uf.d);
                            ui.a(context, a2, rv.i, uf.a, 2097152, GuideControl.CHANGE_PLAY_TYPE_CLH);
                            if (a2.e == null) {
                                a2.e = new rn(new rp(new rr(new rp())));
                            }
                            uc.a(l, ueVar.a(), a2);
                        }
                    } catch (Throwable th) {
                        rx.c(th, "ofm", "aple");
                    }
                }
            });
        }
    }

    public static void a(final Context context) {
        rx.d().submit(new Runnable() {
            /* class com.amap.api.col.stln3.uf.AnonymousClass2 */

            public final void run() {
                try {
                    ub a2 = ui.a(uf.d);
                    ui.a(context, a2, rv.i, uf.a, 2097152, GuideControl.CHANGE_PLAY_TYPE_CLH);
                    a2.h = 14400000;
                    if (a2.g == null) {
                        rn rnVar = new rn(new rp(new rr()));
                        a2.g = new um(new ul(context, new uq(), rnVar, new String(rs.a(10)), qy.f(context), rd.v(context), rd.m(context), rd.h(context), rd.a(), Build.MANUFACTURER, Build.DEVICE, rd.x(context), qy.c(context), Build.MODEL, qy.d(context), qy.b(context)));
                    }
                    if (TextUtils.isEmpty(a2.i)) {
                        a2.i = "fKey";
                    }
                    a2.f = new uu(context, a2.h, a2.i, new us(context, uf.b, uf.e * 1024, uf.c * 1024));
                    uc.a(a2);
                } catch (Throwable th) {
                    rx.c(th, "ofm", "uold");
                }
            }
        });
    }
}
