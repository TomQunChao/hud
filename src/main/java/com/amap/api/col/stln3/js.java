package com.amap.api.col.stln3;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.navi.model.AMapNaviGuide;
import com.amap.api.navi.model.AMapNaviLink;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapNaviStep;
import com.amap.api.navi.model.NaviGuide;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.navi.model.NaviPath;
import com.autonavi.tbt.IFrameWTBT;
import com.autonavi.wtbt.IFrameForWTBT;
import com.autonavi.wtbt.NaviGuideItem;
import com.autonavi.wtbt.WTBT;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* compiled from: WtbtControl */
public final class js extends jc {
    private WTBT a;
    private NaviPath b;
    private int c = -1;
    private Context d;
    private IFrameWTBT e;
    private NaviLatLng f;
    private List<AMapNaviGuide> g = new ArrayList();

    public js(Context context) {
        super(context);
        su.a().a(context, jf.a(), "wtbt828");
        this.d = context;
        this.a = new WTBT();
        this.e = new ji(this.d, this);
    }

    public final IFrameForWTBT a() {
        return this.e;
    }

    public final void b() {
        String str;
        try {
            if (this.d != null) {
                if (this.a == null) {
                    this.a = new WTBT();
                }
                this.a.setEmulatorSpeed(20);
                if (this.e == null) {
                    this.e = new ji(this.d, this);
                }
                String v = rd.v(this.d);
                if (TextUtils.isEmpty(v)) {
                    str = "00000000";
                } else {
                    str = v;
                }
                WTBT wtbt = this.a;
                IFrameWTBT iFrameWTBT = this.e;
                int init = wtbt.init(iFrameWTBT, mj.a(this.d).getAbsolutePath() + "/navigation", "AN_AmapSdk_ADR_FC", "0", str, "");
                int param = this.a.setParam("userid", "AN_AmapSdk_ADR_FC");
                int param2 = this.a.setParam("userpwd", "amapsdk");
                String f2 = qy.f(this.d);
                if (!TextUtils.isEmpty(f2)) {
                    MapsInitializer.setApiKey(f2);
                }
                if (!(init == 0 || param == 0)) {
                    if (param2 != 0) {
                        return;
                    }
                }
                this.e.b();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void c() {
        try {
            super.s();
            ux.c();
            if (this.a != null) {
                this.a.destroy();
                this.a = null;
            }
            if (this.e != null) {
                this.e.a();
                this.e = null;
            }
            if (this.g != null) {
                this.g.clear();
                this.g = null;
            }
            this.b = null;
            this.d = null;
            this.f = null;
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "WtbtControl", "destroy()");
        }
    }

    @Override // com.amap.api.col.stln3.jk
    public final boolean a(int i) {
        try {
            this.c = i;
            boolean z = true;
            if (i == 1) {
                if (this.a.startGPSNavi() != 1) {
                    z = false;
                }
                if (z) {
                    if (this.e != null) {
                        this.e.a(i);
                    }
                }
                return z;
            }
            if (i == 2) {
                if (this.a.startEmulatorNavi() != 1) {
                    z = false;
                }
                if (z && this.e != null) {
                    this.e.a(i);
                }
                return z;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.stln3.jk
    public final void h() {
        WTBT wtbt = this.a;
        if (wtbt != null) {
            wtbt.pauseNavi();
        }
    }

    @Override // com.amap.api.col.stln3.jk
    public final void i() {
        WTBT wtbt = this.a;
        if (wtbt != null) {
            wtbt.stopNavi();
        }
    }

    @Override // com.amap.api.col.stln3.jk
    public final void j() {
        WTBT wtbt = this.a;
        if (wtbt != null) {
            wtbt.resumeNavi();
        }
    }

    @Override // com.amap.api.col.stln3.jk
    public final void a(int i, double d2, double d3) {
        WTBT wtbt = this.a;
        if (wtbt != null) {
            wtbt.setCarLocation(i, d2, d3);
        }
    }

    @Override // com.amap.api.col.stln3.jc
    public final boolean a(NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
        try {
            if (!(this.a == null || naviLatLng == null || naviLatLng2 == null)) {
                if (!mj.a(naviLatLng)) {
                    iw t = t();
                    if (t != null) {
                        t.obtainMessage(29, 3).sendToTarget();
                    }
                    return false;
                } else if (!mj.a(naviLatLng2)) {
                    iw t2 = t();
                    if (t2 != null) {
                        t2.obtainMessage(29, 6).sendToTarget();
                    }
                    return false;
                } else {
                    double[] dArr = {naviLatLng.getLongitude(), naviLatLng.getLatitude()};
                    double[] dArr2 = {naviLatLng2.getLongitude(), naviLatLng2.getLatitude()};
                    this.f = naviLatLng2;
                    if (this.a.requestRouteWithStart(0, 0, 1, dArr, 1, dArr2, 0, null) == 1) {
                        return true;
                    }
                    return false;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "wtbt", "cwr");
        }
        return false;
    }

    @Override // com.amap.api.col.stln3.jc
    public final boolean a(NaviLatLng naviLatLng) {
        if (naviLatLng != null) {
            try {
                if (!mj.a(naviLatLng)) {
                    iw t = t();
                    if (t != null) {
                        t.obtainMessage(29, 6).sendToTarget();
                    }
                    return false;
                }
                NaviLatLng a2 = iu.a(this.d);
                if (a2 != null) {
                    return a(a2, naviLatLng);
                }
                double[] dArr = {naviLatLng.getLongitude(), naviLatLng.getLatitude()};
                this.f = naviLatLng;
                if (this.a.requestRoute(0, 0, 1, dArr, 0, null) == 1) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public final void e() {
        WTBT wtbt = this.a;
        if (wtbt != null) {
            wtbt.reroute(0, 0);
        }
    }

    @Override // com.amap.api.col.stln3.jk
    public final AMapNaviPath m() {
        NaviPath naviPath = this.b;
        if (naviPath != null) {
            return naviPath.amapNaviPath;
        }
        return null;
    }

    @Override // com.amap.api.col.stln3.jk
    public final List<AMapNaviGuide> n() {
        NaviGuideItem[] naviGuideList;
        try {
            if (this.a == null || (naviGuideList = this.a.getNaviGuideList()) == null || naviGuideList.length <= 0) {
                return null;
            }
            this.g.clear();
            for (NaviGuideItem naviGuideItem : naviGuideList) {
                this.g.add(new NaviGuide(naviGuideItem).aMapNaviGuide);
            }
            return this.g;
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "wtbt", "gngl");
            return null;
        }
    }

    @Override // com.amap.api.col.stln3.jk
    public final void b(int i) {
        if (this.a != null) {
            if (i < 9) {
                i = 9;
            }
            if (i > 30) {
                i = 30;
            }
            this.a.setEmulatorSpeed(i);
        }
    }

    @Override // com.amap.api.col.stln3.jk
    public final void g(int i) {
        WTBT wtbt = this.a;
        if (wtbt != null) {
            wtbt.setTimeForOneWord(i);
        }
    }

    @Override // com.amap.api.col.stln3.jk
    public final int c(int i) {
        try {
            if (this.a != null) {
                int selectRoute = this.a.selectRoute(i);
                if (!(selectRoute == -1)) {
                    l();
                }
                return selectRoute;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return -1;
    }

    private NaviPath l() {
        Throwable th;
        double d2;
        double d3;
        js jsVar = this;
        jsVar.b = new NaviPath();
        try {
            jsVar.b.setAllLength(jsVar.a.getRouteLength());
            jsVar.b.setAllTime(jsVar.a.getRouteTime());
            jsVar.b.setStepsCount(jsVar.a.getSegNum());
            jsVar.b.setEndPoint(jsVar.f);
            jsVar.b.setStrategy(-1);
            int segNum = jsVar.a.getSegNum();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (jsVar.b.getWayPoint() != null) {
                jsVar.b.amapNaviPath.wayPointIndex = new int[jsVar.b.getWayPoint().size()];
            }
            double d4 = Double.MIN_VALUE;
            double d5 = Double.MAX_VALUE;
            double d6 = Double.MAX_VALUE;
            double d7 = Double.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            int i3 = -1;
            while (i < segNum) {
                AMapNaviStep aMapNaviStep = new AMapNaviStep();
                aMapNaviStep.setChargeLength(jsVar.a.getSegChargeLength(i));
                int segTollCost = i2 + jsVar.a.getSegTollCost(i);
                aMapNaviStep.setTime(jsVar.a.getSegTime(i));
                double[] segCoor = jsVar.a.getSegCoor(i);
                ArrayList arrayList3 = new ArrayList();
                if (segCoor != null) {
                    int i4 = 0;
                    while (i4 < segCoor.length - 1) {
                        arrayList3.add(new NaviLatLng(segCoor[i4 + 1], segCoor[i4]));
                        i4 += 2;
                        d5 = d5;
                        d7 = d7;
                    }
                    d2 = d7;
                    d3 = d5;
                } else {
                    d2 = d7;
                    d3 = d5;
                }
                aMapNaviStep.setCoords(arrayList3);
                aMapNaviStep.setLength(jsVar.a.getSegLength(i));
                ArrayList arrayList4 = new ArrayList();
                int segLinkNum = jsVar.a.getSegLinkNum(i);
                aMapNaviStep.setStartIndex(i3 + 1);
                d6 = d6;
                d5 = d3;
                int i5 = 0;
                while (i5 < segLinkNum) {
                    try {
                        AMapNaviLink aMapNaviLink = new AMapNaviLink();
                        aMapNaviLink.setLength(jsVar.a.getLinkLength(i, i5));
                        aMapNaviLink.setTime(jsVar.a.getLinkTime(i, i5));
                        aMapNaviLink.setRoadClass(jsVar.a.getLinkRoadClass(i, i5));
                        aMapNaviLink.setRoadType(jsVar.a.getLinkFormWay(i, i5));
                        aMapNaviLink.setRoadName(jsVar.a.getLinkRoadName(i, i5));
                        double d8 = d4;
                        aMapNaviLink.setTrafficLights(jsVar.a.haveTrafficLights(i, i5) == 1);
                        double[] linkCoor = jsVar.a.getLinkCoor(i, i5);
                        ArrayList arrayList5 = new ArrayList();
                        int i6 = 0;
                        while (i6 < linkCoor.length - 1) {
                            double d9 = linkCoor[i6 + 1];
                            double d10 = linkCoor[i6];
                            if (d8 < d9) {
                                d8 = d9;
                            }
                            if (d2 < d10) {
                                d2 = d10;
                            }
                            if (d5 > d9) {
                                d5 = d9;
                            }
                            if (d6 > d10) {
                                d6 = d10;
                            }
                            NaviLatLng naviLatLng = new NaviLatLng(d9, d10);
                            arrayList5.add(naviLatLng);
                            arrayList2.add(naviLatLng);
                            i3++;
                            i6 += 2;
                            linkCoor = linkCoor;
                            i = i;
                            arrayList = arrayList;
                            arrayList4 = arrayList4;
                        }
                        aMapNaviLink.setCoords(arrayList5);
                        arrayList4 = arrayList4;
                        arrayList4.add(aMapNaviLink);
                        i5++;
                        d4 = d8;
                        segLinkNum = segLinkNum;
                        i = i;
                        arrayList = arrayList;
                        jsVar = this;
                    } catch (Throwable th2) {
                        th = th2;
                        jsVar = this;
                        th.printStackTrace();
                        rx.c(th, "WtbtControl", "initNaviPath()");
                        return jsVar.b;
                    }
                }
                aMapNaviStep.setEndIndex(i3);
                jsVar = this;
                jsVar.b.setWayPoint(null);
                aMapNaviStep.setLinks(arrayList4);
                arrayList.add(aMapNaviStep);
                i++;
                arrayList = arrayList;
                segNum = segNum;
                i2 = segTollCost;
                d4 = d4;
                d7 = d2;
            }
            jsVar.b.getMaxCoordForPath().setLatitude(d4);
            jsVar.b.getMaxCoordForPath().setLongitude(d7);
            jsVar.b.getMinCoordForPath().setLatitude(d5);
            jsVar.b.getMinCoordForPath().setLongitude(d6);
            jsVar.b.setTollCost(i2);
            jsVar.b.setListStep(arrayList);
            if (arrayList2.size() > 0) {
                jsVar.b.setStartPoint((NaviLatLng) arrayList2.get(0));
            }
            jsVar.b.setList(arrayList2);
            NaviLatLng a2 = mj.a(jsVar.b.getMinCoordForPath().getLatitude(), jsVar.b.getMinCoordForPath().getLongitude(), jsVar.b.getMaxCoordForPath().getLatitude(), jsVar.b.getMaxCoordForPath().getLongitude());
            jsVar.b.setBounds(new LatLngBounds(new LatLng(jsVar.b.getMinCoordForPath().getLatitude(), jsVar.b.getMinCoordForPath().getLongitude()), new LatLng(jsVar.b.getMaxCoordForPath().getLatitude(), jsVar.b.getMaxCoordForPath().getLongitude())));
            jsVar.b.setCenter(a2);
        } catch (Throwable th3) {
            th = th3;
            th.printStackTrace();
            rx.c(th, "WtbtControl", "initNaviPath()");
            return jsVar.b;
        }
        return jsVar.b;
    }

    @Override // com.amap.api.col.stln3.jk
    public final void a(int i, Location location) {
        try {
            Calendar instance = Calendar.getInstance(Locale.CHINA);
            instance.setTimeInMillis(location.getTime());
            int i2 = instance.get(1);
            int i3 = instance.get(2) + 1;
            int i4 = instance.get(5);
            int i5 = instance.get(11);
            int i6 = instance.get(12);
            int i7 = instance.get(13);
            if (this.c == 1) {
                this.a.setGPSInfo(i, (int) location.getAccuracy(), 0.0d, location.getLongitude(), location.getLatitude(), ((double) location.getSpeed()) * 3.6d, (double) location.getBearing(), i2, i3, i4, i5, i6, i7);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.stln3.jk
    public final NaviInfo d() {
        IFrameWTBT iFrameWTBT = this.e;
        if (iFrameWTBT != null) {
            return iFrameWTBT.c();
        }
        return null;
    }

    @Override // com.amap.api.col.stln3.jk
    public final boolean k() {
        WTBT wtbt = this.a;
        if (wtbt == null || wtbt.playNaviManual() != 1) {
            return false;
        }
        return true;
    }

    public final WTBT f() {
        return this.a;
    }

    @Override // com.autonavi.tbt.IAe8, com.amap.api.col.stln3.jc
    public final HashMap<Integer, AMapNaviPath> getMultipleNaviPathsCalculated() {
        HashMap<Integer, AMapNaviPath> hashMap = new HashMap<>();
        try {
            hashMap.put(12, m());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return hashMap;
    }

    public final int g() {
        return this.c;
    }
}
