package com.amap.api.track.query.entity;

public class ProtocolType {
    public static final int HTTP = 0;
    public static final int HTTPS = 1;

    public static boolean isHttps(int i) {
        return i == 1;
    }
}
