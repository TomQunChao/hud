package com.autonavi.amap.mapcore;

public class FPointBounds {
    private final int mVersionCode;
    public final FPoint northeast;
    public final FPoint southwest;

    FPointBounds(int i, FPoint fPoint, FPoint fPoint2) {
        this.mVersionCode = i;
        this.southwest = fPoint;
        this.northeast = fPoint2;
    }

    public FPointBounds(FPoint fPoint, FPoint fPoint2) {
        this(1, fPoint, fPoint2);
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean contains(FPoint fPoint) {
        return containsy((double) fPoint.y) && containsx((double) fPoint.x);
    }

    public boolean contains(FPointBounds fPointBounds) {
        if (fPointBounds != null && contains(fPointBounds.southwest) && contains(fPointBounds.northeast)) {
            return true;
        }
        return false;
    }

    public boolean intersects(FPointBounds fPointBounds) {
        if (fPointBounds == null) {
            return false;
        }
        if (intersect(fPointBounds) || fPointBounds.intersect(this)) {
            return true;
        }
        return false;
    }

    private boolean intersect(FPointBounds fPointBounds) {
        FPoint fPoint;
        if (fPointBounds == null || (fPoint = fPointBounds.northeast) == null || fPointBounds.southwest == null || this.northeast == null || this.southwest == null) {
            return false;
        }
        double d = (double) (((fPointBounds.northeast.y + fPointBounds.southwest.y) - this.northeast.y) - this.southwest.y);
        double d2 = (double) (((this.northeast.y - this.southwest.y) + fPointBounds.northeast.y) - fPointBounds.southwest.y);
        if (Math.abs((double) (((fPoint.x + fPointBounds.southwest.x) - this.northeast.x) - this.southwest.x)) >= ((double) (((this.northeast.x - this.southwest.x) + fPointBounds.northeast.x) - this.southwest.x)) || Math.abs(d) >= d2) {
            return false;
        }
        return true;
    }

    private boolean containsy(double d) {
        return ((double) this.southwest.y) <= d && d <= ((double) this.northeast.y);
    }

    private boolean containsx(double d) {
        return this.southwest.x <= this.northeast.x ? ((double) this.southwest.x) <= d && d <= ((double) this.northeast.x) : ((double) this.southwest.x) <= d || d <= ((double) this.northeast.x);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FPointBounds)) {
            return false;
        }
        FPointBounds fPointBounds = (FPointBounds) obj;
        if (!this.southwest.equals(fPointBounds.southwest) || !this.northeast.equals(fPointBounds.northeast)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "southwest = (" + this.southwest.x + "," + this.southwest.y + ") northeast = (" + this.northeast.x + "," + this.northeast.y + ")";
    }

    public static final class Builder {
        private float mEast = Float.NEGATIVE_INFINITY;
        private float mNorth = Float.NEGATIVE_INFINITY;
        private float mSouth = Float.POSITIVE_INFINITY;
        private float mWest = Float.POSITIVE_INFINITY;

        public final Builder include(FPoint fPoint) {
            this.mSouth = Math.min(this.mSouth, fPoint.y);
            this.mNorth = Math.max(this.mNorth, fPoint.y);
            this.mWest = Math.min(this.mWest, fPoint.x);
            this.mEast = Math.max(this.mEast, fPoint.x);
            return this;
        }

        private boolean containsx(double d) {
            float f = this.mWest;
            float f2 = this.mEast;
            return f <= f2 ? ((double) f) <= d && d <= ((double) f2) : ((double) f) <= d || d <= ((double) f2);
        }

        public final FPointBounds build() {
            return new FPointBounds(FPoint.obtain(this.mWest, this.mSouth), FPoint.obtain(this.mEast, this.mNorth));
        }
    }
}
