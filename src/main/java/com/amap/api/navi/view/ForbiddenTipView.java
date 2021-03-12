package com.amap.api.navi.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.col.stln3.kg;
import com.amap.api.col.stln3.mk;
import com.amap.api.col.stln3.mm;
import com.amap.api.navi.R;
import com.amap.api.navi.model.AMapNaviRouteNotifyData;
import com.amap.api.navi.model.AMapRestrictionInfo;

public class ForbiddenTipView extends RelativeLayout implements View.OnClickListener {
    public static final int FORBIDDEN_TYPE_CAN_NOT_AVOID_NAVI = 2;
    public static final int FORBIDDEN_TYPE_CAN_NOT_AVOID_ROUTE = 1;
    private static final int THEME_TYPE_AVOID = 1;
    private static final int THEME_TYPE_FORBIDDEN = 2;
    public static final int TIP_HEIGHT = 60;
    Bitmap ivBitmap = null;
    ImageView ivForbidden = null;
    View layoutForbiddenRight = null;
    View lineView = null;
    Context mContext;
    private int mForbiddenType = 1;
    a timeCount = null;
    TipVisibleListener tipListener = null;
    TextView tvForbiddenDetail = null;
    TextView tvForbiddenTime = null;
    TextView tvForbiddenTitle = null;

    public interface TipVisibleListener {
        void onTipHide();

        void onTipShow();
    }

    public ForbiddenTipView(Context context) {
        super(context);
        init(context);
    }

