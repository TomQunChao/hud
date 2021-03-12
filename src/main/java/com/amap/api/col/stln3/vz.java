package com.amap.api.col.stln3;

import android.content.Context;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.util.SparseArray;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.amap.mapcore.tools.GLMapStaticValue;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ReportUtil */
public final class vz {
    static AMapLocation g = null;
    private static List<ug> h = new ArrayList();
    private static JSONArray i = null;
    public SparseArray<Long> a = new SparseArray<>();
    public int b = -1;
    public long c = 0;
    String[] d = {"ol", "cl", "gl", "ha", "bs", "ds"};
    public int e = -1;
    public long f = -1;

    private static boolean a(AMapLocation aMapLocation) {
        return wc.a(aMapLocation) ? !vu.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) : "http://abroad.apilocate.amap.com/mobile/binary".equals(vu.a);
    }

    public static void a(Context context, AMapLocation aMapLocation) {
        String str;
        int i2;
        String str2;
        if (aMapLocation != null) {
            try {
                if (GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider())) {
                    return;
                }
                if (aMapLocation.getLocationType() != 1) {
                    if (a(aMapLocation)) {
                        str = "abroad";
                    } else {
                        str = "domestic";
                    }
                    if (aMapLocation.getErrorCode() == 0) {
                        switch (aMapLocation.getLocationType()) {
                            case 5:
                            case 6:
                                str2 = "net";
                                i2 = 1;
                                break;
                            default:
                                str2 = "cache";
                                i2 = 1;
                                break;
                        }
                    } else {
                        int errorCode = aMapLocation.getErrorCode();
                        if (errorCode != 11) {
                            switch (errorCode) {
                                case 4:
                                case 5:
                                case 6:
                                    break;
                                default:
                                    str2 = "cache";
                                    i2 = 0;
                                    break;
                            }
                        }
                        str2 = "net";
                        i2 = 0;
                    }
                    a(context, "O016", str2, str, i2, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                }
            } catch (Throwable th) {
                vu.a(th, "ReportUtil", "reportBatting");
            }
        }
    }

    public static void a(Context context, vy vyVar) {
        String str;
        String str2;
        if (context != null) {
            try {
                if (vt.o()) {
                    vc c2 = vyVar.c();
                    if (!wc.a(c2) || GeocodeSearch.GPS.equalsIgnoreCase(c2.getProvider())) {
                        return;
                    }
                    if (c2.getLocationType() != 1) {
                        int intValue = Long.valueOf(vyVar.b() - vyVar.a()).intValue();
                        boolean z = false;
                        int intValue2 = Long.valueOf(c2.k()).intValue();
                        switch (c2.getLocationType()) {
                            case 5:
                            case 6:
                                str = "net";
                                break;
                            default:
                                str = "cache";
                                z = true;
                                break;
                        }
                        if (a(c2)) {
                            str2 = "abroad";
                        } else {
                            str2 = "domestic";
                        }
                        if (!z) {
                            a(context, "O014", str2, null, intValue2, intValue);
                        }
                        a(context, "O013", str, str2, intValue, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    }
                }
            } catch (Throwable th) {
                vu.a(th, "ReportUtil", "reportLBSLocUseTime");
            }
        }
    }

    public static void a(Context context, long j, boolean z) {
        String str;
        if (context != null) {
            try {
                if (vt.o()) {
                    int intValue = Long.valueOf(j).intValue();
                    if (!z) {
                        str = "abroad";
                    } else {
                        str = "domestic";
                    }
                    a(context, "O015", str, null, intValue, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                }
            } catch (Throwable th) {
                vu.a(th, "ReportUtil", "reportGPSLocUseTime");
            }
        }
    }

    private static void a(Context context, String str, int i2, String str2) {
        if (context != null) {
            try {
                if (vt.o()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (i2 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i2);
                    }
                    a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                vu.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    private static void a(Context context, String str, String str2, String str3, int i2, int i3) {
        if (context != null) {
            try {
                if (vt.o()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("param_string_second", str3);
                    }
                    if (i2 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i2);
                    }
                    if (i3 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_second", i3);
                    }
                    a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                vu.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    private static void a(Context context, String str, JSONObject jSONObject) {
        if (context != null) {
            try {
                if (vt.o()) {
                    ug ugVar = new ug(context, "loc", "4.5.0", str);
                    ugVar.a(jSONObject.toString());
                    h.add(ugVar);
                    if (h.size() >= 100) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(h);
                        uh.a(arrayList, context);
                        h.clear();
                    }
                }
            } catch (Throwable th) {
                vu.a(th, "ReportUtil", "applyStatistics");
            }
        }
    }

    public static void a(Context context) {
        if (context != null) {
            try {
                if (vt.o()) {
                    if (h != null && h.size() > 0) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(h);
                        uh.a(arrayList, context);
                        h.clear();
                    }
                    f(context);
                }
            } catch (Throwable th) {
                vu.a(th, "ReportUtil", "destroy");
            }
        }
    }

    public static void a(String str, String str2) {
        try {
            rx.b(vu.b(), str2, str);
        } catch (Throwable th) {
            vu.a(th, "ReportUtil", "reportLog");
        }
    }

    public static boolean a(Context context, rj rjVar) {
        try {
            return sk.b(context, rjVar);
        } catch (Throwable th) {
            return false;
        }
    }

    public static void a(Context context, String str, int i2) {
        try {
            a(context, "O009", i2, str);
        } catch (Throwable th) {
            vu.a(th, "ReportUtil", "reportDexLoadDexClass");
        }
    }

    public static void b(Context context, String str, int i2) {
        try {
            a(context, "O010", i2, str);
        } catch (Throwable th) {
            vu.a(th, "ReportUtil", "reportDexFunction");
        }
    }

    public final void a(Context context, int i2) {
        try {
            if (this.b != i2) {
                if (!(this.b == -1 || this.b == i2)) {
                    this.a.append(this.b, Long.valueOf((wc.b() - this.c) + this.a.get(this.b, 0L).longValue()));
                }
                this.c = wc.b() - wb.b(context, "pref", this.d[i2], 0L);
                this.b = i2;
            }
        } catch (Throwable th) {
            vu.a(th, "ReportUtil", "setLocationType");
        }
    }

    public final void b(Context context) {
        try {
            long b2 = wc.b() - this.c;
            if (this.b != -1) {
                this.a.append(this.b, Long.valueOf(b2 + this.a.get(this.b, 0L).longValue()));
            }
            long b3 = wc.b() - this.f;
            if (this.e != -1) {
                this.a.append(this.e, Long.valueOf(b3 + this.a.get(this.e, 0L).longValue()));
            }
            for (int i2 = 0; i2 < this.d.length; i2++) {
                long longValue = this.a.get(i2, 0L).longValue();
                if (longValue > 0 && longValue > wb.b(context, "pref", this.d[i2], 0L)) {
                    wb.a(context, "pref", this.d[i2], longValue);
                }
            }
        } catch (Throwable th) {
            vu.a(th, "ReportUtil", "saveLocationTypeAndMode");
        }
    }

    public final void a(Context context, AMapLocationClientOption aMapLocationClientOption) {
        int i2;
        try {
            switch (aMapLocationClientOption.getLocationMode()) {
                case Battery_Saving:
                    i2 = 4;
                    break;
                case Device_Sensors:
                    i2 = 5;
                    break;
                case Hight_Accuracy:
                    i2 = 3;
                    break;
                default:
                    i2 = -1;
                    break;
            }
            if (this.e != i2) {
                if (!(this.e == -1 || this.e == i2)) {
                    this.a.append(this.e, Long.valueOf((wc.b() - this.f) + this.a.get(this.e, 0L).longValue()));
                }
                this.f = wc.b() - wb.b(context, "pref", this.d[i2], 0L);
                this.e = i2;
            }
        } catch (Throwable th) {
            vu.a(th, "ReportUtil", "setLocationMode");
        }
    }

    public final int c(Context context) {
        try {
            long b2 = wb.b(context, "pref", this.d[2], 0L);
            long b3 = wb.b(context, "pref", this.d[0], 0L);
            long b4 = wb.b(context, "pref", this.d[1], 0L);
            if (b2 == 0 && b3 == 0 && b4 == 0) {
                return -1;
            }
            long j = b3 - b2;
            long j2 = b4 - b2;
            if (b2 > j) {
                if (b2 > j2) {
                    return 2;
                }
                return 1;
            } else if (j > j2) {
                return 0;
            } else {
                return 1;
            }
        } catch (Throwable th) {
            return -1;
        }
    }

    public final int d(Context context) {
        try {
            long b2 = wb.b(context, "pref", this.d[3], 0L);
            long b3 = wb.b(context, "pref", this.d[4], 0L);
            long b4 = wb.b(context, "pref", this.d[5], 0L);
            if (b2 == 0 && b3 == 0 && b4 == 0) {
                return -1;
            }
            if (b2 > b3) {
                if (b2 > b4) {
                    return 3;
                }
                return 5;
            } else if (b3 > b4) {
                return 4;
            } else {
                return 5;
            }
        } catch (Throwable th) {
            return -1;
        }
    }

    public final void e(Context context) {
        for (int i2 = 0; i2 < this.d.length; i2++) {
            try {
                wb.a(context, "pref", this.d[i2], 0L);
            } catch (Throwable th) {
                return;
            }
        }
    }

    public static void a(Context context, int i2, int i3, long j, long j2) {
        if (i2 != -1 && i3 != -1 && context != null) {
            try {
                if (vt.o()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("param_int_first", i2);
                    jSONObject.put("param_int_second", i3);
                    jSONObject.put("param_long_first", j);
                    jSONObject.put("param_long_second", j2);
                    a(context, "O012", jSONObject);
                }
            } catch (Throwable th) {
                vu.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    public static void b(Context context, AMapLocation aMapLocation) {
        int i2;
        try {
            if (wc.a(aMapLocation)) {
                boolean z = false;
                switch (aMapLocation.getLocationType()) {
                    case 1:
                        i2 = 0;
                        z = true;
                        break;
                    case 2:
                    case 4:
                        i2 = 1;
                        z = true;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 7:
                    default:
                        i2 = 0;
                        break;
                    case 8:
                        i2 = 3;
                        z = true;
                        break;
                    case 9:
                        i2 = 2;
                        z = true;
                        break;
                }
                if (z) {
                    if (i == null) {
                        i = new JSONArray();
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("lon", wc.c(aMapLocation.getLongitude()));
                    jSONObject.put("lat", wc.c(aMapLocation.getLatitude()));
                    jSONObject.put("type", i2);
                    jSONObject.put("timestamp", wc.a());
                    if (aMapLocation.getCoordType().equalsIgnoreCase(AMapLocation.COORD_TYPE_WGS84)) {
                        jSONObject.put("coordType", 1);
                    } else {
                        jSONObject.put("coordType", 2);
                    }
                    if (i2 == 0) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("accuracy", wc.b((double) aMapLocation.getAccuracy()));
                        jSONObject2.put("altitude", wc.b(aMapLocation.getAltitude()));
                        jSONObject2.put("bearing", wc.b((double) aMapLocation.getBearing()));
                        jSONObject2.put("speed", wc.b((double) aMapLocation.getSpeed()));
                        jSONObject.put("extension", jSONObject2);
                    }
                    JSONArray put = i.put(jSONObject);
                    i = put;
                    if (put.length() >= vt.p()) {
                        f(context);
                    }
                }
            }
        } catch (Throwable th) {
            vu.a(th, "ReportUtil", "recordOfflineLocLog");
        }
    }

    private static void f(Context context) {
        try {
            if (i != null && i.length() > 0) {
                uf.a(new ue(context, vu.b(), i.toString()), context);
                i = null;
            }
        } catch (Throwable th) {
            vu.a(th, "ReportUtil", "writeOfflineLocLog");
        }
    }

    public static void a(String str, int i2) {
        String valueOf = String.valueOf(i2);
        String str2 = "";
        switch (i2) {
            case 2011:
                str2 = "ContextIsNull";
                break;
            case 2021:
                str2 = "OnlyMainWifi";
                break;
            case GLMapStaticValue.MAP_PARAMETERNAME_CLEAR_INDOORBUILDING_LAST /*{ENCODED_INT: 2022}*/:
                str2 = "OnlyOneWifiButNotMain";
                break;
            case 2031:
                str2 = "CreateApsReqException";
                break;
            case 2041:
                str2 = "ResponseResultIsNull";
                break;
            case 2051:
                str2 = "NeedLoginNetWork\t";
                break;
            case 2052:
                str2 = "MaybeIntercepted";
                break;
            case 2053:
                str2 = "DecryptResponseException";
                break;
            case 2054:
                str2 = "ParserDataException";
                break;
            case 2061:
                str2 = "ServerRetypeError";
                break;
            case 2062:
                str2 = "ServerLocFail";
                break;
            case 2081:
                str2 = "LocalLocException";
                break;
            case 2091:
                str2 = "InitException";
                break;
            case AMapException.CODE_AMAP_NEARBY_KEY_NOT_BIND /*{ENCODED_INT: 2101}*/:
                str2 = "BindAPSServiceException";
                break;
            case 2102:
                str2 = "AuthClientScodeFail";
                break;
            case 2103:
                str2 = "NotConfigAPSService";
                break;
            case 2111:
                str2 = "ErrorCgiInfo";
                break;
            case 2121:
                str2 = "NotLocPermission";
                break;
            case 2131:
                str2 = "NoCgiOAndWifiInfo";
                break;
            case 2132:
                str2 = "AirPlaneModeAndWifiOff";
                break;
            case 2133:
                str2 = "NoCgiAndWifiOff";
                break;
            case 2141:
                str2 = "NoEnoughStatellites";
                break;
            case 2151:
                str2 = "MaybeMockNetLoc";
                break;
            case 2152:
                str2 = "MaybeMockGPSLoc";
                break;
        }
        a(str, valueOf, str2);
    }

    public static void a(String str, String str2, String str3) {
        try {
            rx.a(vu.b(), "/mobile/binary", str3, str, str2);
        } catch (Throwable th) {
        }
    }

    public static void a(String str, Throwable th) {
        try {
            if (th instanceof qx) {
                rx.a(vu.b(), str, (qx) th);
            }
        } catch (Throwable th2) {
        }
    }

    public static void a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        try {
            if (g == null) {
                if (!wc.a(aMapLocation)) {
                    g = aMapLocation2;
                    return;
                }
                g = aMapLocation.clone();
            }
            if (wc.a(g) && wc.a(aMapLocation2)) {
                AMapLocation clone = aMapLocation2.clone();
                if (g.getLocationType() != 1) {
                    if (g.getLocationType() != 9) {
                        if (!GeocodeSearch.GPS.equalsIgnoreCase(g.getProvider())) {
                            if (g.getLocationType() != 7) {
                                if (clone.getLocationType() != 1) {
                                    if (clone.getLocationType() != 9) {
                                        if (!GeocodeSearch.GPS.equalsIgnoreCase(clone.getProvider())) {
                                            if (clone.getLocationType() != 7) {
                                                long abs = Math.abs(clone.getTime() - g.getTime()) / 1000;
                                                if (abs <= 0) {
                                                    abs = 1;
                                                }
                                                if (abs <= 1800) {
                                                    float a2 = wc.a(g, clone);
                                                    float f2 = a2 / ((float) abs);
                                                    if (a2 > 30000.0f && f2 > 1000.0f) {
                                                        StringBuilder sb = new StringBuilder();
                                                        sb.append(g.getLatitude());
                                                        sb.append(",");
                                                        sb.append(g.getLongitude());
                                                        sb.append(",");
                                                        sb.append(g.getAccuracy());
                                                        sb.append(",");
                                                        sb.append(g.getLocationType());
                                                        sb.append(",");
                                                        if (aMapLocation.getTime() != 0) {
                                                            sb.append(wc.a(g.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                                                        } else {
                                                            sb.append(g.getTime());
                                                        }
                                                        sb.append("#");
                                                        sb.append(clone.getLatitude());
                                                        sb.append(",");
                                                        sb.append(clone.getLongitude());
                                                        sb.append(",");
                                                        sb.append(clone.getAccuracy());
                                                        sb.append(",");
                                                        sb.append(clone.getLocationType());
                                                        sb.append(",");
                                                        if (clone.getTime() != 0) {
                                                            sb.append(wc.a(clone.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                                                        } else {
                                                            sb.append(clone.getTime());
                                                        }
                                                        a("bigshiftstatistics", sb.toString());
                                                        sb.delete(0, sb.length());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                g = clone;
            }
        } catch (Throwable th) {
        }
    }
}
