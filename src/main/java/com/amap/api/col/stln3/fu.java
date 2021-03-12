package com.amap.api.col.stln3;

import com.amap.api.maps.model.BuildingOverlayOptions;
import java.util.List;

/* compiled from: IBuildingDelegate */
public interface fu {
    void a(BuildingOverlayOptions buildingOverlayOptions);

    void a(List<BuildingOverlayOptions> list);

    List<BuildingOverlayOptions> c();

    BuildingOverlayOptions d();

    void destroy();

    String getId();

    float getZIndex();

    boolean isVisible();

    void setVisible(boolean z);

    void setZIndex(float f);
}
