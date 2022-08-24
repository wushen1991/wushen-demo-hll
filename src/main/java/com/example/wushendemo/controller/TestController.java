package com.example.wushendemo.controller;

import com.example.wushendemo.domain.User;
import com.example.wushendemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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


    @RequestMapping("/updateUser")
    @ResponseBody
    public User updateOne(String username,String passward,Integer id){
        User u =new User();
        u.setId(id);
        u.setUsername(username);
        u.setPassword(passward);
        userService.updateUser(u);
        return u;
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public User insertUser(String username,String passward){
        User u =new User();
        u.setNumber(11);
        u.setUsername(username);
        u.setPassword(passward);
        userService.insertUser(u);
        return u;
    }
    @RequestMapping("/insertUserOne")
    @ResponseBody
    public User insertOne(String username,String passward){
        User u =new User();
        u.setNumber(11);
        u.setUsername(username);
        u.setPassword(passward);
        userService.insertUserOne(u);
        return u;
    }


    @RequestMapping("/insertUserTwo")
    @ResponseBody
    public User insertTwo(String username,String passward){
        User u =new User();
        u.setNumber(22);
        u.setUsername(username);
        u.setPassword(passward);
        userService.insertUserTwo(u);
        return u;
    }



    @RequestMapping("/insertUserNoExc")
    @ResponseBody
    public User insertUserNoExc(String username,String passward){
        User u =new User();
        u.setNumber(22);
        u.setUsername(username);
        u.setPassword(passward);
        userService.insertUserNoExc(u);
        return u;
    }


    @RequestMapping("/creatUserErrorBack")
    @ResponseBody
    public User creatUserErrorBack(String username,String passward) throws IOException {
        User u =new User();
        u.setNumber(22);
        u.setUsername(username);
        u.setPassword(passward);
        userService.creatUserErrorBack(u);
        return u;
    }


    @RequestMapping("/createUserAB1")
    @ResponseBody
    public User createUserAB1(String username,String passward){
        User u =new User();
        u.setNumber(22);
        u.setUsername(username);
        u.setPassword(passward);
        userService.createUserAB1(u);
        return u;
    }



    @RequestMapping("/createUserAB2")
    @ResponseBody
    public User createUserAB2(String username,String passward){
        User u =new User();
        u.setNumber(22);
        u.setUsername(username);
        u.setPassword(passward);
        userService.createUserAB2(u);
        return u;
    }

}
