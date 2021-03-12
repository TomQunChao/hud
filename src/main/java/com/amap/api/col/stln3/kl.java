package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.amap.api.navi.R;
import java.util.List;

/* compiled from: SearchResultAdapter */
public final class kl extends BaseAdapter {
    private Context a;
    private List<lw> b;

    public kl(Context context) {
        this.a = context;
    }

    public final void a(List<lw> list) {
        this.b = list;
    }

    public final int getCount() {
        List<lw> list = this.b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final Object getItem(int i) {
        List<lw> list = this.b;
        if (list != null) {
            return list.get(i);
        }
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            try {
                aVar = new a();
                view = mm.a(this.a, R.layout.amap_navi_lbs_search_result_item, null);
                aVar.a = (TextView) view.findViewById(R.id.navi_sdk_name);
                aVar.b = (TextView) view.findViewById(R.id.navi_sdk_adress);
                view.setTag(aVar);
            } catch (Throwable th) {
            }
        } else {
            aVar = (a) view.getTag();
        }
        if (this.b == null) {
            return view;
        }
        aVar.a.setText(this.b.get(i).c());
        String d = this.b.get(i).d();
        if (TextUtils.isEmpty(d)) {
            aVar.b.setVisibility(8);
        } else {
            aVar.b.setVisibility(0);
            aVar.b.setText(d);
        }
        return view;
    }

    /* compiled from: SearchResultAdapter */
    static class a {
        TextView a;
        TextView b;

        a() {
        }
    }
}
