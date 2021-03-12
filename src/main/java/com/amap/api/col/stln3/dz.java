package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.col.stln3.er;
import com.amap.api.col.stln3.fa;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import java.io.File;

/* compiled from: CityObject */
public final class dz extends OfflineMapCity implements ei, ez {
    public static final Parcelable.Creator<dz> o = new Parcelable.Creator<dz>() {
        /* class com.amap.api.col.stln3.dz.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ dz createFromParcel(Parcel parcel) {
            return new dz(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ dz[] newArray(int i) {
            return new dz[i];
        }
    };
    public final fd a;
    public final fd b;
    public final fd c;
    public final fd d;
    public final fd e;
    public final fd f;
    public final fd g;
    public final fd h;
    public final fd i;
    public final fd j;
    public final fd k;
    fd l;
    Context m;
    boolean n;
    private String p;
    private String q;
    private long r;

    public final void a(String str) {
        this.q = str;
    }

    public final String a() {
        return this.q;
    }

    @Override // com.amap.api.col.stln3.ei
    public final String b() {
        return getUrl();
    }

    public dz(Context context, OfflineMapCity offlineMapCity) {
        this(context, offlineMapCity.getState());
        setCity(offlineMapCity.getCity());
        setUrl(offlineMapCity.getUrl());
        setState(offlineMapCity.getState());
        setCompleteCode(offlineMapCity.getcompleteCode());
        setAdcode(offlineMapCity.getAdcode());
        setVersion(offlineMapCity.getVersion());
        setSize(offlineMapCity.getSize());
        setCode(offlineMapCity.getCode());
        setJianpin(offlineMapCity.getJianpin());
        setPinyin(offlineMapCity.getPinyin());
        s();
    }

    private dz(Context context, int i2) {
        this.a = new ff(this);
        this.b = new fm(this);
        this.c = new fi(this);
        this.d = new fk(this);
        this.e = new fl(this);
        this.f = new fe(this);
        this.g = new fj(this);
        this.h = new fg(-1, this);
        this.i = new fg(101, this);
        this.j = new fg(102, this);
        this.k = new fg(103, this);
        this.p = null;
        this.q = "";
        this.n = false;
        this.r = 0;
        this.m = context;
        a(i2);
    }

    public final void a(int i2) {
        switch (i2) {
            case -1:
                this.l = this.h;
                break;
            case 0:
                this.l = this.c;
                break;
            case 1:
                this.l = this.e;
                break;
            case 2:
                this.l = this.b;
                break;
            case 3:
                this.l = this.d;
                break;
            case 4:
                this.l = this.f;
                break;
            default:
                switch (i2) {
                    case 6:
                        this.l = this.a;
                        break;
                    case 7:
                        this.l = this.g;
                        break;
                    default:
                        switch (i2) {
                            case 101:
                                this.l = this.i;
                                break;
                            case 102:
                                this.l = this.j;
                                break;
                            case 103:
                                this.l = this.k;
                                break;
                            default:
                                if (i2 < 0) {
                                    this.l = this.h;
                                    break;
                                }
                                break;
                        }
                }
        }
        setState(i2);
    }

    public final void a(fd fdVar) {
        this.l = fdVar;
        setState(fdVar.b());
    }

    public final fd c() {
        return this.l;
    }

    public final void d() {
        ea a2 = ea.a(this.m);
        if (a2 != null) {
            a2.c(this);
        }
    }

    public final void e() {
        ea a2 = ea.a(this.m);
        if (a2 != null) {
            a2.e(this);
            d();
        }
    }

    public final void f() {
        String str = "CityOperation current State==>" + this.l.b();
        if (this.l.equals(this.d)) {
            this.l.d();
        } else if (this.l.equals(this.c)) {
            this.l.e();
        } else {
            boolean z = true;
            if (this.l.equals(this.g) || this.l.equals(this.h)) {
                ea a2 = ea.a(this.m);
                if (a2 != null) {
                    a2.a(this);
                }
                this.n = true;
                return;
            }
            if (!this.l.equals(this.j) && !this.l.equals(this.i)) {
                if (this.k.b() != this.l.b()) {
                    z = false;
                }
                if (!z) {
                    this.l.h();
                    return;
                }
            }
            this.l.c();
        }
    }

    public final void g() {
        this.l.e();
    }

    public final void h() {
        this.l.a(this.k.b());
    }

    public final void i() {
        this.l.a();
        if (this.n) {
            this.l.h();
        }
        this.n = false;
    }

    public final void j() {
        this.l.equals(this.f);
        this.l.f();
    }

    public final void k() {
        ea a2 = ea.a(this.m);
        if (a2 != null) {
            a2.b(this);
        }
    }

    public final void l() {
        ea a2 = ea.a(this.m);
        if (a2 != null) {
            a2.d(this);
        }
    }

    @Override // com.amap.api.col.stln3.fa
    public final void m() {
        this.r = 0;
        this.l.equals(this.b);
        this.l.c();
    }

    @Override // com.amap.api.col.stln3.fa
    public final void a(long j2, long j3) {
        int i2 = (int) ((j3 * 100) / j2);
        if (i2 != getcompleteCode()) {
            setCompleteCode(i2);
            d();
        }
    }

    @Override // com.amap.api.col.stln3.fa
    public final void n() {
        this.l.equals(this.c);
        this.l.g();
    }

    @Override // com.amap.api.col.stln3.fa
    public final void a(fa.a aVar) {
        int i2;
        switch (aVar) {
            case amap_exception:
                i2 = this.j.b();
                break;
            case file_io_exception:
                i2 = this.k.b();
                break;
            case network_exception:
                i2 = this.i.b();
                break;
            default:
                i2 = 6;
                break;
        }
        if (this.l.equals(this.c) || this.l.equals(this.b)) {
            this.l.a(i2);
        }
    }

    @Override // com.amap.api.col.stln3.fa
    public final void o() {
        e();
    }

    @Override // com.amap.api.col.stln3.es
    public final void p() {
        this.r = 0;
        setCompleteCode(0);
        this.l.equals(this.e);
        this.l.c();
    }

    @Override // com.amap.api.col.stln3.es
    public final void q() {
        this.l.equals(this.e);
        this.l.a(this.h.b());
    }

    @Override // com.amap.api.col.stln3.es
    public final void a(long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.r > 500) {
            int i2 = (int) j2;
            if (i2 > getcompleteCode()) {
                setCompleteCode(i2);
                d();
            }
            this.r = currentTimeMillis;
        }
    }

    @Override // com.amap.api.col.stln3.es
    public final void b(String str) {
        this.l.equals(this.e);
        this.q = str;
        final String z = z();
        String A = A();
        if (TextUtils.isEmpty(z) || TextUtils.isEmpty(A)) {
            q();
            return;
        }
        final File file = new File(A + "/");
        File file2 = new File(ic.a(this.m) + File.separator + "map/");
        File file3 = new File(ic.a(this.m));
        if (!file3.exists() && !file3.mkdir()) {
            return;
        }
        if (file2.exists() || file2.mkdir()) {
            new er().a(file, file2, -1, ex.a(file), new er.a() {
                /* class com.amap.api.col.stln3.dz.AnonymousClass1 */

                @Override // com.amap.api.col.stln3.er.a
                public final void a(float f) {
                    int i = (int) ((((double) f) * 0.39d) + 60.0d);
                    if (i - dz.this.getcompleteCode() > 0 && System.currentTimeMillis() - dz.this.r > 1000) {
                        dz.this.setCompleteCode(i);
                        dz.this.r = System.currentTimeMillis();
                    }
                }

                @Override // com.amap.api.col.stln3.er.a
                public final void a() {
                    try {
                        if (new File(z).delete()) {
                            ex.b(file);
                            dz.this.setCompleteCode(100);
                            dz.this.l.g();
                        }
                    } catch (Exception e) {
                        dz.this.l.a(dz.this.k.b());
                    }
                }

                @Override // com.amap.api.col.stln3.er.a
                public final void b() {
                    dz.this.l.a(dz.this.k.b());
                }
            });
        }
    }

    @Override // com.amap.api.col.stln3.es
    public final void r() {
        e();
    }

    /* access modifiers changed from: protected */
    public final void s() {
        String str = ea.a;
        String b2 = ex.b(getUrl());
        if (b2 != null) {
            this.p = str + b2 + ".zip.tmp";
            return;
        }
        this.p = str + getPinyin() + ".zip.tmp";
    }

    private String z() {
        if (TextUtils.isEmpty(this.p)) {
            return null;
        }
        String str = this.p;
        return str.substring(0, str.lastIndexOf("."));
    }

    private String A() {
        if (TextUtils.isEmpty(this.p)) {
            return null;
        }
        String z = z();
        return z.substring(0, z.lastIndexOf(46));
    }

    public final ek t() {
        setState(this.l.b());
        ek ekVar = new ek(this, this.m);
        ekVar.a(this.q);
        String str = "vMapFileNames: " + this.q;
        return ekVar;
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City
    public final int describeContents() {
        return 0;
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City
    public final void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.q);
    }

    public dz(Parcel parcel) {
        super(parcel);
        this.a = new ff(this);
        this.b = new fm(this);
        this.c = new fi(this);
        this.d = new fk(this);
        this.e = new fl(this);
        this.f = new fe(this);
        this.g = new fj(this);
        this.h = new fg(-1, this);
        this.i = new fg(101, this);
        this.j = new fg(102, this);
        this.k = new fg(103, this);
        this.p = null;
        this.q = "";
        this.n = false;
        this.r = 0;
        this.q = parcel.readString();
    }

    @Override // com.amap.api.col.stln3.ez
    public final boolean u() {
        ex.a();
        getSize();
        getcompleteCode();
        getSize();
        return false;
    }

    @Override // com.amap.api.col.stln3.ez
    public final String v() {
        StringBuffer stringBuffer = new StringBuffer();
        String b2 = ex.b(getUrl());
        if (b2 != null) {
            stringBuffer.append(b2);
        } else {
            stringBuffer.append(getPinyin());
        }
        stringBuffer.append(".zip");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.stln3.ez
    public final String w() {
        return getAdcode();
    }

    @Override // com.amap.api.col.stln3.et
    public final String x() {
        return z();
    }

    @Override // com.amap.api.col.stln3.et
    public final String y() {
        return A();
    }

    public final fd b(int i2) {
        switch (i2) {
            case 101:
                return this.i;
            case 102:
                return this.j;
            case 103:
                return this.k;
            default:
                return this.h;
        }
    }
}
