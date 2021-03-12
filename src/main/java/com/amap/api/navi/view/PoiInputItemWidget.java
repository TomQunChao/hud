package com.amap.api.navi.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.col.stln3.mm;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.R;
import com.amap.api.navi.view.PoiInputSearchWidget;

public class PoiInputItemWidget extends RelativeLayout implements View.OnClickListener {
    public static final int SWITCH_ANIMATION_DOWN = 1;
    public static final int SWITCH_ANIMATION_UP = 0;
    public static final int TYPE_DEST = 1;
    public static final int TYPE_MIDDLE = 2;
    public static final int TYPE_START = 0;
    private int animDuration = PoiInputSearchWidget.DEF_ANIMATION_DURATION;
    private Callback mCallback;
    private ImageView mDeleteIV;
    private Poi mPoi;
    private TextView mPoiTV;
    private int mType;
    private TextView mTypeTV;
    public int middle_index = -1;

    public interface Callback {
        void onAddMid();

        void onBack();

        void onClick(PoiInputItemWidget poiInputItemWidget);

        void onDelete(PoiInputItemWidget poiInputItemWidget);
    }

    public PoiInputItemWidget(Context context) {
        super(context);
        init();
    }

    public PoiInputItemWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PoiInputItemWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    private void init() {
        mm.a(getContext(), R.layout.amap_navi_lbs_widget_poi_input_item, this);
        setBackgroundDrawable(mm.a().getDrawable(com.a11hud.www.R.attr.progressBarPadding));
        this.mTypeTV = (TextView) findViewById(R.id.navi_sdk_type_tv);
        this.mDeleteIV = (ImageView) findViewById(R.id.navi_sdk_delete_iv);
        this.mPoiTV = (TextView) findViewById(R.id.navi_sdk_poi_name_tv);
        this.mTypeTV.setOnClickListener(this);
        this.mPoiTV.setOnClickListener(this);
        this.mDeleteIV.setOnClickListener(this);
    }

    public void initUI(int i, Poi poi) {
        this.mType = i;
        this.mPoi = poi;
        if (this.mTypeTV != null && this.mPoiTV != null) {
            setType(i);
            setPoi(i, poi);
        }
    }

    public void setPoi(int i, Poi poi) {
        this.mPoi = poi;
        this.mType = i;
        if (i == 2) {
            setPoiForMid(poi);
        } else if (poi == null || TextUtils.isEmpty(poi.getName())) {
            this.mPoiTV.setText("");
            this.mPoiTV.setHint(getHintStr(i));
        } else {
            this.mPoiTV.setText(poi.getName());
        }
    }

    private String getHintStr(int i) {
        if (i == 0) {
            return "请输入起点";
        }
        return "请输入终点";
    }

    public void setPoi(Poi poi) {
        setPoi(this.mType, poi);
    }

    public void setPos(int i) {
        if (this.mType != 2 || this.mPoi != null) {
            return;
        }
        if (i > 0) {
            TextView textView = this.mPoiTV;
            textView.setHint(mm.a().getString(R.string.amap_navi_poi_input_mid_hint) + i);
            return;
        }
        this.mPoiTV.setHint(mm.a().getString(R.string.amap_navi_poi_input_mid_hint));
    }

    private void setType(int i) {
        if (i == 2) {
            this.mDeleteIV.setVisibility(0);
            this.mTypeTV.setVisibility(8);
            return;
        }
        this.mDeleteIV.setVisibility(8);
        this.mTypeTV.setVisibility(0);
        this.mTypeTV.setText(getTypeStr(i));
    }

    public int getType() {
        return this.mType;
    }

    public Poi getPoi() {
        return this.mPoi;
    }

    private void setPoiForMid(Poi poi) {
        if (poi == null) {
            this.mPoiTV.setText("");
            if (this.middle_index >= 0) {
                TextView textView = this.mPoiTV;
                textView.setHint(mm.a().getString(R.string.amap_navi_poi_input_mid_hint) + (this.middle_index + 1));
                return;
            }
            this.mPoiTV.setHint(mm.a().getString(R.string.amap_navi_poi_input_mid_hint));
            return;
        }
        this.mPoiTV.setText(poi.getName());
    }

    private String getTypeStr(int i) {
        switch (i) {
            case 0:
                return mm.a().getString(R.string.amap_navi_poi_input_type_start);
            case 1:
                return mm.a().getString(R.string.amap_navi_poi_input_type_dest);
            default:
                return "";
        }
    }

    public void onClick(View view) {
        try {
            int id = view.getId();
            if (id != 2147479795) {
                if (id != 2147479797) {
                    if (id != 2147479796) {
                        return;
                    }
                    if (this.mCallback != null) {
                        this.mCallback.onDelete(this);
                        return;
                    }
                    return;
                }
            }
            if (this.mCallback != null) {
                this.mCallback.onClick(this);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void switchAnim(int i, final Runnable runnable) {
        final TextView textView = this.mPoiTV;
        switch (i) {
            case 0:
                mid2Up(textView, new PoiInputSearchWidget.AnimationListenerAdapter() {
                    /* class com.amap.api.navi.view.PoiInputItemWidget.AnonymousClass1 */

                    @Override // com.amap.api.navi.view.PoiInputSearchWidget.AnimationListenerAdapter
                    public final void onAnimationEnd(Animation animation) {
                        PoiInputItemWidget.this.post(runnable);
                        PoiInputItemWidget.this.up2Mid(textView, null);
                    }
                });
                return;
            case 1:
                mid2Down(textView, new PoiInputSearchWidget.AnimationListenerAdapter() {
                    /* class com.amap.api.navi.view.PoiInputItemWidget.AnonymousClass2 */

                    @Override // com.amap.api.navi.view.PoiInputSearchWidget.AnimationListenerAdapter
                    public final void onAnimationEnd(Animation animation) {
                        PoiInputItemWidget.this.post(runnable);
                        PoiInputItemWidget.this.down2Mid(textView, null);
                    }
                });
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void down2Mid(View view, PoiInputSearchWidget.AnimationListenerAdapter animationListenerAdapter) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) getHeight(), 0.0f);
        translateAnimation.setDuration((long) this.animDuration);
        translateAnimation.setAnimationListener(animationListenerAdapter);
        view.startAnimation(translateAnimation);
    }

    private void mid2Up(View view, PoiInputSearchWidget.AnimationListenerAdapter animationListenerAdapter) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-getHeight()));
        translateAnimation.setDuration((long) this.animDuration);
        translateAnimation.setAnimationListener(animationListenerAdapter);
        view.startAnimation(translateAnimation);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void up2Mid(View view, PoiInputSearchWidget.AnimationListenerAdapter animationListenerAdapter) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) (-getHeight()), 0.0f);
        translateAnimation.setDuration((long) this.animDuration);
        translateAnimation.setAnimationListener(animationListenerAdapter);
        view.startAnimation(translateAnimation);
    }

    private void mid2Down(View view, PoiInputSearchWidget.AnimationListenerAdapter animationListenerAdapter) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) getHeight());
        translateAnimation.setDuration((long) this.animDuration);
        translateAnimation.setAnimationListener(animationListenerAdapter);
        view.startAnimation(translateAnimation);
    }
}
