package com.alibaba.idst.nls.internal;

import android.content.Context;
import com.alibaba.idst.nls.NlsClient;
import com.alibaba.idst.nls.NlsListener;
import com.alibaba.idst.nls.internal.connector.ConnectorCallback;
import com.alibaba.idst.nls.internal.connector.FrameDataPosterFactory;
import com.alibaba.idst.nls.internal.connector.HttpGetQtEv;
import com.alibaba.idst.nls.internal.connector.PostFrameInterface;
import com.alibaba.idst.nls.internal.protocol.NlsRequest;
import com.alibaba.idst.nls.internal.utils.JoyPrint;
import com.alibaba.idst.nls.internal.utils.L;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class SpeechServiceConnector implements ConnectorCallback {
    private static final String TAG = SpeechServiceConnector.class.getSimpleName();
    private int connectCount = 0;
    private ConnectorCallback mConnectorCallback = null;
    private Context mContext;
    private String mCurrType = "";
    private String mEngineCsr = NlsClient.Define.HTTP_CSR_OFF;
    private String mEngineIO = NlsClient.Define.HTTP_IO_CHEN;
    private String mEngineIn = NlsClient.Define.HTTP_I_CH;
    private String mEngineSC = NlsClient.Define.HTTP_SC;
    private String mEngineType = NlsClient.Define.HTTP_TYPE_SR;
    private AtomicBoolean mIsOpened = new AtomicBoolean(false);
    private NlsRequest mNlsRequest;
    private PostFrameInterface mPostData = null;
    private ByteArrayOutputStream mSendStream = new ByteArrayOutputStream(20480);
    private boolean useWss = true;

    public SpeechServiceConnector(Context context, NlsRequest nlsRequest, ConnectorCallback connectorCallback, FrameDataPosterFactory.PosterType posterType) {
        this.mContext = context;
        this.mNlsRequest = nlsRequest;
        this.mConnectorCallback = connectorCallback;
        this.mIsOpened.set(false);
        this.mPostData = FrameDataPosterFactory.newInstance(this.mContext, this.mNlsRequest, posterType);
        this.mPostData.setOnNetDataListener(this);
        this.mPostData.setProtocol(this.mEngineType, this.mEngineIn, this.mEngineIO, this.mEngineCsr, this.mEngineSC);
    }

    public void setHost(boolean z, String str) {
        this.useWss = z;
        PostFrameInterface postFrameInterface = this.mPostData;
        if (postFrameInterface != null) {
            postFrameInterface.setHost(this.useWss, str);
        }
    }

    public boolean startup() {
        this.mConnectorCallback.onRecognizeStart();
        this.connectCount = 0;
        this.mSendStream.reset();
        if (this.mPostData.isConnect()) {
            this.mPostData.cancelTask();
            this.mPostData = null;
            this.mPostData = FrameDataPosterFactory.newInstance(this.mContext, this.mNlsRequest);
            this.mPostData.setProtocol(this.mEngineType, this.mEngineIn, this.mEngineIO, this.mEngineCsr, this.mEngineSC);
            this.mPostData.setMtype(this.mCurrType);
        }
        this.mPostData.setOnNetDataListener(this.mConnectorCallback);
        this.mIsOpened.set(true);
        return true;
    }

    public void shutdown() {
        L.i(TAG, "shutdown disconnect");
        this.mPostData.disconnect();
    }

    public boolean send(byte[] bArr, int i) {
        if (!this.mIsOpened.get() || bArr == null || bArr.length <= 0) {
            return false;
        }
        if (i < 0) {
            postData(bArr, 0, bArr.length);
            return true;
        }
        postData(bArr, 0, i);
        return true;
    }

    public boolean sendttsrequest(String str, String str2) {
        if (!this.mIsOpened.get() || str == null) {
            return false;
        }
        postTtsData(str, str2);
        return true;
    }

    private void postData(byte[] bArr, int i, int i2) {
        if (this.mSendStream != null) {
            if (!this.mPostData.isConnect()) {
                this.mPostData.connect(this.mSendStream, false);
            }
            synchronized (this.mSendStream) {
                this.mSendStream.write(bArr, i, i2);
            }
        }
    }

    public boolean send(NlsRequest nlsRequest) {
        if (!this.mIsOpened.get() || nlsRequest == null) {
            return false;
        }
        postData(nlsRequest);
        return true;
    }

    private void postData(NlsRequest nlsRequest) {
        if (nlsRequest != null && !this.mPostData.isConnect()) {
            this.mPostData.connect(nlsRequest);
        }
    }

    private void postTtsData(String str, String str2) {
        if (str != null && !this.mPostData.isConnect()) {
            this.mPostData.connect(str, str2, true);
        }
    }

    public void sendTerminator() {
        this.mPostData.sendTerminator();
    }

    private boolean connect() {
        PostFrameInterface postFrameInterface = this.mPostData;
        if (postFrameInterface == null) {
            return false;
        }
        return postFrameInterface.connect(this.mSendStream, false);
    }

    private boolean retryConnect(String str) {
        this.mPostData.cancelTask();
        this.mPostData.resetCooks();
        this.mPostData = null;
        this.mPostData = FrameDataPosterFactory.newInstance(this.mContext, this.mNlsRequest);
        this.mPostData.setHost(this.useWss, str);
        this.mPostData.setProtocol(this.mEngineType, this.mEngineIn, this.mEngineIO, this.mEngineCsr, this.mEngineSC);
        this.mPostData.setMtype(this.mCurrType);
        this.mPostData.setOnNetDataListener(this.mConnectorCallback);
        if (!this.mPostData.connect(this.mSendStream, true)) {
            return false;
        }
        this.mIsOpened.set(true);
        return true;
    }

    public void close() {
        if (this.mIsOpened.compareAndSet(true, false)) {
            this.mPostData.addPostDataOver();
            this.mPostData.sendTerminator();
            JoyPrint.e("justin", "send Terminator");
        }
    }

    @Override // com.alibaba.idst.nls.internal.connector.ConnectorCallback
    public void onRecognizeResult(NlsListener.RecognizedResult recognizedResult, int i, String str) {
        this.connectCount++;
        L.i("SpeechServiceConnector.onRecognizeResult.connectCount=" + this.connectCount);
        if (i != -3) {
            if (this.connectCount < HttpGetQtEv.hostList.size() && this.connectCount != 0) {
                HttpGetQtEv.hostList.add(0, HttpGetQtEv.hostList.remove(this.connectCount - 1));
            }
            this.connectCount = 0;
            this.mConnectorCallback.onRecognizeResult(recognizedResult, i, str);
        } else if (this.connectCount < HttpGetQtEv.hostList.size()) {
            retryConnect(HttpGetQtEv.hostList.get(this.connectCount));
        } else {
            this.mConnectorCallback.onRecognizeResult(recognizedResult, i, str);
        }
    }

    @Override // com.alibaba.idst.nls.internal.connector.ConnectorCallback
    public void onTtsResult(NlsListener.TtsResult ttsResult, int i, String str) {
        this.mConnectorCallback.onTtsResult(ttsResult, i, str);
    }

    @Override // com.alibaba.idst.nls.internal.connector.ConnectorCallback
    public void onRecognizeStart() {
        this.mConnectorCallback.onRecognizeStart();
    }

    @Override // com.alibaba.idst.nls.internal.connector.ConnectorCallback
    public void onRecognizeEnd() {
        this.mConnectorCallback.onRecognizeEnd();
    }
}
