package com.amap.api.track;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.idst.nls.internal.connector.NetDefine;
import com.amap.api.col.stln3.qq;
import com.amap.api.services.core.AMapException;

/* compiled from: TrackOption */
public final class f implements Parcelable {
    public static final Parcelable.Creator<f> g = new Parcelable.Creator<f>() {
        /* class com.amap.api.track.f.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ f[] newArray(int i) {
            return new f[i];
        }
    };
    int a = 50;
    int b = AMapException.CODE_AMAP_SERVICE_TABLEID_NOT_EXIST;
    int c = NetDefine.HTTP_READ_TIMEOUT;
    int d = 1;
    int e = 0;
    c f;

    private f() {
    }

    public static f a() {
        return new f();
    }

    public final void a(int i) {
        this.a = a(i, 5, 50);
    }

    public final void a(int i, int i2) {
        int a2 = a(i, 1, 60);
        if (a2 > 15) {
            a2 = (a2 / 5) * 5;
        }
        this.b = a2;
        this.c = a(i2, a2 * 5, a2 * 50);
        int i3 = this.c;
        int i4 = this.b;
        this.c = (i3 / i4) * i4;
        this.b = i4 * 1000;
        this.c *= 1000;
    }

    public final void b(int i) {
        this.d = i;
    }

    public final void c(int i) {
        this.e = i;
    }

    public final c b() {
        return this.f;
    }

    public final void a(c cVar) {
        this.f = cVar;
    }

    public static qq a(TrackParam trackParam, f fVar) {
        if (trackParam == null) {
            return null;
        }
        return new qq(trackParam.getTid(), trackParam.getSid(), trackParam.getTrackId(), (long) fVar.b, (long) fVar.c, fVar.d, fVar.a, fVar.e);
    }

    private static int a(int i, int i2, int i3) {
        if (i < i2) {
            return i2;
        }
        if (i > i3) {
            return i3;
        }
        return i;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
    }

    protected f(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
    }
}
