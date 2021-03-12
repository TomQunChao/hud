package com.amap.api.navi.model;

import com.autonavi.ae.route.model.RestrictionInfo;

public class AMapRestrictionInfo {
    private int descLen;
    private String restrictionDesc;
    private String restrictionTitle;
    private int titleLen;
    private int titleType;

    public AMapRestrictionInfo(RestrictionInfo restrictionInfo) {
        if (restrictionInfo != null) {
            try {
                this.restrictionTitle = restrictionInfo.title;
                this.restrictionDesc = "";
                this.titleLen = this.restrictionTitle.length();
                this.descLen = 0;
                this.titleType = restrictionInfo.titleType;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public String getRestrictionTitle() {
        return this.restrictionTitle;
    }

    public String getRestrictionDesc() {
        return this.restrictionDesc;
    }

    public int getTitleLen() {
        return this.titleLen;
    }

    public int getDescLen() {
        return this.descLen;
    }

    public int getTitleType() {
        return this.titleType;
    }
}
