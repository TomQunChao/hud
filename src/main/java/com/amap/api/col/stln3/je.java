package com.amap.api.col.stln3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.a11hud.www.R;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.navi.AMapNaviViewOptions;
import com.amap.api.navi.core.view.BaseNaviView;
import com.amap.api.navi.view.PoiInputSearchWidget;
import com.amap.api.services.core.AMapException;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: CarOverlay */
public final class je {
    protected final int A = PoiInputSearchWidget.DEF_ANIMATION_DURATION;
    protected int B = AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING;
    protected BaseNaviView C;
    boolean D = true;
    private ScheduledExecutorService E;
    protected int a = 2;
    protected boolean b = true;
    protected IPoint c = null;
    protected double d;
    protected double e;
    protected float f;
    protected int g;
    protected float h = 0.0f;
    protected boolean i = false;
    protected float j = 0.0f;
    protected int k = -1;
    protected BitmapDescriptor l = null;
    protected BitmapDescriptor m = null;
    protected Marker n;
    protected Marker o;
    protected Marker p;
    protected AMap q = null;
    protected TextureMapView r;
    protected boolean s = true;
    protected LatLng t = null;
    protected Polyline u = null;
    protected List<LatLng> v = new ArrayList();
    protected Bitmap w;
    protected Bitmap x;
    protected float y;
    protected int z = 0;

