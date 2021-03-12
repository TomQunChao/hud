package com.alibaba.idst.nls.internal.vad;

public interface VoiceActDetectorCallback {
    void onNoneEffectiveRecord();

    void onVoiceDetected(byte[] bArr, int i);

    void onVoiceEnd();

    void onVoiceStart();
}
