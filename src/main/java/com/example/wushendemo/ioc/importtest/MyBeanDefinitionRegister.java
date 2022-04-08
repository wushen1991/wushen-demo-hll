package com.example.wushendemo.ioc.importtest;

import com.sun.tools.hat.internal.model.Root;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author: wushen
 * @date: 2021/7/9 下午11:59
 * @description:
 */
public class MyBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition beanDefinition = new RootBeanDefinition(RegistBean.class);
        registry.registerBeanDefinition("registBean",beanDefinition);



        RootBeanDefinition myBeanProcessor = new RootBeanDefinition(MyBeanDefinitionRegistryPostProcessor.class);
        registry.registerBeanDefinition("myBeanProcessor",myBeanProcessor);
    }
}
