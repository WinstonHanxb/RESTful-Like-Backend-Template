package com.bupt.controller;

import com.bupt.dto.EquipCoordinateDTO;
import com.bupt.service.EquipCoordinateService;
import com.bupt.util.exception.controller.input.NullArgumentException;
import com.bupt.util.exception.controller.result.NoneGetException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    private EquipCoordinateService equipCoordinateService;

    @ApiOperation(value = "根据系统名称获取设备坐标信息")
    @RequestMapping(value = "/coordinates/{systemName}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<EquipCoordinateDTO> listEquipCoordinatesBySystemName(@PathVariable  String systemName){
        if(systemName==null){
            throw new NullArgumentException("systemName");
        }
        List<EquipCoordinateDTO> listDTO= equipCoordinateService.listEquipCoordinateBySystemName(systemName);
        if(listDTO.size()==0){
            throw new NoneGetException();
        }
        return listDTO;
    }
}
