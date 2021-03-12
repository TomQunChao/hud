package com.amap.api.col.stln3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: GpsLocation */
public final class br {
    static AMapLocation j = null;
    static long k = 0;
    static Object l = new Object();
    static long q = 0;
    static boolean t = false;
    static boolean u = false;
    public AMapLocation A = null;
    private Context B;
    private long C = 0;
    private int D = 0;
    private GpsStatus.Listener E = new GpsStatus.Listener() {
        /* class com.amap.api.col.stln3.br.AnonymousClass2 */

        public final void onGpsStatusChanged(int i) {
            Iterable<GpsSatellite> satellites;
            try {
                if (br.this.b != null) {
                    br.this.z = br.this.b.getGpsStatus(br.this.z);
                    int i2 = 0;
                    switch (i) {
                        case 1:
                            return;
                        case 2:
                            br.this.y = 0;
                            return;
                        case 3:
                            return;
                        case 4:
                            try {
                                if (!(br.this.z == null || (satellites = br.this.z.getSatellites()) == null)) {
                                    Iterator<GpsSatellite> it = satellites.iterator();
                                    int maxSatellites = br.this.z.getMaxSatellites();
                                    while (it.hasNext() && i2 < maxSatellites) {
                                        if (it.next().usedInFix()) {
                                            i2++;
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                vu.a(th, "GpsLocation", "GPS_EVENT_SATELLITE_STATUS");
                            }
                            br.this.y = i2;
                            return;
                        default:
                            return;
                    }
                }
            } catch (Throwable th2) {
                vu.a(th2, "GpsLocation", "onGpsStatusChanged");
            }
        }
    };
    private String F = null;
    private boolean G = false;
    private int H = 0;
    private boolean I = false;
    Handler a;
    LocationManager b;
    AMapLocationClientOption c;
    long d = 0;
    boolean e = false;
    vb f = null;
    int g = GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN;
    int h = 80;
    AMapLocation i = null;
    long m = 0;
    float n = 0.0f;
    Object o = new Object();
    Object p = new Object();
    AMapLocationClientOption.GeoLanguage r = AMapLocationClientOption.GeoLanguage.DEFAULT;
    boolean s = true;
    long v = 0;
    int w = 0;
    LocationListener x = new LocationListener() {
        /* class com.amap.api.col.stln3.br.AnonymousClass1 */

        public final void onLocationChanged(Location location) {
            if (br.this.a != null) {
                br.this.a.removeMessages(8);
            }
            if (location != null) {
                try {
                    AMapLocation aMapLocation = new AMapLocation(location);
                    if (wc.a(aMapLocation)) {
                        aMapLocation.setProvider(GeocodeSearch.GPS);
                        aMapLocation.setLocationType(1);
                        if (!br.this.e && wc.a(aMapLocation)) {
                            vz.a(br.this.B, wc.b() - br.this.C, vu.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                            br.this.e = true;
                        }
                        if (wc.a(location, br.this.y)) {
                            aMapLocation.setMock(true);
                            aMapLocation.setTrustedLevel(4);
                            if (!br.this.c.isMockEnable()) {
                                if (br.this.w > 3) {
                                    vz.a((String) null, 2152);
                                    aMapLocation.setErrorCode(15);
                                    aMapLocation.setLocationDetail("GpsLocation has been mocked!#1501");
                                    aMapLocation.setLatitude(0.0d);
                                    aMapLocation.setLongitude(0.0d);
                                    aMapLocation.setAltitude(0.0d);
                                    aMapLocation.setSpeed(0.0f);
                                    aMapLocation.setAccuracy(0.0f);
                                    aMapLocation.setBearing(0.0f);
                                    aMapLocation.setExtras(null);
                                    br.this.b((br) aMapLocation);
                                    return;
                                }
                                br.this.w++;
                                return;
                            }
                        } else {
                            br.this.w = 0;
                        }
                        aMapLocation.setSatellites(br.this.y);
                        br.b(br.this, aMapLocation);
                        br.c(br.this, aMapLocation);
                        AMapLocation d = br.d(br.this, aMapLocation);
                        br.e(br.this, d);
                        br.this.a(d);
                        synchronized (br.this.o) {
                            br.a(br.this, d, br.this.A);
                        }
                        try {
                            if (wc.a(d)) {
                                if (br.this.i != null) {
                                    br.this.m = location.getTime() - br.this.i.getTime();
                                    br.this.n = wc.a(br.this.i, d);
                                }
                                synchronized (br.this.p) {
                                    br.this.i = d.clone();
                                }
                                br.this.F = null;
                                br.this.G = false;
                                br.this.H = 0;
                            }
                        } catch (Throwable th) {
                            vu.a(th, "GpsLocation", "onLocationChangedLast");
                        }
                        br.this.b((br) d);
                    }
                } catch (Throwable th2) {
                    vu.a(th2, "GpsLocation", "onLocationChanged");
                }
            }
        }

        public final void onProviderDisabled(String str) {
            try {
                if (GeocodeSearch.GPS.equalsIgnoreCase(str)) {
                    br.this.d = 0;
                    br.this.y = 0;
                }
            } catch (Throwable th) {
            }
        }

        public final void onProviderEnabled(String str) {
        }

        public final void onStatusChanged(String str, int i, Bundle bundle) {
            if (i == 0) {
                try {
                    br.this.d = 0;
                    br.this.y = 0;
                } catch (Throwable th) {
                }
            }
        }
    };
    int y = 0;
    GpsStatus z = null;

    static /* synthetic */ void a(br brVar, AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 != null && brVar.c.isNeedAddress() && wc.a(aMapLocation, aMapLocation2) < ((float) brVar.g)) {
            vu.a(aMapLocation, aMapLocation2);
        }
    }

    static /* synthetic */ void b(br brVar, AMapLocation aMapLocation) {
        try {
            if (!vu.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) || !brVar.c.isOffset()) {
                aMapLocation.setOffset(false);
                aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
                return;
            }
            DPoint a2 = vv.a(brVar.B, new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
            aMapLocation.setLatitude(a2.getLatitude());
            aMapLocation.setLongitude(a2.getLongitude());
            aMapLocation.setOffset(brVar.c.isOffset());
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
        } catch (Throwable th) {
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
        }
    }

    static /* synthetic */ void c(br brVar, AMapLocation aMapLocation) {
        try {
            if (brVar.y >= 4) {
                aMapLocation.setGpsAccuracyStatus(1);
            } else if (brVar.y == 0) {
                aMapLocation.setGpsAccuracyStatus(-1);
            } else {
                aMapLocation.setGpsAccuracyStatus(0);
            }
        } catch (Throwable th) {
        }
    }

    static /* synthetic */ AMapLocation d(br brVar, AMapLocation aMapLocation) {
        if (!wc.a(aMapLocation) || brVar.D < 3) {
            return aMapLocation;
        }
        if (aMapLocation.getAccuracy() < 0.0f || aMapLocation.getAccuracy() == Float.MAX_VALUE) {
            aMapLocation.setAccuracy(0.0f);
        }
        if (aMapLocation.getSpeed() < 0.0f || aMapLocation.getSpeed() == Float.MAX_VALUE) {
            aMapLocation.setSpeed(0.0f);
        }
        return brVar.f.a(aMapLocation);
    }

    static /* synthetic */ void e(br brVar, AMapLocation aMapLocation) {
        if (wc.a(aMapLocation)) {
            brVar.d = wc.b();
            synchronized (l) {
                k = wc.b();
                j = aMapLocation.clone();
            }
            brVar.D++;
        }
    }

    public br(Context context, Handler handler) {
        this.B = context;
        this.a = handler;
        try {
            this.b = (LocationManager) this.B.getSystemService("location");
        } catch (Throwable th) {
            vu.a(th, "GpsLocation", "<init>");
        }
        this.f = new vb();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0103, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0104, code lost:
        r8.s = false;
        com.amap.api.col.stln3.vz.a((java.lang.String) null, 2121);
        a(2, 12, r0.getMessage() + "#1201", 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x012a, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0103 A[ExcHandler: SecurityException (r0v0 'e' java.lang.SecurityException A[CUSTOM_DECLARE]), Splitter:B:10:0x0025] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.amap.api.location.AMapLocationClientOption r9) {
        /*
        // Method dump skipped, instructions count: 299
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.br.a(com.amap.api.location.AMapLocationClientOption):void");
    }

    public final void b(AMapLocationClientOption aMapLocationClientOption) {
        Handler handler;
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        this.c = aMapLocationClientOption;
        if (!(this.c.getLocationMode() == AMapLocationClientOption.AMapLocationMode.Device_Sensors || (handler = this.a) == null)) {
            handler.removeMessages(8);
        }
        if (this.r != this.c.getGeoLanguage()) {
            synchronized (this.o) {
                this.A = null;
            }
        }
        this.r = this.c.getGeoLanguage();
    }

    public final void a() {
        LocationManager locationManager = this.b;
        if (locationManager != null) {
            try {
                if (this.x != null) {
                    locationManager.removeUpdates(this.x);
                }
            } catch (Throwable th) {
            }
            try {
                if (this.E != null) {
                    this.b.removeGpsStatusListener(this.E);
                }
            } catch (Throwable th2) {
            }
            try {
                if (this.a != null) {
                    this.a.removeMessages(8);
                }
            } catch (Throwable th3) {
            }
            this.y = 0;
            this.C = 0;
            this.v = 0;
            this.d = 0;
            this.D = 0;
            this.w = 0;
            this.f.a();
            this.i = null;
            this.m = 0;
            this.n = 0.0f;
            this.F = null;
            this.I = false;
        }
    }

    private static boolean a(LocationManager locationManager) {
        try {
            if (t) {
                return u;
            }
            List<String> allProviders = locationManager.getAllProviders();
            if (allProviders == null || allProviders.size() <= 0) {
                u = false;
            } else {
                u = allProviders.contains(GeocodeSearch.GPS);
            }
            t = true;
            return u;
        } catch (Throwable th) {
            return u;
        }
    }

    private void a(int i2, int i3, String str, long j2) {
        try {
            if (this.a != null && this.c.getLocationMode() == AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
                Message obtain = Message.obtain();
                AMapLocation aMapLocation = new AMapLocation("");
                aMapLocation.setProvider(GeocodeSearch.GPS);
                aMapLocation.setErrorCode(i3);
                aMapLocation.setLocationDetail(str);
                aMapLocation.setLocationType(1);
                obtain.obj = aMapLocation;
                obtain.what = i2;
                this.a.sendMessageDelayed(obtain, j2);
            }
        } catch (Throwable th) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(AMapLocation aMapLocation) {
        if (wc.a(aMapLocation) && this.a != null && this.c.isNeedAddress()) {
            long b2 = wc.b();
            if (this.c.getInterval() <= 8000 || b2 - this.v > this.c.getInterval() - 8000) {
                Bundle bundle = new Bundle();
                bundle.putDouble("lat", aMapLocation.getLatitude());
                bundle.putDouble("lon", aMapLocation.getLongitude());
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = 5;
                synchronized (this.o) {
                    if (this.A == null) {
                        this.a.sendMessage(obtain);
                    } else if (wc.a(aMapLocation, this.A) > ((float) this.h)) {
                        this.a.sendMessage(obtain);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() == 15 && !AMapLocationClientOption.AMapLocationMode.Device_Sensors.equals(this.c.getLocationMode())) {
            return;
        }
        if (this.c.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.c.getDeviceModeDistanceFilter() > 0.0f) {
            c(aMapLocation);
        } else if (wc.b() - this.v >= this.c.getInterval() - 200) {
            this.v = wc.b();
            c(aMapLocation);
        }
    }

    private void c(AMapLocation aMapLocation) {
        if (this.a != null) {
            Message obtain = Message.obtain();
            obtain.obj = aMapLocation;
            obtain.what = 2;
            this.a.sendMessage(obtain);
        }
    }

    public final boolean b() {
        if (wc.b() - this.d > 2800) {
            return false;
        }
        return true;
    }

    public final void a(Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                this.g = bundle.getInt("I_MAX_GEO_DIS");
                this.h = bundle.getInt("I_MIN_GEO_DIS");
                AMapLocation aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                if (!TextUtils.isEmpty(aMapLocation.getAdCode())) {
                    synchronized (this.o) {
                        this.A = aMapLocation;
                    }
                }
            } catch (Throwable th) {
                vu.a(th, "GpsLocation", "setLastGeoLocation");
            }
        }
    }

    public final void c() {
        this.w = 0;
    }

    public final AMapLocation a(AMapLocation aMapLocation, String str) {
        if (this.i == null) {
            return aMapLocation;
        }
        if ((!this.c.isMockEnable() && this.i.isMock()) || !wc.a(this.i)) {
            return aMapLocation;
        }
        AMapLocation h2 = h();
        if (h2 == null || !wc.a(h2)) {
            float speed = this.i.getSpeed();
            if (speed == 0.0f) {
                long j2 = this.m;
                if (j2 > 0 && j2 < 8) {
                    float f2 = this.n;
                    if (f2 > 0.0f) {
                        speed = f2 / ((float) j2);
                    }
                }
            }
            long j3 = 30000;
            if (aMapLocation != null && wc.a(aMapLocation)) {
                if (aMapLocation.getAccuracy() < 200.0f) {
                    this.H++;
                    if (this.F == null && this.H >= 2) {
                        this.G = true;
                    }
                    j3 = speed > 5.0f ? 10000 : 15000;
                } else {
                    if (!TextUtils.isEmpty(this.F)) {
                        this.G = false;
                        this.H = 0;
                    }
                    if (speed > 5.0f) {
                        j3 = 20000;
                    }
                }
            }
            if (wc.b() - this.d < j3) {
                if (this.F == null && this.H >= 2) {
                    this.F = str;
                }
                AMapLocation clone = this.i.clone();
                clone.setTrustedLevel(2);
                return clone;
            } else if (!this.G || !a(str)) {
                this.F = null;
                this.H = 0;
                synchronized (this.p) {
                    this.i = null;
                }
                this.m = 0;
                this.n = 0.0f;
                return aMapLocation;
            } else {
                AMapLocation clone2 = this.i.clone();
                clone2.setTrustedLevel(3);
                return clone2;
            }
        } else {
            h2.setTrustedLevel(2);
            return h2;
        }
    }

    private boolean a(String str) {
        try {
            ArrayList<String> d2 = wc.d(str);
            ArrayList<String> d3 = wc.d(this.F);
            if (d2 == null || d2.size() < 8 || d3 == null || d3.size() < 8) {
                return false;
            }
            return wc.a(this.F, str);
        } catch (Throwable th) {
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public final int d() {
        LocationManager locationManager = this.b;
        if (locationManager == null || !a(locationManager)) {
            return 1;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            int i2 = Settings.Secure.getInt(this.B.getContentResolver(), "location_mode", 0);
            if (i2 == 0) {
                return 2;
            }
            if (i2 == 2) {
                return 3;
            }
        } else if (!this.b.isProviderEnabled(GeocodeSearch.GPS)) {
            return 2;
        }
        if (!this.s) {
            return 4;
        }
        return 0;
    }

    public final int e() {
        return this.y;
    }

    private static boolean g() {
        try {
            return ((Boolean) vx.a(rk.c("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), rk.c("UaXNOYXZpU3RhcnRlZA=="), (Object[]) null, (Class<?>[]) null)).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    private AMapLocation h() {
        float f2;
        float f3;
        try {
            if (wc.a(this.i) && vt.z() && g()) {
                JSONObject jSONObject = new JSONObject((String) vx.a(rk.c("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), rk.c("UZ2V0TmF2aUxvY2F0aW9u"), (Object[]) null, (Class<?>[]) null));
                long optLong = jSONObject.optLong("time");
                if (!this.I) {
                    this.I = true;
                    vz.a("useNaviLoc", "use NaviLoc");
                }
                if (wc.a() - optLong <= 5500) {
                    double optDouble = jSONObject.optDouble("lat", 0.0d);
                    double optDouble2 = jSONObject.optDouble("lng", 0.0d);
                    float f4 = 0.0f;
                    try {
                        f2 = Float.parseFloat(jSONObject.optString("accuracy", "0"));
                    } catch (NumberFormatException e2) {
                        f2 = 0.0f;
                    }
                    double optDouble3 = jSONObject.optDouble("altitude", 0.0d);
                    try {
                        f3 = Float.parseFloat(jSONObject.optString("bearing", "0"));
                    } catch (NumberFormatException e3) {
                        f3 = 0.0f;
                    }
                    try {
                        f4 = Float.parseFloat(jSONObject.optString("speed", "0"));
                    } catch (NumberFormatException e4) {
                    }
                    AMapLocation aMapLocation = new AMapLocation("lbs");
                    aMapLocation.setLocationType(9);
                    aMapLocation.setLatitude(optDouble);
                    aMapLocation.setLongitude(optDouble2);
                    aMapLocation.setAccuracy(f2);
                    aMapLocation.setAltitude(optDouble3);
                    aMapLocation.setBearing(f3);
                    aMapLocation.setSpeed(f4);
                    aMapLocation.setTime(optLong);
                    aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
                    if (wc.a(aMapLocation, this.i) > 300.0f) {
                        return null;
                    }
                    synchronized (this.p) {
                        this.i.setLongitude(optDouble2);
                        this.i.setLatitude(optDouble);
                        this.i.setAccuracy(f2);
                        this.i.setBearing(f3);
                        this.i.setSpeed(f4);
                        this.i.setTime(optLong);
                        this.i.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
                    }
                    return aMapLocation;
                }
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public final boolean f() {
        if (wc.b() - this.d > 300000) {
            return true;
        }
        return false;
    }
}
