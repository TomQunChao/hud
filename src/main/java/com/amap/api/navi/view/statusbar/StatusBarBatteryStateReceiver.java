package com.amap.api.navi.view.statusbar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;

public class StatusBarBatteryStateReceiver extends BroadcastReceiver {
    private OnBatteryChangedCallback mOnBatteryChangedCallback = null;

    public interface OnBatteryChangedCallback {
        void onBatteryCharging(int i);

        void onBatteryNormal(int i);
    }

    public void onReceive(Context context, Intent intent) {
        if (TextUtils.equals(intent.getAction(), "android.intent.action.BATTERY_CHANGED")) {
            int i = (intent.getExtras().getInt("level") * 100) / intent.getExtras().getInt("scale");
            int intExtra = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
            if (intExtra != 1 && intExtra != 2 && intExtra != 3 && intExtra != 4 && intExtra != 5) {
                return;
            }
            if (intExtra == 2 || intExtra == 5) {
                OnBatteryChangedCallback onBatteryChangedCallback = this.mOnBatteryChangedCallback;
                if (onBatteryChangedCallback != null) {
                    onBatteryChangedCallback.onBatteryCharging(i);
                    return;
                }
                return;
            }
            OnBatteryChangedCallback onBatteryChangedCallback2 = this.mOnBatteryChangedCallback;
            if (onBatteryChangedCallback2 != null) {
                onBatteryChangedCallback2.onBatteryNormal(i);
            }
        }
    }

    public void setOnBatteryChangedCallback(OnBatteryChangedCallback onBatteryChangedCallback) {
        this.mOnBatteryChangedCallback = onBatteryChangedCallback;
    }

    public void register(Context context) {
        if (context != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
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
