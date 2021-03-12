package com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio;

import org.json.JSONArray;

public interface Acknowledge {
    void acknowledge(JSONArray jSONArray);
}
