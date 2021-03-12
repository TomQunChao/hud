package com.amap.api.col.stln3;

/* compiled from: EarClippingTriangulator */
public final class hi {
    private final hy a = new hy();
    private short[] b;
    private double[] c;
    private int d;
    private final ho e = new ho();
    private final hy f = new hy();

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e8, code lost:
        r4 = r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.amap.api.col.stln3.hy a(double[] r43) {
        /*
        // Method dump skipped, instructions count: 443
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.hi.a(double[]):com.amap.api.col.stln3.hy");
    }

    private int a(int i) {
        short[] sArr = this.b;
        int i2 = sArr[b(i)] * 2;
        int i3 = sArr[i] * 2;
        int i4 = sArr[c(i)] * 2;
        double[] dArr = this.c;
        return a(dArr[i2], dArr[i2 + 1], dArr[i3], dArr[i3 + 1], dArr[i4], dArr[i4 + 1]);
    }

    private int b(int i) {
        if (i == 0) {
            i = this.d;
        }
        return i - 1;
    }

    private int c(int i) {
        return (i + 1) % this.d;
    }

    private static int a(double d2, double d3, double d4, double d5, double d6, double d7) {
        return (int) Math.signum((d2 * (d7 - d5)) + (d4 * (d3 - d7)) + (d6 * (d5 - d3)));
    }
}
