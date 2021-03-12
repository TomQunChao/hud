package com.alibaba.idst.nls.internal.connector;

import com.alibaba.idst.nls.internal.common.ZTSDefine;
import com.alibaba.idst.nls.internal.connector.FrameDataPosterFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class HttpGetQtEv {
    private static String host = "";
    public static ArrayList<String> hostList = webSocketHostList;
    private static ArrayList<String> httpHostList = new ArrayList<>();
    private static String mEv = "";
    private static String mQt = "";
    private static String path = ZTSDefine.HTTP_DEFAULT_PATH;
    private static ArrayList<String> webSocketHostList = new ArrayList<>();
    private URL url = null;

    static {
        httpHostList.add("");
        httpHostList.add("");
    }

    public static void setPosterType(FrameDataPosterFactory.PosterType posterType) {
        switch (posterType) {
            case WEBSOCKET_POSTER:
                hostList = webSocketHostList;
                return;
            case HTTP_POSTER:
                hostList = httpHostList;
                return;
            default:
                return;
        }
    }

    public void setHost(String str) {
        host = str;
    }

    public void setPath(String str) {
        path = str;
    }

    public void setHostList(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<String> it = hostList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (arrayList.indexOf(next) == -1) {
                    arrayList.add(next);
                }
            }
            hostList = arrayList;
        }
    }

    private String getUrlStr() {
        return "http://" + host + path + mEv + "&" + mQt;
    }

    public void setEv(int i) {
        mEv = "ev=" + i;
        mQt = "qt=";
    }

    public void setQt(String str) {
        mQt = "qt=" + str;
        mEv = "ev=";
    }

    public String setEvToServer(String str, int i) {
        int size = hostList.size();
        setEv(i);
        String str2 = null;
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            setHost(hostList.get(i2));
            String str3 = str2;
            int i3 = 0;
            while (true) {
                if (i3 >= 2) {
                    str2 = str3;
                    break;
                }
                str3 = setEVRequest(str);
                if (str3 != null) {
                    str2 = str3;
                    z = true;
                    break;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i3++;
            }
            if (z) {
                break;
            }
        }
        return str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String setEVRequest(java.lang.String r5) {
        /*
        // Method dump skipped, instructions count: 165
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.idst.nls.internal.connector.HttpGetQtEv.setEVRequest(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d4 A[SYNTHETIC, Splitter:B:51:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ea A[SYNTHETIC, Splitter:B:61:0x00ea] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<java.lang.String> setQtRequest(java.lang.String r6) {
        /*
        // Method dump skipped, instructions count: 245
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.idst.nls.internal.connector.HttpGetQtEv.setQtRequest(java.lang.String):java.util.ArrayList");
    }
}
