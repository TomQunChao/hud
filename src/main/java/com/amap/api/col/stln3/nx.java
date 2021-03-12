package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.UploadInfo;

/* compiled from: NearbyUpdateHandler */
public final class nx extends nd<UploadInfo, Integer> {
    private Context i;
    private UploadInfo j;

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nc
    public final /* synthetic */ Object a(String str) throws AMapException {
        return 0;
    }

    public nx(Context context, UploadInfo uploadInfo) {
        super(context, uploadInfo);
        this.i = context;
        this.j = uploadInfo;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nd
    public final String d() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(qy.f(this.i));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.j.getUserID());
        LatLonPoint point = this.j.getPoint();
        stringBuffer.append("&location=");
        stringBuffer.append(((float) ((int) (point.getLongitude() * 1000000.0d))) / 1000000.0f);
        stringBuffer.append(",");
        stringBuffer.append(((float) ((int) (point.getLatitude() * 1000000.0d))) / 1000000.0f);
        stringBuffer.append("&coordtype=");
        stringBuffer.append(this.j.getCoordType());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return nk.c() + "/nearby/data/create";
    }
}
