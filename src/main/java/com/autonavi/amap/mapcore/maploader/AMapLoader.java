package com.autonavi.amap.mapcore.maploader;

import android.content.Context;
import com.amap.api.col.stln3.hb;
import com.amap.api.col.stln3.ic;
import com.amap.api.col.stln3.qy;
import com.amap.api.col.stln3.rb;
import com.amap.api.col.stln3.rd;
import com.amap.api.col.stln3.rj;
import com.amap.api.col.stln3.rx;
import com.amap.api.col.stln3.tt;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.ae.gmap.GLMapEngine;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public class AMapLoader implements tt.a {
    private static final int GET_METHOD = 0;
    private static String mDiu;
    private tt downloadManager;
    private volatile boolean isCanceled = false;
    public boolean isFinish = false;
    ADataRequestParam mDataRequestParam;
    private int mEngineID = 0;
    GLMapEngine mGLMapEngine;
    private boolean mRequestCancel = false;

    public static class ADataRequestParam {
        public byte[] enCodeString;
        public long handler;
        public int nCompress;
        public int nRequestType;
        public String requestBaseUrl;
        public String requestUrl;
    }

    public static class AMapGridDownloadRequest extends hb {
        private final Context mContext;
        private byte[] postEntityBytes;
        private String sUrl;
        private String userAgent;

        public AMapGridDownloadRequest(Context context, String str, String str2) {
            this.mContext = context;
            this.sUrl = str;
            this.userAgent = str2;
        }

        @Override // com.amap.api.col.stln3.tw, com.amap.api.col.stln3.hb
        public Map<String, String> getRequestHead() {
            String str;
            rj f = ic.f();
            if (f != null) {
                str = f.b();
            } else {
                str = null;
            }
            Hashtable hashtable = new Hashtable(16);
            hashtable.put("User-Agent", this.userAgent);
            hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", str, "3dmap"));
            hashtable.put("x-INFO", rb.a(this.mContext));
            hashtable.put("key", qy.f(this.mContext));
            hashtable.put("logversion", "2.1");
            return hashtable;
        }

        @Override // com.amap.api.col.stln3.tw, com.amap.api.col.stln3.hb
        public Map<String, String> getParams() {
            return null;
        }

        @Override // com.amap.api.col.stln3.tw
        public String getURL() {
            return this.sUrl;
        }

        public void setPostEntityBytes(byte[] bArr) {
            this.postEntityBytes = bArr;
        }

        @Override // com.amap.api.col.stln3.tw
        public byte[] getEntityBytes() {
            return this.postEntityBytes;
        }
    }

    @Override // com.amap.api.col.stln3.tt.a
    public void onDownload(byte[] bArr, long j) {
        GLMapEngine gLMapEngine;
        ADataRequestParam aDataRequestParam;
        if (bArr != null && (gLMapEngine = this.mGLMapEngine) != null && (aDataRequestParam = this.mDataRequestParam) != null) {
            gLMapEngine.receiveNetData(this.mEngineID, aDataRequestParam.handler, bArr, bArr.length);
        }
    }

    @Override // com.amap.api.col.stln3.tt.a
    public void onStop() {
        ADataRequestParam aDataRequestParam;
        GLMapEngine gLMapEngine = this.mGLMapEngine;
        if (gLMapEngine != null && (aDataRequestParam = this.mDataRequestParam) != null) {
            gLMapEngine.netError(this.mEngineID, aDataRequestParam.handler, -1);
        }
    }

    @Override // com.amap.api.col.stln3.tt.a
    public void onFinish() {
        ADataRequestParam aDataRequestParam;
        GLMapEngine gLMapEngine = this.mGLMapEngine;
        if (gLMapEngine != null && (aDataRequestParam = this.mDataRequestParam) != null) {
            gLMapEngine.finishDownLoad(this.mEngineID, aDataRequestParam.handler);
        }
    }

    @Override // com.amap.api.col.stln3.tt.a
    public void onException(Throwable th) {
        ADataRequestParam aDataRequestParam;
        GLMapEngine gLMapEngine = this.mGLMapEngine;
        if (!(gLMapEngine == null || (aDataRequestParam = this.mDataRequestParam) == null)) {
            gLMapEngine.netError(this.mEngineID, aDataRequestParam.handler, -1);
        }
        rx.c(th, "AMapLoader", "download onException");
    }

    public AMapLoader(int i, GLMapEngine gLMapEngine, ADataRequestParam aDataRequestParam) {
        this.mDataRequestParam = aDataRequestParam;
        this.mEngineID = i;
        this.mGLMapEngine = gLMapEngine;
        this.mRequestCancel = false;
    }

    public void doRequest() {
        boolean z;
        if (!this.mRequestCancel) {
            String str = this.mDataRequestParam.requestBaseUrl;
            String str2 = this.mDataRequestParam.requestUrl;
            if (!str.endsWith("?")) {
                str = str + "?";
            }
            String replaceAll = str2.replaceAll(";", getEncodeRequestParams(";").toString());
            if (str == null || !str.contains("http://m5.amap.com/")) {
                z = false;
            } else {
                z = true;
            }
            String requestParams = getRequestParams(replaceAll, z, this.mDataRequestParam.nRequestType);
            StringBuffer stringBuffer = new StringBuffer();
            if (this.mDataRequestParam.nRequestType == 0) {
                stringBuffer.append(requestParams);
                stringBuffer.append("&csid=" + UUID.randomUUID().toString());
            } else {
                stringBuffer.append("csid=" + UUID.randomUUID().toString());
            }
            try {
                AMapGridDownloadRequest aMapGridDownloadRequest = new AMapGridDownloadRequest(this.mGLMapEngine.getContext(), str + generateQueryString(this.mGLMapEngine.getContext(), stringBuffer.toString()), this.mGLMapEngine.getUserAgent());
                aMapGridDownloadRequest.setConnectionTimeout(1800000);
                aMapGridDownloadRequest.setSoTimeout(1800000);
                if (this.mDataRequestParam.nRequestType != 0) {
                    aMapGridDownloadRequest.setPostEntityBytes(requestParams.getBytes("UTF-8"));
                }
                this.downloadManager = new tt(aMapGridDownloadRequest, 0, -1, MapsInitializer.getProtocol() == 2);
                this.downloadManager.a(this);
            } catch (Throwable th) {
                doCancel();
                throw th;
            }
            doCancel();
        }
    }

    public void doCancel() {
        this.mRequestCancel = true;
        if (this.downloadManager != null && !this.isCanceled) {
            synchronized (this.downloadManager) {
                try {
                    this.isCanceled = true;
                    this.downloadManager.a();
                    this.mGLMapEngine.setMapLoaderToTask(this.mEngineID, this.mDataRequestParam.handler, null);
                } catch (Throwable th) {
                    rx.c(th, "AMapLoader", "doCancel");
                }
            }
        }
    }

    private String getEncodeRequestParams(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getDeviceId(Context context) {
        if (context != null) {
            return rd.v(context);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public String getRequestParams(String str, boolean z, int i) {
        if (mDiu == null) {
            mDiu = getDeviceId(this.mGLMapEngine.getContext());
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        if (z) {
            stringBuffer.append("&channel=amap7&div=GNaviMap");
            stringBuffer.append("&diu=");
            stringBuffer.append(mDiu);
        } else {
            stringBuffer.append("&channel=amapapi");
            stringBuffer.append("&div=GNaviMap");
            stringBuffer.append("&diu=");
            stringBuffer.append(mDiu);
        }
        return stringBuffer.toString();
    }

    private String generateQueryString(Context context, String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        String f = qy.f(this.mGLMapEngine.getContext());
        stringBuffer.append("&key=");
        stringBuffer.append(f);
        String sortReEncoderParams = sortReEncoderParams(stringBuffer.toString());
        String a = rb.a();
        stringBuffer.append("&ts=" + a);
        stringBuffer.append("&scode=" + rb.a(context, a, sortReEncoderParams));
        return stringBuffer.toString();
    }

    private String sortReEncoderParams(String str) {
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(strReEncoder(str2));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2.length() > 1) {
            return (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
        }
        return str;
    }

    private String strReEncoder(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            rx.c(e, "AbstractProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e2) {
            rx.c(e2, "AbstractProtocalHandler", "strReEncoderException");
            return "";
        }
    }
}
