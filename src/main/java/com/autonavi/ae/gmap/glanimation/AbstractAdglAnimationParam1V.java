package com.autonavi.ae.gmap.glanimation;

public class AbstractAdglAnimationParam1V extends AbstractAdglAnimationParam {
    private float fromValue;
    private float toValue;

    public AbstractAdglAnimationParam1V() {
        reset();
    }

    @Override // com.autonavi.ae.gmap.glanimation.AbstractAdglAnimationParam
    public void reset() {
        super.reset();
        this.fromValue = 0.0f;
        this.toValue = 0.0f;
    }

    public void setFromValue(float f) {
        this.fromValue = f;
        this.hasFromValue = true;
        this.hasCheckedParam = false;
    }

    public void setToValue(float f) {
        this.toValue = f;
        this.hasToValue = true;
        this.hasCheckedParam = false;
    }

    public float getFromValue() {
        return this.fromValue;
    }

    public float getToValue() {
        return this.toValue;
    }

    public float getCurValue() {
        float f = this.fromValue;
        return f + ((this.toValue - f) * this.mult);
    }

    @Override // com.autonavi.ae.gmap.glanimation.AbstractAdglAnimationParam
    public void checkParam() {
        this.needToCaculate = false;
        if (this.hasFromValue && this.hasToValue && ((double) Math.abs(this.toValue - this.fromValue)) > 1.0E-4d) {
            this.needToCaculate = true;
        }
        this.hasCheckedParam = true;
    }
}
