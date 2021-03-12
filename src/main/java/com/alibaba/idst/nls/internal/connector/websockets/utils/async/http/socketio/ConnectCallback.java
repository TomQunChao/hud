package com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio;

public interface ConnectCallback {
    void onConnectCompleted(Exception exc, SocketIOClient socketIOClient);
}
