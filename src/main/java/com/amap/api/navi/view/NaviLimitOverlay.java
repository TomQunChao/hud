package com.amap.api.navi.view;

import android.content.Context;
import android.graphics.BitmapFactory;
import com.a11hud.www.R;
import com.amap.api.col.stln3.kd;
import com.amap.api.col.stln3.mj;
import com.amap.api.col.stln3.mm;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.navi.model.AMapNaviForbiddenInfo;
import com.amap.api.navi.model.AMapNaviLimitInfo;
import com.amap.api.navi.model.AMapNotAvoidInfo;
import com.amap.api.navi.model.NaviLatLng;
import java.util.ArrayList;
import java.util.List;

public class NaviLimitOverlay {
    private AMap aMap;
    private BitmapDescriptor limitGoStraightDescriptor;
    private BitmapDescriptor limitHeightDescriptor;
    private BitmapDescriptor limitTurnLeftDescriptor;
    private BitmapDescriptor limitTurnLeftRoundDescriptor;
    private BitmapDescriptor limitTurnRightDescriptor;
    private BitmapDescriptor limitTurnRightRoundDescriptor;
    private BitmapDescriptor limitWidthDescriptor;
    private kd.a markerClickCallBack;
    private List<Marker> markers = new ArrayList();

    public void setMarkerClickCallBack(kd.a aVar) {
        this.markerClickCallBack = aVar;
    }

