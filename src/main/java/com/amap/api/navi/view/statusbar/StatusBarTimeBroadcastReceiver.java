package com.amap.api.navi.view.statusbar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class StatusBarTimeBroadcastReceiver extends BroadcastReceiver {
    static List<OnTimeChangeCallBack> list = new ArrayList();
    private static StatusBarTimeBroadcastReceiver timeBroadcastReceiver = null;

    public interface OnTimeChangeCallBack {
        void onUpdate();
    }

    public static StatusBarTimeBroadcastReceiver getTimeBroadcastReceiver() {
        if (timeBroadcastReceiver == null) {
            timeBroadcastReceiver = new StatusBarTimeBroadcastReceiver();
        }
        return timeBroadcastReceiver;
    }

    StatusBarTimeBroadcastReceiver() {
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (TextUtils.equals(action, "android.intent.action.TIME_TICK") || TextUtils.equals(action, "android.intent.action.TIMEZONE_CHANGED") || TextUtils.equals(action, "android.intent.action.DATE_CHANGED") || TextUtils.equals(action, "android.intent.action.TIME_SET")) {
            for (OnTimeChangeCallBack onTimeChangeCallBack : list) {
                if (onTimeChangeCallBack != null) {
                    onTimeChangeCallBack.onUpdate();
                }
            }
        }
    }

    public void addOnTimeChangeCallBack(OnTimeChangeCallBack onTimeChangeCallBack) {
        if (!list.contains(onTimeChangeCallBack)) {
            list.add(onTimeChangeCallBack);
        }
    }

    public void removeOnTimeChangeCallBack(OnTimeChangeCallBack onTimeChangeCallBack) {
        list.remove(onTimeChangeCallBack);
    }

    public void register(Context context) {
        if (context != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_TICK");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.DATE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_SET");
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

    public static void destroy() {
        list.clear();
        timeBroadcastReceiver = null;
    }
}
