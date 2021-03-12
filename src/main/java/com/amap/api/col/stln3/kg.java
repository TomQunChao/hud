package com.amap.api.col.stln3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.internal.view.SupportMenu;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a11hud.www.R;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.AMapNaviViewListener;
import com.amap.api.navi.AMapNaviViewOptions;
import com.amap.api.navi.AmapNaviPage;
import com.amap.api.navi.AmapRouteActivity;
import com.amap.api.navi.INavi;
import com.amap.api.navi.INaviInfoCallback;
import com.amap.api.navi.core.view.BaseNaviView;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapModelCross;
import com.amap.api.navi.model.AMapNaviGuide;
import com.amap.api.navi.model.AMapNaviMarkerOptions;
import com.amap.api.navi.model.AMapNaviRouteNotifyData;
import com.amap.api.navi.model.AMapNotAvoidInfo;
import com.amap.api.navi.model.RouteOverlayOptions;
import com.amap.api.navi.services.view.NaviInfoLayout_L;
import com.amap.api.navi.services.view.NaviInfoLayout_P;
import com.amap.api.navi.services.view.e;
import com.amap.api.navi.services.view.f;
import com.amap.api.navi.view.DriveWayView;
import com.amap.api.navi.view.ForbiddenPopTip;
import com.amap.api.navi.view.LbsNaviView;
import com.amap.api.navi.view.NightModeImageView;
import com.amap.api.navi.view.NightModeTextView;
import com.amap.api.navi.view.PoiInputSearchWidget;
import com.amap.api.navi.view.TrafficProgressBar;
import com.amap.api.navi.view.ZoomInIntersectionView;
import com.amap.api.navi.view.statusbar.NavigationStatusBarView;
import com.amap.api.navi.view.statusbar.StatusBarGpsItemView;
import com.autonavi.ae.pos.LocManager;
import com.autonavi.amap.mapcore.tools.GLMapStaticValue;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressLint({"NewApi"})
/* compiled from: LbsNaviViewCore */
public final class kg implements View.OnClickListener, AMapNaviViewListener {
    public static int ai = GLMapStaticValue.MAPRENDER_CAN_STOP_AND_FULLSCREEN_RENDEROVER;
    private static int an = 500;
    NightModeTextView A;
    NightModeTextView B;
    NightModeTextView C;
    NightModeTextView D;
    NightModeTextView E;
    NightModeTextView F;
    NightModeTextView G;
    NightModeTextView H;
    NightModeTextView I;
    RelativeLayout J;
    RelativeLayout K;
    LinearLayout L;
    ImageView M;
    FrameLayout N;
    FrameLayout O;
    int P = GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH;
    int Q = GLMapStaticValue.ANIMATION_MOVE_TIME;
    boolean R = false;
    int S = 0;
    int T = 0;
    boolean U = false;
    LbsNaviView V;
    NavigationStatusBarView W = null;
    StatusBarGpsItemView X = null;
    public NaviInfoLayout_L Y;
    public NaviInfoLayout_P Z;
    int a = 35;
    private boolean aA = false;
    private boolean aB = false;
    private DriveWayView aC;
    private int aD = 540;
    private int aE = 220;
    private int aF = 120;
    private boolean aG = false;
    private AmapRouteActivity aH;
    private int aI;
    private long aJ;
    private boolean aK = true;
    private int aL = 2;
    private AMapNaviViewOptions aM = null;
    private e aN;
    private boolean aO = true;
    private Handler aP = new Handler() {
        /* class com.amap.api.col.stln3.kg.AnonymousClass3 */

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                switch (message.what) {
                    case 1:
                        e.c();
                        if (e.b() == 0) {
                            kg.this.aP.removeCallbacksAndMessages(null);
                            kg.this.aN.dismiss();
                        }
                        if (kg.this.aO) {
                            Message obtainMessage = kg.this.aP.obtainMessage();
                            obtainMessage.what = 1;
                            kg.this.aP.sendMessageDelayed(obtainMessage, 1000);
                            return;
                        }
                        return;
                    case 2:
                        e.a();
                        kg.this.aO = false;
                        return;
                    case 3:
                        kg.this.C();
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private int aQ = 0;
    private boolean aR = true;
    private Map<AMapNaviMarkerOptions, Marker> aS = new HashMap();
    int aa = 342;
    AMap ab = null;
    ScaleAnimation ac = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 0.0f, 1, 0.0f);
    ScaleAnimation ad = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
    ScaleAnimation ae = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 0.0f, 1, 0.0f);
    ScaleAnimation af = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
    ForbiddenPopTip ag = null;
    f ah = null;
    public String aj = "已为您切换新路线";
    public int ak = 12;
    int al = 6000;
    boolean am = false;
    private boolean ao = false;
    private double ap = 0.5d;
    private double aq = 0.6666666666666666d;
    private BaseNaviView ar;
    private INavi as;
    private kf at;
    private int au = 2;
    private ImageView av;
    private ImageView aw;
    private boolean ax;
    private boolean ay = true;
    private Context az;
    TextView b;
    LinearLayout c;
    LinearLayout d;
    LinearLayout e;
    LinearLayout f;
    TextView g;
    TextView h;
    TrafficProgressBar i;
    ImageView j;
    ZoomInIntersectionView k;
    View l = null;
    TextView m;
    LinearLayout n;
    LinearLayout o;
    LinearLayout p;
    LinearLayout q;
    LinearLayout r;
    LinearLayout s;
    FrameLayout t;
    TextView u;
    ImageView v;
    NightModeImageView w;
    NightModeImageView x;
    NightModeTextView y;
    NightModeTextView z;

    static /* synthetic */ void a(kg kgVar, int i2) {
        if (i2 == kgVar.aI) {
            ma.a(kgVar.az, "策略未改变，不进行重算.");
        } else {
            kgVar.c(i2);
        }
    }

    public kg(LbsNaviView lbsNaviView) {
        this.V = lbsNaviView;
        this.az = lbsNaviView.getContext();
    }

    public final void a(int i2) {
        if (i2 != this.au) {
            this.au = i2;
            if (i2 == 1) {
                this.ar.setNaviMode(1);
                this.ar.setCarLock(false);
            } else if (i2 == 2) {
                this.ar.setLockTilt(this.a);
                this.ar.setNaviMode(0);
                this.ar.setCarLock(false);
            }
        }
    }

