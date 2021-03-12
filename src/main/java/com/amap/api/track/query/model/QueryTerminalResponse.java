package com.amap.api.track.query.model;

import com.amap.api.col.stln3.qd;

public class QueryTerminalResponse extends BaseResponse {
    private long e = -1;

    public QueryTerminalResponse(BaseResponse baseResponse) {
        super(baseResponse);
        try {
            this.e = new qd().a(getData()).b("results").getJSONObject(0).optLong("tid");
        } catch (Throwable th) {
            this.e = -1;
        }
    }

    public long getTid() {
        return this.e;
    }

    public boolean isTerminalExist() {
        return 10000 == getErrorCode() && this.e > 0;
    }
}
