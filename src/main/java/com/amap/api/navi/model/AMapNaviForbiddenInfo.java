package com.amap.api.navi.model;

import com.autonavi.ae.route.model.ForbiddenLineInfo;
import java.util.LinkedList;

public class AMapNaviForbiddenInfo {
    public String carType;
    public String carTypeDesc;
    private LinkedList<String> carTypes = new LinkedList<>();
    public String forbiddenTime;
    public int forbiddenType;
    public double latitude;
    public int linkIndex;
    public double longitude;
    public String nextRoadName;
    public long pathId;
    public String roadName;
    public int segIndex;

    public AMapNaviForbiddenInfo() {
    }

    public AMapNaviForbiddenInfo(ForbiddenLineInfo forbiddenLineInfo) {
        try {
            this.pathId = forbiddenLineInfo.pathId;
            this.forbiddenType = forbiddenLineInfo.forbiddenType;
            String stringBuffer = new StringBuffer(Integer.toBinaryString(forbiddenLineInfo.carType)).reverse().toString();
            StringBuilder sb = new StringBuilder(stringBuffer);
            int length = 8 - stringBuffer.length();
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    sb.append("0");
                }
            }
            this.carType = sb.toString();
            this.forbiddenTime = forbiddenLineInfo.forbiddenTime;
            this.latitude = forbiddenLineInfo.latitude;
            this.longitude = forbiddenLineInfo.longitude;
            this.roadName = forbiddenLineInfo.roadName;
            this.nextRoadName = forbiddenLineInfo.nextRoadName;
            this.segIndex = forbiddenLineInfo.segIndex;
            this.linkIndex = forbiddenLineInfo.linkIndex;
            this.carTypes.add("全部车型");
            this.carTypes.add("小车");
            this.carTypes.add("微型货车");
            this.carTypes.add("轻型货车");
            this.carTypes.add("中型货车");
            this.carTypes.add("重型货车");
            this.carTypes.add("拖挂");
            this.carTypes.add("保留");
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i2 = 0; i2 < stringBuffer.length(); i2++) {
                if (stringBuffer.charAt(i2) - '0' == 1) {
                    stringBuffer2.append(this.carTypes.get(i2) + "、");
                }
            }
            if (stringBuffer2.length() > 0) {
                this.carTypeDesc = stringBuffer2.substring(0, stringBuffer2.length() - 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
