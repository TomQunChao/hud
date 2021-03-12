package com.amap.api.maps.model;

import com.amap.api.col.stln3.ic;
import com.autonavi.amap.mapcore.DPoint;

public class WeightedLatLng {
    public static final double DEFAULT_INTENSITY = 1.0d;
    private DPoint a;
    public final double intensity;
    public final LatLng latLng;

    public WeightedLatLng(LatLng latLng2, double d) {
        if (latLng2 != null) {
            this.latLng = latLng2;
            this.a = ic.a(latLng2);
            if (d >= 0.0d) {
                this.intensity = d;
            } else {
                this.intensity = 1.0d;
            }
        } else {
            throw new IllegalArgumentException("latLng can not null");
        }
    }

    public WeightedLatLng(LatLng latLng2) {
        this(latLng2, 1.0d);
    }

    /* access modifiers changed from: protected */
    public DPoint getPoint() {
        return this.a;
    }
}
