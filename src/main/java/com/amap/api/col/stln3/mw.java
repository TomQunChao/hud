package com.amap.api.col.stln3;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.internal.view.SupportMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.a11hud.www.R;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.DownloadProgressView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;

/* compiled from: OfflineChild */
public final class mw implements View.OnClickListener {
    private int a = 0;
    private Context b;
    private TextView c;
    private TextView d;
    private ImageView e;
    private TextView f;
    private OfflineMapManager g;
    private OfflineMapCity h;
    private boolean i = false;
    private Handler j = new Handler() {
        /* class com.amap.api.col.stln3.mw.AnonymousClass1 */

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                mw.a(mw.this, message.arg1, message.arg2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private View k;
    private DownloadProgressView l;

    static /* synthetic */ void a(mw mwVar, int i2, int i3) throws Exception {
        if (mwVar.a != 2 || i3 <= 3 || i3 >= 100) {
            mwVar.l.setVisibility(8);
        } else {
            mwVar.l.setVisibility(0);
            mwVar.l.setProgress(i3);
        }
        switch (i2) {
            case -1:
                mwVar.c();
                return;
            case 0:
                if (mwVar.a == 1) {
                    mwVar.e.setVisibility(8);
                    mwVar.f.setText("下载中");
                    mwVar.f.setTextColor(Color.parseColor("#4287ff"));
                    return;
                } else if (mwVar.h != null) {
                    mwVar.f.setVisibility(0);
                    mwVar.f.setText("下载中");
                    mwVar.e.setVisibility(8);
                    mwVar.f.setTextColor(Color.parseColor("#4287ff"));
                    return;
                } else {
                    return;
                }
            case 1:
                if (mwVar.a != 1) {
                    mwVar.f.setVisibility(0);
                    mwVar.e.setVisibility(8);
                    mwVar.f.setText("解压中");
                    mwVar.f.setTextColor(Color.parseColor("#898989"));
                    return;
                }
                return;
            case 2:
                mwVar.b();
                return;
            case 3:
                mwVar.d();
                return;
            case 4:
                mwVar.f.setVisibility(0);
                mwVar.e.setVisibility(8);
                mwVar.f.setText("已下载");
                mwVar.f.setTextColor(Color.parseColor("#898989"));
                return;
            case 5:
                return;
            case 6:
                mwVar.f.setVisibility(8);
                mwVar.e.setVisibility(0);
                mwVar.e.setImageResource(R.attr.actionBarPopupTheme);
                return;
            case 7:
                mwVar.f.setVisibility(0);
                mwVar.e.setVisibility(0);
                mwVar.e.setImageResource(R.attr.actionBarPopupTheme);
                mwVar.f.setText("已下载-有更新");
                return;
            default:
                switch (i2) {
                    case 101:
                    case 102:
                    case 103:
                        mwVar.c();
                        return;
                    default:
                        return;
                }
        }
    }

    public mw(Context context, OfflineMapManager offlineMapManager) {
        this.b = context;
        this.k = na.a(this.b, R.bool.abc_config_actionMenuItemAllCaps);
        this.l = (DownloadProgressView) this.k.findViewById(R.id.action_image);
        this.c = (TextView) this.k.findViewById(R.id.action_bar_subtitle);
        this.d = (TextView) this.k.findViewById(R.id.action_divider);
        this.e = (ImageView) this.k.findViewById(R.id.action_context_bar);
        this.f = (TextView) this.k.findViewById(R.id.action_container);
        this.e.setOnClickListener(this);
        this.g = offlineMapManager;
    }

    public final void a(int i2) {
        this.a = i2;
    }

    public final View a() {
        return this.k;
    }

    public final void a(OfflineMapCity offlineMapCity) {
        if (offlineMapCity != null) {
            this.h = offlineMapCity;
            this.c.setText(offlineMapCity.getCity());
            TextView textView = this.d;
            textView.setText(String.valueOf(((double) ((int) (((((double) offlineMapCity.getSize()) / 1024.0d) / 1024.0d) * 100.0d))) / 100.0d) + " M");
            int state = this.h.getState();
            int i2 = this.h.getcompleteCode();
            boolean z = this.i;
            OfflineMapCity offlineMapCity2 = this.h;
            if (offlineMapCity2 != null) {
                offlineMapCity2.setState(state);
                this.h.setCompleteCode(i2);
            }
            Message message = new Message();
            message.arg1 = state;
            message.arg2 = i2;
            this.j.sendMessage(message);
        }
    }

    private void b() {
        if (this.a == 1) {
            this.e.setVisibility(8);
            this.f.setVisibility(0);
            this.f.setText("等待中");
            this.f.setTextColor(Color.parseColor("#4287ff"));
            return;
        }
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        this.f.setTextColor(Color.parseColor("#4287ff"));
        this.f.setText("等待中");
    }

    private void c() {
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        this.f.setTextColor(SupportMenu.CATEGORY_MASK);
        this.f.setText("下载出现异常");
    }

    private void d() {
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        this.f.setTextColor(-7829368);
        this.f.setText("暂停");
    }

    private synchronized void e() {
        this.g.pause();
        this.g.restart();
    }

    private synchronized boolean f() {
        try {
            this.g.downloadByCityName(this.h.getCity());
        } catch (AMapException e2) {
            e2.printStackTrace();
            Toast.makeText(this.b, e2.getErrorMessage(), 0).show();
            return false;
        }
        return true;
    }

    public final void onClick(View view) {
        try {
            if (!ic.d(this.b)) {
                Toast.makeText(this.b, "无网络连接", 0).show();
            } else if (this.h != null) {
                int state = this.h.getState();
                this.h.getcompleteCode();
                if (state != 4) {
                    switch (state) {
                        case 0:
                            e();
                            d();
                            return;
                        case 1:
                            return;
                        default:
                            if (f()) {
                                b();
                                return;
                            } else {
                                c();
                                return;
                            }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
