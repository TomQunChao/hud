package com.alibaba.idst.nls;

import java.io.Serializable;

public class NlsListener {

    public static class RecognizedResult implements Serializable {
        public String asr_out;
        public Boolean bstream_attached;
        public String ds_out;
        public Boolean finish;
        public String out;
        public String results;
        public int status_code;
    }

    public static class TtsResult implements Serializable {
        public byte[] tts_data;
    }

    public void onTtsResult(int i, byte[] bArr) {
    }

    public void onRecognizingResult(int i, RecognizedResult recognizedResult) {
    }

    public void onServiceStatChanged(boolean z, boolean z2) {
    }
}
