package com.autonavi.ae.gmap.glanimation;

import com.amap.api.maps.AMap;
import com.autonavi.ae.gmap.GLMapState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdglMapAnimationMgr {
    private List<AbstractAdglAnimation> list = Collections.synchronizedList(new ArrayList());
    private AMap.CancelableCallback mCancelCallback;
    private MapAnimationListener mMapAnimationListener;

    public interface MapAnimationListener {
        void onMapAnimationFinish(AMap.CancelableCallback cancelableCallback);
    }

    public void setMapCoreListener() {
    }

    public synchronized void clearAnimations() {
        this.list.clear();
    }

    public synchronized int getAnimationsCount() {
        return this.list.size();
    }

    public synchronized void doAnimations(GLMapState gLMapState) {
        if (gLMapState != null) {
            if (this.list.size() > 0) {
                AbstractAdglAnimation abstractAdglAnimation = this.list.get(0);
                if (abstractAdglAnimation != null) {
                    if (abstractAdglAnimation.isOver()) {
                        if (this.mMapAnimationListener != null) {
                            this.mMapAnimationListener.onMapAnimationFinish(this.mCancelCallback);
                        }
                        this.list.remove(abstractAdglAnimation);
                        return;
                    }
                    abstractAdglAnimation.doAnimation(gLMapState);
                }
            }
        }
    }

    public void addAnimation(AbstractAdglAnimation abstractAdglAnimation, AMap.CancelableCallback cancelableCallback) {
        if (abstractAdglAnimation != null) {
            synchronized (this.list) {
                if (!abstractAdglAnimation.isOver() && this.list.size() > 0) {
                    AbstractAdglAnimation abstractAdglAnimation2 = this.list.get(this.list.size() - 1);
                    if (abstractAdglAnimation2 != null && (abstractAdglAnimation instanceof AdglMapAnimGroup) && (abstractAdglAnimation2 instanceof AdglMapAnimGroup)) {
                        if (((AdglMapAnimGroup) abstractAdglAnimation).typeEqueal((AdglMapAnimGroup) abstractAdglAnimation2)) {
                            if (!((AdglMapAnimGroup) abstractAdglAnimation).needMove) {
                                this.list.remove(abstractAdglAnimation2);
                            }
                        }
                    }
                }
                this.list.add(abstractAdglAnimation);
                this.mCancelCallback = cancelableCallback;
            }
        }
    }

    public AMap.CancelableCallback getCancelCallback() {
        return this.mCancelCallback;
    }

    public void setMapAnimationListener(MapAnimationListener mapAnimationListener) {
        synchronized (this) {
            this.mMapAnimationListener = mapAnimationListener;
        }
    }
}
