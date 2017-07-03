package com.bupt.service;

import com.bupt.dto.SysUserDTO;
import com.bupt.entity.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  韩宪斌 on 2017/6/27.
 * 用户
 */

public interface SysUserService {
    /**
     * 获取所有用户
     * @return List<SysUserDTO>
     */
    List<SysUserDTO> listUser();

    /**
     * 获取用户
     *
     * @param userName
     * @return List<String>
     */
    SysUserDTO getUserByUserName(String userName);



    /**
     * 插入新用户
     *
     * @param sysUserDTO
     * @return boolean
     */
    boolean saveUser(SysUserDTO sysUserDTO);

    /**
     * 删除指定id的用户
     * @param id
     * @return boolean
     */
    boolean removeUser(Long id);

    /**
     * 更改用户
     *
     * @param sysUserDTO
     * @return boolean
     */
    boolean updateUser(SysUserDTO sysUserDTO);


}
