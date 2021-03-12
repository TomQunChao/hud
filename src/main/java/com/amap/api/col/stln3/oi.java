package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.autonavi.ae.guide.GuideControl;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ShareUrlSearchHandler */
public final class oi extends nc<String, String> {
    private String i;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nc
    public final /* synthetic */ String a(String str) throws AMapException {
        return b(str);
    }

    public oi(Context context, String str) {
        super(context, str);
        this.i = str;
    }

    @Override // com.amap.api.col.stln3.nc, com.amap.api.col.stln3.tw
    public final Map<String, String> getParams() {
        byte[] bArr;
        StringBuilder sb = new StringBuilder();
        sb.append("channel=open_api&flag=1");
        sb.append("&address=" + URLEncoder.encode(this.i));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("open_api1");
        stringBuffer.append(this.i);
        stringBuffer.append("@8UbJH6N2szojnTHONAWzB6K7N1kaj7Y0iUMarxac");
        String b = rg.b(stringBuffer.toString());
        sb.append("&sign=");
        sb.append(b.toUpperCase(Locale.US));
        sb.append("&output=json");
        try {
            bArr = oq.a(sb.toString().getBytes("utf-8"), "Yaynpa84IKOfasFx".substring(0, 16).getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            nl.a(e, "ShareUrlSearchHandler", "getParams");
            bArr = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ent", "2");
        hashMap.put("in", re.b(bArr));
        hashMap.put("keyt", "openapi");
        return hashMap;
    }

    private static String b(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String a = nr.a(jSONObject, "code");
            String a2 = nr.a(jSONObject, "message");
            if ("1".equals(a)) {
                return nr.a(jSONObject, "transfer_url");
            }
            if ("0".equals(a)) {
                throw new AMapException(AMapException.AMAP_SERVICE_UNKNOWN_ERROR, 0, a2);
            } else if ("2".equals(a)) {
                throw new AMapException(AMapException.AMAP_SHARE_FAILURE, 0, a2);
            } else if ("3".equals(a)) {
                throw new AMapException(AMapException.AMAP_SERVICE_INVALID_PARAMS, 0, a2);
            } else if ("4".equals(a)) {
                throw new AMapException("用户签名未通过", 0, a2);
            } else if (!GuideControl.CHANGE_PLAY_TYPE_BBHX.equals(a)) {
                return null;
            } else {
                throw new AMapException(AMapException.AMAP_SHARE_LICENSE_IS_EXPIRED, 0, a2);
            }
        } catch (JSONException e) {
            nl.a(e, "ShareUrlSearchHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        return nk.d();
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nc
    public final byte[] a(int i2, tw twVar) throws qx {
        if (i2 == 1) {
            return tv.d(twVar);
        }
        if (i2 == 2) {
            return tv.e(twVar);
        }
        return null;
    }
}
