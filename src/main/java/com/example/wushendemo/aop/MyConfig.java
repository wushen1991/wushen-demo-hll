package com.example.wushendemo.aop;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * @author: wushen
 * @date: 2022/8/5 上午11:28
 * @description:
 * AnnotationAwareAspectJAutoProxyCreator 其实就是一个bean的后置处理器
 */
@Configuration
//@Import(AnnotationAwareAspectJAutoProxyCreator.class) //这个注解会自动解析我们aspectj  把里面的方法解析成一个个的advisor
//@EnableAspectJAutoProxy //这个注解注册了 AnnotationAwareAspectJAutoProxyCreator
// 会自动解析我们aspectj  解析成一个个的InstantiationModelAwarePointcutAdvisorImpl
public class MyConfig {

    // 被代理对象
    @Bean
    public Calculate myCalculate() {
        return new MyCalculate();
    }

    // Advice 方式
    @Bean
    public MyLogAdvice myLogAdvice(){
        return new MyLogAdvice();
    }

    // Interceptor方式 ， 类似环绕通知
    @Bean
    public MyLogInterceptor myLogInterceptor() {
        return new MyLogInterceptor();
    }

    /**
     * FactoryBean方式单个： ProxyFactoryBean
     * @return
     */
    @Bean
    public ProxyFactoryBean calculateProxy(){
        ProxyFactoryBean userService=new ProxyFactoryBean();
        userService.setInterceptorNames("myLogAdvice","myLogInterceptor");  // 根据指定的顺序执行
        userService.setTarget(myCalculate());
        return userService;
    }


    /**
     * Advisor 是包含了匹配规则，和执行逻辑的Advice
     * pointcut 来做匹配规则，Advice是执行逻辑
     * @return
     */
    @Bean
    public NameMatchMethodPointcutAdvisor myLogAspect() {
        NameMatchMethodPointcutAdvisor advisor=new NameMatchMethodPointcutAdvisor();
        // 通知(Advice)  ：是我们的通知类
        // 通知者(Advisor)：是经过包装后的细粒度控制方式。
        advisor.setAdvice(myLogAdvice());
        advisor.setMappedNames("add");
        return  advisor;
    }

    /**
     * FactoryBean方式单个： ProxyFactoryBean
     *  控制粒度到方法
     * @return
     */
    @Bean
    public ProxyFactoryBean calculateProxy2(){
        ProxyFactoryBean userService=new ProxyFactoryBean();
        userService.setInterceptorNames("myLogAspect");
        userService.setTarget(myCalculate());
        return userService;
    }


    /**
     *autoProxy: BeanPostProcessor手动指定Advice方式  BeanNameAutoProxyCreator
     * 去掉原来的 ProxyFactoryBean 的配置，改为使用 BeanNameAutoProxyCreator 来配置
     * @return
     */
    //@Bean
    //public BeanNameAutoProxyCreator autoProxyCreator() {
    //    BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
    //    //设置要创建代理的那些Bean的名字
    //    beanNameAutoProxyCreator.setBeanNames("my*");
    //    //设置拦截链名字(这些拦截器是有先后顺序的)
    //    beanNameAutoProxyCreator.setInterceptorNames("myLogInterceptor");
    //    return beanNameAutoProxyCreator;
    //}


    /**
     * 按照正则表达式来匹配
     * @return
     */
    @Bean
    public RegexpMethodPointcutAdvisor myLogInterceptorAdvisor() {
        RegexpMethodPointcutAdvisor advisor=new RegexpMethodPointcutAdvisor();
        // 通知(Advice)  ：是我们的通知类
        // 通知者(Advisor)：是经过包装后的细粒度控制方式。
        //advisor.setAdvice(myLogAdvice());
        advisor.setAdvice(myLogInterceptor());
        advisor.setPattern("com.example.wushendemo.aop.MyCalculate.*");
        return  advisor;
    }


    /**
     * BeanPostProcessor自动扫描Advisor方式  DefaultAdvisorAutoProxyCreator
     * @return
     */
    //@Bean
    //public DefaultAdvisorAutoProxyCreator autoProxyCreator() {
    //    return new DefaultAdvisorAutoProxyCreator();
    //}

}
