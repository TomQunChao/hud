package com.alibaba.idst.nls.internal.protocol;

public class NlsRequestContext {
    public ApplicationData application = new ApplicationData();
    public NlsRequestAuth auth = null;
    public Debug debug = new Debug();
    public DeviceInfo device = new DeviceInfo();
    public LocationInfo location = new LocationInfo();
    public SdkInfo sdk = new SdkInfo();

    public static class Debug {
        public boolean GDS_AllResultCode;
    }

    public static class LocationInfo {
        public GeoInfo geo = new GeoInfo();
        public String latitude;
        public String longitude;

        public static class GeoInfo {
            public String level1;
            public String level2;
            public String level3;
            public String level4;
            public String level5;
        }

        public String getLongitude() {
            return this.longitude;
        }

        public void setLongitude(String str) {
            this.longitude = str;
        }

        public String getLatitude() {
            return this.latitude;
        }

        public void setLatitude(String str) {
            this.latitude = str;
        }

        public GeoInfo getGeo() {
            return this.geo;
        }

        public void setGeo(GeoInfo geoInfo) {
            this.geo = geoInfo;
        }
    }

    public static class DeviceInfo {
        public String device_brand = null;
        public String device_id = null;
        public String device_imei = null;
        public String device_mac = null;
        public String device_model = null;
        public String device_type = null;
        public String device_uuid = null;
        public String network_type = null;
        public String os_type = null;
        public String os_version = null;
        public String system_locale = null;
        public String timezone = null;

        public String getDevice_type() {
            return this.device_type;
        }

        public void setDevice_type(String str) {
            this.device_type = str;
        }

        public String getDevice_uuid() {
            return this.device_uuid;
        }

        public void setDevice_uuid(String str) {
            this.device_uuid = str;
        }

        public String getDevice_imei() {
            return this.device_imei;
        }

        public void setDevice_imei(String str) {
            this.device_imei = str;
        }

        public String getDevice_mac() {
            return this.device_mac;
        }

        public void setDevice_mac(String str) {
            this.device_mac = str;
        }

        public String getDevice_brand() {
            return this.device_brand;
        }

        public void setDevice_brand(String str) {
            this.device_brand = str;
        }

        public String getDevice_model() {
            return this.device_model;
        }

        public void setDevice_model(String str) {
            this.device_model = str;
        }

        public String getOs_type() {
            return this.os_type;
        }

        public void setOs_type(String str) {
            this.os_type = str;
        }

        public String getOs_version() {
            return this.os_version;
        }

        public void setOs_version(String str) {
            this.os_version = str;
        }

        public String getNetwork_type() {
            return this.network_type;
        }

        public void setNetwork_type(String str) {
            this.network_type = str;
        }

        public String getSystem_locale() {
            return this.system_locale;
        }

        public void setSystem_locale(String str) {
            this.system_locale = str;
        }

        public String getTimezone() {
            return this.timezone;
        }

        public void setTimezone(String str) {
            this.timezone = str;
        }

        public String getDevice_id() {
            return this.device_id;
        }

        public void setDevice_id(String str) {
            this.device_id = str;
        }
    }

    public static class SdkInfo {
        public String sdk_type = "android";
        public String version = "1.7.1-gds-android";

        public String getVersion() {
            return this.version;
        }

        public void setVersion(String str) {
            this.version = str;
        }

        public String getSdk_type() {
            return this.sdk_type;
        }

        public void setSdk_type(String str) {
            this.sdk_type = str;
        }
    }

    public NlsRequestAuth getAuth() {
        return this.auth;
    }

    public void setAuth(NlsRequestAuth nlsRequestAuth) {
        this.auth = nlsRequestAuth;
    }

    public LocationInfo getLocation() {
        return this.location;
    }

    public void setLocation(LocationInfo locationInfo) {
        this.location = locationInfo;
    }

    public SdkInfo getSdk() {
        return this.sdk;
    }

    public void setSdk(SdkInfo sdkInfo) {
        this.sdk = sdkInfo;
    }

    public DeviceInfo getDevice() {
        return this.device;
    }

    public void setDevice(DeviceInfo deviceInfo) {
        this.device = deviceInfo;
    }

    public ApplicationData getApplication() {
        return this.application;
    }

    public void setApplication(ApplicationData applicationData) {
        this.application = applicationData;
    }

    public Debug getDebug() {
        return this.debug;
    }

    public void setDebug(Debug debug2) {
        this.debug = debug2;
    }

    public static class ApplicationData {
        public String application_id;
        public String service_id;
        public String service_version;
        public String user_id;
        public String version = NlsRequestProto.VERSION30;

        public String getApplication_id() {
            return this.application_id;
        }

        public void setApplication_id(String str) {
            this.application_id = str;
        }

        public String getUser_id() {
            return this.user_id;
        }

        public void setUser_id(String str) {
            this.user_id = str;
        }

        public String getVersion() {
            return this.version;
        }

        public void setVersion(String str) {
            this.version = str;
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
    }
}
