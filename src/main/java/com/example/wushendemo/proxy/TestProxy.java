package com.example.wushendemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: wushen
 * @date: 2021/7/11 上午9:35
 * @description:
 */

/**
 * 动态代理：
 *   特点：字节码随用随创建，随用随加载
 *   作用：不修改源码的基础上对方法增强
 *   分类：
 *       基于接口的动态代理
 *   写的是基于接口的动态代理：
 *       设计的类：Proxy
 *       提供者：JDK官方
 *   如何创建代理对象：
 *       使用Proxy类中的newProxyInstance方法
 *   创建代理对象的要求：
 *       被代理对象最少实现一个接口，如果没有，则不能用
 *   new ProxyInstance方法的参数：
 *       ClassLoader：类加载器
 *           它用于加载代理对象的字节码。和被代理对象使用相同的类加载器。(固定写法)
 *       Class[]：字节码数组
 *           它用于让代理对象和被代理对象有相同的方法。 (固定写法)
 *       InvocationHandler：用于增强的代码
 *            它是让我们写如何代理。我们一般都是写一个接口的实现类，通常情况下是匿名内部类，但不是必须的。
 *             此接口的实现类是谁用谁写。
 *
 * */


public class TestProxy {


    public static void main(String[] args) throws Exception{


//        //直接调用
        ProduceService produceService = new ProduceService();
//        produceService.updateDb(2);
//
//        System.err.println("-----------------------------------");
        //代理调用
        IProducer proxyForService = getProxyForService(produceService);
        proxyForService.updateDb(1);

//        proxyForService.insertDb(1);

        //单独为接口创建代理类
//        IProducer poxyProducer = getProxyForInterface();
//        poxyProducer.updateDb(3232);


    }
    // class $proxy0 extends java.lang.reflect.Proxy implements IProducer{
    //       $Proxy0(InvocationHandler h){
    //            super(h);
    //       }
    //       @over
    //       xxxxmethod(){
    //           h.invok();
    //       }
    // }

    private static IProducer getProxyForService(IProducer producer) {
        return (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue = null;
                        //1.获取方法执行的参数
                        int money = (int) args[0];
                        try {
                            System.out.println("======开启事务======");
                            System.out.println("执行目标方法：method:"+method.getName()+"，param:"+money);
                            method.invoke(producer,args);
                            System.out.println("======提交事务======");
                        }catch (Exception e){
                            System.out.println("======回滚事务======");
                            throw e;
                        }
                        return returnValue;
                    }
                });
    }



    private static IProducer getProxyForInterface() {
        return (IProducer) Proxy.newProxyInstance(IProducer.class.getClassLoader(),
                     new Class[]{IProducer.class}, new InvocationHandler() {
                         /**
                          * *作用：执行被代理对象的任何接口方法都会经过该方法
                          * *方法参数的定义：
                          * * @param proxy     代理对象的引用
                          * * @param method    当前执行的方法
                          * * @param args      当前执行方法所需的参数
                          * * @return          和被代理对象方法具有相同的返回值
                          * * @throws Throwable
                          */

                         @Override
                         public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                             //提供增强的代码
                             Object returnValue = null;
                             //1.获取方法执行的参数
                             int money = (int) args[0];
                             //2.判断当前方法是不是销售
    //                         if ("sale".equals(method.getName())) {
    //                             returnValue = method.invoke(producer, money * 0.8f);
    //                         }
                             System.out.println("执行目标方法：method:"+method.getName()+"，param:"+money);

                             return returnValue;
                         }
                     });
    }


}
