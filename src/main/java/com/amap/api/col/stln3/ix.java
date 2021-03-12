package com.amap.api.col.stln3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import com.amap.api.col.stln3.iw;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.navi.AMapNaviListener;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapModelCross;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AMapNotAvoidInfo;
import com.amap.api.navi.model.AMapServiceAreaInfo;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.InnerNaviInfo;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviPath;
import com.autonavi.ae.guide.model.AsyncInfo;
import com.autonavi.ae.guide.model.CrossImageInfo;
import com.autonavi.ae.guide.model.CruiseCongestionInfo;
import com.autonavi.ae.guide.model.CruiseFacilityInfo;
import com.autonavi.ae.guide.model.CruiseInfo;
import com.autonavi.ae.guide.model.CruiseTimeAndDistInfo;
import com.autonavi.ae.guide.model.DriveEventTip;
import com.autonavi.ae.guide.model.ExitDirectionInfo;
import com.autonavi.ae.guide.model.LaneInfo;
import com.autonavi.ae.guide.model.ManeuverConfig;
import com.autonavi.ae.guide.model.ManeuverInfo;
import com.autonavi.ae.guide.model.NaviCamera;
import com.autonavi.ae.guide.model.NaviCongestionInfo;
import com.autonavi.ae.guide.model.NaviFacility;
import com.autonavi.ae.guide.model.NaviIntervalCameraDynamicInfo;
import com.autonavi.ae.guide.model.NaviStatisticsInfo;
import com.autonavi.ae.guide.model.ObtainInfo;
import com.autonavi.ae.guide.model.RouteTrafficEventInfo;
import com.autonavi.ae.guide.model.SoundInfo;
import com.autonavi.ae.guide.model.TMCIncidentReport;
import com.autonavi.ae.guide.model.TrafficEventInfo;
import com.autonavi.ae.guide.model.TrafficFacilityInfo;
import com.autonavi.ae.guide.observer.GCruiseObserver;
import com.autonavi.ae.guide.observer.GNaviObserver;
import com.autonavi.ae.guide.observer.GSoundPlayObserver;
import com.autonavi.ae.guide.observer.GStatusObserver;
import com.autonavi.ae.pos.LocInfo;
import com.autonavi.ae.pos.LocListener;
import com.autonavi.ae.pos.LocParallelRoadObserver;
import com.autonavi.ae.pos.LocParallelRoads;
import com.autonavi.ae.pos.LocParallelSwitchObserver;
import com.autonavi.ae.route.model.LightBarInfo;
import com.autonavi.ae.route.model.LightBarItem;
import com.autonavi.ae.route.model.RerouteOption;
import com.autonavi.ae.route.observer.HttpInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* compiled from: MyGuideObserver */
public final class ix implements GCruiseObserver, GNaviObserver, GSoundPlayObserver, GStatusObserver, LocListener, LocParallelRoadObserver, LocParallelSwitchObserver, HttpInterface {
    boolean a = true;
    boolean b = true;
    Bitmap c = null;
    byte[] d = null;
    int e = -14144457;
    LightBarItem[] f = null;
    AMapNaviLocation g = null;
    private it h;
    private iw i;
    private NaviInfo j;
    private int k = 0;
    private InnerNaviInfo l;
    private Handler m = null;
    private AMapNaviCameraInfo n;
    private AMapNaviCameraInfo o;
    private int p = 0;

    public final NaviInfo a() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public final InnerNaviInfo b() {
        return this.l;
    }

    public final void c() {
        this.h = null;
        this.j = null;
        this.l = null;
        this.m = null;
        this.f = null;
    }

    public final void d() {
        NaviInfo naviInfo = this.j;
        if (naviInfo != null) {
            naviInfo.setCurrentSpeed(0);
            this.j.setCurPoint(0);
            this.j.setCurLink(0);
            this.j.setCurStep(0);
            this.j.setCurPoint(0);
        }
    }

