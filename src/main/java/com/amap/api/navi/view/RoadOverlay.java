package com.amap.api.navi.view;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import com.a11hud.www.R;
import com.amap.api.col.stln3.rx;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.autonavi.ae.guide.model.NaviCongestionInfo;

public class RoadOverlay {
    private AMap mAMap;
    private Context mContext;
    private String nextRoadName;
    private Marker nextRoadNameMarker = null;
    private LatLng tempLatlng;
    private TextView textNextRoadName;
    private Marker tmcStatusMarker = null;

    public RoadOverlay(Context context, AMap aMap) {
        this.mContext = context;
        this.mAMap = aMap;
    }

    private TextView getNextRoadView() {
        this.textNextRoadName = new TextView(this.mContext);
        this.textNextRoadName.setBackgroundResource(R.attr.actionModePopupWindowStyle);
        this.textNextRoadName.setTextColor(-1);
        this.textNextRoadName.setGravity(17);
        this.textNextRoadName.setTypeface(Typeface.defaultFromStyle(1));
        this.textNextRoadName.setTextSize(16.0f);
        return this.textNextRoadName;
    }

    public void drawNextRoadMarker(LatLng latLng, String str) {
        try {
            if (this.tempLatlng != null && latLng.latitude == this.tempLatlng.latitude) {
                if (latLng.longitude == this.tempLatlng.longitude) {
                    return;
                }
            }
            if (this.nextRoadName != null) {
                if (str.equals(this.nextRoadName)) {
                    return;
                }
            }
            if (this.nextRoadNameMarker == null) {
                this.nextRoadNameMarker = this.mAMap.addMarker(new MarkerOptions().position(latLng).anchor(1.0f, 1.0f));
            } else {
                this.nextRoadNameMarker.setPosition(latLng);
            }
            this.textNextRoadName = getNextRoadView();
            this.textNextRoadName.setText(str);
            this.nextRoadNameMarker.setIcon(BitmapDescriptorFactory.fromView(this.textNextRoadName));
            this.nextRoadNameMarker.setVisible(true);
            this.tempLatlng = latLng;
            this.nextRoadName = str;
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "RouteOverLay", "drawNextRoadMarker() ");
        }
    }

    public void hideNextRoadMarker() {
        Marker marker = this.nextRoadNameMarker;
        if (marker != null) {
            marker.setVisible(false);
        }
    }

    public void drawTrafficTip(LatLng latLng, NaviCongestionInfo naviCongestionInfo) {
        try {
            if (this.tmcStatusMarker == null) {
                this.tmcStatusMarker = this.mAMap.addMarker(new MarkerOptions().position(latLng).anchor(1.0f, 1.0f));
            } else {
                this.tmcStatusMarker.setPosition(latLng);
            }
            this.textNextRoadName = getNextRoadView();
            this.textNextRoadName.setText(naviCongestionInfo.totalRemainDist + "米 | " + naviCongestionInfo.totalTimeOfSeconds + "秒");
            this.tmcStatusMarker.setIcon(BitmapDescriptorFactory.fromView(this.textNextRoadName));
            this.tmcStatusMarker.setVisible(true);
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "RouteOverLay", "drawNextRoadMarker() ");
        }
    }

    public void hideStatusMarker() {
        Marker marker = this.tmcStatusMarker;
        if (marker != null) {
            marker.setVisible(false);
        }
    }

    public void removeFromMap() {
        Marker marker = this.nextRoadNameMarker;
        if (marker != null) {
            marker.remove();
        }
    }

    public void destroy() {
        Marker marker = this.nextRoadNameMarker;
        if (marker != null) {
            marker.destroy();
            this.nextRoadNameMarker = null;
        }
        this.textNextRoadName = null;
    }
}