    public ForbiddenTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ForbiddenTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        if (context instanceof mk) {
            this.mContext = ((mk) context).getBaseContext();
        } else {
            this.mContext = context;
        }
        mm.a(this.mContext, R.layout.amap_navi_lbs_forbidden_tip, this);
        this.ivForbidden = (ImageView) findViewById(R.id.navi_sdk_lbs_iv_forbidden_left);
        this.tvForbiddenTitle = (TextView) findViewById(R.id.navi_sdk_lbs_tv_forbidden_title);
        this.tvForbiddenDetail = (TextView) findViewById(R.id.navi_sdk_lbs_tv_forbidden_detail);
        this.layoutForbiddenRight = findViewById(R.id.navi_sdk_lbs_layout_forbidden_right);
        this.lineView = findViewById(R.id.navi_sdk_lbs_line_forbidden);
        this.tvForbiddenTime = (TextView) findViewById(R.id.navi_sdk_lbs_tv_forbidden_time);
        this.tvForbiddenTime.setOnClickListener(this);
    }

    public void setForbiddenTipListener(TipVisibleListener tipVisibleListener) {
        this.tipListener = tipVisibleListener;
    }

    public void setRestrictionInfo(AMapRestrictionInfo aMapRestrictionInfo, int i, boolean z) {
        String str;
        int titleType = aMapRestrictionInfo.getTitleType();
        int i2 = 2;
        if (titleType >= 2 && titleType <= 6) {
            if (titleType == 2) {
                str = "已为您避开限行路段";
                i2 = 1;
            } else {
                str = "无法为您避开限行";
            }
            this.ivForbidden.setVisibility(8);
            setForbiddenTheme(i2);
            String restrictionTitle = aMapRestrictionInfo.getRestrictionTitle();
            setTitleText(str);
            setDetailText(restrictionTitle);
            if (i > 0) {
                startTimer(i * 1000);
            }
            if (z) {
                this.layoutForbiddenRight.setVisibility(0);
            } else {
                this.layoutForbiddenRight.setVisibility(8);
            }
            setVisibility(0);
            TipVisibleListener tipVisibleListener = this.tipListener;
            if (tipVisibleListener != null) {
                tipVisibleListener.onTipShow();
            }
        }
    }

    public void setNotifyData(AMapNaviRouteNotifyData aMapNaviRouteNotifyData, int i) {
        int i2;
        int i3;
        if (aMapNaviRouteNotifyData != null) {
            Resources a2 = mm.a();
            if (aMapNaviRouteNotifyData.getNotifyType() != kg.ai) {
                i3 = mm.a().getColor(com.a11hud.www.R.dimen.abc_dialog_fixed_height_major);
                i2 = mm.a().getColor(com.a11hud.www.R.dimen.abc_dialog_fixed_height_minor);
                if (aMapNaviRouteNotifyData.isSuccess()) {
                    setBackgroundResource(com.a11hud.www.R.attr.switchTextAppearance);
                } else {
                    setBackgroundResource(com.a11hud.www.R.attr.textAllCaps);
                }
                int notifyType = aMapNaviRouteNotifyData.getNotifyType();
                this.ivBitmap = BitmapFactory.decodeResource(a2, com.a11hud.www.R.attr.autoSizeTextType);
                if (notifyType == 3) {
                    this.ivBitmap = BitmapFactory.decodeResource(a2, com.a11hud.www.R.attr.autoSizePresetSizes);
                } else if (notifyType == 4) {
                    this.ivBitmap = BitmapFactory.decodeResource(a2, com.a11hud.www.R.attr.background);
                }
            } else {
                i3 = mm.a().getColor(com.a11hud.www.R.dimen.abc_action_bar_content_inset_material);
                i2 = mm.a().getColor(com.a11hud.www.R.dimen.abc_action_bar_icon_vertical_padding_material);
                setBackgroundResource(com.a11hud.www.R.attr.switchTextAppearance);
                this.ivBitmap = BitmapFactory.decodeResource(a2, com.a11hud.www.R.attr.autoSizeStepGranularity);
            }
            this.ivForbidden.setVisibility(0);
            this.tvForbiddenTitle.setVisibility(0);
            this.tvForbiddenDetail.setVisibility(0);
            this.layoutForbiddenRight.setVisibility(8);
            this.tvForbiddenTitle.setTextColor(i3);
            this.tvForbiddenDetail.setTextColor(i2);
            this.ivForbidden.setImageBitmap(this.ivBitmap);
            this.tvForbiddenTitle.setText(aMapNaviRouteNotifyData.getReason());
            this.tvForbiddenDetail.setText(aMapNaviRouteNotifyData.getSubTitle());
            setVisibility(0);
            if (i > 0) {
                startTimer(i * 1000);
            }
        }
    }

    private void setForbiddenTheme(int i) {
        int color = mm.a().getColor(com.a11hud.www.R.dimen.abc_dialog_fixed_height_major);
        int color2 = mm.a().getColor(com.a11hud.www.R.dimen.abc_dialog_fixed_height_minor);
        int color3 = mm.a().getColor(com.a11hud.www.R.dimen.abc_dialog_fixed_width_major);
        switch (i) {
            case 1:
                setBackgroundResource(com.a11hud.www.R.attr.textAppearanceListItem);
                color = mm.a().getColor(com.a11hud.www.R.dimen.abc_dialog_list_padding_bottom_no_buttons);
                color2 = mm.a().getColor(com.a11hud.www.R.dimen.abc_dialog_list_padding_top_no_title);
                color3 = mm.a().getColor(com.a11hud.www.R.dimen.abc_dialog_min_width_major);
                this.tvForbiddenDetail.setVisibility(8);
                break;
            case 2:
                this.tvForbiddenDetail.setVisibility(0);
                setBackgroundResource(com.a11hud.www.R.attr.textAllCaps);
                color = mm.a().getColor(com.a11hud.www.R.dimen.abc_dialog_fixed_height_major);
                color2 = mm.a().getColor(com.a11hud.www.R.dimen.abc_dialog_fixed_height_minor);
                color3 = mm.a().getColor(com.a11hud.www.R.dimen.abc_dialog_fixed_width_major);
                break;
        }
        this.tvForbiddenTitle.setTextColor(color);
        this.tvForbiddenDetail.setTextColor(color2);
        this.lineView.setBackgroundColor(color3);
        this.tvForbiddenTime.setTextColor(color2);
    }

    public void setTitleText(String str) {
        this.tvForbiddenTitle.setText(str);
    }

    public void setDetailText(String str) {
        this.tvForbiddenDetail.setText(str);
    }

    public void startTimer(int i) {
        if (this.mForbiddenType != 2) {
            a aVar = this.timeCount;
            if (aVar != null) {
                aVar.cancel();
                this.timeCount = null;
            }
            if (this.timeCount == null) {
                this.timeCount = new a((long) i);
            }
            this.timeCount.start();
        }
    }

    private void recycleSource() {
        a aVar = this.timeCount;
        if (aVar != null) {
            aVar.cancel();
        }
        setVisibility(8);
        Bitmap bitmap = this.ivBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.ivBitmap = null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void finish() {
        recycleSource();
        TipVisibleListener tipVisibleListener = this.tipListener;
        if (tipVisibleListener != null) {
            tipVisibleListener.onTipHide();
        }
    }

    public void onClick(View view) {
        if (view.getId() == 2147479654) {
            finish();
        }
    }

    public void destroy() {
        recycleSource();
    }

    /* access modifiers changed from: package-private */
    public class a extends CountDownTimer {
        public a(long j) {
            super(j, 1000);
        }

        public final void onTick(long j) {
            if (ForbiddenTipView.this.tvForbiddenTime != null) {
                TextView textView = ForbiddenTipView.this.tvForbiddenTime;
                textView.setText("知道了(" + (j / 1000) + "s)");
            }
        }

        public final void onFinish() {
            ForbiddenTipView.this.finish();
        }
    }
}
