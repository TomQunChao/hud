package com.amap.api.col.stln3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: JSONLexer */
public final class o {
    private static boolean A;
    private static final ThreadLocal<char[]> B = new ThreadLocal<>();
    protected static final int[] v = new int[103];
    public static final char[] w = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    static final int[] x;
    public static final boolean[] y = new boolean[256];
    public static final boolean[] z = new boolean[256];
    protected int a;
    protected int b;
    public int c;
    protected char d;
    protected int e;
    protected int f;
    protected char[] g;
    protected int h;
    protected boolean i;
    protected boolean j;
    protected int k;
    protected boolean l;
    public TimeZone m;
    public Locale n;
    public Calendar o;
    public int p;
    protected final String q;
    protected final int r;
    protected String s;
    public boolean t;
    protected long u;

    static {
        int i2;
        try {
            i2 = Class.forName("android.os.Build$VERSION").getField("SDK_INT").getInt(null);
        } catch (Exception e2) {
            i2 = -1;
        }
        char c2 = 0;
        A = i2 >= 23;
        for (int i3 = 48; i3 <= 57; i3++) {
            v[i3] = i3 - 48;
        }
        for (int i4 = 97; i4 <= 102; i4++) {
            v[i4] = (i4 - 97) + 10;
        }
        for (int i5 = 65; i5 <= 70; i5++) {
            v[i5] = (i5 - 65) + 10;
        }
        int[] iArr = new int[256];
        x = iArr;
        Arrays.fill(iArr, -1);
        int length = w.length;
        for (int i6 = 0; i6 < length; i6++) {
            x[w[i6]] = i6;
        }
        x[61] = 0;
        char c3 = 0;
        while (true) {
            boolean[] zArr = y;
            if (c3 >= zArr.length) {
                break;
            }
            if (c3 >= 'A' && c3 <= 'Z') {
                zArr[c3] = true;
            } else if (c3 >= 'a' && c3 <= 'z') {
                y[c3] = true;
            } else if (c3 == '_') {
                y[c3] = true;
            }
            c3 = (char) (c3 + 1);
        }
        while (true) {
            boolean[] zArr2 = z;
            if (c2 < zArr2.length) {
                if (c2 >= 'A' && c2 <= 'Z') {
                    zArr2[c2] = true;
                } else if (c2 >= 'a' && c2 <= 'z') {
                    z[c2] = true;
                } else if (c2 == '_') {
                    z[c2] = true;
                } else if (c2 >= '0' && c2 <= '9') {
                    z[c2] = true;
                }
                c2 = (char) (c2 + 1);
            } else {
                return;
            }
        }
    }

    public o(String str) {
        this(str, a.c);
    }

    public o(String str, int i2) {
        char c2;
        this.c = a.c;
        boolean z2 = false;
        this.i = false;
        this.j = false;
        this.m = a.a;
        this.n = a.b;
        String str2 = null;
        this.o = null;
        this.p = 0;
        this.g = B.get();
        if (this.g == null) {
            this.g = new char[512];
        }
        this.c = i2;
        this.q = str;
        this.r = this.q.length();
        this.e = -1;
        int i3 = this.e + 1;
        this.e = i3;
        if (i3 >= this.r) {
            c2 = 26;
        } else {
            c2 = this.q.charAt(i3);
        }
        this.d = c2;
        if (this.d == 65279) {
            c();
        }
        this.s = (n.InitStringFieldAsEmpty.s & i2) != 0 ? "" : str2;
        this.t = (n.DisableCircularReferenceDetect.s & i2) != 0 ? true : z2;
    }

    public final int a() {
        return this.a;
    }

    public final void b() {
        char[] cArr = this.g;
        if (cArr.length <= 8196) {
            B.set(cArr);
        }
        this.g = null;
    }

    public final char c() {
        char c2;
        int i2 = this.e + 1;
        this.e = i2;
        if (i2 >= this.r) {
            c2 = 26;
        } else {
            c2 = this.q.charAt(i2);
        }
        this.d = c2;
        return c2;
    }

    public final boolean a(n nVar) {
        return (nVar.s & this.c) != 0;
    }

    public final void d() {
        char c2;
        this.h = 0;
        while (true) {
            char c3 = this.d;
            if (c3 == ':') {
                int i2 = this.e + 1;
                this.e = i2;
                if (i2 >= this.r) {
                    c2 = 26;
                } else {
                    c2 = this.q.charAt(i2);
                }
                this.d = c2;
                f();
                return;
            } else if (c3 == ' ' || c3 == '\n' || c3 == '\r' || c3 == '\t' || c3 == '\f' || c3 == '\b') {
                c();
            } else {
                throw new d("not match : - " + this.d);
            }
        }
    }

