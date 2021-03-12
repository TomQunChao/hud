package com.amap.api.col.stln3;

import com.amap.api.maps.model.LatLng;

/* compiled from: BaseOverlayImp */
public abstract class cg implements cs {
    public abstract String getId();

    public abstract LatLng getPosition();

    public abstract String getSnippet();

    public abstract String getTitle();

    public abstract boolean isVisible();

    public boolean isDraggable() {
        return false;
    }

    public boolean isInfoWindowAutoOverturn() {
        return false;
    }
}
