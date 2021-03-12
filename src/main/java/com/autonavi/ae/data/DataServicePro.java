package com.autonavi.ae.data;

public final class DataServicePro {
    private static volatile DataServicePro mInstance = null;
    private DataPathManager mDataPathManager;
    private long mShadow;

    private static native void nativeDestroy();

    private native long nativeInit();

    private static native void nativeInit(String str, String str2, String str3, String str4, String str5);

    private DataServicePro() {
        this.mShadow = 0;
        this.mShadow = nativeInit();
        long j = this.mShadow;
        if (j != 0) {
            this.mDataPathManager = new DataPathManager(j);
        }
    }

    private boolean isValid() {
        return this.mShadow != 0;
    }

    public static void init(InitParams initParams) {
        nativeInit(initParams.getRootPath(), initParams.getConfigFilePath(), initParams.getDataFilePath(), initParams.getConfigFileContent(), initParams.get3dCrossPath());
    }

    public static DataServicePro getInstance() {
        if (mInstance == null) {
            synchronized (DataServicePro.class) {
                if (mInstance == null) {
                    DataServicePro dataServicePro = new DataServicePro();
                    mInstance = dataServicePro;
                    if (!dataServicePro.isValid()) {
                        mInstance = null;
                    }
                }
            }
        }
        return mInstance;
    }

    public final DataPathManager getDataPathManager() {
        return this.mDataPathManager;
    }

    public static void destroy() {
        if (mInstance != null) {
            nativeDestroy();
            mInstance = null;
        }
    }
}
