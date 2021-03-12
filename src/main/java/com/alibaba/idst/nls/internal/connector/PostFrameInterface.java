package com.alibaba.idst.nls.internal.connector;

import com.alibaba.idst.nls.internal.protocol.NlsRequest;
import java.io.ByteArrayOutputStream;

public interface PostFrameInterface {
    void addPostDataOver();

    void cancelTask();

    boolean connect(NlsRequest nlsRequest);

    boolean connect(ByteArrayOutputStream byteArrayOutputStream, boolean z);

    boolean connect(String str, String str2, boolean z);

    void destory();

    void disconnect();

    String getPhoneInfoString();

    boolean isBeginPost();

    boolean isCancel();

    boolean isConnect();

    void resetCooks();

    void sendTerminator();

    void setAppID(String str);

    void setCustomParam(String str);

    void setHost(String str);

    void setHost(boolean z, String str);

    void setMinPostSize(Integer num);

    void setMtype(String str);

    void setOnNetDataListener(ConnectorCallback connectorCallback);

    void setPath(String str);

    void setPort(int i);

    void setProtocol(String str, String str2, String str3, String str4, String str5);

    void setReadTimeout(Integer num);

    boolean threadTransText(ByteArrayOutputStream byteArrayOutputStream);

    boolean transText(ByteArrayOutputStream byteArrayOutputStream);

    void updateHostList(String str);
}
