package com.bupt.controller;

import com.bupt.dto.WeatherCountryCityDTO;
import com.bupt.service.WeatherService;
import com.bupt.util.exception.controller.input.NullArgumentException;
import com.bupt.util.exception.controller.result.NoneGetException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 韩宪斌 on 2017/7/7.
 */
@RestController
@Api(tags = "Weather", description = "天气信息接口")
@RequestMapping("/weathers")
public class WeatherController {
    @Resource
    private WeatherService weatherService;
    
    @ApiOperation(value = "根据国家名称获取所需的城市名称")
    @RequestMapping(value = "/cities/{countryName}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<WeatherCountryCityDTO> listCityByCountry(@PathVariable String countryName){
        if(countryName==null){
            throw new NullArgumentException("systemName");
        }
        List<WeatherCountryCityDTO> listDTO= weatherService.listCityByCountry(countryName);
        if(listDTO.size()==0){
            throw new NoneGetException();
        }
        return listDTO;
    }
}
