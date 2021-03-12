package com.autonavi.ae.guide.model;

public class AsyncInfo {
    public int[] arg = new int[4];
    public Object obj;
    public int what;

    public interface IAsyncInfoType {
        public static final int AIT_NAVI_EXIT_DIR_UTILS = 3;
        public static final int AIT_NULL = 0;
        public static final int AIT_RENDER_MANEUVER_ICON = 2;
        public static final int AIT_VOICE_CONFIG_VERSION = 1;
    }
}
