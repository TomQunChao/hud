package com.amap.api.maps.model;

import com.autonavi.amap.mapcore.interfaces.IGroundOverlay;

public final class GroundOverlay {
    private IGroundOverlay a;

    public GroundOverlay(IGroundOverlay iGroundOverlay) {
        this.a = iGroundOverlay;
    }

    public final void remove() {
        try {
            this.a.remove();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final String getId() {
        try {
            return this.a.getId();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void setPosition(LatLng latLng) {
        try {
            this.a.setPosition(latLng);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final LatLng getPosition() {
        try {
            return this.a.getPosition();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void setDimensions(float f) {
        try {
            this.a.setDimensions(f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setImage(BitmapDescriptor bitmapDescriptor) {
        try {
            this.a.setImage(bitmapDescriptor);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setDimensions(float f, float f2) {
        try {
            this.a.setDimensions(f, f2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final float getWidth() {
        try {
            return this.a.getWidth();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final float getHeight() {
        try {
            return this.a.getHeight();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final void setPositionFromBounds(LatLngBounds latLngBounds) {
        try {
            this.a.setPositionFromBounds(latLngBounds);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final LatLngBounds getBounds() {
        try {
            return this.a.getBounds();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void setBearing(float f) {
        try {
            this.a.setBearing(f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final float getBearing() {
        try {
            return this.a.getBearing();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final void setZIndex(float f) {
        try {
            this.a.setZIndex(f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final float getZIndex() {
        try {
            return this.a.getZIndex();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final void setVisible(boolean z) {
        try {
            this.a.setVisible(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean isVisible() {
        try {
            return this.a.isVisible();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void setTransparency(float f) {
        try {
            this.a.setTransparency(f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final float getTransparency() {
        try {
            return this.a.getTransparency();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GroundOverlay)) {
            return false;
        }
        try {
            return this.a.equalsRemote(((GroundOverlay) obj).a);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void destroy() {
        IGroundOverlay iGroundOverlay = this.a;
        if (iGroundOverlay != null) {
            iGroundOverlay.destroy();
        }
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
