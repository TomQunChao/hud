package com.amap.api.col.stln3;

import android.content.Context;
import android.media.SoundPool;
import com.amap.api.maps.AMap;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.AmapNaviPage;
import com.amap.api.navi.INavi;
import com.amap.api.navi.INaviInfoCallback;
import com.amap.api.navi.MyNaviListener;
import com.amap.api.navi.core.view.BaseNaviView;
import com.amap.api.navi.model.AMapCalcRouteResult;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapModelCross;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviRouteNotifyData;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AMapNotAvoidInfo;
import com.amap.api.navi.model.AMapServiceAreaInfo;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.AmapCarLocation;
import com.amap.api.navi.model.InnerNaviInfo;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviPath;
import com.autonavi.ae.guide.model.NaviCongestionInfo;
import com.autonavi.tbt.TrafficFacilityInfo;
import java.io.IOException;

/* compiled from: LbsNaviUIController */
public final class kf implements MyNaviListener {
    BaseNaviView a;
    private int b = 1;
    private INavi c = null;
    private AMap d;
    private Context e;
    private kg f;
    private SoundPool g;
    private SoundPool h;
    private int i = 23;
    private int j = 15;
    private a k;
    private AMapNotAvoidInfo l;

    public kf(Context context, BaseNaviView baseNaviView, kg kgVar) {
        if (kgVar != null) {
            this.e = context.getApplicationContext();
            this.c = AMapNavi.getInstance(this.e);
            this.f = kgVar;
            this.a = baseNaviView;
            this.d = baseNaviView.getMap();
            AMap aMap = this.d;
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onArriveDestination() {
        if (this.b != 2) {
            this.f.l();
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onArrivedWayPoint(int i2) {
        String str = "NaviUIControl-->onArrivedWayPoint(" + i2 + ")";
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onCalculateRouteFailure(int i2) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onCalculateRouteSuccess(int[] iArr) {
    }

    public final void a() {
        SoundPool soundPool = this.g;
        if (soundPool != null) {
            soundPool.release();
        }
        this.g = null;
        SoundPool soundPool2 = this.h;
        if (soundPool2 != null) {
            soundPool2.release();
        }
        this.h = null;
        this.k = null;
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onEndEmulatorNavi() {
        try {
            this.f.U = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onGetNavigationText(int i2, String str) {
        String str2 = "NaviUIControl-->onGetNavigationText(),msg=" + str;
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onGetNavigationText(String str) {
        INaviInfoCallback callback;
        if (me.b() && me.a() && (callback = AmapNaviPage.getInstance().getCallback()) != null) {
            callback.onGetNavigationText(str);
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onInitNaviFailure() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onInitNaviSuccess() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onLocationChange(AMapNaviLocation aMapNaviLocation) {
        INavi iNavi;
        kg kgVar;
        if (aMapNaviLocation != null && (iNavi = this.c) != null && iNavi.getEngineType() == 0 && (kgVar = this.f) != null && kgVar.b != null) {
            int speed = (int) aMapNaviLocation.getSpeed();
            if (speed > 0) {
                this.f.b.setText(String.valueOf(speed));
            } else {
                this.f.b.setText("0");
            }
        }
    }

    public final InnerNaviInfo b() {
        return this.a.getLastNaviInfo();
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onNaviInfoUpdate(NaviInfo naviInfo) {
        boolean z = false;
        if (!(naviInfo.notAvoidInfo == null || (naviInfo.notAvoidInfo.forbidType == 0 && naviInfo.notAvoidInfo.type == 0))) {
            z = true;
        }
        if (z) {
            this.f.a(naviInfo.notAvoidInfo);
            this.l = naviInfo.notAvoidInfo;
            return;
        }
        this.f.t();
        this.l = null;
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onNaviInfoUpdated(AMapNaviInfo aMapNaviInfo) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void updateCameraInfo(AMapNaviCameraInfo[] aMapNaviCameraInfoArr) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onServiceAreaUpdate(AMapServiceAreaInfo[] aMapServiceAreaInfoArr) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void showCross(AMapNaviCross aMapNaviCross) {
        if (this.c.getNaviSetting().isCrossingDrawingEnabled()) {
            this.f.h();
            this.f.s();
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void hideCross() {
        if (this.c.getNaviSetting().isCrossingDrawingEnabled()) {
            this.f.i();
            if (this.l != null) {
                this.f.u();
            }
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void showModeCross(AMapModelCross aMapModelCross) {
        if (this.c.getNaviSetting().isCrossingDrawingEnabled()) {
            this.f.a(aMapModelCross);
            this.f.s();
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void hideModeCross() {
        if (this.c.getNaviSetting().isCrossingDrawingEnabled()) {
            this.f.j();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0059 A[Catch:{ Exception -> 0x012f }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005a A[Catch:{ Exception -> 0x012f }] */
    @Override // com.amap.api.navi.MyNaviListener
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onInnerNaviInfoUpdate(com.amap.api.navi.model.InnerNaviInfo r6) {
        /*
        // Method dump skipped, instructions count: 313
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.kf.onInnerNaviInfoUpdate(com.amap.api.navi.model.InnerNaviInfo):void");
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onReCalculateRouteForTrafficJam() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onReCalculateRouteForYaw() {
    }

    private void c() {
        this.f.c(false);
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onStartNavi(int i2) {
        this.b = i2;
        kg kgVar = this.f;
        kgVar.U = false;
        kgVar.a(true);
        this.f.r();
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onTrafficStatusUpdate() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onGpsOpenStatus(boolean z) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void showLaneInfo(AMapLaneInfo[] aMapLaneInfoArr, byte[] bArr, byte[] bArr2) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void showLaneInfo(AMapLaneInfo aMapLaneInfo) {
        this.f.a(aMapLaneInfo);
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void hideLaneInfo() {
        this.f.b();
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void notifyParallelRoad(int i2) {
        kg kgVar = this.f;
        if (kgVar != null) {
            kgVar.b(i2);
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo aMapNaviTrafficFacilityInfo) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo[] aMapNaviTrafficFacilityInfoArr) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void OnUpdateTrafficFacility(TrafficFacilityInfo trafficFacilityInfo) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void updateAimlessModeStatistics(AimLessModeStat aimLessModeStat) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void updateAimlessModeCongestionInfo(AimLessModeCongestionInfo aimLessModeCongestionInfo) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onPlayRing(int i2) {
        if (i2 != 1) {
            switch (i2) {
                case 100:
                    a(this.e, "ring/navi_warning.ogg");
                    return;
                case 101:
                    a(this.e, "ring/camera.ogg");
                    return;
                case 102:
                    a(this.e, "ring/edog_dingdong.mp3");
                    return;
                default:
                    return;
            }
        } else {
            a(this.e, "ring/autoreroute.ogg");
        }
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onGpsSignalWeak(boolean z) {
        kg kgVar = this.f;
        if (kgVar != null) {
            if (z) {
                kgVar.X.updateGpsStatus(true);
                this.f.b.setText("0");
                return;
            }
            kgVar.X.updateGpsStatus(false);
        }
    }

    private void a(Context context, String str) {
        try {
            if (this.g == null) {
                this.g = new SoundPool(5, 3, 5);
            }
            if (this.k == null) {
                this.k = new a();
            }
            this.g.setOnLoadCompleteListener(this.k);
            this.k.a(context, str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void carProjectionChange(AmapCarLocation amapCarLocation) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void updateIntervalCameraInfo(AMapNaviCameraInfo aMapNaviCameraInfo, AMapNaviCameraInfo aMapNaviCameraInfo2, int i2) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onStopNavi() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onCalculateRouteSuccess(AMapCalcRouteResult aMapCalcRouteResult) {
        kg kgVar = this.f;
        if (kgVar != null) {
            kgVar.q();
        }
        c();
        if (this.d == null || this.c == null) {
            String str = "NaviUIControl-->" + this.d;
            String str2 = "NaviUIControl-->" + this.c;
            return;
        }
        INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
        if (callback != null) {
            callback.onReCalculateRoute(aMapCalcRouteResult.getCalcRouteType());
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onCalculateRouteFailure(AMapCalcRouteResult aMapCalcRouteResult) {
        c();
        if (aMapCalcRouteResult.getCalcRouteType() == 3 || aMapCalcRouteResult.getCalcRouteType() == 12) {
            ma.a(this.e, lz.a(aMapCalcRouteResult.getErrorCode()));
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onNaviRouteNotify(AMapNaviRouteNotifyData aMapNaviRouteNotifyData) {
        kg kgVar = this.f;
        if (kgVar != null) {
            kgVar.a(aMapNaviRouteNotifyData);
        }
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onUpdateTmcStatus(NaviCongestionInfo naviCongestionInfo) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onSelectRouteId(int i2) {
        kg kgVar = this.f;
        if (kgVar != null) {
            kgVar.ak = i2;
        }
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onChangeNaviPath(int i2) {
        kg kgVar = this.f;
        if (kgVar != null) {
            kgVar.a();
        }
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onDeletePath(long[] jArr) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void updateBackupPath(NaviPath[] naviPathArr) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onSelectMainPathStatus(long j2) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onInnerNaviInfoUpdate(InnerNaviInfo[] innerNaviInfoArr) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onSuggestChangePath(long j2, long j3, int i2) {
        if (j2 != 0 && j2 != j3) {
            this.f.a(j2, i2);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: LbsNaviUIController */
    public class a implements SoundPool.OnLoadCompleteListener {
        private int b = -1;

        a() {
        }

        public final void a(Context context, String str) {
            try {
                this.b = kf.this.g.load(context.getAssets().openFd(str), 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
            kf.this.h = soundPool;
            soundPool.play(this.b, 1.0f, 1.0f, 1, 0, 1.0f);
        }
    }
}
