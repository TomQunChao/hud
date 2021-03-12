package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InputtipsHandler */
public final class le extends ky<lf, ArrayList<lw>> {
    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.kx
    public final /* synthetic */ Object a(String str) throws kv {
        return c(str);
    }

    public le(Context context, lf lfVar) {
        super(context, lfVar);
    }

    private static ArrayList<lw> c(String str) throws kv {
        try {
            return a(new JSONObject(str));
        } catch (JSONException e) {
            return null;
        }
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return "http://restapi.amap.com/v3/assistant/inputtips?";
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.ky
    public final String d() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json&keywords=");
        stringBuffer.append(b(((lf) this.d).a()));
        String b = ((lf) this.d).b();
        if (!d(b)) {
            String b2 = b(b);
            stringBuffer.append("&city=");
            stringBuffer.append(b2);
        }
        String c = ((lf) this.d).c();
        if (!d(c)) {
            String b3 = b(c);
            stringBuffer.append("&type=");
            stringBuffer.append(b3);
        }
        if (((lf) this.d).d()) {
            stringBuffer.append("&citylimit=true");
        } else {
            stringBuffer.append("&citylimit=false");
        }
        li e = ((lf) this.d).e();
        if (e != null) {
            stringBuffer.append("&location=");
            stringBuffer.append(e.a());
            stringBuffer.append(",");
            stringBuffer.append(e.b());
        }
        stringBuffer.append("&key=");
        stringBuffer.append(qy.f(this.g));
        return stringBuffer.toString();
    }

    private static boolean d(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }
        return false;
    }

    private static String a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str) && !"[]".equals(jSONObject.getString(str))) {
            return jSONObject.optString(str).trim();
        }
        return "";
    }

    private static ArrayList<lw> a(JSONObject jSONObject) throws JSONException {
        ArrayList<lw> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("tips");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            lw lwVar = new lw();
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                lwVar.b(a(optJSONObject, "name"));
                lwVar.c(a(optJSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
                lwVar.d(a(optJSONObject, "adcode"));
                lwVar.a(a(optJSONObject, "id"));
                lwVar.e(a(optJSONObject, "address"));
                lwVar.f(a(optJSONObject, "typecode"));
                String a = a(optJSONObject, "location");
                if (!TextUtils.isEmpty(a)) {
                    String[] split = a.split(",");
                    if (split.length == 2) {
                        lwVar.a(new li(Double.parseDouble(split[1]), Double.parseDouble(split[0])));
                    }
                }
                arrayList.add(lwVar);
            }
        }
        return arrayList;
    }
}