    public ix(it itVar) {
        try {
            this.h = itVar;
            this.j = new NaviInfo();
            this.l = new InnerNaviInfo();
            this.i = itVar.t();
            if (this.m == null) {
                this.m = new Handler(itVar.e().getMainLooper()) {
                    /* class com.amap.api.col.stln3.ix.AnonymousClass1 */

                    public final void handleMessage(Message message) {
                        super.handleMessage(message);
                        if (message.what == 21) {
                            try {
                                if (message.obj == null) {
                                    return;
                                }
                                if (ix.this.h != null) {
                                    iz izVar = (iz) message.obj;
                                    if (izVar.b != null) {
                                        ix.this.h.f().processHttpData(izVar.a, 200, izVar.b);
                                    } else {
                                        ix.this.h.f().processHttpError(izVar.a, 404);
                                    }
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                };
            }
        } catch (Throwable th) {
            rx.c(th, "MyGuideObserver", "init");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onUpdateNaviInfo(com.autonavi.ae.guide.model.NaviInfo[] naviInfoArr) {
        iw.a aVar = new iw.a();
        aVar.e = naviInfoArr;
        iw iwVar = this.i;
        if (iwVar != null) {
            iwVar.obtainMessage(59, aVar).sendToTarget();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(com.autonavi.ae.guide.model.NaviInfo[] naviInfoArr) {
        if (naviInfoArr != null) {
            try {
                if (naviInfoArr.length > 0) {
                    String str = "MyGuideObserver-->onUpdateNaviInfo " + naviInfoArr.length;
                    this.j.m_CurRoadName = naviInfoArr[0].curRouteName;
                    this.j.m_NextRoadName = naviInfoArr[0].nextRouteName;
                    this.j.m_RouteRemainDis = naviInfoArr[0].routeRemainDist;
                    this.j.m_RouteRemainTime = naviInfoArr[0].routeRemainTime;
                    this.j.m_SegRemainDis = naviInfoArr[0].segmentRemainDist;
                    this.j.m_SegRemainTime = naviInfoArr[0].segmentRemainTime;
                    if (naviInfoArr[0].maneuverID > 19) {
                        this.j.m_Icon = 9;
                    } else {
                        this.j.m_Icon = naviInfoArr[0].maneuverID;
                    }
                    if (this.h != null) {
                        this.j.m_Type = this.h.c();
                    }
                    String str2 = "MyGuideObserver-->onUpdateNaviInfo -->>> " + this.j.m_NextRoadName + ", distance is " + this.j.m_SegRemainDis;
                    this.j.notAvoidInfo = new AMapNotAvoidInfo(naviInfoArr[0].notAvoidInfo);
                    this.j.setIconBitmap(this.c);
                    this.l.setDriveDist(naviInfoArr[0].driveDist);
                    this.l.setDriveTime(naviInfoArr[0].driveTime);
                    this.l.setIconBitmap(this.c);
                    this.l.setIconData(this.d);
                    InnerNaviInfo[] innerNaviInfoArr = new InnerNaviInfo[naviInfoArr.length];
                    int i2 = 0;
                    for (com.autonavi.ae.guide.model.NaviInfo naviInfo : naviInfoArr) {
                        innerNaviInfoArr[i2] = new InnerNaviInfo();
                        innerNaviInfoArr[i2].setPathRetainDistance(naviInfo.routeRemainDist);
                        innerNaviInfoArr[i2].setPathRetainTime(naviInfo.routeRemainTime);
                        innerNaviInfoArr[i2].setPathid(naviInfo.pathID);
                        innerNaviInfoArr[i2].setCurStep(naviInfo.curSegIdx);
                        innerNaviInfoArr[i2].setCurLink(naviInfo.curLinkIdx);
                        i2++;
                    }
                    if (this.i != null) {
                        this.i.obtainMessage(1, this.j).sendToTarget();
                        this.l.setInnerNaviInfo(this.j);
                        this.i.obtainMessage(27, this.l).sendToTarget();
                        this.i.obtainMessage(60, innerNaviInfoArr).sendToTarget();
                    }
                }
            } catch (Throwable th) {
                rx.c(th, "MyGuideObserver", "onUpdateNaviInfo");
                th.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onShowCrossImage(CrossImageInfo crossImageInfo) {
        iw iwVar = this.i;
        if (iwVar != null) {
            iwVar.obtainMessage(54, crossImageInfo).sendToTarget();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(CrossImageInfo crossImageInfo) {
        try {
            String str = "MyGuideObserver-->onShowCrossImage() type is " + crossImageInfo.type;
            this.k = crossImageInfo.type;
            if (this.k == 1) {
                AMapNaviCross aMapNaviCross = new AMapNaviCross(this.k, crossImageInfo.dataBuf, crossImageInfo.arrowDataBuf);
                if (this.b) {
                    this.i.obtainMessage(25).sendToTarget();
                    this.b = false;
                }
                this.i.obtainMessage(2, aMapNaviCross).sendToTarget();
                this.a = true;
            } else if (this.k != 3) {
            } else {
                if (!"6.4.0".equals(MapsInitializer.getVersion()) || Build.VERSION.SDK_INT >= 21) {
                    if (this.a) {
                        this.i.obtainMessage(3).sendToTarget();
                        this.a = false;
                    }
                    this.b = true;
                    this.i.obtainMessage(24, new AMapModelCross(crossImageInfo.dataBuf)).sendToTarget();
                }
            }
        } catch (Throwable th) {
            rx.c(th, "MyGuideObserver", "onShowCrossImage");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onShowNaviCrossTMC(byte[] bArr, int i2) {
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onHideCrossImage() {
        try {
            if (this.i != null) {
                if (this.k == 1) {
                    this.i.obtainMessage(3).sendToTarget();
                    this.a = false;
                }
                if (this.k != 3) {
                    return;
                }
                if (!"6.4.0".equals(MapsInitializer.getVersion()) || Build.VERSION.SDK_INT >= 21) {
                    this.b = false;
                    this.i.obtainMessage(25).sendToTarget();
                }
            }
        } catch (Throwable th) {
            rx.c(th, "MyGuideObserver", "onHideCrossImage");
        }
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onShowNaviLaneInfo(LaneInfo laneInfo) {
        if (laneInfo != null) {
            try {
                AMapLaneInfo aMapLaneInfo = new AMapLaneInfo(laneInfo);
                iw.a aVar = new iw.a();
                aVar.a = aMapLaneInfo;
                this.i.obtainMessage(39, aVar).sendToTarget();
                byte[] bArr = new byte[8];
                byte[] bArr2 = new byte[8];
                for (int i2 = 0; i2 < 8; i2++) {
                    bArr[i2] = 15;
                    bArr2[i2] = 15;
                }
                for (int i3 = 0; i3 < laneInfo.backLane.length; i3++) {
                    bArr[i3] = laneInfo.backLane[i3] > 15 ? 15 : (byte) laneInfo.backLane[i3];
                }
                for (int i4 = 0; i4 < laneInfo.frontLane.length; i4++) {
                    bArr2[i4] = laneInfo.frontLane[i4] > 15 ? 15 : (byte) laneInfo.frontLane[i4];
                }
                AMapLaneInfo[] a2 = a(bArr, bArr2, laneInfo.pointLat, laneInfo.pointLon);
                iw.a aVar2 = new iw.a();
                aVar2.a = bArr;
                aVar2.b = bArr2;
                aVar2.c = a2;
                this.i.obtainMessage(4, aVar2).sendToTarget();
            } catch (Throwable th) {
                rx.c(th, "MyGuideObserver", "onShowNaviLaneInfo");
                th.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onHideNaviLaneInfo() {
        try {
            if (this.i != null) {
                this.i.obtainMessage(5).sendToTarget();
            }
        } catch (Throwable th) {
            rx.c(th, "MyGuideObserver", "onHideNaviLaneInfo");
            th.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x004b A[Catch:{ Throwable -> 0x0071 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0053 A[Catch:{ Throwable -> 0x0071 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.amap.api.navi.model.AMapLaneInfo[] a(byte[] r7, byte[] r8, double r9, double r11) {
        /*
        // Method dump skipped, instructions count: 123
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ix.a(byte[], byte[], double, double):com.amap.api.navi.model.AMapLaneInfo[]");
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onShowNaviManeuver(ManeuverInfo maneuverInfo) {
        iw iwVar = this.i;
        if (iwVar != null) {
            iwVar.obtainMessage(57, maneuverInfo).sendToTarget();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(ManeuverInfo maneuverInfo) {
        try {
            if (maneuverInfo.type == 1) {
                ManeuverConfig maneuverConfig = new ManeuverConfig();
                AsyncInfo asyncInfo = new AsyncInfo();
                maneuverConfig.width = 255;
                maneuverConfig.height = 255;
                maneuverConfig.backColor = 2632759;
                maneuverConfig.roadColor = 5790310;
                maneuverConfig.arrowColor = ViewCompat.MEASURED_SIZE_MASK;
                maneuverConfig.pathID = maneuverInfo.pathID;
                maneuverConfig.maneuverID = maneuverInfo.maneuverID;
                maneuverConfig.segmentIdx = maneuverInfo.segmentIndex;
                asyncInfo.obj = maneuverConfig;
                asyncInfo.what = 2;
                this.h.f().obtainAsyncInfo(asyncInfo);
                return;
            }
            this.c = null;
            this.l.setIconData(null);
            this.l.setIconBitmap(null);
            if (maneuverInfo.maneuverID > 19) {
                this.j.setIconType(9);
            } else {
                this.j.setIconType(maneuverInfo.maneuverID);
            }
        } catch (Throwable th) {
            rx.c(th, "MyGuideObserver", "onShowNaviManeuver");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onObtainAsyncInfo(ObtainInfo obtainInfo) {
        iw iwVar = this.i;
        if (iwVar != null) {
            iwVar.obtainMessage(58, obtainInfo).sendToTarget();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(ObtainInfo obtainInfo) {
        if (obtainInfo != null) {
            try {
                if (obtainInfo.what != 2) {
                    int i2 = obtainInfo.what;
                } else if (obtainInfo.pData != null) {
                    this.d = obtainInfo.pData;
                    this.l.setIconData(this.d);
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(this.d, 0, this.d.length);
                    int width = decodeByteArray.getWidth();
                    int height = decodeByteArray.getHeight();
                    int[] iArr = new int[(width * height)];
                    decodeByteArray.getPixels(iArr, 0, width, 0, 0, width, height);
                    for (int i3 = 0; i3 < iArr.length; i3++) {
                        int i4 = iArr[i3];
                        if (i4 == this.e) {
                            iArr[i3] = Color.argb(0, Color.red(i4), Color.green(i4), Color.blue(i4));
                        }
                    }
                    decodeByteArray.recycle();
                    this.c = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                    this.l.setIconBitmap(this.c);
                } else {
                    this.c = null;
                    this.l.setIconData(null);
                    this.l.setIconBitmap(null);
                }
            } catch (Throwable th) {
                rx.c(th, "MyGuideObserver", "onObtainAsyncInfo");
            }
        }
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onUpdateTMCLightBar(LightBarInfo[] lightBarInfoArr, int i2, int i3) {
        if (lightBarInfoArr != null && i3 != 0 && this.i != null) {
            iw.a aVar = new iw.a();
            aVar.d = lightBarInfoArr;
            this.i.obtainMessage(7, aVar).sendToTarget();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(LightBarInfo[] lightBarInfoArr) {
        LightBarItem[] lightBarItemArr = null;
        try {
            long q = this.h.q();
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= lightBarInfoArr.length) {
                    break;
                } else if (lightBarInfoArr[i2].pathID == q) {
                    lightBarItemArr = lightBarInfoArr[i2].items;
                    break;
                } else {
                    i2++;
                }
            }
            if (lightBarItemArr != null) {
                if (lightBarItemArr != null) {
                    try {
                        if (lightBarItemArr.length > 0 && this.f != null && this.f.length > 0 && this.f.length == lightBarItemArr.length) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= lightBarItemArr.length) {
                                    break;
                                } else if (lightBarItemArr[i3].length == this.f[i3].length && lightBarItemArr[i3].status == this.f[i3].status) {
                                    i3++;
                                }
                            }
                            if (i3 == lightBarItemArr.length) {
                                z = true;
                            }
                            if (z) {
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                this.f = lightBarItemArr;
                this.h.a(lightBarItemArr);
                if (this.h.m() != null && System.currentTimeMillis() - this.h.r() >= 10000) {
                    for (AMapNaviListener aMapNaviListener : this.i.a) {
                        try {
                            aMapNaviListener.onTrafficStatusUpdate();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            rx.c(th3, "MyGuideObserver", "onUpdateTMCLightBar");
            th3.printStackTrace();
        }
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onUpdateTMCCongestionInfo(NaviCongestionInfo naviCongestionInfo) {
        if (naviCongestionInfo != null) {
            try {
                if (this.i != null) {
                    this.i.obtainMessage(42, naviCongestionInfo).sendToTarget();
                }
            } catch (Throwable th) {
                mj.a(th);
                rx.c(th, "gObserver", "updateNoNaviCongestionInfo");
            }
        }
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onUpdateSAPA(NaviFacility[] naviFacilityArr) {
        if (naviFacilityArr != null) {
            try {
                AMapServiceAreaInfo[] aMapServiceAreaInfoArr = new AMapServiceAreaInfo[naviFacilityArr.length];
                for (int i2 = 0; i2 < naviFacilityArr.length; i2++) {
                    aMapServiceAreaInfoArr[i2] = new AMapServiceAreaInfo(naviFacilityArr[i2]);
                }
                this.i.obtainMessage(8, aMapServiceAreaInfoArr).sendToTarget();
            } catch (Throwable th) {
                rx.c(th, "gObserver", "onUpdateSAPA");
                th.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onNaviStop(int i2) {
        try {
            String str = "MyGuideObserver-->navigationEnd(" + i2 + ")";
            if (this.i != null) {
                int i3 = 0;
                if (i2 == 1) {
                    i3 = 2;
                }
                if (i2 == 0) {
                    i3 = 1;
                }
                this.c = null;
                iu.a((LocInfo) null);
                d();
                this.i.obtainMessage(9, Integer.valueOf(i3)).sendToTarget();
            }
        } catch (Throwable th) {
            rx.c(th, "gObserver", "onNaviStop");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onUpdateViaPass(int i2) {
        try {
            String str = "MyGuideObserver-->arrayViaPoint(" + i2 + ")";
            if (this.i != null) {
                this.i.obtainMessage(10, Integer.valueOf(i2)).sendToTarget();
            }
        } catch (Throwable th) {
            rx.c(th, "gObserver", "onUpdateViaPass");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onShowNaviCamera(NaviCamera[] naviCameraArr) {
        int i2 = 0;
        if (naviCameraArr == null) {
            try {
                this.i.obtainMessage(11, new AMapNaviCameraInfo[0]).sendToTarget();
            } catch (Throwable th) {
                th.printStackTrace();
                rx.c(th, "gObserver", "onShowNaviCamera");
            }
        } else {
            ArrayList arrayList = new ArrayList(Arrays.asList(naviCameraArr));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                NaviCamera naviCamera = (NaviCamera) it.next();
                if (naviCamera != null) {
                    if (naviCamera.type == 0 && naviCamera.speed != null && naviCamera.speed.length > 0 && naviCamera.speed[0] == 0) {
                        it.remove();
                    }
                }
            }
            NaviCamera[] naviCameraArr2 = (NaviCamera[]) arrayList.toArray(new NaviCamera[0]);
            AMapNaviCameraInfo[] aMapNaviCameraInfoArr = new AMapNaviCameraInfo[naviCameraArr2.length];
            for (int i3 = 0; i3 < naviCameraArr2.length; i3++) {
                aMapNaviCameraInfoArr[i3] = new AMapNaviCameraInfo(naviCameraArr2[i3]);
            }
            if (this.j != null) {
                NaviInfo naviInfo = this.j;
                if (aMapNaviCameraInfoArr.length > 0) {
                    i2 = aMapNaviCameraInfoArr[0].getCameraSpeed();
                }
                naviInfo.setLimitSpeed(i2);
            }
            this.i.obtainMessage(11, aMapNaviCameraInfoArr).sendToTarget();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021 A[Catch:{ Throwable -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002b A[Catch:{ Throwable -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0051 A[Catch:{ Throwable -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onShowNaviIntervalCamera(com.autonavi.ae.guide.model.NaviIntervalCamera[] r5) {
        /*
        // Method dump skipped, instructions count: 125
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ix.onShowNaviIntervalCamera(com.autonavi.ae.guide.model.NaviIntervalCamera[]):void");
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onUpdateIntervalCameraDynamicInfo(NaviIntervalCameraDynamicInfo[] naviIntervalCameraDynamicInfoArr) {
        if (naviIntervalCameraDynamicInfoArr != null) {
            try {
                if (naviIntervalCameraDynamicInfoArr.length > 0 && this.o != null && this.p == 2) {
                    this.o.update(naviIntervalCameraDynamicInfoArr[0]);
                    iw.a aVar = new iw.a();
                    aVar.a = this.n;
                    aVar.b = this.o;
                    aVar.c = 2;
                    this.i.obtainMessage(37, aVar).sendToTarget();
                }
            } catch (Throwable th) {
                rx.c(th, "gObserver", "onUpdateIntervalCameraDynamicInfo");
            }
        }
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onReroute(RerouteOption rerouteOption) {
        try {
            if (rerouteOption.getRerouteType() == 2) {
                if (this.i != null) {
                    this.i.obtainMessage(30).sendToTarget();
                }
            }
            if (rerouteOption.getRerouteType() == 5) {
                if (this.i != null) {
                    this.i.obtainMessage(31).sendToTarget();
                }
            }
            if (this.i != null) {
                this.i.obtainMessage(53, rerouteOption).sendToTarget();
            }
        } catch (Throwable th) {
            rx.c(th, "gObserver", "onReroute");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.ae.guide.observer.GSoundPlayObserver
    public final boolean isPlaying() {
        return mj.a;
    }

    @Override // com.autonavi.ae.guide.observer.GSoundPlayObserver
    public final void onPlayTTS(SoundInfo soundInfo) {
        try {
            if (this.i != null) {
                this.i.obtainMessage(17, soundInfo.text).sendToTarget();
            }
        } catch (Throwable th) {
            rx.c(th, "gObserver", "onPlayTTS");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.ae.guide.observer.GSoundPlayObserver
    public final void onPlayRing(int i2) {
        String str = "MyGuideObserver-->onPlayRing(" + i2 + ")";
        iw iwVar = this.i;
        if (iwVar != null) {
            iwVar.obtainMessage(23, Integer.valueOf(i2)).sendToTarget();
        }
    }

    @Override // com.autonavi.ae.guide.observer.GCruiseObserver
    public final void onUpdateCruiseFacility(CruiseFacilityInfo[] cruiseFacilityInfoArr) {
        try {
            AMapNaviTrafficFacilityInfo[] aMapNaviTrafficFacilityInfoArr = new AMapNaviTrafficFacilityInfo[cruiseFacilityInfoArr.length];
            for (int i2 = 0; i2 < aMapNaviTrafficFacilityInfoArr.length; i2++) {
                aMapNaviTrafficFacilityInfoArr[i2] = new AMapNaviTrafficFacilityInfo(new TrafficFacilityInfo(cruiseFacilityInfoArr[i2]));
            }
            if (this.i != null) {
                this.i.obtainMessage(18, aMapNaviTrafficFacilityInfoArr).sendToTarget();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "gObserver", "onUpdateCruiseFacility");
        }
    }

    @Override // com.autonavi.ae.guide.observer.GCruiseObserver
    public final void onUpdateCruiseInfo(CruiseInfo cruiseInfo) {
        String str = "MyGuideObserver-->updateCruiseInfo(" + cruiseInfo.roadName + ")";
    }

    @Override // com.autonavi.ae.guide.observer.GCruiseObserver
    public final void onUpdateCruiseCongestionInfo(CruiseCongestionInfo cruiseCongestionInfo) {
        try {
            AimLessModeCongestionInfo aimLessModeCongestionInfo = new AimLessModeCongestionInfo(cruiseCongestionInfo);
            if (this.i != null) {
                this.i.obtainMessage(20, aimLessModeCongestionInfo).sendToTarget();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "gObserver", "onUpdateCruiseCongestionInfo");
        }
    }

    @Override // com.autonavi.ae.guide.observer.GCruiseObserver
    public final void onShowCruiseLaneInfo(LaneInfo laneInfo) {
    }

    @Override // com.autonavi.ae.guide.observer.GCruiseObserver
    public final void onUpdateCruiseTimeAndDist(CruiseTimeAndDistInfo cruiseTimeAndDistInfo) {
        try {
            AimLessModeStat aimLessModeStat = new AimLessModeStat(cruiseTimeAndDistInfo);
            if (this.i != null) {
                this.i.obtainMessage(19, aimLessModeStat).sendToTarget();
            }
        } catch (Throwable th) {
            rx.c(th, "gObserver", "onUpdateCruiseTimeAndDist");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.ae.guide.observer.GCruiseObserver
    public final void onUpdateElecCameraInfo(CruiseFacilityInfo[] cruiseFacilityInfoArr) {
    }

    @Override // com.autonavi.ae.route.observer.HttpInterface
    public final boolean requestHttpPost(int i2, int i3, String str, byte[] bArr) {
        jg.a().execute(new a(i2, i3, bArr));
        return false;
    }

    /* compiled from: MyGuideObserver */
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
            iz izVar;
            try {
                String str = "MyGuideObserver-->requestHttpPost(),moduleId=" + this.a + ",TheadName=" + Thread.currentThread().getName() + ",reqId=" + this.b + ",data=" + new String(this.c, "UTF-8");
                byte[] bArr = this.c;
                if (3 != this.a) {
                    bArr = iv.a("1.0", this.c);
                }
                String a2 = iv.a(this.a);
                if (a2 == null) {
                    return;
                }
                if (a2.length() != 0) {
                    ty a3 = iv.a(ix.this.h.e(), a2, this.a, bArr);
                    if (a3 == null || a3.a == null) {
                        izVar = new iz(this.b, null);
                    } else {
                        izVar = new iz(this.b, a3.a);
                    }
                    if (ix.this.m != null) {
                        ix.this.m.obtainMessage(21, izVar).sendToTarget();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                rx.c(th, "gObserver", "GuideTask run(" + this.a + "," + this.b + ")");
                if (ix.this.m != null) {
                    ix.this.m.obtainMessage(21, new iz(this.b, null)).sendToTarget();
                }
            }
        }
    }

    @Override // com.autonavi.ae.pos.LocListener
    public final void updateNaviInfo(LocInfo locInfo) {
        AMapNaviLocation a2 = a(locInfo);
        iw iwVar = this.i;
        if (iwVar != null) {
            iwVar.obtainMessage(22, a2).sendToTarget();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x00ba A[Catch:{ Throwable -> 0x0113 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.amap.api.navi.model.AMapNaviLocation a(com.autonavi.ae.pos.LocInfo r14) {
        /*
        // Method dump skipped, instructions count: 288
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ix.a(com.autonavi.ae.pos.LocInfo):com.amap.api.navi.model.AMapNaviLocation");
    }

    @Override // com.autonavi.ae.pos.LocParallelRoadObserver
    public final void updateParallelRoad(LocParallelRoads locParallelRoads) {
        if (locParallelRoads != null) {
            int i2 = locParallelRoads.nFlag;
            iw iwVar = this.i;
            if (iwVar != null) {
                iwVar.obtainMessage(6, Integer.valueOf(i2)).sendToTarget();
            }
        }
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onCarOnRouteAgain() {
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onChangeNaviPath(long j2) {
        try {
            if (this.i != null) {
                this.i.obtainMessage(55, Long.valueOf(j2)).sendToTarget();
            }
        } catch (Throwable th) {
            rx.c(th, "gObserver", "onChangeNaviPath");
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a A[Catch:{ Throwable -> 0x018d }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x011a A[Catch:{ Throwable -> 0x018d }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x015d A[Catch:{ Throwable -> 0x018d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(long[] r18) {
        /*
        // Method dump skipped, instructions count: 408
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ix.a(long[]):void");
    }

    /* access modifiers changed from: package-private */
    public final void a(long j2) {
        int i2 = 12;
        try {
            if (!(this.h == null || this.h.b == null)) {
                Map<Integer, NaviPath> a2 = this.h.b.a();
                NaviPath[] naviPathArr = null;
                if (a2.size() > 1) {
                    naviPathArr = new NaviPath[(a2.size() - 1)];
                }
                int i3 = 0;
                if (a2 != null) {
                    for (Map.Entry<Integer, NaviPath> entry : a2.entrySet()) {
                        if (j2 == entry.getValue().getPathId()) {
                            i2 = entry.getKey().intValue();
                            this.h.d(i2);
                        } else if (naviPathArr != null && naviPathArr.length > 0) {
                            naviPathArr[i3] = entry.getValue();
                            i3++;
                        }
                    }
                }
                if (naviPathArr != null && naviPathArr.length > 0) {
                    this.h.b.a(naviPathArr);
                }
            }
            if (this.i != null) {
                this.i.obtainMessage(45, Integer.valueOf(i2)).sendToTarget();
            }
        } catch (Throwable th) {
            rx.c(th, "gObserver", "changeNaviPath");
        }
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onDeletePath(long[] jArr) {
        try {
            if (this.i != null) {
                this.i.obtainMessage(46, jArr).sendToTarget();
            }
        } catch (Throwable th) {
            rx.c(th, "gObserver", "onDeletePath");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onDriveReport(String str, NaviStatisticsInfo naviStatisticsInfo) {
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onHideTMCIncidentReport(int i2) {
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onPassLast3DSegment() {
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onSelectMainPathStatus(long j2, int i2) {
        if (i2 == 1) {
            try {
                if (this.i != null) {
                    this.i.obtainMessage(48, Long.valueOf(j2)).sendToTarget();
                }
            } catch (Throwable th) {
                rx.c(th, "gObserver", "onSelectMainPathStatus");
            }
        }
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onShowDriveEventTip(DriveEventTip[] driveEventTipArr) {
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onShowTMCIncidentReport(TMCIncidentReport tMCIncidentReport) {
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onSuggestChangePath(long j2, long j3, int i2) {
        try {
            Bundle bundle = new Bundle();
            bundle.putLong("newpathid", j2);
            bundle.putLong("oldpathid", j3);
            bundle.putInt("reason", i2);
            if (this.i != null) {
                this.i.obtainMessage(50, bundle).sendToTarget();
            }
        } catch (Throwable th) {
            rx.c(th, "gObserver", "onSuggestChangePath");
        }
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onUpdateExitDirectionInfo(ExitDirectionInfo exitDirectionInfo) {
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onUpdateIsSupportSimple3D(boolean z) {
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onUpdateSocolText(String str) {
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onUpdateTREvent(TrafficEventInfo[] trafficEventInfoArr, int i2) {
    }

    @Override // com.autonavi.ae.guide.observer.GNaviObserver
    public final void onUpdateTRPlayView(RouteTrafficEventInfo routeTrafficEventInfo) {
    }

    @Override // com.autonavi.ae.route.observer.HttpInterface
    public final boolean requestHttpGet(int i2, int i3, String str) {
        return false;
    }

    @Override // com.autonavi.ae.guide.observer.GCruiseObserver
    public final void onHideCruiseLaneInfo() {
    }

    @Override // com.autonavi.ae.guide.observer.GStatusObserver
    public final void onTbtStatusChanged(int i2, int i3) {
    }

    @Override // com.autonavi.ae.pos.LocParallelSwitchObserver
    public final void switchParallelRoadFinished() {
        iw iwVar = this.i;
        if (iwVar != null) {
            iwVar.obtainMessage(56).sendToTarget();
        }
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        try {
            RerouteOption rerouteOption = new RerouteOption();
            rerouteOption.setRerouteType(4);
            this.h.reCalculateRoute(rerouteOption, false);
        } catch (Throwable th) {
        }
    }
}
