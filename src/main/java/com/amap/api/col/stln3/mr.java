package com.amap.api.col.stln3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.amap.api.navi.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: OfflineDownloadedAdapter */
public final class mr extends BaseExpandableListAdapter implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {
    List<OfflineMapProvince> a = new ArrayList();
    private boolean[] b;
    private Context c;
    private mw d;
    private List<OfflineMapProvince> e = new ArrayList();
    private my f;
    private OfflineMapManager g;

    public mr(Context context, my myVar, OfflineMapManager offlineMapManager, List<OfflineMapProvince> list) {
        this.c = context;
        this.f = myVar;
        this.g = offlineMapManager;
        if (list != null && list.size() > 0) {
            this.e.clear();
            this.e.addAll(list);
            for (OfflineMapProvince offlineMapProvince : this.e) {
                if (offlineMapProvince != null && offlineMapProvince.getDownloadedCityList().size() > 0) {
                    this.a.add(offlineMapProvince);
                }
            }
        }
        this.b = new boolean[this.a.size()];
    }

    public final void a() {
        for (OfflineMapProvince offlineMapProvince : this.e) {
            if (offlineMapProvince.getDownloadedCityList().size() > 0 && !this.a.contains(offlineMapProvince)) {
                this.a.add(offlineMapProvince);
            }
        }
        this.b = new boolean[this.a.size()];
        notifyDataSetChanged();
    }

    public final void b() {
        try {
            for (int size = this.a.size(); size > 0; size--) {
                OfflineMapProvince offlineMapProvince = this.a.get(size - 1);
                if (offlineMapProvince.getDownloadedCityList().size() == 0) {
                    this.a.remove(offlineMapProvince);
                }
            }
            this.b = new boolean[this.a.size()];
            notifyDataSetChanged();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final int getGroupCount() {
        return this.a.size();
    }

    public final int getChildrenCount(int i) {
        return this.a.get(i).getDownloadedCityList().size();
    }

    public final Object getGroup(int i) {
        return this.a.get(i).getProvinceName();
    }

    public final Object getChild(int i, int i2) {
        return this.a.get(i).getDownloadedCityList().get(i2);
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
        if (view == null) {
            view = (RelativeLayout) na.a(this.c, R.layout.amap_navi_api_hudlayout_land);
        }
        ImageView imageView = (ImageView) view.findViewById(com.a11hud.www.R.id.action_menu_presenter);
        ((TextView) view.findViewById(com.a11hud.www.R.id.action_menu_divider)).setText(this.a.get(i).getProvinceName());
        if (this.b[i]) {
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
            this.d = new mw(this.c, this.g);
            this.d.a(2);
            view = this.d.a();
            aVar.a = this.d;
            view.setTag(aVar);
        }
        OfflineMapProvince offlineMapProvince = this.a.get(i);
        if (i2 < offlineMapProvince.getDownloadedCityList().size()) {
            final OfflineMapCity offlineMapCity = offlineMapProvince.getDownloadedCityList().get(i2);
            aVar.a.a(offlineMapCity);
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.amap.api.col.stln3.mr.AnonymousClass1 */

                public final void onClick(View view) {
                    mr.this.f.a(offlineMapCity);
                }
            });
        }
        return view;
    }

    public final boolean isChildSelectable(int i, int i2) {
        return true;
    }

    /* compiled from: OfflineDownloadedAdapter */
    public final class a {
        public mw a;

        public a() {
        }
    }

    public final void onGroupCollapse(int i) {
        this.b[i] = false;
    }

    public final void onGroupExpand(int i) {
        this.b[i] = true;
    }
}
