package com.amap.api.navi.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.col.stln3.mj;
import com.amap.api.navi.services.view.d;
import com.amap.api.navi.services.view.g;
import java.util.List;

public class SlidingUpPanelLayout extends ViewGroup {
    public static final int ACTION_MASK = 255;
    private static final float DEFAULT_ANCHOR_POINT = 1.0f;
    private static final int[] DEFAULT_ATTRS = {16842927};
    private static final boolean DEFAULT_CLIP_PANEL_FLAG = true;
    private static final int DEFAULT_FADE_COLOR = -1728053248;
    private static final int DEFAULT_MIN_FLING_VELOCITY = 400;
    private static final boolean DEFAULT_OVERLAY_FLAG = false;
    private static final int DEFAULT_PANEL_HEIGHT = 68;
    private static final int DEFAULT_PARALLAX_OFFSET = 0;
    private static final int DEFAULT_SHADOW_HEIGHT = 4;
    private static PanelState DEFAULT_SLIDE_STATE = PanelState.NAVI_SDK_COLLAPSED;
    public static final String SLIDING_STATE = "sliding_state";
    private static final String TAG = SlidingUpPanelLayout.class.getSimpleName();
    private float mAnchorPoint;
    private boolean mClipPanel;
    private int mCoveredFadeColor;
    private final Paint mCoveredFadePaint;
    private final g mDragHelper;
    private View mDragView;
    private int mDragViewResId;
    private View.OnClickListener mFadeOnClickListener;
    private boolean mFirstLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsScrollableViewHandlingTouch;
    private boolean mIsSlidingUp;
    private boolean mIsTouchEnabled;
    private boolean mIsUnableToDrag;
    private PanelState mLastNotDraggingSlideState;
    private View mMainView;
    private int mMinFlingVelocity;
    private boolean mOverlayContent;
    private int mPanelHeight;
    private final List<PanelSlideListener> mPanelSlideListeners;
    private int mParallaxOffset;
    private float mPrevMotionY;
    private View mScrollableView;
    private d mScrollableViewHelper;
    private int mScrollableViewResId;
    private final Drawable mShadowDrawable;
    private int mShadowHeight;
    private float mSlideOffset;
    private int mSlideRange;
    private PanelState mSlideState;
    private View mSlideableView;
    private final Rect mTmpRect;
    private View mTopView;

    public interface PanelSlideListener {
        void onPanelSlide(View view, float f);

        void onPanelStateChanged(View view, PanelState panelState, PanelState panelState2);
    }

    public enum PanelState {
        NAVI_SDK_EXPANDED,
        NAVI_SDK_COLLAPSED,
        NAVI_SDK_ANCHORED,
        NAVI_SDK_HIDDEN,
        NAVI_SDK_DRAGGING
    }

    public static class SimplePanelSlideListener implements PanelSlideListener {
        @Override // com.amap.api.navi.view.SlidingUpPanelLayout.PanelSlideListener
        public void onPanelSlide(View view, float f) {
        }

        @Override // com.amap.api.navi.view.SlidingUpPanelLayout.PanelSlideListener
        public void onPanelStateChanged(View view, PanelState panelState, PanelState panelState2) {
        }
    }

