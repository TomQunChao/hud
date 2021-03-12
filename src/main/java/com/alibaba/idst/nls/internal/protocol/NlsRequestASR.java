package com.alibaba.idst.nls.internal.protocol;

public class NlsRequestASR {
    public String asrSC = "opu";
    public String customization_id = null;
    public int max_end_silence = -1;
    public String model;
    public String organization_id;
    public String response_mode = null;
    public String user_id;
    public String version = NlsRequestProto.VERSION30;
    public String vocabulary_id;

    public enum mode {
        STREAMING,
        NORMAL
    }

    public static class out {
        public Boolean fake = true;
        public String result = "";
        public String version = NlsRequestProto.VERSION40;
    }
}
