package com.amap.api.col.stln3;

import android.content.Context;
import android.graphics.BitmapFactory;
import com.a11hud.www.R;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.navi.model.AMapNaviForbiddenInfo;
import com.amap.api.navi.model.AMapNaviLimitInfo;
import com.amap.api.navi.model.AMapNaviLink;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapNaviStep;
import com.amap.api.navi.model.AMapTrafficStatus;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.navi.view.NaviLimitOverlay;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: BaseOverlay */
public abstract class kd {
    int A = 0;
    protected BitmapDescriptor[] a = new BitmapDescriptor[2];
    protected BitmapDescriptor[] b = new BitmapDescriptor[2];
    protected BitmapDescriptor[] c = new BitmapDescriptor[2];
    protected BitmapDescriptor[] d = new BitmapDescriptor[2];
    protected BitmapDescriptor[] e = new BitmapDescriptor[2];
    protected BitmapDescriptor[] f = new BitmapDescriptor[2];
    protected BitmapDescriptor[] g = new BitmapDescriptor[3];
    protected List<kj> h = new ArrayList();
    protected NaviLimitOverlay i;
    protected float j = 40.0f;
    protected AMapNaviPath k = null;
    protected kj l;
    protected kj m;
    protected Polyline n;
    protected AMap o;
    protected Context p;
    protected List<Marker> q;
    protected List<Marker> r;
    protected Marker s;
    protected HashMap<Integer, BitmapDescriptor[]> t = new HashMap<>();
    protected List<Integer> u = new ArrayList();
    protected int v = 0;
    protected int w = -1;
    List<NaviLatLng> x = new ArrayList();
    int y = 1;
    public boolean z = false;

    /* compiled from: BaseOverlay */
    public interface a {
        void a(AMapNaviForbiddenInfo aMapNaviForbiddenInfo);

