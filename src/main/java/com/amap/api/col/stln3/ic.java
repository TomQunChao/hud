package com.amap.api.col.stln3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Build;
import android.support.v7.widget.ActivityChooserView;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.amap.api.col.stln3.rj;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.CircleHoleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.PolygonHoleOptions;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.AeUtil;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.FPoint3;
import com.autonavi.amap.mapcore.FileUtil;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: Util */
public final class ic {
    private static FPoint[] a = {FPoint.obtain(), FPoint.obtain(), FPoint.obtain(), FPoint.obtain()};
    private static List<Float> b = new ArrayList(4);
    private static List<Float> c = new ArrayList(4);

    public static Bitmap a(Context context, String str) {
        try {
            InputStream open = hw.a(context).open(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            open.close();
            return decodeStream;
        } catch (Throwable th) {
            rx.c(th, "Util", "fromAsset");
            return null;
        }
    }

    public static void a(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public static String a(String str, Object obj) {
        return str + "=" + String.valueOf(obj);
    }

    public static float a(float f, float f2) {
        int i;
        if (f <= 40.0f) {
            return f;
        }
        if (f2 <= 15.0f) {
            i = 40;
        } else if (f2 <= 16.0f) {
            i = 56;
        } else if (f2 <= 17.0f) {
            i = 66;
        } else {
            int i2 = (f2 > 18.0f ? 1 : (f2 == 18.0f ? 0 : -1));
            if (i2 <= 0) {
                i = 74;
            } else if (i2 <= 0) {
                i = 78;
            } else {
                i = 80;
            }
        }
        float f3 = (float) i;
        return f > f3 ? f3 : f;
    }

    public static float a(MapConfig mapConfig, float f) {
        if (mapConfig != null) {
            if (f > mapConfig.maxZoomLevel) {
                return mapConfig.maxZoomLevel;
            }
            if (f < mapConfig.minZoomLevel) {
                return mapConfig.minZoomLevel;
            }
            return f;
        } else if (f > 20.0f) {
            return 20.0f;
        } else {
            if (f < 3.0f) {
                return 3.0f;
            }
            return f;
        }
    }

    public static FloatBuffer a(float[] fArr) {
        try {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            asFloatBuffer.put(fArr);
            asFloatBuffer.position(0);
            return asFloatBuffer;
        } catch (Throwable th) {
            rx.c(th, "Util", "makeFloatBuffer1");
            th.printStackTrace();
            return null;
        }
    }

    public static FloatBuffer a(float[] fArr, FloatBuffer floatBuffer) {
        try {
            floatBuffer.clear();
            floatBuffer.put(fArr);
            floatBuffer.position(0);
            return floatBuffer;
        } catch (Throwable th) {
            rx.c(th, "Util", "makeFloatBuffer2");
            th.printStackTrace();
            return null;
        }
    }

    public static int a() {
        return a(Bitmap.createBitmap(512, 1024, Bitmap.Config.ARGB_8888), true);
    }

    public static int a(Bitmap bitmap) {
        return a(bitmap, false);
    }

    public static int b(Bitmap bitmap) {
        return a(bitmap, true);
    }

    private static int a(Bitmap bitmap, boolean z) {
        int a2 = a(0, bitmap, z);
        if (bitmap != null) {
            bitmap.recycle();
        }
        return a2;
    }

    public static int a(int i, Bitmap bitmap, boolean z) {
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        if (i == 0) {
            int[] iArr = {0};
            GLES20.glGenTextures(1, iArr, 0);
            i = iArr[0];
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        if (z) {
            GLES20.glTexParameterf(3553, 10242, 10497.0f);
            GLES20.glTexParameterf(3553, 10243, 10497.0f);
        } else {
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
        }
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        return i;
    }

    public static int a(int i, Bitmap bitmap, int i2, int i3) {
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        if (i == 0) {
            int[] iArr = {0};
            GLES20.glGenTextures(1, iArr, 0);
            i = iArr[0];
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLUtils.texSubImage2D(3553, 0, i2, i3, bitmap);
        return i;
    }

    public static String a(String... strArr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : strArr) {
            sb.append(str);
            if (i != strArr.length - 1) {
                sb.append(",");
            }
            i++;
        }
        return sb.toString();
    }

    public static int a(Object[] objArr) {
        return Arrays.hashCode(objArr);
    }

    public static Bitmap a(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) * f), (int) (((float) bitmap.getHeight()) * f), true);
    }

