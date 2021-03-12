package com.amap.api.col.stln3;

import android.graphics.Point;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

/* compiled from: CameraUpdateFactoryDelegate */
public final class dh {
    public static AbstractCameraUpdateMessage a() {
        dg dgVar = new dg();
        dgVar.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        dgVar.amount = 1.0f;
        return dgVar;
    }

    public static AbstractCameraUpdateMessage b() {
        dg dgVar = new dg();
        dgVar.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        dgVar.amount = -1.0f;
        return dgVar;
    }

    public static AbstractCameraUpdateMessage a(float f) {
        de deVar = new de();
        deVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        deVar.zoom = f;
        return deVar;
    }

    public static AbstractCameraUpdateMessage a(float f, Point point) {
        dg dgVar = new dg();
        dgVar.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        dgVar.amount = f;
        dgVar.focus = point;
        return dgVar;
    }

    public static AbstractCameraUpdateMessage a(CameraPosition cameraPosition) {
        de deVar = new de();
        deVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        if (cameraPosition == null || cameraPosition.target == null) {
            return deVar;
        }
        deVar.geoPoint = VirtualEarthProjection.latLongToPixels(cameraPosition.target.latitude, cameraPosition.target.longitude, 20);
        deVar.zoom = cameraPosition.zoom;
        deVar.bearing = cameraPosition.bearing;
        deVar.tilt = cameraPosition.tilt;
        deVar.cameraPosition = cameraPosition;
        return deVar;
    }

    public static AbstractCameraUpdateMessage a(Point point) {
        de deVar = new de();
        deVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        deVar.geoPoint = point;
        return deVar;
    }

    public static AbstractCameraUpdateMessage b(float f) {
        de deVar = new de();
        deVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        deVar.tilt = f;
        return deVar;
    }

    public static AbstractCameraUpdateMessage c(float f) {
        de deVar = new de();
        deVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        deVar.bearing = f;
        return deVar;
    }

    public static AbstractCameraUpdateMessage a(LatLng latLng, float f) {
        return a(CameraPosition.builder().target(latLng).zoom(f).bearing(Float.NaN).tilt(Float.NaN).build());
    }

    public static AbstractCameraUpdateMessage a(LatLngBounds latLngBounds, int i) {
        dd ddVar = new dd();
        ddVar.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        ddVar.bounds = latLngBounds;
        ddVar.paddingLeft = i;
        ddVar.paddingRight = i;
        ddVar.paddingTop = i;
        ddVar.paddingBottom = i;
        return ddVar;
    }
}
