package com.amap.api.col.stln3;

/* compiled from: SymbolTable */
public final class y {
    private final a[] a = new a[16384];
    private final int b = 16383;

    public y() {
        a("$ref", 0, 4, "$ref".hashCode());
        a("@type", 0, 5, "@type".hashCode());
    }

    public final String a(char[] cArr, int i, int i2) {
        boolean z;
        int i3 = this.b & i2;
        a aVar = this.a[i3];
        if (aVar != null) {
            if (i2 == aVar.c && i == aVar.b.length) {
                int i4 = 0;
                while (true) {
                    if (i4 < i) {
                        if (cArr[i4 + 0] != aVar.b[i4]) {
                            break;
                        }
                        i4++;
                    } else {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                return aVar.a;
            }
            return new String(cArr, 0, i);
        }
        String intern = new String(cArr, 0, i).intern();
        this.a[i3] = new a(intern, i2);
        return intern;
    }

    public final String a(String str, int i, int i2, int i3) {
        int i4 = this.b & i3;
        a aVar = this.a[i4];
        if (aVar == null) {
            if (i2 != str.length()) {
                str = a(str, i, i2);
            }
            String intern = str.intern();
            this.a[i4] = new a(intern, i3);
            return intern;
        } else if (i3 == aVar.c && i2 == aVar.b.length && str.regionMatches(i, aVar.a, 0, i2)) {
            return aVar.a;
        } else {
            return a(str, i, i2);
        }
    }

    private static String a(String str, int i, int i2) {
        char[] cArr = new char[i2];
        str.getChars(i, i2 + i, cArr, 0);
        return new String(cArr);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: SymbolTable */
    public static class a {
        final String a;
        final char[] b;
        final int c;

        a(String str, int i) {
            this.a = str;
            this.b = str.toCharArray();
            this.c = i;
        }
    }
}
