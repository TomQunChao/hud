package com.alibaba.idst.nls.internal.common;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;

public class DeviceId {
    private static final String DEVICE_ID_KEY = "NLS_SPEECH_DEVICE_ID";
    private static final int MIN_ID_LENGTH = 10;
    private static String sDeviceId;
    private static String tempDeviceId;

    public static String getDeviceId(Context context) {
        if (context == null) {
            return null;
        }
        if (TextUtils.isEmpty(sDeviceId)) {
            sDeviceId = getDeviceIdFromSettings(context);
        }
        String str = sDeviceId;
        if (str == null || str.equals("")) {
            return "DefaultDeviceId";
        }
        return sDeviceId;
    }

    private static String getDeviceIdFromSettings(Context context) {
        if (TextUtils.isEmpty(null)) {
            return generateDeviceId(context);
        }
        return null;
    }

    private static boolean needRecalcDeviceId(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 10) {
            return true;
        }
        return false;
    }

    private static String generateDeviceId(Context context) {
        String imei = getIMEI(context);
        if (needRecalcDeviceId(imei)) {
            return getMacId(context);
        }
        return imei;
    }

    public static String getMacId(Context context) {
        WifiInfo connectionInfo;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                return null;
            }
            return connectionInfo.getMacAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getIMEI(Context context) {
        return context == null ? null : null;
    }
}
