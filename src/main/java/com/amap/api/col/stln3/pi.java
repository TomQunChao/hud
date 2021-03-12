package com.amap.api.col.stln3;

import android.support.v4.app.NotificationCompat;
import com.alibaba.idst.nls.internal.connector.NetDefine;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.amap.api.services.core.AMapException;
import com.amap.api.track.ErrorCode;
import com.autonavi.amap.mapcore.tools.GLMapStaticValue;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CoreUtil */
public final class pi {
    private static String[] a = {"com.amap.api.trace", "com.amap.api.trace.core"};

    public static void a(String str) throws pf {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                a(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"));
            } else if (!jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
            } else {
                if (jSONObject.has("infocode")) {
                    String string = jSONObject.getString(NotificationCompat.CATEGORY_STATUS);
                    int i = jSONObject.getInt("infocode");
                    if (!"1".equals(string)) {
                        String string2 = jSONObject.getString("info");
                        if ("0".equals(string)) {
                            a(i, string2);
                        }
                    }
                }
            }
        } catch (JSONException e) {
            throw new pf("协议解析错误 - ProtocolException");
        }
    }

    private static void a(int i, String str) throws pf {
        if (i != 0) {
            switch (i) {
                case ErrorCode.Response.SUCCESS /*{ENCODED_INT: 10000}*/:
                    return;
                case GLMapStaticValue.AM_CALLBACK_CHANGEMAPLOGO /*{ENCODED_INT: 10001}*/:
                    throw new pf(AMapException.AMAP_INVALID_USER_KEY);
                case GLMapStaticValue.AM_CALLBACK_NEED_NEXTFRAME /*{ENCODED_INT: 10002}*/:
                    throw new pf(AMapException.AMAP_SERVICE_NOT_AVAILBALE);
                case GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR /*{ENCODED_INT: 10003}*/:
                    throw new pf(AMapException.AMAP_DAILY_QUERY_OVER_LIMIT);
                case 10004:
                    throw new pf(AMapException.AMAP_ACCESS_TOO_FREQUENT);
                case 10005:
                    throw new pf(AMapException.AMAP_INVALID_USER_IP);
                case 10006:
                    throw new pf(AMapException.AMAP_INVALID_USER_DOMAIN);
                case 10007:
                    throw new pf("用户签名未通过");
                case 10008:
                    throw new pf(AMapException.AMAP_INVALID_USER_SCODE);
                case 10009:
                    throw new pf(AMapException.AMAP_USERKEY_PLAT_NOMATCH);
                case 10010:
                    throw new pf(AMapException.AMAP_IP_QUERY_OVER_LIMIT);
                case 10011:
                    throw new pf(AMapException.AMAP_NOT_SUPPORT_HTTPS);
                case 10012:
                    throw new pf(AMapException.AMAP_INSUFFICIENT_PRIVILEGES);
                case 10013:
                    throw new pf(AMapException.AMAP_USER_KEY_RECYCLED);
                default:
                    switch (i) {
                        case NetDefine.HTTP_READ_TIMEOUT:
                            throw new pf(AMapException.AMAP_SERVICE_INVALID_PARAMS);
                        case 20001:
                            throw new pf(AMapException.AMAP_SERVICE_MISSING_REQUIRED_PARAMS);
                        case 20002:
                            throw new pf(AMapException.AMAP_SERVICE_ILLEGAL_REQUEST);
                        case 20003:
                            throw new pf(AMapException.AMAP_SERVICE_UNKNOWN_ERROR);
                        default:
                            switch (i) {
                                case 30000:
                                    throw new pf(AMapException.AMAP_ENGINE_RESPONSE_ERROR);
                                case 30001:
                                    throw new pf(AMapException.AMAP_ENGINE_RESPONSE_DATA_ERROR);
                                case 30002:
                                    throw new pf(AMapException.AMAP_ENGINE_CONNECT_TIMEOUT);
                                case 30003:
                                    throw new pf(AMapException.AMAP_ENGINE_RETURN_TIMEOUT);
                                default:
                                    throw new pf(str);
                            }
                    }
            }
        }
    }

    public static int a(List<LatLng> list) {
        int i = 0;
        if (list == null || list.size() == 0) {
            return 0;
        }
        int i2 = 0;
        while (i < list.size() - 1) {
            LatLng latLng = list.get(i);
            i++;
            LatLng latLng2 = list.get(i);
            if (latLng == null || latLng2 == null) {
                return i2;
            }
            i2 = (int) (((float) i2) + AMapUtils.calculateLineDistance(latLng, latLng2));
        }
        return i2;
    }
}
