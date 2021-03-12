package com.amap.api.col.stln3;

import com.amap.api.maps.model.LatLng;

/* compiled from: SegmentsIntersect */
public final class hx {
    private static LatLng a(LatLng latLng, LatLng latLng2) {
        return new LatLng(latLng2.latitude - latLng.latitude, latLng2.longitude - latLng.longitude);
    }

    private static double a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        LatLng a = a(latLng3, latLng);
        LatLng a2 = a(latLng2, latLng);
        return (a.longitude * a2.latitude) - (a2.longitude * a.latitude);
    }

    private static boolean b(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d = latLng.longitude - latLng2.longitude > 0.0d ? latLng.longitude : latLng2.longitude;
        double d2 = latLng.longitude - latLng2.longitude < 0.0d ? latLng.longitude : latLng2.longitude;
        double d3 = latLng.latitude - latLng2.latitude > 0.0d ? latLng.latitude : latLng2.latitude;
        double d4 = latLng.latitude - latLng2.latitude < 0.0d ? latLng.latitude : latLng2.latitude;
        if (d2 > latLng3.longitude || latLng3.longitude > d || d4 > latLng3.latitude || latLng3.latitude > d3) {
            return false;
        }
        return true;
    }

    public static boolean a(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4) {
        double a = a(latLng3, latLng4, latLng);
        double a2 = a(latLng3, latLng4, latLng2);
        double a3 = a(latLng, latLng2, latLng3);
        double a4 = a(latLng, latLng2, latLng4);
        int i = (a > 0.0d ? 1 : (a == 0.0d ? 0 : -1));
        if (((i > 0 && a2 < 0.0d) || (a < 0.0d && a2 > 0.0d)) && ((a3 > 0.0d && a4 < 0.0d) || (a3 < 0.0d && a4 > 0.0d))) {
            return true;
        }
        if (i == 0 && b(latLng3, latLng4, latLng)) {
            return true;
        }
        if (a2 == 0.0d && b(latLng3, latLng4, latLng2)) {
            return true;
        }
        if (a3 != 0.0d || !b(latLng, latLng2, latLng3)) {
            return a4 == 0.0d && b(latLng, latLng2, latLng4);
        }
        return true;
    }
}
