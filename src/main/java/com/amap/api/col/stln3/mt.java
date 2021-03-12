package com.amap.api.col.stln3;

import android.app.Activity;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapActivity;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SearchListAdapter */
public final class mt extends BaseAdapter {
    private List<OfflineMapCity> a = new ArrayList();
    private OfflineMapManager b;
    private Activity c;

    public mt(OfflineMapManager offlineMapManager, OfflineMapActivity offlineMapActivity) {
        this.b = offlineMapManager;
        this.c = offlineMapActivity;
    }

    public final void a(List<OfflineMapCity> list) {
        this.a = list;
    }

    public final int getCount() {
        return this.a.size();
    }

    public final Object getItem(int i) {
        return this.a.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00d5 A[Catch:{ Exception -> 0x00ed }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r7, android.view.View r8, android.view.ViewGroup r9) {
        /*
        // Method dump skipped, instructions count: 268
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.mt.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    /* compiled from: SearchListAdapter */
    public final class a {
        public TextView a;
        public TextView b;
        public TextView c;
        public ImageView d;

        public a() {
        }
    }
}
