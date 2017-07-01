package com.bupt.service;

import com.bupt.dto.SysUserDTO;
import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by 韩宪斌 on 2017/6/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class SysUserServiceTest {

    private static Logger logger = LoggerFactory.getLogger(SysUserServiceTest.class);
    @Resource
    private SysUserService sysUserService;


    @Test
    public void getUserInfoTest(){

    }

    @Test
    public void updateUserTest(){

    }

    @Test
    public void listUserTest(){

    }



}
