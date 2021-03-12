package com.alibaba.idst.nls.internal.connector.websockets;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.idst.nls.internal.connector.websockets.HybiParser;
import com.alibaba.idst.nls.internal.utils.L;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import org.apache.http.Header;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.BasicNameValuePair;

public class WebSocketClient {
    private static TrustManager[] sTrustManagers;
    private String TAG = "WebSocketClient";
    private boolean isRequestOver;
    private final Object mConFlagLock = new Object();
    private boolean mConnected;
    private List<BasicNameValuePair> mExtraHeaders;
    private final Handler mHandler;
    private HandlerThread mHandlerThread;
    private Listener mListener;
    private HybiParser mParser;
    private final Object mSendLock = new Object();
    private Socket mSocket;
    private Thread mThread;
    private URI mURI;

    public interface Listener {
        void onConnect();

        void onDisconnect(int i, String str);

        void onError(Exception exc);

        void onMessage(String str);

        void onMessage(byte[] bArr);
    }

    public static void setTrustManagers(TrustManager[] trustManagerArr) {
        sTrustManagers = trustManagerArr;
    }

    public WebSocketClient(URI uri, Listener listener, List<BasicNameValuePair> list) {
        this.mURI = uri;
        this.mListener = listener;
        this.mExtraHeaders = list;
        synchronized (this.mConFlagLock) {
            this.mConnected = false;
        }
        this.mParser = new HybiParser(this);
        this.mHandlerThread = new HandlerThread("websocket-thread");
        this.mHandlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        this.isRequestOver = false;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null && handlerThread.getLooper() != null) {
            this.mHandlerThread.getLooper().quit();
            super.finalize();
        }
    }

    public Listener getListener() {
        return this.mListener;
    }

    public void connect() {
        this.mThread = new Thread(new Runnable() {
            /* class com.alibaba.idst.nls.internal.connector.websockets.WebSocketClient.AnonymousClass1 */

            /* JADX WARNING: Removed duplicated region for block: B:41:0x01c8 A[Catch:{ EOFException -> 0x02b3, SSLException -> 0x02a8, StreamCorruptedException -> 0x029d, HttpResponseException -> 0x0298, HttpException -> 0x0293, SocketException -> 0x0286, Exception -> 0x0281, Throwable -> 0x027c }] */
            /* JADX WARNING: Removed duplicated region for block: B:48:0x021f A[Catch:{ EOFException -> 0x02b3, SSLException -> 0x02a8, StreamCorruptedException -> 0x029d, HttpResponseException -> 0x0298, HttpException -> 0x0293, SocketException -> 0x0286, Exception -> 0x0281, Throwable -> 0x027c }] */
            /* JADX WARNING: Removed duplicated region for block: B:65:0x0274  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                // Method dump skipped, instructions count: 746
                */
                throw new UnsupportedOperationException("Method not decompiled: com.alibaba.idst.nls.internal.connector.websockets.WebSocketClient.AnonymousClass1.run():void");
            }
        });
        this.mThread.start();
    }

    /* access modifiers changed from: private */
    public static SocketFactory getTrustAllHostsSocketFactory() {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, null, new SecureRandom());
            return instance.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void disconnect() {
        Handler handler;
        if (this.mSocket != null && (handler = this.mHandler) != null) {
            handler.post(new Runnable() {
                /* class com.alibaba.idst.nls.internal.connector.websockets.WebSocketClient.AnonymousClass2 */

                public void run() {
                    if (WebSocketClient.this.mSocket != null) {
                        try {
                            if (!WebSocketClient.this.mSocket.isClosed()) {
                                WebSocketClient.this.mSocket.close();
                                L.i("Socket closed!");
                                synchronized (WebSocketClient.this.mConFlagLock) {
                                    WebSocketClient.this.mConnected = false;
                                }
                            }
                        } catch (IOException e) {
                            WebSocketClient.this.mListener.onError(e);
                        }
                    }
                }
            });
        }
    }

    public void send(String str) {
        sendFrame(this.mParser.frame(str));
    }

    public void send(byte[] bArr) {
        sendFrame(this.mParser.frame(bArr));
    }

    public boolean isConnected() {
        return this.mConnected;
    }

    public Socket createSocket(SocketFactory socketFactory, String str, int i, int i2) throws IOException, UnknownHostException, ConnectTimeoutException {
        Socket createSocket = socketFactory.createSocket();
        createSocket.connect(new InetSocketAddress(str, i), i2);
        return createSocket;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private StatusLine parseStatusLine(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return BasicLineParser.parseStatusLine(str, new BasicLineParser());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Header parseHeader(String str) {
        return BasicLineParser.parseHeader(str, new BasicLineParser());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String readLine(HybiParser.HappyDataInputStream happyDataInputStream) throws IOException {
        int read = happyDataInputStream.read();
        if (read == -1) {
            return null;
        }
        StringBuilder sb = new StringBuilder("");
        while (read != 10) {
            if (read != 13) {
                sb.append((char) read);
            }
            read = happyDataInputStream.read();
            if (read == -1) {
                return null;
            }
        }
        return sb.toString();
    }

    private String readLine2(HybiParser.HappyDataInputStream happyDataInputStream) throws IOException {
        if (happyDataInputStream.read() == -1) {
            return null;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(happyDataInputStream, Charset.forName("utf-8"));
        CharBuffer allocate = CharBuffer.allocate(100);
        StringBuilder sb = new StringBuilder();
        while (inputStreamReader.read(allocate) > 0) {
            allocate.flip();
            sb.append(allocate.toString());
            allocate.clear();
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String createSecret() {
        byte[] bArr = new byte[16];
        for (int i = 0; i < 16; i++) {
            bArr[i] = (byte) ((int) (Math.random() * 256.0d));
        }
        return Base64.encodeToString(bArr, 0).trim();
    }

    /* access modifiers changed from: package-private */
    public void sendFrame(final byte[] bArr) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() {
                /* class com.alibaba.idst.nls.internal.connector.websockets.WebSocketClient.AnonymousClass3 */

                public void run() {
                    try {
                        synchronized (WebSocketClient.this.mSendLock) {
                            OutputStream outputStream = WebSocketClient.this.mSocket.getOutputStream();
                            outputStream.write(bArr);
                            outputStream.flush();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        WebSocketClient.this.mListener.onError(e);
                    }
                }
            });
        }
    }

    public void setIsRequestOver(boolean z) {
        this.isRequestOver = z;
    }

    public boolean IsRequestOver() {
        return this.isRequestOver;
    }

    private SSLSocketFactory getSSLSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init(null, sTrustManagers, null);
        return instance.getSocketFactory();
    }

    public void destroy() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandlerThread.getLooper().quit();
        }
    }
}
