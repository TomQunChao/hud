package com.amap.api.col.stln3;

import com.amap.api.track.ErrorCode;
import com.amap.api.track.query.model.BaseResponse;

/* compiled from: BadResponseCreator */
public final class qu {
    public static BaseResponse a() {
        return new BaseResponse(3002, ErrorCode.Response.BAD_NETWORK_MSG, ErrorCode.Response.BAD_NETWORK_MSG);
    }

    public static BaseResponse b() {
        return new BaseResponse(ErrorCode.Response.REQ_NOT_VALID, ErrorCode.Response.REQ_NOT_VALID_MSG, ErrorCode.Response.REQ_NOT_VALID_MSG);
    }
}
