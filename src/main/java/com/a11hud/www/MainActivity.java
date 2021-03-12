package com.a11hud.www;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.a11hud.www.activities.NaviAcitvity;
import com.a11hud.www.activities.SearchPointActivity;
import com.a11hud.www.service.LocationService;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.Poi;
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
import com.autonavi.tbt.TrafficFacilityInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity {
    private AMapNavi aMapNavi;
    private AMap amap;
    private Button btnMode;
    private Button btnSelectNext;
    private Button btnStartNavi;
    private Context context;
    private String curCity;
    private LatLng curLatLng;
    private LatLng dstLatLng = null;
    private boolean isFirstIn = true;
    private boolean isMoke = true;
    boolean isNaviReady = false;
    private LocationService locationService;
    List<NaviLatLng> mWayPointList = new ArrayList();
    private MapView mapView;
    private SparseArray<RouteOverLay> routeOverlays = new SparseArray<>();
    private LinearLayout route_cal;
    private int selectedRouteID = 0;
    private LatLng startLatLng;
    private TextView txvSelectPoint;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mapView = (MapView) findViewById(R.id.amap_map_view);
        this.mapView.onCreate(savedInstanceState);
        this.amap = this.mapView.getMap();
        this.context = this;
        this.aMapNavi = AMapNavi.getInstance(getApplicationContext());
        checkPermissions();
        initLocation();
        initView();
        initListener();
    }

    private void checkPermissions() {
        for (String s : new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE"}) {
            if (ContextCompat.checkSelfPermission(this, s) != 0) {
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 1);
            }
        }
    }

    private void initView() {
        this.route_cal = (LinearLayout) findViewById(R.id.id_route_cal);
        this.route_cal.setVisibility(8);
        this.btnMode = (Button) findViewById(R.id.id_mode);
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationType(1);
        myLocationStyle.myLocationType(5);
        myLocationStyle.interval(2000);
        this.amap.setMyLocationStyle(myLocationStyle);
        this.amap.setMyLocationEnabled(true);
        this.amap.getUiSettings().setMyLocationButtonEnabled(true);
        this.btnStartNavi = (Button) findViewById(R.id.id_btn_startnavi);
        this.btnSelectNext = (Button) findViewById(R.id.id__btn_nextroute);
        this.txvSelectPoint = (TextView) findViewById(R.id.id_txv_searchpoint);
    }

    private void initListener() {
        this.aMapNavi.setAMapNaviListener(new AMapNaviListener() {
            /* class com.a11hud.www.MainActivity.AnonymousClass1 */

            @Override // com.amap.api.navi.AMapNaviListener
            public void onInitNaviFailure() {
                Toast.makeText(MainActivity.this.context, "Init Navi Failed", 1).show();
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onInitNaviSuccess() {
                Log.i("Info", "地图初始化成功");
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
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onArriveDestination() {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onCalculateRouteFailure(int i) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onReCalculateRouteForYaw() {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onReCalculateRouteForTrafficJam() {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onArrivedWayPoint(int i) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onGpsOpenStatus(boolean b) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onNaviInfoUpdate(NaviInfo naviInfo) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onNaviInfoUpdated(AMapNaviInfo aMapNaviInfo) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void updateCameraInfo(AMapNaviCameraInfo[] aMapNaviCameraInfos) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void updateIntervalCameraInfo(AMapNaviCameraInfo aMapNaviCameraInfo, AMapNaviCameraInfo aMapNaviCameraInfo1, int i) {
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onServiceAreaUpdate(AMapServiceAreaInfo[] aMapServiceAreaInfos) {
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
                MainActivity mainActivity = MainActivity.this;
                mainActivity.isNaviReady = true;
                mainActivity.amap.moveCamera(CameraUpdateFactory.changeTilt(0.0f));
                MainActivity.this.routeOverlays.clear();
                HashMap<Integer, AMapNaviPath> paths = MainActivity.this.aMapNavi.getNaviPaths();
                for (int i = 0; i < ints.length; i++) {
                    RouteOverLay routeOverLay = new RouteOverLay(MainActivity.this.amap, paths.get(Integer.valueOf(ints[i])), MainActivity.this.context);
                    routeOverLay.setTrafficLine(false);
                    routeOverLay.addToMap();
                    MainActivity.this.routeOverlays.put(ints[i], routeOverLay);
                }
                MainActivity.this.findViewById(R.id.id_route_cal).setVisibility(0);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                alphaAnimation.setDuration(2000);
                MainActivity.this.findViewById(R.id.id_route_cal).setAnimation(alphaAnimation);
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
                Context applicationContext = MainActivity.this.getApplicationContext();
                Toast.makeText(applicationContext, "计算路线失败，errorcode＝" + aMapCalcRouteResult.getErrorDetail(), 0).show();
            }

            @Override // com.amap.api.navi.AMapNaviListener
            public void onNaviRouteNotify(AMapNaviRouteNotifyData aMapNaviRouteNotifyData) {
            }
        });
        this.btnStartNavi.setOnClickListener(new View.OnClickListener() {
            /* class com.a11hud.www.MainActivity.AnonymousClass2 */

            public void onClick(View v) {
                if (MainActivity.this.isNaviReady) {
                    Intent intent = new Intent(MainActivity.this, NaviAcitvity.class);
                    intent.putExtra("isMoke", MainActivity.this.isMoke);
                    intent.putExtra("curLatLng", MainActivity.this.curLatLng);
                    intent.putExtra("dstLatLng", MainActivity.this.dstLatLng);
                    intent.putExtra("selectedRouteID", MainActivity.this.selectedRouteID);
                    MainActivity.this.startActivity(intent);
                    return;
                }
                Toast.makeText(MainActivity.this.context, "not ready", 1).show();
            }
        });
        this.btnMode.setOnClickListener(new View.OnClickListener() {
            /* class com.a11hud.www.MainActivity.AnonymousClass3 */

            public void onClick(View v) {
                if (MainActivity.this.isMoke) {
                    MainActivity.this.isMoke = false;
                    MainActivity.this.btnMode.setText("Real");
                    return;
                }
                MainActivity.this.isMoke = true;
                MainActivity.this.btnMode.setText("Moke");
            }
        });
        this.btnSelectNext.setOnClickListener(new View.OnClickListener() {
            /* class com.a11hud.www.MainActivity.AnonymousClass4 */

            public void onClick(View v) {
                MainActivity.this.changeRoute();
            }
        });
        this.txvSelectPoint.setOnClickListener(new View.OnClickListener() {
            /* class com.a11hud.www.MainActivity.AnonymousClass5 */

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchPointActivity.class);
                intent.putExtra("curCity", MainActivity.this.curCity);
                MainActivity.this.startActivityForResult(intent, 100);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void changeRoute() {
        if (!this.isNaviReady) {
            Toast.makeText(this.context, "请先算路", 0).show();
            return;
        }
        this.selectedRouteID++;
        if (this.selectedRouteID >= this.routeOverlays.size()) {
            this.selectedRouteID = 0;
        }
        this.aMapNavi.selectRouteId(this.selectedRouteID);
        for (int i = 0; i < this.routeOverlays.size(); i++) {
            this.routeOverlays.get(this.routeOverlays.keyAt(i)).setTransparency(0.4f);
        }
        SparseArray<RouteOverLay> sparseArray = this.routeOverlays;
        sparseArray.get(sparseArray.keyAt(this.selectedRouteID)).setTransparency(1.0f);
        Toast.makeText(this, "路线标签:" + this.aMapNavi.getNaviPath().getLabels(), 0).show();
    }

    private void initLocation() {
        this.locationService = new LocationService(this.context, new AMapLocationListener() {
            /* class com.a11hud.www.MainActivity.AnonymousClass6 */

            @Override // com.amap.api.location.AMapLocationListener
            public void onLocationChanged(AMapLocation aMapLocation) {
                MainActivity.this.curLatLng = new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude());
                if (MainActivity.this.isFirstIn) {
                    MainActivity.this.amap.animateCamera(CameraUpdateFactory.newLatLng(MainActivity.this.curLatLng));
                    MainActivity.this.isFirstIn = false;
                }
                MainActivity.this.curCity = aMapLocation.getCity();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.amap.clear();
        Poi startPoi = (Poi) data.getParcelableExtra("startPoi");
        Poi dstPoi = (Poi) data.getParcelableExtra("dstPoi");
        if (startPoi == null) {
            this.startLatLng = this.curLatLng;
        } else {
            this.startLatLng = startPoi.getCoordinate();
        }
        this.dstLatLng = dstPoi.getCoordinate();
        if (this.dstLatLng == null) {
            Toast.makeText(this.context, "Long click to get destination point", 1).show();
            return;
        }
        int strategy = 0;
        try {
            strategy = this.aMapNavi.strategyConvert(false, false, false, false, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<NaviLatLng> sList = new ArrayList<>();
        List<NaviLatLng> eList = new ArrayList<>();
        sList.add(new NaviLatLng(this.startLatLng.latitude, this.startLatLng.longitude));
        eList.add(new NaviLatLng(this.dstLatLng.latitude, this.dstLatLng.longitude));
        this.aMapNavi.calculateDriveRoute(sList, eList, this.mWayPointList, strategy);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mapView.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.mapView.onDestroy();
        this.locationService.destory();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mapView.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.locationService.start();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.locationService.stop();
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.aMapNavi.stopNavi();
        finish();
    }
}
