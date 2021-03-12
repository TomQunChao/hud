package com.amap.api.navi.view.statusbar;

import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import com.amap.api.col.stln3.mj;
import com.amap.api.col.stln3.mp;
import com.amap.api.col.stln3.mq;
import com.amap.api.navi.R;
import com.amap.api.navi.view.NightModeImageView;
import com.amap.api.navi.view.statusbar.StatusBarVolumeReceiver;

public class StatusBarVolumeItemView extends NightModeImageView implements IStatusBarItemView, StatusBarVolumeReceiver.OnVolumeChangeCallBack {
    boolean isMute;
    AudioManager mAudioManager;
    StatusBarVolumeReceiver statusBarVolumeReceiver;

    public StatusBarVolumeItemView(Context context) {
        this(context, null);
    }

    public StatusBarVolumeItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StatusBarVolumeItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isMute = false;
        this.mAudioManager = null;
    }

    public void updateMuteChangeSoundMode(boolean z) {
        this.isMute = z;
        setVisibility(z ? 0 : 8);
    }

    @Override // com.amap.api.navi.view.statusbar.IStatusBarItemView
    public void init() {
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        this.statusBarVolumeReceiver = new StatusBarVolumeReceiver();
        this.statusBarVolumeReceiver.setOnVolumeChangeCallBack(this);
        this.statusBarVolumeReceiver.register(getContext());
    }

    @Override // com.amap.api.navi.view.statusbar.IStatusBarItemView
    public void onDestroy() {
        this.statusBarVolumeReceiver.unRegister(getContext());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.amap.api.navi.view.statusbar.StatusBarVolumeItemView$1  reason: invalid class name */
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
            setDayNightModeImageResource(R.drawable.status_bar_volume_day, R.drawable.status_bar_volume_night);
        } else if (mj.d(getContext()) != 2) {
            setDayNightModeImageResource(R.drawable.status_bar_volume_cutout_day, R.drawable.status_bar_volume_cutout_night);
        } else {
            setDayNightModeImageResource(R.drawable.status_bar_volume_day, R.drawable.status_bar_volume_night);
        }
        updateMuteChangeSoundMode(this.isMute);
    }

    @Override // com.amap.api.navi.view.statusbar.StatusBarVolumeReceiver.OnVolumeChangeCallBack
    public void onVolumeUpdate() {
        updateMuteChangeSoundMode(isMute());
    }

    private boolean isMute() {
        if (this.mAudioManager.getStreamVolume(3) <= 0) {
            return true;
        }
        return false;
    }
}
