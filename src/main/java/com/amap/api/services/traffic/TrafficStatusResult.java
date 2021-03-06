package com.amap.api.services.traffic;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class TrafficStatusResult implements Parcelable {
    public static final Parcelable.Creator<TrafficStatusResult> CREATOR = new Parcelable.Creator<TrafficStatusResult>() {
        /* class com.amap.api.services.traffic.TrafficStatusResult.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TrafficStatusResult createFromParcel(Parcel parcel) {
            return new TrafficStatusResult(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TrafficStatusResult[] newArray(int i) {
            return new TrafficStatusResult[i];
        }
    };
    private String a;
    private TrafficStatusEvaluation b;
    private List<TrafficStatusInfo> c;

    public String getDescription() {
        return this.a;
    }

    public void setDescription(String str) {
        this.a = str;
    }

    public TrafficStatusEvaluation getEvaluation() {
        return this.b;
    }

    public void setEvaluation(TrafficStatusEvaluation trafficStatusEvaluation) {
        this.b = trafficStatusEvaluation;
    }

    public List<TrafficStatusInfo> getRoads() {
        return this.c;
    }

    public void setRoads(List<TrafficStatusInfo> list) {
        this.c = list;
    }

    public TrafficStatusResult() {
    }

    protected TrafficStatusResult(Parcel parcel) {
        this.a = parcel.readString();
        this.b = (TrafficStatusEvaluation) parcel.readParcelable(TrafficStatusEvaluation.class.getClassLoader());
        this.c = parcel.createTypedArrayList(TrafficStatusInfo.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, i);
        parcel.writeTypedList(this.c);
    }
}
