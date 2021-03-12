package com.autonavi.ae.gmap.glanimation;

public abstract class AbstractAdglAnimationParam {
    protected float factor;
    protected boolean hasCheckedParam;
    protected boolean hasFromValue;
    protected boolean hasToValue;
    protected int interpolationType;
    protected float mult;
    protected boolean needToCaculate;
    protected float normalizedTime;

    public abstract void checkParam();

    static float bounce(float f) {
        return f * f * 8.0f;
    }

    public void reset() {
        this.hasCheckedParam = false;
        this.needToCaculate = false;
        this.interpolationType = 0;
        this.factor = 1.0f;
        this.hasCheckedParam = false;
        this.needToCaculate = false;
        this.hasFromValue = false;
        this.hasToValue = false;
    }

    public boolean needToCaculate() {
        if (!this.hasCheckedParam) {
            checkParam();
        }
        if (!this.hasCheckedParam || !this.needToCaculate) {
            return false;
        }
        return true;
    }

    public float getCurMult() {
        return this.mult;
    }

    public void setNormalizedTime(float f) {
        this.normalizedTime = f;
        switch (this.interpolationType) {
            case 0:
                break;
            case 1:
                f = (float) Math.pow((double) f, (double) (this.factor * 2.0f));
                break;
            case 2:
                float f2 = this.factor;
                if (f2 != 1.0f) {
                    f = (float) (1.0d - Math.pow((double) (1.0f - f), (double) (f2 * 2.0f)));
                    break;
                } else {
                    float f3 = 1.0f - f;
                    f = 1.0f - (f3 * f3);
                    break;
                }
            case 3:
                f = (float) ((Math.cos(((double) (f + 1.0f)) * 3.141592653589793d) / 2.0d) + 0.5d);
                break;
            case 4:
                float f4 = f * 1.1226f;
                if (f4 >= 0.3535f) {
                    if (f4 >= 0.7408f) {
                        if (f4 >= 0.9644f) {
                            f = bounce(f4 - 1.0435f) + 0.95f;
                            break;
                        } else {
                            f = bounce(f4 - 0.8526f) + 0.9f;
                            break;
                        }
                    } else {
                        f = bounce(f4 - 0.54719f) + 0.7f;
                        break;
                    }
                } else {
                    f = bounce(f4);
                    break;
                }
            case 5:
                float f5 = f - 1.0f;
                f = (f5 * f5 * ((f5 * 3.0f) + 2.0f)) + 1.0f;
                break;
            case 6:
                if (f >= 0.0f) {
                    if (f >= 0.25f) {
                        if (f >= 0.5f) {
                            if (f >= 0.75f) {
                                if (f > 1.0f) {
                                    f = 0.0f;
                                    break;
                                } else {
                                    f = 4.0f - (f * 4.0f);
                                    break;
                                }
                            } else {
                                f = (f * 4.0f) - 2.0f;
                                break;
                            }
                        } else {
                            f = 2.0f - (f * 4.0f);
                            break;
                        }
                    } else {
                        f *= 4.0f;
                        break;
                    }
                } else {
                    f = 0.0f;
                    break;
                }
            default:
                f = 0.0f;
                break;
        }
        this.mult = f;
    }

    public void setInterpolatorType(int i, float f) {
        this.interpolationType = i;
        this.factor = f;
    }

    public int getInterpolatorType() {
        return this.interpolationType;
    }

    public AbstractAdglAnimationParam() {
        this.hasCheckedParam = false;
        this.needToCaculate = false;
        this.interpolationType = 0;
        this.factor = 1.0f;
        this.hasCheckedParam = false;
        this.needToCaculate = false;
        this.hasFromValue = false;
        this.hasToValue = false;
    }
}
