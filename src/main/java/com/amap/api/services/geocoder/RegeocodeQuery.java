package com.amap.api.services.geocoder;

import com.amap.api.services.core.LatLonPoint;

public class RegeocodeQuery {
    private LatLonPoint a;
    private float b = 1000.0f;
    private String c = GeocodeSearch.AMAP;
    private String d = "";

    public RegeocodeQuery(LatLonPoint latLonPoint, float f, String str) {
        this.a = latLonPoint;
        this.b = f;
        setLatLonType(str);
    }

    public LatLonPoint getPoint() {
        return this.a;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.a = latLonPoint;
    }

    public float getRadius() {
        return this.b;
    }

    public void setRadius(float f) {
        this.b = f;
    }

    public String getLatLonType() {
        return this.c;
    }

    public void setLatLonType(String str) {
        if (str == null) {
            return;
        }
        if (str.equals(GeocodeSearch.AMAP) || str.equals(GeocodeSearch.GPS)) {
            this.c = str;
        }
    }

    public String getPoiType() {
        return this.d;
    }

    public void setPoiType(String str) {
        this.d = str;
    }

    public int hashCode() {
        int i;
        String str = this.c;
        int i2 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int i3 = (i + 31) * 31;
        LatLonPoint latLonPoint = this.a;
        if (latLonPoint != null) {
            i2 = latLonPoint.hashCode();
        }
        return ((i3 + i2) * 31) + Float.floatToIntBits(this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RegeocodeQuery regeocodeQuery = (RegeocodeQuery) obj;
        String str = this.c;
        if (str == null) {
            if (regeocodeQuery.c != null) {
                return false;
            }
        } else if (!str.equals(regeocodeQuery.c)) {
            return false;
        }
        LatLonPoint latLonPoint = this.a;
        if (latLonPoint == null) {
            if (regeocodeQuery.a != null) {
                return false;
            }
        } else if (!latLonPoint.equals(regeocodeQuery.a)) {
            return false;
        }
        if (Float.floatToIntBits(this.b) != Float.floatToIntBits(regeocodeQuery.b)) {
            return false;
        }
        return true;
    }
}
