package com.alibaba.idst.nls.internal.utils;

import java.nio.ByteOrder;

public class BytesTransUtil {
    private static BytesTransUtil instance = null;
    private String TAG = "BytesTransUtil";

    private BytesTransUtil() {
    }

    public static BytesTransUtil getInstance() {
        if (instance == null) {
            instance = new BytesTransUtil();
        }
        return instance;
    }

    public boolean testCPU() {
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            return true;
        }
        return false;
    }

    public byte[] getBytes(short s, boolean z) {
        byte[] bArr = new byte[2];
        if (z) {
            for (int length = bArr.length - 1; length >= 0; length--) {
                bArr[length] = (byte) (s & 255);
                s = (short) (s >> 8);
            }
        } else {
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) (s & 255);
                s = (short) (s >> 8);
            }
        }
        return bArr;
    }

    public byte[] getBytes(int i, boolean z) {
        byte[] bArr = new byte[4];
        if (z) {
            for (int length = bArr.length - 1; length >= 0; length--) {
                bArr[length] = (byte) (i & 255);
                i >>= 8;
            }
        } else {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr[i2] = (byte) (i & 255);
                i >>= 8;
            }
        }
        return bArr;
    }

    public byte[] getBytes(long j, boolean z) {
        byte[] bArr = new byte[8];
        if (z) {
            for (int length = bArr.length - 1; length >= 0; length--) {
                bArr[length] = (byte) ((int) (j & 255));
                j >>= 8;
            }
        } else {
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) ((int) (j & 255));
                j >>= 8;
            }
        }
        return bArr;
    }

    public short getShort(byte[] bArr, boolean z) {
        if (bArr == null) {
            throw new IllegalArgumentException("byte array is null!");
        } else if (bArr.length <= 2) {
            short s = 0;
            if (z) {
                short s2 = 0;
                for (byte b : bArr) {
                    s2 = (short) (((short) (s2 << 8)) | (b & 255));
                }
                return s2;
            }
            for (int length = bArr.length - 1; length >= 0; length--) {
                s = (short) (((short) (s << 8)) | (bArr[length] & 255));
            }
            return s;
        } else {
            throw new IllegalArgumentException("byte array size > 2 !");
        }
    }

    public int getInt(byte[] bArr, boolean z) {
        if (bArr == null) {
            throw new IllegalArgumentException("byte array is null!");
        } else if (bArr.length <= 4) {
            int i = 0;
            if (z) {
                int i2 = 0;
                while (i < bArr.length) {
                    i2 = (i2 << 8) | (bArr[i] & 255);
                    i++;
                }
                return i2;
            }
            for (int length = bArr.length - 1; length >= 0; length--) {
                i = (i << 8) | (bArr[length] & 255);
            }
            return i;
        } else {
            throw new IllegalArgumentException("byte array size > 4 !");
        }
    }

    public long getLong(byte[] bArr, boolean z) {
        if (bArr == null) {
            throw new IllegalArgumentException("byte array is null!");
        } else if (bArr.length <= 8) {
            long j = 0;
            if (z) {
                for (byte b : bArr) {
                    j = (j << 8) | ((long) (b & 255));
                }
            } else {
                for (int length = bArr.length - 1; length >= 0; length--) {
                    j = (j << 8) | ((long) (bArr[length] & 255));
                }
            }
            return j;
        } else {
            throw new IllegalArgumentException("byte array size > 8 !");
        }
    }

    public byte[] getBytes(int i) {
        return getBytes(i, testCPU());
    }

    public byte[] getBytes(short s) {
        return getBytes(s, testCPU());
    }

    public byte[] getBytes(long j) {
        return getBytes(j, testCPU());
    }

    public int getInt(byte[] bArr) {
        return getInt(bArr, testCPU());
    }

    public short getShort(byte[] bArr) {
        return getShort(bArr, testCPU());
    }

    public long getLong(byte[] bArr) {
        return getLong(bArr, testCPU());
    }

    public short[] Bytes2Shorts(byte[] bArr) {
        short[] sArr = new short[(bArr.length / 2)];
        for (int i = 0; i < sArr.length; i++) {
            byte[] bArr2 = new byte[2];
            for (int i2 = 0; i2 < 2; i2++) {
                bArr2[i2] = bArr[(i * 2) + i2];
            }
            sArr[i] = getShort(bArr2);
        }
        return sArr;
    }

    public byte[] Shorts2Bytes(short[] sArr) {
        byte[] bArr = new byte[(sArr.length * 2)];
        for (int i = 0; i < sArr.length; i++) {
            byte[] bytes = getBytes(sArr[i]);
            for (int i2 = 0; i2 < 2; i2++) {
                bArr[(i * 2) + i2] = bytes[i2];
            }
        }
        return bArr;
    }

    public int[] Bytes2Ints(byte[] bArr) {
        int[] iArr = new int[(bArr.length / 4)];
        for (int i = 0; i < iArr.length; i++) {
            byte[] bArr2 = new byte[4];
            for (int i2 = 0; i2 < 4; i2++) {
                bArr2[i2] = bArr[(i * 4) + i2];
            }
            iArr[i] = getInt(bArr2);
        }
        return iArr;
    }

    public byte[] Ints2Bytes(int[] iArr) {
        byte[] bArr = new byte[(iArr.length * 4)];
        for (int i = 0; i < iArr.length; i++) {
            byte[] bytes = getBytes(iArr[i]);
            for (int i2 = 0; i2 < 4; i2++) {
                bArr[(i * 4) + i2] = bytes[i2];
            }
        }
        return bArr;
    }

    public long[] Bytes2Longs(byte[] bArr) {
        long[] jArr = new long[(bArr.length / 8)];
        for (int i = 0; i < jArr.length; i++) {
            byte[] bArr2 = new byte[8];
            for (int i2 = 0; i2 < 8; i2++) {
                bArr2[i2] = bArr[(i * 8) + i2];
            }
            jArr[i] = getLong(bArr2);
        }
        return jArr;
    }

    public byte[] Longs2Bytes(long[] jArr) {
        byte[] bArr = new byte[(jArr.length * 8)];
        for (int i = 0; i < jArr.length; i++) {
            byte[] bytes = getBytes(jArr[i]);
            for (int i2 = 0; i2 < 8; i2++) {
                bArr[(i * 8) + i2] = bytes[i2];
            }
        }
        return bArr;
    }
}