    public final void a(AmapRouteActivity amapRouteActivity) {
        try {
            this.aH = amapRouteActivity;
            if (this.aM == null) {
                this.aM = new AMapNaviViewOptions();
            }
            amapRouteActivity.showLoadingDialog("initDialog");
            this.as = AMapNavi.getInstance(this.az);
            if (this.az != null) {
                this.aI = mo.a(this.aH);
            }
            this.aD = mj.a(this.az, 180);
            this.aE = mj.a(this.az, 74);
            this.aa = (int) mm.a().getDimension(R.id.id__btn_nextroute);
            this.aF = mj.a(this.az, 40);
            this.ac.setDuration(300);
            this.ad.setDuration(300);
            this.ae.setDuration(300);
            this.af.setDuration(300);
            mm.a(this.az.getApplicationContext());
            this.l = mm.a(this.az, com.amap.api.navi.R.layout.amap_navi_lbs_navi_fragment_textture, null);
            this.V.addView(this.l);
            this.ar = (BaseNaviView) this.l.findViewById(com.amap.api.navi.R.id.navi_sdk_map);
            this.R = x();
            this.ab = this.ar.getMap();
            if (this.at == null) {
                this.at = new kf(this.az, this.ar, this);
            }
            try {
                this.M = (ImageView) this.l.findViewById(com.amap.api.navi.R.id.navigation_road_switches);
                this.Y = (NaviInfoLayout_L) this.l.findViewById(com.amap.api.navi.R.id.navi_sdk_lbs_navi_expand_land);
                this.Z = (NaviInfoLayout_P) this.l.findViewById(com.amap.api.navi.R.id.navi_sdk_lbs_navi_expand_prot);
                this.b = (TextView) this.l.findViewById(com.amap.api.navi.R.id.navi_sdk_lbs_navi_speed);
                this.c = (LinearLayout) this.l.findViewById(com.amap.api.navi.R.id.navi_sdk_lbs_navi_forbidden);
                this.d = (LinearLayout) this.l.findViewById(com.amap.api.navi.R.id.navi_control_container);
                this.e = (LinearLayout) this.l.findViewById(com.amap.api.navi.R.id.navigation_info_layout_sim);
                this.g = (TextView) this.l.findViewById(com.amap.api.navi.R.id.navi_sdk_lbs_navi_text_forbidden);
                this.h = (TextView) this.l.findViewById(com.amap.api.navi.R.id.navi_sdk_lbs_navi_text_forbidden_label);
                this.f = (LinearLayout) this.l.findViewById(com.amap.api.navi.R.id.navigation_tmc_container);
                this.i = (TrafficProgressBar) this.l.findViewById(com.amap.api.navi.R.id.navi_sdk_lbs_navi_progress_tmcbar);
                this.j = (ImageView) this.l.findViewById(com.amap.api.navi.R.id.btn_port_navi_refresh);
                this.k = (ZoomInIntersectionView) this.V.findViewById(com.amap.api.navi.R.id.navi_sdk_enlarge_road_layout);
                this.v = (ImageView) this.l.findViewById(com.amap.api.navi.R.id.navigation_mode_switches);
                this.J = (RelativeLayout) this.l.findViewById(com.amap.api.navi.R.id.navi_sdk_lbs_navi_middle_layout);
                this.K = (RelativeLayout) this.l.findViewById(com.amap.api.navi.R.id.exit_layout);
                this.L = (LinearLayout) this.l.findViewById(com.amap.api.navi.R.id.navi_alert_layout);
                this.aC = (DriveWayView) this.l.findViewById(com.amap.api.navi.R.id.navi_sdk_driveway);
                this.B = (NightModeTextView) this.l.findViewById(com.amap.api.navi.R.id.remaining_distance_portrait);
                this.A = (NightModeTextView) this.l.findViewById(com.amap.api.navi.R.id.remaining_time_portrait);
                this.C = (NightModeTextView) this.l.findViewById(com.amap.api.navi.R.id.remaining_txt_portrait);
                this.m = (TextView) this.l.findViewById(com.amap.api.navi.R.id.keep_on_navigation_caption_portrait);
                this.n = (LinearLayout) this.l.findViewById(com.amap.api.navi.R.id.remaining_info_portrait);
                this.z = (NightModeTextView) this.l.findViewById(com.amap.api.navi.R.id.navigation_settings_portrait);
                this.E = (NightModeTextView) this.l.findViewById(com.amap.api.navi.R.id.navigation_settings_land);
                this.y = (NightModeTextView) this.l.findViewById(com.amap.api.navi.R.id.exit_navigation_portrait);
                this.D = (NightModeTextView) this.l.findViewById(com.amap.api.navi.R.id.exit_navigation_land);
                this.G = (NightModeTextView) this.l.findViewById(com.amap.api.navi.R.id.exit_navigation_sim);
                this.F = (NightModeTextView) this.l.findViewById(com.amap.api.navi.R.id.autonavi_continue_navi);
                this.H = (NightModeTextView) this.l.findViewById(com.amap.api.navi.R.id.exit_navi_tv);
                this.I = (NightModeTextView) this.l.findViewById(com.amap.api.navi.R.id.cancel_navi_tv);
                this.u = (TextView) this.l.findViewById(com.amap.api.navi.R.id.autonavi_speed_mode);
                this.w = (NightModeImageView) this.l.findViewById(com.amap.api.navi.R.id.navi_sdk_lbs_navi_route_tmc);
                this.x = (NightModeImageView) this.l.findViewById(com.amap.api.navi.R.id.navigation_preview);
                this.o = (LinearLayout) this.l.findViewById(com.amap.api.navi.R.id.navigation_zoom_layout);
                this.av = (ImageView) this.l.findViewById(com.amap.api.navi.R.id.navigation_zoom_out);
                this.aw = (ImageView) this.l.findViewById(com.amap.api.navi.R.id.navigation_zoom_in);
                this.N = (FrameLayout) this.l.findViewById(com.amap.api.navi.R.id.lbs_navi_time_and_km);
                this.O = (FrameLayout) this.l.findViewById(com.amap.api.navi.R.id.lbs_navi_custom_bottom_view);
                this.p = (LinearLayout) this.l.findViewById(com.amap.api.navi.R.id.navigation_info_layout);
                this.q = (LinearLayout) this.l.findViewById(com.amap.api.navi.R.id.navigation_info_layout_sim);
                this.r = (LinearLayout) this.l.findViewById(com.amap.api.navi.R.id.navigation_footer_land_container);
                this.s = (LinearLayout) this.l.findViewById(com.amap.api.navi.R.id.bottom_layout);
                this.t = (FrameLayout) this.l.findViewById(com.amap.api.navi.R.id.navigation_road_switches_container);
                this.Y.getContinueButton().setBackgroundDrawable(mm.a().getDrawable(R.attr.ratingBarStyleSmall));
                this.W = (NavigationStatusBarView) this.l.findViewById(com.amap.api.navi.R.id.status_bar_container);
                this.W.onCreate();
                this.X = this.W.getGPSView();
            } catch (Throwable th) {
                mj.a(th);
                rx.c(th, "AMapNaviView", "findView()");
            }
            if (this.ar != null) {
                this.ar.setZoomInIntersectionView(this.k, true);
                this.ar.setTrafficProgressBar(this.i, true);
            }
            this.ar.addMapNaviViewListener(this);
            this.ar.setViewOptions(this.aM);
        } catch (Throwable th2) {
            mj.a(th2);
            rx.c(th2, "AMapNaviView", "init()");
        }
    }

    public final void a(AMapNaviRouteNotifyData aMapNaviRouteNotifyData) {
        if (this.ag == null) {
            this.ag = new ForbiddenPopTip(this.az);
            this.ag.setAnimationStyle(R.drawable.abc_btn_default_mtrl_shape);
        }
        this.ag.setHeight(mj.a(this.az, 60));
        this.ag.setWidth(this.P);
        this.ag.upNaviRouteNotifyData(aMapNaviRouteNotifyData);
        f fVar = this.ah;
        if (fVar != null) {
            fVar.dismiss();
        }
        if (this.R) {
            this.ag.setWidth(this.P - this.aD);
            this.ag.showAtLocation(this.l, 80, this.aD, -1);
            return;
        }
        this.ag.showAtLocation(this.l, 80, 0, 0);
    }

    public final void a(long j2, int i2) {
        StringBuffer pathDetail = this.ar.getPathDetail(j2, this.ar.naviInfoHashMap.get(Long.valueOf(j2)).getCurStep());
        if (pathDetail != null) {
            String str = "新路线大约节省" + mj.c(i2);
            if (this.ah == null) {
                this.ah = new f(this.az);
                this.ah.setAnimationStyle(R.drawable.abc_btn_default_mtrl_shape);
            }
            ForbiddenPopTip forbiddenPopTip = this.ag;
            if (forbiddenPopTip != null) {
                forbiddenPopTip.dismiss();
            }
            this.ah.setHeight(mj.a(this.az, f.a));
            this.ah.setWidth(this.P);
            this.ah.a(pathDetail.toString(), str, j2);
            if (this.R) {
                this.ah.setWidth(this.P - this.aD);
                this.ah.showAtLocation(this.l, 80, this.aD, -1);
                return;
            }
            this.ah.showAtLocation(this.l, 80, 0, 0);
        }
    }

