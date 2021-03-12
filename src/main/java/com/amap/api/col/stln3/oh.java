package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.routepoisearch.RoutePOIItem;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RoutePOISearchHandler */
public final class oh extends nd<RoutePOISearchQuery, RoutePOISearchResult> {
    public oh(Context context, RoutePOISearchQuery routePOISearchQuery) {
        super(context, routePOISearchQuery);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nd
    public final String d() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(qy.f(this.g));
        stringBuffer.append("&range=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RoutePOISearchQuery) this.d).getRange());
        stringBuffer.append(sb.toString());
        String str = "";
        try {
            switch (((RoutePOISearchQuery) this.d).getSearchType()) {
                case TypeGasStation:
                    str = "0101";
                    break;
                case TypeMaintenanceStation:
                    str = "0300";
                    break;
                case TypeATM:
                    str = "1603";
                    break;
                case TypeToilet:
                    str = "2003";
                    break;
                case TypeFillingStation:
                    str = "0103";
                    break;
                case TypeServiceArea:
                    str = "180301";
                    break;
            }
        } catch (Exception e) {
        }
        if (((RoutePOISearchQuery) this.d).getPolylines() == null || ((RoutePOISearchQuery) this.d).getPolylines().size() <= 0) {
            stringBuffer.append("&origin=");
            stringBuffer.append(nl.a(((RoutePOISearchQuery) this.d).getFrom()));
            stringBuffer.append("&destination=");
            stringBuffer.append(nl.a(((RoutePOISearchQuery) this.d).getTo()));
            stringBuffer.append("&strategy=");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(((RoutePOISearchQuery) this.d).getMode());
            stringBuffer.append(sb2.toString());
        } else {
            stringBuffer.append("&polyline=");
            stringBuffer.append(nl.a(((RoutePOISearchQuery) this.d).getPolylines()));
        }
        stringBuffer.append("&types=");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public RoutePOISearchResult a(String str) throws AMapException {
        ArrayList<RoutePOIItem> arrayList = new ArrayList<>();
        try {
            arrayList = nr.i(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new RoutePOISearchResult(arrayList, (RoutePOISearchQuery) this.d);
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return nk.a() + "/place/route?";
    }
}
