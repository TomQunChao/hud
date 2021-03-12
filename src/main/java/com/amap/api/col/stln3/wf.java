package com.amap.api.col.stln3;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import java.lang.reflect.Constructor;

/* compiled from: MapGpsLocation */
public final class wf {
    Context a;
    LocationManager b;
    volatile long c = 0;
    volatile boolean d = false;
    boolean e = false;
    volatile Inner_3dMap_location f = null;
    Object g = null;
    boolean h = false;
    boolean i = false;
    LocationListener j = new LocationListener() {
        /* class com.amap.api.col.stln3.wf.AnonymousClass1 */

        public final void onLocationChanged(Location location) {
            if (location != null) {
                try {
                    Inner_3dMap_location inner_3dMap_location = new Inner_3dMap_location(location);
                    inner_3dMap_location.setLocationType(1);
                    Bundle extras = location.getExtras();
                    int i = 0;
                    if (extras != null) {
                        i = extras.getInt("satellites");
                    }
                    inner_3dMap_location.setSatellites(i);
                    wf.this.f = inner_3dMap_location;
                    wf.this.c = xb.b();
                    wf.this.d = true;
                } catch (Throwable th) {
                    wy.a(th, "MAPGPSLocation", "onLocationChanged");
                }
            }
        }

        public final void onProviderDisabled(String str) {
            try {
                if (GeocodeSearch.GPS.equals(str)) {
                    wf.this.d = false;
                }
            } catch (Throwable th) {
                wy.a(th, "MAPGPSLocation", "onProviderDisabled");
            }
        }

        public final void onProviderEnabled(String str) {
        }

        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }
    };

    public wf(Context context) {
        Object newInstance;
        if (context != null) {
            this.a = context;
            try {
                if (Class.forName("com.amap.api.maps.CoordinateConverter") != null) {
                    this.h = true;
                }
            } catch (Throwable th) {
            }
            try {
                if (this.g == null && !this.i) {
                    if (this.h) {
                        newInstance = Class.forName("com.amap.api.maps.CoordinateConverter").getConstructor(Context.class).newInstance(context);
                    } else {
                        newInstance = Class.forName("com.amap.api.maps2d.CoordinateConverter").getConstructor(new Class[0]).newInstance(new Object[0]);
                    }
                    this.g = newInstance;
                    if (context == null) {
                        this.i = true;
                    }
                }
            } catch (Throwable th2) {
            }
            if (this.b == null) {
                this.b = (LocationManager) this.a.getSystemService("location");
            }
        }
    }

    public final void a() {
        LocationListener locationListener;
        this.e = false;
        this.d = false;
        this.c = 0;
        this.f = null;
        LocationManager locationManager = this.b;
        if (locationManager != null && (locationListener = this.j) != null) {
            locationManager.removeUpdates(locationListener);
        }
    }

    public final Inner_3dMap_location b() {
        double[] a2;
        Object a3;
        Constructor<?> constructor;
        Object[] objArr;
        if (this.f == null) {
            return null;
        }
        Inner_3dMap_location clone = this.f.clone();
        if (clone != null && clone.getErrorCode() == 0) {
            try {
                if (this.g != null) {
                    if (wy.a(clone.getLatitude(), clone.getLongitude())) {
                        Object[] objArr2 = {"GPS"};
                        Class[] clsArr = {String.class};
                        if (this.h) {
                            a3 = wz.a("com.amap.api.maps.CoordinateConverter$CoordType", "valueOf", objArr2, clsArr);
                            constructor = Class.forName("com.amap.api.maps.model.LatLng").getConstructor(Double.TYPE, Double.TYPE);
                            objArr = new Object[]{Double.valueOf(clone.getLatitude()), Double.valueOf(clone.getLongitude())};
                        } else {
                            a3 = wz.a("com.amap.api.maps2d.CoordinateConverter$CoordType", "valueOf", objArr2, clsArr);
                            constructor = Class.forName("com.amap.api.maps2d.model.LatLng").getConstructor(Double.TYPE, Double.TYPE);
                            objArr = new Object[]{Double.valueOf(clone.getLatitude()), Double.valueOf(clone.getLongitude())};
                        }
                        wz.a(this.g, "coord", constructor.newInstance(objArr));
                        wz.a(this.g, "from", a3);
                        Object a4 = wz.a(this.g, "convert", new Object[0]);
                        double doubleValue = ((Double) a4.getClass().getDeclaredField("latitude").get(a4)).doubleValue();
                        double doubleValue2 = ((Double) a4.getClass().getDeclaredField("longitude").get(a4)).doubleValue();
                        clone.setLatitude(doubleValue);
                        clone.setLongitude(doubleValue2);
                    }
                } else if (this.i && wy.a(clone.getLatitude(), clone.getLongitude()) && (a2 = xc.a(clone.getLongitude(), clone.getLatitude())) != null) {
                    clone.setLatitude(a2[1]);
                    clone.setLongitude(a2[0]);
                }
            } catch (Throwable th) {
            }
        }
        return clone;
    }
}
