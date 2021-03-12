package com.amap.api.track.query.model;

import android.text.TextUtils;
import com.amap.api.col.stln3.qe;
import com.amap.api.col.stln3.qf;
import com.amap.api.track.query.entity.AccuracyMode;
import com.amap.api.track.query.entity.CorrectMode;
import java.util.HashMap;

public final class LatestPointRequest extends qf {
    private long d;
    private long e;
    private long f;
    private String g;
    private int h;
    private String i;

    public LatestPointRequest(long j, long j2) {
        this(j, j2, -1);
    }

    public LatestPointRequest(long j, long j2, long j3) {
        this(j, j2, j3, -1, "");
    }

    public LatestPointRequest(long j, long j2, long j3, int i2, String str) {
        this.i = "";
        this.d = j;
        this.e = j2;
        this.f = j3;
        this.h = i2;
        this.i = str;
    }

    @Override // com.amap.api.col.stln3.qf
    public final int getUrl() {
        return 201;
    }

    @Override // com.amap.api.col.stln3.qf
    public final HashMap<String, String> getRequestParams() {
        qe qeVar = new qe();
        StringBuilder sb = new StringBuilder();
        sb.append(this.d);
        qe a = qeVar.a("sid", sb.toString());
        long j = this.e;
        boolean z = false;
        qe a2 = a.a("tid", j, j > 0);
        long j2 = this.f;
        if (j2 > 0) {
            z = true;
        }
        qe a3 = a2.a("trid", j2, z);
        String str = this.g;
        qe a4 = a3.a("trname", str, !TextUtils.isEmpty(str)).a("correction", CorrectMode.getMode(this.h));
        String str2 = this.i;
        return a4.a("accuracy", str2, AccuracyMode.isValid(str2)).a();
    }

    @Override // com.amap.api.col.stln3.qf
    public final int getMethod() {
        return 0;
    }
}
