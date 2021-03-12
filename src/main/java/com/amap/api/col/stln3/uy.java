package com.amap.api.col.stln3;

/* compiled from: ThreadTask */
public abstract class uy implements Runnable {
    a d;

    /* access modifiers changed from: package-private */
    /* compiled from: ThreadTask */
    public interface a {
        void a(uy uyVar);

        void b(uy uyVar);
    }

    public abstract void runTask();

    public final void run() {
        try {
            if (this.d != null) {
                a aVar = this.d;
            }
            if (!Thread.interrupted()) {
                runTask();
                if (!Thread.interrupted() && this.d != null) {
                    this.d.a(this);
                }
            }
        } catch (Throwable th) {
            rx.c(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }

    public final void cancelTask() {
        try {
            if (this.d != null) {
                this.d.b(this);
            }
        } catch (Throwable th) {
            rx.c(th, "ThreadTask", "cancelTask");
            th.printStackTrace();
        }
    }
}
