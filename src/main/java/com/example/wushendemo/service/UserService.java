package com.example.wushendemo.service;

import com.example.wushendemo.dao.UserMapper;
import com.example.wushendemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findByUsername(String username) {
        return userMapper.find(username);
    }


    public List<User> listUser() {
        return userMapper.list();
    }


    @Transactional(rollbackFor = Exception.class)
    public int insertUser(User user) {
        int insert = userMapper.insert(user);
        if(1==1)
        throw new RuntimeException();
        return insert;
    }


    @Transactional(rollbackFor = Exception.class)
    public int updateUser(User user) {
        int update = userMapper.update(user);
        if(user.getId()==5)
            throw new RuntimeException();
        return update;
    }


    public int delete(int id) {
        return userMapper.delete(id);
    }
}
