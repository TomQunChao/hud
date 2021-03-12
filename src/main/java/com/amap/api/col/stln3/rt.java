package com.amap.api.col.stln3;

/* compiled from: HashCodeBuilder */
public final class rt {
    private final int a;
    private int b;

    public rt() {
        this.b = 0;
        this.a = 37;
        this.b = 17;
    }

    private rt a(long j) {
        this.b = (this.b * this.a) + ((int) (j ^ (j >> 32)));
        return this;
    }

    public final rt a(Object obj) {
        if (obj == null) {
            this.b *= this.a;
        } else if (obj.getClass().isArray()) {
            int i = 0;
            if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                if (jArr == null) {
                    this.b *= this.a;
                } else {
                    while (i < jArr.length) {
                        a(jArr[i]);
                        i++;
                    }
                }
            } else if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr == null) {
                    this.b *= this.a;
                } else {
                    while (i < iArr.length) {
                        this.b = (this.b * this.a) + iArr[i];
                        i++;
                    }
                }
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                if (sArr == null) {
                    this.b *= this.a;
                } else {
                    while (i < sArr.length) {
                        this.b = (this.b * this.a) + sArr[i];
                        i++;
                    }
                }
            } else if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                if (cArr == null) {
                    this.b *= this.a;
                } else {
                    while (i < cArr.length) {
                        this.b = (this.b * this.a) + cArr[i];
                        i++;
                    }
                }
            } else if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                if (bArr == null) {
                    this.b *= this.a;
                } else {
                    while (i < bArr.length) {
                        this.b = (this.b * this.a) + bArr[i];
                        i++;
                    }
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                if (dArr == null) {
                    this.b *= this.a;
                } else {
                    while (i < dArr.length) {
                        a(Double.doubleToLongBits(dArr[i]));
                        i++;
                    }
                }
            } else if (obj instanceof float[]) {
                float[] fArr = (float[]) obj;
                if (fArr == null) {
                    this.b *= this.a;
                } else {
                    while (i < fArr.length) {
                        this.b = (this.b * this.a) + Float.floatToIntBits(fArr[i]);
                        i++;
                    }
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                if (zArr == null) {
                    this.b *= this.a;
                } else {
                    while (i < zArr.length) {
                        this.b = (this.b * this.a) + (!zArr[i] ? 1 : 0);
                        i++;
                    }
                }
            } else {
                a((Object[]) obj);
            }
        } else {
            this.b = (this.b * this.a) + obj.hashCode();
        }
        return this;
    }

    public final rt a(Object[] objArr) {
        if (objArr == null) {
            this.b *= this.a;
        } else {
            for (Object obj : objArr) {
                a(obj);
            }
        }
        return this;
    }

    public final int a() {
        return this.b;
    }

    public final int hashCode() {
        return this.b;
    }
}
