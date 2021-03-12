package com.alibaba.idst.nls.internal.protocol;

public class NlsResponse {
    public static final String FAIL = "0";
    public static final String SUCCESS = "1";
    private String[] NBestCM;
    private String[] NBestRS;
    private String asrId;
    private String asr_ret;
    private String asr_ret_unc;
    private Boolean bstream_attached = false;
    private String ds_ret;
    private String finish = "0";
    private String finishType;
    private String id;
    private String nlp_ret;
    private String ret;
    private String status = "1";
    private String uid;
    private String version = NlsRequestProto.VERSION40;

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getFinish() {
        return this.finish;
    }

    public void setFinish(String str) {
        this.finish = str;
    }

    public String getFinishType() {
        return this.finishType;
    }

    public void setFinishType(String str) {
        this.finishType = str;
    }

    public String getAsr_ret() {
        return this.asr_ret;
    }

    public void setAsr_ret(String str) {
        this.asr_ret = str;
    }

    public void setAsr_ret_unc(String str) {
        this.asr_ret_unc = str;
    }

    public String getNlp_ret() {
        return this.nlp_ret;
    }

    public void setNlp_ret(String str) {
        this.nlp_ret = str;
    }

    public String getRet() {
        return this.ret;
    }

    public void setRet(String str) {
        this.ret = str;
    }

    public String getAsrId() {
        return this.asrId;
    }

    public void setAsrId(String str) {
        this.asrId = str;
    }

    public String[] getNBestCM() {
        return this.NBestCM;
    }

    public void setNBestCM(String[] strArr) {
        this.NBestCM = strArr;
    }

    public String[] getNBestRS() {
        return this.NBestRS;
    }

    public void setNBestRS(String[] strArr) {
        this.NBestRS = strArr;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String getDs_ret() {
        return this.ds_ret;
    }

    public void setDs_ret(String str) {
        this.ds_ret = str;
    }
}
