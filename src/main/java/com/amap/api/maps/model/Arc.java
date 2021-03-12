package com.amap.api.maps.model;

import com.autonavi.amap.mapcore.interfaces.IArc;

public final class Arc {
    private final IArc a;

    public Arc(IArc iArc) {
        this.a = iArc;
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
        if (obj == null || !(obj instanceof Arc)) {
            return false;
        }
        try {
            return this.a.equalsRemote(((Arc) obj).a);
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
}
