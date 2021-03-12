package com.amap.api.maps;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.amap.api.col.stln3.ct;
import com.amap.api.col.stln3.qz;
import com.amap.api.col.stln3.rf;
import com.amap.api.col.stln3.tr;

public final class MapsInitializer {
    public static final int HTTP = 1;
    public static final int HTTPS = 2;
    private static boolean a = true;
    private static boolean b = true;
    private static boolean c = false;
    private static int d = 1;
    public static String sdcardDir = "";

    public static void initialize(Context context) throws RemoteException {
        if (context != null) {
            ct.a = context.getApplicationContext();
        }
    }

    public static void setNetWorkEnable(boolean z) {
        a = z;
    }

    public static boolean getNetWorkEnable() {
        return a;
    }

    public static void setApiKey(String str) {
        if (str != null && str.trim().length() > 0) {
            qz.a(ct.a, str);
        }
    }

    public static String getVersion() {
        return "6.6.0";
    }

    public static void loadWorldGridMap(boolean z) {
        c = z;
    }

    public static boolean isLoadWorldGridMap() {
        return c;
    }

    public static void setBuildingHeight(int i) {
    }

    public static void setDownloadCoordinateConvertLibrary(boolean z) {
        b = z;
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return b;
    }

    public static void setHost(String str) {
        if (TextUtils.isEmpty(str)) {
            tr.a = -1;
            tr.b = "";
            return;
        }
        tr.a = 1;
        tr.b = str;
    }

    public static void setProtocol(int i) {
        d = i;
        rf.a().a(d == 2);
    }

    public static int getProtocol() {
        return d;
    }
}
