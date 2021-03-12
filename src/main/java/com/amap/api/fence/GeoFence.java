package com.amap.api.fence;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.col.stln3.wc;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import java.util.ArrayList;
import java.util.List;

public class GeoFence implements Parcelable {
    public static final int ADDGEOFENCE_SUCCESS = 0;
    public static final String BUNDLE_KEY_CUSTOMID = "customId";
    public static final String BUNDLE_KEY_FENCE = "fence";
    public static final String BUNDLE_KEY_FENCEID = "fenceid";
    public static final String BUNDLE_KEY_FENCESTATUS = "event";
    public static final String BUNDLE_KEY_LOCERRORCODE = "location_errorcode";
    public static final Parcelable.Creator<GeoFence> CREATOR = new Parcelable.Creator<GeoFence>() {
        /* class com.amap.api.fence.GeoFence.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GeoFence createFromParcel(Parcel parcel) {
            return new GeoFence(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GeoFence[] newArray(int i) {
            return new GeoFence[i];
        }
    };
    public static final int ERROR_CODE_EXISTS = 17;
    public static final int ERROR_CODE_FAILURE_AUTH = 7;
    public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
    public static final int ERROR_CODE_FAILURE_PARSER = 5;
    public static final int ERROR_CODE_INVALID_PARAMETER = 1;
    public static final int ERROR_CODE_UNKNOWN = 8;
    public static final int ERROR_NO_VALIDFENCE = 16;
    public static final int STATUS_IN = 1;
    public static final int STATUS_LOCFAIL = 4;
    public static final int STATUS_OUT = 2;
    public static final int STATUS_STAYED = 3;
    public static final int STATUS_UNKNOWN = 0;
    public static final int TYPE_AMAPPOI = 2;
    public static final int TYPE_DISTRICT = 3;
    public static final int TYPE_POLYGON = 1;
    public static final int TYPE_ROUND = 0;
    private String a;
    private String b;
    private String c;
    private PendingIntent d;
    private int e;
    private PoiItem f;
    private List<DistrictItem> g;
    private List<List<DPoint>> h;
    private float i;
    private long j;
    private int k;
    private float l;
    private float m;
    private DPoint n;
    private int o;
    private long p;
    private boolean q;
    private AMapLocation r;

    public GeoFence() {
        this.d = null;
        this.e = 0;
        this.f = null;
        this.g = null;
        this.i = 0.0f;
        this.j = -1;
        this.k = 1;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = null;
        this.o = 0;
        this.p = -1;
        this.q = true;
        this.r = null;
    }

    public String getFenceId() {
        return this.a;
    }

    public void setFenceId(String str) {
        this.a = str;
    }

    public String getCustomId() {
        return this.b;
    }

    public void setCustomId(String str) {
        this.b = str;
    }

    public String getPendingIntentAction() {
        return this.c;
    }

    public void setPendingIntentAction(String str) {
        this.c = str;
    }

    public PendingIntent getPendingIntent() {
        return this.d;
    }

    public void setPendingIntent(PendingIntent pendingIntent) {
        this.d = pendingIntent;
    }

    public int getType() {
        return this.e;
    }

    public void setType(int i2) {
        this.e = i2;
    }

    public PoiItem getPoiItem() {
        return this.f;
    }

    public void setPoiItem(PoiItem poiItem) {
        this.f = poiItem;
    }

    public List<DistrictItem> getDistrictItemList() {
        return this.g;
    }

    public void setDistrictItemList(List<DistrictItem> list) {
        this.g = list;
    }

    public List<List<DPoint>> getPointList() {
        return this.h;
    }

    public void setPointList(List<List<DPoint>> list) {
        this.h = list;
    }

    public float getRadius() {
        return this.i;
    }

    public void setRadius(float f2) {
        this.i = f2;
    }

    public long getExpiration() {
        return this.j;
    }

    public void setExpiration(long j2) {
        if (j2 < 0) {
            this.j = -1;
        } else {
            this.j = j2 + wc.b();
        }
    }

    public int getActivatesAction() {
        return this.k;
    }

    public void setActivatesAction(int i2) {
        this.k = i2;
    }

    public int getStatus() {
        return this.o;
    }

    public void setStatus(int i2) {
        this.o = i2;
    }

    public long getEnterTime() {
        return this.p;
    }

    public void setEnterTime(long j2) {
        this.p = j2;
    }

    public DPoint getCenter() {
        return this.n;
    }

    public void setCenter(DPoint dPoint) {
        this.n = dPoint;
    }

    public float getMinDis2Center() {
        return this.l;
    }

    public void setMinDis2Center(float f2) {
        this.l = f2;
    }

    public float getMaxDis2Center() {
        return this.m;
    }

    public void setMaxDis2Center(float f2) {
        this.m = f2;
    }

    public boolean isAble() {
        return this.q;
    }

    public void setAble(boolean z) {
        this.q = z;
    }

    public void setCurrentLocation(AMapLocation aMapLocation) {
        this.r = aMapLocation.clone();
    }

    public AMapLocation getCurrentLocation() {
        return this.r;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GeoFence)) {
            return false;
        }
        GeoFence geoFence = (GeoFence) obj;
        if (TextUtils.isEmpty(this.b)) {
            if (!TextUtils.isEmpty(geoFence.b)) {
                return false;
            }
        } else if (!this.b.equals(geoFence.b)) {
            return false;
        }
        DPoint dPoint = this.n;
        if (dPoint == null) {
            if (geoFence.n != null) {
                return false;
            }
        } else if (!dPoint.equals(geoFence.n)) {
            return false;
        }
        if (this.i != geoFence.i) {
            return false;
        }
        List<List<DPoint>> list = this.h;
        if (list == null) {
            if (geoFence.h != null) {
                return false;
            }
            return true;
        } else if (!list.equals(geoFence.h)) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return this.b.hashCode() + this.h.hashCode() + this.n.hashCode() + ((int) (this.i * 100.0f));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i2);
        parcel.writeInt(this.e);
        parcel.writeParcelable(this.f, i2);
        parcel.writeTypedList(this.g);
        parcel.writeFloat(this.i);
        parcel.writeLong(this.j);
        parcel.writeInt(this.k);
        parcel.writeFloat(this.l);
        parcel.writeFloat(this.m);
        parcel.writeParcelable(this.n, i2);
        parcel.writeInt(this.o);
        parcel.writeLong(this.p);
        List<List<DPoint>> list = this.h;
        if (list != null && !list.isEmpty()) {
            parcel.writeInt(this.h.size());
            for (List<DPoint> list2 : this.h) {
                parcel.writeTypedList(list2);
            }
        }
        parcel.writeByte(this.q ? (byte) 1 : 0);
        parcel.writeParcelable(this.r, i2);
    }

    protected GeoFence(Parcel parcel) {
        this.d = null;
        boolean z = false;
        this.e = 0;
        this.f = null;
        this.g = null;
        this.i = 0.0f;
        this.j = -1;
        this.k = 1;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = null;
        this.o = 0;
        this.p = -1;
        this.q = true;
        this.r = null;
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = (PendingIntent) parcel.readParcelable(PendingIntent.class.getClassLoader());
        this.e = parcel.readInt();
        this.f = (PoiItem) parcel.readParcelable(PoiItem.class.getClassLoader());
        this.g = parcel.createTypedArrayList(DistrictItem.CREATOR);
        this.i = parcel.readFloat();
        this.j = parcel.readLong();
        this.k = parcel.readInt();
        this.l = parcel.readFloat();
        this.m = parcel.readFloat();
        this.n = (DPoint) parcel.readParcelable(DPoint.class.getClassLoader());
        this.o = parcel.readInt();
        this.p = parcel.readLong();
        int readInt = parcel.readInt();
        if (readInt != 0) {
            this.h = new ArrayList();
            for (int i2 = 0; i2 < readInt; i2++) {
                this.h.add(parcel.createTypedArrayList(DPoint.CREATOR));
            }
        }
        this.q = parcel.readByte() != 0 ? true : z;
        this.r = (AMapLocation) parcel.readParcelable(AMapLocation.class.getClassLoader());
    }
}
