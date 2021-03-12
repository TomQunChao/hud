package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.util.LongSparseArray;
import com.amap.api.col.stln3.hg;
import com.amap.api.maps.AMapException;
import com.autonavi.amap.mapcore.DPoint;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class HeatmapTileProvider implements TileProvider {
    public static final Gradient DEFAULT_GRADIENT = new Gradient(a, b);
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;
    private static final int[] a = {Color.rgb(102, 225, 0), Color.rgb(255, 0, 0)};
    private static final float[] b = {0.2f, 1.0f};
    private a c;
    private Collection<WeightedLatLng> d;
    private hg e;
    private int f;
    private Gradient g;
    private int[] h;
    private double[] i;
    private double j;
    private double[] k;

    /* synthetic */ HeatmapTileProvider(Builder builder, byte b2) {
        this(builder);
    }

    static /* synthetic */ Collection a(Collection collection) {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new WeightedLatLng((LatLng) it.next()));
        }
        return arrayList;
    }

    public static class Builder {
        private Collection<WeightedLatLng> a;
        private int b = 12;
        private Gradient c = HeatmapTileProvider.DEFAULT_GRADIENT;
        private double d = 0.6d;

        public Builder data(Collection<LatLng> collection) {
            return weightedData(HeatmapTileProvider.a(collection));
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            this.a = collection;
            return this;
        }

        public Builder radius(int i) {
            this.b = Math.max(10, Math.min(i, 50));
            return this;
        }

        public Builder gradient(Gradient gradient) {
            this.c = gradient;
            return this;
        }

        public Builder transparency(double d2) {
            this.d = Math.max(0.0d, Math.min(d2, 1.0d));
            return this;
        }

        public HeatmapTileProvider build() {
            Collection<WeightedLatLng> collection = this.a;
            if (collection == null || collection.size() == 0) {
                try {
                    throw new AMapException("No input points.");
                } catch (AMapException e) {
                    e.getErrorMessage();
                    e.printStackTrace();
                    return null;
                }
            } else {
                try {
                    return new HeatmapTileProvider(this, (byte) 0);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
        }
    }

    private HeatmapTileProvider(Builder builder) {
        this.d = builder.a;
        this.f = builder.b;
        this.g = builder.c;
        Gradient gradient = this.g;
        if (gradient == null || !gradient.isAvailable()) {
            this.g = DEFAULT_GRADIENT;
        }
        this.j = builder.d;
        int i2 = this.f;
        this.i = a(i2, ((double) i2) / 3.0d);
        Gradient gradient2 = this.g;
        this.g = gradient2;
        this.h = gradient2.generateColorMap(this.j);
        b(this.d);
    }

    private void b(Collection<WeightedLatLng> collection) {
        try {
            ArrayList arrayList = new ArrayList();
            for (WeightedLatLng weightedLatLng : collection) {
                if (weightedLatLng.latLng.latitude < 85.0d && weightedLatLng.latLng.latitude > -85.0d) {
                    arrayList.add(weightedLatLng);
                }
            }
            this.d = arrayList;
            this.e = c(this.d);
            this.c = new a(this.e);
            for (WeightedLatLng weightedLatLng2 : this.d) {
                this.c.a(weightedLatLng2);
            }
            this.k = a(this.f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public Tile getTile(int i2, int i3, int i4) {
        double d2;
        double pow = 1.0d / Math.pow(2.0d, (double) i4);
        int i5 = this.f;
        double d3 = (((double) i5) * pow) / 256.0d;
        double d4 = ((2.0d * d3) + pow) / ((double) ((i5 * 2) + 256));
        double d5 = (((double) i2) * pow) - d3;
        double d6 = (((double) (i2 + 1)) * pow) + d3;
        double d7 = (((double) i3) * pow) - d3;
        double d8 = (((double) (i3 + 1)) * pow) + d3;
        Collection<WeightedLatLng> arrayList = new ArrayList<>();
        if (d5 < 0.0d) {
            arrayList = this.c.a(new hg(d5 + 1.0d, 1.0d, d7, d8));
            d2 = -1.0d;
        } else if (d6 > 1.0d) {
            arrayList = this.c.a(new hg(0.0d, d6 - 1.0d, d7, d8));
            d2 = 1.0d;
        } else {
            d2 = 0.0d;
        }
        hg hgVar = new hg(d5, d6, d7, d8);
        if (!hgVar.a(new hg(this.e.a - d3, this.e.c + d3, this.e.b - d3, this.e.d + d3))) {
            return TileProvider.NO_TILE;
        }
        Collection<WeightedLatLng> a2 = this.c.a(hgVar);
        if (a2.isEmpty()) {
            return TileProvider.NO_TILE;
        }
        int i6 = this.f;
        double[][] dArr = (double[][]) Array.newInstance(double.class, (i6 * 2) + 256, (i6 * 2) + 256);
        for (Iterator<WeightedLatLng> it = a2.iterator(); it.hasNext(); it = it) {
            WeightedLatLng next = it.next();
            DPoint point = next.getPoint();
            int i7 = (int) ((point.y - d7) / d4);
            double[] dArr2 = dArr[(int) ((point.x - d5) / d4)];
            dArr2[i7] = dArr2[i7] + next.intensity;
        }
        for (WeightedLatLng weightedLatLng : arrayList) {
            DPoint point2 = weightedLatLng.getPoint();
            int i8 = (int) (((point2.x + d2) - d5) / d4);
            int i9 = (int) ((point2.y - d7) / d4);
            double[] dArr3 = dArr[i8];
            dArr3[i9] = dArr3[i9] + weightedLatLng.intensity;
        }
        Bitmap a3 = a(a(dArr, this.i), this.h, this.k[i4]);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a3.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return Tile.obtain(256, 256, byteArrayOutputStream.toByteArray());
    }

    private double[] a(int i2) {
        int i3;
        double[] dArr = new double[21];
        int i4 = 5;
        while (true) {
            if (i4 >= 11) {
                break;
            }
            Collection<WeightedLatLng> collection = this.d;
            hg hgVar = this.e;
            int pow = (int) (Math.pow(2.0d, (double) i4) * 1280.0d);
            double d2 = hgVar.a;
            double d3 = hgVar.c;
            double d4 = hgVar.b;
            double d5 = d3 - d2;
            double d6 = hgVar.d - d4;
            if (d5 > d6) {
                d6 = d5;
            }
            double d7 = ((double) ((int) (((double) (pow / (i2 * 2))) + 0.5d))) / d6;
            LongSparseArray longSparseArray = new LongSparseArray();
            Iterator<WeightedLatLng> it = collection.iterator();
            double d8 = 0.0d;
            while (it.hasNext()) {
                WeightedLatLng next = it.next();
                double d9 = next.getPoint().x;
                int i5 = (int) ((d9 - d2) * d7);
                int i6 = (int) ((next.getPoint().y - d4) * d7);
                long j2 = (long) i5;
                LongSparseArray longSparseArray2 = (LongSparseArray) longSparseArray.get(j2);
                if (longSparseArray2 == null) {
                    longSparseArray2 = new LongSparseArray();
                    longSparseArray.put(j2, longSparseArray2);
                }
                long j3 = (long) i6;
                Double d10 = (Double) longSparseArray2.get(j3);
                if (d10 == null) {
                    d10 = Double.valueOf(0.0d);
                }
                Double valueOf = Double.valueOf(d10.doubleValue() + next.intensity);
                longSparseArray2.put(j3, valueOf);
                if (valueOf.doubleValue() > d8) {
                    d8 = valueOf.doubleValue();
                }
                it = it;
                i4 = i4;
                d7 = d7;
            }
            dArr[i4] = d8;
            if (i4 == 5) {
                for (int i7 = 0; i7 < i4; i7++) {
                    dArr[i7] = dArr[i4];
                }
            }
            i4++;
        }
        for (i3 = 11; i3 < 21; i3++) {
            dArr[i3] = dArr[10];
        }
        return dArr;
    }

    private static hg c(Collection<WeightedLatLng> collection) {
        Iterator<WeightedLatLng> it = collection.iterator();
        WeightedLatLng next = it.next();
        double d2 = next.getPoint().x;
        double d3 = next.getPoint().x;
        double d4 = d2;
        double d5 = d3;
        double d6 = next.getPoint().y;
        double d7 = next.getPoint().y;
        while (it.hasNext()) {
            WeightedLatLng next2 = it.next();
            double d8 = next2.getPoint().x;
            double d9 = next2.getPoint().y;
            if (d8 < d4) {
                d4 = d8;
            }
            if (d8 > d5) {
                d5 = d8;
            }
            if (d9 < d6) {
                d6 = d9;
            }
            if (d9 > d7) {
                d7 = d9;
            }
        }
        return new hg(d4, d5, d6, d7);
    }

    private static double[] a(int i2, double d2) {
        double[] dArr = new double[((i2 * 2) + 1)];
        for (int i3 = -i2; i3 <= i2; i3++) {
            dArr[i3 + i2] = Math.exp(((double) ((-i3) * i3)) / ((2.0d * d2) * d2));
        }
        return dArr;
    }

    private static double[][] a(double[][] dArr, double[] dArr2) {
        int floor = (int) Math.floor(((double) dArr2.length) / 2.0d);
        int length = dArr.length;
        int i2 = length - (floor * 2);
        int i3 = (floor + i2) - 1;
        double[][] dArr3 = (double[][]) Array.newInstance(double.class, length, length);
        for (int i4 = 0; i4 < length; i4++) {
            for (int i5 = 0; i5 < length; i5++) {
                double d2 = dArr[i4][i5];
                if (d2 != 0.0d) {
                    int i6 = i4 + floor;
                    if (i3 < i6) {
                        i6 = i3;
                    }
                    int i7 = i6 + 1;
                    int i8 = i4 - floor;
                    for (int i9 = floor > i8 ? floor : i8; i9 < i7; i9++) {
                        double[] dArr4 = dArr3[i9];
                        dArr4[i5] = dArr4[i5] + (dArr2[i9 - i8] * d2);
                    }
                }
            }
        }
        double[][] dArr5 = (double[][]) Array.newInstance(double.class, i2, i2);
        for (int i10 = floor; i10 < i3 + 1; i10++) {
            for (int i11 = 0; i11 < length; i11++) {
                double d3 = dArr3[i10][i11];
                if (d3 != 0.0d) {
                    int i12 = i11 + floor;
                    if (i3 < i12) {
                        i12 = i3;
                    }
                    int i13 = i12 + 1;
                    int i14 = i11 - floor;
                    for (int i15 = floor > i14 ? floor : i14; i15 < i13; i15++) {
                        double[] dArr6 = dArr5[i10 - floor];
                        int i16 = i15 - floor;
                        dArr6[i16] = dArr6[i16] + (dArr2[i15 - i14] * d3);
                    }
                }
            }
        }
        return dArr5;
    }

    private static Bitmap a(double[][] dArr, int[] iArr, double d2) {
        int i2 = iArr[iArr.length - 1];
        double length = ((double) (iArr.length - 1)) / d2;
        int length2 = dArr.length;
        int[] iArr2 = new int[(length2 * length2)];
        for (int i3 = 0; i3 < length2; i3++) {
            for (int i4 = 0; i4 < length2; i4++) {
                double d3 = dArr[i4][i3];
                int i5 = (i3 * length2) + i4;
                int i6 = (int) (d3 * length);
                if (d3 == 0.0d) {
                    iArr2[i5] = 0;
                } else if (i6 < iArr.length) {
                    iArr2[i5] = iArr[i6];
                } else {
                    iArr2[i5] = i2;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(length2, length2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr2, 0, length2, 0, 0, length2, length2);
        return createBitmap;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileHeight() {
        return 256;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileWidth() {
        return 256;
    }
}
