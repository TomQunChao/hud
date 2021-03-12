package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearchQuery;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DistrictServerHandler */
public final class nn extends nd<DistrictSearchQuery, DistrictResult> {
    public nn(Context context, DistrictSearchQuery districtSearchQuery) {
        super(context, districtSearchQuery);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nd
    public final String d() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        stringBuffer.append("&page=");
        stringBuffer.append(((DistrictSearchQuery) this.d).getPageNum());
        stringBuffer.append("&offset=");
        stringBuffer.append(((DistrictSearchQuery) this.d).getPageSize());
        stringBuffer.append("&showChild=");
        stringBuffer.append(((DistrictSearchQuery) this.d).isShowChild());
        if (((DistrictSearchQuery) this.d).isShowBoundary()) {
            stringBuffer.append("&extensions=all");
        } else {
            stringBuffer.append("&extensions=base");
        }
        if (((DistrictSearchQuery) this.d).checkKeyWords()) {
            String b = b(((DistrictSearchQuery) this.d).getKeywords());
            stringBuffer.append("&keywords=");
            stringBuffer.append(b);
        }
        stringBuffer.append("&key=" + qy.f(this.g));
        return stringBuffer.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public DistrictResult a(String str) throws AMapException {
        ArrayList arrayList = new ArrayList();
        DistrictResult districtResult = new DistrictResult((DistrictSearchQuery) this.d, arrayList);
        try {
            JSONObject jSONObject = new JSONObject(str);
            districtResult.setPageCount(jSONObject.optInt("count"));
            JSONArray optJSONArray = jSONObject.optJSONArray("districts");
            if (optJSONArray == null) {
                return districtResult;
            }
            nr.a(optJSONArray, arrayList, null);
            return districtResult;
        } catch (JSONException e) {
            nl.a(e, "DistrictServerHandler", "paseJSONJSONException");
        } catch (Exception e2) {
            nl.a(e2, "DistrictServerHandler", "paseJSONException");
        }
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return nk.a() + "/config/district?";
    }
}
