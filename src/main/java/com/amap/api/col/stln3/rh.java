package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Build;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

/* compiled from: ProxyUtil */
public final class rh {
    public static Proxy a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                return a(context, new URI("http://restapi.amap.com"));
            }
            return b(context);
        } catch (Throwable th) {
            rx.c(th, "pu", "gp");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x017e A[SYNTHETIC, Splitter:B:106:0x017e] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0190 A[SYNTHETIC, Splitter:B:111:0x0190] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01a0 A[Catch:{ Throwable -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c9 A[SYNTHETIC, Splitter:B:57:0x00c9] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00ef A[SYNTHETIC, Splitter:B:70:0x00ef] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0111  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.net.Proxy b(android.content.Context r11) {
        /*
        // Method dump skipped, instructions count: 476
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.rh.b(android.content.Context):java.net.Proxy");
    }

    private static String a() {
        String str;
        try {
            str = android.net.Proxy.getDefaultHost();
        } catch (Throwable th) {
            rx.c(th, "pu", "gdh");
            str = null;
        }
        if (str == null) {
            return "null";
        }
        return str;
    }

    private static Proxy a(Context context, URI uri) {
        Proxy proxy;
        if (c(context)) {
            try {
                List<Proxy> select = ProxySelector.getDefault().select(uri);
                if (select == null || select.isEmpty() || (proxy = select.get(0)) == null || proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                return proxy;
            } catch (Throwable th) {
                rx.c(th, "pu", "gpsc");
            }
        }
        return null;
    }

    private static boolean c(Context context) {
        return rd.r(context) == 0;
    }

    private static int b() {
        try {
            return android.net.Proxy.getDefaultPort();
        } catch (Throwable th) {
            rx.c(th, "pu", "gdp");
            return -1;
        }
    }
}
