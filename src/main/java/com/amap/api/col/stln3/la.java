package com.amap.api.col.stln3;

import com.alibaba.idst.nls.internal.connector.NetDefine;
import com.amap.api.services.core.AMapException;
import com.amap.api.track.ErrorCode;
import com.autonavi.amap.mapcore.tools.GLMapStaticValue;

/* compiled from: CoreUtil */
public final class la {
    public static void a(int i) throws kv {
        if (i != 22000) {
            switch (i) {
                case ErrorCode.Response.SUCCESS /*{ENCODED_INT: 10000}*/:
                    return;
                case GLMapStaticValue.AM_CALLBACK_CHANGEMAPLOGO /*{ENCODED_INT: 10001}*/:
                    throw new kv(AMapException.AMAP_INVALID_USER_KEY);
                case GLMapStaticValue.AM_CALLBACK_NEED_NEXTFRAME /*{ENCODED_INT: 10002}*/:
                    throw new kv(AMapException.AMAP_SERVICE_NOT_AVAILBALE);
                case GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR /*{ENCODED_INT: 10003}*/:
                    throw new kv(AMapException.AMAP_DAILY_QUERY_OVER_LIMIT);
                case 10004:
                    throw new kv(AMapException.AMAP_ACCESS_TOO_FREQUENT);
                case 10005:
                    throw new kv(AMapException.AMAP_INVALID_USER_IP);
                case 10006:
                    throw new kv(AMapException.AMAP_INVALID_USER_DOMAIN);
                case 10007:
                    throw new kv("用户签名未通过");
                case 10008:
                    throw new kv(AMapException.AMAP_INVALID_USER_SCODE);
                case 10009:
                    throw new kv(AMapException.AMAP_USERKEY_PLAT_NOMATCH);
                case 10010:
                    throw new kv(AMapException.AMAP_IP_QUERY_OVER_LIMIT);
                case 10011:
                    throw new kv(AMapException.AMAP_NOT_SUPPORT_HTTPS);
                case 10012:
                    throw new kv(AMapException.AMAP_INSUFFICIENT_PRIVILEGES);
                case 10013:
                    throw new kv(AMapException.AMAP_USER_KEY_RECYCLED);
                default:
                    switch (i) {
                        case NetDefine.HTTP_READ_TIMEOUT:
                            throw new kv(AMapException.AMAP_SERVICE_INVALID_PARAMS);
                        case 20001:
                            throw new kv(AMapException.AMAP_SERVICE_MISSING_REQUIRED_PARAMS);
                        case 20002:
                            throw new kv(AMapException.AMAP_SERVICE_ILLEGAL_REQUEST);
                        case 20003:
                            throw new kv(AMapException.AMAP_SERVICE_UNKNOWN_ERROR);
                        default:
                            switch (i) {
                                case 20800:
                                    throw new kv(AMapException.AMAP_ROUTE_OUT_OF_SERVICE);
                                case 20801:
                                    throw new kv(AMapException.AMAP_ROUTE_NO_ROADS_NEARBY);
                                case 20802:
                                    throw new kv(AMapException.AMAP_ROUTE_FAIL);
                                case 20803:
                                    throw new kv(AMapException.AMAP_OVER_DIRECTION_RANGE);
                                default:
                                    switch (i) {
                                        case 30000:
                                            throw new kv(AMapException.AMAP_ENGINE_RESPONSE_ERROR);
                                        case 30001:
                                            throw new kv(AMapException.AMAP_ENGINE_RESPONSE_DATA_ERROR);
                                        case 30002:
                                            throw new kv(AMapException.AMAP_ENGINE_CONNECT_TIMEOUT);
                                        case 30003:
                                            throw new kv(AMapException.AMAP_ENGINE_RETURN_TIMEOUT);
                                        default:
                                            switch (i) {
                                                case 32000:
                                                    throw new kv(AMapException.AMAP_ENGINE_TABLEID_NOT_EXIST);
                                                case 32001:
                                                    throw new kv(AMapException.AMAP_ID_NOT_EXIST);
                                                case 32002:
                                                    throw new kv(AMapException.AMAP_SERVICE_MAINTENANCE);
                                                default:
                                                    switch (i) {
                                                        case 32200:
                                                            throw new kv(AMapException.AMAP_NEARBY_INVALID_USERID);
                                                        case 32201:
                                                            throw new kv(AMapException.AMAP_NEARBY_KEY_NOT_BIND);
                                                        default:
                                                            throw new kv(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
                                                    }
                                            }
                                    }
                            }
                    }
            }
        } else {
            throw new kv(AMapException.AMAP_SERVICE_TABLEID_NOT_EXIST);
        }
    }

    public static void a(Throwable th, String str, String str2) {
        try {
            rx e = rx.e();
            if (e != null) {
                e.b(th, str, str2);
            }
            th.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
