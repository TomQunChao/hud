package com.amap.api.navi.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.col.stln3.mk;
import com.amap.api.col.stln3.mm;
import com.amap.api.navi.R;

public class MultiRouteBubble extends RelativeLayout {
    public static final int BUBBLE_POSITION_LB = 2;
    public static final int BUBBLE_POSITION_LT = 1;
    public static final int BUBBLE_POSITION_RB = 4;
    public static final int BUBBLE_POSITION_RT = 3;
    public static final int BUBBLE_VIEW_TYPE_NAVI = 1;
    public static final int BUBBLE_VIEW_TYPE_PREVIEW = 2;
    public float[] anchor;
    private View container;
    private int currentType;
    Drawable drawableLB;
    Drawable drawableLT;
    Drawable drawableRB;
    Drawable drawableRT;
    Drawable drawableTollLess;
    Drawable drawableTollMore;
    Drawable drawableTrafficLess;
    Drawable drawableTrafficMore;
    private ImageView ivToll;
    private ImageView ivTraffic;
    private Context mContext;
    private TextView tvDetail;
    private TextView tvTimeInfo;
    private TextView tvTrafficInfo;

    public MultiRouteBubble(Context context) {
        super(context);
        this.tvTimeInfo = null;
        this.ivToll = null;
        this.tvDetail = null;
        this.ivTraffic = null;
        this.tvTrafficInfo = null;
        this.currentType = 1;
        this.anchor = new float[2];
        this.drawableLB = null;
        this.drawableLT = null;
        this.drawableRB = null;
        this.drawableRT = null;
        this.drawableTollMore = null;
        this.drawableTollLess = null;
        this.drawableTrafficMore = null;
        this.drawableTrafficLess = null;
        init(context);
    }

    public MultiRouteBubble(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tvTimeInfo = null;
        this.ivToll = null;
        this.tvDetail = null;
        this.ivTraffic = null;
        this.tvTrafficInfo = null;
        this.currentType = 1;
        this.anchor = new float[2];
        this.drawableLB = null;
        this.drawableLT = null;
        this.drawableRB = null;
        this.drawableRT = null;
        this.drawableTollMore = null;
        this.drawableTollLess = null;
        this.drawableTrafficMore = null;
        this.drawableTrafficLess = null;
        init(context);
    }

    public MultiRouteBubble(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tvTimeInfo = null;
        this.ivToll = null;
        this.tvDetail = null;
        this.ivTraffic = null;
        this.tvTrafficInfo = null;
        this.currentType = 1;
        this.anchor = new float[2];
        this.drawableLB = null;
        this.drawableLT = null;
        this.drawableRB = null;
        this.drawableRT = null;
        this.drawableTollMore = null;
        this.drawableTollLess = null;
        this.drawableTrafficMore = null;
        this.drawableTrafficLess = null;
        init(context);
    }

    public MultiRouteBubble(Context context, int i) {
        super(context);
        this.tvTimeInfo = null;
        this.ivToll = null;
        this.tvDetail = null;
        this.ivTraffic = null;
        this.tvTrafficInfo = null;
        this.currentType = 1;
        this.anchor = new float[2];
        this.drawableLB = null;
        this.drawableLT = null;
        this.drawableRB = null;
        this.drawableRT = null;
        this.drawableTollMore = null;
        this.drawableTollLess = null;
        this.drawableTrafficMore = null;
        this.drawableTrafficLess = null;
        init(context);
        setBubbleType(i);
    }

