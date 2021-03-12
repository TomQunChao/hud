package com.autonavi.ae.gmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.text.TextUtils;
import com.amap.api.col.stln3.co;
import com.amap.api.col.stln3.ib;
import com.amap.api.col.stln3.ic;
import com.amap.api.col.stln3.rx;
import com.amap.api.maps.AMap;
import com.autonavi.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.ae.gmap.glanimation.AdglMapAnimFling;
import com.autonavi.ae.gmap.glanimation.AdglMapAnimGroup;
import com.autonavi.ae.gmap.glanimation.AdglMapAnimationMgr;
import com.autonavi.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.ae.gmap.style.StyleItem;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.FileUtil;
import com.autonavi.amap.mapcore.IAMapEngineCallback;
import com.autonavi.amap.mapcore.interfaces.IAMapListener;
import com.autonavi.amap.mapcore.maploader.AMapLoader;
import com.autonavi.amap.mapcore.maploader.NetworkState;
import com.autonavi.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.amap.mapcore.message.ScaleGestureMapMessage;
import com.autonavi.amap.mapcore.tools.GLConvertUtil;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.amap.mapcore.tools.TextTextureGenerator;
import java.io.File;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GLMapEngine implements IAMapEngineCallback, NetworkState.NetworkChangeListener {
    Hashtable<Long, AMapLoader> aMapLoaderHashtable;
    GLOverlayBundle<BaseMapOverlay<?, ?>> bundle;
    private Context context;
    private GLMapState copyGLMapState;
    private boolean isEngineRenderComplete;
    boolean isGestureStep;
    boolean isMoveCameraStep;
    private List<AbstractCameraUpdateMessage> mAnimateStateMessageList;
    private List<AbstractGestureMapMessage> mGestureEndMessageList;
    private List<AbstractGestureMapMessage> mGestureMessageList;
    private co mGlMapView;
    private Lock mLock;
    private IAMapListener mMapListener;
    private long mNativeMapengineInstance;
    private NetworkState mNetworkState;
    boolean mRequestDestroy;
    private AtomicInteger mRequestID;
    private List<AbstractCameraUpdateMessage> mStateMessageList;
    private TextTextureGenerator mTextTextureGenerator;
    private AdglMapAnimationMgr mapAnimationMgr;
    private int mapGestureCount;
    private Object mutLock;
    GLMapState state;
    private String userAgent;

    public static class InitParam {
        public String mConfigPath;
        public String mOfflineDataPath;
        public String mP3dCrossPath;
        public String mRootPath;
    }

    public static class MapViewInitParam {
        public int engineId;
        public int height;
        public float mapZoomScale;
        public int screenHeight;
        public float screenScale;
        public int screenWidth;
        public float textScale;
        public int width;
        public int x;
        public int y;
    }

    private static native boolean nativeAddOverlayTexture(int i, long j, int i2, int i3, float f, float f2, Bitmap bitmap, boolean z, boolean z2);

    private static native void nativeCreateAMapEngineWithFrame(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, float f2, float f3);

    private static native long nativeCreateAMapInstance(String str, String str2, String str3);

    protected static native long nativeCreateOverlay(int i, long j, int i2);

    private static native void nativeDestroy(long j);

    private static native void nativeDestroyCurrentState(long j, long j2);

    protected static native void nativeDestroyOverlay(int i, long j);

    private static native void nativeFinishDownLoad(int i, long j, long j2);

    private static native void nativeGetCurTileIDs(int i, long j, int[] iArr, int i2);

    private static native long nativeGetCurrentMapState(int i, long j);

    private static native long nativeGetGlOverlayMgrPtr(int i, long j);

    public static native String nativeGetMapEngineVersion(int i);

    private static native int[] nativeGetMapModeState(int i, long j, boolean z);

    private static native boolean nativeGetSrvViewStateBoolValue(int i, long j, int i2);

    private static native void nativeInitAMapEngineCallback(long j, Object obj);

    private static native void nativeInitParam(String str, String str2, String str3, String str4);

    private static native boolean nativeIsEngineCreated(long j, int i);

    private static native void nativePopRenderState(int i, long j);

    private static native void nativePostRenderAMap(long j, int i);

    private static native void nativePushRendererState(int i, long j);

    private static native void nativeReceiveNetData(int i, long j, byte[] bArr, long j2, int i2);

    private static native void nativeRenderAMap(long j, int i);

    private static native void nativeSelectMapPois(int i, long j, int i2, int i3, int i4, byte[] bArr);

    private static native void nativeSetAllContentEnable(int i, long j, boolean z);

    private static native void nativeSetBuildingEnable(int i, long j, boolean z);

    private static native void nativeSetBuildingTextureEnable(int i, long j, boolean z);

    private static native void nativeSetCustomStyleData(int i, long j, byte[] bArr, byte[] bArr2);

    private static native void nativeSetCustomStyleTexture(int i, long j, byte[] bArr);

    private static native void nativeSetHighlightSubwayEnable(int i, long j, boolean z);

    private static native void nativeSetIndoorBuildingToBeActive(int i, long j, String str, int i2, String str2);

    private static native void nativeSetIndoorEnable(int i, long j, boolean z);

    private static native void nativeSetLabelEnable(int i, long j, boolean z);

    private static native boolean nativeSetMapModeAndStyle(int i, long j, int[] iArr, boolean z, boolean z2, StyleItem[] styleItemArr);

    /* access modifiers changed from: private */
    public static native void nativeSetNetStatus(long j, int i);

    private static native void nativeSetOfflineDataEnable(int i, long j, boolean z);

    private static native void nativeSetParameter(int i, long j, int i2, int i3, int i4, int i5, int i6);

    private static native void nativeSetProjectionCenter(int i, long j, float f, float f2);

    private static native void nativeSetRenderListenerStatus(int i, long j);

    private static native void nativeSetServiceViewRect(int i, long j, int i2, int i3, int i4, int i5, int i6, int i7);

    private static native void nativeSetSetBackgroundTexture(int i, long j, byte[] bArr);

    private static native void nativeSetSimple3DEnable(int i, long j, boolean z);

    private static native void nativeSetSkyTexture(int i, long j, byte[] bArr);

    private static native void nativeSetSrvViewStateBoolValue(int i, long j, int i2, boolean z);

    private static native void nativeSetTrafficEnable(int i, long j, boolean z);

    private static native void nativeSetTrafficTexture(int i, long j, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    private static native void nativeSetTrafficTextureAllInOne(int i, long j, byte[] bArr);

    @Override // com.autonavi.amap.mapcore.IAMapEngineCallback
    public byte[] requireMapResource(int i, String str) {
        byte[] bArr;
        if (str == null) {
            return null;
        }
        String str2 = "map_assets/" + str;
        try {
            if (this.mGlMapView.getMapConfig().isCustomStyleEnable()) {
                if (str.startsWith("icons_5")) {
                    bArr = FileUtil.readFileContents(this.mGlMapView.getMapConfig().getCustomTextureResourcePath());
                } else if (str.startsWith("bktile")) {
                    bArr = FileUtil.readFileContentsFromAssets(this.context, str2);
                    int customBackgroundColor = this.mGlMapView.getMapConfig().getCustomBackgroundColor();
                    if (customBackgroundColor != 0) {
                        bArr = ic.a(bArr, customBackgroundColor);
                    }
                } else {
                    bArr = null;
                }
                if (bArr != null) {
                    return bArr;
                }
            }
            return FileUtil.readFileContentsFromAssets(this.context, str2);
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.IAMapEngineCallback
    public void reloadMapResource(int i, String str, int i2) {
    }

    @Override // com.autonavi.amap.mapcore.IAMapEngineCallback
    public int generateRequestId() {
        return this.mRequestID.incrementAndGet();
    }

    @Override // com.autonavi.amap.mapcore.IAMapEngineCallback
    public int requireMapDataAsyn(int i, byte[] bArr) {
        if (!this.mRequestDestroy && bArr != null) {
            AMapLoader.ADataRequestParam aDataRequestParam = new AMapLoader.ADataRequestParam();
            int i2 = GLConvertUtil.getInt(bArr, 0);
            aDataRequestParam.requestBaseUrl = GLConvertUtil.getString(bArr, 4, i2);
            int i3 = i2 + 4;
            int i4 = GLConvertUtil.getInt(bArr, i3);
            int i5 = i3 + 4;
            aDataRequestParam.requestUrl = GLConvertUtil.getString(bArr, i5, i4);
            int i6 = i5 + i4;
            aDataRequestParam.handler = GLConvertUtil.getLong(bArr, i6);
            int i7 = i6 + 8;
            aDataRequestParam.nRequestType = GLConvertUtil.getInt(bArr, i7);
            int i8 = i7 + 4;
            int i9 = GLConvertUtil.getInt(bArr, i8);
            int i10 = i8 + 4;
            aDataRequestParam.enCodeString = GLConvertUtil.getSubBytes(bArr, i10, i9);
            aDataRequestParam.nCompress = GLConvertUtil.getInt(bArr, i10 + i9);
            final AMapLoader aMapLoader = new AMapLoader(i, this, aDataRequestParam);
            this.aMapLoaderHashtable.put(Long.valueOf(aDataRequestParam.handler), aMapLoader);
            aMapLoader.isFinish = false;
            try {
                ib.a().a(new Runnable() {
                    /* class com.autonavi.ae.gmap.GLMapEngine.AnonymousClass1 */

                    public void run() {
                        try {
                            if (GLMapEngine.this.mRequestDestroy) {
                                AMapLoader aMapLoader = aMapLoader;
                                if (aMapLoader != null && !aMapLoader.isFinish) {
                                    synchronized (aMapLoader) {
                                        if (!aMapLoader.isFinish) {
                                            aMapLoader.notify();
                                            aMapLoader.isFinish = true;
                                        }
                                    }
                                }
                            } else if (aMapLoader == null) {
                                AMapLoader aMapLoader2 = aMapLoader;
                                if (aMapLoader2 != null && !aMapLoader2.isFinish) {
                                    synchronized (aMapLoader) {
                                        if (!aMapLoader.isFinish) {
                                            aMapLoader.notify();
                                            aMapLoader.isFinish = true;
                                        }
                                    }
                                }
                            } else {
                                aMapLoader.doRequest();
                                AMapLoader aMapLoader3 = aMapLoader;
                                if (aMapLoader3 != null && !aMapLoader3.isFinish) {
                                    synchronized (aMapLoader) {
                                        if (!aMapLoader.isFinish) {
                                            aMapLoader.notify();
                                            aMapLoader.isFinish = true;
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            try {
                                rx.c(th, "download Thread", "AMapLoader doRequest");
                                AMapLoader aMapLoader4 = aMapLoader;
                                if (aMapLoader4 != null && !aMapLoader4.isFinish) {
                                    synchronized (aMapLoader) {
                                        if (!aMapLoader.isFinish) {
                                            aMapLoader.notify();
                                            aMapLoader.isFinish = true;
                                        }
                                    }
                                }
                            } catch (Throwable th2) {
                                AMapLoader aMapLoader5 = aMapLoader;
                                if (aMapLoader5 != null && !aMapLoader5.isFinish) {
                                    synchronized (aMapLoader) {
                                        if (!aMapLoader.isFinish) {
                                            aMapLoader.notify();
                                            aMapLoader.isFinish = true;
                                        }
                                    }
                                }
                                throw th2;
                            }
                        }
                    }
                });
                synchronized (aMapLoader) {
                    while (!aMapLoader.isFinish) {
                        aMapLoader.wait();
                    }
                }
            } catch (Throwable th) {
                rx.c(th, "download Thread", "requireMapData");
            }
        }
        return 0;
    }

    @Override // com.autonavi.amap.mapcore.IAMapEngineCallback
    public void requireMapData(int i, byte[] bArr) {
    }

    @Override // com.autonavi.amap.mapcore.IAMapEngineCallback
    public void cancelRequireMapData(Object obj) {
        if (obj != null && (obj instanceof AMapLoader)) {
            ((AMapLoader) obj).doCancel();
        }
    }

    @Override // com.autonavi.amap.mapcore.IAMapEngineCallback
    public byte[] requireCharBitmap(int i, int i2, int i3) {
        return this.mTextTextureGenerator.getTextPixelBuffer(i2, i3);
    }

    @Override // com.autonavi.amap.mapcore.IAMapEngineCallback
    public byte[] requireCharsWidths(int i, int[] iArr, int i2, int i3) {
        return this.mTextTextureGenerator.getCharsWidths(iArr);
    }

    @Override // com.autonavi.amap.mapcore.IAMapEngineCallback
    public void requireMapRender(int i, int i2, int i3) {
    }

    @Override // com.autonavi.amap.mapcore.IAMapEngineCallback
    public void onMapRender(int i, int i2) {
        if (i2 != 13) {
            switch (i2) {
                case 5:
                    if (this.mMapListener != null) {
                        this.mMapListener.beforeDrawLabel(i, getMapState(i));
                        return;
                    }
                    return;
                case 6:
                    try {
                        if (this.mMapListener != null) {
                            this.mMapListener.afterDrawLabel(i, getMapState(i));
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        return;
                    }
                default:
                    return;
            }
        } else {
            this.isEngineRenderComplete = true;
        }
    }

    @Override // com.autonavi.amap.mapcore.IAMapEngineCallback
    public void OnIndoorBuildingActivity(int i, byte[] bArr) {
        co coVar = this.mGlMapView;
        if (coVar != null) {
            try {
                coVar.onIndoorBuildingActivity(i, bArr);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void receiveNetData(int i, long j, byte[] bArr, int i2) {
        if (!this.mRequestDestroy) {
            if (this.mNativeMapengineInstance != 0) {
                nativeReceiveNetData(i, this.mNativeMapengineInstance, bArr, j, i2);
            }
        }
    }

    public boolean getMapDataTaskIsCancel(int i, long j) {
        if (!this.aMapLoaderHashtable.containsKey(Long.valueOf(j))) {
            return true;
        }
        return false;
    }

    public synchronized void finishDownLoad(int i, long j) {
        if (this.mNativeMapengineInstance != 0) {
            nativeFinishDownLoad(i, this.mNativeMapengineInstance, j);
        }
        this.aMapLoaderHashtable.remove(Long.valueOf(j));
    }

    public void netError(int i, long j, int i2) {
        long j2 = this.mNativeMapengineInstance;
        if (j2 != 0) {
            nativeFinishDownLoad(i, j2, j);
        }
        this.aMapLoaderHashtable.remove(Long.valueOf(j));
    }

    public void setMapLoaderToTask(int i, long j, AMapLoader aMapLoader) {
    }

    public Context getContext() {
        return this.context;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setParamater(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mLock.lock();
        try {
            if (this.mNativeMapengineInstance != 0) {
                nativeSetParameter(i, this.mNativeMapengineInstance, i2, i3, i4, i5, i6);
            }
        } finally {
            this.mLock.unlock();
        }
    }

    public void onClearCache(int i) {
    }

    public boolean isInMapAction(int i) {
        return false;
    }

    public long getNativeInstance() {
        return this.mNativeMapengineInstance;
    }

    public boolean canStopMapRender(int i) {
        return this.isEngineRenderComplete;
    }

    public int getEngineIDWithType(int i) {
        return 1;
    }

    public boolean isEngineCreated(int i) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            return nativeIsEngineCreated(j, i);
        }
        return false;
    }

    public long getMapStateInstance(int i) {
        return 0;
    }

    public int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo eAMapPlatformGestureInfo) {
        long j = this.mNativeMapengineInstance;
        return 1;
    }

    public void setServiceViewRect(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        nativeSetServiceViewRect(i, this.mNativeMapengineInstance, i2, i3, i4, i5, i6, i7);
    }

    public void setSrvViewStateBoolValue(int i, int i2, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetSrvViewStateBoolValue(i, j, i2, z);
        }
    }

    public boolean getSrvViewStateBoolValue(int i, int i2) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            return nativeGetSrvViewStateBoolValue(i, j, i2);
        }
        return false;
    }

    public boolean getIsProcessBuildingMark(int i) {
        return false;
    }

    public void setIndoorBuildingToBeActive(int i, String str, int i2, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            long j = this.mNativeMapengineInstance;
            if (j != 0) {
                nativeSetIndoorBuildingToBeActive(i, j, str, i2, str2);
            }
        }
    }

    public void setMapListener(IAMapListener iAMapListener) {
        this.mMapListener = iAMapListener;
    }

    public void setInternaltexture(int i, byte[] bArr, int i2) {
    }

    /* JADX INFO: finally extract failed */
    public GLMapState getMapState(int i) {
        this.mLock.lock();
        try {
            if (this.mNativeMapengineInstance != 0 && this.state == null) {
                long nativeGetCurrentMapState = nativeGetCurrentMapState(i, this.mNativeMapengineInstance);
                if (nativeGetCurrentMapState != 0) {
                    this.state = new GLMapState(this.mNativeMapengineInstance, nativeGetCurrentMapState);
                }
            }
            this.mLock.unlock();
            return this.state;
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public GLMapState getNewMapState(int i) {
        this.mLock.lock();
        try {
            if (this.mNativeMapengineInstance != 0) {
                return new GLMapState(i, this.mNativeMapengineInstance);
            }
            this.mLock.unlock();
            return null;
        } finally {
            this.mLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public synchronized GLMapState getCloneMapState() {
        this.mLock.lock();
        try {
            if (this.mNativeMapengineInstance != 0) {
                if (this.copyGLMapState == null) {
                    this.copyGLMapState = new GLMapState(1, this.mNativeMapengineInstance);
                }
                this.copyGLMapState.setMapZoomer(this.mGlMapView.getMapConfig().getSZ());
                this.copyGLMapState.setCameraDegree(this.mGlMapView.getMapConfig().getSC());
                this.copyGLMapState.setMapAngle(this.mGlMapView.getMapConfig().getSR());
                this.copyGLMapState.setMapGeoCenter(this.mGlMapView.getMapConfig().getSX(), this.mGlMapView.getMapConfig().getSY());
            }
            this.mLock.unlock();
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
        return this.copyGLMapState;
    }

    public void setMapState(int i, GLMapState gLMapState) {
        setMapState(i, gLMapState, true);
    }

    public void setMapState(int i, GLMapState gLMapState, boolean z) {
        co coVar;
        if (this.mNativeMapengineInstance != 0) {
            if (!(!z || (coVar = this.mGlMapView) == null || coVar.getMapConfig() == null)) {
                this.mGlMapView.checkMapState(gLMapState);
            }
            this.mLock.lock();
            try {
                gLMapState.setNativeMapengineState(i, this.mNativeMapengineInstance);
            } finally {
                this.mLock.unlock();
            }
        }
    }

    private void initAnimation() {
        AbstractCameraUpdateMessage remove;
        if (this.mStateMessageList.size() <= 0 && this.mAnimateStateMessageList.size() > 0 && (remove = this.mAnimateStateMessageList.remove(0)) != null) {
            remove.generateMapAnimation(this);
        }
    }

    public synchronized void addGestureMessage(int i, AbstractGestureMapMessage abstractGestureMapMessage, boolean z, int i2, int i3) {
        if (abstractGestureMapMessage != null) {
            abstractGestureMapMessage.isGestureScaleByMapCenter = z;
            this.mGestureMessageList.add(abstractGestureMapMessage);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003c A[Catch:{ Exception -> 0x0045 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean processMessage() {
        /*
            r5 = this;
            r0 = 0
            r1 = 1
            com.autonavi.ae.gmap.GLMapState r2 = r5.getNewMapState(r1)     // Catch:{ Exception -> 0x0045 }
            boolean r3 = r5.processGestureMessage(r2)     // Catch:{ Exception -> 0x0045 }
            java.util.List<com.autonavi.amap.mapcore.message.AbstractGestureMapMessage> r4 = r5.mGestureMessageList     // Catch:{ Exception -> 0x0045 }
            int r4 = r4.size()     // Catch:{ Exception -> 0x0045 }
            if (r4 > 0) goto L_0x001f
            if (r3 != 0) goto L_0x001d
            boolean r3 = r5.processStateMapMessage(r2)     // Catch:{ Exception -> 0x0045 }
            if (r3 == 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r3 = 0
            goto L_0x001e
        L_0x001d:
            r3 = 1
        L_0x001e:
            goto L_0x002e
        L_0x001f:
            java.util.List<com.autonavi.amap.mapcore.AbstractCameraUpdateMessage> r4 = r5.mStateMessageList     // Catch:{ Exception -> 0x0045 }
            int r4 = r4.size()     // Catch:{ Exception -> 0x0045 }
            if (r4 <= 0) goto L_0x002d
            java.util.List<com.autonavi.amap.mapcore.AbstractCameraUpdateMessage> r4 = r5.mStateMessageList     // Catch:{ Exception -> 0x0045 }
            r4.clear()     // Catch:{ Exception -> 0x0045 }
            goto L_0x002e
        L_0x002d:
        L_0x002e:
            if (r3 != 0) goto L_0x0039
            boolean r3 = r5.processAnimations(r2)     // Catch:{ Exception -> 0x0045 }
            if (r3 == 0) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r3 = 0
            goto L_0x003a
        L_0x0039:
            r3 = 1
        L_0x003a:
            if (r3 == 0) goto L_0x0040
            r5.setMapState(r1, r2)     // Catch:{ Exception -> 0x0045 }
            goto L_0x0041
        L_0x0040:
        L_0x0041:
            r2.recycle()     // Catch:{ Exception -> 0x0045 }
            return r3
        L_0x0045:
            r1 = move-exception
            r1.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.ae.gmap.GLMapEngine.processMessage():boolean");
    }

    private boolean processGestureMessage(GLMapState gLMapState) {
        AbstractGestureMapMessage remove;
        if (this.mGestureMessageList.size() <= 0) {
            if (this.isGestureStep) {
                this.isGestureStep = false;
            }
            return false;
        }
        this.isGestureStep = true;
        if (gLMapState == null) {
            return false;
        }
        while (this.mGestureMessageList.size() > 0 && (remove = this.mGestureMessageList.remove(0)) != null) {
            if (remove.width == 0) {
                remove.width = this.mGlMapView.getMapWidth();
            }
            if (remove.height == 0) {
                remove.height = this.mGlMapView.getMapHeight();
            }
            int mapGestureState = remove.getMapGestureState();
            if (mapGestureState == 100) {
                gestureBegin();
            } else if (mapGestureState == 101) {
                remove.runCameraUpdate(gLMapState);
            } else if (mapGestureState == 102) {
                gestureEnd();
            }
            this.mGestureEndMessageList.add(remove);
        }
        if (this.mGestureEndMessageList.size() == 1) {
            recycleMessage();
        }
        return true;
    }

    private boolean processAnimations(GLMapState gLMapState) {
        try {
            if (this.mapAnimationMgr.getAnimationsCount() <= 0) {
                return false;
            }
            gLMapState.recalculate();
            this.mapAnimationMgr.doAnimations(gLMapState);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void interruptAnimation() {
        if (isInMapAnimation(1)) {
            try {
                doMapAnimationCancelCallback(this.mapAnimationMgr.getCancelCallback());
                clearAnimations(1, false);
            } catch (Throwable th) {
                rx.c(th, getClass().getName(), "CancelableCallback.onCancel");
                th.printStackTrace();
            }
        }
    }

    public void addGroupAnimation(int i, int i2, float f, int i3, int i4, int i5, int i6, AMap.CancelableCallback cancelableCallback) {
        AdglMapAnimGroup adglMapAnimGroup = new AdglMapAnimGroup(i2);
        adglMapAnimGroup.setToCameraDegree((float) i4, 0);
        adglMapAnimGroup.setToMapAngle((float) i3, 0);
        adglMapAnimGroup.setToMapLevel(f, 0);
        adglMapAnimGroup.setToMapCenterGeo(i5, i6, 0);
        if (this.mapAnimationMgr != null && adglMapAnimGroup.isValid()) {
            this.mapAnimationMgr.addAnimation(adglMapAnimGroup, cancelableCallback);
        }
    }

    private void doMapAnimationCancelCallback(final AMap.CancelableCallback cancelableCallback) {
        co coVar;
        if (cancelableCallback != null && (coVar = this.mGlMapView) != null) {
            coVar.getMainHandler().post(new Runnable() {
                /* class com.autonavi.ae.gmap.GLMapEngine.AnonymousClass2 */

                public void run() {
                    try {
                        cancelableCallback.onCancel();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doMapAnimationFinishCallback(final AMap.CancelableCallback cancelableCallback) {
        co coVar;
        IAMapListener iAMapListener = this.mMapListener;
        if (iAMapListener != null) {
            iAMapListener.afterAnimation();
        }
        if (cancelableCallback != null && (coVar = this.mGlMapView) != null) {
            coVar.getMainHandler().post(new Runnable() {
                /* class com.autonavi.ae.gmap.GLMapEngine.AnonymousClass3 */

                public void run() {
                    try {
                        cancelableCallback.onFinish();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    public boolean isInMapAnimation(int i) {
        if (getAnimateionsCount() > 0) {
            return true;
        }
        return false;
    }

    public int getAnimateionsCount() {
        if (this.mNativeMapengineInstance != 0) {
            return this.mapAnimationMgr.getAnimationsCount();
        }
        return 0;
    }

    public void clearAllMessages(int i) {
    }

    public void clearAnimations(int i, boolean z) {
        this.mapAnimationMgr.clearAnimations();
    }

    public void clearAnimations(int i, boolean z, int i2) {
        this.mapAnimationMgr.clearAnimations();
    }

    public void startMapSlidAnim(int i, Point point, float f, float f2) {
        if (point != null) {
            try {
                clearAnimations(i, true);
                GLMapState cloneMapState = getCloneMapState();
                cloneMapState.reset();
                cloneMapState.recalculate();
                float abs = Math.abs(f);
                float abs2 = Math.abs(f2);
                int i2 = (abs > abs2 ? 1 : (abs == abs2 ? 0 : -1));
                if ((i2 > 0 ? abs : abs2) > 12000.0f) {
                    float f3 = -12000.0f;
                    if (i2 > 0) {
                        if (f > 0.0f) {
                            f3 = 12000.0f;
                        }
                        f = f3;
                        f2 = (12000.0f / abs) * f2;
                    } else {
                        float f4 = (12000.0f / abs2) * f;
                        if (f2 > 0.0f) {
                            f = f4;
                            f2 = 12000.0f;
                        } else {
                            f = f4;
                            f2 = -12000.0f;
                        }
                    }
                }
                int mapWidth = this.mGlMapView.getMapWidth() >> 1;
                int mapHeight = this.mGlMapView.getMapHeight() >> 1;
                if (this.mGlMapView.n()) {
                    mapWidth = this.mGlMapView.getMapConfig().getAnchorX();
                    mapHeight = this.mGlMapView.getMapConfig().getAnchorY();
                }
                AdglMapAnimFling adglMapAnimFling = new AdglMapAnimFling(500, mapWidth, mapHeight);
                adglMapAnimFling.setPositionAndVelocity(f, f2);
                adglMapAnimFling.commitAnimation(cloneMapState);
                this.mapAnimationMgr.addAnimation(adglMapAnimFling, null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void startPivotZoomRotateAnim(int i, Point point, float f, int i2, int i3) {
        if (f == -9999.0f && i2 != -9999) {
        }
    }

    private void gestureBegin() {
        this.mapGestureCount++;
    }

    private void gestureEnd() {
        this.mapGestureCount--;
        if (this.mapGestureCount == 0) {
            recycleMessage();
        }
    }

    public int getStateMessageCount() {
        return this.mStateMessageList.size();
    }

    public void addMessage(AbstractCameraUpdateMessage abstractCameraUpdateMessage, boolean z) {
        if (z) {
            List<AbstractCameraUpdateMessage> list = this.mAnimateStateMessageList;
            if (list != null) {
                list.clear();
                this.mAnimateStateMessageList.add(abstractCameraUpdateMessage);
                return;
            }
            return;
        }
        List<AbstractCameraUpdateMessage> list2 = this.mStateMessageList;
        if (list2 != null) {
            list2.add(abstractCameraUpdateMessage);
        }
    }

    public synchronized AbstractCameraUpdateMessage getStateMessage() {
        if (this.mStateMessageList != null) {
            if (this.mStateMessageList.size() != 0) {
                AbstractCameraUpdateMessage abstractCameraUpdateMessage = this.mStateMessageList.get(0);
                this.mStateMessageList.remove(abstractCameraUpdateMessage);
                return abstractCameraUpdateMessage;
            }
        }
        return null;
    }

    private void recycleMessage() {
        AbstractGestureMapMessage remove;
        while (this.mGestureEndMessageList.size() > 0 && (remove = this.mGestureEndMessageList.remove(0)) != null) {
            if (remove instanceof MoveGestureMapMessage) {
                ((MoveGestureMapMessage) remove).recycle();
            } else if (remove instanceof HoverGestureMapMessage) {
                ((HoverGestureMapMessage) remove).recycle();
            } else if (remove instanceof RotateGestureMapMessage) {
                ((RotateGestureMapMessage) remove).recycle();
            } else if (remove instanceof ScaleGestureMapMessage) {
                ((ScaleGestureMapMessage) remove).recycle();
            }
        }
    }

    private boolean processStateMapMessage(GLMapState gLMapState) {
        AbstractCameraUpdateMessage remove;
        if (this.mStateMessageList.size() <= 0) {
            if (this.isMoveCameraStep) {
                this.isMoveCameraStep = false;
            }
            return false;
        }
        this.isMoveCameraStep = true;
        if (gLMapState == null) {
            return false;
        }
        while (this.mStateMessageList.size() > 0 && (remove = this.mStateMessageList.remove(0)) != null) {
            if (remove.width == 0) {
                remove.width = this.mGlMapView.getMapWidth();
            }
            if (remove.height == 0) {
                remove.height = this.mGlMapView.getMapHeight();
            }
            gLMapState.recalculate();
            remove.runCameraUpdate(gLMapState);
        }
        return true;
    }

    public void pushRendererState() {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativePushRendererState(1, j);
        }
    }

    public void popRendererState() {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativePopRenderState(1, j);
        }
    }

    public int[] getMapModeState(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j == 0) {
            return null;
        }
        nativeGetMapModeState(i, j, z);
        return null;
    }

    public boolean setNativeMapModeAndStyle(int i, int i2, int i3, int i4, boolean z, boolean z2, StyleItem[] styleItemArr) {
        long j = this.mNativeMapengineInstance;
        if (j == 0) {
            return false;
        }
        return nativeSetMapModeAndStyle(i, j, new int[]{i2, i3, i4, 0, 0}, z, z2, styleItemArr);
    }

    public boolean setMapModeAndStyle(int i, int i2, int i3, int i4, boolean z, boolean z2, StyleItem[] styleItemArr) {
        if (this.mNativeMapengineInstance == 0) {
            return false;
        }
        boolean nativeMapModeAndStyle = setNativeMapModeAndStyle(i, i2, i3, i4, z, z2, styleItemArr);
        if (styleItemArr != null && z2) {
            int customBackgroundColor = this.mGlMapView.getMapConfig().getCustomBackgroundColor();
            if (customBackgroundColor != 0) {
                Context context2 = this.context;
                setBackgroundTexture(i, ic.a(FileUtil.readFileContentsFromAssets(context2, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_BACKGROUND_NAME), customBackgroundColor));
            }
            String customTextureResourcePath = this.mGlMapView.getMapConfig().getCustomTextureResourcePath();
            if (this.mGlMapView.getMapConfig().isProFunctionAuthEnable() && !TextUtils.isEmpty(customTextureResourcePath)) {
                this.mGlMapView.getMapConfig().setUseProFunction(true);
                setCustomStyleTexture(i, FileUtil.readFileContents(customTextureResourcePath));
            }
        } else if (i2 == 0 && i3 == 0 && i4 == 0) {
            Context context3 = this.context;
            setBackgroundTexture(i, FileUtil.readFileContentsFromAssets(context3, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_BACKGROUND_NAME));
            Context context4 = this.context;
            setCustomStyleTexture(i, FileUtil.readFileContentsFromAssets(context4, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_ICON_5_NAME));
        }
        return nativeMapModeAndStyle;
    }

    public void putResourceData(int i, byte[] bArr) {
    }

    @Override // com.autonavi.amap.mapcore.maploader.NetworkState.NetworkChangeListener
    public void networkStateChanged(Context context2) {
        if (!this.mRequestDestroy && this.mNativeMapengineInstance != 0) {
            final boolean isNetworkConnected = NetworkState.isNetworkConnected(context2);
            this.mGlMapView.queueEvent(new Runnable() {
                /* class com.autonavi.ae.gmap.GLMapEngine.AnonymousClass4 */

                public void run() {
                    GLMapEngine.nativeSetNetStatus(GLMapEngine.this.mNativeMapengineInstance, isNetworkConnected ? 1 : 0);
                }
            });
        }
    }

    public byte[] getLabelBuffer(int i, int i2, int i3, int i4) {
        this.mLock.lock();
        try {
            byte[] bArr = new byte[3072];
            if (this.mNativeMapengineInstance != 0) {
                nativeSelectMapPois(i, this.mNativeMapengineInstance, i2, i3, i4, bArr);
            }
            return bArr;
        } finally {
            this.mLock.unlock();
        }
    }

    public long createOverlay(int i, int i2) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            return nativeCreateOverlay(i, j, i2);
        }
        return 0;
    }

    public long getGlOverlayMgrPtr(int i) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            return nativeGetGlOverlayMgrPtr(i, j);
        }
        return 0;
    }

    public void setOvelayBundle(int i, GLOverlayBundle<BaseMapOverlay<?, ?>> gLOverlayBundle) {
        this.bundle = gLOverlayBundle;
    }

    public void addOverlayTexture(int i, GLTextureProperty gLTextureProperty) {
        if (this.mNativeMapengineInstance != 0 && gLTextureProperty != null && gLTextureProperty.mBitmap != null && !gLTextureProperty.mBitmap.isRecycled()) {
            nativeAddOverlayTexture(i, this.mNativeMapengineInstance, gLTextureProperty.mId, gLTextureProperty.mAnchor, gLTextureProperty.mXRatio, gLTextureProperty.mYRatio, gLTextureProperty.mBitmap, gLTextureProperty.isGenMimps, gLTextureProperty.isRepeat);
        }
    }

    public GLOverlayBundle getOverlayBundle(int i) {
        return this.bundle;
    }

    public static void destroyOverlay(int i, long j) {
        synchronized (GLMapEngine.class) {
            nativeDestroyOverlay(i, j);
        }
    }

    public void setSimple3DEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetSimple3DEnable(i, j, z);
        }
    }

    public void setSkyTexture(int i, byte[] bArr) {
        if (bArr != null) {
            long j = this.mNativeMapengineInstance;
            if (j != 0) {
                nativeSetSkyTexture(i, j, bArr);
            }
        }
    }

    public void setBackgroundTexture(int i, byte[] bArr) {
        if (bArr != null) {
            long j = this.mNativeMapengineInstance;
            if (j != 0) {
                nativeSetSetBackgroundTexture(i, j, bArr);
            }
        }
    }

    public void setCustomStyleTexture(int i, byte[] bArr) {
        if (bArr != null) {
            long j = this.mNativeMapengineInstance;
            if (j != 0) {
                nativeSetCustomStyleTexture(i, j, bArr);
            }
        }
    }

    public void setCustomStyleData(int i, byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            long j = this.mNativeMapengineInstance;
            if (j != 0) {
                nativeSetCustomStyleData(i, j, bArr, bArr2);
            }
        }
    }

    public void setTrafficEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetTrafficEnable(i, j, z);
        }
    }

    public void setBuildingEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetBuildingEnable(i, j, z);
        }
    }

    public void setLabelEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetLabelEnable(i, j, z);
        }
    }

    public void setAllContentEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetAllContentEnable(i, j, z);
        }
    }

    public void setProjectionCenter(int i, int i2, int i3) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetProjectionCenter(i, j, (float) i2, (float) i3);
        }
    }

    public void setTrafficStyle(int i, int i2, int i3, int i4, int i5) {
        if (this.mNativeMapengineInstance != 0) {
            Context context2 = this.context;
            nativeSetTrafficTextureAllInOne(i, this.mNativeMapengineInstance, ic.a(FileUtil.readFileContentsFromAssets(context2, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_TRL_NAME), new int[]{i5, i4, i3, i2}));
        }
    }

    public void startCheckEngineRenderComplete() {
        this.isEngineRenderComplete = false;
    }

    public void getCurTileIDs(int i, int[] iArr) {
        if (iArr != null) {
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr[i2] = 0;
            }
            nativeGetCurTileIDs(i, this.mNativeMapengineInstance, iArr, iArr.length);
        }
    }

    public void setIndoorEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetIndoorEnable(i, j, z);
        }
    }

    public void setOfflineDataEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetOfflineDataEnable(i, j, z);
        }
    }

    public void setHighlightSubwayEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetHighlightSubwayEnable(i, j, z);
        }
    }

    public void setBuildingTextureEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetBuildingTextureEnable(i, j, z);
        }
    }

    public GLMapEngine(Context context2, co coVar) {
        this.mNativeMapengineInstance = 0;
        this.mGlMapView = null;
        this.mStateMessageList = new Vector();
        this.mGestureMessageList = new Vector();
        this.mGestureEndMessageList = new Vector();
        this.mAnimateStateMessageList = new Vector();
        this.isMoveCameraStep = false;
        this.isGestureStep = false;
        this.mapGestureCount = 0;
        this.mapAnimationMgr = null;
        this.copyGLMapState = null;
        this.mLock = new ReentrantLock();
        this.mutLock = new Object();
        this.mNetworkState = null;
        this.bundle = null;
        this.isEngineRenderComplete = false;
        this.aMapLoaderHashtable = new Hashtable<>();
        this.mRequestDestroy = false;
        this.mRequestID = new AtomicInteger(1);
        this.mRequestDestroy = false;
        if (context2 != null) {
            this.context = context2.getApplicationContext();
            this.mGlMapView = coVar;
            this.mTextTextureGenerator = new TextTextureGenerator();
            this.mapAnimationMgr = new AdglMapAnimationMgr();
            this.mapAnimationMgr.setMapAnimationListener(new AdglMapAnimationMgr.MapAnimationListener() {
                /* class com.autonavi.ae.gmap.GLMapEngine.AnonymousClass5 */

                @Override // com.autonavi.ae.gmap.glanimation.AdglMapAnimationMgr.MapAnimationListener
                public void onMapAnimationFinish(AMap.CancelableCallback cancelableCallback) {
                    GLMapEngine.this.doMapAnimationFinishCallback(cancelableCallback);
                }
            });
            this.userAgent = System.getProperty("http.agent") + " amap/" + GlMapUtil.getAppVersionName(context2);
        }
    }

    public void createAMapInstance(InitParam initParam) {
        if (initParam != null) {
            synchronized (GLMapEngine.class) {
                nativeInitParam(initParam.mRootPath, initParam.mConfigPath, initParam.mOfflineDataPath, initParam.mP3dCrossPath);
                this.mNativeMapengineInstance = nativeCreateAMapInstance("", "http://mpsapi.amap.com/", "http://m5.amap.com/");
                nativeInitAMapEngineCallback(this.mNativeMapengineInstance, this);
                initNetworkState();
            }
        }
    }

    private void initNetworkState() {
        this.mNetworkState = new NetworkState();
        this.mNetworkState.setNetworkListener(this);
        this.mNetworkState.registerNetChangeReceiver(this.context.getApplicationContext(), true);
        boolean isNetworkConnected = NetworkState.isNetworkConnected(this.context.getApplicationContext());
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetNetStatus(j, isNetworkConnected ? 1 : 0);
        }
    }

    public void createAMapEngineWithFrame(MapViewInitParam mapViewInitParam) {
        if (this.mNativeMapengineInstance != 0) {
            synchronized (GLMapEngine.class) {
                nativeCreateAMapEngineWithFrame(this.mNativeMapengineInstance, mapViewInitParam.engineId, mapViewInitParam.x, mapViewInitParam.y, mapViewInitParam.width, mapViewInitParam.height, mapViewInitParam.screenWidth, mapViewInitParam.screenHeight, mapViewInitParam.screenScale, mapViewInitParam.textScale, mapViewInitParam.mapZoomScale);
            }
        }
    }

    public void changeSurface(int i, int i2) {
    }

    public void renderAMap() {
        if (this.mNativeMapengineInstance != 0) {
            boolean processMessage = processMessage();
            synchronized (GLMapEngine.class) {
                nativeRenderAMap(this.mNativeMapengineInstance, 1);
                nativePostRenderAMap(this.mNativeMapengineInstance, 1);
            }
            initAnimation();
            if (processMessage) {
                startCheckEngineRenderComplete();
            }
            if (!this.isEngineRenderComplete) {
                nativeSetRenderListenerStatus(1, this.mNativeMapengineInstance);
            }
        }
    }

    public void releaseNetworkState() {
        NetworkState networkState = this.mNetworkState;
        if (networkState != null) {
            networkState.registerNetChangeReceiver(this.context.getApplicationContext(), false);
            this.mNetworkState.setNetworkListener(null);
            this.mNetworkState = null;
        }
    }

    public void cancelAllAMapDownload() {
        try {
            synchronized (this.aMapLoaderHashtable) {
                for (Map.Entry<Long, AMapLoader> entry : this.aMapLoaderHashtable.entrySet()) {
                    AMapLoader value = entry.getValue();
                    value.doCancel();
                    if (!value.isFinish) {
                        synchronized (value) {
                            if (!value.isFinish) {
                                value.notify();
                                value.isFinish = true;
                            }
                        }
                    }
                }
                this.aMapLoaderHashtable.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void destroyAMapEngine() {
        try {
            this.mRequestDestroy = true;
            cancelAllAMapDownload();
            synchronized (this.mutLock) {
                if (this.mNativeMapengineInstance != 0) {
                    synchronized (this) {
                        if (this.copyGLMapState != null) {
                            this.copyGLMapState.recycle();
                        }
                    }
                    nativeDestroyCurrentState(this.mNativeMapengineInstance, this.state.getNativeInstance());
                    nativeDestroy(this.mNativeMapengineInstance);
                }
                this.mNativeMapengineInstance = 0;
            }
            this.mGlMapView = null;
            this.mStateMessageList.clear();
            this.mAnimateStateMessageList.clear();
            this.mGestureEndMessageList.clear();
            this.mGestureMessageList.clear();
            this.mMapListener = null;
            ib.b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
