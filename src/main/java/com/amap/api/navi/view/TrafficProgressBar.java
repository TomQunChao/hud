package com.amap.api.navi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.amap.api.col.stln3.mm;
import com.amap.api.navi.R;
import com.amap.api.navi.model.AMapTrafficStatus;
import java.util.List;

public class TrafficProgressBar extends FrameLayout {
    private ImageView mDefaultTmcBarCarView;
    private TmcBarView mDefaultTmcBarView;

    public TrafficProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public TrafficProgressBar(Context context) {
        this(context, null);
    }

    private void init() {
        try {
            View a = mm.a(getContext(), R.layout.amap_navi_api_trafficbar, null);
            addView(a);
            this.mDefaultTmcBarView = (TmcBarView) a.findViewById(R.id.navi_sdk_apiTmcBarView);
            this.mDefaultTmcBarCarView = (ImageView) a.findViewById(R.id.navi_sdk_apiTmcBarCar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void update(int i, int i2, List<AMapTrafficStatus> list) {
        try {
            this.mDefaultTmcBarView.setData(list, i);
            this.mDefaultTmcBarView.setCarView(this.mDefaultTmcBarCarView);
            this.mDefaultTmcBarView.setCursorPos(i2);
            this.mDefaultTmcBarView.invalidate();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setUnknownTrafficColor(int i) {
        try {
            if (this.mDefaultTmcBarView != null) {
                this.mDefaultTmcBarView.setUnknownTrafficColor(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setSmoothTrafficColor(int i) {
        try {
            if (this.mDefaultTmcBarView != null) {
                this.mDefaultTmcBarView.setSmoothTrafficColor(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setSlowTrafficColor(int i) {
        try {
            if (this.mDefaultTmcBarView != null) {
                this.mDefaultTmcBarView.setSlowTrafficColor(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setJamTrafficColor(int i) {
        try {
            if (this.mDefaultTmcBarView != null) {
                this.mDefaultTmcBarView.setJamTrafficColor(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVeryJamTrafficColor(int i) {
        try {
            if (this.mDefaultTmcBarView != null) {
                this.mDefaultTmcBarView.setVeryJamTrafficColor(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
