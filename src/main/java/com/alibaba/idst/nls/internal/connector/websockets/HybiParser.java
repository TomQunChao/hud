package com.alibaba.idst.nls.internal.connector.websockets;

import com.alibaba.idst.nls.internal.utils.L;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

public class HybiParser {
    private static final int BYTE = 255;
    private static final int FIN = 128;
    private static final List<Integer> FRAGMENTED_OPCODES = Arrays.asList(0, 1, 2);
    private static final int LENGTH = 127;
    private static final int MASK = 128;
    private static final int MODE_BINARY = 2;
    private static final int MODE_TEXT = 1;
    private static final int OPCODE = 15;
    private static final List<Integer> OPCODES = Arrays.asList(0, 1, 2, 8, 9, 10);
    private static final int OP_BINARY = 2;
    private static final int OP_CLOSE = 8;
    private static final int OP_CONTINUATION = 0;
    private static final int OP_PING = 9;
    private static final int OP_PONG = 10;
    private static final int OP_TEXT = 1;
    private static final int RSV1 = 64;
    private static final int RSV2 = 32;
    private static final int RSV3 = 16;
    private static final String TAG = "HybiParser";
    private ByteArrayOutputStream mBuffer = new ByteArrayOutputStream();
    private WebSocketClient mClient;
    private boolean mClosed = false;
    private boolean mFinal;
    private int mLength;
    private int mLengthSize;
    private byte[] mMask = new byte[0];
    private boolean mMasked;
    private boolean mMasking = true;
    private int mMode;
    private int mOpcode;
    private byte[] mPayload = new byte[0];
    private int mStage;

    public HybiParser(WebSocketClient webSocketClient) {
        this.mClient = webSocketClient;
    }