    public NaviLimitOverlay(Context context, AMap aMap2) {
        try {
            this.limitHeightDescriptor = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.gapBetweenBars));
            this.limitWidthDescriptor = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.homeLayout));
            this.limitGoStraightDescriptor = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.fontWeight));
            this.limitTurnLeftDescriptor = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.goIcon));
            this.limitTurnRightDescriptor = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.hideOnContentScroll));
            this.limitTurnLeftRoundDescriptor = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.height));
            this.limitTurnRightRoundDescriptor = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.homeAsUpIndicator));
            this.aMap = aMap2;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void drawLimitInfo(List<AMapNaviLimitInfo> list) {
        for (int i = 0; i < list.size(); i++) {
            handleLimitAndAddMarker(list.get(i));
        }
    }

    public void drawForbiddenInfo(List<AMapNaviForbiddenInfo> list) {
        for (int i = 0; i < list.size(); i++) {
            handleForbiddenAndAddMarker(list.get(i));
        }
    }

    private void handleForbiddenAndAddMarker(AMapNaviForbiddenInfo aMapNaviForbiddenInfo) {
        BitmapDescriptor bitmapDescriptor;
        switch (aMapNaviForbiddenInfo.forbiddenType) {
            case 0:
                bitmapDescriptor = this.limitTurnLeftDescriptor;
                break;
            case 1:
                bitmapDescriptor = this.limitTurnRightDescriptor;
                break;
            case 2:
                bitmapDescriptor = this.limitTurnLeftRoundDescriptor;
                break;
            case 3:
                bitmapDescriptor = this.limitTurnRightRoundDescriptor;
                break;
            case 4:
                bitmapDescriptor = this.limitGoStraightDescriptor;
                break;
            default:
                bitmapDescriptor = null;
                break;
        }
        if (bitmapDescriptor != null) {
            addMarker(bitmapDescriptor, new LatLng(aMapNaviForbiddenInfo.latitude, aMapNaviForbiddenInfo.longitude)).setObject(aMapNaviForbiddenInfo);
        }
    }

    private void handleLimitAndAddMarker(AMapNaviLimitInfo aMapNaviLimitInfo) {
        BitmapDescriptor bitmapDescriptor;
        switch (aMapNaviLimitInfo.type) {
            case 81:
                bitmapDescriptor = this.limitHeightDescriptor;
                break;
            case 82:
                bitmapDescriptor = this.limitWidthDescriptor;
                break;
            default:
                bitmapDescriptor = null;
                break;
        }
        if (bitmapDescriptor != null) {
            addMarker(bitmapDescriptor, new LatLng(aMapNaviLimitInfo.latitude, aMapNaviLimitInfo.longitude)).setObject(aMapNaviLimitInfo);
        }
    }

    private Marker addMarker(BitmapDescriptor bitmapDescriptor, LatLng latLng) {
        Marker addMarker = this.aMap.addMarker(new MarkerOptions().position(latLng).anchor(0.5f, 0.5f).icon(bitmapDescriptor));
        this.markers.add(addMarker);
        return addMarker;
    }

    public void onMarkerClick(Marker marker) {
        if (this.markerClickCallBack != null) {
            if (marker.getObject() instanceof AMapNaviLimitInfo) {
                this.markerClickCallBack.a((AMapNaviLimitInfo) marker.getObject());
            } else if (marker.getObject() instanceof AMapNaviForbiddenInfo) {
                this.markerClickCallBack.a((AMapNaviForbiddenInfo) marker.getObject());
            }
        }
    }

    public void destroy() {
        try {
            if (this.markers != null) {
                removeAllMarker();
                this.markers.clear();
            }
            if (this.limitHeightDescriptor != null) {
                this.limitHeightDescriptor.recycle();
            }
            if (this.limitWidthDescriptor != null) {
                this.limitWidthDescriptor.recycle();
                this.limitWidthDescriptor = null;
            }
            if (this.limitGoStraightDescriptor != null) {
                this.limitGoStraightDescriptor.recycle();
                this.limitGoStraightDescriptor = null;
            }
            if (this.limitTurnLeftDescriptor != null) {
                this.limitTurnLeftDescriptor.recycle();
                this.limitTurnLeftDescriptor = null;
            }
            if (this.limitTurnRightDescriptor != null) {
                this.limitTurnRightDescriptor.recycle();
                this.limitTurnRightDescriptor = null;
            }
            if (this.limitTurnLeftRoundDescriptor != null) {
                this.limitTurnLeftRoundDescriptor.recycle();
                this.limitTurnLeftRoundDescriptor = null;
            }
            if (this.limitTurnRightRoundDescriptor != null) {
                this.limitTurnRightRoundDescriptor.recycle();
                this.limitTurnRightRoundDescriptor = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void removeAllMarker() {
        try {
            if (this.markers != null) {
                for (int i = 0; i < this.markers.size(); i++) {
                    this.markers.get(i).remove();
                }
                this.markers.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void handlePassLimitAndForbidden(AMapNotAvoidInfo aMapNotAvoidInfo) {
        int i = -1;
        int i2 = 0;
        while (true) {
            try {
                if (i2 >= this.markers.size()) {
                    break;
                }
                Marker marker = this.markers.get(i2);
                LatLng position = marker.getPosition();
                int a = mj.a(new NaviLatLng(aMapNotAvoidInfo.coord2D.getLatitude(), aMapNotAvoidInfo.coord2D.getLongitude()), new NaviLatLng(position.latitude, position.longitude));
                if (marker.getObject() instanceof AMapNaviLimitInfo) {
                    AMapNaviLimitInfo aMapNaviLimitInfo = (AMapNaviLimitInfo) marker.getObject();
                    if (a < 10 && aMapNaviLimitInfo.type == aMapNotAvoidInfo.type + 80) {
                        marker.remove();
                        break;
                    }
                    i2++;
                } else {
                    if (marker.getObject() instanceof AMapNaviForbiddenInfo) {
                        AMapNaviForbiddenInfo aMapNaviForbiddenInfo = (AMapNaviForbiddenInfo) marker.getObject();
                        if (a < 10 && aMapNaviForbiddenInfo.forbiddenType == aMapNotAvoidInfo.forbidType) {
                            marker.remove();
                            break;
                        }
                    } else {
                        continue;
                    }
                    i2++;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        i = i2;
        if (i >= 0) {
            this.markers.remove(i);
        }
    }
}
