package com.example.wushendemo.proxy;

import org.springframework.stereotype.Service;

/**
 * @author: wushen
 * @date: 2021/7/11 上午9:38
 * @description:
 */
@Service
public interface IProducer {

    public void updateDb(int data);

    public void insertDb(int data);
}
