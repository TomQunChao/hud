package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.animation.GLAnimation;

public interface IAnimation {
    void setAnimation(GLAnimation gLAnimation);

    void setAnimationListener(Animation.AnimationListener animationListener);

    boolean startAnimation();
}
