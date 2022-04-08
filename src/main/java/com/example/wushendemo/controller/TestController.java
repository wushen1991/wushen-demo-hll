package com.example.wushendemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wushen
 * @date: 2021/7/9 下午11:29
 * @description:
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String sayHello(String name){
        return "hello ward:"+name;
    }
}
