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
public class UserService implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.find(username);
    }

    @Override
    public List<User> listUser() {
        return userMapper.list();
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertUser(User user) {
        int insert = userMapper.insert(user);
        if(1==1)
        throw new RuntimeException();
        return insert;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateUser(User user) {
        int update = userMapper.update(user);
        if(user.getId()==5)
            throw new RuntimeException();
        return update;
    }


    @Override
    public int delete(int id) {
        return userMapper.delete(id);
    }


    @Override
    public int errorUserOne(User user) {
        return 0;
    }


    /**
     * 调用本地方法
     * @return
     */


    public int test(){
//        localPrivate();
        localPublic();
        return 0;
    }

    @Transactional
    private int localPrivate(){
        //
        if(1==1){
            throw new RuntimeException("localPrivate");
        }
        return 1;
    }


    @Transactional
    public int localPublic(){
        //
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
    @Transactional
    public int creatUserWrong(User user){
        try {
            userMapper.insert(user);
        }catch (Exception e){

        }
        return 0;
    }

    /**
     * 事务的异常机制
     * @param user
     * @return
     * @throws IOException
     */

    @Transactional(rollbackFor = Exception.class)
//    @Transactional
    public int creatUserWrong2(User user) throws IOException {
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
     * 事务的传播行为
     * @param user
     * @return
     */

    @Transactional
    public int createUserA1(User user){
        userMapper.insert(user);
        creatUserB();
        return 0;
    }



    @Transactional
    public int createUserA(User user){
        userMapper.insert(user);
        try {
            creatUserB();
        }catch (Exception e){

        }
        return 0;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @Transactional
    public int creatUserB(){
        if(1==1){
            throw new RuntimeException("testB");
        }
        return 0;
    }


}
