package com.amap.api.navi.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.col.stln3.mm;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.R;

public class PoiInputResItemWidget extends RelativeLayout {
    private TextView mPoiTV;
    private ImageView mTypeNoinputIV;
    private TextView mTypeTV;

    public PoiInputResItemWidget(Context context) {
        super(context);
        init();
    }

    public PoiInputResItemWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PoiInputResItemWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        mm.a(getContext(), R.layout.amap_navi_lbs_widget_poi_input_res_item, this);
        this.mTypeTV = (TextView) findViewById(R.id.navi_sdk_type_tv);
        this.mPoiTV = (TextView) findViewById(R.id.navi_sdk_poi_name_tv);
        this.mTypeNoinputIV = (ImageView) findViewById(R.id.navi_sdk_type_noinput_iv);
    }

    public void setPoi(int i, Poi poi) {
        setPoi(i, poi == null ? "" : poi.getName());
    }

    public void setPoi(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            this.mTypeNoinputIV.setVisibility(0);
            this.mTypeTV.setVisibility(8);
            if (i == 0) {
                this.mPoiTV.setText("输入起点");
            } else if (i == 1) {
                this.mPoiTV.setText("输入终点");
            }
        } else {
            this.mTypeNoinputIV.setVisibility(8);
            this.mTypeTV.setVisibility(0);
            this.mTypeTV.setText(getTypeStr(i));
            if (!TextUtils.isEmpty(str)) {
                this.mPoiTV.setText(str);
            }
        }
    }

    private String getTypeStr(int i) {
        switch (i) {
            case 0:
                return mm.a().getString(R.string.amap_navi_poi_input_type_start);
            case 1:
                return mm.a().getString(R.string.amap_navi_poi_input_type_dest);
            case 2:
                return mm.a().getString(R.string.amap_navi_poi_input_type_mid);
            default:
                return "";
        }
    }
}
