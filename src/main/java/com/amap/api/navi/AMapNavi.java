package com.amap.api.navi;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.amap.api.col.stln3.ja;
import com.amap.api.col.stln3.jf;
import com.amap.api.col.stln3.jv;
import com.amap.api.col.stln3.mj;
import com.amap.api.col.stln3.mm;
import com.amap.api.col.stln3.qz;
import com.amap.api.col.stln3.rf;
import com.amap.api.col.stln3.rx;
import com.amap.api.col.stln3.sk;
import com.amap.api.col.stln3.su;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.enums.AMapNaviOnlineCarHailingType;
import com.amap.api.navi.enums.NetWorkingProtocol;
import com.amap.api.navi.enums.SoundQuality;
import com.amap.api.navi.model.AMapCarInfo;
import com.amap.api.navi.model.AMapNaviGuide;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapTrafficStatus;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.autonavi.amap.mapcore.AeUtil;
import java.util.HashMap;
import java.util.List;

public class AMapNavi implements INavi {
    public static int EmulatorNaviMode = 2;
    public static int GPSNaviMode = 1;
    private static String mNaviLocation;
    private static boolean mNaviStarted = false;
    private static AMapNavi singletonAMapNavi;
    private INavi mINavi;

    protected AMapNavi() {
    }

    private AMapNavi(Context context) {
        if (context != null) {
            try {
                su.a().a(context.getApplicationContext(), jf.a(), AeUtil.SO_FILENAME_NAVI);
                mm.a(context.getApplicationContext());
                this.mINavi = (INavi) sk.a(context, mj.a(), "com.amap.api.navi.wrapper.AmapNaviWrapper", ja.class, new Class[]{Context.class}, new Object[]{context});
            } catch (Throwable th) {
                th.printStackTrace();
                this.mINavi = new ja(context);
            }
        }
    }

    public static synchronized AMapNavi getInstance(Context context) {
        AMapNavi aMapNavi;
        synchronized (AMapNavi.class) {
            try {
                if (singletonAMapNavi == null) {
                    singletonAMapNavi = new AMapNavi(context);
                }
            } catch (Throwable th) {
                mj.a(th);
                rx.c(th, "AMapNavi", "getInstance(Context context)");
            }
            aMapNavi = singletonAMapNavi;
        }
        return aMapNavi;
    }

    public static String getVersion() {
        return "6.5.0";
    }

