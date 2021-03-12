package com.amap.api.col.stln3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.amap.api.navi.R;
import java.util.List;

/* compiled from: OfflineListAdapter */
public final class ms extends BaseExpandableListAdapter implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {
    private boolean[] a;
    private int b = -1;
    private List<OfflineMapProvince> c = null;
    private OfflineMapManager d;
    private Context e;

    public ms(List<OfflineMapProvince> list, OfflineMapManager offlineMapManager, Context context) {
        this.c = list;
        this.d = offlineMapManager;
        this.e = context;
        this.a = new boolean[list.size()];
    }

    public final int getGroupCount() {
        int i = this.b;
        if (i == -1) {
            return this.c.size();
        }
        return i;
    }

    public final Object getGroup(int i) {
        return this.c.get(i).getProvinceName();
    }

    public final long getGroupId(int i) {
        return (long) i;
    }

    public final int getChildrenCount(int i) {
        boolean z = true;
        if (i == 0 || i == getGroupCount() - 1) {
            z = false;
        }
        if (z) {
            return this.c.get(i).getCityList().size();
        }
        return this.c.get(i).getCityList().size();
    }

    public final Object getChild(int i, int i2) {
        return null;
    }

    public final long getChildId(int i, int i2) {
        return (long) i2;
    }

    public final boolean hasStableIds() {
        return true;
    }

    public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = (RelativeLayout) na.a(this.e, R.layout.amap_navi_api_hudlayout_land);
        }
        ImageView imageView = (ImageView) view.findViewById(com.a11hud.www.R.id.action_menu_presenter);
        ((TextView) view.findViewById(com.a11hud.www.R.id.action_menu_divider)).setText(this.c.get(i).getProvinceName());
        if (this.a[i]) {
            imageView.setImageDrawable(na.a().getDrawable(com.a11hud.www.R.attr.actionBarStyle));
        } else {
            imageView.setImageDrawable(na.a().getDrawable(com.a11hud.www.R.attr.actionBarTabBarStyle));
        }
        return view;
    }

    public final View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        a aVar;
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            aVar = new a();
            mw mwVar = new mw(this.e, this.d);
            mwVar.a(1);
            View a2 = mwVar.a();
            aVar.a = mwVar;
            a2.setTag(aVar);
            view = a2;
        }
        aVar.a.a(this.c.get(i).getCityList().get(i2));
        return view;
    }

    public final boolean isChildSelectable(int i, int i2) {
        return true;
    }

    public final void a() {
        this.b = -1;
        notifyDataSetChanged();
    }

    public final void b() {
        this.b = 0;
        notifyDataSetChanged();
    }

    /* compiled from: OfflineListAdapter */
    public final class a {
        public mw a;

        public a() {
        }
    }

    public final void onGroupCollapse(int i) {
        this.a[i] = false;
    }

    public final void onGroupExpand(int i) {
        this.a[i] = true;
    }
}
