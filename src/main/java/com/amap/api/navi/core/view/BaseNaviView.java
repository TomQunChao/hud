package com.amap.api.navi.core.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.amap.api.col.stln3.mg;
import com.amap.api.col.stln3.mj;
import com.amap.api.col.stln3.mk;
import com.amap.api.col.stln3.mm;
import com.amap.api.col.stln3.rx;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.CrossOverlay;
import com.amap.api.maps.model.CrossOverlayOptions;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.Polyline;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.AMapNaviViewListener;
import com.amap.api.navi.AMapNaviViewOptions;
import com.amap.api.navi.INavi;
import com.amap.api.navi.model.AMapModelCross;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviLink;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.InnerNaviInfo;
import com.amap.api.navi.view.DirectionView;
import com.amap.api.navi.view.DriveWayView;
import com.amap.api.navi.view.NextTurnTipView;
import com.amap.api.navi.view.OverviewButtonView;
import com.amap.api.navi.view.TrafficBarView;
import com.amap.api.navi.view.TrafficButtonView;
import com.amap.api.navi.view.TrafficProgressBar;
import com.amap.api.navi.view.ZoomButtonView;
import com.amap.api.navi.view.ZoomInIntersectionView;
import com.amap.api.navi.view.statusbar.StatusBarTimeBroadcastReceiver;
import com.autonavi.ae.gmap.gloverlay.GLCrossVector;
import com.autonavi.amap.mapcore.tools.GLMapStaticValue;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseNaviView extends FrameLayout implements View.OnClickListener, AMap.OnCameraChangeListener, AMap.OnMapLoadedListener, AMap.OnMapTouchListener, AMap.OnMarkerClickListener, AMap.OnPolylineClickListener, StatusBarTimeBroadcastReceiver.OnTimeChangeCallBack {
    public static final int CAR_UP_MODE = 0;
    public static final double DEFAULT_X = 0.5d;
    public static final double DEFAULT_Y = 0.6666666666666666d;
    public static final int NORTH_UP_MODE = 1;
    boolean A = true;
    StatusBarTimeBroadcastReceiver B;
    long C = 30000;
    long D = 0;
    List<AMapNaviViewListener> E = new ArrayList();
    int F = -1;
    AMap.OnMapLoadedListener G = null;
    AMap.OnCameraChangeListener H = null;
    AMap.OnMapTouchListener I = null;
    boolean J = true;
    private OverviewButtonView K;
    private boolean L = false;
    private double M = 0.5d;
    private double N = 0.6666666666666666d;
    private int O = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private TextureMapView P;
    private INavi Q;
    private a R;
    private long S = 5000;
    private boolean T = true;
    private boolean U = true;
    private boolean V = true;
    private boolean W = false;
    private boolean Z = false;
    protected AMapNaviViewOptions a = null;
    private boolean aa = false;
    private int ab = 0;
    private View.OnClickListener ac = new View.OnClickListener() {
        /* class com.amap.api.navi.core.view.BaseNaviView.AnonymousClass1 */

        public final void onClick(View view) {
            BaseNaviView.a(BaseNaviView.this);
        }
    };
    private Context ad;
    private View.OnClickListener ae = new View.OnClickListener() {
        /* class com.amap.api.navi.core.view.BaseNaviView.AnonymousClass2 */

        public final void onClick(View view) {
            BaseNaviView.b(BaseNaviView.this);
        }
    };
    private CrossOverlay af;
    private boolean ag = false;
    private boolean ah = false;
    private boolean ai = false;
    private AMapModelCross aj;
    private float ak = 0.0f;
    private boolean al = true;
    private AMap.OnMarkerClickListener am;
    private AMap.OnPolylineClickListener an;
    protected AMap b;
    protected Handler c;
    protected int d = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    long e = 0;
    ZoomInIntersectionView f;
    ZoomInIntersectionView g;
    NextTurnTipView h;
    NextTurnTipView i;
    TrafficProgressBar j;
    TrafficProgressBar k;
    TrafficBarView l;
    DirectionView m;
    DirectionView n;
    public HashMap<Long, InnerNaviInfo> naviInfoHashMap = new HashMap<>();
    TrafficButtonView o;
    TrafficButtonView p;
    DriveWayView q;
    DriveWayView r;
    ZoomButtonView s;
    OverviewButtonView t;
    int u = GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH;
    int v = GLMapStaticValue.ANIMATION_MOVE_TIME;
    boolean w = false;
    int x = 0;
    int y = 0;
    boolean z = false;
    public float zoom = 18.0f;

    static /* synthetic */ void a(BaseNaviView baseNaviView) {
        try {
            if (baseNaviView.L) {
                baseNaviView.recoverLockMode();
            } else {
                baseNaviView.b(true);
                baseNaviView.setCarLock(false);
                baseNaviView.R.d();
            }
            if (baseNaviView.E != null) {
                for (AMapNaviViewListener aMapNaviViewListener : baseNaviView.E) {
                    try {
                        aMapNaviViewListener.onScanViewButtonClick();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        } catch (Throwable th2) {
            rx.c(th2, "BaseNaviView", "doOverViewClientEvent");
            th2.printStackTrace();
        }
    }

    static /* synthetic */ void b(BaseNaviView baseNaviView) {
        try {
            boolean isTrafficEnabled = baseNaviView.b.isTrafficEnabled();
            boolean z2 = true;
            if (baseNaviView.o != null) {
                baseNaviView.o.setIsTrafficOpen(!isTrafficEnabled);
            }
            if (baseNaviView.p != null) {
                baseNaviView.p.setIsTrafficOpen(!isTrafficEnabled);
            }
            if (isTrafficEnabled) {
                z2 = false;
            }
            baseNaviView.setTrafficLine(z2);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "switchTrafficStatus");
        }
    }

    public BaseNaviView(Context context) {
        super(context);
        try {
            a(context, (AMapNaviViewOptions) null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public BaseNaviView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        try {
            a(context, (AMapNaviViewOptions) null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public BaseNaviView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        try {
            a(context, (AMapNaviViewOptions) null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public BaseNaviView(Context context, AMapNaviViewOptions aMapNaviViewOptions) {
        super(context);
        try {
            a(context, aMapNaviViewOptions);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context, AMapNaviViewOptions aMapNaviViewOptions) {
        if (aMapNaviViewOptions == null) {
            try {
                aMapNaviViewOptions = new AMapNaviViewOptions();
            } catch (Throwable th) {
                mj.a(th);
                rx.c(th, "BaseNaviView", "init");
                return;
            }
        }
        if (context instanceof mk) {
            this.ad = ((mk) context).getBaseContext();
        } else {
            this.ad = context;
        }
        this.a = aMapNaviViewOptions;
        this.Q = AMapNavi.getInstance(this.ad);
        mm.a(this.ad.getApplicationContext());
        this.P = new TextureMapView(this.ad.getApplicationContext());
        this.b = this.P.getMap();
        addView(this.P);
        this.w = e();
        if (this.R == null) {
            this.R = new a(this.ad, this.P, this);
        }
        this.c = new a(this);
        this.B = StatusBarTimeBroadcastReceiver.getTimeBroadcastReceiver();
        this.B.register(this.ad);
    }

    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
            f();
            this.w = e();
            a(this.w);
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "BaseNaviView", "onConfigurationChanged");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001d A[Catch:{ Throwable -> 0x0023 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        /*
            r0 = this;
            super.onLayout(r1, r2, r3, r4, r5)     // Catch:{ Throwable -> 0x0023 }
            int r1 = r0.x     // Catch:{ Throwable -> 0x0023 }
            com.amap.api.maps.TextureMapView r2 = r0.P     // Catch:{ Throwable -> 0x0023 }
            int r2 = r2.getHeight()     // Catch:{ Throwable -> 0x0023 }
            if (r1 != r2) goto L_0x001a
            int r1 = r0.y     // Catch:{ Throwable -> 0x0023 }
            com.amap.api.maps.TextureMapView r2 = r0.P     // Catch:{ Throwable -> 0x0023 }
            int r2 = r2.getWidth()     // Catch:{ Throwable -> 0x0023 }
            if (r1 == r2) goto L_0x0018
            goto L_0x001a
        L_0x0018:
            r1 = 0
            goto L_0x001b
        L_0x001a:
            r1 = 1
        L_0x001b:
            if (r1 == 0) goto L_0x0021
            r0.setCustomizedLockCenter()     // Catch:{ Throwable -> 0x0023 }
            goto L_0x0022
        L_0x0021:
        L_0x0022:
            return
        L_0x0023:
            r1 = move-exception
            r1.printStackTrace()
            java.lang.String r2 = "BaseNaviView"
            java.lang.String r3 = "onLayout"
            com.amap.api.col.stln3.rx.c(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.navi.core.view.BaseNaviView.onLayout(boolean, int, int, int, int):void");
    }

    public double getAnchorX() {
        return this.M;
    }

    public double getAnchorY() {
        return this.N;
    }

    public int getLockZoom() {
        AMapNaviViewOptions aMapNaviViewOptions = this.a;
        if (aMapNaviViewOptions != null) {
            return aMapNaviViewOptions.getZoom();
        }
        return this.d;
    }

    public void setLockZoom(int i2) {
        if (i2 != this.d) {
            AMapNaviViewOptions aMapNaviViewOptions = this.a;
            if (aMapNaviViewOptions != null) {
                aMapNaviViewOptions.setZoom(i2);
            }
            changeCamera();
            setZoom((float) i2);
        }
    }

    public int getLockTilt() {
        return this.O;
    }

    public void setLockTilt(int i2) {
        try {
            if (i2 != this.O) {
                if (this.a != null) {
                    this.a.setTilt(i2);
                }
                changeCamera();
            }
        } catch (Throwable th) {
            rx.c(th, "BaseNaviView", "setLockTilt");
            th.printStackTrace();
        }
    }

    public int getNaviMode() {
        return this.ab;
    }

    public void setNaviMode(int i2) {
        if (i2 == 1 || i2 == 0) {
            try {
                if (i2 != this.ab) {
                    this.ab = i2;
                    setCarLock(true);
                    if (i2 == 1) {
                        openNorthUpMode();
                    } else if (i2 == 0) {
                        try {
                            if (this.R != null) {
                                this.R.f();
                            }
                        } catch (Throwable th) {
                            mj.a(th);
                            rx.c(th, "BaseNaviView", "openCarUpMode");
                        }
                    }
                    if (this.E != null) {
                        for (AMapNaviViewListener aMapNaviViewListener : this.E) {
                            try {
                                aMapNaviViewListener.onNaviMapMode(this.ab);
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                rx.c(th3, "BaseNaviView", "setNaviMode");
                th3.printStackTrace();
            }
        }
    }

    public boolean isAutoChangeZoom() {
        return this.W;
    }

    public AMapNaviViewOptions getViewOptions() {
        return this.a;
    }

    public void setViewOptions(AMapNaviViewOptions aMapNaviViewOptions) {
        if (aMapNaviViewOptions != null) {
            this.a = aMapNaviViewOptions;
            Handler handler = this.c;
            if (handler != null) {
                handler.obtainMessage(7).sendToTarget();
            }
        }
    }

    public AMap getMap() {
        return this.b;
    }

    private boolean e() {
        try {
            Activity c2 = mj.c(this.ad);
            if (c2 != null && (c2.getRequestedOrientation() == 0 || c2.getResources().getConfiguration().orientation == 2)) {
                return true;
            }
        } catch (Throwable th) {
            rx.c(th, "BaseNaviView", "isLandscape");
            th.printStackTrace();
        }
        try {
            if (this.ad == null || this.ad.getResources().getConfiguration().orientation != 2) {
                return false;
            }
            return true;
        } catch (Throwable th2) {
            rx.c(th2, "BaseNaviView", "isLandscape1");
            th2.printStackTrace();
            return false;
        }
    }

    private void f() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.ad.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.u = displayMetrics.widthPixels;
        this.v = displayMetrics.heightPixels;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0065 A[Catch:{ Throwable -> 0x0219 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x007e A[Catch:{ Throwable -> 0x0219 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008d A[Catch:{ Throwable -> 0x0219 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b7 A[Catch:{ Throwable -> 0x0219 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ee A[Catch:{ Throwable -> 0x0219 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f2 A[Catch:{ Throwable -> 0x0219 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x010b A[Catch:{ Throwable -> 0x0219 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0111 A[Catch:{ Throwable -> 0x0219 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0120 A[Catch:{ Throwable -> 0x0219 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01d0 A[Catch:{ Throwable -> 0x0219 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
        // Method dump skipped, instructions count: 549
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.navi.core.view.BaseNaviView.a():void");
    }

    public final void onCreate(Bundle bundle) {
        try {
            this.P.onCreate(bundle);
            MyTrafficStyle myTrafficStyle = new MyTrafficStyle();
            myTrafficStyle.setRatio(0.7f);
            myTrafficStyle.setSmoothColor(Color.parseColor("#CC80CD65"));
            myTrafficStyle.setCongestedColor(Color.parseColor("#F2CB7257"));
            myTrafficStyle.setSlowColor(Color.parseColor("#F2D5C247"));
            myTrafficStyle.setSeriousCongestedColor(Color.parseColor("#CCA52A2A"));
            this.b.setMyTrafficStyle(myTrafficStyle);
            this.b.getUiSettings().setZoomControlsEnabled(false);
            this.b.setTrafficEnabled(true);
            a();
            try {
                this.b.setOnMapLoadedListener(this);
                this.b.setOnCameraChangeListener(this);
                this.b.setOnMapTouchListener(this);
                this.b.setOnMarkerClickListener(this);
                this.b.setOnPolylineClickListener(this);
                this.Q.addAMapNaviListener(this.R);
            } catch (Throwable th) {
                mj.a(th);
                rx.c(th, "BaseNaviView", "initListener()");
            }
            f();
            a(this.w);
        } catch (Throwable th2) {
            mj.a(th2);
            rx.c(th2, "BaseNaviView", "onCreate");
        }
    }

    private void a(boolean z2) {
        try {
            if (this.l != null) {
                this.l.onConfigurationChanged(z2);
            }
            setCarLock(this.T);
            if (!(this.aj == null || this.af == null)) {
                this.af.remove();
                this.af = null;
                showModeCross(this.aj);
            }
            if (this.L) {
                displayOverview();
            }
            setCustomizedLockCenter();
        } catch (Throwable th) {
            rx.c(th, "BaseNaviView", "setConfigurationChanged");
        }
    }

    public void onResume() {
        try {
            this.P.onResume();
            f();
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "BaseNaviView", "onResume");
        }
    }

    public final void onPause() {
        try {
            this.P.onPause();
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "BaseNaviView", "onPause");
        }
    }

    public final void onDestroy() {
        try {
            this.Q.removeAMapNaviListener(this.R);
            this.R.g();
            if (this.af != null) {
                this.af.remove();
                this.af = null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.P.onDestroy();
            long currentTimeMillis2 = System.currentTimeMillis();
            String str = "mapView destroy()-->" + (currentTimeMillis2 - currentTimeMillis);
            mm.c();
            removeAllViews();
            this.c.removeCallbacksAndMessages(null);
            this.B.unRegister(this.ad);
            StatusBarTimeBroadcastReceiver.destroy();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "onDestroy");
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        try {
            this.P.onSaveInstanceState(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "BaseNaviView", "onSaveInstanceState");
        }
    }

    @Override // com.amap.api.maps.AMap.OnMapLoadedListener
    public void onMapLoaded() {
        try {
            this.x = this.P.getHeight();
            this.y = this.P.getWidth();
            f();
            if (!(this.x == 0 || this.y == 0)) {
                this.b.setPointToCenter((int) (((double) this.y) * this.M), (int) (((double) this.x) * this.N));
            }
            this.R.c();
            this.R.a(this.Q.getNaviPath(), true);
            if (this.G != null) {
                this.G.onMapLoaded();
            }
            changeCamera();
        } catch (Throwable th) {
            this.c.sendEmptyMessage(5);
            throw th;
        }
        this.c.sendEmptyMessage(5);
    }

    public void changeCamera() {
        try {
            if (this.a.getZoom() != this.d) {
                this.d = this.a.getZoom();
                this.b.moveCamera(CameraUpdateFactory.zoomTo((float) this.d));
            }
            if (this.a.getTilt() != this.O) {
                this.O = this.a.getTilt();
                this.b.moveCamera(CameraUpdateFactory.changeTilt((float) this.O));
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "changeCamera");
        }
    }

    @Override // com.amap.api.maps.AMap.OnCameraChangeListener
    public void onCameraChange(CameraPosition cameraPosition) {
        try {
            if (!(cameraPosition.zoom == this.ak || this.R == null)) {
                this.R.a(cameraPosition);
            }
            this.ak = cameraPosition.zoom;
            if (!this.ag) {
                if (this.n != null) {
                    this.n.setRotate(360.0f - cameraPosition.bearing);
                }
                if (this.m != null) {
                    if (this.m.isShown()) {
                        this.m.setRotate(360.0f - cameraPosition.bearing);
                    }
                }
                if (this.H != null) {
                    this.H.onCameraChange(cameraPosition);
                }
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "onCameraChange");
        }
    }

    @Override // com.amap.api.maps.AMap.OnCameraChangeListener
    public void onCameraChangeFinish(CameraPosition cameraPosition) {
        try {
            if (this.H != null) {
                this.H.onCameraChangeFinish(cameraPosition);
            }
            if (this.T) {
                if (SystemClock.currentThreadTimeMillis() - this.D > 1000) {
                    if (this.R != null) {
                        this.R.j(this.L);
                    }
                    this.D = SystemClock.currentThreadTimeMillis();
                }
            } else if (this.R != null) {
                this.R.j(this.L);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "onCameraChangeFinish");
        }
    }

    public void displayOverview() {
        boolean z2;
        int i2 = 1;
        try {
            b(true);
            if (this.a != null) {
                z2 = this.a.isAutoLockCar();
            } else {
                z2 = false;
            }
            if (this.c != null) {
                Handler handler = this.c;
                if (!z2) {
                    i2 = 0;
                }
                handler.obtainMessage(9, i2, 0).sendToTarget();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "displayOverview");
        }
    }

    public void openNorthUpMode() {
        try {
            if (this.R != null) {
                this.R.e();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "openNorthUpMode");
        }
    }

    public void openNorthMode() {
        try {
            this.ab = 1;
            setCarLock(true);
            this.R.e();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "openNorthMode");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(AMapNaviCross aMapNaviCross) {
        try {
            if (this.A && this.U) {
                this.ah = true;
                if (this.T) {
                    if (this.f != null) {
                        this.f.setVisibility(0);
                        this.f.setIntersectionBitMap(aMapNaviCross);
                    }
                    c(true);
                }
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "showCross");
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        try {
            if (this.f != null) {
                if (this.U && this.f.getVisibility() == 0) {
                    g();
                    this.f.setVisibility(8);
                    this.f.recycleResource();
                    c(false);
                }
                this.ah = false;
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "hideCross");
        }
    }

    public boolean showModeCross(AMapModelCross aMapModelCross) {
        int i2;
        if (this.V) {
            this.ai = true;
            InputStream inputStream = null;
            try {
                GLCrossVector.AVectorCrossAttr aVectorCrossAttr = new GLCrossVector.AVectorCrossAttr();
                if (e()) {
                    Rect landscapeCross = this.a.getLandscapeCross();
                    if (landscapeCross != null) {
                        aVectorCrossAttr.stAreaRect = landscapeCross;
                    } else {
                        aVectorCrossAttr.stAreaRect = new Rect(0, mj.a(this.ad, 48), (int) (((double) this.u) * 0.4d), this.v);
                    }
                } else {
                    Rect verticalCross = this.a.getVerticalCross();
                    if (verticalCross != null) {
                        aVectorCrossAttr.stAreaRect = verticalCross;
                    } else {
                        aVectorCrossAttr.stAreaRect = new Rect(0, mj.a(this.ad, 48), this.u, mj.a(this.ad, 290));
                    }
                }
                aVectorCrossAttr.stAreaColor = Color.argb(217, 95, 95, 95);
                aVectorCrossAttr.fArrowBorderWidth = mj.a(this.ad, 22);
                aVectorCrossAttr.stArrowBorderColor = Color.argb(0, 0, 50, 20);
                aVectorCrossAttr.fArrowLineWidth = mj.a(this.ad, 18);
                aVectorCrossAttr.stArrowLineColor = Color.argb(255, 255, 253, 65);
                aVectorCrossAttr.fArrowLineWidth = 18;
                aVectorCrossAttr.stArrowLineColor = Color.argb(255, 255, 253, 65);
                aVectorCrossAttr.dayMode = this.J;
                InputStream open = this.ad.getAssets().open("amap_navi_vector3d_arrow_in.png");
                this.af = getMap().addCrossOverlay(new CrossOverlayOptions().setAttribute(aVectorCrossAttr).setRes(BitmapFactory.decodeStream(open)));
                if (this.af != null) {
                    i2 = this.af.setData(aMapModelCross.getPicBuf1());
                    this.af.setVisible(this.T);
                } else {
                    i2 = 0;
                }
                if (i2 == 0) {
                    this.aj = aMapModelCross;
                    c(true);
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    return true;
                }
                this.af.setVisible(false);
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                return false;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        try {
            if (this.V && this.af != null) {
                this.aj = null;
                this.af.remove();
                this.af.setVisible(false);
                this.af = null;
                c(false);
            }
            this.ai = false;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "hideModeCross");
        }
    }

    public void recoverLockMode() {
        try {
            setCarLock(true);
            c(false);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "recoverLockMode");
        }
    }

    @Override // com.amap.api.maps.AMap.OnMapTouchListener
    public void onTouch(MotionEvent motionEvent) {
        try {
            b(false);
            this.c.sendEmptyMessage(4);
            this.c.removeMessages(0);
            this.c.removeMessages(9);
            if (this.a != null) {
                if (this.a.isAutoLockCar()) {
                    this.c.sendEmptyMessageDelayed(0, this.S);
                }
            }
            if (this.I != null) {
                this.I.onTouch(motionEvent);
            }
            this.D = 0;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "onTouch");
        }
    }

    public void setCarLock(boolean z2) {
        boolean z3;
        try {
            int i2 = 0;
            if (this.a != null) {
                z3 = this.a.isAutoLockCar();
            } else {
                z3 = false;
            }
            if (this.c != null) {
                Handler handler = this.c;
                if (z3) {
                    i2 = 1;
                }
                handler.obtainMessage(6, z2 ? 1 : 0, i2).sendToTarget();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "setCarLock");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z2, boolean z3) {
        try {
            if (this.E != null) {
                int i2 = z2 ? 1 : this.L ? 2 : 3;
                if (i2 != this.F) {
                    this.F = i2;
                    if (this.c != null) {
                        Message obtain = Message.obtain();
                        obtain.what = 11;
                        obtain.arg1 = this.F;
                        this.c.sendMessage(obtain);
                    }
                }
                if (this.T != z2 && !this.z) {
                    for (AMapNaviViewListener aMapNaviViewListener : this.E) {
                        try {
                            aMapNaviViewListener.onLockMap(z2);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            if (!this.z) {
                this.T = z2;
                this.c.removeMessages(0);
                if (z2) {
                    b(false);
                } else {
                    g();
                    if (z3) {
                        this.c.sendEmptyMessageDelayed(0, this.S);
                    }
                }
                this.R.c(z2);
                if (this.s != null) {
                    this.s.setVisibility(!z2 ? 0 : 8);
                }
                if (this.t != null && this.a.isRouteListButtonShow()) {
                    this.t.setVisibility(!z2 ? 0 : 8);
                }
                d(this.a.isTrafficBarEnabled());
                if (z2) {
                    if (this.ah && this.f != null) {
                        this.f.setVisibility(0);
                        this.ag = true;
                    }
                    if (this.ai && this.af != null) {
                        this.af.setVisible(true);
                        this.ag = true;
                        return;
                    }
                    return;
                }
                if (this.f != null && this.f.getVisibility() == 0) {
                    this.f.setVisibility(8);
                }
                if (this.af != null) {
                    this.af.setVisible(false);
                }
                this.ag = false;
            }
        } catch (Throwable th2) {
            mj.a(th2);
            rx.c(th2, "BaseNaviView", "setCarLock(boolean isLock, boolean autoRestore)");
        }
    }

    public void onClick(View view) {
        try {
            if (this.m.equals(view)) {
                try {
                    this.b.animateCamera(CameraUpdateFactory.changeBearing(0.0f));
                    this.c.sendEmptyMessage(4);
                    this.c.removeMessages(0);
                    this.c.sendEmptyMessageDelayed(0, this.S);
                } catch (Throwable th) {
                    mj.a(th);
                    rx.c(th, "BaseNaviView", "directionViewClickEvent");
                }
            }
        } catch (Throwable th2) {
            mj.a(th2);
            rx.c(th2, "BaseNaviView", "onClick");
        }
    }

    public boolean isTrafficLine() {
        AMap aMap = this.b;
        if (aMap != null) {
            return aMap.isTrafficEnabled();
        }
        return false;
    }

    public void setTrafficLine(boolean z2) {
        try {
            this.al = z2;
            if (!(this.a == null || this.a.isTrafficLine() == z2)) {
                this.a.setTrafficLine(z2);
            }
            this.b.setTrafficEnabled(z2);
            if (this.c != null) {
                this.c.obtainMessage(8, Boolean.valueOf(z2)).sendToTarget();
            }
            if (this.R != null) {
                this.R.d(z2);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "setTrafficLine");
        }
    }

    public void addMapNaviViewListener(AMapNaviViewListener aMapNaviViewListener) {
        if (!this.E.contains(aMapNaviViewListener)) {
            this.E.add(aMapNaviViewListener);
        }
    }

    public void arrivedEnd() {
        try {
            this.z = true;
            this.j.setVisibility(8);
            if (this.o != null) {
                this.o.setVisibility(8);
            }
            if (this.t != null) {
                this.t.setVisibility(8);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "arrivedEnd");
        }
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        try {
            if (this.o != null) {
                this.o.setVisibility(this.a.isTrafficLayerEnabled() ? 0 : 8);
            }
            if (this.s != null) {
                this.s.setVisibility(8);
            }
            if (this.t != null) {
                this.t.setVisibility(8);
            }
            a(this.w);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "initLayout");
        }
    }

    public boolean isShowRoadEnlarge() {
        return isCrossShowing();
    }

    public boolean isOrientationLandscape() {
        return this.w;
    }

    public void setCustomizedLockCenter() {
        try {
            this.x = this.P.getHeight();
            this.y = this.P.getWidth();
            double mapCenter_X = this.a.getMapCenter_X();
            double mapCenter_Y = this.a.getMapCenter_Y();
            if (mapCenter_X != 0.0d) {
                this.M = mapCenter_X;
            }
            if (mapCenter_Y != 0.0d) {
                this.N = mapCenter_Y;
            }
            if (!(this.x == 0 || this.y == 0)) {
                this.b.setPointToCenter((int) (((double) this.y) * this.M), (int) (((double) this.x) * this.N));
            }
            this.R.h();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "setCustomizedLockCenter");
        }
    }

    private void g() {
        if (this.w) {
            try {
                boolean z2 = this.A;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.P.getLayoutParams();
                layoutParams.setMargins(0, 0, 0, 0);
                this.P.setLayoutParams(layoutParams);
            } catch (Throwable th) {
                mj.a(th);
                rx.c(th, "BaseNaviView", "setMapLayoutParams");
            }
        }
    }

    public void setLayoutVisible(boolean z2) {
        this.A = z2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(boolean z2) {
        try {
            if (this.L != z2) {
                int i2 = z2 ? 2 : this.T ? 1 : 3;
                if (this.F != i2) {
                    this.F = i2;
                    if (this.c != null) {
                        Message obtain = Message.obtain();
                        obtain.what = 11;
                        obtain.arg1 = this.F;
                        this.c.sendMessage(obtain);
                    }
                }
            }
            updateRouteOverViewStatus(z2);
        } catch (Throwable th) {
            rx.c(th, "BaseNaviView", "setIsRouteOverviewNow");
        }
    }

    public void updateRouteOverViewStatus(boolean z2) {
        try {
            this.L = z2;
            if (this.t != null) {
                this.t.setChecked(z2);
            }
            if (this.K != null) {
                this.K.setChecked(z2);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "setMapLayoutParams");
        }
    }

    public TrafficBarView getLazyTrafficBarView() {
        return this.l;
    }

    public void setLazyTrafficBarView(TrafficBarView trafficBarView) {
        if (trafficBarView != null) {
            try {
                this.l = trafficBarView;
            } catch (Throwable th) {
                mj.a(th);
                rx.c(th, "BaseNaviView", "setLazyTrafficBarView");
            }
        }
    }

    public void setTrafficProgressBar(TrafficProgressBar trafficProgressBar, boolean z2) {
        if (z2) {
            try {
                this.j = trafficProgressBar;
            } catch (Throwable th) {
                mj.a(th);
                rx.c(th, "BaseNaviView", "setTrafficProgressBar");
            }
        } else {
            this.k = trafficProgressBar;
        }
    }

    public void zoomIn() {
        try {
            setCarLock(false);
            this.b.animateCamera(CameraUpdateFactory.zoomIn());
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "zoomIn");
        }
    }

    public void zoomOut() {
        try {
            setCarLock(false);
            this.b.animateCamera(CameraUpdateFactory.zoomOut());
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "zoomOut");
        }
    }

    public boolean isRouteOverviewNow() {
        return this.L;
    }

    @Override // com.amap.api.maps.AMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        try {
            if (this.R != null) {
                this.R.a(marker);
            }
            if (this.am == null) {
                return true;
            }
            this.am.onMarkerClick(marker);
            return true;
        } catch (Throwable th) {
            rx.c(th, "BaseNaviView", "onMarkerClick");
            return true;
        }
    }

    @Override // com.amap.api.maps.AMap.OnPolylineClickListener
    public void onPolylineClick(Polyline polyline) {
        try {
            if (this.R != null) {
                this.R.a(polyline);
            }
            if (this.an != null) {
                this.an.onPolylineClick(polyline);
            }
        } catch (Throwable th) {
            rx.c(th, "BaseNaviView", "onPolylineClick");
        }
    }

    public void setOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) {
        this.am = onMarkerClickListener;
    }

    public void setOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) {
        this.an = onPolylineClickListener;
    }

    @Override // com.amap.api.navi.view.statusbar.StatusBarTimeBroadcastReceiver.OnTimeChangeCallBack
    public void onUpdate() {
        h();
    }

    /* access modifiers changed from: package-private */
    public class a extends Handler {
        private WeakReference<BaseNaviView> b;

        a(BaseNaviView baseNaviView) {
            try {
                this.b = new WeakReference<>(baseNaviView);
            } catch (Throwable th) {
                mj.a(th);
                rx.c(th, "BaseNaviView", "MapViewListenerTriggerHandler");
            }
        }

        public final void handleMessage(Message message) {
            BaseNaviView baseNaviView = this.b.get();
            if (baseNaviView != null) {
                try {
                    int i = message.what;
                    boolean z = true;
                    if (i != 0) {
                        switch (i) {
                            case 4:
                                baseNaviView.setCarLock(false);
                                return;
                            case 5:
                                if (BaseNaviView.this.E != null) {
                                    for (AMapNaviViewListener aMapNaviViewListener : BaseNaviView.this.E) {
                                        try {
                                            aMapNaviViewListener.onNaviViewLoaded();
                                        } catch (Throwable th) {
                                            th.printStackTrace();
                                        }
                                    }
                                    return;
                                }
                                return;
                            case 6:
                                boolean z2 = message.arg1 == 1;
                                if (message.arg2 != 1) {
                                    z = false;
                                }
                                BaseNaviView.this.a(z2, z);
                                return;
                            case 7:
                                BaseNaviView.this.a();
                                return;
                            case 8:
                                if (!(BaseNaviView.this.o == null || message.obj == null)) {
                                    BaseNaviView.this.o.setIsTrafficOpen(((Boolean) message.obj).booleanValue());
                                    return;
                                }
                                return;
                            case 9:
                                if (message.arg1 != 1) {
                                    z = false;
                                }
                                BaseNaviView.this.a(false, z);
                                BaseNaviView.this.R.d();
                                BaseNaviView.this.b((BaseNaviView) true);
                                return;
                            case 10:
                                int i2 = message.arg1;
                                if (BaseNaviView.this.E != null) {
                                    for (AMapNaviViewListener aMapNaviViewListener2 : BaseNaviView.this.E) {
                                        try {
                                            aMapNaviViewListener2.onMapTypeChanged(i2);
                                        } catch (Throwable th2) {
                                            th2.printStackTrace();
                                        }
                                    }
                                    return;
                                }
                                return;
                            case 11:
                                int i3 = message.arg1;
                                if (BaseNaviView.this.E != null) {
                                    for (AMapNaviViewListener aMapNaviViewListener3 : BaseNaviView.this.E) {
                                        try {
                                            aMapNaviViewListener3.onNaviViewShowMode(i3);
                                        } catch (Throwable th3) {
                                            th3.printStackTrace();
                                        }
                                    }
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    } else {
                        baseNaviView.setCarLock(true);
                    }
                } catch (Throwable th4) {
                    mj.a(th4);
                    rx.c(th4, "BaseNaviView", "handleMessage(android");
                }
            }
        }
    }

    private void c(boolean z2) {
        try {
            if (!this.T) {
                z2 = false;
            }
            String str = "threadName=" + Thread.currentThread().getName() + ",checkCrossView=" + z2;
            if (z2) {
                this.ag = true;
                if (this.o != null) {
                    this.o.setVisibility(8);
                }
                if (this.m != null) {
                    this.m.setVisibility(8);
                }
                if (this.j != null) {
                    this.j.setVisibility(8);
                }
            } else {
                this.ag = false;
                if (this.a != null) {
                    if (this.a.isCompassEnabled()) {
                        if (this.m != null) {
                            this.m.setVisibility(0);
                        }
                    }
                    if (this.a.isTrafficLayerEnabled()) {
                        if (this.o != null) {
                            this.o.setVisibility(0);
                        }
                    }
                    d(this.a.isTrafficBarEnabled());
                }
            }
            setCustomizedLockCenter();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "checkCrossView");
        }
    }

    private void d(boolean z2) {
        try {
            if (this.j != null) {
                int i2 = 8;
                if (!z2 || this.Q.getEngineType() != 0) {
                    this.j.setVisibility(8);
                    return;
                }
                TrafficProgressBar trafficProgressBar = this.j;
                if (this.T && !this.ag) {
                    i2 = 0;
                }
                trafficProgressBar.setVisibility(i2);
            }
        } catch (Throwable th) {
            rx.c(th, "BaseNaviView", "setTrafficBarVisible");
        }
    }

    public boolean isCrossShowing() {
        return this.ag;
    }

    public void setOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) {
        this.G = onMapLoadedListener;
    }

    public void setOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) {
        this.H = onCameraChangeListener;
    }

    public void setOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) {
        this.I = onMapTouchListener;
    }

    public float getZoom() {
        return this.zoom;
    }

    public void setZoom(float f2) {
        if (f2 < 14.0f) {
            f2 = 14.0f;
        }
        if (f2 > 18.0f) {
            f2 = 18.0f;
        }
        try {
            this.zoom = f2;
            this.d = (int) this.zoom;
            this.a.setZoom(this.d);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "setZoom");
        }
    }

    public void setTrafficButtonView(TrafficButtonView trafficButtonView, boolean z2) {
        if (trafficButtonView != null) {
            try {
                trafficButtonView.setOnClickListener(this.ae);
                if (z2) {
                    this.o = trafficButtonView;
                } else {
                    this.p = trafficButtonView;
                }
            } catch (Throwable th) {
                mj.a(th);
                rx.c(th, "BaseNaviView", "setTrafficButtonView");
            }
        }
    }

    public void setZoomButtonView(ZoomButtonView zoomButtonView, boolean z2) {
        if (zoomButtonView != null) {
            try {
                zoomButtonView.getZoomInBtn().setOnClickListener(new View.OnClickListener() {
                    /* class com.amap.api.navi.core.view.BaseNaviView.AnonymousClass3 */

                    public final void onClick(View view) {
                        BaseNaviView.this.zoomIn();
                    }
                });
                zoomButtonView.getZoomOutBtn().setOnClickListener(new View.OnClickListener() {
                    /* class com.amap.api.navi.core.view.BaseNaviView.AnonymousClass4 */

                    public final void onClick(View view) {
                        BaseNaviView.this.zoomOut();
                    }
                });
                if (z2) {
                    this.s = zoomButtonView;
                }
            } catch (Throwable th) {
                mj.a(th);
                rx.c(th, "BaseNaviView", "setZoomButtonView");
            }
        }
    }

    public void setOverviewButtonView(OverviewButtonView overviewButtonView, boolean z2) {
        if (overviewButtonView != null) {
            try {
                overviewButtonView.setOnClickListener(this.ac);
                if (z2) {
                    this.t = overviewButtonView;
                } else {
                    this.K = overviewButtonView;
                }
            } catch (Throwable th) {
                mj.a(th);
                rx.c(th, "BaseNaviView", "setOverviewButtonView");
            }
        }
    }

    public void setDirectionView(DirectionView directionView, boolean z2) {
        if (directionView != null) {
            try {
                directionView.setOnClickListener(this);
                if (z2) {
                    this.m = directionView;
                } else {
                    this.n = directionView;
                }
            } catch (Throwable th) {
                mj.a(th);
                rx.c(th, "BaseNaviView", "setDirectionView");
            }
        }
    }

    public void setDriveWayView(DriveWayView driveWayView, boolean z2) {
        if (driveWayView != null) {
            if (z2) {
                try {
                    this.q = driveWayView;
                } catch (Throwable th) {
                    mj.a(th);
                    rx.c(th, "BaseNaviView", "setDriveWayView");
                }
            } else {
                this.r = driveWayView;
            }
        }
    }

    public void setZoomInIntersectionView(ZoomInIntersectionView zoomInIntersectionView, boolean z2) {
        if (zoomInIntersectionView != null) {
            if (z2) {
                try {
                    this.f = zoomInIntersectionView;
                } catch (Throwable th) {
                    mj.a(th);
                    rx.c(th, "BaseNaviView", "setZoomInIntersectionView");
                }
            } else {
                this.g = zoomInIntersectionView;
            }
        }
    }

    public void setNextTurnTipView(NextTurnTipView nextTurnTipView, boolean z2) {
        if (nextTurnTipView != null) {
            if (z2) {
                try {
                    this.h = nextTurnTipView;
                } catch (Throwable th) {
                    mj.a(th);
                    rx.c(th, "BaseNaviView", "setNextTurnTipView");
                }
            } else {
                this.i = nextTurnTipView;
            }
        }
    }

    public void setRouteOverlayVisible(boolean z2) {
        try {
            if (this.R != null) {
                this.R.k(z2);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "setRouteOverlayVisible");
        }
    }

    public void setCarOverlayVisible(boolean z2) {
        try {
            if (this.R != null) {
                this.R.l(z2);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "setCarOverlayVisible");
        }
    }

    public void setTrafficLightsVisible(boolean z2) {
        try {
            if (this.R != null) {
                this.R.m(z2);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "setTrafficLightsVisible");
        }
    }

    public void setArrowOnRoute(boolean z2) {
        try {
            if (this.R != null) {
                this.R.a();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "setArrowOnRoute");
        }
    }

    public InnerNaviInfo getLastNaviInfo() {
        try {
            if (this.R != null) {
                return this.R.b();
            }
            return null;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "getLastNaviInfo");
            return null;
        }
    }

    public void setStartPointBitmap(Bitmap bitmap) {
        try {
            if (this.R != null) {
                this.R.a(bitmap);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "BaseNaviView", "setStartPointBitmap");
        }
    }

    public StringBuffer getPathDetail(long j2, int i2) {
        int i3;
        try {
            if (this.Q == null || j2 == 0) {
                return null;
            }
            AMapNaviPath aMapNaviPath = null;
            for (Map.Entry<Integer, AMapNaviPath> entry : this.Q.getNaviPaths().entrySet()) {
                if (j2 == entry.getValue().getPathid()) {
                    aMapNaviPath = entry.getValue();
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("途经");
            int i4 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            HashMap hashMap = new HashMap();
            while (true) {
                i3 = 0;
                if (i2 >= aMapNaviPath.getSteps().size()) {
                    break;
                }
                List<AMapNaviLink> links = aMapNaviPath.getSteps().get(i2).getLinks();
                int size = links.size();
                while (i3 < size) {
                    AMapNaviLink aMapNaviLink = links.get(i3);
                    if (aMapNaviLink.getRoadClass() < i4) {
                        i4 = aMapNaviLink.getRoadClass();
                        if (aMapNaviLink.getRoadName() == null) {
                            if (aMapNaviLink.getRoadName().length() == 0) {
                                i3++;
                            }
                        }
                        hashMap.clear();
                    }
                    if (aMapNaviLink.getRoadClass() == i4) {
                        if (hashMap.containsKey(aMapNaviLink.getRoadName())) {
                            hashMap.put(aMapNaviLink.getRoadName(), Integer.valueOf(((Integer) hashMap.get(aMapNaviLink.getRoadName())).intValue() + aMapNaviLink.getLength()));
                        } else {
                            hashMap.put(aMapNaviLink.getRoadName(), Integer.valueOf(aMapNaviLink.getLength()));
                        }
                    }
                    i3++;
                }
                i2++;
            }
            String str = "";
            for (Map.Entry entry2 : hashMap.entrySet()) {
                if (((Integer) entry2.getValue()).intValue() > i3) {
                    i3 = ((Integer) entry2.getValue()).intValue();
                    str = (String) entry2.getKey();
                }
            }
            stringBuffer.append(str);
            return stringBuffer;
        } catch (Throwable th) {
            rx.c(th, "BaseNaviView", "getPathDetail");
            return null;
        }
    }

    private void h() {
        if (this.b != null) {
            try {
                if (TextUtils.isEmpty(this.a.getCustomMapStylePath())) {
                    this.b.setMapCustomEnable(false);
                    if (this.a.isNaviNight()) {
                        if (this.b.getMapType() != 3) {
                            this.b.setMapType(3);
                            this.J = false;
                            if (this.c != null) {
                                Message obtain = Message.obtain();
                                obtain.what = 10;
                                obtain.arg1 = 3;
                                this.c.sendMessage(obtain);
                            }
                        }
                    } else if (this.a.isAutoNaviViewNightMode()) {
                        if (mg.a()) {
                            if (this.b.getMapType() != 3) {
                                this.b.setMapType(3);
                                this.J = false;
                                if (this.c != null) {
                                    Message obtain2 = Message.obtain();
                                    obtain2.what = 10;
                                    obtain2.arg1 = 3;
                                    this.c.sendMessage(obtain2);
                                }
                            }
                        } else if (this.b.getMapType() != 4) {
                            this.b.setMapType(4);
                            this.J = true;
                            if (this.c != null) {
                                Message obtain3 = Message.obtain();
                                obtain3.what = 10;
                                obtain3.arg1 = 4;
                                this.c.sendMessage(obtain3);
                            }
                        }
                    } else if (this.b.getMapType() != 4) {
                        this.b.setMapType(4);
                        this.J = true;
                        if (this.c != null) {
                            Message obtain4 = Message.obtain();
                            obtain4.what = 10;
                            obtain4.arg1 = 4;
                            this.c.sendMessage(obtain4);
                        }
                    }
                }
            } catch (Throwable th) {
                mj.a(th);
                rx.c(th, "BaseNaviView", "checkDayAndNight");
            }
        }
    }
}
