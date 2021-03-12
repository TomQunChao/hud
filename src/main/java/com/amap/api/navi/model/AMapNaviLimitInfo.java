package com.amap.api.navi.model;

import com.autonavi.ae.route.model.ForbiddenWideHighWeightInfo;

public class AMapNaviLimitInfo {
    public String currentRoadName;
    public double latitude;
    public double longitude;
    public long pathId;
    public byte type;

    public AMapNaviLimitInfo() {
    }

    public AMapNaviLimitInfo(ForbiddenWideHighWeightInfo forbiddenWideHighWeightInfo) {
        this.pathId = forbiddenWideHighWeightInfo.pathId;
        this.type = forbiddenWideHighWeightInfo.type;
        this.latitude = forbiddenWideHighWeightInfo.latitude;
        this.longitude = forbiddenWideHighWeightInfo.longitude;
        this.currentRoadName = forbiddenWideHighWeightInfo.currentRoadName;
    }
}
