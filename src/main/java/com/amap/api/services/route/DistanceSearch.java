package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.stln3.nk;
import com.amap.api.col.stln3.nl;
import com.amap.api.col.stln3.ou;
import com.amap.api.col.stln3.qx;
import com.amap.api.col.stln3.sk;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IDistanceSearch;
import java.util.ArrayList;
import java.util.List;

public class DistanceSearch {
    public static final int TYPE_DISTANCE = 0;
    public static final int TYPE_DRIVING_DISTANCE = 1;
    private IDistanceSearch a;

    public interface OnDistanceSearchListener {
        void onDistanceSearched(DistanceResult distanceResult, int i);
    }

    public DistanceSearch(Context context) {
        try {
            this.a = (IDistanceSearch) sk.a(context, nk.a(true), "com.amap.api.services.dynamic.DistanceSearchWrapper", ou.class, new Class[]{Context.class}, new Object[]{context});
        } catch (qx e) {
            e.printStackTrace();
        }
        if (this.a == null) {
            try {
                this.a = new ou(context);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setDistanceSearchListener(OnDistanceSearchListener onDistanceSearchListener) {
        IDistanceSearch iDistanceSearch = this.a;
        if (iDistanceSearch != null) {
            iDistanceSearch.setDistanceSearchListener(onDistanceSearchListener);
        }
    }

    public DistanceResult calculateRouteDistance(DistanceQuery distanceQuery) throws AMapException {
        IDistanceSearch iDistanceSearch = this.a;
        if (iDistanceSearch != null) {
            return iDistanceSearch.calculateRouteDistance(distanceQuery);
        }
        return null;
    }

    public void calculateRouteDistanceAsyn(DistanceQuery distanceQuery) {
        IDistanceSearch iDistanceSearch = this.a;
        if (iDistanceSearch != null) {
            iDistanceSearch.calculateRouteDistanceAsyn(distanceQuery);
        }
    }

    public static class DistanceQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DistanceQuery> CREATOR = new Parcelable.Creator<DistanceQuery>() {
            /* class com.amap.api.services.route.DistanceSearch.DistanceQuery.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistanceQuery createFromParcel(Parcel parcel) {
                return new DistanceQuery(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ DistanceQuery[] newArray(int i) {
                return new DistanceQuery[i];
            }
        };
        private int a = 1;
        private List<LatLonPoint> b = new ArrayList();
        private LatLonPoint c;

        public DistanceQuery() {
        }

        protected DistanceQuery(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            this.c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        }

        @Override // java.lang.Object
        public DistanceQuery clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                nl.a(e, "DistanceSearch", "DistanceQueryclone");
            }
            DistanceQuery distanceQuery = new DistanceQuery();
            distanceQuery.setType(this.a);
            distanceQuery.setOrigins(this.b);
            distanceQuery.setDestination(this.c);
            return distanceQuery;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeTypedList(this.b);
            parcel.writeParcelable(this.c, i);
        }

        public int getType() {
            return this.a;
        }

        public List<LatLonPoint> getOrigins() {
            return this.b;
        }

        public LatLonPoint getDestination() {
            return this.c;
        }

        public void setType(int i) {
            this.a = i;
        }

        public void setOrigins(List<LatLonPoint> list) {
            if (list != null) {
                this.b = list;
            }
        }

        public void addOrigins(LatLonPoint... latLonPointArr) {
            for (LatLonPoint latLonPoint : latLonPointArr) {
                if (latLonPoint != null) {
                    this.b.add(latLonPoint);
                }
            }
        }

        public void setDestination(LatLonPoint latLonPoint) {
            this.c = latLonPoint;
        }
    }
}
