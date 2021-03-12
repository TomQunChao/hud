package com.amap.api.maps;

import android.content.Context;
import com.amap.api.col.stln3.di;
import com.amap.api.col.stln3.hv;
import com.amap.api.col.stln3.rx;
import com.amap.api.maps.model.LatLng;

public class CoordinateConverter {
    private Context a;
    private CoordType b = null;
    private LatLng c = null;

    public enum CoordType {
        BAIDU,
        MAPBAR,
        GPS,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE
    }

    public CoordinateConverter(Context context) {
        this.a = context;
    }

    public CoordinateConverter from(CoordType coordType) {
        this.b = coordType;
        return this;
    }

    public CoordinateConverter coord(LatLng latLng) {
        this.c = latLng;
        return this;
    }

    public LatLng convert() {
        if (this.b == null || this.c == null) {
            return null;
        }
        try {
            switch (this.b) {
                case BAIDU:
                    return di.a(this.c);
                case MAPBAR:
                    return di.b(this.a, this.c);
                case MAPABC:
                case SOSOMAP:
                case ALIYUN:
                case GOOGLE:
                    return this.c;
                case GPS:
                    return di.a(this.a, this.c);
                default:
                    return null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "CoordinateConverter", "convert");
            return this.c;
        }
    }

    public static boolean isAMapDataAvailable(double d, double d2) {
        return hv.a(d, d2);
    }
}
