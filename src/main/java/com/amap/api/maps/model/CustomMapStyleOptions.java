package com.amap.api.maps.model;

public class CustomMapStyleOptions {
    private String a = null;
    private byte[] b = null;
    private String c = null;
    private byte[] d = null;
    private String e = null;
    private boolean f = true;

    public String getStyleDataPath() {
        return this.a;
    }

    public CustomMapStyleOptions setStyleDataPath(String str) {
        this.a = str;
        return this;
    }

    public String getStyleTexturePath() {
        return this.c;
    }

    public CustomMapStyleOptions setStyleTexturePath(String str) {
        this.c = str;
        return this;
    }

    public byte[] getStyleData() {
        return this.b;
    }

    public CustomMapStyleOptions setStyleData(byte[] bArr) {
        this.b = bArr;
        return this;
    }

    public byte[] getStyleTextureData() {
        return this.d;
    }

    public CustomMapStyleOptions setStyleTextureData(byte[] bArr) {
        this.d = bArr;
        return this;
    }

    public String getStyleId() {
        return this.e;
    }

    public CustomMapStyleOptions setStyleId(String str) {
        this.e = str;
        return this;
    }

    public boolean isEnable() {
        return this.f;
    }

    public CustomMapStyleOptions setEnable(boolean z) {
        this.f = z;
        return this;
    }
}
