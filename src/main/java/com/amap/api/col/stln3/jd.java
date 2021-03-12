package com.amap.api.col.stln3;

import java.lang.Thread;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: BasicThreadFactory */
public final class jd implements ThreadFactory {
    private final AtomicLong a;
    private final ThreadFactory b;
    private final Thread.UncaughtExceptionHandler c;
    private final String d;
    private final Integer e;
    private final Boolean f;

    /* synthetic */ jd(a aVar, byte b2) {
        this(aVar);
    }

    private jd(a aVar) {
        if (aVar.a == null) {
            this.b = Executors.defaultThreadFactory();
        } else {
            this.b = aVar.a;
        }
        this.d = aVar.c;
        this.e = aVar.d;
        this.f = aVar.e;
        this.c = aVar.b;
        this.a = new AtomicLong();
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.b.newThread(runnable);
        if (this.d != null) {
            Long valueOf = Long.valueOf(this.a.incrementAndGet());
            newThread.setName(String.format(this.d, valueOf));
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.c;
        if (uncaughtExceptionHandler != null) {
            newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
        Integer num = this.e;
        if (num != null) {
            newThread.setPriority(num.intValue());
        }
        Boolean bool = this.f;
        if (bool != null) {
            newThread.setDaemon(bool.booleanValue());
        }
        return newThread;
    }

    /* compiled from: BasicThreadFactory */
    public static class a {
        private ThreadFactory a;
        private Thread.UncaughtExceptionHandler b;
        private String c;
        private Integer d;
        private Boolean e;

        public final a a(String str) {
            if (str != null) {
                this.c = str;
                return this;
            }
            throw new NullPointerException("Naming pattern must not be null!");
        }

        public final a a() {
            this.e = true;
            return this;
        }

        public final jd b() {
            jd jdVar = new jd(this, (byte) 0);
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            return jdVar;
        }
    }
}
