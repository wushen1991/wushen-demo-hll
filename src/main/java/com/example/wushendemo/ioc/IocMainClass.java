package com.example.wushendemo.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: wushen
 * @date: 2021/7/9 下午11:56
 * @description:
 */
public class IocMainClass {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
//        System.out.println(ctx.getBean("registBean"));
        System.out.println(ctx.getBean("myBeanProcessor"));
    }
}