    public static void setApiKey(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                qz.a(str);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setApiKey");
        }
    }

    public static void setIgnoreWifiCheck(boolean z) {
        try {
            NaviSetting.setIgnoreWifi(z);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setIgnoreWifiCheck");
        }
    }

    public static void setUseOfflineVoice(boolean z) {
        try {
            NaviSetting.setUseOfflineVoice(z);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setUseOfflineVoice");
        }
    }

    public static void setTtsPlaying(boolean z) {
        mj.a = z;
    }

    @Override // com.amap.api.navi.INavi
    public int strategyConvert(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.strategyConvert(z, z2, z3, z4, z5);
            }
            return 0;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "strategyConvert");
            return 0;
        }
    }

    @Override // com.amap.api.navi.INavi
    public synchronized void destroy() {
        try {
            if (this.mINavi != null) {
                this.mINavi.destroy();
                this.mINavi = null;
            }
            mj.a = false;
            singletonAMapNavi = null;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "destroy");
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean startNavi(int i) {
        try {
            if (this.mINavi == null) {
                return false;
            }
            if (i == 1) {
                mNaviStarted = true;
            }
            return this.mINavi.startNavi(i);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "startNavi(naviType)");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public void pauseNavi() {
        try {
            if (this.mINavi != null) {
                this.mINavi.pauseNavi();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "pauseNavi()");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void stopNavi() {
        try {
            if (this.mINavi != null) {
                mNaviStarted = false;
                this.mINavi.stopNavi();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "stopNavi();");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void resumeNavi() {
        try {
            if (this.mINavi != null) {
                this.mINavi.resumeNavi();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "resumeNavi()");
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean readNaviInfo() {
        try {
            if (this.mINavi != null) {
                return this.mINavi.readNaviInfo();
            }
            return false;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "readNaviInfo() ");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean readTrafficInfo(int i) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.readTrafficInfo(i);
            }
            return false;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "readTrafficInfo(int frontDistance)");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean calculateDriveRoute(List<NaviLatLng> list, List<NaviLatLng> list2, List<NaviLatLng> list3, int i) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.calculateDriveRoute(list, list2, list3, i);
            }
            return false;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "calculateDriveRoute(List<NaviLatLng> from, List<NaviLatLng> to,\n                                       List<NaviLatLng> wayPoints, int strategy)");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setCarNumber(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                if (this.mINavi != null && str2.length() < 7) {
                    this.mINavi.setCarNumber(str, str2);
                }
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setCarNumber(String province,String number)");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setCarInfo(AMapCarInfo aMapCarInfo) {
        try {
            if (this.mINavi != null) {
                this.mINavi.setCarInfo(aMapCarInfo);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setCarInfo");
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean calculateDriveRoute(List<NaviLatLng> list, List<NaviLatLng> list2, int i) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.calculateDriveRoute(list, list2, i);
            }
            return false;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "calculateDriveRoute(java.util.List<NaviLatLng> to,\n                                       java.util.List<NaviLatLng> wayPoints, int strategy)");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean reCalculateRoute(int i) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.reCalculateRoute(i);
            }
            return false;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "reCalculateRoute(int strategy)");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public List<AMapTrafficStatus> getTrafficStatuses(int i, int i2) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.getTrafficStatuses(i, i2);
            }
            return null;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "getTrafficStatuses(int startPos, int distance) ");
            return null;
        }
    }

    @Override // com.amap.api.navi.INavi
    public AMapNaviPath getNaviPath() {
        try {
            if (this.mINavi != null) {
                return this.mINavi.getNaviPath();
            }
            return null;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "getNaviPath()");
            return null;
        }
    }

    @Override // com.amap.api.navi.INavi
    public HashMap<Integer, AMapNaviPath> getNaviPaths() {
        try {
            if (this.mINavi != null) {
                return this.mINavi.getNaviPaths();
            }
            return null;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "getNaviPaths()");
            return null;
        }
    }

    @Override // com.amap.api.navi.INavi
    public List<AMapNaviGuide> getNaviGuideList() {
        try {
            if (this.mINavi != null) {
                return this.mINavi.getNaviGuideList();
            }
            return null;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "getNaviGuideList()");
            return null;
        }
    }

    @Override // com.amap.api.navi.INavi
    public NaviSetting getNaviSetting() {
        try {
            if (this.mINavi != null) {
                return this.mINavi.getNaviSetting();
            }
            return null;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "getNaviSetting");
            return null;
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setEmulatorNaviSpeed(int i) {
        try {
            if (this.mINavi != null) {
                this.mINavi.setEmulatorNaviSpeed(i);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setEmulatorNaviSpeed(int speed)");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setTimeForOneWord(int i) {
        try {
            if (this.mINavi != null) {
                this.mINavi.setTimeForOneWord(i);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setTimeForOneWord(int time)");
        }
    }

    public void setAMapNaviListener(AMapNaviListener aMapNaviListener) {
        try {
            if (this.mINavi != null) {
                this.mINavi.addAMapNaviListener(aMapNaviListener);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setAMapNaviListener(AMapNaviListener naviListener) ");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void addAMapNaviListener(AMapNaviListener aMapNaviListener) {
        try {
            if (this.mINavi != null) {
                this.mINavi.addAMapNaviListener(aMapNaviListener);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "addAMapNaviListener(AMapNaviListener naviListener)");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void removeAMapNaviListener(AMapNaviListener aMapNaviListener) {
        try {
            if (this.mINavi != null) {
                this.mINavi.removeAMapNaviListener(aMapNaviListener);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "removeAMapNaviListener(AMapNaviListener naviListener)");
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean startGPS() {
        try {
            if (this.mINavi != null) {
                return this.mINavi.startGPS();
            }
            return false;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "startGPS");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean startGPS(long j, int i) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.startGPS(j, i);
            }
            return false;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "startGPS");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean stopGPS() {
        try {
            if (this.mINavi != null) {
                return this.mINavi.stopGPS();
            }
            return false;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "stopGPS");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean calculateWalkRoute(NaviLatLng naviLatLng) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.calculateWalkRoute(naviLatLng);
            }
            return false;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "calculateWalkRoute");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean calculateWalkRoute(NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.calculateWalkRoute(naviLatLng, naviLatLng2);
            }
            return false;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "calculateWalkRoute");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean calculateRideRoute(NaviLatLng naviLatLng) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.calculateRideRoute(naviLatLng);
            }
            return false;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "calculateRideRoute");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean calculateRideRoute(NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.calculateRideRoute(naviLatLng, naviLatLng2);
            }
            return false;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "calculateRideRoute");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setReCalculateRouteForYaw(boolean z) {
    }

    @Override // com.amap.api.navi.INavi
    public void setReCalculateRouteForTrafficJam(boolean z) {
    }

    @Override // com.amap.api.navi.INavi
    public int getEngineType() {
        try {
            if (this.mINavi != null) {
                return this.mINavi.getEngineType();
            }
            return 0;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "getEngineType");
            return 0;
        }
    }

    @Override // com.amap.api.navi.INavi
    public int getNaviType() {
        try {
            if (this.mINavi != null) {
                return this.mINavi.getNaviType();
            }
            return 0;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "getNaviType");
            return 0;
        }
    }

    @Override // com.amap.api.navi.INavi
    public NaviInfo getNaviInfo() {
        try {
            if (this.mINavi != null) {
                return this.mINavi.getNaviInfo();
            }
            return null;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "getNaviInfo");
            return null;
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setDetectedMode(int i) {
        try {
            if (this.mINavi != null) {
                this.mINavi.setDetectedMode(i);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setDetectedMode");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void startAimlessMode(int i) {
        try {
            if (this.mINavi != null) {
                this.mINavi.startAimlessMode(i);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "startAimlessMode");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void stopAimlessMode() {
        try {
            if (this.mINavi != null) {
                this.mINavi.stopAimlessMode();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "stopAimlessMode");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setConnectionTimeout(int i) {
        try {
            if (this.mINavi != null) {
                this.mINavi.setConnectionTimeout(i);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setConnectionTimeout");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setSoTimeout(int i) {
        try {
            if (this.mINavi != null) {
                this.mINavi.setSoTimeout(i);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setSoTimeout");
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean selectRouteId(int i) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.selectRouteId(i);
            }
            return false;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "selectRouteId");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean isGpsReady() {
        try {
            if (this.mINavi != null) {
                return this.mINavi.isGpsReady();
            }
            return false;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "isGpsReady");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean setBroadcastMode(int i) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.setBroadcastMode(i);
            }
            return false;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setBroadcastMode");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public void switchParallelRoad() {
        try {
            if (this.mINavi != null) {
                this.mINavi.switchParallelRoad();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "switchParallelRoad");
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean getIsUseExtraGPSData() {
        try {
            if (this.mINavi != null) {
                return this.mINavi.getIsUseExtraGPSData();
            }
            return false;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "getIsUseExtraGPSData");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setIsUseExtraGPSData(boolean z) {
        try {
            if (this.mINavi != null) {
                this.mINavi.setIsUseExtraGPSData(z);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setIsUseExtraGPSData");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setExtraGPSData(int i, Location location) {
        try {
            if (this.mINavi != null) {
                this.mINavi.setExtraGPSData(i, location);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setExtraGPSData");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setExtraGPSData(Location location) {
        try {
            if (this.mINavi != null) {
                this.mINavi.setExtraGPSData(location);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setExtraGPSData");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setUseInnerVoice(boolean z) {
        try {
            setUseInnerVoice(z, false);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setUseInnerVoice");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setUseInnerVoice(boolean z, boolean z2) {
        try {
            if (this.mINavi != null) {
                this.mINavi.setUseInnerVoice(z, z2);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setUseInnerVoice1");
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean getIsUseInnerVoice() {
        try {
            if (this.mINavi != null) {
                return this.mINavi.getIsUseInnerVoice();
            }
            return false;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "getIsUseInnerVoice");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean calculateDriveRoute(String str, String str2, List<String> list, int i) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.calculateDriveRoute(str, str2, list, i);
            }
            return false;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "calculateDriveRoute_Poi");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean calculateDriveRoute(String str, List<String> list, int i) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.calculateDriveRoute(str, list, i);
            }
            return false;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "calculateDriveRoute_Poi1");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setSoundQuality(SoundQuality soundQuality) {
        try {
            if (this.mINavi != null) {
                this.mINavi.setSoundQuality(soundQuality);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setSoundQuality");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setMultipleRouteNaviMode(boolean z) {
        try {
            if (this.mINavi != null) {
                this.mINavi.setMultipleRouteNaviMode(z);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setMultipleRouteNaviMode");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void selectMainPathID(long j) {
        try {
            if (this.mINavi != null) {
                this.mINavi.selectMainPathID(j);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "selectMainPathID");
        }
    }

    public static String getNaviLocation() {
        return mNaviLocation;
    }

    public void setNaviLocation(String str) {
        mNaviLocation = str;
    }

    public static boolean isNaviStarted() {
        return mNaviStarted;
    }

    @Override // com.amap.api.navi.INavi
    public boolean calculateDriveRoute(Poi poi, Poi poi2, List<Poi> list, int i) {
        try {
            if (this.mINavi != null) {
                return this.mINavi.calculateDriveRoute(poi, poi2, list, i);
            }
            return false;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "calculateDriveRoute_Poi2");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public void stopSpeak() {
        try {
            if (this.mINavi != null) {
                this.mINavi.stopSpeak();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "stopSpeaking");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void startSpeak() {
        try {
            if (this.mINavi != null) {
                this.mINavi.startSpeak();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "startSpeaking");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setAMapNaviOnlineCarHailingType(AMapNaviOnlineCarHailingType aMapNaviOnlineCarHailingType) {
        try {
            if (this.mINavi != null) {
                this.mINavi.setAMapNaviOnlineCarHailingType(aMapNaviOnlineCarHailingType);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setAMapNaviOnlineCarHailingType");
        }
    }

    public static boolean isTtsPlaying() {
        return mj.a;
    }

    public static void setNetWorkingProtocol(NetWorkingProtocol netWorkingProtocol) {
        try {
            jv.a = netWorkingProtocol;
            if (netWorkingProtocol == NetWorkingProtocol.HTTPS) {
                rf.a().a(true);
            } else {
                rf.a().a(false);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setNetWorkingProtocol");
        }
    }
}
