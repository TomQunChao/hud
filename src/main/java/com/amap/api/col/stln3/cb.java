package com.amap.api.col.stln3;

import android.location.Location;
import com.amap.api.maps.LocationSource;

/* compiled from: AMapOnLocationChangedListener */
final class cb implements LocationSource.OnLocationChangedListener {
    Location a;
    private co b;

    cb(co coVar) {
        this.b = coVar;
    }

    @Override // com.amap.api.maps.LocationSource.OnLocationChangedListener
    public final void onLocationChanged(Location location) {
        this.a = location;
        try {
            if (this.b.isMyLocationEnabled()) {
                this.b.a(location);
            }
        } catch (Throwable th) {
            rx.c(th, "AMapOnLocationChangedListener", "onLocationChanged");
            th.printStackTrace();
        }
    }
}
