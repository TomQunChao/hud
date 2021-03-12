package com.autonavi.ae.route.model;

public class GeoPoint {
    public static final double EARTH_CIRCUMFERENCE_IN_METERS = 4.007501668557849E7d;
    public static final int EARTH_RADIUS_IN_METERS = 6378137;
    public static final int MAXZOOMLEVEL = 20;
    public static final double MAX_LATITUDE = 85.0511287798d;
    public static final double MAX_LONGITUDE = 180.0d;
    public static final double MIN_LATITUDE = -85.0511287798d;
    public static final double MIN_LONGITUDE = -180.0d;
    public static final int PIXELS_PER_TILE = 256;
    public static final int TILE_SPLIT_LEVEL = 0;
    public int x;
    public int y;

    public GeoPoint() {
    }

    public GeoPoint(int i, int i2) {
        this.x = i;
        this.y = i2;
    }

    public GeoPoint(double d, double d2) {
        latLongToPixels(d, d2, 20);
    }

    public void setLonLat(double d, double d2) {
        latLongToPixels(d, d2, 20);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public double getLatitude() {
        int i = this.x;
        return (1.570796326794897d - (Math.atan(Math.exp((-(2.0037508342789244E7d - (((double) this.y) * 0.1492910708694849d))) / 6378137.0d)) * 2.0d)) * 57.29577951308232d;
    }

    public double getLongitude() {
        int i = this.y;
        return (((((double) this.x) * 0.1492910708694849d) - 2.0037508342789244E7d) / 6378137.0d) * 57.29577951308232d;
    }

    private void latLongToPixels(double d, double d2, int i) {
        double sin = Math.sin((clip(d2, -85.0511287798d, 85.0511287798d) * 3.141592653589793d) / 180.0d);
        double log = Math.log((sin + 1.0d) / (1.0d - sin)) * 3189068.0d;
        long j = 256 << i;
        double d3 = 4.007501668557849E7d / ((double) j);
        double d4 = (double) (j - 1);
        this.x = (int) clip((((((clip(d, -180.0d, 180.0d) * 3.141592653589793d) / 180.0d) * 6378137.0d) + 2.0037508342789244E7d) / d3) + 0.5d, 0.0d, d4);
        this.y = (int) clip(((2.0037508342789244E7d - log) / d3) + 0.5d, 0.0d, d4);
    }

    private double clip(double d, double d2, double d3) {
        return Math.min(Math.max(d, d2), d3);
    }
}
