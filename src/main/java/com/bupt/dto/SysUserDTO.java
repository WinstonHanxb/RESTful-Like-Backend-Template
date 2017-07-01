package com.bupt.dto;


/**
 * Created by 韩宪斌 on 2017/6/28.
 */
public class SysUserDTO {
    private String userName;
    private String password;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SysUserDTO{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
