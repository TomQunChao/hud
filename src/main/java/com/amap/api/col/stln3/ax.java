package com.amap.api.col.stln3;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

/* compiled from: NumberCodec */
public final class ax implements ae, ay {
    public static final ax a = new ax();
    private DecimalFormat b = null;

    private ax() {
    }

    @Override // com.amap.api.col.stln3.ay
    public final void a(ar arVar, Object obj, Object obj2, Type type) throws IOException {
        String str;
        bd bdVar = arVar.b;
        if (obj == null) {
            if ((bdVar.c & be.WriteNullNumberAsZero.w) != 0) {
                bdVar.write(48);
            } else {
                bdVar.a();
            }
        } else if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            if (Float.isNaN(floatValue)) {
                bdVar.a();
            } else if (Float.isInfinite(floatValue)) {
                bdVar.a();
            } else {
                String f = Float.toString(floatValue);
                if (f.endsWith(".0")) {
                    f = f.substring(0, f.length() - 2);
                }
                bdVar.write(f);
                if ((bdVar.c & be.WriteClassName.w) != 0) {
                    bdVar.write(70);
                }
            }
        } else {
            double doubleValue = ((Double) obj).doubleValue();
            if (Double.isNaN(doubleValue)) {
                bdVar.a();
            } else if (Double.isInfinite(doubleValue)) {
                bdVar.a();
            } else {
                DecimalFormat decimalFormat = this.b;
                if (decimalFormat == null) {
                    str = Double.toString(doubleValue);
                    if (str.endsWith(".0")) {
                        str = str.substring(0, str.length() - 2);
                    }
                } else {
                    str = decimalFormat.format(doubleValue);
                }
                bdVar.append((CharSequence) str);
                if ((bdVar.c & be.WriteClassName.w) != 0) {
                    bdVar.write(68);
                }
            }
        }
    }

    @Override // com.amap.api.col.stln3.ae
    public final <T> T a(l lVar, Type type, Object obj) {
        o oVar = lVar.c;
        int a2 = oVar.a();
        if (a2 == 2) {
            if (type == Double.TYPE || type == Double.class) {
                String e = oVar.e();
                oVar.a(16);
                return (T) Double.valueOf(Double.parseDouble(e));
            } else if (type == Float.TYPE || type == Float.class) {
                String e2 = oVar.e();
                oVar.a(16);
                return (T) Float.valueOf(Float.parseFloat(e2));
            } else {
                long t = oVar.t();
                oVar.a(16);
                return (type == Short.TYPE || type == Short.class) ? (T) Short.valueOf((short) ((int) t)) : (type == Byte.TYPE || type == Byte.class) ? (T) Byte.valueOf((byte) ((int) t)) : (t < -2147483648L || t > 2147483647L) ? (T) Long.valueOf(t) : (T) Integer.valueOf((int) t);
            }
        } else if (a2 != 3) {
            Object e3 = lVar.e();
            if (e3 == null) {
                return null;
            }
            return (type == Double.TYPE || type == Double.class) ? (T) bk.h(e3) : (type == Float.TYPE || type == Float.class) ? (T) bk.g(e3) : (type == Short.TYPE || type == Short.class) ? (T) bk.d(e3) : (type == Byte.TYPE || type == Byte.class) ? (T) bk.b(e3) : (T) bk.e(e3);
        } else if (type == Double.TYPE || type == Double.class) {
            String e4 = oVar.e();
            oVar.a(16);
            return (T) Double.valueOf(Double.parseDouble(e4));
        } else if (type == Float.TYPE || type == Float.class) {
            String e5 = oVar.e();
            oVar.a(16);
            return (T) Float.valueOf(Float.parseFloat(e5));
        } else {
            T t2 = (T) oVar.u();
            oVar.a(16);
            return (type == Short.TYPE || type == Short.class) ? (T) Short.valueOf(t2.shortValue()) : (type == Byte.TYPE || type == Byte.class) ? (T) Byte.valueOf(t2.byteValue()) : t2;
        }
    }
}
