package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import com.autonavi.ae.guide.GuideControl;
import java.lang.ref.WeakReference;

/* compiled from: MarkInfoManager */
public class ud {
    static WeakReference<ub> a;

    static /* synthetic */ String b(Context context) {
        String v = rd.v(context);
        if (!TextUtils.isEmpty(v)) {
            return v;
        }
        String h = rd.h(context);
        if (!TextUtils.isEmpty(h)) {
            return h;
        }
        String m = rd.m(context);
        return !TextUtils.isEmpty(m) ? m : rd.b(context);
    }

    public static void a(final String str, final Context context) {
        rx.d().submit(new Runnable() {
            /* class com.amap.api.col.stln3.ud.AnonymousClass1 */

            public final void run() {
                synchronized (ud.class) {
                    try {
                        String a2 = rg.a(rk.a(str));
                        ub a3 = ui.a(ud.a);
                        ui.a(context, a3, rv.j, 50, 102400, GuideControl.CHANGE_PLAY_TYPE_XTX);
                        if (a3.e == null) {
                            a3.e = new rn(new rr(new rp()));
                        }
                        String a4 = rk.a(System.currentTimeMillis(), "yyyyMMdd HH:mm:ss");
                        uc.a(a2, rk.a(" \"timestamp\":\"" + a4 + "\",\"details\":" + str), a3);
                    } catch (Throwable th) {
                        rx.c(th, "mam", "ap");
                    }
                }
            }
        });
    }

    public static void a(final Context context) {
        rx.d().submit(new Runnable() {
            /* class com.amap.api.col.stln3.ud.AnonymousClass2 */

            public final void run() {
                synchronized (ud.class) {
                    ub a2 = ui.a(ud.a);
                    ui.a(context, a2, rv.j, 50, 102400, GuideControl.CHANGE_PLAY_TYPE_XTX);
                    if (a2.g == null) {
                        String b = ud.b(context);
                        a2.g = new um(new ul(context, new uq(), new rn(new rr(new rp())), "WImFwcG5hbWUiOiIlcyIsInBrZyI6IiVzIiwiZGl1IjoiJXMi", qy.b(context), qy.c(context), b));
                    }
                    a2.h = 14400000;
                    if (TextUtils.isEmpty(a2.i)) {
                        a2.i = "eKey";
                    }
                    if (a2.f == null) {
                        a2.f = new uu(context, a2.h, a2.i, new ur(5, a2.a, new uw(context)));
                    }
                    uc.a(a2);
                }
            }
        });
    }
}
