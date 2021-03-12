package com.amap.api.col.stln3;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.AMapNaviListener;
import com.amap.api.navi.AmapNaviPage;
import com.amap.api.navi.INaviInfoCallback;
import com.amap.api.navi.R;
import com.amap.api.navi.model.AMapCalcRouteResult;
import com.amap.api.navi.model.AMapCarInfo;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapModelCross;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviMarkerOptions;
import com.amap.api.navi.model.AMapNaviRouteNotifyData;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AMapServiceAreaInfo;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.view.LbsNaviView;
import com.autonavi.tbt.TrafficFacilityInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: NaviPage */
public final class ks extends ke implements AMapNaviListener {
    boolean h = false;
    private LbsNaviView i;
    private AMapNavi j;
    private View k;
    private ug l;
    private JSONObject m;
    private boolean n = false;
    private int o;
    private Dialog p;
    private boolean q = false;
    private boolean r = true;
    private boolean s = true;
    private boolean t = true;
    private int u = 12;
    private List<Poi> v;

    @Override // com.amap.api.col.stln3.ke
    public final void a(Bundle bundle) {
        AMapCarInfo g;
        super.a(bundle);
        this.n = false;
        if (this.g.orientation != this.g.defaultOrientation) {
            this.g.setRequestedOrientation(this.g.orientation);
        }
        this.i = (LbsNaviView) this.k.findViewById(R.id.navi_sdk_navi_view);
        this.i.setService(this.g);
        this.i.onCreate(bundle);
        if (AmapNaviPage.getInstance().getCallback() != null) {
            View customNaviView = AmapNaviPage.getInstance().getCallback().getCustomNaviView();
            if (customNaviView != null) {
                this.i.setCustomNaviView(customNaviView);
            }
            View customNaviBottomView = AmapNaviPage.getInstance().getCallback().getCustomNaviBottomView();
            if (customNaviBottomView != null) {
                this.i.setCustomNaviBottomView(customNaviBottomView);
            }
        }
        this.j = AMapNavi.getInstance(this.g);
        this.j.addAMapNaviListener(this);
        if (bundle != null) {
            this.o = bundle.getInt("navi_mode", 1);
            this.h = bundle.getBoolean(AmapNaviPage.PAGE_TYPE, false);
            this.r = bundle.getBoolean(AmapNaviPage.ISNEEDCALCULATEROUTEWHENPRESENT, true);
            this.t = bundle.getBoolean(AmapNaviPage.ISSHOWEXITNAVIDIALOG, true);
            this.s = bundle.getBoolean(AmapNaviPage.ISNEEDDESTROYDRIVEMANAGERINSTANCEWHENNAVIEXIT, true);
            this.u = mo.a(this.g);
            this.j.getNaviSetting().setCrossingDrawingEnabled(bundle.getBoolean(AmapNaviPage.SHOWCROSSIMAGE, true));
        }
        if (this.o == -1) {
            this.o = 1;
        }
        try {
            if (this.o == 1) {
                this.l = new ug(this.g.getApplicationContext(), "navi", "6.5.0", "O001");
                this.m = new JSONObject();
                this.m.put("time", System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.h) {
            if (this.r) {
                if (!(this.g == null || this.g.getSearchResult() == null || (g = this.g.getSearchResult().g()) == null)) {
                    this.j.setCarInfo(g);
                }
                Poi poi = (Poi) bundle.getParcelable(AmapNaviPage.POI_START);
                Poi poi2 = (Poi) bundle.getParcelable(AmapNaviPage.POI_END);
                this.v = new ArrayList();
                Poi poi3 = (Poi) bundle.getParcelable(AmapNaviPage.POI_WAY1);
                Poi poi4 = (Poi) bundle.getParcelable(AmapNaviPage.POI_WAY2);
                Poi poi5 = (Poi) bundle.getParcelable(AmapNaviPage.POI_WAY3);
                this.v.clear();
                if (poi3 != null) {
                    this.v.add(poi3);
                }
                if (poi4 != null) {
                    this.v.add(poi4);
                }
                if (poi5 != null) {
                    this.v.add(poi5);
                }
                this.q = true;
                c();
                a(poi, poi2, this.v, this.u);
            } else if (this.j.getNaviPaths() == null || this.j.getNaviPaths().get(12) == null) {
                Dialog a = a(this.g, 28);
                if (a != null) {
                    a.show();
                }
            }
            mq.b(this.g);
        }
        this.j.stopNavi();
        this.j.startNavi(this.o);
        mq.b(this.g);
    }

    private void a(Poi poi, Poi poi2, List<Poi> list, int i2) {
        this.j.calculateDriveRoute(poi, poi2, list, i2);
    }

    @Override // com.amap.api.col.stln3.ke
    public final void a() {
    }

    @Override // com.amap.api.col.stln3.ke
    public final void a(View view) {
        try {
            if (view.getId() == 2147479647) {
                if (this.g != null) {
                    int a = mo.a(this.g);
                    this.p.dismiss();
                    if (this.r) {
                        a(null, this.g.getSearchResult().f(), this.v, a);
                    }
                }
            }
            if (view.getId() == 2147479645) {
                this.p.dismiss();
                this.g.closeScr();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.col.stln3.ke
    public final boolean b() {
        if (this.t) {
            LbsNaviView lbsNaviView = this.i;
            if (lbsNaviView == null) {
                return false;
            }
            lbsNaviView.showExitDialog();
            return false;
        }
        INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
        if (callback != null) {
            callback.onExitPage(1);
        }
        return true;
    }

    private Dialog a(Context context, int i2) {
        try {
            if (this.p == null) {
                this.p = new Dialog(context);
                this.p.requestWindowFeature(1);
                this.p.getWindow().setBackgroundDrawableResource(17170445);
            }
            View a = mm.a(this.g, R.layout.amap_navi_lbs_exit_dialog, null);
            TextView textView = (TextView) a.findViewById(R.id.navi_sdk_lbs_dialog_cancle);
            TextView textView2 = (TextView) a.findViewById(R.id.navi_sdk_lbs_dialog_ok);
            View findViewById = a.findViewById(R.id.navi_sdk_view_split_line);
            textView.setOnClickListener(this.g);
            textView2.setOnClickListener(this.g);
            this.p.setContentView(a);
            this.p.setCancelable(false);
            ((TextView) a.findViewById(R.id.navi_sdk_strategy_select_title)).setText(lz.a(i2));
            textView.setText("退出");
            if (i2 == 28) {
                textView2.setVisibility(8);
                findViewById.setVisibility(8);
                this.p.setCancelable(false);
            }
            textView2.setText("重试");
            return this.p;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.stln3.ke
    public final View e() {
        this.k = mm.a(this.g, R.layout.amap_navi_lbs_activity_navi, null);
        return this.k;
    }

    @Override // com.amap.api.col.stln3.ke
    public final void g() {
        super.g();
        this.i.onResume();
    }

    @Override // com.amap.api.col.stln3.ke
    public final void i() {
        super.i();
        this.i.onPause();
    }

    @Override // com.amap.api.col.stln3.ke
    public final void f() {
        this.i.onDestroy();
        this.j.removeAMapNaviListener(this);
        if (this.s) {
            this.j.stopNavi();
        }
        AMapNavi.setTtsPlaying(false);
        INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
        if (callback != null) {
            callback.onStopSpeaking();
        }
        try {
            if (this.o == 1) {
                if (this.m != null) {
                    this.m.put("isnavi", this.n ? "1" : "0");
                    this.l.a(this.m.toString());
                }
                uh.a(this.l, this.g.getApplicationContext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onGetNavigationText(int i2, String str) {
        INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
        if (callback != null) {
            callback.onGetNavigationText(str);
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onGetNavigationText(String str) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onInitNaviFailure() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onInitNaviSuccess() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onStartNavi(int i2) {
        INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
        if (callback != null) {
            callback.onStartNavi(i2);
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onTrafficStatusUpdate() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onLocationChange(AMapNaviLocation aMapNaviLocation) {
        INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
        if (callback != null) {
            callback.onLocationChange(aMapNaviLocation);
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onEndEmulatorNavi() {
        INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
        if (callback != null) {
            callback.onArriveDestination(true);
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onArriveDestination() {
        try {
            INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
            if (callback != null) {
                callback.onArriveDestination(false);
            }
            if (this.o == 1) {
                this.n = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onCalculateRouteSuccess(int[] iArr) {
        if (this.h) {
            this.j.startNavi(this.o);
            d();
            this.q = false;
        }
        INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
        if (callback != null) {
            callback.onCalculateRouteSuccess(iArr);
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onCalculateRouteFailure(int i2) {
        Dialog a;
        if (this.h) {
            d();
            if (this.q && (a = a(this.g, i2)) != null) {
                a.show();
            }
        }
        INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
        if (callback != null) {
            callback.onCalculateRouteFailure(i2);
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onReCalculateRouteForYaw() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onReCalculateRouteForTrafficJam() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onArrivedWayPoint(int i2) {
        INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
        if (callback != null) {
            callback.onArrivedWayPoint(i2);
        }
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
    public final void onServiceAreaUpdate(AMapServiceAreaInfo[] aMapServiceAreaInfoArr) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void showCross(AMapNaviCross aMapNaviCross) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void hideCross() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void showModeCross(AMapModelCross aMapModelCross) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void hideModeCross() {
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
    public final void notifyParallelRoad(int i2) {
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
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void updateIntervalCameraInfo(AMapNaviCameraInfo aMapNaviCameraInfo, AMapNaviCameraInfo aMapNaviCameraInfo2, int i2) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onCalculateRouteSuccess(AMapCalcRouteResult aMapCalcRouteResult) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onCalculateRouteFailure(AMapCalcRouteResult aMapCalcRouteResult) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onNaviRouteNotify(AMapNaviRouteNotifyData aMapNaviRouteNotifyData) {
    }

    public final void a(AMapNaviMarkerOptions aMapNaviMarkerOptions) {
        LbsNaviView lbsNaviView = this.i;
        if (lbsNaviView != null) {
            lbsNaviView.addPositionMarker(aMapNaviMarkerOptions);
        }
    }

    public final void b(AMapNaviMarkerOptions aMapNaviMarkerOptions) {
        LbsNaviView lbsNaviView = this.i;
        if (lbsNaviView != null) {
            lbsNaviView.updateMarkerPosition(aMapNaviMarkerOptions);
        }
    }

    public final void c(AMapNaviMarkerOptions aMapNaviMarkerOptions) {
        LbsNaviView lbsNaviView = this.i;
        if (lbsNaviView != null) {
            lbsNaviView.removePositionMarker(aMapNaviMarkerOptions);
        }
    }
}
