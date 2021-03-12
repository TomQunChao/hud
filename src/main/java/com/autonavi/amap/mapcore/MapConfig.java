package com.autonavi.amap.mapcore;

import android.opengl.Matrix;
import com.amap.api.maps.model.LatLngBounds;
import java.util.concurrent.atomic.AtomicInteger;

public class MapConfig implements Cloneable {
    public static final int DEFAULT_RATIO = 1;
    private static final int GEO_POINT_ZOOM = 20;
    public static final float MAX_ZOOM = 20.0f;
    public static final float MAX_ZOOM_INDOOR = 20.0f;
    public static final float MIN_ZOOM = 3.0f;
    public static final int MSG_ACTION_ONBASEPOICLICK = 20;
    public static final int MSG_ACTION_ONMAPCLICK = 19;
    public static final int MSG_AUTH_FAILURE = 2;
    public static final int MSG_CALLBACK_MAPLOADED = 16;
    public static final int MSG_CALLBACK_ONTOUCHEVENT = 14;
    public static final int MSG_CALLBACK_SCREENSHOT = 15;
    public static final int MSG_CAMERAUPDATE_CHANGE = 10;
    public static final int MSG_CAMERAUPDATE_FINISH = 11;
    public static final int MSG_COMPASSVIEW_CHANGESTATE = 13;
    public static final int MSG_INFOWINDOW_UPDATE = 18;
    public static final int MSG_TILEOVERLAY_REFRESH = 17;
    public static final int MSG_ZOOMVIEW_CHANGESTATE = 12;
    private static final int TILE_SIZE_POW = 8;
    private int anchorX = 0;
    private int anchorY = 0;
    private volatile double changeGridRatio = 1.0d;
    private volatile double changeRatio = 1.0d;
    private AtomicInteger changedCounter = new AtomicInteger(0);
    private int customBackgroundColor = -1;
    private String customTextureResourcePath;
    private Rectangle geoRectangle = new Rectangle();
    private int gridX = 0;
    private int gridY = 0;
    private boolean isBearingChanged = false;
    private boolean isBuildingEnable = true;
    private boolean isCenterChanged = false;
    private boolean isCustomStyleEnabled = false;
    private boolean isHideLogoEnable = true;
    private boolean isIndoorEnable = false;
    private boolean isMapTextEnable = true;
    private boolean isNeedUpdateMapRectNextFrame = false;
    private boolean isNeedUpdateZoomControllerState = false;
    private boolean isProFunctionAuthEnable = true;
    private boolean isSetLimitZoomLevel;
    private boolean isTiltChanged = false;
    private boolean isTrafficEnabled = false;
    private boolean isUseProFunction = false;
    private boolean isWorldMapEnable = false;
    private boolean isZoomChanged = false;
    MapConfig lastMapconfig = null;
    private IPoint[] limitIPoints;
    private LatLngBounds limitLatLngBounds;
    private String mCustomStyleID;
    private String mCustomStylePath;
    private String mMapLanguage = "zh_cn";
    private int mMapStyleMode = 0;
    private int mMapStyleState = 0;
    private int mMapStyleTime = 0;
    private IPoint mapGeoCenter = new IPoint(this.sX, this.sY);
    private int mapHeight;
    private float mapPerPixelUnitLength;
    private FPoint[] mapRect = null;
    private int mapWidth;
    private float mapZoomScale = 1.0f;
    public float maxZoomLevel = 20.0f;
    public float minZoomLevel = 3.0f;
    float[] mvpMatrix = new float[16];
    float[] projectionMatrix = new float[16];
    private float sC = 0.0f;
    private float sR = 0.0f;
    private int sX = 221010267;
    private int sY = 101697799;
    private float sZ = 10.0f;
    private float skyHeight;
    int[] tilsIDs = new int[100];
    float[] viewMatrix = new float[16];

    public int getAnchorY() {
        return this.anchorY;
    }

    public void setAnchorY(int i) {
        this.anchorY = i;
    }

    public int getAnchorX() {
        return this.anchorX;
    }

