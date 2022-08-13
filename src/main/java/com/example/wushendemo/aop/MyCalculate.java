package com.example.wushendemo.aop;

/**
 * @author: wushen
 * @date: 2022/8/5 上午11:24
 * @description:
 */
public class MyCalculate implements Calculate{

    @Override
    public int add(int numA, int numB) {

        System.out.println("执行目标方法:add");
        return numA+numB;
    }

    @Override
    public int sub(int numA, int numB) {
        System.out.println("执行目标方法:reduce");
        return numA-numB;
    }
}
