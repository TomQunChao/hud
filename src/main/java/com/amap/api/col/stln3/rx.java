package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Looper;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: SDKLogHandler */
public final class rx extends ru implements Thread.UncaughtExceptionHandler {
    private static ExecutorService e;
    private static Set<Integer> f = Collections.synchronizedSet(new HashSet());
    private static WeakReference<Context> g;
    private static final ThreadFactory h = new ThreadFactory() {
        /* class com.amap.api.col.stln3.rx.AnonymousClass2 */
        private final AtomicInteger a = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pama#" + this.a.getAndIncrement());
        }
    };
    private Context d;

    public static void a(Context context) {
        if (context != null) {
            try {
                g = new WeakReference<>(context.getApplicationContext());
            } catch (Throwable th) {
            }
        }
    }

    public static synchronized rx a(Context context, rj rjVar) throws qx {
        synchronized (rx.class) {
            if (rjVar == null) {
                throw new qx("sdk info is null");
            } else if (rjVar.a() == null || "".equals(rjVar.a())) {
                throw new qx("sdk name is invalid");
            } else {
                try {
                    new rz().a(context);
                    if (!f.add(Integer.valueOf(rjVar.hashCode()))) {
                        return (rx) ru.a;
                    }
                    if (ru.a == null) {
                        ru.a = new rx(context);
                    } else {
                        ru.a.c = false;
                    }
                    ru.a.a(context, rjVar, ru.a.c);
                    return (rx) ru.a;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static synchronized void b() {
        synchronized (rx.class) {
            try {
                if (e != null) {
                    e.shutdown();
                }
                tm.a();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                if (ru.a != null) {
                    if (Thread.getDefaultUncaughtExceptionHandler() == ru.a && ru.a.b != null) {
                        Thread.setDefaultUncaughtExceptionHandler(ru.a.b);
                    }
                }
                ru.a = null;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        return;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.ru
    public final void a(rj rjVar, String str, String str2) {
        ry.b(rjVar, this.d, str2, str);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.ru
    public final void a(Throwable th, int i, String str, String str2) {
        ry.a(this.d, th, i, str, str2);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.ru
    public final void a() {
        rv.b(this.d);
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        if (th != null) {
            a(th, 0, null, null);
            if (this.b != null) {
                try {
                    Thread.setDefaultUncaughtExceptionHandler(this.b);
                } catch (Throwable th2) {
                }
                this.b.uncaughtException(thread, th);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.ru
    public final void a(final Context context, final rj rjVar, final boolean z) {
        try {
            ExecutorService d2 = d();
            if (d2 == null) {
                return;
            }
            if (!d2.isShutdown()) {
                d2.submit(new Runnable() {
                    /* class com.amap.api.col.stln3.rx.AnonymousClass1 */

                    public final void run() {
                        try {
                            synchronized (Looper.getMainLooper()) {
                                new sh(context, true).a(rjVar);
                            }
                            if (z) {
                                ry.a(rx.this.d);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        } catch (RejectedExecutionException e2) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void b(Throwable th, String str, String str2) {
        if (th != null) {
            try {
                a(th, 1, str, str2);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private rx(Context context) {
        this.d = context;
        try {
            this.b = Thread.getDefaultUncaughtExceptionHandler();
            if (this.b == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.c = true;
                return;
            }
            String obj = this.b.toString();
            if (obj.startsWith("com.amap.apis.utils.core.dynamiccore") || (obj.indexOf("com.amap.api") == -1 && obj.indexOf("com.loc") == -1)) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.c = true;
                return;
            }
            this.c = false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void c() {
        WeakReference<Context> weakReference = g;
        if (weakReference != null && weakReference.get() != null) {
            rv.b(g.get());
        } else if (ru.a != null) {
            ru.a.a();
        }
    }

    public static void c(Throwable th, String str, String str2) {
        try {
            if (ru.a != null) {
                ru.a.a(th, 1, str, str2);
            }
        } catch (Throwable th2) {
        }
    }

    public static void a(rj rjVar, String str, String str2, String str3, String str4) {
        try {
            if (ru.a != null) {
                ru.a.a(rjVar, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",code:" + str4, "networkError");
            }
        } catch (Throwable th) {
        }
    }

    public static void b(rj rjVar, String str, String str2) {
        try {
            if (ru.a != null) {
                ru.a.a(rjVar, str, str2);
            }
        } catch (Throwable th) {
        }
    }

    public static void a(rj rjVar, String str, qx qxVar) {
        if (qxVar != null) {
            a(rjVar, str, qxVar.c(), qxVar.d(), qxVar.b());
        }
    }

    public static synchronized ExecutorService d() {
        ExecutorService executorService;
        synchronized (rx.class) {
            try {
                if (e != null) {
                    if (!e.isShutdown()) {
                        executorService = e;
                    }
                }
                e = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256), h);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            executorService = e;
        }
        return executorService;
    }

    public static synchronized rx e() {
        rx rxVar;
        synchronized (rx.class) {
            rxVar = (rx) ru.a;
        }
        return rxVar;
    }
}
