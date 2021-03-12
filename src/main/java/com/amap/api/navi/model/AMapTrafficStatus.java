package com.amap.api.navi.model;

import com.autonavi.ae.route.model.LightBarItem;

public class AMapTrafficStatus {
    private int linkIndex;
    private int mLength;
    private int mStatus;

    public AMapTrafficStatus(LightBarItem lightBarItem) {
        try {
            this.mStatus = lightBarItem.status;
            this.mLength = lightBarItem.length;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public AMapTrafficStatus() {
    }

    public void setLinkIndex(int i) {
        this.linkIndex = i;
    }

    public int getLinkIndex() {
        return this.linkIndex;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public int getLength() {
        return this.mLength;
    }

    public void setLength(int i) {
        this.mLength = i;
    }
}
