package com.bupt.service.impl;

import com.bupt.dao.ResWeatherCountryCityDao;
import com.bupt.dto.WeatherCountryCityDTO;
import com.bupt.entity.ResWeatherCountryCity;
import com.bupt.service.WeatherService;
import com.bupt.webservice.weather.GlobalWeather;
import com.bupt.webservice.weather.GlobalWeatherSoap;
import org.dom4j.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;


/**
 * Created by 韩宪斌 on 2017/7/6.
 * 远程天气WebService相关操作
 */
@Service("weatherService")
public class WeatherServiceImpl implements WeatherService {
    
    private static GlobalWeather WEATHER_SERVICE = new GlobalWeather();
    @Resource
    private ResWeatherCountryCityDao resWeatherCountryCityDao;
    
    @Override
    @Transactional
    public List<WeatherCountryCityDTO> listCityByCountry(String country){
        List<WeatherCountryCityDTO> DTOList = new ArrayList<>();
        List<ResWeatherCountryCity> DaoList = resWeatherCountryCityDao.listCityByCountry(country);
        if (DaoList.size()==0 || checkTimeLimits(DaoList.get(0),5)) {
            Set<WeatherCountryCityDTO> xmlSet = remoteListCityByCountry(country);
            DTOList.addAll(xmlSet);
            this.insertList(DTOList);
            return DTOList;
        }
        Iterator<ResWeatherCountryCity> DaoIte = DaoList.iterator();
        while (DaoIte.hasNext()) {
            DTOList.add(this.convertToDTO(DaoIte.next()));
        }
        return DTOList;
    }
    
    /**
     * 将远程获取的数据插入数据库
     * @param DTOList
     */
    private void insertList(List<WeatherCountryCityDTO> DTOList){
        Iterator<WeatherCountryCityDTO> DTOIte=DTOList.iterator();
        List<ResWeatherCountryCity> DaoList=new ArrayList<>();
        while(DTOIte.hasNext()){
            resWeatherCountryCityDao.replaceSelective(this.convertToDO(DTOIte.next()));
        }
    }
    
    
    /**
     * 检查是否超过时间限制
     * 超过minutes则返回true
     * @param testObj
     * @param minutes
     * @return
     */
    private boolean checkTimeLimits(ResWeatherCountryCity testObj,long minutes) {
        return Math.abs(((new Date().getTime() - testObj.getGmtModified().getTime()) / (60 * 1000))) >= minutes;
    }
    
    
    /**
     * 通过Webservice获取数据
     *
     * @param country
     * @return
     */
    private Set<WeatherCountryCityDTO> remoteListCityByCountry(String country) {
        GlobalWeatherSoap port = WEATHER_SERVICE.getGlobalWeatherSoap();
        try {
            Document XMLDoc = DocumentHelper.parseText(port.getCitiesByCountry(country));
            return this.XMLMapper(XMLDoc);
        } catch (DocumentException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    /**
     * 遍历XML文件
     *
     * @param XMLDoc
     * @return
     */
    public Set<WeatherCountryCityDTO> XMLMapper(Document XMLDoc) {
        Set<WeatherCountryCityDTO> xmlSet = new HashSet<>();
        Element rootNode = XMLDoc.getRootElement();
        Iterator<Element> rootIte = rootNode.elementIterator();
        while (rootIte.hasNext()) {
            Element nextElement = rootIte.next();
            if (nextElement.element("City").getText().indexOf("/") >= 0) {
                String[] cityArr = nextElement.element("City").getTextTrim().split("/ ");
                for (String cityString : cityArr) {
                    xmlSet.add(new WeatherCountryCityDTO(nextElement.element("Country").getTextTrim(), cityString));
                }
            } else {
                xmlSet.add(new WeatherCountryCityDTO(nextElement.element("Country").getTextTrim(), nextElement.element
                        ("City").getTextTrim()));
            }
        }
        return xmlSet;
    }
    
    
    private ResWeatherCountryCity convertToDO(WeatherCountryCityDTO weatherCountryCityDTO) {
        if (weatherCountryCityDTO == null) {
            return null;
        }
        ResWeatherCountryCity resWeatherCountryCity = new ResWeatherCountryCity();
        BeanUtils.copyProperties(weatherCountryCityDTO, resWeatherCountryCity);
        return resWeatherCountryCity;
    }
    
    private WeatherCountryCityDTO convertToDTO(ResWeatherCountryCity resWeatherCountryCity) {
        if (resWeatherCountryCity == null) {
            return null;
        }
        WeatherCountryCityDTO weatherCountryCityDTO = new WeatherCountryCityDTO();
        BeanUtils.copyProperties(resWeatherCountryCity, weatherCountryCityDTO);
        return weatherCountryCityDTO;
    }
}
