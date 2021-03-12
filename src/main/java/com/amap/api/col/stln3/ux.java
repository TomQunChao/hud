package com.amap.api.col.stln3;

import com.amap.api.col.stln3.uy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPool */
public final class ux {
    private static ux a = null;
    private ExecutorService b;
    private ConcurrentHashMap<uy, Future<?>> c = new ConcurrentHashMap<>();
    private uy.a d = new uy.a() {
        /* class com.amap.api.col.stln3.ux.AnonymousClass1 */

        @Override // com.amap.api.col.stln3.uy.a
        public final void a(uy uyVar) {
            ux.this.a((ux) uyVar, (uy) false);
        }

        @Override // com.amap.api.col.stln3.uy.a
        public final void b(uy uyVar) {
            ux.this.a((ux) uyVar, (uy) true);
        }
    };

    public static synchronized ux a() {
        ux uxVar;
        synchronized (ux.class) {
            if (a == null) {
                a = new ux(1);
            }
            uxVar = a;
        }
        return uxVar;
    }

    public static ux b() {
        return new ux(5);
    }

    private ux(int i) {
        try {
            this.b = new ThreadPoolExecutor(i, i, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256));
        } catch (Throwable th) {
            rx.c(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    public final void a(uy uyVar) throws qx {
        try {
            if (b(uyVar) || this.b == null) {
                return;
            }
            if (!this.b.isShutdown()) {
                uyVar.d = this.d;
                try {
                    Future<?> submit = this.b.submit(uyVar);
                    if (submit != null) {
                        a(uyVar, submit);
                    }
                } catch (RejectedExecutionException e) {
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "TPool", "addTask");
            throw new qx("thread pool has exception");
        }
    }

    public static synchronized void c() {
        synchronized (ux.class) {
            try {
                if (a != null) {
                    ux uxVar = a;
                    try {
                        for (Map.Entry<uy, Future<?>> entry : uxVar.c.entrySet()) {
                            Future<?> future = uxVar.c.get(entry.getKey());
                            if (future != null) {
                                try {
                                    future.cancel(true);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        uxVar.c.clear();
                        uxVar.b.shutdown();
                    } catch (Throwable th) {
                        rx.c(th, "TPool", "destroy");
                        th.printStackTrace();
                    }
                    a = null;
                }
            } catch (Throwable th2) {
                rx.c(th2, "TPool", "onDestroy");
                th2.printStackTrace();
            }
        }
    }

    private synchronized boolean b(uy uyVar) {
        boolean z;
        z = false;
        try {
            z = this.c.containsKey(uyVar);
        } catch (Throwable th) {
            rx.c(th, "TPool", "contain");
            th.printStackTrace();
        }
        return z;
    }

    private synchronized void a(uy uyVar, Future<?> future) {
        try {
            this.c.put(uyVar, future);
        } catch (Throwable th) {
            rx.c(th, "TPool", "addQueue");
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void a(uy uyVar, boolean z) {
        try {
            Future<?> remove = this.c.remove(uyVar);
            if (z && remove != null) {
                remove.cancel(true);
            }
        } catch (Throwable th) {
            rx.c(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }
}
