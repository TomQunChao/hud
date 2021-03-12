package com.alibaba.idst.nls;

import android.content.Context;
import android.os.Handler;
import com.alibaba.idst.nls.NlsListener;
import com.alibaba.idst.nls.internal.ServiceStatusChecker;
import com.alibaba.idst.nls.internal.SpeechServiceConnector;
import com.alibaba.idst.nls.internal.VoiceActDetector;
import com.alibaba.idst.nls.internal.VoiceRecorder;
import com.alibaba.idst.nls.internal.common.Config;
import com.alibaba.idst.nls.internal.common.EngineResultFlag;
import com.alibaba.idst.nls.internal.config.Version;
import com.alibaba.idst.nls.internal.connector.ConnectorCallback;
import com.alibaba.idst.nls.internal.connector.FrameDataPosterFactory;
import com.alibaba.idst.nls.internal.protocol.NlsRequest;
import com.alibaba.idst.nls.internal.protocol.NlsRequestASR;
import com.alibaba.idst.nls.internal.recorder.VoiceRecorderCallback;
import com.alibaba.idst.nls.internal.utils.JoyPrint;
import com.alibaba.idst.nls.internal.utils.L;
import com.alibaba.idst.nls.internal.vad.VoiceActDetectorCallback;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class NlsClient implements ConnectorCallback, VoiceRecorderCallback, VoiceActDetectorCallback {
    private static final String TAG = "NlsClient";
    private static String mAddress = "";
    private static String mAppKey = "";
    private static String mNLP = "tb";
    private SpeechServiceConnector mConnector = null;
    private Context mContext = null;
    private ByteArrayOutputStream mEncodedVoiceBytes = new ByteArrayOutputStream(65536);
    private volatile boolean mIsCancelled = false;
    private boolean mIsConnectorEnabled = true;
    private boolean mIsOver = true;
    private AtomicBoolean mIsStarted = new AtomicBoolean(false);
    private long mLastVoiceValueTime = 0;
    private int mMinVoiceValueInterval = 200;
    private int mMinimalSpeechLength = 500;
    private NlsRequest mNlsRequest = null;
    private boolean mOnTts = false;
    private NlsListener mRecognizeListener = null;
    private StageListener mStageListener = null;
    private Handler mUIHandler = null;
    private VoiceActDetector mVoiceActDetector = null;
    private VoiceRecorder mVoiceRecorder = null;
    private boolean realFinish = true;
    private boolean useDefaultAudioRecord = true;

    static {
        JoyPrint.closePrint();
    }

    public static String getBuildVersion() {
        return Version.BuildVersion;
    }

    public static String getBuildTime() {
        return Version.BuildTime;
    }

    public static void openLog(boolean z) {
        if (z) {
            JoyPrint.openPrint();
        } else {
            JoyPrint.closePrint();
        }
    }

    public static void configure(Context context, String str, String str2) {
        mAppKey = str2;
        mAddress = str;
        ServiceStatusChecker.check(null, context);
    }

    public static void configure(Context context) {
        ServiceStatusChecker.check(null, context);
    }

    public static NlsClient newInstance(Context context, NlsListener nlsListener, StageListener stageListener, NlsRequest nlsRequest) {
        return new NlsClient(context, nlsListener, stageListener, nlsRequest);
    }

    private NlsClient(Context context, NlsListener nlsListener, StageListener stageListener, NlsRequest nlsRequest) {
        this.mStageListener = stageListener;
        this.mRecognizeListener = nlsListener;
        this.mUIHandler = new Handler();
        this.mContext = context;
        this.mNlsRequest = nlsRequest;
        this.mVoiceActDetector = new VoiceActDetector(this);
        this.mVoiceActDetector.open();
        this.mVoiceRecorder = new VoiceRecorder(1, VoiceRecorder.SAMPLE_RATE, 2, 2, this);
        try {
            this.mConnector = new SpeechServiceConnector(context, this.mNlsRequest, this, FrameDataPosterFactory.sDefaultPosterType);
        } catch (Throwable th) {
            this.mConnector = new SpeechServiceConnector(context, this.mNlsRequest, this, FrameDataPosterFactory.sDefaultPosterType);
        }
        runOnUIThread(new Runnable() {
            /* class com.alibaba.idst.nls.NlsClient.AnonymousClass1 */

            public void run() {
                if (NlsClient.this.mRecognizeListener != null) {
                    NlsClient.this.mRecognizeListener.onServiceStatChanged(NlsClient.isSerivceAvailable(), ServiceStatusChecker.isRpcAvailable());
                }
            }
        });
    }

    public byte[] getObject() {
        return this.mVoiceActDetector.getObject();
    }

    public NlsClient setHost(String str) {
        SpeechServiceConnector speechServiceConnector = this.mConnector;
        if (speechServiceConnector != null) {
            speechServiceConnector.setHost(false, str);
        }
        return this;
    }

    public NlsClient setHost(boolean z, String str) {
        SpeechServiceConnector speechServiceConnector = this.mConnector;
        if (speechServiceConnector != null) {
            speechServiceConnector.setHost(z, str);
        }
        return this;
    }

    public static void setAutoLoadLibs(boolean z) {
        Config.AUTO_LOAD_LIBS = z;
    }

    public static void setServiceCheckUrl(String str) {
        ServiceStatusChecker.setServiceCheckUrl(str);
    }

    public static boolean isSerivceAvailable() {
        return ServiceStatusChecker.isServiceAvailable();
    }

    public NlsClient setMinVoiceValueInterval(int i) {
        this.mMinVoiceValueInterval = i;
        return this;
    }

    public NlsClient setNoneEffectiveRecordTime(int i) {
        VoiceActDetector.minNoneEffectiveRecordTime = i;
        return this;
    }

    public NlsClient setMinRecordTime(int i) {
        VoiceActDetector.minRecordTime = i;
        return this;
    }

    public NlsClient setMaxRecordTime(int i) {
        if (i > 1073741823) {
            i = 1073741823;
        }
        VoiceActDetector.maxRecordTime = i;
        return this;
    }

    public NlsClient setMaxStallTime(int i) {
        this.mVoiceActDetector.setMuteGate(i / 20);
        return this;
    }

    public NlsClient setMinimalSpeechLength(int i) {
        this.mMinimalSpeechLength = i;
        return this;
    }

    public NlsClient setMinMuteValue(int i) {
        VoiceActDetector voiceActDetector = this.mVoiceActDetector;
        if (voiceActDetector != null) {
            voiceActDetector.setVADParam(2, i);
        }
        return this;
    }

    public NlsClient setRecordAutoStop(boolean z) {
        VoiceActDetector voiceActDetector = this.mVoiceActDetector;
        if (voiceActDetector != null) {
            voiceActDetector.detectStopEnabled(z);
        }
        return this;
    }

    public NlsClient setConnectorEnabled(boolean z) {
        this.mIsConnectorEnabled = z;
        return this;
    }

    public boolean isConnectorEnabled() {
        return this.mIsConnectorEnabled;
    }

    public void checkService() {
        ServiceStatusChecker.check(new ServiceStatusChecker.ServiceStatusListener() {
            /* class com.alibaba.idst.nls.NlsClient.AnonymousClass2 */

            @Override // com.alibaba.idst.nls.internal.ServiceStatusChecker.ServiceStatusListener
            public void onServiceStatus(final boolean z, final boolean z2) {
                NlsClient.this.runOnUIThread(new Runnable() {
                    /* class com.alibaba.idst.nls.NlsClient.AnonymousClass2.AnonymousClass1 */

                    public void run() {
                        if (NlsClient.this.mRecognizeListener != null) {
                            NlsClient.this.mRecognizeListener.onServiceStatChanged(z, z2);
                        }
                    }
                });
            }
        }, this.mContext);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void runOnUIThread(Runnable runnable) {
        this.mUIHandler.post(runnable);
    }

    public boolean start() {
        if (!isSerivceAvailable()) {
            JoyPrint.e(TAG, "Start failed: service unavailable");
            return false;
        } else if (this.mIsStarted.compareAndSet(false, true)) {
            this.mNlsRequest.initId();
            this.mIsOver = false;
            this.mIsCancelled = false;
            this.realFinish = false;
            this.mVoiceActDetector.reset();
            this.mEncodedVoiceBytes.reset();
            if (this.useDefaultAudioRecord) {
                this.mVoiceRecorder.start();
            } else {
                this.mVoiceRecorder.UserVoiceStart();
            }
            JoyPrint.d(TAG, "engine Started");
            return true;
        } else {
            JoyPrint.e(TAG, "Start failed: already started");
            runOnUIThread(new Runnable() {
                /* class com.alibaba.idst.nls.NlsClient.AnonymousClass3 */

                public void run() {
                    if (NlsClient.this.mRecognizeListener != null) {
                        NlsClient.this.mRecognizeListener.onRecognizingResult(ErrorCode.ERROR_CLICK_TOOMUCH, null);
                    }
                }
            });
            return false;
        }
    }

    public void useDefaultAudioRecord(Boolean bool) {
        this.useDefaultAudioRecord = bool.booleanValue();
    }

    public Boolean sendUserVoice(byte[] bArr) {
        if (bArr.length != 640) {
            JoyPrint.e(TAG, "User voice length should be 640!");
            return false;
        }
        this.mVoiceRecorder.setUserVoice(bArr);
        return true;
    }

    public void stop() {
        JoyPrint.e(TAG, "stop is called");
        if (!this.mIsStarted.get()) {
            VoiceRecorder voiceRecorder = this.mVoiceRecorder;
            if (voiceRecorder != null) {
                voiceRecorder.immediateStop();
            }
        } else if (this.mVoiceActDetector.getRecordTime() < this.mMinimalSpeechLength) {
            this.mVoiceRecorder.immediateStop();
            this.mRecognizeListener.onRecognizingResult(4, null);
            onRealRecogizeEnd();
        } else {
            this.mVoiceRecorder.immediateStop();
        }
    }

    private void close() {
        JoyPrint.e(TAG, "close is called");
        VoiceActDetector voiceActDetector = this.mVoiceActDetector;
        if (voiceActDetector != null) {
            try {
                voiceActDetector.close();
            } catch (Throwable th) {
            }
        }
    }

    public boolean isStarted() {
        return this.mIsStarted.get();
    }

    public void cancel() {
        JoyPrint.e(TAG, "cancel is called");
        if (this.mIsStarted.get()) {
            this.mVoiceRecorder.immediateStop();
            this.mIsCancelled = true;
            this.mIsOver = true;
            runOnUIThread(new Runnable() {
                /* class com.alibaba.idst.nls.NlsClient.AnonymousClass4 */

                public void run() {
                    NlsClient.this.mRecognizeListener.onRecognizingResult(3, null);
                    NlsClient.this.onRealRecogizeEnd();
                    JoyPrint.e(NlsClient.TAG, "cancel: engine end");
                }
            });
            return;
        }
        JoyPrint.e(TAG, "cancel: the mrecognizer isn't started");
    }

    public void destory() {
        FrameDataPosterFactory.destory();
    }

    @Override // com.alibaba.idst.nls.internal.recorder.VoiceRecorderCallback
    public boolean onRecorderStart() {
        runOnUIThread(new Runnable() {
            /* class com.alibaba.idst.nls.NlsClient.AnonymousClass5 */

            public void run() {
                if (NlsClient.this.mStageListener != null) {
                    NlsClient.this.mStageListener.onStartRecording(NlsClient.this);
                }
                JoyPrint.d(NlsClient.TAG, "onRecorderStart");
            }
        });
        return true;
    }

    @Override // com.alibaba.idst.nls.internal.recorder.VoiceRecorderCallback
    public boolean onRecorderReady() {
        if (isConnectorEnabled()) {
            JoyPrint.d(TAG, "onRecorderReady: start connector");
            return this.mConnector.startup();
        }
        JoyPrint.d(TAG, "onRecorderReady: connector already started");
        return true;
    }

    @Override // com.alibaba.idst.nls.internal.recorder.VoiceRecorderCallback
    public void onRecorderStop() {
        if (isConnectorEnabled()) {
            runOnUIThread(new Runnable() {
                /* class com.alibaba.idst.nls.NlsClient.AnonymousClass6 */

                public void run() {
                    if (NlsClient.this.mStageListener != null) {
                        NlsClient.this.mStageListener.onStopRecording(NlsClient.this);
                    }
                }
            });
            JoyPrint.d(TAG, "onRecorderStop: close connector");
            this.mConnector.close();
            return;
        }
        runOnUIThread(new Runnable() {
            /* class com.alibaba.idst.nls.NlsClient.AnonymousClass7 */

            public void run() {
                if (NlsClient.this.mStageListener != null) {
                    NlsClient.this.mStageListener.onStopRecording(NlsClient.this.mEncodedVoiceBytes.toByteArray());
                }
            }
        });
        JoyPrint.d(TAG, "onRecorderStop: connector is not opened");
        onRecognizeStart();
        onRecognizeEnd();
    }

    @Override // com.alibaba.idst.nls.internal.recorder.VoiceRecorderCallback
    public void onRecorded(final short[] sArr) {
        final byte[] update = this.mVoiceActDetector.update(sArr);
        onVoiceValue(this.mVoiceActDetector.getVoiceValue());
        runOnUIThread(new Runnable() {
            /* class com.alibaba.idst.nls.NlsClient.AnonymousClass8 */

            public void run() {
                if (NlsClient.this.mStageListener != null) {
                    StageListener stageListener = NlsClient.this.mStageListener;
                    short[] sArr = sArr;
                    int i = 0;
                    stageListener.onVoiceData(sArr, sArr == null ? 0 : sArr.length);
                    StageListener stageListener2 = NlsClient.this.mStageListener;
                    byte[] bArr = update;
                    if (bArr != null) {
                        i = bArr.length;
                    }
                    stageListener2.onByteVoiceData(bArr, i);
                }
            }
        });
    }

    @Override // com.alibaba.idst.nls.internal.recorder.VoiceRecorderCallback
    public void onVoiceValue(final int i) {
        long j = this.mLastVoiceValueTime;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - j >= ((long) this.mMinVoiceValueInterval)) {
            this.mLastVoiceValueTime = currentTimeMillis;
            runOnUIThread(new Runnable() {
                /* class com.alibaba.idst.nls.NlsClient.AnonymousClass9 */

                public void run() {
                    if (NlsClient.this.mStageListener != null) {
                        NlsClient.this.mStageListener.onVoiceVolume(i);
                    }
                }
            });
        }
    }

    @Override // com.alibaba.idst.nls.internal.recorder.VoiceRecorderCallback
    public void onRecordedFail(final int i) {
        runOnUIThread(new Runnable() {
            /* class com.alibaba.idst.nls.NlsClient.AnonymousClass10 */

            public void run() {
                if (NlsClient.this.mRecognizeListener != null) {
                    NlsClient.this.mIsStarted.set(false);
                }
                if (i == 3) {
                    NlsClient.this.mRecognizeListener.onRecognizingResult(ErrorCode.NO_RECORDING_PERMISSION, null);
                    NlsClient.this.mIsOver = true;
                    return;
                }
                NlsClient.this.mRecognizeListener.onRecognizingResult(2, null);
            }
        });
        JoyPrint.d(TAG, "onRecorderFailed");
    }

    @Override // com.alibaba.idst.nls.internal.vad.VoiceActDetectorCallback
    public void onVoiceStart() {
    }

    @Override // com.alibaba.idst.nls.internal.vad.VoiceActDetectorCallback
    public void onVoiceEnd() {
        JoyPrint.d(TAG, "onVoiceEnd");
        this.mVoiceRecorder.stop();
        runOnUIThread(new Runnable() {
            /* class com.alibaba.idst.nls.NlsClient.AnonymousClass11 */

            public void run() {
                if (NlsClient.this.mStageListener != null) {
                    NlsClient.this.mStageListener.onVadStop(NlsClient.this);
                }
            }
        });
    }

    @Override // com.alibaba.idst.nls.internal.vad.VoiceActDetectorCallback
    public void onNoneEffectiveRecord() {
        JoyPrint.d(TAG, "onNoneEffectiveRecord");
        runOnUIThread(new Runnable() {
            /* class com.alibaba.idst.nls.NlsClient.AnonymousClass12 */

            public void run() {
                if (NlsClient.this.mStageListener != null) {
                    NlsClient.this.mStageListener.onNoneEffectiveRecord();
                }
            }
        });
    }

    @Override // com.alibaba.idst.nls.internal.vad.VoiceActDetectorCallback
    public void onVoiceDetected(final byte[] bArr, final int i) {
        if (isConnectorEnabled()) {
            this.mConnector.send(bArr, i);
            return;
        }
        this.mEncodedVoiceBytes.write(bArr, 0, i);
        runOnUIThread(new Runnable() {
            /* class com.alibaba.idst.nls.NlsClient.AnonymousClass13 */

            public void run() {
                if (NlsClient.this.mStageListener != null) {
                    NlsClient.this.mStageListener.onVoiceDetected(bArr, i);
                }
            }
        });
    }

    public boolean PostUserQuery(String str) {
        if (!isConnectorEnabled()) {
            return false;
        }
        if (this.mIsStarted.compareAndSet(false, true)) {
            this.mNlsRequest.initId();
            this.mIsOver = false;
            this.realFinish = false;
            onRecorderReady();
            NlsRequestASR.out out = new NlsRequestASR.out();
            out.result = str;
            this.mNlsRequest.setAsr_out(out);
            this.mConnector.send(this.mNlsRequest);
            L.d(TAG, "Send User Input Content:" + str);
            return true;
        }
        JoyPrint.e(TAG, "Start failed: already started");
        runOnUIThread(new Runnable() {
            /* class com.alibaba.idst.nls.NlsClient.AnonymousClass14 */

            public void run() {
                if (NlsClient.this.mRecognizeListener != null) {
                    NlsClient.this.mRecognizeListener.onRecognizingResult(ErrorCode.ERROR_CLICK_TOOMUCH, null);
                }
            }
        });
        return false;
    }

    public boolean PostTtsRequest(String str, String str2) {
        if (!isConnectorEnabled()) {
            return false;
        }
        if (this.mIsStarted.compareAndSet(false, true)) {
            this.mNlsRequest.initId();
            this.mIsOver = false;
            this.realFinish = false;
            onRecorderReady();
            this.mConnector.sendttsrequest(str, str2);
            L.d(TAG, "Send User Input Content:" + str);
            return true;
        }
        JoyPrint.e(TAG, "Start failed: already started");
        runOnUIThread(new Runnable() {
            /* class com.alibaba.idst.nls.NlsClient.AnonymousClass15 */

            public void run() {
                if (NlsClient.this.mRecognizeListener != null) {
                    NlsClient.this.mRecognizeListener.onRecognizingResult(ErrorCode.ERROR_CLICK_TOOMUCH, null);
                }
            }
        });
        return false;
    }

    public boolean PostTtsRequest(String str) {
        if (!isConnectorEnabled()) {
            return false;
        }
        if (this.mIsStarted.compareAndSet(false, true)) {
            this.mNlsRequest.initId();
            this.mIsOver = false;
            this.realFinish = false;
            onRecorderReady();
            this.mConnector.sendttsrequest(str, "16000");
            L.d(TAG, "Send User Input Content:" + str);
            return true;
        }
        JoyPrint.e(TAG, "Start failed: already started");
        runOnUIThread(new Runnable() {
            /* class com.alibaba.idst.nls.NlsClient.AnonymousClass16 */

            public void run() {
                if (NlsClient.this.mRecognizeListener != null) {
                    NlsClient.this.mRecognizeListener.onRecognizingResult(ErrorCode.ERROR_CLICK_TOOMUCH, null);
                }
            }
        });
        return false;
    }

    @Override // com.alibaba.idst.nls.internal.connector.ConnectorCallback
    public void onRecognizeResult(final NlsListener.RecognizedResult recognizedResult, final int i, String str) {
        if (!(this.mVoiceRecorder == null || recognizedResult == null || !recognizedResult.finish.booleanValue())) {
            this.mVoiceRecorder.immediateStop();
        }
        if (recognizedResult == null && !this.mIsOver) {
            this.mIsOver = true;
            L.i("CLOSE FRAME WITH ErrorCode :" + ErrorCode.getErrorCode(i));
            if (ErrorCode.getErrorCode(i) != 0) {
                this.mVoiceRecorder.immediateStop();
                this.mRecognizeListener.onRecognizingResult(ErrorCode.getErrorCode(i), null);
            }
        } else if (!this.mIsCancelled && recognizedResult != null && !this.mIsOver) {
            JoyPrint.d(TAG, "onRecognizeResult: parsing");
            runOnUIThread(new Runnable() {
                /* class com.alibaba.idst.nls.NlsClient.AnonymousClass17 */

                public void run() {
                    if (recognizedResult.asr_out != null) {
                        NlsClient.this.mRecognizeListener.onRecognizingResult(0, recognizedResult);
                    } else if (NlsClient.this.mRecognizeListener != null) {
                        NlsClient.this.mRecognizeListener.onRecognizingResult(ErrorCode.getErrorCode(i), recognizedResult);
                    }
                }
            });
        }
        if (this.mIsOver) {
            L.i("Recognize over,onRealRecogizeEnd!");
            onRealRecogizeEnd();
        }
        JoyPrint.d(TAG, "onRecognizeResult parsed");
    }

    @Override // com.alibaba.idst.nls.internal.connector.ConnectorCallback
    public void onTtsResult(final NlsListener.TtsResult ttsResult, final int i, String str) {
        runOnUIThread(new Runnable() {
            /* class com.alibaba.idst.nls.NlsClient.AnonymousClass18 */

            public void run() {
                if (ttsResult != null) {
                    byte[] bArr = new byte[0];
                    L.d(NlsClient.TAG, "Received tts binary data length:" + ttsResult.tts_data.length);
                    if (ttsResult.tts_data.length > 4) {
                        bArr = Arrays.copyOfRange(ttsResult.tts_data, 4, ttsResult.tts_data.length);
                    }
                    if (bArr.length <= 0) {
                        NlsClient.this.mRecognizeListener.onTtsResult(8, bArr);
                        NlsClient.this.onRealRecogizeEnd();
                        NlsClient.this.mOnTts = false;
                    } else if (!NlsClient.this.mOnTts) {
                        NlsClient.this.mRecognizeListener.onTtsResult(6, bArr);
                        NlsClient.this.mOnTts = true;
                    } else {
                        NlsClient.this.mRecognizeListener.onTtsResult(7, bArr);
                    }
                } else if (ErrorCode.getErrorCode(i) != 0) {
                    NlsClient.this.mRecognizeListener.onTtsResult(ErrorCode.getErrorCode(i), null);
                    NlsClient.this.onRealRecogizeEnd();
                }
            }
        });
    }

    @Override // com.alibaba.idst.nls.internal.connector.ConnectorCallback
    public void onRecognizeStart() {
        JoyPrint.d(TAG, "onRecognizeStart");
        runOnUIThread(new Runnable() {
            /* class com.alibaba.idst.nls.NlsClient.AnonymousClass19 */

            public void run() {
                if (NlsClient.this.mStageListener != null) {
                    NlsClient.this.mStageListener.onStartRecognizing(NlsClient.this);
                }
            }
        });
    }

    @Override // com.alibaba.idst.nls.internal.connector.ConnectorCallback
    public void onRecognizeEnd() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onRealRecogizeEnd() {
        JoyPrint.d(TAG, "onRealRecogizeEnd");
        this.mIsOver = true;
        if (isConnectorEnabled()) {
            this.mConnector.shutdown();
            try {
                Thread.sleep(70);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        runOnUIThread(new Runnable() {
            /* class com.alibaba.idst.nls.NlsClient.AnonymousClass20 */

            public void run() {
                if (NlsClient.this.mStageListener != null && !NlsClient.this.realFinish) {
                    NlsClient.this.realFinish = true;
                    NlsClient.this.mStageListener.onStopRecognizing(NlsClient.this);
                }
            }
        });
        this.mIsStarted.set(false);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        close();
    }

    public void setExt_userData(String str, String str2) {
        if (str != null && str2 != null && !str.equals("") && !str2.equals("")) {
            this.mNlsRequest.setExt_userData(str, str2);
        }
    }

    public static String getExt_userData(String str, NlsListener.RecognizedResult recognizedResult) {
        if (str != null) {
            String str2 = recognizedResult.results;
            L.i("out is " + str2);
            try {
                return new JSONObject(str2).optString(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String getData(String str, String str2) {
        if (str != null) {
            try {
                return new JSONObject(str2).optString(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static class ErrorCode {
        public static final int CONNECT_ERROR = 530;
        public static final int ERROR_AUTH_FAILD = 403;
        public static final int ERROR_CLICK_TOOMUCH = 570;
        public static final int ERROR_FORMAT = 400;
        public static final int ERROR_NEED_DATA_PLUS_AUTH = 401;
        public static final int ERROR_OVER_CONNECTION_LIMITED = 429;
        public static final int ERROR_REQUEST_TIMEOUT = 408;
        public static final int NOTHING = 4;
        public static final int NO_RECORDING_PERMISSION = 504;
        public static final int RECOGNIZE_ERROR = 1;
        public static final int RECORDING_ERROR = 2;
        public static final int SERVER_HANDLING_ERROR = 500;
        public static final int SERVICE_NOT_AVAILABLE = 503;
        public static final int SUCCESS = 0;
        public static final int TTS_BEGIN = 6;
        public static final int TTS_OVER = 8;
        public static final int TTS_TRANSFERRING = 7;
        public static final int USER_CANCEL = 3;

        static int getErrorCode(int i) {
            if (i == 10 || i == 1000) {
                return 0;
            }
            if (i == 4403) {
                return ERROR_AUTH_FAILD;
            }
            if (i == 4408) {
                return ERROR_REQUEST_TIMEOUT;
            }
            if (i == 4429) {
                return ERROR_OVER_CONNECTION_LIMITED;
            }
            if (i == 4500) {
                return 500;
            }
            if (i == 4503) {
                return SERVICE_NOT_AVAILABLE;
            }
            switch (i) {
                case -4:
                    return 2;
                case -3:
                    return CONNECT_ERROR;
                case -2:
                    return 3;
                case -1:
                    return 4;
                case 0:
                    return 500;
                default:
                    switch (i) {
                        case EngineResultFlag.ERROR_FORMAT /*{ENCODED_INT: 4400}*/:
                            return ERROR_FORMAT;
                        case EngineResultFlag.ERROR_NEED_DATA_PLUS_AUTH /*{ENCODED_INT: 4401}*/:
                            return ERROR_NEED_DATA_PLUS_AUTH;
                        default:
                            return 1;
                    }
            }
        }
    }

    public class Define {
        public static final String HTTP_CSR_OFF = "csr=0";
        public static final String HTTP_CSR_ON = "csr=1";
        public static final String HTTP_CSR_ON2 = "csr=2";
        public static final String HTTP_IO_CHEN = "io=chen";
        public static final String HTTP_IO_ENCH = "io=ench";
        public static final String HTTP_I_CH = "i=ch";
        public static final String HTTP_I_EN = "i=en";
        public static final String HTTP_SC = "sc=opu";
        public static final String HTTP_TYPE_S2N = "t=s2n";
        public static final String HTTP_TYPE_S2T = "t=s2t";
        public static final String HTTP_TYPE_SR = "t=sr";
        public static final String HTTP_TYPE_T2S = "t=t2s";

        public Define() {
        }
    }
}
