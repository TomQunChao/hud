package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.RouteSearch;

/* compiled from: BusRouteSearchHandler */
public final class ne extends nd<RouteSearch.BusRouteQuery, BusRouteResult> {
    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nc
    public final /* bridge */ /* synthetic */ Object a(String str) throws AMapException {
        return nr.a(str);
    }

    public ne(Context context, RouteSearch.BusRouteQuery busRouteQuery) {
        super(context, busRouteQuery);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nd
    public final String d() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(qy.f(this.g));
        stringBuffer.append("&origin=");
        stringBuffer.append(nl.a(((RouteSearch.BusRouteQuery) this.d).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(nl.a(((RouteSearch.BusRouteQuery) this.d).getFromAndTo().getTo()));
        String city = ((RouteSearch.BusRouteQuery) this.d).getCity();
        if (!nr.f(city)) {
            city = b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(city);
        }
        if (!nr.f(((RouteSearch.BusRouteQuery) this.d).getCity())) {
            String b = b(city);
            stringBuffer.append("&cityd=");
            stringBuffer.append(b);
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearch.BusRouteQuery) this.d).getMode());
        stringBuffer.append(sb.toString());
        stringBuffer.append("&nightflag=");
        stringBuffer.append(((RouteSearch.BusRouteQuery) this.d).getNightFlag());
        stringBuffer.append("&extensions=all");
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return nk.a() + "/direction/transit/integrated?";
    }
}
