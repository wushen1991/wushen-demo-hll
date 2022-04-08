package com.example.wushendemo.ioc;

import com.example.wushendemo.ioc.bean.TestBean;
import com.example.wushendemo.ioc.importtest.MyBeanDefinitionRegister;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: wushen
 * @date: 2021/7/9 下午11:35
 * @description:
 */
//@ComponentScan(basePackages = "com.example.wushendemo")
@Configuration
@Import(MyBeanDefinitionRegister.class)
public class MainConfig {

    @Bean
    public TestBean testBean(){
        return new TestBean();
    }

}
