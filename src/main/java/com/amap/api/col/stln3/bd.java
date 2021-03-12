package com.amap.api.col.stln3;

import android.support.v7.widget.ActivityChooserView;
import com.autonavi.amap.mapcore.tools.GLMapStaticValue;
import java.io.IOException;
import java.io.Writer;

/* compiled from: SerializeWriter */
public final class bd extends Writer {
    static final int[] e = {9, 99, GLMapStaticValue.MAPRENDER_CAN_STOP_AND_FULLSCREEN_RENDEROVER, 9999, 99999, 999999, 9999999, 99999999, 999999999, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED};
    static final char[] f = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static final char[] g = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
    static final char[] h = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static final char[] i = {'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
    static final byte[] j = new byte[161];
    static final byte[] k = new byte[161];
    static final char[] l = new char[93];
    public static final char[] m = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final ThreadLocal<char[]> n = new ThreadLocal<>();
    protected char[] a;
    protected int b;
    protected int c;
    protected final Writer d;

    static {
        byte[] bArr = j;
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        byte[] bArr2 = k;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i2 = 14; i2 <= 31; i2++) {
            j[i2] = 4;
            k[i2] = 4;
        }
        for (int i3 = 127; i3 < 160; i3++) {
            j[i3] = 4;
            k[i3] = 4;
        }
        char[] cArr = l;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = '\"';
        cArr[39] = '\'';
        cArr[47] = '/';
        cArr[92] = '\\';
    }

    public bd() {
        this((byte) 0);
    }

    private bd(byte b2) {
        this.d = null;
        this.c = a.e;
        this.a = n.get();
        ThreadLocal<char[]> threadLocal = n;
        if (threadLocal != null) {
            threadLocal.set(null);
        }
        if (this.a == null) {
            this.a = new char[1024];
        }
    }

    public bd(int i2, be[] beVarArr) {
        this.d = null;
        this.a = n.get();
        if (this.a != null) {
            n.set(null);
        }
        if (this.a == null) {
            this.a = new char[1024];
        }
        for (be beVar : beVarArr) {
            i2 |= beVar.w;
        }
        this.c = i2;
    }

    public final void a(be beVar) {
        this.c = beVar.w | this.c;
    }

    public final boolean b(be beVar) {
        return (beVar.w & this.c) != 0;
    }

    @Override // java.io.Writer
    public final void write(int i2) {
        int i3 = this.b + 1;
        if (i3 > this.a.length) {
            if (this.d == null) {
                a(i3);
            } else {
                flush();
                i3 = 1;
            }
        }
        this.a[this.b] = (char) i2;
        this.b = i3;
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i2, int i3) {
        int i4;
        if (i2 < 0 || i2 > cArr.length || i3 < 0 || (i4 = i2 + i3) > cArr.length || i4 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i3 != 0) {
            int i5 = this.b + i3;
            if (i5 > this.a.length) {
                if (this.d == null) {
                    a(i5);
                } else {
                    do {
                        char[] cArr2 = this.a;
                        int length = cArr2.length;
                        int i6 = this.b;
                        int i7 = length - i6;
                        System.arraycopy(cArr, i2, cArr2, i6, i7);
                        this.b = this.a.length;
                        flush();
                        i3 -= i7;
                        i2 += i7;
                    } while (i3 > this.a.length);
                    i5 = i3;
                }
            }
            System.arraycopy(cArr, i2, this.a, this.b, i3);
            this.b = i5;
        }
    }

    /* access modifiers changed from: protected */
    public final void a(int i2) {
        int length = ((this.a.length * 3) / 2) + 1;
        if (length >= i2) {
            i2 = length;
        }
        char[] cArr = new char[i2];
        System.arraycopy(this.a, 0, cArr, 0, this.b);
        this.a = cArr;
    }

    @Override // java.io.Writer
    public final void write(String str, int i2, int i3) {
        int i4;
        int i5 = this.b + i3;
        if (i5 > this.a.length) {
            if (this.d == null) {
                a(i5);
            } else {
                while (true) {
                    char[] cArr = this.a;
                    int length = cArr.length;
                    int i6 = this.b;
                    int i7 = length - i6;
                    i4 = i2 + i7;
                    str.getChars(i2, i4, cArr, i6);
                    this.b = this.a.length;
                    flush();
                    i3 -= i7;
                    if (i3 <= this.a.length) {
                        break;
                    }
                    i2 = i4;
                }
                i5 = i3;
                i2 = i4;
            }
        }
        str.getChars(i2, i3 + i2, this.a, this.b);
        this.b = i5;
    }

