package com.amap.api.track.query.model;

import android.text.TextUtils;
import com.amap.api.col.stln3.qe;
import com.amap.api.col.stln3.qf;
import com.amap.api.track.query.entity.DriveMode;
import com.amap.api.track.query.entity.RecoupMode;
import java.util.Map;

public final class QueryTrackRequest extends qf {
    private long d;
    private long e;
    private long f;
    private String g;
    private long h;
    private long i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o = 5000;
    private int p = 1;
    private int q;
    private int r;

    public QueryTrackRequest(long j2, long j3, long j4, long j5) {
        this.d = j2;
        this.e = j3;
        this.h = j4;
        this.i = j5;
    }

    public QueryTrackRequest(long j2, long j3, long j4, long j5, long j6) {
        this.d = j2;
        this.e = j3;
        this.f = j4;
        this.h = j5;
        this.i = j6;
    }

    public QueryTrackRequest(long j2, long j3, long j4, long j5, long j6, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.d = j2;
        this.e = j3;
        this.f = j4;
        this.h = j5;
        this.i = j6;
        this.j = i2;
        this.k = i3;
        this.l = i4;
        this.m = i5;
        this.n = i6;
        this.o = i7;
        this.p = i8;
        this.q = i9;
        this.r = i10;
    }

    @Override // com.amap.api.col.stln3.qf
    public final int getMethod() {
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.qf
    public final int getUrl() {
        return 306;
    }

    @Override // com.amap.api.col.stln3.qf
    public final Map<String, String> getRequestParams() {
        String str = "denoise=" + this.j + ",mapmatch=" + this.k + ",threshold=" + this.l + ",mode=" + DriveMode.getDriveMode(this.m);
        qe a = new qe().a("sid", this.d).a("tid", this.e).a("starttime", this.h).a("endtime", this.i);
        long j2 = this.f;
        boolean z = false;
        qe a2 = a.a("trid", j2, j2 > 0);
        int i2 = this.n;
        qe a3 = a2.a("recoup", i2, RecoupMode.isValid(i2));
        String str2 = this.g;
        qe a4 = a3.a("trname", str2, !TextUtils.isEmpty(str2)).a("correction", str);
        int i3 = this.p;
        qe a5 = a4.a("ispoints", i3, i3 >= 0);
        int i4 = this.q;
        qe a6 = a5.a("page", i4, i4 > 0);
        int i5 = this.r;
        qe a7 = a6.a("pagesize", i5, i5 > 0);
        int i6 = this.o;
        if (i6 >= 0) {
            z = true;
        }
        return a7.a("gap", i6, z).a();
    }
}
