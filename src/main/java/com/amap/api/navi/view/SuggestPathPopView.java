package com.amap.api.navi.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.col.stln3.mk;
import com.amap.api.col.stln3.mm;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.R;
import com.amap.api.navi.view.ForbiddenTipView;
import com.amap.api.track.ErrorCode;

public class SuggestPathPopView extends RelativeLayout implements View.OnClickListener {
    Button cancel;
    Button change;
    TextView detailView;
    Context mContext = null;
    long newPathid = 0;
    a timeCount;
    ForbiddenTipView.TipVisibleListener tipListener;
    TextView titleView;

    public SuggestPathPopView(Context context) {
        super(context);
        init(context);
    }

    public SuggestPathPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public SuggestPathPopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        if (context instanceof mk) {
            this.mContext = ((mk) context).getBaseContext();
        } else {
            this.mContext = context;
        }
        View a2 = mm.a(this.mContext, R.layout.amap_navi_lbs_route_foot_view_suggestpath, this);
        this.titleView = (TextView) a2.findViewById(R.id.navi_sdk_lbs_tv_suggestpath_title);
        this.detailView = (TextView) a2.findViewById(R.id.navi_sdk_lbs_tv_suggestpath_detail);
        this.cancel = (Button) a2.findViewById(R.id.navi_sdk_lbs_tv_suggestpath_cancle);
        this.change = (Button) a2.findViewById(R.id.navi_sdk_lbs_tv_suggestpath_ok);
        this.cancel.setOnClickListener(this);
        this.change.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() != 2147479759) {
            if (view.getId() != 2147479760) {
                return;
            }
            if (this.newPathid != 0) {
                AMapNavi.getInstance(this.mContext).selectMainPathID(this.newPathid);
            }
        }
        finish();
    }

    public void updatePathInfo(String str, String str2, long j) {
        this.titleView.setText(str);
        this.detailView.setText(str2);
        this.newPathid = j;
        startTimer(ErrorCode.Response.SUCCESS);
    }

    public void startTimer(int i) {
        a aVar = this.timeCount;
        if (aVar != null) {
            aVar.cancel();
            this.timeCount = null;
        }
        if (this.timeCount == null) {
            this.timeCount = new a((long) i);
        }
        this.timeCount.start();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void finish() {
        ForbiddenTipView.TipVisibleListener tipVisibleListener = this.tipListener;
        if (tipVisibleListener != null) {
            tipVisibleListener.onTipHide();
        }
    }

    public void setTipListener(ForbiddenTipView.TipVisibleListener tipVisibleListener) {
        this.tipListener = tipVisibleListener;
    }

    /* access modifiers changed from: package-private */
    public class a extends CountDownTimer {
        public a(long j) {
            super(j, 1000);
        }

        public final void onTick(long j) {
        }

        public final void onFinish() {
            SuggestPathPopView.this.finish();
        }
    }
}
