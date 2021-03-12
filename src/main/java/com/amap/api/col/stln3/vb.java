package com.amap.api.col.stln3;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.services.geocoder.GeocodeSearch;

/* compiled from: LocFilter */
public final class vb {
    vc a = null;
    long b = 0;
    long c = 0;
    int d = 0;
    long e = 0;
    AMapLocation f = null;
    long g = 0;
    private boolean h = true;

    public final void a() {
        this.a = null;
        this.b = 0;
        this.c = 0;
        this.f = null;
        this.g = 0;
    }

    public final vc a(vc vcVar) {
        if (wc.b() - this.e > 30000) {
            this.a = vcVar;
            this.e = wc.b();
            return this.a;
        }
        this.e = wc.b();
        if (!wc.a(this.a) || !wc.a(vcVar)) {
            this.b = wc.b();
            this.a = vcVar;
            return this.a;
        } else if (vcVar.getTime() == this.a.getTime() && vcVar.getAccuracy() < 300.0f) {
            return vcVar;
        } else {
            if (vcVar.getProvider().equals(GeocodeSearch.GPS)) {
                this.b = wc.b();
                this.a = vcVar;
                return this.a;
            } else if (vcVar.c() != this.a.c()) {
                this.b = wc.b();
                this.a = vcVar;
                return this.a;
            } else if (vcVar.getBuildingId().equals(this.a.getBuildingId()) || TextUtils.isEmpty(vcVar.getBuildingId())) {
                this.d = vcVar.getLocationType();
                float a2 = wc.a(vcVar, this.a);
                float accuracy = this.a.getAccuracy();
                float accuracy2 = vcVar.getAccuracy();
                float f2 = accuracy2 - accuracy;
                long b2 = wc.b();
                long j = b2 - this.b;
                boolean z = false;
                boolean z2 = accuracy <= 100.0f && accuracy2 > 299.0f;
                int i = (accuracy > 299.0f ? 1 : (accuracy == 299.0f ? 0 : -1));
                if (i > 0 && accuracy2 > 299.0f) {
                    z = true;
                }
                if (z2 || z) {
                    long j2 = this.c;
                    if (j2 == 0) {
                        this.c = b2;
                    } else if (b2 - j2 > 30000) {
                        this.b = b2;
                        this.a = vcVar;
                        this.c = 0;
                        return this.a;
                    }
                    this.a = b(this.a);
                    return this.a;
                } else if (accuracy2 >= 100.0f || i <= 0) {
                    if (accuracy2 <= 299.0f) {
                        this.c = 0;
                    }
                    if (a2 >= 10.0f || ((double) a2) <= 0.1d || accuracy2 <= 5.0f) {
                        if (f2 < 300.0f) {
                            this.b = wc.b();
                            this.a = vcVar;
                            return this.a;
                        } else if (j >= 30000) {
                            this.b = wc.b();
                            this.a = vcVar;
                            return this.a;
                        } else {
                            this.a = b(this.a);
                            return this.a;
                        }
                    } else if (f2 >= -300.0f) {
                        this.a = b(this.a);
                        return this.a;
                    } else if (accuracy / accuracy2 >= 2.0f) {
                        this.b = b2;
                        this.a = vcVar;
                        return this.a;
                    } else {
                        this.a = b(this.a);
                        return this.a;
                    }
                } else {
                    this.b = b2;
                    this.a = vcVar;
                    this.c = 0;
                    return this.a;
                }
            } else {
                this.b = wc.b();
                this.a = vcVar;
                return this.a;
            }
        }
    }

    private vc b(vc vcVar) {
        if (wc.a(vcVar)) {
            if (!this.h || !vt.b(vcVar.getTime())) {
                vcVar.setLocationType(this.d);
            } else if (vcVar.getLocationType() == 5 || vcVar.getLocationType() == 6) {
                vcVar.setLocationType(4);
            }
        }
        return vcVar;
    }

    public final void a(boolean z) {
        this.h = z;
    }

    public final AMapLocation a(AMapLocation aMapLocation) {
        if (!wc.a(aMapLocation)) {
            return aMapLocation;
        }
        long b2 = wc.b() - this.g;
        this.g = wc.b();
        if (b2 > 5000) {
            return aMapLocation;
        }
        AMapLocation aMapLocation2 = this.f;
        if (aMapLocation2 == null) {
            this.f = aMapLocation;
            return aMapLocation;
        } else if (1 != aMapLocation2.getLocationType() && !GeocodeSearch.GPS.equalsIgnoreCase(this.f.getProvider())) {
            this.f = aMapLocation;
            return aMapLocation;
        } else if (this.f.getAltitude() == aMapLocation.getAltitude() && this.f.getLongitude() == aMapLocation.getLongitude()) {
            this.f = aMapLocation;
            return aMapLocation;
        } else {
            long abs = Math.abs(aMapLocation.getTime() - this.f.getTime());
            if (30000 < abs) {
                this.f = aMapLocation;
                return aMapLocation;
            } else if (wc.a(aMapLocation, this.f) > (((this.f.getSpeed() + aMapLocation.getSpeed()) * ((float) abs)) / 2000.0f) + ((this.f.getAccuracy() + aMapLocation.getAccuracy()) * 2.0f) + 3000.0f) {
                return this.f;
            } else {
                this.f = aMapLocation;
                return aMapLocation;
            }
        }
    }
}
