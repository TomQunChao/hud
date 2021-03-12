package com.amap.api.col.stln3;

import android.content.Context;
import java.lang.Thread;

/* compiled from: BasicLogHandler */
public class ru {
    protected static ru a;
    protected Thread.UncaughtExceptionHandler b;
    protected boolean c = true;

    public static void a(Throwable th, String str, String str2) {
        th.printStackTrace();
        ru ruVar = a;
        if (ruVar != null) {
            ruVar.a(th, 1, str, str2);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Throwable th, int i, String str, String str2) {
    }

    /* access modifiers changed from: protected */
    public void a(Context context, rj rjVar, boolean z) {
    }

    /* access modifiers changed from: protected */
    public void a(rj rjVar, String str, String str2) {
    }

    /* access modifiers changed from: protected */
    public void a() {
    }
}
