package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: BusSearchServerHandler */
public final class nf<T> extends nd<T, Object> {
    private int i = 0;
    private List<String> j = new ArrayList();
    private List<SuggestionCity> k = new ArrayList();

    public nf(Context context, T t) {
        super(context, t);
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        String str = "";
        if (!(this.d instanceof BusLineQuery)) {
            str = "stopname";
        } else if (((BusLineQuery) this.d).getCategory() == BusLineQuery.SearchType.BY_LINE_ID) {
            str = "lineid";
        } else if (((BusLineQuery) this.d).getCategory() == BusLineQuery.SearchType.BY_LINE_NAME) {
            str = "linename";
        }
        return nk.a() + "/bus/" + str + "?";
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nc
    public final Object a(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
            if (optJSONObject != null) {
                this.k = nr.a(optJSONObject);
                this.j = nr.b(optJSONObject);
            }
            this.i = jSONObject.optInt("count");
            if (this.d instanceof BusLineQuery) {
                return BusLineResult.createPagedResult((BusLineQuery) this.d, this.i, this.k, this.j, nr.f(jSONObject));
            }
            return BusStationResult.createPagedResult((BusStationQuery) this.d, this.i, this.k, this.j, nr.e(jSONObject));
        } catch (Exception e) {
            nl.a(e, "BusSearchServerHandler", "paseJSON");
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nd
    public final String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        if (this.d instanceof BusLineQuery) {
            BusLineQuery busLineQuery = (BusLineQuery) this.d;
            sb.append("&extensions=all");
            if (busLineQuery.getCategory() == BusLineQuery.SearchType.BY_LINE_ID) {
                sb.append("&id=");
                sb.append(b(((BusLineQuery) this.d).getQueryString()));
            } else {
                String city = busLineQuery.getCity();
                if (!nr.f(city)) {
                    String b = b(city);
                    sb.append("&city=");
                    sb.append(b);
                }
                sb.append("&keywords=" + b(busLineQuery.getQueryString()));
                sb.append("&offset=" + busLineQuery.getPageSize());
                sb.append("&page=" + busLineQuery.getPageNumber());
            }
        } else {
            BusStationQuery busStationQuery = (BusStationQuery) this.d;
            String city2 = busStationQuery.getCity();
            if (!nr.f(city2)) {
                String b2 = b(city2);
                sb.append("&city=");
                sb.append(b2);
            }
            sb.append("&keywords=" + b(busStationQuery.getQueryString()));
            sb.append("&offset=" + busStationQuery.getPageSize());
            sb.append("&page=" + busStationQuery.getPageNumber());
        }
        sb.append("&key=" + qy.f(this.g));
        return sb.toString();
    }
}
