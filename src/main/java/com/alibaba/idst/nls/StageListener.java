package com.alibaba.idst.nls;

public class StageListener {
    public void onVoiceData(short[] sArr, int i) {
    }

    public void onByteVoiceData(byte[] bArr, int i) {
    }

    public void onVoiceDetected(byte[] bArr, int i) {
    }

    public void onVoiceVolume(int i) {
    }

    public void onStartRecording(NlsClient nlsClient) {
    }

    public void onStopRecording(NlsClient nlsClient) {
    }

    public void onStopRecording(byte[] bArr) {
    }

    public void onStartRecognizing(NlsClient nlsClient) {
    }

    public void onStopRecognizing(NlsClient nlsClient) {
    }

    public void onVadStop(NlsClient nlsClient) {
    }

    public void onNoneEffectiveRecord() {
    }
}
