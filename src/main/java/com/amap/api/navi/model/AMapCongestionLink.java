package com.amap.api.navi.model;

import com.autonavi.ae.guide.model.LinkLineStatus;
import com.autonavi.ae.route.model.GeoPoint;
import java.util.ArrayList;

public class AMapCongestionLink {
    private int mCongestionStatus;
    private ArrayList<NaviLatLng> mCoords;

    public AMapCongestionLink(LinkLineStatus linkLineStatus) {
        try {
            this.mCoords = new ArrayList<>();
            GeoPoint[] geoPointArr = linkLineStatus.points;
            for (int i = 0; i < geoPointArr.length; i++) {
                this.mCoords.add(new NaviLatLng(geoPointArr[i].getLatitude(), geoPointArr[i].getLongitude()));
            }
            this.mCongestionStatus = linkLineStatus.status;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<NaviLatLng> getCoords() {
        return this.mCoords;
    }

    public int getCongestionStatus() {
        return this.mCongestionStatus;
    }

    public void setCongestionStatus(int i) {
        this.mCongestionStatus = i;
    }
}
