package com.example.springboot.controller;

import com.example.springboot.bean.Result;
import com.example.springboot.bean.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService;


@PostMapping ("/regist")
    public Result regist(User user){



        return userService.regist(user);
    }

    @PostMapping  (value = "/login")
    public Result login(User user){
        return userService.login(user);
    }



}

