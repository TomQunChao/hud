package com.amap.api.col.stln3;

import com.amap.api.services.core.AMapException;

/* compiled from: AMapException */
public final class pf extends Exception {
    private String a = "";
    private int b = 1000;

    public pf(String str) {
        super(str);
        int i;
        this.a = str;
        if ("用户签名未通过".equals(str)) {
            i = 1001;
        } else if (AMapException.AMAP_INVALID_USER_KEY.equals(str)) {
            i = 1002;
        } else if (AMapException.AMAP_SERVICE_NOT_AVAILBALE.equals(str)) {
            i = 1003;
        } else if (AMapException.AMAP_DAILY_QUERY_OVER_LIMIT.equals(str)) {
            i = 1004;
        } else if (AMapException.AMAP_ACCESS_TOO_FREQUENT.equals(str)) {
            i = AMapException.CODE_AMAP_ACCESS_TOO_FREQUENT;
        } else if (AMapException.AMAP_INVALID_USER_IP.equals(str)) {
            i = 1006;
        } else if (AMapException.AMAP_INVALID_USER_DOMAIN.equals(str)) {
            i = 1007;
        } else if (AMapException.AMAP_INVALID_USER_SCODE.equals(str)) {
            i = 1008;
        } else if (AMapException.AMAP_USERKEY_PLAT_NOMATCH.equals(str)) {
            i = 1009;
        } else if (AMapException.AMAP_IP_QUERY_OVER_LIMIT.equals(str)) {
            i = 1010;
        } else if (AMapException.AMAP_NOT_SUPPORT_HTTPS.equals(str)) {
            i = 1011;
        } else if (AMapException.AMAP_INSUFFICIENT_PRIVILEGES.equals(str)) {
            i = 1012;
        } else if (AMapException.AMAP_USER_KEY_RECYCLED.equals(str)) {
            i = 1013;
        } else if (AMapException.AMAP_ENGINE_RESPONSE_ERROR.equals(str)) {
            i = 1100;
        } else if (AMapException.AMAP_ENGINE_RESPONSE_DATA_ERROR.equals(str)) {
            i = AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR;
        } else if (AMapException.AMAP_ENGINE_CONNECT_TIMEOUT.equals(str)) {
            i = AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT;
        } else if (AMapException.AMAP_ENGINE_RETURN_TIMEOUT.equals(str)) {
            i = AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT;
        } else if (AMapException.AMAP_SERVICE_INVALID_PARAMS.equals(str)) {
            i = AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS;
        } else if (AMapException.AMAP_SERVICE_MISSING_REQUIRED_PARAMS.equals(str)) {
            i = AMapException.CODE_AMAP_SERVICE_MISSING_REQUIRED_PARAMS;
        } else if (AMapException.AMAP_SERVICE_ILLEGAL_REQUEST.equals(str)) {
            i = AMapException.CODE_AMAP_SERVICE_ILLEGAL_REQUEST;
        } else if (AMapException.AMAP_SERVICE_UNKNOWN_ERROR.equals(str)) {
            i = AMapException.CODE_AMAP_SERVICE_UNKNOWN_ERROR;
        } else if ("协议解析错误 - ProtocolException".equals(str)) {
            i = AMapException.CODE_AMAP_CLIENT_ERROR_PROTOCOL;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            i = AMapException.CODE_AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION;
        } else if ("url异常 - MalformedURLException".equals(str)) {
            i = AMapException.CODE_AMAP_CLIENT_URL_EXCEPTION;
        } else if ("未知主机 - UnKnowHostException".equals(str)) {
            i = AMapException.CODE_AMAP_CLIENT_UNKNOWHOST_EXCEPTION;
        } else if (AMapException.AMAP_CLIENT_UNKNOWN_ERROR.equals(str)) {
            i = 1900;
        } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
            i = AMapException.CODE_AMAP_CLIENT_INVALID_PARAMETER;
        } else if (AMapException.AMAP_CLIENT_NETWORK_EXCEPTION.equals(str)) {
            i = AMapException.CODE_AMAP_CLIENT_NETWORK_EXCEPTION;
        } else if ("IO 操作异常 - IOException".equals(str)) {
            i = AMapException.CODE_AMAP_CLIENT_IO_EXCEPTION;
        } else if ("空指针异常 - NullPointException".equals(str)) {
            i = AMapException.CODE_AMAP_CLIENT_NULLPOINT_EXCEPTION;
        } else {
            this.b = AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING;
            return;
        }
        this.b = i;
    }

    public pf() {
    }

    public final String a() {
        return this.a;
    }
}
