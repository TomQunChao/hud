package com.alibaba.idst.nls.internal.protocol;

import android.content.Context;
import android.os.Build;
import com.alibaba.idst.nls.internal.common.DeviceId;
import com.alibaba.idst.nls.internal.common.PhoneInfo;
import java.util.Locale;
import java.util.TimeZone;

public class NlsRequestProto {
    public static final String VERSION10 = "1.0";
    public static final String VERSION20 = "2.0";
    public static final String VERSION30 = "3.0";
    public static final String VERSION40 = "4.0";
    private String app_id = null;
    private String app_user_id = null;
    private String app_version = null;
    Build bd = new Build();
    Context context;
    private String device_brand;
    private String device_id;
    private String device_imei;
    private String device_mac;
    private String device_model;
    private String device_system_locale;
    private String device_timezone;
    private String device_type;
    private String device_uuid;
    Locale locale;
    private String network_type;
    private String os_type;
    private String os_version;
    private String service_id;
    private String service_version;

    public NlsRequestProto() {
    }

    public NlsRequestProto(Context context2) {
        this.context = context2;
        initProto(this.context);
    }

    private void initProto(Context context2) {
        this.locale = context2.getResources().getConfiguration().locale;
        Build build = this.bd;
        this.device_type = Build.TYPE;
        this.device_system_locale = this.locale.getLanguage();
        this.device_timezone = TimeZone.getDefault().getID();
        this.device_uuid = DeviceId.getDeviceId(context2);
        this.device_id = DeviceId.getDeviceId(context2);
        this.device_imei = DeviceId.getIMEI(context2);
        this.device_mac = DeviceId.getMacId(context2);
        Build build2 = this.bd;
        this.device_brand = Build.BRAND;
        Build build3 = this.bd;
        this.device_model = Build.MODEL;
        Build build4 = this.bd;
        this.os_type = Build.DISPLAY;
        this.os_version = Build.VERSION.RELEASE;
        this.network_type = PhoneInfo.getCurrentNetType(context2);
    }

    public String getApp_user_id() {
        return this.app_user_id;
    }

    public String getApp_version() {
        return this.app_version;
    }

    public void setApp_id(String str) {
        this.app_id = str;
    }

    public void setApp_user_id(String str) {
        this.app_user_id = str;
    }

    public void setApp_version(String str) {
        this.app_version = str;
    }

    public void setDevice_type(String str) {
        this.device_type = str;
    }

    public void setDevice_system_locale(String str) {
        this.device_system_locale = str;
    }

    public void setDevice_timezone(String str) {
        this.device_timezone = str;
    }

    public String getApp_id() {
        return this.app_id;
    }

    public String getService_id() {
        return this.service_id;
    }

    public void setService_id(String str) {
        this.service_id = str;
    }

    public String getService_version() {
        return this.service_version;
    }

    public void setService_version(String str) {
        this.service_version = str;
    }

    public String getDevice_type() {
        return this.device_type;
    }

    public String getDevice_system_locale() {
        return this.device_system_locale;
    }

    public String getDevice_timezone() {
        return this.device_timezone;
    }

    public String getDevice_uuid() {
        return this.device_uuid;
    }

    public String getDevice_imei() {
        return this.device_imei;
    }

    public String getDevice_mac() {
        return this.device_mac;
    }

    public String getDevice_brand() {
        return this.device_brand;
    }

    public String getDevice_model() {
        return this.device_model;
    }

    public String getOs_type() {
        return this.os_type;
    }

    public String getOs_version() {
        return this.os_version;
    }

    public String getNetwork_type() {
        return this.network_type;
    }

    public String getDevice_id() {
        return this.device_id;
    }

    public void setDevice_id(String str) {
        this.device_id = str;
    }
}
