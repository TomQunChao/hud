package com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio;

import org.json.JSONArray;

public interface EventCallback {
    void onEvent(String str, JSONArray jSONArray, Acknowledge acknowledge);
}
