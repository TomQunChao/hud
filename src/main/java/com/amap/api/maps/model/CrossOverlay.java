package com.amap.api.maps.model;

import android.graphics.Bitmap;
import com.autonavi.ae.gmap.gloverlay.CrossVectorOverlay;
import com.autonavi.ae.gmap.gloverlay.GLCrossVector;

public class CrossOverlay {
    CrossVectorOverlay a = null;

    public interface GenerateCrossImageListener {
        void onGenerateComplete(Bitmap bitmap, int i);
    }

    public CrossOverlay(CrossOverlayOptions crossOverlayOptions, CrossVectorOverlay crossVectorOverlay) {
        this.a = crossVectorOverlay;
    }

    public int setData(byte[] bArr) {
        CrossVectorOverlay crossVectorOverlay;
        if (bArr == null || (crossVectorOverlay = this.a) == null) {
            return -1;
        }
        try {
            return crossVectorOverlay.setData(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public void setAttribute(GLCrossVector.AVectorCrossAttr aVectorCrossAttr) {
        try {
            this.a.setAttribute(aVectorCrossAttr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z) {
        CrossVectorOverlay crossVectorOverlay = this.a;
        if (crossVectorOverlay != null) {
            try {
                crossVectorOverlay.setVisible(z);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void remove() {
        CrossVectorOverlay crossVectorOverlay = this.a;
        if (crossVectorOverlay != null) {
            try {
                crossVectorOverlay.remove();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setImageMode(boolean z) {
        CrossVectorOverlay crossVectorOverlay = this.a;
        if (crossVectorOverlay != null) {
            try {
                crossVectorOverlay.setImageMode(z);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setGenerateCrossImageListener(GenerateCrossImageListener generateCrossImageListener) {
        CrossVectorOverlay crossVectorOverlay = this.a;
        if (crossVectorOverlay != null) {
            try {
                crossVectorOverlay.setGenerateCrossImageListener(generateCrossImageListener);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
