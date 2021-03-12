package com.alibaba.idst.nls.internal.connector;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.idst.nls.NlsListener;
import com.alibaba.idst.nls.internal.protocol.NlsRequest;

public abstract class AbstractPostFrameData implements PostFrameInterface {
    protected boolean isTtsRequest;
    protected Context mContext;
    protected NlsRequest mNlsRequest;
    protected ConnectorCallback mOnEngineListener;
    protected ThreadMsgHandler mThreadMsgHandler;

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public abstract void destory();

    protected static class Define {
        protected static final String MSG_CONTENT = "CONTENT";
        protected static final String MSG_FLAG = "FLAG";
        protected static final String MSG_ID = "ID";
        protected static final String MSG_TYPE = "TYPE";
        protected static final int TYPE_BEGIN = 1;
        protected static final int TYPE_END = 3;
        protected static final int TYPE_RESULT = 2;

        protected Define() {
        }
    }

    /* access modifiers changed from: protected */
    public class ThreadMsgHandler extends Handler {
        public ThreadMsgHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            ConnectorCallback connectorCallback = AbstractPostFrameData.this.mOnEngineListener;
            if (connectorCallback != null) {
                Bundle data = message.getData();
                int i = data.getInt("TYPE");
                if (i == 2) {
                    int i2 = data.getInt("FLAG");
                    String string = data.getString("ID");
                    if (i2 == 2) {
                        connectorCallback.onTtsResult((NlsListener.TtsResult) data.getSerializable("CONTENT"), i2, string);
                    } else {
                        connectorCallback.onRecognizeResult((NlsListener.RecognizedResult) data.getSerializable("CONTENT"), i2, string);
                    }
                } else if (i == 1) {
                    connectorCallback.onRecognizeStart();
                } else if (i == 3) {
                    connectorCallback.onRecognizeEnd();
                }
            }
        }
    }

    public AbstractPostFrameData(Context context, NlsRequest nlsRequest) {
        this.mThreadMsgHandler = new ThreadMsgHandler(context.getMainLooper());
        this.mNlsRequest = nlsRequest;
        this.mContext = context;
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public void setOnNetDataListener(ConnectorCallback connectorCallback) {
        this.mOnEngineListener = connectorCallback;
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public boolean isCancel() {
        return this.mOnEngineListener == null;
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public void cancelTask() {
        onNetResult(null, -2, null);
        onEnd();
        this.mOnEngineListener = null;
    }

    /* access modifiers changed from: protected */
    public void onEnd() {
        if (this.mOnEngineListener != null) {
            Message obtainMessage = this.mThreadMsgHandler.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putInt("TYPE", 3);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        if (this.mOnEngineListener != null) {
            Message obtainMessage = this.mThreadMsgHandler.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putInt("TYPE", 1);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }

    /* access modifiers changed from: protected */
    public void onNetResult(NlsListener.RecognizedResult recognizedResult, int i, String str) {
        if (this.mOnEngineListener != null) {
            Message obtainMessage = this.mThreadMsgHandler.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putInt("TYPE", 2);
            bundle.putInt("FLAG", i);
            bundle.putString("ID", str);
            bundle.putSerializable("CONTENT", recognizedResult);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }

    /* access modifiers changed from: protected */
    public void onNetTTSResult(NlsListener.TtsResult ttsResult, int i, String str) {
        if (this.mOnEngineListener != null) {
            Message obtainMessage = this.mThreadMsgHandler.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putInt("TYPE", 2);
            bundle.putInt("FLAG", i);
            bundle.putString("ID", str);
            bundle.putSerializable("CONTENT", ttsResult);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }

    @Override // com.alibaba.idst.nls.internal.connector.PostFrameInterface
    public void sendTerminator() {
    }
}
