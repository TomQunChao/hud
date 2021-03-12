package com.amap.api.col.stln3;

import android.os.Process;
import java.util.Formatter;

/* compiled from: Logger */
public final class qr {
    public static boolean a = false;
    private static Formatter b;

    public static void a(String str) {
        b(str);
    }

    public static void b(String str) {
        int myPid = Process.myPid();
        long id = Thread.currentThread().getId();
        String name = Thread.currentThread().getName();
        if (b == null) {
            b = new Formatter();
        }
        String.format("PID:" + myPid + " THREADID:" + id + " THREADNAME:" + name + " msg:" + str, new Object[0]);
    }
}
