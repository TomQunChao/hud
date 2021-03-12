package com.amap.api.maps.model;

import com.autonavi.amap.mapcore.interfaces.ICircle;
import java.util.List;

public final class Circle {
    private final ICircle a;

    public Circle(ICircle iCircle) {
        this.a = iCircle;
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

    public final void setCenter(LatLng latLng) {
        try {
            this.a.setCenter(latLng);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final LatLng getCenter() {
        try {
            return this.a.getCenter();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void setRadius(double d) {
        try {
            this.a.setRadius(d);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final double getRadius() {
        try {
            return this.a.getRadius();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0d;
        }
    }

    public final void setStrokeWidth(float f) {
        try {
            this.a.setStrokeWidth(f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final float getStrokeWidth() {
        try {
            return this.a.getStrokeWidth();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final void setStrokeColor(int i) {
        try {
            this.a.setStrokeColor(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final int getStrokeColor() {
        try {
            return this.a.getStrokeColor();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final void setFillColor(int i) {
        try {
            this.a.setFillColor(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final int getFillColor() {
        try {
            return this.a.getFillColor();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
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

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Circle)) {
            return false;
        }
        try {
            return this.a.equalsRemote(((Circle) obj).a);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final int hashCode() {
        try {
            return this.a.hashCodeRemote();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final boolean contains(LatLng latLng) {
        try {
            return this.a.contains(latLng);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void setHoleOptions(List<BaseHoleOptions> list) {
        try {
            this.a.setHoleOptions(list);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final List<BaseHoleOptions> getHoleOptions() {
        try {
            return this.a.getHoleOptions();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void setStrokeDottedLineType(int i) {
        try {
            this.a.setDottedLineType(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final int getStrokeDottedLineType() {
        try {
            return this.a.getDottedLineType();
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }
}
