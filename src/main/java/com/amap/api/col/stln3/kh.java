package com.amap.api.col.stln3;

import android.content.Context;
import android.graphics.BitmapFactory;
import com.a11hud.www.R;
import com.amap.api.col.stln3.kd;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.NaviLatLng;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LbsRouteLine */
public final class kh extends kd {
    private Marker B;
    private Marker C;
    private boolean D = true;

    public kh(AMap aMap, AMapNaviPath aMapNaviPath, Context context) {
        super(aMap, aMapNaviPath, context);
    }

    public final void e() {
        List<NaviLatLng> list;
        LatLng latLng;
        try {
            if (this.o == null) {
                if (this.z) {
                    a();
                }
            } else if (this.j != 0.0f && this.k != null) {
                a(this.o, this.k);
                if (this.x != null) {
                    c();
                    if (this.B != null) {
                        this.B.remove();
                    }
                    if (this.C != null) {
                        this.C.remove();
                    }
                    if (this.q != null && this.q.size() > 0) {
                        for (int i = 0; i < this.q.size(); i++) {
                            Marker marker = (Marker) this.q.get(i);
                            if (marker != null) {
                                marker.remove();
                            }
                        }
                    }
                    if (this.r != null && this.r.size() > 0) {
                        for (int i2 = 0; i2 < this.r.size(); i2++) {
                            Marker marker2 = (Marker) this.r.get(i2);
                            if (marker2 != null) {
                                marker2.remove();
                            }
                        }
                    }
                    NaviLatLng carToFootPoint = this.k.getCarToFootPoint();
                    if (carToFootPoint != null) {
                        if (this.s == null) {
                            this.s = this.o.addMarker(new MarkerOptions().position(a(carToFootPoint)).anchor(0.5f, 0.5f).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.colorAccent))));
                        }
                        if (this.y == 0) {
                            this.s.setVisible(false);
                        }
                    }
                    LatLng latLng2 = null;
                    if (this.k.getStartPoint() == null || this.k.getEndPoint() == null) {
                        latLng = null;
                        list = null;
                    } else {
                        latLng2 = new LatLng(this.k.getStartPoint().getLatitude(), this.k.getStartPoint().getLongitude());
                        latLng = new LatLng(this.k.getEndPoint().getLatitude(), this.k.getEndPoint().getLongitude());
                        list = this.k.getWayPoint();
                    }
                    this.B = this.o.addMarker(new MarkerOptions().position(latLng2).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.alphabeticModifiers))));
                    if (list != null && list.size() > 0) {
                        int size = list.size();
                        if (this.q == null) {
                            this.q = new ArrayList(size);
                        }
                        if (list.size() == 1) {
                            NaviLatLng naviLatLng = list.get(0);
                            this.q.add(this.o.addMarker(new MarkerOptions().position(new LatLng(naviLatLng.getLatitude(), naviLatLng.getLongitude())).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.alertDialogStyle)))));
                        } else {
                            for (int i3 = 0; i3 < list.size(); i3++) {
                                NaviLatLng naviLatLng2 = list.get(i3);
                                this.q.add(this.o.addMarker(new MarkerOptions().position(new LatLng(naviLatLng2.getLatitude(), naviLatLng2.getLongitude())).icon(this.g[i3])));
                            }
                        }
                    }
                    if (this.D) {
                        this.C = this.o.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.alertDialogCenterButtons))));
                    }
                    if (AMapNavi.getInstance(this.p).getEngineType() == 0) {
                        a(this.k.getTrafficStatuses());
                    } else {
                        b(this.x);
                    }
                    if (this.y == 1) {
                        b();
                    } else if (this.i != null) {
                        this.i.removeAllMarker();
                    }
                    if (this.z) {
                        a();
                    }
                } else if (this.z) {
                    a();
                }
            } else if (this.z) {
                a();
            }
        } catch (Throwable th) {
            if (this.z) {
                a();
            }
            throw th;
        }
    }

    @Override // com.amap.api.col.stln3.kd
    public final void a() {
        try {
            if (this.l != null) {
                this.l.a.setVisible(false);
            }
            if (this.m != null) {
                this.m.a.setVisible(false);
            }
            if (this.s != null) {
                this.s.setVisible(false);
                this.s.remove();
            }
            if (this.B != null) {
                this.B.setVisible(false);
                this.B.remove();
            }
            if (this.C != null) {
                this.C.setVisible(false);
                this.C.remove();
            }
            if (this.q != null) {
                for (Marker marker : this.q) {
                    marker.setVisible(false);
                }
            }
            if (this.r != null) {
                for (Marker marker2 : this.r) {
                    marker2.setVisible(false);
                }
            }
            if (this.i != null) {
                this.i.removeAllMarker();
            }
            c();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "RouteOverLay", "removeFromMap()");
        }
    }

    public final void a(kd.a aVar) {
        if (this.i != null) {
            this.i.setMarkerClickCallBack(aVar);
        }
    }
}
