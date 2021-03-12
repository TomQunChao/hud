package com.amap.api.col.stln3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

/* compiled from: MemDataCacher */
public final class pz implements py {
    private Vector<pt> a = new Stack();

    public final List<pt> a(int i) {
        Vector<pt> vector = this.a;
        if (vector == null || vector.size() == 0) {
            return new ArrayList();
        }
        if (i >= this.a.size()) {
            return new ArrayList(this.a);
        }
        return this.a.subList(0, i);
    }

    public final int a() {
        Vector<pt> vector = this.a;
        if (vector != null) {
            return vector.size();
        }
        return 0;
    }

    public final List<pt> b() {
        return this.a;
    }

    public final void c() {
        this.a.clear();
    }

    @Override // com.amap.api.col.stln3.py
    public final void a(Set<Long> set) {
        if (set != null) {
            Vector vector = new Vector();
            if (!(set == null || set.size() == 0)) {
                for (int i = 0; i < this.a.size(); i++) {
                    if (!set.contains(Long.valueOf(this.a.get(i).a()))) {
                        vector.add(this.a.get(i));
                    }
                }
                this.a = new Vector<>(vector);
            }
        }
    }

    public final void a(pt ptVar) {
        if (this.a == null) {
            this.a = new Vector<>();
        }
        this.a.add(0, ptVar);
    }

    public final void a(List<pt> list) {
        if (this.a == null) {
            this.a = new Vector<>();
        }
        this.a.addAll(0, list);
    }
}
