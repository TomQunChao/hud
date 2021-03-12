package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.amap.api.col.stln3.kd;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.Poi;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
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
import com.amap.api.navi.model.AMapNaviForbiddenInfo;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLimitInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapNaviRouteNotifyData;
import com.amap.api.navi.model.AMapNaviStep;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AMapServiceAreaInfo;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.navi.services.view.e;
import com.amap.api.navi.view.ForbiddenPopTip;
import com.amap.api.navi.view.ForbiddenTipView;
import com.amap.api.navi.view.PoiInputSearchWidget;
import com.amap.api.navi.view.SlidingTabLayout;
import com.amap.api.navi.view.SlidingUpPanelLayout;
import com.amap.api.services.district.DistrictSearchQuery;
import com.autonavi.ae.route.model.POIInfo;
import com.autonavi.tbt.TrafficFacilityInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: RoutePage */
public final class kt extends ke implements View.OnClickListener, kr, AMap.OnCameraChangeListener, AMap.OnMapTouchListener, AMapNaviListener {
    private ImageButton A;
    private ImageButton B;
    private SlidingUpPanelLayout C;
    private SlidingTabLayout D;
    private boolean E;
    private SparseArray<kh> F = new SparseArray<>();
    private int G = 10;
    private PoiInputSearchWidget H;
    private int I = 4;
    private int[] J;
    private int K = R.id.navi_sdk_route_select_tab1;
    private long L = 0;
    private a M = a.SUCCESS;
    private int N;
    private boolean O = true;
    private long P;
    private Polygon Q;
    private e R;
    private com.amap.api.navi.services.view.b S;
    private boolean T = true;
    private ForbiddenPopTip U;
    private Handler V = null;
    private Poi W;
    private Poi X;
    private Poi Y;
    private Poi Z;
    private Poi aa;
    protected AMapNavi h;
    ImageButton i = null;
    ImageButton j = null;
    ImageView k = null;
    int l = 6000;
    boolean m = false;
    ForbiddenTipView n = null;
    ForbiddenTipView.TipVisibleListener o = new ForbiddenTipView.TipVisibleListener() {
        /* class com.amap.api.col.stln3.kt.AnonymousClass9 */

        @Override // com.amap.api.navi.view.ForbiddenTipView.TipVisibleListener
        public final void onTipShow() {
            kt.c(kt.this, 20);
        }

        @Override // com.amap.api.navi.view.ForbiddenTipView.TipVisibleListener
        public final void onTipHide() {
            if (kt.this.k != null) {
                kt.this.k.setVisibility(0);
            }
            kt.c(kt.this, 0);
        }
    };
    int p = 12;
    Marker q;
    private final String r = "RoutePage";
    private TextureMapView s;
    private AMap t;
    private View u;
    private RelativeLayout v;
    private RelativeLayout w;
    private kq x;
    private ImageButton y;
    private ImageButton z;

    /* access modifiers changed from: package-private */
    /* compiled from: RoutePage */
    public enum a {
        SUCCESS,
        LOCATION_FAILE,
        CALCULATE_FAILE
    }

