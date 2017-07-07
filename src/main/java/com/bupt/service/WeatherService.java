package com.bupt.service;

import com.bupt.dto.WeatherCountryCityDTO;
import org.dom4j.DocumentException;

import java.util.List;

/**
 *
 * Created by 韩宪斌 on 2017/7/6.
 */
public interface WeatherService {
    
    /**
     * 根据国家名称获取城市
     * @return
     */
    List<WeatherCountryCityDTO> listCityByCountry(String country);
}
