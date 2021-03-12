package com.amap.api.col.stln3;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.enums.AMapNaviOnlineCarHailingType;
import com.amap.api.navi.model.AMapCalcRouteResult;
import com.amap.api.navi.model.AMapCarInfo;
import com.amap.api.navi.model.AMapNaviGuide;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapTrafficStatus;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.navi.model.NaviPath;
import com.amap.api.services.core.AMapException;
import com.autonavi.ae.data.DataServicePro;
import com.autonavi.ae.data.InitParams;
import com.autonavi.ae.dice.NaviEngine;
import com.autonavi.ae.guide.GuideService;
import com.autonavi.ae.guide.model.GNaviPath;
import com.autonavi.ae.guide.model.GuideConfig;
import com.autonavi.ae.pos.GpsInfo;
import com.autonavi.ae.pos.LocInfo;
import com.autonavi.ae.pos.LocManager;
import com.autonavi.ae.route.RouteService;
import com.autonavi.ae.route.model.CurrentNaviInfo;
import com.autonavi.ae.route.model.CurrentPositionInfo;
import com.autonavi.ae.route.model.LightBarItem;
import com.autonavi.ae.route.model.POIForRequest;
import com.autonavi.ae.route.model.POIInfo;
import com.autonavi.ae.route.model.RerouteOption;
import com.autonavi.ae.route.model.RouteConfig;
import com.autonavi.ae.route.model.RouteOption;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: Ae8Control */
public final class it extends jc {
    ix a;
    iy b;
    NaviPath c;
    int d = -1;
    AMapCarInfo e = null;
    boolean f = true;
    boolean g = true;
    int h = 16;
    int i = 100;
    boolean j = false;
    boolean k = false;
    AMapNaviOnlineCarHailingType l = AMapNaviOnlineCarHailingType.NONE;
    private Context m;
    private GuideService n;
    private RouteService o;
    private int p = 12;
    private POIForRequest q;
    private jj r = null;
    private long s = 0;
    private Map<String, ln> t = new HashMap();

    static /* synthetic */ void a(it itVar, AMapCalcRouteResult aMapCalcRouteResult) {
        try {
            if (itVar.t() != null) {
                itVar.t().obtainMessage(29, Integer.valueOf(aMapCalcRouteResult.getErrorCode())).sendToTarget();
            }
            if (itVar.t() != null) {
                itVar.t().obtainMessage(41, aMapCalcRouteResult).sendToTarget();
            }
        } catch (Throwable th) {
            rx.c(th, "A8C", "callbackErrorcode");
        }
    }

