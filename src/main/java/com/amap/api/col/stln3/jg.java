package com.amap.api.col.stln3;

import com.amap.api.col.stln3.jd;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ExecutorThreadPoolUtil */
public final class jg {
    private static int a = 5;
    private static int b = 0;
    private static TimeUnit c = TimeUnit.SECONDS;
    private static BlockingDeque<Runnable> d = new LinkedBlockingDeque(10);
    private static ExecutorService e = null;

    public static synchronized ExecutorService a() {
        ExecutorService executorService;
        synchronized (jg.class) {
            if (e == null) {
                e = new ThreadPoolExecutor(a, a, (long) b, c, d, new jd.a().a("navi-schedule-pool-%d").b(), new RejectedExecutionHandler() {
                    /* class com.amap.api.col.stln3.jg.AnonymousClass1 */

                    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                        if (!threadPoolExecutor.isShutdown()) {
                            threadPoolExecutor.getQueue().poll();
                            threadPoolExecutor.execute(runnable);
                        }
                    }
                });
            }
            executorService = e;
        }
        return executorService;
    }

    public static void b() {
        ExecutorService executorService = e;
        if (executorService != null && !executorService.isShutdown()) {
            e.shutdown();
        }
        e = null;
    }
}
