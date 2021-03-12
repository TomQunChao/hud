package com.alibaba.idst.nls.internal.utils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.alibaba.idst.nls.internal.common.PhoneInfo;

public class NetCheck {
    public static ConnectivityManager connectivity = null;

    public static boolean isWifiActive() {
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = connectivity;
        if (!(connectivityManager == null || connectivityManager == null || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null)) {
            for (int i = 0; i < allNetworkInfo.length; i++) {
                if (allNetworkInfo[i].getTypeName().equals(PhoneInfo.NETWORK_TYPE_WIFI) && allNetworkInfo[i].isConnected()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isNetActive() {
        ConnectivityManager connectivityManager = connectivity;
        if (connectivityManager == null) {
            return true;
        }
        if (connectivityManager != null) {
            NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
            if (allNetworkInfo == null) {
                return true;
            }
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.isConnected()) {
                    return true;
                }
            }
        }
        JoyPrint.e("Websocket", "network is not connected");
        return false;
    }
}