    private void init(Context context) {
        try {
            if (context instanceof mk) {
                this.mContext = ((mk) context).getBaseContext();
            } else {
                this.mContext = context;
            }
            mm.a(this.mContext.getApplicationContext());
            this.container = mm.a(this.mContext, R.layout.amap_navi_navi_sdk_multi_route_bubble_layout, null);
            addView(this.container);
            this.tvTimeInfo = (TextView) this.container.findViewById(R.id.nav_sdk_tv_multi_route_time_info);
            this.ivToll = (ImageView) this.container.findViewById(R.id.nav_sdk_image_multi_route_toll);
            this.tvDetail = (TextView) this.container.findViewById(R.id.nav_sdk_tv_multi_route_detail);
            this.ivTraffic = (ImageView) this.container.findViewById(R.id.nav_sdk_ic_multi_route_traffic_lights);
            this.tvTrafficInfo = (TextView) this.container.findViewById(R.id.nav_sdk_tv_multi_route_traffic_lights);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setBubblePosition(int i) {
        switch (i) {
            case 1:
                if (this.drawableLT == null) {
                    this.drawableLT = mm.a().getDrawable(com.a11hud.www.R.attr.layout_anchor);
                }
                this.container.setBackgroundDrawable(this.drawableLT);
                float[] fArr = this.anchor;
                fArr[0] = 1.0f;
                fArr[1] = 1.0f;
                break;
            case 2:
                if (this.drawableLB == null) {
                    this.drawableLB = mm.a().getDrawable(com.a11hud.www.R.attr.layout);
                }
                this.container.setBackgroundDrawable(this.drawableLB);
                float[] fArr2 = this.anchor;
                fArr2[0] = 1.0f;
                fArr2[1] = 0.0f;
                break;
            case 3:
                if (this.drawableRT == null) {
                    this.drawableRT = mm.a().getDrawable(com.a11hud.www.R.attr.layout_behavior);
                }
                this.container.setBackgroundDrawable(this.drawableRT);
                float[] fArr3 = this.anchor;
                fArr3[0] = 0.0f;
                fArr3[1] = 1.0f;
                break;
            case 4:
                if (this.drawableRB == null) {
                    this.drawableRB = mm.a().getDrawable(com.a11hud.www.R.attr.layout_anchorGravity);
                }
                this.container.setBackgroundDrawable(this.drawableRB);
                float[] fArr4 = this.anchor;
                fArr4[0] = 0.0f;
                fArr4[1] = 0.0f;
                break;
            default:
                if (this.drawableLB == null) {
                    this.drawableLB = mm.a().getDrawable(com.a11hud.www.R.attr.layout);
                }
                this.container.setBackgroundDrawable(this.drawableLB);
                float[] fArr5 = this.anchor;
                fArr5[0] = 1.0f;
                fArr5[1] = 0.0f;
                break;
        }
        invalidate();
    }

    public void setNaviStateInfo(int i, boolean z, String str, String str2) {
        setBubblePosition(i);
        setUseMoreTime(z);
        setBubbleType(1);
        this.tvTimeInfo.setText(str);
        this.tvDetail.setText(str2);
    }

    public void setPreviewStateInfo(int i, boolean z, String str, boolean z2, String str2, String str3) {
        setBubblePosition(i);
        setUseMoreTime(z);
        setBubbleType(2);
        if (z2) {
            this.ivToll.setVisibility(0);
        } else {
            this.ivToll.setVisibility(8);
        }
        if (TextUtils.isEmpty(str3)) {
            this.ivTraffic.setVisibility(8);
            this.tvTrafficInfo.setVisibility(8);
        } else {
            this.ivTraffic.setVisibility(0);
            this.tvTrafficInfo.setVisibility(0);
            this.tvTrafficInfo.setText(str3);
        }
        this.tvTimeInfo.setText(str);
        this.tvDetail.setText(str2);
    }

    public void setUseMoreTime(boolean z) {
        if (z) {
            this.tvTimeInfo.setTextColor(mm.a().getColor(com.a11hud.www.R.dimen.abc_disabled_alpha_material_dark));
            this.tvDetail.setTextColor(mm.a().getColor(com.a11hud.www.R.dimen.abc_disabled_alpha_material_dark));
            this.tvTrafficInfo.setTextColor(mm.a().getColor(com.a11hud.www.R.dimen.abc_disabled_alpha_material_dark));
            if (this.drawableTollMore == null) {
                this.drawableTollMore = mm.a().getDrawable(com.a11hud.www.R.attr.layout_constraintBaseline_creator);
            }
            this.ivToll.setBackgroundDrawable(this.drawableTollMore);
            if (this.drawableTrafficMore == null) {
                this.drawableTrafficMore = mm.a().getDrawable(com.a11hud.www.R.attr.layout_constraintBaseline_toBaselineOf);
            }
            this.ivTraffic.setBackgroundDrawable(this.drawableTrafficMore);
            return;
        }
        this.tvTimeInfo.setTextColor(mm.a().getColor(com.a11hud.www.R.dimen.abc_dropdownitem_icon_width));
        this.tvDetail.setTextColor(mm.a().getColor(com.a11hud.www.R.dimen.abc_dropdownitem_icon_width));
        this.tvTrafficInfo.setTextColor(mm.a().getColor(com.a11hud.www.R.dimen.abc_dropdownitem_icon_width));
        if (this.drawableTollLess == null) {
            this.drawableTollLess = mm.a().getDrawable(com.a11hud.www.R.attr.layout_constrainedHeight);
        }
        this.ivToll.setBackgroundDrawable(this.drawableTollLess);
        if (this.drawableTrafficLess == null) {
            this.drawableTrafficLess = mm.a().getDrawable(com.a11hud.www.R.attr.layout_constrainedWidth);
        }
        this.ivTraffic.setBackgroundDrawable(this.drawableTrafficLess);
    }

    public void setTimeInfo(String str) {
        this.tvTimeInfo.setText(str);
    }

    public void setDetailInfo(String str) {
        this.tvDetail.setText(str);
    }

    public void setTvTrafficInfo(String str) {
        if (2 == this.currentType) {
            this.ivTraffic.setVisibility(0);
            this.tvTrafficInfo.setText(str);
            return;
        }
        this.ivTraffic.setVisibility(8);
        this.tvTrafficInfo.setText("");
    }

    public void setIsNeedToll(boolean z) {
        if (2 != this.currentType) {
            this.ivToll.setVisibility(8);
        } else if (z) {
            this.ivToll.setVisibility(0);
        } else {
            this.ivToll.setVisibility(8);
        }
    }

    public void setBubbleType(int i) {
        this.currentType = i;
        if (1 == i) {
            this.ivToll.setVisibility(8);
            this.ivTraffic.setVisibility(8);
            this.tvTrafficInfo.setVisibility(8);
        }
    }
}
