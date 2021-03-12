package com.alibaba.idst.nls.internal.connector;

import android.support.v4.app.NotificationCompat;
import com.alibaba.idst.nls.internal.utils.L;
import org.json.JSONObject;

public class WebsocketRecogDataParser {

    public static class Result {
        public String asr_out;
        public boolean bstream_attached;
        public String ds_out;
        public boolean finish;
        public boolean hasRet = false;
        public boolean isSucceed;
        public String out;
        public String results;
        public int status_code;
        public String version;
    }

    public static Result parse(String str) {
        L.i("返回结果为：" + str);
        Result result = new Result();
        boolean z = true;
        result.finish = true;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("results")) {
                result.hasRet = true;
            }
            result.isSucceed = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS) != 0;
            result.bstream_attached = jSONObject.optBoolean("bstream_attached");
            result.results = jSONObject.optString("results");
            result.version = jSONObject.optString("version");
            result.status_code = jSONObject.optInt("status_code");
            if (jSONObject.has("finish")) {
                if (jSONObject.optInt("finish") == 0) {
                    z = false;
                }
                result.finish = z;
            } else {
                result.finish = false;
            }
            if (jSONObject.has("results")) {
                JSONObject jSONObject2 = new JSONObject(result.results);
                result.asr_out = jSONObject2.optString("asr_out");
                result.ds_out = jSONObject2.optString("ds_out");
                result.out = jSONObject2.optString("out");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
