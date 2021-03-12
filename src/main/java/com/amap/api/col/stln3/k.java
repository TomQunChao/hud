package com.amap.api.col.stln3;

import com.amap.api.col.stln3.l;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/* compiled from: DefaultFieldDeserializer */
public final class k extends ac {
    protected ae a;

    public k(Class<?> cls, bh bhVar) {
        super(cls, bhVar);
    }

    public final ae a(w wVar) {
        if (this.a == null) {
            this.a = wVar.a(this.b.f, this.b.g);
        }
        return this.a;
    }

    @Override // com.amap.api.col.stln3.ac
    public final void a(l lVar, Object obj, Type type, Map<String, Object> map) {
        Object obj2;
        Class<?> cls;
        if (this.a == null) {
            this.a = lVar.b.a(this.b.f, this.b.g);
        }
        Type type2 = this.b.g;
        boolean z = type instanceof ParameterizedType;
        if (z) {
            v vVar = lVar.d;
            if (vVar != null) {
                vVar.d = type;
            }
            type2 = bh.a(this.c, type, type2);
            this.a = lVar.b.a(type2);
        }
        if ((type2 instanceof ParameterizedType) && z) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            ParameterizedType parameterizedType2 = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Type rawType = parameterizedType2.getRawType();
            if ((rawType instanceof Class) && bk.a(actualTypeArguments, ((Class) rawType).getTypeParameters(), parameterizedType2.getActualTypeArguments())) {
                type2 = new bj(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType());
            }
        }
        String str = this.b.k;
        if (str == null || !(this.a instanceof am)) {
            obj2 = this.a.a(lVar, type2, this.b.a);
        } else {
            String str2 = this.b.a;
            obj2 = am.a(lVar, type2, str);
        }
        if (lVar.e == 1) {
            l.a c = lVar.c();
            c.a = this;
            c.b = lVar.d;
            lVar.e = 0;
        } else if (obj == null) {
            map.put(this.b.a, obj2);
        } else if (obj2 != null || ((cls = this.b.f) != Byte.TYPE && cls != Short.TYPE && cls != Float.TYPE && cls != Double.TYPE)) {
            a(obj, obj2);
        }
    }
}
