package com.amap.api.col.stln3;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.IdentityHashMap;
import java.util.List;

/* compiled from: ListSerializer */
public final class at implements ay {
    /* JADX INFO: finally extract failed */
    @Override // com.amap.api.col.stln3.ay
    public final void a(ar arVar, Object obj, Object obj2, Type type) throws IOException {
        bd bdVar = arVar.b;
        boolean z = (bdVar.c & be.WriteClassName.w) != 0;
        Type type2 = null;
        if (z) {
            type2 = bk.d(type);
        }
        if (obj != null) {
            List list = (List) obj;
            int size = list.size();
            if (size == 0) {
                bdVar.append((CharSequence) "[]");
                return;
            }
            bb bbVar = arVar.j;
            if ((bdVar.c & be.DisableCircularReferenceDetect.w) == 0) {
                arVar.j = new bb(bbVar, obj, obj2, 0);
                if (arVar.i == null) {
                    arVar.i = new IdentityHashMap<>();
                }
                arVar.i.put(obj, arVar.j);
            }
            try {
                if ((bdVar.c & be.PrettyFormat.w) != 0) {
                    bdVar.write(91);
                    arVar.b();
                    for (int i = 0; i < size; i++) {
                        Object obj3 = list.get(i);
                        if (i != 0) {
                            bdVar.write(44);
                        }
                        arVar.d();
                        if (obj3 == null) {
                            arVar.b.a();
                        } else if (arVar.i == null || !arVar.i.containsKey(obj3)) {
                            ay a = arVar.a.a(obj3.getClass());
                            arVar.j = new bb(bbVar, obj, obj2, 0);
                            a.a(arVar, obj3, Integer.valueOf(i), type2);
                        } else {
                            arVar.a(obj3);
                        }
                    }
                    arVar.c();
                    arVar.d();
                    bdVar.write(93);
                    arVar.j = bbVar;
                    return;
                }
                int i2 = bdVar.b + 1;
                if (i2 > bdVar.a.length) {
                    if (bdVar.d == null) {
                        bdVar.a(i2);
                    } else {
                        bdVar.flush();
                        i2 = 1;
                    }
                }
                bdVar.a[bdVar.b] = '[';
                bdVar.b = i2;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    Object obj4 = list.get(i3);
                    if (i3 != 0) {
                        int i4 = bdVar.b + 1;
                        if (i4 > bdVar.a.length) {
                            if (bdVar.d == null) {
                                bdVar.a(i4);
                            } else {
                                bdVar.flush();
                                i4 = 1;
                            }
                        }
                        bdVar.a[bdVar.b] = ',';
                        bdVar.b = i4;
                    }
                    if (obj4 == null) {
                        bdVar.append((CharSequence) "null");
                    } else {
                        Class<?> cls = obj4.getClass();
                        if (cls == Integer.class) {
                            bdVar.b(((Integer) obj4).intValue());
                        } else if (cls == Long.class) {
                            long longValue = ((Long) obj4).longValue();
                            if (z) {
                                bdVar.a(longValue);
                                bdVar.write(76);
                            } else {
                                bdVar.a(longValue);
                            }
                        } else if (cls == String.class) {
                            String str = (String) obj4;
                            if ((bdVar.c & be.UseSingleQuotes.w) != 0) {
                                bdVar.b(str);
                            } else {
                                bdVar.a(str, (char) 0, true);
                            }
                        } else {
                            if ((bdVar.c & be.DisableCircularReferenceDetect.w) == 0) {
                                arVar.j = new bb(bbVar, obj, obj2, 0);
                            }
                            if (arVar.i == null || !arVar.i.containsKey(obj4)) {
                                arVar.a.a(obj4.getClass()).a(arVar, obj4, Integer.valueOf(i3), type2);
                            } else {
                                arVar.a(obj4);
                            }
                        }
                    }
                }
                int i5 = bdVar.b + 1;
                if (i5 > bdVar.a.length) {
                    if (bdVar.d == null) {
                        bdVar.a(i5);
                    } else {
                        bdVar.flush();
                        i5 = 1;
                    }
                }
                bdVar.a[bdVar.b] = ']';
                bdVar.b = i5;
                arVar.j = bbVar;
            } catch (Throwable th) {
                arVar.j = bbVar;
                throw th;
            }
        } else if ((bdVar.c & be.WriteNullListAsEmpty.w) != 0) {
            bdVar.write("[]");
        } else {
            bdVar.a();
        }
    }
}
