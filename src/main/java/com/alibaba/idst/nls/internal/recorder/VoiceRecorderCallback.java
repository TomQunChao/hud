package com.alibaba.idst.nls.internal.recorder;

public interface VoiceRecorderCallback {
    void onRecorded(short[] sArr);

    void onRecordedFail(int i);

    boolean onRecorderReady();

    boolean onRecorderStart();

    void onRecorderStop();

    void onVoiceValue(int i);
}
