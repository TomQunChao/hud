package com.amap.api.track.query.model;

import com.amap.api.col.stln3.qe;
import com.amap.api.col.stln3.qf;
import com.amap.api.track.query.entity.AccuracyMode;
import com.amap.api.track.query.entity.CorrectMode;
import com.amap.api.track.query.entity.OrderMode;
import com.amap.api.track.query.entity.RecoupMode;
import java.util.Map;

public final class HistoryTrackRequest extends qf {
    private long d;
    private long e;
    private long f;
    private long g;
    private int h;
    private int i;
    private int j = 5000;
    private int k;
    private int l;
    private int m;
    private String n = "";

    public HistoryTrackRequest(long j2, long j3, long j4, long j5) {
        this.d = j2;
        this.e = j3;
        this.f = j4;
        this.g = j5;
    }

    public HistoryTrackRequest(long j2, long j3, long j4, long j5, int i2, int i3, int i4, int i5, int i6, int i7, String str) {
        this.d = j2;
        this.e = j3;
        this.f = j4;
        this.g = j5;
        this.h = i2;
        this.i = i3;
        this.j = i4;
        this.k = i5;
        this.l = i6;
        this.m = i7;
        this.n = str;
    }

    @Override // com.amap.api.col.stln3.qf
    public final int getUrl() {
        return 203;
    }

    @Override // com.amap.api.col.stln3.qf
    public final Map<String, String> getRequestParams() {
        qe a = new qe().a("sid", this.d).a("tid", this.e).a("starttime", this.f).a("endtime", this.g).a("correction", CorrectMode.getMode(this.h)).a("recoup", RecoupMode.getMode(this.i));
        int i2 = this.j;
        boolean z = true;
        qe a2 = a.a("gap", i2, i2 >= 50 && i2 <= 10000).a("order", OrderMode.getMode(this.k));
        int i3 = this.l;
        qe a3 = a2.a("page", i3, i3 > 0);
        int i4 = this.m;
        if (i4 <= 0 || i4 >= 1000) {
            z = false;
        }
        qe a4 = a3.a("pagesize", i4, z);
        String str = this.n;
        return a4.a("accuracy", str, AccuracyMode.isValid(str)).a();
    }

    @Override // com.amap.api.col.stln3.qf
    public final int getMethod() {
        return 0;
    }
}