    public void setAnchorX(int i) {
        this.anchorX = i;
    }

    public MapConfig(boolean z) {
        if (z) {
            this.lastMapconfig = new MapConfig(false);
            this.lastMapconfig.setGridXY(0, 0);
            this.lastMapconfig.setSX(0);
            this.lastMapconfig.setSY(0);
            this.lastMapconfig.setSZ(0.0f);
            this.lastMapconfig.setSC(0.0f);
            this.lastMapconfig.setSR(0.0f);
        }
    }

    public int getChangedCounter() {
        return this.changedCounter.get();
    }

    public void resetChangedCounter() {
        this.changedCounter.set(0);
    }

    public boolean isMapStateChange() {
        boolean z;
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            int sx = mapConfig.getSX();
            int sy = this.lastMapconfig.getSY();
            float sz = this.lastMapconfig.getSZ();
            float sc = this.lastMapconfig.getSC();
            float sr = this.lastMapconfig.getSR();
            this.isCenterChanged = sx != this.sX;
            this.isCenterChanged = sy != this.sY ? true : this.isCenterChanged;
            this.isZoomChanged = sz != this.sZ;
            if (this.isZoomChanged) {
                float f = this.minZoomLevel;
                if (sz > f) {
                    float f2 = this.sZ;
                    if (f2 > f) {
                        float f3 = this.maxZoomLevel;
                        if (sz < f3 && f2 < f3) {
                            this.isNeedUpdateZoomControllerState = false;
                        }
                    }
                }
                this.isNeedUpdateZoomControllerState = true;
            }
            this.isTiltChanged = sc != this.sC;
            this.isBearingChanged = sr != this.sR;
            z = this.isCenterChanged || this.isZoomChanged || this.isTiltChanged || this.isBearingChanged || this.isNeedUpdateMapRectNextFrame;
            if (z) {
                this.isNeedUpdateMapRectNextFrame = false;
                this.changedCounter.incrementAndGet();
                int i = (20 - ((int) this.sZ)) + 8;
                setGridXY(this.sX >> i, this.sY >> i);
                changeRatio();
            }
        } else {
            z = false;
        }
        if (this.sC < 45.0f || this.skyHeight != 0.0f) {
            return z;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void setGridXY(int i, int i2) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setGridXY(this.gridX, this.gridY);
        }
        this.gridX = i;
        this.gridY = i2;
    }

    /* access modifiers changed from: protected */
    public int getGridX() {
        return this.gridX;
    }

    /* access modifiers changed from: protected */
    public int getGridY() {
        return this.gridY;
    }

    public double getChangeRatio() {
        return this.changeRatio;
    }

    public double getChangeGridRatio() {
        return this.changeGridRatio;
    }

    private void changeRatio() {
        int sx = this.lastMapconfig.getSX();
        int sy = this.lastMapconfig.getSY();
        float sz = this.lastMapconfig.getSZ();
        float sc = this.lastMapconfig.getSC();
        float sr = this.lastMapconfig.getSR();
        this.changeRatio = (double) (Math.abs(this.sX - sx) + Math.abs(this.sY - sy));
        double d = 1.0d;
        this.changeRatio = this.changeRatio == 0.0d ? 1.0d : this.changeRatio * 2.0d;
        double d2 = this.changeRatio;
        float f = this.sZ;
        this.changeRatio = d2 * (sz == f ? 1.0d : (double) Math.abs(sz - f));
        float f2 = this.sC;
        float f3 = 1.0f;
        float abs = sc == f2 ? 1.0f : Math.abs(sc - f2);
        float f4 = this.sR;
        if (sr != f4) {
            f3 = Math.abs(sr - f4);
        }
        double d3 = (double) abs;
        this.changeRatio *= d3;
        double d4 = (double) f3;
        this.changeRatio *= d4;
        this.changeGridRatio = (double) (Math.abs(this.lastMapconfig.getGridX() - this.gridX) + (this.lastMapconfig.getGridY() - this.gridY));
        if (this.changeGridRatio != 0.0d) {
            d = this.changeGridRatio * 2.0d;
        }
        this.changeGridRatio = d;
        this.changeGridRatio *= d3;
        this.changeGridRatio *= d4;
    }

    public String toString() {
        return " sX: " + this.sX + " sY: " + this.sY + " sZ: " + this.sZ + " sC: " + this.sC + " sR: " + this.sR + " skyHeight: " + this.skyHeight;
    }

    public boolean isZoomChanged() {
        return this.isZoomChanged;
    }

    public boolean isTiltChanged() {
        return this.isTiltChanged;
    }

    public boolean isBearingChanged() {
        return this.isBearingChanged;
    }

    public boolean isIndoorEnable() {
        return this.isIndoorEnable;
    }

    public void setIndoorEnable(boolean z) {
        this.isIndoorEnable = z;
    }

    public boolean isBuildingEnable() {
        return this.isBuildingEnable;
    }

    public void setBuildingEnable(boolean z) {
        this.isBuildingEnable = z;
    }

    public boolean isMapTextEnable() {
        return this.isMapTextEnable;
    }

    public void setMapTextEnable(boolean z) {
        this.isMapTextEnable = z;
    }

    public boolean isTrafficEnabled() {
        return this.isTrafficEnabled;
    }

    public void setTrafficEnabled(boolean z) {
        this.isTrafficEnabled = z;
    }

    public boolean isNeedUpdateZoomControllerState() {
        return this.isNeedUpdateZoomControllerState;
    }

    public int getSX() {
        return this.sX;
    }

    public void setSX(int i) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSX(this.sX);
        }
        this.sX = i;
        this.mapGeoCenter.x = this.sX;
    }

    public int getSY() {
        return this.sY;
    }

    public void setSY(int i) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSY(this.sY);
        }
        this.sY = i;
        this.mapGeoCenter.x = this.sY;
    }

    public IPoint getMapGeoCenter() {
        return this.mapGeoCenter;
    }

    public float getSZ() {
        return this.sZ;
    }

    public void setSZ(float f) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSZ(this.sZ);
        }
        this.sZ = f;
    }

    public float getSC() {
        return this.sC;
    }

    public void setSC(float f) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSC(this.sC);
        }
        this.sC = f;
    }

    public float getSR() {
        return this.sR;
    }

    public void setSR(float f) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSR(this.sR);
        }
        this.sR = f;
    }

    public FPoint[] getMapRect() {
        return this.mapRect;
    }

    public void setMapRect(FPoint[] fPointArr) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setMapRect(fPointArr);
        }
        this.mapRect = fPointArr;
    }

    public Rectangle getGeoRectangle() {
        return this.geoRectangle;
    }

    public void setMaxZoomLevel(float f) {
        if (f > 20.0f) {
            f = 20.0f;
        }
        if (f < 3.0f) {
            f = 3.0f;
        }
        if (f < getMinZoomLevel()) {
            f = getMinZoomLevel();
        }
        this.isSetLimitZoomLevel = true;
        this.maxZoomLevel = f;
    }

    public void setMinZoomLevel(float f) {
        if (f < 3.0f) {
            f = 3.0f;
        }
        if (f > 20.0f) {
            f = 20.0f;
        }
        if (f > getMaxZoomLevel()) {
            f = getMaxZoomLevel();
        }
        this.isSetLimitZoomLevel = true;
        this.minZoomLevel = f;
    }

    public float getMaxZoomLevel() {
        return this.maxZoomLevel;
    }

    public float getMinZoomLevel() {
        return this.minZoomLevel;
    }

    public IPoint[] getLimitIPoints() {
        return this.limitIPoints;
    }

    public void setLimitIPoints(IPoint[] iPointArr) {
        this.limitIPoints = iPointArr;
    }

    public boolean isSetLimitZoomLevel() {
        return this.isSetLimitZoomLevel;
    }

    public LatLngBounds getLimitLatLngBounds() {
        return this.limitLatLngBounds;
    }

    public void setLimitLatLngBounds(LatLngBounds latLngBounds) {
        this.limitLatLngBounds = latLngBounds;
        if (latLngBounds == null) {
            resetMinMaxZoomPreference();
        }
    }

    public void resetMinMaxZoomPreference() {
        this.minZoomLevel = 3.0f;
        this.maxZoomLevel = 20.0f;
        this.isSetLimitZoomLevel = false;
    }

    public void updateMapRectNextFrame(boolean z) {
        this.isNeedUpdateMapRectNextFrame = z;
    }

    public void setMapPerPixelUnitLength(float f) {
        this.mapPerPixelUnitLength = f;
    }

    public float getMapPerPixelUnitLength() {
        return this.mapPerPixelUnitLength;
    }

    public void setCustomStylePath(String str) {
        this.mCustomStylePath = str;
    }

    public String getCustomStylePath() {
        return this.mCustomStylePath;
    }

    public String getCustomStyleID() {
        return this.mCustomStyleID;
    }

    public void setCustomStyleID(String str) {
        this.mCustomStyleID = str;
    }

    public void setCustomStyleEnable(boolean z) {
        this.isCustomStyleEnabled = z;
    }

    public boolean isCustomStyleEnable() {
        return this.isCustomStyleEnabled;
    }

    public int getMapStyleTime() {
        return this.mMapStyleTime;
    }

    public void setMapStyleTime(int i) {
        this.mMapStyleTime = i;
    }

    public int getMapStyleMode() {
        return this.mMapStyleMode;
    }

    public void setMapStyleMode(int i) {
        this.mMapStyleMode = i;
    }

    public int getMapStyleState() {
        return this.mMapStyleState;
    }

    public void setMapStyleState(int i) {
        this.mMapStyleState = i;
    }

    public void setCustomTextureResourcePath(String str) {
        this.customTextureResourcePath = str;
    }

    public String getCustomTextureResourcePath() {
        return this.customTextureResourcePath;
    }

    public boolean isProFunctionAuthEnable() {
        return this.isProFunctionAuthEnable;
    }

    public void setProFunctionAuthEnable(boolean z) {
        this.isProFunctionAuthEnable = z;
    }

    public boolean isUseProFunction() {
        return this.isUseProFunction;
    }

    public void setUseProFunction(boolean z) {
        this.isUseProFunction = z;
    }

    public void setCustomBackgroundColor(int i) {
        this.customBackgroundColor = i;
    }

    public int getCustomBackgroundColor() {
        return this.customBackgroundColor;
    }

    public void setMapZoomScale(float f) {
        this.mapZoomScale = f;
    }

    public float getMapZoomScale() {
        return this.mapZoomScale;
    }

    public void setMapWidth(int i) {
        this.mapWidth = i;
    }

    public int getMapWidth() {
        return this.mapWidth;
    }

    public void setMapHeight(int i) {
        this.mapHeight = i;
    }

    public int getMapHeight() {
        return this.mapHeight;
    }

    public void setMapLanguage(String str) {
        this.mMapLanguage = str;
    }

    public String getMapLanguage() {
        return this.mMapLanguage;
    }

    public void setHideLogoEnble(boolean z) {
        this.isHideLogoEnable = z;
    }

    public boolean isHideLogoEnable() {
        return this.isHideLogoEnable;
    }

    public void setWorldMapEnable(boolean z) {
        this.isWorldMapEnable = z;
    }

    public boolean isWorldMapEnable() {
        return this.isWorldMapEnable;
    }

    public float getSkyHeight() {
        return this.skyHeight;
    }

    public void setSkyHeight(float f) {
        this.skyHeight = f;
    }

    public float[] getViewMatrix() {
        return this.viewMatrix;
    }

    public float[] getProjectionMatrix() {
        return this.projectionMatrix;
    }

    public float[] getMvpMatrix() {
        return this.mvpMatrix;
    }

    public void updateFinalMatrix() {
        Matrix.multiplyMM(this.mvpMatrix, 0, this.projectionMatrix, 0, this.viewMatrix, 0);
    }

    public int[] getCurTileIds() {
        return this.tilsIDs;
    }
}
