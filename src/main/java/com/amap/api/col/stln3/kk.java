package com.amap.api.col.stln3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.a11hud.www.R;
import com.amap.api.col.stln3.km;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: NaviGuideAdapter */
public final class kk extends BaseExpandableListAdapter {
    List<km> a = new ArrayList();
    Context b = null;
    int c = -1;
    int d = -2;
    private int[] e = {R.attr.actionBarItemBackground, R.attr.actionBarItemBackground, R.attr.actionBarTabTextStyle, R.attr.actionBarTheme, R.attr.actionBarWidgetTheme, R.attr.actionButtonStyle, R.attr.actionDropDownStyle, R.attr.actionLayout, R.attr.actionMenuTextAppearance, R.attr.actionMenuTextColor, R.attr.actionBarSize, R.attr.actionBarSplitStyle, R.attr.actionBarStyle, R.attr.actionBarTabBarStyle, R.attr.actionBarTabStyle, R.attr.actionMenuTextColor};

    public kk(Context context, List<km> list) {
        this.b = context;
        this.a = list;
    }

    public final int getGroupCount() {
        return this.a.size();
    }

    public final int getChildrenCount(int i) {
        return this.a.get(i).a().size();
    }

    public final Object getGroup(int i) {
        return this.a.get(i);
    }

    public final Object getChild(int i, int i2) {
        return this.a.get(i).a().get(i2);
    }

    public final long getGroupId(int i) {
        return (long) i;
    }

    public final long getChildId(int i, int i2) {
        return (long) i2;
    }

    public final boolean hasStableIds() {
        return false;
    }

    public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            try {
                bVar = new b();
                view = mm.a(this.b, com.amap.api.navi.R.layout.amap_navi_lbs_naviguide_item_group, null);
                bVar.a = (ImageView) view.findViewById(com.amap.api.navi.R.id.navi_sdk_iv_groupIcon);
                bVar.b = (TextView) view.findViewById(com.amap.api.navi.R.id.navi_sdk_tv_before);
                bVar.c = (TextView) view.findViewById(com.amap.api.navi.R.id.navi_sdk_tv_groupName);
                bVar.d = (TextView) view.findViewById(com.amap.api.navi.R.id.navi_sdk_tv_after);
                bVar.e = (TextView) view.findViewById(com.amap.api.navi.R.id.navi_sdk_tv_groupDetail);
                bVar.f = (ImageView) view.findViewById(com.amap.api.navi.R.id.navi_sdk_iv_action);
                bVar.g = view.findViewById(com.amap.api.navi.R.id.navi_sdk_line);
                view.setTag(bVar);
            } catch (Throwable th) {
            }
        } else {
            bVar = (b) view.getTag();
        }
        km kmVar = this.a.get(i);
        if (kmVar != null) {
            int e2 = kmVar.e();
            bVar.a.setBackgroundResource(a(e2));
            bVar.c.setText(kmVar.b());
            if (e2 != -1) {
                if (e2 != -2) {
                    bVar.b.setVisibility(8);
                    bVar.d.setVisibility(8);
                    bVar.e.setVisibility(0);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(mj.a(kmVar.c()));
                    stringBuffer.append(" ");
                    if (kmVar.d() > 0) {
                        stringBuffer.append("红绿灯");
                        stringBuffer.append(kmVar.d());
                        stringBuffer.append("个");
                    }
                    bVar.e.setText(stringBuffer.toString());
                    bVar.f.setVisibility(0);
                    if (z) {
                        bVar.f.setBackgroundResource(R.attr.textAppearancePopupMenuHeader);
                        bVar.g.setVisibility(8);
                    } else {
                        bVar.f.setBackgroundResource(R.attr.backgroundTintMode);
                        bVar.g.setVisibility(0);
                    }
                }
            }
            bVar.e.setVisibility(8);
            bVar.f.setVisibility(8);
            bVar.b.setVisibility(0);
            if (e2 == -1) {
                bVar.b.setText(this.b.getResources().getString(com.amap.api.navi.R.string.amap_navi_poi_input_type_start));
                bVar.d.setVisibility(0);
                bVar.d.setText(this.b.getResources().getString(com.amap.api.navi.R.string.amap_navi_guide_from));
            } else {
                bVar.d.setVisibility(8);
                bVar.b.setText(this.b.getResources().getString(com.amap.api.navi.R.string.amap_navi_guide_end));
            }
        }
        return view;
    }

    public final View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            try {
                aVar = new a();
                view = mm.a(this.b, com.amap.api.navi.R.layout.amap_navi_lbs_naviguide_item_child, null);
                aVar.a = (ImageView) view.findViewById(com.amap.api.navi.R.id.navi_sdk_iv_childIcon);
                aVar.b = (TextView) view.findViewById(com.amap.api.navi.R.id.navi_sdk_tv_childDetail);
                aVar.c = view.findViewById(com.amap.api.navi.R.id.navi_sdk_line);
                view.setTag(aVar);
            } catch (Throwable th) {
            }
        } else {
            aVar = (a) view.getTag();
        }
        km.a aVar2 = this.a.get(i).a().get(i2);
        if (aVar2 != null) {
            aVar.a.setBackgroundResource(a(aVar2.c()));
            Locale locale = Locale.CHINA;
            Object[] objArr = new Object[3];
            objArr[0] = mj.a(aVar2.b());
            int c2 = aVar2.c();
            String str = "";
            switch (c2) {
                case 2:
                    str = "左转";
                    break;
                case 3:
                    str = "右转";
                    break;
                case 4:
                    str = "向左前方转";
                    break;
                case 5:
                    str = "向右前方转";
                    break;
                case 6:
                    str = "向左后方行驶";
                    break;
                case 7:
                    str = "向右后方行驶";
                    break;
                case 8:
                    str = "左转调头";
                    break;
                case 9:
                    str = "直行";
                    break;
                case 10:
                    str = "到达途径点";
                    break;
                case 11:
                    str = "进入环岛";
                    break;
                case 12:
                    str = "驶出环岛";
                    break;
                default:
                    switch (c2) {
                        case 51:
                            str = "靠左";
                            break;
                        case 52:
                            str = "靠右";
                            break;
                    }
            }
            objArr[1] = str;
            objArr[2] = aVar2.a();
            aVar.b.setText(String.format(locale, "行驶%s%s进入%s", objArr));
        }
        if (z) {
            aVar.c.setVisibility(0);
        } else {
            aVar.c.setVisibility(8);
        }
        return view;
    }

    public final boolean isChildSelectable(int i, int i2) {
        return false;
    }

    private int a(int i) {
        if (i >= 0) {
            if (i == 51) {
                return R.attr.actionBarWidgetTheme;
            }
            if (i == 52) {
                return R.attr.actionButtonStyle;
            }
            if (i == 53) {
                return R.attr.actionMenuTextColor;
            }
            try {
                return this.e[i];
            } catch (Throwable th) {
                return R.attr.actionBarItemBackground;
            }
        } else if (i == this.c) {
            return R.attr.actionModeCloseButtonStyle;
        } else {
            if (i == this.d) {
                return R.attr.actionModeBackground;
            }
            return R.attr.actionBarItemBackground;
        }
    }

    /* compiled from: NaviGuideAdapter */
    static class b {
        ImageView a;
        TextView b;
        TextView c;
        TextView d;
        TextView e;
        ImageView f;
        View g;

        b() {
        }
    }

    /* compiled from: NaviGuideAdapter */
    static class a {
        ImageView a;
        TextView b;
        View c;

        a() {
        }
    }
}
