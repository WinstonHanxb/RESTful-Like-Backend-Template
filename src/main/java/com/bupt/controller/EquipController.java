package com.bupt.controller;

import com.bupt.dto.EquipCordinateDTO;
import com.bupt.service.EquipCordinateService;
import com.bupt.util.exception.controller.input.NullArgumentException;
import com.bupt.util.exception.controller.result.NoneGetException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 韩宪斌 on 2017/7/3.
 */
@RestController
@Api(tags = "Equip", description = "设备相关操作")
@RequestMapping("/equips")
public class EquipController {
    @Resource
    private EquipCordinateService equipCordinateService;

    @ApiOperation(value = "根据系统名称获取设备坐标信息")
    @RequestMapping(value = "/cordinates/{systemName}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<EquipCordinateDTO> listEquipCordinatesBySystemName(String systemName){
        if(systemName==null){
            throw new NullArgumentException("systemName");
        }
        List<EquipCordinateDTO> listDTO=equipCordinateService.listEquipCordinateBySystemName(systemName);
        if(listDTO==null){
            throw new NoneGetException();
        }
        return listDTO;
    }
}
