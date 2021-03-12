package com.amap.api.col.stln3;

import android.support.v4.app.NotificationCompat;
import com.alibaba.idst.nls.internal.connector.NetDefine;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.track.ErrorCode;
import com.autonavi.amap.mapcore.tools.GLMapStaticValue;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CoreUtil */
public final class nl {
    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static void b(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                a(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"));
            } else if (jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
                String string = jSONObject.getString(NotificationCompat.CATEGORY_STATUS);
                if (!string.equals("1")) {
                    if (string.equals("0")) {
                        if (!jSONObject.has("infocode")) {
                            throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
                        }
                    }
                    int i = jSONObject.getInt("infocode");
                    if (string.equals("0")) {
                        a(i, jSONObject.getString("info"));
                    }
                }
            }
        } catch (JSONException e) {
            a(e, "CoreUtil", "paseAuthFailurJson");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void a(int i, String str) throws AMapException, JSONException {
        if (i == 0) {
            return;
        }
        if (i != 22000) {
            switch (i) {
                case ErrorCode.Response.SUCCESS /*{ENCODED_INT: 10000}*/:
                    return;
                case GLMapStaticValue.AM_CALLBACK_CHANGEMAPLOGO /*{ENCODED_INT: 10001}*/:
                    throw new AMapException(AMapException.AMAP_INVALID_USER_KEY, 2, str);
                case GLMapStaticValue.AM_CALLBACK_NEED_NEXTFRAME /*{ENCODED_INT: 10002}*/:
                    throw new AMapException(AMapException.AMAP_SERVICE_NOT_AVAILBALE, 2, str);
                case GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR /*{ENCODED_INT: 10003}*/:
                    throw new AMapException(AMapException.AMAP_DAILY_QUERY_OVER_LIMIT, 2, str);
                case 10004:
                    throw new AMapException(AMapException.AMAP_ACCESS_TOO_FREQUENT, 2, str);
                case 10005:
                    throw new AMapException(AMapException.AMAP_INVALID_USER_IP, 2, str);
                case 10006:
                    throw new AMapException(AMapException.AMAP_INVALID_USER_DOMAIN, 2, str);
                case 10007:
                    throw new AMapException("用户签名未通过", 2, str);
                case 10008:
                    throw new AMapException(AMapException.AMAP_INVALID_USER_SCODE, 2, str);
                case 10009:
                    throw new AMapException(AMapException.AMAP_USERKEY_PLAT_NOMATCH, 2, str);
                case 10010:
                    throw new AMapException(AMapException.AMAP_IP_QUERY_OVER_LIMIT, 2, str);
                case 10011:
                    throw new AMapException(AMapException.AMAP_NOT_SUPPORT_HTTPS, 2, str);
                case 10012:
                    throw new AMapException(AMapException.AMAP_INSUFFICIENT_PRIVILEGES, 2, str);
                case 10013:
                    throw new AMapException(AMapException.AMAP_USER_KEY_RECYCLED, 2, str);
                default:
                    switch (i) {
                        case NetDefine.HTTP_READ_TIMEOUT:
                            throw new AMapException(AMapException.AMAP_SERVICE_INVALID_PARAMS, 2, str);
                        case 20001:
                            throw new AMapException(AMapException.AMAP_SERVICE_MISSING_REQUIRED_PARAMS, 2, str);
                        case 20002:
                            throw new AMapException(AMapException.AMAP_SERVICE_ILLEGAL_REQUEST, 2, str);
                        case 20003:
                            throw new AMapException(AMapException.AMAP_SERVICE_UNKNOWN_ERROR, 2, str);
                        default:
                            switch (i) {
                                case 20800:
                                    throw new AMapException(AMapException.AMAP_ROUTE_OUT_OF_SERVICE, 2, str);
                                case 20801:
                                    throw new AMapException(AMapException.AMAP_ROUTE_NO_ROADS_NEARBY, 2, str);
                                case 20802:
                                    throw new AMapException(AMapException.AMAP_ROUTE_FAIL, 2, str);
                                case 20803:
                                    throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE, 2, str);
                                default:
                                    switch (i) {
                                        case 30000:
                                            throw new AMapException(AMapException.AMAP_ENGINE_RESPONSE_ERROR, 2, str);
                                        case 30001:
                                            throw new AMapException(AMapException.AMAP_ENGINE_RESPONSE_DATA_ERROR, 2, str);
                                        case 30002:
                                            throw new AMapException(AMapException.AMAP_ENGINE_CONNECT_TIMEOUT, 2, str);
                                        case 30003:
                                            throw new AMapException(AMapException.AMAP_ENGINE_RETURN_TIMEOUT, 2, str);
                                        default:
                                            switch (i) {
                                                case 32000:
                                                    throw new AMapException(AMapException.AMAP_ENGINE_TABLEID_NOT_EXIST, 2, str);
                                                case 32001:
                                                    throw new AMapException(AMapException.AMAP_ID_NOT_EXIST, 2, str);
                                                case 32002:
                                                    throw new AMapException(AMapException.AMAP_SERVICE_MAINTENANCE, 2, str);
                                                default:
                                                    switch (i) {
                                                        case 32200:
                                                            throw new AMapException(AMapException.AMAP_NEARBY_INVALID_USERID, 2, str);
                                                        case 32201:
                                                            throw new AMapException(AMapException.AMAP_NEARBY_KEY_NOT_BIND, 2, str);
                                                        default:
                                                            throw new AMapException(str, 2, str);
                                                    }
                                            }
                                    }
                            }
                    }
            }
        } else {
            throw new AMapException(AMapException.AMAP_SERVICE_TABLEID_NOT_EXIST, 2, str);
        }
    }

    public static double a(double d) {
        return Double.parseDouble(new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US)).format(d));
    }

    public static String a(LatLonPoint latLonPoint) {
        if (latLonPoint == null) {
            return "";
        }
        double a = a(latLonPoint.getLongitude());
        double a2 = a(latLonPoint.getLatitude());
        return a + "," + a2;
    }

    public static Date c(String str) {
        if (str == null || str.trim().equals("")) {
            return null;
        }
        try {
            return new SimpleDateFormat("HHmm").parse(str);
        } catch (ParseException e) {
            a(e, "CoreUtil", "parseString2Time");
            return null;
        }
    }

    public static String a(Date date) {
        return date != null ? new SimpleDateFormat("HH:mm").format(date) : "";
    }

    public static Date d(String str) {
        if (str == null || str.trim().equals("")) {
            return null;
        }
        try {
            return new SimpleDateFormat("HH:mm").parse(str);
        } catch (ParseException e) {
            a(e, "CoreUtil", "parseTime");
            return null;
        }
    }

    public static String a(List<LatLonPoint> list) {
        return a(list, ";");
    }

    public static String a(List<LatLonPoint> list, String str) {
        if (list == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            LatLonPoint latLonPoint = list.get(i);
            if (latLonPoint != null) {
                double a = a(latLonPoint.getLongitude());
                double a2 = a(latLonPoint.getLatitude());
                stringBuffer.append(a);
                stringBuffer.append(",");
                stringBuffer.append(a2);
                stringBuffer.append(str);
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
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
