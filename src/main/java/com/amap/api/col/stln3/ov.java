package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.interfaces.IDistrictSearch;
import java.util.HashMap;

/* compiled from: DistrictSearchCore */
public class ov implements IDistrictSearch {
    private static HashMap<Integer, DistrictResult> f;
    private Context a;
    private DistrictSearchQuery b;
    private DistrictSearch.OnDistrictSearchListener c;
    private DistrictSearchQuery d;
    private int e;
    private Handler g = nu.a();

    public ov(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public DistrictSearchQuery getQuery() {
        return this.b;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.b = districtSearchQuery;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public DistrictResult searchDistrict() throws AMapException {
        DistrictResult districtResult;
        try {
            DistrictResult districtResult2 = new DistrictResult();
            ns.a(this.a);
            boolean z = true;
            if (!(this.b != null)) {
                this.b = new DistrictSearchQuery();
            }
            districtResult2.setQuery(this.b.clone());
            if (!this.b.weakEquals(this.d)) {
                this.e = 0;
                this.d = this.b.clone();
                if (f != null) {
                    f.clear();
                }
            }
            if (this.e == 0) {
                districtResult = (DistrictResult) new nn(this.a, this.b.clone()).a();
                if (districtResult == null) {
                    return districtResult;
                }
                this.e = districtResult.getPageCount();
                f = new HashMap<>();
                if (this.b != null) {
                    if (districtResult != null) {
                        if (this.e > 0 && this.e > this.b.getPageNum()) {
                            f.put(Integer.valueOf(this.b.getPageNum()), districtResult);
                        }
                    }
                }
            } else {
                int pageNum = this.b.getPageNum();
                if (pageNum >= this.e || pageNum < 0) {
                    z = false;
                }
                if (z) {
                    districtResult = f.get(Integer.valueOf(pageNum));
                    if (districtResult == null) {
                        districtResult = (DistrictResult) new nn(this.a, this.b.clone()).a();
                        if (this.b != null) {
                            if (districtResult != null) {
                                if (this.e > 0) {
                                    if (this.e > this.b.getPageNum()) {
                                        f.put(Integer.valueOf(this.b.getPageNum()), districtResult);
                                    }
                                }
                            }
                        }
                        return districtResult;
                    }
                } else {
                    throw new AMapException("无效的参数 - IllegalArgumentException");
                }
            }
            return districtResult;
        } catch (AMapException e2) {
            nl.a(e2, "DistrictSearch", "searchDistrict");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public void searchDistrictAsyn() {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.ov.AnonymousClass1 */

                public final void run() {
                    Message obtainMessage = nu.a().obtainMessage();
                    DistrictResult districtResult = new DistrictResult();
                    districtResult.setQuery(ov.this.b);
                    try {
                        DistrictResult searchDistrict = ov.this.searchDistrict();
                        if (searchDistrict != null) {
                            searchDistrict.setAMapException(new AMapException());
                        }
                        obtainMessage.arg1 = 4;
                        obtainMessage.obj = ov.this.c;
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("result", searchDistrict);
                        obtainMessage.setData(bundle);
                        if (ov.this.g != null) {
                            ov.this.g.sendMessage(obtainMessage);
                        }
                    } catch (AMapException e) {
                        districtResult.setAMapException(e);
                        obtainMessage.arg1 = 4;
                        obtainMessage.obj = ov.this.c;
                        Bundle bundle2 = new Bundle();
                        bundle2.putParcelable("result", districtResult);
                        obtainMessage.setData(bundle2);
                        if (ov.this.g != null) {
                            ov.this.g.sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        obtainMessage.arg1 = 4;
                        obtainMessage.obj = ov.this.c;
                        Bundle bundle3 = new Bundle();
                        bundle3.putParcelable("result", districtResult);
                        obtainMessage.setData(bundle3);
                        if (ov.this.g != null) {
                            ov.this.g.sendMessage(obtainMessage);
                        }
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public void searchDistrictAnsy() {
        searchDistrictAsyn();
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public void setOnDistrictSearchListener(DistrictSearch.OnDistrictSearchListener onDistrictSearchListener) {
        this.c = onDistrictSearchListener;
    }
}
