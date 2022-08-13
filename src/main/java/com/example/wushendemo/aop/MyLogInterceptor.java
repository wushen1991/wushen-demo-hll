package com.example.wushendemo.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author: wushen
 * @date: 2022/8/5 上午11:27
 * @description:
 */
public class MyLogInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println(getClass()+"调用方法前");
        Object ret=methodInvocation.proceed();
        System.out.println(getClass()+"调用方法后");
        return ret;
    }
}
