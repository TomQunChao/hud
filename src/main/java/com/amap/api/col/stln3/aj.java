package com.amap.api.col.stln3;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: BigDecimalCodec */
public final class aj implements ae, ay {
    public static final aj a = new aj();

    private aj() {
    }

    @Override // com.amap.api.col.stln3.ay
    public final void a(ar arVar, Object obj, Object obj2, Type type) throws IOException {
        bd bdVar = arVar.b;
        if (obj == null) {
            if ((bdVar.c & be.WriteNullNumberAsZero.w) != 0) {
                bdVar.write(48);
            } else {
                bdVar.a();
            }
        } else if (obj instanceof BigInteger) {
            bdVar.write(((BigInteger) obj).toString());
        } else {
            BigDecimal bigDecimal = (BigDecimal) obj;
            bdVar.write(bigDecimal.toString());
            if ((bdVar.c & be.WriteClassName.w) != 0 && type != BigDecimal.class && bigDecimal.scale() == 0) {
                bdVar.write(46);
            }
        }
    }

    @Override // com.amap.api.col.stln3.ae
    public final <T> T a(l lVar, Type type, Object obj) {
        o oVar = lVar.c;
        int a2 = oVar.a();
        if (a2 == 2) {
            if (type == BigInteger.class) {
                String e = oVar.e();
                oVar.a(16);
                return (T) new BigInteger(e, 10);
            }
            T t = (T) oVar.u();
            oVar.a(16);
            return t;
        } else if (a2 == 3) {
            T t2 = (T) oVar.u();
            oVar.a(16);
            return type == BigInteger.class ? (T) t2.toBigInteger() : t2;
        } else {
            Object e2 = lVar.e();
            if (e2 == null) {
                return null;
            }
            return type == BigInteger.class ? (T) bk.f(e2) : (T) bk.e(e2);
        }
    }
}
