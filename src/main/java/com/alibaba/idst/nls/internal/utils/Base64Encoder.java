package com.alibaba.idst.nls.internal.utils;

import java.util.Arrays;

public class Base64Encoder {
    private static final boolean doPadding = true;
    private static final int linemax = -1;
    private static final byte[] newline = null;
    private static final char[] toBase64 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    private static final int outLength(int i) {
        return ((i + 2) / 3) * 4;
    }

    private static int encode0(byte[] bArr, int i, int i2, byte[] bArr2) {
        char[] cArr = toBase64;
        int i3 = ((i2 - i) / 3) * 3;
        int i4 = i + i3;
        int i5 = 0;
        while (i < i4) {
            int min = Math.min(i + i3, i4);
            int i6 = i;
            int i7 = i5;
            while (i6 < min) {
                int i8 = i6 + 1;
                int i9 = i8 + 1;
                int i10 = ((bArr[i6] & 255) << 16) | ((bArr[i8] & 255) << 8);
                int i11 = i9 + 1;
                int i12 = i10 | (bArr[i9] & 255);
                int i13 = i7 + 1;
                bArr2[i7] = (byte) cArr[(i12 >>> 18) & 63];
                int i14 = i13 + 1;
                bArr2[i13] = (byte) cArr[(i12 >>> 12) & 63];
                int i15 = i14 + 1;
                bArr2[i14] = (byte) cArr[(i12 >>> 6) & 63];
                i7 = i15 + 1;
                bArr2[i15] = (byte) cArr[i12 & 63];
                i6 = i11;
            }
            int i16 = ((min - i) / 3) * 4;
            i5 += i16;
            if (i16 == -1 && min < i2) {
                byte[] bArr3 = newline;
                int length = bArr3.length;
                int i17 = i5;
                int i18 = 0;
                while (i18 < length) {
                    bArr2[i17] = bArr3[i18];
                    i18++;
                    i17++;
                }
                i5 = i17;
            }
            i = min;
        }
        if (i >= i2) {
            return i5;
        }
        int i19 = i + 1;
        int i20 = bArr[i] & 255;
        int i21 = i5 + 1;
        bArr2[i5] = (byte) cArr[i20 >> 2];
        if (i19 == i2) {
            int i22 = i21 + 1;
            bArr2[i21] = (byte) cArr[(i20 << 4) & 63];
            int i23 = i22 + 1;
            bArr2[i22] = 61;
            int i24 = i23 + 1;
            bArr2[i23] = 61;
            return i24;
        }
        int i25 = bArr[i19] & 255;
        int i26 = i21 + 1;
        bArr2[i21] = (byte) cArr[((i20 << 4) & 63) | (i25 >> 4)];
        int i27 = i26 + 1;
        bArr2[i26] = (byte) cArr[(i25 << 2) & 63];
        int i28 = i27 + 1;
        bArr2[i27] = 61;
        return i28;
    }

    public static String encode(byte[] bArr) {
        byte[] bArr2 = new byte[outLength(bArr.length)];
        int encode0 = encode0(bArr, 0, bArr.length, bArr2);
        if (encode0 != bArr2.length) {
            bArr2 = Arrays.copyOf(bArr2, encode0);
        }
        return new String(bArr2, 0, 0, bArr2.length);
    }
}