        void a(AMapNaviLimitInfo aMapNaviLimitInfo);
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    public kd(AMap aMap, AMapNaviPath aMapNaviPath, Context context) {
        this.p = context;
        this.j = (float) mj.a(context, 22);
        try {
            this.o = aMap;
            this.k = aMapNaviPath;
            this.i = new NaviLimitOverlay(this.p, aMap);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "RouteOverLay", "init(AMap amap, AMapNaviPath aMapNaviPath)");
        }
        this.b[0] = BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture_green_unselected.png");
        this.b[1] = BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture_green.png");
        this.a[0] = BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture_no_unselected.png");
        this.a[1] = BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture.png");
        this.c[0] = BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture_slow_unselected.png");
        this.c[1] = BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture_slow.png");
        this.d[0] = BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture_bad_unselected.png");
        this.d[1] = BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture_bad.png");
        this.e[0] = BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture_serious_unselected.png");
        this.e[1] = BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture_grayred.png");
        this.f[0] = BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture_dott_gray_unselected.png");
        this.f[1] = BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture_dott_gray.png");
        this.t.put(0, this.a);
        this.t.put(1, this.b);
        this.t.put(2, this.c);
        this.t.put(3, this.d);
        this.t.put(4, this.e);
        this.t.put(5, this.f);
        this.g[0] = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.alertDialogTheme));
        this.g[1] = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.allowStacking));
        this.g[2] = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.alpha));
    }

    /* access modifiers changed from: protected */
    public final void a(AMap aMap, AMapNaviPath aMapNaviPath) {
        int i2;
        boolean z2;
        List<AMapNaviLink> list;
        try {
            NaviLatLng carToFootPoint = aMapNaviPath.getCarToFootPoint();
            ArrayList<NaviLatLng> arrayList = new ArrayList();
            ArrayList<NaviLatLng> arrayList2 = new ArrayList();
            this.x = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (carToFootPoint != null) {
                i2 = mj.a(this.k.getStartPoint(), carToFootPoint);
            } else {
                i2 = -1;
            }
            int size = aMapNaviPath.getSteps().size();
            int i3 = 0;
            boolean z3 = false;
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            while (i3 < size) {
                int i9 = i4;
                boolean z4 = z3;
                int i10 = 0;
                for (List<AMapNaviLink> links = aMapNaviPath.getSteps().get(i3).getLinks(); i10 < links.size(); links = list) {
                    AMapNaviLink aMapNaviLink = links.get(i10);
                    int roadClass = aMapNaviLink.getRoadClass();
                    String roadName = aMapNaviLink.getRoadName();
                    if (!z4) {
                        list = links;
                        if (("内部道路".equals(roadName) || "无名道路".equals(roadName)) && roadClass == 10) {
                            arrayList.addAll(aMapNaviLink.getCoords());
                            i10++;
                            size = size;
                        }
                    } else {
                        list = links;
                    }
                    if (i5 == -1) {
                        i5 = i3;
                        i6 = i10;
                    }
                    if (carToFootPoint != null) {
                        int i11 = i7;
                        for (int i12 = 0; i12 < aMapNaviLink.getCoords().size(); i12++) {
                            NaviLatLng naviLatLng = aMapNaviLink.getCoords().get(i12);
                            if (!(carToFootPoint == null || i2 == -1 || i2 <= 1000)) {
                                if (Math.abs(naviLatLng.getLatitude() - carToFootPoint.getLatitude()) < 5.0E-6d) {
                                    if (Math.abs(naviLatLng.getLongitude() - carToFootPoint.getLongitude()) < 5.0E-6d) {
                                        this.x.add(naviLatLng);
                                        i9 = i12;
                                    }
                                }
                            }
                            if (i9 >= 0) {
                                arrayList2.add(naviLatLng);
                                if (i11 == -1) {
                                    i11 = i3;
                                    i8 = i10;
                                }
                            } else {
                                this.x.add(naviLatLng);
                            }
                        }
                        i7 = i11;
                        z4 = true;
                    } else {
                        this.x.addAll(arrayList3);
                        z4 = true;
                    }
                    i10++;
                    size = size;
                }
                i3++;
                z3 = z4;
                i4 = i9;
            }
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            for (NaviLatLng naviLatLng2 : arrayList) {
                arrayList4.add(a(naviLatLng2));
            }
            for (NaviLatLng naviLatLng3 : arrayList2) {
                arrayList5.add(a(naviLatLng3));
            }
            if (this.l != null) {
                this.l.a.remove();
            }
            if (this.m != null) {
                this.m.a.remove();
            }
            if (arrayList4.size() > 0) {
                z2 = true;
                Polyline addPolyline = aMap.addPolyline(new PolylineOptions().setDottedLine(true).addAll(arrayList4).setCustomTexture(this.f[this.y]).width(this.j - 10.0f));
                addPolyline.setZIndex((float) this.A);
                this.l = new kj(addPolyline, i5, i6, true, arrayList4);
            } else {
                z2 = true;
            }
            if (arrayList5.size() > 0) {
                Polyline addPolyline2 = aMap.addPolyline(new PolylineOptions().setDottedLine(z2).addAll(arrayList5).setCustomTexture(this.f[this.y]).width(this.j - 10.0f));
                addPolyline2.setZIndex((float) this.A);
                this.m = new kj(addPolyline2, i7, i8, true, arrayList5);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(List<AMapTrafficStatus> list) {
        NaviLatLng naviLatLng;
        int i2;
        NaviLatLng naviLatLng2;
        List<AMapNaviLink> list2;
        AMapNaviLink aMapNaviLink;
        AMapNaviLink aMapNaviLink2;
        int i3;
        AMapNaviLink aMapNaviLink3;
        int i4;
        String str;
        List<AMapNaviLink> list3;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    this.w = -1;
                    NaviLatLng carToFootPoint = this.k.getCarToFootPoint();
                    if (this.u != null) {
                        this.u.clear();
                    }
                    ArrayList arrayList = new ArrayList();
                    List<AMapNaviStep> steps = this.k.getSteps();
                    int i5 = 0;
                    ArrayList arrayList2 = arrayList;
                    int i6 = 0;
                    int i7 = 0;
                    boolean z2 = false;
                    boolean z3 = false;
                    while (i6 < steps.size()) {
                        AMapNaviStep aMapNaviStep = steps.get(i6);
                        List<AMapNaviLink> links = aMapNaviStep.getLinks();
                        AMapNaviLink aMapNaviLink4 = aMapNaviStep.getLinks().get(i5);
                        if (aMapNaviLink4.getLinkType() == 1) {
                            if (arrayList2.size() > 1) {
                                list3 = links;
                                a(arrayList2, this.w, null, i6, i7 - 1);
                            } else {
                                list3 = links;
                            }
                            if (aMapNaviLink4.getLinkType() != this.v) {
                                if (this.r == null) {
                                    this.r = new ArrayList();
                                }
                                NaviLatLng naviLatLng3 = aMapNaviStep.getCoords().get(i5);
                                this.r.add(this.o.addMarker(new MarkerOptions().position(new LatLng(naviLatLng3.getLatitude(), naviLatLng3.getLongitude())).anchor(0.5f, 0.5f).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.activityChooserViewStyle)))));
                            }
                            a(list3, i6);
                            arrayList2.clear();
                            this.w = -1;
                            naviLatLng = carToFootPoint;
                        } else {
                            this.v = aMapNaviLink4.getLinkType();
                            if (carToFootPoint != null) {
                                i2 = mj.a(this.k.getStartPoint(), carToFootPoint);
                            } else {
                                i2 = -1;
                            }
                            boolean z4 = z2;
                            ArrayList arrayList3 = arrayList2;
                            int i8 = 0;
                            for (List<AMapNaviLink> list4 = links; i8 < list4.size(); list4 = list2) {
                                AMapNaviLink aMapNaviLink5 = list4.get(i8);
                                int roadClass = aMapNaviLink5.getRoadClass();
                                String roadName = aMapNaviLink5.getRoadName();
                                if (!z4 && ("内部道路".equals(roadName) || "无名道路".equals(roadName))) {
                                    if (roadClass == 10) {
                                        list2 = list4;
                                        naviLatLng2 = carToFootPoint;
                                        i8++;
                                        carToFootPoint = naviLatLng2;
                                    }
                                }
                                LatLng latLng = null;
                                int i9 = 0;
                                while (true) {
                                    if (z3 || i9 >= aMapNaviLink5.getCoords().size()) {
                                        aMapNaviLink = aMapNaviLink5;
                                    } else {
                                        LatLng latLng2 = new LatLng(aMapNaviLink5.getCoords().get(i9).getLatitude(), aMapNaviLink5.getCoords().get(i9).getLongitude(), false);
                                        if (carToFootPoint == null) {
                                            aMapNaviLink = aMapNaviLink5;
                                        } else if (i2 != -1 && i2 > 1000) {
                                            aMapNaviLink = aMapNaviLink5;
                                            if (Math.abs(latLng2.latitude - carToFootPoint.getLatitude()) < 5.0E-6d && Math.abs(latLng2.longitude - carToFootPoint.getLongitude()) < 5.0E-6d) {
                                                arrayList3.add(latLng2);
                                                latLng = latLng2;
                                                z3 = true;
                                                break;
                                            }
                                        } else {
                                            aMapNaviLink = aMapNaviLink5;
                                        }
                                        if (arrayList3.size() != 0) {
                                            if (arrayList3.get(arrayList3.size() - 1).equals(latLng2)) {
                                                i9++;
                                                latLng = latLng2;
                                                aMapNaviLink5 = aMapNaviLink;
                                            }
                                        }
                                        if (i6 == steps.size() - 1) {
                                            if (i8 == list4.size() - 1) {
                                                i9++;
                                                latLng = latLng2;
                                                aMapNaviLink5 = aMapNaviLink;
                                            }
                                        }
                                        arrayList3.add(latLng2);
                                        i9++;
                                        latLng = latLng2;
                                        aMapNaviLink5 = aMapNaviLink;
                                    }
                                }
                                aMapNaviLink = aMapNaviLink5;
                                int trafficStatus = aMapNaviLink.getTrafficStatus();
                                if (arrayList3.size() <= 0 || this.w == -1) {
                                    list2 = list4;
                                    naviLatLng2 = carToFootPoint;
                                    aMapNaviLink2 = aMapNaviLink;
                                } else if (i6 < steps.size() - 1 || i8 < list4.size() - 1) {
                                    list2 = list4;
                                    naviLatLng2 = carToFootPoint;
                                    aMapNaviLink2 = aMapNaviLink;
                                    if (this.w != trafficStatus) {
                                        a(arrayList3, this.w, latLng, i6, i8);
                                    }
                                } else {
                                    if (this.w != trafficStatus) {
                                        list2 = list4;
                                        str = roadName;
                                        naviLatLng2 = carToFootPoint;
                                        i4 = roadClass;
                                        aMapNaviLink3 = aMapNaviLink;
                                        i3 = trafficStatus;
                                        a(arrayList3, this.w, arrayList3.get(arrayList3.size() - 1), i6, i8);
                                    } else {
                                        list2 = list4;
                                        str = roadName;
                                        naviLatLng2 = carToFootPoint;
                                        aMapNaviLink3 = aMapNaviLink;
                                        i4 = roadClass;
                                        i3 = trafficStatus;
                                    }
                                    if (!"内部道路".equals(str) && !"无名道路".equals(str) && i4 != 10) {
                                        arrayList3 = a(arrayList3, aMapNaviLink3);
                                    }
                                    a(arrayList3, i3, null, i6, i8);
                                    aMapNaviLink2 = aMapNaviLink3;
                                }
                                this.w = aMapNaviLink2.getTrafficStatus();
                                z4 = true;
                                i8++;
                                carToFootPoint = naviLatLng2;
                            }
                            naviLatLng = carToFootPoint;
                            i7 = i8;
                            arrayList2 = arrayList3;
                            z2 = z4;
                        }
                        i6++;
                        carToFootPoint = naviLatLng;
                        i5 = 0;
                    }
                    if (!this.z) {
                        return;
                    }
                    a();
                    return;
                }
            } catch (Throwable th) {
                if (this.z) {
                    a();
                }
                throw th;
            }
        }
        if (this.z) {
            a();
        }
    }

    private static List<LatLng> a(List<LatLng> list, AMapNaviLink aMapNaviLink) {
        for (int i2 = 0; i2 < aMapNaviLink.getCoords().size(); i2++) {
            LatLng latLng = new LatLng(aMapNaviLink.getCoords().get(i2).getLatitude(), aMapNaviLink.getCoords().get(i2).getLongitude(), false);
            if (list.size() == 0 || !list.get(list.size() - 1).equals(latLng)) {
                list.add(latLng);
            }
        }
        return list;
    }

    public final void b(List<NaviLatLng> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(new LatLng(list.get(i2).getLatitude(), list.get(i2).getLongitude(), false));
        }
        if (arrayList.size() > 0) {
            LatLng latLng = arrayList.get(arrayList.size() - 1);
            a(arrayList, 0, null, -1, -1);
            LatLng latLng2 = new LatLng(this.k.getEndPoint().getLatitude(), this.k.getEndPoint().getLongitude());
            if (AMapUtils.calculateLineDistance(latLng, latLng2) > 10.0f) {
                this.n = this.o.addPolyline(new PolylineOptions().setDottedLine(true).add(latLng, latLng2).setCustomTexture(this.f[1]).width(this.j - 10.0f));
            }
        }
    }

    private void a(List<LatLng> list, int i2, LatLng latLng, int i3, int i4) {
        Polyline polyline;
        BitmapDescriptor[] bitmapDescriptorArr = this.t.get(Integer.valueOf(i2));
        if (bitmapDescriptorArr != null) {
            polyline = a(list, bitmapDescriptorArr[this.y]);
        } else {
            polyline = a(list, this.a[this.y]);
        }
        if (this.z) {
            polyline.remove();
            a();
            return;
        }
        this.u.add(Integer.valueOf(i2));
        polyline.setZIndex((float) this.A);
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng2 : list) {
            arrayList.add(latLng2);
        }
        this.h.add(new kj(polyline, i3, i4, false, arrayList));
        list.clear();
        if (latLng != null) {
            list.add(latLng);
        }
    }

    private Polyline a(List<LatLng> list, BitmapDescriptor bitmapDescriptor) {
        return this.o.addPolyline(new PolylineOptions().addAll(list).width(this.j).setCustomTexture(bitmapDescriptor));
    }

    private void a(List<AMapNaviLink> list, int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            AMapNaviLink aMapNaviLink = list.get(i3);
            for (int i4 = 0; i4 < aMapNaviLink.getCoords().size(); i4++) {
                LatLng latLng = new LatLng(aMapNaviLink.getCoords().get(i4).getLatitude(), aMapNaviLink.getCoords().get(i4).getLongitude(), false);
                if (arrayList.size() == 0 || !arrayList.get(arrayList.size() - 1).equals(latLng)) {
                    arrayList.add(latLng);
                }
            }
        }
        Polyline a2 = a(arrayList, this.f[this.y]);
        this.u.add(5);
        a2.setZIndex((float) this.A);
        this.h.add(new kj(a2, i2, 0, true, arrayList));
    }

    public final void a(int i2) {
        if (i2 <= 0) {
            i2 = 0;
        } else if (i2 > 0) {
            i2 = 1;
        }
        try {
            this.y = i2;
            int size = this.u.size();
            int size2 = this.h.size();
            int i3 = 0;
            while (size == size2 && i3 < size2) {
                BitmapDescriptor[] bitmapDescriptorArr = this.t.get(Integer.valueOf(this.u.get(i3).intValue()));
                if (!this.h.get(i3).a.getOptions().getCustomTexture().equals(bitmapDescriptorArr[this.y])) {
                    this.h.get(i3).a.setCustomTexture(bitmapDescriptorArr[this.y]);
                }
                i3++;
            }
            if (this.l != null) {
                this.l.a.setCustomTexture(this.f[this.y]);
            }
            if (this.m != null) {
                this.m.a.setCustomTexture(this.f[this.y]);
            }
            if (i2 == 1) {
                b();
                if (this.s != null) {
                    this.s.setVisible(true);
                    return;
                }
                return;
            }
            if (this.s != null) {
                this.s.setVisible(false);
            }
            if (this.i != null) {
                this.i.removeAllMarker();
            }
        } catch (Throwable th) {
        }
    }

    public final void b() {
        try {
            if (this.i != null && this.k != null) {
                this.i.removeAllMarker();
                if (this.k.getLimitInfos() != null) {
                    this.i.drawLimitInfo(this.k.getLimitInfos());
                }
                if (this.k.getForbiddenInfos() != null) {
                    this.i.drawForbiddenInfo(this.k.getForbiddenInfos());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        if (this.h.size() > 0) {
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                if (this.h.get(i2) != null) {
                    this.h.get(i2).a.remove();
                }
            }
        }
        this.h.clear();
    }

    protected static LatLng a(NaviLatLng naviLatLng) {
        if (naviLatLng == null) {
            return null;
        }
        return new LatLng(naviLatLng.getLatitude(), naviLatLng.getLongitude());
    }

    public final void d() {
        try {
            this.z = true;
            if (this.l != null) {
                this.l.a.remove();
            }
            if (this.m != null) {
                this.m.a.remove();
            }
            if (this.n != null) {
                this.n.remove();
                this.n = null;
            }
            this.k = null;
            if (this.b != null && this.b.length > 1) {
                this.b[0].recycle();
                this.b[1].recycle();
            }
            if (this.a != null && this.a.length > 1) {
                this.a[0].recycle();
                this.a[1].recycle();
            }
            if (this.c != null && this.c.length > 1) {
                this.c[0].recycle();
                this.c[1].recycle();
            }
            if (this.d != null && this.d.length > 1) {
                this.d[0].recycle();
                this.d[1].recycle();
            }
            if (this.e != null && this.e.length > 1) {
                this.e[0].recycle();
                this.e[1].recycle();
            }
            if (this.f != null && this.f.length > 1) {
                this.f[0].recycle();
                this.f[1].recycle();
            }
            if (this.t != null) {
                this.t.clear();
            }
            if (this.i != null) {
                this.i.destroy();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "RouteOverLay", "destroy()");
        }
    }

    public final void b(int i2) {
        this.A = i2;
        try {
            if (this.h != null) {
                for (int i3 = 0; i3 < this.h.size(); i3++) {
                    this.h.get(i3).a.setZIndex((float) i2);
                }
            }
            if (this.l != null) {
                this.l.a.setZIndex((float) i2);
            }
            if (this.m != null) {
                this.m.a.setZIndex((float) i2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
