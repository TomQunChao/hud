package com.amap.api.col.stln3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.amap.api.col.stln3.gu;
import com.amap.api.col.stln3.im;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CustomRenderer;
import com.amap.api.maps.InfoWindowAnimationManager;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.Projection;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BuildingOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.CrossOverlay;
import com.amap.api.maps.model.CrossOverlayOptions;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.GL3DModelOptions;
import com.amap.api.maps.model.GroundOverlay;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.IndoorBuildingInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MultiPointOverlay;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Poi;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.RouteOverlay;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.animation.Animation;
import com.amap.api.maps.model.particle.ParticleOverlay;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.autonavi.ae.gmap.GLMapEngine;
import com.autonavi.ae.gmap.GLMapRender;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.ae.gmap.gloverlay.CrossVectorOverlay;
import com.autonavi.ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.ae.gmap.style.StyleItem;
import com.autonavi.amap.mapcore.AMapNativeRenderer;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.AeUtil;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.Rectangle;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.amap.mapcore.animation.GLAlphaAnimation;
import com.autonavi.amap.mapcore.interfaces.IAMapListener;
import com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay;
import com.autonavi.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.amap.mapcore.tools.GLConvertUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: AMapDelegateImp */
public final class bw implements co, gu.a, IAMapListener {
    private AMap.OnPOIClickListener A;
    private AMap.OnMapLongClickListener B;
    private AMap.OnInfoWindowClickListener C;
    private AMap.OnIndoorBuildingActiveListener D;
    private AMap.OnMyLocationChangeListener E;
    private cb F;
    private AMap.onMapPrintScreenListener G = null;
    private AMap.OnMapScreenShotListener H = null;
    private AMapGestureListener I;
    private ds J;
    private gm K = null;
    private UiSettings L;
    private cq M;
    private final dc N;
    private boolean O = false;
    private final cp P;
    private io Q;
    private final db R;
    private final cm S;
    private boolean T = false;
    private int U;
    private boolean V = false;
    private cj W;
    private AMapWidgetListener X;
    private boolean Y = false;
    private boolean Z = false;
    protected boolean a = false;
    private gs aA;
    private gu aB;
    private ca aC;
    private GLMapRender aD;
    private ck aE;
    private boolean aF = false;
    private float aG = 0.0f;
    private float aH = 1.0f;
    private float aI = 1.0f;
    private boolean aJ = true;
    private boolean aK = false;
    private boolean aL = false;
    private int aM = 0;
    private volatile boolean aN = false;
    private volatile boolean aO = false;
    private boolean aP = false;
    private boolean aQ = false;
    private Lock aR = new ReentrantLock();
    private int aS = 0;
    private int aT;
    private int aU;
    private b aV;
    private gq aW;
    private cn aX;
    private dx aY;
    private bv aZ;
    private boolean aa = false;
    private gh ab;
    private LocationSource ac;
    private boolean ad = false;
    private Marker ae = null;
    private cg af = null;
    private boolean ag = false;
    private boolean ah = false;
    private boolean ai = false;
    private boolean aj = false;
    private boolean ak = false;
    private boolean al = true;
    private Rect am = new Rect();
    private int an = 1;
    private MyTrafficStyle ao = null;
    private Thread ap;
    private Thread aq;
    private boolean ar = false;
    private boolean as = false;
    private boolean at = false;
    private int au = 0;
    private CustomRenderer av;
    private final cv aw;
    private int ax = -1;
    private int ay = -1;
    private List<cx> az = new ArrayList();
    protected final cu b;
    private a ba = new a() {
        /* class com.amap.api.col.stln3.bw.AnonymousClass11 */

        @Override // com.amap.api.col.stln3.bw.a
        public final void run() {
            super.run();
            try {
                bw.this.setTrafficEnabled(this.c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private a bb = new a() {
        /* class com.amap.api.col.stln3.bw.AnonymousClass21 */

        @Override // com.amap.api.col.stln3.bw.a
        public final void run() {
            super.run();
            try {
                bw.this.setCenterToPixel(bw.this.aT, bw.this.aU);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private a bc = new a() {
        /* class com.amap.api.col.stln3.bw.AnonymousClass28 */

        @Override // com.amap.api.col.stln3.bw.a
        public final void run() {
            super.run();
            bw.this.a(this.g, this.d, this.e, this.f);
        }
    };
    private a bd = new a() {
        /* class com.amap.api.col.stln3.bw.AnonymousClass29 */

        @Override // com.amap.api.col.stln3.bw.a
        public final void run() {
            super.run();
            bw.this.setMapCustomEnable(this.c);
        }
    };
    private a be = new a() {
        /* class com.amap.api.col.stln3.bw.AnonymousClass30 */

        @Override // com.amap.api.col.stln3.bw.a
        public final void run() {
            super.run();
            bw.this.a(this.g, this.c);
        }
    };
    private a bf = new a() {
        /* class com.amap.api.col.stln3.bw.AnonymousClass31 */

        @Override // com.amap.api.col.stln3.bw.a
        public final void run() {
            super.run();
            try {
                bw.this.setMapTextEnable(this.c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private a bg = new a() {
        /* class com.amap.api.col.stln3.bw.AnonymousClass32 */

        @Override // com.amap.api.col.stln3.bw.a
        public final void run() {
            super.run();
            bw.this.b(this.g, this.c);
        }
    };
    private a bh = new a() {
        /* class com.amap.api.col.stln3.bw.AnonymousClass33 */

        @Override // com.amap.api.col.stln3.bw.a
        public final void run() {
            super.run();
            try {
                bw.this.setIndoorEnabled(this.c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private Runnable bi = new Runnable() {
        /* class com.amap.api.col.stln3.bw.AnonymousClass2 */

        public final void run() {
            iq j;
            if (bw.this.Q != null && (j = bw.this.Q.j()) != null) {
                j.c();
            }
        }
    };
    private a bj = new a() {
        /* class com.amap.api.col.stln3.bw.AnonymousClass3 */

        @Override // com.amap.api.col.stln3.bw.a
        public final void run() {
            super.run();
            bw.this.c(this.g, this.c);
        }
    };
    private a bk = new a() {
        /* class com.amap.api.col.stln3.bw.AnonymousClass4 */

        @Override // com.amap.api.col.stln3.bw.a
        public final void run() {
            super.run();
            try {
                bw.this.setMyTrafficStyle(bw.this.ao);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private EAMapPlatformGestureInfo bl = new EAMapPlatformGestureInfo();
    private long bm = 0;
    private dq bn = null;
    private IPoint[] bo = null;
    protected MapConfig c = new MapConfig(true);
    protected dq d;
    protected Context e;
    protected GLMapEngine f;
    public int g;
    public int h;
    protected final Handler i = new Handler(Looper.getMainLooper()) {
        /* class com.amap.api.col.stln3.bw.AnonymousClass1 */

        public final void handleMessage(Message message) {
            il i;
            dr c;
            if (message != null && !bw.this.V) {
                try {
                    int i2 = message.what;
                    if (i2 != 2) {
                        boolean z = false;
                        switch (i2) {
                            case 10:
                                CameraPosition cameraPosition = (CameraPosition) message.obj;
                                if (cameraPosition != null && bw.this.x != null) {
                                    bw.this.x.onCameraChange(cameraPosition);
                                    return;
                                }
                                return;
                            case 11:
                                try {
                                    CameraPosition cameraPosition2 = bw.this.getCameraPosition();
                                    if (!(cameraPosition2 == null || bw.this.Q == null)) {
                                        bw.this.Q.a(cameraPosition2);
                                    }
                                    bw.this.b((bw) cameraPosition2);
                                    if (bw.this.aL) {
                                        bw.this.aL = false;
                                        if (bw.this.R != null) {
                                            bw.this.R.b(false);
                                        }
                                        bw.this.t();
                                    }
                                    if (bw.this.aj) {
                                        bw.this.m();
                                        bw.this.aj = false;
                                    }
                                    bw.this.a(cameraPosition2);
                                    return;
                                } catch (Throwable th) {
                                    rx.c(th, "AMapDelegateImp", "CameraUpdateFinish");
                                    return;
                                }
                            case 12:
                                if (bw.this.Q != null) {
                                    bw.this.Q.a(bw.this.j());
                                    return;
                                }
                                return;
                            case 13:
                                if (bw.this.Q != null && (i = bw.this.Q.i()) != null) {
                                    i.b();
                                    return;
                                }
                                return;
                            case 14:
                                try {
                                    if (bw.this.z != null) {
                                        bw.this.z.onTouch((MotionEvent) message.obj);
                                        return;
                                    }
                                    return;
                                } catch (Throwable th2) {
                                    rx.c(th2, "AMapDelegateImp", "onTouchHandler");
                                    th2.printStackTrace();
                                    return;
                                }
                            case 15:
                                Bitmap bitmap = (Bitmap) message.obj;
                                int i3 = message.arg1;
                                if (bitmap == null || bw.this.Q == null) {
                                    if (bw.this.G != null) {
                                        bw.this.G.onMapPrint(null);
                                    }
                                    if (bw.this.H != null) {
                                        bw.this.H.onMapScreenShot(null);
                                        bw.this.H.onMapScreenShot(null, i3);
                                    }
                                } else {
                                    Canvas canvas = new Canvas(bitmap);
                                    iq j = bw.this.Q.j();
                                    if (j != null) {
                                        j.onDraw(canvas);
                                    }
                                    bw.this.Q.a(canvas);
                                    if (bw.this.G != null) {
                                        bw.this.G.onMapPrint(new BitmapDrawable(bw.this.e.getResources(), bitmap));
                                    }
                                    if (bw.this.H != null) {
                                        bw.this.H.onMapScreenShot(bitmap);
                                        bw.this.H.onMapScreenShot(bitmap, i3);
                                    }
                                }
                                bw.this.G = null;
                                bw.this.H = null;
                                return;
                            case 16:
                                if (bw.this.w != null) {
                                    try {
                                        bw.this.w.onMapLoaded();
                                        return;
                                    } catch (Throwable th3) {
                                        rx.c(th3, "AMapDelegateImp", "onMapLoaded");
                                        th3.printStackTrace();
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            case 17:
                                if (bw.this.f.isInMapAnimation(1) && bw.this.R != null) {
                                    bw.this.R.b(false);
                                }
                                if (bw.this.R != null) {
                                    db dbVar = bw.this.R;
                                    if (message.arg1 != 0) {
                                        z = true;
                                    }
                                    dbVar.a(z);
                                    return;
                                }
                                return;
                            case 18:
                                if (bw.this.J != null && bw.this.aa && (c = bw.this.J.c()) != null) {
                                    c.a_();
                                    return;
                                }
                                return;
                            case 19:
                                if (bw.this.y != null) {
                                    DPoint obtain = DPoint.obtain();
                                    bw.this.b(message.arg1, message.arg2, obtain);
                                    try {
                                        bw.this.y.onMapClick(new LatLng(obtain.y, obtain.x));
                                        obtain.recycle();
                                        return;
                                    } catch (Throwable th4) {
                                        rx.c(th4, "AMapDelegateImp", "OnMapClickListener.onMapClick");
                                        th4.printStackTrace();
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            case 20:
                                try {
                                    bw.this.A.onPOIClick((Poi) message.obj);
                                    return;
                                } catch (Throwable th5) {
                                    rx.c(th5, "AMapDelegateImp", "OnPOIClickListener.onPOIClick");
                                    th5.printStackTrace();
                                    return;
                                }
                            default:
                                return;
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Key验证失败：[");
                        if (message.obj != null) {
                            sb.append(message.obj);
                        } else {
                            sb.append(qz.b);
                        }
                        sb.append("]");
                        sb.toString();
                    }
                } catch (Throwable th6) {
                    rx.c(th6, "AMapDelegateImp", "handleMessage");
                    th6.printStackTrace();
                }
            }
        }
    };
    Point j = new Point();
    Rect k = new Rect();
    protected String l = null;
    float[] m = new float[16];
    float[] n = new float[16];
    float[] o = new float[16];
    float[] p = new float[12];
    String q = "precision highp float;\nattribute vec3 aVertex;//顶点数组,三维坐标\nuniform mat4 aMVPMatrix;//mvp矩阵\nvoid main(){\n  gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n}";
    String r = "//有颜色 没有纹理\nprecision highp float;\nvoid main(){\n  gl_FragColor = vec4(1.0,0,0,1.0);\n}";
    int s = -1;
    private AMap.OnMarkerClickListener t;
    private AMap.OnPolylineClickListener u;
    private AMap.OnMarkerDragListener v;
    private AMap.OnMapLoadedListener w;
    private AMap.OnCameraChangeListener x;
    private AMap.OnMapClickListener y;
    private AMap.OnMapTouchListener z;

    static /* synthetic */ void a(bw bwVar, final MotionEvent motionEvent) {
        bwVar.i.post(new Runnable() {
            /* class com.amap.api.col.stln3.bw.AnonymousClass8 */

            public final void run() {
                Message obtain = Message.obtain();
                obtain.what = 19;
                obtain.arg1 = (int) motionEvent.getX();
                obtain.arg2 = (int) motionEvent.getY();
                bw.this.i.sendMessage(obtain);
            }
        });
    }

    @Override // com.amap.api.col.stln3.co
    public final void a(AMapWidgetListener aMapWidgetListener) {
        this.X = aMapWidgetListener;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(CameraPosition cameraPosition) {
        if (this.c.getMapLanguage().equals("en")) {
            boolean c2 = c(cameraPosition);
            if (c2 != this.al) {
                this.al = c2;
                b(1, this.al);
            }
        } else if (!this.al) {
            this.al = true;
            b(1, this.al);
        }
    }

    private boolean c(CameraPosition cameraPosition) {
        boolean z2 = false;
        if (cameraPosition.zoom < 7.0f) {
            return false;
        }
        if (cameraPosition.isAbroad) {
            return true;
        }
        MapConfig mapConfig = this.c;
        if (mapConfig == null) {
            return false;
        }
        try {
            IPoint[] clipRect = mapConfig.getGeoRectangle().getClipRect();
            if (clipRect != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= clipRect.length) {
                        z2 = true;
                        break;
                    }
                    DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) clipRect[i2].x, (long) clipRect[i2].y, 20);
                    if (pixelsToLatLong != null && !hv.a(pixelsToLatLong.y, pixelsToLatLong.x)) {
                        break;
                    }
                    i2++;
                }
            }
            return !z2;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setVisibilityEx(int i2) {
        cp cpVar = this.P;
        if (cpVar != null) {
            try {
                cpVar.setVisibility(i2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onActivityPause() {
        this.Y = true;
        m(this.U);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onActivityResume() {
        this.Y = false;
        int i2 = this.U;
        if (i2 == 0) {
            i2 = this.f.getEngineIDWithType(0);
        }
        n(i2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void queueEvent(Runnable runnable) {
        try {
            this.P.queueEvent(runnable);
        } catch (Throwable th) {
            rx.c(th, "AMapdelegateImp", "queueEvent");
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: AMapDelegateImp */
    public static abstract class a implements Runnable {
        boolean b;
        boolean c;
        int d;
        int e;
        int f;
        int g;

        private a() {
            this.b = false;
            this.c = false;
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public void run() {
            this.b = false;
        }
    }

    public bw(cp cpVar, Context context) {
        this.e = context;
        this.aC = new ca(this);
        rx.a(this.e);
        hn.a().a(this.e);
        ch.b = qy.c(context);
        hd.a(this.e);
        this.aE = new ck(this);
        this.f = new GLMapEngine(this.e, this);
        this.aD = new GLMapRender(this);
        this.P = cpVar;
        cpVar.setRenderer(this.aD);
        this.N = new dc(this);
        this.Q = new io(this.e, this);
        this.Q.g().a(new c(this, (byte) 0));
        this.aV = new b();
        this.S = new cm(this);
        this.R = new db(this.e, this);
        Context context2 = this.e;
        this.b = new cu(this);
        this.W = new cj(this.e, this);
        this.P.setRenderMode(0);
        this.aD.setRenderFps(15.0f);
        this.f.setMapListener(this);
        this.M = new cz(this);
        this.F = new cb(this);
        this.K = new gm(this, context);
        this.J = new ds(this.e);
        this.J.a(this.Q);
        this.J.b(this.K);
        this.aw = new cv();
        this.ap = new ce(this.e, this);
        this.ac = new dt(this.e);
        this.aY = new dx(this);
        this.aX = new cn();
        this.aA = new gs(this.e, this);
        this.aB = new gu(this.e);
        this.aB.a(this);
        this.aZ = new bv(this, this.e);
    }

    @Override // com.amap.api.col.stln3.co
    public final GLMapEngine a() {
        return this.f;
    }

    @Override // com.amap.api.col.stln3.co
    public final void a(int i2) {
        if (this.aS == 0 || i2 != 5) {
            this.aS = i2;
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final float b() {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return mapConfig.getSZ();
        }
        return 0.0f;
    }

    private float D() {
        if (this.c != null) {
            return getMapConfig().getSZ();
        }
        return 0.0f;
    }

    private boolean b(int i2, int i3) {
        AbstractCameraUpdateMessage abstractCameraUpdateMessage;
        if (!this.aN || ((float) ((int) D())) >= this.c.getMaxZoomLevel()) {
            return false;
        }
        try {
            if (!this.Z) {
                if (!this.N.isZoomInByScreenCenter()) {
                    this.j.x = i2;
                    this.j.y = i3;
                    abstractCameraUpdateMessage = dh.a(1.0f, this.j);
                    b(abstractCameraUpdateMessage);
                    resetRenderTime();
                    return true;
                }
            }
            abstractCameraUpdateMessage = dh.a(1.0f, (Point) null);
            b(abstractCameraUpdateMessage);
        } catch (Throwable th) {
            rx.c(th, "AMapDelegateImp", "onDoubleTap");
            th.printStackTrace();
        }
        resetRenderTime();
        return true;
    }

    @Override // com.amap.api.col.stln3.co
    public final void c() {
        if (this.aN && ((float) ((int) D())) > this.c.getMinZoomLevel()) {
            try {
                b(dh.b());
            } catch (Throwable th) {
                rx.c(th, "AMapDelegateImp", "onDoubleTap");
                th.printStackTrace();
            }
            resetRenderTime();
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final boolean d() {
        return false;
    }

    @Override // com.amap.api.col.stln3.co
    public final boolean b(int i2) {
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            return gLMapEngine.getSrvViewStateBoolValue(i2, 7);
        }
        return false;
    }

    @Override // com.amap.api.col.stln3.co
    public final void e() {
        db dbVar = this.R;
        if (dbVar != null) {
            dbVar.g();
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final GLMapState f() {
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            return gLMapEngine.getMapState(1);
        }
        return null;
    }

    @Override // com.amap.api.col.stln3.co
    public final int g() {
        cn cnVar = this.aX;
        if (cnVar != null) {
            return cnVar.a();
        }
        return 0;
    }

    @Override // com.amap.api.col.stln3.co
    public final int c(int i2) {
        cn cnVar = this.aX;
        if (cnVar != null) {
            return cnVar.a(i2);
        }
        return 0;
    }

    @Override // com.amap.api.col.stln3.co
    public final int h() {
        cn cnVar = this.aX;
        if (cnVar != null) {
            return cnVar.b();
        }
        return 0;
    }

    @Override // com.amap.api.col.stln3.co
    public final void a(Location location) throws RemoteException {
        if (location != null) {
            try {
                if (this.T) {
                    if (this.ac != null) {
                        if (this.ab == null) {
                            this.ab = new gh(this, this.e);
                        }
                        if (!(location.getLongitude() == 0.0d || location.getLatitude() == 0.0d)) {
                            this.ab.a(location);
                        }
                        if (this.E != null) {
                            this.E.onMyLocationChange(location);
                        }
                        resetRenderTime();
                        return;
                    }
                }
                if (this.ab != null) {
                    this.ab.b();
                }
                this.ab = null;
            } catch (Throwable th) {
                rx.c(th, "AMapDelegateImp", "showMyLocationOverlay");
                th.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final boolean a(String str) throws RemoteException {
        resetRenderTime();
        return this.S.c(str);
    }

    @Override // com.amap.api.col.stln3.co
    public final boolean b(String str) {
        try {
            this.W.a(str);
            return false;
        } catch (Throwable th) {
            rx.c(th, "AMapDelegateImp", "removeGLModel");
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final void i() {
        this.S.d();
    }

    @Override // com.amap.api.col.stln3.co
    public final void a(double d2, double d3, IPoint iPoint) {
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d2, d3, 20);
        iPoint.x = latLongToPixels.x;
        iPoint.y = latLongToPixels.y;
    }

    @Override // com.amap.api.col.stln3.co
    public final void a(int i2, int i3, FPoint fPoint) {
        fPoint.x = (float) (i2 - this.c.getSX());
        fPoint.y = (float) (i3 - this.c.getSY());
    }

    @Override // com.amap.api.col.stln3.co
    public final void a(int i2, int i3, DPoint dPoint) {
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) i2, (long) i3, 20);
        dPoint.x = pixelsToLatLong.x;
        dPoint.y = pixelsToLatLong.y;
        pixelsToLatLong.recycle();
    }

    @Override // com.amap.api.col.stln3.co
    public final float j() {
        int i2 = this.U;
        return D();
    }

    @Override // com.amap.api.col.stln3.co
    public final cr k() {
        return this.N;
    }

    @Override // com.amap.api.col.stln3.co
    public final void a(cg cgVar) throws RemoteException {
        ds dsVar;
        if (cgVar != null && (dsVar = this.J) != null) {
            try {
                dr c2 = dsVar.c();
                if (c2 != null) {
                    c2.a(cgVar);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final void l() {
        dr c2;
        ds dsVar = this.J;
        if (dsVar != null && (c2 = dsVar.c()) != null) {
            c2.b_();
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final void a(double d2, double d3, FPoint fPoint) {
        IPoint obtain = IPoint.obtain();
        a(d2, d3, obtain);
        a(obtain.x, obtain.y, fPoint);
        obtain.recycle();
    }

    @Override // com.amap.api.col.stln3.co
    public final void b(int i2, int i3, DPoint dPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.aN && (gLMapEngine = this.f) != null && (mapState = gLMapEngine.getMapState(1)) != null) {
            IPoint obtain = IPoint.obtain();
            mapState.screenToP20Point(i2, i3, obtain);
            DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) obtain.x, (long) obtain.y, 20);
            dPoint.x = pixelsToLatLong.x;
            dPoint.y = pixelsToLatLong.y;
            obtain.recycle();
            pixelsToLatLong.recycle();
        }
    }

    private void a(GLMapState gLMapState, int i2, int i3, DPoint dPoint) {
        if (this.aN && this.f != null) {
            Point point = new Point();
            gLMapState.screenToP20Point(i2, i3, point);
            DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) point.x, (long) point.y, 20);
            dPoint.x = pixelsToLatLong.x;
            dPoint.y = pixelsToLatLong.y;
            pixelsToLatLong.recycle();
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final void b(double d2, double d3, IPoint iPoint) {
        if (this.aN && this.f != null) {
            try {
                Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d2, d3, 20);
                FPoint obtain = FPoint.obtain();
                b(latLongToPixels.x, latLongToPixels.y, obtain);
                if (obtain.x == -10000.0f && obtain.y == -10000.0f) {
                    GLMapState newMapState = this.f.getNewMapState(1);
                    newMapState.setCameraDegree(0.0f);
                    newMapState.recalculate();
                    newMapState.p20ToScreenPoint(latLongToPixels.x, latLongToPixels.y, obtain);
                    newMapState.recycle();
                }
                iPoint.x = (int) obtain.x;
                iPoint.y = (int) obtain.y;
                obtain.recycle();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final void a(int i2, int i3, IPoint iPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.aN && (gLMapEngine = this.f) != null && (mapState = gLMapEngine.getMapState(1)) != null) {
            mapState.screenToP20Point(i2, i3, iPoint);
        }
    }

    private void b(int i2, int i3, FPoint fPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.aN && (gLMapEngine = this.f) != null && (mapState = gLMapEngine.getMapState(1)) != null) {
            mapState.p20ToScreenPoint(i2, i3, fPoint);
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final void m() {
        if (this.aN) {
            this.i.sendEmptyMessage(18);
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final void a(boolean z2) {
        io ioVar;
        if (!this.V && (ioVar = this.Q) != null) {
            ioVar.b(z2);
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final void b(boolean z2) {
        io ioVar;
        if (!this.V && (ioVar = this.Q) != null) {
            ioVar.a(z2);
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final void c(boolean z2) {
        io ioVar;
        if (!this.V && (ioVar = this.Q) != null) {
            ioVar.c(z2);
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final void d(boolean z2) {
        io ioVar;
        if (!this.V && (ioVar = this.Q) != null) {
            ioVar.d(z2);
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final void e(boolean z2) {
        io ioVar;
        if (!this.V && (ioVar = this.Q) != null) {
            ioVar.e(z2);
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final void d(int i2) {
        io ioVar;
        if (!this.V && (ioVar = this.Q) != null) {
            ioVar.a(i2);
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final LatLngBounds a(LatLng latLng, float f2) {
        int mapWidth = getMapWidth();
        int mapHeight = getMapHeight();
        if (mapWidth <= 0 || mapHeight <= 0 || this.V) {
            return null;
        }
        float a2 = ic.a(this.c, f2);
        GLMapState gLMapState = new GLMapState(1, this.f.getNativeInstance());
        if (latLng != null) {
            IPoint obtain = IPoint.obtain();
            a(latLng.latitude, latLng.longitude, obtain);
            gLMapState.setCameraDegree(0.0f);
            gLMapState.setMapAngle(0.0f);
            gLMapState.setMapGeoCenter(obtain.x, obtain.y);
            gLMapState.setMapZoomer(a2);
            gLMapState.recalculate();
            obtain.recycle();
        }
        DPoint obtain2 = DPoint.obtain();
        a(gLMapState, 0, 0, obtain2);
        LatLng latLng2 = new LatLng(obtain2.y, obtain2.x, false);
        a(gLMapState, mapWidth, mapHeight, obtain2);
        LatLng latLng3 = new LatLng(obtain2.y, obtain2.x, false);
        obtain2.recycle();
        gLMapState.recycle();
        return LatLngBounds.builder().include(latLng3).include(latLng2).build();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        Marker marker;
        if (this.Y || !this.aN || !this.aJ) {
            return false;
        }
        EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.bl;
        eAMapPlatformGestureInfo.mGestureState = 3;
        eAMapPlatformGestureInfo.mGestureType = 8;
        eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
        final int a2 = a(this.bl);
        GLMapRender gLMapRender = this.aD;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(2);
        }
        switch (motionEvent.getAction() & 255) {
            case 0:
                H();
                if (this.aN) {
                    this.aE.a();
                    this.aF = true;
                    this.aK = true;
                    try {
                        stopAnimation();
                    } catch (RemoteException e2) {
                    }
                    queueEvent(new Runnable() {
                        /* class com.amap.api.col.stln3.bw.AnonymousClass5 */

                        public final void run() {
                            try {
                                bw.this.f.clearAllMessages(a2);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                    break;
                }
                break;
            case 1:
                this.aF = true;
                this.aK = false;
                if (this.ah) {
                    this.ah = false;
                }
                if (this.ag) {
                    this.ag = false;
                }
                if (this.ai) {
                    this.ai = false;
                }
                this.ad = false;
                AMap.OnMarkerDragListener onMarkerDragListener = this.v;
                if (!(onMarkerDragListener == null || (marker = this.ae) == null)) {
                    try {
                        onMarkerDragListener.onMarkerDragEnd(marker);
                    } catch (Throwable th) {
                        rx.c(th, "AMapDelegateImp", "OnMarkerDragListener.onMarkerDragEnd");
                        th.printStackTrace();
                    }
                    this.ae = null;
                }
                this.P.postDelayed(new Runnable() {
                    /* class com.amap.api.col.stln3.bw.AnonymousClass6 */

                    public final void run() {
                        bw.this.aM = 1;
                    }
                }, 300);
                break;
        }
        if (motionEvent.getAction() != 2 || !(z2 = this.ad)) {
            if (this.aF) {
                try {
                    this.aE.a(motionEvent);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (this.z != null) {
                this.i.removeMessages(14);
                Message obtainMessage = this.i.obtainMessage();
                obtainMessage.what = 14;
                obtainMessage.obj = MotionEvent.obtain(motionEvent);
                obtainMessage.sendToTarget();
            }
            return true;
        }
        if (z2) {
            try {
                if (!(this.ae == null || this.af == null)) {
                    int x2 = (int) motionEvent.getX();
                    int y2 = (int) (motionEvent.getY() - 60.0f);
                    LatLng b2 = this.af.b();
                    if (b2 != null) {
                        LatLng position = this.af.getPosition();
                        DPoint obtain = DPoint.obtain();
                        b(x2, y2, obtain);
                        LatLng latLng = new LatLng((position.latitude + obtain.y) - b2.latitude, (position.longitude + obtain.x) - b2.longitude);
                        obtain.recycle();
                        this.ae.setPosition(latLng);
                        if (this.v != null) {
                            this.v.onMarkerDrag(this.ae);
                        }
                    }
                }
            } catch (Throwable th3) {
                rx.c(th3, "AMapDelegateImp", "onDragMarker");
                th3.printStackTrace();
            }
        }
        return true;
    }

    @Override // com.amap.api.col.stln3.co
    public final void a(int i2, int i3, PointF pointF) {
        if (this.aN && !this.Y && this.f != null) {
            IPoint obtain = IPoint.obtain();
            a(i2, i3, obtain);
            pointF.x = (float) (obtain.x - this.c.getSX());
            pointF.y = (float) (obtain.y - this.c.getSY());
            obtain.recycle();
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final void a(float f2, float f3, IPoint iPoint) {
        iPoint.x = (int) (f2 + ((float) this.c.getSX()));
        iPoint.y = (int) (f3 + ((float) this.c.getSY()));
    }

    @Override // com.amap.api.col.stln3.co
    public final float e(int i2) {
        GLMapEngine gLMapEngine;
        if (!this.aN || this.Y || (gLMapEngine = this.f) == null) {
            return 0.0f;
        }
        return gLMapEngine.getMapState(1).getGLUnitWithWin(i2);
    }

    private CameraPosition h(boolean z2) {
        LatLng latLng;
        try {
            if (this.c == null) {
                return null;
            }
            if (!this.aN || this.Y || this.f == null) {
                DPoint obtain = DPoint.obtain();
                a(this.c.getSX(), this.c.getSY(), obtain);
                LatLng latLng2 = new LatLng(obtain.y, obtain.x);
                obtain.recycle();
                return CameraPosition.builder().target(latLng2).bearing(this.c.getSR()).tilt(this.c.getSC()).zoom(this.c.getSZ()).build();
            }
            if (z2) {
                DPoint obtain2 = DPoint.obtain();
                b(this.c.getAnchorX(), this.c.getAnchorY(), obtain2);
                latLng = new LatLng(obtain2.y, obtain2.x, false);
                obtain2.recycle();
            } else if (this.c != null) {
                DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) this.c.getSX(), (long) this.c.getSY(), 20);
                LatLng latLng3 = new LatLng(pixelsToLatLong.y, pixelsToLatLong.x, false);
                pixelsToLatLong.recycle();
                latLng = latLng3;
            } else {
                latLng = null;
            }
            return CameraPosition.builder().target(latLng).bearing(this.c.getSR()).tilt(this.c.getSC()).zoom(this.c.getSZ()).build();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final boolean n() {
        return this.Z;
    }

    @Override // com.amap.api.col.stln3.co
    public final Point o() {
        io ioVar = this.Q;
        if (ioVar != null) {
            return ioVar.c();
        }
        return new Point();
    }

    @Override // com.amap.api.col.stln3.co
    public final View p() {
        cp cpVar = this.P;
        if (cpVar instanceof View) {
            return (View) cpVar;
        }
        return null;
    }

    @Override // com.amap.api.col.stln3.co
    public final boolean q() {
        dq dqVar;
        if (j() < 17.0f || (dqVar = this.d) == null || dqVar.g == null) {
            return false;
        }
        FPoint obtain = FPoint.obtain();
        b(this.d.g.x, this.d.g.y, obtain);
        if (this.am.contains((int) obtain.x, (int) obtain.y)) {
            return true;
        }
        return false;
    }

    private synchronized void E() {
        synchronized (this.az) {
            int size = this.az.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.az.get(i2).e().recycle();
            }
            this.az.clear();
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final void a(cx cxVar) {
        if (cxVar != null && cxVar.f() != 0) {
            synchronized (this.az) {
                this.az.add(cxVar);
            }
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final void c(String str) {
        synchronized (this.az) {
            int size = this.az.size();
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                } else if (this.az.get(i3).j().equals(str)) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            if (i2 >= 0) {
                this.az.remove(i2);
            }
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final cx a(BitmapDescriptor bitmapDescriptor) {
        return a(bitmapDescriptor, false);
    }

    @Override // com.amap.api.col.stln3.co
    public final cx a(BitmapDescriptor bitmapDescriptor, boolean z2) {
        if (bitmapDescriptor == null || bitmapDescriptor.getBitmap() == null || bitmapDescriptor.getBitmap().isRecycled()) {
            return null;
        }
        synchronized (this.az) {
            for (int i2 = 0; i2 < this.az.size(); i2++) {
                cx cxVar = this.az.get(i2);
                if (z2) {
                    if (cxVar.f() == h()) {
                    }
                }
                if (cxVar.e().equals(bitmapDescriptor)) {
                    return cxVar;
                }
            }
            return null;
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final int r() {
        return 0;
    }

    @Override // com.amap.api.col.stln3.co
    public final void f(int i2) {
        io ioVar = this.Q;
        if (ioVar != null) {
            ioVar.b(i2);
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final void g(int i2) {
        io ioVar = this.Q;
        if (ioVar != null) {
            ioVar.c(i2);
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final void h(int i2) {
        io ioVar = this.Q;
        if (ioVar != null) {
            ioVar.d(i2);
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final float i(int i2) {
        io ioVar = this.Q;
        if (ioVar != null) {
            return ioVar.e(i2);
        }
        return 0.0f;
    }

    @Override // com.amap.api.col.stln3.co
    public final void a(int i2, float f2) {
        io ioVar = this.Q;
        if (ioVar != null) {
            ioVar.a(i2, f2);
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final int s() {
        return this.ax;
    }

    @Override // com.amap.api.col.stln3.co
    public final void a(final int i2, MotionEvent motionEvent) {
        try {
            this.ag = false;
            queueEvent(new Runnable() {
                /* class com.amap.api.col.stln3.bw.AnonymousClass10 */

                public final void run() {
                    if (bw.this.aN && bw.this.f != null) {
                        bw.this.f.setHighlightSubwayEnable(i2, false);
                    }
                }
            });
            this.af = this.b.a(motionEvent);
            if (this.af != null && this.af.isDraggable()) {
                this.ae = new Marker((gg) this.af);
                LatLng position = this.ae.getPosition();
                LatLng b2 = this.af.b();
                if (!(position == null || b2 == null)) {
                    IPoint obtain = IPoint.obtain();
                    b(b2.latitude, b2.longitude, obtain);
                    obtain.y -= 60;
                    DPoint obtain2 = DPoint.obtain();
                    b(obtain.x, obtain.y, obtain2);
                    this.ae.setPosition(new LatLng((position.latitude + obtain2.y) - b2.latitude, (position.longitude + obtain2.x) - b2.longitude));
                    this.b.a((fx) ((gg) this.af));
                    try {
                        if (this.v != null) {
                            this.v.onMarkerDragStart(this.ae);
                        }
                    } catch (Throwable th) {
                        rx.c(th, "AMapDelegateImp", "onMarkerDragStart");
                        th.printStackTrace();
                    }
                    this.ad = true;
                    obtain.recycle();
                    obtain2.recycle();
                }
            } else if (this.B != null) {
                DPoint obtain3 = DPoint.obtain();
                b((int) motionEvent.getX(), (int) motionEvent.getY(), obtain3);
                this.B.onMapLongClick(new LatLng(obtain3.y, obtain3.x));
                this.ah = true;
                obtain3.recycle();
            }
            this.aD.resetTickCount(30);
        } catch (Throwable th2) {
            rx.c(th2, "AMapDelegateImp", "onLongPress");
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final boolean a(MotionEvent motionEvent) {
        if (!this.aN) {
            return false;
        }
        b((int) motionEvent.getX(), (int) motionEvent.getY());
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x004f A[Catch:{ Throwable -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0071 A[Catch:{ Throwable -> 0x00b1 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0072 A[Catch:{ Throwable -> 0x00b1 }] */
    @Override // com.amap.api.col.stln3.co
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(final android.view.MotionEvent r8) {
        /*
        // Method dump skipped, instructions count: 189
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.bw.b(android.view.MotionEvent):boolean");
    }

    private boolean c(MotionEvent motionEvent) throws RemoteException {
        LatLng b2;
        if (!this.b.b(motionEvent)) {
            return false;
        }
        cg d2 = this.b.d();
        boolean z2 = true;
        if (d2 == null) {
            return true;
        }
        try {
            Marker marker = new Marker((gg) d2);
            this.b.a((fx) ((gg) d2));
            if (this.t != null) {
                boolean onMarkerClick = this.t.onMarkerClick(marker);
                if (!onMarkerClick) {
                    if (this.b.g() > 0) {
                        z2 = onMarkerClick;
                    }
                }
                return true;
            }
            a((gg) d2);
            if (!d2.g() && (b2 = d2.b()) != null) {
                IPoint obtain = IPoint.obtain();
                a(b2.latitude, b2.longitude, obtain);
                a(dh.a(obtain));
            }
            return z2;
        } catch (Throwable th) {
            rx.c(th, "AMapDelegateImp", "onMarkerTap");
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void drawFrame(GL10 gl10) {
        GLMapEngine gLMapEngine;
        float f2;
        GLMapRender gLMapRender;
        if (!this.V && (gLMapEngine = this.f) != null) {
            int i2 = this.ay;
            if (i2 != -1) {
                this.aD.setRenderFps((float) i2);
                resetRenderTime();
            } else {
                if (gLMapEngine.isInMapAction(1) || this.aK) {
                    gLMapRender = this.aD;
                    f2 = 40.0f;
                } else if (this.f.isInMapAnimation(1)) {
                    this.aD.setRenderFps(30.0f);
                    this.aD.resetTickCount(15);
                } else {
                    gLMapRender = this.aD;
                    f2 = 15.0f;
                }
                gLMapRender.setRenderFps(f2);
            }
            if (this.c.isWorldMapEnable() != MapsInitializer.isLoadWorldGridMap()) {
                t();
                this.c.setWorldMapEnable(MapsInitializer.isLoadWorldGridMap());
            }
            this.f.renderAMap();
            this.f.pushRendererState();
            CustomRenderer customRenderer = this.av;
            if (customRenderer != null) {
                customRenderer.onDrawFrame(gl10);
            }
            bv bvVar = this.aZ;
            if (bvVar != null) {
                bvVar.a();
            }
            if (this.ak) {
                boolean canStopMapRender = this.f.canStopMapRender(1);
                Message obtainMessage = this.i.obtainMessage(15, ic.a(0, getMapWidth(), getMapHeight()));
                obtainMessage.arg1 = canStopMapRender ? 1 : 0;
                obtainMessage.sendToTarget();
                this.ak = false;
            }
            long j2 = this.bm;
            if (j2 < 2) {
                this.bm = j2 + 1;
            } else {
                final ik f3 = this.Q.f();
                if (!(f3 == null || f3.getVisibility() == 8)) {
                    if (!this.aa) {
                        this.i.sendEmptyMessage(16);
                        this.aa = true;
                        t();
                    }
                    this.i.post(new Runnable() {
                        /* class com.amap.api.col.stln3.bw.AnonymousClass9 */

                        public final void run() {
                            if (!bw.this.Y) {
                                try {
                                    if (bw.this.d != null) {
                                        bw.this.setIndoorBuildingInfo(bw.this.d);
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                                f3.a();
                            }
                        }
                    });
                }
            }
            if (!this.aP) {
                this.aP = true;
            }
            this.f.popRendererState();
            ca caVar = this.aC;
            if (caVar != null) {
                caVar.a(new cw());
            }
        }
    }

    private void F() {
        boolean z2 = false;
        if (this.c.getMapRect() == null || this.at) {
            G();
            this.at = false;
        }
        this.f.getCurTileIDs(1, this.c.getCurTileIds());
        GLMapState mapState = this.f.getMapState(1);
        if (mapState != null) {
            mapState.getViewMatrix(this.c.getViewMatrix());
            mapState.getProjectionMatrix(this.c.getProjectionMatrix());
            this.c.updateFinalMatrix();
            Point mapGeoCenter = mapState.getMapGeoCenter();
            this.c.setSX(mapGeoCenter.x);
            this.c.setSY(mapGeoCenter.y);
            this.c.setSZ(mapState.getMapZoomer());
            this.c.setSC(mapState.getCameraDegree());
            this.c.setSR(mapState.getMapAngle());
            if (this.c.isMapStateChange()) {
                this.c.setSkyHeight(mapState.getSkyHeight());
                DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) mapGeoCenter.x, (long) mapGeoCenter.y, 20);
                CameraPosition cameraPosition = new CameraPosition(new LatLng(pixelsToLatLong.y, pixelsToLatLong.x, false), this.c.getSZ(), this.c.getSC(), this.c.getSR());
                pixelsToLatLong.recycle();
                Message obtainMessage = this.i.obtainMessage();
                obtainMessage.what = 10;
                obtainMessage.obj = cameraPosition;
                this.i.sendMessage(obtainMessage);
                this.aL = true;
                m();
                G();
                try {
                    if (this.N.isZoomControlsEnabled() && this.c.isNeedUpdateZoomControllerState()) {
                        this.X.invalidateZoomController(this.c.getSZ());
                    }
                    if (this.c.getChangeGridRatio() != 1.0d) {
                        t();
                    }
                    if (this.N.isCompassEnabled()) {
                        if (!this.c.isTiltChanged()) {
                            if (this.c.isBearingChanged()) {
                            }
                        }
                        z2 = true;
                    }
                    if (z2) {
                        this.X.invalidateCompassView();
                    }
                    if (this.N.isScaleControlsEnabled()) {
                        this.X.invalidateScaleView();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else if (!this.aK && this.f.getAnimateionsCount() == 0 && this.f.getStateMessageCount() == 0) {
                onChangeFinish();
            }
        }
    }

    private void G() {
        try {
            this.c.setMapRect(ic.a(this));
            GLMapState mapState = this.f.getMapState(1);
            if (mapState != null) {
                mapState.getPixel20Bound(this.k, getMapWidth(), getMapHeight());
                this.c.getGeoRectangle().updateRect(this.k, this.c.getSX(), this.c.getSY());
                this.c.setMapPerPixelUnitLength(mapState.getGLUnitWithWin(1));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public final void t() {
        this.i.obtainMessage(17, 1, 0).sendToTarget();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ef A[Catch:{ Throwable -> 0x0112 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0111 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.amap.api.maps.model.Poi c(int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 276
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.bw.c(int, int):com.amap.api.maps.model.Poi");
    }

    @Override // com.amap.api.col.stln3.co
    public final float u() {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return mapConfig.getSR();
        }
        return 0.0f;
    }

    @Override // com.amap.api.col.stln3.co
    public final void a(IPoint iPoint) {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            iPoint.x = mapConfig.getSX();
            iPoint.y = this.c.getSY();
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final float v() {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return mapConfig.getSC();
        }
        return 0.0f;
    }

    @Override // com.amap.api.col.stln3.co
    public final void a(int i2, AbstractGestureMapMessage abstractGestureMapMessage) {
        if (this.aN && this.f != null) {
            try {
                abstractGestureMapMessage.isUseAnchor = this.Z;
                abstractGestureMapMessage.anchorX = this.c.getAnchorX();
                abstractGestureMapMessage.anchorY = this.c.getAnchorY();
                this.f.addGestureMessage(i2, abstractGestureMapMessage, this.N.isGestureScaleByMapCenter(), this.c.getAnchorX(), this.c.getAnchorY());
            } catch (RemoteException e2) {
            }
        }
    }

    private void m(int i2) {
        GLMapRender gLMapRender = this.aD;
        if (gLMapRender != null) {
            gLMapRender.renderPause();
        }
        o(i2);
    }

    private void n(int i2) {
        o(i2);
        GLMapRender gLMapRender = this.aD;
        if (gLMapRender != null) {
            gLMapRender.renderResume();
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final void w() {
        GLMapRender gLMapRender = this.aD;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(30);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void resetRenderTime() {
        GLMapRender gLMapRender = this.aD;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(2);
        }
    }

    private void H() {
        GLMapRender gLMapRender;
        if (this.aN && (gLMapRender = this.aD) != null && !gLMapRender.isRenderPause()) {
            requestRender();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void requestRender() {
        GLMapRender gLMapRender = this.aD;
        if (gLMapRender != null && !gLMapRender.isRenderPause()) {
            this.P.requestRender();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getRenderMode() {
        return this.P.getRenderMode();
    }

    private void I() {
        if (!this.as) {
            try {
                if (this.aq == null) {
                    this.aq = new cc(this.e, this);
                }
                this.aq.setName("AuthProThread");
                this.aq.start();
                this.as = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final float x() {
        return this.aH;
    }

    public final synchronized void a(int i2, int i3, int i4, int i5) {
        a(i2, i3, i4, i5, false, false, null);
    }

    private synchronized void a(final int i2, final int i3, final int i4, final int i5, final boolean z2, final boolean z3, final StyleItem[] styleItemArr) {
        io ioVar;
        if (!this.aO || !this.aN || !this.a) {
            this.bc.g = i2;
            this.bc.d = i3;
            this.bc.e = i4;
            this.bc.f = i5;
            this.bc.b = true;
            return;
        }
        if (this.Q != null) {
            if (i4 == 0) {
                if (this.Q.d()) {
                    this.Q.g(false);
                    ioVar = this.Q;
                }
            } else if (!this.Q.d()) {
                this.Q.g(true);
                ioVar = this.Q;
            }
            ioVar.e();
        }
        queueEvent(new Runnable() {
            /* class com.amap.api.col.stln3.bw.AnonymousClass12 */

            public final void run() {
                try {
                    bw.this.f.setMapModeAndStyle(i2, i3, i4, i5, z2, z3, styleItemArr);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    private void o(final int i2) {
        queueEvent(new Runnable() {
            /* class com.amap.api.col.stln3.bw.AnonymousClass13 */

            public final void run() {
                try {
                    bw.this.f.clearAllMessages(i2);
                    bw.this.f.clearAnimations(i2, true);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public final void a(final int i2, final boolean z2) {
        if (!this.aN || !this.aO) {
            a aVar = this.be;
            aVar.c = z2;
            aVar.b = true;
            aVar.g = i2;
            return;
        }
        resetRenderTime();
        queueEvent(new Runnable() {
            /* class com.amap.api.col.stln3.bw.AnonymousClass14 */

            public final void run() {
                try {
                    bw.this.f.setBuildingEnable(i2, z2);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public final void b(final int i2, final boolean z2) {
        if (!this.aN || !this.aO) {
            a aVar = this.bg;
            aVar.c = z2;
            aVar.b = true;
            aVar.g = i2;
            return;
        }
        resetRenderTime();
        queueEvent(new Runnable() {
            /* class com.amap.api.col.stln3.bw.AnonymousClass15 */

            public final void run() {
                if (bw.this.f != null) {
                    if (z2) {
                        bw.this.f.setAllContentEnable(i2, true);
                    } else {
                        bw.this.f.setAllContentEnable(i2, false);
                    }
                    bw.this.f.setSimple3DEnable(i2, false);
                }
            }
        });
    }

    public final void c(final int i2, final boolean z2) {
        if (!this.aN || !this.aO) {
            a aVar = this.bj;
            aVar.c = z2;
            aVar.b = true;
            aVar.g = i2;
            return;
        }
        resetRenderTime();
        queueEvent(new Runnable() {
            /* class com.amap.api.col.stln3.bw.AnonymousClass16 */

            public final void run() {
                try {
                    if (z2) {
                        bw.this.f.setBuildingTextureEnable(i2, true);
                    } else {
                        bw.this.f.setBuildingTextureEnable(i2, false);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    private synchronized void a(GL10 gl10, EGLConfig eGLConfig) {
        if (this.an == 3) {
            this.Q.f().a(ik.b);
        } else {
            this.Q.f().a(ik.a);
        }
        this.aO = false;
        this.g = this.P.getWidth();
        this.h = this.P.getHeight();
        this.aQ = false;
        try {
            AeUtil.loadLib(this.e);
            this.f.createAMapInstance(AeUtil.initResource(this.e));
            this.aW = new gq();
            this.S.a(this.aW);
            this.aN = true;
            this.l = gl10.glGetString(7937);
        } catch (Throwable th) {
            rx.c(th, "AMapDElegateImp", "createSurface");
        }
        GLMapState mapState = this.f.getMapState(1);
        if (!(mapState == null || mapState.getNativeInstance() == 0)) {
            mapState.setMapGeoCenter(this.c.getSX(), this.c.getSY());
            mapState.setMapAngle(this.c.getSR());
            mapState.setMapZoomer(this.c.getSZ());
            mapState.setCameraDegree(this.c.getSC());
        }
        this.aX.a(this.e);
        if (!this.ar) {
            try {
                this.ap.setName("AuthThread");
                this.ap.start();
                this.ar = true;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        if (this.av != null) {
            this.av.onSurfaceCreated(gl10, eGLConfig);
        }
        AMapNativeRenderer.nativeDrawLineInit();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void destroySurface(int i2) {
        this.aR.lock();
        try {
            if (this.aN) {
                this.f.destroyAMapEngine();
            }
            this.aN = false;
            this.aO = false;
            this.aQ = false;
        } catch (Throwable th) {
        } finally {
            this.aR.unlock();
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final Context y() {
        return this.e;
    }

    @Override // com.amap.api.col.stln3.co
    public final int a(EAMapPlatformGestureInfo eAMapPlatformGestureInfo) {
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            return gLMapEngine.getEngineIDWithGestureInfo(eAMapPlatformGestureInfo);
        }
        return 1;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final CameraPosition getCameraPosition() throws RemoteException {
        return h(this.Z);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getMaxZoomLevel() {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return mapConfig.getMaxZoomLevel();
        }
        return 20.0f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getMinZoomLevel() {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return mapConfig.getMinZoomLevel();
        }
        return 3.0f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void moveCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate != null) {
            a(cameraUpdate.getCameraUpdateFactoryDelegate());
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final void a(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException {
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null && !this.V) {
            if (this.Y && gLMapEngine.getStateMessageCount() > 0) {
                de deVar = new de();
                deVar.nowType = AbstractCameraUpdateMessage.Type.changeGeoCenterZoomTiltBearing;
                deVar.geoPoint = new Point(this.c.getSX(), this.c.getSY());
                deVar.zoom = this.c.getSZ();
                deVar.bearing = this.c.getSR();
                deVar.tilt = this.c.getSC();
                this.f.addMessage(abstractCameraUpdateMessage, false);
                while (this.f.getStateMessageCount() > 0) {
                    AbstractCameraUpdateMessage stateMessage = this.f.getStateMessage();
                    if (stateMessage != null) {
                        stateMessage.mergeCameraUpdateDelegate(deVar);
                    }
                }
                abstractCameraUpdateMessage = deVar;
            }
            resetRenderTime();
            this.f.clearAnimations(1, false);
            abstractCameraUpdateMessage.isChangeFinished = true;
            c(abstractCameraUpdateMessage);
            this.f.addMessage(abstractCameraUpdateMessage, false);
        }
    }

    private void c(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        boolean z2 = this.Z;
        abstractCameraUpdateMessage.isUseAnchor = z2;
        if (z2) {
            abstractCameraUpdateMessage.anchorX = this.c.getAnchorX();
            abstractCameraUpdateMessage.anchorY = this.c.getAnchorY();
        }
        if (abstractCameraUpdateMessage.width == 0) {
            abstractCameraUpdateMessage.width = getMapWidth();
        }
        if (abstractCameraUpdateMessage.height == 0) {
            abstractCameraUpdateMessage.height = getMapHeight();
        }
        abstractCameraUpdateMessage.mapConfig = this.c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void animateCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate != null) {
            b(cameraUpdate.getCameraUpdateFactoryDelegate());
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final void b(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException {
        a(abstractCameraUpdateMessage, 250, (AMap.CancelableCallback) null);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void animateCameraWithCallback(CameraUpdate cameraUpdate, AMap.CancelableCallback cancelableCallback) throws RemoteException {
        if (cameraUpdate != null) {
            animateCameraWithDurationAndCallback(cameraUpdate, 250, cancelableCallback);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void animateCameraWithDurationAndCallback(CameraUpdate cameraUpdate, long j2, AMap.CancelableCallback cancelableCallback) {
        if (cameraUpdate != null) {
            a(cameraUpdate.getCameraUpdateFactoryDelegate(), j2, cancelableCallback);
        }
    }

    private void a(AbstractCameraUpdateMessage abstractCameraUpdateMessage, long j2, AMap.CancelableCallback cancelableCallback) {
        if (abstractCameraUpdateMessage != null && !this.V && this.f != null) {
            abstractCameraUpdateMessage.mCallback = cancelableCallback;
            abstractCameraUpdateMessage.mDuration = j2;
            if (this.Y || getMapHeight() == 0 || getMapWidth() == 0) {
                try {
                    a(abstractCameraUpdateMessage);
                    if (abstractCameraUpdateMessage.mCallback != null) {
                        abstractCameraUpdateMessage.mCallback.onFinish();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                try {
                    this.f.interruptAnimation();
                    resetRenderTime();
                    c(abstractCameraUpdateMessage);
                    this.f.addMessage(abstractCameraUpdateMessage, true);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void stopAnimation() throws RemoteException {
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            gLMapEngine.interruptAnimation();
        }
        resetRenderTime();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Polyline addPolyline(PolylineOptions polylineOptions) throws RemoteException {
        resetRenderTime();
        gd a2 = this.S.a(polylineOptions);
        if (a2 != null) {
            return new Polyline(a2);
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final BuildingOverlay addBuildingOverlay() {
        try {
            fu a2 = this.S.a();
            if (a2 != null) {
                return new BuildingOverlay(a2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final GL3DModel addGLModel(GL3DModelOptions gL3DModelOptions) {
        return this.W.a(gL3DModelOptions);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final ParticleOverlay addParticleOverlay(ParticleOverlayOptions particleOverlayOptions) {
        try {
            gb a2 = this.S.a(particleOverlayOptions);
            if (a2 != null) {
                return new ParticleOverlay(a2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final NavigateArrow addNavigateArrow(NavigateArrowOptions navigateArrowOptions) throws RemoteException {
        resetRenderTime();
        fy a2 = this.S.a(navigateArrowOptions);
        if (a2 != null) {
            return new NavigateArrow(a2);
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Polygon addPolygon(PolygonOptions polygonOptions) throws RemoteException {
        resetRenderTime();
        gc a2 = this.S.a(polygonOptions);
        if (a2 != null) {
            return new Polygon(a2);
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Circle addCircle(CircleOptions circleOptions) throws RemoteException {
        resetRenderTime();
        fv a2 = this.S.a(circleOptions);
        if (a2 != null) {
            return new Circle(a2);
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Arc addArc(ArcOptions arcOptions) throws RemoteException {
        resetRenderTime();
        ft a2 = this.S.a(arcOptions);
        if (a2 != null) {
            return new Arc(a2);
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        resetRenderTime();
        fw a2 = this.S.a(groundOverlayOptions);
        if (a2 != null) {
            return new GroundOverlay(a2);
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final MultiPointOverlay addMultiPointOverlay(MultiPointOverlayOptions multiPointOverlayOptions) throws RemoteException {
        resetRenderTime();
        IMultiPointOverlay a2 = this.aY.a(multiPointOverlayOptions);
        if (a2 != null) {
            return new MultiPointOverlay(a2);
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Marker addMarker(MarkerOptions markerOptions) throws RemoteException {
        resetRenderTime();
        return this.b.a(markerOptions);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Text addText(TextOptions textOptions) throws RemoteException {
        resetRenderTime();
        return this.b.a(textOptions);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> arrayList, boolean z2) throws RemoteException {
        resetRenderTime();
        return this.b.a(arrayList, z2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        return this.R.a(tileOverlayOptions);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void clear() throws RemoteException {
        try {
            clear(false);
        } catch (Throwable th) {
            rx.c(th, "AMapDelegateImp", "clear");
            th.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044 A[Catch:{ Throwable -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0039 A[Catch:{ Throwable -> 0x004f }] */
    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void clear(boolean r3) throws android.os.RemoteException {
        /*
            r2 = this;
            r2.l()     // Catch:{ Throwable -> 0x004f }
            com.amap.api.col.stln3.gh r0 = r2.ab     // Catch:{ Throwable -> 0x004f }
            r1 = 0
            if (r0 == 0) goto L_0x001f
            if (r3 == 0) goto L_0x0019
            com.amap.api.col.stln3.gh r3 = r2.ab     // Catch:{ Throwable -> 0x004f }
            java.lang.String r1 = r3.c()     // Catch:{ Throwable -> 0x004f }
            com.amap.api.col.stln3.gh r3 = r2.ab     // Catch:{ Throwable -> 0x004f }
            java.lang.String r3 = r3.d()     // Catch:{ Throwable -> 0x004f }
            goto L_0x0021
        L_0x0019:
            com.amap.api.col.stln3.gh r3 = r2.ab     // Catch:{ Throwable -> 0x004f }
            r3.e()     // Catch:{ Throwable -> 0x004f }
            goto L_0x0020
        L_0x001f:
        L_0x0020:
            r3 = r1
        L_0x0021:
            com.amap.api.col.stln3.cm r0 = r2.S     // Catch:{ Throwable -> 0x004f }
            r0.b(r3)     // Catch:{ Throwable -> 0x004f }
            com.amap.api.col.stln3.db r3 = r2.R     // Catch:{ Throwable -> 0x004f }
            r3.c()     // Catch:{ Throwable -> 0x004f }
            com.amap.api.col.stln3.cu r3 = r2.b     // Catch:{ Throwable -> 0x004f }
            r3.a(r1)     // Catch:{ Throwable -> 0x004f }
            com.amap.api.col.stln3.cj r3 = r2.W     // Catch:{ Throwable -> 0x004f }
            r3.b()     // Catch:{ Throwable -> 0x004f }
            com.amap.api.col.stln3.io r3 = r2.Q     // Catch:{ Throwable -> 0x004f }
            if (r3 == 0) goto L_0x003f
            com.amap.api.col.stln3.io r3 = r2.Q     // Catch:{ Throwable -> 0x004f }
            com.amap.api.col.stln3.io.l()     // Catch:{ Throwable -> 0x004f }
            goto L_0x0040
        L_0x003f:
        L_0x0040:
            com.amap.api.col.stln3.dx r3 = r2.aY     // Catch:{ Throwable -> 0x004f }
            if (r3 == 0) goto L_0x004a
            com.amap.api.col.stln3.dx r3 = r2.aY     // Catch:{ Throwable -> 0x004f }
            r3.c()     // Catch:{ Throwable -> 0x004f }
            goto L_0x004b
        L_0x004a:
        L_0x004b:
            r2.resetRenderTime()     // Catch:{ Throwable -> 0x004f }
            return
        L_0x004f:
            r3 = move-exception
            java.lang.String r0 = "AMapDelegateImp"
            java.lang.String r1 = "clear"
            com.amap.api.col.stln3.rx.c(r3, r0, r1)
            r3.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.bw.clear(boolean):void");
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapType() throws RemoteException {
        return this.an;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapType(int i2) throws RemoteException {
        MapConfig mapConfig;
        if (i2 != this.an || ((mapConfig = this.c) != null && mapConfig.isCustomStyleEnable())) {
            ca caVar = this.aC;
            if (caVar != null) {
                caVar.a(new cw(Integer.valueOf(i2)));
            }
            this.an = i2;
        }
    }

    public final void j(int i2) {
        int i3;
        int i4;
        int i5;
        this.an = i2;
        if (i2 == 1) {
            i5 = 0;
            i4 = 0;
            i3 = 0;
        } else if (i2 == 2) {
            i5 = 1;
            i4 = 0;
            i3 = 0;
        } else if (i2 == 3) {
            i5 = 0;
            i4 = 1;
            i3 = 4;
        } else if (i2 == 4) {
            i5 = 0;
            i4 = 0;
            i3 = 4;
        } else if (i2 == 5) {
            i5 = 2;
            i4 = 0;
            i3 = 5;
        } else {
            try {
                this.an = 1;
                i5 = 0;
                i4 = 0;
                i3 = 0;
            } catch (Throwable th) {
                rx.c(th, "AMapDelegateImp", "setMaptype");
                th.printStackTrace();
                return;
            }
        }
        this.c.setMapStyleMode(i5);
        this.c.setMapStyleTime(i4);
        this.c.setMapStyleState(i3);
        if (this.c.isCustomStyleEnable()) {
            if (this.aZ == null || !this.aZ.d()) {
                a(1, i5, i4, i3, true, false, null);
                this.c.setCustomStyleEnable(false);
            } else {
                this.aZ.e();
            }
            this.N.setLogoEnable(true);
        } else {
            if (this.c.getMapLanguage().equals("en")) {
                setMapLanguage("zh_cn");
            }
            a(1, i5, i4, i3);
        }
        resetRenderTime();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isTrafficEnabled() throws RemoteException {
        return this.c.isTrafficEnabled();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setTrafficEnabled(final boolean z2) throws RemoteException {
        if (!this.aN || this.V) {
            a aVar = this.ba;
            aVar.c = z2;
            aVar.b = true;
            aVar.g = 1;
            return;
        }
        queueEvent(new Runnable(z2) {
            /* class com.amap.api.col.stln3.bw.AnonymousClass17 */
            final /* synthetic */ boolean a;

            {
                this.a = r2;
            }

            public final void run() {
                try {
                    if (bw.this.c.isTrafficEnabled() != this.a) {
                        bw.this.c.setTrafficEnabled(z2);
                        bw.this.aD.setTrafficMode(this.a);
                        boolean z = this.a;
                        bw.this.f.setTrafficEnable(1, this.a);
                        bw.this.resetRenderTime();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isIndoorEnabled() throws RemoteException {
        return this.c.isIndoorEnable();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setIndoorEnabled(final boolean z2) throws RemoteException {
        if (!this.aN || this.V) {
            a aVar = this.bh;
            aVar.c = z2;
            aVar.b = true;
            aVar.g = 1;
            return;
        }
        this.c.setIndoorEnable(z2);
        resetRenderTime();
        if (z2) {
            GLMapEngine gLMapEngine = this.f;
            if (gLMapEngine != null) {
                gLMapEngine.setIndoorEnable(1, true);
            }
        } else {
            GLMapEngine gLMapEngine2 = this.f;
            if (gLMapEngine2 != null) {
                gLMapEngine2.setIndoorEnable(1, false);
            }
            MapConfig mapConfig = this.c;
            mapConfig.maxZoomLevel = mapConfig.isSetLimitZoomLevel() ? this.c.getMaxZoomLevel() : 20.0f;
            if (this.N.isZoomControlsEnabled()) {
                this.X.invalidateZoomController(this.c.getSZ());
            }
        }
        if (this.N.isIndoorSwitchEnabled()) {
            this.i.post(new Runnable() {
                /* class com.amap.api.col.stln3.bw.AnonymousClass18 */

                public final void run() {
                    if (z2) {
                        bw.this.b(true);
                    } else if (bw.this.Q != null && bw.this.Q.g() != null) {
                        bw.this.Q.g().a(false);
                    }
                }
            });
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void set3DBuildingEnabled(boolean z2) throws RemoteException {
        m(1);
        a(1, z2);
        n(1);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isMyLocationEnabled() throws RemoteException {
        return this.T;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationEnabled(boolean z2) throws RemoteException {
        if (!this.V) {
            try {
                if (this.Q != null) {
                    in h2 = this.Q.h();
                    if (this.ac == null) {
                        h2.a(false);
                    } else if (z2) {
                        this.ac.activate(this.F);
                        h2.a(true);
                        if (this.ab == null) {
                            this.ab = new gh(this, this.e);
                        }
                    } else {
                        if (this.ab != null) {
                            this.ab.b();
                            this.ab = null;
                        }
                        this.ac.deactivate();
                    }
                }
                if (!z2) {
                    this.N.setMyLocationButtonEnabled(z2);
                }
                this.T = z2;
                resetRenderTime();
            } catch (Throwable th) {
                rx.c(th, "AMapDelegateImp", "setMyLocationEnabled");
                th.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setLoadOfflineData(final boolean z2) throws RemoteException {
        queueEvent(new Runnable() {
            /* class com.amap.api.col.stln3.bw.AnonymousClass19 */

            public final void run() {
                if (bw.this.f != null) {
                    bw.this.f.setOfflineDataEnable(1, z2);
                }
            }
        });
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationStyle(MyLocationStyle myLocationStyle) throws RemoteException {
        if (!this.V) {
            if (this.ab == null) {
                this.ab = new gh(this, this.e);
            }
            if (this.ab != null) {
                if (myLocationStyle.getInterval() < 1000) {
                    myLocationStyle.interval(1000);
                }
                LocationSource locationSource = this.ac;
                if (locationSource != null && (locationSource instanceof dt)) {
                    ((dt) locationSource).a(myLocationStyle.getInterval());
                    ((dt) this.ac).a(myLocationStyle.getMyLocationType());
                }
                this.ab.a(myLocationStyle);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationType(int i2) throws RemoteException {
        gh ghVar = this.ab;
        if (ghVar != null && ghVar.a() != null) {
            this.ab.a().myLocationType(i2);
            setMyLocationStyle(this.ab.a());
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final List<Marker> getMapScreenMarkers() throws RemoteException {
        if (!ic.a(getMapWidth(), getMapHeight())) {
            return new ArrayList();
        }
        return this.b.e();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapTextEnable(final boolean z2) throws RemoteException {
        if (!this.aN || !this.aO) {
            a aVar = this.bf;
            aVar.c = z2;
            aVar.b = true;
            aVar.g = 1;
            return;
        }
        resetRenderTime();
        queueEvent(new Runnable() {
            /* class com.amap.api.col.stln3.bw.AnonymousClass20 */

            public final void run() {
                try {
                    bw.this.f.setLabelEnable(1, z2);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyTrafficStyle(MyTrafficStyle myTrafficStyle) throws RemoteException {
        if (!this.V) {
            this.ao = myTrafficStyle;
            if (!this.aN || !this.aO || myTrafficStyle == null) {
                a aVar = this.bk;
                aVar.c = false;
                aVar.b = true;
                aVar.g = 1;
                return;
            }
            resetRenderTime();
            queueEvent(new Runnable() {
                /* class com.amap.api.col.stln3.bw.AnonymousClass22 */

                public final void run() {
                    try {
                        bw.this.f.setTrafficStyle(1, bw.this.ao.getSmoothColor(), bw.this.ao.getSlowColor(), bw.this.ao.getCongestedColor(), bw.this.ao.getSeriousCongestedColor());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Location getMyLocation() throws RemoteException {
        if (this.ac != null) {
            return this.F.a;
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setLocationSource(LocationSource locationSource) throws RemoteException {
        try {
            if (!this.V) {
                if (this.ac != null && (this.ac instanceof dt)) {
                    this.ac.deactivate();
                }
                this.ac = locationSource;
                if (locationSource != null) {
                    this.Q.h().a(true);
                } else {
                    this.Q.h().a(false);
                }
            }
        } catch (Throwable th) {
            rx.c(th, "AMapDelegateImp", "setLocationSource");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationRotateAngle(float f2) throws RemoteException {
        gh ghVar = this.ab;
        if (ghVar != null) {
            ghVar.a(f2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final UiSettings getAMapUiSettings() throws RemoteException {
        if (this.L == null) {
            this.L = new UiSettings(this.N);
        }
        return this.L;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Projection getAMapProjection() throws RemoteException {
        return new Projection(this.M);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        this.y = onMapClickListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        this.z = onMapTouchListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        this.A = onPOIClickListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        this.B = onMapLongClickListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        this.t = onMarkerClickListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        this.u = onPolylineClickListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) throws RemoteException {
        this.v = onMarkerDragListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMaploadedListener(AMap.OnMapLoadedListener onMapLoadedListener) throws RemoteException {
        this.w = onMapLoadedListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        this.x = onCameraChangeListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        this.C = onInfoWindowClickListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        this.D = onIndoorBuildingActiveListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        this.E = onMyLocationChangeListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setInfoWindowAdapter(AMap.InfoWindowAdapter infoWindowAdapter) throws RemoteException {
        ds dsVar;
        if (!this.V && (dsVar = this.J) != null) {
            dsVar.a(infoWindowAdapter);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setInfoWindowAdapter(AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) throws RemoteException {
        ds dsVar;
        if (!this.V && (dsVar = this.J) != null) {
            dsVar.a(commonInfoWindowAdapter);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMultiPointClickListener(AMap.OnMultiPointClickListener onMultiPointClickListener) {
        dx dxVar = this.aY;
        if (dxVar != null) {
            dxVar.a(onMultiPointClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getMapContentApprovalNumber() {
        MapConfig mapConfig = this.c;
        if (mapConfig == null || mapConfig.isCustomStyleEnable()) {
            return null;
        }
        String a2 = ht.a(this.e, "approval_number", "mc", "");
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        return "GS（2017）3426号 | GS（2017）2550号";
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getSatelliteImageApprovalNumber() {
        String a2 = ht.a(this.e, "approval_number", "si", "");
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        return "GS（2018）984号";
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapLanguage(String str) {
        MapConfig mapConfig;
        if (!TextUtils.isEmpty(str) && (mapConfig = this.c) != null && !mapConfig.isCustomStyleEnable() && !this.c.getMapLanguage().equals(str)) {
            if (!str.equals("en")) {
                this.c.setMapLanguage("zh_cn");
                this.au = 0;
            } else {
                if (this.an != 1) {
                    try {
                        setMapType(1);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                this.c.setMapLanguage("en");
                this.au = -10000;
            }
            try {
                b(getCameraPosition());
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            db dbVar = this.R;
            String mapLanguage = this.c.getMapLanguage();
            if (dbVar.d != null) {
                dbVar.d.a(mapLanguage);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void getMapPrintScreen(AMap.onMapPrintScreenListener onmapprintscreenlistener) {
        this.G = onmapprintscreenlistener;
        this.ak = true;
        resetRenderTime();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void getMapScreenShot(AMap.OnMapScreenShotListener onMapScreenShotListener) {
        this.H = onMapScreenShotListener;
        this.ak = true;
        resetRenderTime();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getScalePerPixel() throws RemoteException {
        try {
            return ((float) ((((Math.cos((getCameraPosition().target.latitude * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, (double) j()) * 256.0d))) * this.aH;
        } catch (Throwable th) {
            rx.c(th, "AMapDelegateImp", "getScalePerPixel");
            th.printStackTrace();
            return 0.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRunLowFrame(boolean z2) {
        if (!z2) {
            H();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removecache() throws RemoteException {
        removecache(null);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removecache(AMap.OnCacheRemoveListener onCacheRemoveListener) throws RemoteException {
        if (this.i != null && this.f != null) {
            try {
                d dVar = new d(this.e, onCacheRemoveListener);
                this.i.removeCallbacks(dVar);
                this.i.post(dVar);
            } catch (Throwable th) {
                rx.c(th, "AMapDelegateImp", "removecache");
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: AMapDelegateImp */
    public class d implements Runnable {
        private Context b;
        private AMap.OnCacheRemoveListener c;

        public d(Context context, AMap.OnCacheRemoveListener onCacheRemoveListener) {
            this.b = context;
            this.c = onCacheRemoveListener;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0057  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 232
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.bw.d.run():void");
        }

        public final boolean equals(Object obj) {
            return obj instanceof d;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomRenderer(CustomRenderer customRenderer) throws RemoteException {
        this.av = customRenderer;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCenterToPixel(int i2, int i3) throws RemoteException {
        this.Z = true;
        this.aT = i2;
        this.aU = i3;
        if (this.aO && this.aN) {
            if (this.c.getAnchorX() != this.aT || this.c.getAnchorY() != this.aU) {
                this.c.setAnchorX(this.aT);
                this.c.setAnchorY(this.aU);
                queueEvent(new Runnable() {
                    /* class com.amap.api.col.stln3.bw.AnonymousClass23 */

                    public final void run() {
                        try {
                            bw.this.c.setAnchorX(Math.max(0, Math.min(bw.this.aT, bw.this.g)));
                            bw.this.c.setAnchorY(Math.max(0, Math.min(bw.this.aU, bw.this.h)));
                            bw.this.f.setProjectionCenter(1, bw.this.c.getAnchorX(), bw.this.c.getAnchorY());
                            bw.this.at = true;
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapTextZIndex(int i2) throws RemoteException {
        this.au = i2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapTextZIndex() throws RemoteException {
        return this.au;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void reloadMap() {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRenderFps(int i2) {
        try {
            this.ay = Math.max(10, Math.min(i2, 40));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setIndoorBuildingInfo(IndoorBuildingInfo indoorBuildingInfo) throws RemoteException {
        if (!this.V && indoorBuildingInfo != null && indoorBuildingInfo.activeFloorName != null && indoorBuildingInfo.poiid != null) {
            this.d = (dq) indoorBuildingInfo;
            resetRenderTime();
            queueEvent(new Runnable() {
                /* class com.amap.api.col.stln3.bw.AnonymousClass24 */

                public final void run() {
                    if (bw.this.f != null) {
                        bw.this.f.setIndoorBuildingToBeActive(1, bw.this.d.activeFloorName, bw.this.d.activeFloorIndex, bw.this.d.poiid);
                    }
                }
            });
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setAMapGestureListener(AMapGestureListener aMapGestureListener) {
        ck ckVar = this.aE;
        if (ckVar != null) {
            this.I = aMapGestureListener;
            ckVar.d = aMapGestureListener;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getZoomToSpanLevel(LatLng latLng, LatLng latLng2) {
        MapConfig mapConfig = getMapConfig();
        if (latLng == null || latLng2 == null || !this.aN || this.V) {
            return mapConfig.getSZ();
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(latLng);
        builder.include(latLng2);
        GLMapState gLMapState = new GLMapState(1, this.f.getNativeInstance());
        Pair<Float, IPoint> a2 = ic.a(mapConfig, 0, 0, 0, 0, builder.build(), getMapWidth(), getMapHeight());
        gLMapState.recycle();
        if (a2 != null) {
            return ((Float) a2.first).floatValue();
        }
        return gLMapState.getMapZoomer();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Pair<Float, LatLng> calculateZoomToSpanLevel(int i2, int i3, int i4, int i5, LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null && i2 == i3 && i3 == i4 && i4 == i5 && latLng.latitude == latLng2.latitude && latLng.longitude == latLng2.longitude) {
            return new Pair<>(Float.valueOf(getMaxZoomLevel()), latLng);
        }
        MapConfig mapConfig = getMapConfig();
        if (latLng == null || latLng2 == null || !this.aN || this.V) {
            DPoint obtain = DPoint.obtain();
            GLMapState.geo2LonLat(mapConfig.getSX(), mapConfig.getSY(), obtain);
            Pair<Float, LatLng> pair = new Pair<>(Float.valueOf(mapConfig.getSZ()), new LatLng(obtain.y, obtain.x));
            obtain.recycle();
            return pair;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(latLng);
        builder.include(latLng2);
        GLMapState gLMapState = new GLMapState(1, this.f.getNativeInstance());
        Pair<Float, IPoint> a2 = ic.a(mapConfig, i2, i3, i4, i5, builder.build(), getMapWidth(), getMapHeight());
        gLMapState.recycle();
        if (a2 == null) {
            return null;
        }
        DPoint obtain2 = DPoint.obtain();
        GLMapState.geo2LonLat(((IPoint) a2.second).x, ((IPoint) a2.second).y, obtain2);
        Pair<Float, LatLng> pair2 = new Pair<>(a2.first, new LatLng(obtain2.y, obtain2.x));
        obtain2.recycle();
        return pair2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final InfoWindowAnimationManager getInfoWindowAnimationManager() {
        return new InfoWindowAnimationManager(this.K);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMaskLayerParams(int i2, int i3, int i4, int i5, final int i6, long j2) {
        GLAlphaAnimation gLAlphaAnimation;
        try {
            if (this.aw != null) {
                float f2 = ((float) i5) / 255.0f;
                if (i6 == -1) {
                    gLAlphaAnimation = new GLAlphaAnimation(f2, 0.0f);
                    gLAlphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                        /* class com.amap.api.col.stln3.bw.AnonymousClass25 */

                        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
                        public final void onAnimationStart() {
                        }

                        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
                        public final void onAnimationEnd() {
                            bw.this.i.post(new Runnable() {
                                /* class com.amap.api.col.stln3.bw.AnonymousClass25.AnonymousClass1 */

                                public final void run() {
                                    bw.this.ax = i6;
                                    if (bw.this.Q != null) {
                                        bw.this.Q.j().setVisibility(0);
                                    }
                                }
                            });
                        }
                    });
                } else {
                    this.ax = i6;
                    gLAlphaAnimation = new GLAlphaAnimation(0.0f, f2);
                    if (f2 > 0.2f) {
                        if (this.Q != null) {
                            this.Q.j().setVisibility(4);
                        }
                    } else if (this.Q != null) {
                        this.Q.j().setVisibility(0);
                    }
                }
                gLAlphaAnimation.setInterpolator(new LinearInterpolator());
                gLAlphaAnimation.setDuration(j2);
                this.aw.a(i2, i3, i4, i5);
                this.aw.a(gLAlphaAnimation);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMaxZoomLevel(float f2) {
        this.c.setMaxZoomLevel(f2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMinZoomLevel(float f2) {
        this.c.setMinZoomLevel(f2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void resetMinMaxZoomPreference() {
        this.c.resetMinMaxZoomPreference();
        try {
            if (this.N.isZoomControlsEnabled() && this.c.isNeedUpdateZoomControllerState()) {
                this.X.invalidateZoomController(this.c.getSZ());
            }
        } catch (RemoteException e2) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapStatusLimits(LatLngBounds latLngBounds) {
        try {
            this.c.setLimitLatLngBounds(latLngBounds);
            try {
                LatLngBounds limitLatLngBounds = this.c.getLimitLatLngBounds();
                if (this.f != null) {
                    if ((limitLatLngBounds == null || limitLatLngBounds.northeast == null || limitLatLngBounds.southwest == null) ? false : true) {
                        GLMapState gLMapState = new GLMapState(1, this.f.getNativeInstance());
                        IPoint obtain = IPoint.obtain();
                        GLMapState.lonlat2Geo(limitLatLngBounds.northeast.longitude, limitLatLngBounds.northeast.latitude, obtain);
                        IPoint obtain2 = IPoint.obtain();
                        GLMapState.lonlat2Geo(limitLatLngBounds.southwest.longitude, limitLatLngBounds.southwest.latitude, obtain2);
                        this.c.setLimitIPoints(new IPoint[]{obtain, obtain2});
                        gLMapState.recycle();
                        return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.c.setLimitIPoints(null);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Handler getMainHandler() {
        return this.i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onChangeFinish() {
        Message obtainMessage = this.i.obtainMessage();
        obtainMessage.what = 11;
        this.i.sendMessage(obtainMessage);
    }

    /* access modifiers changed from: protected */
    public final void a(CameraPosition cameraPosition) {
        MapConfig mapConfig = this.c;
        if (mapConfig != null && mapConfig.getChangedCounter() != 0) {
            try {
                if (!this.aK && this.f.getAnimateionsCount() == 0 && this.f.getStateMessageCount() == 0) {
                    this.c.resetChangedCounter();
                    if (this.I != null) {
                        this.I.onMapStable();
                    }
                    if (this.x != null && this.P.isEnabled()) {
                        if (cameraPosition == null) {
                            try {
                                cameraPosition = getCameraPosition();
                            } catch (Throwable th) {
                                rx.c(th, "AMapDelegateImp", "cameraChangeFinish");
                                th.printStackTrace();
                            }
                        }
                        this.x.onCameraChangeFinish(cameraPosition);
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setZoomScaleParam(float f2) {
        this.aH = f2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onFling() {
        db dbVar = this.R;
        if (dbVar != null) {
            dbVar.b(true);
        }
        this.aj = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapWidth() {
        return this.g;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapHeight() {
        return this.h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getCameraAngle() {
        int i2 = this.U;
        return v();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getSkyHeight() {
        return this.c.getSkyHeight();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isMaploaded() {
        return this.aa;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final MapConfig getMapConfig() {
        return this.c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final View getView() throws RemoteException {
        return this.Q;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setZOrderOnTop(boolean z2) throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onIndoorBuildingActivity(int i2, byte[] bArr) {
        dq dqVar;
        if (bArr != null) {
            try {
                dqVar = new dq();
                byte b2 = bArr[0];
                dqVar.a = new String(bArr, 1, b2, "utf-8");
                int i3 = b2 + 1;
                int i4 = i3 + 1;
                byte b3 = bArr[i3];
                dqVar.b = new String(bArr, i4, b3, "utf-8");
                int i5 = i4 + b3;
                int i6 = i5 + 1;
                byte b4 = bArr[i5];
                dqVar.activeFloorName = new String(bArr, i6, b4, "utf-8");
                int i7 = i6 + b4;
                dqVar.activeFloorIndex = GLConvertUtil.getInt(bArr, i7);
                int i8 = i7 + 4;
                int i9 = i8 + 1;
                byte b5 = bArr[i8];
                dqVar.poiid = new String(bArr, i9, b5, "utf-8");
                int i10 = i9 + b5;
                int i11 = i10 + 1;
                byte b6 = bArr[i10];
                dqVar.h = new String(bArr, i11, b6, "utf-8");
                int i12 = i11 + b6;
                dqVar.c = GLConvertUtil.getInt(bArr, i12);
                dqVar.floor_indexs = new int[dqVar.c];
                dqVar.floor_names = new String[dqVar.c];
                dqVar.d = new String[dqVar.c];
                int i13 = i12 + 4;
                for (int i14 = 0; i14 < dqVar.c; i14++) {
                    dqVar.floor_indexs[i14] = GLConvertUtil.getInt(bArr, i13);
                    int i15 = i13 + 4;
                    int i16 = i15 + 1;
                    byte b7 = bArr[i15];
                    if (b7 > 0) {
                        dqVar.floor_names[i14] = new String(bArr, i16, b7, "utf-8");
                        i16 += b7;
                    }
                    i13 = i16 + 1;
                    byte b8 = bArr[i16];
                    if (b8 > 0) {
                        dqVar.d[i14] = new String(bArr, i13, b8, "utf-8");
                        i13 += b8;
                    }
                }
                dqVar.e = GLConvertUtil.getInt(bArr, i13);
                int i17 = i13 + 4;
                if (dqVar.e > 0) {
                    dqVar.f = new int[dqVar.e];
                    for (int i18 = 0; i18 < dqVar.e; i18++) {
                        dqVar.f[i18] = GLConvertUtil.getInt(bArr, i17);
                        i17 += 4;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        } else {
            dqVar = null;
        }
        this.bn = dqVar;
        AnonymousClass26 r8 = new Runnable() {
            /* class com.amap.api.col.stln3.bw.AnonymousClass26 */

            public final void run() {
                if (bw.this.aV != null) {
                    bw.this.aV.a(bw.this.bn);
                }
            }
        };
        if (this.P != null) {
            this.P.post(r8);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final AMapCameraInfo getCamerInfo() {
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void destroy() {
        this.V = true;
        try {
            if (this.aC != null) {
                this.aC.a();
            }
            if (this.aY != null) {
                this.aY.b();
            }
            if (this.ac != null) {
                this.ac.deactivate();
            }
            this.ac = null;
            this.aV = null;
            if (this.aD != null) {
                this.aD.renderPause();
            }
            if (this.aX != null) {
                this.aX.d();
            }
            if (this.aE != null) {
                this.aE.d = null;
                this.aE.b();
                this.aE = null;
            }
            if (this.S != null) {
                this.S.c();
            }
            if (this.b != null) {
                this.b.h();
            }
            int i2 = 0;
            if (this.R != null) {
                db dbVar = this.R;
                dbVar.c();
                if (dbVar.d != null) {
                    dbVar.d.c();
                    dbVar.d.destroy(false);
                }
                dbVar.d = null;
            }
            E();
            if (this.ap != null) {
                this.ap.interrupt();
                this.ap = null;
            }
            if (this.aq != null) {
                this.aq.interrupt();
                this.aq = null;
            }
            if (this.aA != null) {
                this.aA.a();
                this.aA = null;
            }
            if (this.aB != null) {
                this.aB.a((gu.a) null);
                this.aB.a();
                this.aB = null;
            }
            hn.b();
            if (this.f != null) {
                this.f.setMapListener(null);
                this.f.releaseNetworkState();
                queueEvent(new Runnable() {
                    /* class com.amap.api.col.stln3.bw.AnonymousClass27 */

                    public final void run() {
                        try {
                            if (bw.this.aX != null) {
                                bw.this.aX.c();
                            }
                            if (bw.this.aW != null) {
                                bw.this.aW.b();
                                bw.this.aW = null;
                            }
                            if (bw.this.f != null) {
                                bw.this.f.destroyAMapEngine();
                                bw.this.f = null;
                            }
                            bw.this.W.d();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                while (this.f != null) {
                    int i3 = i2 + 1;
                    if (i2 >= 20) {
                        break;
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e2) {
                    }
                    i2 = i3;
                }
            }
            if (this.W != null) {
                this.W.c();
            }
            if (this.J != null) {
                this.J.b();
            }
            if (this.P != null) {
                try {
                    this.P.b();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (this.Q != null) {
                this.Q.k();
                this.Q = null;
            }
            if (this.ab != null) {
                this.ab.b();
                this.ab = null;
            }
            this.ac = null;
            this.E = null;
            this.t = null;
            this.u = null;
            this.v = null;
            this.w = null;
            this.x = null;
            this.y = null;
            this.z = null;
            this.A = null;
            this.B = null;
            this.C = null;
            this.D = null;
            this.F = null;
            this.G = null;
            this.H = null;
            this.ao = null;
            rx.b();
        } catch (Throwable th) {
            rx.c(th, "AMapDelegateImp", "destroy");
            th.printStackTrace();
        }
    }

    /* compiled from: AMapDelegateImp */
    private class c implements im.a {
        private c() {
        }

        /* synthetic */ c(bw bwVar, byte b) {
            this();
        }

        @Override // com.amap.api.col.stln3.im.a
        public final void a(int i) {
            if (bw.this.d != null) {
                bw.this.d.activeFloorIndex = bw.this.d.floor_indexs[i];
                bw.this.d.activeFloorName = bw.this.d.floor_names[i];
                try {
                    bw.this.setIndoorBuildingInfo(bw.this.d);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp */
    public class b {
        b() {
        }

        public final void a(dq dqVar) {
            if (bw.this.c != null && bw.this.c.isIndoorEnable()) {
                final im g = bw.this.Q.g();
                float f = 20.0f;
                if (dqVar == null) {
                    try {
                        if (bw.this.D != null) {
                            bw.this.D.OnIndoorBuilding(dqVar);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (bw.this.d != null) {
                        bw.this.d.g = null;
                    }
                    if (g.b()) {
                        bw.this.i.post(new Runnable() {
                            /* class com.amap.api.col.stln3.bw.b.AnonymousClass1 */

                            public final void run() {
                                g.a(false);
                            }
                        });
                    }
                    bw.this.c.maxZoomLevel = bw.this.c.isSetLimitZoomLevel() ? bw.this.c.getMaxZoomLevel() : 20.0f;
                    try {
                        if (bw.this.N.isZoomControlsEnabled()) {
                            bw.this.X.invalidateZoomController(bw.this.c.getSZ());
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                if (dqVar == null || bw.this.d == null || !bw.this.d.poiid.equals(dqVar.poiid) || !g.b()) {
                    if (dqVar != null && (bw.this.d == null || !bw.this.d.poiid.equals(dqVar.poiid) || bw.this.d.g == null)) {
                        bw bwVar = bw.this;
                        bwVar.d = dqVar;
                        if (bwVar.c != null) {
                            bw.this.d.g = bw.this.c.getMapGeoCenter();
                        }
                    }
                    try {
                        if (bw.this.D != null) {
                            bw.this.D.OnIndoorBuilding(dqVar);
                        }
                        MapConfig mapConfig = bw.this.c;
                        if (bw.this.c.isSetLimitZoomLevel()) {
                            f = bw.this.c.getMaxZoomLevel();
                        }
                        mapConfig.maxZoomLevel = f;
                        if (bw.this.N.isZoomControlsEnabled()) {
                            bw.this.X.invalidateZoomController(bw.this.c.getSZ());
                        }
                        if (bw.this.N.isIndoorSwitchEnabled()) {
                            if (!g.b()) {
                                bw.this.N.setIndoorSwitchEnabled(true);
                            }
                            bw.this.i.post(new Runnable() {
                                /* class com.amap.api.col.stln3.bw.b.AnonymousClass2 */

                                public final void run() {
                                    try {
                                        g.a(bw.this.d.floor_names);
                                        g.a(bw.this.d.activeFloorName);
                                        if (!g.b()) {
                                            g.a(true);
                                        }
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                            });
                        } else if (!bw.this.N.isIndoorSwitchEnabled() && g.b()) {
                            bw.this.N.setIndoorSwitchEnabled(false);
                        }
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMapListener
    public final void beforeDrawLabel(int i2, GLMapState gLMapState) {
        F();
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.S.a(true, this.au);
        GLMapEngine gLMapEngine2 = this.f;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMapListener
    public final void afterDrawLabel(int i2, GLMapState gLMapState) {
        F();
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.R.b();
        this.S.a(false, this.au);
        dx dxVar = this.aY;
        if (dxVar != null) {
            dxVar.a(this.c, getViewMatrix(), getProjectionMatrix());
        }
        cj cjVar = this.W;
        if (cjVar != null) {
            cjVar.a();
        }
        cu cuVar = this.b;
        if (cuVar != null) {
            cuVar.b();
        }
        gm gmVar = this.K;
        if (gmVar != null) {
            gmVar.a(getMapWidth(), getMapHeight());
        }
        GLMapEngine gLMapEngine2 = this.f;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMapListener
    public final void afterDrawFrame(int i2, GLMapState gLMapState) {
        float mapZoomer = gLMapState.getMapZoomer();
        GLMapEngine gLMapEngine = this.f;
        if (!(gLMapEngine != null && (gLMapEngine.isInMapAction(i2) || this.f.isInMapAnimation(i2)))) {
            int i3 = this.ay;
            if (i3 != -1) {
                this.aD.setRenderFps((float) i3);
            } else {
                this.aD.setRenderFps(15.0f);
            }
            if (this.aM == 1) {
                this.aM = 0;
            }
            if (this.aG != mapZoomer) {
                this.aG = mapZoomer;
            }
        }
        if (!this.aQ) {
            this.aQ = true;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMapListener
    public final void afterAnimation() {
        m();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final long createGLOverlay(int i2) {
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            return gLMapEngine.createOverlay(1, i2);
        }
        return 0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final long getGlOverlayMgrPtr() {
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            return gLMapEngine.getGlOverlayMgrPtr(1);
        }
        return 0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final CrossOverlay addCrossVector(CrossOverlayOptions crossOverlayOptions) {
        if (crossOverlayOptions == null || crossOverlayOptions.getRes() == null) {
            return null;
        }
        CrossVectorOverlay crossVectorOverlay = new CrossVectorOverlay(1, this.e, this);
        if (crossOverlayOptions != null) {
            crossVectorOverlay.setAttribute(crossOverlayOptions.getAttribute());
        }
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            gLMapEngine.getOverlayBundle(1).addOverlay(crossVectorOverlay);
            crossVectorOverlay.resumeMarker(crossOverlayOptions.getRes());
        }
        return new CrossOverlay(crossOverlayOptions, crossVectorOverlay);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final RouteOverlay addNaviRouteOverlay() {
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOverlayTexture(int i2, GLTextureProperty gLTextureProperty) {
        GLOverlayBundle overlayBundle;
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null && (overlayBundle = gLMapEngine.getOverlayBundle(i2)) != null && gLTextureProperty != null && gLTextureProperty.mBitmap != null) {
            this.f.addOverlayTexture(i2, gLTextureProperty);
            overlayBundle.addOverlayTextureItem(gLTextureProperty.mId, gLTextureProperty.mAnchor, gLTextureProperty.mXRatio, gLTextureProperty.mYRatio, gLTextureProperty.mBitmap.getWidth(), gLTextureProperty.mBitmap.getHeight());
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomMapStylePath(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.c.getCustomStylePath())) {
            this.c.setCustomStylePath(str);
            this.O = true;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomMapStyleID(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.c.getCustomStyleID())) {
            this.c.setCustomStyleID(str);
            this.O = true;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomTextureResourcePath(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.c.setCustomTextureResourcePath(str);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomMapStyle(CustomMapStyleOptions customMapStyleOptions) {
        if (customMapStyleOptions != null) {
            if (customMapStyleOptions.isEnable()) {
                I();
            }
            this.aZ.c();
            this.aZ.a(customMapStyleOptions);
        }
        resetRenderTime();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final MyLocationStyle getMyLocationStyle() throws RemoteException {
        gh ghVar = this.ab;
        if (ghVar != null) {
            return ghVar.a();
        }
        return null;
    }

    @Override // com.amap.api.col.stln3.co
    public final void z() {
        bv bvVar = this.aZ;
        if (bvVar != null) {
            bvVar.b();
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final void a(boolean z2, boolean z3) {
        boolean z4;
        if (!this.aN || this.V) {
            a aVar = this.bd;
            aVar.b = true;
            aVar.c = z2;
            return;
        }
        if (z3) {
            z4 = z3;
        } else {
            z4 = false;
        }
        if (!TextUtils.isEmpty(this.c.getCustomStylePath()) || !TextUtils.isEmpty(this.c.getCustomStyleID())) {
            if (z2) {
                try {
                    if (this.c.isProFunctionAuthEnable() && !TextUtils.isEmpty(this.c.getCustomStyleID())) {
                        if (this.aA != null) {
                            this.aA.a(this.c.getCustomStyleID());
                            this.aA.b();
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            if (!z3 && !this.O) {
                if (!(this.c.isCustomStyleEnable() ^ z2)) {
                    this.O = false;
                }
            }
            a(z2, (byte[]) null, z4);
            this.O = false;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapCustomEnable(boolean z2) {
        if (z2) {
            I();
        }
        a(z2, false);
    }

    @Override // com.amap.api.col.stln3.co
    public final void a(boolean z2, byte[] bArr) {
        a(z2, bArr, false);
    }

    private void a(boolean z2, byte[] bArr, boolean z3) {
        ha haVar;
        this.c.setCustomStyleEnable(z2);
        if (this.c.isHideLogoEnable()) {
            this.N.setLogoEnable(!z2);
        }
        boolean z4 = false;
        if (z2) {
            c(1, true);
            Context context = this.e;
            gz gzVar = new gz();
            MyTrafficStyle myTrafficStyle = this.ao;
            if (!(myTrafficStyle == null || myTrafficStyle.getTrafficRoadBackgroundColor() == -1)) {
                gzVar.a(this.ao.getTrafficRoadBackgroundColor());
            }
            if (this.c.isProFunctionAuthEnable() && !TextUtils.isEmpty(this.c.getCustomTextureResourcePath())) {
                z4 = true;
            }
            StyleItem[] styleItemArr = null;
            if (bArr != null) {
                haVar = gzVar.a(bArr, z4);
                if (!(haVar == null || (styleItemArr = haVar.c()) == null)) {
                    this.c.setUseProFunction(true);
                }
            } else {
                haVar = null;
            }
            if (styleItemArr == null && (haVar = gzVar.a(this.c.getCustomStylePath(), z4)) != null) {
                styleItemArr = haVar.c();
            }
            if (gzVar.a() != 0) {
                this.c.setCustomBackgroundColor(gzVar.a());
            }
            if (haVar == null || haVar.d() == null) {
                a(styleItemArr, z3);
            } else if (this.aB != null) {
                this.aB.a((String) haVar.d());
                this.aB.a(haVar);
                this.aB.b();
            }
        } else {
            c(1, false);
            a(1, this.c.getMapStyleMode(), this.c.getMapStyleTime(), this.c.getMapStyleState(), true, false, null);
        }
    }

    @Override // com.amap.api.col.stln3.gu.a
    public final void a(String str, ha haVar) {
        setCustomTextureResourcePath(str);
        if (this.c.isCustomStyleEnable() && haVar != null) {
            a(haVar.c(), false);
        }
    }

    private void a(StyleItem[] styleItemArr, boolean z2) {
        if (z2 || (styleItemArr != null && styleItemArr.length > 0)) {
            a(1, 0, 0, 0, true, true, styleItemArr);
            ia.a(this.e, true);
            return;
        }
        ia.a(this.e, false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeEngineGLOverlay(BaseMapOverlay baseMapOverlay) {
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            gLMapEngine.getOverlayBundle(1).removeOverlay(baseMapOverlay);
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final float[] A() {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return mapConfig.getMvpMatrix();
        }
        return this.m;
    }

    @Override // com.amap.api.col.stln3.co
    public final String d(String str) {
        cm cmVar = this.S;
        if (cmVar != null) {
            return cmVar.a(str);
        }
        return null;
    }

    @Override // com.amap.api.col.stln3.co
    public final void f(boolean z2) {
        if (!this.V) {
            this.Q.f(z2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float[] getViewMatrix() {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return mapConfig.getViewMatrix();
        }
        return this.n;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float[] getProjectionMatrix() {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return mapConfig.getProjectionMatrix();
        }
        return this.o;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void changeSurface(GL10 gl10, int i2, int i3) {
        int i4;
        try {
            this.aQ = false;
            if (!this.aN) {
                a(gl10, (EGLConfig) null);
            }
            this.g = i2;
            this.h = i3;
            this.at = true;
            this.am = new Rect(0, 0, i2, i3);
            Rect rect = new Rect(0, 0, this.g, this.h);
            int i5 = this.g;
            int i6 = this.h;
            if (this.f != null) {
                i4 = this.f.getEngineIDWithType(1);
                if (!this.f.isEngineCreated(i4)) {
                    int i7 = this.e.getResources().getDisplayMetrics().densityDpi;
                    float f2 = this.e.getResources().getDisplayMetrics().density;
                    this.aH = GLMapState.calMapZoomScalefactor(i5, i6, i7);
                    GLMapEngine.MapViewInitParam mapViewInitParam = new GLMapEngine.MapViewInitParam();
                    mapViewInitParam.engineId = i4;
                    mapViewInitParam.x = rect.left;
                    mapViewInitParam.y = rect.top;
                    mapViewInitParam.width = rect.width();
                    mapViewInitParam.height = rect.height();
                    mapViewInitParam.screenWidth = i5;
                    mapViewInitParam.screenHeight = i6;
                    mapViewInitParam.screenScale = f2;
                    mapViewInitParam.textScale = this.aI * f2;
                    mapViewInitParam.mapZoomScale = this.aH;
                    this.f.createAMapEngineWithFrame(mapViewInitParam);
                    GLMapState mapState = this.f.getMapState(i4);
                    mapState.setMapZoomer(this.c.getSZ());
                    mapState.setCameraDegree(this.c.getSC());
                    mapState.setMapAngle(this.c.getSR());
                    mapState.setMapGeoCenter(this.c.getSX(), this.c.getSY());
                    this.f.setMapState(i4, mapState);
                    this.f.setOvelayBundle(i4, new GLOverlayBundle<>(i4, this));
                } else {
                    int i8 = rect.left;
                    int i9 = rect.top;
                    int width = rect.width();
                    int height = rect.height();
                    if (this.f != null) {
                        this.f.setServiceViewRect(i4, i8, i9, width, height, i5, i6);
                    }
                }
            } else {
                i4 = 0;
            }
            this.U = i4;
            if (!this.aO) {
                if (this.c != null) {
                    this.c.setMapZoomScale(this.aH);
                    this.c.setMapWidth(i2);
                    this.c.setMapHeight(i3);
                }
                this.f.setIndoorEnable(this.U, false);
                this.f.setSimple3DEnable(this.U, false);
            }
            if (this.aC != null) {
                this.aC.a(new cw());
            }
            synchronized (this) {
                this.aO = true;
            }
            if (!this.Z) {
                this.c.setAnchorX(i2 >> 1);
                this.c.setAnchorY(i3 >> 1);
            } else {
                this.c.setAnchorX(Math.max(1, Math.min(this.aT, i2 - 1)));
                this.c.setAnchorY(Math.max(1, Math.min(this.aU, i3 - 1)));
            }
            this.f.setProjectionCenter(this.U, this.c.getAnchorX(), this.c.getAnchorY());
            this.a = true;
            if (this.bg.b) {
                this.bg.run();
            }
            if (this.bc.b) {
                this.bc.run();
            }
            if (this.bd.b) {
                this.bd.run();
            }
            if (this.ba.b) {
                this.ba.run();
            }
            if (this.be.b) {
                this.be.run();
            }
            if (this.bj.b) {
                this.bj.run();
            }
            if (this.bf.b) {
                this.bf.run();
            }
            if (this.bh.b) {
                this.bh.run();
            }
            if (this.bb.b) {
                this.bb.run();
            }
            if (this.bk.b) {
                this.bk.run();
            }
            if (this.av != null) {
                this.av.onSurfaceChanged(gl10, i2, i3);
            }
            if (this.i != null) {
                this.i.post(this.bi);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void createSurface(GL10 gl10, EGLConfig eGLConfig) {
        try {
            a(gl10, eGLConfig);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void renderSurface(GL10 gl10) {
        drawFrame(gl10);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean canStopMapRender() {
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            gLMapEngine.canStopMapRender(1);
        }
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void getLatLngRect(DPoint[] dPointArr) {
        try {
            Rectangle geoRectangle = this.c.getGeoRectangle();
            if (geoRectangle != null) {
                IPoint[] clipRect = geoRectangle.getClipRect();
                for (int i2 = 0; i2 < 4; i2++) {
                    GLMapState.geo2LonLat(clipRect[i2].x, clipRect[i2].y, dPointArr[i2]);
                }
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void checkMapState(GLMapState gLMapState) {
        IPoint[] iPointArr;
        MapConfig mapConfig = this.c;
        if (mapConfig != null && !this.V) {
            LatLngBounds limitLatLngBounds = mapConfig.getLimitLatLngBounds();
            if (limitLatLngBounds != null) {
                try {
                    IPoint[] limitIPoints = this.c.getLimitIPoints();
                    if (limitIPoints == null) {
                        IPoint obtain = IPoint.obtain();
                        GLMapState.lonlat2Geo(limitLatLngBounds.northeast.longitude, limitLatLngBounds.northeast.latitude, obtain);
                        IPoint obtain2 = IPoint.obtain();
                        GLMapState.lonlat2Geo(limitLatLngBounds.southwest.longitude, limitLatLngBounds.southwest.latitude, obtain2);
                        iPointArr = new IPoint[]{obtain, obtain2};
                        this.c.setLimitIPoints(iPointArr);
                    } else {
                        iPointArr = limitIPoints;
                    }
                    float a2 = ic.a(this.c, iPointArr[0].x, iPointArr[0].y, iPointArr[1].x, iPointArr[1].y, getMapWidth(), getMapHeight());
                    float mapZoomer = gLMapState.getMapZoomer();
                    if (this.c.isSetLimitZoomLevel()) {
                        float maxZoomLevel = this.c.getMaxZoomLevel();
                        float minZoomLevel = this.c.getMinZoomLevel();
                        if (a2 < maxZoomLevel) {
                            if (a2 > minZoomLevel) {
                                a2 = Math.max(a2, Math.min(mapZoomer, maxZoomLevel));
                            }
                        }
                    } else if (a2 <= 0.0f || mapZoomer >= a2) {
                        a2 = mapZoomer;
                    }
                    gLMapState.setMapZoomer(a2);
                    IPoint obtain3 = IPoint.obtain();
                    gLMapState.getMapGeoCenter(obtain3);
                    int i2 = obtain3.x;
                    int i3 = obtain3.y;
                    int[] a3 = ic.a(iPointArr[0].x, iPointArr[0].y, iPointArr[1].x, iPointArr[1].y, this.c, gLMapState, i2, i3);
                    if (a3 != null && a3.length == 2) {
                        i2 = a3[0];
                        i3 = a3[1];
                    }
                    gLMapState.setMapGeoCenter(i2, i3);
                    obtain3.recycle();
                } catch (Throwable th) {
                }
            } else if (this.c.isSetLimitZoomLevel()) {
                gLMapState.setMapZoomer(Math.max(this.c.getMinZoomLevel(), Math.min(gLMapState.getMapZoomer(), this.c.getMaxZoomLevel())));
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRenderMode(int i2) {
        cp cpVar = this.P;
        if (cpVar != null) {
            cpVar.setRenderMode(i2);
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final gp k(int i2) {
        gq gqVar = this.aW;
        if (gqVar == null) {
            return null;
        }
        return gqVar.a(i2);
    }

    @Override // com.amap.api.col.stln3.co
    public final gq B() {
        return this.aW;
    }

    @Override // com.amap.api.col.stln3.co
    public final void a(int i2, int i3) {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            this.g = i2;
            this.h = i3;
            mapConfig.setMapWidth(i2);
            this.c.setMapHeight(i3);
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final void g(boolean z2) {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            mapConfig.setHideLogoEnble(z2);
            if (this.c.isCustomStyleEnable()) {
                this.N.setLogoEnable(!z2);
            }
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final void a(String str, boolean z2, int i2) {
        io ioVar = this.Q;
        if (ioVar != null) {
            ioVar.a(str, z2, i2);
        }
        dc dcVar = this.N;
        if (dcVar != null) {
            dcVar.requestRefreshLogo();
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final void C() {
        io ioVar = this.Q;
        if (ioVar != null) {
            ioVar.e();
        }
    }

    @Override // com.amap.api.col.stln3.co
    public final float l(int i2) {
        GLMapState gLMapState = new GLMapState(1, this.f.getNativeInstance());
        gLMapState.setMapZoomer((float) i2);
        gLMapState.recalculate();
        float gLUnitWithWin = gLMapState.getGLUnitWithWin(1);
        gLMapState.recycle();
        return gLUnitWithWin;
    }
}
