package com.amap.api.navi.model;

import com.autonavi.ae.guide.model.CruiseTimeAndDistInfo;

public class AimLessModeStat {
    private int aimlessModeDistance;
    private int aimlessModeTime;

    public AimLessModeStat(CruiseTimeAndDistInfo cruiseTimeAndDistInfo) {
        this.aimlessModeDistance = cruiseTimeAndDistInfo.driveDist;
        this.aimlessModeTime = cruiseTimeAndDistInfo.driveTime;
    }

    public int getAimlessModeDistance() {
        return this.aimlessModeDistance;
    }

    public void setAimlessModeDistance(int i) {
        this.aimlessModeDistance = i;
    }

    public int getAimlessModeTime() {
        return this.aimlessModeTime;
    }

    public void setAimlessModeTime(int i) {
        this.aimlessModeTime = i;
    }
}
