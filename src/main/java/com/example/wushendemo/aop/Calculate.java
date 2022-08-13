package com.example.wushendemo.aop;

/**
 * @author: wushen
 * @date: 2022/8/5 上午11:23
 * @description:
 */
public interface Calculate {

    /**
     * 加法
     * @param numA
     * @param numB
     * @return
     */
    int add(int numA, int numB);

    /**
     * 减法
     * @param numA
     * @param numB
     * @return
     */
    int sub(int numA, int numB);

}
