package com.amap.api.navi.model;

public class AMapCalcRouteResult {
    private int calcRouteType = 0;
    private int errorCode = 0;
    private String errorDetail = "";
    private int[] routeId;

    public AMapCalcRouteResult(int i) {
        this.errorCode = i;
    }

    public AMapCalcRouteResult() {
    }

    public String getErrorDetail() {
        return this.errorDetail;
    }

    public void setErrorDetail(String str) {
        this.errorDetail = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public int getCalcRouteType() {
        return this.calcRouteType;
    }

    public void setCalcRouteType(int i) {
        this.calcRouteType = i;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public int[] getRouteid() {
        return this.routeId;
    }

    public void setRouteid(int[] iArr) {
        this.routeId = iArr;
    }
}
