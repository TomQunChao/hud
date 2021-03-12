package com.amap.api.navi.view.statusbar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;

public class StatusBarVolumeReceiver extends BroadcastReceiver {
    private OnVolumeChangeCallBack mOnVolumeChangeCallBack = null;

    public interface OnVolumeChangeCallBack {
        void onVolumeUpdate();
    }

    public void onReceive(Context context, Intent intent) {
        OnVolumeChangeCallBack onVolumeChangeCallBack;
        if (TextUtils.equals(intent.getAction(), "android.media.VOLUME_CHANGED_ACTION") && (onVolumeChangeCallBack = this.mOnVolumeChangeCallBack) != null) {
            onVolumeChangeCallBack.onVolumeUpdate();
        }
    }

    public void setOnVolumeChangeCallBack(OnVolumeChangeCallBack onVolumeChangeCallBack) {
        this.mOnVolumeChangeCallBack = onVolumeChangeCallBack;
    }

    public void register(Context context) {
        if (context != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            try {
                context.registerReceiver(this, intentFilter);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void unRegister(Context context) {
        if (context != null) {
            try {
                context.unregisterReceiver(this);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
