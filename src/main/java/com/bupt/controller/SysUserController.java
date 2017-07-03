package com.bupt.controller;

import com.bupt.dto.SysUserDTO;
import com.bupt.service.SysUserService;;
import com.bupt.util.exception.controller.input.NullArgumentException;
import com.bupt.util.exception.controller.result.NoneGetException;
import com.bupt.util.exception.controller.result.NoneRemoveException;
import com.bupt.util.exception.controller.result.NoneSaveException;
import com.bupt.util.exception.controller.result.NoneUpdateException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.List;


/**
 * Created by 韩宪斌 on 2017/6/19.
 * 对用户操作
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Api(tags = "User", description = "用户相关操作")
@RequestMapping(value = "/users")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    @ApiOperation(value = "查询全部用户信息")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<SysUserDTO> listUser() {
        List<SysUserDTO> listSysUserDTO = sysUserService.listUser();
        if (listSysUserDTO.size()==0) {
            throw new NoneGetException();
        }
        return listSysUserDTO;
    }

    @ApiOperation(value = "根据用户名获取用户")
    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public SysUserDTO getUser(@PathVariable String userName) {
        SysUserDTO sysUserDTO = sysUserService.getUserByUserName(userName);
        if (sysUserDTO == null) {
            throw new NoneGetException();
        }
        return sysUserDTO;
    }

    @ApiOperation(value = "創建新用戶，忽略id")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public SysUserDTO saveUser(@RequestBody SysUserDTO sysUserDTO) {
        sysUserDTO.setId(null);
        this.checkSysUserDTO(sysUserDTO);
        if (!this.sysUserService.saveUser(sysUserDTO)) {
            throw new NoneSaveException();
        }
        return this.sysUserService.getUserByUserName(sysUserDTO.getUserName());
    }

    @ApiOperation(value = "更新用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.CREATED)
    public SysUserDTO updateUser(@PathVariable Long id, @RequestBody SysUserDTO sysUserDTO) {
        sysUserDTO.setId(id);
        this.checkSysUserDTO(sysUserDTO);
        if (!this.sysUserService.updateUser(sysUserDTO)) {
            throw new NoneUpdateException();
        }
        return sysUserDTO;
    }

    @ApiOperation(value = "删除指定id的用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUser(@PathVariable Long id) {
        if (!this.sysUserService.removeUser(id)) {
            throw new NoneRemoveException();
        }
    }

    private void checkSysUserDTO(SysUserDTO sysUserDTO) {
        if (sysUserDTO.getUserName() == null) {
            throw new NullArgumentException("userName");
        }
        if (sysUserDTO.getPassword() == null) {
            throw new NullArgumentException("password");
        }
    }


}
