package com.a11hud.www.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.a11hud.www.R;
import com.a11hud.www.service.LocationService;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.AMapNaviListener;
import com.amap.api.navi.model.AMapCalcRouteResult;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapModelCross;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapNaviRouteNotifyData;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AMapServiceAreaInfo;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.navi.view.RouteOverLay;
import com.amap.api.navi.view.TrafficProgressBar;
import com.autonavi.tbt.TrafficFacilityInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NaviAcitvity extends Activity {
    private AMap aMap;
    private AMapNavi aMapNavi = null;
    private Context context;
    private int curAllLength = 0;
    private LatLng curLatLng;
    private int curSpeed = 0;
    private LatLng dstLatLng;
    private ImageView imageAlert;
    private ImageView imageInfo;
    private ImageView imageMainDirection;
    private ImageView imageMergeLeft;
    private ImageView imageMergeRight;
    private boolean isMoke = true;
    private LocationService locationService;
    List<NaviLatLng> mWayPointList = new ArrayList();
    private MapView naviOverview = null;
    private int remainDistance = 0;
    private int remainTime = 0;
    private SparseArray<RouteOverLay> routeOverlays = new SparseArray<>();
    private int selectRouteID = 0;
    private TrafficProgressBar trafficBar = null;
    private TextView txvAlertDistance;
    private TextView txvAlertValue;
    private TextView txvDistance;
    private TextView txvOil;
    private TextView txvSpeed;
    private TextView txvTime;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = this;
        setContentView(R.layout.activity_navi_acitvity);
        this.naviOverview = (MapView) findViewById(R.id.navi_overview);
        this.naviOverview.onCreate(savedInstanceState);
        this.aMap = this.naviOverview.getMap();
        this.aMapNavi = AMapNavi.getInstance(getApplicationContext());
        this.aMapNavi.setEmulatorNaviSpeed(120);
        this.aMapNavi.setUseInnerVoice(true);
        this.isMoke = getIntent().getBooleanExtra("isMoke", true);
        this.aMapNavi.startNavi(this.isMoke ? AMapNavi.EmulatorNaviMode : AMapNavi.GPSNaviMode);
        initLocation();
        initListener();
        initView();
        Log.i("Info", "已经进入导航界面");
    }

    private void initView() {
        this.txvDistance = (TextView) findViewById(R.id.id_txv_distance);
        this.txvTime = (TextView) findViewById(R.id.id_txv_time);
        this.txvSpeed = (TextView) findViewById(R.id.id_txv_speed);
        this.txvOil = (TextView) findViewById(R.id.id_txv_oil);
        this.trafficBar = (TrafficProgressBar) findViewById(R.id.id_trafficbar);
        this.aMap.setMapCustomEnable(true);
        this.aMap.setCustomMapStyleID("a2035a089f6f4458628b1bdecb667527");
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.interval(1000);
        myLocationStyle.myLocationType(3);
        this.aMap.setMyLocationStyle(myLocationStyle);
        this.aMap.getUiSettings().setMyLocationButtonEnabled(false);
        this.aMap.setMyLocationEnabled(true);
        this.aMap.animateCamera(CameraUpdateFactory.zoomTo(12.0f));
        Bundle bundle = getIntent().getExtras();
        this.curLatLng = (LatLng) bundle.get("curLatLng");
        this.dstLatLng = (LatLng) bundle.get("dstLatLng");
        this.selectRouteID = ((Integer) bundle.get("selectedRouteID")).intValue();
        int strategy = 0;
        try {
            strategy = this.aMapNavi.strategyConvert(false, false, false, false, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<NaviLatLng> sList = new ArrayList<>();
        List<NaviLatLng> eList = new ArrayList<>();
        sList.add(new NaviLatLng(this.curLatLng.latitude, this.curLatLng.longitude));
        eList.add(new NaviLatLng(this.dstLatLng.latitude, this.dstLatLng.longitude));
        this.aMapNavi.calculateDriveRoute(sList, eList, this.mWayPointList, strategy);
        getWindow().getDecorView().setSystemUiVisibility(2);
        getWindow().getDecorView().setSystemUiVisibility(4);
        this.txvAlertDistance = (TextView) findViewById(R.id.id_txv_alertdistance);
        this.imageAlert = (ImageView) findViewById(R.id.id_image_alert);
        this.txvAlertValue = (TextView) findViewById(R.id.id_txv_alertvalue);
        this.imageInfo = (ImageView) findViewById(R.id.id_image_info);
        this.imageMainDirection = (ImageView) findViewById(R.id.id_image_maindirection);
        this.imageMergeLeft = (ImageView) findViewById(R.id.id_image_mergeleft);
        this.imageMergeRight = (ImageView) findViewById(R.id.id_image_mergeright);
    }

    private void initListener() {
        this.aMapNavi.setAMapNaviListener(new AMapNaviListener() {
            /* class com.a11hud.www.activities.NaviAcitvity.AnonymousClass1 */

            @Override // com.amap.api.navi.AMapNaviListener
            public void onInitNaviFailure() {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onInitNaviSuccess() {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onStartNavi(int i) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onTrafficStatusUpdate() {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onLocationChange(AMapNaviLocation aMapNaviLocation) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onGetNavigationText(int i, String s) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onGetNavigationText(String s) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onEndEmulatorNavi() {
                NaviAcitvity.this.aMapNavi.stopNavi();
                NaviAcitvity.this.finish();
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onArriveDestination() {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onCalculateRouteFailure(int i) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onReCalculateRouteForYaw() {
                Toast.makeText(NaviAcitvity.this.context, "您已偏离原来的路线,正在为您重新规划路线", 0).show();
                NaviAcitvity.this.aMap.moveCamera(CameraUpdateFactory.changeTilt(0.0f));
                NaviAcitvity.this.routeOverlays.clear();
                RouteOverLay routeOverLay = new RouteOverLay(NaviAcitvity.this.aMap, NaviAcitvity.this.aMapNavi.getNaviPaths().get(Integer.valueOf((int) NaviAcitvity.this.aMapNavi.getNaviPath().getPathid())), NaviAcitvity.this.context);
                routeOverLay.setTrafficLine(false);
                routeOverLay.addToMap();
                NaviAcitvity.this.routeOverlays.put((int) NaviAcitvity.this.aMapNavi.getNaviPath().getPathid(), routeOverLay);
                NaviAcitvity.this.aMapNavi.startNavi(NaviAcitvity.this.isMoke ? AMapNavi.EmulatorNaviMode : AMapNavi.GPSNaviMode);
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onReCalculateRouteForTrafficJam() {
                Toast.makeText(NaviAcitvity.this.context, "前方拥堵，正在为您重新规划路线", 0).show();
                NaviAcitvity.this.aMap.moveCamera(CameraUpdateFactory.changeTilt(0.0f));
                NaviAcitvity.this.routeOverlays.clear();
                RouteOverLay routeOverLay = new RouteOverLay(NaviAcitvity.this.aMap, NaviAcitvity.this.aMapNavi.getNaviPaths().get(Integer.valueOf((int) NaviAcitvity.this.aMapNavi.getNaviPath().getPathid())), NaviAcitvity.this.context);
                routeOverLay.setTrafficLine(false);
                routeOverLay.addToMap();
                NaviAcitvity.this.routeOverlays.put((int) NaviAcitvity.this.aMapNavi.getNaviPath().getPathid(), routeOverLay);
                NaviAcitvity.this.aMapNavi.startNavi(NaviAcitvity.this.isMoke ? AMapNavi.EmulatorNaviMode : AMapNavi.GPSNaviMode);
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onArrivedWayPoint(int i) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onGpsOpenStatus(boolean b) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onNaviInfoUpdate(NaviInfo naviInfo) {
                NaviAcitvity.this.trafficBar.update(NaviAcitvity.this.curAllLength, NaviAcitvity.this.remainDistance, NaviAcitvity.this.aMapNavi.getTrafficStatuses(0, 0));
                NaviAcitvity.this.remainDistance = naviInfo.getPathRetainDistance();
                NaviAcitvity.this.remainTime = naviInfo.getPathRetainTime();
                NaviAcitvity.this.curSpeed = naviInfo.getCurrentSpeed();
                NaviAcitvity.this.txvSpeed.setText(String.format("%dkm/h", Integer.valueOf(NaviAcitvity.this.curSpeed)));
                NaviAcitvity.this.txvDistance.setText(String.format("%.1fkm", Float.valueOf(((float) NaviAcitvity.this.remainDistance) / 1000.0f)));
                NaviAcitvity.this.txvTime.setText(String.format("%.1fmin", Float.valueOf(((float) NaviAcitvity.this.remainTime) / 60.0f)));
                int iconType = naviInfo.getIconType();
                if (iconType != 9) {
                    switch (iconType) {
                        case 2:
                            NaviAcitvity.this.imageMainDirection.setImageResource(R.mipmap.left);
                            NaviAcitvity.this.imageMergeLeft.setImageBitmap(null);
                            NaviAcitvity.this.imageMergeRight.setImageBitmap(null);
                            return;
                        case 3:
                            NaviAcitvity.this.imageMainDirection.setImageResource(R.mipmap.right);
                            NaviAcitvity.this.imageMergeLeft.setImageBitmap(null);
                            NaviAcitvity.this.imageMergeRight.setImageBitmap(null);
                            return;
                        case 4:
                            NaviAcitvity.this.imageMainDirection.setImageResource(R.mipmap.lf);
                            NaviAcitvity.this.imageMergeLeft.setImageBitmap(null);
                            NaviAcitvity.this.imageMergeRight.setImageBitmap(null);
                            return;
                        case 5:
                            NaviAcitvity.this.imageMainDirection.setImageResource(R.mipmap.rf);
                            NaviAcitvity.this.imageMergeLeft.setImageBitmap(null);
                            NaviAcitvity.this.imageMergeRight.setImageBitmap(null);
                            return;
                        case 6:
                            NaviAcitvity.this.imageMainDirection.setImageResource(R.mipmap.lb);
                            NaviAcitvity.this.imageMergeLeft.setImageBitmap(null);
                            NaviAcitvity.this.imageMergeRight.setImageBitmap(null);
                            return;
                        case 7:
                            NaviAcitvity.this.imageMainDirection.setImageResource(R.mipmap.rb);
                            NaviAcitvity.this.imageMergeLeft.setImageBitmap(null);
                            NaviAcitvity.this.imageMergeRight.setImageBitmap(null);
                            return;
                        default:
                            switch (iconType) {
                                case 51:
                                    NaviAcitvity.this.imageMergeLeft.setImageResource(R.mipmap.merge_left);
                                    NaviAcitvity.this.imageMergeRight.setImageBitmap(null);
                                    return;
                                case 52:
                                    NaviAcitvity.this.imageMergeRight.setImageResource(R.mipmap.merge_right);
                                    NaviAcitvity.this.imageMergeLeft.setImageBitmap(null);
                                    return;
                                default:
                                    NaviAcitvity.this.imageMainDirection.setImageResource(R.mipmap.straight);
                                    NaviAcitvity.this.imageMergeLeft.setImageBitmap(null);
                                    NaviAcitvity.this.imageMergeRight.setImageBitmap(null);
                                    return;
                            }
                    }
                } else {
                    NaviAcitvity.this.imageMainDirection.setImageResource(R.mipmap.straight);
                    NaviAcitvity.this.imageMergeLeft.setImageBitmap(null);
                    NaviAcitvity.this.imageMergeRight.setImageBitmap(null);
                }
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onNaviInfoUpdated(AMapNaviInfo aMapNaviInfo) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void updateCameraInfo(AMapNaviCameraInfo[] aMapNaviCameraInfos) {
                TextView textView = NaviAcitvity.this.txvAlertValue;
                textView.setText(aMapNaviCameraInfos[0].getAverageSpeed() + "/" + aMapNaviCameraInfos[0].getCameraSpeed());
                NaviAcitvity.this.txvAlertDistance.setText(aMapNaviCameraInfos[0].getCameraDistance());
                NaviAcitvity.this.imageAlert.setVisibility(0);
                NaviAcitvity.this.imageAlert.setImageResource(R.mipmap.camera);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                NaviAcitvity.this.imageAlert.setVisibility(4);
                NaviAcitvity.this.txvAlertDistance.setText("");
                NaviAcitvity.this.txvAlertValue.setText("");
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void updateIntervalCameraInfo(AMapNaviCameraInfo aMapNaviCameraInfo, AMapNaviCameraInfo aMapNaviCameraInfo1, int i) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onServiceAreaUpdate(AMapServiceAreaInfo[] aMapServiceAreaInfos) {
                NaviAcitvity.this.imageInfo.setVisibility(0);
                NaviAcitvity.this.imageInfo.setImageResource(R.mipmap.service_area);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                NaviAcitvity.this.imageInfo.setVisibility(4);
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void showCross(AMapNaviCross aMapNaviCross) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void hideCross() {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void showModeCross(AMapModelCross aMapModelCross) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void hideModeCross() {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void showLaneInfo(AMapLaneInfo[] aMapLaneInfos, byte[] bytes, byte[] bytes1) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void showLaneInfo(AMapLaneInfo aMapLaneInfo) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void hideLaneInfo() {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onCalculateRouteSuccess(int[] ints) {
                NaviAcitvity.this.aMap.moveCamera(CameraUpdateFactory.changeTilt(0.0f));
                NaviAcitvity.this.routeOverlays.clear();
                HashMap<Integer, AMapNaviPath> paths = NaviAcitvity.this.aMapNavi.getNaviPaths();
                for (int i = 0; i < ints.length; i++) {
                    RouteOverLay routeOverLay = new RouteOverLay(NaviAcitvity.this.aMap, paths.get(Integer.valueOf(ints[i])), NaviAcitvity.this.context);
                    routeOverLay.setTrafficLine(true);
                    routeOverLay.addToMap();
                    NaviAcitvity.this.routeOverlays.put(ints[i], routeOverLay);
                }
                NaviAcitvity.this.curAllLength = paths.get(Integer.valueOf(ints[0])).getAllLength();
                for (int i2 = 0; i2 < NaviAcitvity.this.routeOverlays.size(); i2++) {
                    ((RouteOverLay) NaviAcitvity.this.routeOverlays.get(NaviAcitvity.this.routeOverlays.keyAt(i2))).setTransparency(0.4f);
                }
                ((RouteOverLay) NaviAcitvity.this.routeOverlays.get(NaviAcitvity.this.routeOverlays.keyAt(NaviAcitvity.this.selectRouteID))).setTransparency(1.0f);
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void notifyParallelRoad(int i) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo aMapNaviTrafficFacilityInfo) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo[] aMapNaviTrafficFacilityInfos) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void OnUpdateTrafficFacility(TrafficFacilityInfo trafficFacilityInfo) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void updateAimlessModeStatistics(AimLessModeStat aimLessModeStat) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void updateAimlessModeCongestionInfo(AimLessModeCongestionInfo aimLessModeCongestionInfo) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onPlayRing(int i) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onCalculateRouteSuccess(AMapCalcRouteResult aMapCalcRouteResult) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onCalculateRouteFailure(AMapCalcRouteResult aMapCalcRouteResult) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onNaviRouteNotify(AMapNaviRouteNotifyData aMapNaviRouteNotifyData) {
            }
        });
    }

    private void initLocation() {
        this.locationService = new LocationService(this.context, new AMapLocationListener() {
            /* class com.a11hud.www.activities.NaviAcitvity.AnonymousClass2 */

            @Override // com.amap.api.location.AMapLocationListener
            public void onLocationChanged(AMapLocation aMapLocation) {
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.locationService.stop();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.locationService.start();
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.aMapNavi.stopNavi();
        finish();
    }
}
