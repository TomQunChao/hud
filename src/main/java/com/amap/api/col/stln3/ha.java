package com.amap.api.col.stln3;

import com.autonavi.ae.gmap.style.StyleItem;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: StyleParserResult */
public final class ha {
    private Map<Integer, StyleItem> a = new ConcurrentHashMap();
    private Object b = null;
    private StyleItem[] c;

    public final Map<Integer, StyleItem> a() {
        return this.a;
    }

    public final StyleItem[] b() {
        Map<Integer, StyleItem> map = this.a;
        if (map == null || map.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (StyleItem styleItem : this.a.values()) {
            if (styleItem.isValid()) {
                arrayList.add(styleItem);
            }
        }
        int size = arrayList.size();
        if (size <= 0) {
            return null;
        }
        this.c = (StyleItem[]) arrayList.toArray(new StyleItem[size]);
        return this.c;
    }

    public final StyleItem[] c() {
        return this.c;
    }

    public final Object d() {
        return this.b;
    }
}
