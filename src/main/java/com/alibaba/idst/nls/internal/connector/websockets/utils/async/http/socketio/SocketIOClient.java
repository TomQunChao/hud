package com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio;

import android.os.Handler;
import android.text.TextUtils;
import com.alibaba.idst.nls.internal.connector.websockets.WebSocketClient;
import com.alibaba.idst.nls.internal.connector.websockets.utils.http.AsyncHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class SocketIOClient extends EventEmitter {
    ConnectCallback connectCallback;
    boolean connected;
    SocketIOConnection connection;
    DisconnectCallback disconnectCallback;
    boolean disconnected;
    String endpoint;
    ErrorCallback errorCallback;
    Handler handler;
    JSONCallback jsonCallback;
    ReconnectCallback reconnectCallback;
    StringCallback stringCallback;

    private void emitRaw(int i, String str, Acknowledge acknowledge) {
        this.connection.emitRaw(i, this, str, acknowledge);
    }

    public void emit(String str, JSONArray jSONArray) {
        emit(str, jSONArray, null);
    }

    public void emit(String str) {
        emit(str, (Acknowledge) null);
    }

    public void emit(JSONObject jSONObject) {
        emit(jSONObject, (Acknowledge) null);
    }

    public void emit(String str, JSONArray jSONArray, Acknowledge acknowledge) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("args", jSONArray);
            emitRaw(5, jSONObject.toString(), acknowledge);
        } catch (Exception e) {
        }
    }

    public void emit(String str, Acknowledge acknowledge) {
        emitRaw(3, str, acknowledge);
    }

    public void emit(JSONObject jSONObject, Acknowledge acknowledge) {
        emitRaw(4, jSONObject.toString(), acknowledge);
    }

    public static void connect(String str, ConnectCallback connectCallback2, Handler handler2) {
        connect(new AsyncHttpClient.SocketIORequest(str), connectCallback2, handler2);
    }

    public static void connect(final AsyncHttpClient.SocketIORequest socketIORequest, final ConnectCallback connectCallback2, final Handler handler2) {
        final SocketIOConnection socketIOConnection = new SocketIOConnection(handler2, new AsyncHttpClient(), socketIORequest);
        socketIOConnection.clients.add(new SocketIOClient(socketIOConnection, "", new ConnectCallback() {
            /* class com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOClient.AnonymousClass1 */

            @Override // com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.ConnectCallback
            public final void onConnectCompleted(Exception exc, SocketIOClient socketIOClient) {
                if (exc != null || TextUtils.isEmpty(socketIORequest.getEndpoint())) {
                    socketIOClient.handler = handler2;
                    ConnectCallback connectCallback = connectCallback2;
                    if (connectCallback != null) {
                        connectCallback.onConnectCompleted(exc, socketIOClient);
                        return;
                    }
                    return;
                }
                socketIOConnection.clients.remove(socketIOClient);
                socketIOClient.of(socketIORequest.getEndpoint(), new ConnectCallback() {
                    /* class com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOClient.AnonymousClass1.AnonymousClass1 */

                    @Override // com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.ConnectCallback
                    public void onConnectCompleted(Exception exc, SocketIOClient socketIOClient) {
                        if (connectCallback2 != null) {
                            connectCallback2.onConnectCompleted(exc, socketIOClient);
                        }
                    }
                });
            }
        }));
        socketIOConnection.reconnect();
    }

    public void setErrorCallback(ErrorCallback errorCallback2) {
        this.errorCallback = errorCallback2;
    }

    public ErrorCallback getErrorCallback() {
        return this.errorCallback;
    }

    public void setDisconnectCallback(DisconnectCallback disconnectCallback2) {
        this.disconnectCallback = disconnectCallback2;
    }

    public DisconnectCallback getDisconnectCallback() {
        return this.disconnectCallback;
    }

    public void setReconnectCallback(ReconnectCallback reconnectCallback2) {
        this.reconnectCallback = reconnectCallback2;
    }

    public ReconnectCallback getReconnectCallback() {
        return this.reconnectCallback;
    }

    public void setJSONCallback(JSONCallback jSONCallback) {
        this.jsonCallback = jSONCallback;
    }

    public JSONCallback getJSONCallback() {
        return this.jsonCallback;
    }

    public void setStringCallback(StringCallback stringCallback2) {
        this.stringCallback = stringCallback2;
    }

    public StringCallback getStringCallback() {
        return this.stringCallback;
    }

    private SocketIOClient(SocketIOConnection socketIOConnection, String str, ConnectCallback connectCallback2) {
        this.endpoint = str;
        this.connection = socketIOConnection;
        this.connectCallback = connectCallback2;
    }

    public boolean isConnected() {
        return this.connected && !this.disconnected && this.connection.isConnected();
    }

    public void disconnect() {
        this.connection.disconnect(this);
        final DisconnectCallback disconnectCallback2 = this.disconnectCallback;
        if (disconnectCallback2 != null) {
            this.handler.post(new Runnable() {
                /* class com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOClient.AnonymousClass2 */

                public void run() {
                    disconnectCallback2.onDisconnect(null);
                }
            });
        }
    }

    public void of(String str, ConnectCallback connectCallback2) {
        SocketIOConnection socketIOConnection = this.connection;
        socketIOConnection.connect(new SocketIOClient(socketIOConnection, str, connectCallback2));
    }

    public WebSocketClient getWebSocket() {
        return this.connection.webSocketClient;
    }
}
