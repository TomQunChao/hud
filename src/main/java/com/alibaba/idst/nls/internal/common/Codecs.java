package com.alibaba.idst.nls.internal.common;

import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Codecs {
    private static Codecs instanse = null;
    private static boolean sIsAvailable = true;

    private native int decode(byte[] bArr, short[] sArr, int i);

    private native int open(int i);

    public native void close();

    public native int encode(short[] sArr, int i, byte[] bArr, int i2);

    static {
        if (Config.AUTO_LOAD_LIBS) {
            try {
                System.loadLibrary("ztcodec2");
            } catch (Throwable th) {
            }
        }
    }

    public Codecs() {
        instanse = this;
    }

    private String set() {
        return "libztcodec2.so";
    }

    private String set(Object obj) {
        return "libztcodec2.so";
    }

    public class Define {
        public static final int SPEEX_FRAM_SIZE = 70;
        public static final int WAVE_FRAM_SIZE = 320;

        public Define() {
        }
    }

    public InputStream toWave(InputStream inputStream) {
        ByteArrayInputStream byteArrayInputStream;
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(34000);
        byte[] bArr = new byte[70];
        short[] sArr = new short[320];
        synchronized (this) {
            open();
            try {
                inputStream.reset();
                while (true) {
                    if (inputStream.read(bArr, 0, 70) == 70) {
                        decode(bArr, sArr, bArr.length);
                        for (int i = 0; i < 320; i++) {
                            byteArrayOutputStream.write(sArr[i] & 255);
                            byteArrayOutputStream.write((sArr[i] >> 8) & 255);
                        }
                    } else {
                        close();
                        byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                close();
                return null;
            }
        }
        return byteArrayInputStream;
    }

    public byte[] WaveToSpx(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[70];
        short[] sArr = new short[320];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(34000);
        int length = bArr.length;
        synchronized (this) {
            open();
            int i = 0;
            while (i + GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH <= length) {
                int i2 = i;
                for (int i3 = 0; i3 < 320; i3++) {
                    int i4 = i2 + 1;
                    sArr[i3] = (short) ((bArr[i2] & 255) | ((bArr[i4] & 255) << 8));
                    i2 = i4 + 1;
                }
                encode(sArr, 0, bArr2, 320);
                byteArrayOutputStream.write(bArr2, 0, bArr2.length);
                i = i2;
            }
            close();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public OutputStream spxToWave(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(34000);
        byte[] bArr = new byte[70];
        short[] sArr = new short[320];
        open();
        try {
            inputStream.reset();
            while (true) {
                if (inputStream.read(bArr, 0, 70) == 70) {
                    decode(bArr, sArr, bArr.length);
                    for (int i = 0; i < 320; i++) {
                        byteArrayOutputStream.write(sArr[i] & 255);
                        byteArrayOutputStream.write((sArr[i] >>> 8) & 255);
                    }
                } else {
                    close();
                    return byteArrayOutputStream;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            close();
            return null;
        }
    }

    public boolean isAvailable() {
        return sIsAvailable;
    }

    public static Codecs getInstanse() {
        if (instanse == null) {
            instanse = new Codecs();
        }
        return instanse;
    }

    public int decode(byte[] bArr, short[] sArr) {
        return decode(bArr, sArr, 70);
    }

    public boolean open() {
        return open(8) == 0 ? true : true;
    }
}
