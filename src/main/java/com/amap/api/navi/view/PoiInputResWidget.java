package com.amap.api.navi.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.a11hud.www.R;
import com.amap.api.col.stln3.mm;
import com.amap.api.maps.model.Poi;
import java.util.ArrayList;
import java.util.List;

public class PoiInputResWidget extends LinearLayout {
    public PoiInputResWidget(Context context) {
        super(context);
        init();
    }

    public PoiInputResWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PoiInputResWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setBackgroundDrawable(mm.a().getDrawable(R.attr.progressBarPadding));
        setOrientation(1);
    }

    public void setPoi(Poi poi, Poi poi2, List<Poi> list) {
        removeAllViews();
        addView(createItemWidget(0, poi));
        addView(createItemWidget(2, extractPoiStr(list)));
        addView(createItemWidget(1, poi2));
    }

    private String extractPoiStr(List<Poi> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Poi poi = list.get(i);
            if (poi != null) {
                arrayList.add(poi);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (arrayList.size() > 1) {
            stringBuffer.append(arrayList.size() + "地: ");
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Poi poi2 = (Poi) arrayList.get(i2);
                if (poi2 != null && !TextUtils.isEmpty(poi2.getName())) {
                    stringBuffer.append(poi2.getName());
                    if (i2 < arrayList.size() - 1) {
                        stringBuffer.append("、");
                    }
                }
            }
        } else if (arrayList.size() > 0) {
            stringBuffer.append(((Poi) arrayList.get(0)).getName());
        }
        return stringBuffer.toString();
    }

    public PoiInputResItemWidget createItemWidget(int i, Poi poi) {
        String str = "";
        if (poi != null) {
            str = poi.getName();
        }
        return createItemWidget(i, str);
    }

    public PoiInputResItemWidget createItemWidget(int i, String str) {
        PoiInputResItemWidget poiInputResItemWidget = new PoiInputResItemWidget(getContext());
        poiInputResItemWidget.setPoi(i, str);
        return poiInputResItemWidget;
    }
}
