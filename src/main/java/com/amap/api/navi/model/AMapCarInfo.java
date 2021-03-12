package com.amap.api.navi.model;

import android.os.Parcel;
import android.os.Parcelable;

public class AMapCarInfo implements Parcelable {
    public static final Parcelable.Creator<AMapCarInfo> CREATOR = new Parcelable.Creator<AMapCarInfo>() {
        /* class com.amap.api.navi.model.AMapCarInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapCarInfo createFromParcel(Parcel parcel) {
            return new AMapCarInfo(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AMapCarInfo[] newArray(int i) {
            return new AMapCarInfo[i];
        }
    };
    private boolean isRestriction = true;
    private String mCarNumber;
    private String mCarType;
    private String mVehicleAxis;
    private String mVehicleHeight;
    private String mVehicleLength;
    private String mVehicleLoad;
    private boolean mVehicleLoadSwitch;
    private String mVehicleSize;
    private String mVehicleWeight;
    private String mVehicleWidth;

    public AMapCarInfo() {
    }

    protected AMapCarInfo(Parcel parcel) {
        boolean z = true;
        this.mCarNumber = parcel.readString();
        this.isRestriction = parcel.readByte() != 0;
        this.mCarType = parcel.readString();
        this.mVehicleHeight = parcel.readString();
        this.mVehicleWeight = parcel.readString();
        this.mVehicleLoad = parcel.readString();
        this.mVehicleLoadSwitch = parcel.readByte() == 0 ? false : z;
        this.mVehicleWidth = parcel.readString();
        this.mVehicleLength = parcel.readString();
        this.mVehicleSize = parcel.readString();
        this.mVehicleAxis = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mCarNumber);
        parcel.writeByte(this.isRestriction ? (byte) 1 : 0);
        parcel.writeString(this.mCarType);
        parcel.writeString(this.mVehicleHeight);
        parcel.writeString(this.mVehicleWeight);
        parcel.writeString(this.mVehicleLoad);
        parcel.writeByte(this.mVehicleLoadSwitch ? (byte) 1 : 0);
        parcel.writeString(this.mVehicleWidth);
        parcel.writeString(this.mVehicleLength);
        parcel.writeString(this.mVehicleSize);
        parcel.writeString(this.mVehicleAxis);
    }

    public int describeContents() {
        return 0;
    }

    public String getCarNumber() {
        return this.mCarNumber;
    }

    public void setCarNumber(String str) {
        this.mCarNumber = str;
    }

    public boolean isRestriction() {
        return this.isRestriction;
    }

    public void setRestriction(boolean z) {
        this.isRestriction = z;
    }

    public String getCarType() {
        return this.mCarType;
    }

    public void setCarType(String str) {
        this.mCarType = str;
    }

    public String getVehicleHeight() {
        return this.mVehicleHeight;
    }

    public void setVehicleHeight(String str) {
        this.mVehicleHeight = str;
    }

    public String getVehicleLoad() {
        return this.mVehicleLoad;
    }

    public void setVehicleLoad(String str) {
        this.mVehicleLoad = str;
    }

    public boolean isVehicleLoadSwitch() {
        return this.mVehicleLoadSwitch;
    }

    public void setVehicleLoadSwitch(boolean z) {
        this.mVehicleLoadSwitch = z;
    }

    public void setVehicleWidth(String str) {
        this.mVehicleWidth = str;
    }

    public void setVehicleLength(String str) {
        this.mVehicleLength = str;
    }

    public void setVehicleSize(String str) {
        this.mVehicleSize = str;
    }

    public void setVehicleAxis(String str) {
        this.mVehicleAxis = str;
    }

    public void setVehicleWeight(String str) {
        this.mVehicleWeight = str;
    }

    public String getVehicleWidth() {
        return this.mVehicleWidth;
    }

    public String getVehicleLength() {
        return this.mVehicleLength;
    }

    public String getVehicleSize() {
        return this.mVehicleSize;
    }

    public String getVehicleAxis() {
        return this.mVehicleAxis;
    }

    public String getVehicleWeight() {
        return this.mVehicleWeight;
    }
}
