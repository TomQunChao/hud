package com.alibaba.idst.nls.internal.utils;

public class Location {
    String city;
    String country;
    String county;
    String latitude;
    String longitude;
    String province;
    String street;

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

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String getCounty() {
        return this.county;
    }

    public void setCounty(String str) {
        this.county = str;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String str) {
        this.street = str;
    }

    public String getLocationInfo() {
        return "   \"longitude\": \"" + this.longitude + "\",   \"latitude\": \"" + this.latitude + "\",   \"geo\": {       \"level1\": \"" + this.country + "\",       \"level2\": \"" + this.province + "\",       \"level3\": \"" + this.city + "\",       \"level4\": \"" + this.county + "\",       \"level5\": \"" + this.street + "\"   }";
    }
}
