package com.amap.api.maps.model;

import com.amap.api.col.stln3.hg;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: PointQuadTree */
final class a {
    private final hg a;
    private final int b;
    private List<WeightedLatLng> c;
    private List<a> d;

    protected a(hg hgVar) {
        this(hgVar, 0);
    }

    private a(double d2, double d3, double d4, double d5, int i) {
        this(new hg(d2, d3, d4, d5), i);
    }

    private a(hg hgVar, int i) {
        this.d = null;
        this.a = hgVar;
        this.b = i;
    }

    /* access modifiers changed from: protected */
    public final void a(WeightedLatLng weightedLatLng) {
        DPoint point = weightedLatLng.getPoint();
        if (this.a.a(point.x, point.y)) {
            a(point.x, point.y, weightedLatLng);
        }
    }

    private void a(double d2, double d3, WeightedLatLng weightedLatLng) {
        a aVar = this;
        while (aVar.d != null) {
            if (d3 < aVar.a.f) {
                if (d2 < aVar.a.e) {
                    aVar = aVar.d.get(0);
                } else {
                    aVar = aVar.d.get(1);
                }
            } else if (d2 < aVar.a.e) {
                aVar = aVar.d.get(2);
            } else {
                aVar = aVar.d.get(3);
            }
        }
        if (aVar.c == null) {
            aVar.c = new ArrayList();
        }
        aVar.c.add(weightedLatLng);
        if (aVar.c.size() > 50 && aVar.b < 40) {
            aVar.a();
        }
    }

    private void a() {
        this.d = new ArrayList(4);
        this.d.add(new a(this.a.a, this.a.e, this.a.b, this.a.f, this.b + 1));
        this.d.add(new a(this.a.e, this.a.c, this.a.b, this.a.f, this.b + 1));
        this.d.add(new a(this.a.a, this.a.e, this.a.f, this.a.d, this.b + 1));
        this.d.add(new a(this.a.e, this.a.c, this.a.f, this.a.d, this.b + 1));
        List<WeightedLatLng> list = this.c;
        this.c = null;
        for (WeightedLatLng weightedLatLng : list) {
            a(weightedLatLng.getPoint().x, weightedLatLng.getPoint().y, weightedLatLng);
        }
    }

    /* access modifiers changed from: protected */
    public final Collection<WeightedLatLng> a(hg hgVar) {
        ArrayList arrayList = new ArrayList();
        a(hgVar, arrayList);
        return arrayList;
    }

    private void a(hg hgVar, Collection<WeightedLatLng> collection) {
        if (this.a.a(hgVar)) {
            List<a> list = this.d;
            if (list != null) {
                for (a aVar : list) {
                    aVar.a(hgVar, collection);
                }
            } else if (this.c != null) {
                hg hgVar2 = this.a;
                if (hgVar2.a >= hgVar.a && hgVar2.c <= hgVar.c && hgVar2.b >= hgVar.b && hgVar2.d <= hgVar.d) {
                    collection.addAll(this.c);
                    return;
                }
                for (WeightedLatLng weightedLatLng : this.c) {
                    DPoint point = weightedLatLng.getPoint();
                    if (hgVar.a(point.x, point.y)) {
                        collection.add(weightedLatLng);
                    }
                }
            }
        }
    }
}
