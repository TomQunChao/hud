package com.amap.api.navi.model;

import com.autonavi.ae.guide.model.LaneInfo;

public class AMapLaneInfo {
    public int[] backgroundLane;
    public int[] frontLane;
    public int laneCount;
    int laneTypeId = 0;
    public double pointLatitude;
    public double pointLongitude;

    public AMapLaneInfo() {
    }

    public AMapLaneInfo(LaneInfo laneInfo) {
        this.backgroundLane = laneInfo.backLane;
        this.frontLane = laneInfo.frontLane;
        this.laneCount = laneInfo.laneCount;
        this.pointLatitude = laneInfo.pointLat;
        this.pointLongitude = laneInfo.pointLon;
    }

    public boolean isRecommended() {
        try {
            if (!getLaneTypeIdHexString().endsWith("F")) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public int getLaneTypeId() {
        return this.laneTypeId;
    }

    public void setLaneTypeId(int i) {
        this.laneTypeId = i;
    }

    public String getLaneTypeIdHexString() {
        try {
            return String.format("%1$02X", Integer.valueOf(this.laneTypeId));
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public char[] getLaneTypeIdArray() {
        try {
            return String.format("%1$02X", Integer.valueOf(this.laneTypeId)).toCharArray();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
