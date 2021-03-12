package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GeocodingHandler */
public final class np extends nd<GeocodeQuery, ArrayList<GeocodeAddress>> {
    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nc
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    public np(Context context, GeocodeQuery geocodeQuery) {
        super(context, geocodeQuery);
    }

    private static ArrayList<GeocodeAddress> c(String str) throws AMapException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("count") && jSONObject.getInt("count") > 0) {
                return nr.g(jSONObject);
            }
            return arrayList;
        } catch (JSONException e) {
            nl.a(e, "GeocodingHandler", "paseJSONJSONException");
            return arrayList;
        } catch (Exception e2) {
            nl.a(e2, "GeocodingHandler", "paseJSONException");
            return arrayList;
        }
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return nk.a() + "/geocode/geo?";
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nd
    public final String d() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json&address=");
        stringBuffer.append(b(((GeocodeQuery) this.d).getLocationName()));
        String city = ((GeocodeQuery) this.d).getCity();
        if (!nr.f(city)) {
            String b = b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(b);
        }
        stringBuffer.append("&key=" + qy.f(this.g));
        return stringBuffer.toString();
    }
}
