package com.amap.api.maps.model;

import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IglModel;

public class GL3DModel extends BasePointOverlay {
    private final IglModel a;

    public GL3DModel(IglModel iglModel) {
        this.a = iglModel;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setPosition(LatLng latLng) {
        try {
            this.a.setPosition(latLng);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAngle(float f) {
        try {
            this.a.setRotateAngle(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public float getAngle() {
        try {
            return this.a.getRotateAngle();
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public LatLng getPosition() {
        try {
            return this.a.getPosition();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getId() {
        try {
            return this.a.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setAnimation(Animation animation) {
        try {
            this.a.setAnimation(animation);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public boolean startAnimation() {
        try {
            return this.a.startAnimation();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setModelFixedLength(int i) {
        try {
            this.a.setModelFixedLength(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void remove() {
        try {
            this.a.remove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public boolean isVisible() {
        try {
            return this.a.isVisible();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setVisible(boolean z) {
        try {
            this.a.setVisible(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setObject(Object obj) {
        try {
            this.a.setObject(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public Object getObject() {
        IglModel iglModel = this.a;
        if (iglModel != null) {
            return iglModel.getObject();
        }
        return null;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setRotateAngle(float f) {
        try {
            this.a.setRotateAngle(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public float getRotateAngle() {
        try {
            return this.a.getRotateAngle();
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    public void setZoomLimit(float f) {
        IglModel iglModel = this.a;
        if (iglModel != null) {
            iglModel.setZoomLimit(f);
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void destroy() {
        IglModel iglModel = this.a;
        if (iglModel != null) {
            iglModel.destroy();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setGeoPoint(IPoint iPoint) {
        IglModel iglModel = this.a;
        if (iglModel != null) {
            iglModel.setGeoPoint(iPoint);
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setTitle(String str) {
        IglModel iglModel = this.a;
        if (iglModel != null) {
            iglModel.setTitle(str);
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getTitle() {
        try {
            return this.a.getTitle();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getSnippet() {
        try {
            return this.a.getSnippet();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setSnippet(String str) {
        IglModel iglModel = this.a;
        if (iglModel != null) {
            iglModel.setSnippet(str);
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void showInfoWindow() {
        try {
            this.a.showInfoWindow();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
