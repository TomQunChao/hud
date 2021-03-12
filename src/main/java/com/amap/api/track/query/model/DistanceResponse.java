package com.amap.api.track.query.model;

import com.amap.api.col.stln3.qd;
import com.amap.api.col.stln3.qs;

public final class DistanceResponse extends BaseResponse {
    private double e = qs.b(new qd().a(getData()).c("distance"));

    public DistanceResponse(BaseResponse baseResponse) {
        super(baseResponse);
    }

    public final double getDistance() {
        return this.e;
    }

    public final void setDistance(double d) {
        this.e = d;
    }
}
