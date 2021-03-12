package com.amap.api.col.stln3;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JSONObjUtil */
public final class qd {
    private JSONObject a = null;

    public final qd a(String str) {
        try {
            this.a = new JSONObject(str);
        } catch (JSONException e) {
        }
        return this;
    }

    public final JSONArray b(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONArray();
        }
        JSONObject jSONObject = this.a;
        if (jSONObject == null) {
            return new JSONArray();
        }
        return jSONObject.optJSONArray(str);
    }

    public final String c(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str) && (jSONObject = this.a) != null) {
            return jSONObject.optString(str);
        }
        return "";
    }

    public final long d(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str) && (jSONObject = this.a) != null) {
            return jSONObject.optLong(str);
        }
        return -1;
    }

    public final double e(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str) && (jSONObject = this.a) != null) {
            return jSONObject.optDouble(str);
        }
        return -1.0d;
    }

    public final Map<String, String> f(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject optJSONObject = this.a.optJSONObject(str);
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, optJSONObject.optString(next));
            }
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    public final List<String> g(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = this.a.optJSONArray(str);
            if (optJSONArray == null) {
                return arrayList;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.optString(i));
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    public final int h(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str) && (jSONObject = this.a) != null) {
            return jSONObject.optInt(str);
        }
        return -1;
    }
}
