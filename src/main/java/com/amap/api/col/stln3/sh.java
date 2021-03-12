package com.amap.api.col.stln3;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

/* compiled from: SDKDBOperation */
public final class sh {
    private sc a;
    private Context b;

    public sh(Context context, boolean z) {
        this.b = context;
        this.a = a(this.b, z);
    }

    private static sc a(Context context, boolean z) {
        try {
            return new sc(context, sc.a((Class<? extends sb>) sg.class));
        } catch (Throwable th) {
            if (!z) {
                rx.c(th, "sd", "gdb");
            }
            return null;
        }
    }

    public final void a(rj rjVar) {
        if (rjVar != null) {
            try {
                boolean z = false;
                if (this.a == null) {
                    this.a = a(this.b, false);
                }
                String a2 = rj.a(rjVar.a());
                List b2 = this.a.b(a2, rj.class);
                if (b2 != null) {
                    if (b2.size() != 0) {
                        Iterator it = b2.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (((rj) it.next()).equals(rjVar)) {
                                    break;
                                }
                            } else {
                                z = true;
                                break;
                            }
                        }
                        if (z) {
                            this.a.a(a2, rjVar);
                            return;
                        }
                        return;
                    }
                }
                this.a.a(rjVar);
            } catch (Throwable th) {
                rx.c(th, "sd", "it");
            }
        }
    }

    public final List<rj> a() {
        try {
            return this.a.a(rj.h(), rj.class, true);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