    public final void a() {
        List<AMapNaviGuide> naviGuideList = this.as.getNaviGuideList();
        if (naviGuideList == null) {
            naviGuideList = null;
        } else if (naviGuideList.size() >= 2) {
            Collections.sort(naviGuideList, new Comparator<AMapNaviGuide>() {
                /* class com.amap.api.col.stln3.kg.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(AMapNaviGuide aMapNaviGuide, AMapNaviGuide aMapNaviGuide2) {
                    return aMapNaviGuide.getLength() - aMapNaviGuide2.getLength() < 0 ? 1 : -1;
                }
            });
            if (naviGuideList.size() >= 3) {
                naviGuideList = naviGuideList.subList(0, 3);
            }
            Collections.sort(naviGuideList, new Comparator<AMapNaviGuide>() {
                /* class com.amap.api.col.stln3.kg.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(AMapNaviGuide aMapNaviGuide, AMapNaviGuide aMapNaviGuide2) {
                    return aMapNaviGuide.getStartSegId() - aMapNaviGuide2.getStartSegId() < 0 ? -1 : 1;
                }
            });
        }
        if (naviGuideList != null && naviGuideList.size() != 0) {
            AMapNaviRouteNotifyData aMapNaviRouteNotifyData = new AMapNaviRouteNotifyData();
            aMapNaviRouteNotifyData.setNotifyType(ai);
            aMapNaviRouteNotifyData.setReason(this.aj);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("途经");
            Iterator<AMapNaviGuide> it = naviGuideList.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next().getName() + "-");
            }
            aMapNaviRouteNotifyData.setSubTitle(stringBuffer.substring(0, stringBuffer.length() - 1).toString());
            if (this.ag == null) {
                this.ag = new ForbiddenPopTip(this.az);
                this.ag.setAnimationStyle(R.drawable.abc_btn_default_mtrl_shape);
            }
            this.ag.setHeight(mj.a(this.az, 60));
            this.ag.setWidth(this.P);
            this.ag.upNaviRouteNotifyData(aMapNaviRouteNotifyData);
            f fVar = this.ah;
            if (fVar != null) {
                fVar.dismiss();
            }
            if (this.R) {
                this.ag.setWidth(this.P - this.aD);
                this.ag.showAtLocation(this.l, 80, this.aD, 0);
                return;
            }
            this.ag.showAtLocation(this.l, 80, 0, 0);
        }
    }

    @SuppressLint({"NewApi", "ResourceType"})
    private void v() {
        NavigationStatusBarView navigationStatusBarView = this.W;
        Context context = this.az;
        navigationStatusBarView.layoutView(context, mj.d(context));
        if (x()) {
            this.p.setVisibility(8);
            this.q.setVisibility(8);
            this.r.setVisibility(0);
            LinearLayout linearLayout = this.s;
            linearLayout.setPadding(linearLayout.getPaddingLeft(), this.s.getPaddingTop(), this.s.getPaddingRight(), (int) mm.a().getDimension(R.id.custom));
            FrameLayout frameLayout = this.t;
            frameLayout.setPadding(frameLayout.getPaddingLeft(), this.t.getPaddingTop(), this.t.getPaddingRight(), (int) mm.a().getDimension(R.id.custom));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.width = (this.P / 2) - mj.a(this.az, 10);
            layoutParams.height = (this.Q - this.aE) - mj.a(this.az, 20);
            layoutParams.topMargin = this.aE + mj.a(this.az, 10);
            this.k.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = mj.a(this.az, 126) + this.aD;
            layoutParams2.bottomMargin = mj.a(this.az, 2);
            layoutParams2.addRule(12);
            this.N.setLayoutParams(layoutParams2);
            if (this.aA || this.aQ != 0) {
                e(false);
            } else {
                e(true);
            }
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams3.bottomMargin = mj.a(this.az, 100);
            this.f.setLayoutParams(layoutParams3);
        } else {
            this.r.setVisibility(4);
            if (this.K.getVisibility() == 8) {
                if (this.as.getNaviType() == 2) {
                    this.q.setVisibility(0);
                } else {
                    this.p.setVisibility(0);
                }
            }
            LinearLayout linearLayout2 = this.s;
            linearLayout2.setPadding(linearLayout2.getPaddingLeft(), this.s.getPaddingTop(), this.s.getPaddingRight(), (int) mm.a().getDimension(R.id.dimensions));
            FrameLayout frameLayout2 = this.t;
            frameLayout2.setPadding(frameLayout2.getPaddingLeft(), this.t.getPaddingTop(), this.t.getPaddingRight(), (int) mm.a().getDimension(R.id.dimensions));
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams4.width = -1;
            layoutParams4.height = (an - this.aF) - mj.a(this.az, 10);
            layoutParams4.topMargin = this.aF + mj.a(this.az, 10);
            this.k.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.bottomMargin = mj.a(this.az, 64);
            layoutParams5.leftMargin = mj.a(this.az, 5);
            layoutParams5.addRule(12);
            layoutParams5.addRule(1, com.amap.api.navi.R.id.navigation_mode_switches_container);
            this.N.setLayoutParams(layoutParams5);
            if (this.aQ != 0) {
                e(false);
            } else {
                e(true);
            }
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams6.bottomMargin = mj.a(this.az, (int) PoiInputSearchWidget.DEF_ANIMATION_DURATION);
            this.f.setLayoutParams(layoutParams6);
        }
        e eVar = this.aN;
        if (eVar != null && eVar.isShowing()) {
            if (this.R) {
                this.aN.setHeight(this.Q - mj.a(this.az, 50));
                this.aN.update(0, 0, -1, this.Q - mj.a(this.az, 50));
            } else {
                this.aN.setHeight(this.Q - this.aa);
                this.aN.update(0, 0, -1, (this.Q - this.aa) - mj.a(this.az, 20));
            }
        }
        ForbiddenPopTip forbiddenPopTip = this.ag;
        if (forbiddenPopTip != null && forbiddenPopTip.isShowing()) {
            this.ag.dismiss();
        }
        f fVar = this.ah;
        if (fVar != null && fVar.isShowing()) {
            this.ah.dismiss();
        }
        d(this.aA);
        kf kfVar = this.at;
        if (!(kfVar == null || kfVar.b() == null)) {
            this.Y.updateNaviInfo(this.at.b());
            this.Z.updateNaviInfo(this.at.b());
        }
        if (this.U) {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.w.setVisibility(8);
            this.b.setText("0");
        }
    }

    private void w() {
        if (this.aA) {
            if (this.R) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aC.getLayoutParams();
                layoutParams.topMargin = mj.a(this.az, 20);
                layoutParams.leftMargin = ((this.P * 3) / 4) - ((this.aC.getDriveWayWidth() * this.aC.getDriveWaySize()) / 2);
                this.aC.setLayoutParams(layoutParams);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aC.getLayoutParams();
            layoutParams2.topMargin = an - this.aC.getHeight();
            layoutParams2.leftMargin = (this.P / 2) - ((this.aC.getDriveWayWidth() * this.aC.getDriveWaySize()) / 2);
            this.aC.setLayoutParams(layoutParams2);
            this.ap = 0.5d;
        } else if (this.R) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.aC.getLayoutParams();
            layoutParams3.topMargin = mj.a(this.az, 20);
            int i2 = this.aD;
            layoutParams3.leftMargin = (i2 + ((this.P - i2) / 2)) - ((this.aC.getDriveWayWidth() * this.aC.getDriveWaySize()) / 2);
            this.aC.setLayoutParams(layoutParams3);
        } else {
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.aC.getLayoutParams();
            layoutParams4.topMargin = this.aa + mj.a(this.az, 30);
            layoutParams4.leftMargin = (this.P / 2) - ((this.aC.getDriveWayWidth() * this.aC.getDriveWaySize()) / 2);
            this.aC.setLayoutParams(layoutParams4);
        }
    }

    public final void a(AMapLaneInfo aMapLaneInfo) {
        this.aC.loadDriveWayBitmap(aMapLaneInfo);
        w();
        this.aC.setVisibility(0);
    }

    public final void b() {
        this.aC.setVisibility(8);
    }

    private boolean x() {
        AmapRouteActivity amapRouteActivity = this.aH;
        if (amapRouteActivity == null) {
            return false;
        }
        if (amapRouteActivity.getRequestedOrientation() == 0 || this.aH.getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    private void y() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.az.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.P = displayMetrics.widthPixels;
        this.Q = displayMetrics.heightPixels;
        an = (this.Q / 10) * 4;
    }

    public final void c() {
        Rect rect;
        Rect rect2;
        Rect rect3;
        try {
            y();
            this.R = x();
            v();
            if (this.R) {
                rect3 = new Rect(this.Y.getWidth() + mj.a(this.az, 50), mj.a(this.az, 40), mj.a(this.az, 20), mj.a(this.az, 30));
                rect = new Rect(mj.a(this.az, 10), this.aE + mj.a(this.az, 10), (int) (((double) this.P) * 0.5d), this.Q - mj.a(this.az, 10));
                rect2 = new Rect(mj.a(this.az, 10), this.aF + mj.a(this.az, 10), this.Q - mj.a(this.az, 10), an);
            } else {
                rect3 = new Rect(mj.a(this.az, 65), this.Z.getHeight() + mj.a(this.az, 50), mj.a(this.az, 65), mj.a(this.az, 120));
                rect = new Rect(mj.a(this.az, 10), this.aE + mj.a(this.az, 10), (int) (((double) this.Q) * 0.5d), this.P - mj.a(this.az, 10));
                rect2 = new Rect(mj.a(this.az, 10), this.aF + mj.a(this.az, 10), this.P - mj.a(this.az, 10), an);
            }
            if (this.aM != null) {
                this.aM.getRouteOverlayOptions().setRect(rect3);
                this.aM.setCrossLocation(rect, rect2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapNaviView", "onConfigurationChanged(Configuration newConfig)");
        }
    }

    public final void a(Bundle bundle) {
        Rect rect;
        Rect rect2;
        try {
            this.as.addAMapNaviListener(this.at);
            this.m.setOnClickListener(this);
            this.z.setOnClickListener(this);
            this.E.setOnClickListener(this);
            this.y.setOnClickListener(this);
            this.D.setOnClickListener(this);
            this.G.setOnClickListener(this);
            this.F.setOnClickListener(this);
            this.M.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.v.setOnClickListener(this);
            this.H.setOnClickListener(this);
            this.I.setOnClickListener(this);
            this.u.setOnClickListener(this);
            this.w.setOnClickListener(this);
            this.x.setOnClickListener(this);
            this.av.setOnClickListener(this);
            this.aw.setOnClickListener(this);
            this.Y.getContinueButton().setOnClickListener(this);
            this.Y.getSimSpeedButton().setOnClickListener(this);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "onCreate(Bundle bundle)");
            return;
        }
        this.aM.setCarBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.dropDownListViewStyle));
        this.ar.onCreate(bundle);
        this.ab = this.ar.getMap();
        MyTrafficStyle myTrafficStyle = new MyTrafficStyle();
        myTrafficStyle.setRatio(0.7f);
        myTrafficStyle.setSmoothColor(Color.parseColor("#CC80CD65"));
        myTrafficStyle.setCongestedColor(Color.parseColor("#F2CB7257"));
        myTrafficStyle.setSlowColor(Color.parseColor("#F2D5C247"));
        myTrafficStyle.setSeriousCongestedColor(Color.parseColor("#CCA52A2A"));
        this.ab.setMyTrafficStyle(myTrafficStyle);
        this.ab.getUiSettings().setZoomControlsEnabled(false);
        this.ab.getUiSettings().setGestureScaleByMapCenter(true);
        this.ab.getUiSettings().setScaleControlsEnabled(false);
        if (!AmapNaviPage.getInstance().isTrafficEnable()) {
            this.ab.setTrafficEnabled(false);
        } else {
            this.ab.setTrafficEnabled(true);
        }
        y();
        v();
        RouteOverlayOptions routeOverlayOptions = new RouteOverlayOptions();
        routeOverlayOptions.setSmoothTraffic(BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture_green.png").getBitmap());
        routeOverlayOptions.setUnknownTraffic(BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture.png").getBitmap());
        routeOverlayOptions.setSlowTraffic(BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture_slow.png").getBitmap());
        routeOverlayOptions.setJamTraffic(BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture_bad.png").getBitmap());
        routeOverlayOptions.setVeryJamTraffic(BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture_grayred.png").getBitmap());
        routeOverlayOptions.setPassRoute(BitmapDescriptorFactory.fromAsset("amap_navi_lbs_pass_custtexture.png").getBitmap());
        this.aM.setRouteOverlayOptions(routeOverlayOptions);
        this.aM.setEndPointBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.collapseIcon));
        this.aM.setWayPointBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.alertDialogStyle));
        this.aM.setCarBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.dropDownListViewStyle));
        this.aM.setAutoChangeZoom(true);
        this.aM.setAutoLockCar(true);
        this.aM.setLeaderLineEnabled(SupportMenu.CATEGORY_MASK);
        this.aM.setAutoNaviViewNightMode(true);
        this.aM.setAfterRouteAutoGray(true);
        if (x()) {
            rect = new Rect(mj.a(this.az, 10), this.aE + mj.a(this.az, 10), (int) (((double) this.P) * 0.5d), this.Q - mj.a(this.az, 10));
            rect2 = new Rect(mj.a(this.az, 10), this.aF + mj.a(this.az, 10), this.Q - mj.a(this.az, 10), an);
        } else {
            rect = new Rect(mj.a(this.az, 10), this.aE + mj.a(this.az, 10), (int) (((double) this.Q) * 0.5d), this.P - mj.a(this.az, 10));
            rect2 = new Rect(mj.a(this.az, 10), this.aF + mj.a(this.az, 10), this.P - mj.a(this.az, 10), an);
        }
        this.aM.setCrossLocation(rect, rect2);
        this.ar.setArrowOnRoute(false);
        this.ar.setStartPointBitmap(null);
    }

    public final void d() {
        try {
            this.ar.onResume();
            y();
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapNaviView", "onResume()");
        }
    }

    public final void e() {
        try {
            this.ar.onPause();
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapNaviView", "onPause()");
        }
    }

    public final void f() {
        try {
            this.i = null;
            if (this.k != null) {
                this.k.recycleResource();
            }
            if (this.Y != null) {
                this.Y.recycle();
                this.Y = null;
            }
            if (this.Z != null) {
                this.Z.recycle();
                this.Z = null;
            }
            if (this.ax) {
                this.N.removeAllViews();
            }
            if (this.ag != null) {
                this.ag.destroy();
                this.ag.dismiss();
            }
            if (this.ah != null) {
                f fVar = this.ah;
                f.a();
                this.ah.dismiss();
            }
            if (this.at != null) {
                this.at.a();
            }
            if (this.W != null) {
                this.W.onDestroy();
            }
            this.as.removeAMapNaviListener(this.at);
            this.ar.onDestroy();
            mm.c();
            if (this.k != null) {
                this.k.setVisibility(8);
                this.k.recycleResource();
            }
            if (this.aN != null) {
                this.aN.e();
                this.aN = null;
            }
            if (this.V != null) {
                this.V.removeAllViews();
            }
            if (this.aS != null) {
                for (AMapNaviMarkerOptions aMapNaviMarkerOptions : this.aS.keySet()) {
                    c(aMapNaviMarkerOptions);
                }
                this.aS.clear();
            }
            this.az = null;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "onDestroy()");
        }
    }

    public final void b(Bundle bundle) {
        try {
            this.ar.onSaveInstanceState(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapNaviView", "onSaveInstanceState(android.os.Bundle paramBundle)");
        }
    }

    public final void g() {
        this.ar.displayOverview();
    }

    /* access modifiers changed from: package-private */
    public final void h() {
        d(true);
        this.V.requestLayout();
        this.aB = true;
    }

    /* access modifiers changed from: package-private */
    public final void i() {
        this.V.requestLayout();
        d(false);
        if (x() && this.ay) {
            e(true);
        }
        this.aB = false;
    }

    /* access modifiers changed from: package-private */
    public final void a(AMapModelCross aMapModelCross) {
        if (this.ar.showModeCross(aMapModelCross)) {
            this.aB = true;
            d(true);
        }
    }

    /* access modifiers changed from: package-private */
    public final void j() {
        this.aB = false;
        d(false);
        if (x() && this.ay) {
            e(true);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z2) {
        this.ar.setCarLock(z2);
    }

    public final void onClick(View view) {
        TextView textView;
        String str;
        try {
            int id = view.getId();
            if (2147479686 != id) {
                if (2147479565 != id) {
                    if (2147479714 != id) {
                        if (!(2147479569 == id || 2147479677 == id)) {
                            if (2147479574 != id) {
                                if (!(2147479556 == id || 2147479676 == id)) {
                                    if (2147479571 != id) {
                                        if (2147479681 != id) {
                                            if (2147479573 != id) {
                                                if (2147479713 != id) {
                                                    if (2147479820 == id) {
                                                        z();
                                                        return;
                                                    } else if (2147479822 == id) {
                                                        C();
                                                        return;
                                                    } else if (2147479691 == id) {
                                                        if (this.au == 2) {
                                                            a(1);
                                                            this.v.setSelected(true);
                                                            this.v.setActivated(false);
                                                            return;
                                                        } else if (this.au == 1) {
                                                            a(2);
                                                            this.v.setSelected(false);
                                                            this.v.setActivated(false);
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    } else if (2147479683 == id) {
                                                        this.ab.animateCamera(CameraUpdateFactory.zoomOut());
                                                        return;
                                                    } else if (2147479682 == id) {
                                                        this.ab.animateCamera(CameraUpdateFactory.zoomIn());
                                                        return;
                                                    } else if (2147479684 == id) {
                                                        try {
                                                            if (this.U) {
                                                                ma.a(this.az, "导航已结束");
                                                                return;
                                                            } else if (this.ao) {
                                                                a(true);
                                                                return;
                                                            } else {
                                                                this.ao = true;
                                                                this.ar.displayOverview();
                                                                a(false);
                                                                return;
                                                            }
                                                        } catch (Throwable th) {
                                                            th.printStackTrace();
                                                            return;
                                                        }
                                                    } else if (2147479672 != id) {
                                                        return;
                                                    } else {
                                                        if (this.ab.isTrafficEnabled()) {
                                                            this.ab.setTrafficEnabled(false);
                                                            this.w.setSelected(false);
                                                            return;
                                                        }
                                                        this.ab.setTrafficEnabled(true);
                                                        this.w.setSelected(true);
                                                        return;
                                                    }
                                                }
                                            }
                                            switch (this.aL) {
                                                case 1:
                                                    this.as.setEmulatorNaviSpeed(80);
                                                    this.aL = 2;
                                                    textView = this.u;
                                                    str = "中速";
                                                    break;
                                                case 2:
                                                    this.as.setEmulatorNaviSpeed(120);
                                                    this.aL = 3;
                                                    textView = this.u;
                                                    str = "高速";
                                                    break;
                                                case 3:
                                                    this.as.setEmulatorNaviSpeed(40);
                                                    this.aL = 1;
                                                    textView = this.u;
                                                    str = "低速";
                                                    break;
                                                default:
                                                    this.Y.updateEmulatorInfo(this.aL);
                                                    return;
                                            }
                                            textView.setText(str);
                                            this.Y.updateEmulatorInfo(this.aL);
                                            return;
                                        } else if (System.currentTimeMillis() - this.aJ > ((long) this.al)) {
                                            c(this.aI);
                                            this.aJ = System.currentTimeMillis();
                                            return;
                                        } else {
                                            ma.a(this.aH, "暂无新路线");
                                            return;
                                        }
                                    }
                                }
                                if (this.as.getNaviType() == 2 || !this.aH.isShowExitNaviDialog()) {
                                    z();
                                    return;
                                } else if (this.K.getVisibility() == 0) {
                                    C();
                                    return;
                                } else {
                                    this.p.setVisibility(8);
                                    this.p.setAnimation(this.ad);
                                    this.p.startAnimation(this.ad);
                                    this.K.setVisibility(0);
                                    this.K.setAnimation(this.ac);
                                    this.K.startAnimation(this.ac);
                                    this.aP.sendEmptyMessageDelayed(3, 10000);
                                    return;
                                }
                            }
                        }
                        if (this.as.getNaviType() == 2) {
                            if (this.aK) {
                                this.E.setText("开始");
                                this.F.setText("开始");
                                this.as.pauseNavi();
                                this.aK = false;
                                return;
                            }
                            this.F.setText("暂停");
                            this.E.setText("暂停");
                            this.as.resumeNavi();
                            this.aK = true;
                            return;
                        } else if (this.U) {
                            ma.a(this.az, "导航已结束");
                            return;
                        } else {
                            try {
                                if (this.aN == null) {
                                    this.aN = new e(this.az);
                                    this.aN.a(true);
                                }
                                if (this.R) {
                                    this.aN.setHeight(this.Q - mj.a(this.az, 50));
                                } else if (this.Z != null) {
                                    int height = (this.Q - this.Z.getHeight()) - mj.a(this.az, 20);
                                    if (!AmapNaviPage.getInstance().isShowRouteStrategyPreferenceView()) {
                                        height = this.Q / 3;
                                    }
                                    this.aN.setHeight(height);
                                }
                                this.aN.d();
                                this.aN.showAtLocation(this.V, 81, 0, 0);
                                final WindowManager.LayoutParams attributes = this.aH.getWindow().getAttributes();
                                attributes.alpha = 0.7f;
                                this.aH.getWindow().setAttributes(attributes);
                                this.aN.setOnDismissListener(new PopupWindow.OnDismissListener() {
                                    /* class com.amap.api.col.stln3.kg.AnonymousClass4 */

                                    public final void onDismiss() {
                                        try {
                                            kg.this.aP.obtainMessage(2).sendToTarget();
                                            attributes.alpha = 1.0f;
                                            kg.this.aH.getWindow().setAttributes(attributes);
                                            int a2 = mo.a(kg.this.aH);
                                            INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
                                            if (callback != null) {
                                                if (a2 != kg.this.aI) {
                                                    callback.onStrategyChanged(a2);
                                                }
                                            }
                                            kg.a(kg.this, a2);
                                        } catch (Throwable th) {
                                            th.printStackTrace();
                                        }
                                    }
                                });
                                this.aO = true;
                                this.aP.obtainMessage(1).sendToTarget();
                                return;
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                                return;
                            }
                        }
                    }
                }
                a(true);
            } else if (mj.b(this.az)) {
                LocManager.switchParallelRoad(0);
            } else {
                ma.a(this.az, "无网络");
            }
        } catch (Throwable th3) {
            mj.a(th3);
            rx.c(th3, "AMapNaviView", "onClick(View v)");
        }
    }

    private void z() {
        this.aP.removeMessages(3);
        INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
        if (callback != null) {
            callback.onExitPage(1);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("from", 2);
        bundle.putInt("routeid", this.ak);
        md.a(this.az).a();
        this.aH.closeScr(bundle);
    }

    private void c(int i2) {
        try {
            c(true);
            if (!this.as.getIsUseInnerVoice()) {
                INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
                if (callback != null && !mj.a) {
                    callback.onGetNavigationText("路线重新规划");
                }
            } else if (!mj.a) {
                md.a(this.az).onGetNavigationText("路线重新规划");
            }
            this.as.reCalculateRoute(i2);
            this.aJ = System.currentTimeMillis();
            this.aI = i2;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean k() {
        return this.ab.isTrafficEnabled();
    }

    public final void b(boolean z2) {
        this.ab.setTrafficEnabled(z2);
    }

    public final void l() {
        this.U = true;
        this.j.setVisibility(8);
        this.m.setVisibility(8);
        this.w.setVisibility(8);
        this.b.setText("0");
        this.b.setVisibility(8);
        s();
    }

    public final boolean m() {
        return this.R;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001a A[Catch:{ Throwable -> 0x0020 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n() {
        /*
            r3 = this;
            int r0 = r3.S     // Catch:{ Throwable -> 0x0020 }
            com.amap.api.navi.core.view.BaseNaviView r1 = r3.ar     // Catch:{ Throwable -> 0x0020 }
            int r1 = r1.getHeight()     // Catch:{ Throwable -> 0x0020 }
            if (r0 != r1) goto L_0x0017
            int r0 = r3.T     // Catch:{ Throwable -> 0x0020 }
            com.amap.api.navi.core.view.BaseNaviView r1 = r3.ar     // Catch:{ Throwable -> 0x0020 }
            int r1 = r1.getWidth()     // Catch:{ Throwable -> 0x0020 }
            if (r0 == r1) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r0 = 0
            goto L_0x0018
        L_0x0017:
            r0 = 1
        L_0x0018:
            if (r0 == 0) goto L_0x001e
            r3.A()     // Catch:{ Throwable -> 0x0020 }
            goto L_0x001f
        L_0x001e:
        L_0x001f:
            return
        L_0x0020:
            r0 = move-exception
            r0.printStackTrace()
            java.lang.String r1 = "AMapNaviView"
            java.lang.String r2 = "onLayout(boolean changed, int left, int top, int right,\n                            int bottom)"
            com.amap.api.col.stln3.rx.c(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.kg.n():void");
    }

    private void A() {
        try {
            this.S = this.ar.getHeight();
            this.T = this.ar.getWidth();
            this.ar.getViewOptions().setPointToCenter(this.ap, this.aq);
            this.ar.setCustomizedLockCenter();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean o() {
        return this.ao;
    }

    public final void p() {
        NightModeTextView nightModeTextView = this.y;
        if (nightModeTextView != null) {
            nightModeTextView.performClick();
        }
        NightModeTextView nightModeTextView2 = this.D;
        if (nightModeTextView2 != null) {
            nightModeTextView2.performLongClick();
        }
        NightModeTextView nightModeTextView3 = this.G;
        if (nightModeTextView3 != null) {
            nightModeTextView3.performLongClick();
        }
    }

    public final void b(int i2) {
        try {
            String str = "parallelRoadType=" + i2;
            this.aQ = i2;
            if (this.aQ == 0) {
                this.M.setVisibility(8);
                e(true);
                return;
            }
            if (this.as.getNaviType() != 2) {
                this.M.setVisibility(0);
                e(false);
            }
            if (this.aQ == 1) {
                if (this.am) {
                    this.M.setImageDrawable(mm.a().getDrawable(com.amap.api.navi.R.drawable.navi_icon_road_switch_main_night));
                } else {
                    this.M.setImageDrawable(mm.a().getDrawable(com.amap.api.navi.R.drawable.navi_icon_road_switch_main_day));
                }
            }
            if (this.aQ == 2) {
                if (this.am) {
                    this.M.setImageDrawable(mm.a().getDrawable(com.amap.api.navi.R.drawable.navi_icon_road_switch_sub_night));
                } else {
                    this.M.setImageDrawable(mm.a().getDrawable(com.amap.api.navi.R.drawable.navi_icon_road_switch_sub_day));
                }
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.M.getLayoutParams();
            if (this.aG) {
                layoutParams.addRule(12);
            } else if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(12);
            }
            this.M.setLayoutParams(layoutParams);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void q() {
        this.ar.setCarLock(true);
    }

    /* access modifiers changed from: package-private */
    public final void r() {
        this.z.setVisibility(0);
        this.m.setVisibility(8);
        this.n.setVisibility(0);
        this.v.setVisibility(4);
        this.b.setText("0");
        if (this.as.getNaviType() == 2) {
            this.as.setEmulatorNaviSpeed(80);
            this.b.setVisibility(8);
            s();
            this.n.setVisibility(8);
            this.u.setVisibility(0);
            this.m.setVisibility(0);
            this.m.setText("中速");
            this.n.setVisibility(8);
            this.j.setVisibility(8);
            this.p.setVisibility(8);
            if (!x()) {
                this.q.setVisibility(0);
            }
            this.E.setText("暂停");
            this.Y.showContinueButton(false);
            this.Y.updateEmulatorInfo(this.aL);
            this.p.setVisibility(8);
            this.X.setmNavigationBool(false);
            return;
        }
        this.q.setVisibility(8);
        this.X.setmNavigationBool(true);
        this.Y.showContinueButton(true ^ this.ay);
    }

    private void d(boolean z2) {
        if (!this.ay) {
            z2 = false;
        }
        String str = "threadName=" + Thread.currentThread().getName() + ",checkCrossView=" + z2;
        this.Y.expandNaviInfo(!z2);
        this.Z.expandNaviInfo(!z2);
        if (z2) {
            this.aA = true;
            this.i.setVisibility(8);
            if (this.R) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Y.getLayoutParams();
                layoutParams.width = this.P / 2;
                layoutParams.height = this.aE;
                this.Y.setVisibility(0);
                this.Y.setLayoutParams(layoutParams);
                this.Z.setVisibility(8);
                this.ap = 0.75d;
                A();
                e(false);
                this.x.setVisibility(4);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.Z.getLayoutParams();
                layoutParams2.height = this.aF;
                this.Z.setVisibility(0);
                this.Z.setLayoutParams(layoutParams2);
                this.Y.setVisibility(8);
                this.ap = 0.5d;
                A();
                if (this.ay) {
                    this.x.setVisibility(0);
                }
            }
        } else {
            this.aA = false;
            if (this.aG) {
                this.i.setVisibility(0);
            }
            if (this.ay) {
                this.x.setVisibility(0);
            }
            if (this.R) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.Y.getLayoutParams();
                layoutParams3.height = -1;
                layoutParams3.width = this.aD;
                this.Y.setLayoutParams(layoutParams3);
                this.Y.setVisibility(0);
                this.Z.setVisibility(8);
                this.ap = 0.65d;
                A();
                if (this.aQ == 0) {
                    e(true);
                }
            } else {
                this.ap = 0.5d;
                A();
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.Z.getLayoutParams();
                layoutParams4.height = this.aa;
                this.Z.setVisibility(0);
                this.Z.setLayoutParams(layoutParams4);
                this.Y.setVisibility(8);
            }
        }
        B();
        w();
        this.V.invalidate();
    }

    private void B() {
        if (this.ay) {
            this.ab.getUiSettings().setScaleControlsEnabled(false);
        } else {
            this.ab.getUiSettings().setScaleControlsEnabled(true);
        }
        if (this.aA) {
            if (this.R) {
                AMap aMap = this.ab;
                if (aMap != null) {
                    aMap.getUiSettings().setLogoBottomMargin(mj.a(this.az, 12));
                    this.ab.getUiSettings().setLogoLeftMargin((this.P / 2) + this.r.getWidth());
                }
            } else if (this.ay) {
                AMap aMap2 = this.ab;
                if (aMap2 != null) {
                    aMap2.getUiSettings().setLogoBottomMargin(this.p.getHeight());
                    this.ab.getUiSettings().setLogoLeftMargin(mj.a(this.az, 5));
                }
            } else {
                AMap aMap3 = this.ab;
                if (aMap3 != null) {
                    aMap3.getUiSettings().setLogoBottomMargin(this.p.getHeight() + mj.a(this.az, 10));
                    this.ab.getUiSettings().setLogoLeftMargin(mj.a(this.az, 5) + this.v.getWidth());
                }
            }
        } else if (this.R) {
            AMap aMap4 = this.ab;
            if (aMap4 != null) {
                aMap4.getUiSettings().setLogoBottomMargin(mj.a(this.az, 12));
                this.ab.getUiSettings().setLogoLeftMargin(this.aD + this.r.getWidth());
            }
        } else if (this.ay) {
            AMap aMap5 = this.ab;
            if (aMap5 != null) {
                aMap5.getUiSettings().setLogoBottomMargin(this.p.getHeight());
                this.ab.getUiSettings().setLogoLeftMargin(mj.a(this.az, 5));
            }
        } else {
            AMap aMap6 = this.ab;
            if (aMap6 != null) {
                aMap6.getUiSettings().setLogoBottomMargin(this.p.getHeight() + mj.a(this.az, 10));
                this.ab.getUiSettings().setLogoLeftMargin(mj.a(this.az, 5) + this.v.getWidth());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void c(boolean z2) {
        AmapRouteActivity amapRouteActivity = this.aH;
        if (amapRouteActivity != null) {
            if (z2) {
                amapRouteActivity.showLoadingDialog();
            } else {
                amapRouteActivity.removeLoadingDialog();
            }
        }
    }

    public final void a(AMapNotAvoidInfo aMapNotAvoidInfo) {
        if (this.aR) {
            this.aR = false;
            u();
        }
        if (aMapNotAvoidInfo != null) {
            String limitText = AMapNotAvoidInfo.getLimitText(aMapNotAvoidInfo.type);
            if (!TextUtils.isEmpty(limitText)) {
                this.g.setText(limitText);
            }
            if (aMapNotAvoidInfo.distToCar > 0) {
                this.h.setVisibility(0);
                this.h.setText(mj.a(aMapNotAvoidInfo.distToCar));
                return;
            }
            this.h.setVisibility(8);
            s();
            return;
        }
        s();
    }

    public final void s() {
        LinearLayout linearLayout = this.c;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public final void t() {
        LinearLayout linearLayout = this.c;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
            this.aR = true;
        }
    }

    public final void u() {
        LinearLayout linearLayout = this.c;
        if (linearLayout != null && !this.aR) {
            linearLayout.setVisibility(0);
        }
    }

    public final void a(View view) {
        if (view != null) {
            try {
                if (this.N != null) {
                    this.ax = true;
                    this.N.addView(view, new FrameLayout.LayoutParams(-1, -1));
                    e(true);
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.ax = false;
    }

    public final void b(View view) {
        if (view != null) {
            try {
                if (this.O != null && view.getLayoutParams() != null) {
                    this.O.setLayoutParams(new LinearLayout.LayoutParams(-1, view.getLayoutParams().height));
                    this.O.addView(view, new FrameLayout.LayoutParams(-1, view.getLayoutParams().height));
                    this.O.setVisibility(0);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void e(boolean z2) {
        if (this.ax) {
            this.N.setAlpha(1.0f);
            this.N.setVisibility(z2 ? 0 : 8);
        }
    }

    public final void a(AMapNaviMarkerOptions aMapNaviMarkerOptions) {
        if (aMapNaviMarkerOptions != null) {
            try {
                this.aS.put(aMapNaviMarkerOptions, this.ab.addMarker(new MarkerOptions().position(new LatLng(aMapNaviMarkerOptions.getPosition().getLatitude(), aMapNaviMarkerOptions.getPosition().getLongitude())).icon(aMapNaviMarkerOptions.getBitmapDescriptor()).zIndex(aMapNaviMarkerOptions.getzIndex()).title(aMapNaviMarkerOptions.getTitle())));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void b(AMapNaviMarkerOptions aMapNaviMarkerOptions) {
        Marker marker;
        if (aMapNaviMarkerOptions != null && (marker = this.aS.get(aMapNaviMarkerOptions)) != null) {
            if (aMapNaviMarkerOptions.getPosition() != null) {
                marker.setPosition(new LatLng(aMapNaviMarkerOptions.getPosition().getLatitude(), aMapNaviMarkerOptions.getPosition().getLongitude()));
            }
            if (aMapNaviMarkerOptions.getzIndex() != 0.0f) {
                marker.setZIndex(aMapNaviMarkerOptions.getzIndex());
            }
            if (aMapNaviMarkerOptions.getBitmapDescriptor() != null) {
                marker.setIcon(aMapNaviMarkerOptions.getBitmapDescriptor());
            }
        }
    }

    public final void c(AMapNaviMarkerOptions aMapNaviMarkerOptions) {
        Marker marker;
        if (aMapNaviMarkerOptions != null && (marker = this.aS.get(aMapNaviMarkerOptions)) != null) {
            marker.remove();
            marker.destroy();
        }
    }

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
    public final void onNaviMapMode(int i2) {
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
    public final void onLockMap(boolean z2) {
    }

    @Override // com.amap.api.navi.AMapNaviViewListener
    public final void onNaviViewLoaded() {
        this.aH.removeLoadingDialog("initDialog");
        this.S = this.ar.getHeight();
        this.T = this.ar.getWidth();
        y();
        if (AMapNavi.getInstance(this.aH).getNaviType() == 2) {
            this.ar.setLockTilt(0);
        } else {
            this.ar.setLockTilt(this.a);
        }
        v();
        this.R = x();
        if (this.R) {
            if (this.aM != null) {
                this.aM.getRouteOverlayOptions().setRect(new Rect(this.Y.getWidth() + mj.a(this.az, 50), mj.a(this.az, 40), mj.a(this.az, 20), mj.a(this.az, 30)));
            }
        } else if (this.aM != null) {
            this.aM.getRouteOverlayOptions().setRect(new Rect(mj.a(this.az, 65), this.Z.getHeight() + mj.a(this.az, 50), mj.a(this.az, 65), mj.a(this.az, 120)));
        }
    }

    @Override // com.amap.api.navi.AMapNaviViewListener
    public final void onMapTypeChanged(int i2) {
        boolean z2 = i2 == 3;
        this.am = z2;
        NavigationStatusBarView navigationStatusBarView = this.W;
        if (navigationStatusBarView != null) {
            navigationStatusBarView.processNightMode(z2);
        }
        NightModeImageView nightModeImageView = this.w;
        if (nightModeImageView != null) {
            nightModeImageView.processNightMode(z2);
        }
        NightModeTextView nightModeTextView = this.z;
        if (nightModeTextView != null) {
            nightModeTextView.processNightMode(z2);
        }
        NightModeTextView nightModeTextView2 = this.y;
        if (nightModeTextView2 != null) {
            nightModeTextView2.processNightMode(z2);
        }
        NightModeTextView nightModeTextView3 = this.B;
        if (nightModeTextView3 != null) {
            nightModeTextView3.processNightMode(z2);
        }
        NightModeTextView nightModeTextView4 = this.A;
        if (nightModeTextView4 != null) {
            nightModeTextView4.processNightMode(z2);
        }
        NightModeTextView nightModeTextView5 = this.C;
        if (nightModeTextView5 != null) {
            nightModeTextView5.processNightMode(z2);
        }
        NightModeImageView nightModeImageView2 = this.x;
        if (nightModeImageView2 != null) {
            nightModeImageView2.processNightMode(z2);
        }
        NightModeTextView nightModeTextView6 = this.D;
        if (nightModeTextView6 != null) {
            nightModeTextView6.processNightMode(z2);
        }
        NightModeTextView nightModeTextView7 = this.E;
        if (nightModeTextView7 != null) {
            nightModeTextView7.processNightMode(z2);
        }
        NightModeTextView nightModeTextView8 = this.F;
        if (nightModeTextView8 != null) {
            nightModeTextView8.processNightMode(z2);
        }
        NightModeTextView nightModeTextView9 = this.G;
        if (nightModeTextView9 != null) {
            nightModeTextView9.processNightMode(z2);
        }
        NightModeTextView nightModeTextView10 = this.H;
        if (nightModeTextView10 != null) {
            nightModeTextView10.processNightMode(z2);
        }
        NightModeTextView nightModeTextView11 = this.I;
        if (nightModeTextView11 != null) {
            nightModeTextView11.processNightMode(z2);
        }
        if (z2) {
            this.d.setBackground(mm.a().getDrawable(com.amap.api.navi.R.drawable.navigation_footer_night_bg));
            this.e.setBackground(mm.a().getDrawable(com.amap.api.navi.R.drawable.navigation_footer_night_bg));
            this.M.setBackground(mm.a().getDrawable(com.amap.api.navi.R.drawable.navi_icon_common_bg_night_selector));
            this.v.setBackground(mm.a().getDrawable(com.amap.api.navi.R.drawable.navi_icon_common_bg_night_selector));
            this.v.setImageDrawable(mm.a().getDrawable(com.amap.api.navi.R.drawable.navi_icon_navimode_night_selector));
            this.j.setBackground(mm.a().getDrawable(com.amap.api.navi.R.drawable.navi_icon_common_bg_night_selector));
            this.j.setImageDrawable(mm.a().getDrawable(com.amap.api.navi.R.drawable.navi_icon_refresh_night));
            this.aw.setImageDrawable(mm.a().getDrawable(com.amap.api.navi.R.drawable.navi_icon_zoomin_night_selector));
            this.av.setImageDrawable(mm.a().getDrawable(com.amap.api.navi.R.drawable.navi_icon_zoomout_night_selector));
            this.L.setBackground(mm.a().getDrawable(com.amap.api.navi.R.drawable.navigation_footer_night_bg));
            this.N.setBackground(mm.a().getDrawable(com.amap.api.navi.R.drawable.navigation_footer_night_bg));
        } else {
            this.d.setBackground(mm.a().getDrawable(com.amap.api.navi.R.drawable.navigation_footer_bg));
            this.e.setBackground(mm.a().getDrawable(com.amap.api.navi.R.drawable.navigation_footer_bg));
            this.M.setBackground(mm.a().getDrawable(com.amap.api.navi.R.drawable.navi_icon_common_bg_day_selector));
            this.v.setBackground(mm.a().getDrawable(com.amap.api.navi.R.drawable.navi_icon_common_bg_day_selector));
            this.v.setImageDrawable(mm.a().getDrawable(com.amap.api.navi.R.drawable.navi_icon_navimode_day_selector));
            this.j.setBackground(mm.a().getDrawable(com.amap.api.navi.R.drawable.navi_icon_common_bg_day_selector));
            this.j.setImageDrawable(mm.a().getDrawable(com.amap.api.navi.R.drawable.navi_icon_refresh_day));
            this.aw.setImageDrawable(mm.a().getDrawable(com.amap.api.navi.R.drawable.navi_icon_zoomin_day_selector));
            this.av.setImageDrawable(mm.a().getDrawable(com.amap.api.navi.R.drawable.navi_icon_zoomout_day_selector));
            this.L.setBackground(mm.a().getDrawable(com.amap.api.navi.R.drawable.navigation_footer_bg));
            this.N.setBackground(mm.a().getDrawable(com.amap.api.navi.R.drawable.navigation_footer_bg));
        }
        if (this.aQ == 1) {
            if (this.am) {
                this.M.setImageDrawable(mm.a().getDrawable(com.amap.api.navi.R.drawable.navi_icon_road_switch_main_night));
            } else {
                this.M.setImageDrawable(mm.a().getDrawable(com.amap.api.navi.R.drawable.navi_icon_road_switch_main_day));
            }
        }
        if (this.aQ != 2) {
            return;
        }
        if (this.am) {
            this.M.setImageDrawable(mm.a().getDrawable(com.amap.api.navi.R.drawable.navi_icon_road_switch_sub_night));
        } else {
            this.M.setImageDrawable(mm.a().getDrawable(com.amap.api.navi.R.drawable.navi_icon_road_switch_sub_day));
        }
    }

    @Override // com.amap.api.navi.AMapNaviViewListener
    public final void onNaviViewShowMode(int i2) {
        switch (i2) {
            case 1:
                this.ay = true;
                break;
            case 2:
            case 3:
                try {
                    this.ay = false;
                    break;
                } catch (Throwable th) {
                    mj.a(th);
                    rx.c(th, "AMapNaviView", "setCarLock(boolean isLock, boolean autoRestore)");
                    return;
                }
        }
        this.aG = this.ay;
        boolean z2 = this.ay;
        this.ay = z2;
        if (z2) {
            this.Z.showContinueButton(false);
            this.Y.showContinueButton(false);
            this.v.setVisibility(4);
            this.j.setVisibility(8);
            this.o.setVisibility(8);
            this.x.setVisibility(0);
            this.i.setVisibility(0);
            this.w.setVisibility(8);
            if (this.as.getNaviType() == 1) {
                this.b.setVisibility(0);
                u();
            }
            d(this.aB);
        } else {
            this.Z.showContinueButton(true);
            this.Y.showContinueButton(true);
            this.v.setVisibility(0);
            this.b.setVisibility(8);
            s();
            this.o.setVisibility(0);
            this.x.setVisibility(8);
            this.i.setVisibility(8);
            this.w.setVisibility(0);
            if (this.as.getNaviType() == 1) {
                this.j.setVisibility(0);
            }
            d(false);
        }
        this.m.setVisibility(z2 ? 8 : 0);
        this.n.setVisibility(z2 ? 0 : 8);
        if (this.R && z2) {
            this.Y.showContinueButton(false);
        }
        B();
        if (this.U) {
            this.j.setVisibility(8);
            this.b.setVisibility(8);
            s();
        }
        this.aG = this.ay;
        if (this.ay) {
            this.ao = false;
        }
        b(this.aQ);
        this.V.requestLayout();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void C() {
        this.aP.removeMessages(3);
        this.K.setVisibility(8);
        this.K.setAnimation(this.ae);
        this.K.startAnimation(this.ae);
        if (!this.R) {
            this.p.setVisibility(0);
            this.p.setAnimation(this.af);
            this.p.startAnimation(this.af);
        }
    }
}
