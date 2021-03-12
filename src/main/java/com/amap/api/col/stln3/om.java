package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkRouteResult;

/* compiled from: WalkRouteSearchHandler */
public final class om extends nd<RouteSearch.WalkRouteQuery, WalkRouteResult> {
    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nc
    public final /* synthetic */ Object a(String str) throws AMapException {
        return nr.c(str);
    }

    public om(Context context, RouteSearch.WalkRouteQuery walkRouteQuery) {
        super(context, walkRouteQuery);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nd
    public final String d() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(qy.f(this.g));
        stringBuffer.append("&origin=");
        stringBuffer.append(nl.a(((RouteSearch.WalkRouteQuery) this.d).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(nl.a(((RouteSearch.WalkRouteQuery) this.d).getFromAndTo().getTo()));
        stringBuffer.append("&multipath=0");
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return nk.a() + "/direction/walking?";
    }
}
