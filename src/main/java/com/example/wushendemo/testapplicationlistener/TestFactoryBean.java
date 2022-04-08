package com.example.wushendemo.testapplicationlistener;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author: wushen
 * @date: 2021/7/10 下午11:07
 * @description:
 */
@Component
public class TestFactoryBean implements FactoryBean<XiaoQiang> {


    @Override
    public XiaoQiang getObject() throws Exception {
        return new XiaoQiang();
    }

    @Override
    public Class<?> getObjectType() {
        return XiaoQiang.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
