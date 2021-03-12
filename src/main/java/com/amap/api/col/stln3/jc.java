package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.AMapNaviListener;
import com.amap.api.navi.model.AMapCarInfo;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapTrafficStatus;
import com.amap.api.navi.model.NaviLatLng;
import com.autonavi.ae.route.model.RerouteOption;
import com.autonavi.tbt.IAe8;
import java.util.HashMap;
import java.util.List;

/* compiled from: BaseEngine */
public abstract class jc implements jk, jn, jo, IAe8 {
    private iw a;

    public jc(Context context) {
        if (context != null) {
            this.a = iw.a(context);
        }
    }

    public final void s() {
        iw iwVar = this.a;
        if (iwVar != null) {
            iwVar.a();
            this.a = null;
        }
    }

    public final iw t() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public final void a(AMapNaviListener aMapNaviListener) {
        this.a.a(aMapNaviListener);
    }

    /* access modifiers changed from: protected */
    public final void b(AMapNaviListener aMapNaviListener) {
        this.a.b(aMapNaviListener);
    }

    public boolean a(NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
        return false;
    }

    public boolean a(NaviLatLng naviLatLng) {
        return false;
    }

    public boolean b(NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
        return false;
    }

    public boolean b(NaviLatLng naviLatLng) {
        return false;
    }

    @Override // com.autonavi.tbt.IAe8
    public int strategyConvert(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return 0;
    }

    @Override // com.autonavi.tbt.IAe8
    public HashMap<Integer, AMapNaviPath> getMultipleNaviPathsCalculated() {
        return null;
    }

    @Override // com.autonavi.tbt.IAe8
    public void refreshTrafficStatuses() {
    }

    @Override // com.autonavi.tbt.IAe8
    public boolean readTrafficInfo(int i) {
        return false;
    }

    @Override // com.autonavi.tbt.IAe8
    public boolean calculateDriveRoute(List<NaviLatLng> list, List<NaviLatLng> list2, int i) {
        return false;
    }

    @Override // com.autonavi.tbt.IAe8
    public boolean calculateDriveRoute(List<NaviLatLng> list, List<NaviLatLng> list2, List<NaviLatLng> list3, int i) {
        return false;
    }

    @Override // com.autonavi.tbt.IAe8
    public void setCarNumber(String str, String str2) {
    }

    @Override // com.autonavi.tbt.IAe8
    public void setCarInfo(AMapCarInfo aMapCarInfo) {
    }

    @Override // com.autonavi.tbt.IAe8
    public boolean reCalculateRoute(RerouteOption rerouteOption, boolean z) {
        return false;
    }

    @Override // com.autonavi.tbt.IAe8
    public List<AMapTrafficStatus> getTrafficStatuses(int i, int i2) {
        return null;
    }

    @Override // com.autonavi.tbt.IAe8
    public int[] getAllRouteID() {
        return new int[0];
    }

    @Override // com.autonavi.tbt.IAe8
    public void setReCalculateRouteForYaw(boolean z) {
    }

    @Override // com.autonavi.tbt.IAe8
    public void setReCalculateRouteForTrafficJam(boolean z) {
    }

    @Override // com.autonavi.tbt.IAe8
    public void setTrafficStatusUpdateEnabled(boolean z) {
    }

    @Override // com.autonavi.tbt.IAe8
    public void setTrafficInfoUpdateEnabled(boolean z) {
    }

    @Override // com.autonavi.tbt.IAe8
    public void setCameraInfoUpdateEnabled(boolean z) {
    }

    @Override // com.autonavi.tbt.IAe8
    public void setDetectedMode(int i) {
    }

    @Override // com.autonavi.tbt.IAe8
    public boolean setBroadcastMode(int i) {
        return false;
    }

    @Override // com.autonavi.tbt.IAe8
    public void switchParallelRoad() {
    }

    @Override // com.autonavi.tbt.IAe8
    public void startAimlessMode(int i) {
    }

    @Override // com.autonavi.tbt.IAe8
    public void stopAimlessMode() {
    }

    public boolean a(String str, String str2, List<String> list, int i) {
        return false;
    }

    public boolean a(String str, List<String> list, int i) {
        return false;
    }

    public void a(boolean z) {
    }

    public void b(long j) {
    }

    public boolean a(Poi poi, Poi poi2, List<Poi> list, int i) {
        return false;
    }
}
