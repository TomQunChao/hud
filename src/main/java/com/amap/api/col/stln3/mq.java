package com.amap.api.col.stln3;

import android.app.Activity;
import android.os.Build;

/* compiled from: DisplayTypeHelper */
public class mq {
    private static final String a = (Build.BRAND + ":" + Build.MODEL + "_2");
    private static volatile mp b;

    public static mp a() {
        if (b == null) {
            synchronized (mq.class) {
                if (b == null) {
                    b = mp.NORMAL;
                }
            }
        }
        return b;
    }

    public static void a(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            activity.getWindow().clearFlags(1024);
        }
    }

    public static void b(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            activity.getWindow().addFlags(1024);
        }
    }
}
