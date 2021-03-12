package com.amap.api.col.stln3;

import java.lang.reflect.Type;

/* access modifiers changed from: package-private */
/* compiled from: ListTypeFieldDeserializer */
public final class t extends ac {
    private final Type a;
    private ae f;
    private final boolean g;

    public t(Class<?> cls, bh bhVar) {
        super(cls, bhVar);
        Type type = bhVar.g;
        Class<?> cls2 = bhVar.f;
        if (cls2.isArray()) {
            this.a = cls2.getComponentType();
            this.g = true;
            return;
        }
        this.a = bk.d(type);
        this.g = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.amap.api.col.stln3.t] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.amap.api.col.stln3.ac
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.amap.api.col.stln3.l r5, java.lang.Object r6, java.lang.reflect.Type r7, java.util.Map<java.lang.String, java.lang.Object> r8) {
        /*
        // Method dump skipped, instructions count: 115
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.t.a(com.amap.api.col.stln3.l, java.lang.Object, java.lang.reflect.Type, java.util.Map):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.amap.api.col.stln3.l r18, java.lang.reflect.Type r19, java.util.Collection r20) {
        /*
        // Method dump skipped, instructions count: 623
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.t.a(com.amap.api.col.stln3.l, java.lang.reflect.Type, java.util.Collection):void");
    }
}
