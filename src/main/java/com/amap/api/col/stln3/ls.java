package com.amap.api.col.stln3;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PoiSearchIdHandler */
public final class ls extends kz<String, ln> {
    @Override // com.amap.api.col.stln3.kx
    public final /* synthetic */ Object a(String str) throws kv {
        return c(str);
    }

    public ls(Context context, String str) {
        super(context, str);
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        StringBuilder sb = new StringBuilder();
        sb.append(lu.a().c() == 1 ? "http://restapi.amap.com/v3" : "https://restapi.amap.com/v3");
        sb.append("/place/detail?");
        return sb.toString();
    }

    private static ln c(String str) throws kv {
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
            return lh.a(optJSONObject);
        } catch (JSONException e) {
            la.a(e, "PoiSearchIdHandler", "paseJSONJSONException");
            return null;
        } catch (Throwable th) {
            la.a(th, "PoiSearchIdHandler", "paseJSONException");
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.ky
    public final String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append((String) this.d);
        sb.append("&output=json");
        sb.append("&extensions=all");
        sb.append("&children=1");
        sb.append("&language=");
        sb.append(lu.a().b());
        sb.append("&key=" + qy.f(this.g));
        return sb.toString();
    }
}
