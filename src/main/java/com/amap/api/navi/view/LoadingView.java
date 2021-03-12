package com.amap.api.navi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.col.stln3.mm;
import com.amap.api.navi.R;

public class LoadingView extends RelativeLayout {
    private ImageView imageView;
    private RelativeLayout loadingLayout;
    private RelativeLayout refreshLayout;
    private TextView refreshText;
    private Animation rotation;
    private boolean showing = false;

    public LoadingView(Context context) {
        super(context);
        init();
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        View a = mm.a(getContext(), R.layout.amap_navi_lbs_loading, null);
        addView(a);
        this.imageView = (ImageView) a.findViewById(R.id.navi_sdk_route_select_loading);
        this.loadingLayout = (RelativeLayout) a.findViewById(R.id.navi_sdk_route_select_loading_layout);
        this.refreshLayout = (RelativeLayout) a.findViewById(R.id.navi_sdk_route_select_loading_refresh_layout);
        this.refreshText = (TextView) a.findViewById(R.id.navi_sdk_route_select_loading_text);
    }

    public void showLoading() {
        try {
            this.refreshLayout.setVisibility(8);
            this.loadingLayout.setVisibility(0);
            if (this.rotation == null) {
                this.rotation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            }
            this.rotation.setRepeatCount(-1);
            this.rotation.setInterpolator(new LinearInterpolator());
            this.rotation.setDuration(2000);
            this.rotation.setRepeatCount(-1);
            this.imageView.startAnimation(this.rotation);
            this.showing = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showFailed(String str, View.OnClickListener onClickListener) {
        try {
            this.loadingLayout.setVisibility(8);
            this.refreshLayout.setVisibility(0);
            this.refreshLayout.setOnClickListener(onClickListener);
            this.refreshText.setText(str);
            this.showing = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hideLoading() {
        try {
            this.loadingLayout.setVisibility(8);
            this.refreshLayout.setVisibility(8);
            if (this.rotation != null) {
                this.rotation.cancel();
            }
            this.showing = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isShowing() {
        return this.showing;
    }
}
