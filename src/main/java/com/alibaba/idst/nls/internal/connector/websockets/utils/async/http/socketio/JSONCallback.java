package com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio;

import org.json.JSONObject;

public interface JSONCallback {
    void onJSON(JSONObject jSONObject, Acknowledge acknowledge);
}
