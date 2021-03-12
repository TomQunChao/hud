package com.amap.api.maps.model;

import com.amap.api.col.stln3.fu;
import java.util.List;

public class BuildingOverlay {
    private fu a;

    public BuildingOverlay(fu fuVar) {
        this.a = fuVar;
    }

    public void setDefaultOptions(BuildingOverlayOptions buildingOverlayOptions) {
        fu fuVar = this.a;
        if (fuVar != null) {
            fuVar.a(buildingOverlayOptions);
        }
    }

    public BuildingOverlayOptions getDefaultOptions() {
        fu fuVar = this.a;
        if (fuVar != null) {
            return fuVar.d();
        }
        return null;
    }

    public void setCustomOptions(List<BuildingOverlayOptions> list) {
        fu fuVar = this.a;
        if (fuVar != null) {
            fuVar.a(list);
        }
    }

    public List<BuildingOverlayOptions> getCustomOptions() {
        fu fuVar = this.a;
        if (fuVar != null) {
            return fuVar.c();
        }
        return null;
    }

    public void destroy() {
        fu fuVar = this.a;
        if (fuVar != null) {
            fuVar.destroy();
        }
    }

    public String getId() {
        fu fuVar = this.a;
        if (fuVar != null) {
            return fuVar.getId();
        }
        return "";
    }

    public void setZIndex(float f) {
        fu fuVar = this.a;
        if (fuVar != null) {
            fuVar.setZIndex(f);
        }
    }

    public float getZIndex() {
        fu fuVar = this.a;
        if (fuVar != null) {
            return fuVar.getZIndex();
        }
        return 0.0f;
    }

    public void setVisible(boolean z) {
        fu fuVar = this.a;
        if (fuVar != null) {
            fuVar.setVisible(z);
        }
    }

    public boolean isVisible() {
        fu fuVar = this.a;
        if (fuVar != null) {
            return fuVar.isVisible();
        }
        return false;
    }
}
