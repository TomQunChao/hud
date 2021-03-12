package com.amap.api.col.stln3;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import com.a11hud.www.R;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.AmapRouteActivity;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;

/* compiled from: LocationView */
public final class ki implements kq, Inner_3dMap_locationListener {
    private AmapRouteActivity a;
    private AMap b;
    private Marker c;
    private is d;
    private Inner_3dMap_locationOption e;
    private Circle f;
    private Circle g;
    private LatLng h;
    private boolean i;
    private kr j;
    private String k = "北京市";

    public ki(AmapRouteActivity amapRouteActivity) {
        this.a = amapRouteActivity;
        if (this.d == null) {
            this.d = new is(this.a);
            this.e = new Inner_3dMap_locationOption();
            this.e.setHttpTimeOut(4000);
            this.d.a(this);
            this.e.setLocationMode(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Hight_Accuracy);
            this.e.setInterval(4000);
            this.d.a(this.e);
        }
    }

    @Override // com.amap.api.col.stln3.kq
    public final void a(AMap aMap) {
        this.b = aMap;
    }

    @Override // com.amap.api.col.stln3.kq
    public final void a(boolean z) {
        this.i = z;
    }

    @Override // com.amap.api.col.stln3.kq
    public final void a(kr krVar) {
        this.j = krVar;
    }

    @Override // com.amap.api.col.stln3.kq
    public final void a() {
        is isVar = this.d;
        if (isVar != null) {
            isVar.a();
        }
    }

    @Override // com.amap.api.col.stln3.kq
    public final void b() {
        is isVar = this.d;
        if (isVar != null) {
            isVar.b();
        }
    }

    @Override // com.amap.api.col.stln3.kq
    public final void c() {
        is isVar = this.d;
        if (isVar != null) {
            isVar.c();
            this.d = null;
        }
        Marker marker = this.c;
        if (marker != null) {
            marker.remove();
            this.c = null;
        }
        this.e = null;
        this.a = null;
    }

    @Override // com.amap.api.col.stln3.kq
    public final LatLng d() {
        return this.h;
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_locationListener
    public final void onLocationChanged(Inner_3dMap_location inner_3dMap_location) {
        if (inner_3dMap_location != null) {
            try {
                if (inner_3dMap_location.getErrorCode() == 0) {
                    this.h = new LatLng(inner_3dMap_location.getLatitude(), inner_3dMap_location.getLongitude());
                    LatLng latLng = new LatLng(inner_3dMap_location.getLatitude(), inner_3dMap_location.getLongitude());
                    float accuracy = inner_3dMap_location.getAccuracy();
                    if (this.c == null) {
                        this.c = this.b.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.itemPadding))).anchor(0.5f, 0.5f));
                        this.f = this.b.addCircle(new CircleOptions().center(latLng).fillColor(Color.argb(100, 255, 218, 185)).radius(3.0d).strokeColor(Color.argb(255, 255, 228, 185)).strokeWidth(5.0f));
                        this.g = this.b.addCircle(new CircleOptions().center(latLng).fillColor(Color.argb(70, 255, 218, 185)).radius(3.0d).strokeColor(Color.argb(255, 255, 228, 185)).strokeWidth(0.0f));
                    } else {
                        this.c.setPosition(latLng);
                        this.f.setCenter(latLng);
                        double d2 = (double) accuracy;
                        this.f.setRadius(d2);
                        this.g.setCenter(latLng);
                        this.g.setRadius(d2);
                    }
                    this.k = inner_3dMap_location.getCity();
                    if (this.a != null) {
                        this.a.getSearchResult().a(new Poi("我的位置", this.h, ""));
                    }
                    if (this.i && this.j != null) {
                        this.j.a(inner_3dMap_location.getErrorCode(), new LatLng(inner_3dMap_location.getLatitude(), inner_3dMap_location.getLongitude()));
                        this.i = false;
                        return;
                    }
                    return;
                }
                if (this.i) {
                    this.j.a(inner_3dMap_location.getErrorCode(), null);
                    this.i = false;
                }
                String str = "定位失败," + inner_3dMap_location.getErrorCode() + ": " + inner_3dMap_location.getErrorInfo();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.col.stln3.kq
    public final String e() {
        return this.k;
    }
}
