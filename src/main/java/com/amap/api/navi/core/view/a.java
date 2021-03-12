package com.amap.api.navi.core.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Pair;
import com.amap.api.col.stln3.je;
import com.amap.api.col.stln3.jq;
import com.amap.api.col.stln3.kj;
import com.amap.api.col.stln3.mj;
import com.amap.api.col.stln3.rx;
import com.amap.api.maps.AMap;
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.Polyline;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.INavi;
import com.amap.api.navi.MyNaviListener;
import com.amap.api.navi.model.AMapCalcRouteResult;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapModelCross;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLink;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapNaviRouteNotifyData;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AMapNotAvoidInfo;
import com.amap.api.navi.model.AMapServiceAreaInfo;
import com.amap.api.navi.model.AMapTrafficStatus;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.AmapCarLocation;
import com.amap.api.navi.model.IndependInfo;
import com.amap.api.navi.model.InnerNaviInfo;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.navi.model.NaviPath;
import com.amap.api.navi.model.RouteOverlayOptions;
import com.amap.api.navi.view.AmapCameraOverlay;
import com.amap.api.navi.view.NaviLimitOverlay;
import com.amap.api.navi.view.RouteOverLay;
import com.amap.api.navi.view.TrafficBarView;
import com.amap.api.navi.view.TrafficProgressBar;
import com.autonavi.ae.guide.model.NaviCongestionInfo;
import com.autonavi.tbt.TrafficFacilityInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: BaseNaviUIController */
public final class a implements jq.a, MyNaviListener {
    private boolean A = true;
    private RouteOverLay B;
    private je C;
    private AmapCameraOverlay D;
    private NaviLimitOverlay E;
    private INavi F = null;
    private AMap G;
    private Context H;
    private BaseNaviView I;
    private boolean J = true;
    private AMapNaviPath K;
    private AMapNaviLocation L = null;
    private int M = -1;
    private AMapNaviPath N;
    private int O;
    private int P;
    private jq Q;
    private boolean R;
    private boolean S = false;
    private boolean T = false;
    private boolean U = false;
    private AMapNotAvoidInfo V;
    private NaviLatLng W;
    private int X = 0;
    private ScheduledExecutorService Y;
    private LatLng Z;
    BitmapDescriptor a = null;
    BitmapDescriptor b = null;
    BitmapDescriptor c = null;
    BitmapDescriptor d = null;
    BitmapDescriptor e = null;
    BitmapDescriptor f = null;
    Rect g = null;
    int h = 50;
    LatLng i = null;
    float j = 0.0f;
    float k = 17.0f;
    float l = 0.0f;
    float m = 0.0f;
    int n = 0;
    int o = 14;
    int p = 18;
    int q = 20;
    boolean r = true;
    boolean s = false;
    List<RouteOverLay> t = new ArrayList();
    boolean u = false;
    private long v = 0;
    private InnerNaviInfo w;
    private int x = 1;
    private boolean y = true;
    private boolean z = true;

    public a(Context context, TextureMapView textureMapView, BaseNaviView baseNaviView) {
        if (baseNaviView != null) {
            this.H = context.getApplicationContext();
            this.B = new RouteOverLay(textureMapView.getMap(), null, this.H);
            this.C = new je(textureMapView, baseNaviView);
            this.D = new AmapCameraOverlay(context);
            this.F = AMapNavi.getInstance(this.H);
            this.I = baseNaviView;
            this.G = textureMapView.getMap();
            AMap aMap = this.G;
            this.Q = new jq(this.H);
            this.Q.a(this);
            this.E = new NaviLimitOverlay(context, textureMapView.getMap());
            this.a = BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture_green_unselected.png");
            this.b = BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture_no_unselected.png");
            this.c = BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture_slow_unselected.png");
            this.d = BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture_bad_unselected.png");
            this.e = BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture_serious_unselected.png");
            this.f = BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture_dott_gray_unselected.png");
        }
    }

    public final void a(Bitmap bitmap) {
        RouteOverLay routeOverLay = this.B;
        if (routeOverLay != null) {
            routeOverLay.setStartPointBitmap(bitmap);
        }
    }

