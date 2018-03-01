package com.example.wb.spinnerdemo;

/**
 * Created by wb on 2017/2/25.
 */

public class City {
    String province,city;
    City(String provinceName, String cityName){
        province = provinceName;
        city = cityName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
