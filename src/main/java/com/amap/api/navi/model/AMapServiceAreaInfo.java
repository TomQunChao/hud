package com.amap.api.navi.model;

import com.autonavi.ae.guide.model.NaviFacility;

public class AMapServiceAreaInfo {
    private String name;
    private int remainDist;
    private int type;

    public AMapServiceAreaInfo(NaviFacility naviFacility) {
        try {
            this.remainDist = naviFacility.remainDist;
            this.type = naviFacility.type;
            this.name = naviFacility.name;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getRemainDist() {
        return this.remainDist;
    }

    public int getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }
}
