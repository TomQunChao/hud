package com.amap.api.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.col.stln3.vu;
import com.amap.api.col.stln3.wc;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.district.DistrictSearchQuery;
import org.json.JSONObject;

public class AMapLocation extends Location implements Parcelable, Cloneable {
    public static final String COORD_TYPE_GCJ02 = "GCJ02";
    public static final String COORD_TYPE_WGS84 = "WGS84";
    public static final Parcelable.Creator<AMapLocation> CREATOR = new Parcelable.Creator<AMapLocation>() {
        /* class com.amap.api.location.AMapLocation.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocation createFromParcel(Parcel parcel) {
            AMapLocation aMapLocation = new AMapLocation((Location) Location.CREATOR.createFromParcel(parcel));
            aMapLocation.h = parcel.readString();
            aMapLocation.i = parcel.readString();
            aMapLocation.w = parcel.readString();
            aMapLocation.a = parcel.readString();
            aMapLocation.e = parcel.readString();
            aMapLocation.g = parcel.readString();
            aMapLocation.k = parcel.readString();
            aMapLocation.f = parcel.readString();
            aMapLocation.p = parcel.readInt();
            aMapLocation.q = parcel.readString();
            aMapLocation.b = parcel.readString();
            boolean z = true;
            aMapLocation.A = parcel.readInt() != 0;
            aMapLocation.o = parcel.readInt() != 0;
            aMapLocation.t = parcel.readDouble();
            aMapLocation.r = parcel.readString();
            aMapLocation.s = parcel.readInt();
            aMapLocation.u = parcel.readDouble();
            if (parcel.readInt() == 0) {
                z = false;
            }
            aMapLocation.y = z;
            aMapLocation.n = parcel.readString();
            aMapLocation.j = parcel.readString();
            aMapLocation.d = parcel.readString();
            aMapLocation.l = parcel.readString();
            aMapLocation.v = parcel.readInt();
            aMapLocation.x = parcel.readInt();
            aMapLocation.m = parcel.readString();
            aMapLocation.z = parcel.readString();
            aMapLocation.B = parcel.readString();
            aMapLocation.C = parcel.readInt();
            return aMapLocation;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AMapLocation[] newArray(int i) {
            return new AMapLocation[i];
        }
    };
    public static final int ERROR_CODE_AIRPLANEMODE_WIFIOFF = 18;
    public static final int ERROR_CODE_FAILURE_AUTH = 7;
    public static final int ERROR_CODE_FAILURE_CELL = 11;
    public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
    public static final int ERROR_CODE_FAILURE_INIT = 9;
    public static final int ERROR_CODE_FAILURE_LOCATION = 6;
    public static final int ERROR_CODE_FAILURE_LOCATION_PARAMETER = 3;
    public static final int ERROR_CODE_FAILURE_LOCATION_PERMISSION = 12;
    public static final int ERROR_CODE_FAILURE_NOENOUGHSATELLITES = 14;
    public static final int ERROR_CODE_FAILURE_NOWIFIANDAP = 13;
    public static final int ERROR_CODE_FAILURE_PARSER = 5;
    public static final int ERROR_CODE_FAILURE_SIMULATION_LOCATION = 15;
    public static final int ERROR_CODE_FAILURE_WIFI_INFO = 2;
    public static final int ERROR_CODE_INVALID_PARAMETER = 1;
    public static final int ERROR_CODE_NOCGI_WIFIOFF = 19;
    public static final int ERROR_CODE_SERVICE_FAIL = 10;
    public static final int ERROR_CODE_UNKNOWN = 8;
    public static final int GPS_ACCURACY_BAD = 0;
    public static final int GPS_ACCURACY_GOOD = 1;
    public static final int GPS_ACCURACY_UNKNOWN = -1;
    public static final int LOCATION_SUCCESS = 0;
    public static final int LOCATION_TYPE_AMAP = 7;
    public static final int LOCATION_TYPE_CELL = 6;
    public static final int LOCATION_TYPE_FAST = 3;
    public static final int LOCATION_TYPE_FIX_CACHE = 4;
    public static final int LOCATION_TYPE_GPS = 1;
    public static final int LOCATION_TYPE_LAST_LOCATION_CACHE = 9;
    public static final int LOCATION_TYPE_OFFLINE = 8;
    public static final int LOCATION_TYPE_SAME_REQ = 2;
    public static final int LOCATION_TYPE_WIFI = 5;
    public static final int TRUSTED_LEVEL_BAD = 4;
    public static final int TRUSTED_LEVEL_HIGH = 1;
    public static final int TRUSTED_LEVEL_LOW = 3;
    public static final int TRUSTED_LEVEL_NORMAL = 2;
    private boolean A = false;
    private String B = COORD_TYPE_GCJ02;
    private int C = 1;
    protected String a = "";
    protected String b = "";
    AMapLocationQualityReport c = new AMapLocationQualityReport();
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";
    private String h = "";
    private String i = "";
    private String j = "";
    private String k = "";
    private String l = "";
    private String m = "";
    private String n = "";
    private boolean o = true;
    private int p = 0;
    private String q = "success";
    private String r = "";
    private int s = 0;
    private double t = 0.0d;
    private double u = 0.0d;
    private int v = 0;
    private String w = "";
    private int x = -1;
    private boolean y = false;
    private String z = "";

    public int getGpsAccuracyStatus() {
        return this.x;
    }

    public void setGpsAccuracyStatus(int i2) {
        this.x = i2;
    }

    public AMapLocation(String str) {
        super(str);
    }

    public AMapLocation(Location location) {
        super(location);
        this.t = location.getLatitude();
        this.u = location.getLongitude();
    }

    public int getLocationType() {
        return this.s;
    }

    public void setLocationType(int i2) {
        this.s = i2;
    }

    public String getLocationDetail() {
        return this.r;
    }

    public void setLocationDetail(String str) {
        this.r = str;
    }

    public int getErrorCode() {
        return this.p;
    }

    public void setErrorCode(int i2) {
        if (this.p == 0) {
            this.q = wc.b(i2);
            this.p = i2;
        }
    }

    public String getErrorInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.q);
        if (this.p != 0) {
            sb.append(" 请到http://lbs.amap.com/api/android-location-sdk/guide/utilities/errorcode/查看错误码说明");
            sb.append(",错误详细信息:" + this.r);
        }
        return sb.toString();
    }

    public void setErrorInfo(String str) {
        this.q = str;
    }

    public String getCountry() {
        return this.k;
    }

    public void setCountry(String str) {
        this.k = str;
    }

    public String getRoad() {
        return this.l;
    }

    public void setRoad(String str) {
        this.l = str;
    }

    public String getAddress() {
        return this.i;
    }

    public void setAddress(String str) {
        this.i = str;
    }

    public String getProvince() {
        return this.d;
    }

    public void setProvince(String str) {
        this.d = str;
    }

    public String getCity() {
        return this.e;
    }

    public void setCity(String str) {
        this.e = str;
    }

    public String getDistrict() {
        return this.f;
    }

    public void setDistrict(String str) {
        this.f = str;
    }

    public String getCityCode() {
        return this.g;
    }

    public void setCityCode(String str) {
        this.g = str;
    }

    public String getAdCode() {
        return this.h;
    }

    public void setAdCode(String str) {
        this.h = str;
    }

    public String getPoiName() {
        return this.j;
    }

    public void setPoiName(String str) {
        this.j = str;
    }

    public double getLatitude() {
        return this.t;
    }

    public void setLatitude(double d2) {
        this.t = d2;
    }

    public double getLongitude() {
        return this.u;
    }

    public void setLongitude(double d2) {
        this.u = d2;
    }

    public int getSatellites() {
        return this.v;
    }

    public void setSatellites(int i2) {
        this.v = i2;
    }

    public String getStreet() {
        return this.m;
    }

    public void setStreet(String str) {
        this.m = str;
    }

    public String getStreetNum() {
        return this.n;
    }

    public void setNumber(String str) {
        this.n = str;
    }

    public void setOffset(boolean z2) {
        this.o = z2;
    }

    public boolean isOffset() {
        return this.o;
    }

    public String getAoiName() {
        return this.w;
    }

    public void setAoiName(String str) {
        this.w = str;
    }

    public String getBuildingId() {
        return this.a;
    }

    public void setBuildingId(String str) {
        this.a = str;
    }

    public String getFloor() {
        return this.b;
    }

    public boolean isFixLastLocation() {
        return this.A;
    }

    public void setFixLastLocation(boolean z2) {
        this.A = z2;
    }

    public void setFloor(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.replace("F", "");
            try {
                Integer.parseInt(str);
            } catch (Throwable th) {
                vu.a(th, "AmapLoc", "setFloor");
                str = null;
            }
        }
        this.b = str;
    }

    public boolean isMock() {
        return this.y;
    }

    public void setMock(boolean z2) {
        this.y = z2;
    }

    public String getDescription() {
        return this.z;
    }

    public void setDescription(String str) {
        this.z = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append("latitude=" + this.t + "#");
            stringBuffer.append("longitude=" + this.u + "#");
            stringBuffer.append("province=" + this.d + "#");
            stringBuffer.append("coordType=" + this.B + "#");
            stringBuffer.append("city=" + this.e + "#");
            stringBuffer.append("district=" + this.f + "#");
            stringBuffer.append("cityCode=" + this.g + "#");
            stringBuffer.append("adCode=" + this.h + "#");
            stringBuffer.append("address=" + this.i + "#");
            stringBuffer.append("country=" + this.k + "#");
            stringBuffer.append("road=" + this.l + "#");
            stringBuffer.append("poiName=" + this.j + "#");
            stringBuffer.append("street=" + this.m + "#");
            stringBuffer.append("streetNum=" + this.n + "#");
            stringBuffer.append("aoiName=" + this.w + "#");
            stringBuffer.append("poiid=" + this.a + "#");
            stringBuffer.append("floor=" + this.b + "#");
            stringBuffer.append("errorCode=" + this.p + "#");
            stringBuffer.append("errorInfo=" + this.q + "#");
            stringBuffer.append("locationDetail=" + this.r + "#");
            stringBuffer.append("description=" + this.z + "#");
            StringBuilder sb = new StringBuilder("locationType=");
            sb.append(this.s);
            stringBuffer.append(sb.toString());
        } catch (Throwable th) {
        }
        return stringBuffer.toString();
    }

    public String toStr() {
        return toStr(1);
    }

    public String toStr(int i2) {
        JSONObject jSONObject;
        try {
            jSONObject = toJson(i2);
        } catch (Throwable th) {
            vu.a(th, "AMapLocation", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    public float getAccuracy() {
        return super.getAccuracy();
    }

    public float getBearing() {
        return super.getBearing();
    }

    public double getAltitude() {
        return super.getAltitude();
    }

    public float getSpeed() {
        return super.getSpeed();
    }

    public String getProvider() {
        return super.getProvider();
    }

    public JSONObject toJson(int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            switch (i2) {
                case 1:
                    try {
                        jSONObject.put("altitude", getAltitude());
                        jSONObject.put("speed", (double) getSpeed());
                        jSONObject.put("bearing", (double) getBearing());
                    } catch (Throwable th) {
                    }
                    jSONObject.put("citycode", this.g);
                    jSONObject.put("adcode", this.h);
                    jSONObject.put(DistrictSearchQuery.KEYWORDS_COUNTRY, this.k);
                    jSONObject.put(DistrictSearchQuery.KEYWORDS_PROVINCE, this.d);
                    jSONObject.put(DistrictSearchQuery.KEYWORDS_CITY, this.e);
                    jSONObject.put(DistrictSearchQuery.KEYWORDS_DISTRICT, this.f);
                    jSONObject.put("road", this.l);
                    jSONObject.put("street", this.m);
                    jSONObject.put("number", this.n);
                    jSONObject.put("poiname", this.j);
                    jSONObject.put(MyLocationStyle.ERROR_CODE, this.p);
                    jSONObject.put(MyLocationStyle.ERROR_INFO, this.q);
                    jSONObject.put(MyLocationStyle.LOCATION_TYPE, this.s);
                    jSONObject.put("locationDetail", this.r);
                    jSONObject.put("aoiname", this.w);
                    jSONObject.put("address", this.i);
                    jSONObject.put("poiid", this.a);
                    jSONObject.put("floor", this.b);
                    jSONObject.put("description", this.z);
                case 2:
                    jSONObject.put("time", getTime());
                    break;
                case 3:
                    break;
                default:
                    return jSONObject;
            }
            jSONObject.put("provider", getProvider());
            jSONObject.put("lon", getLongitude());
            jSONObject.put("lat", getLatitude());
            jSONObject.put("accuracy", (double) getAccuracy());
            jSONObject.put("isOffset", this.o);
            jSONObject.put("isFixLastLocation", this.A);
            jSONObject.put("coordType", this.B);
            return jSONObject;
        } catch (Throwable th2) {
            vu.a(th2, "AmapLoc", "toStr");
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        try {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.h);
            parcel.writeString(this.i);
            parcel.writeString(this.w);
            parcel.writeString(this.a);
            parcel.writeString(this.e);
            parcel.writeString(this.g);
            parcel.writeString(this.k);
            parcel.writeString(this.f);
            parcel.writeInt(this.p);
            parcel.writeString(this.q);
            parcel.writeString(this.b);
            int i3 = 1;
            parcel.writeInt(this.A ? 1 : 0);
            parcel.writeInt(this.o ? 1 : 0);
            parcel.writeDouble(this.t);
            parcel.writeString(this.r);
            parcel.writeInt(this.s);
            parcel.writeDouble(this.u);
            if (!this.y) {
                i3 = 0;
            }
            parcel.writeInt(i3);
            parcel.writeString(this.n);
            parcel.writeString(this.j);
            parcel.writeString(this.d);
            parcel.writeString(this.l);
            parcel.writeInt(this.v);
            parcel.writeInt(this.x);
            parcel.writeString(this.m);
            parcel.writeString(this.z);
            parcel.writeString(this.B);
            parcel.writeInt(this.C);
        } catch (Throwable th) {
            vu.a(th, "AMapLocation", "writeToParcel");
        }
    }

    @Override // java.lang.Object
    public AMapLocation clone() {
        try {
            super.clone();
        } catch (Throwable th) {
        }
        AMapLocation aMapLocation = new AMapLocation(this);
        try {
            aMapLocation.setLatitude(this.t);
            aMapLocation.setLongitude(this.u);
            aMapLocation.setAdCode(this.h);
            aMapLocation.setAddress(this.i);
            aMapLocation.setAoiName(this.w);
            aMapLocation.setBuildingId(this.a);
            aMapLocation.setCity(this.e);
            aMapLocation.setCityCode(this.g);
            aMapLocation.setCountry(this.k);
            aMapLocation.setDistrict(this.f);
            aMapLocation.setErrorCode(this.p);
            aMapLocation.setErrorInfo(this.q);
            aMapLocation.setFloor(this.b);
            aMapLocation.setFixLastLocation(this.A);
            aMapLocation.setOffset(this.o);
            aMapLocation.setLocationDetail(this.r);
            aMapLocation.setLocationType(this.s);
            aMapLocation.setMock(this.y);
            aMapLocation.setNumber(this.n);
            aMapLocation.setPoiName(this.j);
            aMapLocation.setProvince(this.d);
            aMapLocation.setRoad(this.l);
            aMapLocation.setSatellites(this.v);
            aMapLocation.setGpsAccuracyStatus(this.x);
            aMapLocation.setStreet(this.m);
            aMapLocation.setDescription(this.z);
            aMapLocation.setExtras(getExtras());
            if (this.c != null) {
                aMapLocation.setLocationQualityReport(this.c.clone());
            }
            aMapLocation.setCoordType(this.B);
            aMapLocation.setTrustedLevel(this.C);
        } catch (Throwable th2) {
            vu.a(th2, "AMapLocation", "clone");
        }
        return aMapLocation;
    }

    public AMapLocationQualityReport getLocationQualityReport() {
        return this.c;
    }

    public void setLocationQualityReport(AMapLocationQualityReport aMapLocationQualityReport) {
        if (aMapLocationQualityReport != null) {
            this.c = aMapLocationQualityReport;
        }
    }

    public String getCoordType() {
        return this.B;
    }

    public void setCoordType(String str) {
        this.B = str;
    }

    public void setTrustedLevel(int i2) {
        this.C = i2;
    }

    public int getTrustedLevel() {
        return this.C;
    }
}
