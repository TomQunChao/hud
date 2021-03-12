package com.amap.api.col.stln3;

import android.os.Handler;
import android.os.Message;
import android.support.v4.internal.view.SupportMenu;
import android.text.TextUtils;
import com.amap.api.col.stln3.iw;
import com.amap.api.navi.enums.AMapNaviOnlineCarHailingType;
import com.amap.api.navi.model.AMapCalcRouteResult;
import com.amap.api.navi.model.AMapCarInfo;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import com.amap.api.navi.model.AMapNaviForbiddenInfo;
import com.amap.api.navi.model.AMapNaviLimitInfo;
import com.amap.api.navi.model.AMapNaviRouteNotifyData;
import com.amap.api.navi.model.IndependInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.navi.model.NaviPath;
import com.autonavi.ae.guide.model.GNaviPath;
import com.autonavi.ae.route.model.AvoidJamArea;
import com.autonavi.ae.route.model.AvoidRestrictArea;
import com.autonavi.ae.route.model.CRouteDivergeMerge;
import com.autonavi.ae.route.model.ForbiddenInfo;
import com.autonavi.ae.route.model.ForbiddenLineInfo;
import com.autonavi.ae.route.model.ForbiddenWideHighWeightInfo;
import com.autonavi.ae.route.model.FormWay;
import com.autonavi.ae.route.model.LabelInfo;
import com.autonavi.ae.route.model.LineIconPoint;
import com.autonavi.ae.route.model.POIInfo;
import com.autonavi.ae.route.model.RoadClosedArea;
import com.autonavi.ae.route.model.RouteCamera;
import com.autonavi.ae.route.observer.HttpInterface;
import com.autonavi.ae.route.observer.RouteObserver;
import com.autonavi.ae.route.route.CalcRouteResult;
import com.autonavi.ae.route.route.Route;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: MyRouteObserver */
public final class iy implements HttpInterface, RouteObserver {
    int a = 35;
    int b = 36;
    boolean c = false;
    AMapNaviOnlineCarHailingType d = AMapNaviOnlineCarHailingType.NONE;
    private it e;
    private CalcRouteResult f;
    private int[] g;
    private Map<Integer, NaviPath> h = new HashMap();
    private int i = -1;
    private iw j;
    private Handler k = null;
    private GNaviPath l;

    public final Map<Integer, NaviPath> a() {
        return this.h;
    }

    public final int[] b() {
        return this.g;
    }

