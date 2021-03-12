package com.autonavi.ae.pos;

public class LocManager {
    public static native void addDebugInfoObserver(DebugInfoListener debugInfoListener);

    public static native void addLocListener(LocListener locListener, int i);

    public static native void addNGMListener(LocNGMListener locNGMListener);

    public static native void addParallelRoadObserver(LocParallelRoadObserver locParallelRoadObserver);

    public static native void addParallelSwitchObserver(LocParallelSwitchObserver locParallelSwitchObserver);

    public static native String getDebugInfo(int i);

    public static native String getVersion();

    public static native long init();

    public static native long requestCallBackPos(int i);

    public static native void saveLocStorage();

    public static native void setAcce(int i, float f, float f2, float f3, int i2, long j);

    public static native void setCarPosByCoord(int i, int i2, double d);

    public static native void setCompass(double d, long j);

    public static native void setDRPos(LocDRPos locDRPos);

    public static native void setDebug(int i, int i2);

    public static native void setDoorIn(LocDoorIn locDoorIn);

    public static native void setDriveSigInfo(LocDriveSig locDriveSig);

    public static native void setGSVData(LocGSVData locGSVData);

    public static native void setGpsInfo(GpsInfo gpsInfo);

    public static native void setGyro(int i, float f, float f2, float f3, float f4, int i2, long j);

    public static native void setLogSwitch(boolean z, boolean z2, int i);

    public static native void setMatchMode(int i);

    public static native void setPressure(double d, long j);

    public static native void setPulse(float f, int i, long j);

    public static native void setW4M(LocW4M locW4M);

    public static native void setW4MTR(LocW4MTR locW4MTR);

    public static native void switchParallelRoad(long j);

    public static native void uninit();
}
