package com.amap.api.maps.model;

import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMarker;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import java.util.ArrayList;

public final class Marker extends BasePointOverlay {
    private IMarker a;

    public Marker(IMarker iMarker) {
        this.a = iMarker;
    }

    public final void setPeriod(int i) {
        try {
            this.a.setPeriod(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final int getPeriod() {
        try {
            return this.a.getPeriod();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        try {
            this.a.setIcons(arrayList);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final ArrayList<BitmapDescriptor> getIcons() {
        try {
            return this.a.getIcons();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void remove() {
        try {
            this.a.remove();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void destroy() {
        try {
            if (this.a != null) {
                this.a.destroy(true);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final String getId() {
        try {
            return this.a.getId();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void setPerspective(boolean z) {
        try {
            this.a.setPerspective(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean isPerspective() {
        try {
            return this.a.isPerspective();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setPosition(LatLng latLng) {
        try {
            this.a.setPosition(latLng);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final LatLng getPosition() {
        try {
            return this.a.getPosition();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setTitle(String str) {
        try {
            this.a.setTitle(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final String getTitle() {
        try {
            return this.a.getTitle();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setSnippet(String str) {
        try {
            this.a.setSnippet(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final String getSnippet() {
        try {
            return this.a.getSnippet();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            try {
                this.a.setIcon(bitmapDescriptor);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void setAnchor(float f, float f2) {
        try {
            this.a.setAnchor(f, f2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setDraggable(boolean z) {
        try {
            this.a.setDraggable(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean isDraggable() {
        return this.a.isDraggable();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void showInfoWindow() {
        try {
            this.a.showInfoWindow();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void hideInfoWindow() {
        try {
            this.a.hideInfoWindow();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean isInfoWindowShown() {
        return this.a.isInfoWindowShown();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setVisible(boolean z) {
        try {
            this.a.setVisible(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final boolean isVisible() {
        try {
            return this.a.isVisible();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean equals(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof Marker) {
                    return this.a.equalsRemote(((Marker) obj).a);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCodeRemote();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setObject(Object obj) {
        this.a.setObject(obj);
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final Object getObject() {
        return this.a.getObject();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setRotateAngle(float f) {
        try {
            this.a.setRotateAngle(f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final float getRotateAngle() {
        return this.a.getRotateAngle();
    }

    public final void setToTop() {
        try {
            this.a.set2Top();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setGeoPoint(IPoint iPoint) {
        this.a.setGeoPoint(iPoint);
    }

    public final IPoint getGeoPoint() {
        return this.a.getGeoPoint();
    }

    public final void setFlat(boolean z) {
        try {
            this.a.setFlat(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean isFlat() {
        return this.a.isFlat();
    }

    public final void setPositionByPixels(int i, int i2) {
        this.a.setPositionByPixels(i, i2);
    }

    public final void setZIndex(float f) {
        this.a.setZIndex(f);
    }

    public final float getZIndex() {
        return this.a.getZIndex();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setAnimation(Animation animation) {
        try {
            this.a.setAnimation(animation);
        } catch (Throwable th) {
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final boolean startAnimation() {
        return this.a.startAnimation();
    }

    public final void setAnimationListener(Animation.AnimationListener animationListener) {
        this.a.setAnimationListener(animationListener);
    }

    public final float getAlpha() {
        IMarkerAction iMarkerAction = this.a.getIMarkerAction();
        if (iMarkerAction != null) {
            return iMarkerAction.getAlpha();
        }
        return 1.0f;
    }

    public final void setAlpha(float f) {
        IMarkerAction iMarkerAction = this.a.getIMarkerAction();
        if (iMarkerAction != null) {
            iMarkerAction.setAlpha(f);
        }
    }

    public final int getDisplayLevel() {
        IMarkerAction iMarkerAction = this.a.getIMarkerAction();
        if (iMarkerAction != null) {
            return iMarkerAction.getDisplayLevel();
        }
        return 5;
    }

    public final MarkerOptions getOptions() {
        IMarkerAction iMarkerAction = this.a.getIMarkerAction();
        if (iMarkerAction != null) {
            return iMarkerAction.getOptions();
        }
        return null;
    }

    public final boolean isClickable() {
        IMarkerAction iMarkerAction = this.a.getIMarkerAction();
        if (iMarkerAction != null) {
            return iMarkerAction.isClickable();
        }
        return false;
    }

    public final boolean isInfoWindowAutoOverturn() {
        IMarkerAction iMarkerAction = this.a.getIMarkerAction();
        if (iMarkerAction != null) {
            return iMarkerAction.isInfoWindowAutoOverturn();
        }
        return false;
    }

    public final boolean isInfoWindowEnable() {
        IMarkerAction iMarkerAction = this.a.getIMarkerAction();
        if (iMarkerAction != null) {
            return iMarkerAction.isInfoWindowEnable();
        }
        return false;
    }

    public final void setInfoWindowEnable(boolean z) {
        IMarkerAction iMarkerAction = this.a.getIMarkerAction();
        if (iMarkerAction != null) {
            iMarkerAction.setInfoWindowEnable(z);
        }
    }

    public final void setMarkerOptions(MarkerOptions markerOptions) {
        IMarkerAction iMarkerAction = this.a.getIMarkerAction();
        if (iMarkerAction != null) {
            iMarkerAction.setMarkerOptions(markerOptions);
        }
    }

    public final void setAutoOverturnInfoWindow(boolean z) {
        IMarkerAction iMarkerAction = this.a.getIMarkerAction();
        if (iMarkerAction != null) {
            iMarkerAction.setAutoOverturnInfoWindow(z);
        }
    }

    public final void setClickable(boolean z) {
        IMarkerAction iMarkerAction = this.a.getIMarkerAction();
        if (iMarkerAction != null) {
            iMarkerAction.setClickable(z);
        }
    }

    public final void setDisplayLevel(int i) {
        IMarkerAction iMarkerAction = this.a.getIMarkerAction();
        if (iMarkerAction != null) {
            iMarkerAction.setDisplayLevel(i);
        }
    }

    public final void setFixingPointEnable(boolean z) {
        IMarkerAction iMarkerAction = this.a.getIMarkerAction();
        if (iMarkerAction != null) {
            iMarkerAction.setFixingPointEnable(z);
        }
    }

    public final boolean isRemoved() {
        IMarker iMarker = this.a;
        if (iMarker != null) {
            return iMarker.isRemoved();
        }
        return false;
    }

    public final void setPositionNotUpdate(LatLng latLng) {
        setPosition(latLng);
    }

    public final void setRotateAngleNotUpdate(float f) {
        IMarkerAction iMarkerAction = this.a.getIMarkerAction();
        if (iMarkerAction != null) {
            iMarkerAction.setRotateAngleNotUpdate(f);
        }
    }

    public final void setBelowMaskLayer(boolean z) {
        this.a.setBelowMaskLayer(z);
    }

    public final float getAnchorU() {
        return this.a.getAnchorU();
    }

    public final float getAnchorV() {
        return this.a.getAnchorV();
    }
}
