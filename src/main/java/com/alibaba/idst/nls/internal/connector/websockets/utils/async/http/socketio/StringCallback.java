package com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio;

public interface StringCallback {
    void onString(String str, Acknowledge acknowledge);
}
