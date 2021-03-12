package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: LoaderFactory */
public final class ss {
    private static final ss a = new ss();
    private static final ThreadFactory d = new ThreadFactory() {
        /* class com.amap.api.col.stln3.ss.AnonymousClass1 */
        private final AtomicInteger a = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "amapD#" + this.a.getAndIncrement());
        }
    };
    private final Map<String, sl> b = new HashMap();
    private final Map<String, a> c = new HashMap();
    private ExecutorService e = null;

    /* access modifiers changed from: package-private */
    /* compiled from: LoaderFactory */
    public class a {
        volatile boolean a = false;
        volatile boolean b = false;

        a() {
        }
    }

    private ss() {
    }

    /* access modifiers changed from: package-private */
    public final ExecutorService a() {
        try {
            if (this.e != null) {
                if (!this.e.isShutdown()) {
                    return this.e;
                }
            }
            this.e = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(128), d);
        } catch (Throwable th) {
        }
        return this.e;
    }

    public static ss b() {
        return a;
    }

    /* access modifiers changed from: package-private */
    public final a a(rj rjVar) {
        synchronized (this.c) {
            if (!b(rjVar)) {
                return null;
            }
            String a2 = rjVar.a();
            a aVar = this.c.get(a2);
            if (aVar == null) {
                try {
                    a aVar2 = new a();
                    try {
                        this.c.put(a2, aVar2);
                        aVar = aVar2;
                    } catch (Throwable th) {
                        aVar = aVar2;
                    }
                } catch (Throwable th2) {
                }
            }
            return aVar;
        }
    }

    /* access modifiers changed from: package-private */
    public final sl a(Context context, rj rjVar) throws Exception {
        sl slVar;
        if (!b(rjVar) || context == null) {
            return null;
        }
        String a2 = rjVar.a();
        synchronized (this.b) {
            slVar = this.b.get(a2);
            if (slVar == null) {
                try {
                    sq sqVar = new sq(context.getApplicationContext(), rjVar);
                    try {
                        this.b.put(a2, sqVar);
                        so.a(context, rjVar);
                        slVar = sqVar;
                    } catch (Throwable th) {
                        slVar = sqVar;
                    }
                } catch (Throwable th2) {
                }
            }
        }
        return slVar;
    }

    private static boolean b(rj rjVar) {
        if (rjVar == null || TextUtils.isEmpty(rjVar.b()) || TextUtils.isEmpty(rjVar.a())) {
            return false;
        }
        return true;
    }
}
