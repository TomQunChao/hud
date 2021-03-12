package com.amap.api.col.stln3;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* compiled from: ParameterizedTypeImpl */
public final class bj implements ParameterizedType {
    private final Type[] a;
    private final Type b;
    private final Type c;

    public bj(Type[] typeArr, Type type, Type type2) {
        this.a = typeArr;
        this.b = type;
        this.c = type2;
    }

    public final Type[] getActualTypeArguments() {
        return this.a;
    }

    public final Type getOwnerType() {
        return this.b;
    }

    public final Type getRawType() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        bj bjVar = (bj) obj;
        if (!Arrays.equals(this.a, bjVar.a)) {
            return false;
        }
        Type type = this.b;
        if (type == null ? bjVar.b != null : !type.equals(bjVar.b)) {
            return false;
        }
        Type type2 = this.c;
        if (type2 != null) {
            return type2.equals(bjVar.c);
        }
        if (bjVar.c == null) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        Type[] typeArr = this.a;
        int i = 0;
        int hashCode = (typeArr != null ? Arrays.hashCode(typeArr) : 0) * 31;
        Type type = this.b;
        int hashCode2 = (hashCode + (type != null ? type.hashCode() : 0)) * 31;
        Type type2 = this.c;
        if (type2 != null) {
            i = type2.hashCode();
        }
        return hashCode2 + i;
    }
}
