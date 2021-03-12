package com.alibaba.idst.nls.internal.connector;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.alibaba.idst.nls.NlsListener;
import com.alibaba.idst.nls.internal.common.DeviceId;
import com.alibaba.idst.nls.internal.common.EngineResultFlag;
import com.alibaba.idst.nls.internal.common.PhoneInfo;
import com.alibaba.idst.nls.internal.connector.WebsocketRecogDataParser;
import com.alibaba.idst.nls.internal.connector.websockets.WebSocketClient;
import com.alibaba.idst.nls.internal.protocol.NlsRequest;
import com.alibaba.idst.nls.internal.utils.JoyPrint;
import com.alibaba.idst.nls.internal.utils.L;
import com.alibaba.idst.nls.internal.utils.NetCheck;
import com.amap.api.services.core.AMapException;
import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.client.HttpResponseException;

public class WebsocketPostFrameData extends AbstractPostFrameData {
    private static final String TAG = "WebSocket";
    private static String URL_TLS = "";
    private static boolean sUseTlsInMobile = false;
    private String Samplerate;
    private String URL = "wss://nls.dataapi.aliyun.com/websocket";
    private String UserContent;
    private Boolean isText = false;
    private String mAppId = "";
    private Context mContext;
    private DeviceId mDeviceId;
    private volatile boolean mHasResult = false;
    private volatile boolean mIsAvailable = false;
    private volatile boolean mIsNegotiating = false;
    private int mMinPostSize = AMapException.CODE_AMAP_SERVICE_TABLEID_NOT_EXIST;
    private PhoneInfo mPhoneInfo = PhoneInfo.getInstance();
    private ByteArrayOutputStream mPostStream;
    private Runnable mSendDataRun = new Runnable() {
        /* class com.alibaba.idst.nls.internal.connector.WebsocketPostFrameData.AnonymousClass2 */

        public void run() {
            int size;
            int size2;
            WebsocketPostFrameData.this.mHasResult = false;
            int i = 0;
            boolean z = false;
            while (WebsocketPostFrameData.this.isConnect()) {
                if (i < WebsocketPostFrameData.this.mMinPostSize) {
                    threadSleep(300);
                }
                synchronized (WebsocketPostFrameData.this.mPostStream) {
                    size = WebsocketPostFrameData.this.mPostStream.size();
                    if (size > WebsocketPostFrameData.this.mMinPostSize) {
                        WebsocketPostFrameData.this.postData(WebsocketPostFrameData.this.mPostStream);
                        WebsocketPostFrameData.this.mPostStream.reset();
                        z = true;
                    }
                }
                if (WebsocketPostFrameData.this.mShouldSendTerminator.compareAndSet(true, false)) {
                    synchronized (WebsocketPostFrameData.this.mPostStream) {
                        size2 = WebsocketPostFrameData.this.mPostStream.size();
                        WebsocketPostFrameData.this.postData(WebsocketPostFrameData.this.mPostStream);
                        WebsocketPostFrameData.this.mPostStream.reset();
                    }
                    if (!WebsocketPostFrameData.this.useCloudVad) {
                        WebsocketPostFrameData.this.postTerminator();
                        L.i("post Terminator");
                    }
                    i = size2;
                    z = true;
                } else {
                    i = size;
                }
            }
            if (!WebsocketPostFrameData.this.mHasResult && !z) {
                WebsocketPostFrameData.this.onNetResult(null, -1, "");
            }
        }

        private void threadSleep(int i) {
            try {
                Thread.sleep((long) i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    private AtomicBoolean mShouldSendTerminator = new AtomicBoolean(false);
    private String mUrl;
    private WebSocketClient mWebSocketClient;
    private NlsRequest nlsRequest = this.mNlsRequest;
    private String requestId = "";
    private boolean useCloudVad = false;
    private boolean useSslMode = true;

    public WebsocketPostFrameData(Context context, NlsRequest nlsRequest2) {
        super(context, nlsRequest2);
        this.mContext = context;
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public void setMinPostSize(Integer num) {
        this.mMinPostSize = num.intValue();
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public void setReadTimeout(Integer num) {
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public void setProtocol(String str, String str2, String str3, String str4, String str5) {
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public String getPhoneInfoString() {
        return "cs=" + this.mPhoneInfo.getIMEI() + "&ct=Android&cov=" + this.mPhoneInfo.osVersion + "&cv=" + this.mPhoneInfo.appVersion + "&un=" + this.mPhoneInfo.getUserInfo();
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public void setHost(boolean z, String str) {
        if (z) {
            this.URL = "wss://" + str;
            return;
        }
        this.URL = "ws://" + str;
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public void setHost(String str) {
        this.URL = "wss://" + str;
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public void setPort(int i) {
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public void setPath(String str) {
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public void updateHostList(String str) {
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public void setMtype(String str) {
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public void setCustomParam(String str) {
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public void setAppID(String str) {
        this.mAppId = str;
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public void addPostDataOver() {
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public boolean isBeginPost() {
        return this.mPostStream.size() > this.mMinPostSize;
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public boolean transText(ByteArrayOutputStream byteArrayOutputStream) {
        JoyPrint.e(TAG, "transText");
        return false;
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public boolean threadTransText(ByteArrayOutputStream byteArrayOutputStream) {
        JoyPrint.e(TAG, "transText thread");
        return false;
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public boolean connect(ByteArrayOutputStream byteArrayOutputStream, boolean z) {
        synchronized (this) {
            this.mPostStream = byteArrayOutputStream;
        }
        if (NetCheck.isNetActive()) {
            if (!getWebSocketClient().IsRequestOver() && !this.nlsRequest.getId().equals(this.requestId)) {
                doConnect();
            }
            this.isText = false;
            this.isTtsRequest = false;
            return true;
        }
        onNetResult(null, -3, null);
        return false;
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public boolean connect(NlsRequest nlsRequest2) {
        synchronized (this) {
            this.nlsRequest = nlsRequest2;
            if (this.nlsRequest != null) {
                this.isText = true;
                this.isTtsRequest = false;
            }
        }
        if (NetCheck.isNetActive()) {
            TextRequestConnect();
            return true;
        }
        onNetResult(null, -3, null);
        return false;
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public boolean connect(String str, String str2, boolean z) {
        synchronized (this) {
            this.isTtsRequest = z;
            if (this.isTtsRequest) {
                L.i("is tts request");
            }
            this.UserContent = str;
            this.Samplerate = str2;
        }
        if (NetCheck.isNetActive()) {
            TtsRequestConnect();
            return true;
        }
        onNetResult(null, -3, null);
        return false;
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public void disconnect() {
        WebSocketClient webSocketClient = this.mWebSocketClient;
        if (webSocketClient != null && webSocketClient.isConnected()) {
            this.mWebSocketClient.disconnect();
            synchronized (this) {
                this.mIsNegotiating = false;
                this.mIsAvailable = false;
                this.mHasResult = false;
            }
        }
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public void resetCooks() {
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public boolean isConnect() {
        return isAvailable();
    }

    private boolean isMobileNet() {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        Context context = this.mContext;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return true;
        }
        if (activeNetworkInfo.getType() == 1) {
            return false;
        }
        if (sUseTlsInMobile || activeNetworkInfo.getSubtype() == 2 || activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 4) {
            return true;
        }
        return false;
    }

    private boolean isAvailable() {
        WebSocketClient webSocketClient = this.mWebSocketClient;
        if (webSocketClient == null || !webSocketClient.isConnected()) {
            this.mIsAvailable = false;
        }
        return this.mIsAvailable;
    }

    private boolean doConnect() {
        WebSocketClient webSocketClient = getWebSocketClient();
        this.mShouldSendTerminator.set(false);
        if (webSocketClient == null) {
            return false;
        }
        if (!webSocketClient.isConnected()) {
            if (!this.mIsNegotiating) {
                this.mIsNegotiating = true;
                webSocketClient.connect();
            }
            return false;
        } else if (this.mIsAvailable) {
            return true;
        } else {
            if (!this.mIsNegotiating) {
                this.mIsNegotiating = true;
                sendHeaderInfo(webSocketClient);
            }
            return false;
        }
    }

    private boolean TextRequestConnect() {
        WebSocketClient webSocketClient = getWebSocketClient();
        this.mShouldSendTerminator.set(false);
        if (webSocketClient == null) {
            return false;
        }
        if (!webSocketClient.isConnected()) {
            if (!this.mIsNegotiating) {
                this.mIsNegotiating = true;
                webSocketClient.connect();
            }
            return false;
        } else if (this.mIsAvailable) {
            return true;
        } else {
            if (!this.mIsNegotiating) {
                this.mIsNegotiating = true;
                sendTextRequest(webSocketClient);
            }
            return false;
        }
    }

    private boolean TtsRequestConnect() {
        WebSocketClient webSocketClient = getWebSocketClient();
        this.mShouldSendTerminator.set(false);
        if (webSocketClient == null) {
            return false;
        }
        if (!webSocketClient.isConnected()) {
            if (!this.mIsNegotiating) {
                this.mIsNegotiating = true;
                webSocketClient.connect();
            }
            return false;
        } else if (this.mIsAvailable) {
            return true;
        } else {
            if (!this.mIsNegotiating) {
                this.mIsNegotiating = true;
                sendTtsRequest(webSocketClient);
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized WebSocketClient getWebSocketClient() {
        if (this.mWebSocketClient == null) {
            L.i("new mWebSocketClient");
            this.mWebSocketClient = generateWebSocketClient();
        }
        return this.mWebSocketClient;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendHeaderInfo(WebSocketClient webSocketClient) {
        if (!this.nlsRequest.getId().equals(this.requestId)) {
            this.requestId = this.nlsRequest.getId();
            this.useCloudVad = this.nlsRequest.requests.asr_in.max_end_silence > 0;
            this.nlsRequest.setBstream_attached(true);
            this.nlsRequest.requests.asr_out = null;
            this.nlsRequest.requests.tts_in = null;
            NlsRequest nlsRequest2 = this.nlsRequest;
            String a = nlsRequest2.ParseExtUserIn(nlsRequest2).a();
            L.i("发送请求 ：" + a);
            webSocketClient.send(a);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendTextRequest(WebSocketClient webSocketClient) {
        NlsRequest nlsRequest2 = this.nlsRequest;
        nlsRequest2.requests.tts_in = null;
        nlsRequest2.setBstream_attached(false);
        String a = nlsRequest2.ParseExtUserIn(nlsRequest2).a();
        L.i("发送请求：" + a);
        webSocketClient.send(a);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendTtsRequest(WebSocketClient webSocketClient) {
        NlsRequest nlsRequest2 = this.nlsRequest;
        L.i("tts content = " + this.UserContent);
        String str = this.UserContent;
        if (str != null && !str.equals("")) {
            nlsRequest2.setTts_req(this.UserContent, this.Samplerate);
        }
        nlsRequest2.requests.asr_out = null;
        nlsRequest2.requests.asr_in = null;
        nlsRequest2.requests.ds_in = null;
        nlsRequest2.setBstream_attached(false);
        String a = nlsRequest2.ParseExtUserIn(nlsRequest2).a();
        L.i("发送请求：" + a);
        webSocketClient.send(a);
    }

    public static byte[] int2byteArray(int i) {
        return new byte[]{(byte) (i >>> 24), (byte) (i >>> 16), (byte) (i >>> 8), (byte) i};
    }

    public static byte[] byteMerger(byte[] bArr, byte[] bArr2, int i) {
        byte[] bArr3 = new byte[(bArr.length + i)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, i);
        return bArr3;
    }

    public void postData(ByteArrayOutputStream byteArrayOutputStream) {
        byte[] byteMerger;
        JoyPrint.d(TAG, "posting data");
        if (this.mIsAvailable) {
            JoyPrint.d(TAG, "ok, posting data, length " + byteArrayOutputStream.size());
            synchronized (byteArrayOutputStream) {
                byteMerger = byteMerger(int2byteArray(byteArrayOutputStream.size()), byteArrayOutputStream.toByteArray(), byteArrayOutputStream.size());
            }
            if (byteArrayOutputStream.size() > 0) {
                getWebSocketClient().send(byteMerger);
            }
        }
    }

    public void postTerminator() {
        getWebSocketClient().send(int2byteArray(0));
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface, com.alibaba.idst.nls.internal.connector.AbstractPostFrameData
    public void sendTerminator() {
        this.mShouldSendTerminator.set(true);
        if (this.mIsAvailable || this.mIsNegotiating) {
            JoyPrint.d(TAG, "web is available");
            return;
        }
        JoyPrint.e(TAG, "web isn't available");
        onNetResult(null, -1, "");
        onEnd();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void processMessage(String str) {
        L.d(TAG, "WebsocketPostFrameData,正确获取识别结果，准备解析。。。");
        WebsocketRecogDataParser.Result parse = WebsocketRecogDataParser.parse(str);
        if (parse.isSucceed) {
            if (!this.mIsAvailable) {
                if (this.isText.booleanValue() || this.isTtsRequest) {
                    L.d(TAG, "processMessage, post Terminator");
                    postTerminator();
                } else {
                    this.mIsAvailable = true;
                    new Thread(this.mSendDataRun).start();
                }
            }
            this.mIsAvailable = true;
            if (parse.hasRet && !parse.bstream_attached && parse.finish) {
                getWebSocketClient().setIsRequestOver(true);
                this.mHasResult = true;
                NlsListener.RecognizedResult recognizedResult = new NlsListener.RecognizedResult();
                recognizedResult.bstream_attached = Boolean.valueOf(parse.bstream_attached);
                recognizedResult.results = parse.results;
                recognizedResult.ds_out = parse.ds_out;
                recognizedResult.asr_out = parse.asr_out;
                recognizedResult.out = parse.out;
                recognizedResult.finish = Boolean.valueOf(parse.finish);
                recognizedResult.status_code = parse.status_code;
                onNetResult(recognizedResult, 1000, "");
            }
            if (!parse.finish && parse.asr_out != null && !parse.asr_out.equals("")) {
                this.mHasResult = true;
                NlsListener.RecognizedResult recognizedResult2 = new NlsListener.RecognizedResult();
                recognizedResult2.bstream_attached = Boolean.valueOf(parse.bstream_attached);
                recognizedResult2.results = parse.results;
                recognizedResult2.ds_out = parse.ds_out;
                recognizedResult2.asr_out = parse.asr_out;
                recognizedResult2.out = parse.out;
                recognizedResult2.finish = Boolean.valueOf(parse.finish);
                recognizedResult2.status_code = parse.status_code;
                onNetResult(recognizedResult2, 1000, "");
            }
        } else if (!parse.finish || parse.asr_out.equals("") || parse.bstream_attached) {
            this.mIsAvailable = false;
            JoyPrint.e(TAG, "Service is not available");
            onNetResult(null, EngineResultFlag.SERVER_HANDLING_ERROR, null);
            this.mIsNegotiating = false;
        } else {
            getWebSocketClient().setIsRequestOver(true);
            this.mHasResult = true;
            NlsListener.RecognizedResult recognizedResult3 = new NlsListener.RecognizedResult();
            recognizedResult3.bstream_attached = Boolean.valueOf(parse.bstream_attached);
            recognizedResult3.results = parse.results;
            recognizedResult3.ds_out = parse.ds_out;
            recognizedResult3.asr_out = parse.asr_out;
            recognizedResult3.out = parse.out;
            recognizedResult3.finish = Boolean.valueOf(parse.finish);
            recognizedResult3.status_code = parse.status_code;
            onNetResult(recognizedResult3, 1000, "");
        }
    }

    private WebSocketClient generateWebSocketClient() {
        URI uri;
        try {
            if (isMobileNet()) {
                uri = new URI(this.URL);
                this.mUrl = URL_TLS;
                L.d(TAG, "use url" + URL_TLS);
            } else {
                L.e("uri is :" + this.URL);
                uri = new URI(this.URL);
                this.mUrl = this.URL;
                L.d(TAG, "use url" + this.URL);
            }
            return new WebSocketClient(uri, new WebSocketClient.Listener() {
                /* class com.alibaba.idst.nls.internal.connector.WebsocketPostFrameData.AnonymousClass1 */

                @Override // com.alibaba.idst.nls.internal.connector.websockets.WebSocketClient.Listener
                public void onConnect() {
                    if (!WebsocketPostFrameData.this.isText.booleanValue() && !WebsocketPostFrameData.this.isTtsRequest) {
                        WebsocketPostFrameData websocketPostFrameData = WebsocketPostFrameData.this;
                        websocketPostFrameData.sendHeaderInfo(websocketPostFrameData.getWebSocketClient());
                    } else if (WebsocketPostFrameData.this.isTtsRequest) {
                        WebsocketPostFrameData websocketPostFrameData2 = WebsocketPostFrameData.this;
                        websocketPostFrameData2.sendTtsRequest(websocketPostFrameData2.getWebSocketClient());
                    } else {
                        WebsocketPostFrameData websocketPostFrameData3 = WebsocketPostFrameData.this;
                        websocketPostFrameData3.sendTextRequest(websocketPostFrameData3.getWebSocketClient());
                    }
                }

                @Override // com.alibaba.idst.nls.internal.connector.websockets.WebSocketClient.Listener
                public void onMessage(String str) {
                    L.d(WebsocketPostFrameData.TAG, "Message received:" + str);
                    WebsocketPostFrameData.this.processMessage(str);
                }

                @Override // com.alibaba.idst.nls.internal.connector.websockets.WebSocketClient.Listener
                public void onMessage(byte[] bArr) {
                    NlsListener.TtsResult ttsResult = new NlsListener.TtsResult();
                    ttsResult.tts_data = bArr;
                    WebsocketPostFrameData.this.onNetTTSResult(ttsResult, 2, "");
                }

                @Override // com.alibaba.idst.nls.internal.connector.websockets.WebSocketClient.Listener
                public void onDisconnect(int i, String str) {
                    JoyPrint.i(WebsocketPostFrameData.TAG, "disconnect code : " + i + " reason " + str);
                    WebsocketPostFrameData.this.getWebSocketClient().setIsRequestOver(false);
                    if (WebsocketPostFrameData.this.mIsNegotiating) {
                        if (!WebsocketPostFrameData.this.isTtsRequest) {
                            L.i(WebsocketPostFrameData.TAG, "TEXT disconnect! ");
                            WebsocketPostFrameData.this.onNetResult(null, i, str);
                        } else {
                            L.i(WebsocketPostFrameData.TAG, "tts disconnect! ");
                            WebsocketPostFrameData.this.onNetResult(null, i, str);
                        }
                    }
                    WebsocketPostFrameData.this.disconnect();
                    synchronized (this) {
                        WebsocketPostFrameData.this.mIsAvailable = false;
                        WebsocketPostFrameData.this.mIsNegotiating = false;
                    }
                    WebsocketPostFrameData.this.onEnd();
                }

                @Override // com.alibaba.idst.nls.internal.connector.websockets.WebSocketClient.Listener
                public void onError(Exception exc) {
                    L.e(WebsocketPostFrameData.TAG, "on error:" + exc.toString());
                    if ((exc instanceof HttpResponseException) && ((HttpResponseException) exc).getStatusCode() == 302) {
                        boolean unused = WebsocketPostFrameData.sUseTlsInMobile = true;
                    }
                    synchronized (this) {
                        WebsocketPostFrameData.this.mIsAvailable = false;
                        WebsocketPostFrameData.this.mIsNegotiating = false;
                    }
                    if (!WebsocketPostFrameData.this.isTtsRequest) {
                        WebsocketPostFrameData.this.onNetResult(null, -3, null);
                    } else {
                        L.e(WebsocketPostFrameData.TAG, "tts onError,  " + exc.getMessage());
                        WebsocketPostFrameData.this.onNetResult(null, -3, null);
                    }
                    WebsocketPostFrameData.this.disconnect();
                    WebsocketPostFrameData.this.onEnd();
                }
            }, null);
        } catch (Exception e) {
            L.e(TAG, "catch exception:" + e.getMessage());
            this.mIsNegotiating = false;
            return null;
        }
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface, com.alibaba.idst.nls.internal.connector.AbstractPostFrameData
    public void destory() {
        getWebSocketClient().destroy();
    }
}
