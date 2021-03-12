package com.amap.api.col.stln3;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/* compiled from: IntegerCodec */
public final class ap implements ae, ay {
    public static ap a = new ap();

    private ap() {
    }

    @Override // com.amap.api.col.stln3.ay
    public final void a(ar arVar, Object obj, Object obj2, Type type) throws IOException {
        bd bdVar = arVar.b;
        Number number = (Number) obj;
        if (number != null) {
            if (obj instanceof Long) {
                bdVar.a(number.longValue());
            } else {
                bdVar.b(number.intValue());
            }
            if ((bdVar.c & be.WriteClassName.w) != 0) {
                Class<?> cls = number.getClass();
                if (cls == Byte.class) {
                    bdVar.write(66);
                } else if (cls == Short.class) {
                    bdVar.write(83);
                } else if (cls == Long.class) {
                    long longValue = number.longValue();
                    if (longValue <= 2147483647L && longValue >= -2147483648L && type != Long.class) {
                        bdVar.write(76);
                    }
                }
            }
        } else if ((bdVar.c & be.WriteNullNumberAsZero.w) != 0) {
            bdVar.write(48);
        } else {
            bdVar.a();
        }
    }

    @Override // com.amap.api.col.stln3.ae
    public final <T> T a(l lVar, Type type, Object obj) {
        T t;
        o oVar = lVar.c;
        int a2 = oVar.a();
        if (a2 == 8) {
            oVar.a(16);
            return null;
        } else if (a2 == 2) {
            if (type == Long.TYPE || type == Long.class) {
                t = (T) Long.valueOf(oVar.t());
            } else {
                try {
                    t = (T) Integer.valueOf(oVar.k());
                } catch (NumberFormatException e) {
                    throw new d("int value overflow, field : " + obj, e);
                }
            }
            oVar.a(16);
            return t;
        } else if (a2 == 3) {
            BigDecimal u = oVar.u();
            oVar.a(16);
            return (type == Long.TYPE || type == Long.class) ? (T) Long.valueOf(u.longValue()) : (T) Integer.valueOf(u.intValue());
        } else {
            Object e2 = lVar.e();
            try {
                if (type != Long.TYPE) {
                    if (type != Long.class) {
                        return (T) bk.j(e2);
                    }
                }
                return (T) bk.i(e2);
            } catch (Exception e3) {
                throw new d("cast error, field : " + obj + ", value " + e2, e3);
            }
        }
    }
}
