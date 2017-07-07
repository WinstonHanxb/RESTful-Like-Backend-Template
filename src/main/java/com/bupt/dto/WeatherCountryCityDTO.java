package com.bupt.dto;

/**
 * Created by 韩宪斌 on 2017/7/6.
 */
public class WeatherCountryCityDTO {
    private String countryName;
    private String cityName;
   
    
    public String getCountryName() {
        return countryName;
    }
    
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    
    public String getCityName() {
        return cityName;
    }
    
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    
    public WeatherCountryCityDTO(String countryName, String cityName) {
        this.countryName = countryName;
        this.cityName = cityName;
    }
    
    public WeatherCountryCityDTO() {
    }
}