    public static String a(Context context) {
        File file = new File(FileUtil.getMapBaseStorage(context), AeUtil.ROOT_DATA_PATH_NAME);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file.toString() + File.separator);
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file.toString() + File.separator;
    }

    public static String b(Context context) {
        return FileUtil.getMapBaseStorage(context) + File.separator + "data" + File.separator;
    }

    public static String c(Context context) {
        String a2 = a(context);
        if (a2 == null) {
            return null;
        }
        File file = new File(a2, "VMAP2");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.toString() + File.separator;
    }

    public static String a(int i) {
        if (i < 1000) {
            return i + "m";
        }
        return (i / 1000) + "km";
    }

    public static boolean d(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || (state = activeNetworkInfo.getState()) == null || state == NetworkInfo.State.DISCONNECTED || state == NetworkInfo.State.DISCONNECTING) {
            return false;
        }
        return true;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 8;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 9;
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT >= 11;
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT >= 12;
    }

    public static void b(int i) {
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
    }

    public static String a(InputStream inputStream) {
        try {
            return new String(b(inputStream), "utf-8");
        } catch (Throwable th) {
            rx.c(th, "Util", "decodeAssetResData");
            th.printStackTrace();
            return null;
        }
    }

    private static byte[] b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr, 0, 2048);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x010a A[SYNTHETIC, Splitter:B:102:0x010a] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0133 A[SYNTHETIC, Splitter:B:120:0x0133] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0087 A[SYNTHETIC, Splitter:B:50:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00b0 A[SYNTHETIC, Splitter:B:68:0x00b0] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00cb A[SYNTHETIC, Splitter:B:76:0x00cb] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x00f4 A[SYNTHETIC, Splitter:B:94:0x00f4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r6) {
        /*
        // Method dump skipped, instructions count: 320
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ic.a(java.io.File):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0105 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(com.amap.api.maps.model.LatLng r31, java.util.List<com.amap.api.maps.model.LatLng> r32) {
        /*
        // Method dump skipped, instructions count: 282
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ic.a(com.amap.api.maps.model.LatLng, java.util.List):boolean");
    }

    private static boolean a(double d, double d2, double d3, double d4, double d5, double d6) {
        if (Math.abs(((d3 - d) * (d6 - d2)) - ((d5 - d) * (d4 - d2))) >= 1.0E-9d || (d - d3) * (d - d5) > 0.0d || (d2 - d4) * (d2 - d6) > 0.0d) {
            return false;
        }
        return true;
    }

    public static boolean a(BaseHoleOptions baseHoleOptions, LatLng latLng) {
        if (baseHoleOptions instanceof CircleHoleOptions) {
            CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
            LatLng center = circleHoleOptions.getCenter();
            double radius = circleHoleOptions.getRadius();
            if (center != null && ((double) AMapUtils.calculateLineDistance(center, latLng)) <= radius) {
                return true;
            }
            return false;
        }
        List<LatLng> points = ((PolygonHoleOptions) baseHoleOptions).getPoints();
        if (points == null || points.size() == 0) {
            return false;
        }
        return a(latLng, points);
    }

    public static List<FPoint> a(FPoint[] fPointArr, List<FPoint> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        for (byte b2 = 0; b2 < 4; b2 = (byte) (b2 + 1)) {
            arrayList.clear();
            int size = arrayList2.size();
            int i = 0;
            while (i < size - 1) {
                FPoint fPoint = (FPoint) arrayList2.get(i % size);
                int i2 = i + 1;
                FPoint fPoint2 = (FPoint) arrayList2.get(i2 % size);
                if (i == 0 && a(fPoint, fPointArr[b2], fPointArr[(b2 + 1) % fPointArr.length])) {
                    arrayList.add(fPoint);
                }
                int i3 = b2 + 1;
                if (a(fPoint, fPointArr[b2], fPointArr[i3 % fPointArr.length])) {
                    if (a(fPoint2, fPointArr[b2], fPointArr[i3 % fPointArr.length])) {
                        arrayList.add(fPoint2);
                    } else {
                        arrayList.add(a(fPointArr[b2], fPointArr[i3 % fPointArr.length], fPoint, fPoint2));
                    }
                } else if (a(fPoint2, fPointArr[b2], fPointArr[i3 % fPointArr.length])) {
                    arrayList.add(a(fPointArr[b2], fPointArr[i3 % fPointArr.length], fPoint, fPoint2));
                    arrayList.add(fPoint2);
                }
                i = i2;
            }
            arrayList2.clear();
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                arrayList2.add(arrayList.get(i4));
            }
        }
        return arrayList2;
    }

    public static List<FPoint> b(FPoint[] fPointArr, List<FPoint> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        for (byte b2 = 0; b2 < 4; b2 = (byte) (b2 + 1)) {
            arrayList.clear();
            int size = arrayList2.size();
            int i = 0;
            while (i < size - 1) {
                FPoint3 fPoint3 = (FPoint3) arrayList2.get(i % size);
                int i2 = i + 1;
                FPoint3 fPoint32 = (FPoint3) arrayList2.get(i2 % size);
                if (i == 0 && a(fPoint3, fPointArr[b2], fPointArr[(b2 + 1) % fPointArr.length])) {
                    arrayList.add(fPoint3);
                }
                int i3 = b2 + 1;
                if (a(fPoint3, fPointArr[b2], fPointArr[i3 % fPointArr.length])) {
                    if (a(fPoint32, fPointArr[b2], fPointArr[i3 % fPointArr.length])) {
                        arrayList.add(fPoint32);
                    } else {
                        arrayList.add(a(fPointArr[b2], fPointArr[i3 % fPointArr.length], fPoint3, fPoint32, fPoint32.colorIndex));
                    }
                } else if (a(fPoint32, fPointArr[b2], fPointArr[i3 % fPointArr.length])) {
                    arrayList.add(a(fPointArr[b2], fPointArr[i3 % fPointArr.length], fPoint3, fPoint32, fPoint3.colorIndex));
                    arrayList.add(fPoint32);
                }
                i = i2;
            }
            arrayList2.clear();
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                arrayList2.add(arrayList.get(i4));
            }
        }
        return arrayList2;
    }

    public static FPoint[] a(co coVar) {
        float skyHeight = coVar.getSkyHeight();
        FPoint obtain = FPoint.obtain();
        int i = (int) (skyHeight - 10.0f);
        coVar.a(-100, i, (PointF) obtain);
        a[0].set(obtain.x, obtain.y);
        FPoint obtain2 = FPoint.obtain();
        coVar.a(coVar.getMapWidth() + 100, i, (PointF) obtain2);
        a[1].set(obtain2.x, obtain2.y);
        FPoint obtain3 = FPoint.obtain();
        coVar.a(coVar.getMapWidth() + 100, coVar.getMapHeight() + 100, (PointF) obtain3);
        a[2].set(obtain3.x, obtain3.y);
        FPoint obtain4 = FPoint.obtain();
        coVar.a(-100, coVar.getMapHeight() + 100, (PointF) obtain4);
        a[3].set(obtain4.x, obtain4.y);
        obtain.recycle();
        obtain2.recycle();
        obtain3.recycle();
        obtain4.recycle();
        return a;
    }

    private static FPoint3 a(FPoint fPoint, FPoint fPoint2, FPoint3 fPoint3, FPoint3 fPoint32, int i) {
        FPoint3 fPoint33 = new FPoint3(0.0f, 0.0f, i);
        double d = (double) (((fPoint2.y - fPoint.y) * (fPoint.x - fPoint3.x)) - ((fPoint2.x - fPoint.x) * (fPoint.y - fPoint3.y)));
        double d2 = (double) (((fPoint2.y - fPoint.y) * (fPoint32.x - fPoint3.x)) - ((fPoint2.x - fPoint.x) * (fPoint32.y - fPoint3.y)));
        fPoint33.x = (float) (((double) fPoint3.x) + ((((double) (fPoint32.x - fPoint3.x)) * d) / d2));
        fPoint33.y = (float) (((double) fPoint3.y) + ((((double) (fPoint32.y - fPoint3.y)) * d) / d2));
        return fPoint33;
    }

    private static FPoint a(FPoint fPoint, FPoint fPoint2, FPoint fPoint3, FPoint fPoint4) {
        FPoint obtain = FPoint.obtain(0.0f, 0.0f);
        double d = (double) (((fPoint2.y - fPoint.y) * (fPoint.x - fPoint3.x)) - ((fPoint2.x - fPoint.x) * (fPoint.y - fPoint3.y)));
        double d2 = (double) (((fPoint2.y - fPoint.y) * (fPoint4.x - fPoint3.x)) - ((fPoint2.x - fPoint.x) * (fPoint4.y - fPoint3.y)));
        obtain.x = (float) (((double) fPoint3.x) + ((((double) (fPoint4.x - fPoint3.x)) * d) / d2));
        obtain.y = (float) (((double) fPoint3.y) + ((((double) (fPoint4.y - fPoint3.y)) * d) / d2));
        return obtain;
    }

    public static boolean a(FPoint fPoint, FPoint[] fPointArr) {
        if (fPointArr == null) {
            return false;
        }
        byte b2 = 0;
        while (b2 < fPointArr.length) {
            FPoint fPoint2 = fPointArr[b2];
            int i = b2 + 1;
            if (!a(fPoint, fPoint2, fPointArr[i % fPointArr.length])) {
                return false;
            }
            b2 = (byte) i;
        }
        return true;
    }

    private static boolean a(FPoint fPoint, FPoint fPoint2, FPoint fPoint3) {
        if (((double) (((fPoint3.x - fPoint2.x) * (fPoint.y - fPoint2.y)) - ((fPoint.x - fPoint2.x) * (fPoint3.y - fPoint2.y)))) >= 0.0d) {
            return true;
        }
        return false;
    }

    public static boolean a(List<IPoint> list, int i) {
        if (i < 3) {
            return false;
        }
        int i2 = i - 1;
        double d = 0.0d;
        for (int i3 = 0; i3 < i; i3++) {
            IPoint iPoint = list.get(i2);
            IPoint iPoint2 = list.get(i3);
            d += ((((double) iPoint.x) / 1000000.0d) * (((double) iPoint2.y) / 1000000.0d)) - ((((double) iPoint2.x) / 1000000.0d) * (((double) iPoint.y) / 1000000.0d));
            i2 = i3;
        }
        if (d < 0.0d) {
            return true;
        }
        return false;
    }

    public static Bitmap a(int i, int i2, int i3) {
        int i4 = i2 * i3;
        try {
            int[] iArr = new int[i4];
            int[] iArr2 = new int[i4];
            IntBuffer wrap = IntBuffer.wrap(iArr);
            wrap.position(0);
            GLES20.glReadPixels(0, i, i2, i3, 6408, 5121, wrap);
            for (int i5 = 0; i5 < i3; i5++) {
                for (int i6 = 0; i6 < i2; i6++) {
                    int i7 = iArr[(i5 * i2) + i6];
                    iArr2[(((i3 - i5) - 1) * i2) + i6] = (i7 & -16711936) | ((i7 << 16) & 16711680) | ((i7 >> 16) & 255);
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr2, 0, i2, 0, 0, i2, i3);
            return createBitmap;
        } catch (Throwable th) {
            rx.c(th, "AMapDelegateImpGLSurfaceView", "SavePixels");
            th.printStackTrace();
            return null;
        }
    }

    public static rj f() {
        try {
            if (ch.e == null) {
                return new rj.a("3dmap", "6.6.0", ch.c).a(new String[]{"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core"}).a("6.6.0").a();
            }
            return ch.e;
        } catch (Throwable th) {
            return null;
        }
    }

    private static void b(View view) {
        int i = 0;
        if (view instanceof ViewGroup) {
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i < viewGroup.getChildCount()) {
                    b(viewGroup.getChildAt(i));
                    i++;
                } else {
                    return;
                }
            }
        } else if (view instanceof TextView) {
            ((TextView) view).setHorizontallyScrolling(false);
        }
    }

    public static Bitmap a(View view) {
        try {
            b(view);
            view.destroyDrawingCache();
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                return drawingCache.copy(Bitmap.Config.ARGB_8888, false);
            }
            return null;
        } catch (Throwable th) {
            rx.c(th, "Utils", "getBitmapFromView");
            th.printStackTrace();
            return null;
        }
    }

    public static DPoint a(LatLng latLng) {
        double sin = Math.sin(Math.toRadians(latLng.latitude));
        return DPoint.obtain(((latLng.longitude / 360.0d) + 0.5d) * 1.0d, (((Math.log((sin + 1.0d) / (1.0d - sin)) * 0.5d) / -6.283185307179586d) + 0.5d) * 1.0d);
    }

    public static boolean a(Rect rect, int i, int i2) {
        return rect.contains(i, i2);
    }

    public static Pair<Float, IPoint> a(AbstractCameraUpdateMessage abstractCameraUpdateMessage, MapConfig mapConfig) {
        return a(mapConfig, Math.max(abstractCameraUpdateMessage.paddingLeft, 1), Math.max(abstractCameraUpdateMessage.paddingRight, 1), Math.max(abstractCameraUpdateMessage.paddingTop, 1), Math.max(abstractCameraUpdateMessage.paddingBottom, 1), abstractCameraUpdateMessage.bounds, abstractCameraUpdateMessage.width, abstractCameraUpdateMessage.height);
    }

    public static Pair<Float, IPoint> a(MapConfig mapConfig, int i, int i2, int i3, int i4, LatLngBounds latLngBounds, int i5, int i6) {
        Point point;
        float f;
        boolean z;
        int i7;
        int i8;
        if (latLngBounds == null || latLngBounds.northeast == null || latLngBounds.southwest == null || mapConfig == null) {
            return null;
        }
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(latLngBounds.northeast.latitude, latLngBounds.northeast.longitude, 20);
        Point latLongToPixels2 = VirtualEarthProjection.latLongToPixels(latLngBounds.southwest.latitude, latLngBounds.southwest.longitude, 20);
        int i9 = latLongToPixels.x - latLongToPixels2.x;
        int i10 = latLongToPixels2.y - latLongToPixels.y;
        int i11 = i5 - (i + i2);
        int i12 = i6 - (i3 + i4);
        if (i9 < 0 && i10 < 0) {
            return null;
        }
        if (i9 <= 0) {
            i9 = 1;
        }
        if (i10 <= 0) {
            i10 = 1;
        }
        if (i11 <= 0) {
            i11 = 1;
        }
        if (i12 <= 0) {
            i12 = 1;
        }
        int i13 = latLongToPixels.x;
        int i14 = latLongToPixels.y;
        int i15 = latLongToPixels2.x;
        int i16 = latLongToPixels2.y;
        mapConfig.getSZ();
        if (i13 == i15 && i14 == i16) {
            f = mapConfig.getMaxZoomLevel();
            point = latLongToPixels;
            z = true;
        } else {
            point = latLongToPixels;
            float a2 = (float) a(mapConfig.getMapZoomScale(), (double) i11, (double) Math.abs(i15 - i13));
            float min = Math.min(a2, (float) a(mapConfig.getMapZoomScale(), (double) i12, (double) Math.abs(i16 - i14)));
            boolean z2 = min == a2;
            f = Math.min(mapConfig.getMaxZoomLevel(), Math.max(mapConfig.getMinZoomLevel(), min));
            z = z2;
        }
        Pair pair = new Pair(Float.valueOf(f), Boolean.valueOf(z));
        float floatValue = ((Float) pair.first).floatValue();
        boolean booleanValue = ((Boolean) pair.second).booleanValue();
        float a3 = a(mapConfig.getMapZoomScale(), floatValue, (double) i9);
        float a4 = a(mapConfig.getMapZoomScale(), floatValue, (double) i10);
        if (floatValue >= mapConfig.maxZoomLevel) {
            i8 = (int) (((float) latLongToPixels2.x) + (((((float) (i2 - i)) + a3) * ((float) i9)) / (a3 * 2.0f)));
            i7 = (int) (((float) point.y) + (((((float) (i4 - i3)) + a4) * ((float) i10)) / (a4 * 2.0f)));
        } else if (booleanValue) {
            i8 = (int) (((float) latLongToPixels2.x) + ((((float) ((i5 / 2) - i)) / a3) * ((float) i9)));
            i7 = (int) (((float) point.y) + (((((float) (i4 - i3)) + a4) * ((float) i10)) / (a4 * 2.0f)));
        } else {
            i8 = (int) (((float) latLongToPixels2.x) + (((((float) (i2 - i)) + a3) * ((float) i9)) / (a3 * 2.0f)));
            i7 = (int) (((float) point.y) + ((((float) ((i6 / 2) - i3)) / a4) * ((float) i10)));
        }
        return new Pair<>(Float.valueOf(floatValue), IPoint.obtain((int) (((float) i8) + a(mapConfig.getMapZoomScale(), floatValue, (float) (mapConfig.getAnchorX() - (mapConfig.getMapWidth() >> 1)))), (int) (((float) i7) + a(mapConfig.getMapZoomScale(), floatValue, (float) (mapConfig.getAnchorY() - (mapConfig.getMapHeight() >> 1))))));
    }

    private static double a(float f, double d, double d2) {
        return 20.0d - (Math.log(d2 / (d * ((double) f))) / Math.log(2.0d));
    }

    private static float a(float f, float f2, double d) {
        return (float) (d / (Math.pow(2.0d, (double) (20.0f - f2)) * ((double) f)));
    }

    private static float a(float f, float f2, float f3) {
        return (float) (((double) f3) * Math.pow(2.0d, (double) (20.0f - f2)) * ((double) f));
    }

    public static float a(MapConfig mapConfig, int i, int i2, int i3, int i4, int i5, int i6) {
        float sz = mapConfig.getSZ();
        if (i == i3 || i2 == i4) {
            return sz;
        }
        return Math.max((float) a(mapConfig.getMapZoomScale(), (double) i5, (double) Math.abs(i3 - i)), (float) a(mapConfig.getMapZoomScale(), (double) i6, (double) Math.abs(i4 - i2)));
    }

    public static boolean a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return false;
        }
        return true;
    }

    public static synchronized int[] a(int i, int i2, int i3, int i4, MapConfig mapConfig, GLMapState gLMapState, int i5, int i6) {
        int[] iArr;
        synchronized (ic.class) {
            int mapWidth = mapConfig.getMapWidth();
            int mapHeight = mapConfig.getMapHeight();
            int anchorX = mapConfig.getAnchorX();
            int anchorY = mapConfig.getAnchorY();
            float f = (float) i5;
            iArr = new int[]{(int) Math.max(((float) i3) + a(mapConfig.getMapZoomScale(), gLMapState.getMapZoomer(), (float) anchorX), Math.min(f, ((float) i) - a(mapConfig.getMapZoomScale(), gLMapState.getMapZoomer(), (float) (mapWidth - anchorX)))), (int) Math.max(((float) i2) + a(mapConfig.getMapZoomScale(), gLMapState.getMapZoomer(), (float) anchorY), Math.min((float) i6, ((float) i4) - a(mapConfig.getMapZoomScale(), gLMapState.getMapZoomer(), (float) (mapHeight - anchorY))))};
        }
        return iArr;
    }

    public static void a(Rect rect) {
        if (rect != null) {
            rect.set(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Integer.MIN_VALUE, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        }
    }

    public static void b(Rect rect, int i, int i2) {
        if (rect != null) {
            if (i < rect.left) {
                rect.left = i;
            }
            if (i > rect.right) {
                rect.right = i;
            }
            if (i2 > rect.top) {
                rect.top = i2;
            }
            if (i2 < rect.bottom) {
                rect.bottom = i2;
            }
        }
    }

    public static byte[] a(byte[] bArr, int[] iArr) {
        try {
            int i = 0;
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            Bitmap copy = decodeByteArray.copy(decodeByteArray.getConfig(), true);
            decodeByteArray.getWidth();
            decodeByteArray.getHeight();
            int i2 = 6;
            int i3 = 6;
            for (int i4 = 1; i4 < 72; i4++) {
                for (int i5 = 8; i5 < 12; i5++) {
                    decodeByteArray.getPixel(i5, i4);
                    if (i4 < i3 * 4) {
                        copy.setPixel(i5, i4, iArr[i]);
                    } else {
                        i++;
                        i2--;
                        i3 += i2;
                    }
                }
            }
            byte[] c2 = c(copy);
            if (c2 == null) {
                c2 = bArr;
            }
            copy.recycle();
            decodeByteArray.recycle();
            return c2;
        } catch (Throwable th) {
            th.printStackTrace();
            return bArr;
        }
    }

    public static byte[] a(byte[] bArr, int i) {
        try {
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            Bitmap copy = decodeByteArray.copy(decodeByteArray.getConfig(), true);
            int width = decodeByteArray.getWidth();
            int height = decodeByteArray.getHeight();
            for (int i2 = 1; i2 < width; i2++) {
                for (int i3 = 1; i3 < height; i3++) {
                    copy.setPixel(i2, i3, i);
                }
            }
            byte[] c2 = c(copy);
            if (c2 == null) {
                c2 = bArr;
            }
            copy.recycle();
            decodeByteArray.recycle();
            return c2;
        } catch (Throwable th) {
            th.printStackTrace();
            return bArr;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0027 A[SYNTHETIC, Splitter:B:15:0x0027] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] c(android.graphics.Bitmap r4) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Throwable -> 0x0033, all -> 0x0022 }
            r1.<init>()     // Catch:{ Throwable -> 0x0033, all -> 0x0022 }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Throwable -> 0x0020, all -> 0x001e }
            r3 = 100
            r4.compress(r2, r3, r1)     // Catch:{ Throwable -> 0x0020, all -> 0x001e }
            byte[] r4 = r1.toByteArray()     // Catch:{ Throwable -> 0x0020, all -> 0x001e }
            r1.close()     // Catch:{ Throwable -> 0x0018 }
            goto L_0x001c
        L_0x0018:
            r0 = move-exception
            r0.printStackTrace()
        L_0x001c:
            return r4
        L_0x001e:
            r4 = move-exception
            goto L_0x0024
        L_0x0020:
            r4 = move-exception
            goto L_0x0035
        L_0x0022:
            r4 = move-exception
            r1 = r0
        L_0x0024:
            if (r1 == 0) goto L_0x0030
            r1.close()     // Catch:{ Throwable -> 0x002b }
            goto L_0x0031
        L_0x002b:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0032
        L_0x0030:
        L_0x0031:
        L_0x0032:
            throw r4
        L_0x0033:
            r4 = move-exception
            r1 = r0
        L_0x0035:
            if (r1 == 0) goto L_0x0042
            r1.close()     // Catch:{ Throwable -> 0x003d }
            goto L_0x0043
        L_0x003d:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x0044
        L_0x0042:
        L_0x0043:
        L_0x0044:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ic.c(android.graphics.Bitmap):byte[]");
    }

    public static boolean a(List<BaseHoleOptions> list, PolygonHoleOptions polygonHoleOptions) {
        boolean z = false;
        for (int i = 0; i < list.size(); i++) {
            BaseHoleOptions baseHoleOptions = list.get(i);
            if (baseHoleOptions instanceof PolygonHoleOptions) {
                z = a(((PolygonHoleOptions) baseHoleOptions).getPoints(), polygonHoleOptions.getPoints());
                if (z) {
                    return true;
                }
            } else if ((baseHoleOptions instanceof CircleHoleOptions) && (z = b(polygonHoleOptions.getPoints(), (CircleHoleOptions) baseHoleOptions))) {
                return true;
            }
        }
        return z;
    }

    public static boolean a(List<BaseHoleOptions> list, CircleHoleOptions circleHoleOptions) {
        boolean z = false;
        for (int i = 0; i < list.size(); i++) {
            BaseHoleOptions baseHoleOptions = list.get(i);
            if (baseHoleOptions instanceof PolygonHoleOptions) {
                z = b(((PolygonHoleOptions) baseHoleOptions).getPoints(), circleHoleOptions);
                if (z) {
                    return true;
                }
            } else if ((baseHoleOptions instanceof CircleHoleOptions) && (z = a(circleHoleOptions, (CircleHoleOptions) baseHoleOptions))) {
                return true;
            }
        }
        return z;
    }

    private static boolean a(CircleHoleOptions circleHoleOptions, CircleHoleOptions circleHoleOptions2) {
        try {
            if (((double) AMapUtils.calculateLineDistance(circleHoleOptions2.getCenter(), circleHoleOptions.getCenter())) < circleHoleOptions.getRadius() + circleHoleOptions2.getRadius()) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            rx.c(th, "Util", "isPolygon2CircleIntersect");
            th.printStackTrace();
            return false;
        }
    }

    public static boolean b(List<LatLng> list, CircleHoleOptions circleHoleOptions) {
        int i;
        try {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                arrayList.add(list.get(i2));
            }
            arrayList.add(list.get(0));
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            while (i3 < arrayList.size() && (i = i3 + 1) < arrayList.size()) {
                if (circleHoleOptions.getRadius() < ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) arrayList.get(i3)))) {
                    if (circleHoleOptions.getRadius() < ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) arrayList.get(i)))) {
                        arrayList2.clear();
                        arrayList2.add(arrayList.get(i3));
                        arrayList2.add(arrayList.get(i));
                        if (circleHoleOptions.getRadius() >= ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) SpatialRelationUtil.calShortestDistancePoint(arrayList2, circleHoleOptions.getCenter()).second))) {
                            return true;
                        }
                        i3 = i;
                    }
                }
                return true;
            }
        } catch (Throwable th) {
            rx.c(th, "Util", "isPolygon2CircleIntersect");
            th.printStackTrace();
        }
        return false;
    }

    private static boolean a(List<LatLng> list, List<LatLng> list2) {
        for (int i = 0; i < list2.size(); i++) {
            try {
                if (a(list2.get(i), list)) {
                    return true;
                }
            } catch (Throwable th) {
                rx.c(th, "Util", "isPolygon2PolygonIntersect");
                th.printStackTrace();
                return false;
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (a(list.get(i2), list2)) {
                return true;
            }
        }
        return b(list, list2);
    }

    private static boolean b(List<LatLng> list, List<LatLng> list2) {
        int i;
        int i2;
        int i3 = 0;
        while (i3 < list.size() && (i = i3 + 1) < list.size()) {
            try {
                int i4 = 0;
                while (i4 < list2.size() && (i2 = i4 + 1) < list2.size()) {
                    boolean a2 = hx.a(list.get(i3), list.get(i), list2.get(i4), list2.get(i2));
                    if (a2) {
                        return a2;
                    }
                    i4 = i2;
                }
                i3 = i;
            } catch (Throwable th) {
                rx.c(th, "Util", "isSegmentsIntersect");
                th.printStackTrace();
            }
        }
        return false;
    }

    public static boolean e(Context context) {
        File file = new File(b(context));
        if (!file.exists()) {
            return true;
        }
        return FileUtil.deleteFile(file);
    }

    public static float a(DPoint dPoint, DPoint dPoint2) {
        if (dPoint == null || dPoint2 == null) {
            return 0.0f;
        }
        double d = dPoint.x;
        double d2 = dPoint2.x;
        return (float) ((Math.atan2(dPoint2.y - dPoint.y, d2 - d) / 3.141592653589793d) * 180.0d);
    }
}
