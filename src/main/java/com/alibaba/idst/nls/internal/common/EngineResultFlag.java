package com.alibaba.idst.nls.internal.common;

public class EngineResultFlag {
    public static final int CANCEL = -2;
    public static final int CLOSE_FRAME_ERROR = 0;
    public static final int CONNECT_ERROR = -3;
    public static final int EOF = 10;
    public static final int ERROR_AUTH_FAILD = 4403;
    public static final int ERROR_FORMAT = 4400;
    public static final int ERROR_NEED_DATA_PLUS_AUTH = 4401;
    public static final int ERROR_OVER_CONNECTION_LIMITED = 4429;
    public static final int ERROR_REQUEST_TIMEOUT = 4408;
    public static final int NOTHING = -1;
    public static final int RECORDING_ERROR = -4;
    public static final int SERVER_HANDLING_ERROR = 4500;
    public static final int SERVICE_NOT_AVAILABLE = 4503;
    public static final int TTS_STREAMING = 2;
    public static final int WORKING = 1000;
}