    public SlidingUpPanelLayout(Context context) {
        this(context, null);
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0135  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SlidingUpPanelLayout(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
        // Method dump skipped, instructions count: 338
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.navi.view.SlidingUpPanelLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setTopView(View view) {
        this.mTopView = view;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.mDragViewResId;
        if (i != -1) {
            setDragView(findViewById(i));
        }
        int i2 = this.mScrollableViewResId;
        if (i2 != -1) {
            setScrollableView(findViewById(i2));
        }
    }

    public void setGravity(int i) {
        if (i == 48 || i == 80) {
            this.mIsSlidingUp = i == 80;
            if (!this.mFirstLayout) {
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("gravity must be set to either top or bottom");
    }

    public void setCoveredFadeColor(int i) {
        this.mCoveredFadeColor = i;
        requestLayout();
    }

    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    public void setTouchEnabled(boolean z) {
        this.mIsTouchEnabled = z;
    }

    public boolean isTouchEnabled() {
        return (!this.mIsTouchEnabled || this.mSlideableView == null || this.mSlideState == PanelState.NAVI_SDK_HIDDEN) ? false : true;
    }

    public void setPanelHeight(int i) {
        if (getPanelHeight() != i) {
            this.mPanelHeight = i;
            if (!this.mFirstLayout) {
                requestLayout();
            }
            if (getPanelState() == PanelState.NAVI_SDK_COLLAPSED) {
                smoothToBottom();
                invalidate();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void smoothToBottom() {
        smoothSlideTo(0.0f, 0);
    }

    public int getShadowHeight() {
        return this.mShadowHeight;
    }

    public void setShadowHeight(int i) {
        this.mShadowHeight = i;
        if (!this.mFirstLayout) {
            invalidate();
        }
    }

    public int getPanelHeight() {
        return this.mPanelHeight;
    }

    public int getCurrentParallaxOffset() {
        int max = (int) (((float) this.mParallaxOffset) * Math.max(this.mSlideOffset, 0.0f));
        return this.mIsSlidingUp ? -max : max;
    }

    public void setParallaxOffset(int i) {
        this.mParallaxOffset = i;
        if (!this.mFirstLayout) {
            requestLayout();
        }
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public void setMinFlingVelocity(int i) {
        this.mMinFlingVelocity = i;
    }

    public void addPanelSlideListener(PanelSlideListener panelSlideListener) {
        synchronized (this.mPanelSlideListeners) {
            this.mPanelSlideListeners.add(panelSlideListener);
        }
    }

    public void removePanelSlideListener(PanelSlideListener panelSlideListener) {
        synchronized (this.mPanelSlideListeners) {
            this.mPanelSlideListeners.remove(panelSlideListener);
        }
    }

    public void setFadeOnClickListener(View.OnClickListener onClickListener) {
        this.mFadeOnClickListener = onClickListener;
    }

    public void setDragView(View view) {
        View view2 = this.mDragView;
        if (view2 != null) {
            view2.setOnClickListener(null);
        }
        this.mDragView = view;
        View view3 = this.mDragView;
        if (view3 != null) {
            view3.setClickable(true);
            this.mDragView.setFocusable(false);
            this.mDragView.setFocusableInTouchMode(false);
            this.mDragView.setOnClickListener(new View.OnClickListener() {
                /* class com.amap.api.navi.view.SlidingUpPanelLayout.AnonymousClass1 */

                public final void onClick(View view) {
                    try {
                        if (!SlidingUpPanelLayout.this.isEnabled()) {
                            return;
                        }
                        if (SlidingUpPanelLayout.this.isTouchEnabled()) {
                            if (SlidingUpPanelLayout.this.mSlideState == PanelState.NAVI_SDK_EXPANDED || SlidingUpPanelLayout.this.mSlideState == PanelState.NAVI_SDK_ANCHORED) {
                                SlidingUpPanelLayout.this.setPanelState(PanelState.NAVI_SDK_COLLAPSED);
                            } else if (SlidingUpPanelLayout.this.mAnchorPoint < 1.0f) {
                                SlidingUpPanelLayout.this.setPanelState(PanelState.NAVI_SDK_ANCHORED);
                            } else {
                                SlidingUpPanelLayout.this.setPanelState(PanelState.NAVI_SDK_EXPANDED);
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    public void setDragView(int i) {
        this.mDragViewResId = i;
        setDragView(findViewById(i));
    }

    public void setScrollableView(View view) {
        this.mScrollableView = view;
    }

    public void setAnchorPoint(float f) {
        if (f > 0.0f && f <= 1.0f) {
            this.mAnchorPoint = f;
            this.mFirstLayout = true;
            requestLayout();
        }
    }

    public float getAnchorPoint() {
        return this.mAnchorPoint;
    }

    public void setOverlayed(boolean z) {
        this.mOverlayContent = z;
    }

    public boolean isOverlayed() {
        return this.mOverlayContent;
    }

    public void setClipPanel(boolean z) {
        this.mClipPanel = z;
    }

    public boolean isClipPanel() {
        return this.mClipPanel;
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnPanelSlide(View view) {
        try {
            synchronized (this.mPanelSlideListeners) {
                for (PanelSlideListener panelSlideListener : this.mPanelSlideListeners) {
                    panelSlideListener.onPanelSlide(view, this.mSlideOffset);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnPanelStateChanged(View view, PanelState panelState, PanelState panelState2) {
        synchronized (this.mPanelSlideListeners) {
            for (PanelSlideListener panelSlideListener : this.mPanelSlideListeners) {
                panelSlideListener.onPanelStateChanged(view, panelState, panelState2);
            }
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: package-private */
    public void updateObscuredViewVisibility() {
        int i;
        int i2;
        int i3;
        int i4;
        if (getChildCount() != 0) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            View view = this.mSlideableView;
            int i5 = 0;
            if (view == null || !hasOpaqueBackground(view)) {
                i4 = 0;
                i3 = 0;
                i2 = 0;
                i = 0;
            } else {
                i4 = this.mSlideableView.getLeft();
                i3 = this.mSlideableView.getRight();
                i2 = this.mSlideableView.getTop();
                i = this.mSlideableView.getBottom();
            }
            View childAt = getChildAt(0);
            int max = Math.max(paddingLeft, childAt.getLeft());
            int max2 = Math.max(paddingTop, childAt.getTop());
            int min = Math.min(width, childAt.getRight());
            int min2 = Math.min(height, childAt.getBottom());
            if (max >= i4 && max2 >= i2 && min <= i3 && min2 <= i) {
                i5 = 4;
            }
            childAt.setVisibility(i5);
        }
    }

    /* access modifiers changed from: package-private */
    public void setAllChildrenVisible() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    private static boolean hasOpaqueBackground(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        try {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode != 1073741824) {
                if (mode != Integer.MIN_VALUE) {
                    throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
                }
            }
            if (mode2 != 1073741824) {
                if (mode2 != Integer.MIN_VALUE) {
                    throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
                }
            }
            int childCount = getChildCount();
            if (childCount == 2) {
                this.mMainView = getChildAt(0);
                this.mSlideableView = getChildAt(1);
                if (this.mDragView == null) {
                    setDragView(this.mSlideableView);
                }
                if (this.mSlideableView.getVisibility() != 0) {
                    this.mSlideState = PanelState.NAVI_SDK_HIDDEN;
                }
                int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                for (int i7 = 0; i7 < childCount; i7++) {
                    View childAt = getChildAt(i7);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (childAt.getVisibility() == 8) {
                        if (i7 == 0) {
                        }
                    }
                    if (childAt == this.mMainView) {
                        if (this.mOverlayContent || this.mSlideState == PanelState.NAVI_SDK_HIDDEN) {
                            i4 = paddingTop;
                        } else {
                            i4 = paddingTop - this.mPanelHeight;
                        }
                        i3 = paddingLeft - (layoutParams.leftMargin + layoutParams.rightMargin);
                    } else if (childAt == this.mSlideableView) {
                        i4 = paddingTop - layoutParams.topMargin;
                        i3 = paddingLeft;
                    } else {
                        i4 = paddingTop;
                        i3 = paddingLeft;
                    }
                    if (layoutParams.width == -2) {
                        i5 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
                    } else if (layoutParams.width == -1) {
                        i5 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                    } else {
                        i5 = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                    }
                    if (layoutParams.height == -2) {
                        i6 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                    } else {
                        if (layoutParams.weight > 0.0f && layoutParams.weight < 1.0f) {
                            i4 = (int) (((float) i4) * layoutParams.weight);
                        } else if (layoutParams.height != -1) {
                            i4 = layoutParams.height;
                        }
                        i6 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                    }
                    childAt.measure(i5, i6);
                    if (childAt == this.mSlideableView) {
                        this.mSlideRange = this.mSlideableView.getMeasuredHeight() - this.mPanelHeight;
                    }
                }
                setMeasuredDimension(size, size2);
                return;
            }
            throw new IllegalStateException("Sliding up panel layout must have exactly 2 children!");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        try {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int childCount = getChildCount();
            if (this.mFirstLayout) {
                switch (this.mSlideState) {
                    case NAVI_SDK_EXPANDED:
                        this.mSlideOffset = 1.0f;
                        break;
                    case NAVI_SDK_ANCHORED:
                        this.mSlideOffset = this.mAnchorPoint;
                        break;
                    case NAVI_SDK_HIDDEN:
                        this.mSlideOffset = computeSlideOffset(computePanelTopPosition(0.0f) + (this.mIsSlidingUp ? this.mPanelHeight : -this.mPanelHeight));
                        break;
                    default:
                        this.mSlideOffset = 0.0f;
                        break;
                }
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (childAt.getVisibility() == 8) {
                    if (i6 == 0 || this.mFirstLayout) {
                    }
                }
                int measuredHeight = childAt.getMeasuredHeight();
                if (childAt == this.mSlideableView) {
                    i5 = computePanelTopPosition(this.mSlideOffset);
                } else {
                    i5 = paddingTop;
                }
                if (!this.mIsSlidingUp) {
                    if (childAt == this.mMainView && !this.mOverlayContent) {
                        i5 = computePanelTopPosition(this.mSlideOffset) + this.mSlideableView.getMeasuredHeight();
                    }
                }
                int i7 = layoutParams.leftMargin + paddingLeft;
                childAt.layout(i7, i5, childAt.getMeasuredWidth() + i7, measuredHeight + i5);
            }
            if (this.mFirstLayout) {
                updateObscuredViewVisibility();
            }
            applyParallaxForCurrentSlideOffset();
            this.mFirstLayout = false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i2 != i4) {
            this.mFirstLayout = true;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mIsScrollableViewHandlingTouch || !isTouchEnabled()) {
            this.mDragHelper.d();
            return false;
        }
        int actionMasked = getActionMasked(motionEvent);
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float abs = Math.abs(x - this.mInitialMotionX);
        float abs2 = Math.abs(y - this.mInitialMotionY);
        int b = this.mDragHelper.b();
        switch (actionMasked) {
            case 0:
                this.mIsUnableToDrag = false;
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                if (!isViewUnder(this.mDragView, (int) x, (int) y)) {
                    this.mDragHelper.c();
                    this.mIsUnableToDrag = true;
                    return false;
                }
                break;
            case 1:
            case 3:
                if (this.mDragHelper.f()) {
                    this.mDragHelper.b(motionEvent);
                    return true;
                }
                float f = (float) b;
                if (abs2 <= f && abs <= f && this.mSlideOffset > 0.0f && !isViewUnder(this.mSlideableView, (int) this.mInitialMotionX, (int) this.mInitialMotionY) && this.mFadeOnClickListener != null) {
                    playSoundEffect(0);
                    this.mFadeOnClickListener.onClick(this);
                    return true;
                }
            case 2:
                if (abs2 > ((float) b) && abs > abs2) {
                    this.mDragHelper.c();
                    this.mIsUnableToDrag = true;
                    return false;
                }
        }
        return this.mDragHelper.a(motionEvent);
    }

    private boolean dodo(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            this.mDragView.getLocationOnScreen(iArr);
            if (((int) motionEvent.getX()) >= iArr[0] && ((int) motionEvent.getY()) + 100 < iArr[1]) {
                return super.onTouchEvent(motionEvent);
            }
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !isTouchEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        try {
            this.mDragHelper.b(motionEvent);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static int getActionMasked(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
        /*
        // Method dump skipped, instructions count: 338
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.navi.view.SlidingUpPanelLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    private boolean isViewUnder(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr2);
        int i3 = iArr2[0] + i;
        int i4 = iArr2[1] + i2;
        if (i3 < iArr[0] || i3 >= iArr[0] + view.getWidth() || i4 < iArr[1] || i4 >= iArr[1] + view.getHeight()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int computePanelTopPosition(float f) {
        View view = this.mSlideableView;
        int measuredHeight = view != null ? view.getMeasuredHeight() : 0;
        int i = (int) (f * ((float) this.mSlideRange));
        if (this.mIsSlidingUp) {
            return ((getMeasuredHeight() - getPaddingBottom()) - this.mPanelHeight) - i;
        }
        return (getPaddingTop() - measuredHeight) + this.mPanelHeight + i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private float computeSlideOffset(int i) {
        int computePanelTopPosition = computePanelTopPosition(0.0f);
        return (this.mIsSlidingUp ? (float) (computePanelTopPosition - i) : (float) (i - computePanelTopPosition)) / ((float) this.mSlideRange);
    }

    public PanelState getPanelState() {
        return this.mSlideState;
    }

    public void setPanelState(PanelState panelState) {
        PanelState panelState2;
        if (panelState == null || panelState == PanelState.NAVI_SDK_DRAGGING) {
            throw new IllegalArgumentException("Panel state cannot be null or DRAGGING.");
        } else if (!isEnabled()) {
        } else {
            if ((this.mFirstLayout || this.mSlideableView != null) && panelState != (panelState2 = this.mSlideState) && panelState2 != PanelState.NAVI_SDK_DRAGGING) {
                if (this.mFirstLayout) {
                    setPanelStateInternal(panelState);
                    return;
                }
                if (this.mSlideState == PanelState.NAVI_SDK_HIDDEN) {
                    this.mSlideableView.setVisibility(0);
                    requestLayout();
                }
                switch (panelState) {
                    case NAVI_SDK_EXPANDED:
                        smoothSlideTo(1.0f, 0);
                        return;
                    case NAVI_SDK_ANCHORED:
                        smoothSlideTo(this.mAnchorPoint, 0);
                        return;
                    case NAVI_SDK_HIDDEN:
                        smoothSlideTo(computeSlideOffset(computePanelTopPosition(0.0f) + (this.mIsSlidingUp ? this.mPanelHeight : -this.mPanelHeight)), 0);
                        return;
                    case NAVI_SDK_COLLAPSED:
                        smoothSlideTo(0.0f, 0);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setPanelStateInternal(PanelState panelState) {
        PanelState panelState2 = this.mSlideState;
        if (panelState2 != panelState) {
            this.mSlideState = panelState;
            dispatchOnPanelStateChanged(this, panelState2, panelState);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @SuppressLint({"NewApi"})
    private void applyParallaxForCurrentSlideOffset() {
        if (this.mParallaxOffset > 0) {
            this.mMainView.setTranslationY((float) getCurrentParallaxOffset());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void applyParallaxForTopOffset(int i) {
        View view = this.mTopView;
        if (view != null) {
            int height = view.getHeight();
            int a2 = (i - mj.a(getContext(), 100)) - height;
            if (a2 > 0) {
                a2 = 0;
            }
            int i2 = -height;
            if (a2 < i2) {
                a2 = i2;
            }
            this.mTopView.setTranslationY((float) a2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onPanelDragged(int i) {
        if (this.mSlideState != PanelState.NAVI_SDK_DRAGGING) {
            this.mLastNotDraggingSlideState = this.mSlideState;
        }
        setPanelStateInternal(PanelState.NAVI_SDK_DRAGGING);
        this.mSlideOffset = computeSlideOffset(i);
        applyParallaxForCurrentSlideOffset();
        dispatchOnPanelSlide(this.mSlideableView);
        LayoutParams layoutParams = (LayoutParams) this.mMainView.getLayoutParams();
        int height = ((getHeight() - getPaddingBottom()) - getPaddingTop()) - this.mPanelHeight;
        if (this.mSlideOffset <= 0.0f && !this.mOverlayContent) {
            layoutParams.height = this.mIsSlidingUp ? i - getPaddingBottom() : ((getHeight() - getPaddingBottom()) - this.mSlideableView.getMeasuredHeight()) - i;
            if (layoutParams.height == height) {
                layoutParams.height = -1;
            }
            this.mMainView.requestLayout();
        } else if (layoutParams.height != -1 && !this.mOverlayContent) {
            layoutParams.height = -1;
            this.mMainView.requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        int save = canvas.save();
        View view2 = this.mSlideableView;
        if (view2 == null || view2 == view) {
            z = super.drawChild(canvas, view, j);
        } else {
            canvas.getClipBounds(this.mTmpRect);
            if (!this.mOverlayContent) {
                if (this.mIsSlidingUp) {
                    Rect rect = this.mTmpRect;
                    rect.bottom = Math.min(rect.bottom, this.mSlideableView.getTop());
                } else {
                    Rect rect2 = this.mTmpRect;
                    rect2.top = Math.max(rect2.top, this.mSlideableView.getBottom());
                }
            }
            if (this.mClipPanel) {
                canvas.clipRect(this.mTmpRect);
            }
            z = super.drawChild(canvas, view, j);
            int i = this.mCoveredFadeColor;
            if (i != 0) {
                float f = this.mSlideOffset;
                if (f > 0.0f) {
                    this.mCoveredFadePaint.setColor((i & ViewCompat.MEASURED_SIZE_MASK) | (((int) (((float) ((-16777216 & i) >>> 24)) * f)) << 24));
                    canvas.drawRect(this.mTmpRect, this.mCoveredFadePaint);
                }
            }
        }
        canvas.restoreToCount(save);
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean smoothSlideTo(float f, int i) {
        if (!isEnabled() || this.mSlideableView == null) {
            return false;
        }
        int computePanelTopPosition = computePanelTopPosition(f);
        g gVar = this.mDragHelper;
        View view = this.mSlideableView;
        if (!gVar.a(view, view.getLeft(), computePanelTopPosition)) {
            return false;
        }
        setAllChildrenVisible();
        invalidate();
        return true;
    }

    public void computeScroll() {
        g gVar = this.mDragHelper;
        if (gVar != null && gVar.e()) {
            if (!isEnabled()) {
                this.mDragHelper.d();
            } else {
                invalidate();
            }
        }
    }

    public void draw(Canvas canvas) {
        View view;
        int i;
        int i2;
        super.draw(canvas);
        if (this.mShadowDrawable != null && (view = this.mSlideableView) != null) {
            int right = view.getRight();
            if (this.mIsSlidingUp) {
                i2 = this.mSlideableView.getTop() - this.mShadowHeight;
                i = this.mSlideableView.getTop();
            } else {
                i2 = this.mSlideableView.getBottom();
                i = this.mSlideableView.getBottom() + this.mShadowHeight;
            }
            this.mShadowDrawable.setBounds(this.mSlideableView.getLeft(), i2, right, i);
            this.mShadowDrawable.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && canScroll(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (!z || !view.canScrollHorizontally(-i)) {
            return false;
        }
        return true;
    }

    public boolean canScrollHorizontally(int i) {
        int computeHorizontalScrollOffset = computeHorizontalScrollOffset();
        int computeHorizontalScrollRange = computeHorizontalScrollRange() - computeHorizontalScrollExtent();
        if (computeHorizontalScrollRange == 0) {
            return false;
        }
        if (i < 0) {
            if (computeHorizontalScrollOffset > 0) {
                return true;
            }
            return false;
        } else if (computeHorizontalScrollOffset < computeHorizontalScrollRange - 1) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putSerializable(SLIDING_STATE, this.mSlideState != PanelState.NAVI_SDK_DRAGGING ? this.mSlideState : this.mLastNotDraggingSlideState);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mSlideState = (PanelState) bundle.getSerializable(SLIDING_STATE);
            PanelState panelState = this.mSlideState;
            if (panelState == null) {
                panelState = DEFAULT_SLIDE_STATE;
            }
            this.mSlideState = panelState;
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    private class a extends g.a {
        private a() {
        }

        /* synthetic */ a(SlidingUpPanelLayout slidingUpPanelLayout, byte b) {
            this();
        }

        @Override // com.amap.api.navi.services.view.g.a
        public final boolean a(View view) {
            return !SlidingUpPanelLayout.this.mIsUnableToDrag && view == SlidingUpPanelLayout.this.mSlideableView;
        }

        @Override // com.amap.api.navi.services.view.g.a
        public final void a() {
            if (SlidingUpPanelLayout.this.mDragHelper != null && SlidingUpPanelLayout.this.mDragHelper.a() == 0) {
                SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
                slidingUpPanelLayout.mSlideOffset = slidingUpPanelLayout.computeSlideOffset(slidingUpPanelLayout.mSlideableView.getTop());
                SlidingUpPanelLayout.this.applyParallaxForCurrentSlideOffset();
                if (SlidingUpPanelLayout.this.mSlideOffset == 1.0f) {
                    SlidingUpPanelLayout.this.updateObscuredViewVisibility();
                    SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.NAVI_SDK_EXPANDED);
                } else if (SlidingUpPanelLayout.this.mSlideOffset == 0.0f) {
                    SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.NAVI_SDK_COLLAPSED);
                } else if (SlidingUpPanelLayout.this.mSlideOffset < 0.0f) {
                    SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.NAVI_SDK_HIDDEN);
                    SlidingUpPanelLayout.this.mSlideableView.setVisibility(4);
                } else {
                    SlidingUpPanelLayout.this.updateObscuredViewVisibility();
                    SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.NAVI_SDK_ANCHORED);
                }
            }
        }

        @Override // com.amap.api.navi.services.view.g.a
        public final void b() {
            SlidingUpPanelLayout.this.setAllChildrenVisible();
        }

        @Override // com.amap.api.navi.services.view.g.a
        public final void a(int i) {
            SlidingUpPanelLayout.this.onPanelDragged(i);
            SlidingUpPanelLayout.this.applyParallaxForTopOffset(i);
            SlidingUpPanelLayout.this.invalidate();
        }

        @Override // com.amap.api.navi.services.view.g.a
        public final void a(View view, float f) {
            int i;
            if (SlidingUpPanelLayout.this.mIsSlidingUp) {
                f = -f;
            }
            int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            if (i2 > 0 && SlidingUpPanelLayout.this.mSlideOffset <= SlidingUpPanelLayout.this.mAnchorPoint) {
                SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
                i = slidingUpPanelLayout.computePanelTopPosition(slidingUpPanelLayout.mAnchorPoint);
            } else if (i2 <= 0 || SlidingUpPanelLayout.this.mSlideOffset <= SlidingUpPanelLayout.this.mAnchorPoint) {
                int i3 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i3 >= 0 || SlidingUpPanelLayout.this.mSlideOffset < SlidingUpPanelLayout.this.mAnchorPoint) {
                    if (i3 >= 0 || SlidingUpPanelLayout.this.mSlideOffset >= SlidingUpPanelLayout.this.mAnchorPoint) {
                        if (SlidingUpPanelLayout.this.mSlideOffset >= (SlidingUpPanelLayout.this.mAnchorPoint + 1.0f) / 2.0f) {
                            i = SlidingUpPanelLayout.this.computePanelTopPosition(1.0f);
                        } else if (SlidingUpPanelLayout.this.mSlideOffset >= SlidingUpPanelLayout.this.mAnchorPoint / 2.0f) {
                            SlidingUpPanelLayout slidingUpPanelLayout2 = SlidingUpPanelLayout.this;
                            i = slidingUpPanelLayout2.computePanelTopPosition(slidingUpPanelLayout2.mAnchorPoint);
                        }
                    }
                    i = SlidingUpPanelLayout.this.computePanelTopPosition(0.0f);
                } else {
                    SlidingUpPanelLayout slidingUpPanelLayout3 = SlidingUpPanelLayout.this;
                    i = slidingUpPanelLayout3.computePanelTopPosition(slidingUpPanelLayout3.mAnchorPoint);
                }
            } else {
                i = SlidingUpPanelLayout.this.computePanelTopPosition(1.0f);
            }
            if (SlidingUpPanelLayout.this.mDragHelper != null) {
                SlidingUpPanelLayout.this.mDragHelper.a(view.getLeft(), i);
            }
            SlidingUpPanelLayout.this.invalidate();
        }

        @Override // com.amap.api.navi.services.view.g.a
        public final int c() {
            return SlidingUpPanelLayout.this.mSlideRange;
        }

        @Override // com.amap.api.navi.services.view.g.a
        public final int b(int i) {
            int computePanelTopPosition = SlidingUpPanelLayout.this.computePanelTopPosition(0.0f);
            int computePanelTopPosition2 = SlidingUpPanelLayout.this.computePanelTopPosition(1.0f);
            if (SlidingUpPanelLayout.this.mIsSlidingUp) {
                return Math.min(Math.max(i, computePanelTopPosition2), computePanelTopPosition);
            }
            return Math.min(Math.max(i, computePanelTopPosition), computePanelTopPosition2);
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int[] ATTRS = {16843137};
        public float weight = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2);
            this.weight = f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
            if (obtainStyledAttributes != null) {
                this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
                obtainStyledAttributes.recycle();
            }
        }
    }
}
