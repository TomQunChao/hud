package com.amap.api.col.stln3;

import android.text.TextUtils;
import java.lang.Thread;
import java.util.concurrent.ThreadFactory;

/* compiled from: AsyncExecutor */
final class sy implements ThreadFactory {
    private static String a = "";
    private static Thread.UncaughtExceptionHandler c = new Thread.UncaughtExceptionHandler() {
        /* class com.amap.api.col.stln3.sy.AnonymousClass1 */

        public final void uncaughtException(Thread thread, Throwable th) {
        }
    };
    private String b;

    public sy() {
        if (TextUtils.isEmpty(a)) {
            a = rg.b("DYNAMIC_SO_THREAD");
        }
        this.b = "DYNAMIC_SO_THREAD_" + ((String) null);
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setUncaughtExceptionHandler(c);
        thread.setName(this.b);
        return thread;
    }
}
