package com.alibaba.idst.nls.internal.config;

public class SessionConfig {
    private static String sSessionId;

    public static synchronized String getSessionId() {
        String str;
        synchronized (SessionConfig.class) {
            str = sSessionId;
        }
        return str;
    }
}
