package com.amap.api.track.query.model;

import android.text.TextUtils;
import com.amap.api.col.stln3.qr;
import com.amap.api.track.ErrorCode;
import org.json.JSONObject;

public class BaseResponse {
    protected int a;
    protected String b;
    protected String c;
    protected String d;

    public BaseResponse(BaseResponse baseResponse) {
        if (baseResponse != null) {
            this.a = baseResponse.getErrorCode();
            this.b = baseResponse.getErrorMsg();
            this.d = baseResponse.getData();
        }
    }

    public BaseResponse(int i, String str, String str2) {
        this.a = i;
        this.b = str;
        this.c = str;
        this.d = str2;
    }

    public BaseResponse(int i, String str, String str2, String str3) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public int getErrorCode() {
        return this.a;
    }

    public void setErrorCode(int i) {
        this.a = i;
    }

    public String getErrorMsg() {
        return this.b;
    }

    public void setErrorMsg(String str) {
        this.b = str;
    }

    public String getErrorDetail() {
        return this.c;
    }

    public void setErrorDetail(String str) {
        this.c = str;
    }

    public String getData() {
        return this.d;
    }

    public void setData(String str) {
        this.d = str;
    }

    public boolean isSuccess() {
        return 10000 == getErrorCode();
    }

    public static BaseResponse createFrom(String str) {
        if (TextUtils.isEmpty(str)) {
            return new BaseResponse(3003, ErrorCode.Response.NET_RES_FAIL_MSG, ErrorCode.Response.NET_RES_FAIL_MSG, "");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new BaseResponse(jSONObject.optInt("errcode", 3003), jSONObject.optString("errmsg", ErrorCode.Response.NET_RES_FAIL_MSG), jSONObject.optString("errdetail", ErrorCode.Response.NET_RES_FAIL_MSG), jSONObject.optString("data", ""));
        } catch (Throwable th) {
            qr.a("BaseResponse.createFrom " + th);
            return new BaseResponse(3003, ErrorCode.Response.NET_RES_FAIL_MSG, ErrorCode.Response.NET_RES_FAIL_MSG, "");
        }
    }
}
