package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import java.util.List;

/* compiled from: DistanceSearchHandler */
public final class nm extends nd<DistanceSearch.DistanceQuery, DistanceResult> {
    private final String i = "/distance?";
    private final String j = "|";
    private final String k = ",";

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nc
    public final /* synthetic */ Object a(String str) throws AMapException {
        return nr.i(str);
    }

    public nm(Context context, DistanceSearch.DistanceQuery distanceQuery) {
        super(context, distanceQuery);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nd
    public final String d() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(qy.f(this.g));
        List<LatLonPoint> origins = ((DistanceSearch.DistanceQuery) this.d).getOrigins();
        if (origins != null && origins.size() > 0) {
            stringBuffer.append("&origins=");
            int size = origins.size();
            for (int i2 = 0; i2 < size; i2++) {
                LatLonPoint latLonPoint = origins.get(i2);
                if (latLonPoint != null) {
                    double a = nl.a(latLonPoint.getLatitude());
                    stringBuffer.append(nl.a(latLonPoint.getLongitude()));
                    stringBuffer.append(",");
                    stringBuffer.append(a);
                    if (i2 < size) {
                        stringBuffer.append("|");
                    }
                }
            }
        }
        LatLonPoint destination = ((DistanceSearch.DistanceQuery) this.d).getDestination();
        if (destination != null) {
            double a2 = nl.a(destination.getLatitude());
            double a3 = nl.a(destination.getLongitude());
            stringBuffer.append("&destination=");
            stringBuffer.append(a3);
            stringBuffer.append(",");
            stringBuffer.append(a2);
        }
        stringBuffer.append("&type=");
        stringBuffer.append(((DistanceSearch.DistanceQuery) this.d).getType());
        stringBuffer.append("&extensions=all");
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return nk.a() + "/distance?";
    }
}
