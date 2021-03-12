package com.amap.api.col.stln3;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.alibaba.idst.nls.internal.connector.NetDefine;
import com.amap.api.services.core.AMapException;
import com.autonavi.amap.mapcore.tools.GLMapStaticValue;
import org.json.JSONObject;

/* compiled from: RestFront */
public final class jy {
    public static void a(String str, int i) {
        String str2 = "";
        String str3 = "";
        switch (i) {
            case 3:
                str2 = "5030";
                str3 = "起点错误";
                break;
            case 4:
                str2 = "5031";
                str3 = AMapException.AMAP_SERVICE_ILLEGAL_REQUEST;
                break;
            case 5:
                str2 = "5050";
                str3 = "呼叫中心错误";
                break;
            case 6:
                str2 = "5060";
                str3 = "终点错误";
                break;
            case 7:
                str2 = "5070";
                str3 = "算路服务端编码失败";
                break;
            case 8:
                str2 = "5080";
                str3 = "路径数据缺乏预览数据";
                break;
            case 9:
                str2 = "5090";
                str3 = "Buf数据格式错误";
                break;
            case 10:
                str2 = "5100";
                str3 = "起点找不到道路";
                break;
            case 11:
                str2 = "5110";
                str3 = "终点找不到道路";
                break;
            case 12:
                str2 = "5120";
                str3 = "途经点找不到道路";
                break;
            default:
                switch (i) {
                    case 19:
                        str2 = "5042";
                        str3 = "算路失败未知错误";
                        break;
                    case 20:
                        str2 = "5051";
                        str3 = "路径距离太长";
                        break;
                    case 21:
                        str2 = "5210";
                        str3 = "途经点错误";
                        break;
                }
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            rx.a(mj.a(), str, str3, "", str2);
        }
    }

    public static int a(String str, ty tyVar) {
        if (tyVar == null) {
            return 2;
        }
        try {
            String str2 = tyVar.d;
            String str3 = new String(tyVar.a, "UTF-8");
            if (!str3.contains("\"status\":\"0\"")) {
                return -1;
            }
            String str4 = "错误码:" + str3;
            jz jzVar = new jz();
            JSONObject jSONObject = new JSONObject(str3);
            String string = jSONObject.getString(NotificationCompat.CATEGORY_STATUS);
            String string2 = jSONObject.getString("info");
            String string3 = jSONObject.getString("infocode");
            jzVar.a(Integer.parseInt(string));
            jzVar.a(string2);
            jzVar.b(Integer.parseInt(string3));
            rx.a(mj.a(), str, jzVar.c(), str2, String.valueOf(jzVar.b()));
            if (jzVar.a() == 0) {
                return a(jzVar);
            }
            return 19;
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static int b(String str, ty tyVar) {
        if (tyVar == null) {
            return 2;
        }
        try {
            String str2 = tyVar.d;
            String str3 = new String(tyVar.a, "UTF-8");
            if (str3.contains("\"errcode\":")) {
                String str4 = "错误码:" + str3;
                jz jzVar = new jz();
                JSONObject jSONObject = new JSONObject(str3);
                String string = jSONObject.getString("errcode");
                String string2 = jSONObject.getString("errmsg");
                String string3 = jSONObject.getString("errcode");
                jzVar.a(Integer.parseInt(string));
                jzVar.a(string2);
                jzVar.b(Integer.parseInt(string3));
                if (jzVar.a() == 0) {
                    return -1;
                }
                rx.a(mj.a(), str, jzVar.c(), str2, String.valueOf(jzVar.b()));
                if (jzVar.a() != 0) {
                    return a(jzVar);
                }
                return 19;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return -1;
    }

    private static int a(jz jzVar) {
        switch (jzVar.b()) {
            case GLMapStaticValue.AM_CALLBACK_CHANGEMAPLOGO /*{ENCODED_INT: 10001}*/:
                return 13;
            case GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR /*{ENCODED_INT: 10003}*/:
                return 17;
            case 10004:
                return 23;
            case 10008:
                return 22;
            case 10009:
                return 24;
            case 10016:
                return 17;
            case NetDefine.HTTP_READ_TIMEOUT:
            case 20001:
                return 18;
            case 20800:
                return 25;
            case 20803:
                return 26;
            default:
                return 19;
        }
    }
}
