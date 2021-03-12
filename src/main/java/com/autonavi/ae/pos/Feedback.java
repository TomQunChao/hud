package com.autonavi.ae.pos;

import com.alibaba.idst.nls.NlsClient;

public class Feedback {
    static int sendMessage(int i, String str) {
        if (i > 99 || i < 0) {
            return -3;
        }
        try {
            Class.forName("com.amap.location.uptunnel.UpTunnel").getMethod("reportEvent", Integer.TYPE, byte[].class).invoke(null, Integer.valueOf(i + NlsClient.ErrorCode.ERROR_FORMAT), str.getBytes("utf-8"));
            return 1;
        } catch (Exception e) {
            return -2;
        }
    }
}
