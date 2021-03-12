package com.amap.api.col.stln3;

import com.amap.api.maps.model.MultiPointItem;
import com.autonavi.amap.mapcore.IPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: QuadTree2 */
public final class dy {
    private final dv a;
    private final int b;
    private int c;
    private List<MultiPointItem> d;
    private List<dy> e;

    protected dy(dv dvVar) {
        this(dvVar, 0);
    }

    private dy(int i, int i2, int i3, int i4, int i5) {
        this(new dv(i, i2, i3, i4), i5);
    }

    private dy(dv dvVar, int i) {
        this.c = 30;
        this.e = null;
        this.a = dvVar;
        this.b = i;
        int i2 = 10;
        switch (this.b) {
            case 0:
                i2 = 50;
                break;
            case 1:
                i2 = 30;
                break;
            case 2:
            case 3:
                i2 = 20;
                break;
            case 4:
            case 5:
                break;
            case 6:
            default:
                i2 = 5;
                break;
        }
        this.c = i2;
    }

    /* access modifiers changed from: protected */
    public final void a(MultiPointItem multiPointItem) {
        dy dyVar;
        int i;
        List<dy> list;
        IPoint iPoint = multiPointItem.getIPoint();
        if (this.a.a(iPoint.x, iPoint.y)) {
            int i2 = iPoint.x;
            int i3 = iPoint.y;
            dy dyVar2 = this;
            while (true) {
                if (dyVar2.d == null) {
                    dyVar2.d = new ArrayList();
                }
                if (dyVar2.d.size() <= dyVar2.c || dyVar2.b >= 40) {
                    dyVar2.d.add(multiPointItem);
                } else {
                    if (dyVar2.e == null) {
                        dyVar2.e = new ArrayList(4);
                        dyVar2.e.add(new dy(dyVar2.a.a, dyVar2.a.e, dyVar2.a.b, dyVar2.a.f, dyVar2.b + 1));
                        dyVar2.e.add(new dy(dyVar2.a.e, dyVar2.a.c, dyVar2.a.b, dyVar2.a.f, dyVar2.b + 1));
                        dyVar2.e.add(new dy(dyVar2.a.a, dyVar2.a.e, dyVar2.a.f, dyVar2.a.d, dyVar2.b + 1));
                        dyVar2.e.add(new dy(dyVar2.a.e, dyVar2.a.c, dyVar2.a.f, dyVar2.a.d, dyVar2.b + 1));
                    }
                    if (dyVar2.e != null) {
                        if (i3 < dyVar2.a.f) {
                            if (i2 < dyVar2.a.e) {
                                list = dyVar2.e;
                                i = 0;
                            } else {
                                dyVar = dyVar2.e.get(1);
                                dyVar2 = dyVar;
                            }
                        } else if (i2 < dyVar2.a.e) {
                            list = dyVar2.e;
                            i = 2;
                        } else {
                            list = dyVar2.e;
                            i = 3;
                        }
                        dyVar = list.get(i);
                        dyVar2 = dyVar;
                    } else {
                        return;
                    }
                }
            }
            dyVar2.d.add(multiPointItem);
        }
    }

    /* access modifiers changed from: protected */
    public final void a() {
        this.e = null;
        List<MultiPointItem> list = this.d;
        if (list != null) {
            list.clear();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(dv dvVar, Collection<MultiPointItem> collection, double d2) {
        a(dvVar, collection, 1.0f, d2);
    }

    private void a(dv dvVar, Collection<MultiPointItem> collection, float f, double d2) {
        if (this.a.a(dvVar)) {
            List<MultiPointItem> list = this.d;
            if (list != null) {
                int size = (int) (((float) list.size()) * f);
                for (int i = 0; i < size; i++) {
                    MultiPointItem multiPointItem = this.d.get(i);
                    IPoint iPoint = multiPointItem.getIPoint();
                    if (iPoint == null ? false : dvVar.a(iPoint.x, iPoint.y)) {
                        collection.add(multiPointItem);
                    }
                }
            }
            if (d2 > 0.0d) {
                double d3 = ((((double) this.a.d) - ((double) this.a.b)) * (((double) this.a.c) - ((double) this.a.a))) / d2;
                if (d3 < 0.699999988079071d) {
                    return;
                }
                if (d3 > 1.0d) {
                    f = 1.0f;
                } else {
                    f = (float) ((((4.8188d * d3) * d3) - (d3 * 4.9339d)) + 1.1093d);
                }
            }
            List<dy> list2 = this.e;
            if (list2 != null) {
                for (dy dyVar : list2) {
                    dyVar.a(dvVar, collection, f, d2);
                }
            }
        }
    }
}
