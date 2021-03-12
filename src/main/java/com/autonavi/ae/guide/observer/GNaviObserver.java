package com.autonavi.ae.guide.observer;

import com.autonavi.ae.guide.model.CrossImageInfo;
import com.autonavi.ae.guide.model.DriveEventTip;
import com.autonavi.ae.guide.model.ExitDirectionInfo;
import com.autonavi.ae.guide.model.LaneInfo;
import com.autonavi.ae.guide.model.ManeuverInfo;
import com.autonavi.ae.guide.model.NaviCamera;
import com.autonavi.ae.guide.model.NaviCongestionInfo;
import com.autonavi.ae.guide.model.NaviFacility;
import com.autonavi.ae.guide.model.NaviInfo;
import com.autonavi.ae.guide.model.NaviIntervalCamera;
import com.autonavi.ae.guide.model.NaviIntervalCameraDynamicInfo;
import com.autonavi.ae.guide.model.NaviStatisticsInfo;
import com.autonavi.ae.guide.model.ObtainInfo;
import com.autonavi.ae.guide.model.RouteTrafficEventInfo;
import com.autonavi.ae.guide.model.TMCIncidentReport;
import com.autonavi.ae.guide.model.TrafficEventInfo;
import com.autonavi.ae.route.model.LightBarInfo;
import com.autonavi.ae.route.model.RerouteOption;

public interface GNaviObserver {
    void onCarOnRouteAgain();

    void onChangeNaviPath(long j);

    void onDeletePath(long[] jArr);

    void onDriveReport(String str, NaviStatisticsInfo naviStatisticsInfo);

    void onHideCrossImage();

    void onHideNaviLaneInfo();

    void onHideTMCIncidentReport(int i);

    void onNaviStop(int i);

    void onObtainAsyncInfo(ObtainInfo obtainInfo);

    void onPassLast3DSegment();

    void onReroute(RerouteOption rerouteOption);

    void onSelectMainPathStatus(long j, int i);

    void onShowCrossImage(CrossImageInfo crossImageInfo);

    void onShowDriveEventTip(DriveEventTip[] driveEventTipArr);

    void onShowNaviCamera(NaviCamera[] naviCameraArr);

    void onShowNaviCrossTMC(byte[] bArr, int i);

    void onShowNaviIntervalCamera(NaviIntervalCamera[] naviIntervalCameraArr);

    void onShowNaviLaneInfo(LaneInfo laneInfo);

    void onShowNaviManeuver(ManeuverInfo maneuverInfo);

    void onShowTMCIncidentReport(TMCIncidentReport tMCIncidentReport);

    void onSuggestChangePath(long j, long j2, int i);

    void onUpdateExitDirectionInfo(ExitDirectionInfo exitDirectionInfo);

    void onUpdateIntervalCameraDynamicInfo(NaviIntervalCameraDynamicInfo[] naviIntervalCameraDynamicInfoArr);

    void onUpdateIsSupportSimple3D(boolean z);

    void onUpdateNaviInfo(NaviInfo[] naviInfoArr);

    void onUpdateSAPA(NaviFacility[] naviFacilityArr);

    void onUpdateSocolText(String str);

    void onUpdateTMCCongestionInfo(NaviCongestionInfo naviCongestionInfo);

    void onUpdateTMCLightBar(LightBarInfo[] lightBarInfoArr, int i, int i2);

    void onUpdateTREvent(TrafficEventInfo[] trafficEventInfoArr, int i);

    void onUpdateTRPlayView(RouteTrafficEventInfo routeTrafficEventInfo);

    void onUpdateViaPass(int i);
}
