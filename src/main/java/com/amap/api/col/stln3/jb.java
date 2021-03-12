package com.amap.api.col.stln3;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.ActivityChooserView;
import android.text.Html;
import android.text.Spanned;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.AMap;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.AMapNaviView;
import com.amap.api.navi.AMapNaviViewListener;
import com.amap.api.navi.AMapNaviViewOptions;
import com.amap.api.navi.IAmapNaviView;
import com.amap.api.navi.INavi;
import com.amap.api.navi.MyNaviListener;
import com.amap.api.navi.R;
import com.amap.api.navi.core.view.BaseNaviView;
import com.amap.api.navi.model.AMapCalcRouteResult;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapModelCross;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapNaviRouteNotifyData;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AMapServiceAreaInfo;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.AmapCarLocation;
import com.amap.api.navi.model.InnerNaviInfo;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviPath;
import com.amap.api.navi.view.DirectionView;
import com.amap.api.navi.view.DriveWayView;
import com.amap.api.navi.view.NextTurnTipView;
import com.amap.api.navi.view.OverviewButtonView;
import com.amap.api.navi.view.TrafficBarView;
import com.amap.api.navi.view.TrafficButtonView;
import com.amap.api.navi.view.TrafficProgressBar;
import com.amap.api.navi.view.ZoomButtonView;
import com.amap.api.navi.view.ZoomInIntersectionView;
import com.autonavi.ae.guide.model.NaviCongestionInfo;
import com.autonavi.amap.mapcore.tools.GLMapStaticValue;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.tbt.TrafficFacilityInfo;
import java.lang.ref.WeakReference;

