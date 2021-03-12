package com.amap.api.track.query.model;

import android.text.TextUtils;
import com.amap.api.col.stln3.qe;
import com.amap.api.col.stln3.qf;
import java.util.Map;

public final class AddTrackRequest extends qf {
    private long d;
    private long e;
    private String f;

    public AddTrackRequest(long j, long j2) {
        this.d = j;
        this.e = j2;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.qf
    public final int getUrl() {
        return 302;
    }

    @Override // com.amap.api.col.stln3.qf
    public final Map<String, String> getRequestParams() {
        qe a = new qe().a("tid", this.e).a("sid", this.d);
        String str = this.f;
        return a.a("trname", str, !TextUtils.isEmpty(str)).a();
    }
}
