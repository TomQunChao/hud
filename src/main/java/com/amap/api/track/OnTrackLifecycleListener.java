package com.amap.api.track;

public interface OnTrackLifecycleListener {
    void onBindServiceCallback(int i, String str);

    void onStartGatherCallback(int i, String str);

    void onStartTrackCallback(int i, String str);

    void onStopGatherCallback(int i, String str);

    void onStopTrackCallback(int i, String str);
}
