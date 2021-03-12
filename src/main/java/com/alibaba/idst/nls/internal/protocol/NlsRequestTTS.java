package com.alibaba.idst.nls.internal.protocol;

import com.amap.api.navi.enums.AliTTS;

public class NlsRequestTTS {
    private int background_music_id = -1;
    private int background_music_offset;
    private int background_music_volume = 50;
    private String encode_type = AliTTS.TTS_ENCODETYPE_PCM;
    private String format = "normal";
    private int nus = 1;
    private int pitch_rate = 0;
    private String refer;
    private String sample_rate = "16000";
    private int speech_rate = 0;
    private String text = null;
    private String version = "1.0";
    private String voice;
    private int volume = 50;

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public String getEncode_type() {
        return this.encode_type;
    }

    public void setEncode_type(String str) {
        this.encode_type = str;
    }

    public String getSample_rate() {
        return this.sample_rate;
    }

    public void setSample_rate(String str) {
        this.sample_rate = str;
    }

    public int getSpeech_rate() {
        return this.speech_rate;
    }

    public void setSpeech_rate(int i) {
        this.speech_rate = i;
    }

    public int getVolume() {
        return this.volume;
    }

    public void setVolume(int i) {
        this.volume = i;
    }

    public int getNus() {
        return this.nus;
    }

    public void setNus(int i) {
        this.nus = i;
    }

    public int getPitch_rate() {
        return this.pitch_rate;
    }

    public void setPitch_rate(int i) {
        this.pitch_rate = i;
    }

    public int getBackground_music_id() {
        return this.background_music_id;
    }

    public void setBackground_music_id(int i) {
        this.background_music_id = i;
    }

    public int getBackground_music_offset() {
        return this.background_music_offset;
    }

    public void setBackground_music_offset(int i) {
        this.background_music_offset = i;
    }

    public int getBackground_music_volume() {
        return this.background_music_volume;
    }

    public void setBackground_music_volume(int i) {
        this.background_music_volume = i;
    }

    public String getVoice() {
        return this.voice;
    }

    public void setVoice(String str) {
        this.voice = str;
    }

    public String getRefer() {
        return this.refer;
    }

    public void setRefer(String str) {
        this.refer = str;
    }
}
