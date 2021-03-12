package com.amap.api.col.stln3;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* compiled from: OfflineDBOperation */
public class ep {
    private static volatile ep a;
    private static sc b;
    private Context c;

    public static ep a(Context context) {
        if (a == null) {
            synchronized (ep.class) {
                if (a == null) {
                    a = new ep(context);
                }
            }
        }
        return a;
    }

    private ep(Context context) {
        this.c = context;
        b = b(this.c);
    }

    private static sc b(Context context) {
        try {
            return new sc(context, eo.a());
        } catch (Throwable th) {
            rx.c(th, "OfflineDB", "getDB");
            th.printStackTrace();
            return null;
        }
    }

    private boolean b() {
        if (b == null) {
            b = b(this.c);
        }
        if (b == null) {
            return false;
        }
        return true;
    }

    public final ArrayList<ek> a() {
        ArrayList<ek> arrayList = new ArrayList<>();
        if (!b()) {
            return arrayList;
        }
        for (ek ekVar : b.b("", ek.class)) {
            arrayList.add(ekVar);
        }
        return arrayList;
    }

    public final synchronized ek a(String str) {
        if (!b()) {
            return null;
        }
        List b2 = b.b(ek.e(str), ek.class);
        if (b2.size() <= 0) {
            return null;
        }
        return (ek) b2.get(0);
    }

    public final synchronized void a(ek ekVar) {
        if (b()) {
            b.a(ekVar, ek.f(ekVar.h()));
            String a2 = ekVar.a();
            String e = ekVar.e();
            if (a2 != null && a2.length() > 0) {
                String a3 = em.a(e);
                if (b.b(a3, em.class).size() > 0) {
                    b.a(a3, em.class);
                }
                String[] split = a2.split(";");
                ArrayList arrayList = new ArrayList();
                for (String str : split) {
                    arrayList.add(new em(e, str));
                }
                b.a((List) arrayList);
            }
        }
    }

    public final synchronized List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        if (!b()) {
            return arrayList;
        }
        arrayList.addAll(a(b.b(em.a(str), em.class)));
        return arrayList;
    }

    private static List<String> a(List<em> list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > 0) {
            for (em emVar : list) {
                arrayList.add(emVar.a());
            }
        }
        return arrayList;
    }

    public final synchronized void c(String str) {
        if (b()) {
            b.a(en.e(str), en.class);
            b.a(em.a(str), em.class);
            b.a(el.a(str), el.class);
        }
    }

    public final synchronized void b(ek ekVar) {
        if (b()) {
            b.a(en.f(ekVar.h()), en.class);
            b.a(em.a(ekVar.e()), em.class);
            b.a(el.a(ekVar.e()), el.class);
        }
    }

    public final void a(String str, int i, long j, long j2, long j3) {
        if (b()) {
            a(str, i, j, new long[]{j2, 0, 0, 0, 0}, new long[]{j3, 0, 0, 0, 0});
        }
    }

    private synchronized void a(String str, int i, long j, long[] jArr, long[] jArr2) {
        if (b()) {
            b.a(new el(str, j, i, jArr[0], jArr2[0]), el.a(str));
        }
    }

    public final synchronized String d(String str) {
        String str2 = null;
        if (!b()) {
            return null;
        }
        List b2 = b.b(en.f(str), en.class);
        if (b2.size() > 0) {
            str2 = ((en) b2.get(0)).d();
        }
        return str2;
    }
}
