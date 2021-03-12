package com.a11hud.www.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.a11hud.www.R;
import com.amap.api.services.help.Tip;
import java.util.List;

public class SearchResultAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater = ((LayoutInflater) this.mContext.getSystemService("layout_inflater"));
    private Context mContext;
    private List<Tip> mListTips;

    public SearchResultAdapter(Context context, List<Tip> tipList) {
        this.mContext = context;
        this.mListTips = tipList;
    }

    public int getCount() {
        List<Tip> list = this.mListTips;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public Object getItem(int i) {
        List<Tip> list = this.mListTips;
        if (list != null) {
            return list.get(i);
        }
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if (view == null) {
            try {
                holder = new Holder();
                view = this.layoutInflater.inflate(R.layout.search_result_item, (ViewGroup) null);
                holder.mName = (TextView) view.findViewById(R.id.name);
                holder.mAddress = (TextView) view.findViewById(R.id.adress);
                view.setTag(holder);
            } catch (Throwable th) {
            }
        } else {
            holder = (Holder) view.getTag();
        }
        if (this.mListTips == null) {
            return view;
        }
        holder.mName.setText(this.mListTips.get(i).getName());
        String address = this.mListTips.get(i).getAddress();
        if (TextUtils.isEmpty(address)) {
            holder.mAddress.setVisibility(8);
        } else {
            holder.mAddress.setVisibility(0);
            holder.mAddress.setText(address);
        }
        return view;
    }

    class Holder {
        TextView mAddress;
        TextView mName;

        Holder() {
        }
    }
}
