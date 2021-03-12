package com.amap.api.col.stln3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: IExecutor */
public final class sz {
    private ExecutorService a = Executors.newSingleThreadExecutor(new sy());

    public final void a(Runnable runnable) {
        if (runnable != null) {
            this.a.execute(runnable);
        }
    }

    public final void a() {
        ExecutorService executorService = this.a;
        if (executorService != null) {
            executorService.execute(new sx());
        }
    }
}
