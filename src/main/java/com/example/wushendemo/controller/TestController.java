package com.example.wushendemo.controller;

import com.example.wushendemo.domain.User;
import com.example.wushendemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wushen
 * @date: 2021/7/9 下午11:29
 * @description:
 */
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String sayHello(String name){
        return "hello ward:"+name;
    }


    @RequestMapping("/listone")
    @ResponseBody
    public User listOne(String username){
        return userService.findByUsername(username);
    }
}
