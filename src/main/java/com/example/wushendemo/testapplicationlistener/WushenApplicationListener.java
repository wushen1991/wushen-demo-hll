package com.example.wushendemo.testapplicationlistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author: wushen
 * @date: 2021/7/9 下午11:50
 * @description:
 */
@Component
public class WushenApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("我收到了一个事件："+applicationEvent);
    }
}