/* compiled from: AmapNaviViewCore */
public class jb implements View.OnClickListener, IAmapNaviView {
    private static int S = 1000;
    private static int T = 500;
    RelativeLayout A;
    RelativeLayout B;
    int C = GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH;
    int D = GLMapStaticValue.ANIMATION_MOVE_TIME;
    boolean E = false;
    int F = 0;
    int G = 0;
    boolean H = false;
    boolean I = true;
    protected int J = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    protected Handler K;
    double L = 0.5d;
    double M = 0.6666666666666666d;
    boolean N = false;
    boolean O = false;
    boolean P = false;
    AMapNaviViewListener Q = new AMapNaviViewListener() {
        /* class com.amap.api.col.stln3.jb.AnonymousClass3 */

        @Override // com.amap.api.navi.AMapNaviViewListener
        public final void onNaviSetting() {
        }

        @Override // com.amap.api.navi.AMapNaviViewListener
        public final void onNaviCancel() {
        }

        @Override // com.amap.api.navi.AMapNaviViewListener
        public final boolean onNaviBackClick() {
            return false;
        }

        @Override // com.amap.api.navi.AMapNaviViewListener
        public final void onNaviMapMode(int i) {
        }

        @Override // com.amap.api.navi.AMapNaviViewListener
        public final void onNaviTurnClick() {
        }

        @Override // com.amap.api.navi.AMapNaviViewListener
        public final void onNextRoadClick() {
        }

        @Override // com.amap.api.navi.AMapNaviViewListener
        public final void onScanViewButtonClick() {
        }

        @Override // com.amap.api.navi.AMapNaviViewListener
        public final void onLockMap(boolean z) {
        }

        @Override // com.amap.api.navi.AMapNaviViewListener
        public final void onNaviViewLoaded() {
            jb jbVar = jb.this;
            jbVar.F = jbVar.U.getHeight();
            jb jbVar2 = jb.this;
            jbVar2.G = jbVar2.U.getWidth();
            jb.this.d();
            jb jbVar3 = jb.this;
            jbVar3.a((jb) jbVar3.E);
            jb.T = (jb.this.D / 10) * 4;
            jb.S = jb.this.C / 2;
        }

        @Override // com.amap.api.navi.AMapNaviViewListener
        public final void onMapTypeChanged(int i) {
        }

        @Override // com.amap.api.navi.AMapNaviViewListener
        public final void onNaviViewShowMode(int i) {
            switch (i) {
                case 1:
                    jb.this.g.setVisibility(8);
                    jb.this.h.setVisibility(0);
                    jb.this.P = true;
                    break;
                case 2:
                case 3:
                    jb.this.g.setVisibility(0);
                    jb.this.h.setVisibility(8);
                    jb jbVar = jb.this;
                    jbVar.P = false;
                    jb.f(jbVar);
                    break;
            }
            if (!jb.this.P || !jb.this.O) {
                jb.this.c((jb) false);
            } else {
                jb.this.c((jb) true);
            }
        }
    };
    MyNaviListener R = new MyNaviListener() {
        /* class com.amap.api.col.stln3.jb.AnonymousClass4 */

        @Override // com.amap.api.navi.MyNaviListener
        public final void carProjectionChange(AmapCarLocation amapCarLocation) {
        }

        @Override // com.amap.api.navi.MyNaviListener
        public final void onInnerNaviInfoUpdate(InnerNaviInfo innerNaviInfo) {
            jb.a(jb.this, innerNaviInfo);
        }

        @Override // com.amap.api.navi.MyNaviListener
        public final void onUpdateTmcStatus(NaviCongestionInfo naviCongestionInfo) {
        }

        @Override // com.amap.api.navi.MyNaviListener
        public final void onGpsSignalWeak(boolean z) {
        }

        @Override // com.amap.api.navi.MyNaviListener
        public final void onStopNavi() {
        }

        @Override // com.amap.api.navi.MyNaviListener
        public final void onSelectRouteId(int i) {
            jb.g(jb.this);
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
        public final void onInitNaviFailure() {
        }

        @Override // com.amap.api.navi.AMapNaviListener
        public final void onInitNaviSuccess() {
        }

        @Override // com.amap.api.navi.AMapNaviListener
        public final void onStartNavi(int i) {
            jb jbVar = jb.this;
            jbVar.H = false;
            jbVar.b();
            jb.this.a();
        }

        @Override // com.amap.api.navi.AMapNaviListener
        public final void onTrafficStatusUpdate() {
        }

        @Override // com.amap.api.navi.AMapNaviListener
        public final void onLocationChange(AMapNaviLocation aMapNaviLocation) {
        }

        @Override // com.amap.api.navi.AMapNaviListener
        public final void onGetNavigationText(int i, String str) {
        }

        @Override // com.amap.api.navi.AMapNaviListener
        public final void onGetNavigationText(String str) {
        }

        @Override // com.amap.api.navi.AMapNaviListener
        public final void onEndEmulatorNavi() {
        }

        @Override // com.amap.api.navi.AMapNaviListener
        public final void onArriveDestination() {
        }

        @Override // com.amap.api.navi.AMapNaviListener
        public final void onCalculateRouteFailure(int i) {
        }

        @Override // com.amap.api.navi.AMapNaviListener
        public final void onReCalculateRouteForYaw() {
            jb.this.ap = null;
        }

        @Override // com.amap.api.navi.AMapNaviListener
        public final void onReCalculateRouteForTrafficJam() {
            jb.this.ap = null;
        }

        @Override // com.amap.api.navi.AMapNaviListener
        public final void onArrivedWayPoint(int i) {
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
            jb.this.e();
            jb.this.c((jb) true);
            jb.this.O = true;
        }

        @Override // com.amap.api.navi.AMapNaviListener
        public final void hideCross() {
            jb.f(jb.this);
            jb.this.c((jb) false);
            jb.this.O = false;
        }

        @Override // com.amap.api.navi.AMapNaviListener
        public final void showModeCross(AMapModelCross aMapModelCross) {
            if (jb.this.U.showModeCross(aMapModelCross)) {
                jb jbVar = jb.this;
                jbVar.O = true;
                jbVar.c((jb) true);
            }
        }

        @Override // com.amap.api.navi.AMapNaviListener
        public final void hideModeCross() {
            jb.this.c((jb) false);
            jb.this.O = false;
        }

        @Override // com.amap.api.navi.AMapNaviListener
        public final void showLaneInfo(AMapLaneInfo[] aMapLaneInfoArr, byte[] bArr, byte[] bArr2) {
        }

        @Override // com.amap.api.navi.AMapNaviListener
        public final void showLaneInfo(AMapLaneInfo aMapLaneInfo) {
            if (jb.this.I && jb.this.aj.isLaneInfoShow() && !jb.this.isShowRoadEnlarge() && aMapLaneInfo != null && jb.this.z != null && jb.this.b.getVisibility() != 0) {
                jb.this.z.setDefaultTopMargin(jb.this.e.getHeight());
            }
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
        public final void OnUpdateTrafficFacility(TrafficFacilityInfo trafficFacilityInfo) {
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
        public final void onCalculateRouteSuccess(AMapCalcRouteResult aMapCalcRouteResult) {
            jb.g(jb.this);
        }

        @Override // com.amap.api.navi.AMapNaviListener
        public final void onCalculateRouteFailure(AMapCalcRouteResult aMapCalcRouteResult) {
        }

        @Override // com.amap.api.navi.AMapNaviListener
        public final void onNaviRouteNotify(AMapNaviRouteNotifyData aMapNaviRouteNotifyData) {
        }
    };
    private BaseNaviView U;
    private INavi V;
    private AMapNaviViewListener W;
    private DriveWayView X;
    private ZoomInIntersectionView Y;
    private TrafficBarView Z;
    View a = null;
    private TrafficProgressBar aa;
    private DirectionView ab;
    private TrafficButtonView ac;
    private NextTurnTipView ad;
    private ZoomButtonView ae;
    private AMapNaviView af;
    private Context ag;
    private ZoomButtonView ah;
    private OverviewButtonView ai;
    private AMapNaviViewOptions aj = null;
    private int ak = 0;
    private double al = 0.5d;
    private double am = 0.6666666666666666d;
    private String an = "#ffffff";
    private String ao = "#ffffff";
    private NaviInfo ap;
    ZoomInIntersectionView b;
    NextTurnTipView c;
    TextView d;
    TextView e;
    TextView f;
    FrameLayout g;
    FrameLayout h;
    LinearLayout i;
    LinearLayout j;
    LinearLayout k;
    FrameLayout l;
    LinearLayout m;
    TextView n;
    TextView o;
    TrafficProgressBar p;
    DirectionView q;
    TrafficButtonView r;
    TextView s;
    TextView t;
    ImageView u;
    ImageView v;
    ImageView w;
    ImageView x;
    OverviewButtonView y;
    DriveWayView z;

    static /* synthetic */ void a(jb jbVar, NaviInfo naviInfo) {
        if (naviInfo != null && jbVar.V != null) {
            jbVar.ap = naviInfo;
            TextView textView = jbVar.d;
            if (textView != null) {
                textView.setText(mj.a(naviInfo.getCurStepRetainDistance()));
            }
            TextView textView2 = jbVar.e;
            if (textView2 != null) {
                textView2.setText(naviInfo.getNextRoadName());
            }
            String b2 = mj.b(naviInfo.getPathRetainTime());
            Spanned fromHtml = Html.fromHtml(mj.a(b2, jbVar.an, jbVar.ao));
            Spanned fromHtml2 = Html.fromHtml(mj.a(naviInfo.getPathRetainDistance(), jbVar.an, jbVar.ao));
            Spanned fromHtml3 = Html.fromHtml("<big>距离终点:</big><big><big>" + mj.a(b2) + " " + mj.a(naviInfo.getPathRetainDistance()) + "</big></big>");
            TextView textView3 = jbVar.f;
            if (textView3 != null) {
                textView3.setText(fromHtml3);
            }
            TextView textView4 = jbVar.s;
            if (textView4 != null) {
                textView4.setText(fromHtml2);
            }
            TextView textView5 = jbVar.t;
            if (textView5 != null) {
                textView5.setText(fromHtml);
            }
        }
    }

    static /* synthetic */ void c(jb jbVar) {
        new AlertDialog.Builder(jbVar.ag).setTitle("提示").setMessage("确定退出导航?").setPositiveButton("确定", new DialogInterface.OnClickListener() {
            /* class com.amap.api.col.stln3.jb.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                try {
                    dialogInterface.cancel();
                    jb.this.V.stopNavi();
                    jb.this.K.sendEmptyMessage(3);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            /* class com.amap.api.col.stln3.jb.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (dialogInterface != null) {
                    try {
                        dialogInterface.cancel();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }).show();
    }

    static /* synthetic */ void f(jb jbVar) {
        jbVar.b.setLayoutParams(new RelativeLayout.LayoutParams(0, 0));
    }

    static /* synthetic */ void g(jb jbVar) {
        AMapNaviPath naviPath;
        INavi iNavi = jbVar.V;
        if (iNavi != null && (naviPath = iNavi.getNaviPath()) != null) {
            TextView textView = jbVar.s;
            if (textView != null) {
                textView.setText(Html.fromHtml(mj.a(naviPath.getAllLength(), jbVar.an, jbVar.ao)));
            }
            if (jbVar.t != null) {
                jbVar.t.setText(Html.fromHtml(mj.a(mj.b(naviPath.getAllTime()), jbVar.an, jbVar.ao)));
            }
        }
    }

    public jb(AMapNaviView aMapNaviView, AMapNaviViewOptions aMapNaviViewOptions) {
        this.aj = aMapNaviViewOptions;
        this.af = aMapNaviView;
        Context context = aMapNaviView.getContext();
        if (context instanceof mk) {
            this.ag = ((mk) context).getBaseContext();
        } else {
            this.ag = context;
        }
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public double getAnchorX() {
        return this.U.getAnchorX();
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public double getAnchorY() {
        return this.U.getAnchorY();
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public int getLockZoom() {
        AMapNaviViewOptions aMapNaviViewOptions = this.aj;
        if (aMapNaviViewOptions != null) {
            return aMapNaviViewOptions.getZoom();
        }
        return this.J;
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void setLockZoom(int i2) {
        this.U.setLockZoom(i2);
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public int getLockTilt() {
        return this.U.getLockTilt();
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void setLockTilt(int i2) {
        this.U.setLockTilt(i2);
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public int getNaviMode() {
        return this.U.getNaviMode();
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void setNaviMode(int i2) {
        this.U.setNaviMode(i2);
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public boolean isAutoChangeZoom() {
        return this.U.isAutoChangeZoom();
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public AMapNaviViewOptions getViewOptions() {
        return this.aj;
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void setViewOptions(AMapNaviViewOptions aMapNaviViewOptions) {
        if (aMapNaviViewOptions != null) {
            this.aj = aMapNaviViewOptions;
            Handler handler = this.K;
            if (handler != null) {
                handler.obtainMessage(7).sendToTarget();
            }
            this.U.setViewOptions(aMapNaviViewOptions);
        }
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public AMap getMap() {
        return this.U.getMap();
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void init() {
        try {
            if (this.aj == null) {
                this.aj = new AMapNaviViewOptions();
            }
            this.V = AMapNavi.getInstance(this.ag);
            mm.a(this.ag.getApplicationContext());
            this.a = mm.a(this.ag, R.layout.amap_navi_api_navi_fragment, null);
            this.af.addView(this.a);
            this.U = (BaseNaviView) this.a.findViewById(R.id.navi_sdk_base);
            this.U.addMapNaviViewListener(this.Q);
            this.E = c();
            try {
                this.b = (ZoomInIntersectionView) this.af.findViewById(R.id.navi_sdk_enlarge_road_layout);
                this.q = (DirectionView) this.a.findViewById(R.id.navi_sdk_directionView);
                this.B = (RelativeLayout) this.a.findViewById(R.id.navi_sdk_navi_container);
                this.z = (DriveWayView) this.a.findViewById(R.id.navi_sdk_driveWayViewInNaviView);
                this.z.setAMapNaviView(this.af);
                this.c = (NextTurnTipView) this.a.findViewById(R.id.navi_sdk_autonavi_port_roadsign);
                this.d = (TextView) this.a.findViewById(R.id.navi_sdk_autonavi_port_nextRoadSignDisText);
                this.e = (TextView) this.a.findViewById(R.id.navi_sdk_autonavi_port_nextRoadNameText);
                this.f = (TextView) this.a.findViewById(R.id.navi_sdk_autonavi_port_restDistanceAndTime);
                this.s = (TextView) this.a.findViewById(R.id.navi_sdk_autonavi_port_restDistance);
                this.t = (TextView) this.a.findViewById(R.id.navi_sdk_autonavi_port_distanceTimeText);
                this.g = (FrameLayout) this.a.findViewById(R.id.navi_sdk_autonavi_port_reset_navi_car_layout);
                this.h = (FrameLayout) this.a.findViewById(R.id.navi_sdk_autonavi_port_show_naving_info);
                this.v = (ImageView) this.a.findViewById(R.id.navi_sdk_navigation_down_line);
                this.w = (ImageView) this.a.findViewById(R.id.navi_sdk_navi_back_line);
                this.x = (ImageView) this.a.findViewById(R.id.navi_sdk_autonavi_browser_navi_setting);
                this.u = (ImageView) this.a.findViewById(R.id.navi_sdk_autonavi_browser_navi_back);
                this.l = (FrameLayout) this.a.findViewById(R.id.navi_sdk_autonavi_port_cur_road_name_view);
                this.m = (LinearLayout) this.a.findViewById(R.id.navi_sdk_navi_widget_footer_linearlayout);
                this.n = (TextView) this.a.findViewById(R.id.navi_sdk_autonavi_port_curRoadName);
                this.o = (TextView) this.a.findViewById(R.id.navi_sdk_navigation_go_on);
                this.r = (TrafficButtonView) this.a.findViewById(R.id.navi_sdk_route_tmc);
                this.y = (OverviewButtonView) this.a.findViewById(R.id.navi_sdk_autonavi_btn_preview);
                this.A = (RelativeLayout) this.a.findViewById(R.id.navi_sdk_footer);
                this.i = (LinearLayout) this.a.findViewById(R.id.navi_sdk_roadsign_layout);
                this.j = (LinearLayout) this.a.findViewById(R.id.navi_sdk_roadname_layout);
                this.k = (LinearLayout) this.a.findViewById(R.id.navi_sdk_autonavi_zoom_and_preview_view);
                this.ae = (ZoomButtonView) this.a.findViewById(R.id.navi_sdk_zoom_button_view);
                this.p = new TrafficProgressBar(this.ag);
                this.p.setVisibility(8);
                this.B.addView(this.p);
                if (this.U != null) {
                    this.U.setZoomInIntersectionView(this.b, true);
                    this.U.setDirectionView(this.q, true);
                    this.U.setDriveWayView(this.z, true);
                    this.U.setNextTurnTipView(this.c, true);
                    this.U.setTrafficButtonView(this.r, true);
                    this.U.setOverviewButtonView(this.y, true);
                    this.U.setZoomButtonView(this.ae, true);
                    this.U.setTrafficProgressBar(this.p, true);
                }
                a(this.E);
            } catch (Throwable th) {
                mj.a(th);
                rx.c(th, "AMapNaviView", "findView()");
            }
            this.K = new a(this);
        } catch (Throwable th2) {
            mj.a(th2);
            rx.c(th2, "AMapNaviView", "init()");
        }
    }

    private boolean c() {
        try {
            return ((Activity) this.ag).getRequestedOrientation() == 0 || this.af.getResources().getConfiguration().orientation == 2;
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapNaviView", "isLandscape");
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void d() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.ag.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.C = displayMetrics.widthPixels;
        this.D = displayMetrics.heightPixels;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(boolean z2) {
        RelativeLayout.LayoutParams layoutParams;
        int a2 = mj.a(this.ag, 12);
        if (z2) {
            layoutParams = new RelativeLayout.LayoutParams(-2, mj.a(this.ag, 220));
            layoutParams.addRule(12);
        } else {
            if (this.ak == 0) {
                if (this.U.getHeight() > this.U.getWidth()) {
                    this.ak = (this.U.getHeight() / 5) * 3;
                } else {
                    this.ak = (this.U.getWidth() / 5) * 3;
                }
            }
            layoutParams = new RelativeLayout.LayoutParams(-2, this.ak);
            layoutParams.addRule(15);
        }
        layoutParams.rightMargin = a2;
        layoutParams.addRule(11);
        this.p.setLayoutParams(layoutParams);
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void onConfigurationChanged(Configuration configuration) {
        try {
            d();
            this.E = c();
            S = this.C / 2;
            b(this.E);
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapNaviView", "onConfigurationChanged(Configuration newConfig)");
        }
    }

    private void b(boolean z2) {
        if (this.N) {
            c(true);
        } else {
            c(false);
        }
        if (z2) {
            if (!this.H) {
                this.f.setVisibility(0);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A.getLayoutParams();
            layoutParams.width = c(320);
            this.A.setLayoutParams(layoutParams);
            d(0);
            e(0);
        } else {
            this.f.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.A.getLayoutParams();
            layoutParams2.width = -2;
            this.A.setLayoutParams(layoutParams2);
            d(40);
            e(30);
        }
        e();
        a(z2);
        g();
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        try {
            boolean isLayoutVisible = this.aj.isLayoutVisible();
            if (this.I != isLayoutVisible) {
                this.I = isLayoutVisible;
                this.U.setLayoutVisible(isLayoutVisible);
                try {
                    if (!this.I) {
                        this.m.setVisibility(8);
                        this.k.setVisibility(8);
                        this.i.setVisibility(8);
                        this.j.setVisibility(8);
                    } else {
                        this.m.setVisibility(0);
                        this.k.setVisibility(0);
                        this.i.setVisibility(0);
                        this.j.setVisibility(0);
                        if (!this.E) {
                            d(40);
                        }
                    }
                    d(0);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            this.al = this.aj.getMapCenter_X();
            this.L = this.al;
            this.am = this.aj.getMapCenter_Y();
            this.M = this.am;
            this.V.getNaviSetting().setScreenAlwaysBright(this.aj.isScreenAlwaysBright());
            this.V.getNaviSetting().setTrafficInfoUpdateEnabled(this.aj.isTrafficInfoUpdateEnabled());
            this.V.getNaviSetting().setCameraInfoUpdateEnabled(this.aj.isCameraInfoUpdateEnabled());
            this.V.setReCalculateRouteForYaw(this.aj.isReCalculateRouteForYaw());
            this.V.setReCalculateRouteForTrafficJam(this.aj.isReCalculateRouteForTrafficJam());
            if (this.aj.isSettingMenuEnabled()) {
                this.v.setVisibility(0);
                this.x.setVisibility(0);
            } else {
                this.v.setVisibility(8);
                this.x.setVisibility(8);
            }
            this.d.setTextColor(-1);
            this.e.setTextColor(-1);
            this.f.setTextColor(-1);
            this.m.setBackgroundDrawable(mm.a().getDrawable(com.a11hud.www.R.attr.colorButtonNormal));
            Drawable drawable = mm.a().getDrawable(com.a11hud.www.R.attr.layout_constraintDimensionRatio);
            this.v.setBackgroundDrawable(drawable);
            this.w.setBackgroundDrawable(drawable);
            this.u.setImageDrawable(mm.a().getDrawable(com.a11hud.www.R.attr.textColorAlertDialogListItem));
            this.x.setImageDrawable(mm.a().getDrawable(com.a11hud.www.R.attr.theme));
            this.n.setTextColor(-1);
            this.o.setTextColor(-1);
            if (this.ap != null) {
                if (this.s != null) {
                    this.s.setText(Html.fromHtml(mj.a(this.ap.getPathRetainDistance(), this.an, this.ao)));
                }
                if (this.t != null) {
                    this.t.setText(Html.fromHtml(mj.a(mj.b(this.ap.getPathRetainTime()), this.an, this.ao)));
                }
            }
        } catch (Throwable th2) {
            mj.a(th2);
            rx.c(th2, "AMapNaviView", "checkViewOptions()");
        }
    }

    private int c(int i2) {
        return mj.a(this.ag, i2);
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public final void onCreate(Bundle bundle) {
        try {
            this.V.addAMapNaviListener(this.R);
            this.g.setOnClickListener(this);
            this.x.setOnClickListener(this);
            this.u.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.c.setOnClickListener(this);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "onCreate(Bundle bundle)");
            return;
        }
        this.U.onCreate(bundle);
        a();
        d();
        b(c());
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public final void onResume() {
        try {
            this.U.onResume();
            d();
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapNaviView", "onResume()");
        }
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public final void onPause() {
        try {
            this.U.onPause();
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapNaviView", "onPause()");
        }
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public final void onDestroy() {
        try {
            this.V.removeAMapNaviListener(this.R);
            long currentTimeMillis = System.currentTimeMillis();
            this.U.onDestroy();
            long currentTimeMillis2 = System.currentTimeMillis();
            String str = "baseView destroy()-->" + (currentTimeMillis2 - currentTimeMillis);
            mm.c();
            if (this.b != null) {
                this.b.setVisibility(8);
                this.b.recycleResource();
            }
            if (this.Y != null) {
                this.Y.setVisibility(8);
                this.Y.recycleResource();
            }
            if (this.z != null) {
                this.z.setVisibility(8);
            }
            if (this.X != null) {
                this.X.setVisibility(8);
            }
            if (this.q != null) {
                this.q.setVisibility(8);
                this.q.recycleResource();
            }
            if (this.ab != null) {
                this.ab.setVisibility(8);
                this.ab.recycleResource();
            }
            if (this.Z != null) {
                this.Z.setVisibility(8);
                this.Z.recycleResource();
            }
            if (this.c != null) {
                this.c.setVisibility(8);
                this.c.recycleResource();
            }
            if (this.ad != null) {
                this.ad.setVisibility(8);
                this.ad.recycleResource();
            }
            if (this.r != null) {
                this.r.setVisibility(8);
                this.r.recycleResource();
            }
            if (this.ac != null) {
                this.ac.setVisibility(8);
                this.ac.recycleResource();
            }
            if (this.y != null) {
                this.y.setVisibility(8);
                this.y.recycleResource();
            }
            if (this.ai != null) {
                this.ai.setVisibility(8);
                this.ai.recycleResource();
            }
            if (this.ae != null) {
                this.ae.setVisibility(8);
            }
            if (this.ah != null) {
                this.ah.setVisibility(8);
            }
            this.af.removeAllViews();
            this.K.removeCallbacksAndMessages(null);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "onDestroy()");
        }
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public final void onSaveInstanceState(Bundle bundle) {
        try {
            this.U.onSaveInstanceState(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapNaviView", "onSaveInstanceState(android.os.Bundle paramBundle)");
        }
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void displayOverview() {
        this.U.displayOverview();
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void openNorthMode() {
        this.U.openNorthMode();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e() {
        if (this.I && this.aj.isRealCrossDisplayShow()) {
            if (this.E) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(S, -1);
                layoutParams.topMargin = mj.a(this.ag, 48);
                this.b.setLayoutParams(layoutParams);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, T);
            layoutParams2.topMargin = mj.a(this.ag, 48);
            this.b.setLayoutParams(layoutParams2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c(boolean z2) {
        if (!this.P) {
            z2 = false;
        }
        if (z2) {
            this.N = true;
            if (c()) {
                this.L = 0.75d;
                this.M = 0.6666666666666666d;
            } else {
                f();
            }
        } else {
            this.N = false;
            f();
        }
        g();
    }

    private void f() {
        double d2 = this.al;
        if (d2 != 0.0d) {
            this.L = d2;
        } else {
            this.L = 0.5d;
        }
        double d3 = this.am;
        if (d3 != 0.0d) {
            this.M = d3;
        } else {
            this.M = 0.6666666666666666d;
        }
    }

    private void g() {
        BaseNaviView baseNaviView = this.U;
        if (baseNaviView != null) {
            baseNaviView.getViewOptions().setPointToCenter(this.L, this.M);
            this.U.setCustomizedLockCenter();
        }
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void recoverLockMode() {
        this.U.recoverLockMode();
    }

    public void onClick(View view) {
        try {
            if (2147479611 == view.getId()) {
                recoverLockMode();
            }
            if (2147479614 == view.getId()) {
                this.K.sendEmptyMessage(1);
            }
            if (2147479604 == view.getId()) {
                if (this.W != null) {
                    if (!this.W.onNaviBackClick()) {
                        this.K.sendEmptyMessage(2);
                    }
                }
            }
            if (2147479591 == view.getId()) {
                if (this.W != null) {
                    this.W.onNaviTurnClick();
                }
            }
            if (this.n.equals(view) && this.W != null) {
                this.W.onNextRoadClick();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "onClick(View v)");
        }
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public boolean isTrafficLine() {
        return this.U.isTrafficLine();
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void setTrafficLine(boolean z2) {
        this.U.setTrafficLine(z2);
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void setAMapNaviViewListener(AMapNaviViewListener aMapNaviViewListener) {
        if (aMapNaviViewListener != null) {
            this.U.addMapNaviViewListener(aMapNaviViewListener);
            this.W = aMapNaviViewListener;
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        try {
            this.l.setVisibility(8);
            int i2 = 0;
            this.v.setVisibility(0);
            this.x.setVisibility(0);
            this.g.setVisibility(8);
            this.e.setVisibility(0);
            this.h.setVisibility(0);
            TrafficButtonView trafficButtonView = this.r;
            if (!this.aj.isTrafficLayerEnabled()) {
                i2 = 8;
            }
            trafficButtonView.setVisibility(i2);
            this.ae.setVisibility(8);
            this.y.setVisibility(8);
            b(this.E);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public boolean isShowRoadEnlarge() {
        return this.U.isShowRoadEnlarge();
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public boolean isOrientationLandscape() {
        return this.E;
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void layout(boolean z2, int i2, int i3, int i4, int i5) {
        boolean z3;
        try {
            if (this.F == this.U.getHeight()) {
                if (this.G == this.U.getWidth()) {
                    z3 = false;
                    if (z3 && this.z != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.z.getLayoutParams();
                        layoutParams.setMargins(0, this.e.getHeight() + 10, 0, 0);
                        this.z.setLayoutParams(layoutParams);
                        this.z.invalidate();
                        return;
                    }
                }
            }
            z3 = true;
            if (z3) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapNaviView", "onLayout(boolean changed, int left, int top, int right,\n                            int bottom)");
        }
    }

    private void d(int i2) {
        try {
            if (!this.I) {
                if (i2 != 0) {
                    return;
                }
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.U.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, c(i2));
            this.U.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void e(int i2) {
        try {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.setMargins(c(0), c(0), c(10), c(i2));
            this.k.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public DriveWayView getLazyDriveWayView() {
        return this.X;
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void setLazyDriveWayView(DriveWayView driveWayView) {
        if (driveWayView != null) {
            this.X = driveWayView;
            this.U.setDriveWayView(this.X, false);
        }
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public ZoomInIntersectionView getLazyZoomInIntersectionView() {
        return this.Y;
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void setLazyZoomInIntersectionView(ZoomInIntersectionView zoomInIntersectionView) {
        if (zoomInIntersectionView != null) {
            this.Y = zoomInIntersectionView;
            this.U.setZoomInIntersectionView(this.Y, false);
        }
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public TrafficBarView getLazyTrafficBarView() {
        return this.Z;
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void setLazyTrafficBarView(TrafficBarView trafficBarView) {
        if (trafficBarView != null) {
            this.Z = trafficBarView;
            this.U.setLazyTrafficBarView(this.Z);
        }
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public TrafficProgressBar getLazyTrafficProgressBarView() {
        return this.aa;
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void setLazyTrafficProgressBarView(TrafficProgressBar trafficProgressBar) {
        if (trafficProgressBar != null) {
            this.aa = trafficProgressBar;
            this.U.setTrafficProgressBar(this.aa, false);
        }
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public DirectionView getLazyDirectionView() {
        return this.ab;
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void setLazyDirectionView(DirectionView directionView) {
        if (directionView != null) {
            this.ab = directionView;
            this.U.setDirectionView(directionView, false);
        }
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public TrafficButtonView getLazyTrafficButtonView() {
        return this.ac;
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void setLazyTrafficButtonView(TrafficButtonView trafficButtonView) {
        if (trafficButtonView != null) {
            this.ac = trafficButtonView;
            this.U.setTrafficButtonView(trafficButtonView, false);
        }
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public NextTurnTipView getLazyNextTurnTipView() {
        return this.ad;
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void setLazyNextTurnTipView(NextTurnTipView nextTurnTipView) {
        if (nextTurnTipView != null) {
            this.ad = nextTurnTipView;
            this.U.setNextTurnTipView(nextTurnTipView, false);
        }
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void zoomIn() {
        this.U.zoomIn();
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void zoomOut() {
        this.U.zoomOut();
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void setLazyZoomButtonView(ZoomButtonView zoomButtonView) {
        if (zoomButtonView != null) {
            this.ah = zoomButtonView;
            this.U.setZoomButtonView(zoomButtonView, false);
        }
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void setLazyOverviewButtonView(OverviewButtonView overviewButtonView) {
        if (overviewButtonView != null) {
            this.ai = overviewButtonView;
            this.U.setOverviewButtonView(overviewButtonView, false);
        }
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public boolean isRouteOverviewNow() {
        return this.U.isRouteOverviewNow();
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void setOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) {
        this.U.setOnMarkerClickListener(onMarkerClickListener);
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void setOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) {
        this.U.setOnPolylineClickListener(onPolylineClickListener);
    }

    /* compiled from: AmapNaviViewCore */
    static class a extends Handler {
        private WeakReference<jb> a;

        a(jb jbVar) {
            try {
                this.a = new WeakReference<>(jbVar);
            } catch (Throwable th) {
                th.printStackTrace();
                rx.c(th, "AMapNaviView", "MapViewListenerTriggerHandler()");
            }
        }

        public final void handleMessage(Message message) {
            jb jbVar = this.a.get();
            if (jbVar != null) {
                try {
                    int i = message.what;
                    if (i != 7) {
                        switch (i) {
                            case 1:
                                if (jbVar.W != null) {
                                    jbVar.W.onNaviSetting();
                                    return;
                                }
                                return;
                            case 2:
                                jb.c(jbVar);
                                return;
                            case 3:
                                if (jbVar.W != null) {
                                    jbVar.W.onNaviCancel();
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    } else {
                        jbVar.a();
                    }
                } catch (Throwable th) {
                    mj.a(th);
                    rx.c(th, "AMapNaviView", "MapViewListenerTriggerHandler.handleMessage(android.os.Message msg) ");
                }
            }
        }
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void setOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) {
        this.U.setOnMapLoadedListener(onMapLoadedListener);
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void setOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) {
        this.U.setOnCameraChangeListener(onCameraChangeListener);
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void setOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) {
        this.U.setOnMapTouchListener(onMapTouchListener);
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void setRouteOverlayVisible(boolean z2) {
        this.U.setRouteOverlayVisible(z2);
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void setCarOverlayVisible(boolean z2) {
        this.U.setCarOverlayVisible(z2);
    }

    @Override // com.amap.api.navi.IAmapNaviView
    public void setTrafficLightsVisible(boolean z2) {
        this.U.setTrafficLightsVisible(z2);
    }
}
