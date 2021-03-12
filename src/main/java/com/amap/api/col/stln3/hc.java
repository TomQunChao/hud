package com.amap.api.col.stln3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: AbstractAsyncTask */
public abstract class hc<Params, Progress, Result> {
    public static final Executor a = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, e, d, new ThreadPoolExecutor.DiscardOldestPolicy());
    public static final Executor b = (ic.d() ? new d((byte) 0) : new ThreadPoolExecutor(1, 2, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), new hq("AMapSERIAL_EXECUTOR"), new ThreadPoolExecutor.AbortPolicy()));
    public static final Executor c = new ThreadPoolExecutor(2, 2, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), new hq("AMapDUAL_THREAD_EXECUTOR"), new ThreadPoolExecutor.AbortPolicy());
    private static final ThreadFactory d = new ThreadFactory() {
        /* class com.amap.api.col.stln3.hc.AnonymousClass1 */
        private final AtomicInteger a = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AbstractAsyncTask #" + this.a.getAndIncrement());
        }
    };
    private static final BlockingQueue<Runnable> e = new LinkedBlockingQueue(10);
    private static final c f = new c(Looper.getMainLooper());
    private static volatile Executor g = b;
    private final a<Params, Result> h = new a<Params, Result>() {
        /* class com.amap.api.col.stln3.hc.AnonymousClass2 */

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.amap.api.col.stln3.hc */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.Callable
        public final Result call() throws Exception {
            hc.this.l.set(true);
            hc hcVar = hc.this;
            return (Result) hcVar.c(hcVar.a(this.b));
        }
    };
    private final FutureTask<Result> i = new FutureTask<Result>(this.h) {
        /* class com.amap.api.col.stln3.hc.AnonymousClass3 */

        /* access modifiers changed from: protected */
        public final void done() {
            try {
                hc.b(hc.this, hc.this.i.get());
            } catch (InterruptedException e) {
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (CancellationException e3) {
                hc.b(hc.this, null);
            }
        }
    };
    private volatile e j = e.PENDING;
    private final AtomicBoolean k = new AtomicBoolean();
    private final AtomicBoolean l = new AtomicBoolean();

    /* compiled from: AbstractAsyncTask */
    public enum e {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* access modifiers changed from: protected */
    public abstract Result a(Params... paramsArr);

    static /* synthetic */ void b(hc hcVar, Object obj) {
        if (!hcVar.l.get()) {
            hcVar.c(obj);
        }
    }

    static /* synthetic */ void c(hc hcVar, Object obj) {
        if (hcVar.k.get()) {
            hcVar.b(obj);
        } else {
            hcVar.a(obj);
        }
        hcVar.j = e.FINISHED;
    }

    /* compiled from: AbstractAsyncTask */
    private static class d implements Executor {
        final ArrayDeque<Runnable> a;
        Runnable b;

        private d() {
            this.a = new ArrayDeque<>();
        }

        /* synthetic */ d(byte b2) {
            this();
        }

        public final synchronized void execute(final Runnable runnable) {
            this.a.offer(new Runnable() {
                /* class com.amap.api.col.stln3.hc.d.AnonymousClass1 */

                public final void run() {
                    try {
                        runnable.run();
                    } finally {
                        d.this.a();
                    }
                }
            });
            if (this.b == null) {
                a();
            }
        }

        /* access modifiers changed from: protected */
        public final synchronized void a() {
            Runnable poll = this.a.poll();
            this.b = poll;
            if (poll != null) {
                hc.a.execute(this.b);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Result c(Result result) {
        f.obtainMessage(1, new b(this, result)).sendToTarget();
        return result;
    }

    public final e a() {
        return this.j;
    }

    /* access modifiers changed from: protected */
    public void a(Result result) {
    }

    protected static void b() {
    }

    /* access modifiers changed from: protected */
    public void b(Result result) {
    }

    public final boolean c() {
        return this.k.get();
    }

    public final boolean d() {
        this.k.set(true);
        return this.i.cancel(true);
    }

    public final hc<Params, Progress, Result> b(Params... paramsArr) {
        return a(g, paramsArr);
    }

    public final hc<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (this.j != e.PENDING) {
            switch (this.j) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.j = e.RUNNING;
        this.h.b = paramsArr;
        executor.execute(this.i);
        return this;
    }

    /* access modifiers changed from: private */
    /* compiled from: AbstractAsyncTask */
    public static class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            if (message.obj != null && (message.obj instanceof b)) {
                b bVar = (b) message.obj;
                switch (message.what) {
                    case 1:
                        hc.c(bVar.a, bVar.b[0]);
                        return;
                    case 2:
                        hc hcVar = bVar.a;
                        Data[] dataArr = bVar.b;
                        hc.b();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: AbstractAsyncTask */
    public static abstract class a<Params, Result> implements Callable<Result> {
        Params[] b;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: AbstractAsyncTask */
    public static class b<Data> {
        final hc a;
        final Data[] b;

        b(hc hcVar, Data... dataArr) {
            this.a = hcVar;
            this.b = dataArr;
        }
    }
}
