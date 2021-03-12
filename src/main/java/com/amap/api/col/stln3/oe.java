package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ReverseGeocodingHandler */
public final class oe extends nd<RegeocodeQuery, RegeocodeAddress> {
    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nc
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    public oe(Context context, RegeocodeQuery regeocodeQuery) {
        super(context, regeocodeQuery);
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return nk.a() + "/geocode/regeo?";
    }

    private static RegeocodeAddress c(String str) throws AMapException {
        RegeocodeAddress regeocodeAddress = new RegeocodeAddress();
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("regeocode");
            if (optJSONObject == null) {
                return regeocodeAddress;
            }
            regeocodeAddress.setFormatAddress(nr.a(optJSONObject, "formatted_address"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("addressComponent");
            if (optJSONObject2 != null) {
                nr.a(optJSONObject2, regeocodeAddress);
            }
            regeocodeAddress.setPois(nr.c(optJSONObject));
            JSONArray optJSONArray = optJSONObject.optJSONArray("roads");
            if (optJSONArray != null) {
                nr.b(optJSONArray, regeocodeAddress);
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("roadinters");
            if (optJSONArray2 != null) {
                nr.a(optJSONArray2, regeocodeAddress);
            }
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("aois");
            if (optJSONArray3 != null) {
                nr.c(optJSONArray3, regeocodeAddress);
            }
            return regeocodeAddress;
        } catch (JSONException e) {
            nl.a(e, "ReverseGeocodingHandler", "paseJSON");
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nd
    public final String d() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json&extensions=all&location=");
        stringBuffer.append(((RegeocodeQuery) this.d).getPoint().getLongitude());
        stringBuffer.append(",");
        stringBuffer.append(((RegeocodeQuery) this.d).getPoint().getLatitude());
        if (!TextUtils.isEmpty(((RegeocodeQuery) this.d).getPoiType())) {
            stringBuffer.append("&poitype=");
            stringBuffer.append(((RegeocodeQuery) this.d).getPoiType());
        }
        stringBuffer.append("&radius=");
        stringBuffer.append((int) ((RegeocodeQuery) this.d).getRadius());
        stringBuffer.append("&coordsys=");
        stringBuffer.append(((RegeocodeQuery) this.d).getLatLonType());
        stringBuffer.append("&key=" + qy.f(this.g));
        return stringBuffer.toString();
    }
}
