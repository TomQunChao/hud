package com.amap.api.col.stln3;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: ResolveFieldDeserializer */
public final class x extends ac {
    private final int a;
    private final List f;
    private final l g;
    private final Object h;
    private final Map i;
    private final Collection j;

    public x(l lVar, List list, int i2) {
        super(null, null);
        this.g = lVar;
        this.a = i2;
        this.f = list;
        this.h = null;
        this.i = null;
        this.j = null;
    }

    public x(Map map, Object obj) {
        super(null, null);
        this.g = null;
        this.a = -1;
        this.f = null;
        this.h = obj;
        this.i = map;
        this.j = null;
    }

    public x(Collection collection) {
        super(null, null);
        this.g = null;
        this.a = -1;
        this.f = null;
        this.h = null;
        this.i = null;
        this.j = collection;
    }

    @Override // com.amap.api.col.stln3.ac
    public final void a(Object obj, Object obj2) {
        b bVar;
        Object b;
        Map map = this.i;
        if (map != null) {
            map.put(this.h, obj2);
            return;
        }
        Collection collection = this.j;
        if (collection != null) {
            collection.add(obj2);
            return;
        }
        this.f.set(this.a, obj2);
        List list = this.f;
        if ((list instanceof b) && (b = (bVar = (b) list).b()) != null && Array.getLength(b) > this.a) {
            if (bVar.c() != null) {
                obj2 = bk.a(obj2, bVar.c(), this.g.b);
            }
            Array.set(b, this.a, obj2);
        }
    }

    @Override // com.amap.api.col.stln3.ac
    public final void a(l lVar, Object obj, Type type, Map<String, Object> map) {
    }
}
