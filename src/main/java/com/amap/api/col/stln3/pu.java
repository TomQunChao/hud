package com.amap.api.col.stln3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: AsyncExecutor */
public final class pu {
    private static int b = 1;
    private static int c = 10;
    private static long d = 10000;
    private static TimeUnit e = TimeUnit.MILLISECONDS;
    private static int f = 5;
    private ThreadPoolExecutor a = new ThreadPoolExecutor(b, c, d, e, new ArrayBlockingQueue(f), this.g);
    private ThreadFactory g = new ThreadFactory() {
        /* class com.amap.api.col.stln3.pu.AnonymousClass2 */

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("AsyncExecutorThread");
            return thread;
        }
    };

    public static pu a() {
        return new pu();
    }

    public final void a(final Runnable runnable) {
        this.a.execute(new Runnable() {
            /* class com.amap.api.col.stln3.pu.AnonymousClass1 */

            public final void run() {
                Runnable runnable = runnable;
                if (runnable != null) {
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        });
    }
}
