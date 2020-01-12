package com.iotat.infoscreen.controller;

import com.iotat.infoscreen.common.result.ResponseEnum;
import com.iotat.infoscreen.common.result.ResponseJSON;
import com.iotat.infoscreen.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description 用户接口
 * @ClassName UserController
 * @Author Jean
 * @date 2020.01.08 10:52
 */
@RestController
@Api(tags = "用户接口")
@RequestMapping(value = "/iotat")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation("注册")
    @PostMapping("/visitorRegister")
    public ResponseJSON<Boolean> register(
            @RequestParam("userName") String userName,
            @RequestParam("password") String password) {
        return new ResponseJSON<>(userService.register(userName, password), ResponseEnum.REGISTER_SUCCESS);
    }

    @ApiOperation("登录")
    @PostMapping("/login")
    public ResponseJSON<Map<String, Object>> login(
            @RequestParam("userName") String userName,
            @RequestParam("password") String password) {
        return new ResponseJSON<>(userService.login(userName, password), ResponseEnum.LOGIN_SUCCESS);
    }

    //@Token TODO Token测试留至最后
    @ApiOperation("修改密码")
    @PostMapping("/passwordUpdate")
    public ResponseJSON<Boolean> updatePassword(
            @RequestParam("password") String password,
            @RequestParam("newPassword") String newPassword,
            @RequestParam("userName") String userName) {
        return new ResponseJSON<>(userService.passwordUpdate(newPassword, userName, password), ResponseEnum.SUCCESS_OPTION);
    }
}
