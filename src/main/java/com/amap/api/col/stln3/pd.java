package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.ITrafficSearch;
import com.amap.api.services.traffic.CircleTrafficQuery;
import com.amap.api.services.traffic.RoadTrafficQuery;
import com.amap.api.services.traffic.TrafficSearch;
import com.amap.api.services.traffic.TrafficStatusResult;

/* compiled from: TrafficSearchCore */
public class pd implements ITrafficSearch {
    private static final String a = pd.class.getSimpleName();
    private TrafficSearch.OnTrafficSearchListener b;
    private Context c;
    private Handler d = nu.a();

    public pd(Context context) {
        this.c = context.getApplicationContext();
    }

    @Override // com.amap.api.services.interfaces.ITrafficSearch
    public void setTrafficSearchListener(TrafficSearch.OnTrafficSearchListener onTrafficSearchListener) {
        this.b = onTrafficSearchListener;
    }

    @Override // com.amap.api.services.interfaces.ITrafficSearch
    public TrafficStatusResult loadTrafficByRoad(RoadTrafficQuery roadTrafficQuery) throws AMapException {
        try {
            ns.a(this.c);
            if (roadTrafficQuery != null) {
                return (TrafficStatusResult) new og(this.c, roadTrafficQuery.clone()).a();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            nl.a(e, a, "loadTrafficByRoad");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.ITrafficSearch
    public void loadTrafficByRoadAsyn(final RoadTrafficQuery roadTrafficQuery) {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.pd.AnonymousClass1 */

                public final void run() {
                    Message obtainMessage = nu.a().obtainMessage();
                    obtainMessage.what = 300;
                    obtainMessage.arg1 = 15;
                    Bundle bundle = new Bundle();
                    TrafficStatusResult trafficStatusResult = null;
                    try {
                        trafficStatusResult = pd.this.loadTrafficByRoad(roadTrafficQuery);
                        bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                    } catch (AMapException e) {
                        bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                    } catch (Throwable th) {
                        obtainMessage.obj = pd.this.b;
                        bundle.putParcelable("result", trafficStatusResult);
                        obtainMessage.setData(bundle);
                        pd.this.d.sendMessage(obtainMessage);
                        throw th;
                    }
                    obtainMessage.obj = pd.this.b;
                    bundle.putParcelable("result", trafficStatusResult);
                    obtainMessage.setData(bundle);
                    pd.this.d.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            nl.a(th, a, "loadTrafficByRoadAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.ITrafficSearch
    public TrafficStatusResult loadTrafficByCircle(CircleTrafficQuery circleTrafficQuery) throws AMapException {
        try {
            ns.a(this.c);
            if (circleTrafficQuery != null) {
                return (TrafficStatusResult) new ng(this.c, circleTrafficQuery.clone()).a();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            nl.a(e, a, "loadTrafficByCircle");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.ITrafficSearch
    public void loadTrafficByCircleAsyn(final CircleTrafficQuery circleTrafficQuery) {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.pd.AnonymousClass2 */

                public final void run() {
                    Message obtainMessage = nu.a().obtainMessage();
                    obtainMessage.what = 301;
                    obtainMessage.arg1 = 15;
                    Bundle bundle = new Bundle();
                    TrafficStatusResult trafficStatusResult = null;
                    try {
                        trafficStatusResult = pd.this.loadTrafficByCircle(circleTrafficQuery);
                        bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                    } catch (AMapException e) {
                        bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                    } catch (Throwable th) {
                        obtainMessage.obj = pd.this.b;
                        bundle.putParcelable("result", trafficStatusResult);
                        obtainMessage.setData(bundle);
                        pd.this.d.sendMessage(obtainMessage);
                        throw th;
                    }
                    obtainMessage.obj = pd.this.b;
                    bundle.putParcelable("result", trafficStatusResult);
                    obtainMessage.setData(bundle);
                    pd.this.d.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            nl.a(th, a, "loadTrafficByCircleAsyn");
        }
    }
}
