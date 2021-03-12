package com.amap.api.navi.model;

import java.util.List;

public class IndependInfo {
    private int count = 0;
    private List<Integer> endLinkIndex = null;
    private List<Integer> endStepIndex = null;
    private long pathid = 0;
    private List<Integer> startLinkIndex = null;
    private List<Integer> startStepIndex = null;

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public long getPathid() {
        return this.pathid;
    }

    public void setPathid(long j) {
        this.pathid = j;
    }

    public List<Integer> getStartStepIndex() {
        return this.startStepIndex;
    }

    public void setStartStepIndex(List<Integer> list) {
        this.startStepIndex = list;
    }

    public List<Integer> getStartLinkIndex() {
        return this.startLinkIndex;
    }

    public void setStartLinkIndex(List<Integer> list) {
        this.startLinkIndex = list;
    }

    public List<Integer> getEndStepIndex() {
        return this.endStepIndex;
    }

    public void setEndStepIndex(List<Integer> list) {
        this.endStepIndex = list;
    }

    public List<Integer> getEndLinkIndex() {
        return this.endLinkIndex;
    }

    public void setEndLinkIndex(List<Integer> list) {
        this.endLinkIndex = list;
    }
}
