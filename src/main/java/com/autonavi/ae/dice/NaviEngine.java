package com.autonavi.ae.dice;

public class NaviEngine {
    private static native void nativeDestroy();

    private static native String nativeGetSdkVersion();

    private static native boolean nativeInit(InitConfig initConfig);

    private static native void nativeUnInit();

    public static boolean init(InitConfig initConfig) {
        return nativeInit(initConfig);
    }

    public static String getSdkVersion() {
        return nativeGetSdkVersion();
    }

    public static void destroy() {
        nativeDestroy();
    }

    public static void unInit() {
        nativeUnInit();
    }
}