    public final String e() {
        char charAt = this.q.charAt((this.k + this.h) - 1);
        int i2 = this.h;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i2--;
        }
        return a(this.k, i2);
    }

    private char b(int i2) {
        if (i2 >= this.r) {
            return 26;
        }
        return this.q.charAt(i2);
    }

    public final void f() {
        char c2;
        int i2 = 0;
        this.h = 0;
        while (true) {
            this.b = this.e;
            char c3 = this.d;
            if (c3 == '/') {
                v();
            } else if (c3 == '\"') {
                i();
                return;
            } else if ((c3 < '0' || c3 > '9') && (c2 = this.d) != '-') {
                if (c2 == ',') {
                    c();
                    this.a = 16;
                    return;
                }
                char c4 = 26;
                switch (c2) {
                    case '\b':
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        c();
                        continue;
                    case '\'':
                        i();
                        return;
                    case '(':
                        c();
                        this.a = 10;
                        return;
                    case ')':
                        c();
                        this.a = 11;
                        return;
                    case ':':
                        c();
                        this.a = 17;
                        return;
                    case 'S':
                    case 'T':
                    case 'u':
                        w();
                        return;
                    case '[':
                        int i3 = this.e + 1;
                        this.e = i3;
                        if (i3 < this.r) {
                            c4 = this.q.charAt(i3);
                        }
                        this.d = c4;
                        this.a = 14;
                        return;
                    case ']':
                        c();
                        this.a = 15;
                        return;
                    case 'f':
                        if (this.q.startsWith("false", this.e)) {
                            this.e += 5;
                            this.d = b(this.e);
                            char c5 = this.d;
                            if (c5 == ' ' || c5 == ',' || c5 == '}' || c5 == ']' || c5 == '\n' || c5 == '\r' || c5 == '\t' || c5 == 26 || c5 == '\f' || c5 == '\b' || c5 == ':') {
                                this.a = 7;
                                return;
                            }
                        }
                        throw new d("scan false error");
                    case 'n':
                        if (this.q.startsWith("null", this.e)) {
                            this.e += 4;
                            i2 = 8;
                        } else if (this.q.startsWith("new", this.e)) {
                            this.e += 3;
                            i2 = 9;
                        }
                        if (i2 != 0) {
                            this.d = b(this.e);
                            char c6 = this.d;
                            if (c6 == ' ' || c6 == ',' || c6 == '}' || c6 == ']' || c6 == '\n' || c6 == '\r' || c6 == '\t' || c6 == 26 || c6 == '\f' || c6 == '\b') {
                                this.a = i2;
                                return;
                            }
                        }
                        throw new d("scan null/new error");
                    case 't':
                        if (this.q.startsWith("true", this.e)) {
                            this.e += 4;
                            this.d = b(this.e);
                            char c7 = this.d;
                            if (c7 == ' ' || c7 == ',' || c7 == '}' || c7 == ']' || c7 == '\n' || c7 == '\r' || c7 == '\t' || c7 == 26 || c7 == '\f' || c7 == '\b' || c7 == ':') {
                                this.a = 6;
                                return;
                            }
                        }
                        throw new d("scan true error");
                    case '{':
                        int i4 = this.e + 1;
                        this.e = i4;
                        if (i4 < this.r) {
                            c4 = this.q.charAt(i4);
                        }
                        this.d = c4;
                        this.a = 12;
                        return;
                    case '}':
                        int i5 = this.e + 1;
                        this.e = i5;
                        if (i5 < this.r) {
                            c4 = this.q.charAt(i5);
                        }
                        this.d = c4;
                        this.a = 13;
                        return;
                    default:
                        int i6 = this.e;
                        int i7 = this.r;
                        if (!(i6 == i7 || (c2 == 26 && i6 + 1 == i7))) {
                            char c8 = this.d;
                            if (c8 <= 31 || c8 == 127) {
                                c();
                                continue;
                            } else {
                                this.a = 1;
                                c();
                                return;
                            }
                        } else if (this.a != 20) {
                            this.a = 20;
                            int i8 = this.f;
                            this.e = i8;
                            this.b = i8;
                            return;
                        } else {
                            throw new d("EOF error");
                        }
                }
            }
        }
        p();
    }

    public final void a(int i2) {
        this.h = 0;
        while (true) {
            if (i2 != 2) {
                char c2 = 26;
                if (i2 == 4) {
                    char c3 = this.d;
                    if (c3 == '\"') {
                        this.b = this.e;
                        i();
                        return;
                    } else if (c3 >= '0' && c3 <= '9') {
                        this.b = this.e;
                        p();
                        return;
                    } else if (this.d == '{') {
                        this.a = 12;
                        int i3 = this.e + 1;
                        this.e = i3;
                        if (i3 < this.r) {
                            c2 = this.q.charAt(i3);
                        }
                        this.d = c2;
                        return;
                    }
                } else if (i2 == 12) {
                    char c4 = this.d;
                    if (c4 == '{') {
                        this.a = 12;
                        int i4 = this.e + 1;
                        this.e = i4;
                        if (i4 < this.r) {
                            c2 = this.q.charAt(i4);
                        }
                        this.d = c2;
                        return;
                    } else if (c4 == '[') {
                        this.a = 14;
                        int i5 = this.e + 1;
                        this.e = i5;
                        if (i5 < this.r) {
                            c2 = this.q.charAt(i5);
                        }
                        this.d = c2;
                        return;
                    }
                } else if (i2 != 18) {
                    if (i2 != 20) {
                        switch (i2) {
                            case 14:
                                char c5 = this.d;
                                if (c5 == '[') {
                                    this.a = 14;
                                    c();
                                    return;
                                } else if (c5 == '{') {
                                    this.a = 12;
                                    c();
                                    return;
                                }
                                break;
                            case 15:
                                if (this.d == ']') {
                                    this.a = 15;
                                    c();
                                    return;
                                }
                                break;
                            case 16:
                                char c6 = this.d;
                                if (c6 == ',') {
                                    this.a = 16;
                                    int i6 = this.e + 1;
                                    this.e = i6;
                                    if (i6 < this.r) {
                                        c2 = this.q.charAt(i6);
                                    }
                                    this.d = c2;
                                    return;
                                } else if (c6 == '}') {
                                    this.a = 13;
                                    int i7 = this.e + 1;
                                    this.e = i7;
                                    if (i7 < this.r) {
                                        c2 = this.q.charAt(i7);
                                    }
                                    this.d = c2;
                                    return;
                                } else if (c6 == ']') {
                                    this.a = 15;
                                    int i8 = this.e + 1;
                                    this.e = i8;
                                    if (i8 < this.r) {
                                        c2 = this.q.charAt(i8);
                                    }
                                    this.d = c2;
                                    return;
                                } else if (c6 == 26) {
                                    this.a = 20;
                                    return;
                                }
                                break;
                        }
                    }
                    if (this.d == 26) {
                        this.a = 20;
                        return;
                    }
                } else {
                    while (true) {
                        char c7 = this.d;
                        if (c7 <= ' ' && (c7 == ' ' || c7 == '\n' || c7 == '\r' || c7 == '\t' || c7 == '\f' || c7 == '\b')) {
                            c();
                        } else {
                            char c8 = this.d;
                            if (c8 == '_' || Character.isLetter(c8)) {
                                w();
                                return;
                            } else {
                                f();
                                return;
                            }
                        }
                    }
                }
            } else {
                char c9 = this.d;
                if (c9 < '0' || c9 > '9') {
                    char c10 = this.d;
                    if (c10 == '\"') {
                        this.b = this.e;
                        i();
                        return;
                    } else if (c10 == '[') {
                        this.a = 14;
                        c();
                        return;
                    } else if (c10 == '{') {
                        this.a = 12;
                        c();
                        return;
                    }
                } else {
                    this.b = this.e;
                    p();
                    return;
                }
            }
            char c11 = this.d;
            if (c11 == ' ' || c11 == '\n' || c11 == '\r' || c11 == '\t' || c11 == '\f' || c11 == '\b') {
                c();
            } else {
                f();
                return;
            }
        }
    }

    public final Number g() throws NumberFormatException {
        char c2;
        char c3;
        char c4;
        boolean z2;
        long j2;
        long j3;
        char c5;
        char c6;
        int i2 = this.k;
        int i3 = this.h + i2;
        int i4 = i3 - 1;
        if (i4 >= this.r) {
            c2 = 26;
        } else {
            c2 = this.q.charAt(i4);
        }
        if (c2 == 'B') {
            i3--;
            c3 = 'B';
        } else if (c2 == 'L') {
            i3--;
            c3 = 'L';
        } else if (c2 != 'S') {
            c3 = ' ';
        } else {
            i3--;
            c3 = 'S';
        }
        int i5 = this.k;
        if (i5 >= this.r) {
            c4 = 26;
        } else {
            c4 = this.q.charAt(i5);
        }
        if (c4 == '-') {
            j2 = Long.MIN_VALUE;
            i2++;
            z2 = true;
        } else {
            j2 = -9223372036854775807L;
            z2 = false;
        }
        if (i2 < i3) {
            int i6 = i2 + 1;
            if (i2 >= this.r) {
                c6 = 26;
            } else {
                c6 = this.q.charAt(i2);
            }
            j3 = (long) (-(c6 - '0'));
            i2 = i6;
        } else {
            j3 = 0;
        }
        while (i2 < i3) {
            int i7 = i2 + 1;
            if (i2 >= this.r) {
                c5 = 26;
            } else {
                c5 = this.q.charAt(i2);
            }
            int i8 = c5 - '0';
            if (j3 < -922337203685477580L) {
                return new BigInteger(e());
            }
            long j4 = j3 * 10;
            long j5 = (long) i8;
            if (j4 < j2 + j5) {
                return new BigInteger(e());
            }
            j3 = j4 - j5;
            i2 = i7;
        }
        if (!z2) {
            long j6 = -j3;
            if (j6 > 2147483647L || c3 == 'L') {
                return Long.valueOf(j6);
            }
            if (c3 == 'S') {
                return Short.valueOf((short) ((int) j6));
            }
            if (c3 == 'B') {
                return Byte.valueOf((byte) ((int) j6));
            }
            return Integer.valueOf((int) j6);
        } else if (i2 <= this.k + 1) {
            throw new NumberFormatException(e());
        } else if (j3 < -2147483648L || c3 == 'L') {
            return Long.valueOf(j3);
        } else {
            if (c3 == 'S') {
                return Short.valueOf((short) ((int) j3));
            }
            if (c3 == 'B') {
                return Byte.valueOf((byte) ((int) j3));
            }
            return Integer.valueOf((int) j3);
        }
    }

    public final String a(y yVar) {
        char c2;
        while (true) {
            c2 = this.d;
            if (c2 != ' ' && c2 != '\n' && c2 != '\r' && c2 != '\t' && c2 != '\f' && c2 != '\b') {
                break;
            }
            c();
        }
        if (c2 == '\"') {
            return a(yVar, '\"');
        }
        if (c2 == '\'') {
            return a(yVar, '\'');
        }
        if (c2 == '}') {
            c();
            this.a = 13;
            return null;
        } else if (c2 == ',') {
            c();
            this.a = 16;
            return null;
        } else if (c2 != 26) {
            return b(yVar);
        } else {
            this.a = 20;
            return null;
        }
    }

    public final String a(y yVar, char c2) {
        String str;
        char c3;
        int i2 = this.e + 1;
        int indexOf = this.q.indexOf(c2, i2);
        if (indexOf != -1) {
            int i3 = indexOf - i2;
            char[] b2 = b(this.e + 1, i3);
            int i4 = indexOf;
            boolean z2 = false;
            while (i3 > 0 && b2[i3 - 1] == '\\') {
                int i5 = i3 - 2;
                int i6 = 1;
                while (i5 >= 0 && b2[i5] == '\\') {
                    i6++;
                    i5--;
                }
                if (i6 % 2 == 0) {
                    break;
                }
                int indexOf2 = this.q.indexOf(c2, i4 + 1);
                int i7 = (indexOf2 - i4) + i3;
                if (i7 >= b2.length) {
                    int length = (b2.length * 3) / 2;
                    if (length < i7) {
                        length = i7;
                    }
                    char[] cArr = new char[length];
                    System.arraycopy(b2, 0, cArr, 0, b2.length);
                    b2 = cArr;
                }
                this.q.getChars(i4, indexOf2, b2, i3);
                i4 = indexOf2;
                i3 = i7;
                z2 = true;
            }
            if (!z2) {
                int i8 = 0;
                for (int i9 = 0; i9 < i3; i9++) {
                    char c4 = b2[i9];
                    i8 = (i8 * 31) + c4;
                    if (c4 == '\\') {
                        z2 = true;
                    }
                }
                if (z2) {
                    str = a(b2, i3);
                } else {
                    str = i3 < 20 ? yVar.a(b2, i3, i8) : new String(b2, 0, i3);
                }
            } else {
                str = a(b2, i3);
            }
            this.e = i4 + 1;
            int i10 = this.e;
            if (i10 >= this.r) {
                c3 = 26;
            } else {
                c3 = this.q.charAt(i10);
            }
            this.d = c3;
            return str;
        }
        throw new d("unclosed str, " + h());
    }

    private static String a(char[] cArr, int i2) {
        char[] cArr2 = new char[i2];
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            char c2 = cArr[i3];
            if (c2 != '\\') {
                cArr2[i4] = c2;
                i4++;
            } else {
                i3++;
                char c3 = cArr[i3];
                switch (c3) {
                    case '/':
                        cArr2[i4] = '/';
                        i4++;
                        continue;
                    case '0':
                        cArr2[i4] = 0;
                        i4++;
                        continue;
                    case '1':
                        cArr2[i4] = 1;
                        i4++;
                        continue;
                    case '2':
                        cArr2[i4] = 2;
                        i4++;
                        continue;
                    case '3':
                        cArr2[i4] = 3;
                        i4++;
                        continue;
                    case '4':
                        cArr2[i4] = 4;
                        i4++;
                        continue;
                    case '5':
                        cArr2[i4] = 5;
                        i4++;
                        continue;
                    case '6':
                        cArr2[i4] = 6;
                        i4++;
                        continue;
                    case '7':
                        cArr2[i4] = 7;
                        i4++;
                        continue;
                    default:
                        switch (c3) {
                            case 't':
                                cArr2[i4] = '\t';
                                i4++;
                                continue;
                            case 'u':
                                int i5 = i3 + 1;
                                int i6 = i5 + 1;
                                int i7 = i6 + 1;
                                i3 = i7 + 1;
                                cArr2[i4] = (char) Integer.parseInt(new String(new char[]{cArr[i5], cArr[i6], cArr[i7], cArr[i3]}), 16);
                                i4++;
                                continue;
                            case 'v':
                                cArr2[i4] = 11;
                                i4++;
                                continue;
                            default:
                                switch (c3) {
                                    case '\"':
                                        cArr2[i4] = '\"';
                                        i4++;
                                        continue;
                                    case '\'':
                                        cArr2[i4] = '\'';
                                        i4++;
                                        continue;
                                    case 'F':
                                    case 'f':
                                        cArr2[i4] = '\f';
                                        i4++;
                                        continue;
                                    case '\\':
                                        cArr2[i4] = '\\';
                                        i4++;
                                        continue;
                                    case 'b':
                                        cArr2[i4] = '\b';
                                        i4++;
                                        continue;
                                    case 'n':
                                        cArr2[i4] = '\n';
                                        i4++;
                                        continue;
                                    case 'r':
                                        cArr2[i4] = '\r';
                                        i4++;
                                        continue;
                                    case 'x':
                                        int[] iArr = v;
                                        int i8 = i3 + 1;
                                        i3 = i8 + 1;
                                        cArr2[i4] = (char) ((iArr[cArr[i8]] * 16) + iArr[cArr[i3]]);
                                        i4++;
                                        continue;
                                        continue;
                                        continue;
                                    default:
                                        throw new d("unclosed.str.lit");
                                }
                        }
                }
            }
            i3++;
        }
        return new String(cArr2, 0, i4);
    }

    public final String h() {
        String str;
        StringBuilder sb = new StringBuilder("pos ");
        sb.append(this.e);
        sb.append(", json : ");
        if (this.r < 65536) {
            str = this.q;
        } else {
            str = this.q.substring(0, 65536);
        }
        sb.append(str);
        return sb.toString();
    }

    private void v() {
        c();
        char c2 = this.d;
        if (c2 == '/') {
            do {
                c();
            } while (this.d != '\n');
            c();
        } else if (c2 == '*') {
            c();
            while (true) {
                char c3 = this.d;
                if (c3 == 26) {
                    return;
                }
                if (c3 == '*') {
                    c();
                    if (this.d == '/') {
                        c();
                        return;
                    }
                } else {
                    c();
                }
            }
        } else {
            throw new d("invalid comment");
        }
    }

    public final String b(y yVar) {
        int i2 = this.d;
        boolean[] zArr = y;
        if (i2 >= zArr.length || zArr[i2]) {
            this.k = this.e;
            this.h = 1;
            while (true) {
                char c2 = c();
                boolean[] zArr2 = z;
                if (c2 < zArr2.length && !zArr2[c2]) {
                    break;
                }
                i2 = (i2 * 31) + c2;
                this.h++;
            }
            this.d = b(this.e);
            this.a = 18;
            if (this.h != 4 || !this.q.startsWith("null", this.k)) {
                return yVar.a(this.q, this.k, this.h, i2);
            }
            return null;
        }
        throw new d("illegal identifier : " + this.d + ", " + h());
    }

    public final void i() {
        char c2;
        char c3 = this.d;
        int i2 = this.e + 1;
        int indexOf = this.q.indexOf(c3, i2);
        if (indexOf != -1) {
            int i3 = indexOf - i2;
            char[] b2 = b(this.e + 1, i3);
            int i4 = indexOf;
            boolean z2 = false;
            while (i3 > 0 && b2[i3 - 1] == '\\') {
                int i5 = i3 - 2;
                int i6 = 1;
                while (i5 >= 0 && b2[i5] == '\\') {
                    i6++;
                    i5--;
                }
                if (i6 % 2 == 0) {
                    break;
                }
                int indexOf2 = this.q.indexOf(c3, i4 + 1);
                int i7 = (indexOf2 - i4) + i3;
                if (i7 >= b2.length) {
                    int length = (b2.length * 3) / 2;
                    if (length < i7) {
                        length = i7;
                    }
                    char[] cArr = new char[length];
                    System.arraycopy(b2, 0, cArr, 0, b2.length);
                    b2 = cArr;
                }
                this.q.getChars(i4, indexOf2, b2, i3);
                i4 = indexOf2;
                i3 = i7;
                z2 = true;
            }
            if (!z2) {
                for (int i8 = 0; i8 < i3; i8++) {
                    if (b2[i8] == '\\') {
                        z2 = true;
                    }
                }
            }
            this.g = b2;
            this.h = i3;
            this.k = this.e;
            this.l = z2;
            this.e = i4 + 1;
            int i9 = this.e;
            if (i9 >= this.r) {
                c2 = 26;
            } else {
                c2 = this.q.charAt(i9);
            }
            this.d = c2;
            this.a = 4;
            return;
        }
        throw new d("unclosed str, " + h());
    }

    public final String j() {
        String str;
        char c2;
        int i2 = this.e + 1;
        int indexOf = this.q.indexOf(34, i2);
        if (indexOf != -1) {
            if (A) {
                str = this.q.substring(i2, indexOf);
            } else {
                int i3 = indexOf - i2;
                str = new String(b(this.e + 1, i3), 0, i3);
            }
            if (str.indexOf(92) != -1) {
                while (true) {
                    int i4 = indexOf - 1;
                    int i5 = 0;
                    while (i4 >= 0 && this.q.charAt(i4) == '\\') {
                        i5++;
                        i4--;
                    }
                    if (i5 % 2 == 0) {
                        break;
                    }
                    indexOf = this.q.indexOf(34, indexOf + 1);
                }
                int i6 = indexOf - i2;
                str = a(b(this.e + 1, i6), i6);
            }
            this.e = indexOf + 1;
            int i7 = this.e;
            if (i7 >= this.r) {
                c2 = 26;
            } else {
                c2 = this.q.charAt(i7);
            }
            this.d = c2;
            return str;
        }
        throw new d("unclosed str, " + h());
    }

    public final int k() {
        char c2;
        int i2;
        boolean z2;
        int i3;
        char c3;
        char c4;
        int i4 = this.k;
        int i5 = this.h + i4;
        if (i4 >= this.r) {
            c2 = 26;
        } else {
            c2 = this.q.charAt(i4);
        }
        int i6 = 0;
        if (c2 == '-') {
            i4++;
            z2 = true;
            i2 = Integer.MIN_VALUE;
        } else {
            z2 = false;
            i2 = -2147483647;
        }
        if (i4 < i5) {
            int i7 = i4 + 1;
            if (i4 >= this.r) {
                c4 = 26;
            } else {
                c4 = this.q.charAt(i4);
            }
            i6 = -(c4 - '0');
            i4 = i7;
        }
        while (true) {
            if (i4 >= i5) {
                break;
            }
            i3 = i4 + 1;
            if (i4 >= this.r) {
                c3 = 26;
            } else {
                c3 = this.q.charAt(i4);
            }
            if (c3 == 'L' || c3 == 'S' || c3 == 'B') {
                i4 = i3;
            } else {
                int i8 = c3 - '0';
                if (i6 >= -214748364) {
                    int i9 = i6 * 10;
                    if (i9 >= i2 + i8) {
                        i6 = i9 - i8;
                        i4 = i3;
                    } else {
                        throw new NumberFormatException(e());
                    }
                } else {
                    throw new NumberFormatException(e());
                }
            }
        }
        i4 = i3;
        if (!z2) {
            return -i6;
        }
        if (i4 > this.k + 1) {
            return i6;
        }
        throw new NumberFormatException(e());
    }

    public final byte[] l() {
        return a(this.q, this.k + 1, this.h);
    }

    private void w() {
        this.k = this.e - 1;
        this.l = false;
        do {
            this.h++;
            c();
        } while (Character.isLetterOrDigit(this.d));
        String m2 = m();
        if (m2.equals("null")) {
            this.a = 8;
        } else if (m2.equals("true")) {
            this.a = 6;
        } else if (m2.equals("false")) {
            this.a = 7;
        } else if (m2.equals("new")) {
            this.a = 9;
        } else if (m2.equals("undefined")) {
            this.a = 23;
        } else if (m2.equals("Set")) {
            this.a = 21;
        } else if (m2.equals("TreeSet")) {
            this.a = 22;
        } else {
            this.a = 18;
        }
    }

    public final String m() {
        if (this.l) {
            return a(this.g, this.h);
        }
        return a(this.k + 1, this.h);
    }

    private final String a(int i2, int i3) {
        char[] cArr = this.g;
        if (i3 < cArr.length) {
            this.q.getChars(i2, i2 + i3, cArr, 0);
            return new String(this.g, 0, i3);
        }
        char[] cArr2 = new char[i3];
        this.q.getChars(i2, i3 + i2, cArr2, 0);
        return new String(cArr2);
    }

    private char[] b(int i2, int i3) {
        char[] cArr = this.g;
        if (i3 < cArr.length) {
            this.q.getChars(i2, i3 + i2, cArr, 0);
            return this.g;
        }
        char[] cArr2 = new char[i3];
        this.g = cArr2;
        this.q.getChars(i2, i3 + i2, cArr2, 0);
        return cArr2;
    }

    public final boolean n() {
        int i2 = 0;
        while (true) {
            char b2 = b(i2);
            boolean z2 = true;
            if (b2 == 26) {
                return true;
            }
            if (b2 > ' ' || !(b2 == ' ' || b2 == '\n' || b2 == '\r' || b2 == '\t' || b2 == '\f' || b2 == '\b')) {
                z2 = false;
            }
            if (!z2) {
                return false;
            }
            i2++;
        }
    }

    /* access modifiers changed from: package-private */
    public final void o() {
        while (true) {
            char c2 = this.d;
            if (c2 > '/') {
                return;
            }
            if (c2 == ' ' || c2 == '\r' || c2 == '\n' || c2 == '\t' || c2 == '\f' || c2 == '\b') {
                c();
            } else if (c2 == '/') {
                v();
            } else {
                return;
            }
        }
    }

    public final void p() {
        char c2;
        char c3;
        char c4;
        char c5;
        char c6;
        char c7;
        char c8;
        int i2 = this.e;
        this.k = i2;
        this.i = false;
        if (this.d == '-') {
            this.h++;
            int i3 = i2 + 1;
            this.e = i3;
            if (i3 >= this.r) {
                c8 = 26;
            } else {
                c8 = this.q.charAt(i3);
            }
            this.d = c8;
        }
        while (true) {
            char c9 = this.d;
            if (c9 < '0' || c9 > '9') {
                this.j = false;
            } else {
                this.h++;
                int i4 = this.e + 1;
                this.e = i4;
                if (i4 >= this.r) {
                    c7 = 26;
                } else {
                    c7 = this.q.charAt(i4);
                }
                this.d = c7;
            }
        }
        this.j = false;
        if (this.d == '.') {
            this.h++;
            int i5 = this.e + 1;
            this.e = i5;
            if (i5 >= this.r) {
                c5 = 26;
            } else {
                c5 = this.q.charAt(i5);
            }
            this.d = c5;
            this.j = true;
            while (true) {
                char c10 = this.d;
                if (c10 < '0' || c10 > '9') {
                    break;
                }
                this.h++;
                int i6 = this.e + 1;
                this.e = i6;
                if (i6 >= this.r) {
                    c6 = 26;
                } else {
                    c6 = this.q.charAt(i6);
                }
                this.d = c6;
            }
        }
        char c11 = this.d;
        if (c11 == 'L') {
            this.h++;
            c();
        } else if (c11 == 'S') {
            this.h++;
            c();
        } else if (c11 == 'B') {
            this.h++;
            c();
        } else if (c11 == 'F') {
            this.h++;
            c();
            this.j = true;
        } else if (c11 == 'D') {
            this.h++;
            c();
            this.j = true;
        } else if (c11 == 'e' || c11 == 'E') {
            this.h++;
            int i7 = this.e + 1;
            this.e = i7;
            if (i7 >= this.r) {
                c2 = 26;
            } else {
                c2 = this.q.charAt(i7);
            }
            this.d = c2;
            char c12 = this.d;
            if (c12 == '+' || c12 == '-') {
                this.h++;
                int i8 = this.e + 1;
                this.e = i8;
                if (i8 >= this.r) {
                    c4 = 26;
                } else {
                    c4 = this.q.charAt(i8);
                }
                this.d = c4;
            }
            while (true) {
                char c13 = this.d;
                if (c13 < '0' || c13 > '9') {
                    char c14 = this.d;
                } else {
                    this.h++;
                    int i9 = this.e + 1;
                    this.e = i9;
                    if (i9 >= this.r) {
                        c3 = 26;
                    } else {
                        c3 = this.q.charAt(i9);
                    }
                    this.d = c3;
                }
            }
            char c142 = this.d;
            if (c142 == 'D' || c142 == 'F') {
                this.h++;
                c();
            }
            this.i = true;
            this.j = true;
        }
        if (this.j) {
            this.a = 3;
        } else {
            this.a = 2;
        }
    }

    public final boolean q() {
        boolean z2 = false;
        int i2 = 1;
        if (this.q.startsWith("false", this.e)) {
            i2 = 5;
        } else if (this.q.startsWith("true", this.e)) {
            z2 = true;
            i2 = 4;
        } else {
            char c2 = this.d;
            if (c2 == '1') {
                z2 = true;
            } else if (c2 != '0') {
                this.p = -1;
                return false;
            }
        }
        this.e += i2;
        this.d = b(this.e);
        return z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:0x0232 A[Catch:{ NumberFormatException -> 0x0281 }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x024d A[Catch:{ NumberFormatException -> 0x0281 }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x025a A[Catch:{ NumberFormatException -> 0x0281 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Number r() {
        /*
        // Method dump skipped, instructions count: 676
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.o.r():java.lang.Number");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long s() {
        /*
        // Method dump skipped, instructions count: 201
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.o.s():long");
    }

    public final long t() throws NumberFormatException {
        long j2;
        boolean z2;
        long j3;
        char c2;
        int i2 = this.k;
        int i3 = this.h + i2;
        if (b(i2) == '-') {
            j2 = Long.MIN_VALUE;
            i2++;
            z2 = true;
        } else {
            j2 = -9223372036854775807L;
            z2 = false;
        }
        if (i2 < i3) {
            j3 = (long) (-(b(i2) - '0'));
            i2++;
        } else {
            j3 = 0;
        }
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int i4 = i2 + 1;
            if (i2 >= this.r) {
                c2 = 26;
            } else {
                c2 = this.q.charAt(i2);
            }
            if (c2 == 'L' || c2 == 'S' || c2 == 'B') {
                i2 = i4;
            } else {
                int i5 = c2 - '0';
                if (j3 >= -922337203685477580L) {
                    long j4 = j3 * 10;
                    long j5 = (long) i5;
                    if (j4 >= j2 + j5) {
                        j3 = j4 - j5;
                        i2 = i4;
                    } else {
                        throw new NumberFormatException(e());
                    }
                } else {
                    throw new NumberFormatException(e());
                }
            }
        }
        if (!z2) {
            return -j3;
        }
        if (i2 > this.k + 1) {
            return j3;
        }
        throw new NumberFormatException(e());
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b A[Catch:{ NumberFormatException -> 0x0026 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0077 A[Catch:{ NumberFormatException -> 0x0026 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Number a(boolean r9) {
        /*
        // Method dump skipped, instructions count: 252
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.o.a(boolean):java.lang.Number");
    }

    public final BigDecimal u() {
        char charAt = this.q.charAt((this.k + this.h) - 1);
        int i2 = this.h;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i2--;
        }
        int i3 = this.k;
        char[] cArr = this.g;
        if (i2 < cArr.length) {
            this.q.getChars(i3, i3 + i2, cArr, 0);
            return new BigDecimal(this.g, 0, i2);
        }
        char[] cArr2 = new char[i2];
        this.q.getChars(i3, i2 + i3, cArr2, 0);
        return new BigDecimal(cArr2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x011c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(long r18) {
        /*
        // Method dump skipped, instructions count: 302
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.o.a(long):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int o(long r17) {
        /*
        // Method dump skipped, instructions count: 201
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.o.o(long):int");
    }

    public final int b(long j2) {
        char c2;
        int i2;
        char c3;
        char c4;
        int i3;
        this.p = 0;
        int o2 = o(j2);
        if (o2 == 0) {
            return 0;
        }
        int i4 = o2 + 1;
        int i5 = this.e + o2;
        char c5 = 26;
        if (i5 >= this.r) {
            c2 = 26;
        } else {
            c2 = this.q.charAt(i5);
        }
        boolean z2 = c2 == '\"';
        if (z2) {
            int i6 = i4 + 1;
            int i7 = this.e + i4;
            if (i7 >= this.r) {
                c2 = 26;
            } else {
                c2 = this.q.charAt(i7);
            }
            i4 = i6;
            z2 = true;
        }
        boolean z3 = c2 == '-';
        if (z3) {
            int i8 = i4 + 1;
            int i9 = this.e + i4;
            if (i9 >= this.r) {
                c2 = 26;
            } else {
                c2 = this.q.charAt(i9);
            }
            i4 = i8;
        }
        if (c2 < '0' || c2 > '9') {
            this.p = -1;
            return 0;
        }
        int i10 = c2 - '0';
        while (true) {
            i2 = i4 + 1;
            int i11 = this.e + i4;
            if (i11 >= this.r) {
                c3 = 26;
            } else {
                c3 = this.q.charAt(i11);
            }
            if (c3 >= '0' && c3 <= '9') {
                i10 = (i10 * 10) + (c3 - '0');
                i4 = i2;
            }
        }
        if (c3 == '.') {
            this.p = -1;
            return 0;
        }
        if (c3 != '\"') {
            c4 = c3;
            i3 = i2;
        } else if (!z2) {
            this.p = -1;
            return 0;
        } else {
            i3 = i2 + 1;
            int i12 = this.e + i2;
            if (i12 >= this.r) {
                c4 = 26;
            } else {
                c4 = this.q.charAt(i12);
            }
        }
        if (i10 < 0) {
            this.p = -1;
            return 0;
        }
        while (c4 != ',') {
            if (c4 <= ' ' && (c4 == ' ' || c4 == '\n' || c4 == '\r' || c4 == '\t' || c4 == '\f' || c4 == '\b')) {
                int i13 = i3 + 1;
                int i14 = this.e + i3;
                if (i14 >= this.r) {
                    c4 = 26;
                } else {
                    c4 = this.q.charAt(i14);
                }
                i3 = i13;
            } else if (c4 == '}') {
                int i15 = i3 + 1;
                char b2 = b(this.e + i3);
                if (b2 == ',') {
                    this.a = 16;
                    this.e += i15 - 1;
                    int i16 = this.e + 1;
                    this.e = i16;
                    if (i16 < this.r) {
                        c5 = this.q.charAt(i16);
                    }
                    this.d = c5;
                } else if (b2 == ']') {
                    this.a = 15;
                    this.e += i15 - 1;
                    int i17 = this.e + 1;
                    this.e = i17;
                    if (i17 < this.r) {
                        c5 = this.q.charAt(i17);
                    }
                    this.d = c5;
                } else if (b2 == '}') {
                    this.a = 13;
                    this.e += i15 - 1;
                    int i18 = this.e + 1;
                    this.e = i18;
                    if (i18 < this.r) {
                        c5 = this.q.charAt(i18);
                    }
                    this.d = c5;
                } else if (b2 == 26) {
                    this.a = 20;
                    this.e += i15 - 1;
                    this.d = 26;
                } else {
                    this.p = -1;
                    return 0;
                }
                this.p = 4;
                return z3 ? -i10 : i10;
            } else {
                this.p = -1;
                return 0;
            }
        }
        this.e += i3 - 1;
        int i19 = this.e + 1;
        this.e = i19;
        if (i19 < this.r) {
            c5 = this.q.charAt(i19);
        }
        this.d = c5;
        this.p = 3;
        this.a = 16;
        return z3 ? -i10 : i10;
    }

    public final int[] c(long j2) {
        char c2;
        char c3;
        int i2;
        int i3;
        char c4;
        int[] iArr;
        int i4;
        boolean z2;
        int[] iArr2;
        int i5;
        int i6;
        char c5;
        this.p = 0;
        int o2 = o(j2);
        int[] iArr3 = null;
        if (o2 == 0) {
            return null;
        }
        int i7 = o2 + 1;
        int i8 = this.e + o2;
        if (i8 >= this.r) {
            c2 = 26;
        } else {
            c2 = this.q.charAt(i8);
        }
        if (c2 != '[') {
            this.p = -1;
            return null;
        }
        int i9 = i7 + 1;
        int i10 = this.e + i7;
        if (i10 >= this.r) {
            c3 = 26;
        } else {
            c3 = this.q.charAt(i10);
        }
        int[] iArr4 = new int[16];
        if (c3 == ']') {
            i2 = i9 + 1;
            int i11 = this.e + i9;
            if (i11 >= this.r) {
                c4 = 26;
            } else {
                c4 = this.q.charAt(i11);
            }
            i3 = 0;
        } else {
            int i12 = 0;
            while (true) {
                if (c3 == '-') {
                    i4 = i9 + 1;
                    int i13 = this.e + i9;
                    if (i13 >= this.r) {
                        c3 = 26;
                    } else {
                        c3 = this.q.charAt(i13);
                    }
                    z2 = true;
                } else {
                    i4 = i9;
                    z2 = false;
                }
                if (c3 >= '0') {
                    if (c3 > '9') {
                        i5 = -1;
                        iArr2 = null;
                        break;
                    }
                    int i14 = c3 - '0';
                    while (true) {
                        i6 = i4 + 1;
                        int i15 = this.e + i4;
                        if (i15 >= this.r) {
                            c5 = 26;
                        } else {
                            c5 = this.q.charAt(i15);
                        }
                        if (c5 >= '0' && c5 <= '9') {
                            i14 = (i14 * 10) + (c5 - '0');
                            i4 = i6;
                        }
                    }
                    if (i12 >= iArr4.length) {
                        int[] iArr5 = new int[((iArr4.length * 3) / 2)];
                        System.arraycopy(iArr4, 0, iArr5, 0, i12);
                        iArr4 = iArr5;
                    }
                    i3 = i12 + 1;
                    if (z2) {
                        i14 = -i14;
                    }
                    iArr4[i12] = i14;
                    if (c5 == ',') {
                        i9 = i6 + 1;
                        int i16 = this.e + i6;
                        if (i16 >= this.r) {
                            c3 = 26;
                        } else {
                            c3 = this.q.charAt(i16);
                        }
                        i12 = i3;
                        iArr3 = null;
                    } else if (c5 == ']') {
                        i2 = i6 + 1;
                        int i17 = this.e + i6;
                        if (i17 >= this.r) {
                            c4 = 26;
                        } else {
                            c4 = this.q.charAt(i17);
                        }
                    } else {
                        i12 = i3;
                        iArr3 = null;
                        c3 = c5;
                        i9 = i6;
                    }
                } else {
                    iArr2 = iArr3;
                    i5 = -1;
                    break;
                }
            }
            this.p = i5;
            return iArr2;
        }
        if (i3 != iArr4.length) {
            iArr = new int[i3];
            System.arraycopy(iArr4, 0, iArr, 0, i3);
        } else {
            iArr = iArr4;
        }
        if (c4 == ',') {
            this.e += i2 - 1;
            c();
            this.p = 3;
            this.a = 16;
            return iArr;
        } else if (c4 == '}') {
            int i18 = i2 + 1;
            char b2 = b(this.e + i2);
            if (b2 == ',') {
                this.a = 16;
                this.e += i18 - 1;
                c();
            } else if (b2 == ']') {
                this.a = 15;
                this.e += i18 - 1;
                c();
            } else if (b2 == '}') {
                this.a = 13;
                this.e += i18 - 1;
                c();
            } else if (b2 == 26) {
                this.e += i18 - 1;
                this.a = 20;
                this.d = 26;
            } else {
                this.p = -1;
                return null;
            }
            this.p = 4;
            return iArr;
        } else {
            this.p = -1;
            return null;
        }
    }

    public final long d(long j2) {
        char c2;
        int i2;
        char c3;
        char c4;
        char c5;
        char c6;
        char c7;
        boolean z2 = false;
        this.p = 0;
        int o2 = o(j2);
        if (o2 == 0) {
            return 0;
        }
        int i3 = o2 + 1;
        int i4 = this.e + o2;
        if (i4 >= this.r) {
            c2 = 26;
        } else {
            c2 = this.q.charAt(i4);
        }
        boolean z3 = c2 == '\"';
        if (z3) {
            int i5 = i3 + 1;
            int i6 = this.e + i3;
            if (i6 >= this.r) {
                c2 = 26;
            } else {
                c2 = this.q.charAt(i6);
            }
            i3 = i5;
        }
        if (c2 == '-') {
            z2 = true;
        }
        if (z2) {
            int i7 = i3 + 1;
            int i8 = this.e + i3;
            if (i8 >= this.r) {
                c2 = 26;
            } else {
                c2 = this.q.charAt(i8);
            }
            i3 = i7;
        }
        if (c2 < '0' || c2 > '9') {
            this.p = -1;
            return 0;
        }
        long j3 = (long) (c2 - '0');
        while (true) {
            i2 = i3 + 1;
            int i9 = this.e + i3;
            if (i9 >= this.r) {
                c3 = 26;
            } else {
                c3 = this.q.charAt(i9);
            }
            if (c3 >= '0' && c3 <= '9') {
                j3 = (j3 * 10) + ((long) (c3 - '0'));
                i3 = i2;
            }
        }
        if (c3 == '.') {
            this.p = -1;
            return 0;
        }
        if (c3 == '\"') {
            if (!z3) {
                this.p = -1;
                return 0;
            }
            int i10 = i2 + 1;
            int i11 = this.e + i2;
            if (i11 >= this.r) {
                c3 = 26;
            } else {
                c3 = this.q.charAt(i11);
            }
            i2 = i10;
        }
        if (j3 < 0) {
            this.p = -1;
            return 0;
        } else if (c3 == ',') {
            this.e += i2 - 1;
            int i12 = this.e + 1;
            this.e = i12;
            if (i12 >= this.r) {
                c7 = 26;
            } else {
                c7 = this.q.charAt(i12);
            }
            this.d = c7;
            this.p = 3;
            this.a = 16;
            return z2 ? -j3 : j3;
        } else if (c3 == '}') {
            int i13 = i2 + 1;
            char b2 = b(this.e + i2);
            if (b2 == ',') {
                this.a = 16;
                this.e += i13 - 1;
                int i14 = this.e + 1;
                this.e = i14;
                if (i14 >= this.r) {
                    c6 = 26;
                } else {
                    c6 = this.q.charAt(i14);
                }
                this.d = c6;
            } else if (b2 == ']') {
                this.a = 15;
                this.e += i13 - 1;
                int i15 = this.e + 1;
                this.e = i15;
                if (i15 >= this.r) {
                    c5 = 26;
                } else {
                    c5 = this.q.charAt(i15);
                }
                this.d = c5;
            } else if (b2 == '}') {
                this.a = 13;
                this.e += i13 - 1;
                int i16 = this.e + 1;
                this.e = i16;
                if (i16 >= this.r) {
                    c4 = 26;
                } else {
                    c4 = this.q.charAt(i16);
                }
                this.d = c4;
            } else if (b2 == 26) {
                this.a = 20;
                this.e += i13 - 1;
                this.d = 26;
            } else {
                this.p = -1;
                return 0;
            }
            this.p = 4;
            return z2 ? -j3 : j3;
        } else {
            this.p = -1;
            return 0;
        }
    }

    public final String e(long j2) {
        String str;
        char c2;
        char c3;
        this.p = 0;
        int o2 = o(j2);
        if (o2 == 0) {
            return null;
        }
        int i2 = o2 + 1;
        int i3 = this.e + o2;
        if (i3 >= this.r) {
            throw new d("unclosed str, " + h());
        } else if (this.q.charAt(i3) != '\"') {
            this.p = -1;
            return this.s;
        } else {
            int i4 = this.e + i2;
            int indexOf = this.q.indexOf(34, i4);
            if (indexOf != -1) {
                if (A) {
                    str = this.q.substring(i4, indexOf);
                } else {
                    int i5 = indexOf - i4;
                    str = new String(b(this.e + i2, i5), 0, i5);
                }
                if (str.indexOf(92) != -1) {
                    boolean z2 = false;
                    while (true) {
                        int i6 = indexOf - 1;
                        int i7 = 0;
                        while (i6 >= 0 && this.q.charAt(i6) == '\\') {
                            i7++;
                            i6--;
                            z2 = true;
                        }
                        if (i7 % 2 == 0) {
                            break;
                        }
                        indexOf = this.q.indexOf(34, indexOf + 1);
                    }
                    int i8 = indexOf - i4;
                    char[] b2 = b(this.e + i2, i8);
                    if (z2) {
                        str = a(b2, i8);
                    } else {
                        str = new String(b2, 0, i8);
                        if (str.indexOf(92) != -1) {
                            str = a(b2, i8);
                        }
                    }
                }
                int i9 = indexOf + 1;
                char c4 = 26;
                if (i9 >= this.r) {
                    c2 = 26;
                } else {
                    c2 = this.q.charAt(i9);
                }
                if (c2 == ',') {
                    this.e = i9;
                    int i10 = this.e + 1;
                    this.e = i10;
                    if (i10 < this.r) {
                        c4 = this.q.charAt(i10);
                    }
                    this.d = c4;
                    this.p = 3;
                    this.a = 16;
                    return str;
                } else if (c2 == '}') {
                    int i11 = i9 + 1;
                    if (i11 >= this.r) {
                        c3 = 26;
                    } else {
                        c3 = this.q.charAt(i11);
                    }
                    if (c3 == ',') {
                        this.a = 16;
                        this.e = i11;
                        c();
                    } else if (c3 == ']') {
                        this.a = 15;
                        this.e = i11;
                        c();
                    } else if (c3 == '}') {
                        this.a = 13;
                        this.e = i11;
                        c();
                    } else if (c3 == 26) {
                        this.a = 20;
                        this.e = i11;
                        this.d = 26;
                    } else {
                        this.p = -1;
                        return this.s;
                    }
                    this.p = 4;
                    return str;
                } else {
                    this.p = -1;
                    return this.s;
                }
            } else {
                throw new d("unclosed str, " + h());
            }
        }
    }

    public final Date f(long j2) {
        char c2;
        int i2;
        char c3;
        Date date;
        int i3;
        char c4;
        char c5;
        this.p = 0;
        int o2 = o(j2);
        if (o2 == 0) {
            return null;
        }
        int i4 = this.e;
        char c6 = this.d;
        int i5 = o2 + 1;
        int i6 = o2 + i4;
        char c7 = 26;
        if (i6 >= this.r) {
            c2 = 26;
        } else {
            c2 = this.q.charAt(i6);
        }
        if (c2 == '\"') {
            int i7 = this.e;
            int i8 = i7 + i5;
            int i9 = i5 + 1;
            int i10 = i7 + i5;
            if (i10 < this.r) {
                this.q.charAt(i10);
            }
            int indexOf = this.q.indexOf(34, this.e + i9);
            if (indexOf != -1) {
                int i11 = indexOf - i8;
                this.e = i8;
                if (a(false, i11)) {
                    date = this.o.getTime();
                    int i12 = i9 + i11;
                    i2 = i12 + 1;
                    c3 = b(i12 + i4);
                    this.e = i4;
                } else {
                    this.e = i4;
                    this.p = -1;
                    return null;
                }
            } else {
                throw new d("unclosed str");
            }
        } else if (c2 < '0' || c2 > '9') {
            this.p = -1;
            return null;
        } else {
            long j3 = (long) (c2 - '0');
            while (true) {
                i3 = i5 + 1;
                int i13 = this.e + i5;
                if (i13 >= this.r) {
                    c4 = 26;
                } else {
                    c4 = this.q.charAt(i13);
                }
                if (c4 >= '0' && c4 <= '9') {
                    j3 = (j3 * 10) + ((long) (c4 - '0'));
                    i5 = i3;
                }
            }
            if (c4 == '.') {
                this.p = -1;
                return null;
            }
            if (c4 == '\"') {
                int i14 = i3 + 1;
                int i15 = this.e + i3;
                if (i15 >= this.r) {
                    c5 = 26;
                } else {
                    c5 = this.q.charAt(i15);
                }
                c3 = c5;
                i2 = i14;
            } else {
                c3 = c4;
                i2 = i3;
            }
            if (j3 < 0) {
                this.p = -1;
                return null;
            }
            date = new Date(j3);
        }
        if (c3 == ',') {
            this.e += i2 - 1;
            int i16 = this.e + 1;
            this.e = i16;
            if (i16 < this.r) {
                c7 = this.q.charAt(i16);
            }
            this.d = c7;
            this.p = 3;
            this.a = 16;
            return date;
        } else if (c3 == '}') {
            int i17 = i2 + 1;
            char b2 = b(this.e + i2);
            if (b2 == ',') {
                this.a = 16;
                this.e += i17 - 1;
                int i18 = this.e + 1;
                this.e = i18;
                if (i18 < this.r) {
                    c7 = this.q.charAt(i18);
                }
                this.d = c7;
            } else if (b2 == ']') {
                this.a = 15;
                this.e += i17 - 1;
                int i19 = this.e + 1;
                this.e = i19;
                if (i19 < this.r) {
                    c7 = this.q.charAt(i19);
                }
                this.d = c7;
            } else if (b2 == '}') {
                this.a = 13;
                this.e += i17 - 1;
                int i20 = this.e + 1;
                this.e = i20;
                if (i20 < this.r) {
                    c7 = this.q.charAt(i20);
                }
                this.d = c7;
            } else if (b2 == 26) {
                this.a = 20;
                this.e += i17 - 1;
                this.d = 26;
            } else {
                this.e = i4;
                this.d = c6;
                this.p = -1;
                return null;
            }
            this.p = 4;
            return date;
        } else {
            this.e = i4;
            this.d = c6;
            this.p = -1;
            return null;
        }
    }

    public final boolean g(long j2) {
        boolean z2;
        int i2;
        char c2;
        this.p = 0;
        int o2 = o(j2);
        if (o2 == 0) {
            return false;
        }
        if (this.q.startsWith("false", this.e + o2)) {
            i2 = o2 + 5;
            z2 = false;
        } else if (this.q.startsWith("true", this.e + o2)) {
            i2 = o2 + 4;
            z2 = true;
        } else if (this.q.startsWith("\"false\"", this.e + o2)) {
            i2 = o2 + 7;
            z2 = false;
        } else if (this.q.startsWith("\"true\"", this.e + o2)) {
            i2 = o2 + 6;
            z2 = true;
        } else if (this.q.charAt(this.e + o2) == '1') {
            i2 = o2 + 1;
            z2 = true;
        } else if (this.q.charAt(this.e + o2) == '0') {
            i2 = o2 + 1;
            z2 = false;
        } else if (this.q.startsWith("\"1\"", this.e + o2)) {
            i2 = o2 + 3;
            z2 = true;
        } else if (this.q.startsWith("\"0\"", this.e + o2)) {
            i2 = o2 + 3;
            z2 = false;
        } else {
            this.p = -1;
            return false;
        }
        int i3 = i2 + 1;
        int i4 = this.e + i2;
        char c3 = 26;
        if (i4 >= this.r) {
            c2 = 26;
        } else {
            c2 = this.q.charAt(i4);
        }
        while (c2 != ',') {
            if (c2 != '}' && (c2 == ' ' || c2 == '\n' || c2 == '\r' || c2 == '\t' || c2 == '\f' || c2 == '\b')) {
                int i5 = i3 + 1;
                int i6 = this.e + i3;
                if (i6 >= this.r) {
                    c2 = 26;
                } else {
                    c2 = this.q.charAt(i6);
                }
                i3 = i5;
            } else if (c2 == '}') {
                int i7 = i3 + 1;
                char b2 = b(this.e + i3);
                if (b2 == ',') {
                    this.a = 16;
                    this.e += i7 - 1;
                    int i8 = this.e + 1;
                    this.e = i8;
                    if (i8 < this.r) {
                        c3 = this.q.charAt(i8);
                    }
                    this.d = c3;
                } else if (b2 == ']') {
                    this.a = 15;
                    this.e += i7 - 1;
                    int i9 = this.e + 1;
                    this.e = i9;
                    if (i9 < this.r) {
                        c3 = this.q.charAt(i9);
                    }
                    this.d = c3;
                } else if (b2 == '}') {
                    this.a = 13;
                    this.e += i7 - 1;
                    int i10 = this.e + 1;
                    this.e = i10;
                    if (i10 < this.r) {
                        c3 = this.q.charAt(i10);
                    }
                    this.d = c3;
                } else if (b2 == 26) {
                    this.a = 20;
                    this.e += i7 - 1;
                    this.d = 26;
                } else {
                    this.p = -1;
                    return false;
                }
                this.p = 4;
                return z2;
            } else {
                this.p = -1;
                return false;
            }
        }
        this.e += i3 - 1;
        int i11 = this.e + 1;
        this.e = i11;
        if (i11 < this.r) {
            c3 = this.q.charAt(i11);
        }
        this.d = c3;
        this.p = 3;
        this.a = 16;
        return z2;
    }

    public final float h(long j2) {
        int i2;
        char b2;
        int i3;
        int i4;
        boolean z2;
        o oVar;
        float f2;
        int i5;
        int i6;
        char b3;
        boolean z3 = false;
        this.p = 0;
        int o2 = o(j2);
        if (o2 == 0) {
            return 0.0f;
        }
        int i7 = o2 + 1;
        char b4 = b(this.e + o2);
        int i8 = (this.e + i7) - 1;
        boolean z4 = b4 == '-';
        if (z4) {
            b4 = b(this.e + i7);
            i7++;
        }
        if (b4 < '0' || b4 > '9') {
            this.p = -1;
            return 0.0f;
        }
        int i9 = b4 - '0';
        while (true) {
            i2 = i7 + 1;
            b2 = b(this.e + i7);
            if (b2 >= '0' && b2 <= '9') {
                i9 = (i9 * 10) + (b2 - '0');
                i7 = i2;
            }
        }
        if (b2 == '.') {
            int i10 = i2 + 1;
            char b5 = b(this.e + i2);
            if (b5 < '0' || b5 > '9') {
                this.p = -1;
                return 0.0f;
            }
            i9 = (i9 * 10) + (b5 - '0');
            int i11 = 10;
            while (true) {
                i6 = i10 + 1;
                b3 = b(this.e + i10);
                if (b3 < '0' || b3 > '9') {
                    i2 = i6;
                    i3 = i11;
                    b2 = b3;
                } else {
                    i9 = (i9 * 10) + (b3 - '0');
                    i11 *= 10;
                    i10 = i6;
                }
            }
            i2 = i6;
            i3 = i11;
            b2 = b3;
        } else {
            i3 = 1;
        }
        if (b2 == 'e' || b2 == 'E') {
            z3 = true;
        }
        if (z3) {
            int i12 = i2 + 1;
            b2 = b(this.e + i2);
            if (b2 == '+' || b2 == '-') {
                i5 = i9;
                z2 = z3;
                oVar = this;
            } else {
                i4 = i9;
                z2 = z3;
                oVar = this;
                if (b2 >= '0' || b2 > '9') {
                    i2 = i12;
                } else {
                    i5 = i4;
                }
            }
            char b6 = oVar.b(oVar.e + i12);
            i12++;
            i4 = i5;
            b2 = b6;
            if (b2 >= '0') {
            }
            i2 = i12;
        } else {
            i4 = i9;
            z2 = z3;
            oVar = this;
        }
        int i13 = ((oVar.e + i2) - i8) - 1;
        if (z2 || i13 >= 10) {
            f2 = Float.parseFloat(oVar.a(i8, i13));
        } else {
            f2 = ((float) i4) / ((float) i3);
            if (z4) {
                f2 = -f2;
            }
        }
        if (b2 == ',') {
            oVar.e += i2 - 1;
            oVar.c();
            oVar.p = 3;
            oVar.a = 16;
            return f2;
        } else if (b2 == '}') {
            int i14 = i2 + 1;
            char b7 = oVar.b(oVar.e + i2);
            if (b7 == ',') {
                oVar.a = 16;
                oVar.e += i14 - 1;
                oVar.c();
            } else if (b7 == ']') {
                oVar.a = 15;
                oVar.e += i14 - 1;
                oVar.c();
            } else if (b7 == '}') {
                oVar.a = 13;
                oVar.e += i14 - 1;
                oVar.c();
            } else if (b7 == 26) {
                oVar.e += i14 - 1;
                oVar.a = 20;
                oVar.d = 26;
            } else {
                oVar.p = -1;
                return 0.0f;
            }
            oVar.p = 4;
            return f2;
        } else {
            oVar.p = -1;
            return 0.0f;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0230, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final float[] i(long r19) {
        /*
        // Method dump skipped, instructions count: 561
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.o.i(long):float[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:109:0x019e, code lost:
        r9 = r10 + 1;
        r1 = r19.e + r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01a5, code lost:
        if (r1 < r19.r) goto L_0x01aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01a7, code lost:
        r1 = 26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01aa, code lost:
        r1 = r19.q.charAt(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01b2, code lost:
        if (r3 == r11.length) goto L_0x01bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01b4, code lost:
        r10 = new float[r3];
        java.lang.System.arraycopy(r11, 0, r10, 0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01bb, code lost:
        r10 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01bd, code lost:
        if (r5 < r8.length) goto L_0x01cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01bf, code lost:
        r8 = new float[((r8.length * 3) / 2)][];
        java.lang.System.arraycopy(r10, 0, r8, 0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01cc, code lost:
        r3 = r5 + 1;
        r8[r5] = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01d0, code lost:
        if (r1 != ',') goto L_0x01e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01d2, code lost:
        r4 = r9 + 1;
        r1 = r19.e + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01d9, code lost:
        if (r1 >= r19.r) goto L_0x01e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01db, code lost:
        r19.q.charAt(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01e2, code lost:
        r5 = r3;
        r2 = 16;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01e9, code lost:
        if (r1 != ']') goto L_0x027a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x01eb, code lost:
        r5 = r9 + 1;
        r1 = r19.e + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x01f2, code lost:
        if (r1 < r19.r) goto L_0x01f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01f4, code lost:
        r1 = 26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01f7, code lost:
        r1 = r19.q.charAt(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x01ff, code lost:
        if (r3 == r8.length) goto L_0x020a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0201, code lost:
        r9 = new float[r3][];
        java.lang.System.arraycopy(r8, 0, r9, 0, r3);
        r8 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x020a, code lost:
        if (r1 != ',') goto L_0x021d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x020c, code lost:
        r19.e += r5 - 1;
        c();
        r19.p = 3;
        r19.a = 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x021c, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x021f, code lost:
        if (r1 != '}') goto L_0x0276;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0221, code lost:
        r4 = r5 + 1;
        r1 = b(r19.e + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x022a, code lost:
        if (r1 != ',') goto L_0x023b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x022c, code lost:
        r19.a = 16;
        r19.e += r4 - 1;
        c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x023b, code lost:
        if (r1 != ']') goto L_0x024c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x023d, code lost:
        r19.a = 15;
        r19.e += r4 - 1;
        c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x024c, code lost:
        if (r1 != '}') goto L_0x025d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x024e, code lost:
        r19.a = 13;
        r19.e += r4 - 1;
        c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0260, code lost:
        if (r1 != 26) goto L_0x0272;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0262, code lost:
        r19.e += r4 - 1;
        r19.a = 20;
        r19.d = 26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x026e, code lost:
        r19.p = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0271, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0272, code lost:
        r19.p = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0275, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0276, code lost:
        r19.p = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0279, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x027a, code lost:
        r2 = 16;
        r5 = r3;
        r4 = r9;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0294, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final float[][] j(long r20) {
        /*
        // Method dump skipped, instructions count: 661
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.o.j(long):float[][]");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    public final double k(long r18) {
        /*
        // Method dump skipped, instructions count: 341
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.o.k(long):double");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0231, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final double[] l(long r19) {
        /*
        // Method dump skipped, instructions count: 562
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.o.l(long):double[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:109:0x019e, code lost:
        r9 = r10 + 1;
        r1 = r19.e + r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01a5, code lost:
        if (r1 < r19.r) goto L_0x01aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01a7, code lost:
        r1 = 26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01aa, code lost:
        r1 = r19.q.charAt(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01b2, code lost:
        if (r4 == r11.length) goto L_0x01bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01b4, code lost:
        r10 = new double[r4];
        java.lang.System.arraycopy(r11, 0, r10, 0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01bb, code lost:
        r10 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01bd, code lost:
        if (r5 < r8.length) goto L_0x01cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01bf, code lost:
        r8 = new double[((r8.length * 3) / 2)][];
        java.lang.System.arraycopy(r10, 0, r8, 0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01cc, code lost:
        r4 = r5 + 1;
        r8[r5] = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01d0, code lost:
        if (r1 != ',') goto L_0x01ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01d2, code lost:
        r2 = r9 + 1;
        r1 = r19.e + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01d9, code lost:
        if (r1 >= r19.r) goto L_0x01e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01db, code lost:
        r19.q.charAt(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01e2, code lost:
        r5 = r4;
        r3 = null;
        r4 = r2;
        r2 = 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01ea, code lost:
        if (r1 != ']') goto L_0x027b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x01ec, code lost:
        r5 = r9 + 1;
        r1 = r19.e + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x01f3, code lost:
        if (r1 < r19.r) goto L_0x01f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01f5, code lost:
        r1 = 26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01f8, code lost:
        r1 = r19.q.charAt(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0200, code lost:
        if (r4 == r8.length) goto L_0x020b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0202, code lost:
        r9 = new double[r4][];
        java.lang.System.arraycopy(r8, 0, r9, 0, r4);
        r8 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x020b, code lost:
        if (r1 != ',') goto L_0x021e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x020d, code lost:
        r19.e += r5 - 1;
        c();
        r19.p = 3;
        r19.a = 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x021d, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0220, code lost:
        if (r1 != '}') goto L_0x0277;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0222, code lost:
        r6 = r5 + 1;
        r1 = b(r19.e + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x022b, code lost:
        if (r1 != ',') goto L_0x023c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x022d, code lost:
        r19.a = 16;
        r19.e += r6 - 1;
        c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x023c, code lost:
        if (r1 != ']') goto L_0x024d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x023e, code lost:
        r19.a = 15;
        r19.e += r6 - 1;
        c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x024d, code lost:
        if (r1 != '}') goto L_0x025e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x024f, code lost:
        r19.a = 13;
        r19.e += r6 - 1;
        c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0261, code lost:
        if (r1 != 26) goto L_0x0273;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0263, code lost:
        r19.e += r6 - 1;
        r19.a = 20;
        r19.d = 26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x026f, code lost:
        r19.p = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0272, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0273, code lost:
        r19.p = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0276, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0277, code lost:
        r19.p = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x027a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x027b, code lost:
        r2 = 16;
        r5 = r4;
        r4 = r9;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0295, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final double[][] m(long r20) {
        /*
        // Method dump skipped, instructions count: 662
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.o.m(long):double[][]");
    }

    public final long n(long j2) {
        char c2;
        char c3;
        char c4;
        char c5;
        this.p = 0;
        int o2 = o(j2);
        if (o2 == 0) {
            return 0;
        }
        int i2 = o2 + 1;
        int i3 = this.e + o2;
        char c6 = 26;
        if (i3 >= this.r) {
            c2 = 26;
        } else {
            c2 = this.q.charAt(i3);
        }
        if (c2 != '\"') {
            this.p = -1;
            return 0;
        }
        long j3 = -3750763034362895579L;
        int i4 = this.e;
        while (true) {
            int i5 = i2 + 1;
            int i6 = this.e + i2;
            if (i6 >= this.r) {
                c3 = 26;
            } else {
                c3 = this.q.charAt(i6);
            }
            if (c3 == '\"') {
                int i7 = i5 + 1;
                int i8 = this.e + i5;
                if (i8 >= this.r) {
                    c4 = 26;
                } else {
                    c4 = this.q.charAt(i8);
                }
                if (c4 == ',') {
                    this.e += i7 - 1;
                    int i9 = this.e + 1;
                    this.e = i9;
                    if (i9 < this.r) {
                        c6 = this.q.charAt(i9);
                    }
                    this.d = c6;
                    this.p = 3;
                    return j3;
                } else if (c4 == '}') {
                    int i10 = i7 + 1;
                    int i11 = this.e + i7;
                    if (i11 >= this.r) {
                        c5 = 26;
                    } else {
                        c5 = this.q.charAt(i11);
                    }
                    if (c5 == ',') {
                        this.a = 16;
                        this.e += i10 - 1;
                        c();
                    } else if (c5 == ']') {
                        this.a = 15;
                        this.e += i10 - 1;
                        c();
                    } else if (c5 == '}') {
                        this.a = 13;
                        this.e += i10 - 1;
                        c();
                    } else if (c5 == 26) {
                        this.a = 20;
                        this.e += i10 - 1;
                        this.d = 26;
                    } else {
                        this.p = -1;
                        return 0;
                    }
                    this.p = 4;
                    return j3;
                } else {
                    this.p = -1;
                    return 0;
                }
            } else {
                j3 = (j3 ^ ((long) c3)) * 1099511628211L;
                if (c3 == '\\') {
                    this.p = -1;
                    return 0;
                }
                i2 = i5;
            }
        }
    }

    public final boolean b(boolean z2) {
        return a(z2, this.r - this.e);
    }

    private boolean a(boolean z2, int i2) {
        boolean z3;
        char c2;
        int i3;
        char c3;
        char c4;
        char c5;
        char c6;
        char c7;
        int i4;
        int i5;
        int i6;
        char c8;
        char c9;
        int i7;
        char c10;
        char c11;
        char c12;
        char b2;
        int i8;
        int i9;
        char b3;
        char b4;
        char b5;
        char b6;
        if (!z2 && i2 > 13) {
            char b7 = b(this.e);
            char b8 = b(this.e + 1);
            char b9 = b(this.e + 2);
            char b10 = b(this.e + 3);
            char b11 = b(this.e + 4);
            char b12 = b(this.e + 5);
            char b13 = b((this.e + i2) - 1);
            char b14 = b((this.e + i2) - 2);
            if (b7 == '/' && b8 == 'D' && b9 == 'a' && b10 == 't' && b11 == 'e' && b12 == '(' && b13 == '/' && b14 == ')') {
                int i10 = -1;
                for (int i11 = 6; i11 < i2; i11++) {
                    char b15 = b(this.e + i11);
                    if (b15 != '+') {
                        if (b15 < '0' || b15 > '9') {
                            break;
                        }
                    } else {
                        i10 = i11;
                    }
                }
                if (i10 == -1) {
                    return false;
                }
                int i12 = this.e + 6;
                long parseLong = Long.parseLong(a(i12, i10 - i12));
                this.o = Calendar.getInstance(this.m, this.n);
                this.o.setTimeInMillis(parseLong);
                this.a = 5;
                return true;
            }
        }
        if (i2 == 8 || i2 == 14) {
            c3 = '-';
            i3 = 14;
            c2 = '0';
            z3 = false;
        } else if (i2 == 16 && ((b6 = b(this.e + 10)) == 'T' || b6 == ' ')) {
            c3 = '-';
            i3 = 14;
            c2 = '0';
            z3 = false;
        } else if (i2 == 17 && b(this.e + 6) != '-') {
            c3 = '-';
            i3 = 14;
            c2 = '0';
            z3 = false;
        } else if (i2 < 9) {
            return false;
        } else {
            char b16 = b(this.e);
            char b17 = b(this.e + 1);
            char b18 = b(this.e + 2);
            char b19 = b(this.e + 3);
            char b20 = b(this.e + 4);
            char b21 = b(this.e + 5);
            char b22 = b(this.e + 6);
            char b23 = b(this.e + 7);
            char b24 = b(this.e + 8);
            char b25 = b(this.e + 9);
            if ((b20 == '-' && b23 == '-') || (b20 == '/' && b23 == '/')) {
                b23 = b17;
                c12 = b22;
                c10 = b25;
                c11 = b24;
                i7 = 10;
                b22 = b16;
                b24 = b18;
                b25 = b19;
            } else if (b20 == '-' && b22 == '-') {
                if (b24 == ' ') {
                    b22 = b16;
                    b24 = b18;
                    b25 = b19;
                    c12 = b21;
                    c10 = b23;
                    b21 = '0';
                    c11 = '0';
                    i7 = 8;
                    b23 = b17;
                } else {
                    b22 = b16;
                    b25 = b19;
                    c12 = b21;
                    c11 = b23;
                    c10 = b24;
                    b21 = '0';
                    i7 = 9;
                    b23 = b17;
                    b24 = b18;
                }
            } else if ((b18 == '.' && b21 == '.') || (b18 == '-' && b21 == '-')) {
                c11 = b16;
                c10 = b17;
                b21 = b19;
                c12 = b20;
                i7 = 10;
            } else if (b20 != 24180 && b20 != 45380) {
                return false;
            } else {
                if (b23 == 26376 || b23 == 50900) {
                    if (b25 == 26085 || b25 == 51068) {
                        b23 = b17;
                        b25 = b19;
                        c12 = b22;
                        c10 = b24;
                        c11 = '0';
                        i7 = 10;
                        b22 = b16;
                        b24 = b18;
                    } else if (b(this.e + 10) != 26085 && b(this.e + 10) != 51068) {
                        return false;
                    } else {
                        b23 = b17;
                        c12 = b22;
                        c10 = b25;
                        c11 = b24;
                        i7 = 11;
                        b22 = b16;
                        b24 = b18;
                        b25 = b19;
                    }
                } else if (b22 != 26376 && b22 != 50900) {
                    return false;
                } else {
                    if (b24 == 26085 || b24 == 51068) {
                        b22 = b16;
                        b24 = b18;
                        b25 = b19;
                        c12 = b21;
                        c10 = b23;
                        b21 = '0';
                        c11 = '0';
                        i7 = 10;
                        b23 = b17;
                    } else if (b25 != 26085 && b25 != 51068) {
                        return false;
                    } else {
                        b22 = b16;
                        b25 = b19;
                        c12 = b21;
                        c11 = b23;
                        c10 = b24;
                        b21 = '0';
                        i7 = 10;
                        b23 = b17;
                        b24 = b18;
                    }
                }
            }
            if (!a(b22, b23, b24, b25, b21, c12, (int) c11, (int) c10)) {
                return false;
            }
            a(b22, b23, b24, b25, b21, c12, c11, c10);
            char b26 = b(this.e + i7);
            if (b26 == 'T' || (b26 == ' ' && !z2)) {
                int i13 = i7 + 9;
                if (!(i2 >= i13 && b(this.e + i7 + 3) == ':' && b(this.e + i7 + 6) == ':')) {
                    return false;
                }
                char b27 = b(this.e + i7 + 1);
                char b28 = b(this.e + i7 + 2);
                char b29 = b(this.e + i7 + 4);
                char b30 = b(this.e + i7 + 5);
                char b31 = b(this.e + i7 + 7);
                char b32 = b(this.e + i7 + 8);
                if (!b(b27, b28, b29, b30, b31, b32)) {
                    return false;
                }
                a(b27, b28, b29, b30, b31, b32);
                char b33 = b(this.e + i7 + 9);
                if (b33 == '.') {
                    int i14 = i7 + 11;
                    if (i2 < i14 || (b2 = b(this.e + i7 + 10)) < '0' || b2 > '9') {
                        return false;
                    }
                    int i15 = b2 - '0';
                    if (i2 <= i14 || (b5 = b(this.e + i7 + 11)) < '0' || b5 > '9') {
                        i8 = 1;
                    } else {
                        i15 = (i15 * 10) + (b5 - '0');
                        i8 = 2;
                    }
                    if (i8 == 2 && (b4 = b(this.e + i7 + 12)) >= '0' && b4 <= '9') {
                        i15 = (i15 * 10) + (b4 - '0');
                        i8 = 3;
                    }
                    this.o.set(14, i15);
                    char b34 = b(this.e + i7 + 10 + i8);
                    if (b34 == '+' || b34 == '-') {
                        char b35 = b(this.e + i7 + 10 + i8 + 1);
                        if (b35 < '0' || b35 > '1' || (b3 = b(this.e + i7 + 10 + i8 + 2)) < '0' || b3 > '9') {
                            return false;
                        }
                        char b36 = b(this.e + i7 + 10 + i8 + 3);
                        if (b36 == ':') {
                            if (!(b(this.e + i7 + 10 + i8 + 4) == '0' && b(this.e + i7 + 10 + i8 + 5) == '0')) {
                                return false;
                            }
                            i9 = 6;
                        } else if (b36 != '0') {
                            i9 = 3;
                        } else if (b(this.e + i7 + 10 + i8 + 4) != '0') {
                            return false;
                        } else {
                            i9 = 5;
                        }
                        a(b34, b35, b3);
                    } else if (b34 == 'Z') {
                        if (this.o.getTimeZone().getRawOffset() != 0) {
                            String[] availableIDs = TimeZone.getAvailableIDs(0);
                            if (availableIDs.length > 0) {
                                this.o.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                            }
                        }
                        i9 = 1;
                    } else {
                        i9 = 0;
                    }
                    int i16 = i7 + 10 + i8 + i9;
                    char b37 = b(this.e + i16);
                    if (!(b37 == 26 || b37 == '\"')) {
                        return false;
                    }
                    int i17 = this.e + i16;
                    this.e = i17;
                    this.d = b(i17);
                    this.a = 5;
                    return true;
                }
                this.o.set(14, 0);
                int i18 = this.e + i13;
                this.e = i18;
                this.d = b(i18);
                this.a = 5;
                if (b33 == 'Z' && this.o.getTimeZone().getRawOffset() != 0) {
                    String[] availableIDs2 = TimeZone.getAvailableIDs(0);
                    if (availableIDs2.length > 0) {
                        this.o.setTimeZone(TimeZone.getTimeZone(availableIDs2[0]));
                    }
                }
                return true;
            } else if (b26 == '\"' || b26 == 26 || b26 == 26085 || b26 == 51068) {
                this.o.set(11, 0);
                this.o.set(12, 0);
                this.o.set(13, 0);
                this.o.set(14, 0);
                int i19 = this.e + i7;
                this.e = i19;
                this.d = b(i19);
                this.a = 5;
                return true;
            } else if ((b26 != '+' && b26 != '-') || this.r != i7 + 6 || b(this.e + i7 + 3) != ':' || b(this.e + i7 + 4) != '0' || b(this.e + i7 + 5) != '0') {
                return false;
            } else {
                a('0', '0', '0', '0', '0', '0');
                this.o.set(14, 0);
                a(b26, b(this.e + i7 + 1), b(this.e + i7 + 2));
                return true;
            }
        }
        if (z2) {
            return z3;
        }
        char b38 = b(this.e);
        char b39 = b(this.e + 1);
        char b40 = b(this.e + 2);
        char b41 = b(this.e + 3);
        char b42 = b(this.e + 4);
        char b43 = b(this.e + 5);
        char b44 = b(this.e + 6);
        char b45 = b(this.e + 7);
        char b46 = b(this.e + 8);
        boolean z4 = b42 == c3 && b45 == c3;
        boolean z5 = z4 && i2 == 16;
        boolean z6 = z4 && i2 == 17;
        if (z6 || z5) {
            c4 = b(this.e + 9);
            c7 = b43;
            c6 = b44;
            c5 = b46;
        } else {
            c7 = b42;
            c6 = b43;
            c5 = b44;
            c4 = b45;
        }
        if (!a(b38, b39, b40, b41, c7, c6, (int) c5, (int) c4)) {
            return z3;
        }
        a(b38, b39, b40, b41, c7, c6, c5, c4);
        if (i2 != 8) {
            char b47 = b(this.e + 9);
            char b48 = b(this.e + 10);
            char b49 = b(this.e + 11);
            char b50 = b(this.e + 12);
            char b51 = b(this.e + 13);
            if (!(z6 && b48 == 'T' && b51 == ':' && b(this.e + 16) == 'Z') && (!z5 || !((b48 == ' ' || b48 == 'T') && b51 == ':'))) {
                c8 = b51;
                c9 = b49;
                b49 = b46;
            } else {
                b48 = b(this.e + i3);
                c9 = b(this.e + 15);
                b47 = b50;
                c8 = '0';
                b50 = '0';
            }
            if (!b(b49, b47, b48, c9, b50, c8)) {
                return z3;
            }
            if (i2 != 17 || z6) {
                i4 = 0;
            } else {
                char b52 = b(this.e + i3);
                char b53 = b(this.e + 15);
                char b54 = b(this.e + 16);
                if (b52 < c2 || b52 > '9' || b53 < c2 || b53 > '9' || b54 < c2 || b54 > '9') {
                    return z3;
                }
                i4 = ((b52 - c2) * 100) + ((b53 - c2) * 10) + (b54 - c2);
            }
            int i20 = (b47 - c2) + ((b49 - c2) * 10);
            i6 = ((b48 - c2) * 10) + (c9 - c2);
            i5 = ((b50 - c2) * 10) + (c8 - c2);
            z3 = i20;
        } else {
            i6 = 0;
            i5 = 0;
            i4 = 0;
        }
        Calendar calendar = this.o;
        int i21 = z3 ? 1 : 0;
        int i22 = z3 ? 1 : 0;
        int i23 = z3 ? 1 : 0;
        int i24 = z3 ? 1 : 0;
        int i25 = z3 ? 1 : 0;
        int i26 = z3 ? 1 : 0;
        calendar.set(11, i21);
        this.o.set(12, i6);
        this.o.set(13, i5);
        this.o.set(i3, i4);
        this.a = 5;
        return true;
    }

    private void a(char c2, char c3, char c4, char c5, char c6, char c7) {
        this.o.set(11, ((c2 - '0') * 10) + (c3 - '0'));
        this.o.set(12, ((c4 - '0') * 10) + (c5 - '0'));
        this.o.set(13, ((c6 - '0') * 10) + (c7 - '0'));
    }

    private void a(char c2, char c3, char c4) {
        int i2 = (((c3 - '0') * 10) + (c4 - '0')) * 3600 * 1000;
        if (c2 == '-') {
            i2 = -i2;
        }
        if (this.o.getTimeZone().getRawOffset() != i2) {
            String[] availableIDs = TimeZone.getAvailableIDs(i2);
            if (availableIDs.length > 0) {
                this.o.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
            }
        }
    }

    private static boolean b(char c2, char c3, char c4, char c5, char c6, char c7) {
        if (c2 == '0') {
            if (c3 < '0' || c3 > '9') {
                return false;
            }
        } else if (c2 == '1') {
            if (c3 < '0' || c3 > '9') {
                return false;
            }
        } else if (c2 != '2' || c3 < '0' || c3 > '4') {
            return false;
        }
        if (c4 < '0' || c4 > '5') {
            if (!(c4 == '6' && c5 == '0')) {
                return false;
            }
        } else if (c5 < '0' || c5 > '9') {
            return false;
        }
        if (c6 < '0' || c6 > '5') {
            if (c6 == '6' && c7 == '0') {
                return true;
            }
            return false;
        } else if (c7 < '0' || c7 > '9') {
            return false;
        } else {
            return true;
        }
    }

    private void a(char c2, char c3, char c4, char c5, char c6, char c7, char c8, char c9) {
        this.o = Calendar.getInstance(this.m, this.n);
        this.o.set(1, ((c2 - '0') * 1000) + ((c3 - '0') * 100) + ((c4 - '0') * 10) + (c5 - '0'));
        this.o.set(2, (((c6 - '0') * 10) + (c7 - '0')) - 1);
        this.o.set(5, ((c8 - '0') * 10) + (c9 - '0'));
    }

    private static boolean a(char c2, char c3, char c4, char c5, char c6, char c7, int i2, int i3) {
        if (c2 < '1' || c2 > '3' || c3 < '0' || c3 > '9' || c4 < '0' || c4 > '9' || c5 < '0' || c5 > '9') {
            return false;
        }
        if (c6 == '0') {
            if (c7 < '1' || c7 > '9') {
                return false;
            }
        } else if (c6 != '1') {
            return false;
        } else {
            if (!(c7 == '0' || c7 == '1' || c7 == '2')) {
                return false;
            }
        }
        if (i2 == 48) {
            if (i3 < 49 || i3 > 57) {
                return false;
            }
            return true;
        } else if (i2 == 49 || i2 == 50) {
            if (i3 < 48 || i3 > 57) {
                return false;
            }
            return true;
        } else if (i2 != 51) {
            return false;
        } else {
            if (i3 == 48 || i3 == 49) {
                return true;
            }
            return false;
        }
    }

    public static final byte[] a(String str, int i2, int i3) {
        int i4;
        int i5 = 0;
        if (i3 == 0) {
            return new byte[0];
        }
        int i6 = (i2 + i3) - 1;
        while (i2 < i6 && x[str.charAt(i2)] < 0) {
            i2++;
        }
        while (i6 > 0 && x[str.charAt(i6)] < 0) {
            i6--;
        }
        int i7 = str.charAt(i6) == '=' ? str.charAt(i6 + -1) == '=' ? 2 : 1 : 0;
        int i8 = (i6 - i2) + 1;
        if (i3 > 76) {
            i4 = (str.charAt(76) == '\r' ? i8 / 78 : 0) << 1;
        } else {
            i4 = 0;
        }
        int i9 = (((i8 - i4) * 6) >> 3) - i7;
        byte[] bArr = new byte[i9];
        int i10 = (i9 / 3) * 3;
        int i11 = i2;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            int i14 = i11 + 1;
            int i15 = i14 + 1;
            int i16 = i15 + 1;
            int i17 = i16 + 1;
            int i18 = (x[str.charAt(i11)] << 18) | (x[str.charAt(i14)] << 12) | (x[str.charAt(i15)] << 6) | x[str.charAt(i16)];
            int i19 = i12 + 1;
            bArr[i12] = (byte) (i18 >> 16);
            int i20 = i19 + 1;
            bArr[i19] = (byte) (i18 >> 8);
            int i21 = i20 + 1;
            bArr[i20] = (byte) i18;
            if (i4 <= 0 || (i13 = i13 + 1) != 19) {
                i11 = i17;
            } else {
                i11 = i17 + 2;
                i13 = 0;
            }
            i12 = i21;
        }
        if (i12 < i9) {
            int i22 = 0;
            while (i11 <= i6 - i7) {
                i5 |= x[str.charAt(i11)] << (18 - (i22 * 6));
                i22++;
                i11++;
            }
            int i23 = 16;
            while (i12 < i9) {
                bArr[i12] = (byte) (i5 >> i23);
                i23 -= 8;
                i12++;
            }
        }
        return bArr;
    }
}
