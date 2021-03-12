package com.autonavi.ae.guide;

import android.content.Context;
import com.autonavi.ae.guide.model.AsyncInfo;
import com.autonavi.ae.guide.model.GNaviPath;
import com.autonavi.ae.guide.model.GuideConfig;
import com.autonavi.ae.guide.model.GuideGPSInfo;
import com.autonavi.ae.guide.observer.GCruiseObserver;
import com.autonavi.ae.guide.observer.GNaviObserver;
import com.autonavi.ae.guide.observer.GSoundPlayObserver;
import com.autonavi.ae.guide.observer.GStatusObserver;
import com.autonavi.ae.route.observer.HttpInterface;
import java.util.HashSet;
import java.util.Iterator;

public class GuideService {
    public static final int DATA_ADD_OP = 2;
    public static final int DATA_DELETE_OP = 5;
    public static final int DATA_FINISH_OP = 4;
    public static final int DATA_UPDAE_OP = 3;
    private static final int FILE_TYPE_CHANGEPLAY = 3;
    private static final int FILE_TYPE_CITY = 1;
    private static final int FILE_TYPE_GUIDESAFE = 4;
    private static final int FILE_TYPE_NAVISOUND = 2;
    private static final int FILE_TYPE_NAVISOUND_TRUCK = 5;
    public static final int NET_ERROR_CANCEL = 2;
    public static final int NET_ERROR_NO_NETWORK_CONNECTION = 3;
    public static final int NET_ERROR_OTHER = -1;
    public static final int NET_ERROR_TIMEOUT = 1;
    public static final int OFFLINE_DATAMANAGER = 1;
    public static final int VERSION_GET_OP = 1;
    int bufferLen = 1024;
    int guideResReaderTypeChangePlay = 3;
    int guideResReaderTypeCity = 1;
    int guideResReaderTypeCruise = 4;
    int guideResReaderTypeGuide = 2;
    int guideResReaderTypeTruck = 5;
    private Context mContext;
    private GCruiseObserver mCruiseObserver;
    private HttpInterface mHttpProcess;
    private GNaviObserver mNaviObserver;
    private long mPtr;
    private GSoundPlayObserver mSoundPlayObserver;
    private HashSet<GStatusObserver> mStatusListeners;

    public static native String getEngineVersion();

    private final native void init(GuideConfig guideConfig);

    public native int control(int i, String str);

    public final native void destroy();

    public native GuideGPSInfo[] getRecentGPS(int i, int i2, int i3);

    public native void ignoreTmcSugguestNaviPath();

    public native int obtainAsyncInfo(AsyncInfo asyncInfo);

    public native int pauseNavi();

    public native int playNaviManual();

    public native int playTRManual(int i);

    public native void processHttpData(int i, int i2, byte[] bArr);

    public native void processHttpError(int i, int i2);

    public native int resumeNavi();

    public native void selectMainPathID(long j);

    public native void setNaviPath(GNaviPath gNaviPath, int i);

    public native void setPressure(double d);

    public native int startNavi(int i);

    public native int stopNavi();

    public GuideService(GuideConfig guideConfig, Context context) {
        this.mContext = context;
        init(guideConfig);
    }

    public void registerHttpProcesser(HttpInterface httpInterface) {
        this.mHttpProcess = httpInterface;
    }

    public void setNaviObserver(GNaviObserver gNaviObserver) {
        this.mNaviObserver = gNaviObserver;
    }

    public void setSoundPlayObserver(GSoundPlayObserver gSoundPlayObserver) {
        this.mSoundPlayObserver = gSoundPlayObserver;
    }

    public void setElecEyeObserver(GCruiseObserver gCruiseObserver) {
        this.mCruiseObserver = gCruiseObserver;
    }

    public void addStatusObserver(GStatusObserver gStatusObserver) {
        if (this.mStatusListeners == null) {
            this.mStatusListeners = new HashSet<>();
        }
        if (!this.mStatusListeners.contains(gStatusObserver)) {
            this.mStatusListeners.add(gStatusObserver);
        }
    }

    public void removeStatusObserver(GStatusObserver gStatusObserver) {
        HashSet<GStatusObserver> hashSet = this.mStatusListeners;
        if (hashSet != null && hashSet.contains(gStatusObserver)) {
            this.mStatusListeners.remove(gStatusObserver);
        }
    }

    private void notifyStatusChanged(int i) {
        HashSet<GStatusObserver> hashSet = this.mStatusListeners;
        if (hashSet != null) {
            Iterator<GStatusObserver> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().onTbtStatusChanged(i, 0);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x0091 A[SYNTHETIC, Splitter:B:60:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x009d A[SYNTHETIC, Splitter:B:65:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00a9 A[SYNTHETIC, Splitter:B:71:0x00a9] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00c3 A[SYNTHETIC, Splitter:B:82:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00cf A[SYNTHETIC, Splitter:B:87:0x00cf] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] readAssetsFile(int r5, int r6) {
        /*
        // Method dump skipped, instructions count: 218
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.ae.guide.GuideService.readAssetsFile(int, int):byte[]");
    }

    public void setBackUpPath(GNaviPath gNaviPath) {
        setNaviPath(gNaviPath, -1);
    }
}
