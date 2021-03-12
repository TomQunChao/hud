package com.amap.api.col.stln3;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

/* compiled from: CollectionCodec */
public final class al implements ae, ay {
    public static final al a = new al();

    private al() {
    }

    @Override // com.amap.api.col.stln3.ay
    public final void a(ar arVar, Object obj, Object obj2, Type type) throws IOException {
        bd bdVar = arVar.b;
        if (obj != null) {
            Type type2 = null;
            if ((bdVar.c & be.WriteClassName.w) != 0) {
                type2 = bk.d(type);
            }
            Collection collection = (Collection) obj;
            bb bbVar = arVar.j;
            arVar.a(bbVar, obj, obj2);
            if ((bdVar.c & be.WriteClassName.w) != 0) {
                if (HashSet.class == collection.getClass()) {
                    bdVar.append((CharSequence) "Set");
                } else if (TreeSet.class == collection.getClass()) {
                    bdVar.append((CharSequence) "TreeSet");
                }
            }
            int i = 0;
            try {
                bdVar.write(91);
                for (Object obj3 : collection) {
                    int i2 = i + 1;
                    if (i != 0) {
                        bdVar.write(44);
                    }
                    if (obj3 == null) {
                        bdVar.a();
                    } else {
                        Class<?> cls = obj3.getClass();
                        if (cls == Integer.class) {
                            bdVar.b(((Integer) obj3).intValue());
                        } else if (cls == Long.class) {
                            bdVar.a(((Long) obj3).longValue());
                            if ((bdVar.c & be.WriteClassName.w) != 0) {
                                bdVar.write(76);
                            }
                        } else {
                            arVar.a.a(cls).a(arVar, obj3, Integer.valueOf(i2 - 1), type2);
                        }
                    }
                    i = i2;
                }
                bdVar.write(93);
            } finally {
                arVar.j = bbVar;
            }
        } else if ((bdVar.c & be.WriteNullListAsEmpty.w) != 0) {
            bdVar.write("[]");
        } else {
            bdVar.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.amap.api.col.stln3.l] */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.util.Collection] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.amap.api.col.stln3.ae
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T a(com.amap.api.col.stln3.l r3, java.lang.reflect.Type r4, java.lang.Object r5) {
        /*
        // Method dump skipped, instructions count: 206
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.al.a(com.amap.api.col.stln3.l, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }
}
