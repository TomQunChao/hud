package com.amap.api.track.query.entity;

import com.amap.api.col.stln3.qd;
import com.amap.api.col.stln3.qs;

public final class TrackPoint {
    private Point a;
    private long b;
    private long c;

    public static TrackPoint createFrom(String str) {
        qd a2 = new qd().a(str);
        String c2 = a2.c("location");
        String c3 = a2.c("time");
        String c4 = a2.c("createtime");
        TrackPoint trackPoint = new TrackPoint();
        trackPoint.a = Point.createLoc(c2);
        trackPoint.b = qs.a(c3);
        trackPoint.c = qs.a(c4);
        return trackPoint;
    }

    public final Point getLocation() {
        return this.a;
    }

    public final void setLocation(Point point) {
        this.a = point;
    }

    public final long getTime() {
        return this.b;
    }

    public final void setTime(long j) {
        this.b = j;
    }

    public final long getCreatetime() {
        return this.c;
    }

    public final void setCreatetime(long j) {
        this.c = j;
    }
}
