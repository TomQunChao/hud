package com.amap.api.col.stln3;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* compiled from: Tip */
public final class lw implements Parcelable, Serializable {
    public static final Parcelable.Creator<lw> a = new Parcelable.Creator<lw>() {
        /* class com.amap.api.col.stln3.lw.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ lw createFromParcel(Parcel parcel) {
            return new lw(parcel, (byte) 0);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ lw[] newArray(int i) {
            return null;
        }
    };
    private String b;
    private li c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;

    /* synthetic */ lw(Parcel parcel, byte b2) {
        this(parcel);
    }

    public lw() {
    }

    public final String a() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final li b() {
        return this.c;
    }

    public final void a(li liVar) {
        this.c = liVar;
    }

    public final String c() {
        return this.d;
    }

    public final void b(String str) {
        this.d = str;
    }

    public final void c(String str) {
        this.e = str;
    }

    public final void d(String str) {
        this.f = str;
    }

    public final String d() {
        return this.g;
    }

    public final void e(String str) {
        this.g = str;
    }

    public final void f(String str) {
        this.h = str;
    }

    public final String toString() {
        return "name:" + this.d + " district:" + this.e + " adcode:" + this.f;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.d);
        parcel.writeString(this.f);
        parcel.writeString(this.e);
        parcel.writeString(this.b);
        parcel.writeValue(this.c);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
    }

    private lw(Parcel parcel) {
        this.d = parcel.readString();
        this.f = parcel.readString();
        this.e = parcel.readString();
        this.b = parcel.readString();
        this.c = (li) parcel.readValue(li.class.getClassLoader());
        this.g = parcel.readString();
        this.h = parcel.readString();
    }
}
