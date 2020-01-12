package com.iotat.infoscreen.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Description 用户接口逻辑
 * @ClassName UserService
 * @Author Jean
 * @date 2020.01.08 15:02
 */
@Service
public class UserService {

    /**
     * 登录
     *
     * @param userName
     * @param password
     * @return 包含用户信息和token认证的map
     */
    public Map<String, Object> login(String userName, String password) {
        return null;
    }

    /**
     * 密码修改
     *
     * @param newPassword
     * @param userName
     * @param password
     * @return 修改成功返回1
     */
    public Boolean passwordUpdate(String newPassword, String userName, String password) {
        return null;
    }

    /**
     * 用户注册
     *
     * @param userName
     * @param password
     * @return 注册成功返回true
     */
    public Boolean register(String userName, String password) {
        return null;
    }

}
