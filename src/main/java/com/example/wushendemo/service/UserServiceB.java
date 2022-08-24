package com.example.wushendemo.service;

import com.example.wushendemo.dao.UserMapper;
import com.example.wushendemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class UserServiceB {

    @Autowired
    private UserMapper userMapper;


    /**
     * TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
     *
     * @param user
     * @return
     */

    //@Override
    //public int delete(int id) {
    //    return userMapper.delete(id);
    //}
    //
    ///**
    // * 调用本地方法
    // * @return
    // */
    //
    //
    //@Override
    //public int insertUserOne(User user) {
    //    localPrivate(user);
    //    return 0;
    //}
    //
    //@Transactional
    //private int localPrivate(User user){
    //    //执行入库操作
    //    userMapper.insert(user);
    //    if(1==1){
    //        throw new RuntimeException("localPrivate");
    //    }
    //    return 1;
    //}
    //
    //
    //@Override
    //public int insertUserTwo(User user) {
    //    localPublic(user);
    //    return 0;
    //}
    //
    //@Transactional
    //public int localPublic(User user){
    //    //执行入库操作
    //    userMapper.insert(user);
    //    if(1==1){
    //        throw new RuntimeException("localPublic");
    //    }
    //    return 1;
    //}
    //
    //
    ///**
    // * 为了不给客户端返回异常，catch异常，返回默认值
    // * @param user
    // * @return
    // */
    //@Override
    //@Transactional
    //public int insertUserNoExc(User user){
    //    try {
    //        userMapper.insert(user);
    //        if(1==1){
    //            throw new RuntimeException("insertUserNoExc");
    //        }
    //    }catch (Exception e){
    //
    //    }
    //    return 0;
    //}
    //
    ///**
    // * 事务的异常机制
    // * @param user
    // * @return @Transactional(rollbackFor = Exception.class)
    // * @throws IOException
    // */
    //@Override
    //@Transactional
    //public int creatUserErrorBack(User user) throws IOException {
    //    userMapper.insert(user);
    //    task();
    //    return 0;
    //}
    //
    //private void task() throws IOException{
    //    if(1==1){
    //        throw new IOException("IOException");
    //    }
    //}


    ///**
    // * A插入成功，B回滚不影响A插入
    // * 事务的传播行为
    // * @Transactional(propagation = Propagation.REQUIRES_NEW)
    // * @param user
    // * @return
    // */
    //
    //@Override
    //@Transactional
    //public int createUserAB1(User user){
    //    userMapper.insert(user);
    //    creatUserB(user);
    //    return 0;
    //}
    //
    //
    //@Override
    //@Transactional
    //public int createUserAB2(User user){
    //    userMapper.insert(user);
    //    try {
    //        creatUserB(user);
    //    }catch (Exception e){
    //
    //    }
    //    return 0;(propagation = Propagation.REQUIRES_NEW)
    //}
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int updateB(User user) {
        user.setId(5);
        user.setUsername(user.getUsername() + "B");
        user.setPassword(user.getPassword() + "B");
        userMapper.update(user);
        if (1 == 1) {
            throw new RuntimeException("testB");
        }
        return 0;
    }

}