package com.amap.api.track.query.model;

import com.amap.api.track.query.entity.LatestPoint;

public final class LatestPointResponse extends BaseResponse {
    private String e;
    private LatestPoint f = LatestPoint.createFromData(getData());

    public LatestPointResponse(BaseResponse baseResponse) {
        super(baseResponse);
    }

    public final String getTermainl() {
        return this.e;
    }

    public final void setTermainl(String str) {
        this.e = str;
    }

    public final LatestPoint getLatestPoint() {
        return this.f;
    }

    public final void setLatestPoint(LatestPoint latestPoint) {
        this.f = latestPoint;
    }
}
