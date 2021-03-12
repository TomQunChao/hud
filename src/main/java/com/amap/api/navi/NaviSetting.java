package com.amap.api.navi;

import android.content.Context;
import android.os.PowerManager;
import com.amap.api.col.stln3.mj;
import com.amap.api.col.stln3.rx;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.tbt.IAe8;

public class NaviSetting {
    private static boolean isIgnoreWifi = false;
    private static boolean isUseOfflineVoice = false;
    private boolean crossingDrawingEnabled = true;
    private boolean mCameraInfoUpdateEnabled = true;
    boolean mIsMonitorCameraEnabled = true;
    private IAe8 mTbtControl;
    private boolean screenAlwaysBright = false;
    private boolean trafficInfoUpdateEnabled = true;
    private boolean trafficStatusUpdateEnabled = true;
    PowerManager.WakeLock wl;

    public static void setIgnoreWifi(boolean z) {
        isIgnoreWifi = z;
    }

    public static boolean isIsIgnoreWifi() {
        return isIgnoreWifi;
    }

    public static void setUseOfflineVoice(boolean z) {
        isUseOfflineVoice = z;
    }

    public static boolean isUseOfflineVoice() {
        return isUseOfflineVoice;
    }

    public NaviSetting(Context context, IAe8 iAe8) {
        try {
            Context applicationContext = context.getApplicationContext();
            this.mTbtControl = iAe8;
            if (applicationContext != null) {
                this.wl = ((PowerManager) applicationContext.getSystemService("power")).newWakeLock(10, GeocodeSearch.AMAP);
                this.wl.setReferenceCounted(false);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "NaviSetting", "NaviSetting(Context context, WtbtControl tbtControl)");
        }
    }

    public boolean isTrafficStatusUpdateEnabled() {
        return this.trafficStatusUpdateEnabled;
    }

    public void setTrafficStatusUpdateEnabled(boolean z) {
        this.trafficStatusUpdateEnabled = z;
        IAe8 iAe8 = this.mTbtControl;
        if (iAe8 != null) {
            iAe8.setTrafficStatusUpdateEnabled(this.trafficStatusUpdateEnabled);
        }
    }

    public boolean isTrafficInfoUpdateEnabled() {
        return this.trafficInfoUpdateEnabled;
    }

    public void setTrafficInfoUpdateEnabled(boolean z) {
        this.trafficInfoUpdateEnabled = z;
        IAe8 iAe8 = this.mTbtControl;
        if (iAe8 != null) {
            iAe8.setTrafficInfoUpdateEnabled(this.trafficInfoUpdateEnabled);
        }
    }

    public boolean isCameraInfoUpdateEnabled() {
        return this.mCameraInfoUpdateEnabled;
    }

    public void setCameraInfoUpdateEnabled(boolean z) {
        this.mCameraInfoUpdateEnabled = z;
        IAe8 iAe8 = this.mTbtControl;
        if (iAe8 != null) {
            iAe8.setCameraInfoUpdateEnabled(this.mCameraInfoUpdateEnabled);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isMonitorCameraEnabled() {
        return this.mIsMonitorCameraEnabled;
    }

    public void setMonitorCameraEnabled(boolean z) {
        this.mIsMonitorCameraEnabled = z;
    }

    public boolean isCrossingDrawingEnabled() {
        return this.crossingDrawingEnabled;
    }

    public void setCrossingDrawingEnabled(boolean z) {
        this.crossingDrawingEnabled = z;
    }

    public boolean isScreenAlwaysBright() {
        return this.screenAlwaysBright;
    }

    public void setScreenAlwaysBright(boolean z) {
        this.screenAlwaysBright = z;
        try {
            if (this.screenAlwaysBright) {
                this.wl.acquire();
            } else if (this.wl.isHeld()) {
                this.wl.release();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "NaviSetting", "setScreenAlwaysBright(boolean isAlwaysBright)");
        }
    }

    public void destroy() {
        try {
            if (this.wl.isHeld()) {
                this.wl.release();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "NaviSetting", "destroy()");
        }
    }
}
