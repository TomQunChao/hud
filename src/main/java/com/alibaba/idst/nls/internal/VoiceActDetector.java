package com.alibaba.idst.nls.internal;

import com.alibaba.idst.nls.NlsClient;
import com.alibaba.idst.nls.internal.utils.JoyPrint;
import com.alibaba.idst.nls.internal.utils.L;
import com.alibaba.idst.nls.internal.vad.VoiceActDetectorCallback;
import com.amap.api.navi.view.PoiInputSearchWidget;
import com.amap.api.services.core.AMapException;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class VoiceActDetector {
    private static final int DEFAULT_MAX_RECORD_TIME = 30000;
    private static int DEFAULT_MUTE_VALUE = NlsClient.ErrorCode.ERROR_FORMAT;
    private static final int GATE_VOICE_FRAME_COUNT = 10;
    private static final int GET_HEAD_MUTE_FRAME = 25;
    private static int MAX_MUTE_VALUE = 6000;
    private static final int MAX_ZCR = 50;
    public static int MIN_VOICE_COUNT = 5;
    private static final int MIN_ZC_MAGNITUTE = 10;
    private static int MUTE_TIME_CONTINUOUS = PoiInputSearchWidget.DEF_ANIMATION_DURATION;
    private static int MUTE_TIME_DEFAULT = 35;
    private static final String TAG = "VoiceActDetector";
    private static final int VOICE_TIME_CONTINUOUS = 5;
    public static int gateMuteTime = MUTE_TIME_DEFAULT;
    public static int maxRecordTime = DEFAULT_MAX_RECORD_TIME;
    public static int minNoneEffectiveRecordTime = AMapException.CODE_AMAP_SERVICE_TABLEID_NOT_EXIST;
    public static int minRecordTime = 0;
    private int cNotMuteCount = 0;
    private int frameCount = 0;
    public int gateFrameMuteCount = 70;
    public int gateMuteValue = DEFAULT_MUTE_VALUE;
    public int headFrameSum = 0;
    public int headVoiceSum = 0;
    private boolean isHeadVoice = true;
    private boolean isNoneEffectiveRecord = false;
    private VoiceActDetectorCallback mCallback;
    private boolean mContinuous = false;
    private boolean mFastFrame = false;
    private boolean mIsDetectStart = true;
    private boolean mIsDetectStop = true;
    private ByteArrayOutputStream mPcmBuffer = new ByteArrayOutputStream(65536);
    private int mRecordTime = 0;
    private VoiceCodecs mVoiceCodecs = null;
    private int nMuteCount = 0;
    private int nVoiceContinuous = 0;
    private int nVoiceCount = 0;
    private double nVoiceEnergy = 0.0d;
    private int pcmBufferLen = 0;
    private byte[] spx = new byte[GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH];
    private int voiceFrameCount = 0;
    private int voiceValue = 0;
    private List<byte[]> voicebuffer = new ArrayList();

    public VoiceActDetector(VoiceActDetectorCallback voiceActDetectorCallback) {
        this.mCallback = voiceActDetectorCallback;
        this.mVoiceCodecs = new VoiceCodecs();
    }

    public void open() {
        this.mVoiceCodecs.open(true);
    }

    public void close() {
        this.mVoiceCodecs.close();
    }

    public void reset() {
        this.gateMuteValue = DEFAULT_MUTE_VALUE;
        this.nMuteCount = 0;
        this.mRecordTime = 0;
        this.headVoiceSum = 0;
        this.headFrameSum = 0;
        this.frameCount = 0;
        this.nVoiceCount = 0;
        this.voiceFrameCount = 0;
        this.isHeadVoice = true;
        this.cNotMuteCount = 0;
        this.nVoiceEnergy = 0.0d;
        this.mFastFrame = true;
        this.voicebuffer.clear();
        this.mPcmBuffer.reset();
        this.pcmBufferLen = 0;
        this.isNoneEffectiveRecord = false;
    }

    public void detectStopEnabled(boolean z) {
        this.mIsDetectStop = z;
    }

    public void detectStartEnabled(boolean z) {
        this.mIsDetectStart = z;
    }

    public void setMuteGate(int i) {
        gateMuteTime = i;
        MUTE_TIME_CONTINUOUS = i;
        MUTE_TIME_DEFAULT = i;
    }

    public int getRecordTime() {
        return this.mRecordTime;
    }

    private boolean needStopWhenAutoStop() {
        if (this.nMuteCount <= gateMuteTime) {
            return false;
        }
        if (this.mRecordTime < minRecordTime && this.nVoiceCount <= MIN_VOICE_COUNT) {
            return false;
        }
        L.i("RecordTime is:" + this.mRecordTime + " Continuous mute time is :" + (this.nMuteCount * 20) + "Valid voice time is :" + (this.nVoiceCount * 20));
        JoyPrint.e(TAG, "needStopWhenAutoStop true");
        return true;
    }

    private boolean returnNoneEffectiveRecord() {
        int i = this.mRecordTime;
        int i2 = minNoneEffectiveRecordTime;
        if (i <= i2 || ((double) this.nMuteCount) <= ((double) (i2 / 20)) * 0.9d || this.isNoneEffectiveRecord) {
            return false;
        }
        JoyPrint.e(TAG, "No avaliable voice input!");
        this.isNoneEffectiveRecord = true;
        return true;
    }

    private boolean needStopNormal() {
        if (this.mRecordTime <= maxRecordTime || this.mContinuous) {
            int i = this.mRecordTime;
            int i2 = maxRecordTime;
            if (i <= i2 + i2) {
                return false;
            }
            JoyPrint.e(TAG, "needStopNormal true2");
            return true;
        }
        JoyPrint.e(TAG, "needStopNormal true1");
        return true;
    }

    public byte[] update(short[] sArr) {
        int i;
        if (sArr.length != 320) {
            return null;
        }
        if (isMute(sArr)) {
            this.cNotMuteCount = 0;
        } else {
            this.cNotMuteCount++;
        }
        if (this.mFastFrame) {
            this.mFastFrame = false;
            return null;
        }
        int bufferFrame = this.mVoiceCodecs.bufferFrame(sArr, this.spx);
        if (bufferFrame == 0) {
            return null;
        }
        byte[] bytes = getBytes(sArr);
        this.mPcmBuffer.write(bytes, 0, bytes.length);
        this.pcmBufferLen += bytes.length;
        if (!this.mIsDetectStart) {
            this.mCallback.onVoiceDetected(this.spx, bufferFrame);
        } else if (this.isHeadVoice) {
            byte[] bArr = new byte[bufferFrame];
            System.arraycopy(this.spx, 0, bArr, 0, bufferFrame);
            this.voicebuffer.add(bArr);
            if (this.cNotMuteCount > MIN_VOICE_COUNT) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.voicebuffer.size());
                JoyPrint.d("size:", sb.toString());
                if (this.voicebuffer.size() > MIN_VOICE_COUNT + 40) {
                    i = (this.voicebuffer.size() - MIN_VOICE_COUNT) - 40;
                } else {
                    i = 0;
                }
                while (i < this.voicebuffer.size()) {
                    byte[] bArr2 = this.voicebuffer.get(i);
                    this.mCallback.onVoiceDetected(bArr2, bArr2.length);
                    i++;
                }
                this.isHeadVoice = false;
            }
        } else {
            this.mCallback.onVoiceDetected(this.spx, bufferFrame);
        }
        if (returnNoneEffectiveRecord()) {
            this.mCallback.onNoneEffectiveRecord();
        }
        if (needStopNormal()) {
            this.mCallback.onVoiceEnd();
        } else if (this.mIsDetectStop && needStopWhenAutoStop()) {
            this.mCallback.onVoiceEnd();
        }
        return bytes;
    }

    private boolean isMute(short[] sArr) {
        this.frameCount++;
        this.mRecordTime += 20;
        int length = sArr.length;
        double d = 0.0d;
        short s = 0;
        int i = 0;
        short s2 = 0;
        for (int i2 = 0; i2 < length; i2++) {
            short s3 = sArr[i2];
            if (s3 < 0) {
                s3 = (short) (-s3);
            }
            if (s3 > this.gateMuteValue) {
                i++;
            }
            d += (double) (s3 * s3);
            if (s3 > s) {
                s = s3;
            }
            if (i2 > 0 && sArr[i2 - 1] * sArr[i2] < 0 && s3 > 10) {
                s2 = (short) (s2 + 1);
            }
        }
        double d2 = d / ((double) length);
        this.voiceValue = s >> 6;
        if (this.frameCount < 26) {
            if (i <= this.gateFrameMuteCount || s2 >= 50) {
                updateMuteVaule(s);
            } else {
                updateMuteVaule4Voice((short) (s >> 3));
                this.nVoiceEnergy += d2;
                this.voiceFrameCount++;
            }
        }
        if (this.frameCount == 26) {
            if (this.voiceFrameCount > 10) {
                updateMuteVaule4Voice((short) (s >> 3));
            } else {
                updateMuteVaule(s);
            }
        }
        if (i > this.gateFrameMuteCount) {
            this.nVoiceContinuous++;
            if (this.nVoiceContinuous > 5) {
                this.nMuteCount = 0;
            } else {
                this.nMuteCount++;
            }
            this.nVoiceCount++;
            return false;
        }
        this.nMuteCount++;
        this.nVoiceContinuous = 0;
        return true;
    }

    public boolean isContinuous() {
        return this.mContinuous;
    }

    public void setContinuous(boolean z) {
        this.mContinuous = z;
        if (z) {
            gateMuteTime = MUTE_TIME_CONTINUOUS;
        } else {
            gateMuteTime = MUTE_TIME_DEFAULT;
        }
    }

    public byte[] getObject() {
        return this.mPcmBuffer.toByteArray();
    }

    private byte[] getBytes(short[] sArr) {
        int length;
        if (sArr == null || (length = sArr.length) == 0) {
            return null;
        }
        byte[] bArr = new byte[(length + length)];
        int i = 0;
        for (short s : sArr) {
            int i2 = i + 1;
            bArr[i] = (byte) (s & 255);
            i = i2 + 1;
            bArr[i2] = (byte) ((s >> 8) & 255);
        }
        return bArr;
    }

    public void setVADParam(int i, int i2) {
        switch (i) {
            case 1:
                MAX_MUTE_VALUE = i2;
                return;
            case 2:
                DEFAULT_MUTE_VALUE = i2;
                return;
            case 3:
                MUTE_TIME_DEFAULT = i2;
                return;
            case 4:
                minRecordTime = i2;
                return;
            case 5:
                MIN_VOICE_COUNT = i2;
                return;
            default:
                return;
        }
    }

    public int getVoiceValue() {
        return (int) (((double) (this.voiceValue >> 1)) / 2.55d);
    }

    private void updateMuteVaule(short s) {
        int i = this.frameCount;
        if (i > 26) {
            return;
        }
        if (i < 26) {
            int i2 = MAX_MUTE_VALUE;
            if (s > i2 + i2) {
                s = (short) (i2 + i2);
            }
            this.headFrameSum += s;
            return;
        }
        this.gateMuteValue = (int) (((double) (this.headFrameSum / (25 - this.voiceFrameCount))) * 1.2d);
        int i3 = this.gateMuteValue;
        int i4 = MAX_MUTE_VALUE;
        if (i3 > i4) {
            this.gateMuteValue = i4;
            return;
        }
        int i5 = DEFAULT_MUTE_VALUE;
        if (i3 < i5) {
            this.gateMuteValue = i5;
        }
    }

    private void updateMuteVaule4Voice(short s) {
        int i = this.frameCount;
        if (i > 26) {
            return;
        }
        if (i < 26) {
            int i2 = MAX_MUTE_VALUE;
            if (s > i2 + i2) {
                s = (short) (i2 + i2);
            }
            this.headVoiceSum += s;
            return;
        }
        this.gateMuteValue = (int) (((double) (this.headVoiceSum / this.voiceFrameCount)) * 0.8d);
        int i3 = this.gateMuteValue;
        int i4 = MAX_MUTE_VALUE;
        if (i3 > i4) {
            this.gateMuteValue = i4;
            return;
        }
        int i5 = DEFAULT_MUTE_VALUE;
        if (i3 < i5) {
            this.gateMuteValue = i5;
        }
    }
}
