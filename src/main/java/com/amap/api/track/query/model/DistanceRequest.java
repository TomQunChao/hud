package com.amap.api.track.query.model;

import android.text.TextUtils;
import com.amap.api.col.stln3.qe;
import com.amap.api.col.stln3.qf;
import com.amap.api.track.query.entity.CorrectMode;
import com.amap.api.track.query.entity.RecoupMode;
import java.util.Map;

public final class DistanceRequest extends qf {
    private long d;
    private long e;
    private long f;
    private String g;
    private long h;
    private long i;
    private int j;
    private int k;
    private int l;

    public DistanceRequest(long j2, long j3, long j4, long j5, long j6) {
        this(j2, j3, j4, j5, j6, -1, -1, -1);
    }

    public DistanceRequest(long j2, long j3, long j4, long j5, long j6, int i2, int i3, int i4) {
        this.d = j2;
        this.e = j3;
        this.h = j4;
        this.i = j5;
        this.f = j6;
        this.j = i2;
        this.k = i3;
        this.l = i4;
    }

    @Override // com.amap.api.col.stln3.qf
    public final int getUrl() {
        return 202;
    }

    @Override // com.amap.api.col.stln3.qf
    public final int getMethod() {
        return 0;
    }

    @Override // com.amap.api.col.stln3.qf
    public final Map<String, String> getRequestParams() {
        qe a = new qe().a("sid", this.d).a("tid", this.e);
        int i2 = this.l;
        boolean z = false;
        qe a2 = a.a("gap", i2, i2 >= 50 && i2 <= 10000).a("starttime", this.h).a("endtime", this.i);
        long j2 = this.f;
        qe a3 = a2.a("trid", j2, j2 > 0);
        String str = this.g;
        qe a4 = a3.a("trname", str, !TextUtils.isEmpty(str)).a("correction", CorrectMode.getMode(this.j), !TextUtils.isEmpty(CorrectMode.getMode(this.j)));
        int mode = RecoupMode.getMode(this.k);
        if (RecoupMode.getMode(this.k) >= 0) {
            z = true;
        }
        return a4.a("recoup", mode, z).a();
    }
}
