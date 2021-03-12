package com.alibaba.idst.nls.internal;

import android.media.AudioRecord;
import com.alibaba.idst.nls.internal.recorder.VoiceRecorderCallback;
import com.alibaba.idst.nls.internal.utils.BytesTransUtil;
import com.alibaba.idst.nls.internal.utils.JoyPrint;
import com.alibaba.idst.nls.internal.utils.L;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class VoiceRecorder {
    public static final int SAMPLE_RATE = 16000;
    private static final String TAG = "VoiceRecorder";
    static final int WAVE_FRAM_SIZE = 3200;
    private Runnable RecordRun = new Runnable() {
        /* class com.alibaba.idst.nls.internal.VoiceRecorder.AnonymousClass1 */
        short[] wave = new short[320];

        public void run() {
            int i;
            if (VoiceRecorder.this.mAudioRecorder != null && VoiceRecorder.this.mAudioRecorder.getState() == 1) {
                JoyPrint.i(VoiceRecorder.TAG, "mAudioRecorder state is : " + String.valueOf(VoiceRecorder.this.mAudioRecorder.getState()));
                try {
                    VoiceRecorder.this.mAudioRecorder.stop();
                    VoiceRecorder.this.mAudioRecorder.startRecording();
                } catch (Exception e) {
                    e.printStackTrace();
                    VoiceRecorder.this.mCallback.onRecordedFail(0);
                    VoiceRecorder.this.mAudioRecorder = null;
                }
            }
            if (VoiceRecorder.this.mAudioRecorder != null && VoiceRecorder.this.mAudioRecorder.getState() == 1 && VoiceRecorder.this.mAudioRecorder.getRecordingState() == 1) {
                VoiceRecorder.this.mCallback.onRecordedFail(3);
                VoiceRecorder.this.mAudioRecorder = null;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= 2) {
                    break;
                } else if (VoiceRecorder.this.mAudioRecorder == null) {
                    VoiceRecorder.this.isRecord = false;
                    break;
                } else {
                    AudioRecord audioRecord = VoiceRecorder.this.mAudioRecorder;
                    short[] sArr = this.wave;
                    audioRecord.read(sArr, 0, sArr.length);
                    i2++;
                }
            }
            while (VoiceRecorder.this.isRecord) {
                try {
                    i = VoiceRecorder.this.mAudioRecorder.read(this.wave, 0, this.wave.length);
                } catch (Exception e2) {
                    VoiceRecorder.this.isRecord = false;
                    VoiceRecorder.this.mCallback.onRecordedFail(0);
                    i = 0;
                }
                if (i == this.wave.length) {
                    VoiceRecorder.this.mCallback.onRecorded(this.wave);
                } else {
                    VoiceRecorder.this.mCallback.onRecordedFail(1);
                    VoiceRecorder.this.isRecord = false;
                }
            }
            L.i("Stop Recorder!");
            VoiceRecorder.this.unInitializeRecord();
            VoiceRecorder.this.doRecordStop();
        }
    };
    private Runnable UserRun = new Runnable() {
        /* class com.alibaba.idst.nls.internal.VoiceRecorder.AnonymousClass2 */
        short[] wave = new short[320];

        public void run() {
            for (int i = 0; i < 2; i++) {
                if (VoiceRecorder.this.queue.isEmpty()) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            JoyPrint.i(VoiceRecorder.TAG, "User Audio Input.");
            while (VoiceRecorder.this.isRecord) {
                if (!VoiceRecorder.this.queue.isEmpty()) {
                    try {
                        byte[] bArr = (byte[]) VoiceRecorder.this.queue.poll(20, TimeUnit.MILLISECONDS);
                        if (bArr != null) {
                            this.wave = VoiceRecorder.this.bytesTransUtil.Bytes2Shorts(bArr);
                            if (this.wave != null) {
                                short[] sArr = this.wave;
                                VoiceRecorder.this.mCallback.onRecorded(this.wave);
                            }
                        } else {
                            L.e("Get null user audio from queue!");
                        }
                    } catch (Exception e2) {
                        VoiceRecorder.this.isRecord = false;
                        VoiceRecorder.this.mCallback.onRecordedFail(0);
                    }
                } else {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                }
            }
            VoiceRecorder.this.unInitializeRecord();
            VoiceRecorder.this.doRecordStop();
        }
    };
    private int aFormat;
    private int aSource;
    private int bufferSize;
    private BytesTransUtil bytesTransUtil = BytesTransUtil.getInstance();
    private int channle;
    private boolean isRecord = false;
    private AudioRecord mAudioRecorder = null;
    private VoiceRecorderCallback mCallback;
    private Thread mThread = null;
    private LinkedBlockingQueue<byte[]> queue = new LinkedBlockingQueue<>();
    private int sRate;

    public VoiceRecorder(int i, int i2, int i3, int i4, VoiceRecorderCallback voiceRecorderCallback) {
        this.aSource = i;
        this.sRate = i2;
        this.aFormat = i4;
        this.channle = i3;
        this.bufferSize = 128000;
        this.mCallback = voiceRecorderCallback;
    }

    public void setUserVoice(byte[] bArr) {
        try {
            this.queue.put(bArr);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean start() {
        this.isRecord = true;
        synchronized (this) {
            if (doRecordReady()) {
                JoyPrint.d(TAG, "doRecordReady");
                if (initializeRecord()) {
                    JoyPrint.d(TAG, "initializeRecord");
                    if (doRecordStart()) {
                        JoyPrint.d(TAG, "doRecordStart");
                        this.mThread = new Thread(this.RecordRun);
                        this.mThread.start();
                        return true;
                    }
                }
            }
            this.isRecord = false;
            return false;
        }
    }

    public boolean UserVoiceStart() {
        this.isRecord = true;
        synchronized (this) {
            if (doRecordReady()) {
                JoyPrint.d(TAG, "doRecordReady");
                this.mThread = new Thread(this.UserRun);
                this.mThread.start();
                return true;
            }
            this.isRecord = false;
            return false;
        }
    }

    public void stop() {
        synchronized (this) {
            this.mThread = null;
            this.isRecord = false;
        }
    }

    public void immediateStop() {
        L.i("Voice Recorder immediately stop");
        this.isRecord = false;
        Thread thread = this.mThread;
        if (thread != null) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.mThread = null;
    }

    public boolean isStarted() {
        return this.isRecord;
    }

    private boolean initializeRecord() {
        synchronized (this) {
            try {
                if (this.mCallback == null) {
                    JoyPrint.e(TAG, "Error VoiceRecorderCallback = null");
                    return false;
                }
                int minBufferSize = AudioRecord.getMinBufferSize(this.sRate, this.channle, this.aFormat);
                if (this.bufferSize < minBufferSize) {
                    this.bufferSize = minBufferSize;
                    JoyPrint.d(TAG, "Increasing buffer size to " + Integer.toString(this.bufferSize));
                }
                if (this.mAudioRecorder != null) {
                    unInitializeRecord();
                }
                this.mAudioRecorder = new AudioRecord(this.aSource, this.sRate, this.channle, this.aFormat, this.bufferSize);
                if (this.mAudioRecorder.getState() == 1) {
                    this.mAudioRecorder.setPositionNotificationPeriod(WAVE_FRAM_SIZE);
                    JoyPrint.i(TAG, "initialize  Record");
                    return true;
                }
                this.mAudioRecorder = null;
                this.mCallback.onRecordedFail(3);
                throw new Exception("AudioRecord initialization failed");
            } catch (Throwable th) {
                if (th.getMessage() != null) {
                    JoyPrint.e(TAG, getClass().getName() + th.getMessage());
                } else {
                    JoyPrint.e(TAG, getClass().getName() + "Unknown error occured while initializing recording");
                }
                JoyPrint.e("websocket", "recording error");
                return false;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void unInitializeRecord() {
        JoyPrint.i(TAG, "unInitializeRecord");
        synchronized (this) {
            if (this.mAudioRecorder != null) {
                try {
                    this.mAudioRecorder.stop();
                    this.mAudioRecorder.release();
                } catch (Exception e) {
                    e.printStackTrace();
                    JoyPrint.e(TAG, "mAudioRecorder release error!");
                }
                this.mAudioRecorder = null;
            }
        }
    }

    private boolean doRecordStart() {
        VoiceRecorderCallback voiceRecorderCallback = this.mCallback;
        if (voiceRecorderCallback != null) {
            return voiceRecorderCallback.onRecorderStart();
        }
        return true;
    }

    private boolean doRecordReady() {
        VoiceRecorderCallback voiceRecorderCallback = this.mCallback;
        if (voiceRecorderCallback != null) {
            return voiceRecorderCallback.onRecorderReady();
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doRecordStop() {
        VoiceRecorderCallback voiceRecorderCallback = this.mCallback;
        if (voiceRecorderCallback != null) {
            voiceRecorderCallback.onRecorderStop();
        }
    }
}
