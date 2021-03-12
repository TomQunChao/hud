package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

public class OfflineMapProvince extends Province {
    public static final Parcelable.Creator<OfflineMapProvince> CREATOR = new Parcelable.Creator<OfflineMapProvince>() {
        /* class com.amap.api.maps.offlinemap.OfflineMapProvince.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OfflineMapProvince createFromParcel(Parcel parcel) {
            return new OfflineMapProvince(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ OfflineMapProvince[] newArray(int i) {
            return new OfflineMapProvince[i];
        }
    };
    private String a;
    private int b = 6;
    private long c;
    private String d;
    private int e = 0;
    private ArrayList<OfflineMapCity> f;

    public OfflineMapProvince() {
    }

    public String getUrl() {
        return this.a;
    }

    public void setUrl(String str) {
        this.a = str;
    }

    public int getState() {
        return this.b;
    }

    public void setState(int i) {
        this.b = i;
    }

    public long getSize() {
        return this.c;
    }

    public void setSize(long j) {
        this.c = j;
    }

    public String getVersion() {
        return this.d;
    }

    public void setVersion(String str) {
        this.d = str;
    }

    public int getcompleteCode() {
        return this.e;
    }

    public void setCompleteCode(int i) {
        this.e = i;
    }

    @Override // com.amap.api.maps.offlinemap.Province
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.maps.offlinemap.Province
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeLong(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeTypedList(this.f);
    }

    public ArrayList<OfflineMapCity> getCityList() {
        ArrayList<OfflineMapCity> arrayList = this.f;
        if (arrayList == null) {
            return new ArrayList<>();
        }
        return arrayList;
    }

    public ArrayList<OfflineMapCity> getDownloadedCityList() {
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList2 = this.f;
        if (arrayList2 == null) {
            return arrayList;
        }
        Iterator<OfflineMapCity> it = arrayList2.iterator();
        while (it.hasNext()) {
            OfflineMapCity next = it.next();
            if (next.getState() != 6) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public void setCityList(ArrayList<OfflineMapCity> arrayList) {
        this.f = arrayList;
    }

    public OfflineMapProvince(Parcel parcel) {
        super(parcel);
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readLong();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.createTypedArrayList(OfflineMapCity.CREATOR);
    }
}
