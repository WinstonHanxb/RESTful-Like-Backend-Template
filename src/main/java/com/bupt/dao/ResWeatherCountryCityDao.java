package com.bupt.dao;


import com.bupt.entity.ResWeatherCountryCity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


import java.util.List;

/**
 * Created by 韩宪斌 on 2017/7/7.
 *
 */
@Repository
public interface ResWeatherCountryCityDao extends Mapper<ResWeatherCountryCity>{
    @Select("SELECT country_name as countryName,city_name as cityName,gmt_create as gmtCreate,gmt_modified as " +
            "gmtModified FROM  " +
            "res_weather_country_city where country_name like #{country} ORDER BY gmt_modified")
    List<ResWeatherCountryCity> listCityByCountry(String country);
    
    @Insert("Replace into res_weather_country_city(country_name,city_name) Values(#{countryName},#{cityName})")
    int replaceSelective(ResWeatherCountryCity resWeatherCountryCity);
}
