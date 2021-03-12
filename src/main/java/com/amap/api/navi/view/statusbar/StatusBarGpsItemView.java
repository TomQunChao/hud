package com.amap.api.navi.view.statusbar;

import android.content.Context;
import android.util.AttributeSet;
import com.amap.api.col.stln3.mj;
import com.amap.api.col.stln3.mp;
import com.amap.api.col.stln3.mq;
import com.amap.api.navi.R;
import com.amap.api.navi.view.NightModeImageView;

public class StatusBarGpsItemView extends NightModeImageView implements IStatusBarItemView {
    private static final int STATUS_INIT = 0;
    private static final int STATUS_STRONG = 2;
    private static final int STATUS_WEAK = 1;
    private boolean mNavigationBool;
    private int mStatus;

    public StatusBarGpsItemView(Context context) {
        this(context, null);
    }

    public StatusBarGpsItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StatusBarGpsItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mNavigationBool = true;
        this.mStatus = 0;
    }

    public void setmNavigationBool(boolean z) {
        this.mNavigationBool = z;
    }

    public void updateGpsStatus(boolean z) {
        if (!this.mNavigationBool) {
            setVisibility(8);
        }
        int i = this.mStatus;
        int i2 = 1;
        if (i != 0) {
            if (z && i == 1) {
                return;
            }
            if (!z && this.mStatus == 2) {
                return;
            }
        }
        if (!z) {
            i2 = 2;
        }
        this.mStatus = i2;
        reloadItemView(mj.d(getContext()));
    }

    @Override // com.amap.api.navi.view.statusbar.IStatusBarItemView
    public void init() {
        if (this.mNavigationBool) {
            updateGpsStatus(false);
        }
    }

    @Override // com.amap.api.navi.view.statusbar.IStatusBarItemView
    public void onDestroy() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.amap.api.navi.view.statusbar.StatusBarGpsItemView$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[mp.values().length];

        static {
            try {
                a[mp.CUTOUT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[mp.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    @Override // com.amap.api.navi.view.statusbar.IStatusBarItemView
    public void reloadItemView(int i) {
        int[] iArr = AnonymousClass1.a;
        getContext();
        if (iArr[mq.a().ordinal()] != 1) {
            if (this.mStatus == 2) {
                setDayNightModeImageResource(R.drawable.status_bar_gps_strong_day, R.drawable.status_bar_gps_strong_night);
            } else {
                setDayNightModeImageResource(R.drawable.status_bar_gps_weak_day, R.drawable.status_bar_gps_weak_day);
            }
        } else if (i != 2) {
            if (this.mStatus == 2) {
                setDayNightModeImageResource(R.drawable.status_bar_gps_strong_cutout_day, R.drawable.status_bar_gps_strong_cutout_night);
            } else {
                setDayNightModeImageResource(R.drawable.status_bar_gps_weak_cutout_day, R.drawable.status_bar_gps_weak_cutout_night);
            }
        } else if (this.mStatus == 2) {
            setDayNightModeImageResource(R.drawable.status_bar_gps_strong_day, R.drawable.status_bar_gps_strong_night);
        } else {
            setDayNightModeImageResource(R.drawable.status_bar_gps_weak_day, R.drawable.status_bar_gps_weak_day);
        }
    }
}
