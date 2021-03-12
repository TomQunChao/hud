package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.traffic.CircleTrafficQuery;
import com.amap.api.services.traffic.TrafficStatusResult;

/* compiled from: CircleTrafficSearchHandler */
public final class ng extends nd<CircleTrafficQuery, TrafficStatusResult> {
    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nc
    public final /* synthetic */ Object a(String str) throws AMapException {
        return nr.h(str);
    }

    public ng(Context context, CircleTrafficQuery circleTrafficQuery) {
        super(context, circleTrafficQuery);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nd
    public final String d() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(qy.f(this.g));
        if (((CircleTrafficQuery) this.d).getCenterPoint() != null) {
            stringBuffer.append("&location=");
            stringBuffer.append(nl.a(((CircleTrafficQuery) this.d).getCenterPoint()));
        }
        stringBuffer.append("&radius=");
        stringBuffer.append(((CircleTrafficQuery) this.d).getRadius());
        stringBuffer.append("&level=");
        stringBuffer.append(((CircleTrafficQuery) this.d).getLevel());
        stringBuffer.append("&extensions=all");
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return nk.a() + "/traffic/status/circle?";
    }
}
