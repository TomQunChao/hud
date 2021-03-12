package com.alibaba.idst.nls.internal.codec;

import com.nlspeech.nlscodec.NlsCodec2;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class OupsCodec {
    private NlsCodec2 codec = NlsCodec2.getInstance();
    private long dec = 0;
    private long enc = 0;

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
            open(false);
            try {
                inputStream.reset();
                while (inputStream.read(bArr, 0, 70) == 70) {
                    decode(bArr, sArr);
                    for (int i = 0; i < 320; i++) {
                        byteArrayOutputStream.write(sArr[i] & 255);
                        byteArrayOutputStream.write((sArr[i] >>> 8) & 255);
                    }
                }
                close();
                byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                e.printStackTrace();
                close();
                return null;
            }
        }
        return byteArrayInputStream;
    }

    public OutputStream spxToWave(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(34000);
        byte[] bArr = new byte[70];
        short[] sArr = new short[320];
        open(false);
        try {
            inputStream.reset();
            while (inputStream.read(bArr, 0, 70) == 70) {
                decode(bArr, sArr);
                for (int i = 0; i < 320; i++) {
                    byteArrayOutputStream.write(sArr[i] & 255);
                    byteArrayOutputStream.write((sArr[i] >>> 8) & 255);
                }
            }
            close();
            return byteArrayOutputStream;
        } catch (IOException e) {
            e.printStackTrace();
            close();
            return null;
        }
    }

    public boolean isOpen() {
        return this.enc != 0;
    }

    public int encodec(short[] sArr, int i, int i2, byte[] bArr) {
        if (!isOpen() || bArr == null) {
            return 0;
        }
        byte[] bArr2 = new byte[bArr.length];
        int encode = this.codec.encode(this.enc, sArr, 0, bArr2);
        bArr[0] = (byte) encode;
        System.arraycopy(bArr2, 0, bArr, 1, encode);
        return encode + 1;
    }

    public int decode(byte[] bArr, short[] sArr) {
        return this.codec.decode(this.dec, bArr, 70, sArr);
    }

    public void close() {
        long j = this.enc;
        if (j != 0) {
            this.codec.destroyEncoder(j);
            this.enc = 0;
        }
        long j2 = this.dec;
        if (j2 != 0) {
            this.codec.destroyDecoder(j2);
            this.dec = 0;
        }
    }

    public boolean open(boolean z) {
        if (z) {
            this.enc = this.codec.createEncoder();
            if (this.enc != 0) {
                return true;
            }
            return false;
        }
        this.dec = this.codec.createDecoder();
        if (this.dec != 0) {
            return true;
        }
        return false;
    }
}