    public it(Context context) {
        super(context);
        try {
            this.m = context.getApplicationContext();
            this.a = new ix(this);
            this.b = new iy(this);
            DataServicePro.init(new InitParams());
            DataServicePro.getInstance();
            LocManager.init();
            LocManager.setMatchMode(0);
            LocManager.addLocListener(this.a, 0);
            LocManager.addParallelRoadObserver(this.a);
            LocManager.addParallelSwitchObserver(this.a);
            LocManager.setLogSwitch(false, false, 0);
            String v = rd.v(this.m);
            v = TextUtils.isEmpty(v) ? "00000000" : v;
            String b2 = b("navipath");
            String b3 = b("cache");
            String b4 = b("res");
            GuideConfig guideConfig = new GuideConfig();
            guideConfig.userBatch = "0";
            guideConfig.userCode = "An_AMapLBS_ADR";
            guideConfig.UUID = v;
            guideConfig.naviPath = b2;
            guideConfig.cachePath = b3;
            guideConfig.resPath = b4;
            guideConfig.passWord = "maplbs2016";
            this.n = new GuideService(guideConfig, context);
            this.n.registerHttpProcesser(this.a);
            this.n.setNaviObserver(this.a);
            this.n.setSoundPlayObserver(this.a);
            this.n.setElecEyeObserver(this.a);
            this.n.addStatusObserver(this.a);
            RouteConfig routeConfig = new RouteConfig();
            routeConfig.userBatch = "0";
            routeConfig.userCode = "An_AMapLBS_ADR";
            routeConfig.deviceID = v;
            routeConfig.password = "maplbs2016";
            routeConfig.naviPath = b2;
            routeConfig.resPath = b4;
            routeConfig.cachePath = b3;
            this.o = new RouteService(routeConfig, this.m);
            this.o.setRouteObserver(this.b);
            this.o.registerHttpProcesser(this.b);
            t().b = this;
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "A8C", "constructor");
        }
    }

    public final void a() {
        GuideService guideService = this.n;
        if (guideService != null) {
            guideService.control(0, "1");
            this.n.control(15, "3");
            this.n.control(5, "1");
            this.n.control(34, "60");
            this.n.control(61, "0");
            this.o.control(17, "0");
        }
    }

    public final void b() {
        GuideService guideService = this.n;
        if (guideService != null) {
            guideService.stopNavi();
        }
        super.s();
        iu.b(this.m);
        LocManager.saveLocStorage();
        LocManager.uninit();
        NaviEngine.destroy();
        DataServicePro.destroy();
        if (this.o != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.o.setRouteObserver(null);
            this.o.destroy();
            long currentTimeMillis2 = System.currentTimeMillis();
            String str = "routeService destroy()-->" + (currentTimeMillis2 - currentTimeMillis);
            this.o = null;
        }
        if (this.n != null) {
            long currentTimeMillis3 = System.currentTimeMillis();
            this.n.removeStatusObserver(this.a);
            this.n.destroy();
            long currentTimeMillis4 = System.currentTimeMillis();
            String str2 = "guideService destroy()-->" + (currentTimeMillis4 - currentTimeMillis3);
            this.n = null;
        }
        ix ixVar = this.a;
        if (ixVar != null) {
            ixVar.c();
            this.a = null;
        }
        iy iyVar = this.b;
        if (iyVar != null) {
            iyVar.c();
            this.b = null;
        }
        this.m = null;
        this.c = null;
        Map<String, ln> map = this.t;
        if (map != null) {
            map.clear();
            this.t = null;
        }
    }

    public final int c() {
        return this.d;
    }

    @Override // com.amap.api.col.stln3.jk
    public final NaviInfo d() {
        ix ixVar = this.a;
        if (ixVar != null) {
            return ixVar.a();
        }
        return null;
    }

    private String b(String str) {
        try {
            File a2 = mj.a(this.m);
            if (a2 == null) {
                return "";
            }
            if (!a2.exists()) {
                return "";
            }
            String str2 = mj.a(this.m).getAbsolutePath() + "/AmapSdk";
            if (str != null) {
                str2 = str2 + "/" + str;
            }
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "A8C", "getWorkPath");
            return "";
        }
    }

    public final Context e() {
        return this.m;
    }

    public final GuideService f() {
        return this.n;
    }

    public final RouteService g() {
        return this.o;
    }

    @Override // com.amap.api.col.stln3.jk
    public final boolean a(int i2) {
        if (i2 != 2 && i2 != 1) {
            return false;
        }
        try {
            if (this.c == null) {
                c(this.p);
            }
            this.d = i2;
            if (this.a != null) {
                this.a.d();
            }
            if (this.k) {
                e(this.p);
            } else {
                f(this.p);
            }
            this.n.startNavi(this.d - 1);
            t().obtainMessage(26, Integer.valueOf(i2)).sendToTarget();
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "A8C", "startNavi");
        }
        return true;
    }

    @Override // com.amap.api.col.stln3.jk
    public final void h() {
        GuideService guideService = this.n;
        if (guideService != null) {
            guideService.pauseNavi();
        }
    }

    @Override // com.amap.api.col.stln3.jk
    public final void i() {
        try {
            if (this.n != null) {
                this.n.stopNavi();
                this.c = null;
                this.n.setNaviPath(null, 0);
                this.d = -1;
                iu.a((LocInfo) null);
                if (t() != null) {
                    t().obtainMessage(38).sendToTarget();
                }
            }
        } catch (Throwable th) {
            rx.c(th, "A8C", "stopNavi");
        }
    }

    @Override // com.amap.api.col.stln3.jk
    public final void j() {
        GuideService guideService = this.n;
        if (guideService != null) {
            guideService.resumeNavi();
        }
    }

    @Override // com.autonavi.tbt.IAe8, com.amap.api.col.stln3.jc
    public final void refreshTrafficStatuses() {
    }

    @Override // com.amap.api.col.stln3.jk
    public final boolean k() {
        GuideService guideService = this.n;
        if (guideService == null) {
            return true;
        }
        guideService.playNaviManual();
        return true;
    }

    @Override // com.autonavi.tbt.IAe8, com.amap.api.col.stln3.jc
    public final boolean readTrafficInfo(int i2) {
        GuideService guideService = this.n;
        if (guideService == null) {
            return true;
        }
        guideService.playTRManual(i2);
        return true;
    }

    @Override // com.autonavi.tbt.IAe8, com.amap.api.col.stln3.jc
    public final void setCarNumber(String str, String str2) {
        GuideService guideService = this.n;
        if (guideService != null && this.o != null) {
            guideService.control(35, str.concat(str2));
            this.o.control(1, str.concat(str2));
            this.n.control(42, "1");
            this.o.control(2, "1");
        }
    }

    @Override // com.autonavi.tbt.IAe8, com.amap.api.col.stln3.jc
    public final void setCarInfo(AMapCarInfo aMapCarInfo) {
        GuideService guideService;
        this.e = aMapCarInfo;
        if (aMapCarInfo != null && (guideService = this.n) != null && this.o != null) {
            guideService.control(35, aMapCarInfo.getCarNumber());
            this.o.control(1, aMapCarInfo.getCarNumber());
            if (!TextUtils.isEmpty(aMapCarInfo.getCarType())) {
                this.n.control(36, aMapCarInfo.getCarType());
                this.o.control(3, aMapCarInfo.getCarType());
            }
            this.n.control(42, aMapCarInfo.isRestriction() ? "1" : "0");
            this.o.control(2, aMapCarInfo.isRestriction() ? "1" : "0");
            if (!TextUtils.isEmpty(aMapCarInfo.getVehicleHeight())) {
                this.n.control(37, aMapCarInfo.getVehicleHeight());
                this.o.control(4, aMapCarInfo.getVehicleHeight());
            }
            if (!TextUtils.isEmpty(aMapCarInfo.getVehicleLoad())) {
                this.n.control(38, aMapCarInfo.getVehicleLoad());
                this.o.control(5, aMapCarInfo.getVehicleLoad());
            }
            if (!TextUtils.isEmpty(aMapCarInfo.getVehicleWeight())) {
                this.n.control(64, aMapCarInfo.getVehicleWeight());
                this.o.control(8, aMapCarInfo.getVehicleWeight());
            }
            if (!TextUtils.isEmpty(aMapCarInfo.getVehicleWidth())) {
                this.n.control(62, aMapCarInfo.getVehicleWidth());
                this.o.control(6, aMapCarInfo.getVehicleWidth());
            }
            if (!TextUtils.isEmpty(aMapCarInfo.getVehicleLength())) {
                this.n.control(63, aMapCarInfo.getVehicleLength());
                this.o.control(7, aMapCarInfo.getVehicleLength());
            }
            if (!TextUtils.isEmpty(aMapCarInfo.getVehicleSize())) {
                this.n.control(65, aMapCarInfo.getVehicleSize());
                this.o.control(9, aMapCarInfo.getVehicleSize());
            }
            if (!TextUtils.isEmpty(aMapCarInfo.getVehicleAxis())) {
                this.n.control(72, aMapCarInfo.getVehicleAxis());
                this.o.control(21, aMapCarInfo.getVehicleAxis());
            }
            this.o.control(10, aMapCarInfo.isVehicleLoadSwitch() ? "1" : "0");
        }
    }

    public final AMapCarInfo l() {
        return this.e;
    }

    @Override // com.autonavi.tbt.IAe8, com.amap.api.col.stln3.jc
    public final boolean reCalculateRoute(RerouteOption rerouteOption, boolean z) {
        if (rerouteOption == null) {
            return false;
        }
        try {
            if (rerouteOption.getRerouteType() == 2) {
                if (!this.f) {
                    return false;
                }
            }
            if (rerouteOption.getRerouteType() == 5) {
                if (!this.g) {
                    return false;
                }
            }
            if (this.o != null) {
                rerouteOption.setRequestRouteType(4);
                rerouteOption.setConstrainCode(0);
                POIForRequest pOIForRequest = new POIForRequest();
                if (!z) {
                    if (!(this.a == null || this.a.b() == null)) {
                        CurrentPositionInfo currentPositionInfo = new CurrentPositionInfo();
                        currentPositionInfo.linkIndex = this.a.b().m_CurLinkNum;
                        currentPositionInfo.segmentIndex = this.a.b().m_CurSegNum;
                        currentPositionInfo.pointIndex = this.a.b().m_CurPointNum;
                        rerouteOption.setCurrentLocation(currentPositionInfo);
                        CurrentNaviInfo currentNaviInfo = new CurrentNaviInfo();
                        currentNaviInfo.remainRouteDist = this.a.b().m_RouteRemainDis;
                        currentNaviInfo.remainRouteTime = this.a.b().m_RouteRemainTime;
                        currentNaviInfo.remainSegmentDist = this.a.b().m_SegRemainDis;
                        currentNaviInfo.drivingRouteDist = this.a.b().getDriveDist();
                        rerouteOption.setRemainNaviInfo(currentNaviInfo);
                    }
                    rerouteOption.setNaviPath(this.b.e().pathPtrs[this.p - 12]);
                    rerouteOption.setRouteMode(0);
                    POIInfo[] pOIInfoArr = new POIInfo[1];
                    if (iu.a(this.m) != null) {
                        POIInfo pOIInfo = new POIInfo();
                        pOIInfo.latitude = iu.a(this.m).getLatitude();
                        pOIInfo.longitude = iu.a(this.m).getLongitude();
                        pOIInfo.angle = String.valueOf(this.a.g.getBearing());
                        pOIForRequest.reliability = 0.4f;
                        if (iu.h() != null) {
                            pOIInfo.naviLat = (double) (((float) iu.h().MatchInfos[0].stPos.lat) / 3600000.0f);
                            pOIInfo.naviLon = (double) (((float) iu.h().MatchInfos[0].stPos.lon) / 3600000.0f);
                            pOIInfo.angle = String.valueOf((float) iu.h().MatchRoadCourse);
                            pOIForRequest.direction = (float) iu.h().MatchRoadCourse;
                            pOIForRequest.reliability = (float) iu.h().courseAcc;
                            pOIForRequest.angleType = iu.h().CourseType;
                            pOIForRequest.angleGps = (float) iu.h().GpsCourse;
                            pOIForRequest.angleComp = (float) iu.h().CompassCourse;
                            pOIForRequest.matchingDir = iu.h().roadCourse;
                            pOIForRequest.fittingDir = iu.h().fittingCourse;
                            pOIForRequest.radius = iu.h().errorDist;
                            pOIForRequest.sigType = iu.h().sourType;
                            pOIForRequest.gpsCredit = iu.h().gpsCoureAcc;
                            pOIForRequest.fittingCredit = iu.h().fittingCourseAcc;
                            pOIForRequest.precision = (float) iu.h().showPosAcc;
                            pOIForRequest.speed = (float) iu.h().speed;
                            pOIForRequest.formWay = iu.h().MatchInfos[0].formWay;
                            pOIForRequest.linkType = iu.h().MatchInfos[0].linkType;
                        }
                        pOIInfo.type = 0;
                        pOIInfoArr[0] = pOIInfo;
                    }
                    pOIForRequest.start = pOIInfoArr;
                    pOIForRequest.via = iu.e();
                    pOIForRequest.end = iu.f();
                    rerouteOption.setPOIForRequest(pOIForRequest);
                }
                String str = "rerouteOption.getRerouteType() = " + rerouteOption.getRerouteType();
                int reroute = this.o.reroute(rerouteOption);
                rerouteOption.release();
                if (reroute == 1) {
                    return true;
                }
                return false;
            }
        } catch (Throwable th) {
            rx.c(th, "A8C", "reCalculateRoute");
        }
        return false;
    }

    @Override // com.autonavi.tbt.IAe8, com.amap.api.col.stln3.jc
    public final List<AMapTrafficStatus> getTrafficStatuses(int i2, int i3) {
        try {
            if (m() != null) {
                return m().getTrafficStatuses();
            }
            return null;
        } catch (Throwable th) {
            rx.c(th, "A8C", "getTrafficStatuses");
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.stln3.jk
    public final AMapNaviPath m() {
        try {
            if (this.c != null) {
                return this.c.amapNaviPath;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "A8C", "getCurrentChosenNaviPath");
            return null;
        }
    }

    @Override // com.amap.api.col.stln3.jk
    public final List<AMapNaviGuide> n() {
        try {
            if (this.c != null) {
                return this.c.getGuideList();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "A8C", "getNaviGuideList");
            return null;
        }
    }

    @Override // com.amap.api.col.stln3.jk
    public final void b(int i2) {
        if (this.n != null) {
            if (i2 < 9) {
                i2 = 9;
            }
            if (i2 > 120) {
                i2 = 120;
            }
            this.n.control(34, String.valueOf(i2));
        }
    }

    @Override // com.amap.api.col.stln3.jk
    public final int c(int i2) {
        try {
            if (this.d != -1) {
                return this.p;
            }
            int i3 = 14;
            if (!(this.b == null || this.b.a() == null)) {
                i3 = (this.b.a().size() + 12) - 1;
            }
            if (i2 >= 12) {
                if (i2 <= i3) {
                    this.p = i2;
                    d(this.p);
                    return i2;
                }
            }
            return this.p;
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "A8C", "selectRoute");
        }
    }

    /* access modifiers changed from: package-private */
    public final void d(int i2) {
        this.p = i2;
        iy iyVar = this.b;
        if (iyVar != null) {
            this.c = iyVar.a().get(Integer.valueOf(this.p));
            this.b.a(this.p);
        }
    }

    /* access modifiers changed from: package-private */
    public final void o() {
        try {
            GNaviPath gNaviPath = new GNaviPath();
            gNaviPath.pathPtrs = new long[this.b.e().pathPtrs.length];
            for (int i2 = 0; i2 < this.b.e().pathPtrs.length; i2++) {
                if (this.b.e() != null) {
                    gNaviPath.pathPtrs[i2] = this.b.e().pathPtrs[i2];
                }
            }
            gNaviPath.calRouteType = this.b.e().calRouteType;
            gNaviPath.pointAddr = this.b.e().pointAddr;
            gNaviPath.strategy = this.b.e().strategy;
            this.n.setNaviPath(gNaviPath, -1);
            long[] jArr = new long[(this.b.e().pathPtrs.length + 1)];
            for (int i3 = 0; i3 < jArr.length; i3++) {
                if (i3 == 0) {
                    jArr[0] = this.c.getId();
                } else {
                    jArr[i3] = this.b.e().pathPtrs[i3 - 1];
                }
            }
            this.b.e().pathPtrs = jArr;
            this.b.d().addPath(this.c.getId());
            Map<Integer, NaviPath> a2 = this.b.a();
            NaviPath[] naviPathArr = new NaviPath[a2.size()];
            int i4 = 0;
            for (Map.Entry<Integer, NaviPath> entry : a2.entrySet()) {
                naviPathArr[i4] = entry.getValue();
                i4++;
            }
            a2.clear();
            a2.put(12, this.c);
            for (int i5 = 0; i5 < naviPathArr.length; i5++) {
                a2.put(Integer.valueOf(i5 + 12 + 1), naviPathArr[i5]);
            }
            d(12);
            this.b.a(naviPathArr);
        } catch (Throwable th) {
            rx.c(th, "A8C", "setNaviBackupNaviPath");
        }
    }

    /* access modifiers changed from: package-private */
    public final void e(int i2) {
        try {
            this.p = i2;
            GNaviPath gNaviPath = new GNaviPath();
            if (this.k) {
                gNaviPath.pathPtrs = new long[this.b.e().pathPtrs.length];
                int i3 = 0;
                for (int i4 = 0; i4 < this.b.e().pathPtrs.length; i4++) {
                    if (this.b.e() != null) {
                        gNaviPath.pathPtrs[i4] = this.b.e().pathPtrs[i4];
                    }
                }
                gNaviPath.calRouteType = this.b.e().calRouteType;
                gNaviPath.pointAddr = this.b.e().pointAddr;
                gNaviPath.strategy = this.b.e().strategy;
                this.n.setNaviPath(gNaviPath, this.p - 12);
                Map<Integer, NaviPath> a2 = this.b.a();
                NaviPath[] naviPathArr = null;
                if (a2.size() > 1) {
                    naviPathArr = new NaviPath[(a2.size() - 1)];
                    for (Map.Entry<Integer, NaviPath> entry : a2.entrySet()) {
                        if (entry.getKey().intValue() != this.p) {
                            naviPathArr[i3] = entry.getValue();
                            i3++;
                        }
                    }
                }
                this.b.a(naviPathArr);
            }
        } catch (Throwable th) {
            rx.c(th, "A8C", "setMultipleNaviPath");
        }
    }

    /* access modifiers changed from: package-private */
    public final void f(int i2) {
        try {
            this.p = i2;
            if (this.n != null) {
                GNaviPath gNaviPath = new GNaviPath();
                gNaviPath.pathPtrs = new long[1];
                if (this.b.e() != null) {
                    gNaviPath.pathPtrs[0] = this.b.e().pathPtrs[this.p - 12];
                }
                gNaviPath.calRouteType = this.b.e().calRouteType;
                gNaviPath.pointAddr = this.b.e().pointAddr;
                gNaviPath.strategy = this.b.e().strategy;
                this.n.setNaviPath(gNaviPath, 0);
            }
        } catch (Throwable th) {
            rx.c(th, "A8C", "setSingleNaviPath");
        }
    }

    @Override // com.autonavi.tbt.IAe8, com.amap.api.col.stln3.jc
    public final int[] getAllRouteID() {
        try {
            if (this.b != null) {
                return this.b.b();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "A8C", "getAllRouteID");
            return null;
        }
    }

    @Override // com.autonavi.tbt.IAe8, com.amap.api.col.stln3.jc
    public final boolean setBroadcastMode(int i2) {
        RouteService routeService = this.o;
        if (routeService != null) {
            routeService.control(12, String.valueOf(i2));
        }
        GuideService guideService = this.n;
        if (guideService == null) {
            return true;
        }
        guideService.control(22, String.valueOf(i2));
        return true;
    }

    @Override // com.autonavi.tbt.IAe8, com.amap.api.col.stln3.jc
    public final void switchParallelRoad() {
        LocManager.switchParallelRoad(0);
    }

    @Override // com.autonavi.tbt.IAe8, com.amap.api.col.stln3.jc
    public final void startAimlessMode(int i2) {
        GuideService guideService = this.n;
        if (guideService != null) {
            guideService.control(33, String.valueOf(i2));
            this.n.startNavi(2);
            t().obtainMessage(26, 3).sendToTarget();
        }
    }

    @Override // com.autonavi.tbt.IAe8, com.amap.api.col.stln3.jc
    public final void stopAimlessMode() {
        GuideService guideService = this.n;
        if (guideService != null) {
            guideService.control(33, "0");
            this.n.stopNavi();
        }
    }

    @Override // com.autonavi.tbt.IAe8, com.amap.api.col.stln3.jc
    public final int strategyConvert(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        try {
            int a2 = mn.a(z, z2, z3, z4);
            if (!z5) {
                return a2 + 50;
            }
            return a2;
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "A8C", "strategyConvert");
            return 0;
        }
    }

    @Override // com.autonavi.tbt.IAe8, com.amap.api.col.stln3.jc
    public final HashMap<Integer, AMapNaviPath> getMultipleNaviPathsCalculated() {
        HashMap<Integer, AMapNaviPath> hashMap = new HashMap<>(3);
        try {
            for (Map.Entry<Integer, NaviPath> entry : this.b.a().entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue().amapNaviPath);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "A8C", "getMultipleNaviPathsCalculated");
        }
        return hashMap;
    }

    @Override // com.amap.api.col.stln3.jk
    public final void a(int i2, double d2, double d3) {
    }

    @Override // com.amap.api.col.stln3.jk
    public final void g(int i2) {
    }

    @Override // com.amap.api.col.stln3.jk
    public final void a(int i2, Location location) {
        try {
            Calendar instance = Calendar.getInstance(Locale.CHINA);
            instance.setTimeInMillis(location.getTime());
            int i3 = 1;
            int i4 = instance.get(1);
            int i5 = instance.get(2) + 1;
            int i6 = instance.get(5);
            int i7 = instance.get(11);
            int i8 = instance.get(12);
            int i9 = instance.get(13);
            GpsInfo gpsInfo = new GpsInfo();
            if (i2 != 2) {
                i3 = 0;
            }
            gpsInfo.encrypted = (byte) i3;
            gpsInfo.accuracy = (double) location.getAccuracy();
            gpsInfo.alt = location.getAltitude();
            gpsInfo.angle = (double) location.getBearing();
            gpsInfo.lat = (int) (location.getLatitude() * 1000000.0d);
            gpsInfo.lon = (int) (location.getLongitude() * 1000000.0d);
            gpsInfo.speed = ((double) location.getSpeed()) * 3.6d;
            gpsInfo.hour = i7;
            gpsInfo.minute = i8;
            gpsInfo.second = i9;
            gpsInfo.year = i4;
            gpsInfo.month = i5;
            gpsInfo.day = i6;
            gpsInfo.ticktime = System.currentTimeMillis();
            gpsInfo.sourtype = 0;
            gpsInfo.status = 'A';
            gpsInfo.ew = 'E';
            gpsInfo.ns = 'N';
            gpsInfo.hdop = 0.9d;
            gpsInfo.pdop = 0.9d;
            gpsInfo.vdop = 0.9d;
            gpsInfo.satnum = 9;
            gpsInfo.mode = 'N';
            LocManager.setGpsInfo(gpsInfo);
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "A8C", "sgi");
        }
    }

    @Override // com.autonavi.tbt.IAe8, com.amap.api.col.stln3.jc
    public final void setReCalculateRouteForYaw(boolean z) {
        this.f = z;
    }

    @Override // com.autonavi.tbt.IAe8, com.amap.api.col.stln3.jc
    public final void setReCalculateRouteForTrafficJam(boolean z) {
        this.g = z;
    }

    @Override // com.autonavi.tbt.IAe8, com.amap.api.col.stln3.jc
    public final void setTrafficStatusUpdateEnabled(boolean z) {
        GuideService guideService = this.n;
        if (guideService != null) {
            guideService.control(0, z ? "1" : "0");
        }
    }

    @Override // com.autonavi.tbt.IAe8, com.amap.api.col.stln3.jc
    public final void setTrafficInfoUpdateEnabled(boolean z) {
        GuideService guideService = this.n;
        if (guideService != null) {
            guideService.control(5, z ? "1" : "0");
        }
    }

    @Override // com.autonavi.tbt.IAe8, com.amap.api.col.stln3.jc
    public final void setCameraInfoUpdateEnabled(boolean z) {
        GuideService guideService = this.n;
        if (guideService != null) {
            guideService.control(32, z ? "1" : "0");
        }
    }

    @Override // com.autonavi.tbt.IAe8, com.amap.api.col.stln3.jc
    public final void setDetectedMode(int i2) {
    }

    @Override // com.autonavi.tbt.IAe8, com.amap.api.col.stln3.jc
    public final boolean calculateDriveRoute(List<NaviLatLng> list, List<NaviLatLng> list2, int i2) {
        ArrayList arrayList = new ArrayList();
        NaviLatLng a2 = iu.a(this.m);
        if (a2 == null) {
            return false;
        }
        arrayList.add(a2);
        return calculateDriveRoute(arrayList, list, list2, i2);
    }

    @Override // com.autonavi.tbt.IAe8, com.amap.api.col.stln3.jc
    public final boolean calculateDriveRoute(List<NaviLatLng> list, List<NaviLatLng> list2, List<NaviLatLng> list3, int i2) {
        int i3;
        if (list != null) {
            try {
                if (list.size() > 1) {
                    LatLng latLng = new LatLng(list.get(0).getLatitude(), list.get(0).getLongitude());
                    LatLng latLng2 = new LatLng(list.get(1).getLatitude(), list.get(1).getLongitude());
                    if (!latLng.equals(latLng2)) {
                        mj.a(latLng, latLng2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                rx.c(th, "A8C", "cdr");
                i3 = 0;
            }
        }
        if (list3 != null && list3.size() > this.h) {
            list3 = list3.subList(0, this.h);
        }
        if (list != null && list.size() > 0) {
            list = list.subList(list.size() - 1, list.size());
        }
        if (list2 != null && list2.size() > 0) {
            list2 = list2.subList(list2.size() - 1, list2.size());
        }
        iu.a(i2);
        iu.a(iv.a(list));
        iu.c(iv.a(list2));
        iu.b(iv.a(list3));
        float f2 = 0.4f;
        float a2 = this.r.a(iu.d()[0].latitude, iu.d()[0].longitude);
        if (a2 == 0.1111f) {
            if (this.a.g != null) {
                if (((float) mj.a(this.a.g.getCoord(), new NaviLatLng(iu.d()[0].latitude, iu.d()[0].longitude))) < ((float) this.i)) {
                    a2 = this.a.g.getBearing();
                }
            }
            if (a2 == 0.1111f) {
                f2 = -1.0f;
                a2 = -1.0f;
            }
        }
        if (iu.a()) {
            RouteOption routeOption = new RouteOption();
            routeOption.setConstrainCode(0);
            this.q = new POIForRequest();
            this.q.start = iu.d();
            this.q.direction = a2;
            this.q.reliability = f2;
            this.q.end = iu.f();
            if (list3 != null && list3.size() > 0) {
                this.q.via = iu.e();
            }
            routeOption.setPOIForRequestBackUp(this.q);
            routeOption.setRequestRouteType(4);
            i3 = a(routeOption);
        } else {
            i3 = 0;
        }
        return i3 == 1;
    }

    public final void a(LightBarItem[] lightBarItemArr) {
        try {
            if (this.s == 0 || System.currentTimeMillis() - this.s >= 10000) {
                this.b.d().getRoute(this.p - 12).updateTmcBar(lightBarItemArr);
                this.b.a(this.c, this.p);
                this.c = this.b.a().get(Integer.valueOf(this.p));
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "A8C", "updateTrafficStatus");
        }
    }

    public final POIForRequest p() {
        return this.q;
    }

    public final long q() {
        try {
            return this.b.d().getRoute(this.p - 12).getPathId();
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "A8C", "getNaviPathId");
            return 0;
        }
    }

    public final long r() {
        return this.s;
    }

    public final void a(long j2) {
        this.s = j2;
    }

    private int a(RouteOption routeOption) {
        boolean z;
        try {
            if (mf.e) {
                if (this.l != AMapNaviOnlineCarHailingType.PICKUP) {
                    if (this.l == AMapNaviOnlineCarHailingType.TRANSPORT) {
                    }
                }
                POIInfo[] pOIInfoArr = routeOption.poiForRequest.end;
                if (pOIInfoArr != null && pOIInfoArr.length > 0) {
                    for (POIInfo pOIInfo : pOIInfoArr) {
                        if (pOIInfo.type != mf.f) {
                            pOIInfo.type = mf.f;
                            pOIInfo.poiID = mf.g;
                            pOIInfo.typeCode = mf.h;
                        }
                    }
                }
            }
            routeOption.setPOIForRequest(routeOption.poiForRequest);
            if (iu.e() == null || iu.e().length <= 0) {
                z = true;
            } else {
                z = false;
            }
            NaviLatLng naviLatLng = (iu.d() == null || iu.d().length <= 0) ? null : new NaviLatLng(iu.d()[0].latitude, iu.d()[0].longitude);
            NaviLatLng naviLatLng2 = (iu.f() == null || iu.f().length <= 0) ? null : new NaviLatLng(iu.f()[0].latitude, iu.f()[0].longitude);
            if (!(naviLatLng == null || naviLatLng2 == null || mj.a(naviLatLng, naviLatLng2) <= 80000)) {
                z = false;
            }
            if (this.e != null && "1".equals(this.e.getCarType())) {
                z = false;
            }
            if (!z) {
                b(false);
            } else {
                b(this.j);
            }
            if (z) {
                if (this.j) {
                    return this.o.requestRoute(routeOption);
                }
            }
            if (this.b != null) {
                this.b.a((NaviPath[]) null);
            }
        } catch (Throwable th) {
            rx.c(th, "A8C", "requestRoute");
        }
        return this.o.requestRoute(routeOption);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00db A[Catch:{ Throwable -> 0x00fb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.amap.api.col.stln3.ln r7, com.amap.api.col.stln3.ln r8, java.util.List<com.amap.api.col.stln3.ln> r9, int r10) {
        /*
        // Method dump skipped, instructions count: 267
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.it.a(com.amap.api.col.stln3.ln, com.amap.api.col.stln3.ln, java.util.List, int):boolean");
    }

    @Override // com.amap.api.col.stln3.jc
    public final boolean a(String str, String str2, List<String> list, int i2) {
        ArrayList arrayList;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            Poi poi = new Poi(null, null, str);
            Poi poi2 = new Poi(null, null, str2);
            if (list == null || list.size() <= 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                for (String str3 : list) {
                    arrayList.add(new Poi(null, null, str3));
                }
            }
            b(poi, poi2, arrayList, i2);
            return true;
        } catch (Throwable th) {
            rx.c(th, "A8C", "calculateDriveRoute");
            return true;
        }
    }

    @Override // com.amap.api.col.stln3.jc
    public final boolean a(Poi poi, Poi poi2, List<Poi> list, int i2) {
        if (poi2 == null) {
            return false;
        }
        b(poi, poi2, list, i2);
        return true;
    }

    @Override // com.amap.api.col.stln3.jc
    public final boolean a(String str, List<String> list, int i2) {
        ArrayList arrayList;
        try {
            if (TextUtils.isEmpty(str) || iu.a(this.m) == null) {
                return false;
            }
            Poi poi = new Poi(null, null, str);
            if (list == null || list.size() <= 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                for (String str2 : list) {
                    arrayList.add(new Poi(null, null, str2));
                }
            }
            b(null, poi, arrayList, i2);
            return true;
        } catch (Throwable th) {
            rx.c(th, "A8C", "calculateDriveRoute1");
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ln b(Poi poi, ln lnVar) {
        if (lnVar != null) {
            return lnVar;
        }
        if (poi != null) {
            try {
                if (!TextUtils.isEmpty(poi.getPoiId()) || poi.getCoordinate() != null) {
                    if (poi.getCoordinate() != null) {
                        return new ln(null, new li(poi.getCoordinate().latitude, poi.getCoordinate().longitude), poi.getName(), poi.getName());
                    }
                    return null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                rx.c(th, "A8C", "getStartPoiItem");
                return null;
            }
        }
        NaviLatLng a2 = iu.a(this.m);
        if (a2 != null) {
            return new ln(null, new li(a2.getLatitude(), a2.getLongitude()), "我的位置", "我的位置");
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static ln c(Poi poi, ln lnVar) {
        if (lnVar != null) {
            return lnVar;
        }
        if (poi == null) {
            return null;
        }
        try {
            if (poi.getCoordinate() != null) {
                return new ln(null, new li(poi.getCoordinate().latitude, poi.getCoordinate().longitude), poi.getName(), poi.getName());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "A8C", "getEndPoiItem");
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static List<ln> b(List<Poi> list, Map<String, ln> map) {
        try {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    Poi poi = list.get(i2);
                    ln lnVar = (poi == null || TextUtils.isEmpty(poi.getPoiId())) ? null : map.get(c(poi.getPoiId()));
                    if (lnVar == null) {
                        if (poi != null && poi.getCoordinate() != null) {
                            lnVar = new ln(poi.getPoiId(), new li(poi.getCoordinate().latitude, poi.getCoordinate().longitude), poi.getName(), poi.getName());
                        }
                    }
                    if (lnVar != null) {
                        arrayList.add(lnVar);
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "A8C", "getWayPoiItem");
            return null;
        }
    }

    private void b(final Poi poi, final Poi poi2, final List<Poi> list, final int i2) {
        jg.a().execute(new Runnable() {
            /* class com.amap.api.col.stln3.it.AnonymousClass1 */

            public final void run() {
                String str;
                ln lnVar;
                ln lnVar2;
                try {
                    ArrayList arrayList = new ArrayList();
                    if (poi != null && !TextUtils.isEmpty(poi.getPoiId())) {
                        if (it.this.t != null) {
                            Map map = it.this.t;
                            it itVar = it.this;
                            if (map.get(it.c(poi.getPoiId())) == null) {
                            }
                        }
                        arrayList.add(poi.getPoiId());
                    }
                    if (poi2 != null && !TextUtils.isEmpty(poi2.getPoiId())) {
                        if (it.this.t != null) {
                            Map map2 = it.this.t;
                            it itVar2 = it.this;
                            if (map2.get(it.c(poi2.getPoiId())) == null) {
                            }
                        }
                        arrayList.add(poi2.getPoiId());
                    }
                    if (list != null && list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            Poi poi = (Poi) list.get(i);
                            if (poi != null && !TextUtils.isEmpty(poi.getPoiId())) {
                                if (it.this.t != null) {
                                    Map map3 = it.this.t;
                                    it itVar3 = it.this;
                                    if (map3.get(it.c(poi.getPoiId())) == null) {
                                    }
                                }
                                arrayList.add(poi.getPoiId());
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        AMapCalcRouteResult c2 = it.this.c((it) arrayList, (List) it.this.t);
                        if (c2 != null) {
                            it.a(it.this, c2);
                            return;
                        }
                    }
                    List<ln> list = null;
                    if (poi == null || TextUtils.isEmpty(poi.getPoiId())) {
                        lnVar = null;
                        str = null;
                    } else {
                        Map map4 = it.this.t;
                        it itVar4 = it.this;
                        lnVar = (ln) map4.get(it.c(poi.getPoiId()));
                        str = lnVar == null ? "搜索结果失败，搜索的id为" + poi.getPoiId() : null;
                    }
                    ln b2 = it.this.b((it) poi, (Poi) lnVar);
                    if (b2 == null) {
                        AMapCalcRouteResult aMapCalcRouteResult = new AMapCalcRouteResult(3);
                        aMapCalcRouteResult.setErrorDetail(str);
                        it.a(it.this, aMapCalcRouteResult);
                        return;
                    }
                    if (poi2 == null || TextUtils.isEmpty(poi2.getPoiId())) {
                        lnVar2 = null;
                    } else {
                        Map map5 = it.this.t;
                        it itVar5 = it.this;
                        lnVar2 = (ln) map5.get(it.c(poi2.getPoiId()));
                        if (lnVar2 == null) {
                            str = "搜索结果失败，搜索的id为" + poi2.getPoiId();
                        }
                    }
                    it itVar6 = it.this;
                    ln c3 = it.c(poi2, lnVar2);
                    if (c3 == null) {
                        AMapCalcRouteResult aMapCalcRouteResult2 = new AMapCalcRouteResult(6);
                        aMapCalcRouteResult2.setErrorDetail(str);
                        it.a(it.this, aMapCalcRouteResult2);
                        return;
                    }
                    if (list != null) {
                        it itVar7 = it.this;
                        list = it.b(list, it.this.t);
                    }
                    if (!it.this.a(b2, c3, list, i2)) {
                        AMapCalcRouteResult aMapCalcRouteResult3 = new AMapCalcRouteResult(19);
                        aMapCalcRouteResult3.setErrorDetail("引擎返回失败");
                        it.a(it.this, aMapCalcRouteResult3);
                    }
                } catch (Throwable th) {
                    mj.a(th);
                    rx.c(th, "A8C", "searchPoiIdInfoAndCalculateDriveRoute");
                    AMapCalcRouteResult aMapCalcRouteResult4 = new AMapCalcRouteResult(19);
                    aMapCalcRouteResult4.setErrorDetail("引擎返回失败");
                    it.a(it.this, aMapCalcRouteResult4);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private AMapCalcRouteResult c(List<String> list, Map<String, ln> map) {
        lm lmVar = new lm();
        lmVar.a(list);
        int i2 = 19;
        try {
            Map<String, ln> a2 = new lq(this.m, null).a(lmVar);
            if (a2 != null) {
                for (Map.Entry<String, ln> entry : a2.entrySet()) {
                    map.put(c(entry.getKey()), entry.getValue());
                }
            }
            return null;
        } catch (kv e2) {
            if (t() != null) {
                int b2 = e2.b();
                if (b2 == 1002) {
                    i2 = 13;
                } else if (b2 == 1008) {
                    i2 = 22;
                } else if (b2 != 1010) {
                    if (b2 != 1806) {
                        switch (b2) {
                            default:
                                switch (b2) {
                                }
                            case AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT /*{ENCODED_INT: 1102}*/:
                            case AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT /*{ENCODED_INT: 1103}*/:
                                i2 = 2;
                                break;
                        }
                    }
                    i2 = 2;
                } else {
                    i2 = 17;
                }
            }
            e2.printStackTrace();
            AMapCalcRouteResult aMapCalcRouteResult = new AMapCalcRouteResult(i2);
            aMapCalcRouteResult.setErrorDetail(e2.getMessage());
            return aMapCalcRouteResult;
        } catch (Throwable th) {
            AMapCalcRouteResult aMapCalcRouteResult2 = new AMapCalcRouteResult(19);
            aMapCalcRouteResult2.setErrorDetail(th.getMessage());
            rx.c(th, "A8C", "batchSearchPOI");
            mj.a(th);
            return aMapCalcRouteResult2;
        }
    }

    /* access modifiers changed from: private */
    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.toUpperCase(Locale.ENGLISH);
    }

    public final void a(jj jjVar) {
        this.r = jjVar;
    }

    private boolean b(boolean z) {
        try {
            this.k = z;
            if (this.b != null) {
                this.b.a(z);
            }
            if (this.n == null || this.o == null) {
                return false;
            }
            this.n.control(61, z ? "1" : "0");
            this.o.control(17, z ? "1" : "0");
            return true;
        } catch (Throwable th) {
            rx.c(th, "A8C", "batchSearchPOI");
            return false;
        }
    }

    @Override // com.amap.api.col.stln3.jc
    public final void a(boolean z) {
        this.j = z;
    }

    @Override // com.amap.api.col.stln3.jc
    public final void b(long j2) {
        GuideService guideService = this.n;
        if (guideService != null) {
            guideService.selectMainPathID(j2);
        }
    }

    public final void a(AMapNaviOnlineCarHailingType aMapNaviOnlineCarHailingType) {
        this.l = aMapNaviOnlineCarHailingType;
        iy iyVar = this.b;
        if (iyVar != null) {
            iyVar.a(aMapNaviOnlineCarHailingType);
        }
    }
}
