package com.amap.api.maps;

import android.graphics.Point;
import com.amap.api.col.stln3.dd;
import com.amap.api.col.stln3.de;
import com.amap.api.col.stln3.df;
import com.amap.api.col.stln3.dh;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

public final class CameraUpdateFactory {
    public static CameraUpdate zoomIn() {
        return new CameraUpdate(dh.a());
    }

    public static CameraUpdate zoomOut() {
        return new CameraUpdate(dh.b());
    }

    public static CameraUpdate scrollBy(float f, float f2) {
        df dfVar = new df();
        dfVar.nowType = AbstractCameraUpdateMessage.Type.scrollBy;
        dfVar.xPixel = f;
        dfVar.yPixel = f2;
        return new CameraUpdate(dfVar);
    }

    public static CameraUpdate zoomTo(float f) {
        return new CameraUpdate(dh.a(f));
    }

    public static CameraUpdate zoomBy(float f) {
        return new CameraUpdate(dh.a(f, (Point) null));
    }

    public static CameraUpdate zoomBy(float f, Point point) {
        return new CameraUpdate(dh.a(f, point));
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        if (cameraPosition == null) {
            return new CameraUpdate(new de());
        }
        return new CameraUpdate(dh.a(cameraPosition));
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        if (latLng == null) {
            return new CameraUpdate(new de());
        }
        return new CameraUpdate(dh.a(CameraPosition.builder().target(latLng).zoom(Float.NaN).bearing(Float.NaN).tilt(Float.NaN).build()));
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f) {
        if (latLng == null) {
            return new CameraUpdate(new de());
        }
        return new CameraUpdate(dh.a(latLng, f));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i) {
        if (latLngBounds == null) {
            return new CameraUpdate(new de());
        }
        return new CameraUpdate(dh.a(latLngBounds, i));
    }

    public static CameraUpdate changeLatLng(LatLng latLng) {
        if (latLng == null) {
            return new CameraUpdate(new de());
        }
        return new CameraUpdate(dh.a(VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20)));
    }

    public static CameraUpdate changeBearing(float f) {
        return new CameraUpdate(dh.c(f % 360.0f));
    }

    public static CameraUpdate changeBearingGeoCenter(float f, IPoint iPoint) {
        if (iPoint == null) {
            return new CameraUpdate(new de());
        }
        Point point = new Point(iPoint.x, iPoint.y);
        de deVar = new de();
        deVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        deVar.geoPoint = point;
        deVar.bearing = f % 360.0f;
        return new CameraUpdate(deVar);
    }

    public static CameraUpdate changeTilt(float f) {
        return new CameraUpdate(dh.b(f));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2, int i3) {
        if (latLngBounds == null) {
            return new CameraUpdate(new de());
        }
        dd ddVar = new dd();
        ddVar.nowType = AbstractCameraUpdateMessage.Type.newLatLngBoundsWithSize;
        ddVar.bounds = latLngBounds;
        ddVar.paddingLeft = i3;
        ddVar.paddingRight = i3;
        ddVar.paddingTop = i3;
        ddVar.paddingBottom = i3;
        ddVar.width = i;
        ddVar.height = i2;
        return new CameraUpdate(ddVar);
    }

    public static CameraUpdate newLatLngBoundsRect(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        if (latLngBounds == null) {
            return new CameraUpdate(new de());
        }
        dd ddVar = new dd();
        ddVar.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        ddVar.bounds = latLngBounds;
        ddVar.paddingLeft = i;
        ddVar.paddingRight = i2;
        ddVar.paddingTop = i3;
        ddVar.paddingBottom = i4;
        return new CameraUpdate(ddVar);
    }
}
