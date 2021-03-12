package com.amap.api.col.stln3;

import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.core.AMapException;
import com.amap.api.track.query.entity.LocationMode;

/* compiled from: LocalOption */
public final class qq {
    private long a;
    private long b;
    private String c;
    private int d;
    private long e;
    private long f = 2000;
    private long g = 30000;
    private long h = 12000;
    private AMapLocationClientOption.AMapLocationMode i = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
    private int j = 100;
    private int k;

    public final int a() {
        return this.k * AMapException.CODE_AMAP_SHARE_LICENSE_IS_EXPIRED;
    }

    public final long b() {
        return this.e;
    }

    public qq(long j2, long j3, long j4, long j5, long j6, int i2, int i3, int i4) {
        this.a = j2;
        this.e = j3;
        this.f = j5;
        this.h = j6;
        this.k = i3;
        this.b = j4;
        this.c = null;
        this.d = i4;
        this.i = LocationMode.getLocationMode(i2);
    }

    public final long c() {
        long j2 = this.f;
        if (j2 < 1000) {
            return 1000;
        }
        if (j2 > 60000) {
            return 60000;
        }
        return j2;
    }

    public final long d() {
        long j2 = this.h;
        if (j2 < 5000) {
            return 5000;
        }
        if (j2 > 3000000) {
            return 3000000;
        }
        return j2;
    }

    public final int e() {
        return this.j;
    }

    public final long f() {
        return this.a;
    }

    public final void a(long j2) {
        this.b = j2;
    }

    public final long g() {
        return this.b;
    }

    public final String h() {
        return this.c;
    }

    public final void a(String str) {
        this.c = str;
    }

    public final boolean a(long j2, long j3) {
        return this.a == j3 && this.e == j2;
    }

    public final int i() {
        return this.d;
    }

    public final AMapLocationClientOption j() {
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setLocationMode(this.i);
        aMapLocationClientOption.setInterval(c());
        aMapLocationClientOption.setMockEnable(false);
        aMapLocationClientOption.setHttpTimeOut(this.g);
        return aMapLocationClientOption;
    }
}
