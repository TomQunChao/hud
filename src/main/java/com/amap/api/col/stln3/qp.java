package com.amap.api.col.stln3;

import com.amap.api.location.AMapLocation;

/* compiled from: LocUtil */
public final class qp {
    public static boolean a(AMapLocation aMapLocation) {
        if (aMapLocation == null) {
            return false;
        }
        if (aMapLocation.getLatitude() == 0.0d && aMapLocation.getLongitude() == 0.0d) {
            return false;
        }
        return true;
    }
}
