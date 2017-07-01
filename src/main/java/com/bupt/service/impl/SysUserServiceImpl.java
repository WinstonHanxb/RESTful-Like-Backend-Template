package com.bupt.service.impl;

import com.bupt.dao.SysUserDao;
import com.bupt.dto.SysUserDTO;
import com.bupt.entity.SysUser;
import com.bupt.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 韩宪斌 on 2017/6/19.
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    @Override
    public List<SysUserDTO> listUser() {
        List<SysUser> listSysUser = this.sysUserDao.selectAll();
        List<SysUserDTO> listSysUserDTO = new ArrayList<SysUserDTO>();
        Iterator<SysUser> sysUserIterator = listSysUser.iterator();
        while (sysUserIterator.hasNext()) {
            listSysUserDTO.add(this.convertToDTO(sysUserIterator.next()));
        }
        return listSysUserDTO;
    }

    @Override
    public SysUserDTO getUserByUserName(String userName) {
        SysUser sysUser = this.sysUserDao.getUserByName(userName);
        return this.convertToDTO(sysUser);
    }

    @Override
    public boolean saveUser(SysUserDTO sysUserDTO) {
        SysUser sysUser = this.convertToDO(sysUserDTO);
        if (this.sysUserDao.insertSelective(sysUser) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean removeUser(Long id) {
        if (this.sysUserDao.deleteByPrimaryKey(id) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(SysUserDTO sysUserDTO) {
        SysUser sysUser = convertToDO(sysUserDTO);
        if (this.sysUserDao.updateByPrimaryKeySelective(sysUser) > 0) {
            return true;
        }
        return false;
    }

    private SysUser convertToDO(SysUserDTO sysUserDTO) {
        if (sysUserDTO == null) {
            return null;
        }
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserDTO, sysUser);
        return sysUser;
    }

    private SysUserDTO convertToDTO(SysUser sysUser) {
        if (sysUser == null) {
            return null;
        }
        SysUserDTO sysUserDTO = new SysUserDTO();
        BeanUtils.copyProperties(sysUser, sysUserDTO);
        return sysUserDTO;
    }

}
