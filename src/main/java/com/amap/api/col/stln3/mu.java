package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.a11hud.www.R;
import com.amap.api.maps.offlinemap.OfflineMapManager;

/* compiled from: BottomDialog */
public final class mu extends mv implements View.OnClickListener {
    private OfflineMapManager a;
    private View b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private int g;
    private String h;

    public mu(Context context, OfflineMapManager offlineMapManager) {
        super(context);
        this.a = offlineMapManager;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.mv
    public final void a() {
        this.b = na.a(getContext(), R.bool.abc_allow_stacked_button_bar);
        setContentView(this.b);
        this.b.setOnClickListener(new View.OnClickListener() {
            /* class com.amap.api.col.stln3.mu.AnonymousClass1 */

            public final void onClick(View view) {
                mu.this.dismiss();
            }
        });
        this.c = (TextView) this.b.findViewById(R.id.action_bar_activity_content);
        this.d = (TextView) this.b.findViewById(R.id.action_bar_container);
        this.d.setText("暂停下载");
        this.e = (TextView) this.b.findViewById(R.id.action_bar_root);
        this.f = (TextView) this.b.findViewById(R.id.action_bar_spinner);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
    }

    public final void a(int i, String str) {
        this.c.setText(str);
        if (i == 0) {
            this.d.setText("暂停下载");
            this.d.setVisibility(0);
            this.e.setText("取消下载");
        }
        if (i == 2) {
            this.d.setVisibility(8);
            this.e.setText("取消下载");
        } else if (i == -1 || i == 101 || i == 102 || i == 103) {
            this.d.setText("继续下载");
            this.d.setVisibility(0);
        } else if (i == 3) {
            this.d.setVisibility(0);
            this.d.setText("继续下载");
            this.e.setText("取消下载");
        } else if (i == 4) {
            this.e.setText("删除");
            this.d.setVisibility(8);
        }
        this.g = i;
        this.h = str;
    }

    public final void onClick(View view) {
        try {
            int id = view.getId();
            if (id == R.id.action_bar_container) {
                if (this.g == 0) {
                    this.d.setText("继续下载");
                    this.a.pause();
                } else {
                    if (!(this.g == 3 || this.g == -1 || this.g == 101 || this.g == 102)) {
                        if (this.g == 103) {
                        }
                    }
                    this.d.setText("暂停下载");
                    this.a.downloadByCityName(this.h);
                }
                dismiss();
            } else if (id == R.id.action_bar_root) {
                if (!TextUtils.isEmpty(this.h)) {
                    this.a.remove(this.h);
                    dismiss();
                }
            } else if (id == R.id.action_bar_spinner) {
                dismiss();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
