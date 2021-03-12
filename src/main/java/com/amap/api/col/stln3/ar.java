package com.amap.api.col.stln3;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: JSONSerializer */
public final class ar {
    public final bc a;
    public final bd b;
    protected List<ai> c;
    protected List<af> d;
    protected List<az> e;
    protected List<bg> f;
    protected List<aw> g;
    protected List<ba> h;
    protected IdentityHashMap<Object, bb> i;
    protected bb j;
    public TimeZone k;
    public Locale l;
    private int m;
    private String n;
    private DateFormat o;

    public ar() {
        this(new bd(a.e, be.x), bc.a);
    }

    public ar(bd bdVar, bc bcVar) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.m = 0;
        this.i = null;
        this.k = a.a;
        this.l = a.b;
        this.b = bdVar;
        this.a = bcVar;
        this.k = a.a;
    }

    public final DateFormat a() {
        String str;
        if (this.o == null && (str = this.n) != null) {
            this.o = new SimpleDateFormat(str, this.l);
            this.o.setTimeZone(this.k);
        }
        return this.o;
    }

    public final void a(bb bbVar, Object obj, Object obj2) {
        if ((this.b.c & be.DisableCircularReferenceDetect.w) == 0) {
            this.j = new bb(bbVar, obj, obj2, 0);
            if (this.i == null) {
                this.i = new IdentityHashMap<>();
            }
            this.i.put(obj, this.j);
        }
    }

    public final void a(Object obj) {
        bb bbVar = this.j;
        if (obj == bbVar.b) {
            this.b.write("{\"$ref\":\"@\"}");
            return;
        }
        bb bbVar2 = bbVar.a;
        if (bbVar2 == null || obj != bbVar2.b) {
            while (bbVar.a != null) {
                bbVar = bbVar.a;
            }
            if (obj == bbVar.b) {
                this.b.write("{\"$ref\":\"$\"}");
                return;
            }
            String bbVar3 = this.i.get(obj).toString();
            this.b.write("{\"$ref\":\"");
            this.b.write(bbVar3);
            this.b.write("\"}");
            return;
        }
        this.b.write("{\"$ref\":\"..\"}");
    }

    public final void b() {
        this.m++;
    }

    public final void c() {
        this.m--;
    }

    public final void d() {
        this.b.write(10);
        for (int i2 = 0; i2 < this.m; i2++) {
            this.b.write(9);
        }
    }

    public final String toString() {
        return this.b.toString();
    }

    public final void b(Object obj) {
        if (obj == null) {
            this.b.a();
            return;
        }
        try {
            this.a.a(obj.getClass()).a(this, obj, null, null);
        } catch (IOException e2) {
            throw new d(e2.getMessage(), e2);
        }
    }

    public final void a(String str) {
        if (str == null) {
            if ((this.b.c & be.WriteNullStringAsEmpty.w) != 0) {
                this.b.a("");
            } else {
                this.b.a();
            }
        } else if ((this.b.c & be.UseSingleQuotes.w) != 0) {
            this.b.b(str);
        } else {
            this.b.a(str, (char) 0, true);
        }
    }

    public static Object a(ar arVar, Object obj, Object obj2) {
        List<bg> list = arVar.f;
        if (list != null) {
            if (obj != null && !(obj instanceof String)) {
                a.a(obj);
            }
            for (bg bgVar : list) {
                obj2 = bgVar.a();
            }
        }
        return obj2;
    }

    public final Object c(Object obj) {
        List<aw> list = this.g;
        if (list != null) {
            if (obj != null && !(obj instanceof String)) {
                obj = a.a(obj);
            }
            for (aw awVar : list) {
                obj = awVar.a();
            }
        }
        return obj;
    }

    public final boolean d(Object obj) {
        List<ba> list = this.h;
        if (list == null) {
            return true;
        }
        for (ba baVar : list) {
            if (obj != null && !(obj instanceof String)) {
                obj = a.a(obj);
            }
            if (!baVar.a()) {
                return false;
            }
        }
        return true;
    }

    public final boolean e(Object obj) {
        List<az> list = this.e;
        if (list == null) {
            return true;
        }
        if (obj != null && !(obj instanceof String)) {
            a.a(obj);
        }
        for (az azVar : list) {
            if (!azVar.a()) {
                return false;
            }
        }
        return true;
    }
}
