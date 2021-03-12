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
import com.autonavi.rtbt.IFrameForRTBT;
import com.autonavi.rtbt.NaviGuideItem;
import com.autonavi.rtbt.RTBT;
import com.autonavi.tbt.IFrameRTBT;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* compiled from: RtbtControl */
public final class jr extends jc {
    private RTBT a;
    private NaviPath b;
    private Context c;
    private IFrameRTBT d;
    private NaviLatLng e;
    private List<AMapNaviGuide> f = new ArrayList();
    private int g = -1;

    public jr(Context context) {
        super(context);
        su.a().a(context, jf.a(), "rtbt828");
        try {
            this.c = context;
            this.a = new RTBT();
            this.d = new jh(this.c, this);
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "RtbtControl", "RtbtControl()");
        }
    }

    public final void a() {
        String str;
        try {
            if (this.c != null) {
                if (this.a == null) {
                    this.a = new RTBT();
                }
                this.a.setEmulatorSpeed(35);
                if (this.d == null) {
                    this.d = new jh(this.c, this);
                }
                String v = rd.v(this.c);
                if (TextUtils.isEmpty(v)) {
                    str = "00000000";
                } else {
                    str = v;
                }
                RTBT rtbt = this.a;
                IFrameRTBT iFrameRTBT = this.d;
                int init = rtbt.init(iFrameRTBT, mj.a(this.c).getAbsolutePath() + "/navigation", "AN_AmapSdk_ADR_FC", "0", str, "");
                int param = this.a.setParam("userid", "AN_AmapSdk_ADR_FC");
                int param2 = this.a.setParam("userpwd", "amapsdk");
                String f2 = qy.f(this.c);
                if (!TextUtils.isEmpty(f2)) {
                    MapsInitializer.setApiKey(f2);
                }
                if (!(init == 0 || param == 0)) {
                    if (param2 != 0) {
                        return;
                    }
                }
                this.d.b();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void b() {
        try {
            super.s();
            if (this.a != null) {
                this.a.destroy();
                this.a = null;
            }
            if (this.d != null) {
                this.d.a();
                this.d = null;
            }
            if (this.f != null) {
                this.f.clear();
                this.f = null;
            }
            this.b = null;
            this.c = null;
            this.e = null;
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "RtbtControl", "destroy()");
        }
    }

    @Override // com.amap.api.col.stln3.jk
    public final NaviInfo d() {
        IFrameRTBT iFrameRTBT = this.d;
        if (iFrameRTBT != null) {
            return iFrameRTBT.c();
        }
        return null;
    }

    @Override // com.amap.api.col.stln3.jk
    public final boolean k() {
        RTBT rtbt = this.a;
        if (rtbt == null || rtbt.playNaviManual() != 1) {
            return false;
        }
        return true;
    }

    @Override // com.amap.api.col.stln3.jk
    public final boolean a(int i) {
        try {
            this.g = i;
            boolean z = true;
            if (i == 1) {
                if (this.a.startGPSNavi() != 1) {
                    z = false;
                }
                if (z) {
                    if (this.d != null) {
                        this.d.a(i);
                    }
                }
                return z;
            }
            if (i == 2) {
                if (this.a.startEmulatorNavi() != 1) {
                    z = false;
                }
                if (z && this.d != null) {
                    this.d.a(i);
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
        RTBT rtbt = this.a;
        if (rtbt != null) {
            rtbt.pauseNavi();
        }
    }

    @Override // com.amap.api.col.stln3.jk
    public final void i() {
        RTBT rtbt = this.a;
        if (rtbt != null) {
            rtbt.stopNavi();
        }
    }

    @Override // com.amap.api.col.stln3.jk
    public final void j() {
        RTBT rtbt = this.a;
        if (rtbt != null) {
            rtbt.resumeNavi();
        }
    }

    @Override // com.amap.api.col.stln3.jk
    public final void a(int i, double d2, double d3) {
        RTBT rtbt = this.a;
        if (rtbt != null) {
            rtbt.setCarLocation(i, d2, d3);
        }
    }

    @Override // com.amap.api.col.stln3.jc
    public final boolean b(NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
        if (!(naviLatLng == null || naviLatLng2 == null)) {
            try {
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
                    this.e = naviLatLng2;
                    if (this.a.requestRouteWithStart(0, 0, 1, dArr, 1, dArr2, 0, null) == 1) {
                        return true;
                    }
                    return false;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                rx.c(th, "RtbtControl", "calculateRideRoute(from,to)");
            }
        }
        return false;
    }

    @Override // com.amap.api.col.stln3.jc
    public final boolean b(NaviLatLng naviLatLng) {
        if (naviLatLng != null) {
            try {
                if (!mj.a(naviLatLng)) {
                    iw t = t();
                    if (t != null) {
                        t.obtainMessage(29, 6).sendToTarget();
                    }
                    return false;
                }
                NaviLatLng a2 = iu.a(this.c);
                if (a2 != null) {
                    return b(a2, naviLatLng);
                }
                double[] dArr = {naviLatLng.getLongitude(), naviLatLng.getLatitude()};
                this.e = naviLatLng;
                if (this.a.requestRoute(0, 0, 1, dArr, 0, null) == 1) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                rx.c(th, "RtbtControl", "calculateRideRoute(to)");
            }
        }
        return false;
    }

    public final void c() {
        RTBT rtbt = this.a;
        if (rtbt != null) {
            rtbt.reroute(0, 0);
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
            this.f.clear();
            for (NaviGuideItem naviGuideItem : naviGuideList) {
                this.f.add(new NaviGuide(naviGuideItem).aMapNaviGuide);
            }
            return this.f;
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "RtbtControl", "getNaviGuideList()");
            return null;
        }
    }

    @Override // com.amap.api.col.stln3.jk
    public final void b(int i) {
        if (this.a != null) {
            if (i < 9) {
                i = 9;
            }
            if (i > 50) {
                i = 50;
            }
            this.a.setEmulatorSpeed(i);
        }
    }

    @Override // com.amap.api.col.stln3.jk
    public final void g(int i) {
        RTBT rtbt = this.a;
        if (rtbt != null) {
            rtbt.setTimeForOneWord(i);
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
        jr jrVar = this;
        jrVar.b = new NaviPath();
        try {
            jrVar.b.setAllLength(jrVar.a.getRouteLength());
            jrVar.b.setAllTime(jrVar.a.getRouteTime());
            jrVar.b.setStepsCount(jrVar.a.getSegNum());
            jrVar.b.setEndPoint(jrVar.e);
            jrVar.b.setStrategy(-1);
            int segNum = jrVar.a.getSegNum();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (jrVar.b.getWayPoint() != null) {
                jrVar.b.amapNaviPath.wayPointIndex = new int[jrVar.b.getWayPoint().size()];
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
                int segChargeLength = jrVar.a.getSegChargeLength(i);
                if (segChargeLength < 0) {
                    segChargeLength = 0;
                }
                aMapNaviStep.setChargeLength(segChargeLength);
                int segTollCost = i2 + jrVar.a.getSegTollCost(i);
                aMapNaviStep.setTime(jrVar.a.getSegTime(i));
                double[] segCoor = jrVar.a.getSegCoor(i);
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
                aMapNaviStep.setLength(jrVar.a.getSegLength(i));
                ArrayList arrayList4 = new ArrayList();
                int segLinkNum = jrVar.a.getSegLinkNum(i);
                aMapNaviStep.setStartIndex(i3 + 1);
                d6 = d6;
                d5 = d3;
                int i5 = 0;
                while (i5 < segLinkNum) {
                    try {
                        AMapNaviLink aMapNaviLink = new AMapNaviLink();
                        aMapNaviLink.setLength(jrVar.a.getLinkLength(i, i5));
                        aMapNaviLink.setTime(jrVar.a.getLinkTime(i, i5));
                        aMapNaviLink.setRoadClass(jrVar.a.getLinkRoadClass(i, i5));
                        aMapNaviLink.setRoadType(jrVar.a.getLinkFormWay(i, i5));
                        aMapNaviLink.setRoadName(jrVar.a.getLinkRoadName(i, i5));
                        double d8 = d4;
                        aMapNaviLink.setTrafficLights(jrVar.a.haveTrafficLights(i, i5) == 1);
                        double[] linkCoor = jrVar.a.getLinkCoor(i, i5);
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
                        jrVar = this;
                    } catch (Throwable th2) {
                        th = th2;
                        jrVar = this;
                        th.printStackTrace();
                        rx.c(th, "RtbtControl", "initNaviPath()");
                        return jrVar.b;
                    }
                }
                aMapNaviStep.setEndIndex(i3);
                jrVar = this;
                jrVar.b.setWayPoint(null);
                aMapNaviStep.setLinks(arrayList4);
                arrayList.add(aMapNaviStep);
                i++;
                arrayList = arrayList;
                segNum = segNum;
                i2 = segTollCost;
                d4 = d4;
                d7 = d2;
            }
            jrVar.b.getMaxCoordForPath().setLatitude(d4);
            jrVar.b.getMaxCoordForPath().setLongitude(d7);
            jrVar.b.getMinCoordForPath().setLatitude(d5);
            jrVar.b.getMinCoordForPath().setLongitude(d6);
            jrVar.b.setTollCost(i2);
            jrVar.b.setListStep(arrayList);
            if (arrayList2.size() > 0) {
                jrVar.b.setStartPoint((NaviLatLng) arrayList2.get(0));
            }
            jrVar.b.setList(arrayList2);
            NaviLatLng a2 = mj.a(jrVar.b.getMinCoordForPath().getLatitude(), jrVar.b.getMinCoordForPath().getLongitude(), jrVar.b.getMaxCoordForPath().getLatitude(), jrVar.b.getMaxCoordForPath().getLongitude());
            jrVar.b.setBounds(new LatLngBounds(new LatLng(jrVar.b.getMinCoordForPath().getLatitude(), jrVar.b.getMinCoordForPath().getLongitude()), new LatLng(jrVar.b.getMaxCoordForPath().getLatitude(), jrVar.b.getMaxCoordForPath().getLongitude())));
            jrVar.b.setCenter(a2);
        } catch (Throwable th3) {
            th = th3;
            th.printStackTrace();
            rx.c(th, "RtbtControl", "initNaviPath()");
            return jrVar.b;
        }
        return jrVar.b;
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
            if (this.g == 1) {
                this.a.setGPSInfo(i, (int) location.getAccuracy(), 0.0d, location.getLongitude(), location.getLatitude(), ((double) location.getSpeed()) * 3.6d, (double) location.getBearing(), i2, i3, i4, i5, i6, i7);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final RTBT e() {
        return this.a;
    }

    public final IFrameForRTBT f() {
        return this.d;
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
        return this.g;
    }
}
