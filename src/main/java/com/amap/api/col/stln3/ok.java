package com.amap.api.col.stln3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPoolExecutorUtil */
public class ok {
    private static volatile ok c;
    private BlockingQueue<Runnable> a = new LinkedBlockingQueue();
    private ExecutorService b = null;

    public static ok a() {
        if (c == null) {
            synchronized (ok.class) {
                if (c == null) {
                    c = new ok();
                }
            }
        }
        return c;
    }

    public static void b() {
        if (c != null) {
            synchronized (ok.class) {
                if (c != null) {
                    c.b.shutdownNow();
                    c.b = null;
                    c = null;
                }
            }
        }
    }

    private ok() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.b = new ThreadPoolExecutor(availableProcessors, availableProcessors * 2, 1, TimeUnit.SECONDS, this.a, new ThreadPoolExecutor.AbortPolicy());
    }

    public final void a(Runnable runnable) {
        ExecutorService executorService = this.b;
        if (executorService != null) {
            executorService.execute(runnable);
        }
    }
}
