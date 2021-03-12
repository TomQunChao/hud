package com.amap.api.col.stln3;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: TaskManager */
public final class ej {
    private static ej a;
    private ux b;
    private LinkedHashMap<String, uy> c = new LinkedHashMap<>();
    private boolean d = true;

    public static ej a() {
        return c();
    }

    private static synchronized ej c() {
        ej ejVar;
        synchronized (ej.class) {
            try {
                if (a == null) {
                    a = new ej();
                } else if (a.b == null) {
                    a.b = ux.a();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            ejVar = a;
        }
        return ejVar;
    }

    private ej() {
        try {
            this.b = ux.a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(ei eiVar) {
        synchronized (this.c) {
            ef efVar = (ef) this.c.get(eiVar.b());
            if (efVar != null) {
                efVar.a();
                this.c.remove(eiVar.b());
            }
        }
    }

    public final void a(ei eiVar, Context context) throws qx {
        ux uxVar = this.b;
        if (!this.c.containsKey(eiVar.b())) {
            ef efVar = new ef((ez) eiVar, context.getApplicationContext(), (byte) 0);
            synchronized (this.c) {
                this.c.put(eiVar.b(), efVar);
            }
        }
        this.b.a(this.c.get(eiVar.b()));
    }

    public final void b() {
        synchronized (this.c) {
            if (this.c.size() > 0) {
                for (Map.Entry<String, uy> entry : this.c.entrySet()) {
                    entry.getKey();
                    ((ef) entry.getValue()).a();
                }
                this.c.clear();
            }
        }
        ux.c();
        this.b = null;
        a = null;
    }

    public final void b(ei eiVar) {
        ef efVar = (ef) this.c.get(eiVar.b());
        if (efVar != null) {
            synchronized (this.c) {
                efVar.b();
                this.c.remove(eiVar.b());
            }
        }
    }
}
