package com.example.wushendemo.testapplicationlistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: wushen
 * @date: 2021/7/9 下午11:37
 * @description:
 */
public class MainClass {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        ctx.publishEvent(new ApplicationEvent("武神手动发布了一个事件") {

            @Override
            public Object getSource() {
                return super.getSource();
            }
        });
        System.err.println(ctx.getBean("xiaoMing"));
        System.err.println(ctx.getBean("testFactoryBean"));
//        System.out.println(ctx.getBean("&testFactoryBean"));

        ctx.close();
    }


}