    public iy(it itVar) {
        try {
            this.e = itVar;
            this.j = itVar.t();
            if (this.k == null) {
                this.k = new Handler(itVar.e().getMainLooper()) {
                    /* class com.amap.api.col.stln3.iy.AnonymousClass1 */

                    public final void handleMessage(Message message) {
                        try {
                            super.handleMessage(message);
                            if (message.what == 1) {
                                try {
                                    if (message.obj == null) {
                                        return;
                                    }
                                    if (iy.this.e != null) {
                                        iz izVar = (iz) message.obj;
                                        if (izVar.b != null) {
                                            iy.this.e.g().processHttpData(izVar.a, 200, izVar.b);
                                        } else {
                                            iy.this.e.g().processHttpError(izVar.a, 1);
                                        }
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                        } catch (Throwable th2) {
                        }
                    }
                };
            }
        } catch (Throwable th) {
            rx.c(th, "MyRouteObserver", "init");
            th.printStackTrace();
        }
    }

    public final void c() {
        try {
            jv.a();
            if (this.f != null) {
                this.f.destroy();
            }
            if (this.h != null) {
                this.h.clear();
            }
            this.k = null;
        } catch (Throwable th) {
            rx.c(th, "MyRouteObserver", "destory");
        }
    }

    private void a(CalcRouteResult calcRouteResult, POIInfo[] pOIInfoArr, NaviPath naviPath, int i2) {
        if (calcRouteResult != null) {
            try {
                List<NaviLatLng> a2 = iv.a(pOIInfoArr);
                int nativeGetPathCount = calcRouteResult.nativeGetPathCount();
                if (nativeGetPathCount > 0) {
                    this.h.clear();
                    this.g = new int[nativeGetPathCount];
                    boolean z = false;
                    int i3 = 0;
                    while (i3 < nativeGetPathCount) {
                        NaviPath a3 = a(calcRouteResult.getRoute(i3), a2);
                        int i4 = i3 + 12;
                        this.g[i3] = i4;
                        this.h.put(Integer.valueOf(i4), a3);
                        i3++;
                    }
                    if (naviPath != null) {
                        Iterator<Map.Entry<Integer, NaviPath>> it = this.h.entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Map.Entry<Integer, NaviPath> next = it.next();
                            if (next.getValue().getPathId() == naviPath.getPathId()) {
                                i3 = next.getKey().intValue();
                                z = true;
                                break;
                            }
                        }
                        if (z && i3 != i2) {
                            this.h.put(Integer.valueOf(i2), this.h.get(Integer.valueOf(i3)));
                            this.h.put(Integer.valueOf(i3), this.h.get(Integer.valueOf(i2)));
                        }
                    }
                }
            } catch (Throwable th) {
                rx.c(th, "MyRouteObserver", "initNaviPath");
                th.printStackTrace();
            }
        }
    }

    private static boolean a(int i2, int i3, int i4, int i5, Route route) {
        try {
            if (i2 <= route.getSegmentCount() && i3 <= route.getSegment(i2).getLinkCount() && i4 <= route.getSegmentCount() && i5 <= route.getSegment(i4).getLinkCount()) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            rx.c(th, "MyRouteObserver", "isValid");
            return true;
        }
    }

    private static String a(Route route) {
        Throwable th;
        String str;
        String str2 = "";
        try {
            LabelInfo[] pathLabel = route.getPathLabel();
            if (pathLabel == null) {
                return str2;
            }
            try {
                StringBuilder sb = new StringBuilder();
                for (LabelInfo labelInfo : pathLabel) {
                    sb.append(labelInfo.content);
                    sb.append(",");
                }
                String sb2 = sb.toString();
                try {
                    return sb2.substring(0, sb2.length() - 1);
                } catch (Throwable th2) {
                    str2 = str;
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                th.printStackTrace();
                return str2;
            }
        } catch (Throwable th4) {
            th4.printStackTrace();
            rx.c(th4, "rObserver", "getLabels");
            return str2;
        }
    }

    private static List<AMapNaviCameraInfo> b(Route route) {
        ArrayList arrayList = new ArrayList();
        try {
            RouteCamera[] allCamera = route.getAllCamera();
            if (allCamera != null) {
                for (RouteCamera routeCamera : allCamera) {
                    arrayList.add(new AMapNaviCameraInfo(routeCamera));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "rObserver", "getCameraInfos");
        }
        return arrayList;
    }

    private static List<AMapNaviLimitInfo> c(Route route) {
        Throwable th;
        ArrayList arrayList = null;
        try {
            ForbiddenWideHighWeightInfo[] forbiddenWideHighWeightInfo = route.getForbiddenWideHighWeightInfo();
            if (forbiddenWideHighWeightInfo == null || forbiddenWideHighWeightInfo.length <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            for (ForbiddenWideHighWeightInfo forbiddenWideHighWeightInfo2 : forbiddenWideHighWeightInfo) {
                try {
                    arrayList2.add(new AMapNaviLimitInfo(forbiddenWideHighWeightInfo2));
                } catch (Throwable th2) {
                    th = th2;
                    arrayList = arrayList2;
                    th.printStackTrace();
                    rx.c(th, "rObserver", "getRouteLimitInfo");
                    return arrayList;
                }
            }
            return arrayList2;
        } catch (Throwable th3) {
            th = th3;
            th.printStackTrace();
            rx.c(th, "rObserver", "getRouteLimitInfo");
            return arrayList;
        }
    }

    private static List<AMapNaviForbiddenInfo> d(Route route) {
        Throwable th;
        ArrayList arrayList = null;
        try {
            ForbiddenLineInfo[] forbiddenLineInfo = route.getForbiddenLineInfo();
            if (forbiddenLineInfo == null || forbiddenLineInfo.length <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            for (ForbiddenLineInfo forbiddenLineInfo2 : forbiddenLineInfo) {
                try {
                    arrayList2.add(new AMapNaviForbiddenInfo(forbiddenLineInfo2));
                } catch (Throwable th2) {
                    th = th2;
                    arrayList = arrayList2;
                    th.printStackTrace();
                    rx.c(th, "rObserver", "getForbiddenInfo");
                    return arrayList;
                }
            }
            return arrayList2;
        } catch (Throwable th3) {
            th = th3;
            th.printStackTrace();
            rx.c(th, "rObserver", "getForbiddenInfo");
            return arrayList;
        }
    }

    private static List<IndependInfo> e(Route route) {
        CRouteDivergeMerge[] cRouteDivergeMergeArr;
        int[] iArr;
        long j2;
        int[] iArr2;
        ArrayList arrayList = new ArrayList();
        try {
            CRouteDivergeMerge[] cRouteDivergeMergeArr2 = route.getDivAndIndependInfo().divergeMerges;
            if (cRouteDivergeMergeArr2 != null && cRouteDivergeMergeArr2.length > 0) {
                int i2 = 0;
                while (i2 < cRouteDivergeMergeArr2.length) {
                    CRouteDivergeMerge cRouteDivergeMerge = cRouteDivergeMergeArr2[i2];
                    if (cRouteDivergeMerge != null) {
                        if (route.getPathId() == cRouteDivergeMerge.route1Index) {
                            j2 = cRouteDivergeMerge.route2Index;
                            iArr = cRouteDivergeMerge.route1DivergePos;
                            iArr2 = cRouteDivergeMerge.route1MergePos;
                        } else if (route.getPathId() == cRouteDivergeMerge.route2Index) {
                            j2 = cRouteDivergeMerge.route1Index;
                            iArr = cRouteDivergeMerge.route2DivergePos;
                            iArr2 = cRouteDivergeMerge.route2MergePos;
                        } else {
                            cRouteDivergeMergeArr = cRouteDivergeMergeArr2;
                        }
                        IndependInfo independInfo = null;
                        if (j2 == 0 || iArr == null || iArr2 == null || iArr2.length != iArr.length) {
                            cRouteDivergeMergeArr = cRouteDivergeMergeArr2;
                        } else {
                            independInfo = new IndependInfo();
                            independInfo.setCount(iArr.length);
                            independInfo.setPathid(j2);
                            ArrayList arrayList2 = new ArrayList(iArr.length);
                            ArrayList arrayList3 = new ArrayList(iArr.length);
                            ArrayList arrayList4 = new ArrayList(iArr.length);
                            ArrayList arrayList5 = new ArrayList(iArr.length);
                            int i3 = 0;
                            while (i3 < iArr.length) {
                                int i4 = iArr[i3] & SupportMenu.USER_MASK;
                                int i5 = (iArr[i3] >> 16) & SupportMenu.USER_MASK;
                                int i6 = iArr2[i3] & SupportMenu.USER_MASK;
                                int i7 = (iArr2[i3] >> 16) & SupportMenu.USER_MASK;
                                if (i6 == 65535 && i7 == 65535) {
                                    i6 = route.getSegmentCount() - 1;
                                    i7 = route.getSegment(i6).getLinkCount() - 1;
                                }
                                if (a(i4, i5, i6, i7, route)) {
                                    arrayList2.add(Integer.valueOf(i4));
                                    arrayList3.add(Integer.valueOf(i5));
                                    arrayList4.add(Integer.valueOf(i6));
                                    arrayList5.add(Integer.valueOf(i7));
                                }
                                i3++;
                                cRouteDivergeMergeArr2 = cRouteDivergeMergeArr2;
                            }
                            cRouteDivergeMergeArr = cRouteDivergeMergeArr2;
                            independInfo.setStartStepIndex(arrayList2);
                            independInfo.setStartLinkIndex(arrayList3);
                            independInfo.setEndStepIndex(arrayList4);
                            independInfo.setEndLinkIndex(arrayList5);
                        }
                        if (independInfo != null) {
                            arrayList.add(independInfo);
                        }
                    } else {
                        cRouteDivergeMergeArr = cRouteDivergeMergeArr2;
                    }
                    i2++;
                    cRouteDivergeMergeArr2 = cRouteDivergeMergeArr;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "rObserver", "getIndependInfos");
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x0349 A[Catch:{ Throwable -> 0x056a }, LOOP:4: B:59:0x0341->B:61:0x0349, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0529 A[Catch:{ Throwable -> 0x0568 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.amap.api.navi.model.NaviPath a(com.autonavi.ae.route.route.Route r38, java.util.List<com.amap.api.navi.model.NaviLatLng> r39) {
        /*
        // Method dump skipped, instructions count: 1408
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.iy.a(com.autonavi.ae.route.route.Route, java.util.List):com.amap.api.navi.model.NaviPath");
    }

    private static int a(FormWay formWay) {
        if (formWay == null) {
            return 1;
        }
        try {
            switch (formWay) {
                case Formway_Divised_Link:
                default:
                    return 1;
                case Formway_Cross_Link:
                    return 2;
                case Formway_JCT:
                    return 3;
                case Formway_Round_Circle:
                    return 4;
                case Formway_Service_Road:
                    return 5;
                case Formway_Slip_Road:
                    return 6;
                case Formway_Side_Road:
                    return 7;
                case Formway_Slip_JCT:
                    return 8;
                case Formway_Exit_Link:
                    return 9;
                case Formway_Entrance_Link:
                    return 10;
                case Formway_Turn_Right_LineA:
                    return 11;
                case Formway_Turn_Right_LineB:
                    return 12;
                case Formway_Turn_Left_LineA:
                    return 13;
                case Formway_Turn_Left_LineB:
                    return 14;
                case Formway_Common_Link:
                    return 15;
                case Formway_Turn_LeftRight_Line:
                    return 16;
                case Formway_ServiceJCT_Road:
                    return 53;
                case Formway_ServiceSlip_Road:
                    return 56;
                case Formway_ServiceSlipJCT_Road:
                    return 58;
            }
        } catch (Throwable th) {
            rx.c(th, "rObserver", "convertRoadType");
            return 1;
        }
    }

    private int a(int i2, int i3) {
        if (i3 == this.a) {
            return 10;
        }
        if (i3 == this.b) {
            return 15;
        }
        if (i2 == 13) {
            return 53;
        }
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return i2 + 1;
            case 9:
                return 51;
            case 10:
                return 52;
            default:
                return i2;
        }
    }

    @Override // com.autonavi.ae.route.observer.RouteObserver
    public final void onNewRoute(int i2, CalcRouteResult calcRouteResult, Object obj, boolean z) {
        if (this.j != null) {
            iw.a aVar = new iw.a();
            aVar.a = Integer.valueOf(i2);
            aVar.b = calcRouteResult;
            aVar.c = obj;
            this.j.obtainMessage(51, aVar).sendToTarget();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, CalcRouteResult calcRouteResult, Object obj) {
        try {
            String str = "MyRouteObserver-->onNewRoute(),type=" + i2 + ",count=" + calcRouteResult.nativeGetPathCount();
            if (this.f != null) {
                this.f.destroy();
                this.f = null;
            }
            this.i = -1;
            if (this.e != null) {
                this.e.a(System.currentTimeMillis());
            }
            this.f = a(calcRouteResult, i2);
            a(this.f, iu.e(), null, -1);
            this.l = new GNaviPath();
            int pathCount = this.f.getPathCount();
            this.l.pathPtrs = new long[pathCount];
            for (int i3 = 0; i3 < pathCount; i3++) {
                this.l.pathPtrs[i3] = this.f.getRoute(i3).getRouteId();
            }
            if (this.e != null) {
                this.l.pointAddr = this.e.p();
            }
            this.l.calRouteType = i2;
            AMapCalcRouteResult aMapCalcRouteResult = new AMapCalcRouteResult();
            if (i2 != 5) {
                switch (i2) {
                    case 1:
                        i2 = 0;
                        break;
                    case 2:
                        i2 = 1;
                        break;
                }
            } else {
                i2 = 2;
            }
            aMapCalcRouteResult.setCalcRouteType(i2);
            if (this.j != null && this.g != null && this.g.length > 0) {
                if (this.e != null) {
                    this.e.c(this.g[0]);
                    if (this.e.d != -1) {
                        if (!this.c) {
                            this.e.d(this.g[0]);
                            this.e.f(this.g[0]);
                        } else if (i2 == 14) {
                            this.e.o();
                        } else {
                            this.e.d(this.g[0]);
                            this.e.e(this.g[0]);
                        }
                    }
                }
                aMapCalcRouteResult.setRouteid(this.g);
                if (aMapCalcRouteResult.getCalcRouteType() != 14) {
                    this.j.obtainMessage(28, this.g).sendToTarget();
                    this.j.obtainMessage(40, aMapCalcRouteResult).sendToTarget();
                }
            } else if (!(this.j == null || aMapCalcRouteResult.getCalcRouteType() == 14)) {
                aMapCalcRouteResult.setErrorDetail("路线解析异常");
                aMapCalcRouteResult.setErrorCode(19);
                this.j.obtainMessage(29, 19).sendToTarget();
                this.j.obtainMessage(41, aMapCalcRouteResult).sendToTarget();
            }
            a(obj, true);
        } catch (Throwable th) {
            rx.c(th, "rObserver", "onNewRoute");
            th.printStackTrace();
        }
    }

    private CalcRouteResult a(CalcRouteResult calcRouteResult, int i2) {
        try {
            if (mf.e) {
                if (this.d != AMapNaviOnlineCarHailingType.TRANSPORT) {
                    if (this.d == AMapNaviOnlineCarHailingType.PICKUP) {
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < calcRouteResult.getPathCount(); i3++) {
                    Route route = calcRouteResult.getRoute(i3);
                    LineIconPoint[] lineIconPoints = route.getLineIconPoints();
                    if (lineIconPoints != null) {
                        int length = lineIconPoints.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= length) {
                                break;
                            }
                            LineIconPoint lineIconPoint = lineIconPoints[i4];
                            if (lineIconPoint.type != 1) {
                                if (lineIconPoint.type != 2) {
                                    i4++;
                                }
                            }
                            if (i2 != 14) {
                                if (calcRouteResult.getPathCount() - 1 == arrayList.size()) {
                                    break;
                                }
                            }
                            arrayList.add(Long.valueOf(route.getPathId()));
                            i4++;
                        }
                    }
                }
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    int i6 = 0;
                    while (true) {
                        if (i6 >= calcRouteResult.getPathCount()) {
                            break;
                        } else if (((Long) arrayList.get(i5)).longValue() == calcRouteResult.getRoute(i6).getPathId()) {
                            calcRouteResult.removePath((long) i6);
                            break;
                        } else {
                            i6++;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            rx.c(th, "rObserver", "checkOnlineCarHailingType");
            th.printStackTrace();
        }
        return calcRouteResult;
    }

    @Override // com.autonavi.ae.route.observer.RouteObserver
    public final void onNewRouteError(int i2, int i3, Object obj, boolean z) {
        if (this.j != null) {
            iw.a aVar = new iw.a();
            aVar.a = Integer.valueOf(i2);
            aVar.b = Integer.valueOf(i3);
            aVar.c = obj;
            this.j.obtainMessage(52, aVar).sendToTarget();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, int i3, Object obj) {
        int i4;
        int i5;
        try {
            String str = "MyRouteObserver-->onNewRouteError(),type=" + i2 + ",errorCode" + i3;
            if (i3 == 13) {
                if (this.i >= 0) {
                    i4 = this.i;
                } else {
                    i4 = 19;
                }
            } else if (i3 == 16) {
                i4 = 2;
            } else if (i3 == 19) {
                i4 = 20;
            } else if (i3 == 23) {
                i4 = 27;
            } else {
                i4 = i3;
            }
            AMapCalcRouteResult aMapCalcRouteResult = new AMapCalcRouteResult();
            if (i2 != 5) {
                switch (i2) {
                    case 1:
                        i5 = 0;
                        break;
                    case 2:
                        i5 = 1;
                        break;
                    default:
                        i5 = i2;
                        break;
                }
            } else {
                i5 = 2;
            }
            aMapCalcRouteResult.setCalcRouteType(i5);
            aMapCalcRouteResult.setErrorCode(i4);
            aMapCalcRouteResult.setErrorDetail("算路类型为：" + i2 + "算路错误码为：" + i3);
            jy.a("v3/ae8/driving", i4);
            a(obj, false);
            if (((i2 != 2 && i2 != 14) || i4 != 19) && this.j != null && i4 != 27 && aMapCalcRouteResult.getCalcRouteType() != 14) {
                this.j.obtainMessage(41, aMapCalcRouteResult).sendToTarget();
                this.j.obtainMessage(29, Integer.valueOf(i4)).sendToTarget();
            }
        } catch (Throwable th) {
            rx.c(th, "rObserver", "onNewRouteError");
        }
    }

    private void a(Object obj, boolean z) {
        boolean z2;
        String str;
        AMapCarInfo l2;
        try {
            boolean z3 = true;
            if (this.e == null || (l2 = this.e.l()) == null || !"1".equals(l2.getCarType())) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (obj != null) {
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    AMapNaviRouteNotifyData aMapNaviRouteNotifyData = new AMapNaviRouteNotifyData();
                    aMapNaviRouteNotifyData.setSuccess(z);
                    if (obj instanceof AvoidRestrictArea) {
                        AvoidRestrictArea avoidRestrictArea = (AvoidRestrictArea) obj;
                        aMapNaviRouteNotifyData.setNotifyType(1);
                        aMapNaviRouteNotifyData.setLatitude((double) avoidRestrictArea.lat);
                        aMapNaviRouteNotifyData.setLongitude((double) avoidRestrictArea.lon);
                        aMapNaviRouteNotifyData.setDistance(avoidRestrictArea.distance);
                        aMapNaviRouteNotifyData.setRoadName(avoidRestrictArea.roadName);
                        if (!TextUtils.isEmpty(avoidRestrictArea.policyName)) {
                            aMapNaviRouteNotifyData.setReason(avoidRestrictArea.policyName);
                        } else {
                            stringBuffer.append(avoidRestrictArea.roadName);
                            if (z2) {
                                stringBuffer.append("货车");
                            }
                            stringBuffer.append("限行");
                            aMapNaviRouteNotifyData.setReason(stringBuffer.toString());
                            stringBuffer.delete(0, stringBuffer.length());
                        }
                        if (avoidRestrictArea.distance <= 0 || z) {
                            aMapNaviRouteNotifyData.setSubTitle(b(z));
                        } else {
                            stringBuffer.append("距您");
                            stringBuffer.append(mj.a(avoidRestrictArea.distance));
                            aMapNaviRouteNotifyData.setSubTitle(stringBuffer.toString());
                            stringBuffer.delete(0, stringBuffer.length());
                        }
                        stringBuffer.append(b(avoidRestrictArea.distance));
                        stringBuffer.append(",");
                        stringBuffer.append(aMapNaviRouteNotifyData.getReason());
                        stringBuffer.append(",");
                        stringBuffer.append(b(z));
                        String stringBuffer2 = stringBuffer.toString();
                        stringBuffer.delete(0, stringBuffer.length());
                        a(aMapNaviRouteNotifyData, stringBuffer2);
                    }
                    if (obj instanceof ForbiddenInfo) {
                        ForbiddenInfo forbiddenInfo = (ForbiddenInfo) obj;
                        aMapNaviRouteNotifyData.setNotifyType(2);
                        aMapNaviRouteNotifyData.setLatitude((double) forbiddenInfo.lat);
                        aMapNaviRouteNotifyData.setLongitude((double) forbiddenInfo.lon);
                        aMapNaviRouteNotifyData.setDistance(forbiddenInfo.distance);
                        aMapNaviRouteNotifyData.setRoadName(forbiddenInfo.roadName);
                        String str2 = "";
                        switch (forbiddenInfo.action) {
                            case 1:
                                str2 = "左转";
                                break;
                            case 2:
                                str2 = "右转";
                                break;
                            case 3:
                                str2 = "向左前方行驶";
                                break;
                            case 4:
                                str2 = "向右前方行驶";
                                break;
                            case 5:
                                str2 = "向左后方行驶";
                                break;
                            case 6:
                                str2 = "向右后方行驶";
                                break;
                            case 7:
                                str2 = "左转调头";
                                break;
                            case 8:
                                str2 = "直行";
                                break;
                            case 9:
                                str2 = "靠左";
                                break;
                            case 10:
                                str2 = "靠右";
                                break;
                            case 11:
                                str2 = "进入环岛";
                                break;
                            case 12:
                                str2 = "离开环岛";
                                break;
                            case 13:
                                str2 = "减速行驶";
                                break;
                            case 14:
                                str2 = "插入直行（泛亚特有）";
                                break;
                        }
                        if (TextUtils.isEmpty(str2)) {
                            stringBuffer.append(forbiddenInfo.roadName);
                            stringBuffer.append("在禁行时段");
                        } else {
                            stringBuffer.append(forbiddenInfo.roadName);
                            stringBuffer.append("禁止");
                            if (z2) {
                                stringBuffer.append("货车");
                            }
                            stringBuffer.append(str2);
                        }
                        aMapNaviRouteNotifyData.setReason(stringBuffer.toString());
                        stringBuffer.delete(0, stringBuffer.length());
                        if (z) {
                            aMapNaviRouteNotifyData.setSubTitle(b(z));
                        } else {
                            long j2 = forbiddenInfo.startTime;
                            long j3 = forbiddenInfo.endTime;
                            int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
                            boolean z4 = i2 == 0 && j3 == 0;
                            if (i2 != 0 || j3 != 2400) {
                                z3 = false;
                            }
                            if (!z4) {
                                if (!z3) {
                                    str = a(j2) + " - " + a(j3);
                                    stringBuffer.append("禁行时间：");
                                    stringBuffer.append(str);
                                    aMapNaviRouteNotifyData.setSubTitle(stringBuffer.toString());
                                    stringBuffer.delete(0, stringBuffer.length());
                                }
                            }
                            str = "全天";
                            stringBuffer.append("禁行时间：");
                            stringBuffer.append(str);
                            aMapNaviRouteNotifyData.setSubTitle(stringBuffer.toString());
                            stringBuffer.delete(0, stringBuffer.length());
                        }
                        stringBuffer.append(b(forbiddenInfo.distance));
                        stringBuffer.append(",");
                        stringBuffer.append(aMapNaviRouteNotifyData.getReason());
                        stringBuffer.append(b(z));
                        String stringBuffer3 = stringBuffer.toString();
                        stringBuffer.delete(0, stringBuffer.length());
                        a(aMapNaviRouteNotifyData, stringBuffer3);
                    }
                    if (obj instanceof RoadClosedArea) {
                        RoadClosedArea roadClosedArea = (RoadClosedArea) obj;
                        aMapNaviRouteNotifyData.setNotifyType(3);
                        aMapNaviRouteNotifyData.setLatitude((double) roadClosedArea.lat);
                        aMapNaviRouteNotifyData.setLongitude((double) roadClosedArea.lon);
                        aMapNaviRouteNotifyData.setDistance(roadClosedArea.distance);
                        aMapNaviRouteNotifyData.setReason(TextUtils.isEmpty(roadClosedArea.title) ? "前方道路封闭" : roadClosedArea.title);
                        if (roadClosedArea.distance <= 0 || z) {
                            aMapNaviRouteNotifyData.setSubTitle(b(z));
                        } else {
                            stringBuffer.append("距您");
                            stringBuffer.append(mj.a(roadClosedArea.distance));
                            aMapNaviRouteNotifyData.setSubTitle(stringBuffer.toString());
                            stringBuffer.delete(0, stringBuffer.length());
                        }
                        stringBuffer.append(b(roadClosedArea.distance));
                        stringBuffer.append(",");
                        if (TextUtils.isEmpty(roadClosedArea.title)) {
                            stringBuffer.append("道路封闭");
                        } else {
                            stringBuffer.append(roadClosedArea.title);
                        }
                        stringBuffer.append(",");
                        stringBuffer.append(b(z));
                        String stringBuffer4 = stringBuffer.toString();
                        stringBuffer.delete(0, stringBuffer.length());
                        a(aMapNaviRouteNotifyData, stringBuffer4);
                    }
                    if (obj instanceof AvoidJamArea) {
                        AvoidJamArea avoidJamArea = (AvoidJamArea) obj;
                        aMapNaviRouteNotifyData.setNotifyType(4);
                        aMapNaviRouteNotifyData.setLatitude((double) avoidJamArea.lat);
                        aMapNaviRouteNotifyData.setLongitude((double) avoidJamArea.lon);
                        aMapNaviRouteNotifyData.setDistance(avoidJamArea.detourDis);
                        aMapNaviRouteNotifyData.setRoadName(avoidJamArea.roadName);
                        String str3 = "";
                        switch (avoidJamArea.type) {
                            case 101:
                            case 102:
                            case 104:
                                str3 = "事故";
                                break;
                            case 201:
                                str3 = "道路施工";
                                break;
                            case 202:
                                str3 = "施工";
                                break;
                            case 501:
                                str3 = "积水";
                                break;
                        }
                        if (TextUtils.isEmpty(str3)) {
                            stringBuffer.append("前方拥堵");
                        } else {
                            stringBuffer.append(avoidJamArea.roadName);
                            stringBuffer.append(str3);
                        }
                        aMapNaviRouteNotifyData.setReason(stringBuffer.toString());
                        stringBuffer.delete(0, stringBuffer.length());
                        String str4 = "";
                        int i3 = avoidJamArea.saveTime;
                        if (i3 > 0) {
                            stringBuffer.append("大约节省");
                            stringBuffer.append((i3 + 59) / 60);
                            stringBuffer.append("分钟");
                            str4 = stringBuffer.toString();
                            stringBuffer.delete(0, stringBuffer.length());
                        }
                        if (z) {
                            stringBuffer.append("新路线");
                            if (!TextUtils.isEmpty(str4)) {
                                stringBuffer.append(str4);
                            }
                            aMapNaviRouteNotifyData.setSubTitle(stringBuffer.toString());
                            stringBuffer.delete(0, stringBuffer.length());
                        } else {
                            aMapNaviRouteNotifyData.setSubTitle(b(z));
                        }
                        stringBuffer.append(aMapNaviRouteNotifyData.getReason());
                        stringBuffer.append(",");
                        if (z) {
                            stringBuffer.append("已选择更快路线");
                            if (!TextUtils.isEmpty(str4)) {
                                stringBuffer.append(str4);
                            }
                        } else {
                            stringBuffer.append(b(z));
                        }
                        a(aMapNaviRouteNotifyData, stringBuffer.toString());
                    }
                } catch (Throwable th) {
                    rx.c(th, "rObserver", "onRouteNotify");
                }
            }
        } catch (Throwable th2) {
            rx.c(th2, "rObserver", "callBackRouteNotify");
        }
    }

    private void a(AMapNaviRouteNotifyData aMapNaviRouteNotifyData, String str) {
        try {
            if (this.j != null) {
                if (aMapNaviRouteNotifyData != null) {
                    this.j.obtainMessage(44, aMapNaviRouteNotifyData).sendToTarget();
                }
                if (!TextUtils.isEmpty(str)) {
                    this.j.obtainMessage(17, str).sendToTarget();
                }
            }
        } catch (Throwable th) {
            rx.c(th, "rObserver", "sendRouteNotifyMessage");
        }
    }

    private static String a(long j2) {
        long j3 = j2 / 100;
        long j4 = j2 - (100 * j3);
        StringBuffer stringBuffer = new StringBuffer();
        if (j3 < 10) {
            stringBuffer.append("0");
        }
        stringBuffer.append(j3);
        stringBuffer.append(":");
        if (j4 < 10) {
            stringBuffer.append("0");
        }
        stringBuffer.append(j4);
        return stringBuffer.toString();
    }

    private static String b(boolean z) {
        if (z) {
            return "已为您避开";
        }
        return "已无法为您避开";
    }

    private static String b(int i2) {
        if (i2 <= 0) {
            return "当前";
        }
        return "前方" + mj.a(i2);
    }

    @Override // com.autonavi.ae.route.observer.HttpInterface
    public final boolean requestHttpGet(int i2, int i3, String str) {
        return false;
    }

    @Override // com.autonavi.ae.route.observer.HttpInterface
    public final boolean requestHttpPost(int i2, int i3, String str, byte[] bArr) {
        jg.a().execute(new a(i2, i3, bArr));
        return false;
    }

    /* compiled from: MyRouteObserver */
    class a implements Runnable {
        int a;
        int b;
        final byte[] c;

        public a(int i, int i2, byte[] bArr) {
            this.a = i;
            this.b = i2;
            this.c = bArr;
        }

        public final void run() {
            ty tyVar;
            iz izVar;
            try {
                int[] iArr = new int[2];
                switch (iu.g()) {
                    case 0:
                        iArr[0] = 0;
                        iArr[1] = 266280;
                        break;
                    case 1:
                        iArr[0] = 1;
                        iArr[1] = 790568;
                        break;
                    case 2:
                        iArr[0] = 2;
                        iArr[1] = 266280;
                        break;
                    case 3:
                        iArr[0] = 5;
                        iArr[1] = 266280;
                        break;
                    case 4:
                        iArr[0] = 4;
                        iArr[1] = 266280;
                        break;
                    case 5:
                        iArr[0] = 9;
                        iArr[1] = 266280;
                        break;
                    case 6:
                        iArr[0] = 0;
                        iArr[1] = 2363432;
                        break;
                    case 7:
                        iArr[0] = 1;
                        iArr[1] = 2363432;
                        break;
                    case 8:
                        iArr[0] = 12;
                        iArr[1] = 266280;
                        break;
                    case 9:
                        iArr[0] = 12;
                        iArr[1] = 2363432;
                        break;
                    case 10:
                        iArr[0] = 13;
                        iArr[1] = 8786040;
                        break;
                    case 11:
                        iArr[0] = 9;
                        iArr[1] = 8786040;
                        break;
                    case 12:
                        iArr[0] = 4;
                        iArr[1] = 8786040;
                        break;
                    case 13:
                        iArr[0] = 0;
                        iArr[1] = 10883192;
                        break;
                    case 14:
                        iArr[0] = 1;
                        iArr[1] = 8786040;
                        break;
                    case 15:
                        iArr[0] = 4;
                        iArr[1] = 10883192;
                        break;
                    case 16:
                        iArr[0] = 1;
                        iArr[1] = 10883192;
                        break;
                    case 17:
                        iArr[0] = 12;
                        iArr[1] = 8786040;
                        break;
                    case 18:
                        iArr[0] = 12;
                        iArr[1] = 10883192;
                        break;
                    case 19:
                        iArr[0] = 0;
                        iArr[1] = 8786042;
                        break;
                    case 20:
                        iArr[0] = 4;
                        iArr[1] = 8786042;
                        break;
                }
                int i = iArr[0];
                int i2 = iArr[1];
                String replaceFirst = new String(this.c, "UTF-8").replaceFirst("Type=\"4\" Flag=\"135352\"", "Type=\"" + i + "\" Flag=\"" + i2 + "\"").replaceFirst("Source=\"amap\"", "Source=\"amapapi\"");
                if (!replaceFirst.contains("app_key")) {
                    if (iy.this.e != null) {
                        replaceFirst = replaceFirst.replaceFirst("Source=\"amapapi\"", "Source=\"amapapi\" app_key=\"" + qy.f(iy.this.e.e()) + "\"");
                    }
                }
                String a2 = iv.a(this.a);
                String a3 = iy.this.a((iy) replaceFirst);
                String str = "MyRouteObserver-->requestHttpPost(请求参数)" + new String(a3.getBytes("UTF-8"), "UTF-8");
                if (this.a == 102) {
                    tyVar = iv.a(iy.this.e.e(), a2, this.a, a3.getBytes("UTF-8"));
                    iy.this.i = jy.b(a2, tyVar);
                } else {
                    tyVar = iv.a(iy.this.e.e(), a2, this.a, iv.a("1.0", a3.getBytes("UTF-8")));
                    iy.this.i = jy.a(a2, tyVar);
                }
                if (tyVar == null || tyVar.a == null) {
                    izVar = new iz(this.b, null);
                } else {
                    izVar = new iz(this.b, tyVar.a);
                }
                if (iy.this.k != null) {
                    iy.this.k.obtainMessage(1, izVar).sendToTarget();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                rx.c(th, "rObserver", "RouteTask run");
                if (iy.this.k != null) {
                    iy.this.k.obtainMessage(1, new iz(this.b, null)).sendToTarget();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String a(String str) {
        try {
            if (!mf.e || this.d != AMapNaviOnlineCarHailingType.TRANSPORT || !str.contains("Reroute=\"0\"") || str.contains("startpoint Type=\"2\"")) {
                return str;
            }
            return str.replaceFirst("location Type=\"[0-9]+\"", "location Type=\"4\"");
        } catch (Throwable th) {
            rx.c(th, "rObserver", "checkOnlineCarHailingType");
            return str;
        }
    }

    public final CalcRouteResult d() {
        return this.f;
    }

    public final void a(NaviPath naviPath, int i2) {
        a(this.f, iu.e(), naviPath, i2);
    }

    public final GNaviPath e() {
        return this.l;
    }

    public final void a(int i2) {
        iw iwVar = this.j;
        if (iwVar != null) {
            iwVar.obtainMessage(43, Integer.valueOf(i2)).sendToTarget();
        }
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public final void a(NaviPath[] naviPathArr) {
        try {
            if (this.e.c() != 2 && this.j != null) {
                this.j.obtainMessage(47, naviPathArr).sendToTarget();
            }
        } catch (Throwable th) {
            rx.c(th, "rObserver", "updateBackupPath");
        }
    }

    public final void a(AMapNaviOnlineCarHailingType aMapNaviOnlineCarHailingType) {
        this.d = aMapNaviOnlineCarHailingType;
    }
}
