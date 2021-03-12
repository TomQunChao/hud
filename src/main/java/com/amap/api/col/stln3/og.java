package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.traffic.RoadTrafficQuery;
import com.amap.api.services.traffic.TrafficStatusResult;

/* compiled from: RoadTrafficSearchHandler */
public final class og extends nd<RoadTrafficQuery, TrafficStatusResult> {
    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nc
    public final /* synthetic */ Object a(String str) throws AMapException {
        return nr.h(str);
    }

    public og(Context context, RoadTrafficQuery roadTrafficQuery) {
        super(context, roadTrafficQuery);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nd
    public final String d() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(qy.f(this.g));
        if (!TextUtils.isEmpty(((RoadTrafficQuery) this.d).getName())) {
            stringBuffer.append("&name=");
            stringBuffer.append(((RoadTrafficQuery) this.d).getName());
        }
        if (!TextUtils.isEmpty(((RoadTrafficQuery) this.d).getAdCode())) {
            stringBuffer.append("&adcode=");
            stringBuffer.append(((RoadTrafficQuery) this.d).getAdCode());
        }
        stringBuffer.append("&level=");
        stringBuffer.append(((RoadTrafficQuery) this.d).getLevel());
        stringBuffer.append("&extensions=all");
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return nk.a() + "/traffic/status/road?";
    }
}
