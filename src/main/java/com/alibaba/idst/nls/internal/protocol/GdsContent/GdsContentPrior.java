package com.alibaba.idst.nls.internal.protocol.GdsContent;

public class GdsContentPrior {
    private String domain;
    private String intent;
    private PriorQud qud;

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public String getIntent() {
        return this.intent;
    }

    public void setIntent(String str) {
        this.intent = str;
    }

    public PriorQud getQud() {
        return this.qud;
    }

    public void setQud(PriorQud priorQud) {
        this.qud = priorQud;
    }
}
