package com.amap.api.col.stln3;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: NamedThreadFactory */
public final class hq implements ThreadFactory {
    private static final AtomicInteger a = new AtomicInteger(1);
    private final AtomicInteger b;
    private final String c;
    private final boolean d;
    private final ThreadGroup e;

    public hq() {
        this("amap-threadpool-" + a.getAndIncrement(), (byte) 0);
    }

    public hq(String str) {
        this(str, (byte) 0);
    }

    private hq(String str, byte b2) {
        String str2;
        this.b = new AtomicInteger(1);
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = str + "-thread-";
        }
        this.c = str2;
        this.d = false;
        SecurityManager securityManager = System.getSecurityManager();
        this.e = securityManager == null ? Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.e, runnable, this.c + this.b.getAndIncrement(), 0);
        thread.setDaemon(this.d);
        return thread;
    }
}
