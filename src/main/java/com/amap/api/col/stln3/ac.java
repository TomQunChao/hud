package com.amap.api.col.stln3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/* compiled from: FieldDeserializer */
public abstract class ac {
    public final bh b;
    public final Class<?> c;
    protected Enum[] d;
    protected long[] e;

    public abstract void a(l lVar, Object obj, Type type, Map<String, Object> map);

    public ac(Class<?> cls, bh bhVar) {
        this.c = cls;
        this.b = bhVar;
        if (bhVar != null) {
            Class<?> cls2 = bhVar.f;
            if (cls2.isEnum()) {
                Enum[] enumArr = (Enum[]) cls2.getEnumConstants();
                long[] jArr = new long[enumArr.length];
                this.e = new long[enumArr.length];
                for (int i = 0; i < enumArr.length; i++) {
                    String name = enumArr[i].name();
                    long j = -3750763034362895579L;
                    for (int i2 = 0; i2 < name.length(); i2++) {
                        j = (j ^ ((long) name.charAt(i2))) * 1099511628211L;
                    }
                    jArr[i] = j;
                    this.e[i] = j;
                }
                Arrays.sort(this.e);
                this.d = new Enum[enumArr.length];
                for (int i3 = 0; i3 < this.e.length; i3++) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= jArr.length) {
                            break;
                        } else if (this.e[i3] == jArr[i4]) {
                            this.d[i3] = enumArr[i4];
                            break;
                        } else {
                            i4++;
                        }
                    }
                }
            }
        }
    }

    public final Enum a(long j) {
        int binarySearch;
        if (this.d != null && (binarySearch = Arrays.binarySearch(this.e, j)) >= 0) {
            return this.d[binarySearch];
        }
        return null;
    }

    public void a(Object obj, Object obj2) {
        if (obj2 != null || !this.b.f.isPrimitive()) {
            Field field = this.b.c;
            Method method = this.b.b;
            try {
                if (this.b.d) {
                    if (!this.b.i) {
                        field.set(obj, obj2);
                    } else if (Map.class.isAssignableFrom(this.b.f)) {
                        Map map = (Map) field.get(obj);
                        if (map != null) {
                            map.putAll((Map) obj2);
                        }
                    } else {
                        Collection collection = (Collection) field.get(obj);
                        if (collection != null) {
                            collection.addAll((Collection) obj2);
                        }
                    }
                } else if (!this.b.i) {
                    method.invoke(obj, obj2);
                } else if (Map.class.isAssignableFrom(this.b.f)) {
                    Map map2 = (Map) method.invoke(obj, new Object[0]);
                    if (map2 != null) {
                        map2.putAll((Map) obj2);
                    }
                } else {
                    Collection collection2 = (Collection) method.invoke(obj, new Object[0]);
                    if (collection2 != null) {
                        collection2.addAll((Collection) obj2);
                    }
                }
            } catch (Exception e2) {
                throw new d("set property error, " + this.b.a, e2);
            }
        }
    }
}
