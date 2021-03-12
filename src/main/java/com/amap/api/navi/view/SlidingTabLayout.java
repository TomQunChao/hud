package com.amap.api.navi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.col.stln3.km;
import com.amap.api.col.stln3.mj;
import com.amap.api.col.stln3.mm;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.R;
import com.amap.api.navi.model.AMapNaviGuide;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapNaviStep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SlidingTabLayout extends RelativeLayout implements View.OnClickListener {
    Drawable bgTab;
    Drawable bgTabPressed;
    private ISlidingCallback callback;
    int distanceTextColor;
    int distanceTextColorPressed;
    private View.OnClickListener listener;
    private LoadingView loadingView;
    private Button mFootEmulatorNaviButton;
    private Button mFootGPSNaviButton;
    private TextView mLimitForbiddenInfo;
    private TextView mRouteInfo;
    private TextView mRouteTab1Distance;
    private TextView mRouteTab1Strategy;
    private TextView mRouteTab1Time;
    private TextView mRouteTab2Distance;
    private TextView mRouteTab2Strategy;
    private TextView mRouteTab2Time;
    private TextView mRouteTab3Distance;
    private TextView mRouteTab3Strategy;
    private TextView mRouteTab3Time;
    private Button mTopNaviButton;
    private LinearLayout multipleRouteLayout;
    private NaviGuideWidget naviGuideWidget;
    int pathLen_2;
    int pathLen_3;
    private LinearLayout routeTab1;
    private LinearLayout routeTab2;
    private LinearLayout routeTab3;
    private RelativeLayout singleRouteLayout;
    private TextView singleRouteText;
    private RelativeLayout tabInfoLayout;
    int timeTextColor;
    int timeTextColorPressed;
    int titleTextColor;
    int titleTextColorPressed;
    int viewBgColor;
    int viewBgColorPressed;

    public interface ISlidingCallback {
        void drawRoutes(int i, AMapNaviPath aMapNaviPath);

        void selectRoute(int i);
    }

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pathLen_2 = 2;
        this.pathLen_3 = 3;
        getThemeAttrs(context);
        initView();
    }

    private void getThemeAttrs(Context context) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(R.styleable.amap_navi_chooserouteline);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
        if (resourceId == -1) {
            this.bgTab = mm.a().getDrawable(com.a11hud.www.R.attr.maxButtonHeight);
        } else {
            this.bgTab = mm.a().getDrawable(resourceId);
        }
        if (resourceId2 == -1) {
            this.bgTabPressed = mm.a().getDrawable(com.a11hud.www.R.attr.switchMinWidth);
        } else {
            this.bgTabPressed = mm.a().getDrawable(resourceId2);
        }
        this.viewBgColor = obtainStyledAttributes.getColor(2, Color.parseColor("#E2E2E2"));
        this.viewBgColorPressed = obtainStyledAttributes.getColor(3, Color.parseColor("#4287FF"));
        this.titleTextColor = obtainStyledAttributes.getColor(4, ViewCompat.MEASURED_STATE_MASK);
        this.titleTextColorPressed = obtainStyledAttributes.getColor(5, -1);
        this.timeTextColor = obtainStyledAttributes.getColor(6, ViewCompat.MEASURED_STATE_MASK);
        this.timeTextColorPressed = obtainStyledAttributes.getColor(7, Color.parseColor("#4287FF"));
        this.distanceTextColor = obtainStyledAttributes.getColor(8, ViewCompat.MEASURED_STATE_MASK);
        this.distanceTextColorPressed = obtainStyledAttributes.getColor(9, Color.parseColor("#4287FF"));
        obtainStyledAttributes.recycle();
    }

    private void initView() {
        RelativeLayout relativeLayout = (RelativeLayout) mm.a(getContext(), R.layout.amap_navi_lbs_route_sliding_tabs, null);
        this.tabInfoLayout = (RelativeLayout) relativeLayout.findViewById(R.id.navi_sdk_route_select_tabinfo);
        this.multipleRouteLayout = (LinearLayout) relativeLayout.findViewById(R.id.navi_sdk_route_select_tabs);
        this.routeTab1 = (LinearLayout) relativeLayout.findViewById(R.id.navi_sdk_route_select_tab1);
        this.mRouteTab1Strategy = (TextView) relativeLayout.findViewById(R.id.navi_sdk_route_select_tab1_strategy);
        this.mRouteTab1Time = (TextView) relativeLayout.findViewById(R.id.navi_sdk_route_select_tab1_time);
        this.mRouteTab1Distance = (TextView) relativeLayout.findViewById(R.id.navi_sdk_route_select_tab1_distance);
        this.routeTab2 = (LinearLayout) relativeLayout.findViewById(R.id.navi_sdk_route_select_tab2);
        this.mRouteTab2Strategy = (TextView) relativeLayout.findViewById(R.id.navi_sdk_route_select_tab2_strategy);
        this.mRouteTab2Time = (TextView) relativeLayout.findViewById(R.id.navi_sdk_route_select_tab2_time);
        this.mRouteTab2Distance = (TextView) relativeLayout.findViewById(R.id.navi_sdk_route_select_tab2_distance);
        this.routeTab3 = (LinearLayout) relativeLayout.findViewById(R.id.navi_sdk_route_select_tab3);
        this.mRouteTab3Strategy = (TextView) relativeLayout.findViewById(R.id.navi_sdk_route_select_tab3_strategy);
        this.mRouteTab3Time = (TextView) relativeLayout.findViewById(R.id.navi_sdk_route_select_tab3_time);
        this.mRouteTab3Distance = (TextView) relativeLayout.findViewById(R.id.navi_sdk_route_select_tab3_distance);
        this.singleRouteLayout = (RelativeLayout) relativeLayout.findViewById(R.id.navi_sdk_route_select_single_layout);
        this.singleRouteText = (TextView) relativeLayout.findViewById(R.id.navi_sdk_route_select_single_text);
        this.naviGuideWidget = (NaviGuideWidget) relativeLayout.findViewById(R.id.navi_sdk_route_select_guidelist);
        this.mRouteInfo = (TextView) relativeLayout.findViewById(R.id.navi_sdk_route_select_info_traffic);
        this.mLimitForbiddenInfo = (TextView) relativeLayout.findViewById(R.id.navi_sdk_route_select_info_forbidden);
        this.mTopNaviButton = (Button) relativeLayout.findViewById(R.id.navi_sdk_route_select_info_navi);
        this.mTopNaviButton.setOnClickListener(this);
        this.loadingView = (LoadingView) relativeLayout.findViewById(R.id.navi_sdk_loading);
        this.mFootEmulatorNaviButton = (Button) relativeLayout.findViewById(R.id.navi_sdk_route_select_foot_emulatornavi_btn);
        this.mFootEmulatorNaviButton.setOnClickListener(this);
        this.mFootGPSNaviButton = (Button) relativeLayout.findViewById(R.id.navi_sdk_route_select_foot_gpsnavi_btn);
        this.mFootGPSNaviButton.setOnClickListener(this);
        this.routeTab1.setOnClickListener(this);
        this.routeTab2.setOnClickListener(this);
        this.routeTab3.setOnClickListener(this);
        addView(relativeLayout);
    }

    public void setSlidingClickCallback(View.OnClickListener onClickListener) {
        this.listener = onClickListener;
    }

    public void setSlidingCallback(ISlidingCallback iSlidingCallback) {
        this.callback = iSlidingCallback;
    }

    public void selectRouteTab(int i) {
        if (i == 2147479765) {
            this.routeTab1.setBackgroundDrawable(this.bgTabPressed);
            this.routeTab2.setBackgroundDrawable(this.bgTab);
            this.routeTab3.setBackgroundDrawable(this.bgTab);
            this.mRouteTab1Strategy.setBackgroundColor(this.viewBgColorPressed);
            this.mRouteTab2Strategy.setBackgroundColor(this.viewBgColor);
            this.mRouteTab3Strategy.setBackgroundColor(this.viewBgColor);
            this.mRouteTab1Strategy.setTextColor(this.titleTextColorPressed);
            this.mRouteTab2Strategy.setTextColor(this.titleTextColor);
            this.mRouteTab3Strategy.setTextColor(this.titleTextColor);
            this.mRouteTab1Time.setTextColor(this.timeTextColorPressed);
            this.mRouteTab2Time.setTextColor(this.timeTextColor);
            this.mRouteTab3Time.setTextColor(this.timeTextColor);
            this.mRouteTab1Distance.setTextColor(this.distanceTextColorPressed);
            this.mRouteTab2Distance.setTextColor(this.distanceTextColor);
            this.mRouteTab3Distance.setTextColor(this.distanceTextColor);
            this.callback.selectRoute(12);
        }
        if (i == 2147479769) {
            this.routeTab1.setBackgroundDrawable(this.bgTab);
            this.routeTab2.setBackgroundDrawable(this.bgTabPressed);
            this.routeTab3.setBackgroundDrawable(this.bgTab);
            this.mRouteTab1Strategy.setBackgroundColor(this.viewBgColor);
            this.mRouteTab2Strategy.setBackgroundColor(this.viewBgColorPressed);
            this.mRouteTab3Strategy.setBackgroundColor(this.viewBgColor);
            this.mRouteTab1Strategy.setTextColor(this.titleTextColor);
            this.mRouteTab2Strategy.setTextColor(this.titleTextColorPressed);
            this.mRouteTab3Strategy.setTextColor(this.titleTextColor);
            this.mRouteTab1Time.setTextColor(this.timeTextColor);
            this.mRouteTab2Time.setTextColor(this.timeTextColorPressed);
            this.mRouteTab3Time.setTextColor(this.timeTextColor);
            this.mRouteTab1Distance.setTextColor(this.distanceTextColor);
            this.mRouteTab2Distance.setTextColor(this.distanceTextColorPressed);
            this.mRouteTab3Distance.setTextColor(this.distanceTextColor);
            this.callback.selectRoute(13);
        }
        if (i == 2147479773) {
            this.routeTab1.setBackgroundDrawable(this.bgTab);
            this.routeTab2.setBackgroundDrawable(this.bgTab);
            this.routeTab3.setBackgroundDrawable(this.bgTabPressed);
            this.mRouteTab1Strategy.setBackgroundColor(this.viewBgColor);
            this.mRouteTab2Strategy.setBackgroundColor(this.viewBgColor);
            this.mRouteTab3Strategy.setBackgroundColor(this.viewBgColorPressed);
            this.mRouteTab1Strategy.setTextColor(this.titleTextColor);
            this.mRouteTab2Strategy.setTextColor(this.titleTextColor);
            this.mRouteTab3Strategy.setTextColor(this.titleTextColorPressed);
            this.mRouteTab1Time.setTextColor(this.timeTextColor);
            this.mRouteTab2Time.setTextColor(this.timeTextColor);
            this.mRouteTab3Time.setTextColor(this.timeTextColorPressed);
            this.mRouteTab1Distance.setTextColor(this.distanceTextColor);
            this.mRouteTab2Distance.setTextColor(this.distanceTextColor);
            this.mRouteTab3Distance.setTextColor(this.distanceTextColorPressed);
            this.callback.selectRoute(14);
        }
    }

    public void updateRouteTable(int[] iArr, HashMap<Integer, AMapNaviPath> hashMap) {
        AMapNaviPath aMapNaviPath;
        AMapNaviPath aMapNaviPath2;
        if (iArr != null && hashMap != null) {
            int length = iArr.length;
            this.routeTab1.setVisibility(8);
            this.routeTab2.setVisibility(8);
            this.routeTab3.setVisibility(8);
            AMapNaviPath aMapNaviPath3 = null;
            if (length == this.pathLen_2) {
                aMapNaviPath2 = hashMap.get(Integer.valueOf(iArr[0]));
                aMapNaviPath = hashMap.get(Integer.valueOf(iArr[1]));
            } else {
                aMapNaviPath2 = null;
                aMapNaviPath = null;
            }
            if (length == this.pathLen_3) {
                aMapNaviPath2 = hashMap.get(Integer.valueOf(iArr[0]));
                aMapNaviPath = hashMap.get(Integer.valueOf(iArr[1]));
                aMapNaviPath3 = hashMap.get(Integer.valueOf(iArr[2]));
            }
            if (aMapNaviPath2 != null) {
                this.callback.drawRoutes(iArr[0], aMapNaviPath2);
                this.routeTab1.setVisibility(0);
                this.mRouteTab1Time.setText(mj.c(aMapNaviPath2.getAllTime()));
                this.mRouteTab1Distance.setText(String.format("%.1f", Float.valueOf(((float) aMapNaviPath2.getAllLength()) / 1000.0f)) + "公里");
                if (aMapNaviPath2.getLabels().contains(",")) {
                    this.mRouteTab1Strategy.setText(aMapNaviPath2.getLabels().substring(0, aMapNaviPath2.getLabels().indexOf(",")));
                } else {
                    this.mRouteTab1Strategy.setText(String.valueOf(aMapNaviPath2.getLabels()));
                }
            }
            if (aMapNaviPath != null) {
                this.callback.drawRoutes(iArr[1], aMapNaviPath);
                this.routeTab2.setVisibility(0);
                this.mRouteTab2Time.setText(mj.c(aMapNaviPath.getAllTime()));
                this.mRouteTab2Distance.setText(String.format("%.1f", Float.valueOf(((float) aMapNaviPath.getAllLength()) / 1000.0f)) + "公里");
                if (aMapNaviPath.getLabels().contains(",")) {
                    this.mRouteTab2Strategy.setText(aMapNaviPath.getLabels().substring(0, aMapNaviPath.getLabels().indexOf(",")));
                } else {
                    this.mRouteTab2Strategy.setText(String.valueOf(aMapNaviPath.getLabels()));
                }
            }
            if (aMapNaviPath3 != null) {
                this.callback.drawRoutes(iArr[2], aMapNaviPath3);
                this.routeTab3.setVisibility(0);
                this.mRouteTab3Time.setText(mj.c(aMapNaviPath3.getAllTime()));
                this.mRouteTab3Distance.setText(String.format("%.1f", Float.valueOf(((float) aMapNaviPath3.getAllLength()) / 1000.0f)) + "公里");
                if (aMapNaviPath3.getLabels().contains(",")) {
                    this.mRouteTab3Strategy.setText(aMapNaviPath3.getLabels().substring(0, aMapNaviPath3.getLabels().indexOf(",")));
                    return;
                }
                this.mRouteTab3Strategy.setText(String.valueOf(aMapNaviPath3.getLabels()));
            }
        }
    }

    public void showLoading() {
        this.loadingView.showLoading();
        this.loadingView.setVisibility(0);
        this.tabInfoLayout.setVisibility(4);
    }

    public void hideLoading() {
        this.loadingView.hideLoading();
        this.loadingView.setVisibility(8);
        this.tabInfoLayout.setVisibility(0);
    }

    public void showFailedLoading(String str) {
        this.loadingView.setVisibility(0);
        this.loadingView.showFailed(str, this);
        this.tabInfoLayout.setVisibility(4);
    }

    public void setMultipleRouteLayoutVisible(boolean z) {
        LinearLayout linearLayout = this.multipleRouteLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(z ? 0 : 8);
        }
    }

    public void setSingleRouteLayoutVisible(boolean z) {
        RelativeLayout relativeLayout = this.singleRouteLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(z ? 0 : 8);
        }
    }

    public void setGuideData(String str, String str2, AMapNavi aMapNavi) {
        NaviGuideWidget naviGuideWidget2 = this.naviGuideWidget;
        if (naviGuideWidget2 != null) {
            naviGuideWidget2.setGuideData(str, str2, getGuideGroup(aMapNavi));
        }
    }

    public void updateRouteInfo(String str) {
        TextView textView = this.mRouteInfo;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void updateLimitForbiddenInfo(String str) {
        if (this.mLimitForbiddenInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.mLimitForbiddenInfo.setText(str);
            this.mLimitForbiddenInfo.setVisibility(0);
            return;
        }
        this.mLimitForbiddenInfo.setVisibility(8);
    }

    public void updateSingleRouteInfo(String str) {
        TextView textView = this.singleRouteText;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public Button getTopNaviButton() {
        return this.mTopNaviButton;
    }

    public boolean isLoadingShowing() {
        return this.loadingView.isShowing();
    }

    public void onClick(View view) {
        try {
            if (this.listener != null) {
                this.listener.onClick(view);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private List<km> getGuideGroup(AMapNavi aMapNavi) {
        String str;
        int i;
        ArrayList arrayList = new ArrayList();
        try {
            List<AMapNaviGuide> naviGuideList = aMapNavi.getNaviGuideList();
            List<AMapNaviStep> steps = aMapNavi.getNaviPath().getSteps();
            for (int i2 = 0; i2 < naviGuideList.size(); i2++) {
                AMapNaviGuide aMapNaviGuide = naviGuideList.get(i2);
                km kmVar = new km();
                kmVar.c(aMapNaviGuide.getIconType());
                kmVar.a(aMapNaviGuide.getLength());
                kmVar.a(aMapNaviGuide.getName());
                kmVar.d(aMapNaviGuide.getToll());
                int segCount = aMapNaviGuide.getSegCount();
                int startSegId = aMapNaviGuide.getStartSegId();
                int i3 = startSegId;
                int i4 = 0;
                while (true) {
                    int i5 = segCount + startSegId;
                    if (i3 >= i5) {
                        break;
                    }
                    AMapNaviStep aMapNaviStep = steps.get(i3);
                    i4 += aMapNaviStep.getTrafficLightNumber();
                    int i6 = i5 - 1;
                    if (i3 == i6 && i2 == naviGuideList.size() - 1) {
                        str = "终点";
                    } else if (i3 != i6 || (i = i2 + 1) >= naviGuideList.size() - 1) {
                        str = aMapNaviStep.getLinks().get(0).getRoadName();
                    } else {
                        str = naviGuideList.get(i).getName();
                    }
                    kmVar.a().add(new km.a(aMapNaviStep.getIconType(), str, aMapNaviStep.getLength()));
                    i3++;
                }
                kmVar.b(i4);
                arrayList.add(kmVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return arrayList;
    }
}
