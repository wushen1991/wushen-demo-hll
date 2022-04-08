package com.example.wushendemo.proxy;

/**
 * @author: wushen
 * @date: 2021/7/11 上午10:35
 * @description:
 */
public class ProduceService implements IProducer{
    @Override
    public void updateDb(int money) {
        System.out.println("执行数据库操作，更新db");
        if(money ==1){
            throw new RuntimeException();
        }
    }

    @Override
    public void insertDb(int data) {
        System.out.println("执行数据库操作,插入db");
    }
}
