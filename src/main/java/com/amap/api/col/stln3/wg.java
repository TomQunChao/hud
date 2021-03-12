package com.amap.api.col.stln3;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;

/* compiled from: MapLocClientUtils */
public final class wg {
    we a = null;

    public static void a(Object obj, Inner_3dMap_locationOption inner_3dMap_locationOption) {
        AMapLocationClientOption.AMapLocationMode aMapLocationMode;
        if (obj != null) {
            AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
            aMapLocationClientOption.setInterval(inner_3dMap_locationOption.getInterval());
            AMapLocationClientOption.AMapLocationMode aMapLocationMode2 = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
            switch (inner_3dMap_locationOption.getLocationMode()) {
                case Battery_Saving:
                    aMapLocationMode = AMapLocationClientOption.AMapLocationMode.Battery_Saving;
                    break;
                case Device_Sensors:
                    aMapLocationMode = AMapLocationClientOption.AMapLocationMode.Device_Sensors;
                    break;
                case Hight_Accuracy:
                default:
                    aMapLocationMode = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
                    break;
            }
            aMapLocationClientOption.setLocationMode(aMapLocationMode);
            aMapLocationClientOption.setOnceLocation(inner_3dMap_locationOption.isOnceLocation());
            aMapLocationClientOption.setNeedAddress(inner_3dMap_locationOption.isNeedAddress());
            ((AMapLocationClient) obj).setLocationOption(aMapLocationClientOption);
        }
    }

    public final void a(Object obj, Inner_3dMap_locationListener inner_3dMap_locationListener) {
        if (this.a == null) {
            this.a = new we();
        }
        this.a.a(inner_3dMap_locationListener);
        ((AMapLocationClient) obj).setLocationListener(this.a);
    }
}
