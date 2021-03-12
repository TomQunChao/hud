package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.navi.MyNaviListener;
import com.amap.api.navi.model.AMapCalcRouteResult;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapModelCross;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviRouteNotifyData;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AMapServiceAreaInfo;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.AmapCarLocation;
import com.amap.api.navi.model.InnerNaviInfo;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviPath;
import com.autonavi.ae.guide.model.NaviCongestionInfo;
import com.autonavi.tbt.TrafficFacilityInfo;

/* compiled from: TtsController */
public final class md implements MyNaviListener {
    public static md a;
    private Context b;
    private mc c = null;
    private ja d;
    private boolean e = false;

    private md(Context context) {
        this.b = context.getApplicationContext();
        this.c = new mc(this.b);
        mc mcVar = this.c;
        if (mcVar != null) {
            mcVar.a();
            mc mcVar2 = this.c;
            mc.d();
        }
    }

    public static md a(Context context) {
        if (a == null) {
            a = new md(context);
        }
        return a;
    }

    public final void a() {
        mc mcVar = this.c;
        if (mcVar != null) {
            mcVar.b();
        }
        mh.a(this.b).b();
    }

    public final void b() {
        mc mcVar = this.c;
        if (mcVar != null) {
            mcVar.e();
        }
        mh.a(this.b).e();
    }

    public final void c() {
        mc mcVar = this.c;
        if (mcVar != null) {
            mcVar.c();
            this.c = null;
        }
        mh.a(this.b).c();
        a = null;
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onArriveDestination() {
        mc mcVar = this.c;
        if (mcVar != null) {
            mcVar.f();
        }
    }

    public final void a(int i) {
        mc mcVar = this.c;
        if (mcVar != null) {
            mcVar.a(i);
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onArrivedWayPoint(int i) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onCalculateRouteFailure(int i) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onEndEmulatorNavi() {
        mc mcVar = this.c;
        if (mcVar != null) {
            mcVar.f();
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onGetNavigationText(int i, String str) {
        String str2 = "arg1 = " + str;
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onInitNaviFailure() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onInitNaviSuccess() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onLocationChange(AMapNaviLocation aMapNaviLocation) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onReCalculateRouteForTrafficJam() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onReCalculateRouteForYaw() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onStartNavi(int i) {
        b();
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onTrafficStatusUpdate() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onGpsOpenStatus(boolean z) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onNaviInfoUpdate(NaviInfo naviInfo) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onNaviInfoUpdated(AMapNaviInfo aMapNaviInfo) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void updateCameraInfo(AMapNaviCameraInfo[] aMapNaviCameraInfoArr) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void updateIntervalCameraInfo(AMapNaviCameraInfo aMapNaviCameraInfo, AMapNaviCameraInfo aMapNaviCameraInfo2, int i) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onServiceAreaUpdate(AMapServiceAreaInfo[] aMapServiceAreaInfoArr) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void showCross(AMapNaviCross aMapNaviCross) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void hideCross() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void showLaneInfo(AMapLaneInfo[] aMapLaneInfoArr, byte[] bArr, byte[] bArr2) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void showLaneInfo(AMapLaneInfo aMapLaneInfo) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void hideLaneInfo() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onCalculateRouteSuccess(int[] iArr) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void notifyParallelRoad(int i) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo aMapNaviTrafficFacilityInfo) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo[] aMapNaviTrafficFacilityInfoArr) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void updateAimlessModeStatistics(AimLessModeStat aimLessModeStat) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void updateAimlessModeCongestionInfo(AimLessModeCongestionInfo aimLessModeCongestionInfo) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onPlayRing(int i) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onGetNavigationText(String str) {
        ja jaVar = this.d;
        if (jaVar != null && !jaVar.a()) {
            return;
        }
        if (!mf.a() || !mf.b() || !mh.a(this.b).d()) {
            if (this.e && this.c != null) {
                mh.a(this.b).b();
                this.c.e();
            }
            this.e = false;
            mc mcVar = this.c;
            if (mcVar != null) {
                mcVar.a(str);
                return;
            }
            return;
        }
        mc mcVar2 = this.c;
        if (mcVar2 != null && !this.e) {
            mcVar2.b();
            mh.a(this.b).e();
        }
        mh.a(this.b).a(str);
        this.e = true;
    }

    @Override // com.amap.api.navi.AMapNaviListener
    @Deprecated
    public final void OnUpdateTrafficFacility(TrafficFacilityInfo trafficFacilityInfo) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void showModeCross(AMapModelCross aMapModelCross) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void hideModeCross() {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void carProjectionChange(AmapCarLocation amapCarLocation) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onInnerNaviInfoUpdate(InnerNaviInfo innerNaviInfo) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onGpsSignalWeak(boolean z) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onStopNavi() {
        a();
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onCalculateRouteSuccess(AMapCalcRouteResult aMapCalcRouteResult) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onCalculateRouteFailure(AMapCalcRouteResult aMapCalcRouteResult) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onUpdateTmcStatus(NaviCongestionInfo naviCongestionInfo) {
    }

    public final void a(ja jaVar) {
        this.d = jaVar;
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onSelectRouteId(int i) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onChangeNaviPath(int i) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onDeletePath(long[] jArr) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void updateBackupPath(NaviPath[] naviPathArr) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onSelectMainPathStatus(long j) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onInnerNaviInfoUpdate(InnerNaviInfo[] innerNaviInfoArr) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onSuggestChangePath(long j, long j2, int i) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onNaviRouteNotify(AMapNaviRouteNotifyData aMapNaviRouteNotifyData) {
    }
}
