package com.autonavi.ae.guide.observer;

import com.autonavi.ae.guide.model.SoundInfo;

public interface GSoundPlayObserver {
    boolean isPlaying();

    void onPlayRing(int i);

    void onPlayTTS(SoundInfo soundInfo);
}
