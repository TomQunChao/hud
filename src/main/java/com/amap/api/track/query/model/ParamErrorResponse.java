package com.amap.api.track.query.model;

public class ParamErrorResponse extends BaseResponse {
    public ParamErrorResponse(String str) {
        super(3001, str, str);
    }
}
