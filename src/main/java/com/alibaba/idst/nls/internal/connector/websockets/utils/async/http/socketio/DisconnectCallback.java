package com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio;

public interface DisconnectCallback {
    void onDisconnect(Exception exc);
}
