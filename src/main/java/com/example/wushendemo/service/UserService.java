package com.example.wushendemo.service;

import com.example.wushendemo.dao.UserMapper;
import com.example.wushendemo.domain.User;
import com.example.wushendemo.metrics.Metrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.IOException;
import java.util.List;

@Service
public class UserService implements IUserService{


    @Autowired
    private UserMapper userMapper;

//@Autowired
//private UserService userService;


    @Autowired
    private UserServiceB userServiceB;

    @Override
    public User findByUsername(String username) {
        return userMapper.find(username);
    }

    @Override
    public List<User> listUser() {
        return userMapper.list();
    }


    @Transactional
    @Metrics
    @Override
    public int updateUser(User user) {
        int update = userMapper.update(user);
        if(user.getId()==5){
            throw new RuntimeException();
        }
        return update;
    }


    @Override
    public int delete(int id) {
        return userMapper.delete(id);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertUser(User user) {
        int insert = userMapper.insert(user);
        if(1==1){
            throw new RuntimeException();
        }
        return insert;
    }


    /**
     * 调用本地方法
     * @return
     */


    @Override
    public int insertUserOne(User user) {
        localPrivate(user);
        return 0;
    }

    @Transactional
    private int localPrivate(User user){
        //执行入库操作
        userMapper.insert(user);
        if(1==1){
            throw new RuntimeException("localPrivate");
        }
        return 1;
    }


    @Override
    public int insertUserTwo(User user) {
        localPublic(user);
        return 0;
    }

    @Transactional
    public int localPublic(User user){
        //执行入库操作
        userMapper.insert(user);
        if(1==1){
            throw new RuntimeException("localPublic");
        }
        return 1;
    }


    /**
     * 为了不给客户端返回异常，catch异常，返回默认值
     * @param user
     * @return
     */
    @Override
    @Transactional
    public int insertUserNoExc(User user){
        try {
            userMapper.insert(user);
            if(1==1){
                throw new RuntimeException("insertUserNoExc");
            }
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return 0;
    }

    /**
     * 事务的异常机制
     * @param user
     * @return @Transactional(rollbackFor = Exception.class)
     * @throws IOException
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int creatUserErrorBack(User user) throws IOException {
        userMapper.insert(user);
        task();
        return 0;
    }

    private void task() throws IOException{
        if(1==1){
            throw new IOException("IOException");
        }
    }


    /**
     * A插入成功，B回滚不影响A插入
     * 事务的传播行为
     * @Transactional(propagation = Propagation.REQUIRES_NEW)
     * @param user
     * @return
     */

    @Override
    @Transactional
    public int createUserAB1(User user){
        userMapper.insert(user);
        userServiceB.updateB(user);
        return 0;
    }


    @Override
    @Transactional
    public int createUserAB2(User user){
        userMapper.insert(user);
        try {
            userServiceB.updateB(user);
        }catch (Exception e){

        }
        return 0;
    }

}
