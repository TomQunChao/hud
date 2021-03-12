package com.amap.api.track;

import android.app.Notification;
import android.os.Parcel;
import android.os.Parcelable;

public final class TrackParam implements Parcelable {
    public static final Parcelable.Creator<TrackParam> CREATOR = new Parcelable.Creator<TrackParam>() {
        /* class com.amap.api.track.TrackParam.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TrackParam createFromParcel(Parcel parcel) {
            return new TrackParam(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TrackParam[] newArray(int i) {
            return new TrackParam[i];
        }
    };
    private long a;
    private long b;
    private long c;
    private String d;
    private Notification e;

    public TrackParam(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public final boolean isServiceValid() {
        return this.a > 0;
    }

    public final boolean isTerminalValid() {
        return this.b > 0;
    }

    public final long getSid() {
        return this.a;
    }

    public final long getTid() {
        return this.b;
    }

    public final long getTrackId() {
        return this.c;
    }

    public final void setTrackId(long j) {
        this.c = j;
    }

    public final Notification getNotification() {
        return this.e;
    }

    public final void setNotification(Notification notification) {
        this.e = notification;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeLong(this.b);
        parcel.writeLong(this.c);
        parcel.writeString(this.d);
        parcel.writeParcelable(this.e, i);
    }

    protected TrackParam(Parcel parcel) {
        this.a = parcel.readLong();
        this.b = parcel.readLong();
        this.c = parcel.readLong();
        this.d = parcel.readString();
        this.e = (Notification) parcel.readParcelable(Notification.class.getClassLoader());
    }
}
