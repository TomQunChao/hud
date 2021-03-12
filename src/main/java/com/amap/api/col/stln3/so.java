package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import java.lang.Thread;

/* compiled from: DynamicExceptionHandler */
public final class so implements Thread.UncaughtExceptionHandler {
    private static so a;
    private Thread.UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();
    private Context c;
    private rj d;

    private so(Context context, rj rjVar) {
        this.c = context.getApplicationContext();
        this.d = rjVar;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    static synchronized so a(Context context, rj rjVar) {
        so soVar;
        synchronized (so.class) {
            if (a == null) {
                a = new so(context, rjVar);
            }
            soVar = a;
        }
        return soVar;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        sc scVar;
        Context context;
        String str;
        String a2 = rk.a(th);
        try {
            if (!TextUtils.isEmpty(a2)) {
                if ((a2.contains("amapdynamic") || a2.contains("admic")) && a2.contains("com.amap.api")) {
                    sc scVar2 = new sc(this.c, sp.a());
                    if (a2.contains("loc")) {
                        sn.a(scVar2, this.c, "loc");
                    }
                    if (a2.contains("navi")) {
                        sn.a(scVar2, this.c, "navi");
                    }
                    if (a2.contains("sea")) {
                        sn.a(scVar2, this.c, "sea");
                    }
                    if (a2.contains("2dmap")) {
                        sn.a(scVar2, this.c, "2dmap");
                    }
                    if (a2.contains("3dmap")) {
                        sn.a(scVar2, this.c, "3dmap");
                    }
                } else {
                    if (a2.contains("com.autonavi.aps.amapapi.offline")) {
                        scVar = new sc(this.c, sp.a());
                        context = this.c;
                        str = "OfflineLocation";
                    } else if (a2.contains("com.data.carrier_v4")) {
                        scVar = new sc(this.c, sp.a());
                        context = this.c;
                        str = "Collection";
                    } else {
                        if (!a2.contains("com.autonavi.aps.amapapi.httpdns")) {
                            if (!a2.contains("com.autonavi.httpdns")) {
                                if (a2.contains("com.amap.api.aiunet")) {
                                    scVar = new sc(this.c, sp.a());
                                    context = this.c;
                                    str = "aiu";
                                } else if (a2.contains("com.amap.co") || a2.contains("com.amap.opensdk.co") || a2.contains("com.amap.location")) {
                                    sn.a(new sc(this.c, sp.a()), this.c, "co");
                                }
                            }
                        }
                        scVar = new sc(this.c, sp.a());
                        context = this.c;
                        str = "HttpDNS";
                    }
                    sn.a(scVar, context, str);
                }
            }
        } catch (Throwable th2) {
            ru.a(th2, "DynamicExceptionHandler", "uncaughtException");
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
