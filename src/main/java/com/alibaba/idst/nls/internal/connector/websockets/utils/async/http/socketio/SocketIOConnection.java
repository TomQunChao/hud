package com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio;

import android.os.Handler;
import android.text.TextUtils;
import com.alibaba.idst.nls.internal.connector.websockets.WebSocketClient;
import com.alibaba.idst.nls.internal.connector.websockets.utils.http.AsyncHttpClient;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class SocketIOConnection {
    int ackCount;
    Hashtable<String, Acknowledge> acknowledges = new Hashtable<>();
    ArrayList<SocketIOClient> clients = new ArrayList<>();
    int heartbeat;
    AsyncHttpClient httpClient;
    private Handler mHandler;
    long reconnectDelay = 1000;
    AsyncHttpClient.SocketIORequest request;
    WebSocketClient webSocketClient;

    /* access modifiers changed from: private */
    public interface SelectCallback {
        void onSelect(SocketIOClient socketIOClient);
    }

    public SocketIOConnection(Handler handler, AsyncHttpClient asyncHttpClient, AsyncHttpClient.SocketIORequest socketIORequest) {
        this.mHandler = handler;
        this.httpClient = asyncHttpClient;
        this.request = socketIORequest;
    }

    public boolean isConnected() {
        WebSocketClient webSocketClient2 = this.webSocketClient;
        return webSocketClient2 != null && webSocketClient2.isConnected();
    }

    public void emitRaw(int i, SocketIOClient socketIOClient, String str, Acknowledge acknowledge) {
        String str2 = "";
        if (acknowledge != null) {
            StringBuilder sb = new StringBuilder();
            int i2 = this.ackCount;
            this.ackCount = i2 + 1;
            sb.append(i2);
            String sb2 = sb.toString();
            this.acknowledges.put(sb2, acknowledge);
            str2 = sb2 + "+";
        }
        this.webSocketClient.send(String.format("%d:%s:%s:%s", Integer.valueOf(i), str2, socketIOClient.endpoint, str));
    }

    public void connect(SocketIOClient socketIOClient) {
        this.clients.add(socketIOClient);
        this.webSocketClient.send(String.format("1::%s", socketIOClient.endpoint));
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void disconnect(com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOClient r6) {
        /*
            r5 = this;
            java.util.ArrayList<com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOClient> r0 = r5.clients
            r0.remove(r6)
            java.util.ArrayList<com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOClient> r0 = r5.clients
            java.util.Iterator r0 = r0.iterator()
        L_0x000c:
            boolean r1 = r0.hasNext()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0032
            java.lang.Object r1 = r0.next()
            com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOClient r1 = (com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOClient) r1
            java.lang.String r1 = r1.endpoint
            java.lang.String r4 = r6.endpoint
            boolean r1 = android.text.TextUtils.equals(r1, r4)
            if (r1 != 0) goto L_0x002e
            java.lang.String r1 = r6.endpoint
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            goto L_0x000c
        L_0x002e:
        L_0x002f:
            r0 = 0
            goto L_0x0033
        L_0x0032:
            r0 = 1
        L_0x0033:
            if (r0 == 0) goto L_0x0047
            com.alibaba.idst.nls.internal.connector.websockets.WebSocketClient r0 = r5.webSocketClient
            java.lang.String r1 = "0::%s"
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r6 = r6.endpoint
            r3[r2] = r6
            java.lang.String r6 = java.lang.String.format(r1, r3)
            r0.send(r6)
            goto L_0x0048
        L_0x0047:
        L_0x0048:
            java.util.ArrayList<com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOClient> r6 = r5.clients
            int r6 = r6.size()
            if (r6 <= 0) goto L_0x0051
            return
        L_0x0051:
            com.alibaba.idst.nls.internal.connector.websockets.WebSocketClient r6 = r5.webSocketClient
            r6.disconnect()
            r6 = 0
            r5.webSocketClient = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOConnection.disconnect(com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOClient):void");
    }

    /* access modifiers changed from: package-private */
    public void reconnect() {
        if (!isConnected()) {
            this.httpClient.executeString(this.request, new AsyncHttpClient.StringCallback() {
                /* class com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOConnection.AnonymousClass1 */

                @Override // com.alibaba.idst.nls.internal.connector.websockets.utils.http.AsyncHttpClient.StringCallback
                public void onCompleted(Exception exc, String str) {
                    if (exc != null) {
                        SocketIOConnection.this.reportDisconnect(exc);
                        return;
                    }
                    try {
                        String[] split = str.split(":");
                        String str2 = split[0];
                        if (!"".equals(split[1])) {
                            SocketIOConnection.this.heartbeat = (Integer.parseInt(split[1]) / 2) * 1000;
                        } else {
                            SocketIOConnection.this.heartbeat = 0;
                        }
                        if (new HashSet(Arrays.asList(split[3].split(","))).contains("websocket")) {
                            SocketIOConnection.this.webSocketClient = new WebSocketClient(URI.create(SocketIOConnection.this.request.getUri().toString() + "websocket/" + str2 + "/"), new WebSocketClient.Listener() {
                                /* class com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOConnection.AnonymousClass1.AnonymousClass1 */

                                @Override // com.alibaba.idst.nls.internal.connector.websockets.WebSocketClient.Listener
                                public void onMessage(byte[] bArr) {
                                }

                                @Override // com.alibaba.idst.nls.internal.connector.websockets.WebSocketClient.Listener
                                public void onMessage(String str) {
                                    JSONArray jSONArray;
                                    try {
                                        String[] split = str.split(":", 4);
                                        switch (Integer.parseInt(split[0])) {
                                            case 0:
                                                SocketIOConnection.this.webSocketClient.disconnect();
                                                SocketIOConnection.this.reportDisconnect(null);
                                                return;
                                            case 1:
                                                SocketIOConnection.this.reportConnect(split[2]);
                                                return;
                                            case 2:
                                                SocketIOConnection.this.webSocketClient.send("2::");
                                                return;
                                            case 3:
                                                SocketIOConnection.this.reportString(split[2], split[3], SocketIOConnection.this.acknowledge(split[1]));
                                                return;
                                            case 4:
                                                SocketIOConnection.this.reportJson(split[2], new JSONObject(split[3]), SocketIOConnection.this.acknowledge(split[1]));
                                                return;
                                            case 5:
                                                JSONObject jSONObject = new JSONObject(split[3]);
                                                SocketIOConnection.this.reportEvent(split[2], jSONObject.getString("name"), jSONObject.optJSONArray("args"), SocketIOConnection.this.acknowledge(split[1]));
                                                return;
                                            case 6:
                                                String[] split2 = split[3].split("\\+", 2);
                                                Acknowledge remove = SocketIOConnection.this.acknowledges.remove(split2[0]);
                                                if (remove != null) {
                                                    if (split2.length == 2) {
                                                        jSONArray = new JSONArray(split2[1]);
                                                    } else {
                                                        jSONArray = null;
                                                    }
                                                    remove.acknowledge(jSONArray);
                                                    return;
                                                }
                                                return;
                                            case 7:
                                                SocketIOConnection.this.reportError(split[2], split[3]);
                                                return;
                                            case 8:
                                                return;
                                            default:
                                                throw new Exception("unknown code");
                                        }
                                    } catch (Exception e) {
                                        SocketIOConnection.this.webSocketClient.disconnect();
                                        SocketIOConnection.this.webSocketClient = null;
                                        SocketIOConnection.this.reportDisconnect(e);
                                    }
                                }

                                @Override // com.alibaba.idst.nls.internal.connector.websockets.WebSocketClient.Listener
                                public void onError(Exception exc) {
                                    SocketIOConnection.this.reportDisconnect(exc);
                                }

                                @Override // com.alibaba.idst.nls.internal.connector.websockets.WebSocketClient.Listener
                                public void onDisconnect(int i, String str) {
                                    SocketIOConnection.this.reportDisconnect(new IOException(String.format("Disconnected code %d for reason %s", Integer.valueOf(i), str)));
                                }

                                @Override // com.alibaba.idst.nls.internal.connector.websockets.WebSocketClient.Listener
                                public void onConnect() {
                                    SocketIOConnection.this.reconnectDelay = 1000;
                                    SocketIOConnection.this.setupHeartbeat();
                                }
                            }, null);
                            SocketIOConnection.this.webSocketClient.connect();
                            return;
                        }
                        throw new Exception("websocket not supported");
                    } catch (Exception e) {
                        SocketIOConnection.this.reportDisconnect(e);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void setupHeartbeat() {
        final WebSocketClient webSocketClient2 = this.webSocketClient;
        new Runnable() {
            /* class com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOConnection.AnonymousClass2 */

            public void run() {
                WebSocketClient webSocketClient;
                if (SocketIOConnection.this.heartbeat > 0 && webSocketClient2 == SocketIOConnection.this.webSocketClient && (webSocketClient = webSocketClient2) != null && webSocketClient.isConnected()) {
                    SocketIOConnection.this.webSocketClient.send("2:::");
                    SocketIOConnection.this.mHandler.postDelayed(this, (long) SocketIOConnection.this.heartbeat);
                }
            }
        }.run();
    }

    private void select(String str, SelectCallback selectCallback) {
        Iterator<SocketIOClient> it = this.clients.iterator();
        while (it.hasNext()) {
            SocketIOClient next = it.next();
            if (str == null || TextUtils.equals(next.endpoint, str)) {
                selectCallback.onSelect(next);
            }
        }
    }

    private void delayReconnect() {
        if (this.webSocketClient == null && this.clients.size() != 0) {
            boolean z = false;
            Iterator<SocketIOClient> it = this.clients.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().disconnected) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (z) {
                this.mHandler.postDelayed(new Runnable() {
                    /* class com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOConnection.AnonymousClass3 */

                    public void run() {
                        SocketIOConnection.this.reconnect();
                    }
                }, this.reconnectDelay);
                this.reconnectDelay *= 2;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void reportDisconnect(final Exception exc) {
        select(null, new SelectCallback() {
            /* class com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOConnection.AnonymousClass4 */

            @Override // com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOConnection.SelectCallback
            public void onSelect(final SocketIOClient socketIOClient) {
                if (socketIOClient.connected) {
                    socketIOClient.disconnected = true;
                    final DisconnectCallback disconnectCallback = socketIOClient.getDisconnectCallback();
                    if (disconnectCallback != null) {
                        SocketIOConnection.this.mHandler.post(new Runnable() {
                            /* class com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOConnection.AnonymousClass4.AnonymousClass1 */

                            public void run() {
                                disconnectCallback.onDisconnect(exc);
                            }
                        });
                        return;
                    }
                    return;
                }
                final ConnectCallback connectCallback = socketIOClient.connectCallback;
                if (connectCallback != null) {
                    SocketIOConnection.this.mHandler.post(new Runnable() {
                        /* class com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOConnection.AnonymousClass4.AnonymousClass2 */

                        public void run() {
                            connectCallback.onConnectCompleted(exc, socketIOClient);
                        }
                    });
                }
            }
        });
        delayReconnect();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void reportConnect(String str) {
        select(str, new SelectCallback() {
            /* class com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOConnection.AnonymousClass5 */

            @Override // com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOConnection.SelectCallback
            public void onSelect(SocketIOClient socketIOClient) {
                if (!socketIOClient.isConnected()) {
                    if (!socketIOClient.connected) {
                        socketIOClient.connected = true;
                        ConnectCallback connectCallback = socketIOClient.connectCallback;
                        if (connectCallback != null) {
                            connectCallback.onConnectCompleted(null, socketIOClient);
                        }
                    } else if (socketIOClient.disconnected) {
                        socketIOClient.disconnected = false;
                        ReconnectCallback reconnectCallback = socketIOClient.reconnectCallback;
                        if (reconnectCallback != null) {
                            reconnectCallback.onReconnect();
                        }
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void reportJson(String str, final JSONObject jSONObject, final Acknowledge acknowledge) {
        select(str, new SelectCallback() {
            /* class com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOConnection.AnonymousClass6 */

            @Override // com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOConnection.SelectCallback
            public void onSelect(SocketIOClient socketIOClient) {
                final JSONCallback jSONCallback = socketIOClient.jsonCallback;
                if (jSONCallback != null) {
                    SocketIOConnection.this.mHandler.post(new Runnable() {
                        /* class com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOConnection.AnonymousClass6.AnonymousClass1 */

                        public void run() {
                            jSONCallback.onJSON(jSONObject, acknowledge);
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void reportString(String str, final String str2, final Acknowledge acknowledge) {
        select(str, new SelectCallback() {
            /* class com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOConnection.AnonymousClass7 */

            @Override // com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOConnection.SelectCallback
            public void onSelect(SocketIOClient socketIOClient) {
                final StringCallback stringCallback = socketIOClient.stringCallback;
                if (stringCallback != null) {
                    SocketIOConnection.this.mHandler.post(new Runnable() {
                        /* class com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOConnection.AnonymousClass7.AnonymousClass1 */

                        public void run() {
                            stringCallback.onString(str2, acknowledge);
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void reportEvent(String str, final String str2, final JSONArray jSONArray, final Acknowledge acknowledge) {
        select(str, new SelectCallback() {
            /* class com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOConnection.AnonymousClass8 */

            @Override // com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOConnection.SelectCallback
            public void onSelect(final SocketIOClient socketIOClient) {
                SocketIOConnection.this.mHandler.post(new Runnable() {
                    /* class com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOConnection.AnonymousClass8.AnonymousClass1 */

                    public void run() {
                        socketIOClient.onEvent(str2, jSONArray, acknowledge);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void reportError(String str, final String str2) {
        select(str, new SelectCallback() {
            /* class com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOConnection.AnonymousClass9 */

            @Override // com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOConnection.SelectCallback
            public void onSelect(SocketIOClient socketIOClient) {
                final ErrorCallback errorCallback = socketIOClient.errorCallback;
                if (errorCallback != null) {
                    SocketIOConnection.this.mHandler.post(new Runnable() {
                        /* class com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOConnection.AnonymousClass9.AnonymousClass1 */

                        public void run() {
                            errorCallback.onError(str2);
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Acknowledge acknowledge(final String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new Acknowledge() {
            /* class com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.SocketIOConnection.AnonymousClass10 */

            @Override // com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.Acknowledge
            public void acknowledge(JSONArray jSONArray) {
                String str = "";
                if (jSONArray != null) {
                    str = str + "+" + jSONArray.toString();
                }
                SocketIOConnection.this.webSocketClient.send(String.format("6:::%s%s", str, str));
            }
        };
    }
}
