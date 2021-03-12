package com.alibaba.idst.nls.internal.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.alibaba.idst.nls.internal.utils.L;
import com.alibaba.idst.nls.internal.utils.NetCheck;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class PhoneInfo {
    public static final String NETWOKR_TYPE_MOBILE = "MOBILE";
    public static final String NETWORK_TYPE_NONE = "NONETWORK";
    public static final String NETWORK_TYPE_WIFI = "WIFI";
    private static PhoneInfo mInstance = null;
    public static String simOperatorName;
    private String IMEI;
    public String appVersion;
    public String deviceSoftwareVersion;
    private Context mContext;
    private boolean mIsInitData = false;
    public String osModel;
    public String osSdkVersion;
    public String osVersion;
    private String userInfo;

    public static PhoneInfo getInstance() {
        if (mInstance == null) {
            mInstance = new PhoneInfo();
        }
        return mInstance;
    }

    public String getIMEI() {
        String str = this.IMEI;
        if (str == null) {
            this.IMEI = getLocalMacAddress();
        } else if (str.length() < 11) {
            this.IMEI = getLocalMacAddress();
        }
        return this.IMEI;
    }

    public static String getUTF8(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void setUserInfo(String str) {
        this.userInfo = getUTF8(str);
    }

    public String getUserInfo() {
        if (this.userInfo == null) {
            setUserInfo("");
        }
        return this.userInfo;
    }

    public String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getLocalMacAddress() {
        WifiManager wifiManager = (WifiManager) this.mContext.getSystemService("wifi");
        if (wifiManager != null) {
            return wifiManager.getConnectionInfo().getMacAddress();
        }
        return "";
    }

    public void initData(Context context) {
        if (!this.mIsInitData && context != null) {
            this.mIsInitData = true;
            this.mContext = context.getApplicationContext();
            if (NetCheck.connectivity == null) {
                NetCheck.connectivity = (ConnectivityManager) context.getSystemService("connectivity");
            }
            this.osModel = Build.MODEL;
            this.osSdkVersion = Build.VERSION.SDK;
            this.osVersion = Build.VERSION.RELEASE;
            this.appVersion = getVersionName(context);
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            telephonyManager.getCallState();
            this.IMEI = telephonyManager.getDeviceId();
            String str = this.IMEI;
            if (str == null) {
                this.IMEI = getLocalMacAddress();
            } else if (str.length() < 11) {
                this.IMEI = getLocalMacAddress();
            }
            this.deviceSoftwareVersion = telephonyManager.getDeviceSoftwareVersion();
            String simOperatorName2 = telephonyManager.getSimOperatorName();
            simOperatorName = simOperatorName2;
            String utf8 = getUTF8(simOperatorName2);
            simOperatorName = utf8;
            if (utf8.length() == 0) {
                simOperatorName = "null";
            }
        }
    }

    public static String getCurrentNetType(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
            L.d("ContentValues", "Current net type:  WIFI.");
            return NETWORK_TYPE_WIFI;
        } else if (networkInfo2 == null || networkInfo2.getState() != NetworkInfo.State.CONNECTED) {
            L.e("ContentValues", "Current net type:  NONE.");
            return NETWORK_TYPE_NONE;
        } else {
            L.d("ContentValues", "Current net type:  MOBILE.");
            return NETWOKR_TYPE_MOBILE;
        }
    }
}
