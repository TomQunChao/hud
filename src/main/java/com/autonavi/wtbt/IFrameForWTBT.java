package com.autonavi.wtbt;

public interface IFrameForWTBT {
    int GetDialect();

    void PlayVoiceType(int i);

    void arriveWay(int i);

    void carLocationChange(CarLocation carLocation);

    void carProjectionChange(CarLocation carLocation);

    void endEmulatorNavi();

    int getPlayState();

    void lockScreenNaviTips(String str, int i, int i2);

    void offRoute();

    void playNaviSound(int i, String str);

    void requestHttp(int i, int i2, int i3, String str, String str2, byte[] bArr, int i4);

    void routeDestroy();

    void setRouteRequestState(int i);

    void updateNaviInfo(DGNaviInfo dGNaviInfo);

    void vibratePhoneTips(int i, int i2);
}
