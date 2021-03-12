package com.autonavi.amap.mapcore.animation;

import android.view.animation.Interpolator;
import com.amap.api.maps.model.animation.Animation;
import java.util.ArrayList;
import java.util.List;

public class GLAnimationSet extends GLAnimation {
    private static final int PROPERTY_CHANGE_BOUNDS_MASK = 128;
    private static final int PROPERTY_DURATION_MASK = 32;
    private static final int PROPERTY_FILL_AFTER_MASK = 1;
    private static final int PROPERTY_FILL_BEFORE_MASK = 2;
    private static final int PROPERTY_MORPH_MATRIX_MASK = 64;
    private static final int PROPERTY_REPEAT_MODE_MASK = 4;
    private static final int PROPERTY_SHARE_INTERPOLATOR_MASK = 16;
    private static final int PROPERTY_START_OFFSET_MASK = 8;
    private ArrayList<GLAnimation> mAnimations = new ArrayList<>();
    private boolean mDirty;
    private int mFlags = 0;
    private boolean mHasAlpha;
    private long mLastEnd;
    private GLTransformation mTempTransformation = new GLTransformation();

    public GLAnimationSet(boolean z) {
        setFlag(16, z);
        init();
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void initialize() {
        boolean z;
        boolean z2;
        super.initialize();
        boolean z3 = true;
        boolean z4 = (this.mFlags & 32) == 32;
        boolean z5 = (this.mFlags & 1) == 1;
        boolean z6 = (this.mFlags & 2) == 2;
        boolean z7 = (this.mFlags & 4) == 4;
        boolean z8 = (this.mFlags & 16) == 16;
        if ((this.mFlags & 8) != 8) {
            z3 = false;
        }
        if (z8) {
            ensureInterpolator();
        }
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        long j = this.mDuration;
        boolean z9 = this.mFillAfter;
        boolean z10 = this.mFillBefore;
        int i = this.mRepeatMode;
        Interpolator interpolator = this.mInterpolator;
        long j2 = this.mStartOffset;
        int i2 = 0;
        while (i2 < size) {
            GLAnimation gLAnimation = arrayList.get(i2);
            if (z4) {
                gLAnimation.setDuration(j);
            }
            if (z5) {
                gLAnimation.setFillAfter(z9);
            }
            if (z6) {
                gLAnimation.setFillBefore(z10);
            }
            if (z7) {
                gLAnimation.setRepeatMode(i);
            }
            if (z8) {
                gLAnimation.setInterpolator(interpolator);
            }
            if (z3) {
                z2 = z4;
                z = z5;
                gLAnimation.setStartOffset(gLAnimation.getStartOffset() + j2);
            } else {
                z2 = z4;
                z = z5;
            }
            gLAnimation.initialize();
            i2++;
            z4 = z2;
            arrayList = arrayList;
            z5 = z;
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation, com.autonavi.amap.mapcore.animation.GLAnimation, java.lang.Object
    public GLAnimationSet clone() throws CloneNotSupportedException {
        GLAnimationSet gLAnimationSet = (GLAnimationSet) super.clone();
        gLAnimationSet.mTempTransformation = new GLTransformation();
        gLAnimationSet.mAnimations = new ArrayList<>();
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        for (int i = 0; i < size; i++) {
            gLAnimationSet.mAnimations.add(arrayList.get(i).clone());
        }
        return gLAnimationSet;
    }

    private void setFlag(int i, boolean z) {
        if (z) {
            this.mFlags = i | this.mFlags;
            return;
        }
        this.mFlags = (~i) & this.mFlags;
    }

    private void init() {
        this.mStartTime = 0;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setFillAfter(boolean z) {
        this.mFlags |= 1;
        super.setFillAfter(z);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setFillBefore(boolean z) {
        this.mFlags |= 2;
        super.setFillBefore(z);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setRepeatMode(int i) {
        this.mFlags |= 4;
        super.setRepeatMode(i);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setStartOffset(long j) {
        this.mFlags |= 8;
        super.setStartOffset(j);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean hasAlpha() {
        if (this.mDirty) {
            int i = 0;
            this.mHasAlpha = false;
            this.mDirty = false;
            int size = this.mAnimations.size();
            ArrayList<GLAnimation> arrayList = this.mAnimations;
            while (true) {
                if (i >= size) {
                    break;
                } else if (arrayList.get(i).hasAlpha()) {
                    this.mHasAlpha = true;
                    break;
                } else {
                    i++;
                }
            }
        }
        return this.mHasAlpha;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setDuration(long j) {
        this.mFlags |= 32;
        super.setDuration(j);
        this.mLastEnd = this.mStartOffset + this.mDuration;
    }

    public void addAnimation(Animation animation) {
        this.mAnimations.add(animation.glAnimation);
        boolean z = false;
        if (((this.mFlags & 64) == 0) && animation.glAnimation.willChangeTransformationMatrix()) {
            this.mFlags |= 64;
        }
        if ((this.mFlags & 128) == 0) {
            z = true;
        }
        if (z && animation.glAnimation.willChangeBounds()) {
            this.mFlags |= 128;
        }
        if ((this.mFlags & 32) == 32) {
            this.mLastEnd = this.mStartOffset + this.mDuration;
        } else if (this.mAnimations.size() == 1) {
            this.mDuration = animation.glAnimation.getStartOffset() + animation.glAnimation.getDuration();
            this.mLastEnd = this.mStartOffset + this.mDuration;
        } else {
            this.mLastEnd = Math.max(this.mLastEnd, animation.glAnimation.getStartOffset() + animation.glAnimation.getDuration());
            this.mDuration = this.mLastEnd - this.mStartOffset;
        }
        this.mDirty = true;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setStartTime(long j) {
        super.setStartTime(j);
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        for (int i = 0; i < size; i++) {
            arrayList.get(i).setStartTime(j);
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public long getStartTime() {
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        long j = Long.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            j = Math.min(j, arrayList.get(i).getStartTime());
        }
        return j;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void restrictDuration(long j) {
        super.restrictDuration(j);
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get(i).restrictDuration(j);
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public long getDuration() {
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        if ((this.mFlags & 32) == 32) {
            return this.mDuration;
        }
        long j = 0;
        for (int i = 0; i < size; i++) {
            j = Math.max(j, arrayList.get(i).getDuration());
        }
        return j;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public long computeDurationHint() {
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        long j = 0;
        for (int i = size - 1; i >= 0; i--) {
            long computeDurationHint = arrayList.get(i).computeDurationHint();
            if (computeDurationHint > j) {
                j = computeDurationHint;
            }
        }
        return j;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean getTransformation(long j, GLTransformation gLTransformation) {
        if (!this.mInitialized) {
            initialize();
        }
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        GLTransformation gLTransformation2 = this.mTempTransformation;
        gLTransformation.clear();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        for (int i = size - 1; i >= 0; i--) {
            GLAnimation gLAnimation = arrayList.get(i);
            gLTransformation2.clear();
            z2 = gLAnimation.getTransformation(j, gLTransformation, getScaleFactor()) || z2;
            z = z || gLAnimation.hasStarted();
            z3 = gLAnimation.hasEnded() && z3;
        }
        if (z) {
            try {
                if (!this.mStarted) {
                    if (this.mListener != null) {
                        this.mListener.onAnimationStart();
                    }
                    this.mStarted = true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (z3 != this.mEnded) {
            if (this.mListener != null) {
                this.mListener.onAnimationEnd();
            }
            this.mEnded = z3;
        }
        return z2;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void scaleCurrentDuration(float f) {
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get(i).scaleCurrentDuration(f);
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void reset() {
        super.reset();
    }

    public List<GLAnimation> getAnimations() {
        return this.mAnimations;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean willChangeTransformationMatrix() {
        return (this.mFlags & 64) == 64;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean willChangeBounds() {
        return (this.mFlags & 128) == 128;
    }

    public void cleanAnimation() {
        this.mAnimations.clear();
    }
}
