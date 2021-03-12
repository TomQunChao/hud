package com.amap.api.track.query.entity;

import com.amap.api.col.stln3.qd;
import com.amap.api.col.stln3.qs;
import java.util.ArrayList;

public final class HistoryTrack {
    private int a;
    private double b;
    private TrackPoint c;
    private TrackPoint d;
    private ArrayList<Point> e = new ArrayList<>();

    public static HistoryTrack createFromData(String str) {
        qd a2 = new qd().a(str);
        int c2 = qs.c(a2.c("count"));
        double b2 = qs.b(a2.c("distance"));
        TrackPoint createFrom = TrackPoint.createFrom(a2.c("startpoint"));
        TrackPoint createFrom2 = TrackPoint.createFrom(a2.c("endpoint"));
        ArrayList<Point> createLocs = Point.createLocs(a2.g("points"));
        HistoryTrack historyTrack = new HistoryTrack();
        historyTrack.a = c2;
        historyTrack.b = b2;
        historyTrack.c = createFrom;
        historyTrack.d = createFrom2;
        historyTrack.e = createLocs;
        return historyTrack;
    }

    public final int getCount() {
        return this.a;
    }

    public final void setCount(int i) {
        this.a = i;
    }

    public final double getDistance() {
        return this.b;
    }

    public final void setDistance(double d2) {
        this.b = d2;
    }

    public final TrackPoint getStartPoint() {
        return this.c;
    }

    public final void setStartPoint(TrackPoint trackPoint) {
        this.c = trackPoint;
    }

    public final TrackPoint getEndPoint() {
        return this.d;
    }

    public final void setEndPoint(TrackPoint trackPoint) {
        this.d = trackPoint;
    }

    public final ArrayList<Point> getPoints() {
        return this.e;
    }

    public final void setPoints(ArrayList<Point> arrayList) {
        this.e = arrayList;
    }
}
