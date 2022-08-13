package com.example.wushendemo.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: wushen
 * @date: 2022/8/5 上午11:30
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
        Calculate calculateProxy = ctx.getBean("calculateProxy",Calculate.class);
        calculateProxy.add(1,1);
        calculateProxy.sub(1,1);

        System.out.println("================================");
        //AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
        Calculate calculateProxy2 = ctx.getBean("calculateProxy2",Calculate.class);
        calculateProxy2.add(1,1);
        calculateProxy2.sub(1,1);

        System.out.println("--------------------------");
        Calculate myCalculate = ctx.getBean("myCalculate",Calculate.class);
        myCalculate.add(1,1);
        myCalculate.sub(1,1);
    }

}
