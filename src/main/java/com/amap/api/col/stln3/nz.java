package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PoiSearchIdHandler */
public final class nz extends ny<String, PoiItem> {
    @Override // com.amap.api.col.stln3.nc
    public final /* synthetic */ Object a(String str) throws AMapException {
        return d(str);
    }

    public nz(Context context, String str) {
        super(context, str);
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return nk.a() + "/place/detail?";
    }

    private static PoiItem d(String str) throws AMapException {
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("pois");
            if (optJSONArray == null) {
                return null;
            }
            if (optJSONArray.length() <= 0) {
                return null;
            }
            JSONObject optJSONObject = optJSONArray.optJSONObject(0);
            if (optJSONObject == null) {
                return null;
            }
            return nr.d(optJSONObject);
        } catch (JSONException e) {
            nl.a(e, "PoiSearchIdHandler", "paseJSONJSONException");
            return null;
        } catch (Exception e2) {
            nl.a(e2, "PoiSearchIdHandler", "paseJSONException");
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nd
    public final String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append((String) this.d);
        sb.append("&output=json");
        sb.append("&extensions=all");
        sb.append("&children=1");
        sb.append("&key=" + qy.f(this.g));
        return sb.toString();
    }
}
