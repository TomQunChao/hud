package com.amap.api.col.stln3;

import java.io.IOException;
import java.lang.reflect.Member;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/* compiled from: FieldSerializer */
public final class ao implements Comparable<ao> {
    public final bh a;
    protected final boolean b;
    protected final int c;
    protected final String d;
    protected char[] e;
    private a f;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(ao aoVar) {
        return this.a.compareTo(aoVar.a);
    }

    public ao(bh bhVar) {
        boolean z;
        this.a = bhVar;
        i a2 = bhVar.a();
        String str = null;
        if (a2 != null) {
            z = false;
            for (be beVar : a2.f()) {
                if (beVar == be.WriteMapNullValue) {
                    z = true;
                }
            }
            String trim = a2.c().trim();
            str = trim.length() != 0 ? trim : str;
            this.c = be.a(a2.f());
        } else {
            this.c = 0;
            z = false;
        }
        this.b = z;
        this.d = str;
        String str2 = bhVar.a;
        int length = str2.length();
        this.e = new char[(length + 3)];
        str2.getChars(0, str2.length(), this.e, 1);
        char[] cArr = this.e;
        cArr[0] = '\"';
        cArr[length + 1] = '\"';
        cArr[length + 2] = ':';
    }

    public final void a(ar arVar) throws IOException {
        bd bdVar = arVar.b;
        int i = bdVar.c;
        if ((be.QuoteFieldNames.w & i) == 0 || (i & be.UseSingleQuotes.w) != 0) {
            bdVar.a(this.a.a, true);
            return;
        }
        char[] cArr = this.e;
        bdVar.write(cArr, 0, cArr.length);
    }

    public final Object a(Object obj) throws Exception {
        try {
            bh bhVar = this.a;
            return bhVar.d ? bhVar.c.get(obj) : bhVar.b.invoke(obj, new Object[0]);
        } catch (Exception e2) {
            Member member = this.a.b != null ? this.a.b : this.a.c;
            throw new d("get property error。 " + (member.getDeclaringClass().getName() + "." + member.getName()), e2);
        }
    }

    public final void a(ar arVar, Object obj) throws Exception {
        Class<?> cls;
        String str = this.d;
        if (str == null) {
            if (this.f == null) {
                if (obj == null) {
                    cls = this.a.f;
                } else {
                    cls = obj.getClass();
                }
                this.f = new a(arVar.a.a(cls), cls);
            }
            a aVar = this.f;
            if (obj != null) {
                Class<?> cls2 = obj.getClass();
                if (cls2 == aVar.b) {
                    aVar.a.a(arVar, obj, this.a.a, this.a.g);
                } else {
                    arVar.a.a(cls2).a(arVar, obj, this.a.a, this.a.g);
                }
            } else if ((this.c & be.WriteNullNumberAsZero.w) != 0 && Number.class.isAssignableFrom(aVar.b)) {
                arVar.b.write(48);
            } else if ((this.c & be.WriteNullBooleanAsFalse.w) != 0 && Boolean.class == aVar.b) {
                arVar.b.write("false");
            } else if ((this.c & be.WriteNullListAsEmpty.w) == 0 || !Collection.class.isAssignableFrom(aVar.b)) {
                aVar.a.a(arVar, null, this.a.a, aVar.b);
            } else {
                arVar.b.write("[]");
            }
        } else if (obj instanceof Date) {
            DateFormat a2 = arVar.a();
            if (a2 == null) {
                a2 = new SimpleDateFormat(str, arVar.l);
                a2.setTimeZone(arVar.k);
            }
            arVar.b.a(a2.format((Date) obj));
        } else {
            arVar.b(obj);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: FieldSerializer */
    public static class a {
        ay a;
        Class<?> b;

        public a(ay ayVar, Class<?> cls) {
            this.a = ayVar;
            this.b = cls;
        }
    }
}
