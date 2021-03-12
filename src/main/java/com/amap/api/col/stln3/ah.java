package com.amap.api.col.stln3;

import java.io.IOException;
import java.lang.reflect.Type;

/* access modifiers changed from: package-private */
/* compiled from: ArraySerializer */
public final class ah implements ay {
    private final Class<?> a;
    private final ay b;

    ah(Class<?> cls, ay ayVar) {
        this.a = cls;
        this.b = ayVar;
    }

    @Override // com.amap.api.col.stln3.ay
    public final void a(ar arVar, Object obj, Object obj2, Type type) throws IOException {
        bd bdVar = arVar.b;
        if (obj != null) {
            int i = 0;
            if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                bdVar.write(91);
                while (i < zArr.length) {
                    if (i != 0) {
                        bdVar.write(44);
                    }
                    bdVar.a(zArr[i]);
                    i++;
                }
                bdVar.write(93);
            } else if (obj instanceof byte[]) {
                bdVar.a((byte[]) obj);
            } else if (obj instanceof char[]) {
                bdVar.a(new String((char[]) obj));
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length = dArr.length - 1;
                if (length == -1) {
                    bdVar.append((CharSequence) "[]");
                    return;
                }
                bdVar.write(91);
                while (i < length) {
                    double d = dArr[i];
                    if (Double.isNaN(d)) {
                        bdVar.a();
                    } else {
                        bdVar.append((CharSequence) Double.toString(d));
                    }
                    bdVar.write(44);
                    i++;
                }
                double d2 = dArr[length];
                if (Double.isNaN(d2)) {
                    bdVar.a();
                } else {
                    bdVar.append((CharSequence) Double.toString(d2));
                }
                bdVar.write(93);
            } else if (obj instanceof float[]) {
                float[] fArr = (float[]) obj;
                int length2 = fArr.length - 1;
                if (length2 == -1) {
                    bdVar.append((CharSequence) "[]");
                    return;
                }
                bdVar.write(91);
                while (i < length2) {
                    float f = fArr[i];
                    if (Float.isNaN(f)) {
                        bdVar.a();
                    } else {
                        bdVar.append((CharSequence) Float.toString(f));
                    }
                    bdVar.write(44);
                    i++;
                }
                float f2 = fArr[length2];
                if (Float.isNaN(f2)) {
                    bdVar.a();
                } else {
                    bdVar.append((CharSequence) Float.toString(f2));
                }
                bdVar.write(93);
            } else if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                bdVar.write(91);
                while (i < iArr.length) {
                    if (i != 0) {
                        bdVar.write(44);
                    }
                    bdVar.b(iArr[i]);
                    i++;
                }
                bdVar.write(93);
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                bdVar.write(91);
                while (i < jArr.length) {
                    if (i != 0) {
                        bdVar.write(44);
                    }
                    bdVar.a(jArr[i]);
                    i++;
                }
                bdVar.write(93);
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                bdVar.write(91);
                while (i < sArr.length) {
                    if (i != 0) {
                        bdVar.write(44);
                    }
                    bdVar.b(sArr[i]);
                    i++;
                }
                bdVar.write(93);
            } else {
                Object[] objArr = (Object[]) obj;
                int length3 = objArr.length;
                bb bbVar = arVar.j;
                arVar.a(bbVar, obj, obj2);
                try {
                    bdVar.write(91);
                    while (i < length3) {
                        if (i != 0) {
                            bdVar.write(44);
                        }
                        Object obj3 = objArr[i];
                        if (obj3 == null) {
                            if (!bdVar.b(be.WriteNullStringAsEmpty) || !(obj instanceof String[])) {
                                bdVar.append((CharSequence) "null");
                            } else {
                                bdVar.a("");
                            }
                        } else if (obj3.getClass() == this.a) {
                            this.b.a(arVar, obj3, Integer.valueOf(i), null);
                        } else {
                            arVar.a.a(obj3.getClass()).a(arVar, obj3, Integer.valueOf(i), null);
                        }
                        i++;
                    }
                    bdVar.write(93);
                } finally {
                    arVar.j = bbVar;
                }
            }
        } else if ((bdVar.c & be.WriteNullListAsEmpty.w) != 0) {
            bdVar.write("[]");
        } else {
            bdVar.a();
        }
    }
}
