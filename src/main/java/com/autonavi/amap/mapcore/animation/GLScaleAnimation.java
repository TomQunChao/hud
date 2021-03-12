package com.autonavi.amap.mapcore.animation;

public class GLScaleAnimation extends GLAnimation {
    private float mFromX;
    private float mFromY;
    private float mPivotX = 0.0f;
    private float mPivotY = 0.0f;
    private float mToX;
    private float mToY;

    public GLScaleAnimation(float f, float f2, float f3, float f4) {
        this.mFromX = f;
        this.mToX = f2;
        this.mFromY = f3;
        this.mToY = f4;
    }

    /* access modifiers changed from: protected */
    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float f, GLTransformation gLTransformation) {
        float f2;
        float f3 = 1.0f;
        if (this.mFromX == 1.0f && this.mToX == 1.0f) {
            f2 = 1.0f;
        } else {
            float f4 = this.mFromX;
            f2 = f4 + ((this.mToX - f4) * f);
        }
        if (!(this.mFromY == 1.0f && this.mToY == 1.0f)) {
            float f5 = this.mFromY;
            f3 = f5 + ((this.mToY - f5) * f);
        }
        if (this.mPivotX == 0.0f) {
            float f6 = this.mPivotY;
        }
        gLTransformation.scaleX = (double) f2;
        gLTransformation.scaleY = (double) f3;
    }
}
