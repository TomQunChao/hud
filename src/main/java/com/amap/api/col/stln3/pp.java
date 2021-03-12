package com.amap.api.col.stln3;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: StatusUtil */
public final class pp {
    private static AtomicInteger a = new AtomicInteger(0);

    private static void a(int i) {
        switch (a.get()) {
            case 0:
                if (i == 1) {
                    a.set(i);
                    return;
                }
                return;
            case 1:
                if (i == 4 || i == 2) {
                    a.set(i);
                    return;
                }
                return;
            case 2:
                if (i == 3 || i == 4) {
                    a.set(i);
                    return;
                }
                return;
            case 3:
                if (i == 2 || i == 4) {
                    a.set(i);
                    return;
                }
                return;
            case 4:
                if (i == 1) {
                    a.set(i);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public static void a() {
        a(1);
    }

    public static void b() {
        a(2);
    }

    public static void c() {
        a(4);
    }

    public static void d() {
        a(3);
    }

    public static boolean e() {
        return a.get() > 0 && a.get() < 4;
    }

    public static boolean f() {
        return a.get() == 2;
    }
}
