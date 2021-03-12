package com.amap.api.col.stln3;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: DateCodec */
public final class am implements ae, ay {
    public static final am a = new am();

    private am() {
    }

    @Override // com.amap.api.col.stln3.ay
    public final void a(ar arVar, Object obj, Object obj2, Type type) throws IOException {
        Date date;
        char[] cArr;
        bd bdVar = arVar.b;
        if (obj == null) {
            bdVar.a();
        } else if ((bdVar.c & be.WriteClassName.w) == 0 || obj.getClass() == type) {
            if (obj instanceof Calendar) {
                date = ((Calendar) obj).getTime();
            } else {
                date = (Date) obj;
            }
            if ((bdVar.c & be.WriteDateUseDateFormat.w) != 0) {
                DateFormat a2 = arVar.a();
                if (a2 == null) {
                    a2 = new SimpleDateFormat(a.d, arVar.l);
                    a2.setTimeZone(arVar.k);
                }
                bdVar.a(a2.format(date));
                return;
            }
            long time = date.getTime();
            if ((bdVar.c & be.UseISO8601DateFormat.w) != 0) {
                if ((bdVar.c & be.UseSingleQuotes.w) != 0) {
                    bdVar.write(39);
                } else {
                    bdVar.write(34);
                }
                Calendar instance = Calendar.getInstance(arVar.k, arVar.l);
                instance.setTimeInMillis(time);
                int i = instance.get(1);
                int i2 = instance.get(2) + 1;
                int i3 = instance.get(5);
                int i4 = instance.get(11);
                int i5 = instance.get(12);
                int i6 = instance.get(13);
                int i7 = instance.get(14);
                if (i7 != 0) {
                    cArr = "0000-00-00T00:00:00.000".toCharArray();
                    bd.a((long) i7, 23, cArr);
                    bd.a((long) i6, 19, cArr);
                    bd.a((long) i5, 16, cArr);
                    bd.a((long) i4, 13, cArr);
                    bd.a((long) i3, 10, cArr);
                    bd.a((long) i2, 7, cArr);
                    bd.a((long) i, 4, cArr);
                } else if (i6 == 0 && i5 == 0 && i4 == 0) {
                    cArr = "0000-00-00".toCharArray();
                    bd.a((long) i3, 10, cArr);
                    bd.a((long) i2, 7, cArr);
                    bd.a((long) i, 4, cArr);
                } else {
                    cArr = "0000-00-00T00:00:00".toCharArray();
                    bd.a((long) i6, 19, cArr);
                    bd.a((long) i5, 16, cArr);
                    bd.a((long) i4, 13, cArr);
                    bd.a((long) i3, 10, cArr);
                    bd.a((long) i2, 7, cArr);
                    bd.a((long) i, 4, cArr);
                }
                bdVar.write(cArr);
                if ((bdVar.c & be.UseSingleQuotes.w) != 0) {
                    bdVar.write(39);
                } else {
                    bdVar.write(34);
                }
            } else {
                bdVar.a(time);
            }
        } else if (obj.getClass() == Date.class) {
            bdVar.write("new Date(");
            bdVar.a(((Date) obj).getTime());
            bdVar.write(41);
        } else {
            bdVar.write(123);
            bdVar.a("@type", false);
            arVar.a(obj.getClass().getName());
            bdVar.write(44);
            bdVar.a("val", false);
            bdVar.a(((Date) obj).getTime());
            bdVar.write(125);
        }
    }

    @Override // com.amap.api.col.stln3.ae
    public final <T> T a(l lVar, Type type, Object obj) {
        return (T) a(lVar, type, (String) null);
    }

    public static <T> T a(l lVar, Type type, String str) {
        Long l;
        o oVar = lVar.c;
        int a2 = oVar.a();
        if (a2 == 2) {
            Long valueOf = Long.valueOf(oVar.t());
            oVar.a(16);
            l = valueOf;
        } else if (a2 == 4) {
            String m = oVar.m();
            oVar.a(16);
            l = m;
            if ((oVar.c & n.AllowISO8601DateFormat.s) != 0) {
                o oVar2 = new o(m);
                Date date = m;
                if (oVar2.b(true)) {
                    T t = (T) oVar2.o;
                    if (type == Calendar.class) {
                        oVar2.b();
                        return t;
                    }
                    date = t.getTime();
                }
                oVar2.b();
                l = date;
            }
        } else if (a2 == 8) {
            oVar.f();
            l = null;
        } else if (a2 == 12) {
            oVar.f();
            if (oVar.a() == 4) {
                if ("@type".equals(oVar.m())) {
                    oVar.f();
                    lVar.a(17);
                    Class<?> a3 = lVar.b.a(oVar.m(), null, oVar.c);
                    if (a3 != null) {
                        type = a3;
                    }
                    lVar.a(4);
                    lVar.a(16);
                }
                oVar.d();
                int a4 = oVar.a();
                if (a4 == 2) {
                    long t2 = oVar.t();
                    oVar.f();
                    Long valueOf2 = Long.valueOf(t2);
                    lVar.a(13);
                    l = valueOf2;
                } else {
                    throw new d("syntax error : " + p.a(a4));
                }
            } else {
                throw new d("syntax error");
            }
        } else if (lVar.e == 2) {
            lVar.e = 0;
            lVar.a(16);
            if (oVar.a() != 4) {
                throw new d("syntax error");
            } else if ("val".equals(oVar.m())) {
                oVar.f();
                lVar.a(17);
                Object e = lVar.e();
                lVar.a(13);
                l = e;
            } else {
                throw new d("syntax error");
            }
        } else {
            l = lVar.e();
        }
        T t3 = (T) a(lVar, type, l, str);
        if (type != Calendar.class || (t3 instanceof Calendar)) {
            return t3;
        }
        T t4 = t3;
        if (t4 == null) {
            return null;
        }
        T t5 = (T) Calendar.getInstance(oVar.m, oVar.n);
        t5.setTime(t4);
        return t5;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T a(l lVar, Type type, Object obj, String str) {
        DateFormat dateFormat;
        if (obj == 0) {
            return null;
        }
        if (obj instanceof Date) {
            return obj;
        }
        if (obj instanceof Number) {
            return (T) new Date(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.length() == 0) {
                return null;
            }
            o oVar = new o(str2);
            try {
                if (oVar.b(false)) {
                    T t = (T) oVar.o;
                    if (type == Calendar.class) {
                        return t;
                    }
                    T t2 = (T) t.getTime();
                    oVar.b();
                    return t2;
                }
                oVar.b();
                if ("0000-00-00".equals(str2) || "0000-00-00T00:00:00".equalsIgnoreCase(str2) || "0001-01-01T00:00:00+08:00".equalsIgnoreCase(str2)) {
                    return null;
                }
                if (str != null) {
                    dateFormat = new SimpleDateFormat(str);
                } else {
                    dateFormat = lVar.a();
                }
                try {
                    return (T) dateFormat.parse(str2);
                } catch (ParseException e) {
                    return (T) new Date(Long.parseLong(str2));
                }
            } finally {
                oVar.b();
            }
        } else {
            throw new d("parse error");
        }
    }
}
