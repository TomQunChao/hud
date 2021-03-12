package com.amap.api.navi.view;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.amap.api.col.stln3.kg;
import com.amap.api.navi.AMapNaviViewOptions;
import com.amap.api.navi.AmapRouteActivity;
import com.amap.api.navi.model.AMapNaviMarkerOptions;

public class LbsNaviView extends RelativeLayout {
    public static final int CAR_UP_MODE = 0;
    public static final int NORTH_UP_MODE = 1;
    private kg core;

    public LbsNaviView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public LbsNaviView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LbsNaviView(Context context) {
        super(context);
        init();
    }

    public LbsNaviView(Context context, AMapNaviViewOptions aMapNaviViewOptions) {
        super(context);
        init();
    }

    public void setNaviMode(int i) {
        this.core.a(i);
    }

    private void init() {
        this.core = new kg(this);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
            this.core.c();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onCreate(Bundle bundle) {
        this.core.a(bundle);
    }

    public final void onResume() {
        this.core.d();
    }

    public final void onPause() {
        this.core.e();
    }

    public final void onDestroy() {
        this.core.f();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        try {
            this.core.b(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void displayOverview() {
        this.core.g();
    }

    public boolean isTrafficLine() {
        return this.core.k();
    }

    public void setTrafficLine(boolean z) {
        this.core.b(z);
    }

    public boolean isOrientationLandscape() {
        return this.core.m();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            super.onLayout(z, i, i2, i3, i4);
            this.core.n();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isRouteOverviewNow() {
        return this.core.o();
    }

    public void setService(AmapRouteActivity amapRouteActivity) {
        this.core.a(amapRouteActivity);
    }

    public void showExitDialog() {
        kg kgVar = this.core;
        if (kgVar != null) {
            kgVar.p();
        }
    }

    public void setCustomNaviView(View view) {
        kg kgVar = this.core;
        if (kgVar != null && view != null) {
            kgVar.a(view);
        }
    }

    public void setCustomNaviBottomView(View view) {
        kg kgVar = this.core;
        if (kgVar != null && view != null) {
            kgVar.b(view);
        }
    }

    public void addPositionMarker(AMapNaviMarkerOptions aMapNaviMarkerOptions) {
        kg kgVar = this.core;
        if (kgVar != null) {
            kgVar.a(aMapNaviMarkerOptions);
        }
    }

    public void updateMarkerPosition(AMapNaviMarkerOptions aMapNaviMarkerOptions) {
        kg kgVar = this.core;
        if (kgVar != null) {
            kgVar.b(aMapNaviMarkerOptions);
        }
    }

    public void removePositionMarker(AMapNaviMarkerOptions aMapNaviMarkerOptions) {
        kg kgVar = this.core;
        if (kgVar != null) {
            kgVar.c(aMapNaviMarkerOptions);
        }
    }
}