    static /* synthetic */ void K(kt ktVar) {
        if (ktVar.S == null) {
            ktVar.S = new com.amap.api.navi.services.view.b(ktVar.g);
        }
        ktVar.S.setHeight(ktVar.a(300.0f));
        ktVar.S.showAtLocation(ktVar.u, 81, 0, 0);
        final WindowManager.LayoutParams attributes = ktVar.g.getWindow().getAttributes();
        attributes.alpha = 0.7f;
        ktVar.g.getWindow().setAttributes(attributes);
        ktVar.S.setOnDismissListener(new PopupWindow.OnDismissListener() {
            /* class com.amap.api.col.stln3.kt.AnonymousClass6 */

            public final void onDismiss() {
                try {
                    attributes.alpha = 1.0f;
                    kt.this.g.getWindow().setAttributes(attributes);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    static /* synthetic */ void a(kt ktVar, int i2) {
        if (i2 == ktVar.G) {
            ma.a(ktVar.g, "策略未改变，不进行重算.");
            return;
        }
        ktVar.G = i2;
        ktVar.a(i2);
    }

    static /* synthetic */ void c(kt ktVar, int i2) {
        HashMap<Integer, AMapNaviPath> naviPaths;
        try {
            if (ktVar.h != null && (naviPaths = ktVar.h.getNaviPaths()) != null) {
                ktVar.a(naviPaths, i2);
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.amap.api.maps.AMap.OnMapTouchListener
    public final void onTouch(MotionEvent motionEvent) {
        AMap aMap = this.t;
        if (aMap != null) {
            aMap.getUiSettings().setScaleControlsEnabled(true);
        }
        Handler handler = this.V;
        if (handler != null) {
            handler.removeMessages(4);
            this.V.sendEmptyMessageDelayed(4, 1000);
        }
    }

    /* compiled from: RoutePage */
    class b extends Handler {
        private final WeakReference<Context> b;

        public b(Context context) {
            this.b = new WeakReference<>(context);
        }

        public final void handleMessage(Message message) {
            try {
                super.handleMessage(message);
                if (this.b.get() != null) {
                    switch (message.what) {
                        case 1:
                            e.c();
                            if (e.b() == 0) {
                                kt.this.V.removeCallbacksAndMessages(null);
                                kt.this.R.dismiss();
                            }
                            if (kt.this.T) {
                                Message obtainMessage = kt.this.V.obtainMessage();
                                obtainMessage.what = 1;
                                kt.this.V.sendMessageDelayed(obtainMessage, 1000);
                                return;
                            }
                            return;
                        case 2:
                            e.a();
                            kt.this.T = false;
                            return;
                        case 3:
                            kt.this.j();
                            return;
                        case 4:
                            kt.this.t.getUiSettings().setScaleControlsEnabled(false);
                            return;
                        default:
                            return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.col.stln3.ke
    public final void a(Bundle bundle) {
        super.a(bundle);
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.g.setRequestedOrientation(1);
        this.V = new b(this.g);
        this.h = AMapNavi.getInstance(this.g);
        this.h.addAMapNaviListener(this);
        this.s = new TextureMapView(this.g);
        this.v = (RelativeLayout) this.u.findViewById(R.id.navi_sdk_mapContainer);
        this.v.addView(this.s);
        this.s.setBackgroundColor(-1);
        this.s.onCreate(bundle);
        this.t = this.s.getMap();
        this.t.setOnCameraChangeListener(this);
        this.t.setOnMapTouchListener(this);
        this.t.getUiSettings().setZoomControlsEnabled(false);
        this.t.getUiSettings().setLogoLeftMargin(a(45.0f));
        this.t.getUiSettings().setLogoBottomMargin(a(7.0f));
        this.t.setMapType(4);
        if (bundle != null) {
            this.I = bundle.getInt("from", 4);
        }
        this.D = (SlidingTabLayout) this.u.findViewById(R.id.navi_sdk_route_sliding_info);
        this.D.setSlidingCallback(new SlidingTabLayout.ISlidingCallback() {
            /* class com.amap.api.col.stln3.kt.AnonymousClass7 */

            @Override // com.amap.api.navi.view.SlidingTabLayout.ISlidingCallback
            public final void selectRoute(int i) {
                kt.this.b((kt) i);
            }

            @Override // com.amap.api.navi.view.SlidingTabLayout.ISlidingCallback
            public final void drawRoutes(int i, AMapNaviPath aMapNaviPath) {
                kt.this.a((kt) i, (int) aMapNaviPath);
            }
        });
        this.D.setSlidingClickCallback(this);
        this.w = (RelativeLayout) this.u.findViewById(R.id.navi_sdk_route_select_top);
        this.H = (PoiInputSearchWidget) this.u.findViewById(R.id.navi_sdk_lbs_route_header);
        this.C = (SlidingUpPanelLayout) this.u.findViewById(R.id.navi_sdk_sliding_layout);
        this.C.setPanelHeight(a(150.0f));
        this.C.setTopView(this.H);
        this.C.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            /* class com.amap.api.col.stln3.kt.AnonymousClass8 */

            @Override // com.amap.api.navi.view.SlidingUpPanelLayout.PanelSlideListener
            public final void onPanelSlide(View view, float f) {
                String str = "slideOffset=" + f;
                Button topNaviButton = kt.this.D.getTopNaviButton();
                if (topNaviButton != null) {
                    topNaviButton.setAlpha(1.0f - f);
                    if (kt.this.n != null && kt.this.n.getVisibility() == 0) {
                        kt.this.n.setAlpha(1.0f - (4.8f * f));
                    }
                    if (f == 1.0f) {
                        topNaviButton.setVisibility(4);
                        return;
                    }
                    int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                    if (i > 0 && !kt.this.m) {
                        Poi b = kt.this.g.getSearchResult().b();
                        if (b == null) {
                            b = new Poi("当前位置", null, null);
                        }
                        Poi f2 = kt.this.g.getSearchResult().f();
                        if (f2 != null) {
                            kt.this.D.setGuideData(b.getName(), f2.getName(), kt.this.h);
                        }
                        kt.this.m = true;
                    }
                    if (i == 0) {
                        kt.this.m = false;
                    }
                    topNaviButton.setVisibility(0);
                }
            }

            @Override // com.amap.api.navi.view.SlidingUpPanelLayout.PanelSlideListener
            public final void onPanelStateChanged(View view, SlidingUpPanelLayout.PanelState panelState, SlidingUpPanelLayout.PanelState panelState2) {
                String str = "previousState=" + panelState;
            }
        });
        this.A = (ImageButton) this.u.findViewById(R.id.navi_sdk_lbs_route_lbs_btn);
        this.A.setOnClickListener(this);
        this.z = (ImageButton) this.u.findViewById(R.id.navi_sdk_lbs_route_strategy_btn);
        this.z.setOnClickListener(this);
        this.y = (ImageButton) this.u.findViewById(R.id.navi_sdk_lbs_route__recalculate);
        this.y.setOnClickListener(this);
        this.i = (ImageButton) this.u.findViewById(R.id.navi_sdk_lbs_navi_zoomout);
        this.i.setOnClickListener(this);
        this.j = (ImageButton) this.u.findViewById(R.id.navi_sdk_lbs_navi_zoomin);
        this.j.setOnClickListener(this);
        this.B = (ImageButton) this.u.findViewById(R.id.navi_sdk_lbs_route_traffic_btn);
        this.B.setOnClickListener(this);
        this.k = (ImageView) this.u.findViewById(R.id.navi_sdk_lbs_route_iv_forbidden_pop);
        this.k.setOnClickListener(this);
        this.n = (ForbiddenTipView) this.u.findViewById(R.id.navi_sdk_forbidden_head);
        this.n.setForbiddenTipListener(this.o);
        b(bundle);
        mq.a(this.g);
    }

    private void b(Bundle bundle) {
        int i2;
        if (this.g != null) {
            this.G = mo.a(this.g);
            this.z.setVisibility(AmapNaviPage.getInstance().isShowRouteStrategyPreferenceView() ? 0 : 8);
            if (bundle != null) {
                this.O = bundle.getBoolean(AmapNaviPage.SHOWCROSSIMAGE, true);
            }
            if (!AmapNaviPage.getInstance().isTrafficEnable()) {
                this.B.setImageDrawable(mm.a().getDrawable(com.a11hud.www.R.attr.textAppearanceListItemSecondary));
                this.t.setTrafficEnabled(false);
                this.E = false;
            } else {
                this.B.setImageDrawable(mm.a().getDrawable(com.a11hud.www.R.attr.textAppearanceListItemSmall));
                this.t.setTrafficEnabled(true);
                this.E = true;
            }
        }
        this.N = bundle.getInt("navi_type", 0);
        this.H.setCallback(new PoiInputSearchWidget.Callback() {
            /* class com.amap.api.col.stln3.kt.AnonymousClass1 */

            @Override // com.amap.api.navi.view.PoiInputSearchWidget.Callback
            public final void onClick(int i, int i2, Poi poi) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString(DistrictSearchQuery.KEYWORDS_CITY, "北京市");
                    if (kt.this.x != null) {
                        String e = kt.this.x.e();
                        if (!TextUtils.isEmpty(e)) {
                            bundle.putString(DistrictSearchQuery.KEYWORDS_CITY, e);
                        }
                    }
                    bundle.putString("content", kt.this.a((kt) i, i2));
                    bundle.putInt("input_type", i);
                    bundle.putInt("input_type_mid", i2);
                    if (i == 2) {
                        bundle.putString("hint", "请输入途经点");
                    }
                    kt.this.g.newScr(new kn(3, bundle));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.amap.api.navi.view.PoiInputSearchWidget.Callback
            public final void onDelete(int i, Poi poi) {
                if (i < 3) {
                    if (i == 0) {
                        kt.this.g.getSearchResult().c(null);
                        kt.this.g.getSearchResult().c(kt.this.g.getSearchResult().d());
                        kt.this.g.getSearchResult().d(kt.this.g.getSearchResult().e());
                        kt.this.g.getSearchResult().e(null);
                    }
                    if (i == 1) {
                        kt.this.g.getSearchResult().d(null);
                        kt.this.g.getSearchResult().d(kt.this.g.getSearchResult().e());
                        kt.this.g.getSearchResult().e(null);
                    }
                    if (i == 2) {
                        kt.this.g.getSearchResult().e(null);
                    }
                }
            }

            @Override // com.amap.api.navi.view.PoiInputSearchWidget.Callback
            public final void onBack() {
                kt.this.g.closeScr();
            }

            @Override // com.amap.api.navi.view.PoiInputSearchWidget.Callback
            public final boolean onSwitch() {
                Poi b = kt.this.g.getSearchResult().b();
                Poi f = kt.this.g.getSearchResult().f();
                Poi c = kt.this.g.getSearchResult().c();
                kt.this.g.getSearchResult().d();
                kt.this.g.getSearchResult().c(kt.this.g.getSearchResult().e());
                kt.this.g.getSearchResult().e(c);
                kt.this.g.getSearchResult().b(f);
                kt.this.g.getSearchResult().f(b);
                if (kt.this.H.isFinishBtnVisible() || b == null || f == null) {
                    return true;
                }
                kt.this.m();
                return true;
            }

            @Override // com.amap.api.navi.view.PoiInputSearchWidget.Callback
            public final void onSwitchFail() {
            }

            @Override // com.amap.api.navi.view.PoiInputSearchWidget.Callback
            public final void onStartChooseMid() {
            }

            @Override // com.amap.api.navi.view.PoiInputSearchWidget.Callback
            public final void onFinishChooseMid() {
                if (kt.this.l()) {
                    if (kt.this.C.getVisibility() == 8) {
                        kt.this.C.setVisibility(0);
                        kt.this.C.setPanelState(SlidingUpPanelLayout.PanelState.NAVI_SDK_COLLAPSED);
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) kt.this.w.getLayoutParams();
                        layoutParams.bottomMargin = kt.this.a(150.0f);
                        kt.this.w.setLayoutParams(layoutParams);
                    }
                    kt.this.m();
                }
            }
        });
        int i3 = this.I;
        if (i3 == 4) {
            try {
                Poi poi = (Poi) bundle.getParcelable(AmapNaviPage.POI_END);
                Poi poi2 = null;
                if (!a(poi)) {
                    poi = null;
                }
                Poi poi3 = (Poi) bundle.getParcelable(AmapNaviPage.POI_START);
                if (!a(poi3)) {
                    poi3 = null;
                }
                Poi poi4 = (Poi) bundle.getParcelable(AmapNaviPage.POI_WAY1);
                Poi poi5 = (Poi) bundle.getParcelable(AmapNaviPage.POI_WAY2);
                Poi poi6 = (Poi) bundle.getParcelable(AmapNaviPage.POI_WAY3);
                if (this.g != null) {
                    this.g.getSearchResult().f(poi);
                }
                if (this.g != null) {
                    this.g.getSearchResult().b(poi3);
                }
                if (!a(poi4)) {
                    poi4 = null;
                }
                if (!a(poi5)) {
                    poi5 = null;
                }
                if (a(poi6)) {
                    poi2 = poi6;
                }
                if (this.g != null) {
                    this.g.getSearchResult().a(poi4, poi5, poi2);
                }
                j();
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.g != null) {
                    this.g.removeLoadingDialog();
                }
            }
        } else if (i3 == 2) {
            if (bundle != null) {
                try {
                    i2 = bundle.getInt("routeid");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                i2 = 12;
            }
            HashMap<Integer, AMapNaviPath> naviPaths = this.h.getNaviPaths();
            if (naviPaths != null) {
                ArrayList arrayList = new ArrayList(naviPaths.keySet());
                int[] iArr = new int[arrayList.size()];
                long j2 = 0;
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
                    j2 += naviPaths.get(arrayList.get(i4)).getPathid();
                }
                if (this.L != j2) {
                    this.K = R.id.navi_sdk_route_select_tab1;
                    a(this.G);
                } else {
                    if (i2 == 12) {
                        this.K = R.id.navi_sdk_route_select_tab1;
                    }
                    if (i2 == 13) {
                        this.K = R.id.navi_sdk_route_select_tab2;
                    }
                    if (i2 == 14) {
                        this.K = R.id.navi_sdk_route_select_tab3;
                    }
                    if (iArr.length > 0) {
                        a(iArr);
                    }
                }
                a(false);
            }
        }
        if (this.I == 3) {
            try {
                if (this.g.getSearchResult().a() != null) {
                    LatLng coordinate = this.g.getSearchResult().a().getCoordinate();
                    if (coordinate != null) {
                        this.t.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinate, 15.0f));
                    }
                }
                boolean z2 = bundle.getBoolean("needRecalculate");
                int i5 = bundle.getInt("input_type");
                int i6 = bundle.getInt("input_type_mid");
                if (i5 == 0) {
                    this.H.setPoi(0, -1, this.g.getSearchResult().b());
                } else if (i5 == 1) {
                    this.H.setPoi(1, -1, this.g.getSearchResult().f());
                } else if (i5 == 2) {
                    Poi c = this.g.getSearchResult().c();
                    Poi d = this.g.getSearchResult().d();
                    Poi e2 = this.g.getSearchResult().e();
                    if (i6 == 0) {
                        this.H.setPoi(2, 0, c);
                    }
                    if (i6 == 1) {
                        this.H.setPoi(2, 1, d);
                    }
                    if (i6 == 2) {
                        this.H.setPoi(2, 2, e2);
                    }
                }
                String str = "RoutePage initParams(来自搜索页面)mRecalculate=" + z2;
                if (z2 && this.H != null && this.H.isAllInputItemsFilled()) {
                    if (this.C.getVisibility() == 8) {
                        this.C.setVisibility(0);
                        this.C.setPanelState(SlidingUpPanelLayout.PanelState.NAVI_SDK_COLLAPSED);
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.w.getLayoutParams();
                        layoutParams.bottomMargin = a(150.0f);
                        this.w.setLayoutParams(layoutParams);
                    }
                    this.H.setShowChooseRes();
                    m();
                } else if (this.J != null) {
                    a(this.J);
                }
                a(false);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j() {
        try {
            this.g.removeLoadingDialog();
            Poi b2 = this.g.getSearchResult().b();
            Poi f = this.g.getSearchResult().f();
            if (!(b2 == null || f == null)) {
                if (k()) {
                    this.g.getSearchResult().f(null);
                    ma.a(this.g, "起点与终点不能相同");
                    f = null;
                }
            }
            if (f == null) {
                this.C.setVisibility(8);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.w.getLayoutParams();
                layoutParams.bottomMargin = 0;
                this.w.setLayoutParams(layoutParams);
                this.y.setVisibility(8);
                this.z.setVisibility(8);
            }
            ArrayList arrayList = new ArrayList();
            if (this.g.getSearchResult().c() != null) {
                arrayList.add(this.g.getSearchResult().c());
            }
            if (this.g.getSearchResult().d() != null) {
                arrayList.add(this.g.getSearchResult().d());
            }
            if (this.g.getSearchResult().e() != null) {
                arrayList.add(this.g.getSearchResult().e());
            }
            this.H.initUI(b2, f, arrayList, 3);
            a(arrayList);
            if (!(b2 == null || f == null)) {
                a(this.G);
            }
            a(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean k() {
        Poi b2 = this.g.getSearchResult().b();
        Poi f = this.g.getSearchResult().f();
        Poi c = this.g.getSearchResult().c();
        Poi d = this.g.getSearchResult().d();
        Poi e = this.g.getSearchResult().e();
        if (c != null || d != null || e != null) {
            return false;
        }
        if (!TextUtils.isEmpty(b2.getPoiId()) && !TextUtils.isEmpty(f.getPoiId()) && b2.getPoiId().equals(f.getPoiId())) {
            return true;
        }
        if (b2.getCoordinate() == null || f.getCoordinate() == null || b2.getCoordinate().longitude != f.getCoordinate().longitude || b2.getCoordinate().latitude != f.getCoordinate().latitude) {
            return false;
        }
        return true;
    }

    private static boolean a(Poi poi) {
        if (poi != null && poi.getCoordinate() != null && poi.getCoordinate().longitude <= 180.0d && poi.getCoordinate().longitude >= -180.0d && poi.getCoordinate().latitude <= 90.0d && poi.getCoordinate().latitude >= -90.0d) {
            return true;
        }
        return false;
    }

    private void a(List<Poi> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    switch (list.size()) {
                        case 1:
                            this.g.getSearchResult().a(list.get(0), null, null);
                            this.H.setPoi(2, 0, list.get(0));
                            return;
                        case 2:
                            this.g.getSearchResult().a(list.get(0), list.get(1), null);
                            this.H.setPoi(2, 0, list.get(0));
                            this.H.setPoi(2, 1, list.get(1));
                            return;
                        case 3:
                            this.g.getSearchResult().a(list.get(0), list.get(1), list.get(2));
                            this.H.setPoi(2, 0, list.get(0));
                            this.H.setPoi(2, 1, list.get(1));
                            this.H.setPoi(2, 2, list.get(2));
                            return;
                        default:
                            return;
                    }
                } else {
                    this.g.getSearchResult().a(null, null, null);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean l() {
        Poi b2 = this.g.getSearchResult().b();
        Poi f = this.g.getSearchResult().f();
        Poi c = this.g.getSearchResult().c();
        Poi d = this.g.getSearchResult().d();
        Poi e = this.g.getSearchResult().e();
        if (b2 == this.W && this.aa == e && this.Y == c && this.Z == d && this.X == f) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        if (c != null) {
            arrayList.add(c);
        }
        if (d != null) {
            arrayList.add(d);
        }
        if (e != null) {
            arrayList.add(e);
        }
        a(arrayList);
        if (b2 == null || f == null) {
            this.D.showFailedLoading("起点或终点坐标不能为空");
            return false;
        } else if (c != null || d != null || e != null) {
            return true;
        } else {
            try {
                if (b2.getCoordinate().longitude != f.getCoordinate().longitude || b2.getCoordinate().latitude != f.getCoordinate().latitude) {
                    return true;
                }
                this.D.showFailedLoading("起点与终点不能相同");
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return true;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0077 A[Catch:{ Exception -> 0x001d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(int r5, int r6) {
        /*
        // Method dump skipped, instructions count: 136
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.kt.a(int, int):java.lang.String");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void m() {
        try {
            a(this.G);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(int i2) {
        try {
            Poi b2 = this.g.getSearchResult().b();
            Poi f = this.g.getSearchResult().f();
            Poi c = this.g.getSearchResult().c();
            Poi d = this.g.getSearchResult().d();
            Poi e = this.g.getSearchResult().e();
            if (b2 == null || f == null) {
                ma.a(this.g, "起点或终点坐标不能为空");
                return;
            }
            try {
                if (k()) {
                    ma.a(this.g, "起点与终点不能相同");
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.K = R.id.navi_sdk_route_select_tab1;
            this.C.setPanelState(SlidingUpPanelLayout.PanelState.NAVI_SDK_COLLAPSED);
            this.D.showLoading();
            this.W = b2;
            this.X = f;
            this.Y = c;
            this.Z = d;
            this.aa = e;
            String str = "calculate(开始算路，策略=" + i2 + ")";
            AMapCarInfo g = this.g.getSearchResult().g();
            if (g != null) {
                this.h.setCarInfo(g);
            }
            ArrayList arrayList = new ArrayList();
            if (c != null) {
                arrayList.add(c);
            }
            if (d != null) {
                arrayList.add(d);
            }
            if (e != null) {
                arrayList.add(e);
            }
            if (this.N == 0) {
                this.h.calculateDriveRoute(b2, f, arrayList, i2);
            } else {
                NaviLatLng naviLatLng = null;
                NaviLatLng naviLatLng2 = new NaviLatLng(f.getCoordinate().latitude, f.getCoordinate().longitude);
                if (b2.getCoordinate() != null) {
                    naviLatLng = new NaviLatLng(b2.getCoordinate().latitude, b2.getCoordinate().longitude);
                }
                if (this.N == 2) {
                    if (naviLatLng != null) {
                        this.h.calculateRideRoute(naviLatLng, naviLatLng2);
                    } else {
                        this.h.calculateRideRoute(naviLatLng2);
                    }
                } else if (this.N == 1) {
                    if (naviLatLng != null) {
                        this.h.calculateWalkRoute(naviLatLng, naviLatLng2);
                    } else {
                        this.h.calculateWalkRoute(naviLatLng2);
                    }
                }
            }
            if (this.H != null) {
                this.H.isInRouteCal(true);
            }
            this.P = System.currentTimeMillis();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.col.stln3.ke
    public final void g() {
        super.g();
        TextureMapView textureMapView = this.s;
        if (textureMapView != null) {
            textureMapView.onResume();
        }
    }

    @Override // com.amap.api.col.stln3.ke
    public final void i() {
        super.i();
        TextureMapView textureMapView = this.s;
        if (textureMapView != null) {
            textureMapView.onPause();
        }
    }

    @Override // com.amap.api.col.stln3.ke
    public final void h() {
        super.h();
        kq kqVar = this.x;
        if (kqVar != null) {
            kqVar.b();
        }
    }

    @Override // com.amap.api.col.stln3.ke
    public final void f() {
        TextureMapView textureMapView = this.s;
        if (textureMapView != null) {
            textureMapView.onDestroy();
            RelativeLayout relativeLayout = this.v;
            if (relativeLayout != null) {
                relativeLayout.removeView(this.s);
            }
            this.s = null;
        }
        AMapNavi aMapNavi = this.h;
        if (aMapNavi != null) {
            aMapNavi.removeAMapNaviListener(this);
        }
        e eVar = this.R;
        if (eVar != null) {
            eVar.e();
            this.R = null;
        }
        kq kqVar = this.x;
        if (kqVar != null) {
            kqVar.c();
            this.x = null;
        }
        Polygon polygon = this.Q;
        if (polygon != null) {
            polygon.remove();
        }
        ForbiddenTipView forbiddenTipView = this.n;
        if (forbiddenTipView != null) {
            forbiddenTipView.destroy();
        }
    }

    @Override // com.amap.api.col.stln3.ke
    public final boolean b() {
        SlidingUpPanelLayout slidingUpPanelLayout = this.C;
        if (slidingUpPanelLayout == null || slidingUpPanelLayout.getPanelState() != SlidingUpPanelLayout.PanelState.NAVI_SDK_EXPANDED) {
            try {
                if (this.s != null) {
                    this.s.onDestroy();
                    this.v.removeView(this.s);
                    this.s = null;
                }
                if (this.h != null) {
                    this.h.removeAMapNaviListener(this);
                    this.h = null;
                }
                if (this.R != null) {
                    this.R.e();
                    this.R = null;
                }
                if (this.x != null) {
                    this.x.c();
                    this.x = null;
                }
                if (this.F != null) {
                    this.F.clear();
                    this.F = null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return super.b();
        }
        this.C.setPanelState(SlidingUpPanelLayout.PanelState.NAVI_SDK_COLLAPSED);
        return false;
    }

    @Override // com.amap.api.col.stln3.ke
    public final void a() {
    }

    @Override // com.amap.api.col.stln3.ke
    public final void a(View view) {
        onClick(view);
    }

    public final void onClick(View view) {
        try {
            Poi b2 = this.g.getSearchResult().b();
            Poi f = this.g.getSearchResult().f();
            if (!this.D.isLoadingShowing()) {
                Bundle bundle = new Bundle();
                int id = view.getId();
                if (!(id == 2147479765 || id == 2147479769)) {
                    if (id != 2147479773) {
                        if (id == 2147479624) {
                            this.x.a();
                            LatLng d = this.x.d();
                            if (d != null) {
                                this.t.moveCamera(CameraUpdateFactory.newLatLngZoom(d, 15.0f));
                                return;
                            }
                            return;
                        } else if (id == 2147479782) {
                            if ("我的位置".equals(this.g.getSearchResult().f().getName())) {
                                ma.a(this.g, "导航终点不能为“当前位置”");
                                return;
                            }
                            bundle.putInt("navi_mode", 1);
                            c(bundle);
                            return;
                        } else if (id == 2147479784) {
                            bundle.putInt("navi_mode", 2);
                            c(bundle);
                            return;
                        } else if (id == 2147479785) {
                            bundle.putInt("navi_mode", 1);
                            c(bundle);
                            return;
                        } else if (id == 2147479625) {
                            if (this.R == null) {
                                this.R = new e(this.g);
                                this.R.a(false);
                            }
                            this.R.setHeight(a(300.0f));
                            this.R.d();
                            this.R.showAtLocation(this.u, 80, 0, 0);
                            this.R.setOnDismissListener(new PopupWindow.OnDismissListener() {
                                /* class com.amap.api.col.stln3.kt.AnonymousClass4 */

                                public final void onDismiss() {
                                    try {
                                        if (kt.this.V != null) {
                                            kt.this.V.obtainMessage(2).sendToTarget();
                                        }
                                        int a2 = mo.a(kt.this.g);
                                        INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
                                        if (callback != null) {
                                            if (a2 != kt.this.G) {
                                                callback.onStrategyChanged(a2);
                                            }
                                        }
                                        kt.a(kt.this, a2);
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                            });
                            this.T = false;
                            if (this.V != null) {
                                this.V.obtainMessage(1).sendToTarget();
                                return;
                            }
                            return;
                        } else if (id == 2147479626) {
                            if (System.currentTimeMillis() - this.P > ((long) this.l)) {
                                this.G = 19;
                                m();
                                return;
                            }
                            ma.a(this.g, "暂无新路线");
                            return;
                        } else if (id == 2147479627) {
                            if (this.t.isTrafficEnabled()) {
                                this.B.setImageDrawable(mm.a().getDrawable(com.a11hud.www.R.attr.textAppearanceListItemSecondary));
                                this.t.setTrafficEnabled(false);
                                this.E = false;
                                return;
                            }
                            this.B.setImageDrawable(mm.a().getDrawable(com.a11hud.www.R.attr.textAppearanceListItemSmall));
                            this.t.setTrafficEnabled(true);
                            this.E = true;
                            return;
                        } else if (id == 2147479631) {
                            this.t.animateCamera(CameraUpdateFactory.zoomOut());
                            return;
                        } else if (id == 2147479630) {
                            this.t.animateCamera(CameraUpdateFactory.zoomIn());
                            return;
                        } else if (id == 2147479628) {
                            if (this.U == null) {
                                this.U = new ForbiddenPopTip(this.g);
                            }
                            this.U.setHeight(mj.a(this.g.getBaseContext(), 60));
                            int[] iArr = new int[2];
                            this.n.getLocationOnScreen(iArr);
                            this.U.showAtLocation(this.k, 0, iArr[0], iArr[1]);
                            final WindowManager.LayoutParams attributes = this.g.getWindow().getAttributes();
                            attributes.alpha = 0.7f;
                            this.g.getWindow().setAttributes(attributes);
                            this.U.setOnDismissListener(new PopupWindow.OnDismissListener() {
                                /* class com.amap.api.col.stln3.kt.AnonymousClass5 */

                                public final void onDismiss() {
                                    try {
                                        attributes.alpha = 1.0f;
                                        kt.this.g.getWindow().setAttributes(attributes);
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                            });
                            return;
                        } else {
                            return;
                        }
                    }
                }
                if (view.getId() == this.K) {
                    this.C.setPanelState(SlidingUpPanelLayout.PanelState.NAVI_SDK_EXPANDED);
                    return;
                }
                this.K = view.getId();
                this.D.selectRouteTab(view.getId());
                if (this.C.getPanelState() == SlidingUpPanelLayout.PanelState.NAVI_SDK_EXPANDED) {
                    this.D.setGuideData(b2.getName(), f.getName(), this.h);
                }
            } else if (view.getId() == 2147479660) {
                if (this.M == a.CALCULATE_FAILE) {
                    m();
                }
                if (this.M == a.LOCATION_FAILE) {
                    a(true);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void c(Bundle bundle) {
        bundle.putBoolean(AmapNaviPage.SHOWCROSSIMAGE, this.O);
        this.g.newScr(new kn(2, bundle));
        HashMap<Integer, AMapNaviPath> naviPaths = this.h.getNaviPaths();
        this.L = 0;
        for (Map.Entry<Integer, AMapNaviPath> entry : naviPaths.entrySet()) {
            this.L += entry.getValue().getPathid();
        }
    }

    @Override // com.amap.api.col.stln3.ke
    public final View e() {
        if (this.u == null) {
            this.u = mm.a(this.g, R.layout.amap_navi_lbs_activity_route, null);
        }
        return this.u;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(int i2, AMapNaviPath aMapNaviPath) {
        this.t.moveCamera(CameraUpdateFactory.changeTilt(0.0f));
        final kh khVar = new kh(this.t, aMapNaviPath, this.g);
        if (this.p != i2) {
            khVar.a(0);
            khVar.b(-1);
        }
        khVar.a(new kd.a() {
            /* class com.amap.api.col.stln3.kt.AnonymousClass2 */

            @Override // com.amap.api.col.stln3.kd.a
            public final void a(AMapNaviLimitInfo aMapNaviLimitInfo) {
                if (kt.this.S == null) {
                    kt ktVar = kt.this;
                    ktVar.S = new com.amap.api.navi.services.view.b(ktVar.g);
                }
                kt.this.S.setHeight(kt.this.a(60.0f));
                kt.this.S.a(aMapNaviLimitInfo);
                kt.K(kt.this);
            }

            @Override // com.amap.api.col.stln3.kd.a
            public final void a(AMapNaviForbiddenInfo aMapNaviForbiddenInfo) {
                if (kt.this.S == null) {
                    kt ktVar = kt.this;
                    ktVar.S = new com.amap.api.navi.services.view.b(ktVar.g);
                }
                kt.this.S.setHeight(kt.this.a(120.0f));
                kt.this.S.a(aMapNaviForbiddenInfo);
                kt.K(kt.this);
            }
        });
        this.F.put(i2, khVar);
        jg.a().execute(new Runnable() {
            /* class com.amap.api.col.stln3.kt.AnonymousClass3 */

            public final void run() {
                try {
                    khVar.e();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(int i2) {
        try {
            HashMap<Integer, AMapNaviPath> naviPaths = this.h.getNaviPaths();
            if (naviPaths != null) {
                this.p = i2;
                for (int i3 = 0; i3 < this.F.size(); i3++) {
                    int keyAt = this.F.keyAt(i3);
                    if (keyAt != i2) {
                        this.F.get(keyAt).a(0);
                        this.F.get(keyAt).b(-1);
                    }
                }
                this.F.get(i2).a(1);
                this.F.get(i2).b(0);
                this.h.selectRouteId(i2);
                AMapNaviPath naviPath = this.h.getNaviPath();
                List<AMapNaviStep> steps = naviPath.getSteps();
                int tollCost = naviPath.getTollCost();
                int i4 = 0;
                for (AMapNaviStep aMapNaviStep : steps) {
                    i4 += aMapNaviStep.getTrafficLightNumber();
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("红绿灯");
                stringBuffer.append(i4);
                stringBuffer.append("个 ");
                if (tollCost > 0) {
                    stringBuffer.append("过路费");
                    stringBuffer.append(tollCost);
                    stringBuffer.append("元");
                }
                this.D.updateRouteInfo(stringBuffer.toString());
                a(naviPath);
                a(naviPaths, 0);
                if (this.U == null) {
                    this.U = new ForbiddenPopTip(this.g);
                }
                this.U.upRouteForbiddenInfo(naviPath.getRestrictionInfo());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(HashMap<Integer, AMapNaviPath> hashMap, int i2) {
        float f = (float) (i2 + 65);
        float f2 = (float) (i2 + 80);
        this.t.animateCamera(CameraUpdateFactory.newLatLngBoundsRect(hashMap.get(12).getBoundsForPath(), a(f), a(f), this.H.getHeight() + a(f2), a(f2)), 300, null);
    }

    private void a(AMapNaviPath aMapNaviPath) {
        int i2;
        int i3;
        int i4;
        List<AMapNaviLimitInfo> limitInfos = aMapNaviPath.getLimitInfos();
        List<AMapNaviForbiddenInfo> forbiddenInfos = aMapNaviPath.getForbiddenInfos();
        if (limitInfos != null) {
            i3 = 0;
            i2 = 0;
            for (int i5 = 0; i5 < limitInfos.size(); i5++) {
                AMapNaviLimitInfo aMapNaviLimitInfo = limitInfos.get(i5);
                if (aMapNaviLimitInfo.type == 82) {
                    i2++;
                } else if (aMapNaviLimitInfo.type == 81) {
                    i3++;
                }
            }
        } else {
            i3 = 0;
            i2 = 0;
        }
        if (forbiddenInfos != null) {
            i4 = forbiddenInfos.size();
        } else {
            i4 = 0;
        }
        String str = "";
        if (i4 > 0) {
            str = str + i4 + "处禁行，";
        }
        if (i3 > 0) {
            str = str + i3 + "处限高，";
        }
        if (i2 > 0) {
            str = str + i3 + "处限宽，";
        }
        this.D.updateLimitForbiddenInfo(str.length() > 2 ? str.substring(0, str.length() - 1) + "无法避开" : null);
    }

    @Override // com.amap.api.col.stln3.kr
    public final void a(int i2, LatLng latLng) {
        Poi b2 = this.g.getSearchResult().b();
        Poi f = this.g.getSearchResult().f();
        if (i2 == 0 || !(b2 == null || f == null)) {
            POIInfo pOIInfo = new POIInfo();
            pOIInfo.latitude = latLng.latitude;
            pOIInfo.longitude = latLng.longitude;
            this.g.getSearchResult().a(new Poi("我的位置", new LatLng(latLng.latitude, latLng.longitude), null));
            if (b2 == null) {
                Poi poi = new Poi("我的位置", new LatLng(latLng.latitude, latLng.longitude), null);
                this.g.getSearchResult().b(poi);
                this.H.setPoi(0, -1, poi);
                this.H.setShowChooseRes();
                if (this.I != 4) {
                    return;
                }
                if (f == null || (f.getCoordinate() == null && TextUtils.isEmpty(f.getPoiId()))) {
                    this.A.performClick();
                    return;
                }
                this.g.getSearchResult().f(f);
                this.H.setPoi(1, -1, f);
                this.H.setShowChooseRes();
                m();
                return;
            }
            return;
        }
        this.M = a.LOCATION_FAILE;
        this.H.setPoi(0, -1, new Poi("", new LatLng(0.0d, 0.0d), null));
        this.C.setPanelState(SlidingUpPanelLayout.PanelState.NAVI_SDK_COLLAPSED);
        SlidingTabLayout slidingTabLayout = this.D;
        String str = "算路失败,请稍后重试";
        switch (i2) {
            case 2:
                str = "定位失败,仅扫描到单个wifi";
                break;
            case 4:
                str = "定位失败,请求服务器出现异常";
                break;
            case 5:
                str = "定位失败,定位结果解析失败";
                break;
            case 6:
                str = "定位失败,定位服务返回定位失败";
                break;
            case 7:
                str = "定位失败,key非法或过期";
                break;
            case 9:
                str = "定位失败,初始化时出现异常";
                break;
            case 11:
                str = "定位失败,基站信息错误";
                break;
            case 12:
                str = "定位失败,缺少定位权限";
                break;
            case 13:
                str = "定位失败,未获得WIFI列表和基站信息，且GPS当前不可用";
                break;
            case 15:
                str = "定位失败,定位结果被模拟导致定位失败";
                break;
        }
        slidingTabLayout.showFailedLoading(str);
    }

    private void a(boolean z2) {
        if (this.x == null) {
            this.x = new ki(this.g);
            this.x.a(this);
        }
        this.x.a(this.t);
        this.x.a(z2);
        this.x.a();
    }

    private void a(int[] iArr) {
        String str;
        PoiInputSearchWidget poiInputSearchWidget = this.H;
        if (poiInputSearchWidget != null) {
            poiInputSearchWidget.isInRouteCal(false);
        }
        if (this.Q != null) {
            this.Q = this.t.addPolygon(new PolygonOptions().add(new LatLng(85.0d, -180.0d), new LatLng(85.0d, 179.99999d), new LatLng(-85.0d, 179.9999d), new LatLng(-85.0d, -180.0d)).fillColor(-1996488705));
            this.Q.setZIndex(-1.0f);
        }
        this.J = iArr;
        this.y.setVisibility(0);
        this.z.setVisibility(AmapNaviPage.getInstance().isShowRouteStrategyPreferenceView() ? 0 : 8);
        SparseArray<kh> sparseArray = this.F;
        if (sparseArray != null && sparseArray.size() > 0) {
            for (int i2 = 0; i2 < this.F.size(); i2++) {
                kh valueAt = this.F.valueAt(i2);
                valueAt.a();
                valueAt.d();
            }
            this.F.clear();
        }
        Marker marker = this.q;
        if (marker != null) {
            marker.remove();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.w.getLayoutParams();
        HashMap<Integer, AMapNaviPath> naviPaths = this.h.getNaviPaths();
        if (iArr.length == 1) {
            this.C.setPanelHeight(a(132.0f));
            this.D.setMultipleRouteLayoutVisible(false);
            this.D.setSingleRouteLayoutVisible(true);
            this.h.selectRouteId(iArr[0]);
            AMapNaviPath naviPath = this.h.getNaviPath();
            this.p = iArr[0];
            a(iArr[0], naviPath);
            b(iArr[0]);
            SlidingTabLayout slidingTabLayout = this.D;
            StringBuilder sb = new StringBuilder();
            sb.append(mj.c(naviPath.getAllTime()));
            sb.append(" ");
            int allLength = naviPath.getAllLength();
            if (allLength < 0) {
                str = null;
            } else if (allLength >= 1000) {
                str = String.format("%.1f公里", Float.valueOf((float) (((double) allLength) / 1000.0d)));
            } else {
                str = allLength + "米";
            }
            sb.append(str);
            slidingTabLayout.updateSingleRouteInfo(sb.toString());
            layoutParams.bottomMargin = a(130.0f);
        } else {
            this.C.setPanelHeight(a(150.0f));
            this.D.setMultipleRouteLayoutVisible(true);
            this.D.setSingleRouteLayoutVisible(false);
            if (this.K == 2147479765) {
                this.p = 12;
            }
            if (this.K == 2147479769) {
                this.p = 13;
            }
            if (this.K == 2147479773) {
                this.p = 14;
            }
            this.D.updateRouteTable(iArr, naviPaths);
            String str2 = "onCalculateRouteSuccess----》selectedTabId=" + this.K;
            this.D.selectRouteTab(this.K);
            layoutParams.bottomMargin = a(150.0f);
        }
        this.w.setLayoutParams(layoutParams);
        this.D.hideLoading();
        this.M = a.SUCCESS;
        this.n.setRestrictionInfo(this.h.getNaviPath().getRestrictionInfo(), 20, true);
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onCalculateRouteSuccess(int[] iArr) {
        try {
            a(iArr);
            INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
            if (callback != null) {
                callback.onCalculateRouteSuccess(iArr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onInitNaviFailure() {
        INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
        if (callback != null) {
            callback.onInitNaviFailure();
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onInitNaviSuccess() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onStartNavi(int i2) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onTrafficStatusUpdate() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onLocationChange(AMapNaviLocation aMapNaviLocation) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onGetNavigationText(int i2, String str) {
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
    public final void onCalculateRouteFailure(int i2) {
        PoiInputSearchWidget poiInputSearchWidget = this.H;
        if (poiInputSearchWidget != null) {
            poiInputSearchWidget.isInRouteCal(false);
        }
        this.M = a.CALCULATE_FAILE;
        this.D.showFailedLoading(lz.a(i2));
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
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onGpsOpenStatus(boolean z2) {
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

    @Override // com.amap.api.maps.AMap.OnCameraChangeListener
    public final void onCameraChange(CameraPosition cameraPosition) {
    }

    @Override // com.amap.api.maps.AMap.OnCameraChangeListener
    public final void onCameraChangeFinish(CameraPosition cameraPosition) {
        AMap aMap = this.t;
        if (aMap != null) {
            if (aMap.getCameraPosition().zoom >= this.t.getMaxZoomLevel()) {
                this.i.setEnabled(false);
            } else {
                this.i.setEnabled(true);
            }
            if (this.t.getCameraPosition().zoom <= this.t.getMinZoomLevel()) {
                this.j.setEnabled(false);
            } else {
                this.j.setEnabled(true);
            }
        }
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
}
