package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InputtipsHandler */
public final class nq extends nd<InputtipsQuery, ArrayList<Tip>> {
    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nc
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    public nq(Context context, InputtipsQuery inputtipsQuery) {
        super(context, inputtipsQuery);
    }

    private static ArrayList<Tip> c(String str) throws AMapException {
        try {
            return nr.h(new JSONObject(str));
        } catch (JSONException e) {
            nl.a(e, "InputtipsHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return nk.a() + "/assistant/inputtips?";
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nd
    public final String d() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String b = b(((InputtipsQuery) this.d).getKeyword());
        if (!TextUtils.isEmpty(b)) {
            stringBuffer.append("&keywords=");
            stringBuffer.append(b);
        }
        String city = ((InputtipsQuery) this.d).getCity();
        if (!nr.f(city)) {
            String b2 = b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(b2);
        }
        String type = ((InputtipsQuery) this.d).getType();
        if (!nr.f(type)) {
            String b3 = b(type);
            stringBuffer.append("&type=");
            stringBuffer.append(b3);
        }
        if (((InputtipsQuery) this.d).getCityLimit()) {
            stringBuffer.append("&citylimit=true");
        } else {
            stringBuffer.append("&citylimit=false");
        }
        LatLonPoint location = ((InputtipsQuery) this.d).getLocation();
        if (location != null) {
            stringBuffer.append("&location=");
            stringBuffer.append(location.getLongitude());
            stringBuffer.append(",");
            stringBuffer.append(location.getLatitude());
        }
        stringBuffer.append("&key=");
        stringBuffer.append(qy.f(this.g));
        return stringBuffer.toString();
    }
}
