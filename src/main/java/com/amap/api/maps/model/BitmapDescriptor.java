package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public final class BitmapDescriptor implements Parcelable, Cloneable {
    public static final BitmapDescriptorCreator CREATOR = new BitmapDescriptorCreator();
    int a = 0;
    int b = 0;
    Bitmap c;

    BitmapDescriptor(Bitmap bitmap) {
        if (bitmap != null) {
            this.a = bitmap.getWidth();
            this.b = bitmap.getHeight();
            if (bitmap.getConfig() == null) {
                this.c = bitmap.copy(Bitmap.Config.ARGB_8888, true);
            } else {
                this.c = bitmap.copy(bitmap.getConfig(), true);
            }
        }
    }

    private BitmapDescriptor(Bitmap bitmap, int i, int i2) {
        this.a = i;
        this.b = i2;
        this.c = bitmap;
    }

    @Override // java.lang.Object
    public final BitmapDescriptor clone() {
        try {
            return new BitmapDescriptor(this.c.copy(this.c.getConfig(), true), this.a, this.b);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final Bitmap getBitmap() {
        return this.c;
    }

    public final int getWidth() {
        return this.a;
    }

    public final int getHeight() {
        return this.b;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.c, i);
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
    }

    public final void recycle() {
        Bitmap bitmap = this.c;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.c.recycle();
            this.c = null;
        }
    }

    public final boolean equals(Object obj) {
        BitmapDescriptor bitmapDescriptor;
        Bitmap bitmap;
        Bitmap bitmap2 = this.c;
        if (bitmap2 == null || bitmap2.isRecycled() || obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass() || (bitmap = (bitmapDescriptor = (BitmapDescriptor) obj).c) == null || bitmap.isRecycled() || this.a != bitmapDescriptor.getWidth() || this.b != bitmapDescriptor.getHeight()) {
            return false;
        }
        try {
            return this.c.sameAs(bitmapDescriptor.c);
        } catch (Throwable th) {
            return false;
        }
    }

    public final int hashCode() {
        return super.hashCode();
    }
}