    public final void a() {
        RouteOverLay routeOverLay = this.B;
        if (routeOverLay != null) {
            routeOverLay.setArrowOnRoute(false);
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onArriveDestination() {
        if (this.x != 2) {
            RouteOverLay routeOverLay = this.B;
            if (routeOverLay != null) {
                routeOverLay.removeFromMap();
            }
            AmapCameraOverlay amapCameraOverlay = this.D;
            if (amapCameraOverlay != null) {
                amapCameraOverlay.removeAllCamera();
            }
            NaviLimitOverlay naviLimitOverlay = this.E;
            if (naviLimitOverlay != null) {
                naviLimitOverlay.removeAllMarker();
            }
            c(false);
            this.I.arrivedEnd();
            je jeVar = this.C;
            if (jeVar != null) {
                jeVar.e();
            }
            this.P = 0;
            this.X = 0;
        }
    }

    public final InnerNaviInfo b() {
        return this.w;
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onArrivedWayPoint(int i2) {
        String str = "BaseNaviUIController-->onArrivedWayPoint(" + i2 + ")";
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onCalculateRouteFailure(int i2) {
        String str = "BaseNaviUIController-->onCalculateRouteFailure(),errorCode=" + i2;
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onCalculateRouteSuccess(int[] iArr) {
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        INavi iNavi = this.F;
        if (iNavi != null) {
            this.K = iNavi.getNaviPath();
            if (this.I != null && this.F.getEngineType() == 0) {
                TrafficBarView lazyTrafficBarView = this.I.getLazyTrafficBarView();
                AMapNaviPath aMapNaviPath = this.K;
                if (!(aMapNaviPath == null || lazyTrafficBarView == null)) {
                    lazyTrafficBarView.update(this.F.getTrafficStatuses(aMapNaviPath.getAllLength() - this.O, this.K.getAllLength()), this.O);
                }
                if (this.K != null) {
                    TrafficProgressBar trafficProgressBar = this.I.j;
                    int i2 = this.O;
                    if (i2 == 0) {
                        i2 = 1;
                    }
                    a(trafficProgressBar, i2);
                    TrafficProgressBar trafficProgressBar2 = this.I.k;
                    int i3 = this.O;
                    if (i3 == 0) {
                        i3 = 1;
                    }
                    a(trafficProgressBar2, i3);
                }
            }
        }
    }

    private void a(TrafficProgressBar trafficProgressBar, int i2) {
        AMapNaviPath aMapNaviPath = this.K;
        if (aMapNaviPath != null && trafficProgressBar != null) {
            trafficProgressBar.update(aMapNaviPath.getAllLength() + this.X, i2, this.F.getNaviPath().getTrafficStatuses());
        }
    }

    public final void a(boolean z2) {
        this.z = z2;
    }

    public final void b(boolean z2) {
        this.A = z2;
    }

    /* access modifiers changed from: package-private */
    public final void a(AMapNaviPath aMapNaviPath, boolean z2) {
        RouteOverLay routeOverLay;
        if (aMapNaviPath != this.N && aMapNaviPath != null) {
            if (this.z && (routeOverLay = this.B) != null) {
                routeOverLay.setAMapNaviPath(aMapNaviPath);
                this.B.addToMap();
                boolean z3 = this.U;
                if (z3) {
                    this.I.a(!z3, false);
                    d();
                }
            }
            j(this.U);
            if (this.F.getEngineType() != 0 || z2) {
                try {
                    if (this.K != null) {
                        LatLng latLng = null;
                        if (!(this.K.getStartPoint() == null || this.K.getEndPoint() == null)) {
                            latLng = new LatLng(this.K.getStartPoint().getLatitude(), this.K.getStartPoint().getLongitude());
                        }
                        float a2 = mj.a(latLng, new LatLng(this.K.getCoordList().get(1).getLatitude(), this.K.getCoordList().get(1).getLongitude()));
                        if (latLng != null) {
                            this.C.c();
                            this.i = latLng;
                            this.j = a2;
                            je jeVar = this.C;
                            AMap aMap = this.G;
                            this.Z = latLng;
                            jeVar.a(aMap, latLng, a2);
                            if (this.K.getEndPoint() != null) {
                                this.C.a(new LatLng(this.K.getEndPoint().getLatitude(), this.K.getEndPoint().getLongitude()));
                            }
                        }
                    }
                } catch (Throwable th) {
                    mj.a(th);
                    rx.c(th, "BaseNaviUIController", "drawCarOverlay");
                }
            }
            this.K = aMapNaviPath;
            this.N = aMapNaviPath;
        }
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        if (this.B != null) {
            int a2 = mj.a(this.H, 65);
            this.g = new Rect(a2, a2, a2, a2);
            if (this.B.getRouteOverlayOptions() != null) {
                this.g = this.B.getRouteOverlayOptions().getRect();
            }
            if (!this.z) {
                this.B.zoomToSpan(this.h + this.g.left, this.h + this.g.right, this.h + this.g.top, this.h + this.g.bottom, this.K);
            } else {
                this.B.setAMapNaviPath(this.K);
                this.B.zoomToSpan(this.g.left + this.h, this.g.right + this.h, this.g.top + this.h, this.g.bottom + this.h, this.K);
            }
            BaseNaviView baseNaviView = this.I;
            if (baseNaviView != null) {
                baseNaviView.updateRouteOverViewStatus(true);
            }
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onEndEmulatorNavi() {
        AmapCameraOverlay amapCameraOverlay = this.D;
        if (amapCameraOverlay != null) {
            amapCameraOverlay.removeAllCamera();
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onGetNavigationText(int i2, String str) {
        String str2 = "BaseNaviUIController-->onGetNavigationText(),msg=" + str;
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
    public final void onLocationChange(AMapNaviLocation aMapNaviLocation) {
        if (aMapNaviLocation != null && this.F != null) {
            this.L = aMapNaviLocation;
            this.W = aMapNaviLocation.getCoord();
            float bearing = aMapNaviLocation.getBearing();
            LatLng latLng = new LatLng(this.W.getLatitude(), this.W.getLongitude());
            this.i = latLng;
            this.j = bearing;
            if (this.F.getEngineType() == 1 || this.F.getEngineType() == 2) {
                if (!this.R || !this.S) {
                    this.C.a(this.G, latLng, bearing);
                } else {
                    this.Z = latLng;
                }
            } else if (this.F.getEngineType() == 0) {
                this.C.a(this.G, latLng, bearing);
            }
            if (this.s) {
                this.B.updatePolyline(aMapNaviLocation);
            }
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onNaviInfoUpdate(NaviInfo naviInfo) {
    }

    private float a(NaviLatLng naviLatLng, int i2, int i3) {
        LatLng latLng;
        if (i3 < 0) {
            try {
                return this.k;
            } catch (Throwable th) {
                th.printStackTrace();
                return this.k;
            }
        } else {
            if (this.g == null) {
                int a2 = mj.a(this.H, 65);
                this.g = new Rect(a2, a2, a2, a2);
                if (this.B.getRouteOverlayOptions() != null) {
                    this.g = this.B.getRouteOverlayOptions().getRect();
                }
            }
            AMapNaviPath naviPath = this.F.getNaviPath();
            LatLngBounds.Builder builder = LatLngBounds.builder();
            if (i2 >= naviPath.getSteps().size()) {
                return -1.0f;
            }
            List<AMapNaviLink> links = naviPath.getSteps().get(i2).getLinks();
            if (i3 < links.size()) {
                AMapNaviLink aMapNaviLink = links.get(i3);
                if (aMapNaviLink.getRoadType() == 6 || aMapNaviLink.getRoadType() == 3) {
                    return 17.0f;
                }
                if (aMapNaviLink.getRoadType() == 8) {
                    return 17.0f;
                }
            }
            List<NaviLatLng> coords = links.get(links.size() - 1).getCoords();
            NaviLatLng naviLatLng2 = coords.get(coords.size() - 1);
            if (this.I.getNaviMode() == 0) {
                float a3 = (float) mj.a(naviLatLng, naviLatLng2);
                if (this.I.w) {
                    latLng = this.G.getProjection().fromScreenLocation(new Point(this.I.u / 2, 35));
                } else {
                    latLng = this.G.getProjection().fromScreenLocation(new Point(this.I.u / 2, this.g.top + 25));
                }
                float a4 = (float) mj.a(naviLatLng, new NaviLatLng(latLng.latitude, latLng.longitude));
                this.I.getZoom();
                if (a3 > 1.0f) {
                    return (float) (((double) this.G.getCameraPosition().zoom) - (Math.log((double) ((a3 / a4) * ((this.G.getCameraPosition().tilt / 60.0f) + 1.0f))) / Math.log(2.0d)));
                }
                return -1.0f;
            } else if (this.I.getNaviMode() != 1) {
                return -1.0f;
            } else {
                builder.include(mj.b(naviLatLng));
                builder.include(mj.b(naviLatLng2));
                builder.include(new LatLng(naviLatLng.getLatitude() - (naviLatLng2.getLatitude() - naviLatLng.getLatitude()), naviLatLng.getLongitude() - (naviLatLng2.getLongitude() - naviLatLng.getLongitude())));
                LatLngBounds build = builder.build();
                Pair<Float, LatLng> calculateZoomToSpanLevel = this.G.calculateZoomToSpanLevel(35, 35, 35, 35, build.southwest, build.northeast);
                if (calculateZoomToSpanLevel != null) {
                    return ((Float) calculateZoomToSpanLevel.first).floatValue();
                }
                return -1.0f;
            }
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onNaviInfoUpdated(AMapNaviInfo aMapNaviInfo) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void updateCameraInfo(AMapNaviCameraInfo[] aMapNaviCameraInfoArr) {
        try {
            RouteOverlayOptions routeOverlayOptions = this.B.getRouteOverlayOptions();
            if (routeOverlayOptions == null || routeOverlayOptions.isShowCameOnRoute()) {
                if (this.w != null) {
                    this.w.getCurrentSpeed();
                }
                this.D.draw(this.G, aMapNaviCameraInfoArr);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onServiceAreaUpdate(AMapServiceAreaInfo[] aMapServiceAreaInfoArr) {
    }

    private void a(NaviInfo naviInfo) {
        if (naviInfo != null) {
            if (this.z || this.M != naviInfo.getCurStep()) {
                try {
                    List<NaviLatLng> arrowPoints = this.B.getArrowPoints(naviInfo.getCurStep());
                    if (arrowPoints != null && arrowPoints.size() > 0) {
                        this.B.drawArrow(arrowPoints);
                        this.M = naviInfo.getCurStep();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    rx.c(th, "BaseNaviUIController", "drawArrow(NaviInfo naviInfo)");
                }
            }
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void showCross(AMapNaviCross aMapNaviCross) {
        if (this.I.g != null) {
            this.I.g.setImageBitmap(aMapNaviCross.getBitmap());
            this.I.g.setVisibility(0);
        }
        this.I.a(aMapNaviCross);
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void hideCross() {
        if (this.I.g != null) {
            this.I.g.setVisibility(8);
        }
        this.I.b();
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void showModeCross(AMapModelCross aMapModelCross) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void hideModeCross() {
        this.I.c();
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0086 A[Catch:{ Throwable -> 0x00fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0093 A[Catch:{ Throwable -> 0x00fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d4 A[Catch:{ Throwable -> 0x00fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d6 A[Catch:{ Throwable -> 0x00fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e4 A[Catch:{ Throwable -> 0x00fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01a5  */
    @Override // com.amap.api.navi.MyNaviListener
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onInnerNaviInfoUpdate(com.amap.api.navi.model.InnerNaviInfo r18) {
        /*
        // Method dump skipped, instructions count: 655
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.navi.core.view.a.onInnerNaviInfoUpdate(com.amap.api.navi.model.InnerNaviInfo):void");
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onReCalculateRouteForTrafficJam() {
        try {
            this.w = null;
            this.M = -1;
            if (this.D != null) {
                this.D.removeAllCamera();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "onReCalculateRouteForTrafficJam()");
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onReCalculateRouteForYaw() {
        try {
            this.w = null;
            this.M = -1;
            if (this.D != null) {
                this.D.removeAllCamera();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "onReCalculateRouteForYaw()");
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onStartNavi(int i2) {
        try {
            this.x = i2;
            this.I.z = false;
            this.I.a(!this.U, false);
            this.I.d();
            this.I.a();
            if (this.F == null || this.F.getEngineType() == 0 || 1 != this.x || !this.R) {
                this.Q.b();
            } else {
                this.Q.a();
            }
            if (this.F == null || this.F.getEngineType() != 0) {
                this.C.a(20);
            } else {
                this.C.a(2);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "onStartNavi()");
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onTrafficStatusUpdate() {
        try {
            c();
            if (this.J && System.currentTimeMillis() - this.v >= 10000) {
                if (!(this.B == null || this.F == null)) {
                    AMapNaviPath aMapNaviPath = this.B.getAMapNaviPath();
                    List<AMapTrafficStatus> trafficStatuses = AMapNavi.getInstance(this.H).getNaviPath().getTrafficStatuses();
                    if (aMapNaviPath != null && trafficStatuses != null && trafficStatuses.size() > 0) {
                        this.B.setAMapNaviPath(AMapNavi.getInstance(this.H).getNaviPath());
                        this.B.setTrafficLine(Boolean.valueOf(this.J));
                    }
                }
                if (this.s) {
                    this.B.updatePolyline(this.L);
                }
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "onTrafficStatusUpdate");
        }
    }

    public final void e() {
        try {
            if (this.C != null) {
                this.C.a();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "openNorthUpMode");
        }
    }

    public final void f() {
        try {
            if (this.C != null) {
                this.C.b();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "openCarUpMode");
        }
    }

    public final void c(boolean z2) {
        try {
            if (this.y != z2) {
                this.y = z2;
                if (this.C != null) {
                    this.C.a(z2);
                }
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "setLock");
        }
    }

    public final void g() {
        try {
            if (this.B != null) {
                this.B.destroy();
                this.B = null;
            }
            if (this.C != null) {
                this.C.d();
                this.C = null;
            }
            if (this.D != null) {
                this.D.destroy();
                this.D = null;
            }
            if (this.Q != null) {
                this.Q.b();
                this.Q = null;
            }
            if (this.Y != null) {
                try {
                    this.Y.shutdownNow();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                this.Y = null;
            }
            this.P = 0;
            this.X = 0;
            if (this.a != null) {
                this.a.recycle();
                this.a = null;
            }
            if (this.b != null) {
                this.b.recycle();
                this.b = null;
            }
            if (this.c != null) {
                this.c.recycle();
                this.c = null;
            }
            if (this.d != null) {
                this.d.recycle();
                this.d = null;
            }
            if (this.e != null) {
                this.e.recycle();
                this.e = null;
            }
            if (this.f != null) {
                this.f.recycle();
                this.f = null;
            }
        } catch (Throwable th2) {
            mj.a(th2);
            rx.c(th2, "BaseNaviUIController", "destroy");
        }
    }

    public final void b(Bitmap bitmap) {
        try {
            if (this.B != null && bitmap != null) {
                this.B.setStartPointBitmap(bitmap);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "setStartBitmap");
        }
    }

    public final void c(Bitmap bitmap) {
        try {
            if (this.B != null && bitmap != null) {
                this.B.setEndPointBitmap(bitmap);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "setEndBitmap");
        }
    }

    public final void d(Bitmap bitmap) {
        try {
            if (this.B != null && bitmap != null) {
                this.B.setWayPointBitmap(bitmap);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "setWayBitmap");
        }
    }

    public final void e(Bitmap bitmap) {
        try {
            if (this.D != null && bitmap != null) {
                this.D.setCameraBitmap(bitmap);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "setMonitorBitmap");
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onGpsOpenStatus(boolean z2) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void showLaneInfo(AMapLaneInfo[] aMapLaneInfoArr, byte[] bArr, byte[] bArr2) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void showLaneInfo(AMapLaneInfo aMapLaneInfo) {
        try {
            if (this.I.r != null) {
                this.I.r.loadDriveWayBitmap(aMapLaneInfo);
                this.I.r.setVisibility(0);
            }
            if (this.I.A && this.A && aMapLaneInfo != null && this.I.q != null) {
                if (this.I.f != null) {
                    if (this.I.f.getVisibility() == 0) {
                        return;
                    }
                }
                this.I.q.loadDriveWayBitmap(aMapLaneInfo);
                this.I.q.setVisibility(0);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "setMonitorBitmap");
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void hideLaneInfo() {
        try {
            if (this.I.r != null) {
                this.I.r.setVisibility(8);
            }
            if (this.I.A && this.A && this.I.q != null) {
                this.I.q.setVisibility(8);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "hideLaneInfo");
        }
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

    @Override // com.amap.api.navi.MyNaviListener
    public final void onGpsSignalWeak(boolean z2) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void carProjectionChange(AmapCarLocation amapCarLocation) {
    }

    /* access modifiers changed from: package-private */
    public final void d(boolean z2) {
        try {
            this.J = z2;
            if (!(this.B == null || this.F == null)) {
                this.B.setTrafficLine(Boolean.valueOf(this.J));
            }
            if (this.t != null) {
                for (int i2 = 0; i2 < this.t.size(); i2++) {
                    RouteOverLay routeOverLay = this.t.get(i2);
                    routeOverLay.setTrafficLine(Boolean.valueOf(this.J));
                    routeOverLay.setZindex(-2);
                }
            }
            if (this.s) {
                this.B.updatePolyline(this.L);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "setTrafficLine");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        try {
            if (this.C != null) {
                this.C.b(i2);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "setLeaderLineEnabled");
        }
    }

    public final void h() {
        try {
            if (this.C != null) {
                this.C.f();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "setCarPixelPosition");
        }
    }

    public final void f(Bitmap bitmap) {
        try {
            if (this.C != null && bitmap != null) {
                this.C.a(bitmap);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "setCarPixelPosition");
        }
    }

    public final void g(Bitmap bitmap) {
        try {
            if (this.C != null && bitmap != null) {
                this.C.b(bitmap);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "setFourCornersBitmap");
        }
    }

    public final void e(boolean z2) {
        try {
            if (this.B != null) {
                this.B.setNaviArrowVisible(z2);
            }
            this.r = z2;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "setNaviArrowVisible");
        }
    }

    public final void a(RouteOverlayOptions routeOverlayOptions) {
        try {
            if (this.B != null) {
                this.B.setRouteOverlayOptions(routeOverlayOptions);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "setRouteOverlayOptions");
        }
    }

    public final void f(boolean z2) {
        this.R = z2;
    }

    public final void g(boolean z2) {
        try {
            this.T = z2;
            if (this.D != null) {
                this.D.setAllCameraVisible(this.T);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "setCameraBubbleShow");
        }
    }

    public final void h(boolean z2) {
        this.U = z2;
    }

    public final void i(boolean z2) {
        this.s = z2;
    }

    @Override // com.amap.api.col.stln3.jq.a
    public final void a(boolean z2, float f2) {
        try {
            if (this.F != null && this.F.getEngineType() != 0 && 1 == this.x && this.R) {
                this.S = z2;
                if (this.C != null) {
                    this.C.a(this.G, this.Z, f2);
                }
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "onSensorChanged");
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void updateIntervalCameraInfo(AMapNaviCameraInfo aMapNaviCameraInfo, AMapNaviCameraInfo aMapNaviCameraInfo2, int i2) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onStopNavi() {
        this.P = 0;
        this.X = 0;
    }

    public final void a(CameraPosition cameraPosition) {
        try {
            if (cameraPosition.zoom > 14.0f) {
                this.D.setAllCameraVisible(this.T);
                this.B.setLightsVisible(true);
                this.B.setNaviArrowVisible(this.r);
                return;
            }
            this.D.setAllCameraVisible(false);
            this.B.setLightsVisible(false);
            this.B.setNaviArrowVisible(false);
        } catch (Exception e2) {
            mj.a(e2);
            rx.c(e2, "BaseNaviUIController", "zoomChanged");
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onCalculateRouteSuccess(AMapCalcRouteResult aMapCalcRouteResult) {
        try {
            this.v = System.currentTimeMillis();
            if (this.G != null) {
                if (this.F != null) {
                    if (aMapCalcRouteResult.getCalcRouteType() == 0) {
                        n(true);
                        return;
                    } else {
                        n(false);
                        return;
                    }
                }
            }
            String str = "BaseNaviUIController-->" + this.G;
            String str2 = "BaseNaviUIController-->" + this.F;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "onCalculateRouteSuccess");
        }
    }

    private void n(boolean z2) {
        try {
            if (this.P >= 0) {
                this.X += this.P;
            }
            AMapNaviPath naviPath = this.F.getNaviPath();
            if (naviPath != null) {
                this.K = naviPath;
                this.O = naviPath.getAllLength();
                a(naviPath, z2);
                if (this.C != null) {
                    this.C.c(this.F.getEngineType());
                }
                c();
                this.M = -1;
                hideCross();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "refreshRoute");
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onCalculateRouteFailure(AMapCalcRouteResult aMapCalcRouteResult) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public final void onNaviRouteNotify(AMapNaviRouteNotifyData aMapNaviRouteNotifyData) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onUpdateTmcStatus(NaviCongestionInfo naviCongestionInfo) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onSelectRouteId(int i2) {
        if (this.F.getNaviType() == -1) {
            n(false);
        }
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onChangeNaviPath(int i2) {
        n(false);
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onDeletePath(long[] jArr) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void updateBackupPath(NaviPath[] naviPathArr) {
        int i2;
        a aVar = this;
        NaviPath[] naviPathArr2 = naviPathArr;
        for (RouteOverLay routeOverLay : aVar.t) {
            routeOverLay.removeFromMap();
            routeOverLay.destroy();
        }
        aVar.t.clear();
        if (naviPathArr2 != null) {
            int i3 = 0;
            int i4 = 0;
            while (i4 < naviPathArr2.length) {
                RouteOverLay routeOverLay2 = new RouteOverLay(aVar.G, naviPathArr2[i4].amapNaviPath, aVar.H);
                List<IndependInfo> independInfo = naviPathArr2[i4].getIndependInfo();
                if (independInfo == null || independInfo.size() <= 0) {
                    i2 = i4;
                } else {
                    long j2 = 0;
                    INavi iNavi = aVar.F;
                    if (iNavi != null) {
                        j2 = iNavi.getNaviPath().getPathid();
                    }
                    if (i4 == 0) {
                        for (IndependInfo independInfo2 : independInfo) {
                            if (j2 == independInfo2.getPathid()) {
                                routeOverLay2.independStepStartIndexList = independInfo2.getStartStepIndex();
                                routeOverLay2.independLinkStartIndexList = independInfo2.getStartLinkIndex();
                                routeOverLay2.independStepEndIndexList = independInfo2.getEndStepIndex();
                                routeOverLay2.independLinkEndIndexList = independInfo2.getEndLinkIndex();
                            }
                        }
                        i2 = i4;
                    } else if (independInfo.size() > 1) {
                        IndependInfo independInfo3 = independInfo.get(i3);
                        IndependInfo independInfo4 = independInfo.get(1);
                        if (independInfo3 == null && independInfo4 != null) {
                            routeOverLay2.independStepStartIndexList = independInfo4.getStartStepIndex();
                            routeOverLay2.independLinkStartIndexList = independInfo4.getStartLinkIndex();
                            routeOverLay2.independStepEndIndexList = independInfo4.getEndStepIndex();
                            routeOverLay2.independLinkEndIndexList = independInfo4.getEndStepIndex();
                        }
                        if (independInfo3 != null && independInfo4 == null) {
                            routeOverLay2.independStepStartIndexList = independInfo3.getStartStepIndex();
                            routeOverLay2.independLinkStartIndexList = independInfo3.getStartLinkIndex();
                            routeOverLay2.independStepEndIndexList = independInfo3.getEndStepIndex();
                            routeOverLay2.independLinkEndIndexList = independInfo3.getEndStepIndex();
                        }
                        if (independInfo3 == null || independInfo4 == null) {
                            i2 = i4;
                        } else {
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = new ArrayList();
                            ArrayList arrayList4 = new ArrayList();
                            int i5 = 0;
                            while (i5 < independInfo3.getStartStepIndex().size()) {
                                int intValue = independInfo3.getStartStepIndex().get(i5).intValue();
                                int intValue2 = independInfo3.getStartLinkIndex().get(i5).intValue();
                                int intValue3 = independInfo3.getEndStepIndex().get(i5).intValue();
                                int intValue4 = independInfo3.getEndLinkIndex().get(i5).intValue();
                                while (i3 < independInfo4.getStartStepIndex().size()) {
                                    int intValue5 = independInfo4.getStartStepIndex().get(i3).intValue();
                                    int intValue6 = independInfo4.getStartLinkIndex().get(i3).intValue();
                                    int intValue7 = independInfo4.getEndStepIndex().get(i3).intValue();
                                    int intValue8 = independInfo4.getEndLinkIndex().get(i3).intValue();
                                    if (intValue5 <= intValue3 && intValue <= intValue7) {
                                        int i6 = intValue > intValue5 ? intValue : intValue5;
                                        if (intValue > intValue5 || (intValue >= intValue5 && intValue2 > intValue6)) {
                                            intValue6 = intValue2;
                                        }
                                        int i7 = intValue3 > intValue7 ? intValue7 : intValue3;
                                        if (intValue3 <= intValue7 && (intValue3 < intValue7 || intValue8 > intValue4)) {
                                            intValue8 = intValue4;
                                        }
                                        arrayList.add(Integer.valueOf(i6));
                                        arrayList2.add(Integer.valueOf(intValue6));
                                        arrayList3.add(Integer.valueOf(i7));
                                        arrayList4.add(Integer.valueOf(intValue8));
                                    }
                                    i3++;
                                    independInfo3 = independInfo3;
                                    i4 = i4;
                                }
                                i5++;
                                i3 = 0;
                            }
                            i2 = i4;
                            routeOverLay2.independStepStartIndexList = arrayList;
                            routeOverLay2.independLinkStartIndexList = arrayList2;
                            routeOverLay2.independStepEndIndexList = arrayList3;
                            routeOverLay2.independLinkEndIndexList = arrayList4;
                        }
                    } else {
                        i2 = i4;
                        if (independInfo.size() == 1) {
                            routeOverLay2.independStepStartIndexList = independInfo.get(0).getStartStepIndex();
                            routeOverLay2.independLinkStartIndexList = independInfo.get(0).getStartLinkIndex();
                            routeOverLay2.independStepEndIndexList = independInfo.get(0).getEndStepIndex();
                            routeOverLay2.independLinkEndIndexList = independInfo.get(0).getEndStepIndex();
                        }
                    }
                }
                aVar = this;
                routeOverLay2.mapWidth = aVar.I.getWidth();
                routeOverLay2.mapHeight = aVar.I.getHeight();
                routeOverLay2.setStartPointBitmap(null);
                routeOverLay2.setWayPointBitmap(null);
                routeOverLay2.setEndPointBitmap(null);
                routeOverLay2.setCartoFootBitmap(null);
                routeOverLay2.setLightsVisible(false);
                routeOverLay2.setArrowOnRoute(false);
                routeOverLay2.setNaviArrowVisible(false);
                RouteOverlayOptions routeOverlayOptions = new RouteOverlayOptions();
                routeOverlayOptions.setLineWidth(aVar.I.getViewOptions().getRouteOverlayOptions().getLineWidth());
                routeOverlayOptions.setSmoothTraffic(aVar.a.getBitmap());
                routeOverlayOptions.setJamTraffic(aVar.d.getBitmap());
                routeOverlayOptions.setUnknownTraffic(aVar.b.getBitmap());
                routeOverlayOptions.setNormalRoute(aVar.b.getBitmap());
                routeOverlayOptions.setVeryJamTraffic(aVar.e.getBitmap());
                routeOverlayOptions.setSlowTraffic(aVar.c.getBitmap());
                routeOverlayOptions.setFairWayRes(aVar.f.getBitmap());
                routeOverLay2.setRouteOverlayOptions(routeOverlayOptions);
                routeOverLay2.setTrafficLine(Boolean.valueOf(aVar.I.getViewOptions().isTrafficLine()));
                routeOverLay2.addToMap();
                routeOverLay2.setZindex(-2);
                aVar.t.add(routeOverLay2);
                i4 = i2 + 1;
                naviPathArr2 = naviPathArr;
                i3 = 0;
            }
        }
        aVar.j(aVar.u);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void j(boolean r14) {
        /*
        // Method dump skipped, instructions count: 782
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.navi.core.view.a.j(boolean):void");
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onSelectMainPathStatus(long j2) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onInnerNaviInfoUpdate(InnerNaviInfo[] innerNaviInfoArr) {
        BaseNaviView baseNaviView = this.I;
        if (baseNaviView != null) {
            baseNaviView.naviInfoHashMap.clear();
            for (InnerNaviInfo innerNaviInfo : innerNaviInfoArr) {
                this.I.naviInfoHashMap.put(Long.valueOf(innerNaviInfo.getPathid()), innerNaviInfo);
            }
        }
    }

    @Override // com.amap.api.navi.MyNaviListener
    public final void onSuggestChangePath(long j2, long j3, int i2) {
    }

    public final void k(boolean z2) {
        try {
            if (this.B != null) {
                this.B.setRouteOverlayVisible(z2);
                if (z2) {
                    this.B.addToMap();
                    a(this.w);
                } else {
                    this.B.removeFromMap();
                }
            }
            if (this.D != null) {
                this.D.setRouteOverlayVisible(z2);
                if (!z2) {
                    this.D.removeAllCamera();
                }
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "setRouteOverlayVisible");
        }
    }

    public final void l(boolean z2) {
        try {
            if (this.C != null && this.G != null) {
                this.C.b(z2);
                if (z2) {
                    this.C.a(this.G, this.i, this.j);
                } else {
                    this.C.b(false);
                }
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "setCarOverlayVisible");
        }
    }

    public final void m(boolean z2) {
        try {
            if (this.B != null) {
                this.B.setTrafficLightsVisible(z2);
                if (z2) {
                    this.B.drawLights();
                } else {
                    this.B.clearTrafficLights();
                }
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviUIController", "setTrafficLightsVisible");
        }
    }

    public final void a(Marker marker) {
        for (int i2 = 0; i2 < this.t.size(); i2++) {
            RouteOverLay routeOverLay = this.t.get(i2);
            if (!(routeOverLay == null || routeOverLay.bubbleMarker == null || marker.getObject() == null || !marker.getObject().equals(routeOverLay.bubbleMarker.getObject()))) {
                this.F.selectMainPathID(((Long) routeOverLay.bubbleMarker.getObject()).longValue());
            }
        }
        NaviLimitOverlay naviLimitOverlay = this.E;
        if (naviLimitOverlay != null) {
            naviLimitOverlay.onMarkerClick(marker);
        }
    }

    public final void a(Polyline polyline) {
        for (int i2 = 0; i2 < this.t.size(); i2++) {
            RouteOverLay routeOverLay = this.t.get(i2);
            if (routeOverLay.mTrafficColorfulPolylines != null) {
                for (kj kjVar : routeOverLay.mTrafficColorfulPolylines) {
                    if (kjVar.a.getId() == polyline.getId()) {
                        this.F.selectMainPathID(routeOverLay.getAMapNaviPath().getPathid());
                        return;
                    }
                }
            }
            if (routeOverLay.mDefaultPolyline != null && routeOverLay.mDefaultPolyline.a.getId() == polyline.getId()) {
                this.F.selectMainPathID(routeOverLay.getAMapNaviPath().getPathid());
                return;
            }
        }
    }
}
