package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PoiSearchKeywordsHandler */
public final class oa extends ny<od, PoiResult> {
    private int i = 0;
    private List<String> j = new ArrayList();
    private List<SuggestionCity> k = new ArrayList();

    public oa(Context context, od odVar) {
        super(context, odVar);
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        String str = nk.a() + "/place";
        if (((od) this.d).b == null) {
            return str + "/text?";
        } else if (((od) this.d).b.getShape().equals("Bound")) {
            return str + "/around?";
        } else if (!((od) this.d).b.getShape().equals("Rectangle") && !((od) this.d).b.getShape().equals("Polygon")) {
            return str;
        } else {
            return str + "/polygon?";
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public PoiResult a(String str) throws AMapException {
        ArrayList<PoiItem> arrayList;
        ArrayList<PoiItem> arrayList2;
        JSONException e;
        Exception e2;
        ArrayList<PoiItem> arrayList3 = new ArrayList<>();
        if (str == null) {
            return PoiResult.createPagedResult(((od) this.d).a, ((od) this.d).b, this.j, this.k, ((od) this.d).a.getPageSize(), this.i, arrayList3);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.i = jSONObject.optInt("count");
            arrayList2 = nr.c(jSONObject);
            try {
                if (!jSONObject.has("suggestion")) {
                    return PoiResult.createPagedResult(((od) this.d).a, ((od) this.d).b, this.j, this.k, ((od) this.d).a.getPageSize(), this.i, arrayList2);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
                if (optJSONObject == null) {
                    return PoiResult.createPagedResult(((od) this.d).a, ((od) this.d).b, this.j, this.k, ((od) this.d).a.getPageSize(), this.i, arrayList2);
                }
                this.k = nr.a(optJSONObject);
                this.j = nr.b(optJSONObject);
                arrayList = arrayList2;
                return PoiResult.createPagedResult(((od) this.d).a, ((od) this.d).b, this.j, this.k, ((od) this.d).a.getPageSize(), this.i, arrayList);
            } catch (JSONException e3) {
                e = e3;
                nl.a(e, "PoiSearchKeywordHandler", "paseJSONJSONException");
                arrayList = arrayList2;
                return PoiResult.createPagedResult(((od) this.d).a, ((od) this.d).b, this.j, this.k, ((od) this.d).a.getPageSize(), this.i, arrayList);
            } catch (Exception e4) {
                e2 = e4;
                nl.a(e2, "PoiSearchKeywordHandler", "paseJSONException");
                arrayList = arrayList2;
                return PoiResult.createPagedResult(((od) this.d).a, ((od) this.d).b, this.j, this.k, ((od) this.d).a.getPageSize(), this.i, arrayList);
            }
        } catch (JSONException e5) {
            e = e5;
            arrayList2 = arrayList3;
            nl.a(e, "PoiSearchKeywordHandler", "paseJSONJSONException");
            arrayList = arrayList2;
            return PoiResult.createPagedResult(((od) this.d).a, ((od) this.d).b, this.j, this.k, ((od) this.d).a.getPageSize(), this.i, arrayList);
        } catch (Exception e6) {
            e2 = e6;
            arrayList2 = arrayList3;
            nl.a(e2, "PoiSearchKeywordHandler", "paseJSONException");
            arrayList = arrayList2;
            return PoiResult.createPagedResult(((od) this.d).a, ((od) this.d).b, this.j, this.k, ((od) this.d).a.getPageSize(), this.i, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nd
    public final String d() {
        List<LatLonPoint> polyGonList;
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        if (((od) this.d).b != null) {
            if (((od) this.d).b.getShape().equals("Bound")) {
                double a = nl.a(((od) this.d).b.getCenter().getLongitude());
                double a2 = nl.a(((od) this.d).b.getCenter().getLatitude());
                sb.append("&location=");
                sb.append(a + "," + a2);
                sb.append("&radius=");
                sb.append(((od) this.d).b.getRange());
                sb.append("&sortrule=");
                sb.append(a(((od) this.d).b.isDistanceSort()));
            } else if (((od) this.d).b.getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((od) this.d).b.getLowerLeft();
                LatLonPoint upperRight = ((od) this.d).b.getUpperRight();
                double a3 = nl.a(lowerLeft.getLatitude());
                double a4 = nl.a(lowerLeft.getLongitude());
                double a5 = nl.a(upperRight.getLatitude());
                double a6 = nl.a(upperRight.getLongitude());
                sb.append("&polygon=" + a4 + "," + a3 + ";" + a6 + "," + a5);
            } else if (((od) this.d).b.getShape().equals("Polygon") && (polyGonList = ((od) this.d).b.getPolyGonList()) != null && polyGonList.size() > 0) {
                sb.append("&polygon=" + nl.a(polyGonList));
            }
        }
        String city = ((od) this.d).a.getCity();
        if (!c(city)) {
            String b = b(city);
            sb.append("&city=");
            sb.append(b);
        }
        String b2 = b(((od) this.d).a.getQueryString());
        if (!c(b2)) {
            sb.append("&keywords=" + b2);
        }
        sb.append("&offset=" + ((od) this.d).a.getPageSize());
        sb.append("&page=" + ((od) this.d).a.getPageNum());
        String building = ((od) this.d).a.getBuilding();
        if (building != null && building.trim().length() > 0) {
            sb.append("&building=" + ((od) this.d).a.getBuilding());
        }
        String b3 = b(((od) this.d).a.getCategory());
        if (!c(b3)) {
            sb.append("&types=" + b3);
        }
        sb.append("&extensions=all");
        sb.append("&key=" + qy.f(this.g));
        if (((od) this.d).a.getCityLimit()) {
            sb.append("&citylimit=true");
        } else {
            sb.append("&citylimit=false");
        }
        if (((od) this.d).a.isRequireSubPois()) {
            sb.append("&children=1");
        } else {
            sb.append("&children=0");
        }
        if (((od) this.d).b == null && ((od) this.d).a.getLocation() != null) {
            sb.append("&sortrule=");
            sb.append(a(((od) this.d).a.isDistanceSort()));
            double a7 = nl.a(((od) this.d).a.getLocation().getLongitude());
            double a8 = nl.a(((od) this.d).a.getLocation().getLatitude());
            sb.append("&location=");
            sb.append(a7 + "," + a8);
        }
        sb.append("&special=false");
        return sb.toString();
    }

    private static String a(boolean z) {
        if (z) {
            return "distance";
        }
        return "weight";
    }
}
