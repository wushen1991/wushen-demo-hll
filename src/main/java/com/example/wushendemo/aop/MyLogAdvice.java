package com.example.wushendemo.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author: wushen
 * @date: 2022/8/5 上午11:25
 * @description:
 */
public class MyLogAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object o) throws Throwable {
        String methodName = method.getName();
        System.out.println("执行目标方法【"+methodName+"】的<前置通知>,入参"+ Arrays.asList(args));
    }
}
