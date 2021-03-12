package com.amap.api.navi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.a11hud.www.R;
import com.amap.api.col.stln3.ma;
import com.amap.api.col.stln3.mj;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.model.AMapNaviMarkerOptions;
import com.amap.api.navi.model.NaviLatLng;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AmapNaviPage {
    public static final String CAR_INFO = "car_info";
    public static final String ISMULTIPLEROUTENAVIMODE = "ismultipleroutenavimode";
    public static final String ISNEEDCALCULATEROUTEWHENPRESENT = "isNeedCalculateRouteWhenPresent";
    public static final String ISNEEDDESTROYDRIVEMANAGERINSTANCEWHENNAVIEXIT = "isNeedDestroyDriveManagerInstanceWhenNaviExit";
    public static final String ISSHOWEXITNAVIDIALOG = "isShowExitNaviDialog";
    public static final String ISUSEINNERVOICE = "isUseInnerVoice";
    private static AmapNaviPage OUR_INSTANCE = null;
    public static final String PAGE_TYPE = "isNaviPage";
    public static final String PLANSTRATEGY = "planStrategy";
    public static final String POI_DATA = "data";
    public static final String POI_END = "end_poi";
    public static final String POI_START = "start_poi";
    public static final String POI_WAY1 = "way_poi1";
    public static final String POI_WAY2 = "way_poi2";
    public static final String POI_WAY3 = "way_poi3";
    public static final String SHOWCROSSIMAGE = "showCrossImage";
    public static final String SHOWROUTESTRATEGYPREFERENCEVIEW = "showRouteStrategyPreferenceView";
    public static final String TAG = "AmapNaviPage";
    public static final String THEME_DATA = "theme";
    public static final String THEME_ID = "themeId";
    private INaviInfoCallback callback;
    private boolean isShowRouteStrategyPreferenceView = true;
    private boolean isTrafficeEnable = false;
    private Poi poi1;
    private Poi poi2;
    private Poi poi3;
    private List<Poi> wayPointList = new ArrayList();

    public static synchronized AmapNaviPage getInstance() {
        AmapNaviPage amapNaviPage;
        synchronized (AmapNaviPage.class) {
            if (OUR_INSTANCE == null) {
                OUR_INSTANCE = new AmapNaviPage();
            }
            amapNaviPage = OUR_INSTANCE;
        }
        return amapNaviPage;
    }

    private void destroyImpl() {
        this.callback = null;
        List<Poi> list = this.wayPointList;
        if (list != null) {
            list.clear();
            this.wayPointList = null;
        }
    }

    public static synchronized void destroy() {
        synchronized (AmapNaviPage.class) {
            if (OUR_INSTANCE != null) {
                OUR_INSTANCE.destroyImpl();
            }
            OUR_INSTANCE = null;
        }
    }

    private AmapNaviPage() {
    }

    public INaviInfoCallback getCallback() {
        return this.callback;
    }

    public void showRouteActivity(Context context, AmapNaviParams amapNaviParams, INaviInfoCallback iNaviInfoCallback) {
        showRouteActivity(context, amapNaviParams, iNaviInfoCallback, AmapRouteActivity.class);
    }

    public void showRouteActivity(Context context, AmapNaviParams amapNaviParams, INaviInfoCallback iNaviInfoCallback, Class cls) {
        Bundle bundle;
        int i;
        try {
            this.wayPointList.clear();
            Poi poi = null;
            this.poi1 = null;
            this.poi2 = null;
            this.poi3 = null;
            if (context == null || amapNaviParams == null) {
                throw new Exception("context == null 或者 params == null");
            }
            if (iNaviInfoCallback != null) {
                this.callback = iNaviInfoCallback;
            }
            Poi end = amapNaviParams.getEnd();
            if (end != null) {
                if (end.getCoordinate() != null || !TextUtils.isEmpty(end.getPoiId())) {
                    String str = "终点";
                    if (!TextUtils.isEmpty(end.getName())) {
                        str = end.getName();
                    }
                    end = new Poi(str, end.getCoordinate(), end.getPoiId());
                } else {
                    end = null;
                }
            }
            Poi start = amapNaviParams.getStart();
            if (start == null) {
                poi = start;
            } else if (start.getCoordinate() != null || !TextUtils.isEmpty(start.getPoiId())) {
                String str2 = "起点";
                if (!TextUtils.isEmpty(start.getName())) {
                    str2 = start.getName();
                }
                poi = new Poi(str2, start.getCoordinate(), start.getPoiId());
            }
            List<Poi> ways = amapNaviParams.getWays();
            int i2 = 0;
            if (ways != null && ways.size() > 0) {
                for (int i3 = 0; i3 < ways.size(); i3++) {
                    if (i3 < 3) {
                        Poi poi4 = ways.get(i3);
                        if (poi4 != null && (poi4.getCoordinate() != null || !TextUtils.isEmpty(poi4.getPoiId()))) {
                            this.wayPointList.add(poi4);
                        }
                    }
                }
            }
            checkMid();
            Intent intent = new Intent(context, cls);
            AmapPageType pageType = amapNaviParams.getPageType();
            intent.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
            if (amapNaviParams.getBundle() != null) {
                bundle = amapNaviParams.getBundle();
            } else {
                bundle = new Bundle();
            }
            if (pageType == AmapPageType.NAVI) {
                if (amapNaviParams.isNeedCalculateRouteWhenPresent()) {
                    if (end != null) {
                        if (end.getCoordinate() != null || !TextUtils.isEmpty(end.getPoiId())) {
                            if (end.getCoordinate() != null) {
                                if (!mj.a(new NaviLatLng(end.getCoordinate().latitude, end.getCoordinate().longitude))) {
                                    ma.a(context, "终点经纬度不合法!");
                                    return;
                                }
                            }
                        }
                    }
                    ma.a(context, "直接导航，终点不能为空!");
                    return;
                }
                bundle.putInt("navi_mode", AMapNavi.getInstance(context).getNaviType());
                bundle.putBoolean(PAGE_TYPE, true);
            } else {
                bundle.putBoolean(PAGE_TYPE, false);
                if (amapNaviParams.getNaviType() != AmapNaviType.RIDE) {
                    if (amapNaviParams.getNaviType() == AmapNaviType.WALK) {
                    }
                }
                if (end.getCoordinate() != null) {
                    if (!mj.a(new NaviLatLng(end.getCoordinate().latitude, end.getCoordinate().longitude))) {
                        ma.a(context, "终点经纬度不合法!");
                        return;
                    }
                }
            }
            switch (amapNaviParams.getTheme()) {
                case BLUE:
                    i = R.drawable.abc_ab_share_pack_mtrl_alpha;
                    break;
                case WHITE:
                    i = R.drawable.abc_action_bar_item_background_material;
                    break;
                case BLACK:
                    i = R.drawable.abc_btn_borderless_material;
                    break;
                default:
                    i = R.drawable.$ic_launcher_foreground__0;
                    break;
            }
            switch (amapNaviParams.getNaviType()) {
                case RIDE:
                    i2 = 2;
                    break;
                case WALK:
                    i2 = 1;
                    break;
            }
            bundle.putBoolean(ISNEEDCALCULATEROUTEWHENPRESENT, amapNaviParams.isNeedCalculateRouteWhenPresent());
            bundle.putBoolean(ISNEEDDESTROYDRIVEMANAGERINSTANCEWHENNAVIEXIT, amapNaviParams.isNeedDestroyDriveManagerInstanceWhenNaviExit());
            bundle.putBoolean(ISSHOWEXITNAVIDIALOG, amapNaviParams.isShowExitNaviDialog());
            bundle.putBoolean(ISUSEINNERVOICE, amapNaviParams.getIsUseInnerVoice());
            bundle.putBoolean(SHOWCROSSIMAGE, amapNaviParams.isShowCrossImage());
            bundle.putBoolean(SHOWROUTESTRATEGYPREFERENCEVIEW, amapNaviParams.isShowRouteStrategyPreferenceView());
            bundle.putBoolean(ISMULTIPLEROUTENAVIMODE, amapNaviParams.isMultipleRouteNaviMode());
            if (amapNaviParams.getRouteStrategy() >= 0) {
                bundle.putInt(PLANSTRATEGY, amapNaviParams.getRouteStrategy());
            }
            this.isTrafficeEnable = amapNaviParams.isTrafficEnabled();
            this.isShowRouteStrategyPreferenceView = amapNaviParams.isShowRouteStrategyPreferenceView();
            bundle.putInt("navi_type", i2);
            bundle.putParcelable(POI_START, poi);
            bundle.putParcelable(POI_END, end);
            bundle.putParcelable(POI_WAY1, this.poi1);
            bundle.putParcelable(POI_WAY2, this.poi2);
            bundle.putParcelable(POI_WAY3, this.poi3);
            bundle.putParcelable(CAR_INFO, amapNaviParams.getCarInfo());
            intent.putExtra("data", bundle);
            Bundle bundle2 = new Bundle();
            bundle2.putInt(THEME_ID, i);
            intent.putExtra(THEME_DATA, bundle2);
            context.startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void exitRouteActivity() {
        if (AmapRouteActivity.context != null) {
            AmapRouteActivity.context.finish();
        }
    }

    private void removeSamePois() {
        HashSet<a> hashSet = new HashSet();
        for (Poi poi : this.wayPointList) {
            hashSet.add(new a(poi));
        }
        this.wayPointList.clear();
        for (a aVar : hashSet) {
            this.wayPointList.add(new Poi(aVar.a, aVar.b, aVar.c));
        }
    }

    private void checkMid() {
        try {
            removeSamePois();
            if (this.wayPointList != null && this.wayPointList.size() > 0) {
                switch (this.wayPointList.size()) {
                    case 1:
                        this.poi1 = this.wayPointList.get(0);
                        if (TextUtils.isEmpty(this.poi1.getName())) {
                            this.poi1 = new Poi("途径点1", this.poi1.getCoordinate(), this.poi1.getPoiId());
                            return;
                        }
                        return;
                    case 2:
                        this.poi1 = this.wayPointList.get(0);
                        if (TextUtils.isEmpty(this.poi1.getName())) {
                            this.poi1 = new Poi("途径点1", this.poi1.getCoordinate(), this.poi1.getPoiId());
                        }
                        this.poi2 = this.wayPointList.get(1);
                        if (TextUtils.isEmpty(this.poi2.getName())) {
                            this.poi2 = new Poi("途径点2", this.poi2.getCoordinate(), this.poi2.getPoiId());
                            return;
                        }
                        return;
                    case 3:
                        this.poi1 = this.wayPointList.get(0);
                        if (TextUtils.isEmpty(this.poi1.getName())) {
                            this.poi1 = new Poi("途径点1", this.poi1.getCoordinate(), this.poi1.getPoiId());
                        }
                        this.poi2 = this.wayPointList.get(1);
                        if (TextUtils.isEmpty(this.poi2.getName())) {
                            this.poi2 = new Poi("途径点2", this.poi2.getCoordinate(), this.poi2.getPoiId());
                        }
                        this.poi3 = this.wayPointList.get(2);
                        if (TextUtils.isEmpty(this.poi3.getName())) {
                            this.poi3 = new Poi("途径点3", this.poi3.getCoordinate(), this.poi3.getPoiId());
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public String a = "";
        public LatLng b;
        public String c = "";

        public a(Poi poi) {
            if (poi != null) {
                this.b = poi.getCoordinate();
                this.a = poi.getName() != null ? poi.getName() : "";
                this.c = poi.getPoiId() != null ? poi.getPoiId() : "";
            }
        }

        public final boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            a aVar = (a) obj;
            String str = aVar.c;
            if (str == null) {
                str = "";
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.c)) {
                if (this.b.equals(aVar.b)) {
                    return true;
                }
            } else if (this.c.equals(str)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return 0;
        }
    }

    public void addMarker(AMapNaviMarkerOptions aMapNaviMarkerOptions) {
        if (AmapRouteActivity.context != null) {
            AmapRouteActivity.context.addPositionMarker(aMapNaviMarkerOptions);
        }
    }

    public void updateMarker(AMapNaviMarkerOptions aMapNaviMarkerOptions) {
        if (AmapRouteActivity.context != null) {
            AmapRouteActivity.context.updateMarkerPosition(aMapNaviMarkerOptions);
        }
    }

    public void removeMarker(AMapNaviMarkerOptions aMapNaviMarkerOptions) {
        if (AmapRouteActivity.context != null) {
            AmapRouteActivity.context.removePositionMarker(aMapNaviMarkerOptions);
        }
    }

    public boolean isShowRouteStrategyPreferenceView() {
        return this.isShowRouteStrategyPreferenceView;
    }

    public boolean isTrafficEnable() {
        return this.isTrafficeEnable;
    }
}
