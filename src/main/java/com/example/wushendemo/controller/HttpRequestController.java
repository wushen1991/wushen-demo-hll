package com.example.wushendemo.controller;


import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 这类型的接口是通过：BeanNameUrlHandlerMapping 来处理的
 */
@Component("/testBean")
public class HttpRequestController implements HttpRequestHandler {


    @Override
    public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        System.out.println("收到testBean请求");
    }
}
