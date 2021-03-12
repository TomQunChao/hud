package com.amap.api.track.query.model;

import com.amap.api.col.stln3.qd;
import com.amap.api.col.stln3.qs;

public class AddTerminalResponse extends BaseResponse {
    private long e = qs.a(new qd().a(getData()).c("tid"));

    public AddTerminalResponse(BaseResponse baseResponse) {
        super(baseResponse);
    }

    public long getTid() {
        return this.e;
    }

    public boolean isServiceNonExist() {
        return 20050 == getErrorCode();
    }
}
