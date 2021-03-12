package com.amap.api.col.stln3;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: ExeServiceManager */
public final class pr {
    private static final TimeUnit b = TimeUnit.MILLISECONDS;
    private HashMap<Long, a> a = new HashMap<>();

    /* access modifiers changed from: package-private */
    /* compiled from: ExeServiceManager */
    public static class b {
        public static pr a = new pr();
    }

    public static pr a() {
        return b.a;
    }

    public final boolean a(long j) {
        HashMap<Long, a> hashMap = this.a;
        if (hashMap == null || hashMap.get(Long.valueOf(j)) == null || this.a.get(Long.valueOf(j)).a() == null) {
            return false;
        }
        ScheduledExecutorService a2 = this.a.get(Long.valueOf(j)).a();
        return !a2.isShutdown() && !a2.isTerminated();
    }

    public final void a(long j, String str, Runnable runnable, long j2) {
        ScheduledExecutorService scheduledExecutorService;
        a aVar = this.a.get(Long.valueOf(j));
        if (aVar != null) {
            scheduledExecutorService = aVar.a();
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown() || scheduledExecutorService.isTerminated()) {
            this.a.remove(Long.valueOf(j));
            scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(new c(str));
        }
        this.a.put(Long.valueOf(j), new a(scheduledExecutorService, scheduledExecutorService.scheduleAtFixedRate(runnable, 0, j2, b), j2, runnable));
    }

    public final void a(long j, long j2) {
        ScheduledExecutorService scheduledExecutorService;
        a aVar = this.a.get(Long.valueOf(j));
        if (aVar != null) {
            scheduledExecutorService = aVar.a();
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown() && !scheduledExecutorService.isTerminated()) {
            aVar.b().cancel(false);
            ScheduledFuture<?> scheduleWithFixedDelay = scheduledExecutorService.scheduleWithFixedDelay(aVar.c(), j2, j2, b);
            this.a.remove(aVar);
            this.a.put(Long.valueOf(j), new a(scheduledExecutorService, scheduleWithFixedDelay, j2, aVar.c()));
        }
    }

    public final void b(long j) {
        ScheduledExecutorService scheduledExecutorService;
        a aVar = this.a.get(Long.valueOf(j));
        if (aVar != null) {
            scheduledExecutorService = aVar.a();
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown() || scheduledExecutorService.isTerminated()) {
            this.a.remove(Long.valueOf(j));
        } else if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            try {
                scheduledExecutorService.awaitTermination(0, b);
            } catch (InterruptedException e) {
                qr.a("ScheduledExecutorService teminate " + e);
                e.printStackTrace();
            }
            this.a.remove(Long.valueOf(j));
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ExeServiceManager */
    public static class c implements ThreadFactory {
        private String a;

        public c(String str) {
            this.a = str;
        }

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(this.a);
            return thread;
        }
    }

    /* compiled from: ExeServiceManager */
    public class a {
        private ScheduledExecutorService b;
        private ScheduledFuture c;
        private long d;
        private Runnable e;

        public a(ScheduledExecutorService scheduledExecutorService, ScheduledFuture scheduledFuture, long j, Runnable runnable) {
            this.b = scheduledExecutorService;
            this.c = scheduledFuture;
            this.d = j;
            this.e = runnable;
        }

        public final ScheduledExecutorService a() {
            return this.b;
        }

        public final ScheduledFuture b() {
            return this.c;
        }

        public final Runnable c() {
            return this.e;
        }
    }
}