    private static byte[] mask(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2.length == 0) {
            return bArr;
        }
        for (int i2 = 0; i2 < bArr.length - i; i2++) {
            int i3 = i + i2;
            bArr[i3] = (byte) (bArr[i3] ^ bArr2[i2 % 4]);
        }
        return bArr;
    }

    public void start(HappyDataInputStream happyDataInputStream) throws IOException {
        while (happyDataInputStream.available() != -1) {
            switch (this.mStage) {
                case 0:
                    parseOpcode(happyDataInputStream.readByte());
                    break;
                case 1:
                    parseLength(happyDataInputStream.readByte());
                    break;
                case 2:
                    parseExtendedLength(happyDataInputStream.readBytes(this.mLengthSize));
                    break;
                case 3:
                    this.mMask = happyDataInputStream.readBytes(4);
                    this.mStage = 4;
                    break;
                case 4:
                    this.mPayload = happyDataInputStream.readBytes(this.mLength);
                    emitFrame();
                    this.mStage = 0;
                    break;
            }
        }
        this.mClient.getListener().onDisconnect(10, "EOF");
    }

    private void parseOpcode(byte b) throws ProtocolError {
        boolean z = (b & 64) == 64;
        boolean z2 = (b & 32) == 32;
        boolean z3 = (b & 16) == 16;
        if (z || z2 || z3) {
            throw new ProtocolError("RSV not zero");
        }
        this.mFinal = (b & 128) == 128;
        this.mOpcode = b & 15;
        this.mMask = new byte[0];
        this.mPayload = new byte[0];
        if (!OPCODES.contains(Integer.valueOf(this.mOpcode))) {
            throw new ProtocolError("Bad opcode");
        } else if (FRAGMENTED_OPCODES.contains(Integer.valueOf(this.mOpcode)) || this.mFinal) {
            this.mStage = 1;
        } else {
            throw new ProtocolError("Expected non-final packet");
        }
    }

    private void parseLength(byte b) {
        this.mMasked = (b & 128) == 128;
        this.mLength = b & Byte.MAX_VALUE;
        int i = this.mLength;
        if (i < 0 || i > 125) {
            this.mLengthSize = this.mLength == 126 ? 2 : 8;
            this.mStage = 2;
            return;
        }
        this.mStage = this.mMasked ? 3 : 4;
    }

    private void parseExtendedLength(byte[] bArr) throws ProtocolError {
        this.mLength = getInteger(bArr);
        this.mStage = this.mMasked ? 3 : 4;
    }

    public byte[] frame(String str) {
        return frame(str, 1, -1);
    }

    public byte[] frame(byte[] bArr) {
        return frame(bArr, 2, -1);
    }

    private byte[] frame(byte[] bArr, int i, int i2) {
        return frame((Object) bArr, i, i2);
    }

    private byte[] frame(String str, int i, int i2) {
        return frame((Object) str, i, i2);
    }

    private byte[] frame(Object obj, int i, int i2) {
        int i3;
        int i4;
        if (this.mClosed) {
            return null;
        }
        byte[] decode = obj instanceof String ? decode((String) obj) : (byte[]) obj;
        int i5 = i2 > 0 ? 2 : 0;
        int length = (decode == null ? 0 : decode.length) + i5;
        int i6 = length <= 125 ? 2 : length <= 65535 ? 4 : 10;
        int i7 = (this.mMasking ? 4 : 0) + i6;
        int i8 = this.mMasking ? 128 : 0;
        byte[] bArr = new byte[(length + i7)];
        bArr[0] = (byte) (((byte) i) | Byte.MIN_VALUE);
        if (length <= 125) {
            bArr[1] = (byte) (length | i8);
            i4 = i5;
            i3 = i6;
        } else if (length <= 65535) {
            bArr[1] = (byte) (i8 | 126);
            bArr[2] = (byte) ((int) Math.floor((double) (length / 256)));
            bArr[3] = (byte) (length & 255);
            i4 = i5;
            i3 = i6;
        } else {
            bArr[1] = (byte) (i8 | LENGTH);
            double d = (double) length;
            i4 = i5;
            i3 = i6;
            bArr[2] = (byte) (((int) Math.floor(d / Math.pow(2.0d, 56.0d))) & 255);
            bArr[3] = (byte) (((int) Math.floor(d / Math.pow(2.0d, 48.0d))) & 255);
            bArr[4] = (byte) (((int) Math.floor(d / Math.pow(2.0d, 40.0d))) & 255);
            bArr[5] = (byte) (((int) Math.floor(d / Math.pow(2.0d, 32.0d))) & 255);
            bArr[6] = (byte) (((int) Math.floor(d / Math.pow(2.0d, 24.0d))) & 255);
            bArr[7] = (byte) (((int) Math.floor(d / Math.pow(2.0d, 16.0d))) & 255);
            bArr[8] = (byte) (((int) Math.floor(d / Math.pow(2.0d, 8.0d))) & 255);
            bArr[9] = (byte) (length & 255);
        }
        if (i2 > 0) {
            bArr[i7] = (byte) (((int) Math.floor((double) (i2 / 256))) & 255);
            bArr[i7 + 1] = (byte) (i2 & 255);
        }
        if (decode != null) {
            System.arraycopy(decode, 0, bArr, i7 + i4, decode.length);
        }
        if (this.mMasking) {
            byte[] bArr2 = {(byte) ((int) Math.floor(Math.random() * 256.0d)), (byte) ((int) Math.floor(Math.random() * 256.0d)), (byte) ((int) Math.floor(Math.random() * 256.0d)), (byte) ((int) Math.floor(Math.random() * 256.0d))};
            System.arraycopy(bArr2, 0, bArr, i3, bArr2.length);
            mask(bArr, bArr2, i7);
        }
        return bArr;
    }

    public void ping(String str) {
        this.mClient.send(frame(str, 9, -1));
    }

    public void close(int i, String str) {
        if (!this.mClosed) {
            this.mClient.send(frame(str, 8, i));
            this.mClosed = true;
        }
    }

    private void emitFrame() throws IOException {
        int i = 0;
        byte[] mask = mask(this.mPayload, this.mMask, 0);
        int i2 = this.mOpcode;
        if (i2 == 0) {
            if (this.mMode != 0) {
                this.mBuffer.write(mask);
                if (this.mFinal) {
                    byte[] byteArray = this.mBuffer.toByteArray();
                    if (this.mMode == 1) {
                        this.mClient.getListener().onMessage(encode(byteArray));
                    } else {
                        this.mClient.getListener().onMessage(byteArray);
                    }
                    reset();
                    return;
                }
                return;
            }
            throw new ProtocolError("Mode was not set.");
        } else if (i2 == 1) {
            if (this.mFinal) {
                this.mClient.getListener().onMessage(encode(mask));
                return;
            }
            this.mMode = 1;
            this.mBuffer.write(mask);
        } else if (i2 == 2) {
            if (this.mFinal) {
                this.mClient.getListener().onMessage(mask);
                return;
            }
            this.mMode = 2;
            this.mBuffer.write(mask);
        } else if (i2 == 8) {
            if (mask.length >= 2) {
                i = (mask[1] & 255) + ((mask[0] & 255) << 8);
            }
            String encode = mask.length > 2 ? encode(slice(mask, 2)) : null;
            L.d(TAG, "Got close op! " + i + " " + encode);
            this.mClient.getListener().onDisconnect(i, encode);
        } else if (i2 == 9) {
            if (mask.length <= 125) {
                this.mClient.sendFrame(frame(mask, 10, -1));
                return;
            }
            throw new ProtocolError("Ping payload too large");
        } else if (i2 == 10) {
            encode(mask);
        }
    }

    private void reset() {
        this.mMode = 0;
        this.mBuffer.reset();
    }

    private String encode(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] decode(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private int getInteger(byte[] bArr) throws ProtocolError {
        long byteArrayToLong = byteArrayToLong(bArr, 0, bArr.length);
        if (byteArrayToLong >= 0 && byteArrayToLong <= 2147483647L) {
            return (int) byteArrayToLong;
        }
        throw new ProtocolError("Bad integer: " + byteArrayToLong);
    }

    private static byte[] copyOfRange(byte[] bArr, int i, int i2) {
        if (i <= i2) {
            int length = bArr.length;
            if (i < 0 || i > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = i2 - i;
            int min = Math.min(i3, length - i);
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i, bArr2, 0, min);
            return bArr2;
        }
        throw new IllegalArgumentException();
    }

    private byte[] slice(byte[] bArr, int i) {
        return copyOfRange(bArr, i, bArr.length);
    }

    public static class ProtocolError extends IOException {
        public ProtocolError(String str) {
            super(str);
        }
    }

    private static long byteArrayToLong(byte[] bArr, int i, int i2) {
        if (bArr.length >= i2) {
            long j = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                j += (long) ((bArr[i3 + i] & 255) << (((i2 - 1) - i3) * 8));
            }
            return j;
        }
        throw new IllegalArgumentException("length must be less than or equal to b.length");
    }

    public static class HappyDataInputStream extends DataInputStream {
        public HappyDataInputStream(InputStream inputStream) {
            super(inputStream);
        }

        public byte[] readBytes(int i) throws IOException {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = read(bArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            }
            if (i2 == i) {
                return bArr;
            }
            throw new IOException(String.format("Read wrong number of bytes. Got: %s, Expected: %s.", Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
