package com.amap.api.track.query.model;

import com.amap.api.col.stln3.qd;
import com.amap.api.col.stln3.qs;

public class AddTrackResponse extends BaseResponse {
    private long e;
    private String f;

    public AddTrackResponse(BaseResponse baseResponse) {
        super(baseResponse);
        qd a = new qd().a(getData());
        this.e = qs.a(a.c("trid"));
        this.f = a.c("trname");
    }

    public long getTrid() {
        return this.e;
    }
}
