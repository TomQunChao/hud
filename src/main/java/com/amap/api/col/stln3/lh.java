package com.amap.api.col.stln3;

import android.support.v4.app.NotificationCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JsonHelper */
public final class lh {
    static int a = 2;

    public static ln a(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        ln lnVar = new ln(a(jSONObject, "id"), b(jSONObject, "location"), a(jSONObject, "name"), a(jSONObject, "address"));
        lnVar.g(a(jSONObject, "adcode"));
        lnVar.d(a(jSONObject, "pname"));
        lnVar.c(a(jSONObject, "cityname"));
        lnVar.b(a(jSONObject, "adname"));
        lnVar.h(a(jSONObject, "citycode"));
        lnVar.m(a(jSONObject, "pcode"));
        lnVar.l(a(jSONObject, "direction"));
        if (jSONObject.has("distance")) {
            String a2 = a(jSONObject, "distance");
            if (!a(a2)) {
                try {
                    lnVar.a((int) Float.parseFloat(a2));
                } catch (NumberFormatException e) {
                    la.a(e, "JsonHelper", "parseBasePoi");
                } catch (Exception e2) {
                    la.a(e2, "JsonHelper", "parseBasePoi");
                }
            }
        }
        lnVar.f(a(jSONObject, "tel"));
        lnVar.e(a(jSONObject, "type"));
        lnVar.a(b(jSONObject, "entr_location"));
        lnVar.b(b(jSONObject, "exit_location"));
        lnVar.i(a(jSONObject, "website"));
        lnVar.j(a(jSONObject, "postcode"));
        lnVar.a(a(jSONObject, "business_area"));
        lnVar.k(a(jSONObject, NotificationCompat.CATEGORY_EMAIL));
        String a3 = a(jSONObject, "indoor_map");
        int i = 0;
        if (a3 == null || "".equals(a3) || "0".equals(a3)) {
            lnVar.a(false);
        } else {
            lnVar.a(true);
        }
        lnVar.n(a(jSONObject, "parking_type"));
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i2);
                    if (optJSONObject3 != null) {
                        arrayList.add(b(optJSONObject3));
                    }
                }
            }
            lnVar.a(arrayList);
        }
        String str = "";
        String str2 = "";
        if (jSONObject.has("indoor_data") && (optJSONObject2 = jSONObject.optJSONObject("indoor_data")) != null && optJSONObject2.has("cpid") && optJSONObject2.has("floor")) {
            str = a(optJSONObject2, "cpid");
            i = b(a(optJSONObject2, "floor"));
            str2 = a(optJSONObject2, "truefloor");
        }
        lnVar.a(new lc(str, i, str2));
        String str3 = "";
        String str4 = "";
        if (jSONObject.has("biz_ext") && (optJSONObject = jSONObject.optJSONObject("biz_ext")) != null) {
            str3 = a(optJSONObject, "open_time");
            str4 = a(optJSONObject, "rating");
        }
        lnVar.a(new lo(str3, str4));
        lnVar.o(a(jSONObject, "typecode"));
        lnVar.p(a(jSONObject, "shopid"));
        List<lk> c = c(jSONObject.optJSONObject("deep_info"));
        if (c.size() == 0) {
            c = c(jSONObject);
        }
        lnVar.b(c);
        return lnVar;
    }

    private static lv b(JSONObject jSONObject) throws JSONException {
        lv lvVar = new lv(a(jSONObject, "id"), b(jSONObject, "location"), a(jSONObject, "name"), a(jSONObject, "address"));
        lvVar.a(a(jSONObject, "sname"));
        lvVar.b(a(jSONObject, "subtype"));
        if (jSONObject.has("distance")) {
            String a2 = a(jSONObject, "distance");
            if (!a(a2)) {
                try {
                    lvVar.a((int) Float.parseFloat(a2));
                } catch (NumberFormatException e) {
                    la.a(e, "JsonHelper", "parseSubPoiItem");
                } catch (Exception e2) {
                    la.a(e2, "JsonHelper", "parseSubPoiItem");
                }
            }
        }
        return lvVar;
    }

    private static String a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str) && !"[]".equals(jSONObject.getString(str)) && !"{}".equals(jSONObject.getString(str))) {
            return jSONObject.optString(str).trim();
        }
        return "";
    }

    private static li b(JSONObject jSONObject, String str) throws JSONException {
        String optString;
        if (jSONObject == null || !jSONObject.has(str) || (optString = jSONObject.optString(str)) == null || "".equals(optString) || "[]".equals(optString)) {
            return null;
        }
        String[] split = optString.split(",| ");
        if (split.length != a) {
            return null;
        }
        return new li(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
    }

    private static boolean a(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }
        return false;
    }

    private static int b(String str) {
        if (str == null || "".equals(str) || "[]".equals(str) || "{}".equals(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            la.a(e, "JsonHelper", "str2int");
            return 0;
        }
    }

    private static List<lk> c(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || !jSONObject.has("photos")) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("photos");
        int i = 0;
        while (optJSONArray != null && i < optJSONArray.length()) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            lk lkVar = new lk();
            lkVar.a(a(optJSONObject, "title"));
            lkVar.b(a(optJSONObject, "url"));
            arrayList.add(lkVar);
            i++;
        }
        return arrayList;
    }

    public static Map<String, ln> a(JSONArray jSONArray) throws Exception {
        JSONArray optJSONArray;
        HashMap hashMap = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (!(!jSONObject.has("body") || (optJSONArray = jSONObject.getJSONObject("body").optJSONArray("pois")) == null || optJSONArray.length() == 0)) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        ln a2 = a(optJSONObject);
                        hashMap.put(a2.a(), a2);
                    }
                }
            }
        }
        return hashMap;
    }
}
