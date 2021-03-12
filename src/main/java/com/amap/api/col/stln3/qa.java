package com.amap.api.col.stln3;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;

/* compiled from: UploadPointRequest */
public final class qa extends qf {
    private long d;
    private long e;
    private long f;
    private String g;
    private List<pt> h = null;

    @Override // com.amap.api.col.stln3.qf
    public final /* synthetic */ Map getRequestParams() {
        String a = pt.a(this.h);
        qe a2 = new qe().a("tid", this.e).a("sid", this.d);
        long j = this.f;
        boolean z = true;
        qe a3 = a2.a("trid", j, j > 0);
        String str = this.g;
        if (TextUtils.isEmpty(str) || this.f > 0) {
            z = false;
        }
        return a3.a("trname", str, z).a("points", a).a();
    }

    public qa(long j, long j2, long j3, String str, List<pt> list) {
        this.h = list;
        this.e = j2;
        this.f = j3;
        this.d = j;
        this.g = str;
    }

    @Override // com.amap.api.col.stln3.qf
    public final boolean isOutputCipher() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.qf
    public final int getUrl() {
        return 301;
    }
}
