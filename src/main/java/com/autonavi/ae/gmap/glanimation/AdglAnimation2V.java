package com.autonavi.ae.gmap.glanimation;

import android.os.SystemClock;

public class AdglAnimation2V extends AbstractAdglAnimation {
    private double curValue1;
    private double curValue2;
    private AbstractAdglAnimationParam2V v2Param = null;

    public AdglAnimation2V(int i) {
        reset();
        this.duration = i;
        this.curValue1 = 0.0d;
        this.curValue2 = 0.0d;
    }

    public void reset() {
        this.isOver = false;
        this.duration = 0;
        this.curValue1 = 0.0d;
        this.curValue2 = 0.0d;
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.reset();
        }
    }

    public void setAnimationValue(float f, float f2, float f3, float f4, int i) {
        if (this.v2Param == null) {
            this.v2Param = new AbstractAdglAnimationParam2V();
        }
        this.v2Param.reset();
        this.v2Param.setInterpolatorType(i, 1.0f);
        this.v2Param.setFromValue(f, f3);
        this.v2Param.setToValue((double) f2, (double) f4);
        this.startTime = SystemClock.uptimeMillis();
        this.isOver = false;
    }

    public double getCurValue(int i) {
        if (i == 0) {
            return this.curValue1;
        }
        return this.curValue2;
    }

    public double getStartValue(int i) {
        if (i == 0) {
            AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
            if (abstractAdglAnimationParam2V != null) {
                return abstractAdglAnimationParam2V.getFromXValue();
            }
            return 0.0d;
        }
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V2 = this.v2Param;
        if (abstractAdglAnimationParam2V2 != null) {
            return abstractAdglAnimationParam2V2.getFromYValue();
        }
        return 0.0d;
    }

    public double getEndValue(int i) {
        if (i == 0) {
            AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
            if (abstractAdglAnimationParam2V != null) {
                return abstractAdglAnimationParam2V.getToXValue();
            }
            return 0.0d;
        }
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V2 = this.v2Param;
        if (abstractAdglAnimationParam2V2 != null) {
            return abstractAdglAnimationParam2V2.getToYValue();
        }
        return 0.0d;
    }

    @Override // com.autonavi.ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(Object obj) {
        if (!this.isOver) {
            this.offsetTime = SystemClock.uptimeMillis() - this.startTime;
            float f = ((float) this.offsetTime) / ((float) this.duration);
            if (f > 1.0f) {
                this.isOver = true;
                f = 1.0f;
            } else if (f < 0.0f) {
                this.isOver = true;
                return;
            }
            AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
            if (abstractAdglAnimationParam2V != null) {
                abstractAdglAnimationParam2V.setNormalizedTime(f);
                this.curValue1 = this.v2Param.getCurXValue();
                this.curValue2 = this.v2Param.getCurYValue();
            }
        }
    }
}
