package com.amap.api.maps.model;

import android.graphics.Color;
import com.amap.api.maps.AMapException;
import java.util.HashMap;

public class Gradient {
    private int a;
    private int[] b;
    private float[] c;
    private boolean d;

    private static class a {
        private final int a;
        private final int b;
        private final float c;

        /* synthetic */ a(int i, int i2, float f, byte b2) {
            this(i, i2, f);
        }

        private a(int i, int i2, float f) {
            this.a = i;
            this.b = i2;
            this.c = f;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, (byte) 0);
    }

    private Gradient(int[] iArr, float[] fArr, byte b2) {
        this.d = true;
        if (iArr == null || fArr == null) {
            throw new AMapException("colors and startPoints should not be null");
        }
        try {
            if (iArr.length != fArr.length) {
                throw new AMapException("colors and startPoints should be same length");
            } else if (iArr.length != 0) {
                for (int i = 1; i < fArr.length; i++) {
                    if (fArr[i] <= fArr[i - 1]) {
                        throw new AMapException("startPoints should be in increasing order");
                    }
                }
                this.a = 1000;
                this.b = new int[iArr.length];
                this.c = new float[fArr.length];
                System.arraycopy(iArr, 0, this.b, 0, iArr.length);
                System.arraycopy(fArr, 0, this.c, 0, fArr.length);
                this.d = true;
            } else {
                throw new AMapException("No colors have been defined");
            }
        } catch (AMapException e) {
            this.d = false;
            e.getErrorMessage();
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public int[] generateColorMap(double d2) {
        HashMap hashMap = new HashMap(32);
        if (this.c[0] != 0.0f) {
            hashMap.put(0, new a(Color.argb(0, Color.red(this.b[0]), Color.green(this.b[0]), Color.blue(this.b[0])), this.b[0], ((float) this.a) * this.c[0], (byte) 0));
        }
        for (int i = 1; i < this.b.length; i++) {
            int i2 = i - 1;
            Integer valueOf = Integer.valueOf((int) (((float) this.a) * this.c[i2]));
            int[] iArr = this.b;
            int i3 = iArr[i2];
            int i4 = iArr[i];
            float[] fArr = this.c;
            hashMap.put(valueOf, new a(i3, i4, ((float) this.a) * (fArr[i] - fArr[i2]), (byte) 0));
        }
        float[] fArr2 = this.c;
        if (fArr2[fArr2.length - 1] != 1.0f) {
            int length = fArr2.length - 1;
            Integer valueOf2 = Integer.valueOf((int) (((float) this.a) * fArr2[length]));
            int[] iArr2 = this.b;
            hashMap.put(valueOf2, new a(iArr2[length], iArr2[length], ((float) this.a) * (1.0f - this.c[length]), (byte) 0));
        }
        int[] iArr3 = new int[this.a];
        a aVar = (a) hashMap.get(0);
        int i5 = 0;
        for (int i6 = 0; i6 < this.a; i6++) {
            if (hashMap.containsKey(Integer.valueOf(i6))) {
                aVar = (a) hashMap.get(Integer.valueOf(i6));
                i5 = i6;
            }
            iArr3[i6] = a(aVar.a, aVar.b, ((float) (i6 - i5)) / aVar.c);
        }
        if (d2 != 1.0d) {
            for (int i7 = 0; i7 < this.a; i7++) {
                int i8 = iArr3[i7];
                iArr3[i7] = Color.argb((int) (((double) Color.alpha(i8)) * d2), Color.red(i8), Color.green(i8), Color.blue(i8));
            }
        }
        return iArr3;
    }

    private static int a(int i, int i2, float f) {
        int alpha = (int) ((((float) (Color.alpha(i2) - Color.alpha(i))) * f) + ((float) Color.alpha(i)));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i), Color.green(i), Color.blue(i), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i2), Color.green(i2), Color.blue(i2), fArr2);
        if (fArr[0] - fArr2[0] > 180.0f) {
            fArr2[0] = fArr2[0] + 360.0f;
        } else if (fArr2[0] - fArr[0] > 180.0f) {
            fArr[0] = fArr[0] + 360.0f;
        }
        float[] fArr3 = new float[3];
        for (int i3 = 0; i3 < 3; i3++) {
            fArr3[i3] = ((fArr2[i3] - fArr[i3]) * f) + fArr[i3];
        }
        return Color.HSVToColor(alpha, fArr3);
    }

    /* access modifiers changed from: protected */
    public boolean isAvailable() {
        return this.d;
    }
}
