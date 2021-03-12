package com.amap.api.offlineservice;

import android.view.View;
import android.widget.RelativeLayout;
import com.amap.api.maps.offlinemap.OfflineMapActivity;

/* compiled from: ServiceModule */
public abstract class a {
    protected OfflineMapActivity a = null;

    public abstract void a(View view);

    public abstract void b();

    public abstract RelativeLayout d();

    public abstract void e();

    public final void a(OfflineMapActivity offlineMapActivity) {
        this.a = offlineMapActivity;
    }

    public final void a() {
        this.a.showScr();
    }

    public boolean c() {
        return true;
    }

    public final int a(float f) {
        OfflineMapActivity offlineMapActivity = this.a;
        if (offlineMapActivity != null) {
            return (int) ((f * (((float) offlineMapActivity.getResources().getDisplayMetrics().densityDpi) / 160.0f)) + 0.5f);
        }
        return (int) f;
    }
}
