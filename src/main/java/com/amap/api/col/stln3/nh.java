package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.services.cloud.CloudImage;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CloudHandler */
public abstract class nh<T, V> extends nd<T, V> {
    public nh(Context context, T t) {
        super(context, t);
    }

    protected static CloudItemDetail a(JSONObject jSONObject) throws JSONException {
        CloudItemDetail cloudItemDetail = new CloudItemDetail(nr.a(jSONObject, "_id"), nr.b(jSONObject, "_location"), nr.a(jSONObject, "_name"), nr.a(jSONObject, "_address"));
        cloudItemDetail.setCreatetime(nr.a(jSONObject, "_createtime"));
        cloudItemDetail.setUpdatetime(nr.a(jSONObject, "_updatetime"));
        if (jSONObject.has("_distance")) {
            String optString = jSONObject.optString("_distance");
            if (!(optString == null || optString.equals("") || optString.equals("[]"))) {
                cloudItemDetail.setDistance(Integer.parseInt(optString));
            }
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("_image");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            cloudItemDetail.setmCloudImage(arrayList);
            return cloudItemDetail;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            arrayList.add(new CloudImage(nr.a(jSONObject2, "_id"), nr.a(jSONObject2, "_preurl"), nr.a(jSONObject2, "_url")));
        }
        cloudItemDetail.setmCloudImage(arrayList);
        return cloudItemDetail;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.HashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.stln3.nc, com.amap.api.col.stln3.tw, com.amap.api.col.stln3.nd
    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Search 6.5.0");
        hashMap.put("X-INFO", rb.b(this.g));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "6.5.0", "cloud"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    protected static void a(CloudItem cloudItem, JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        HashMap<String, String> hashMap = new HashMap<>();
        if (keys != null) {
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && !next.toString().startsWith("_")) {
                    hashMap.put(next.toString(), jSONObject.optString(next.toString()));
                }
            }
            cloudItem.setCustomfield(hashMap);
        }
    }
}
