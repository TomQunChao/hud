package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CloudSearchKeywordsHandler */
public final class nj extends nh<CloudSearch.Query, CloudResult> {
    private int i = 0;

    public nj(Context context, CloudSearch.Query query) {
        super(context, query);
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        String str = nk.c() + "/datasearch";
        String shape = ((CloudSearch.Query) this.d).getBound().getShape();
        if (shape.equals("Bound")) {
            return str + "/around?";
        } else if (shape.equals("Polygon") || shape.equals("Rectangle")) {
            return str + "/polygon?";
        } else if (!shape.equals(CloudSearch.SearchBound.LOCAL_SHAPE)) {
            return str;
        } else {
            return str + "/local?";
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public CloudResult a(String str) throws AMapException {
        ArrayList<CloudItem> arrayList = null;
        if (str == null || str.equals("")) {
            return CloudResult.createPagedResult((CloudSearch.Query) this.d, this.i, ((CloudSearch.Query) this.d).getBound(), ((CloudSearch.Query) this.d).getPageSize(), null);
        }
        try {
            arrayList = b(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return CloudResult.createPagedResult((CloudSearch.Query) this.d, this.i, ((CloudSearch.Query) this.d).getBound(), ((CloudSearch.Query) this.d).getPageSize(), arrayList);
    }

    private ArrayList<CloudItem> b(JSONObject jSONObject) throws JSONException {
        ArrayList<CloudItem> arrayList = new ArrayList<>();
        if (!jSONObject.has("datas")) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("datas");
        this.i = jSONObject.getInt("count");
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            CloudItemDetail a = a(optJSONObject);
            a(a, optJSONObject);
            arrayList.add(a);
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nd
    public final String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        if (((CloudSearch.Query) this.d).getBound() != null) {
            if (((CloudSearch.Query) this.d).getBound().getShape().equals("Bound")) {
                double a = nl.a(((CloudSearch.Query) this.d).getBound().getCenter().getLongitude());
                double a2 = nl.a(((CloudSearch.Query) this.d).getBound().getCenter().getLatitude());
                sb.append("&center=");
                sb.append(a + "," + a2);
                sb.append("&radius=");
                sb.append(((CloudSearch.Query) this.d).getBound().getRange());
            } else if (((CloudSearch.Query) this.d).getBound().getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((CloudSearch.Query) this.d).getBound().getLowerLeft();
                LatLonPoint upperRight = ((CloudSearch.Query) this.d).getBound().getUpperRight();
                double a3 = nl.a(lowerLeft.getLatitude());
                double a4 = nl.a(lowerLeft.getLongitude());
                double a5 = nl.a(upperRight.getLatitude());
                double a6 = nl.a(upperRight.getLongitude());
                sb.append("&polygon=" + a4 + "," + a3 + ";" + a6 + "," + a5);
            } else if (((CloudSearch.Query) this.d).getBound().getShape().equals("Polygon")) {
                List<LatLonPoint> polyGonList = ((CloudSearch.Query) this.d).getBound().getPolyGonList();
                if (polyGonList != null && polyGonList.size() > 0) {
                    sb.append("&polygon=" + nl.a(polyGonList, ";"));
                }
            } else if (((CloudSearch.Query) this.d).getBound().getShape().equals(CloudSearch.SearchBound.LOCAL_SHAPE)) {
                String b = b(((CloudSearch.Query) this.d).getBound().getCity());
                sb.append("&city=");
                sb.append(b);
            }
        }
        sb.append("&tableid=" + ((CloudSearch.Query) this.d).getTableID());
        if (!nl.a(f())) {
            f();
            String b2 = b(f());
            sb.append("&filter=");
            sb.append(b2);
        }
        if (!nl.a(e())) {
            sb.append("&sortrule=");
            sb.append(e());
        }
        String b3 = b(((CloudSearch.Query) this.d).getQueryString());
        if (((CloudSearch.Query) this.d).getQueryString() == null || ((CloudSearch.Query) this.d).getQueryString().equals("")) {
            sb.append("&keywords=");
        } else {
            sb.append("&keywords=" + b3);
        }
        sb.append("&limit=" + ((CloudSearch.Query) this.d).getPageSize());
        sb.append("&page=" + ((CloudSearch.Query) this.d).getPageNum());
        sb.append("&key=" + qy.f(this.g));
        return sb.toString();
    }

    private String e() {
        if (((CloudSearch.Query) this.d).getSortingrules() != null) {
            return ((CloudSearch.Query) this.d).getSortingrules().toString();
        }
        return "";
    }

    private String f() {
        StringBuffer stringBuffer = new StringBuffer();
        String filterString = ((CloudSearch.Query) this.d).getFilterString();
        String filterNumString = ((CloudSearch.Query) this.d).getFilterNumString();
        stringBuffer.append(filterString);
        if (!nl.a(filterString) && !nl.a(filterNumString)) {
            stringBuffer.append("+");
        }
        stringBuffer.append(filterNumString);
        return stringBuffer.toString();
    }
}
