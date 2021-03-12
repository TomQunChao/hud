package com.amap.api.services.cloud;

import android.content.Context;
import com.amap.api.col.stln3.nk;
import com.amap.api.col.stln3.nl;
import com.amap.api.col.stln3.ob;
import com.amap.api.col.stln3.ot;
import com.amap.api.col.stln3.qx;
import com.amap.api.col.stln3.sk;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.ICloudSearch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CloudSearch {
    private ICloudSearch a;

    public interface OnCloudSearchListener {
        void onCloudItemDetailSearched(CloudItemDetail cloudItemDetail, int i);

        void onCloudSearched(CloudResult cloudResult, int i);
    }

    static /* synthetic */ boolean a(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public CloudSearch(Context context) {
        try {
            this.a = (ICloudSearch) sk.a(context, nk.a(true), "com.amap.api.services.dynamic.CloudSearchWrapper", ot.class, new Class[]{Context.class}, new Object[]{context});
        } catch (qx e) {
            e.printStackTrace();
        }
        if (this.a == null) {
            try {
                this.a = new ot(context);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setOnCloudSearchListener(OnCloudSearchListener onCloudSearchListener) {
        ICloudSearch iCloudSearch = this.a;
        if (iCloudSearch != null) {
            iCloudSearch.setOnCloudSearchListener(onCloudSearchListener);
        }
    }

    public void searchCloudAsyn(Query query) {
        ICloudSearch iCloudSearch = this.a;
        if (iCloudSearch != null) {
            iCloudSearch.searchCloudAsyn(query);
        }
    }

    public void searchCloudDetailAsyn(String str, String str2) {
        ICloudSearch iCloudSearch = this.a;
        if (iCloudSearch != null) {
            iCloudSearch.searchCloudDetailAsyn(str, str2);
        }
    }

    public static class Query implements Cloneable {
        private String a;
        private int b = 1;
        private int c = 20;
        private String d;
        private SearchBound e;
        private Sortingrules f;
        private ArrayList<ob> g = new ArrayList<>();
        private HashMap<String, String> h = new HashMap<>();

        public Query(String str, String str2, SearchBound searchBound) throws AMapException {
            if (nl.a(str) || searchBound == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            this.d = str;
            this.a = str2;
            this.e = searchBound;
        }

        private Query() {
        }

        public String getQueryString() {
            return this.a;
        }

        public void setTableID(String str) {
            this.d = str;
        }

        public String getTableID() {
            return this.d;
        }

        public int getPageNum() {
            return this.b;
        }

        public void setPageNum(int i) {
            this.b = i;
        }

        public void setPageSize(int i) {
            if (i <= 0) {
                this.c = 20;
            } else if (i > 100) {
                this.c = 100;
            } else {
                this.c = i;
            }
        }

        public int getPageSize() {
            return this.c;
        }

        public void setBound(SearchBound searchBound) {
            this.e = searchBound;
        }

        public SearchBound getBound() {
            return this.e;
        }

        public void addFilterString(String str, String str2) {
            this.h.put(str, str2);
        }

        public String getFilterString() {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                for (Map.Entry<String, String> entry : this.h.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    stringBuffer.append(key.toString());
                    stringBuffer.append(":");
                    stringBuffer.append(value.toString());
                    stringBuffer.append("+");
                }
                if (stringBuffer.length() > 0) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return stringBuffer.toString();
        }

        public void addFilterNum(String str, String str2, String str3) {
            this.g.add(new ob(str, str2, str3));
        }

        public String getFilterNumString() {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                Iterator<ob> it = this.g.iterator();
                while (it.hasNext()) {
                    ob next = it.next();
                    stringBuffer.append(next.a());
                    stringBuffer.append(":[");
                    stringBuffer.append(next.b());
                    stringBuffer.append(",");
                    stringBuffer.append(next.c());
                    stringBuffer.append("]");
                    stringBuffer.append("+");
                }
                if (stringBuffer.length() > 0) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return stringBuffer.toString();
        }

        public void setSortingrules(Sortingrules sortingrules) {
            this.f = sortingrules;
        }

        public Sortingrules getSortingrules() {
            return this.f;
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            if (CloudSearch.a(query.a, this.a) && CloudSearch.a(query.getTableID(), getTableID()) && CloudSearch.a(query.getFilterString(), getFilterString()) && CloudSearch.a(query.getFilterNumString(), getFilterNumString()) && query.c == this.c) {
                SearchBound bound = query.getBound();
                SearchBound bound2 = getBound();
                if ((bound == null && bound2 == null) ? true : (bound == null || bound2 == null) ? false : bound.equals(bound2)) {
                    Sortingrules sortingrules = query.getSortingrules();
                    Sortingrules sortingrules2 = getSortingrules();
                    if ((sortingrules == null && sortingrules2 == null) ? true : (sortingrules == null || sortingrules2 == null) ? false : sortingrules.equals(sortingrules2)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            ArrayList<ob> arrayList = this.g;
            int i6 = 0;
            if (arrayList == null) {
                i = 0;
            } else {
                i = arrayList.hashCode();
            }
            int i7 = (i + 31) * 31;
            HashMap<String, String> hashMap = this.h;
            if (hashMap == null) {
                i2 = 0;
            } else {
                i2 = hashMap.hashCode();
            }
            int i8 = (i7 + i2) * 31;
            SearchBound searchBound = this.e;
            if (searchBound == null) {
                i3 = 0;
            } else {
                i3 = searchBound.hashCode();
            }
            int i9 = (((((i8 + i3) * 31) + this.b) * 31) + this.c) * 31;
            String str = this.a;
            if (str == null) {
                i4 = 0;
            } else {
                i4 = str.hashCode();
            }
            int i10 = (i9 + i4) * 31;
            Sortingrules sortingrules = this.f;
            if (sortingrules == null) {
                i5 = 0;
            } else {
                i5 = sortingrules.hashCode();
            }
            int i11 = (i10 + i5) * 31;
            String str2 = this.d;
            if (str2 != null) {
                i6 = str2.hashCode();
            }
            return i11 + i6;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Query)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            Query query = (Query) obj;
            if (!queryEquals(query) || query.b != this.b) {
                return false;
            }
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x005c A[RETURN] */
        @Override // java.lang.Object
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.amap.api.services.cloud.CloudSearch.Query clone() {
            /*
                r6 = this;
                super.clone()     // Catch:{ CloneNotSupportedException -> 0x0004 }
                goto L_0x0008
            L_0x0004:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0008:
                r0 = 0
                com.amap.api.services.cloud.CloudSearch$Query r1 = new com.amap.api.services.cloud.CloudSearch$Query     // Catch:{ AMapException -> 0x004d }
                java.lang.String r2 = r6.d     // Catch:{ AMapException -> 0x004d }
                java.lang.String r3 = r6.a     // Catch:{ AMapException -> 0x004d }
                com.amap.api.services.cloud.CloudSearch$SearchBound r4 = r6.e     // Catch:{ AMapException -> 0x004d }
                r1.<init>(r2, r3, r4)     // Catch:{ AMapException -> 0x004d }
                int r2 = r6.b     // Catch:{ AMapException -> 0x004b }
                r1.setPageNum(r2)     // Catch:{ AMapException -> 0x004b }
                int r2 = r6.c     // Catch:{ AMapException -> 0x004b }
                r1.setPageSize(r2)     // Catch:{ AMapException -> 0x004b }
                com.amap.api.services.cloud.CloudSearch$Sortingrules r2 = r6.getSortingrules()     // Catch:{ AMapException -> 0x004b }
                r1.setSortingrules(r2)     // Catch:{ AMapException -> 0x004b }
                java.util.ArrayList<com.amap.api.col.stln3.ob> r2 = r6.g     // Catch:{ AMapException -> 0x004b }
                if (r2 != 0) goto L_0x002c
                r2 = r0
                goto L_0x0036
            L_0x002c:
                java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ AMapException -> 0x004b }
                r2.<init>()     // Catch:{ AMapException -> 0x004b }
                java.util.ArrayList<com.amap.api.col.stln3.ob> r3 = r6.g     // Catch:{ AMapException -> 0x004b }
                r2.addAll(r3)     // Catch:{ AMapException -> 0x004b }
            L_0x0036:
                r1.g = r2     // Catch:{ AMapException -> 0x004b }
                java.util.HashMap<java.lang.String, java.lang.String> r2 = r6.h     // Catch:{ AMapException -> 0x004b }
                if (r2 != 0) goto L_0x003d
            L_0x003c:
                goto L_0x0048
            L_0x003d:
                java.util.HashMap r0 = new java.util.HashMap     // Catch:{ AMapException -> 0x004b }
                r0.<init>()     // Catch:{ AMapException -> 0x004b }
                java.util.HashMap<java.lang.String, java.lang.String> r2 = r6.h     // Catch:{ AMapException -> 0x004b }
                r0.putAll(r2)     // Catch:{ AMapException -> 0x004b }
                goto L_0x003c
            L_0x0048:
                r1.h = r0     // Catch:{ AMapException -> 0x004b }
                goto L_0x0054
            L_0x004b:
                r0 = move-exception
                goto L_0x0051
            L_0x004d:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
            L_0x0051:
                r0.printStackTrace()
            L_0x0054:
                if (r1 != 0) goto L_0x005c
                com.amap.api.services.cloud.CloudSearch$Query r0 = new com.amap.api.services.cloud.CloudSearch$Query
                r0.<init>()
                return r0
            L_0x005c:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.cloud.CloudSearch.Query.clone():com.amap.api.services.cloud.CloudSearch$Query");
        }
    }

    public static class Sortingrules {
        public static final int DISTANCE = 1;
        public static final int WEIGHT = 0;
        private int a = 0;
        private String b;
        private boolean c = true;

        public Sortingrules(String str, boolean z) {
            this.b = str;
            this.c = z;
        }

        public Sortingrules(int i) {
            this.a = i;
        }

        public String toString() {
            if (nl.a(this.b)) {
                int i = this.a;
                if (i == 0) {
                    return "_weight";
                }
                if (i == 1) {
                    return "_distance";
                }
                return "";
            } else if (this.c) {
                return this.b + ":1";
            } else {
                return this.b + ":0";
            }
        }

        public int hashCode() {
            int i = ((this.c ? 1231 : 1237) + 31) * 31;
            String str = this.b;
            return ((i + (str == null ? 0 : str.hashCode())) * 31) + this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Sortingrules sortingrules = (Sortingrules) obj;
            if (this.c != sortingrules.c) {
                return false;
            }
            String str = this.b;
            if (str == null) {
                if (sortingrules.b != null) {
                    return false;
                }
            } else if (!str.equals(sortingrules.b)) {
                return false;
            }
            if (this.a != sortingrules.a) {
                return false;
            }
            return true;
        }
    }

    public static class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String LOCAL_SHAPE = "Local";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";
        private LatLonPoint a;
        private LatLonPoint b;
        private int c;
        private LatLonPoint d;
        private String e;
        private List<LatLonPoint> f;
        private String g;

        public SearchBound(LatLonPoint latLonPoint, int i) {
            this.e = "Bound";
            this.c = i;
            this.d = latLonPoint;
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.e = "Rectangle";
            this.a = latLonPoint;
            this.b = latLonPoint2;
            LatLonPoint latLonPoint3 = this.a;
            boolean z = false;
            if (latLonPoint3 != null && this.b != null && latLonPoint3.getLatitude() < this.b.getLatitude() && this.a.getLongitude() < this.b.getLongitude()) {
                z = true;
            }
            if (!z) {
                new IllegalArgumentException("invalid rect ").printStackTrace();
            }
        }

        public SearchBound(List<LatLonPoint> list) {
            this.e = "Polygon";
            this.f = list;
        }

        public SearchBound(String str) {
            this.e = LOCAL_SHAPE;
            this.g = str;
        }

        public LatLonPoint getLowerLeft() {
            return this.a;
        }

        public LatLonPoint getUpperRight() {
            return this.b;
        }

        public LatLonPoint getCenter() {
            return this.d;
        }

        public int getRange() {
            return this.c;
        }

        public String getShape() {
            return this.e;
        }

        public String getCity() {
            return this.g;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f;
        }

        public int hashCode() {
            int i;
            int i2;
            int i3;
            int i4;
            LatLonPoint latLonPoint = this.d;
            int i5 = 0;
            if (latLonPoint == null) {
                i = 0;
            } else {
                i = latLonPoint.hashCode();
            }
            int i6 = (i + 31) * 31;
            LatLonPoint latLonPoint2 = this.a;
            if (latLonPoint2 == null) {
                i2 = 0;
            } else {
                i2 = latLonPoint2.hashCode();
            }
            int i7 = (i6 + i2) * 31;
            LatLonPoint latLonPoint3 = this.b;
            if (latLonPoint3 == null) {
                i3 = 0;
            } else {
                i3 = latLonPoint3.hashCode();
            }
            int i8 = (i7 + i3) * 31;
            List<LatLonPoint> list = this.f;
            if (list == null) {
                i4 = 0;
            } else {
                i4 = list.hashCode();
            }
            int i9 = (((i8 + i4) * 31) + this.c) * 31;
            String str = this.e;
            int hashCode = (i9 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.g;
            if (str2 != null) {
                i5 = str2.hashCode();
            }
            return hashCode + i5;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof SearchBound)) {
                return false;
            }
            SearchBound searchBound = (SearchBound) obj;
            if (!getShape().equalsIgnoreCase(searchBound.getShape())) {
                return false;
            }
            if (getShape().equals("Bound")) {
                if (!searchBound.d.equals(this.d) || searchBound.c != this.c) {
                    return false;
                }
                return true;
            } else if (getShape().equals("Polygon")) {
                List<LatLonPoint> list = searchBound.f;
                List<LatLonPoint> list2 = this.f;
                if (list == null && list2 == null) {
                    return true;
                }
                if (!(list == null || list2 == null || list.size() != list2.size())) {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (list.get(i).equals(list2.get(i))) {
                        }
                    }
                    return true;
                }
                return false;
            } else if (getShape().equals(LOCAL_SHAPE)) {
                return searchBound.g.equals(this.g);
            } else {
                if (!searchBound.a.equals(this.a) || !searchBound.b.equals(this.b)) {
                    return false;
                }
                return true;
            }
        }

        private List<LatLonPoint> a() {
            if (this.f == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (LatLonPoint latLonPoint : this.f) {
                arrayList.add(new LatLonPoint(latLonPoint.getLatitude(), latLonPoint.getLongitude()));
            }
            return arrayList;
        }

        @Override // java.lang.Object
        public SearchBound clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
            }
            if (getShape().equals("Bound")) {
                return new SearchBound(this.d, this.c);
            }
            if (getShape().equals("Polygon")) {
                return new SearchBound(a());
            }
            if (getShape().equals(LOCAL_SHAPE)) {
                return new SearchBound(this.g);
            }
            return new SearchBound(this.a, this.b);
        }
    }
}