    static /* synthetic */ void a(je jeVar) {
        Marker marker;
        if (jeVar.i && (marker = jeVar.n) != null && jeVar.q != null) {
            try {
                IPoint geoPoint = marker.getGeoPoint();
                int i2 = jeVar.g;
                jeVar.g = i2 + 1;
                if (i2 < jeVar.a) {
                    double d2 = ((double) jeVar.c.x) + (jeVar.d * ((double) jeVar.g));
                    double d3 = ((double) jeVar.c.y) + (jeVar.e * ((double) jeVar.g));
                    jeVar.j = jeVar.h + (jeVar.f * ((float) jeVar.g));
                    jeVar.j %= (float) jeVar.B;
                    if (d2 == 0.0d) {
                        if (d3 != 0.0d) {
                        }
                        jeVar.a(geoPoint);
                    }
                    geoPoint = new IPoint((int) d2, (int) d3);
                    jeVar.a(geoPoint);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                rx.c(th, "NaviCarOverlay", "drawLeaderLine(IPoint nowPoint");
            }
        }
    }

    public je(TextureMapView textureMapView, BaseNaviView baseNaviView) {
        this.r = textureMapView;
        this.C = baseNaviView;
        this.m = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.backgroundStacked));
        this.l = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.arrowShaftLength));
    }

    public final void a() {
        Marker marker;
        if (this.b && (marker = this.o) != null) {
            this.q.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(marker.getPosition(), this.C.getZoom(), 0.0f, 0.0f)));
            this.n.setRotateAngle(360.0f - this.j);
        }
    }

    public final void b() {
        Marker marker;
        if (this.b && (marker = this.o) != null) {
            this.q.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(marker.getPosition(), this.C.getZoom(), (float) this.C.getLockTilt(), this.j)));
            this.n.setRotateAngle(0.0f);
        }
    }

    public final void a(boolean z2) {
        this.b = z2;
        Marker marker = this.n;
        if (marker != null && this.q != null && this.p != null && this.o != null) {
            if (!this.b) {
                marker.setFlat(true);
                this.p.setGeoPoint(this.o.getGeoPoint());
                this.n.setGeoPoint(this.o.getGeoPoint());
                this.n.setRotateAngle(this.o.getRotateAngle());
            } else if (this.C.getNaviMode() == 1) {
                this.q.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(this.o.getPosition()).bearing(0.0f).tilt(0.0f).zoom(this.C.getZoom()).build()));
                this.n.setPositionByPixels((int) (((double) this.r.getWidth()) * this.C.getAnchorX()), (int) (((double) this.r.getHeight()) * this.C.getAnchorY()));
                this.n.setFlat(true);
                if (this.s) {
                    this.p.setVisible(true);
                } else {
                    this.p.setVisible(false);
                }
            } else {
                this.q.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(this.o.getPosition()).bearing(this.j).tilt((float) this.C.getLockTilt()).zoom(this.C.getZoom()).build()));
                this.n.setPositionByPixels((int) (((double) this.r.getWidth()) * this.C.getAnchorX()), (int) (((double) this.r.getHeight()) * this.C.getAnchorY()));
                this.n.setFlat(true);
                if (this.s) {
                    this.p.setVisible(true);
                } else {
                    this.p.setVisible(false);
                }
            }
        }
    }

    public final void c() {
        Marker marker = this.n;
        if (marker != null) {
            marker.remove();
        }
        Marker marker2 = this.p;
        if (marker2 != null) {
            marker2.remove();
        }
        Marker marker3 = this.o;
        if (marker3 != null) {
            marker3.remove();
        }
        Polyline polyline = this.u;
        if (polyline != null) {
            polyline.remove();
        }
        this.u = null;
        this.n = null;
        this.p = null;
        this.o = null;
        ScheduledExecutorService scheduledExecutorService = this.E;
        if (scheduledExecutorService != null) {
            if (!scheduledExecutorService.isShutdown()) {
                this.E.shutdown();
            }
            this.i = false;
            this.E = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x012d A[Catch:{ Throwable -> 0x0186 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x012f A[Catch:{ Throwable -> 0x0186 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x013a A[Catch:{ Throwable -> 0x0186 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0142 A[Catch:{ Throwable -> 0x0186 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0144 A[Catch:{ Throwable -> 0x0186 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.amap.api.maps.AMap r12, com.amap.api.maps.model.LatLng r13, float r14) {
        /*
        // Method dump skipped, instructions count: 404
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.je.a(com.amap.api.maps.AMap, com.amap.api.maps.model.LatLng, float):void");
    }

    private void a(IPoint iPoint) {
        boolean z2;
        int i2;
        AMapNaviViewOptions viewOptions = this.C.getViewOptions();
        if (viewOptions != null) {
            z2 = viewOptions.isSensorEnable();
        } else {
            z2 = true;
        }
        if (!this.b) {
            this.n.setGeoPoint(iPoint);
            this.n.setFlat(true);
            this.n.setRotateAngle(360.0f - this.j);
            Marker marker = this.p;
            if (marker != null) {
                marker.setGeoPoint(iPoint);
            }
        } else if (this.C.getNaviMode() == 1) {
            int width = (int) (((double) this.r.getWidth()) * this.C.getAnchorX());
            int height = (int) (((double) this.r.getHeight()) * this.C.getAnchorY());
            this.n.setPositionByPixels(width, height);
            this.n.setFlat(true);
            if (!z2 || !((i2 = this.z) == 1 || i2 == 2)) {
                this.q.moveCamera(CameraUpdateFactory.changeBearingGeoCenter(0.0f, iPoint));
                this.n.setRotateAngle(360.0f - this.j);
            } else {
                this.q.moveCamera(CameraUpdateFactory.changeBearingGeoCenter(this.y, iPoint));
                this.n.setRotateAngle(((this.y - 360.0f) - this.j) % 360.0f);
            }
            Marker marker2 = this.p;
            if (marker2 != null) {
                marker2.setPositionByPixels(width, height);
                if (this.s) {
                    this.p.setVisible(true);
                } else {
                    this.p.setVisible(false);
                }
            }
        } else {
            this.q.moveCamera(CameraUpdateFactory.changeBearingGeoCenter(this.j, iPoint));
            int width2 = (int) (((double) this.r.getWidth()) * this.C.getAnchorX());
            int height2 = (int) (((double) this.r.getHeight()) * this.C.getAnchorY());
            this.n.setPositionByPixels(width2, height2);
            this.n.setRotateAngle(360.0f - this.j);
            this.n.setFlat(true);
            Marker marker3 = this.p;
            if (marker3 != null) {
                marker3.setPositionByPixels(width2, height2);
                if (this.s) {
                    this.p.setVisible(true);
                } else {
                    this.p.setVisible(false);
                }
            }
        }
        Marker marker4 = this.o;
        if (marker4 != null) {
            marker4.setGeoPoint(iPoint);
        }
        Marker marker5 = this.o;
        if (marker5 != null) {
            marker5.setRotateAngle(360.0f - this.j);
        }
        b(iPoint);
    }

    public final void a(LatLng latLng) {
        this.t = latLng;
    }

    public final void d() {
        Marker marker = this.n;
        if (marker != null) {
            marker.remove();
        }
        Marker marker2 = this.o;
        if (marker2 != null) {
            marker2.remove();
        }
        Marker marker3 = this.p;
        if (marker3 != null) {
            marker3.remove();
        }
        this.l = null;
        ScheduledExecutorService scheduledExecutorService = this.E;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            this.E.shutdown();
            this.i = false;
            this.E = null;
        }
    }

    public final void a(int i2) {
        this.a = i2;
    }

    private synchronized void b(IPoint iPoint) {
        try {
            if (this.k != -1) {
                if (this.D) {
                    if (this.t != null) {
                        DPoint dPoint = new DPoint();
                        GLMapState.geo2LonLat(iPoint.x, iPoint.y, dPoint);
                        LatLng latLng = new LatLng(dPoint.y, dPoint.x, false);
                        this.v.clear();
                        this.v.add(latLng);
                        this.v.add(this.t);
                        if (this.u == null) {
                            this.u = this.q.addPolyline(new PolylineOptions().add(latLng).add(this.t).color(this.k).width(5.0f));
                        } else {
                            this.u.setPoints(this.v);
                        }
                    } else {
                        if (this.u != null) {
                            this.u.remove();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "NaviCarOverlay", "drawLeaderLine(IPoint nowPoint");
        }
    }

    public final void e() {
        Polyline polyline = this.u;
        if (polyline != null) {
            polyline.remove();
        }
    }

    public final void b(int i2) {
        this.k = i2;
        if (i2 == -1) {
            Polyline polyline = this.u;
            if (polyline != null) {
                polyline.setVisible(false);
                return;
            }
            return;
        }
        Polyline polyline2 = this.u;
        if (polyline2 != null) {
            polyline2.setVisible(true);
            this.u.setColor(i2);
            return;
        }
        Marker marker = this.n;
        if (marker != null && marker.getGeoPoint() != null) {
            b(this.n.getGeoPoint());
        }
    }

    public final void f() {
        if (this.n != null) {
            int width = (int) (((double) this.r.getWidth()) * this.C.getAnchorX());
            int height = (int) (((double) this.r.getHeight()) * this.C.getAnchorY());
            if (this.b) {
                LatLng position = this.o.getPosition();
                if (this.C.getNaviMode() == 1) {
                    int width2 = (int) (((double) this.r.getWidth()) * this.C.getAnchorX());
                    int height2 = (int) (((double) this.r.getHeight()) * this.C.getAnchorY());
                    this.n.setPositionByPixels(width2, height2);
                    this.n.setFlat(false);
                    this.q.moveCamera(CameraUpdateFactory.changeBearing(0.0f));
                    this.n.setRotateAngle(360.0f - this.j);
                    Marker marker = this.p;
                    if (marker != null) {
                        marker.setPositionByPixels(width2, height2);
                        if (this.s) {
                            this.p.setVisible(true);
                        } else {
                            this.p.setVisible(false);
                        }
                    }
                } else {
                    this.q.moveCamera(CameraUpdateFactory.changeBearing(this.j));
                    this.q.moveCamera(CameraUpdateFactory.changeLatLng(position));
                    this.n.setPositionByPixels(width, height);
                    Marker marker2 = this.p;
                    if (marker2 != null) {
                        marker2.setPositionByPixels(width, height);
                        if (!this.s || !this.b) {
                            this.p.setVisible(false);
                        } else {
                            this.p.setVisible(true);
                        }
                    }
                }
            }
        }
    }

    public final void a(Bitmap bitmap) {
        this.w = bitmap;
        this.l = BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    public final void b(Bitmap bitmap) {
        BitmapDescriptor bitmapDescriptor;
        this.x = bitmap;
        this.m = BitmapDescriptorFactory.fromBitmap(bitmap);
        Marker marker = this.p;
        if (marker != null && (bitmapDescriptor = this.m) != null) {
            marker.setIcon(bitmapDescriptor);
        }
    }

    public final void a(float f2) {
        this.y = f2;
    }

    public final void c(int i2) {
        this.z = i2;
    }

    public final void b(boolean z2) {
        this.D = z2;
        boolean z3 = this.D;
        this.s = z3;
        Marker marker = this.n;
        if (marker != null) {
            marker.setVisible(z3);
        }
        Marker marker2 = this.p;
        if (marker2 != null) {
            marker2.setVisible(this.s);
        }
        Polyline polyline = this.u;
        if (polyline != null) {
            polyline.setVisible(this.D);
        }
    }
}
