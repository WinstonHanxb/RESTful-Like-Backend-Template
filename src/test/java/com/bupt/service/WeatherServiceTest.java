package com.bupt.service;

import org.dom4j.DocumentException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by 韩宪斌 on 2017/7/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"/spring.xml"})
public class WeatherServiceTest {
    
    private static Logger logger = LoggerFactory.getLogger(SysUserServiceTest.class);
    @Resource
    private WeatherService weatherService;
    
    @Test
    public void listCityByCountry() throws DocumentException {
        System.out.println(weatherService.listCityByCountry("China"));
        System.out.println(weatherService.listCityByCountry("japan"));
        System.out.println(weatherService.listCityByCountry("asd323423"));
    }
    
}
