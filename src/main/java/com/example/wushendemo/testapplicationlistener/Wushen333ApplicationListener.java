package com.example.wushendemo.testapplicationlistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author: wushen
 * @date: 2021/7/9 下午11:50
 * @description:
 */
@Component
public class Wushen333ApplicationListener {


    @EventListener
    public void testdddd(ApplicationEvent applicationEvent) {
        System.out.println("33333我收到了一个事件："+applicationEvent);
    }
}
