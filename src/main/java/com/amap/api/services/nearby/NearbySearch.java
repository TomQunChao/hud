package com.amap.api.services.nearby;

import android.content.Context;
import com.amap.api.col.stln3.nk;
import com.amap.api.col.stln3.nl;
import com.amap.api.col.stln3.oy;
import com.amap.api.col.stln3.qx;
import com.amap.api.col.stln3.sk;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;
import com.amap.api.track.ErrorCode;

public class NearbySearch {
    public static final int AMAP = 1;
    public static final int GPS = 0;
    private static NearbySearch a;
    private INearbySearch b;

    public interface NearbyListener {
        void onNearbyInfoSearched(NearbySearchResult nearbySearchResult, int i);

        void onNearbyInfoUploaded(int i);

        void onUserInfoCleared(int i);
    }

    public static synchronized NearbySearch getInstance(Context context) {
        NearbySearch nearbySearch;
        synchronized (NearbySearch.class) {
            if (a == null) {
                a = new NearbySearch(context);
            }
            nearbySearch = a;
        }
        return nearbySearch;
    }

    private NearbySearch(Context context) {
        try {
            this.b = (INearbySearch) sk.a(context, nk.a(true), "com.amap.api.services.dynamic.NearbySearchWrapper", oy.class, new Class[]{Context.class}, new Object[]{context});
        } catch (qx e) {
            e.printStackTrace();
        }
        if (this.b == null) {
            try {
                this.b = new oy(context);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public synchronized void addNearbyListener(NearbyListener nearbyListener) {
        if (this.b != null) {
            this.b.addNearbyListener(nearbyListener);
        }
    }

    public synchronized void removeNearbyListener(NearbyListener nearbyListener) {
        if (this.b != null) {
            this.b.removeNearbyListener(nearbyListener);
        }
    }

    public void clearUserInfoAsyn() {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.clearUserInfoAsyn();
        }
    }

    public void setUserID(String str) {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.setUserID(str);
        }
    }

    public synchronized void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i) {
        if (this.b != null) {
            this.b.startUploadNearbyInfoAuto(uploadInfoCallback, i);
        }
    }

    public synchronized void stopUploadNearbyInfoAuto() {
        if (this.b != null) {
            this.b.stopUploadNearbyInfoAuto();
        }
    }

    public void uploadNearbyInfoAsyn(UploadInfo uploadInfo) {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.uploadNearbyInfoAsyn(uploadInfo);
        }
    }

    public void searchNearbyInfoAsyn(NearbyQuery nearbyQuery) {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            iNearbySearch.searchNearbyInfoAsyn(nearbyQuery);
        }
    }

    public NearbySearchResult searchNearbyInfo(NearbyQuery nearbyQuery) throws AMapException {
        INearbySearch iNearbySearch = this.b;
        if (iNearbySearch != null) {
            return iNearbySearch.searchNearbyInfo(nearbyQuery);
        }
        return null;
    }

    public static class NearbyQuery {
        private LatLonPoint a;
        private NearbySearchFunctionType b = NearbySearchFunctionType.DISTANCE_SEARCH;
        private int c = 1000;
        private int d = AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING;
        private int e = 1;

        public void setCenterPoint(LatLonPoint latLonPoint) {
            this.a = latLonPoint;
        }

        public LatLonPoint getCenterPoint() {
            return this.a;
        }

        public int getRadius() {
            return this.c;
        }

        public void setRadius(int i) {
            if (i > 10000) {
                i = ErrorCode.Response.SUCCESS;
            }
            this.c = i;
        }

        public void setType(NearbySearchFunctionType nearbySearchFunctionType) {
            this.b = nearbySearchFunctionType;
        }

        public int getType() {
            switch (this.b) {
                case DISTANCE_SEARCH:
                default:
                    return 0;
                case DRIVING_DISTANCE_SEARCH:
                    return 1;
            }
        }

        public void setCoordType(int i) {
            if (i == 0 || i == 1) {
                this.e = i;
            } else {
                this.e = 1;
            }
        }

        public int getCoordType() {
            return this.e;
        }

        public void setTimeRange(int i) {
            if (i < 5) {
                i = 5;
            } else if (i > 86400) {
                i = 86400;
            }
            this.d = i;
        }

        public int getTimeRange() {
            return this.d;
        }
    }

    public static synchronized void destroy() {
        synchronized (NearbySearch.class) {
            if (a != null) {
                try {
                    NearbySearch nearbySearch = a;
                    if (nearbySearch.b != null) {
                        nearbySearch.b.destroy();
                    }
                    nearbySearch.b = null;
                } catch (Throwable th) {
                    nl.a(th, "NearbySearch", "destryoy");
                }
            }
            a = null;
        }
    }
}
