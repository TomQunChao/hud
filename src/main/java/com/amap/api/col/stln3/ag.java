package com.amap.api.col.stln3;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;

/* compiled from: ArrayCodec */
public final class ag implements ae, ay {
    public static final ag a = new ag();

    private ag() {
    }

    @Override // com.amap.api.col.stln3.ay
    public final void a(ar arVar, Object obj, Object obj2, Type type) throws IOException {
        bd bdVar = arVar.b;
        Object[] objArr = (Object[]) obj;
        if (obj != null) {
            int length = objArr.length;
            int i = length - 1;
            if (i == -1) {
                bdVar.append((CharSequence) "[]");
                return;
            }
            bb bbVar = arVar.j;
            arVar.a(bbVar, obj, obj2);
            try {
                bdVar.write(91);
                int i2 = 0;
                if ((bdVar.c & be.PrettyFormat.w) != 0) {
                    arVar.b();
                    arVar.d();
                    while (i2 < length) {
                        if (i2 != 0) {
                            bdVar.write(44);
                            arVar.d();
                        }
                        arVar.b(objArr[i2]);
                        i2++;
                    }
                    arVar.c();
                    arVar.d();
                    bdVar.write(93);
                    return;
                }
                Class<?> cls = null;
                ay ayVar = null;
                while (i2 < i) {
                    Object obj3 = objArr[i2];
                    if (obj3 == null) {
                        bdVar.append((CharSequence) "null,");
                    } else {
                        if (arVar.i == null || !arVar.i.containsKey(obj3)) {
                            Class<?> cls2 = obj3.getClass();
                            if (cls2 == cls) {
                                ayVar.a(arVar, obj3, null, null);
                            } else {
                                ayVar = arVar.a.a(cls2);
                                ayVar.a(arVar, obj3, null, null);
                                cls = cls2;
                            }
                        } else {
                            arVar.a(obj3);
                        }
                        bdVar.write(44);
                    }
                    i2++;
                }
                Object obj4 = objArr[i];
                if (obj4 == null) {
                    bdVar.append((CharSequence) "null]");
                } else {
                    if (arVar.i == null || !arVar.i.containsKey(obj4)) {
                        Integer valueOf = Integer.valueOf(i);
                        if (obj4 == null) {
                            try {
                                arVar.b.a();
                            } catch (IOException e) {
                                throw new d(e.getMessage(), e);
                            }
                        } else {
                            arVar.a.a(obj4.getClass()).a(arVar, obj4, valueOf, null);
                        }
                    } else {
                        arVar.a(obj4);
                    }
                    bdVar.write(93);
                }
                arVar.j = bbVar;
            } finally {
                arVar.j = bbVar;
            }
        } else if ((bdVar.c & be.WriteNullListAsEmpty.w) != 0) {
            bdVar.write("[]");
        } else {
            bdVar.a();
        }
    }

    @Override // com.amap.api.col.stln3.ae
    public final <T> T a(l lVar, Type type, Object obj) {
        o oVar = lVar.c;
        int a2 = oVar.a();
        if (a2 == 8) {
            oVar.a(16);
            return null;
        } else if (type == char[].class) {
            if (a2 == 4) {
                String m = oVar.m();
                oVar.a(16);
                return (T) m.toCharArray();
            } else if (a2 != 2) {
                return (T) a.a(lVar.e()).toCharArray();
            } else {
                Number g = oVar.g();
                oVar.a(16);
                return (T) g.toString().toCharArray();
            }
        } else if (a2 == 4) {
            T t = (T) oVar.l();
            oVar.a(16);
            return t;
        } else {
            Class<?> componentType = ((Class) type).getComponentType();
            b bVar = new b();
            lVar.a(componentType, bVar, obj);
            return (T) a(lVar, componentType, bVar);
        }
    }

    private <T> T a(l lVar, Class<?> cls, b bVar) {
        if (bVar == null) {
            return null;
        }
        int size = bVar.size();
        T t = (T) Array.newInstance(cls, size);
        for (int i = 0; i < size; i++) {
            Object obj = bVar.get(i);
            if (obj == bVar) {
                Array.set(t, i, t);
            } else {
                if (!cls.isArray()) {
                    obj = bk.a(obj, (Class) cls, lVar.b);
                } else if (!cls.isInstance(obj)) {
                    obj = a(lVar, cls, (b) obj);
                }
                Array.set(t, i, obj);
            }
        }
        bVar.c(t);
        bVar.a((Type) cls);
        return t;
    }
}
