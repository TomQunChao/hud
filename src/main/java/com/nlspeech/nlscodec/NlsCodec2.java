package com.nlspeech.nlscodec;

import com.alibaba.idst.nls.internal.common.Config;

public class NlsCodec2 {
    private static NlsCodec2 instanse = null;
    private static boolean sIsLibAvailable;

    public native long createDecoder();

    public native long createEncoder();

    public native int decode(long j, byte[] bArr, int i, short[] sArr);

    public native void destroyDecoder(long j);

    public native void destroyEncoder(long j);

    public native int encode(long j, short[] sArr, int i, byte[] bArr);

    static {
        sIsLibAvailable = true;
        if (Config.AUTO_LOAD_LIBS) {
            try {
                System.loadLibrary("ztcodec2");
            } catch (Throwable th) {
                sIsLibAvailable = false;
            }
        }
    }

    public NlsCodec2() {
        instanse = this;
    }

    public boolean isAvailable() {
        return sIsLibAvailable;
    }

    public static NlsCodec2 getInstance() {
        if (instanse == null) {
            instanse = new NlsCodec2();
        }
        return instanse;
    }
}
