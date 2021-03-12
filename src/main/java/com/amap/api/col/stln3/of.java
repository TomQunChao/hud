package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;

/* compiled from: RideRouteSearchHandler */
public final class of extends nd<RouteSearch.RideRouteQuery, RideRouteResult> {
    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nc
    public final /* synthetic */ Object a(String str) throws AMapException {
        return nr.g(str);
    }

    public of(Context context, RouteSearch.RideRouteQuery rideRouteQuery) {
        super(context, rideRouteQuery);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nd
    public final String d() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(qy.f(this.g));
        stringBuffer.append("&origin=");
        stringBuffer.append(nl.a(((RouteSearch.RideRouteQuery) this.d).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(nl.a(((RouteSearch.RideRouteQuery) this.d).getFromAndTo().getTo()));
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return nk.b() + "/direction/bicycling?";
    }
}
