package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RouteSearch;

/* compiled from: DriveRouteSearchHandler */
public final class no extends nd<RouteSearch.DriveRouteQuery, DriveRouteResult> {
    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nc
    public final /* synthetic */ Object a(String str) throws AMapException {
        return nr.b(str);
    }

    public no(Context context, RouteSearch.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nd
    public final String d() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(qy.f(this.g));
        if (((RouteSearch.DriveRouteQuery) this.d).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(nl.a(((RouteSearch.DriveRouteQuery) this.d).getFromAndTo().getFrom()));
            if (!nr.f(((RouteSearch.DriveRouteQuery) this.d).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.d).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(nl.a(((RouteSearch.DriveRouteQuery) this.d).getFromAndTo().getTo()));
            if (!nr.f(((RouteSearch.DriveRouteQuery) this.d).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.d).getFromAndTo().getDestinationPoiID());
            }
            if (!nr.f(((RouteSearch.DriveRouteQuery) this.d).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.d).getFromAndTo().getOriginType());
            }
            if (!nr.f(((RouteSearch.DriveRouteQuery) this.d).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.d).getFromAndTo().getDestinationType());
            }
            if (!nr.f(((RouteSearch.DriveRouteQuery) this.d).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.d).getFromAndTo().getPlateProvince());
            }
            if (!nr.f(((RouteSearch.DriveRouteQuery) this.d).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.d).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearch.DriveRouteQuery) this.d).getMode());
        stringBuffer.append(sb.toString());
        stringBuffer.append("&extensions=all");
        stringBuffer.append("&ferry=");
        stringBuffer.append(!((RouteSearch.DriveRouteQuery) this.d).isUseFerry());
        if (((RouteSearch.DriveRouteQuery) this.d).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.d).getPassedPointStr());
        }
        if (((RouteSearch.DriveRouteQuery) this.d).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.d).getAvoidpolygonsStr());
        }
        if (((RouteSearch.DriveRouteQuery) this.d).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=");
            stringBuffer.append(b(((RouteSearch.DriveRouteQuery) this.d).getAvoidRoad()));
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return nk.a() + "/direction/driving?";
    }
}
