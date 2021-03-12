package com.alibaba.idst.nls.internal.connector;

import com.alibaba.idst.nls.NlsListener;

public interface ConnectorCallback {
    void onRecognizeEnd();

    void onRecognizeResult(NlsListener.RecognizedResult recognizedResult, int i, String str);

    void onRecognizeStart();

    void onTtsResult(NlsListener.TtsResult ttsResult, int i, String str);
}
