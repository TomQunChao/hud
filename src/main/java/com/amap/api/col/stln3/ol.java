package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;

/* compiled from: TruckRouteSearchHandler */
public final class ol extends nd<RouteSearch.TruckRouteQuery, TruckRouteRestult> {
    private final String i = "/direction/truck?";
    private final String j = "|";
    private final String k = ",";

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nc
    public final /* synthetic */ Object a(String str) throws AMapException {
        return nr.j(str);
    }

    public ol(Context context, RouteSearch.TruckRouteQuery truckRouteQuery) {
        super(context, truckRouteQuery);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nd
    public final String d() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(qy.f(this.g));
        if (((RouteSearch.TruckRouteQuery) this.d).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(nl.a(((RouteSearch.TruckRouteQuery) this.d).getFromAndTo().getFrom()));
            if (!nr.f(((RouteSearch.TruckRouteQuery) this.d).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.d).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(nl.a(((RouteSearch.TruckRouteQuery) this.d).getFromAndTo().getTo()));
            if (!nr.f(((RouteSearch.TruckRouteQuery) this.d).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.d).getFromAndTo().getDestinationPoiID());
            }
            if (!nr.f(((RouteSearch.TruckRouteQuery) this.d).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.d).getFromAndTo().getOriginType());
            }
            if (!nr.f(((RouteSearch.TruckRouteQuery) this.d).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.d).getFromAndTo().getDestinationType());
            }
            if (!nr.f(((RouteSearch.TruckRouteQuery) this.d).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.d).getFromAndTo().getPlateProvince());
            }
            if (!nr.f(((RouteSearch.TruckRouteQuery) this.d).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.d).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.d).getMode());
        if (((RouteSearch.TruckRouteQuery) this.d).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearch.TruckRouteQuery) this.d).getPassedPointStr());
        }
        stringBuffer.append("&size=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.d).getTruckSize());
        stringBuffer.append("&height=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.d).getTruckHeight());
        stringBuffer.append("&width=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.d).getTruckWidth());
        stringBuffer.append("&load=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.d).getTruckLoad());
        stringBuffer.append("&weight=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.d).getTruckWeight());
        stringBuffer.append("&axis=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.d).getTruckAxis());
        stringBuffer.append("&extensions=all");
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return nk.b() + "/direction/truck?";
    }
}
