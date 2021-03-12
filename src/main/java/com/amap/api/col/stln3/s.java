package com.amap.api.col.stln3;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;

/* access modifiers changed from: package-private */
/* compiled from: JavaObjectDeserializer */
public final class s implements ae {
    public static final s a = new s();

    s() {
    }

    @Override // com.amap.api.col.stln3.ae
    public final <T> T a(l lVar, Type type, Object obj) {
        if (!(type instanceof GenericArrayType)) {
            return (T) lVar.a(obj);
        }
        Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
        if (genericComponentType instanceof TypeVariable) {
            genericComponentType = ((TypeVariable) genericComponentType).getBounds()[0];
        }
        ArrayList arrayList = new ArrayList();
        lVar.a(genericComponentType, (Collection) arrayList);
        if (!(genericComponentType instanceof Class)) {
            return (T) arrayList.toArray();
        }
        T t = (T) ((Object[]) Array.newInstance((Class) genericComponentType, arrayList.size()));
        arrayList.toArray(t);
        return t;
    }
}
