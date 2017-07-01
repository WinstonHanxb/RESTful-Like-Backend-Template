package com.bupt.dao;

import com.bupt.entity.SysUser;

import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface SysUserDao extends Mapper<SysUser> {

    /**
     * 根据姓名查询用户信息
     * @param userName
     * @return SysUser
     */
    @Select("select id,user_name as userName,password from sys_user where user_name=#{userName}")
    public SysUser getUserByName(String userName);
}