package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CloudSearchIdHandler */
public final class ni extends nh<oc, CloudItemDetail> {
    @Override // com.amap.api.col.stln3.nc
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    public ni(Context context, oc ocVar) {
        super(context, ocVar);
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return nk.c() + "/datasearch/id?";
    }

    private static CloudItemDetail c(String str) throws AMapException {
        if (str == null || str.equals("")) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("datas")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("datas");
                if (optJSONArray.length() > 0) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(0);
                    CloudItemDetail a = a(jSONObject2);
                    a(a, jSONObject2);
                    return a;
                }
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nd
    public final String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("key=" + qy.f(this.g));
        sb.append("&tableid=" + ((oc) this.d).a);
        sb.append("&output=json");
        sb.append("&_id=" + ((oc) this.d).b);
        return sb.toString();
    }
}
