package com.example.wushendemo.testapplicationlistener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: wushen
 * @date: 2021/7/9 下午11:35
 * @description:
 */
@ComponentScan(basePackages = "com.example.wushendemo")
public class MainConfig {


//    @Bean
//    public XiaoQiang testFactoryBean(){
//        return new XiaoQiang();
//    }


    @Bean
    public XiaoMing xiaoMing(){
        return new XiaoMing();
    }

}
