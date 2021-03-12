package com.alibaba.idst.nls.internal.protocol.GdsContent;

import com.alibaba.idst.nls.internal.protocol.Content;
import com.amap.api.col.stln3.i;

public class GdsContent extends Content {
    @i(b = "asr_score")
    private String asrScore = null;
    @i(b = "conversation_id")
    private String conversationId = null;
    private String optional = null;
    private GdsContentPrior prior = null;
    @i(b = "query_type")
    private String queryType = null;
    private String text = "";
    @i(b = "turn_id")
    private int turnId;
    @i(b = "use_asr_result")
    private boolean useAsrResult = true;
    @i(b = "web_session")
    private String webSession = null;

    public GdsContentPrior getPrior() {
        return this.prior;
    }

    public String getOptional() {
        return this.optional;
    }

    public void setPrior(GdsContentPrior gdsContentPrior) {
        this.prior = gdsContentPrior;
    }

    public void setOptional(String str) {
        this.optional = str;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public void setConversationId(String str) {
        this.conversationId = str;
    }

    public void setConversation_id(String str) {
        this.conversationId = str;
    }

    public int getTurnId() {
        return this.turnId;
    }

    public void setTurnId(int i) {
        this.turnId = i;
    }

    public void setTurn_id(int i) {
        this.turnId = i;
    }

    public String getWebSession() {
        return this.webSession;
    }

    public void setWebSession(String str) {
        this.webSession = str;
    }

    public void setWeb_session(String str) {
        this.webSession = str;
    }

    public String getAsrScore() {
        return this.asrScore;
    }

    public void setAsrScore(String str) {
        this.asrScore = str;
    }

    public void setAsr_score(String str) {
        this.asrScore = str;
    }

    public boolean isUseAsrResult() {
        return this.useAsrResult;
    }

    public void setUseAsrResult(boolean z) {
        this.useAsrResult = z;
    }

    public String getQueryType() {
        return this.queryType;
    }

    public void setQueryType(String str) {
        this.queryType = str;
    }

    public void setQuery_type(String str) {
        this.queryType = str;
    }
}
