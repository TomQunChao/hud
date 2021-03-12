package com.amap.api.col.stln3;

import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Polyline;
import java.util.List;

/* compiled from: NaviPolyline */
public final class kj {
    public Polyline a = null;
    public int b = 0;
    public int c = 0;
    public boolean d = false;
    public List<LatLng> e;
    public boolean f = false;

    public kj(Polyline polyline, int i, int i2, boolean z, List<LatLng> list) {
        this.a = polyline;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = list;
    }
}
