package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.services.core.AMapException;

/* compiled from: NearbyDeleteHandler */
public final class nv extends nd<String, Integer> {
    private Context i;
    private String j;

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nc
    public final /* synthetic */ Object a(String str) throws AMapException {
        return 0;
    }

    public nv(Context context, String str) {
        super(context, str);
        this.i = context;
        this.j = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nd
    public final String d() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(qy.f(this.i));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.j);
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return nk.c() + "/nearby/data/delete";
    }
}
