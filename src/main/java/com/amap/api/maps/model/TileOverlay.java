package com.amap.api.maps.model;

import com.autonavi.amap.mapcore.interfaces.ITileOverlay;

public final class TileOverlay {
    private ITileOverlay a;

    public TileOverlay(ITileOverlay iTileOverlay) {
        this.a = iTileOverlay;
    }

    public final void remove() {
        this.a.remove();
    }

    public final void clearTileCache() {
        this.a.clearTileCache();
    }

    public final String getId() {
        return this.a.getId();
    }

    public final void setZIndex(float f) {
        this.a.setZIndex(f);
    }

    public final float getZIndex() {
        return this.a.getZIndex();
    }

    public final void setVisible(boolean z) {
        this.a.setVisible(z);
    }

    public final boolean isVisible() {
        return this.a.isVisible();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof TileOverlay)) {
            return false;
        }
        try {
            return this.a.equalsRemote(((TileOverlay) obj).a);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final int hashCode() {
        return this.a.hashCodeRemote();
    }
}
