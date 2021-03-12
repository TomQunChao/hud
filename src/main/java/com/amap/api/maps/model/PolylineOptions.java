package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions implements Parcelable {
    public static final PolylineOptionsCreator CREATOR = new PolylineOptionsCreator();
    public static final int DOTTEDLINE_TYPE_CIRCLE = 1;
    public static final int DOTTEDLINE_TYPE_SQUARE = 0;
    String a;
    private final List<LatLng> b = new ArrayList();
    private float c = 10.0f;
    private int d = ViewCompat.MEASURED_STATE_MASK;
    private float e = 0.0f;
    private boolean f = true;
    private BitmapDescriptor g;
    private List<BitmapDescriptor> h;
    private List<Integer> i;
    private List<Integer> j;
    private boolean k = true;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private float o = 1.0f;
    private boolean p = false;
    private int q = 0;
    private LineCapType r = LineCapType.LineCapRound;
    private LineJoinType s = LineJoinType.LineJoinBevel;
    private float t = -1.0f;

    public final PolylineOptions setUseTexture(boolean z) {
        this.k = z;
        return this;
    }

    public final PolylineOptions setCustomTexture(BitmapDescriptor bitmapDescriptor) {
        this.g = bitmapDescriptor;
        return this;
    }

    public final BitmapDescriptor getCustomTexture() {
        return this.g;
    }

    public final PolylineOptions setCustomTextureList(List<BitmapDescriptor> list) {
        this.h = list;
        return this;
    }

    public final List<BitmapDescriptor> getCustomTextureList() {
        return this.h;
    }

    public final PolylineOptions setCustomTextureIndex(List<Integer> list) {
        this.j = list;
        return this;
    }

    public final List<Integer> getCustomTextureIndex() {
        return this.j;
    }

    public final PolylineOptions colorValues(List<Integer> list) {
        this.i = list;
        return this;
    }

    public final List<Integer> getColorValues() {
        return this.i;
    }

    public final PolylineOptions useGradient(boolean z) {
        this.n = z;
        return this;
    }

    public final boolean isUseGradient() {
        return this.n;
    }

    public final boolean isUseTexture() {
        return this.k;
    }

    public final boolean isGeodesic() {
        return this.l;
    }

    public final PolylineOptions add(LatLng latLng) {
        if (latLng != null) {
            try {
                this.b.add(latLng);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public final PolylineOptions add(LatLng... latLngArr) {
        if (latLngArr != null) {
            try {
                this.b.addAll(Arrays.asList(latLngArr));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public final PolylineOptions addAll(Iterable<LatLng> iterable) {
        if (iterable != null) {
            try {
                for (LatLng latLng : iterable) {
                    this.b.add(latLng);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public final PolylineOptions width(float f2) {
        this.c = f2;
        return this;
    }

    public final PolylineOptions color(int i2) {
        this.d = i2;
        return this;
    }

    public final PolylineOptions zIndex(float f2) {
        this.e = f2;
        return this;
    }

    public final PolylineOptions visible(boolean z) {
        this.f = z;
        return this;
    }

    public final PolylineOptions geodesic(boolean z) {
        this.l = z;
        return this;
    }

    public final PolylineOptions setDottedLine(boolean z) {
        this.m = z;
        return this;
    }

    public final boolean isDottedLine() {
        return this.m;
    }

    public final PolylineOptions setDottedLineType(int i2) {
        this.q = i2 == 0 ? 0 : 1;
        return this;
    }

    public final PolylineOptions lineCapType(LineCapType lineCapType) {
        if (lineCapType != null) {
            this.r = lineCapType;
        }
        return this;
    }

    public final PolylineOptions lineJoinType(LineJoinType lineJoinType) {
        if (lineJoinType != null) {
            this.s = lineJoinType;
        }
        return this;
    }

    public final LineCapType getLineCapType() {
        return this.r;
    }

    public final LineJoinType getLineJoinType() {
        return this.s;
    }

    public final int getDottedLineType() {
        return this.q;
    }

    public final List<LatLng> getPoints() {
        return this.b;
    }

    public final float getWidth() {
        return this.c;
    }

    public final int getColor() {
        return this.d;
    }

    public final float getZIndex() {
        return this.e;
    }

    public final boolean isVisible() {
        return this.f;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.b);
        parcel.writeFloat(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.q);
        parcel.writeFloat(this.e);
        parcel.writeFloat(this.o);
        parcel.writeString(this.a);
        parcel.writeInt(this.r.getTypeValue());
        parcel.writeInt(this.s.getTypeValue());
        parcel.writeBooleanArray(new boolean[]{this.f, this.m, this.l, this.n, this.p});
        BitmapDescriptor bitmapDescriptor = this.g;
        if (bitmapDescriptor != null) {
            parcel.writeParcelable(bitmapDescriptor, i2);
        }
        List<BitmapDescriptor> list = this.h;
        if (list != null) {
            parcel.writeList(list);
        }
        List<Integer> list2 = this.j;
        if (list2 != null) {
            parcel.writeList(list2);
        }
        List<Integer> list3 = this.i;
        if (list3 != null) {
            parcel.writeList(list3);
        }
        parcel.writeFloat(this.t);
    }

    public final PolylineOptions transparency(float f2) {
        this.o = f2;
        return this;
    }

    public final float getTransparency() {
        return this.o;
    }

    public final PolylineOptions aboveMaskLayer(boolean z) {
        this.p = z;
        return this;
    }

    public final boolean isAboveMaskLayer() {
        return this.p;
    }

    public final void setPoints(List<LatLng> list) {
        List<LatLng> list2;
        if (list != null && (list2 = this.b) != list) {
            try {
                list2.clear();
                this.b.addAll(list);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final float getShownRatio() {
        return this.t;
    }

    public final PolylineOptions setShownRatio(float f2) {
        this.t = f2;
        return this;
    }

    public enum LineCapType {
        LineCapButt(0),
        LineCapSquare(1),
        LineCapArrow(2),
        LineCapRound(3);
        
        private int a;

        private LineCapType(int i) {
            this.a = i;
        }

        public static LineCapType valueOf(int i) {
            LineCapType[] values = values();
            return values[Math.max(0, Math.min(i, values.length))];
        }

        public final int getTypeValue() {
            return this.a;
        }
    }

    public enum LineJoinType {
        LineJoinBevel(0),
        LineJoinMiter(1),
        LineJoinRound(2);
        
        private int a;

        private LineJoinType(int i) {
            this.a = i;
        }

        public final int getTypeValue() {
            return this.a;
        }

        public static LineJoinType valueOf(int i) {
            LineJoinType[] values = values();
            return values[Math.max(0, Math.min(i, values.length))];
        }
    }
}
