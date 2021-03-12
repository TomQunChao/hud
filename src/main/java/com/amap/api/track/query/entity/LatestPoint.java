package com.amap.api.track.query.entity;

public final class LatestPoint {
    private Point a;

    public static LatestPoint createFromData(String str) {
        LatestPoint latestPoint = new LatestPoint();
        latestPoint.a = Point.createLoc(str);
        return latestPoint;
    }

    public final Point getPoint() {
        return this.a;
    }

    public final void setPoint(Point point) {
        this.a = point;
    }
}
