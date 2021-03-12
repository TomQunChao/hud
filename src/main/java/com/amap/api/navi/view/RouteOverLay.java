package com.amap.api.navi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import com.a11hud.www.R;
import com.amap.api.col.stln3.kj;
import com.amap.api.col.stln3.mj;
import com.amap.api.col.stln3.mm;
import com.amap.api.col.stln3.rx;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.navi.model.AMapNaviLink;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapNaviStep;
import com.amap.api.navi.model.AMapNotAvoidInfo;
import com.amap.api.navi.model.AMapTrafficStatus;
import com.amap.api.navi.model.BubbleInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.navi.model.RouteOverlayOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class RouteOverLay {
    private AMap aMap;
    private int arrowColor;
    private BitmapDescriptor arrowOnRoute = null;
    protected Polyline arrowOnRoutePolyline;
    public Marker bubbleMarker;
    List<NaviLatLng> carLinkCoods = new ArrayList();
    protected HashMap<Integer, BitmapDescriptor> custtextureHash = new HashMap<>();
    private Bitmap endBitmap;
    private BitmapDescriptor endBitmapDescriptor;
    private Marker endMarker;
    private BitmapDescriptor fairWayRes = null;
    protected List<Marker> ferryMarkers;
    private Bitmap footBitmap;
    private BitmapDescriptor footBitmapDescriptor;
    private Marker footMarker;
    public List<Integer> independLinkEndIndexList = null;
    public List<Integer> independLinkStartIndexList = null;
    public List<Integer> independStepEndIndexList = null;
    public List<Integer> independStepStartIndexList = null;
    boolean isAllOverlayVisible = true;
    boolean isAlwaysLightsVisible = true;
    boolean isArrowOnRoute = true;
    boolean isLightsVisible = true;
    boolean isNaviArrowVisible = true;
    private boolean isTrafficLine = true;
    private BitmapDescriptor jamTraffic = null;
    private AMapNaviPath mAMapNaviPath = null;
    private Context mContext;
    private List<Polyline> mCustomPolylines = new ArrayList();
    public kj mDefaultPolyline;
    protected kj mEndUnNaviPolyline;
    private List<LatLng> mLatLngsOfPath;
    private Polyline mPassDefaultPolyline;
    private List<Polyline> mPassRoutePolylines = new ArrayList();
    private RouteOverlayOptions mRouteOverlayOptions = null;
    protected kj mStartUnNaviPolyline;
    public List<kj> mTrafficColorfulPolylines = new ArrayList();
    private List<Marker> mTrafficLights = new ArrayList();
    private float mWidth = 40.0f;
    public int mapHeight = 0;
    public int mapWidth = 0;
    private NavigateArrow naviArrow = null;
    protected NaviLimitOverlay naviLimitOverlay;
    private BitmapDescriptor normalRoute = null;
    private BitmapDescriptor passDefaultRes = null;
    protected Polyline passEndUnNaviPolyline;
    private BitmapDescriptor passFairWayRes = null;
    private BitmapDescriptor passRoute = null;
    protected Polyline passRoutePolyline;
    protected Polyline passStartUnNaviPolyline;
    public MultiRouteBubble routeBubble;
    private BitmapDescriptor slowTraffic = null;
    private BitmapDescriptor smoothTraffic = null;
    private Bitmap startBitmap;
    private BitmapDescriptor startBitmapDescriptor;
    private Marker startMarker;
    protected int tempLinkType = 0;
    protected int tempTrafficIndex = -1;
    private BitmapDescriptor unknownTraffic = null;
    private BitmapDescriptor veryJamTraffic = null;
    private Bitmap wayBitmap;
    private List<Marker> wayMarkers;
    private BitmapDescriptor wayPointBitmapDescriptor;

    public RouteOverLay(AMap aMap2, AMapNaviPath aMapNaviPath, Context context) {
        try {
            this.arrowColor = Color.parseColor("#4DF6CC");
            this.mContext = context;
            this.mWidth = (float) mj.a(context, 22);
            init(aMap2, aMapNaviPath);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public float getWidth() {
        return this.mWidth;
    }

    public void setWidth(float f) {
        if (f > 0.0f) {
            this.mWidth = f;
        }
    }

    public RouteOverlayOptions getRouteOverlayOptions() {
        return this.mRouteOverlayOptions;
    }

    public void setRouteOverlayOptions(RouteOverlayOptions routeOverlayOptions) {
        try {
            this.mRouteOverlayOptions = routeOverlayOptions;
            if (!(routeOverlayOptions == null || routeOverlayOptions.getNormalRoute() == null)) {
                this.normalRoute = BitmapDescriptorFactory.fromBitmap(routeOverlayOptions.getNormalRoute());
            }
            if (!(routeOverlayOptions == null || routeOverlayOptions.getArrowOnTrafficRoute() == null)) {
                this.arrowOnRoute = BitmapDescriptorFactory.fromBitmap(routeOverlayOptions.getArrowOnTrafficRoute());
            }
            if (!(routeOverlayOptions == null || routeOverlayOptions.getUnknownTraffic() == null)) {
                this.unknownTraffic = BitmapDescriptorFactory.fromBitmap(routeOverlayOptions.getUnknownTraffic());
            }
            if (!(routeOverlayOptions == null || routeOverlayOptions.getSmoothTraffic() == null)) {
                this.smoothTraffic = BitmapDescriptorFactory.fromBitmap(routeOverlayOptions.getSmoothTraffic());
            }
            if (!(routeOverlayOptions == null || routeOverlayOptions.getSlowTraffic() == null)) {
                this.slowTraffic = BitmapDescriptorFactory.fromBitmap(routeOverlayOptions.getSlowTraffic());
            }
            if (!(routeOverlayOptions == null || routeOverlayOptions.getJamTraffic() == null)) {
                this.jamTraffic = BitmapDescriptorFactory.fromBitmap(routeOverlayOptions.getJamTraffic());
            }
            if (!(routeOverlayOptions == null || routeOverlayOptions.getVeryJamTraffic() == null)) {
                this.veryJamTraffic = BitmapDescriptorFactory.fromBitmap(routeOverlayOptions.getVeryJamTraffic());
            }
            if (routeOverlayOptions != null && routeOverlayOptions.getLineWidth() > 0.0f) {
                this.mWidth = routeOverlayOptions.getLineWidth();
            }
            if (!(routeOverlayOptions == null || routeOverlayOptions.getArrowColor() == this.arrowColor)) {
                this.arrowColor = routeOverlayOptions.getArrowColor();
            }
            if (!(routeOverlayOptions == null || routeOverlayOptions.getPassRoute() == null)) {
                this.passRoute = BitmapDescriptorFactory.fromBitmap(routeOverlayOptions.getPassRoute());
            }
            if (!(routeOverlayOptions == null || routeOverlayOptions.getFairWayRes() == null)) {
                this.fairWayRes = BitmapDescriptorFactory.fromBitmap(routeOverlayOptions.getFairWayRes());
            }
            this.custtextureHash.put(0, this.unknownTraffic);
            this.custtextureHash.put(1, this.smoothTraffic);
            this.custtextureHash.put(2, this.slowTraffic);
            this.custtextureHash.put(3, this.jamTraffic);
            this.custtextureHash.put(4, this.veryJamTraffic);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public AMapNaviPath getAMapNaviPath() {
        return this.mAMapNaviPath;
    }

    public void setAMapNaviPath(AMapNaviPath aMapNaviPath) {
        this.mAMapNaviPath = aMapNaviPath;
    }

    @Deprecated
    public void setRouteInfo(AMapNaviPath aMapNaviPath) {
        this.mAMapNaviPath = aMapNaviPath;
    }

    private void init(AMap aMap2, AMapNaviPath aMapNaviPath) {
        try {
            this.aMap = aMap2;
            this.mAMapNaviPath = aMapNaviPath;
            this.normalRoute = BitmapDescriptorFactory.fromAsset("amap_navi_custtexture.png");
            mm.a(this.mContext.getApplicationContext());
            this.naviLimitOverlay = new NaviLimitOverlay(this.mContext, aMap2);
        } catch (Throwable th) {
            th.printStackTrace();
            return;
        }
        this.arrowOnRoute = BitmapDescriptorFactory.fromAsset("amap_navi_custtexture_aolr.png");
        this.smoothTraffic = BitmapDescriptorFactory.fromAsset("amap_navi_custtexture_green.png");
        this.unknownTraffic = BitmapDescriptorFactory.fromAsset("amap_navi_custtexture_no.png");
        this.slowTraffic = BitmapDescriptorFactory.fromAsset("amap_navi_custtexture_slow.png");
        this.jamTraffic = BitmapDescriptorFactory.fromAsset("amap_navi_custtexture_bad.png");
        this.veryJamTraffic = BitmapDescriptorFactory.fromAsset("amap_navi_custtexture_grayred.png");
        this.passRoute = BitmapDescriptorFactory.fromAsset("amap_navi_pass_custtexture_no.png");
        this.fairWayRes = BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture_dott_gray.png");
        this.passFairWayRes = BitmapDescriptorFactory.fromAsset("amap_navi_lbs_custtexture_dott_gray_unselected.png");
        this.passDefaultRes = BitmapDescriptorFactory.fromAsset("amap_navi_pass_custtexture.png");
        this.wayBitmap = BitmapFactory.decodeResource(mm.a(), R.attr.tickMarkTint);
        this.endBitmap = BitmapFactory.decodeResource(mm.a(), R.attr.color);
        this.startBitmap = BitmapFactory.decodeResource(mm.a(), R.attr.subtitleTextStyle);
        this.footBitmap = BitmapFactory.decodeResource(mm.a(), R.attr.colorAccent);
        this.custtextureHash.put(0, this.unknownTraffic);
        this.custtextureHash.put(1, this.smoothTraffic);
        this.custtextureHash.put(2, this.slowTraffic);
        this.custtextureHash.put(3, this.jamTraffic);
        this.custtextureHash.put(4, this.veryJamTraffic);
        this.custtextureHash.put(5, this.fairWayRes);
    }

    public void addToMap() {
        try {
            if (this.aMap != null && this.isAllOverlayVisible && this.mAMapNaviPath != null) {
                removeFromMap();
                if (parserRoute(this.aMap, this.mAMapNaviPath)) {
                    handleLimitAndForbiddenInfos();
                    drawLights();
                    drawDefaultPolyline();
                    drawMarker();
                    if (this.isTrafficLine) {
                        setTrafficLine(Boolean.valueOf(this.isTrafficLine));
                    } else {
                        defaultPolylineDisplay(true);
                    }
                }
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "RouteOverLay", "addToMap()");
        }
    }

    public void drawLights() {
        if (this.isAlwaysLightsVisible && this.mAMapNaviPath != null) {
            clearTrafficLights();
            List<NaviLatLng> lightList = this.mAMapNaviPath.getLightList();
            if (lightList != null && lightList.size() > 0) {
                for (NaviLatLng naviLatLng : lightList) {
                    Marker addMarker = this.aMap.addMarker(new MarkerOptions().zIndex(-1.0f).anchor(0.5f, 0.5f).position(new LatLng(naviLatLng.getLatitude(), naviLatLng.getLongitude())).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.actionModePasteDrawable))));
                    addMarker.setVisible(this.isLightsVisible);
                    this.mTrafficLights.add(addMarker);
                }
            }
        }
    }

    private void drawDefaultPolyline() {
        Polyline addPolyline = this.aMap.addPolyline(new PolylineOptions().addAll(this.mLatLngsOfPath).setCustomTexture(this.normalRoute).width(this.mWidth - 5.0f));
        addPolyline.setVisible(true);
        kj kjVar = this.mEndUnNaviPolyline;
        if (kjVar != null) {
            this.mDefaultPolyline = new kj(addPolyline, kjVar.b, this.mEndUnNaviPolyline.c, false, this.mLatLngsOfPath);
            return;
        }
        int stepsCount = this.mAMapNaviPath.getStepsCount() - 1;
        this.mDefaultPolyline = new kj(addPolyline, stepsCount, this.mAMapNaviPath.getSteps().get(stepsCount).getLinks().size() - 1, false, this.mLatLngsOfPath);
    }

    private void drawMarker() {
        List<NaviLatLng> list;
        LatLng latLng;
        LatLng latLng2;
        Bitmap bitmap;
        if (this.mAMapNaviPath.getStartPoint() == null || this.mAMapNaviPath.getEndPoint() == null) {
            latLng2 = null;
            latLng = null;
            list = null;
        } else {
            latLng2 = new LatLng(this.mAMapNaviPath.getStartPoint().getLatitude(), this.mAMapNaviPath.getStartPoint().getLongitude());
            latLng = new LatLng(this.mAMapNaviPath.getEndPoint().getLatitude(), this.mAMapNaviPath.getEndPoint().getLongitude());
            list = this.mAMapNaviPath.getWayPoint();
        }
        Bitmap bitmap2 = this.startBitmap;
        if (bitmap2 != null) {
            if (this.startBitmapDescriptor == null) {
                this.startBitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmap2);
            }
            if (this.startBitmapDescriptor != null) {
                this.startMarker = this.aMap.addMarker(new MarkerOptions().position(latLng2).icon(this.startBitmapDescriptor));
            }
        }
        if (list != null && list.size() > 0) {
            int size = list.size();
            if (this.wayMarkers == null) {
                this.wayMarkers = new ArrayList(size);
            }
            for (NaviLatLng naviLatLng : list) {
                LatLng latLng3 = new LatLng(naviLatLng.getLatitude(), naviLatLng.getLongitude());
                Bitmap bitmap3 = this.wayBitmap;
                if (bitmap3 != null) {
                    if (this.wayPointBitmapDescriptor == null) {
                        this.wayPointBitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmap3);
                    }
                    this.wayMarkers.add(this.wayPointBitmapDescriptor != null ? this.aMap.addMarker(new MarkerOptions().position(latLng3).icon(this.wayPointBitmapDescriptor)) : null);
                }
            }
        }
        Bitmap bitmap4 = this.endBitmap;
        if (bitmap4 != null) {
            if (this.endBitmapDescriptor == null) {
                this.endBitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmap4);
            }
            if (this.endBitmapDescriptor != null) {
                this.endMarker = this.aMap.addMarker(new MarkerOptions().position(latLng).icon(this.endBitmapDescriptor));
            }
        }
        NaviLatLng carToFootPoint = this.mAMapNaviPath.getCarToFootPoint();
        if (!(carToFootPoint == null || (bitmap = this.footBitmap) == null)) {
            if (this.footBitmapDescriptor == null) {
                this.footBitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmap);
            }
            if (this.footBitmapDescriptor != null) {
                this.footMarker = this.aMap.addMarker(new MarkerOptions().position(conver(carToFootPoint)).anchor(0.5f, 0.5f).icon(this.footBitmapDescriptor));
            }
        }
    }

    public void setStartPointBitmap(Bitmap bitmap) {
        try {
            this.startBitmap = bitmap;
            if (this.startBitmap != null) {
                this.startBitmapDescriptor = BitmapDescriptorFactory.fromBitmap(this.startBitmap);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setWayPointBitmap(Bitmap bitmap) {
        try {
            this.wayBitmap = bitmap;
            if (this.wayBitmap != null) {
                this.wayPointBitmapDescriptor = BitmapDescriptorFactory.fromBitmap(this.wayBitmap);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setEndPointBitmap(Bitmap bitmap) {
        try {
            this.endBitmap = bitmap;
            if (this.endBitmap != null) {
                this.endBitmapDescriptor = BitmapDescriptorFactory.fromBitmap(this.endBitmap);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setCartoFootBitmap(Bitmap bitmap) {
        try {
            this.footBitmap = bitmap;
            if (this.footBitmap != null) {
                this.footBitmapDescriptor = BitmapDescriptorFactory.fromBitmap(this.footBitmap);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void removeFromMap() {
        try {
            clearDefaultPolyline();
            clearMarkers();
            clearTrafficLine();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "RouteOverLay", "removeFromMap()");
        }
    }

    private void clearMarkers() {
        Marker marker = this.startMarker;
        if (marker != null) {
            marker.remove();
            this.startMarker = null;
        }
        List<Marker> list = this.wayMarkers;
        if (list != null) {
            for (Marker marker2 : list) {
                marker2.remove();
            }
            this.wayMarkers.clear();
            this.wayMarkers = null;
        }
        Marker marker3 = this.endMarker;
        if (marker3 != null) {
            marker3.remove();
            this.endMarker = null;
        }
        NavigateArrow navigateArrow = this.naviArrow;
        if (navigateArrow != null) {
            navigateArrow.remove();
            this.naviArrow = null;
        }
        Marker marker4 = this.footMarker;
        if (marker4 != null) {
            marker4.remove();
            this.footMarker = null;
        }
        Marker marker5 = this.bubbleMarker;
        if (marker5 != null) {
            marker5.remove();
            this.bubbleMarker = null;
        }
        Marker marker6 = this.footMarker;
        if (marker6 != null) {
            marker6.remove();
            this.footMarker = null;
        }
        clearTrafficLights();
        NaviLimitOverlay naviLimitOverlay2 = this.naviLimitOverlay;
        if (naviLimitOverlay2 != null) {
            naviLimitOverlay2.removeAllMarker();
        }
    }

    public void clearTrafficLights() {
        List<Marker> list = this.mTrafficLights;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < this.mTrafficLights.size(); i++) {
                if (this.mTrafficLights.get(i) != null) {
                    this.mTrafficLights.get(i).remove();
                }
            }
            this.mTrafficLights.clear();
        }
    }

    private void clearDefaultPolyline() {
        kj kjVar = this.mDefaultPolyline;
        if (kjVar != null) {
            kjVar.a.remove();
            this.mDefaultPolyline = null;
        }
        Polyline polyline = this.mPassDefaultPolyline;
        if (polyline != null) {
            polyline.remove();
            this.mPassDefaultPolyline = null;
        }
        kj kjVar2 = this.mStartUnNaviPolyline;
        if (kjVar2 != null) {
            kjVar2.a.remove();
            this.mStartUnNaviPolyline = null;
        }
        kj kjVar3 = this.mEndUnNaviPolyline;
        if (kjVar3 != null) {
            kjVar3.a.remove();
            this.mEndUnNaviPolyline = null;
        }
        Polyline polyline2 = this.passStartUnNaviPolyline;
        if (polyline2 != null) {
            polyline2.remove();
            this.passStartUnNaviPolyline = null;
        }
        Polyline polyline3 = this.passEndUnNaviPolyline;
        if (polyline3 != null) {
            polyline3.remove();
            this.passEndUnNaviPolyline = null;
        }
        if (this.mCustomPolylines.size() > 0) {
            for (int i = 0; i < this.mCustomPolylines.size(); i++) {
                if (this.mCustomPolylines.get(i) != null) {
                    this.mCustomPolylines.get(i).remove();
                }
            }
        }
    }

    private void clearTrafficLine() {
        if (this.ferryMarkers != null) {
            for (int i = 0; i < this.ferryMarkers.size(); i++) {
                this.ferryMarkers.get(i).remove();
            }
            this.ferryMarkers.clear();
            this.ferryMarkers = null;
        }
        if (this.mTrafficColorfulPolylines.size() > 0) {
            for (int i2 = 0; i2 < this.mTrafficColorfulPolylines.size(); i2++) {
                if (this.mTrafficColorfulPolylines.get(i2) != null) {
                    this.mTrafficColorfulPolylines.get(i2).a.remove();
                }
            }
            this.mTrafficColorfulPolylines.clear();
        }
        Polyline polyline = this.arrowOnRoutePolyline;
        if (polyline != null) {
            polyline.remove();
            this.arrowOnRoutePolyline = null;
        }
        Polyline polyline2 = this.passRoutePolyline;
        if (polyline2 != null) {
            polyline2.remove();
            this.passRoutePolyline = null;
        }
        clearPassRoute();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0182 A[Catch:{ Throwable -> 0x0153 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0183 A[Catch:{ Throwable -> 0x0153 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void colorWayUpdate(java.util.List<com.amap.api.navi.model.AMapTrafficStatus> r30) {
        /*
        // Method dump skipped, instructions count: 857
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.navi.view.RouteOverLay.colorWayUpdate(java.util.List):void");
    }

    private List<LatLng> getLinkLatlngs(List<LatLng> list, AMapNaviLink aMapNaviLink) {
        for (int i = 0; i < aMapNaviLink.getCoords().size(); i++) {
            LatLng latLng = new LatLng(aMapNaviLink.getCoords().get(i).getLatitude(), aMapNaviLink.getCoords().get(i).getLongitude(), false);
            if (list.size() <= 1 || !list.get(list.size() - 1).equals(latLng)) {
                list.add(latLng);
            }
        }
        return list;
    }

    /* access modifiers changed from: protected */
    public void drawTrafficPolyline(List<LatLng> list, int i, LatLng latLng, int i2, int i3) {
        Polyline polyline;
        BitmapDescriptor bitmapDescriptor = this.custtextureHash.get(Integer.valueOf(i));
        if (bitmapDescriptor != null) {
            polyline = addTrafficPolyline(list, bitmapDescriptor);
        } else {
            polyline = addTrafficPolyline(list, this.unknownTraffic);
        }
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng2 : list) {
            arrayList.add(latLng2);
        }
        this.mTrafficColorfulPolylines.add(new kj(polyline, i2, i3, false, arrayList));
        list.clear();
        if (latLng != null) {
            list.add(latLng);
        }
    }

    /* access modifiers changed from: protected */
    public void drawFairWayPositionIcon(AMapNaviLink aMapNaviLink, AMapNaviStep aMapNaviStep) {
        if (aMapNaviLink.getLinkType() != this.tempLinkType) {
            if (this.ferryMarkers == null) {
                this.ferryMarkers = new ArrayList();
            }
            NaviLatLng naviLatLng = aMapNaviStep.getCoords().get(0);
            this.ferryMarkers.add(this.aMap.addMarker(new MarkerOptions().position(new LatLng(naviLatLng.getLatitude(), naviLatLng.getLongitude())).anchor(0.5f, 0.5f).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.activityChooserViewStyle)))));
        }
    }

    /* access modifiers changed from: protected */
    public void drawFairWayLine(List<AMapNaviLink> list, int i, int i2) {
        ArrayList<LatLng> arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            AMapNaviLink aMapNaviLink = list.get(i3);
            for (int i4 = 0; i4 < aMapNaviLink.getCoords().size(); i4++) {
                LatLng latLng = new LatLng(aMapNaviLink.getCoords().get(i4).getLatitude(), aMapNaviLink.getCoords().get(i4).getLongitude(), false);
                if (arrayList.size() == 0 || !arrayList.get(arrayList.size() - 1).equals(latLng)) {
                    arrayList.add(latLng);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (LatLng latLng2 : arrayList) {
            arrayList2.add(latLng2);
        }
        this.mTrafficColorfulPolylines.add(new kj(addTrafficPolyline(arrayList, this.fairWayRes), i, i2, true, arrayList2));
        arrayList.clear();
    }

    /* access modifiers changed from: protected */
    public Polyline addTrafficPolyline(List<LatLng> list, BitmapDescriptor bitmapDescriptor) {
        return this.aMap.addPolyline(new PolylineOptions().addAll(list).width(this.mWidth).setCustomTexture(bitmapDescriptor));
    }

    public void zoomToSpan() {
        try {
            zoomToSpan(100);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void zoomToSpan(int i) {
        try {
            if (this.mAMapNaviPath != null) {
                this.aMap.animateCamera(CameraUpdateFactory.newLatLngBounds(this.mAMapNaviPath.getBoundsForPath(), i), 1000, null);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "RouteOverLay", "zoomToSpan()");
        }
    }

    public void zoomToSpan(int i, AMapNaviPath aMapNaviPath) {
        try {
            zoomToSpan(i, i, i, i, aMapNaviPath);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "RouteOverLay", "zoomToSpan()");
        }
    }

    public void zoomToSpan(int i, int i2, int i3, int i4, AMapNaviPath aMapNaviPath) {
        if (aMapNaviPath != null) {
            try {
                this.aMap.animateCamera(CameraUpdateFactory.newLatLngBoundsRect(aMapNaviPath.getBoundsForPath(), i, i2, i3, i4), 1000, null);
            } catch (Throwable th) {
                mj.a(th);
            }
        }
    }

    public void destroy() {
        try {
            removeFromMap();
            this.mAMapNaviPath = null;
            if (this.arrowOnRoute != null) {
                this.arrowOnRoute.recycle();
            }
            if (this.smoothTraffic != null) {
                this.smoothTraffic.recycle();
            }
            if (this.unknownTraffic != null) {
                this.unknownTraffic.recycle();
            }
            if (this.slowTraffic != null) {
                this.slowTraffic.recycle();
            }
            if (this.jamTraffic != null) {
                this.jamTraffic.recycle();
            }
            if (this.veryJamTraffic != null) {
                this.veryJamTraffic.recycle();
            }
            if (this.startBitmap != null) {
                this.startBitmap.recycle();
            }
            if (this.endBitmap != null) {
                this.endBitmap.recycle();
            }
            if (this.wayBitmap != null) {
                this.wayBitmap.recycle();
            }
            if (this.passRoute != null) {
                this.passRoute.recycle();
            }
            if (this.fairWayRes != null) {
                this.fairWayRes.recycle();
            }
            if (this.passFairWayRes != null) {
                this.passFairWayRes.recycle();
            }
            if (this.footBitmap != null) {
                this.footBitmap.recycle();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "RouteOverLay", "destroy()");
        }
    }

    public void drawArrow(List<NaviLatLng> list) {
        try {
            if (this.isAllOverlayVisible) {
                if (list != null) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (NaviLatLng naviLatLng : list) {
                        arrayList.add(new LatLng(naviLatLng.getLatitude(), naviLatLng.getLongitude(), false));
                    }
                    if (this.naviArrow == null) {
                        this.naviArrow = this.aMap.addNavigateArrow(new NavigateArrowOptions().addAll(arrayList).topColor(this.arrowColor).width(this.mWidth * 0.4f));
                    } else {
                        this.naviArrow.setPoints(arrayList);
                    }
                    this.naviArrow.setZIndex(1.0f);
                    this.naviArrow.setVisible(this.isNaviArrowVisible);
                } else if (this.naviArrow != null) {
                    this.naviArrow.setVisible(false);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "RouteOverLay", "drawArrow(List<NaviLatLng> list) ");
        }
    }

    public void setLightsVisible(boolean z) {
        this.isLightsVisible = z;
        List<Marker> list = this.mTrafficLights;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < this.mTrafficLights.size(); i++) {
                if (this.mTrafficLights.get(i) != null) {
                    this.mTrafficLights.get(i).setVisible(z);
                }
            }
        }
    }

    public void setNaviArrowVisible(boolean z) {
        this.isNaviArrowVisible = z;
        NavigateArrow navigateArrow = this.naviArrow;
        if (navigateArrow != null) {
            navigateArrow.setVisible(z);
        }
    }

    public void setArrowOnRoute(boolean z) {
        this.isArrowOnRoute = z;
    }

    public List<NaviLatLng> getArrowPoints(int i) {
        AMapNaviPath aMapNaviPath = this.mAMapNaviPath;
        if (aMapNaviPath == null) {
            return null;
        }
        try {
            if (i < aMapNaviPath.getStepsCount()) {
                if (i >= 0) {
                    List<NaviLatLng> coordList = this.mAMapNaviPath.getCoordList();
                    int size = coordList.size();
                    int endIndex = this.mAMapNaviPath.getSteps().get(i).getEndIndex();
                    NaviLatLng naviLatLng = coordList.get(endIndex);
                    Vector vector = new Vector();
                    int i2 = endIndex - 1;
                    int i3 = 0;
                    NaviLatLng naviLatLng2 = naviLatLng;
                    int i4 = 0;
                    while (true) {
                        if (i2 < 0) {
                            break;
                        }
                        NaviLatLng naviLatLng3 = coordList.get(i2);
                        int a = mj.a(naviLatLng2, naviLatLng3);
                        i4 += a;
                        if (i4 >= 50) {
                            vector.add(mj.a(naviLatLng2, naviLatLng3, (double) ((a + 50) - i4)));
                            break;
                        }
                        vector.add(naviLatLng3);
                        i2--;
                        naviLatLng2 = naviLatLng3;
                    }
                    Collections.reverse(vector);
                    vector.add(naviLatLng);
                    int i5 = endIndex + 1;
                    while (true) {
                        if (i5 >= size) {
                            break;
                        }
                        NaviLatLng naviLatLng4 = coordList.get(i5);
                        int a2 = mj.a(naviLatLng, naviLatLng4);
                        i3 += a2;
                        if (i3 >= 50) {
                            vector.add(mj.a(naviLatLng, naviLatLng4, (double) ((a2 + 50) - i3)));
                            break;
                        }
                        vector.add(naviLatLng4);
                        i5++;
                        naviLatLng = naviLatLng4;
                    }
                    if (vector.size() > 2) {
                        return vector;
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "RouteOverLay", "getArrowPoints(int roadIndex)");
        }
    }

    public boolean isTrafficLine() {
        return this.isTrafficLine;
    }

    public void setTrafficLine(Boolean bool) {
        try {
            if (this.mContext != null) {
                this.isTrafficLine = bool.booleanValue();
                if (this.isAllOverlayVisible) {
                    List<AMapTrafficStatus> list = null;
                    clearTrafficLine();
                    if (this.isTrafficLine) {
                        if (this.mAMapNaviPath != null) {
                            list = this.mAMapNaviPath.getTrafficStatuses();
                        }
                        if (list != null) {
                            if (list.size() != 0) {
                                defaultPolylineDisplay(false);
                                colorWayUpdate(list);
                                return;
                            }
                        }
                        defaultPolylineDisplay(true);
                        return;
                    }
                    defaultPolylineDisplay(true);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "RouteOverLay", "setTrafficLine(Boolean enabled)");
        }
    }

    private void defaultPolylineDisplay(boolean z) {
        try {
            if (this.mDefaultPolyline != null) {
                this.mDefaultPolyline.a.setVisible(z);
            }
            if (this.mPassDefaultPolyline != null) {
                this.mPassDefaultPolyline.setVisible(z);
            }
            if (this.mCustomPolylines.size() > 0) {
                for (int i = 0; i < this.mCustomPolylines.size(); i++) {
                    if (this.mCustomPolylines.get(i) != null) {
                        this.mCustomPolylines.get(i).setVisible(z);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void addToMap(int[] iArr, int[] iArr2, BitmapDescriptor[] bitmapDescriptorArr) {
        try {
            addToMap();
            drawCustomPolyline(iArr, iArr2, bitmapDescriptorArr);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "RouteOverLay", "addToMap(int[] color, int[] index, BitmapDescriptor[] resourceArray)");
        }
    }

    private void drawCustomPolyline(int[] iArr, int[] iArr2, BitmapDescriptor[] bitmapDescriptorArr) {
        int i;
        Polyline polyline;
        ArrayList arrayList = new ArrayList();
        if (iArr == null) {
            i = bitmapDescriptorArr.length;
        } else {
            i = iArr.length;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr2 == null || i3 >= iArr2.length || iArr2[i3] > 0) {
                arrayList.clear();
                while (i2 < this.mLatLngsOfPath.size()) {
                    arrayList.add(this.mLatLngsOfPath.get(i3));
                    if (iArr2 != null && i3 < iArr2.length && i2 == iArr2[i3]) {
                        break;
                    }
                    i2++;
                }
                if (bitmapDescriptorArr == null || bitmapDescriptorArr.length == 0) {
                    polyline = this.aMap.addPolyline(new PolylineOptions().addAll(arrayList).color(iArr[i3]).width(this.mWidth));
                } else {
                    polyline = this.aMap.addPolyline(new PolylineOptions().addAll(arrayList).setCustomTexture(bitmapDescriptorArr[i3]).width(this.mWidth));
                }
                polyline.setVisible(true);
                this.mCustomPolylines.add(polyline);
            }
        }
        this.mCustomPolylines.add(this.aMap.addPolyline(new PolylineOptions().addAll(this.mLatLngsOfPath).width(this.mWidth).setCustomTexture(this.arrowOnRoute)));
    }

    /* access modifiers changed from: protected */
    public boolean parserRoute(AMap aMap2, AMapNaviPath aMapNaviPath) {
        int i;
        boolean z;
        int i2;
        try {
            NaviLatLng carToFootPoint = aMapNaviPath.getCarToFootPoint();
            ArrayList<NaviLatLng> arrayList = new ArrayList();
            ArrayList<NaviLatLng> arrayList2 = new ArrayList();
            if (this.carLinkCoods != null) {
                this.carLinkCoods.clear();
            } else {
                this.carLinkCoods = new ArrayList();
            }
            ArrayList arrayList3 = new ArrayList();
            if (carToFootPoint != null) {
                i = mj.a(this.mAMapNaviPath.getStartPoint(), carToFootPoint);
            } else {
                i = -1;
            }
            int size = aMapNaviPath.getSteps().size();
            int i3 = 0;
            boolean z2 = false;
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            while (i3 < size) {
                List<AMapNaviLink> links = aMapNaviPath.getSteps().get(i3).getLinks();
                int i9 = i4;
                boolean z3 = z2;
                int i10 = 0;
                while (i10 < links.size()) {
                    AMapNaviLink aMapNaviLink = links.get(i10);
                    int roadClass = aMapNaviLink.getRoadClass();
                    String roadName = aMapNaviLink.getRoadName();
                    if (!z3) {
                        i2 = size;
                        if (("内部道路".equals(roadName) || "无名道路".equals(roadName)) && roadClass == 10) {
                            if (aMapNaviPath.getStrategy() != -1) {
                                arrayList.addAll(aMapNaviLink.getCoords());
                                i10++;
                                links = links;
                                size = i2;
                            }
                        }
                    } else {
                        i2 = size;
                    }
                    if (i5 == -1) {
                        i6 = i10 - 1;
                        i5 = i3;
                    }
                    arrayList3.addAll(aMapNaviLink.getCoords());
                    if (carToFootPoint != null) {
                        int i11 = i7;
                        for (int i12 = 0; i12 < aMapNaviLink.getCoords().size(); i12++) {
                            NaviLatLng naviLatLng = aMapNaviLink.getCoords().get(i12);
                            if (!(carToFootPoint == null || i == -1)) {
                                if (Math.abs(naviLatLng.getLatitude() - carToFootPoint.getLatitude()) < 5.0E-6d) {
                                    if (Math.abs(naviLatLng.getLongitude() - carToFootPoint.getLongitude()) < 5.0E-6d) {
                                        this.carLinkCoods.add(naviLatLng);
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
                                this.carLinkCoods.add(naviLatLng);
                            }
                        }
                        i7 = i11;
                    } else {
                        this.carLinkCoods.addAll(arrayList3);
                    }
                    arrayList3.clear();
                    z3 = true;
                    i10++;
                    links = links;
                    size = i2;
                }
                i3++;
                z2 = z3;
                i4 = i9;
            }
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            for (NaviLatLng naviLatLng2 : arrayList) {
                arrayList4.add(conver(naviLatLng2));
            }
            for (NaviLatLng naviLatLng3 : arrayList2) {
                arrayList5.add(conver(naviLatLng3));
            }
            if (arrayList4.size() > 0) {
                z = true;
                this.mStartUnNaviPolyline = new kj(aMap2.addPolyline(new PolylineOptions().setDottedLine(true).addAll(arrayList4).setCustomTexture(this.fairWayRes).width(this.mWidth - 10.0f)), i5, i6, true, arrayList4);
            } else {
                z = true;
            }
            if (arrayList5.size() > 0) {
                this.mEndUnNaviPolyline = new kj(aMap2.addPolyline(new PolylineOptions().setDottedLine(z).addAll(arrayList5).setCustomTexture(this.fairWayRes).width(this.mWidth - 10.0f)), i7, i8, true, arrayList5);
            }
            this.mLatLngsOfPath = new ArrayList(this.carLinkCoods.size());
            for (NaviLatLng naviLatLng4 : this.carLinkCoods) {
                this.mLatLngsOfPath.add(new LatLng(naviLatLng4.getLatitude(), naviLatLng4.getLongitude(), false));
            }
            if (this.mLatLngsOfPath == null || this.mLatLngsOfPath.size() <= 0) {
                return false;
            }
            return z;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public LatLng conver(NaviLatLng naviLatLng) {
        if (naviLatLng == null) {
            return null;
        }
        return new LatLng(naviLatLng.getLatitude(), naviLatLng.getLongitude());
    }

    public void addToMap(int[] iArr, int[] iArr2) {
        if (iArr != null) {
            try {
                if (iArr.length != 0) {
                    addToMap(iArr, iArr2, null);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void addToMap(BitmapDescriptor[] bitmapDescriptorArr, int[] iArr) {
        if (bitmapDescriptorArr != null) {
            try {
                if (bitmapDescriptorArr.length != 0) {
                    addToMap(null, iArr, bitmapDescriptorArr);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setTransparency(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        try {
            if (this.mDefaultPolyline != null) {
                this.mDefaultPolyline.a.setTransparency(f);
            }
            for (kj kjVar : this.mTrafficColorfulPolylines) {
                kjVar.a.setTransparency(f);
            }
            if (this.arrowOnRoutePolyline != null) {
                this.arrowOnRoutePolyline.setTransparency(f);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZindex(int i) {
        try {
            if (this.mTrafficColorfulPolylines != null) {
                for (int i2 = 0; i2 < this.mTrafficColorfulPolylines.size(); i2++) {
                    this.mTrafficColorfulPolylines.get(i2).a.setZIndex((float) i);
                }
            }
            if (this.arrowOnRoutePolyline != null) {
                this.arrowOnRoutePolyline.setZIndex((float) (i + 1));
            }
            if (this.mDefaultPolyline != null) {
                this.mDefaultPolyline.a.setZIndex((float) i);
            }
            if (this.mStartUnNaviPolyline != null) {
                this.mStartUnNaviPolyline.a.setZIndex((float) i);
            }
            if (this.mEndUnNaviPolyline != null) {
                this.mEndUnNaviPolyline.a.setZIndex((float) i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void handleLimitAndForbiddenInfos() {
        try {
            if (this.naviLimitOverlay != null) {
                this.naviLimitOverlay.removeAllMarker();
                if (this.mAMapNaviPath.getLimitInfos() != null) {
                    this.naviLimitOverlay.drawLimitInfo(this.mAMapNaviPath.getLimitInfos());
                }
                if (this.mAMapNaviPath.getForbiddenInfos() != null) {
                    this.naviLimitOverlay.drawForbiddenInfo(this.mAMapNaviPath.getForbiddenInfos());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void handlePassLimitAndForbidden(AMapNotAvoidInfo aMapNotAvoidInfo) {
        NaviLimitOverlay naviLimitOverlay2 = this.naviLimitOverlay;
        if (naviLimitOverlay2 != null && aMapNotAvoidInfo != null) {
            naviLimitOverlay2.handlePassLimitAndForbidden(aMapNotAvoidInfo);
        }
    }

    private void clearPassRoute() {
        if (this.mPassRoutePolylines.size() > 0) {
            for (int i = 0; i < this.mPassRoutePolylines.size(); i++) {
                if (this.mPassRoutePolylines.get(i) != null) {
                    this.mPassRoutePolylines.get(i).remove();
                }
            }
            this.mPassRoutePolylines.clear();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:113:0x01e9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0261  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updatePolyline(com.amap.api.navi.model.AMapNaviLocation r18) {
        /*
        // Method dump skipped, instructions count: 813
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.navi.view.RouteOverLay.updatePolyline(com.amap.api.navi.model.AMapNaviLocation):void");
    }

    private List<LatLng> getRemainPoint(AMapNaviLocation aMapNaviLocation, int i, int i2, int i3, int i4, int i5) {
        int i6;
        int i7 = i;
        ArrayList arrayList = new ArrayList();
        List<AMapNaviStep> steps = this.mAMapNaviPath.getSteps();
        arrayList.add(new LatLng(aMapNaviLocation.getCoord().getLatitude(), aMapNaviLocation.getCoord().getLongitude()));
        List<AMapNaviLink> links = steps.get(i7).getLinks();
        int size = links.size();
        if (i7 == i3) {
            size = i4 + 1;
        }
        for (int i8 = i2; i8 < size; i8++) {
            List<NaviLatLng> coords = links.get(i8).getCoords();
            if (i8 == i2) {
                i6 = i5 + 1;
            } else {
                i6 = 0;
            }
            while (i6 < coords.size()) {
                NaviLatLng naviLatLng = coords.get(i6);
                arrayList.add(new LatLng(naviLatLng.getLatitude(), naviLatLng.getLongitude()));
                i6++;
                links = links;
                size = size;
            }
        }
        while (true) {
            i7++;
            if (i7 > i3) {
                return arrayList;
            }
            List<AMapNaviLink> links2 = steps.get(i7).getLinks();
            int size2 = links2.size();
            if (i7 == i3) {
                size2 = i4 + 1;
            }
            for (int i9 = 0; i9 < size2; i9++) {
                int i10 = 0;
                for (List<NaviLatLng> coords2 = links2.get(i9).getCoords(); i10 < coords2.size(); coords2 = coords2) {
                    NaviLatLng naviLatLng2 = coords2.get(i10);
                    arrayList.add(new LatLng(naviLatLng2.getLatitude(), naviLatLng2.getLongitude()));
                    i10++;
                }
            }
        }
    }

    private List<LatLng> getPassedPoint(int i, int i2, AMapNaviLocation aMapNaviLocation, int i3, int i4, int i5) {
        int i6;
        int i7;
        List<AMapNaviStep> steps = this.mAMapNaviPath.getSteps();
        ArrayList arrayList = new ArrayList();
        for (int i8 = i; i8 < i3; i8++) {
            List<AMapNaviLink> links = steps.get(i8).getLinks();
            if (i8 == i) {
                i7 = i2 + 1;
            } else {
                i7 = 0;
            }
            while (i7 < links.size()) {
                List<NaviLatLng> coords = links.get(i7).getCoords();
                int i9 = 0;
                while (i9 < coords.size()) {
                    NaviLatLng naviLatLng = coords.get(i9);
                    arrayList.add(new LatLng(naviLatLng.getLatitude(), naviLatLng.getLongitude()));
                    i9++;
                    links = links;
                }
                i7++;
            }
        }
        List<AMapNaviLink> links2 = steps.get(i3).getLinks();
        if (i == i3) {
            i6 = i2 + 1;
        } else {
            i6 = 0;
        }
        while (i6 < i4 && i6 < links2.size()) {
            List<NaviLatLng> coords2 = links2.get(i6).getCoords();
            int size = coords2.size();
            for (int i10 = 0; i10 < size; i10++) {
                NaviLatLng naviLatLng2 = coords2.get(i10);
                arrayList.add(new LatLng(naviLatLng2.getLatitude(), naviLatLng2.getLongitude()));
            }
            i6++;
        }
        List<NaviLatLng> coords3 = links2.get(i4).getCoords();
        for (int i11 = 0; i11 < i5 + 1; i11++) {
            NaviLatLng naviLatLng3 = coords3.get(i11);
            arrayList.add(new LatLng(naviLatLng3.getLatitude(), naviLatLng3.getLongitude()));
        }
        arrayList.add(new LatLng(aMapNaviLocation.getCoord().getLatitude(), aMapNaviLocation.getCoord().getLongitude()));
        return arrayList;
    }

    public void setRouteOverlayVisible(boolean z) {
        this.isAllOverlayVisible = z;
    }

    public void setTrafficLightsVisible(boolean z) {
        this.isAlwaysLightsVisible = z;
    }

    public BubbleInfo getBubbleInfo() {
        int i;
        int i2;
        if (this.mAMapNaviPath == null) {
            return null;
        }
        if (this.independStepStartIndexList == null || this.independStepEndIndexList == null || this.independLinkStartIndexList == null) {
            return null;
        }
        if (this.independLinkEndIndexList == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.independStepStartIndexList.size(); i3++) {
            int intValue = this.independStepStartIndexList.get(i3).intValue();
            int intValue2 = this.independStepEndIndexList.get(i3).intValue();
            int intValue3 = this.independLinkStartIndexList.get(i3).intValue();
            int intValue4 = this.independLinkEndIndexList.get(i3).intValue();
            int i4 = intValue + 1;
            while (i4 < intValue2 && i4 < this.mAMapNaviPath.getSteps().size()) {
                AMapNaviStep aMapNaviStep = this.mAMapNaviPath.getSteps().get(i4);
                NaviLatLng naviLatLng = aMapNaviStep.getCoords().get(aMapNaviStep.getCoords().size() - 1);
                BubbleInfo isInsideScreen = isInsideScreen(new LatLng(naviLatLng.getLatitude(), naviLatLng.getLongitude()));
                if (isInsideScreen != null) {
                    arrayList.add(isInsideScreen);
                }
                i4++;
            }
            if (arrayList.size() > 0) {
                return (BubbleInfo) arrayList.get((arrayList.size() - 1) / 2);
            }
            int i5 = intValue;
            while (i5 <= intValue2 && i5 < this.mAMapNaviPath.getSteps().size()) {
                if (i5 == intValue) {
                    i2 = intValue3 + 1;
                } else {
                    i2 = 0;
                }
                AMapNaviStep aMapNaviStep2 = this.mAMapNaviPath.getSteps().get(i5);
                List<AMapNaviLink> links = aMapNaviStep2.getLinks();
                int size = links.size();
                if (i5 == intValue2) {
                    size = intValue4 - 1;
                }
                while (i2 < size && i2 < size) {
                    AMapNaviLink aMapNaviLink = links.get(i2);
                    NaviLatLng naviLatLng2 = aMapNaviLink.getCoords().get(aMapNaviLink.getCoords().size() - 1);
                    BubbleInfo isInsideScreen2 = isInsideScreen(new LatLng(naviLatLng2.getLatitude(), naviLatLng2.getLongitude()));
                    if (!(isInsideScreen2 == null || (i5 == intValue && i2 == intValue3 && intValue3 == aMapNaviStep2.getLinks().size() - 1))) {
                        arrayList.add(isInsideScreen2);
                    }
                    i2++;
                    links = links;
                    size = size;
                }
                i5++;
            }
            if (arrayList.size() > 0) {
                return (BubbleInfo) arrayList.get((arrayList.size() - 1) / 2);
            }
            int i6 = intValue;
            while (i6 <= intValue2 && i6 < this.mAMapNaviPath.getSteps().size()) {
                if (i6 == intValue) {
                    i = intValue3 + 1;
                } else {
                    i = 0;
                }
                List<AMapNaviLink> links2 = this.mAMapNaviPath.getSteps().get(i6).getLinks();
                int size2 = links2.size();
                if (i6 == intValue2) {
                    size2 = intValue4;
                }
                while (i < size2 && i < size2) {
                    AMapNaviLink aMapNaviLink2 = links2.get(i);
                    int i7 = 0;
                    while (i7 < aMapNaviLink2.getCoords().size()) {
                        NaviLatLng naviLatLng3 = aMapNaviLink2.getCoords().get(i7);
                        BubbleInfo isInsideScreen3 = isInsideScreen(new LatLng(naviLatLng3.getLatitude(), naviLatLng3.getLongitude()));
                        if (isInsideScreen3 != null) {
                            arrayList.add(isInsideScreen3);
                        }
                        i7++;
                        intValue = intValue;
                        intValue2 = intValue2;
                        intValue3 = intValue3;
                        intValue4 = intValue4;
                    }
                    i++;
                }
                i6++;
                intValue = intValue;
                intValue2 = intValue2;
                intValue3 = intValue3;
                intValue4 = intValue4;
            }
            if (arrayList.size() > 0) {
                return (BubbleInfo) arrayList.get((arrayList.size() - 1) / 2);
            }
        }
        return null;
    }

    private BubbleInfo isInsideScreen(LatLng latLng) {
        AMap aMap2 = this.aMap;
        if (aMap2 == null) {
            return null;
        }
        Point screenLocation = aMap2.getProjection().toScreenLocation(latLng);
        if (screenLocation.x <= 0 || screenLocation.x >= this.mapWidth || screenLocation.y <= 100 || screenLocation.y >= this.mapHeight) {
            return null;
        }
        int i = this.mapWidth;
        int i2 = i / 2;
        int i3 = i / 2;
        BubbleInfo bubbleInfo = new BubbleInfo();
        bubbleInfo.setBubblePosition(latLng);
        if (screenLocation.x < i2 && screenLocation.y < i3) {
            bubbleInfo.setBubblePositionScreen(4);
        }
        if (screenLocation.x > i2 && screenLocation.y < i3) {
            bubbleInfo.setBubblePositionScreen(2);
        }
        if (screenLocation.x < i2 && screenLocation.y > i3) {
            bubbleInfo.setBubblePositionScreen(3);
        }
        if (screenLocation.x > i2 && screenLocation.y > i3) {
            bubbleInfo.setBubblePositionScreen(1);
        }
        return bubbleInfo;
    }
}
