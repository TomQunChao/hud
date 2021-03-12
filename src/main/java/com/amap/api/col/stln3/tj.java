package com.amap.api.col.stln3;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SoManager */
public final class tj {
    public static volatile boolean a = false;
    public static volatile rj b = null;
    public static List<String> c;
    private tk d;

    private tk a(Context context) {
        if (this.d == null) {
            this.d = new tk(context);
        }
        return this.d;
    }

    public final void a(rj rjVar, List<String> list) {
        if (c == null) {
            c = new ArrayList();
        }
        a = true;
        if (list != null) {
            c.addAll(list);
        }
        if (rjVar != null) {
            b = rjVar;
        }
        tk tkVar = this.d;
        if (tkVar != null) {
            tkVar.a();
        }
    }

    public final boolean a(Context context, sv svVar, String str, boolean z) {
        return b(context, svVar, str, z);
    }

    public final void a(Context context, sv svVar, boolean z, boolean z2, String str, String str2, String str3, boolean z3) {
        try {
            tk a2 = a(context);
            if (a2 != null) {
                a2.a(context, svVar.a(), str3, z, z2, str, str2, z3);
            }
        } catch (Throwable th) {
            sw.c("SoManagerCore ex " + th);
        }
    }

    private boolean b(Context context, sv svVar, String str, boolean z) {
        if (svVar != null) {
            try {
                if (svVar.a() != null) {
                    tk a2 = a(context);
                    if (a2 == null) {
                        return false;
                    }
                    return a2.a(context, svVar.a(), str, z);
                }
            } catch (Throwable th) {
                sw.c("SoManagerCore ex " + th);
                return false;
            }
        }
        return false;
    }
}
