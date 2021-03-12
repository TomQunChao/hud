package com.amap.api.navi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ExpandableListView;
import com.amap.api.col.stln3.kk;
import com.amap.api.col.stln3.km;
import java.util.List;

public class NaviGuideWidget extends ExpandableListView {
    public NaviGuideWidget(Context context) {
        super(context);
    }

    public NaviGuideWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NaviGuideWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void setParams() {
        setDivider(null);
        setGroupIndicator(null);
    }

    public void setGuideData(String str, String str2, List<km> list) {
        setParams();
        if (list != null && list.size() > 0) {
            list.size();
            km kmVar = new km();
            kmVar.c(-1);
            kmVar.a(str);
            list.add(0, kmVar);
            km kmVar2 = new km();
            kmVar2.c(-2);
            kmVar2.a(str2);
            list.add(list.size(), kmVar2);
            setAdapter(new kk(getContext(), list));
        }
    }
}
