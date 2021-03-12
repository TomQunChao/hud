package com.amap.api.track;

public final class ErrorCode {
    private static final int LOC_FAIL_CODE_PREFIX = 1000;

    public static class Response {
        public static final int BAD_NETWORK = 3002;
        public static final String BAD_NETWORK_MSG = "网络未连接";
        public static final int BEYOND_LIMIT = 20150;
        public static final int NET_RES_FAIL = 3003;
        public static final String NET_RES_FAIL_MSG = "网络请求失败";
        public static final int PARAM_ERROR_CODE = 3001;
        public static final String PARAM_ERROR_CODE_MSG = "参数错误";
        public static final int REQ_NOT_VALID = 3004;
        public static final String REQ_NOT_VALID_MSG = "请求参数为空";
        public static final int SERVICE_NON_EXIST = 20050;
        public static final int SUCCESS = 10000;
        public static final int TERMINAL_ALREADY_EXIST = 20009;
        public static final int TERMINAL_CREATE_FAIL = 20052;
        public static final int TERMINAL_NON_EXIST = 20051;
        public static final int TRID_NON_EXIST = 20010;
    }

    public static class TrackListen {
        public static final int BIND_SUCCESS = 2001;
        public static final String BIND_SUCCESS_MSG = "寻迹服务绑定成功";
        public static final int REMOTE_EX = 2004;
        public static final String REMOTE_EX_MSG = "寻迹服务异常";
        public static final int SERVICE_NOT_STARTED = 2003;
        public static final String SERVICE_NOT_STARTED_MSG = "寻迹服务未启动，请先启动";
        public static final int START_GATHER_ALREADY_STARTED = 2009;
        public static final String START_GATHER_ALREADY_STARTED_MSG = "定位采集 已经启动";
        public static final int START_GATHER_SUCEE = 2010;
        public static final String START_GATHER_SUCEE_MSG = "定位采集 启动成功";
        public static final int START_GATHER_TRACK_NOT_STARTED = 2008;
        public static final String START_GATHER_TRACK_NOT_STARTED_MSG = "轨迹同步 未启动 ";
        public static final int START_SERVICE_EX = 2002;
        public static final String START_SERVICE_MSG = "寻迹服务启动出现异常";
        public static final int START_TRACK_ALREADY_STARTED = 2007;
        public static final String START_TRACK_ALREADY_STARTED_MSG = "轨迹同步 已经启动";
        public static final int START_TRACK_AUTH_CHECK_FAIL = 2017;
        public static final String START_TRACK_AUTH_CHECK_FAIL_MSG = "鉴权失败 ";
        public static final int START_TRACK_CREATE_TERMINAL_FAIL = 2021;
        public static final String START_TRACK_CREATE_TERMINAL_FAIL_MSG = "创建terminal非法 ";
        public static final int START_TRACK_NET_CONNECTED = 2016;
        public static final String START_TRACK_NET_CONNECTED_MSG = "网络未连接 ";
        public static final int START_TRACK_SERVICE_IS_INVALID = 2019;
        public static final String START_TRACK_SERVICE_IS_INVALID_MSG = "serviceid 非法 ";
        public static final int START_TRACK_SUCEE = 2005;
        public static final String START_TRACK_SUCEE_MSG = "轨迹同步 启动成功";
        public static final int START_TRACK_SUCEE_NO_NETWORK = 2006;
        public static final String START_TRACK_SUCEE_NO_NETWORK_MSG = "轨迹同步 启动成功,但是网络未连接";
        public static final int START_TRACK_TERMINAL_IS_INVALID = 2020;
        public static final String START_TRACK_TERMINAL_IS_INVALID_MSG = "terminal 非法 ";
        public static final int START_TRACK_TRACK_IS_INVALID = 2018;
        public static final String START_TRACK_TRACK_IS_INVALID_MSG = "Track不能为null ";
        public static final int STOP_GATHER_GATHER_NOT_STARTED = 2012;
        public static final String STOP_GATHER_GATHER_NOT_STARTED_MSG = "定位采集 未启动";
        public static final int STOP_GATHER_SUCCE = 2013;
        public static final String STOP_GATHER_SUCCE_MSG = "定位采集 停止成功";
        public static final int STOP_GATHER_TRACK_NOT_STARTED = 2011;
        public static final String STOP_GATHER_TRACK_NOT_STARTED_MSG = "轨迹同步 未启动";
        public static final int STOP_TRACK_SUCCE = 2014;
        public static final String STOP_TRACK_SUCCE_MSG = "轨迹同步 停止成功";
    }

    public static int getLocErrCode(int i) {
        return i + 1000;
    }
}