    /* renamed from: a */
    public final bd append(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "null" : charSequence.toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public bd append(CharSequence charSequence, int i2, int i3) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String charSequence2 = charSequence.subSequence(i2, i3).toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public bd append(char c2) {
        write(c2);
        return this;
    }

    public final String toString() {
        return new String(this.a, 0, this.b);
    }

    @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
    public final void close() {
        if (this.d != null && this.b > 0) {
            flush();
        }
        char[] cArr = this.a;
        if (cArr.length <= 8192) {
            n.set(cArr);
        }
        this.a = null;
    }

    @Override // java.io.Writer
    public final void write(String str) {
        while (str == null) {
            str = "null";
        }
        write(str, 0, str.length());
    }

    public final void b(int i2) {
        if (i2 == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int i3 = 0;
        while ((i2 < 0 ? -i2 : i2) > e[i3]) {
            i3++;
        }
        int i4 = i3 + 1;
        if (i2 < 0) {
            i4++;
        }
        int i5 = this.b + i4;
        if (i5 > this.a.length) {
            if (this.d == null) {
                a(i5);
            } else {
                char[] cArr = new char[i4];
                a((long) i2, i4, cArr);
                write(cArr, 0, cArr.length);
                return;
            }
        }
        a((long) i2, i5, this.a);
        this.b = i5;
    }

    public final void a(byte[] bArr) {
        int length = bArr.length;
        int i2 = 0;
        boolean z = (this.c & be.UseSingleQuotes.w) != 0;
        char c2 = z ? '\'' : '\"';
        if (length == 0) {
            write(z ? "''" : "\"\"");
            return;
        }
        char[] cArr = o.w;
        int i3 = (length / 3) * 3;
        int i4 = length - 1;
        int i5 = this.b;
        int i6 = (((i4 / 3) + 1) << 2) + i5 + 2;
        if (i6 > this.a.length) {
            if (this.d != null) {
                write(c2);
                int i7 = 0;
                while (i7 < i3) {
                    int i8 = i7 + 1;
                    int i9 = i8 + 1;
                    int i10 = ((bArr[i7] & 255) << 16) | ((bArr[i8] & 255) << 8) | (bArr[i9] & 255);
                    write(cArr[(i10 >>> 18) & 63]);
                    write(cArr[(i10 >>> 12) & 63]);
                    write(cArr[(i10 >>> 6) & 63]);
                    write(cArr[i10 & 63]);
                    i7 = i9 + 1;
                }
                int i11 = length - i3;
                if (i11 > 0) {
                    int i12 = (bArr[i3] & 255) << 10;
                    if (i11 == 2) {
                        i2 = (bArr[i4] & 255) << 2;
                    }
                    int i13 = i12 | i2;
                    write(cArr[i13 >> 12]);
                    write(cArr[(i13 >>> 6) & 63]);
                    write(i11 == 2 ? cArr[i13 & 63] : '=');
                    write(61);
                }
                write(c2);
                return;
            }
            a(i6);
        }
        this.b = i6;
        int i14 = i5 + 1;
        this.a[i5] = c2;
        int i15 = 0;
        while (i15 < i3) {
            int i16 = i15 + 1;
            int i17 = i16 + 1;
            int i18 = ((bArr[i15] & 255) << 16) | ((bArr[i16] & 255) << 8);
            int i19 = i17 + 1;
            int i20 = i18 | (bArr[i17] & 255);
            char[] cArr2 = this.a;
            int i21 = i14 + 1;
            cArr2[i14] = cArr[(i20 >>> 18) & 63];
            int i22 = i21 + 1;
            cArr2[i21] = cArr[(i20 >>> 12) & 63];
            int i23 = i22 + 1;
            cArr2[i22] = cArr[(i20 >>> 6) & 63];
            i14 = i23 + 1;
            cArr2[i23] = cArr[i20 & 63];
            i15 = i19;
        }
        int i24 = length - i3;
        if (i24 > 0) {
            int i25 = (bArr[i3] & 255) << 10;
            if (i24 == 2) {
                i2 = (bArr[i4] & 255) << 2;
            }
            int i26 = i25 | i2;
            char[] cArr3 = this.a;
            cArr3[i6 - 5] = cArr[i26 >> 12];
            cArr3[i6 - 4] = cArr[(i26 >>> 6) & 63];
            cArr3[i6 - 3] = i24 == 2 ? cArr[i26 & 63] : '=';
            this.a[i6 - 2] = '=';
        }
        this.a[i6 - 1] = c2;
    }

    public final void a(long j2) {
        if (j2 == Long.MIN_VALUE) {
            write("-9223372036854775808");
            return;
        }
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        long j3 = i2 < 0 ? -j2 : j2;
        int i3 = 1;
        long j4 = 10;
        while (true) {
            if (i3 >= 19) {
                i3 = 0;
                break;
            } else if (j3 < j4) {
                break;
            } else {
                j4 *= 10;
                i3++;
            }
        }
        if (i3 == 0) {
            i3 = 19;
        }
        if (i2 < 0) {
            i3++;
        }
        int i4 = this.b + i3;
        if (i4 > this.a.length) {
            if (this.d == null) {
                a(i4);
            } else {
                char[] cArr = new char[i3];
                a(j2, i3, cArr);
                write(cArr, 0, cArr.length);
                return;
            }
        }
        a(j2, i4, this.a);
        this.b = i4;
    }

    public final void a() {
        write("null");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x015a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0136  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r18, char r19, boolean r20) {
        /*
        // Method dump skipped, instructions count: 797
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.bd.a(java.lang.String, char, boolean):void");
    }

    public final void a(boolean z) {
        write(z ? "true" : "false");
    }

    public final void a(String str) {
        if ((this.c & be.UseSingleQuotes.w) != 0) {
            b(str);
        } else {
            a(str, (char) 0, true);
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        int i2 = 0;
        if (str == null) {
            int i3 = this.b + 4;
            if (i3 > this.a.length) {
                a(i3);
            }
            "null".getChars(0, 4, this.a, this.b);
            this.b = i3;
            return;
        }
        int length = str.length();
        int i4 = this.b + length + 2;
        if (i4 > this.a.length) {
            if (this.d != null) {
                write(39);
                while (i2 < str.length()) {
                    char charAt = str.charAt(i2);
                    if (charAt <= '\r' || charAt == '\\' || charAt == '\'' || (charAt == '/' && (this.c & be.WriteSlashAsSpecial.w) != 0)) {
                        write(92);
                        write(l[charAt]);
                    } else {
                        write(charAt);
                    }
                    i2++;
                }
                write(39);
                return;
            }
            a(i4);
        }
        int i5 = this.b;
        int i6 = i5 + 1;
        int i7 = i6 + length;
        char[] cArr = this.a;
        cArr[i5] = '\'';
        str.getChars(0, length, cArr, i6);
        this.b = i4;
        int i8 = -1;
        char c2 = 0;
        for (int i9 = i6; i9 < i7; i9++) {
            char c3 = this.a[i9];
            if (c3 <= '\r' || c3 == '\\' || c3 == '\'' || (c3 == '/' && (this.c & be.WriteSlashAsSpecial.w) != 0)) {
                i2++;
                i8 = i9;
                c2 = c3;
            }
        }
        int i10 = i4 + i2;
        if (i10 > this.a.length) {
            a(i10);
        }
        this.b = i10;
        if (i2 == 1) {
            char[] cArr2 = this.a;
            int i11 = i8 + 1;
            System.arraycopy(cArr2, i11, cArr2, i8 + 2, (i7 - i8) - 1);
            char[] cArr3 = this.a;
            cArr3[i8] = '\\';
            cArr3[i11] = l[c2];
        } else if (i2 > 1) {
            char[] cArr4 = this.a;
            int i12 = i8 + 1;
            System.arraycopy(cArr4, i12, cArr4, i8 + 2, (i7 - i8) - 1);
            char[] cArr5 = this.a;
            cArr5[i8] = '\\';
            cArr5[i12] = l[c2];
            int i13 = i7 + 1;
            for (int i14 = i12 - 2; i14 >= i6; i14--) {
                char c4 = this.a[i14];
                if (c4 <= '\r' || c4 == '\\' || c4 == '\'' || (c4 == '/' && (this.c & be.WriteSlashAsSpecial.w) != 0)) {
                    char[] cArr6 = this.a;
                    int i15 = i14 + 1;
                    System.arraycopy(cArr6, i15, cArr6, i14 + 2, (i13 - i14) - 1);
                    char[] cArr7 = this.a;
                    cArr7[i14] = '\\';
                    cArr7[i15] = l[c4];
                    i13++;
                }
            }
        }
        this.a[this.b - 1] = '\'';
    }

    public final void a(String str, boolean z) {
        int i2 = 0;
        boolean z2 = true;
        if ((this.c & be.UseSingleQuotes.w) != 0) {
            if ((this.c & be.QuoteFieldNames.w) != 0) {
                b(str);
                write(58);
                return;
            }
            int length = str.length();
            int i3 = this.b + length + 1;
            if (i3 > this.a.length) {
                if (this.d == null) {
                    a(i3);
                } else if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                } else {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            z2 = false;
                            break;
                        }
                        char charAt = str.charAt(i4);
                        byte[] bArr = k;
                        if (charAt < bArr.length && bArr[charAt] != 0) {
                            break;
                        }
                        i4++;
                    }
                    if (z2) {
                        write(39);
                    }
                    while (i2 < length) {
                        char charAt2 = str.charAt(i2);
                        byte[] bArr2 = k;
                        if (charAt2 < bArr2.length && bArr2[charAt2] != 0) {
                            write(92);
                            charAt2 = l[charAt2];
                        }
                        write(charAt2);
                        i2++;
                    }
                    if (z2) {
                        write(39);
                    }
                    write(58);
                    return;
                }
            }
            if (length == 0) {
                int i5 = this.b;
                if (i5 + 3 > this.a.length) {
                    a(i5 + 3);
                }
                char[] cArr = this.a;
                int i6 = this.b;
                this.b = i6 + 1;
                cArr[i6] = '\'';
                int i7 = this.b;
                this.b = i7 + 1;
                cArr[i7] = '\'';
                int i8 = this.b;
                this.b = i8 + 1;
                cArr[i8] = ':';
                return;
            }
            int i9 = this.b;
            int i10 = i9 + length;
            str.getChars(0, length, this.a, i9);
            this.b = i3;
            int i11 = i9;
            boolean z3 = false;
            while (i11 < i10) {
                char[] cArr2 = this.a;
                char c2 = cArr2[i11];
                byte[] bArr3 = k;
                if (c2 < bArr3.length && bArr3[c2] != 0) {
                    if (!z3) {
                        i3 += 3;
                        if (i3 > cArr2.length) {
                            a(i3);
                        }
                        this.b = i3;
                        char[] cArr3 = this.a;
                        int i12 = i11 + 1;
                        System.arraycopy(cArr3, i12, cArr3, i11 + 3, (i10 - i11) - 1);
                        char[] cArr4 = this.a;
                        System.arraycopy(cArr4, 0, cArr4, 1, i11);
                        char[] cArr5 = this.a;
                        cArr5[i9] = '\'';
                        cArr5[i12] = '\\';
                        int i13 = i12 + 1;
                        cArr5[i13] = l[c2];
                        i10 += 2;
                        cArr5[this.b - 2] = '\'';
                        i11 = i13;
                        z3 = true;
                    } else {
                        i3++;
                        if (i3 > cArr2.length) {
                            a(i3);
                        }
                        this.b = i3;
                        char[] cArr6 = this.a;
                        int i14 = i11 + 1;
                        System.arraycopy(cArr6, i14, cArr6, i11 + 2, i10 - i11);
                        char[] cArr7 = this.a;
                        cArr7[i11] = '\\';
                        cArr7[i14] = l[c2];
                        i10++;
                        i11 = i14;
                    }
                }
                i11++;
            }
            this.a[i3 - 1] = ':';
        } else if ((this.c & be.QuoteFieldNames.w) != 0) {
            a(str, ':', z);
        } else {
            int length2 = str.length();
            int i15 = this.b + length2 + 1;
            if (i15 > this.a.length) {
                if (this.d == null) {
                    a(i15);
                } else if (length2 == 0) {
                    write(34);
                    write(34);
                    write(58);
                    return;
                } else {
                    int i16 = 0;
                    while (true) {
                        if (i16 >= length2) {
                            z2 = false;
                            break;
                        }
                        char charAt3 = str.charAt(i16);
                        byte[] bArr4 = j;
                        if (charAt3 < bArr4.length && bArr4[charAt3] != 0) {
                            break;
                        }
                        i16++;
                    }
                    if (z2) {
                        write(34);
                    }
                    while (i2 < length2) {
                        char charAt4 = str.charAt(i2);
                        byte[] bArr5 = j;
                        if (charAt4 < bArr5.length && bArr5[charAt4] != 0) {
                            write(92);
                            charAt4 = l[charAt4];
                        }
                        write(charAt4);
                        i2++;
                    }
                    if (z2) {
                        write(34);
                    }
                    write(58);
                    return;
                }
            }
            if (length2 == 0) {
                int i17 = this.b;
                if (i17 + 3 > this.a.length) {
                    a(i17 + 3);
                }
                char[] cArr8 = this.a;
                int i18 = this.b;
                this.b = i18 + 1;
                cArr8[i18] = '\"';
                int i19 = this.b;
                this.b = i19 + 1;
                cArr8[i19] = '\"';
                int i20 = this.b;
                this.b = i20 + 1;
                cArr8[i20] = ':';
                return;
            }
            int i21 = this.b;
            int i22 = i21 + length2;
            str.getChars(0, length2, this.a, i21);
            this.b = i15;
            int i23 = i21;
            boolean z4 = false;
            while (i23 < i22) {
                char[] cArr9 = this.a;
                char c3 = cArr9[i23];
                byte[] bArr6 = j;
                if (c3 < bArr6.length && bArr6[c3] != 0) {
                    if (!z4) {
                        i15 += 3;
                        if (i15 > cArr9.length) {
                            a(i15);
                        }
                        this.b = i15;
                        char[] cArr10 = this.a;
                        int i24 = i23 + 1;
                        System.arraycopy(cArr10, i24, cArr10, i23 + 3, (i22 - i23) - 1);
                        char[] cArr11 = this.a;
                        System.arraycopy(cArr11, 0, cArr11, 1, i23);
                        char[] cArr12 = this.a;
                        cArr12[i21] = '\"';
                        cArr12[i24] = '\\';
                        int i25 = i24 + 1;
                        cArr12[i25] = l[c3];
                        i22 += 2;
                        cArr12[this.b - 2] = '\"';
                        i23 = i25;
                        z4 = true;
                    } else {
                        i15++;
                        if (i15 > cArr9.length) {
                            a(i15);
                        }
                        this.b = i15;
                        char[] cArr13 = this.a;
                        int i26 = i23 + 1;
                        System.arraycopy(cArr13, i26, cArr13, i23 + 2, i22 - i23);
                        char[] cArr14 = this.a;
                        cArr14[i23] = '\\';
                        cArr14[i26] = l[c3];
                        i22++;
                        i23 = i26;
                    }
                }
                i23++;
            }
            this.a[this.b - 1] = ':';
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        Writer writer = this.d;
        if (writer != null) {
            try {
                writer.write(this.a, 0, this.b);
                this.d.flush();
                this.b = 0;
            } catch (IOException e2) {
                throw new d(e2.getMessage(), e2);
            }
        }
    }

    protected static void a(long j2, int i2, char[] cArr) {
        char c2;
        if (j2 < 0) {
            c2 = '-';
            j2 = -j2;
        } else {
            c2 = 0;
        }
        while (j2 > 2147483647L) {
            long j3 = j2 / 100;
            int i3 = (int) (j2 - (((j3 << 6) + (j3 << 5)) + (j3 << 2)));
            int i4 = i2 - 1;
            cArr[i4] = h[i3];
            i2 = i4 - 1;
            cArr[i2] = g[i3];
            j2 = j3;
        }
        int i5 = (int) j2;
        while (i5 >= 65536) {
            int i6 = i5 / 100;
            int i7 = i5 - (((i6 << 6) + (i6 << 5)) + (i6 << 2));
            int i8 = i2 - 1;
            cArr[i8] = h[i7];
            i2 = i8 - 1;
            cArr[i2] = g[i7];
            i5 = i6;
        }
        while (true) {
            int i9 = (52429 * i5) >>> 19;
            i2--;
            cArr[i2] = f[i5 - ((i9 << 3) + (i9 << 1))];
            if (i9 == 0) {
                break;
            }
            i5 = i9;
        }
        if (c2 != 0) {
            cArr[i2 - 1] = c2;
        }
    }
}
