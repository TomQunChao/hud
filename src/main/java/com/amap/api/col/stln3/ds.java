package com.amap.api.col.stln3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amap.api.maps.AMap;
import com.amap.api.maps.InfoWindowParams;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.Marker;

/* compiled from: InfoWindowDelegate */
public final class ds {
    AMap.InfoWindowAdapter a = null;
    AMap.CommonInfoWindowAdapter b = null;
    Context c;
    private boolean d = true;
    private View e;
    private TextView f;
    private TextView g;
    private Drawable h = null;
    private dr i;
    private dr j;
    private AMap.InfoWindowAdapter k = new AMap.InfoWindowAdapter() {
        /* class com.amap.api.col.stln3.ds.AnonymousClass1 */

        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public final View getInfoWindow(Marker marker) {
            try {
                if (ds.this.h == null) {
                    ds.this.h = hs.a(ds.this.c, "infowindow_bg.9.png");
                }
                if (ds.this.e == null) {
                    ds.this.e = new LinearLayout(ds.this.c);
                    ds.this.e.setBackground(ds.this.h);
                    ds.this.f = new TextView(ds.this.c);
                    ds.this.f.setText(marker.getTitle());
                    ds.this.f.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    ds.this.g = new TextView(ds.this.c);
                    ds.this.g.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    ds.this.g.setText(marker.getSnippet());
                    ((LinearLayout) ds.this.e).setOrientation(1);
                    ((LinearLayout) ds.this.e).addView(ds.this.f);
                    ((LinearLayout) ds.this.e).addView(ds.this.g);
                }
            } catch (Throwable th) {
                rx.c(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
            }
            return ds.this.e;
        }

        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public final View getInfoContents(Marker marker) {
            return null;
        }
    };
    private AMap.CommonInfoWindowAdapter l = new AMap.CommonInfoWindowAdapter() {
        /* class com.amap.api.col.stln3.ds.AnonymousClass2 */

        @Override // com.amap.api.maps.AMap.CommonInfoWindowAdapter
        public final InfoWindowParams getInfoWindowParams(BasePointOverlay basePointOverlay) {
            try {
                InfoWindowParams infoWindowParams = new InfoWindowParams();
                if (ds.this.h == null) {
                    ds.this.h = hs.a(ds.this.c, "infowindow_bg.9.png");
                }
                ds.this.e = new LinearLayout(ds.this.c);
                ds.this.e.setBackground(ds.this.h);
                ds.this.f = new TextView(ds.this.c);
                ds.this.f.setText("标题");
                ds.this.f.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                ds.this.g = new TextView(ds.this.c);
                ds.this.g.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                ds.this.g.setText("内容");
                ((LinearLayout) ds.this.e).setOrientation(1);
                ((LinearLayout) ds.this.e).addView(ds.this.f);
                ((LinearLayout) ds.this.e).addView(ds.this.g);
                infoWindowParams.setInfoWindowType(2);
                infoWindowParams.setInfoWindow(ds.this.e);
                return infoWindowParams;
            } catch (Throwable th) {
                rx.c(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
                return null;
            }
        }
    };

    public ds(Context context) {
        this.c = context;
    }

    public final void a(dr drVar) {
        synchronized (this) {
            this.i = drVar;
            if (this.i != null) {
                this.i.a(this);
            }
        }
    }

    public final void b(dr drVar) {
        synchronized (this) {
            this.j = drVar;
            if (this.j != null) {
                this.j.a(this);
            }
        }
    }

    public final synchronized boolean a() {
        return this.d;
    }

    public final void a(String str, String str2) {
        TextView textView = this.f;
        if (textView != null) {
            textView.requestLayout();
            this.f.setText(str);
        }
        TextView textView2 = this.g;
        if (textView2 != null) {
            textView2.requestLayout();
            this.g.setText(str2);
        }
        View view = this.e;
        if (view != null) {
            view.requestLayout();
        }
    }

    public final synchronized void a(AMap.InfoWindowAdapter infoWindowAdapter) {
        this.a = infoWindowAdapter;
        this.b = null;
        if (this.a == null) {
            this.a = this.k;
            this.d = true;
        } else {
            this.d = false;
        }
        if (this.j != null) {
            this.j.b_();
        }
        if (this.i != null) {
            this.i.b_();
        }
    }

    public final synchronized void a(AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) {
        this.b = commonInfoWindowAdapter;
        this.a = null;
        if (this.b == null) {
            this.b = this.l;
            this.d = true;
        } else {
            this.d = false;
        }
        if (this.j != null) {
            this.j.b_();
        }
        if (this.i != null) {
            this.i.b_();
        }
    }

    public final void b() {
        this.c = null;
        this.e = null;
        this.f = null;
        this.g = null;
        synchronized (this) {
            ic.a(this.h);
            this.h = null;
            this.k = null;
            this.a = null;
        }
        this.b = null;
        this.i = null;
        this.j = null;
    }

    public final View a(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.a;
        if (infoWindowAdapter != null) {
            return infoWindowAdapter.getInfoWindow((Marker) basePointOverlay);
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.b;
        if (commonInfoWindowAdapter != null && (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) != null) {
            return infoWindowParams.getInfoWindow();
        }
        InfoWindowParams infoWindowParams2 = this.l.getInfoWindowParams(basePointOverlay);
        if (infoWindowParams2 != null) {
            return infoWindowParams2.getInfoWindow();
        }
        return null;
    }

    public final View b(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.a;
        if (infoWindowAdapter != null) {
            return infoWindowAdapter.getInfoContents((Marker) basePointOverlay);
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.b;
        if (commonInfoWindowAdapter != null && (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) != null) {
            return infoWindowParams.getInfoContents();
        }
        InfoWindowParams infoWindowParams2 = this.l.getInfoWindowParams(basePointOverlay);
        if (infoWindowParams2 != null) {
            return infoWindowParams2.getInfoContents();
        }
        return null;
    }

    public final View a(Marker marker) {
        AMap.InfoWindowAdapter infoWindowAdapter = this.a;
        if (infoWindowAdapter == null || !(infoWindowAdapter instanceof AMap.MultiPositionInfoWindowAdapter)) {
            return null;
        }
        return ((AMap.MultiPositionInfoWindowAdapter) infoWindowAdapter).getInfoWindowClick(marker);
    }

    public final View b(Marker marker) {
        AMap.InfoWindowAdapter infoWindowAdapter = this.a;
        if (infoWindowAdapter == null || !(infoWindowAdapter instanceof AMap.MultiPositionInfoWindowAdapter)) {
            return null;
        }
        return ((AMap.MultiPositionInfoWindowAdapter) infoWindowAdapter).getOverturnInfoWindow(marker);
    }

    public final View c(Marker marker) {
        AMap.InfoWindowAdapter infoWindowAdapter = this.a;
        if (infoWindowAdapter == null || !(infoWindowAdapter instanceof AMap.MultiPositionInfoWindowAdapter)) {
            return null;
        }
        return ((AMap.MultiPositionInfoWindowAdapter) infoWindowAdapter).getOverturnInfoWindowClick(marker);
    }

    public final long c(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.a;
        if (infoWindowAdapter != null && (infoWindowAdapter instanceof AMap.ImageInfoWindowAdapter)) {
            return ((AMap.ImageInfoWindowAdapter) infoWindowAdapter).getInfoWindowUpdateTime();
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.b;
        if (commonInfoWindowAdapter == null || (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) == null) {
            return 0;
        }
        return infoWindowParams.getInfoWindowUpdateTime();
    }

    public final synchronized dr c() {
        if (this.a != null) {
            if (this.a instanceof AMap.ImageInfoWindowAdapter) {
                return this.j;
            } else if (this.a instanceof AMap.MultiPositionInfoWindowAdapter) {
                return this.j;
            }
        }
        if (this.b == null || this.b.getInfoWindowParams(null).getInfoWindowType() != 1) {
            return this.i;
        }
        return this.j;
    }

    public final Drawable d() {
        if (this.h == null) {
            try {
                this.h = hs.a(this.c, "infowindow_bg.9.png");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.h;
    }
}
