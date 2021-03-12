package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.stln3.vu;

public class AMapLocationClientOption implements Parcelable, Cloneable {
    public static final Parcelable.Creator<AMapLocationClientOption> CREATOR = new Parcelable.Creator<AMapLocationClientOption>() {
        /* class com.amap.api.location.AMapLocationClientOption.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocationClientOption createFromParcel(Parcel parcel) {
            return new AMapLocationClientOption(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AMapLocationClientOption[] newArray(int i) {
            return new AMapLocationClientOption[i];
        }
    };
    public static boolean OPEN_ALWAYS_SCAN_WIFI = true;
    public static long SCAN_WIFI_INTERVAL = 30000;
    static String a = "";
    private static AMapLocationProtocol j = AMapLocationProtocol.HTTP;
    private static boolean u = true;
    private long b;
    private long c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private AMapLocationMode i;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private long r;
    private long s;
    private GeoLanguage t;
    private float v;
    private AMapLocationPurpose w;

    public enum AMapLocationMode {
        Battery_Saving,
        Device_Sensors,
        Hight_Accuracy
    }

    public enum AMapLocationPurpose {
        SignIn,
        Transport,
        Sport
    }

    public enum GeoLanguage {
        DEFAULT,
        ZH,
        EN
    }

    public enum AMapLocationProtocol {
        HTTP(0),
        HTTPS(1);
        
        private int a;

        private AMapLocationProtocol(int i) {
            this.a = i;
        }

        public final int getValue() {
            return this.a;
        }
    }

    public static String getAPIKEY() {
        return a;
    }

    public boolean isMockEnable() {
        return this.e;
    }

    public AMapLocationClientOption setMockEnable(boolean z) {
        this.e = z;
        return this;
    }

    public long getInterval() {
        return this.b;
    }

    public AMapLocationClientOption setInterval(long j2) {
        if (j2 <= 800) {
            j2 = 800;
        }
        this.b = j2;
        return this;
    }

    public boolean isOnceLocation() {
        return this.d;
    }

    public AMapLocationClientOption setOnceLocation(boolean z) {
        this.d = z;
        return this;
    }

    public boolean isNeedAddress() {
        return this.f;
    }

    public AMapLocationClientOption setNeedAddress(boolean z) {
        this.f = z;
        return this;
    }

    public boolean isWifiActiveScan() {
        return this.g;
    }

    public AMapLocationClientOption setWifiActiveScan(boolean z) {
        this.g = z;
        this.h = z;
        return this;
    }

    public boolean isWifiScan() {
        return this.q;
    }

    public AMapLocationClientOption setWifiScan(boolean z) {
        this.q = z;
        if (this.q) {
            this.g = this.h;
        } else {
            this.g = false;
        }
        return this;
    }

    public AMapLocationMode getLocationMode() {
        return this.i;
    }

    public AMapLocationClientOption setLocationMode(AMapLocationMode aMapLocationMode) {
        this.i = aMapLocationMode;
        return this;
    }

    public AMapLocationProtocol getLocationProtocol() {
        return j;
    }

    public static void setLocationProtocol(AMapLocationProtocol aMapLocationProtocol) {
        j = aMapLocationProtocol;
    }

    public boolean isKillProcess() {
        return this.k;
    }

    public AMapLocationClientOption setKillProcess(boolean z) {
        this.k = z;
        return this;
    }

    public boolean isGpsFirst() {
        return this.l;
    }

    public AMapLocationClientOption setGpsFirst(boolean z) {
        this.l = z;
        return this;
    }

    public AMapLocationClientOption setGpsFirstTimeout(long j2) {
        if (j2 < 5000) {
            j2 = 5000;
        }
        if (j2 > 30000) {
            j2 = 30000;
        }
        this.s = j2;
        return this;
    }

    public long getGpsFirstTimeout() {
        return this.s;
    }

    @Override // java.lang.Object
    public AMapLocationClientOption clone() {
        try {
            super.clone();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.b = this.b;
        aMapLocationClientOption.d = this.d;
        aMapLocationClientOption.i = this.i;
        aMapLocationClientOption.e = this.e;
        aMapLocationClientOption.k = this.k;
        aMapLocationClientOption.l = this.l;
        aMapLocationClientOption.f = this.f;
        aMapLocationClientOption.g = this.g;
        aMapLocationClientOption.c = this.c;
        aMapLocationClientOption.m = this.m;
        aMapLocationClientOption.n = this.n;
        aMapLocationClientOption.o = this.o;
        aMapLocationClientOption.p = isSensorEnable();
        aMapLocationClientOption.q = isWifiScan();
        aMapLocationClientOption.r = this.r;
        j = getLocationProtocol();
        aMapLocationClientOption.t = this.t;
        u = isDownloadCoordinateConvertLibrary();
        aMapLocationClientOption.v = this.v;
        aMapLocationClientOption.w = this.w;
        OPEN_ALWAYS_SCAN_WIFI = isOpenAlwaysScanWifi();
        SCAN_WIFI_INTERVAL = getScanWifiInterval();
        aMapLocationClientOption.s = this.s;
        return aMapLocationClientOption;
    }

    public long getHttpTimeOut() {
        return this.c;
    }

    public AMapLocationClientOption setHttpTimeOut(long j2) {
        this.c = j2;
        return this;
    }

    public boolean isOffset() {
        return this.m;
    }

    public AMapLocationClientOption setOffset(boolean z) {
        this.m = z;
        return this;
    }

    public boolean isLocationCacheEnable() {
        return this.n;
    }

    public AMapLocationClientOption setLocationCacheEnable(boolean z) {
        this.n = z;
        return this;
    }

    public boolean isOnceLocationLatest() {
        return this.o;
    }

    public AMapLocationClientOption setOnceLocationLatest(boolean z) {
        this.o = z;
        return this;
    }

    public boolean isSensorEnable() {
        return this.p;
    }

    public AMapLocationClientOption setSensorEnable(boolean z) {
        this.p = z;
        return this;
    }

    public AMapLocationClientOption setLastLocationLifeCycle(long j2) {
        this.r = j2;
        return this;
    }

    public long getLastLocationLifeCycle() {
        return this.r;
    }

    public GeoLanguage getGeoLanguage() {
        return this.t;
    }

    public AMapLocationClientOption setGeoLanguage(GeoLanguage geoLanguage) {
        this.t = geoLanguage;
        return this;
    }

    public static void setDownloadCoordinateConvertLibrary(boolean z) {
        u = z;
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return u;
    }

    public float getDeviceModeDistanceFilter() {
        return this.v;
    }

    public AMapLocationClientOption setDeviceModeDistanceFilter(float f2) {
        this.v = f2;
        return this;
    }

    public AMapLocationClientOption setLocationPurpose(AMapLocationPurpose aMapLocationPurpose) {
        this.w = aMapLocationPurpose;
        if (aMapLocationPurpose != null) {
            switch (aMapLocationPurpose) {
                case SignIn:
                    this.i = AMapLocationMode.Hight_Accuracy;
                    this.d = true;
                    this.o = true;
                    this.l = false;
                    this.e = false;
                    this.q = true;
                    break;
                case Transport:
                case Sport:
                    this.i = AMapLocationMode.Hight_Accuracy;
                    this.d = false;
                    this.o = false;
                    this.l = true;
                    this.e = false;
                    this.q = true;
                    break;
            }
        }
        return this;
    }

    public AMapLocationPurpose getLocationPurpose() {
        return this.w;
    }

    public String toString() {
        return "interval:" + String.valueOf(this.b) + "#" + "isOnceLocation:" + String.valueOf(this.d) + "#" + "locationMode:" + String.valueOf(this.i) + "#" + "locationProtocol:" + String.valueOf(j) + "#" + "isMockEnable:" + String.valueOf(this.e) + "#" + "isKillProcess:" + String.valueOf(this.k) + "#" + "isGpsFirst:" + String.valueOf(this.l) + "#" + "isNeedAddress:" + String.valueOf(this.f) + "#" + "isWifiActiveScan:" + String.valueOf(this.g) + "#" + "wifiScan:" + String.valueOf(this.q) + "#" + "httpTimeOut:" + String.valueOf(this.c) + "#" + "isLocationCacheEnable:" + String.valueOf(this.n) + "#" + "isOnceLocationLatest:" + String.valueOf(this.o) + "#" + "sensorEnable:" + String.valueOf(this.p) + "#" + "geoLanguage:" + String.valueOf(this.t) + "#" + "locationPurpose:" + String.valueOf(this.w) + "#";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.b);
        parcel.writeLong(this.c);
        parcel.writeByte(this.d ? (byte) 1 : 0);
        parcel.writeByte(this.e ? (byte) 1 : 0);
        parcel.writeByte(this.f ? (byte) 1 : 0);
        parcel.writeByte(this.g ? (byte) 1 : 0);
        parcel.writeByte(this.h ? (byte) 1 : 0);
        AMapLocationMode aMapLocationMode = this.i;
        int i3 = -1;
        parcel.writeInt(aMapLocationMode == null ? -1 : aMapLocationMode.ordinal());
        parcel.writeByte(this.k ? (byte) 1 : 0);
        parcel.writeByte(this.l ? (byte) 1 : 0);
        parcel.writeByte(this.m ? (byte) 1 : 0);
        parcel.writeByte(this.n ? (byte) 1 : 0);
        parcel.writeByte(this.o ? (byte) 1 : 0);
        parcel.writeByte(this.p ? (byte) 1 : 0);
        parcel.writeByte(this.q ? (byte) 1 : 0);
        parcel.writeLong(this.r);
        parcel.writeInt(j == null ? -1 : getLocationProtocol().ordinal());
        GeoLanguage geoLanguage = this.t;
        parcel.writeInt(geoLanguage == null ? -1 : geoLanguage.ordinal());
        parcel.writeByte(u ? (byte) 1 : 0);
        parcel.writeFloat(this.v);
        AMapLocationPurpose aMapLocationPurpose = this.w;
        if (aMapLocationPurpose != null) {
            i3 = aMapLocationPurpose.ordinal();
        }
        parcel.writeInt(i3);
        parcel.writeInt(OPEN_ALWAYS_SCAN_WIFI ? 1 : 0);
        parcel.writeLong(this.s);
    }

    public AMapLocationClientOption() {
        this.b = 2000;
        this.c = (long) vu.f;
        this.d = false;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = AMapLocationMode.Hight_Accuracy;
        this.k = false;
        this.l = false;
        this.m = true;
        this.n = true;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = 30000;
        this.s = 30000;
        this.t = GeoLanguage.DEFAULT;
        this.v = 0.0f;
        this.w = null;
    }

    protected AMapLocationClientOption(Parcel parcel) {
        this.b = 2000;
        this.c = (long) vu.f;
        boolean z = false;
        this.d = false;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = AMapLocationMode.Hight_Accuracy;
        this.k = false;
        this.l = false;
        this.m = true;
        this.n = true;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = 30000;
        this.s = 30000;
        this.t = GeoLanguage.DEFAULT;
        this.v = 0.0f;
        AMapLocationPurpose aMapLocationPurpose = null;
        this.w = null;
        this.b = parcel.readLong();
        this.c = parcel.readLong();
        this.d = parcel.readByte() != 0;
        this.e = parcel.readByte() != 0;
        this.f = parcel.readByte() != 0;
        this.g = parcel.readByte() != 0;
        this.h = parcel.readByte() != 0;
        int readInt = parcel.readInt();
        this.i = readInt == -1 ? AMapLocationMode.Hight_Accuracy : AMapLocationMode.values()[readInt];
        this.k = parcel.readByte() != 0;
        this.l = parcel.readByte() != 0;
        this.m = parcel.readByte() != 0;
        this.n = parcel.readByte() != 0;
        this.o = parcel.readByte() != 0;
        this.p = parcel.readByte() != 0;
        this.q = parcel.readByte() != 0;
        this.r = parcel.readLong();
        int readInt2 = parcel.readInt();
        j = readInt2 == -1 ? AMapLocationProtocol.HTTP : AMapLocationProtocol.values()[readInt2];
        int readInt3 = parcel.readInt();
        this.t = readInt3 == -1 ? GeoLanguage.DEFAULT : GeoLanguage.values()[readInt3];
        u = parcel.readByte() != 0;
        this.v = parcel.readFloat();
        int readInt4 = parcel.readInt();
        this.w = readInt4 != -1 ? AMapLocationPurpose.values()[readInt4] : aMapLocationPurpose;
        OPEN_ALWAYS_SCAN_WIFI = parcel.readByte() != 0 ? true : z;
        this.s = parcel.readLong();
    }

    public static boolean isOpenAlwaysScanWifi() {
        return OPEN_ALWAYS_SCAN_WIFI;
    }

    public static void setOpenAlwaysScanWifi(boolean z) {
        OPEN_ALWAYS_SCAN_WIFI = z;
    }

    public static void setScanWifiInterval(long j2) {
        SCAN_WIFI_INTERVAL = j2;
    }

    public long getScanWifiInterval() {
        return SCAN_WIFI_INTERVAL;
    }
}
