package com.autonavi.ae.guide.observer;

import com.autonavi.ae.guide.model.CruiseCongestionInfo;
import com.autonavi.ae.guide.model.CruiseFacilityInfo;
import com.autonavi.ae.guide.model.CruiseInfo;
import com.autonavi.ae.guide.model.CruiseTimeAndDistInfo;
import com.autonavi.ae.guide.model.LaneInfo;

public interface GCruiseObserver {
    void onHideCruiseLaneInfo();

    void onShowCruiseLaneInfo(LaneInfo laneInfo);

    void onUpdateCruiseCongestionInfo(CruiseCongestionInfo cruiseCongestionInfo);

    void onUpdateCruiseFacility(CruiseFacilityInfo[] cruiseFacilityInfoArr);

    void onUpdateCruiseInfo(CruiseInfo cruiseInfo);

    void onUpdateCruiseTimeAndDist(CruiseTimeAndDistInfo cruiseTimeAndDistInfo);

    void onUpdateElecCameraInfo(CruiseFacilityInfo[] cruiseFacilityInfoArr);
}
