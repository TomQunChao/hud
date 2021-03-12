package com.alibaba.idst.nls.internal.connector.websockets.utils.http;

import android.net.Uri;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import com.alibaba.idst.nls.internal.connector.websockets.WebSocketClient;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.client.methods.HttpPost;

public class AsyncHttpClient {

    public interface StringCallback {
        void onCompleted(Exception exc, String str);
    }

    public interface WebSocketConnectCallback {
        void onCompleted(Exception exc, WebSocketClient webSocketClient);
    }

    public static class SocketIORequest {
        private String mEndpoint;
        private String mUri;

        public SocketIORequest(String str) {
            this(str, null);
        }

        public SocketIORequest(String str, String str2) {
            this.mUri = Uri.parse(str).buildUpon().encodedPath("/socket.io/1/").build().toString();
            this.mEndpoint = str2;
        }

        public String getUri() {
            return this.mUri;
        }

        public String getEndpoint() {
            return this.mEndpoint;
        }
    }

    public void executeString(final SocketIORequest socketIORequest, final StringCallback stringCallback) {
        new AsyncTask<Void, Void, Void>() {
            /* class com.alibaba.idst.nls.internal.connector.websockets.utils.http.AsyncHttpClient.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                AndroidHttpClient newInstance = AndroidHttpClient.newInstance("android-websockets-2.0");
                try {
                    String readToEnd = AsyncHttpClient.this.readToEnd(newInstance.execute(new HttpPost(socketIORequest.getUri())).getEntity().getContent());
                    if (stringCallback != null) {
                        stringCallback.onCompleted(null, readToEnd);
                    }
                } catch (IOException e) {
                    if (stringCallback != null) {
                        stringCallback.onCompleted(e, null);
                    }
                } catch (Throwable th) {
                    newInstance.close();
                    throw th;
                }
                newInstance.close();
                return null;
            }
        }.execute(new Void[0]);
    }

    private byte[] readToEndAsArray(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = dataInputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String readToEnd(InputStream inputStream) throws IOException {
        return new String(readToEndAsArray(inputStream));
    }
}
