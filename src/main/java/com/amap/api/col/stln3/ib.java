package com.amap.api.col.stln3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadUtil */
public class ib {
    private static volatile ib c;
    private BlockingQueue<Runnable> a = new LinkedBlockingQueue();
    private ExecutorService b = null;

    public static ib a() {
        if (c == null) {
            synchronized (ib.class) {
                if (c == null) {
                    c = new ib();
                }
            }
        }
        return c;
    }

    public static void b() {
        if (c != null) {
            try {
                c.b.shutdownNow();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            c.b = null;
            c = null;
        }
    }

    private ib() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.b = new ThreadPoolExecutor(availableProcessors, availableProcessors * 2, 1, TimeUnit.SECONDS, this.a, new hq("AMapThreadUtil"), new ThreadPoolExecutor.AbortPolicy());
    }

    public final void a(Runnable runnable) {
        ExecutorService executorService = this.b;
        if (executorService != null) {
            try {
                executorService.execute(runnable);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
