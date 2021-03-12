package com.autonavi.rtbt;

public class RTBT {
    public static native String getVersion();

    public native void destroy();

    public native int errorPointReport(int i, double d, double d2);

    public native int[] getAllRouteID();

    public native int getConfirmReroute();

    public native double[] getEndCoor();

    public native String getEndPoiID();

    public native String getEndPoiName();

    public native double[] getLinkCoor(int i, int i2);

    public native int getLinkFormWay(int i, int i2);

    public native int getLinkIOFlag(int i, int i2);

    public native int getLinkIsBranched(int i, int i2);

    public native int getLinkLength(int i, int i2);

    public native int getLinkRoadClass(int i, int i2);

    public native String getLinkRoadName(int i, int i2);

    public native int getLinkTime(int i, int i2);

    public native int getLinkType(int i, int i2);

    public native RMileageInfo getMileageInfo();

    public native NaviGuideItem[] getNaviGuideList();

    public native NaviGuideItem[] getNaviGuideSplitList();

    public native String getNaviID();

    public native NaviStaticInfo getNaviStaticInfo();

    public native GPSDataInfo[] getRecentGPS(int i, int i2, int i3);

    public native int getRouteCrossingCount();

    public native RPoint[] getRouteHawkEyePoints();

    public native int getRouteLength();

    public native RMilestone[] getRouteMilestones();

    public native RPushSection[] getRoutePushSections();

    public native RPoint[] getRouteSearchPoints();

    public native int getRouteStrategy();

    public native String getRouteText();

    public native int getRouteTime();

    public native int getRouteTravelTime();

    public native int getSegChargeLength(int i);

    public native double[] getSegCoor(int i);

    public native int getSegIndoor(int i);

    public native int getSegLength(int i);

    public native int getSegLinkNum(int i);

    public native int getSegNum();

    public native int getSegTime(int i);

    public native int getSegTollCost(int i);

    public native double[] getStartCoor();

    public native int getStartDirection();

    public native String getStartPoiID();

    public native String getStartPoiName();

    public native int haveTrafficLights(int i, int i2);

    public native int init(IFrameForRTBT iFrameForRTBT, String str, String str2, String str3, String str4, String str5);

    public native void pauseNavi();

    public native int playNaviManual();

    public native int pushRouteData(int i, int i2, byte[] bArr, int i3);

    public native void receiveNetData(int i, int i2, byte[] bArr, int i3);

    public native int requestRoute(int i, int i2, int i3, double[] dArr, int i4, double[] dArr2);

    public native int requestRoutePoi(int i, int i2, RPoiPoint[] rPoiPointArr, RPoiPoint[] rPoiPointArr2);

    public native int requestRouteWithStart(int i, int i2, int i3, double[] dArr, int i4, double[] dArr2, int i5, double[] dArr3);

    public native int reroute(int i, int i2);

    public native void resumeNavi();

    public native int selectRoute(int i);

    public native void setCarLocation(int i, double d, double d2);

    public native void setEmulatorSpeed(int i);

    public native void setGPSInfo(int i, int i2, double d, double d2, double d3, double d4, double d5, int i3, int i4, int i5, int i6, int i7, int i8);

    public native void setNaviEnd(int i, double d, double d2);

    public native void setNaviEndPoi(RPoiPoint rPoiPoint);

    public native void setNetRequestState(int i, int i2, int i3);

    public native int setParam(String str, String str2);

    public native void setTimeForOneWord(int i);

    public native int startEmulatorNavi();

    public native int startGPSNavi();

    public native void stopEmulatorNavi();

    public native void stopNavi();
}
